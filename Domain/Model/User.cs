namespace Shared.Model; 

public class User {
    public User(int id, string? role)
    {
        Id = id;
        Role = role;
    }
    public int Id { get; init; }
    public string? Role { get; init; }
}