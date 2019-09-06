package com.zhangcw.driving_schooling_manage_system.util;

/**
 * @author: zhangcw
 * @date: 2019/10/24 10:16
 */
public class StringTools {

	public static boolean isNullOrEmpty(String str) {
		return null == str || "".equals(str) || "null".equals(str);
	}

	public static boolean isNullOrEmpty(Object obj) {
		return null == obj || "".equals(obj);
	}
}
