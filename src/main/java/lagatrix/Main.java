package lagatrix;

import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.window.LoginWindow;

public class Main {

    public static void main(String[] args) throws ConnectionException {
        new LoginWindow().setVisible(true);
    }
}
