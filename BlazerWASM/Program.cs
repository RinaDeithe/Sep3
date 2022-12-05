using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using BlazerWASM;
using BlazerWASM.StateContainer;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri(builder.HostEnvironment.BaseAddress) });
builder.Services.AddScoped<IItemService, ItemHttpClient>();
builder.Services.AddScoped<IItemTypeService, ItemTypeHttpClient>();
builder.Services.AddScoped<IShelfService, ShelfHttpClient>();

builder.Services.AddSingleton<AddNewItemBeginState>();

builder.Services.AddScoped(
    sp => 
        new HttpClient { 
            BaseAddress = new Uri("https://localhost:7162") 
        }
);

await builder.Build().RunAsync();