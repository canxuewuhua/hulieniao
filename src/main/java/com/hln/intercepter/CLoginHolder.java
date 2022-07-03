package com.hln.intercepter;

/**
 * @Date: 2022/5/21 20:03
 * @Description:
 */
public class CLoginHolder {
    private static ThreadLocal<CLoginAccount> cloginAccountThreadLocal = new ThreadLocal<>();

    public static boolean isLogin() {
        return cloginAccountThreadLocal.get() != null;
    }


    public static void setLoginUser(CLoginAccount loginAccount) {
        cloginAccountThreadLocal.set(loginAccount);
    }


    public static CLoginAccount getLoginAccount() {
        return cloginAccountThreadLocal.get();
    }

    public static Long getMerchantId() {
        CLoginAccount loginAccount = cloginAccountThreadLocal.get();
        if (loginAccount != null) {
            return loginAccount.getMerchantId();
        }
        return null;
    }


    public static void clear() {
        cloginAccountThreadLocal.remove();
    }
}

