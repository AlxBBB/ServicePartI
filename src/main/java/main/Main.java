package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

/**
 * Created by AlxB on 02/12/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SignInServlet signInServlet=new SignInServlet();
        SignUpServlet signUpServlet=new SignUpServlet();

        Server server=new Server(8080);
        ServletContextHandler context=new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(signInServlet),"/signin");
        context.addServlet(new ServletHolder(signUpServlet),"/signup");
        server.start();
        System.out.println("Server started");
        server.join();
    }
}
