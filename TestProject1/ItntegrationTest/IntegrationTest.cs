using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using ClientgRPC.Converters;
using ClientgRPC.GRPC_stubs;
using GRPC.Proto;
using Microsoft.AspNetCore.Mvc;
using NUnit.Framework;
using Shared.DTOs.Item;
using Shared.Model;

namespace TestProject1;

public class IntegrationTest
{
    [SetUp]
    public void Setup()
    {
        
    }


    [Test]
    public async Task FåItemIgennemGRPCVIAShelf()
    {
        ClientgRPC.GRPC_stubs.ShelfStub ShelfStub = new ShelfStub();

        List<Shelf> shelves = await ShelfStub.ReadAll();

        bool resultat = false;

        foreach (Shelf hylde in shelves)
        {
            if (hylde.ItemsOnShelf.Count>0)
            {
                resultat = true;
                Assert.True(hylde.ItemsOnShelf.Count>0);
            }
            
        }

        if (resultat == false)
        {
            Assert.Fail("it couldn't find any items on any shelves");
        }

        
    }
    
    [Test]
    public async Task FåHyldeFraGetAll()
    {
        ClientgRPC.GRPC_stubs.ShelfStub ShelfStub = new ShelfStub();

        List<Shelf> shelves = await ShelfStub.ReadAll();

        bool resultat = false;

        foreach (Shelf hylde in shelves)
        {
            if (hylde.RowNo=="1")
            {
                resultat = true;
                Assert.True(hylde.RowNo=="1");
            }
            
        }

        if (resultat == false)
        {
            Assert.Fail("Den kan ikke finde række 1");
        }

        
    }

    [Test]
    public async Task GemItemPåDatabase()
    {
        //assign
        ItemType itemType = new ItemType(1, 2.2, 3.9, 4.0);
        User user = new User(1, "ee");
        List<Item> items = new List<Item>();
        Shelf shelf = new Shelf("1", "1", 1.2, 2.3, 4.0, items);
        Item item = new Item(itemType,1,user,shelf);

        
        
        ItemStub itemStub = new ItemStub();

        ItemCreationDto itemCreationDto = new ItemCreationDto(1, 1, -1, false, "test");
        
        //act
        Item newitem = await itemStub.Create(itemCreationDto);
        

        
        //assert
        Assert.Equals(newitem,itemStub.Read(new ItemSearchDto(newitem.Uid)));
        
        
        await itemStub.Delete(new ItemSearchDto(newitem.Uid));
        
        
    }

    [Test]
    public async Task ItemHasShelf()
    {
        ItemStub itemStub = new ItemStub();

        Item item = await itemStub.Read(new ItemSearchDto(-1));

        Assert.NotNull(item.Shelf);
    }

    [Test]
    public async Task DeleteItemDerIkkeFindes()
    {
        ItemStub itemStub = new ItemStub();

        Item item = await itemStub.Delete(new ItemSearchDto(-10000));
        
        Console.WriteLine(item.Uid);
    }


    
}