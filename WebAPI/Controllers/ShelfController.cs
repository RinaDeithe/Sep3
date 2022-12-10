using Logic.Shelf;
using Microsoft.AspNetCore.Mvc;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.DTOs.Shelf;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class ShelfController : ControllerBase
{
    private readonly IShelfManager _shelfManager;

    public ShelfController(IShelfManager shelfManager)
    {
        _shelfManager = shelfManager;
    }

    [HttpPatch]
    public async Task<ActionResult<bool>> update(ShelfAddItemRequestDto dtos)
    {
        
        try
        {
            bool succes = await _shelfManager.Update(dtos);
            if (succes)
            {
                return Ok();
            }
            return StatusCode(500, "something went wrong");
        }
        catch(Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpGet]
    [Route("HasRoom")]
    public async Task<ActionResult<bool>> HasRoom(ItemRegisterResponseDto dto)
    {
        try
        {
            return await _shelfManager.HasRoom(dto);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    public async Task<ActionResult<ItemRegisterRequestDto>> GetAmountOnShelf(ItemTypeSearchDto dto)
    {
        try
        {
            
            ItemRegisterRequestDto succes = await _shelfManager.GetAmountOnShelf(dto.Id);
           
                return Created("Shelf/Amount",succes);
                
        }
        catch(Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}