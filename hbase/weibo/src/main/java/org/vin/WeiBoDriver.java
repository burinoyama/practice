package org.vin;

import java.io.IOException;

public class WeiBoDriver {

	public static void init() throws IOException {

		//创建命名空间
		WeiBoUtil.createNS(Constants.NS);

		//创建三张表
		WeiBoUtil.createTable(Constants.CONTENT_TABLE, 1, Constants.CONTENT_CF);
		WeiBoUtil.createTable(Constants.RELATION_TABLE, 1, Constants.RELATION_CF1, Constants.RELATION_CF2);
		WeiBoUtil.createTable(Constants.INBOX_TABLE, 2, Constants.INBOX_CF);
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		//初始化表信息
//        init();

		//1001发布微博
//        WeiBoUtil.publishWeibo("1001", "今天天气真冷！");
//
//        //1002关注1001和1003
//        WeiBoUtil.attends("1002", "1001", "1003");
//
//        //获取1002初始化页面
//        WeiBoUtil.initMessage("1002");
//
//        System.out.println("**********************");
//
//        //1003发布微博
//        WeiBoUtil.publishWeibo("1003", "今天月亮很圆！！！");
//
//        //获取1002初始化页面
//        WeiBoUtil.initMessage("1002");

//        //1001又发布两条微博
//        WeiBoUtil.publishWeibo("1001", "赶紧下课！！！");
//        Thread.sleep(100);
//        WeiBoUtil.publishWeibo("1001", "赶紧放假！！！");
//
//        //获取1002初始化页面
//        WeiBoUtil.initMessage("1002");

//        //1002取关1003
//        WeiBoUtil.deleteAttends("1002", "1003");
//        //获取1002初始化页面
//        WeiBoUtil.initMessage("1002");

		//获取1001的微博详情
//        WeiBoUtil.getDatas("1001");

		//1002关注1003


//
//		WeiBoUtil.attends("1002", "1003");
//		WeiBoUtil.initMessage("1002");


	}
}
