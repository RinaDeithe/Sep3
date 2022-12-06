namespace LogicClient.Adapters.Shelf;

public class GetAllShelves
{
    private readonly IGRPCServerSide _grpcServerSide;

    public GetAllShelves(IGRPCServerSide grpcServerSide)
    {
        _grpcServerSide = grpcServerSide;
    }

    public List<Shared.Model.Shelf> getRequest()
    {
        throw new NotImplementedException();
    }
}