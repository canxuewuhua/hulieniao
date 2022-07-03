package com.hln.intercepter;

import lombok.extern.slf4j.Slf4j;
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
public class BLoginInterceptor implements HandlerInterceptor {

    private static final String HEADER_NAME_TOKEN = "token";
    private static final String HEADER_NAME_CLIENT_ID = "clientId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        BAuthorized BAuthorized = handlerMethod.getMethodAnnotation(BAuthorized.class);
        if (null != BAuthorized){
            BLoginHolder.clear();
            BLoginAccount loginAccount = null;
            String token = request.getHeader(HEADER_NAME_TOKEN);
            //clientId: wxapp wxpc wxweb
            String clientId = request.getHeader(HEADER_NAME_CLIENT_ID);
            if (!ObjectUtils.isEmpty(token)) {
                loginAccount = parseToken(token, clientId);
            }
            BLoginHolder.setLoginUser(loginAccount);
            int[] roleTypes = BAuthorized.roleTypes();
            int authorizedType = BAuthorized.value().getCode();
            if (BAuthorizedType.PUBLIC.getCode() == authorizedType) {
                //不需要检查登陆态
                return true;
            }
            if (BAuthorizedType.LOGIN.getCode() == authorizedType) {
                if (null != loginAccount) {
                    return true;
                }
//            this.print(ErrorCodeEnum.NOT_LOGIN, response);
                return false;
            }
            if (BAuthorizedType.AUTHORIZED.getCode() == authorizedType) {
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

    private BLoginAccount parseToken(String token, String clientId) {
//        CheckTokenDto checkTokenDto = new CheckTokenDto();
//        checkTokenDto.setToken(token);
//        checkTokenDto.setClientId(clientId);
//        Response<BLoginAccount> response = tokenDubboService.checkToken(checkTokenDto);
//        if (response.isSuccess()) {
//            return response.getData();
//        }
//        log.error("解析token失败 token={},clientId={},cause={}", token, clientId, response.getErr());
//        return null;
        return new BLoginAccount();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        BLoginHolder.clear();
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