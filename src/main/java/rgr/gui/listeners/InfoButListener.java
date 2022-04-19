package rgr.gui.listeners;

import rgr.gui.subPanel.InfoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving infoBut events.
 * The class that is interested in processing a infoBut
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addInfoButListener<code> method. When
 * the infoBut event occurs, that object's appropriate
 * method is invoked.
 *
 * @see InfoButEvent
 */
public final class InfoButListener implements ActionListener {
    
    /**
     * Отображение панели с информацией об участниках.
     * 
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new InfoPanel();
    }
}
