package rgr.gui.elements;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ResidentComboBox.
 */
public final class ResidentComboBox extends JComboBox {

    /** The content on JComboBox. */
    private final String[] content = {
            "Резидент",
            "Не Резидент",
    };
    
    /**
     * Instantiates a new resident combo box.
     */
    public ResidentComboBox(){
        addItem(content[0]);
        addItem(content[1]);

    }
}
