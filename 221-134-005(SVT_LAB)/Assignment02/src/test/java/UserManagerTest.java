import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserManagerTest {

    @Test
    void registerUser() {
        UserService userServiceMock = mock(UserService.class);

        // Stub the usernameExists method
        when(userServiceMock.usernameExists("existingUser")).thenReturn(true);
        when(userServiceMock.usernameExists("newUser")).thenReturn(false);

        // Stub the saveUser method
        when(userServiceMock.saveUser("newUser", "password123")).thenReturn(true);
        when(userServiceMock.saveUser("invalidUser", "password")).thenReturn(false);

        // Create an instance of UserManager with the mocked UserService
        UserManager userManager = new UserManager(userServiceMock);

        // Test case: Register with an existing username
        assertFalse(userManager.registerUser("existingUser", "password123"));
        verify(userServiceMock).usernameExists("existingUser");
        verify(userServiceMock, never()).saveUser("existingUser", "password123");

        // Test case: Register with a new valid username
        assertTrue(userManager.registerUser("newUser", "password123"));
        verify(userServiceMock).usernameExists("newUser");
        verify(userServiceMock).saveUser("newUser", "password123");

        // Test case: Register with a username that fails save
        assertFalse(userManager.registerUser("invalidUser", "password"));
        verify(userServiceMock).usernameExists("invalidUser");
        verify(userServiceMock).saveUser("invalidUser", "password");
    }

}