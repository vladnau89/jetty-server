package servlets;

import accounts.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by win on 22.12.2015.
 */
public class SignUpServlet extends HttpServlet {

    private final IAccountService accountService;

    public SignUpServlet(IAccountService accountService){
        this.accountService = accountService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String pass  = request.getParameter("password");

        if (login == null || pass == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        else{

            try {
                accountService.addUser(login, pass);
                response.setStatus(HttpServletResponse.SC_OK);
            }
            catch (Exception e){
                System.out.println("cann`t add user! " + e.getLocalizedMessage());
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

}
