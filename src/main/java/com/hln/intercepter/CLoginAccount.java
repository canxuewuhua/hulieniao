package com.hln.intercepter;

import lombok.Data;
import java.io.Serializable;

/**
 * 登陆的账号
 */
@Data
public class CLoginAccount implements Serializable {
    private static final long serialVersionUID = -8645048067947004594L;

    private Long userId;
    /**
     * 登录人id
     */
    private String account;

    private String clientId;

    private String unionId;
    /**
     * 登录人手机号
     */
    private String mobile;
    /**
     * 过期时间点
     */
    private Long expireAtTime;

    /**
     * token字符串
     */
    private String token;


    private Long storeId;

    private Long merchantId;

    /**
     * 微信用户昵称
     */
    private String nickName;

    /**
     * 用户头像图片的URL
     */
    private String avatarUrl;

}
