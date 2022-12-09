namespace Shared.DTOs.Item;

public record ItemRegisterRequestDto
(
    int? ItemType,
    List<AmountOnSpaceDto> ShelfInfo);  