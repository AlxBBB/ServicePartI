package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AlxB on 09/12/2017.
 */
public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=utf-8");
        if (login == null || password == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        
        UserProfile profile=new UserProfile(login,password,login);
        accountService.addNewUser(profile);

        accountService.addSession(request.getSession().getId(), profile);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
