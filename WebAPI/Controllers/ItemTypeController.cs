﻿using Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;
using Shared.DTOs;
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
    public async Task<ActionResult<itemType>> CreateAsync([FromBody] ItemTypeCreationDto dto)
    {
        try
        {
            itemType created = await itemManager.createItemAsync(dto);
            return Created($"/ItemType/{created.Id}", created);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

}