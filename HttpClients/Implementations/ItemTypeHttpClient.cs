using System.Net;
using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.DTOs;
using Shared.DTOs.ItemType;
using Shared.Model;


namespace HttpClients.Implementations;

public class ItemTypeHttpClient : IItemTypeService
{
    private readonly HttpClient client;

    public ItemTypeHttpClient(HttpClient client) {
        this.client = client;
    }
    public async Task<ItemType> CreateAsync(ItemTypeCreationDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/itemsType", dto);
        string result = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode)
        {
            
            throw new Exception(result);
        }

        ItemType itemType = JsonSerializer.Deserialize<ItemType>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return itemType;
    }

    public async Task<ItemType> ReadAsync(ItemTypeSearchDto dto)
    {
        HttpResponseMessage response = await client.GetAsync("/ItemType");
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        ItemType result = JsonSerializer.Deserialize<ItemType>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return result;
    }

    public async Task<bool> CheckType(ItemTypeSearchDto dto)
    {
        HttpResponseMessage response = await client.GetAsync($"/ItemType/{dto}");
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        bool result = JsonSerializer.Deserialize<bool>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return result;
    }
}
