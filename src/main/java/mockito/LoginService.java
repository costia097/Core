package mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean checkIfExistUser(RegistrDto registrDto) {
        return loginRepository.findUserByLogin(registrDto.getLogin()) != null;
    }

    public void saveUser(RegistrDto registrDto) {
        loginRepository.saveUser(registrDto);
    }
}
