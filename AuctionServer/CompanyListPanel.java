/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CompanyListPanel extends JPanel{
    /*
        A panel to display a set of companies (Their symbols and prices)
     */
    static String[] prefferedCompanies={"FB", "VRTU","MSFT", "GOOGL", "YHOO", "XLNX", "TSLA" ,"TXN"};
    ArrayList<JButton> listOfCompanies;

    CompanyListPanel(Dimension dim, String title){
        listOfCompanies=new ArrayList<>();
        setPreferredSize(dim);
        this.setLayout(new GridLayout(11,1));
        this.add(new JLabel(title));
    }

    public void addCompany(StockItem item){
        JButton text=new JButton(item.getSymbol()+"      "+item.getPrice());
        text.setHorizontalTextPosition( SwingConstants.LEFT );
        text.addActionListener(new DisplayCompanyInfo(item));
        this.add(text);
        listOfCompanies.add(text);
    }


    public void clearList(){
        while (listOfCompanies.size()!=0){
            JButton temp=listOfCompanies.remove(0);
            this.remove(temp);
        }
    }





}
