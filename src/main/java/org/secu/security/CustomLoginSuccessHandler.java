package org.secu.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        List<String> roleNames = new ArrayList<>();
        authentication.getAuthorities().forEach(authority ->{roleNames.add(authority.getAuthority());
        });

        if (roleNames.contains("ROLE_ADMIN")){
            httpServletResponse.sendRedirect("sample/admin");
            return;
        }
        if (roleNames.contains("ROLE_MEMBER")){
            httpServletResponse.sendRedirect("sample/member");
            return;
        }
        if (roleNames.contains("ROLE_USER")){
            httpServletResponse.sendRedirect("sample/all");
            return;
        }
        httpServletResponse.sendRedirect("/");
    }
}
