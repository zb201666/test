package com.test;

import java.util.HashMap;
import java.util.Map.Entry;


public class TestMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("1", "2");
		map.put("1", "3");
		map.put("1", "4");
		map.put("2", "3");
		map.put("4", "3");
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"--------->"+entry.getValue());
		}
		System.out.println("=======================");
		System.out.println(map.size());
	}

}
