import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//<applet code="Banking" width="300" height="200"></applet>
public class Banking extends Applet implements ActionListener
{
    double amt=0;
    String msg="",str="";
    void deposit(double d)
    {
        amt+=d;
    }
    void withdraw(double w)throws MyException
    {
        if(w<=amt)
           amt-=w;
        else
            throw new MyException();
    }
    Frame f=new Frame("Bank");
    TextField num1,num2;
    TextArea a=new TextArea(str);
    Button btnd,btnw,btnb,btno;
    Label l=new Label();
    public void init() 
    {
        btnd=new Button("DEPOSIT");
        btnw=new Button("WITHDRAW");
        btnb=new Button("BALANCE");
        btno=new Button("OK");
        num1=new TextField(10);
        num2=new TextField(10);
                        
        f.add(btnd);
        f.add(btnw);
        f.add(btnb);
                        
        num1.setBounds(100,150,150,30);
        num2.setBounds(100,150,150,30);
                
        btnd.setBounds(100,100,60,30);
        btnw.setBounds(180,100,80,30);
        btnb.setBounds(280,100,70,30);
        btno.setBounds(300,150,60,30);
        
        l.setBounds(100,200,500,50);
        
        btnd.addActionListener(this);
        btnw.addActionListener(this);
        btnb.addActionListener(this);
        btno.addActionListener(this);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,450);
    }
    public void actionPerformed(ActionEvent e) 
    {
        String str = e.getActionCommand();
        switch(str)
        {
            case "DEPOSIT":f.add(num1);
                           f.add(btno);
                           f.remove(l);
                           f.remove(num2);
                           double dep=Double.parseDouble(num1.getText());
                           deposit(dep);
                           l.setText("Amount deposited successsfully. Kindly check the balance.");
                           break;
            case "WITHDRAW":f.add(num2);
                            f.add(btno);
                            f.remove(l);
                            f.remove(num1);
                            double with=Double.parseDouble(num2.getText());
                            try
                            {
                                withdraw(with);
                                l.setText("Amount withdrawn successsfully. Kindly check the balance.");
                            }
                            catch(MyException ex)
                            {
                                l.setText("Insufficient Balance.");
                            }
                            f.add(l);
                            break;
            case "BALANCE":l.setText("Balance: "+amt);
                           f.add(l);
                           f.remove(num1);
                           f.remove(num2);
                           f.remove(btno);
                           break;
            case "OK":f.add(l);
                      break;
        }
    } 
}