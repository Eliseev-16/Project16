package rgr.gui.elements;

import rgr.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodComboBox.
 */
public final class PeriodComboBox extends JComboBox {

    /** The content. */
    private final String[] content = {
            "Подневной",
            "Почасовой",
    };

    /**
     * Instantiates a new period combo box.
     */
    public PeriodComboBox(){
        addItem(content[0]);
        addItem(content[1]);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTypeOfValue();
            }
        });
    }

    /**
     * Изменение метки на форме после выбора часовой или подневной оплаты.
     */
    public void convertTypeOfValue(){
        String buffer = "",selected;
        selected = (String) getSelectedItem();
        if (selected.equals(content[0])) buffer = "Количество отработанных дней: ";
        if (selected.equals(content[1])) buffer = "Количество отработанных часов: ";
        Main.getGUI().getNameOfPeriod().setText(buffer);
    }

}

