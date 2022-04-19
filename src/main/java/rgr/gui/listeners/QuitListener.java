package rgr.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving quit events.
 * The class that is interested in processing a quit
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addQuitListener<code> method. When
 * the quit event occurs, that object's appropriate
 * method is invoked.
 *
 * @see QuitEvent
 */
public final class QuitListener implements ActionListener {

    /**
     * Action performed.
     * Обработчик кнопок для выхода из программы
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
