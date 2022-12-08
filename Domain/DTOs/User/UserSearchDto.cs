namespace Shared.DTOs.User;

public class UserSearchDto
{
    public UserSearchDto(string id)
    {
        Id = id;
    }

    public string Id { get; init;  }

}