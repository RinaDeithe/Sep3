namespace Shared.DTOs.Item; 

public record ItemCreationDto(int ItemTypeId, int Antal, int OwnerId, bool Reserved,int? shelfId);