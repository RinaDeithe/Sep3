using System.Collections.Generic;
using ClientgRPC.StaticBusiness;
using Microsoft.AspNetCore.Authorization.Infrastructure;
using NUnit.Framework;
using NUnit.Framework.Interfaces;
using Shared.DTOs;
using Shared.Model;

namespace TestProject1;

public class Tests
{
    [SetUp]
    public void Setup()
    {
        
    }

    [Test]
    public void Test1()
    {
        User user= new User(10, null);
        
        
    }

    [Test]
    public void TestFill1Space()
    {
        //assign
        List<Item> items = new List<Item>();
        Shelf shelf = new Shelf("1", "1", 10, 10, 10,items);
        ItemType itemType = new ItemType(1, 10, 10, 10);
        
        AmountOnSpaceDto beforefilled = Amount.AmountOnSpaceDto(shelf, itemType);
        
        //act
        Item item = new Item(itemType, 1, new User(1, "s"),null);
        items.Add(item);
        AmountOnSpaceDto after =  Amount.AmountOnSpaceDto(shelf,itemType);

        //asssert
        Assert.AreEqual(beforefilled.ShelfId, after.ShelfId);
        Assert.AreEqual(beforefilled.AvalibleSpace, after.AvalibleSpace + 1);
    }
}