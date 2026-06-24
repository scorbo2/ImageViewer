package ca.corbett.imageviewer.ui.actions;

import ca.corbett.extras.EnhancedAction;
import ca.corbett.extras.logging.LogConsole;
import ca.corbett.imageviewer.ui.MainWindow;

import java.awt.event.ActionEvent;

/**
 * An Action to show the log console.
 *
 * @author <a href="https://github.com/scorbo2">scorbo2</a>
 */
public class LogConsoleAction extends EnhancedAction {

    private static final String NAME = "Log console";
    private static boolean positionAdjusted = false;

    public LogConsoleAction() {
        super(NAME);
        setTooltip(NAME);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // The first time LogConsole is shown, we'll position it over the MainWindow.
        // But LogConsole is a singleton hide-when-closed window, so if the user adjusts
        // its position manually after bringing it up, and then closes it, we don't want
        // to mess with it again.
        if (!positionAdjusted) {
            LogConsole.getInstance().setLocationRelativeTo(MainWindow.getInstance());
            positionAdjusted = true;
        }

        LogConsole.getInstance().setVisible(true);
    }
}
