namespace Shared.DTOs.Item; 

public record ItemCreationDto(string ItemTypeId, int Antal, string OwnerId, bool Reserved,string shelfId);