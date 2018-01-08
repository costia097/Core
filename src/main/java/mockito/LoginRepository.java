package mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    @Autowired
    private Object sessionFactori;

    public Object findUserByLogin(String login) {
        sessionFactori.hashCode();
         return new Object();
    }

    public void saveUser(RegistrDto registrDto) {
        sessionFactori.hashCode();
    }
}
