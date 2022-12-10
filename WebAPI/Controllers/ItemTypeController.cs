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
            return Created("/ItemType/", created);
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
            ItemType created = await itemManager.ReadItemTypeAsync(dto);
            if (created.Id!=id)
            {
                throw new Exception("ItemType not found");
            }
            return Ok(created);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    

    [HttpGet("Check/{id:int}")]
    public async Task<ActionResult<Boolean>> CheckType([FromRoute] int id)
    {
        try
        {
            return Ok(await itemManager.CheckType(new ItemTypeSearchDto(id)));
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
            return StatusCode(500, e.Message + "blah");
        }
    }

}