namespace Shared.DTOs.Shelf;

public record ShelfAddItemRequestDto
(int ItemTypeId, List<AmountOnSpaceDto> ShelfInfo, Model.User Owner);