using ClientgRPC.ClientInterfaces;
using Shared.DTOs.User;
using Shared.Model;

namespace Logic.Authentication;

public class AuthService : IAuthService
{
    private IUserClient client;
    public async Task<User> ValidateUser(UserLoginDto dto)
    {
        
        User? existingUser = client.Read(new UserSearchDto(dto.Id));

        if (existingUser == null)
        {
            throw new Exception("User not found");
        }
/*
        if (!existingUser.Password.Equals(dto.Password))
        {
            throw new Exception("Password mismatch");
        }
*/
        return await Task.FromResult(existingUser);
    }
}