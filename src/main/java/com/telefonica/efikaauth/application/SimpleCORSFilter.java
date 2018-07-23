/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikaauth.application;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author A0077749
 */
//@Component
public class SimpleCORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("SimpleCORSFilter");
        //HttpServletResponse response = (HttpServletResponse) res;
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Methods", "GET,POST");
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Credentials", "true");
        
        if (((HttpServletRequest) req).getMethod().equals("OPTIONS"))
            ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_OK);
        else 
            chain.doFilter(req, res);
        //chain.doFilter(req, res);
        //response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        //response.setHeader("Access-Control-Max-Age", "3600");
        //response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        //response.setHeader("Access-Control-Expose-Headers", "Location");
        //chain.doFilter(req, res);
    }

    //@Override
    public void init(FilterConfig filterConfig) {}

    //@Override
    public void destroy() {}
}
