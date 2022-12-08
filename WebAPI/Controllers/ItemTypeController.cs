using Logic.Item;
using Microsoft.AspNetCore.Mvc;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace WebAPI.Controllers;


[ApiController]
[Route("[controller]")]
public class ItemTypeController : ControllerBase
{
    private readonly IItemLogic itemManager;

    public ItemTypeController(IItemLogic itemManager)
    {
        this.itemManager = itemManager;
    }

    [HttpPost]
    public async Task<ActionResult<ItemType>> CreateAsync([FromBody] ItemTypeCreationDto dto)
    {
        try
        {
            Console.WriteLine(dto.Id);
            ItemType created = await itemManager.CreateItemTypeAsync(dto);
            return Created($"/itemtype/{created.Id}", created);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpGet("{id:int}")]
    public async Task<ActionResult<ItemType>> ReadAsync([FromRoute] int id)
    {
        try
        {
            ItemTypeSearchDto dto = new ItemTypeSearchDto(id);
            Console.WriteLine(id);
            ItemType created = await itemManager.ReadItemTypeAsync(dto);
            return Created($"/itemtype/{created.Id}", created);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    

}