using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using HttpClients.ClientInterfaces;
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
        Console.WriteLine("testt");
        HttpResponseMessage response = await client.PostAsJsonAsync("/ItemType/", dto);
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
        HttpResponseMessage response = await client.GetAsync($"/ItemType/{dto.Id}");
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
        
        HttpResponseMessage response = await client.GetAsync($"/ItemType/Check/{dto.Id}");
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            
            throw new Exception(content);
        }
        Boolean result = System.Text.Json.JsonSerializer.Deserialize<Boolean>(content);
         return result;
    }
}
