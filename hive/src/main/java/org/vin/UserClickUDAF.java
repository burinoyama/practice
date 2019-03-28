package org.vin;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class UserClickUDAF extends UDAF {

	// 日志对象初始化
	public static Logger logger = Logger.getLogger(UserClickUDAF.class);

	// 静态类实现UDAFEvaluator
	public static class Evaluator implements UDAFEvaluator {
		// 设置成员变量，存储每个统计范围内的总记录数
		private static Map<String, String> courseScoreMap;

		private static Map<String, String> city_info;
		private static Map<String, String> product_info;
		private static Map<String, String> user_click;

		//初始化函数,map和reduce均会执行该函数,起到初始化所需要的变量的作用
		public Evaluator() {
			init();
		}

		// 初始化函数间传递的中间变量
		@Override
		public void init() {
			courseScoreMap = new HashMap<String, String>();
			city_info = new HashMap<String, String>();
			product_info = new HashMap<String, String>();
		}

		//map阶段，返回值为boolean类型，当为true则程序继续执行，当为false则程序退出
		public boolean iterate(String pcid, String pcname, String pccount) {
			if (pcid == null || pcname == null || pccount == null) {
				return true;
			}

			if (pccount.equals("-1")) {
				// 城市表
				city_info.put(pcid, pcname);
			} else if (pccount.equals("-2")) {
				// 产品表
				product_info.put(pcid, pcname);
			} else {
				// 处理用户点击关联
				unionCity_Prod_UserClic1(pcid, pcname, pccount);
			}
			return true;
		}

		// 处理用户点击关联
		private void unionCity_Prod_UserClic1(String pcid, String pcname, String pccount) {
			if (product_info.containsKey(pcid)) {
				if (city_info.containsKey(pcname)) {
					String city_name = city_info.get(pcname);
					String prod_name = product_info.get(pcid);
					String cp_name = city_name + prod_name;

					// 如果之前已经Put过Key值为区域信息，则把记录相加处理
					if (courseScoreMap.containsKey(cp_name)) {
						int pcrn = 0;
						String strTemp = courseScoreMap.get(cp_name);
						String courseScoreMap_pn = strTemp.substring(strTemp.lastIndexOf("\t".toString())).trim();
						pcrn = Integer.parseInt(pccount) + Integer.parseInt(courseScoreMap_pn);

						courseScoreMap.put(cp_name, city_name + "\t" + prod_name + "\t" + Integer.toString(pcrn));
					} else {
						courseScoreMap.put(cp_name, city_name + "\t" + prod_name + "\t" + pccount);
					}
				}
			}
		}

		/**
		 * 类似于combiner,在map范围内做部分聚合，将结果传给merge函数中的形参mapOutput
		 * 如果需要聚合，则对iterator返回的结果处理，否则直接返回iterator的结果即可
		 */
		public Map<String, String> terminatePartial() {
			return courseScoreMap;
		}

		// reduce 阶段，用于逐个迭代处理map当中每个不同key对应的 terminatePartial的结果
		public boolean merge(Map<String, String> mapOutput) {
			Evaluator.courseScoreMap.putAll(mapOutput);
			return true;
		}

		// 处理merge计算完成后的结果，即对merge完成后的结果做最后的业务处理
		public String terminate() {
			return courseScoreMap.toString();
		}
	}
}
