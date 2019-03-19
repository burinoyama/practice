package MapKVTest;

import scala.collection.mutable.HashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KVTest {

	public static void main(String[] args) {

		Map hm = new HashMap();

		ConcurrentHashMap cm = new ConcurrentHashMap();

		Map ht = new Hashtable();

		hm.put(null, null);
		hm.remove(null);

//		cm.put(null, null);
//		cm.remove(null);
//		ht.put(null, null);
//		ht.remove(null);


	}

}
