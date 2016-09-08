/*
 * COPYRIGHT. ShenZhen MinSiDa Technology Co., Ltd. 2016.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen MinSiDa Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2016年8月5日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @FileName RandomUnit.java
 * @Description: 日期随机数工具类
 *
 * @Date 2016年8月5日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class RandomUnit {
	/**生成随机数的源数据*/
	public static final String numberChar = "0123456789";
	
	/**年月日时分秒(无下划线) yyyyMMddHHmmss*/
	public static final String dtLong = "yyyyMMddHHmmss";
	
	/**完整时间 yyyy-MM-dd HH:mm:ss*/
    public static final String simple = "yyyy-MM-dd HH:mm:ss";
    
    /**年月日(无下划线) yyyyMMdd*/
    public static final String dtShort = "yyyyMMdd";
    
	/**
	 * @Title: generateNum 
	 * @Description:生成随机数
	 * @param length 随机数的长度
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年3月15日
	 */
	public static String generateNum(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
		}
		return sb.toString();
	}

	/**
	 * @Title: generateOrderNo 
	 * @Description:根据当前日期+指定个数随机数生成字符串,随机数个数201406011744500673
	 * @param num 随机数的长度
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年3月15日
	 */
	public static String generateOrderNo(int num) {
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat mat = new SimpleDateFormat(dtLong);
		Date date = new Date();
		sb.append(mat.format(date));
		sb.append(generateNum(num));
		return sb.toString();
	}
	/**
	 * @Title: getDateFormatter 
	 * @Description:获取系统当前日期
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年8月5日
	 */
	public  static String getDateFormatter(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(simple);
		return df.format(date);
	}
	/**
	 * @Title: getDate 
	 * @Description:获取系统当前日期
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年8月5日
	 */
	public static String getDate(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtShort);
		return df.format(date);
	}

	/**
	 * @Title: splitAndMerger 
	 * @Description:带有逗号字符串分割为List集合
	 * @param str
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年3月15日
	 */
	public List<String> splitAndMerger(String str) {
		String[] strs = str.split(",");
		List<String> listRes = new ArrayList<String>();
		for (int i = 0; i < strs.length; i++) {
			listRes.add(strs[i]);
		}
		return listRes;
	}
	/**
	 * @Title: getDiffrent 
	 * @Description:获取两个数组中的不同元素
	 * @param list1
	 * @param list2
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年3月3日
	 */
	public static List<String> getDiffrent(List<String> list1, List<String> list2) {
		long st = System.nanoTime();
		List<String> diff = new ArrayList<String>();
		for (String str : list1) {
			if (!list2.contains(str)) {
				diff.add(str);
			}
		}
		System.out.println("total times " + (System.nanoTime() - st));
		return diff;
	}
	
	/**
	 * @Title: getsalt 
	 * @Description:生成字母和数字组合的随机数
	 * @param length 生成随机数的长度
	 * @return 
	 * @author Li Xiao Fei
	 * @date 2016年7月5日
	 */
	public static String getsalt(int length){
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	}
}
