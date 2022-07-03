package com.hln.intercepter;

import lombok.Data;

import java.io.Serializable;
@Data
public class BLoginAccount implements Serializable {
    private static final long serialVersionUID = -5914521007529860710L;
    private Long accountId;
    private String userid;
    private String clientId;
    private String token;
    private String corpid;
    private String corpName;
    private String merchantPhone;
    private Long expireAtTime;
    private String agentid;
    private Integer userType;
    private String mobile;
    private Long corpAuthInfoId;
    private String suiteId;
}
