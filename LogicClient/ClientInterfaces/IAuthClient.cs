using Shared.DTOs.User;
using Shared.Model;

namespace LogicClient.ClientInterfaces;

public interface IAuthClient
{
    User Read(UserSearchDto dto);
}