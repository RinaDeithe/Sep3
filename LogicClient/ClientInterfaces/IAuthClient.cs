using Shared.DTOs.User;
using Shared.Model;

namespace ClientgRPC.ClientInterfaces;

public interface IAuthClient
{
    User Read(UserSearchDto dto);
}