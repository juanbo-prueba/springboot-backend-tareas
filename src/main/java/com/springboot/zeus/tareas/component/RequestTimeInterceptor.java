package com.springboot.zeus.tareas.component;

import com.springboot.zeus.tareas.component.model.Log;
import com.springboot.zeus.tareas.component.repository.LogRepository;
import com.springboot.zeus.tareas.login.model.UsuarioPrincipal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LogManager.getLogger(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long starTime = (long) request.getAttribute("startTime");
        String url = request.getRequestURL().toString();
        Long tiempoRespuestta = System.currentTimeMillis() - starTime;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = "";
        String detalle = "";
        long codIdUsuario = 0;
        if ( auth != null && auth.isAuthenticated() ) {
            userName = auth.getName();
            if( auth.getPrincipal() instanceof UsuarioPrincipal) {
                UsuarioPrincipal user = (UsuarioPrincipal) auth.getPrincipal();
                codIdUsuario = user.getId();
            }

            if ( auth.getDetails() != null ) {
                detalle = auth.getDetails().toString();
            }
        }
        System.out.println("user: " + userName);
        System.out.println("id: " + codIdUsuario);
       // System.out.println("id: "+ userDetails.getEmail());

       /* UsuarioPrincipal user = (UsuarioPrincipal) auth.getDetails();
        System.out.println("BUSCANDO ID LOG: " + user.getId());*/

        Log log = new Log( new Date(), detalle, userName, url, tiempoRespuestta.toString(), codIdUsuario );
        logRepository.guardarLog( log );
        LOG.info("--REQUEST URL: '" + url + "' -- TOTAL TIEMPO: '" + (System.currentTimeMillis() - starTime) + "'ms");
    }
}
