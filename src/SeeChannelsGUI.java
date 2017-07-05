import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeChannelsGUI extends JDialog {
    private JTextArea text = new JTextArea(10, 20);
    private JRadioButton ord1 = new JRadioButton("Channel number");
    private JRadioButton ord2 = new JRadioButton("Channel name");
    private ButtonGroup bg = new ButtonGroup();
    private JScrollPane sp = new JScrollPane(text, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    public SeeChannelsGUI(JFrame f){
        super(f, "See all channels");
        bg.add(ord1);
        bg.add(ord2);

        setLayout(new GridLayout(2,1));
        JPanel p = new JPanel();
        text.setEditable(false);
        p.add(sp, BorderLayout.CENTER);

        text.setText(GUI.getTv().toString());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4,1));

        JPanel p3 = new JPanel();
        p3.add(new JLabel("Order by: "), BorderLayout.CENTER);
        p1.add(p3);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(ord1);
        p2.add(ord2);

        ord1.setSelected(true);
        GUI.getTv().setOrder(0);
        text.setText(GUI.getTv().toString());

        ord1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                GUI.getTv().setOrder(0);
                text.setText(GUI.getTv().toString());
            }
        });


        ord2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                GUI.getTv().setOrder(1);
                text.setText(GUI.getTv().toString());
            }
        });

        p1.add(p2, BorderLayout.CENTER);

        add(p);
        add(p1);

        setVisible(true);
        setSize(400,450);
        setLocationRelativeTo(f);
    }
}