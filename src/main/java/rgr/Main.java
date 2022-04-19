        package rgr;

        import rgr.gui.MainGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public final class Main {

    /** The gui. */
    private static MainGUI gui;

    /**
     * The main method.
     * Start program.
     * @param args the arguments
     */
    public static void main(String[] args) {
        gui = new MainGUI();
    }

    /**
     * Gets the gui.
     *
     * @return the gui
     */
    public static MainGUI getGUI(){
        return gui;
    }

}
