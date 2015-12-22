package main;

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
        MirrorRequestServlet mirrorRequestServlet = new MirrorRequestServlet();
        SignUpServlet signUpServlet = new SignUpServlet();
        SignInServlet signInServlet = new SignInServlet();

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
