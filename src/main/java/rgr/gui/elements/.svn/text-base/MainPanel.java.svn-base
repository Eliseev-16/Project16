package rgr.gui.elements;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MainPanel.
 */
public final class MainPanel extends JPanel {

    /** The content. */
    private Box content = Box.createVerticalBox();

    /**
     * Instantiates a new main panel.
     */
    public MainPanel(){
        setLayout(new BorderLayout());
        //setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    /**
     * Adds the one element on panel.
     *
     * @param component the component
     */
    public void addOneElement(Component component){
        JPanel line = new JPanel();
        line.setLayout(new FlowLayout(FlowLayout.LEFT));
        line.add(component);
        content.add(line);
        updateContent();
    }

    /**
     * Adds the several element on panel.
     *
     * @param components the components
     * @param separator the separator
     */
    public void addSeveralElement(Component [] components,String separator){
        JPanel line = new JPanel();
        line.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i<components.length;i++) {
            line.add(components[i]);
            if (i<components.length-1) line.add(new JLabel(separator));}
        content.add(line);
        updateContent();
    }

    /**
     * Update content.
     */
    private void updateContent(){
        removeAll();
        add(content);
    }

}
