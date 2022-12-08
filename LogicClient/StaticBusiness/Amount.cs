﻿using Shared.DTOs;
using Shared.Model;


public class Amount
{
    public static AmountOnSpaceDto AmountOnSpaceDto(Shelf shelf, ItemType _itemType)
    {
        double volumenShelf = shelf.DimX * shelf.DimY * shelf.DimZ;
        double volumenItemType = _itemType.DimX * _itemType.DimY * _itemType.DimZ;

        return new AmountOnSpaceDto(shelf.RowNo+shelf.ShelfNo,(int?)Math.Floor(volumenShelf / volumenItemType));
    }
}