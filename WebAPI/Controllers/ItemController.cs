using Logic.Logic;
using Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;
using Shared.DTOs;
using Shared.Model;

namespace WebAPI.Controllers; 

[ApiController]
[Route("[Controller]")]
public class ItemController : ControllerBase {

    private IItemLogic _itemLogic = new ItemManager();


    public ItemController(IItemLogic itemLogic) {
        this._itemLogic = itemLogic;
    }

    [HttpPost]
    public async Task<ActionResult<Item>> CreateAsync(ItemCreationDto dto) {
        try {
            Item item = await _itemLogic.CreateAsync(dto);
            if (item.Type.Id!=dto.ItemTypeId)
            {
                return StatusCode(428, "ItemType not found");
            }
            return Created($"/item/{item.Uid}", item);
        }
        catch (Exception e) {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpDelete("id:int")]
    public async Task<ActionResult> DeleteAsync(ItemSearchDto dto)
    {
        
       try
        {
            await _itemLogic.DeleteItemAsync(dto);
            return Ok();
        }
        catch(Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}