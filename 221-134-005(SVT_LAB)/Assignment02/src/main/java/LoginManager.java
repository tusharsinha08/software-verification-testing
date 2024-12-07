interface AuthenticationService
{
    boolean authenticate(String username,String password);
}

public class LoginManager
{
    private final AuthenticationService authenticationService;
    public LoginManager(AuthenticationService authenticationService)
    {
        this.authenticationService = authenticationService;
    }

    public boolean login(String username,String password) throws Exception
    {
        if(username == null || password == null)throw new Exception("Username and password cannot null");
        return authenticationService.authenticate(username,password);
    }
}