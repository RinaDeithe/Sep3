using Microsoft.AspNetCore.Mvc;
using Shared.DTOs.Item;
using Shared.Model;
using IItemLogic = Logic.Item.IItemLogic;

namespace WebAPI.Controllers; 

[ApiController]
[Route("[Controller]")]
public class ItemController : ControllerBase {

    private IItemLogic _itemLogic;


    public ItemController(IItemLogic itemLogic) {
        this._itemLogic = itemLogic;
    }

    [HttpPost]
    public async Task<ActionResult<Item>> CreateAsync([FromBody]ItemCreationDto dto) {
        try {
            Console.WriteLine(dto);
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
    
    
    [HttpPost("reserve")]
    public async Task<ActionResult> ReserveItem([FromBody]ItemCreationDto dto) {
        try
        {
            await _itemLogic.ReserveItem(dto);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message + "test");
            return StatusCode(500, e.Message);
        }
    }

    [HttpDelete("{id}")]
    public async Task<ActionResult> DeleteAsync([FromRoute] int id)
    {
        try
        {
            await _itemLogic.DeleteItemAsync(new ItemSearchDto(id));
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpGet]
    public async Task<ActionResult<List<Item>>> GetAllItems()
    {
        try
        {
            List<Item> items = await _itemLogic.ReadAllAsync();
            return Ok(items);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
        
    }
}