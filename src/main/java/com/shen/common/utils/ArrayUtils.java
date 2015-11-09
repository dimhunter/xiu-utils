package com.shen.common.utils;

import java.util.Map;

/**
 * 数组工具类
 * @author shen
 *
 */
public class ArrayUtils extends org.apache.commons.lang3.ArrayUtils {
	
	/**
	 * 转换为字符串
	 * @param array
	 * 
	 * 如String[]{"a","bb","c"} 转换为 "{a,bb,c}"
	 * int[]{1,33,6} 转换为 "{1,33,6}"
	 * 
	 * @return
	 */
	public static String toString(Object array) {
		return org.apache.commons.lang3.ArrayUtils.toString(array);
	}
	
	/**
	 * 判断数组是否为空，数组为null或者length=0，返回true
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }
	
	/**
	 * 判断两数组是否相等。采用EqualsBuilder进行判断
	 * 只有当两个数组的数据类型,长度,,数值顺序都相同的时候,该方法才会返回True
	 * 		除去以下两种情况，其余都是false。
	 * 		ArrayUtils.isEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 })
	 * 		ArrayUtils.isEquals(null, null)
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static boolean isEquals(Object array1, Object array2) {
        return org.apache.commons.lang3.ArrayUtils.isEquals(array1, array2);
    }
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static Map<Object, Object> toMap(Object[] array){
		//TODO
		return null;
	}
	
	
	
}
