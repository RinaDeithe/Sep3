using ClientgRPC;
using Logic.AdapterToGRPC.Item;
using Logic.AdapterToGRPC.ItemType;
using Logic.AdapterToGRPC.Shelf;
using Logic.Logic;
using Logic.LogicInterfaces;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddScoped<IItemLogic, ItemManager>();


builder.Services.AddScoped<IItemManager, ItemManager>();


builder.Services.AddScoped<IItemClient, TypeMainAdapter>();
builder.Services.AddScoped<IItemTypeClient, ItemTypeMainAdapter>();
builder.Services.AddScoped<IShelfClient, ShelfClient>();

builder.Services.AddScoped<IGRPCServerSide, GRPCServerSide>();






var app = builder.Build();

app.UseCors(x => x
    .AllowAnyMethod()
    .AllowAnyHeader()
    .SetIsOriginAllowed(origin => true) // allow any origin
    .AllowCredentials());

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment()) {
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();