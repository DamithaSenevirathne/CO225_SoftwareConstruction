/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import java.util.HashMap;

public class HashMap2 extends HashMap<String, StockItem>
{
    /*
        Just a small tweak to the existing HashMap class for convinience
     */
    public void put(StockItem item){
        super.put(item.symbol,item);
    }
}
