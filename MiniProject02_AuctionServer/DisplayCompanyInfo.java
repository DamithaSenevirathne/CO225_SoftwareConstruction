/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayCompanyInfo implements ActionListener {
    /*
        The action listener for company name buttons on the auction server panel
        Once a button is clicked this will display the information about that company
     */

    StockItem item;
    DisplayCompanyInfo(StockItem item){
        this.item=item;
    }

    public void actionPerformed(ActionEvent e){
        CompanyInfoPanel companyInfoPanel=new CompanyInfoPanel(item);


        JFrame companyInfoFrame=new JFrame("Company Info");
        companyInfoFrame.setLayout(new FlowLayout());
        companyInfoFrame.add(companyInfoPanel);
        companyInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        companyInfoFrame.setLocationRelativeTo(null);
        companyInfoFrame.pack();
        companyInfoFrame.setVisible(true);






    }
}
