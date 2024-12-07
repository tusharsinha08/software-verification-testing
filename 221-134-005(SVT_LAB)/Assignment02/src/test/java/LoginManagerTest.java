import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LoginManagerTest {

    @Test
    void testLogin() throws Exception {

        AuthenticationService authServiceMock = mock(AuthenticationService.class);
        when(authServiceMock.authenticate("validUser", "validPass")).thenReturn(true);
        when(authServiceMock.authenticate("invalidUser", "invalidPass")).thenReturn(false);


        LoginManager loginManager = new LoginManager(authServiceMock);
        assertTrue(loginManager.login("validUser", "validPass"));
        verify(authServiceMock).authenticate("validUser", "validPass");


        assertFalse(loginManager.login("invalidUser", "invalidPass"));
        verify(authServiceMock).authenticate("invalidUser", "invalidPass");  // Verify correct arguments

        Exception usernameException = assertThrows(Exception.class,
                () -> loginManager.login(null, "somePass"));
        assertEquals("Username and password cannot null", usernameException.getMessage());


        Exception passwordException = assertThrows(Exception.class,
                () -> loginManager.login("someUser", null),
                "Expected an exception for null password");
        assertEquals("Username and password cannot null", passwordException.getMessage());
    }
}