package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSet.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    private final DBService loginToProfile;
    private final Map<String, User> sessionIdToProfile;

    public AccountService() {
        loginToProfile = new DBService();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(User userProfile) throws DBException{
        loginToProfile.addUser(userProfile);
    }

    public User getUserByLogin(String login)throws DBException {
        return loginToProfile.getUserByName(login);
    }

    public User getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, User userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
