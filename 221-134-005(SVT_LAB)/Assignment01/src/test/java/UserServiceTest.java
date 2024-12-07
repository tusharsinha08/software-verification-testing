import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findUserById() {
        User mockUser = new User(1, "X");

        when(userRepository.findUserById(1)).thenReturn(mockUser);

        User result = userService.findUserById(1);

        assertEquals(mockUser, result);

        assertEquals("X",result.getName());

        verify(userRepository, times(1)).findUserById(1);
    }

    @Test
    void findUserByIdNotFound(){
        when(userRepository.findUserById(999)).thenReturn(null);

        User result = userService.findUserById(999);

        assertNull(result);

        verify(userRepository, times(1)).findUserById(999);
    }
}