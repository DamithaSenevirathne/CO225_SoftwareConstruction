/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class ListUpdater implements ActionListener{
    /*
        This updates the auction server lists with a time gap

     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Driver.topCompanies.setVisible(false);

        Driver.topCompanies.clearList();
        for(int x=0;x<CompanyListPanel.prefferedCompanies.length;x++){
            String name=CompanyListPanel.prefferedCompanies[x];
            Driver.topCompanies.addCompany(Driver.stockItems.get(name));
        }
        Driver.topCompanies.setVisible(true);


        Driver.newBids.setVisible(false);
        Driver.newBids.clearList();
        Iterator<StockItem> it=Driver.lastestBids.iterator();
        while(it.hasNext()){
            StockItem item=it.next();
            Driver.newBids.addCompany(item);
        }
        Driver.newBids.setVisible(true);






    }
}
