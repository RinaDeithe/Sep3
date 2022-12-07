using Shared.DTOs.User;
using Shared.Model;

namespace HttpClients.ClientInterfaces;

public interface IAuthService
{
    User LoginAsync(UserLoginDto dto);
    Task LogoutAsync();
}