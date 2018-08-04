package cn.hand.exam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		// 随机生成50个整数<100
		List<Integer> list = new ArrayList<Integer>();
		int rand = 0;
		for (int i = 0; i < 50; i++) {
			rand = (int) (Math.random() * 100);
			list.add(rand);
		}
		System.out.print("随机生成的50个小于100的数为：");
		for (int i = 0; i < list.size()-1; i++) {
			System.out.print(list.get(i)+",");
		}
		System.out.println(list.size());
		Map<Integer, List> map = new HashMap<Integer, List>();
		
		// 初始化map集合key
		int temp = 0;
		for (Integer i : list) {
			temp = i / 10;
			if (map.get(temp) == null) {
				map.put(temp, new ArrayList());
			}
		}
		// 将value值加入
		for (Integer i : list) {
			temp = i/10;
			map.get(temp).add(i);
		}
		
		Set<Integer> keySet = map.keySet();
		System.out.println("map中的数据为：");
		for (Integer i : keySet) {
			System.out.println(i + "=>" + map.get(i));
		}
		//将value值排序
		for (Integer k : keySet) {
			map.get(k).sort(null);
		}
		System.out.println("排序后的map为：");
		for (Integer i : keySet) {
			System.out.println(i + "=>" + map.get(i));
		}
	}
}
