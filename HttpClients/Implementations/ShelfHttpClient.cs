using System.Text;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.DTOs.Shelf;
using Shared.Model;

namespace HttpClients.Implementations;

public class ShelfHttpClient : IShelfService
{
    private readonly HttpClient client;
    public ShelfHttpClient(HttpClient client)
    {
        this.client = client;
    }

    public async Task<bool> AddItemToShelf(List<ShelfAddItemRequestDto> dto)
    {
        string dtoAsJson = JsonSerializer.Serialize(dto);
        StringContent body = new StringContent(dtoAsJson, Encoding.UTF8, "application/json");

        HttpResponseMessage response = await client.PatchAsync("/shelf/AddItem", body);
        return true;
    }

    public async Task<List<Shelf>> getShelfs()
    {
        HttpResponseMessage response = await client.GetAsync("/Shelfs");
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        List<Shelf> shelves = JsonSerializer.Deserialize<List<Shelf>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return shelves;
    }

    public async Task<bool> HasRoom(ItemRegisterResponseDto dto)
    {
        HttpResponseMessage response = await client.GetAsync("/Shelf/HasRoom");
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        return JsonSerializer.Deserialize<bool>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
    }
    public async Task<ItemRegisterRequestDto> GetAmountOnShelf(ItemTypeSearchDto dto)
    {
        HttpResponseMessage response = await client.GetAsync($"/Shelfs/{dto.Id}");
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }
        
        ItemRegisterRequestDto shelves = JsonSerializer.Deserialize<ItemRegisterRequestDto>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return shelves;
    }
}