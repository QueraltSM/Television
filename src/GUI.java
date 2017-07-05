import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private static Television t = new Television();
    private static Channel c1 = new Channel("Television 1");
    private static Channel c2 = new Channel("Channel 2");
    private static Channel c3 = new Channel("Jason 3");

    private JFrame f = new JFrame();


    private JButton seeChannels = new JButton("See channels");
    private JButton addChannel = new JButton("Add channel");
    private JButton searchChannel = new JButton("Search channel");
    private JButton deleteChannel = new JButton("Delete channel");
    private JButton swapChannel = new JButton("Swap channels");

    private JTextField name = new JTextField(10);
    private JButton proceed = new JButton("Proceed");
    private JButton cancel = new JButton("Cancel");


    public static Television getTv() {
        return t;
    }

    public GUI() {

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(8,1));
        JPanel p1 = new JPanel();
        p1.add(seeChannels, BorderLayout.CENTER);
        p.add(p1);

        seeChannels.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SeeChannelsGUI(new JFrame());
            }
        });

        JPanel p2 = new JPanel();
        p2.add(addChannel, BorderLayout.CENTER);
        p.add(p2);

        addChannel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddChannelGUI(new JFrame());
            }
        });

        JPanel p3 = new JPanel();
        p3.add(searchChannel, BorderLayout.CENTER);
        p.add(p3);

        searchChannel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initF();
                f.setTitle("Search a Channel");

                proceed.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (t.search(name.getText())!=null) {
                            JOptionPane.showMessageDialog(GUI.this, "Channel number: " + t.search(name.getText()).getnChannel());
                         } else {
                            JOptionPane.showMessageDialog(GUI.this, "No Channel named " + name.getText());
                        }
                    }
                });



            }
        });

        JPanel p4 = new JPanel();
        p4.add(deleteChannel, BorderLayout.CENTER);
        p.add(p4);


        deleteChannel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initF();
                f.setTitle("Delete a Channel");

                proceed.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (t.search(name.getText())!=null) {
                            t.removeChannel(name.getText());
                            JOptionPane.showMessageDialog(GUI.this, "Channel was successfully deleted.");
                            f.dispose();
                        } else {
                            JOptionPane.showMessageDialog(GUI.this, "No channel named " + name.getText());
                        }
                    }
                });

            }
        });



        JPanel p5 = new JPanel();
        p5.add(swapChannel, BorderLayout.CENTER);
        p.add(p5);

        swapChannel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f = new JFrame();
                f.setTitle("Swapping Channels");
                f.setVisible(true);
                f.setSize(250, 200);
                f.setLocationRelativeTo(null);

                JPanel aux5 = new JPanel();
                aux5.setLayout(new GridLayout(2,1));
                JPanel aux6 = new JPanel();
                aux6.setLayout(new FlowLayout());
                aux6.add(new JLabel("Channel named: "));
                TextField channel1 = new TextField(10);
                aux6.add(channel1);

                JPanel aux7 = new JPanel();
                aux7.setLayout(new FlowLayout());
                aux7.add(new JLabel("Channel named: "));
                TextField channel2 = new TextField(10);
                aux7.add(channel2);

                aux5.add(aux6);
                aux5.add(aux7);


                f.setLayout(new GridLayout(2,1));
                f.add(aux5);
                JPanel aux8 = new JPanel();
                aux8.setLayout(new FlowLayout());
                JButton swap = new JButton("Swap");
                aux8.add(swap);
                JButton delete = new JButton("Cancel");
                aux8.add(delete);
                f.add(aux8);

                swap.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (t.swapChannels(t.search(channel1.getText()), t.search(channel2.getText()))) {
                            JOptionPane.showMessageDialog(GUI.this, "Swap was successful.");
                            f.dispose();
                        } else {
                            JOptionPane.showMessageDialog(GUI.this, "Swap was not successful.");
                        }

                    }
                });



            }
        });


        add(p, BorderLayout.CENTER);

        initComponents();
        setVisible(true);
        setSize(400, 275);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initF() {
        f = new JFrame();
        f.setVisible(true);
        f.setSize(250, 200);
        f.setLocationRelativeTo(null);
        JPanel aux1 = new JPanel();
        aux1.setLayout(new GridLayout(2,1));
        JPanel aux3 = new JPanel();
        aux3.add(new JLabel("Channel named: "));
        aux3.add(name);
        aux1.add(aux3);

        JPanel aux2 = new JPanel();
        aux2.setLayout(new FlowLayout());
        aux2.add(proceed);
        aux2.add(cancel);
        aux1.add(aux2);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.add(aux1, BorderLayout.CENTER);

    }

    public  static void main(String[] args) {
        new GUI();
    }

    private void initComponents() {
        setTitle("TV Channels Configuration");
        t.addChannel(c1);
        t.addChannel(c2);
        t.addChannel(c3);

    }
}