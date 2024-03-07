package pfeffer.oms.order.infra.middleware;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// https://mmarcosab.medium.com/usando-interceptor-em-uma-api-spring-boot-43585731d2b
@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    // Usado para executar alguma ação nas requisições enviadas à controller.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Requisição interceptada: " + request.getHeader("Authorization"));

        return true;
    }

    // Usado para executar alguma ação nas respostas enviadas ao client.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // Usado para executar ações após o request e response.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
