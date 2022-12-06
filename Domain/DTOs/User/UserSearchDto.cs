namespace Shared.DTOs.User;

public class UserSearchDto
{
    public UserSearchDto(int id)
    {
        Id = id;
    }

    public int Id { get; init;  }

}