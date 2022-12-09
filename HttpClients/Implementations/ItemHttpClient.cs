using System.Net;
using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.DTOs;
using Shared.DTOs.Item;
using Shared.Model;

namespace HttpClients.Implementations; 

public class ItemHttpClient : IItemService {
    
    private HttpClient client;

    public ItemHttpClient(HttpClient client) {
        this.client = client;
    }

    public async Task<Item> CreateAsync(ItemCreationDto dto) {
        HttpResponseMessage response = await client.PostAsJsonAsync("/item", dto);
        string result = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode)
        {
            
            throw new Exception(result);
        }

        Item item = JsonSerializer.Deserialize<Item>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return item;
    }

    public async Task DeleItemAsync(ItemSearchDto dto)
    {
        HttpResponseMessage response = await client.DeleteAsync($"Item/{dto}");
        if (!response.IsSuccessStatusCode)
        {
            string content = await response.Content.ReadAsStringAsync();
            throw new Exception(content);
        }
    }

    public async Task ReserveItem(ItemCreationDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync($"Item/",dto);
        if (!response.IsSuccessStatusCode)
        {
            string content = await response.Content.ReadAsStringAsync();
            throw new Exception(content);
        }   
    }
}