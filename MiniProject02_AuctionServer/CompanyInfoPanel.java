/*
gihanchanaka@gmail.com
E/14/158 CO225
 */
import javax.swing.*;
import java.awt.*;

public class CompanyInfoPanel extends JPanel{
    /*
        The panel to display the information about a single company once it's name is clicked
     */
    static final long serialVersionUID = 1L; //Just to supress compiler warning

    CompanyInfoPanel(StockItem item){
        this.setLayout(new GridLayout(Driver.fields.length+1,2));
        this.setPreferredSize(new Dimension(400,400));

        for(int x=0;x<Driver.fields.length;x++){

            JTextField parameter=new JTextField(Driver.fields[x]);
            parameter.setEditable(false);
            JTextField value=new JTextField(item.get(Driver.fields[x]));
            value.setEditable(false);
            value.setHorizontalAlignment(SwingConstants.LEFT);
            this.add(parameter);
            this.add(value);
            parameter.setLocation(x,0);
            value.setLocation(x,1);
        }

        JTextField parameter=new JTextField("Bidder");
        parameter.setEditable(false);
        JTextField value=new JTextField(item.getBidder());
        value.setEditable(false);
        value.setHorizontalAlignment(JTextField.LEFT);
        this.add(parameter);
        this.add(value);
        parameter.setLocation(Driver.fields.length,0);
        value.setLocation(Driver.fields.length,1);

    }


}
