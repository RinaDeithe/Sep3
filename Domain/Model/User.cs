namespace Shared.Model; 

public class User {
    public User(string id, string? role)
    {
        Id = id;
        Role = role;
    }
    public string Id { get; init; }
    public string? Role { get; init; }
}