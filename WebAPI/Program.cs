using LogicClient;
using LogicClient.ClientInterfaces;
using LogicClient.GRPC_stubs;
using Logic.Item;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddScoped<IItemLogic, ItemManager>();


builder.Services.AddScoped<IItemClient, TypeMainAdapter>();
builder.Services.AddScoped<IItemTypeClient, ItemTypeClient>();
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