using Shared.DTOs.User;
using Shared.Model;

namespace Logic.Authentication;

public interface IAuthService
{
    Task<User> ValidateUser(UserLoginDto user);
}