package com.devendortech.intellij.plugin.decompile;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.*;

public class FolderSelectionForm extends DialogWrapper {

    private static final String title = "Select Folder";

    private static final String description = "Select Project Specific Folder For Storing Decompiled Sources";

    private JPanel contentPane;

    private JLabel descriptionLabel;

    private LabeledComponent<TextFieldWithBrowseButton> workingDirComponent;

    public FolderSelectionForm(Project project) {
        super(project);
        init();
        setTitle(title);
        setOKActionEnabled(false);
        descriptionLabel.setText(description);
        workingDirComponent.setComponent(new TextFieldWithBrowseButton(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!workingDirComponent.getComponent().getText().isEmpty()) {
                    setOKActionEnabled(true);
                }
            }
        }));
        workingDirComponent.getComponent().addBrowseFolderListener(
                "Test Title", "", project,
                new FileChooserDescriptor(false, true, false, false, false, false));  /* {
                    /*@Override
                    public boolean isFileSelectable(VirtualFile file) {
                        if (!super.isFileSelectable(file)) return false;
                        return true;
                    }
                } );*/
        workingDirComponent.getComponent().setEditable(false);
        workingDirComponent.getComponent().setTextFieldPreferredWidth(50);
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return contentPane;
    }

    public String getSelectedPath() {
        return workingDirComponent.getComponent().getText();
    }
}
