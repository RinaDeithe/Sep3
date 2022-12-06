namespace Shared.DTOs.User;

public class UserLoginDto
{
    public UserLoginDto(string userName, string password)
    {
        throw new NotImplementedException();
    }

    public UserLoginDto Id { get; init; }
    public string Password { get; init; }
}