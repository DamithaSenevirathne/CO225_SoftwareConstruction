/*
gihanchanaka@gmail.com
E/14/158 CO225
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ShowCpanel implements ActionListener{
    /*
        This implements the CPANEL, which can show logs and change the prices as well
     */
    JList<String> list ;
    private JTextField logText;
    boolean readyToGo=false;
    JButton changePrince;
    javax.swing.JTextArea newPrice;
    JPanel panel;
    JScrollPane scrollPane;
    public void actionPerformed(ActionEvent e){
        if(e.getSource()!=Driver.timer && e.getSource()!=changePrince) {

            JFrame frame = new JFrame("Company logs");
            panel = new JPanel();

            frame.setSize(panel.getSize());
            panel.setLayout(new GridLayout(1,3));
            String[] ar=new String[Driver.symbolList.size()];
            Driver.symbolList.toArray(ar);
            list = new JList<String>(ar);
            JScrollPane scrollableList = new JScrollPane(list);
            list.setSize(500,400);
            scrollableList.setSize(500,400);
            panel.add(scrollableList, 0);


            logText = new JTextField("Select a company");

            panel.add(logText, 1);

            JPanel changeValue=new JPanel();
            changeValue.setLayout(new FlowLayout());
            newPrice=new JTextArea("Enter the new price");

            changeValue.add(newPrice);
            changePrince=new JButton("Change price");
            changePrince.addActionListener(this);
            changeValue.add(changePrince);

            panel.add(changeValue,2);

            frame.setContentPane(panel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            readyToGo=true;
        }
        else if(readyToGo && e.getSource()==changePrince ){
            try{
                StockItem si=Driver.stockItems.get(list.getSelectedValue());
                if(si.adminBid(Float.parseFloat(newPrice.getText()))){
                    Util.prln("Changing price by admin command");
                }
                else{
                    Util.prln("Bid higher!");
                }
            }
            catch (Exception eeee){
                //
            }


        }
        else if(readyToGo){
            try{
                String s="";
                ArrayList<String> ss= Driver.stockItems.get(list.getSelectedValue()).getLog();
                Iterator<String> sss=ss.iterator();
                while(sss.hasNext()){
                    s=s+sss.next()+System.getProperty("line.separator");

                }
                logText.setLayout(new FlowLayout());
                logText.setText(s);
                logText.setEditable(false);

            }
            catch(Exception ee){
                //
            }

        }


    }





}
