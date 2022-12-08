namespace Shared.DTOs.Item;

public record ItemRegisterReqiestDto
(
    string? ItemType,
    List<AmountOnSpaceDto> ShelfInfo);  