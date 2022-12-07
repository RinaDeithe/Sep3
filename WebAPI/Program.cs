using LogicClient.ClientInterfaces;
using LogicClient.GRPC_stubs;
using Logic.Authentication;
using Logic.Item;
using Logic.Shelf;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();


builder.Services.AddScoped<IShelfManager, ShelfManager>();
builder.Services.AddScoped<IAuthService, AuthService>();
builder.Services.AddScoped<IItemLogic, ItemManager>();
builder.Services.AddScoped<IItemClient, ItemStub>();
builder.Services.AddScoped<IItemTypeClient, ItemTypeStub>();
builder.Services.AddScoped<IShelfClient, ShelfStub>();
builder.Services.AddScoped<IUserClient, UserStub>();

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