using System.Collections.Generic;
using System.Threading.Tasks;
using ClientgRPC.GRPC_stubs;
using NUnit.Framework;
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
}