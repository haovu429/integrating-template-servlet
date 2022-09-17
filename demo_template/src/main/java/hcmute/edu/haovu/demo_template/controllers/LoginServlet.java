package hcmute.edu.haovu.demo_template.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/login_page/login.jsp";
        String mess = "";

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        System.out.println("Note 1 ");

        if (action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember_me");

            boolean rem;

            if (remember != null){
                if(remember.equals("on")) {
                    rem = true;
                } else {
                    rem = false;
                }
            } else {
                rem = false;
            }

            System.out.println("Day la username: " + username);
            System.out.println("Remember: " + remember);

            assert (username != null);
            assert (password != null);

            if (username.equals("admin") && password.equals("haodeptrai")) {
                mess = "Login success!";
                url = "/home";
                response.sendRedirect(request.getContextPath() + "/home");
                return;
            } else {
                mess = "Login fail!";
            }
        }
        request.setAttribute("message", mess);
        System.out.println("url :" + url);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
