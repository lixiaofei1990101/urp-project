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
 * 2016年7月14日    Li Xiao Fei         Create the class
*/

package com.lixf.urp.sys.shiro;

import org.apache.shiro.authc.AccountException;

/**
 * @FileName VlidateCodeAccountException.java
 * @Description: 验证码错误异常
 *
 * @Date 2016年7月14日 
 * @author Li Xiao Fei
 * @version 1.0
 * 
 */
@SuppressWarnings("serial")
public class VlidateCodeAccountException extends AccountException{
	 /**
     * Creates a new UnknownAccountException.
     */
    public VlidateCodeAccountException() {
        super();
    }

    /**
     * Constructs a new UnknownAccountException.
     *
     * @param message the reason for the exception
     */
    public VlidateCodeAccountException(String message) {
        super(message);
    }

    /**
     * Constructs a new UnknownAccountException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public VlidateCodeAccountException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new UnknownAccountException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public VlidateCodeAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
