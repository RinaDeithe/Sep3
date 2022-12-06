using Shared.DTOs.User;
using Shared.Model;

namespace ClientgRPC.ClientInterfaces;

public interface IUserClient
{
    User Read(UserSearchDto userSearchDto);
}