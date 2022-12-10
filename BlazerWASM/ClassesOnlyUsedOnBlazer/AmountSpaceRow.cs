namespace BlazerWASM.ClassesOnlyUsedOnBlazer;

public class AmountSpaceRow
{
    public int Antal { get; set; }
    public int AvalibleSpace { get; set; }
    public String ShelfID { get; set; }

    public AmountSpaceRow(int antal, int spaceAmount, string row)
    {
        Antal = antal;
        AvalibleSpace = spaceAmount;
        this.ShelfID = row;
    }
}