namespace Shared.DTOs.Shelf;

public record ShelfAddItemRequestDto
(string ItemTypeId, List<AmountOnSpaceDto> ShelfInfo, Model.User Owner);