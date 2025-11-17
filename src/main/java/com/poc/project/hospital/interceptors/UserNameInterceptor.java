package com.poc.project.hospital.interceptors;

import com.poc.project.hospital.entity.MyUser;
import com.poc.project.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserNameInterceptor implements HandlerInterceptor {
    @Autowired
    UserRepository userRepository;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser headerUser = userRepository.getUserByLogin(authentication.getName());
        if (modelAndView != null) {
            modelAndView.addObject("headerUser", headerUser);
        }
    }
}
