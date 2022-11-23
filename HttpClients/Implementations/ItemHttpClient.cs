using System.Net;
using System.Net.Http.Json;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared.DTOs;
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
        
        if (response.StatusCode == HttpStatusCode.NotFound)
        {
            throw new Exception("ItemType not found");
        }
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
}