package mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/registrate")
    public String registration(RegistrDto registrDto) {
        boolean b = loginService.checkIfExistUser(registrDto);
        if (b) {
            return "user already exist";
        }
        loginService.saveUser(registrDto);
        return "suc";
    }

}
