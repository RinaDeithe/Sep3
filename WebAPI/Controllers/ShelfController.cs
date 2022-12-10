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

    [HttpPatch("AddItem")]
    public async Task<ActionResult<bool>> update([FromBody]ShelfAddItemRequestDto dtos)
    {
        
        try
        {
            Console.WriteLine("tete");
            bool succes = await _shelfManager.Update(dtos);
            if (succes)
            {
                return Ok("/shelf/AddItem");
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

    [HttpGet("Amount/{dto.Id}")]
    public async Task<ActionResult<ItemRegisterRequestDto>> GetAmountOnShelf([FromHeader]ItemTypeSearchDto dto)
    {
        Console.WriteLine("here");
        try
        {
            
            ItemRegisterRequestDto succes = await _shelfManager.GetAmountOnShelf(dto.Id);
           
                return Created($"Shelf/Amount/{dto.Id}",succes);
                
        }
        catch(Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}