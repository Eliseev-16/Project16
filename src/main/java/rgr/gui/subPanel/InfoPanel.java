package rgr.gui.subPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class InfoPanel.
 */
public final class InfoPanel extends JFrame {

    /**
     * Instantiates a new info panel.
     */
    public InfoPanel(){
    	super("Участники группы");
        setSize(400,300);
        setVisible(true);
        setLocationRelativeTo(null);
        JTextArea content = new JTextArea();
        JButton exitBut = new JButton("Закрыть");
        JPanel base = new JPanel();
        Font font = new Font("Times New Roman",Font.BOLD,20);
        content.setFont(font);
        content.setEditable(false);
        content.setBackground(base.getBackground());

        JPanel centerPanel = new JPanel();
        JPanel footerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        base.setLayout(new BorderLayout());

        content.append("Работу выполнили: \nЕлисеев Александр - 20131014" +
                "\nЦкриалашвили Диана - 20130483\nСаитов Эрик - 20130500\n");
        centerPanel.add(content);
        footerPanel.add(exitBut);
        base.add(centerPanel,BorderLayout.CENTER);
        base.add(footerPanel,BorderLayout.SOUTH);
        add(base);

        exitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
