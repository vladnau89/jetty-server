package main;

import accounts.AccountService;
import accounts.IAccountService;
import accounts.UserProfile;
import dbService.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MirrorRequestServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;

/**
 * Created by win on 14.12.2015.
 */
public class Main {

    public static void main(String[] atgs) throws Exception{

        //IAccountService accountService = new AccountService();

        IAccountService accountService = new DBService();
        accountService.printConnectInfo();

//        try {
//            long userId = accountService.addUser("tully", "pass");
//            System.out.println("Added user id: " + userId);
//
//            UserProfile dataSet = accountService.getUser("tully", "pss");
//            System.out.println("User data set: " + dataSet);
//
//            accountService.cleanUp();
//        } catch (DBException e) {
//            e.printStackTrace();
//        }
//
//        if (true)
//        {
//            return;
//        }

        MirrorRequestServlet mirrorRequestServlet = new MirrorRequestServlet();
        SignUpServlet signUpServlet = new SignUpServlet(accountService);
        SignInServlet signInServlet = new SignInServlet(accountService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorRequestServlet), "/mirror");
        context.addServlet(new ServletHolder(signUpServlet), "/signup");
        context.addServlet(new ServletHolder(signInServlet), "/signin");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();

        System.out.println("Server started");

        server.join();
    }

}
