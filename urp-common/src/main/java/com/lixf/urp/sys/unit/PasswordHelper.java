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
 * 2016年7月5日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.sys.unit;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.lixf.urp.sys.model.User;

/**
 * @FileName PasswordHelper.java
 * @Description: 新增用户时，密码处理工具类
 *
 * @Date 2016年7月5日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";  
    private final int hashIterations = 2; 
    public void encryptPassword(User user) {  
        user.setSalt(randomNumberGenerator.nextBytes().toHex());  
        String newPassword = new SimpleHash(algorithmName,user.getPassword(),ByteSource.Util.bytes(user.getCredentialsSalt()),hashIterations).toHex();  
        System.out.println(newPassword);
        user.setPassword(newPassword);  
    } 
}
