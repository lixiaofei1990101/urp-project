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
 * 2016年7月6日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.sys.unit;

import org.junit.Test;

import com.lixf.urp.sys.model.User;

/**
 * @FileName PasswordHelperTest.java
 * @Description: 
 *
 * @Date 2016年7月6日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
public class PasswordHelperTest {

	@Test
	public void testEncryptPassword() {
		PasswordHelper passwordHelper = new PasswordHelper();
		User user = new User();
		user.setPassword("123456");
		user.setUserName("张三");
		user.setSalt("eteokues");
		passwordHelper.encryptPassword(user);
	}

}
