package GUI.State;

import GUI.AdminWindow;
import java.awt.GridBagConstraints;

public interface FormState {
    void setupForm(AdminWindow adminWindow, GridBagConstraints gbc);
    void register(AdminWindow adminWindow);
}
