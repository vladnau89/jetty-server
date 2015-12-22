package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win on 22.12.2015.
 */
public class SignInServlet extends HttpServlet {

    private final AccountService accountService;

    public SignInServlet(AccountService accountService){
        this.accountService = accountService;
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String pass  = request.getParameter("password");

        response.setContentType("text/html;charset=utf-8");

        if (login == null || pass == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print("Unauthorized");
            return;
        }

        UserProfile profile = accountService.getUserByLogin(login);
        if (profile == null || !profile.getPass().equals(pass)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print("Unauthorized");
        }
        else{
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print("Authorized");
        }

    }

}
