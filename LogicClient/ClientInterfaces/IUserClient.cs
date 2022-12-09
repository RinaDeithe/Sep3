using Shared.DTOs.User;
using Shared.Model;

namespace ClientgRPC.ClientInterfaces;

public interface IUserClient {
    Task<User> Create(UserCreationDto dto);
    Task<User> Read(UserSearchDto dto);
    Task<List<User>> ReadAll();
    Task<User> Update(User entity);
    Task<User> Delete(UserSearchDto dto);

}