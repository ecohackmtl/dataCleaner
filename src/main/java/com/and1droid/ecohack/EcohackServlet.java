package com.and1droid.ecohack;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class EcohackServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Hello, world");
    }
}
