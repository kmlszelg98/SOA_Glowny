// Import required java libraries

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Implements Filter class
public class LogFilter implements Filter  {

    private static final String[] DEFAULT_BROWSERS =
            { "Chrome", "Firefox", "Safari", "Opera", "MSIE 8", "MSIE 7", "MSIE 6" };

    public static final String KEY_BROWSER_IDS = "browserIds";
    public static final String KEY_BAD_BROWSER_URL = "badBrowserUrl";


    private String[] browserIds;
    private String badBrowserUrl;

    @Override
    public void init(FilterConfig cfg) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException
    {

        String userAgent = ((HttpServletRequest) req).getHeader("User-Agent");

        if(!userAgent.contains("Chrome")) {
            chain.doFilter(req, resp);
            return;
        } else {
            ((HttpServletResponse) resp).sendRedirect("Error");
            return;
        }


    }


    public void destroy()
    {
        this.browserIds = null;
    }
}