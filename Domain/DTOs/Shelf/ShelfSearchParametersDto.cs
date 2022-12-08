namespace Shared.DTOs.Shelf; 

public record ShelfSearchParametersDto(
    string RowNo, string ShelfNo,double DimY,double DimZ,double DimX);