using Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;
using Shared.DTOs;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace WebAPI.Controllers;


[ApiController]
[Route("[controller]")]
public class ItemTypeController : ControllerBase
{
    private readonly IItemManager itemManager;

    public ItemTypeController(IItemManager itemManager)
    {
        this.itemManager = itemManager;
    }

    [HttpPost]
    public async Task<ActionResult<ItemType>> CreateAsync([FromBody] ItemTypeCreationDto dto)
    {
        try
        {
            Console.WriteLine("here");
            ItemType created = await itemManager.CreateItemTypeAsync(dto);
            return Created($"/itemtype/{created.Id}", created);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpGet]
    public async Task<ActionResult<ItemType>> ReadAsync([FromBody] ItemTypeSearchDto dto)
    {
        try
        {
            ItemType created = await itemManager.ReadItemTypeAsync(dto);
            return Created($"/itemtype/{created.Id}", created);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpGet("{dto : ItemTypeSearchDto}")]
    public async Task<ActionResult<bool>> CheckType([FromQuery]ItemTypeSearchDto dto)
    {
        try
        {
            return await itemManager.CheckType(dto);
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
            return StatusCode(500, e.Message);
        }
    }

}