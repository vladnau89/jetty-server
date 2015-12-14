package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MirrorRequestServlet;

/**
 * Created by win on 14.12.2015.
 */
public class Main {

    public static void main(String[] atgs) throws Exception{
        MirrorRequestServlet mirrorRequestServlet = new MirrorRequestServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorRequestServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();

        System.out.println("Server started");

        server.join();
    }

}
