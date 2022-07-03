package com.hln.intercepter;

/**
 * @Date: 2022/5/21 20:03
 * @Description:
 */
public class BLoginHolder {
    private static ThreadLocal<BLoginAccount> bloginAccountThreadLocal = new ThreadLocal<>();

    public static boolean isLogin() {
        return bloginAccountThreadLocal.get() != null;
    }


    public static void setLoginUser(BLoginAccount loginAccount) {
        bloginAccountThreadLocal.set(loginAccount);
    }


    public static BLoginAccount getLoginAccount() {
        return bloginAccountThreadLocal.get();
    }

    public static Long getMerchantId() {
        BLoginAccount loginAccount = bloginAccountThreadLocal.get();
        if (loginAccount != null) {
            return loginAccount.getCorpAuthInfoId();
        }
        return null;
    }


    public static void clear() {
        bloginAccountThreadLocal.remove();
    }
}
