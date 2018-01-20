package mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @Mock
    private LoginService loginService;

    @InjectMocks
    private LoginController loginController;

    @Before
    public void before() {
    }

    @Test
    public void testIfUserAlreadyExist() {
        when(loginService.checkIfExistUser(any())).thenReturn(true);
        //Запускаем флов
        loginController.registration(any());
        //Проверяем что метод вызвался с лююым аргументом
        verify(loginService).checkIfExistUser(any());
        //Проверяем что метод с задаными входными параметрами возврашает результат еквивалентный заданому
        assertThat(loginService.checkIfExistUser(any()), is(equalTo(true)));
        //Проверяем что метод возврашает заданый результат
        assertThat(loginController.registration(any()),is(equalTo("User already exist")));
    }

    @Test
    public void testIfUserNotExist() {
        when(loginService.checkIfExistUser(any())).thenReturn(false);
        loginController.registration(any());
        verify(loginService).checkIfExistUser(any());
        assertThat(loginService.checkIfExistUser(any()), is(equalTo(false)));
        assertThat(loginController.registration(any()),is(equalTo("suc")));
    }

}
