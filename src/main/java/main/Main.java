package main;

import accounts.AccountService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

/**
 * Created by AlxB on 02/12/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();

        SignInServlet signInServlet=new SignInServlet(accountService);
        SignUpServlet signUpServlet=new SignUpServlet(accountService);

        ServletContextHandler context=new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(signInServlet),"/signin");
        context.addServlet(new ServletHolder(signUpServlet),"/signup");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("web");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
