namespace Shared.DTOs.Item;

public record ItemRegisterReqiestDto
(
    int? ItemType,
    List<AmountOnSpaceDto> ShelfInfo);  