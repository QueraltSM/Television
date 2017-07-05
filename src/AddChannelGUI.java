import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddChannelGUI extends JDialog {
        private JTextField name = new JTextField(10);
        private JButton add = new JButton("Add");
        private JButton delete = new JButton("Cancel");

        public AddChannelGUI (JFrame f){
            super(f, "Add new channel to TV");
            JPanel p = new JPanel();
            p.setLayout(new FlowLayout());
            p.add(new JLabel("Channel name: "));
            p.add(name);

            JPanel p2 = new JPanel();
            p2.setLayout(new GridLayout(1,6));
            p2.add(new JPanel());
            p2.add(new JPanel());
            JPanel p3 = new JPanel();
            p3.add(add, BorderLayout.CENTER);
            p2.add(p3);


            JPanel p4 = new JPanel();
            p4.add(delete, BorderLayout.CENTER);
            p2.add(p4);

            p2.add(new JPanel());

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (GUI.getTv().addChannel(new Channel(name.getText()))) {
                        JOptionPane.showMessageDialog(AddChannelGUI.this, "Channel added.");
                        dispose();
                     } else {
                        JOptionPane.showMessageDialog(AddChannelGUI.this, "Name already taken.");
                        name.setText("");
                    }

                }
            });
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    name.setText("");
                }
            });


            setLayout(new GridLayout(3,1));
            add(p);
            add(p2);


            setVisible(true);
            setSize(380,200);
            setLocationRelativeTo(f);
        }


    }


