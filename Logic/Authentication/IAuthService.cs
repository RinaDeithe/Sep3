using Shared.DTOs.User;
using Shared.Model;

namespace Logic.Authentication;

public interface IAuthService
{
    User ValidateUser(UserLoginDto user);
}