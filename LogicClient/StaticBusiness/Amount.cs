﻿using Shared.DTOs;
using Shared.Model;

namespace ClientgRPC.StaticBusiness;

public class Amount
{
    public static AmountOnSpaceDto AmountOnSpaceDto(Shelf shelf, ItemType itemType)
    {
        double volumenShelf = shelf.DimX * shelf.DimY * shelf.DimZ;
        double volumenItemType = itemType.DimX * itemType.DimY * itemType.DimZ;

        foreach (Item ItemOnShelf in shelf.ItemsOnShelf)
        {
            volumenShelf -= ItemOnShelf.Type.DimX * ItemOnShelf.Type.DimY * ItemOnShelf.Type.DimZ;
        }

        return new AmountOnSpaceDto(shelf.RowNo+shelf.ShelfNo,(int?)Math.Floor(volumenShelf / volumenItemType));
    }

    public static double ItemTypeMass(ItemType type)
    {
        double volumenItemType = type.DimX * type.DimY * type.DimZ;
        return volumenItemType;
    }

    public static double ShelfMass(Shelf shelf)
    {
        return shelf.DimX * shelf.DimY * shelf.DimZ;
    }
}