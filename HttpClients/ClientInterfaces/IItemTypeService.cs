﻿using Shared.DTOs.ItemType;
using Shared.Model;

namespace HttpClients.ClientInterfaces;

public interface IItemTypeService
{
    Task<ItemType> CreateAsync(ItemTypeCreationDto dto);
    Task<ItemType> ReadAsync(ItemTypeSearchDto dto);
    
    Task<bool> CheckType(ItemTypeSearchDto dto);
}