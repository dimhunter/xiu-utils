package com.shen.common.utils;


import org.junit.Test;

public class ArrayUtilsTest {

//	protected void setUp() throws Exception {
//		super.setUp();
//	}
//
//	protected void tearDown() throws Exception {
//		super.tearDown();
//	}

	@Test
	public void testToStringObject() {
		String[] array = new String[]{"a","bb","c"};
		int[] array2 = new int[]{1,33,6};
		System.out.println(ArrayUtils.toString(array));
		System.out.println(ArrayUtils.toString(array2));
	}

	public void testIsEqualsObjectObject() {
		// 2.1 两个数组完全相同
        System.out.println(ArrayUtils.isEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }));// true
        // 2.2 数据类型以及长度相同,但各个Index上的数据不是一一对应
        System.out.println(ArrayUtils.isEquals(new int[] { 1, 3, 2 }, new int[] { 1, 2, 3 }));// false
        // 2.3 数组的长度不一致
        System.out.println(ArrayUtils.isEquals(new int[] { 1, 2, 3, 3 }, new int[] { 1, 2, 3 }));// false
        // 2.4 不同的数据类型
        System.out.println(ArrayUtils.isEquals(new int[] { 1, 2, 3 }, new long[] { 1, 2, 3 }));// false
        System.out.println(ArrayUtils.isEquals(new Object[] { 1, 2, 3 }, new Object[] { 1, (long) 2, 3 }));// false
        // 2.5 Null处理,如果输入的两个数组都为null时候则返回true
        System.out.println(ArrayUtils.isEquals(new int[] { 1, 2, 3 }, null));// false
        System.out.println(ArrayUtils.isEquals(null, null));// true
	}

}
