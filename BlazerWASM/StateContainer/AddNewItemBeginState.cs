using Microsoft.AspNetCore.Components;

namespace BlazerWASM.StateContainer;

public class AddNewItemBeginState
{
    [Parameter]
    public string Id { get; set; }
    public int Amount { get; set; }
    public string User { get; set; }
}