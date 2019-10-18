package bot.looter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    public static void main(String[] args) {

    }

    private JTextField textField1;
    private JPanel panel1;
    private JButton Ok;
    public static int x;
    Looter looter= new Looter();

    public void Gui(){
        JFrame frame = new JFrame("Gui");
        frame.setContentPane(new Gui().panel1);
        frame.pack();
        frame.setVisible(true);

        Ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Ok.isEnabled()){
                    x=Integer.parseInt(textField1.getText());
                    looter.adamantArrow=x;
                    System.out.println(x);
                }
            }
        });

    }
}
