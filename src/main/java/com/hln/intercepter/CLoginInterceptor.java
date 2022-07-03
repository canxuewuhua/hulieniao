package com.hln.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆态检查拦截器
 *
 * @Date: 2022/5/21 19:53
 * @Description:
 */
@Slf4j
public class CLoginInterceptor implements HandlerInterceptor {

    private static final String HEADER_NAME_TOKEN = "token";
    private static final String HEADER_NAME_CLIENT_ID = "clientId";

//    @Autowired
//    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CAuthorized cAuthorized = handlerMethod.getMethodAnnotation(CAuthorized.class);
        if (null != cAuthorized){
            CLoginHolder.clear();
            CLoginAccount loginAccount = null;
            String token = request.getHeader(HEADER_NAME_TOKEN);
            //clientId: wxapp wxpc wxweb
            String clientId = request.getHeader(HEADER_NAME_CLIENT_ID);
            if (!ObjectUtils.isEmpty(token)) {
//            loginAccount = userService.parseToken(token, clientId).getData();
                loginAccount = new CLoginAccount();
            }
            CLoginHolder.setLoginUser(loginAccount);
            int[] roleTypes = cAuthorized.roleTypes();
            int authorizedType = cAuthorized.value().getCode();
            if (CAuthorizedType.PUBLIC.getCode() == authorizedType) {
                //不需要检查登陆态
                return true;
            }
            if (CAuthorizedType.LOGIN.getCode() == authorizedType) {
                if (null != loginAccount) {
                    return true;
                }
//            this.print(ErrorCodeEnum.NOT_LOGIN, response);
                return false;
            }
            if (CAuthorizedType.AUTHORIZED.getCode() == authorizedType) {
                if (null == loginAccount) {
//                this.print(ErrorCodeEnum.NOT_LOGIN, response);
                    return false;
                }
                //if (ArrayUtils.contains(roleTypes, loginAccount.getCurrentMerchantRoleType())) {
                //    return true;
                //}
//            this.print(ErrorCodeEnum.NO_AUTHORIZED, response);
                return false;
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        CLoginHolder.clear();
    }

//    private void print(ErrorCodeEnum errorCodeEnum, HttpServletResponse response) throws IOException {
//        Response res = new Response();
//        res.setStatus(errorCodeEnum.getCode());
//        res.setErr(errorCodeEnum.getMessage());
//        response.getOutputStream().write(JSON.toJSONString(res).getBytes("UTF-8"));
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "application/json;charset=UTF-8");
//        response.getOutputStream().flush();
//    }

}
