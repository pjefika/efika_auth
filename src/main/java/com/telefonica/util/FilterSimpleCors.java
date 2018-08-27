package com.telefonica.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 15/08/18 - 23:31
 */
public class FilterSimpleCors implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        if(!((HttpServletResponse) res).containsHeader("Access-Control-Allow-Origin"))
            ((HttpServletResponse) res).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
        ((HttpServletResponse) res).addHeader("Access-Control-Allow-Credentials", "true");
        ((HttpServletResponse) res).addHeader("Access-Control-Expose-Headers", "Authorization");

        if (((HttpServletRequest) req).getMethod().equals("OPTIONS"))
            ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_OK);
        else
            chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}
}
