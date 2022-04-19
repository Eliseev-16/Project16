package rgr.gui.elements;

import rgr.gui.listeners.InfoButListener;
import rgr.gui.listeners.QuitListener;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class TrayMenu.
 */
public final class TrayMenu extends JMenuBar {

    /**
     * Instantiates a new tray menu.
     */
    public TrayMenu(){
        JMenu menu = new JMenu("Меню");

        JMenuItem info = new JMenuItem("Информация");
        JMenuItem quit = new JMenuItem("Выход");
        menu.add(info);
        menu.add(quit);
        this.add(menu);
        quit.addActionListener(new QuitListener());
        info.addActionListener(new InfoButListener());
    }
}
