package dbService.dao;

import dbService.dataSet.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UserDAO {

    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public User get(long id) throws HibernateException {
        return (User) session.get(User.class, id);
    }

    public long getId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(User.class);
        return ((User) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }

    public User getByName(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(User.class);
        return ((User) criteria.add(Restrictions.eq("name", name)).uniqueResult());
    }

    public long insert(String name, String password) throws HibernateException {
        return (Long) session.save(new User(name, password));
    }
    public long insert(User user) throws HibernateException {
        return (Long) session.save(user);
    }
}
