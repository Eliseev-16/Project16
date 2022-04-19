package rgr.gui.elements;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class FormatLabel.
 */
public final class FormatLabel extends JLabel {

    /** The value. */
    private double value;
    
    /**
     * Instantiates a new format label object.
     *
     * @param text the text
     * @param value the value
     */
    public FormatLabel(String text, double value){
        setText(text + ":");
        setValue(value);
    }

    /**
     * Sets the value on a gui form.
     *
     * @param value the new value
     */
    public void setValue(double value){
        this.value = value;
        String text = String.format("%.2f",value);
        int separator = getText().indexOf(":");
        String subText = getText().substring(0,separator+1) + " ";
        setText(subText + text + " Р");
    }

    /**
     * Получения значения поля.
     *
     * @return the value
     */
    public double getValue(){
        return value;
    }
}
