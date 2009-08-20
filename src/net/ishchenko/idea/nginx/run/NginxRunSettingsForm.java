/*
 * Copyright 2009 Max Ishchenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ishchenko.idea.nginx.run;

import com.intellij.openapi.ui.MultiLineLabelUI;
import com.intellij.openapi.util.IconLoader;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import net.ishchenko.idea.nginx.NginxBundle;
import net.ishchenko.idea.nginx.configurator.NginxServerDescriptor;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 29.07.2009
 * Time: 18:00:55
 */
public class NginxRunSettingsForm {

    JComboBox serverCombo;
    JTextField executableField;
    JTextField configurationField;
    JButton configureButton;
    JPanel panel;
    JTextField globalsField;
    JTextField pidField;
    JCheckBox showHttpLogCheckBox;
    JTextField httpLogPathField;
    JCheckBox showErrorLogCheckBox;
    JTextField errorLogPathField;
    private JLabel explanationLabel;

    public NginxRunSettingsForm(final NginxRunSettingsEditor.Mediator mediator) {

        mediator.form = this;

        $$$setupUI$$$();
        serverCombo.setRenderer(new NginxServerComboboxRenderer());
        serverCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediator.onChooseDescriptor((NginxServerDescriptor) serverCombo.getSelectedItem());
            }
        });

        configureButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mediator.showServerManagerDialog();
                    }
                }
        );

        showHttpLogCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediator.onHttpLogCheckboxAction();
            }
        });

        showErrorLogCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mediator.onErrorLogCheckboxAction();
            }
        });

    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        explanationLabel = new JLabel(NginxBundle.message("run.layoutExplanation"));
        explanationLabel.setUI(new MultiLineLabelUI());
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new FormLayout("fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        serverCombo = new JComboBox();
        CellConstraints cc = new CellConstraints();
        panel.add(serverCombo, cc.xy(1, 1));
        configureButton = new JButton();
        this.$$$loadButtonText$$$(configureButton, ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.configureButton"));
        panel.add(configureButton, cc.xy(3, 1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow", "center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        panel.add(panel1, cc.xyw(1, 3, 3));
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.serverinfo")));
        final JLabel label1 = new JLabel();
        this.$$$loadLabelText$$$(label1, ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.executable"));
        panel1.add(label1, cc.xy(1, 3));
        final JLabel label2 = new JLabel();
        this.$$$loadLabelText$$$(label2, ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.configuration"));
        panel1.add(label2, cc.xy(1, 5));
        executableField = new JTextField();
        executableField.setEditable(false);
        executableField.setEnabled(true);
        panel1.add(executableField, cc.xy(3, 3, CellConstraints.FILL, CellConstraints.DEFAULT));
        configurationField = new JTextField();
        configurationField.setEditable(false);
        configurationField.setEnabled(true);
        panel1.add(configurationField, cc.xy(3, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label3 = new JLabel();
        this.$$$loadLabelText$$$(label3, ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.globals"));
        panel1.add(label3, cc.xy(1, 9));
        globalsField = new JTextField();
        globalsField.setEditable(false);
        globalsField.setEnabled(true);
        panel1.add(globalsField, cc.xy(3, 9, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label4 = new JLabel();
        this.$$$loadLabelText$$$(label4, ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.pidpath"));
        panel1.add(label4, cc.xy(1, 7));
        pidField = new JTextField();
        pidField.setEditable(false);
        pidField.setEnabled(true);
        panel1.add(pidField, cc.xy(3, 7, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FormLayout("fill:d:noGrow,left:4dlu:noGrow,fill:d:grow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        panel.add(panel2, cc.xyw(1, 5, 3));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.logFiles")));
        showHttpLogCheckBox = new JCheckBox();
        this.$$$loadButtonText$$$(showHttpLogCheckBox, ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.showAccessLog"));
        panel2.add(showHttpLogCheckBox, cc.xy(1, 1));
        httpLogPathField = new JTextField();
        httpLogPathField.setEditable(true);
        httpLogPathField.setEnabled(false);
        panel2.add(httpLogPathField, cc.xy(3, 1, CellConstraints.FILL, CellConstraints.DEFAULT));
        showErrorLogCheckBox = new JCheckBox();
        this.$$$loadButtonText$$$(showErrorLogCheckBox, ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.showErrorLog"));
        panel2.add(showErrorLogCheckBox, cc.xy(1, 3));
        errorLogPathField = new JTextField();
        errorLogPathField.setEditable(true);
        errorLogPathField.setEnabled(false);
        panel2.add(errorLogPathField, cc.xy(3, 3, CellConstraints.FILL, CellConstraints.DEFAULT));
        this.$$$loadLabelText$$$(explanationLabel, ResourceBundle.getBundle("net/ishchenko/idea/nginx/NginxBundle").getString("run.layoutExplanation"));
        panel2.add(explanationLabel, cc.xyw(1, 5, 3));
    }

    /**
     * @noinspection ALL
     */
    private void $$$loadLabelText$$$(JLabel component, String text) {
        StringBuffer result = new StringBuffer();
        boolean haveMnemonic = false;
        char mnemonic = '\0';
        int mnemonicIndex = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '&') {
                i++;
                if (i == text.length()) break;
                if (!haveMnemonic && text.charAt(i) != '&') {
                    haveMnemonic = true;
                    mnemonic = text.charAt(i);
                    mnemonicIndex = result.length();
                }
            }
            result.append(text.charAt(i));
        }
        component.setText(result.toString());
        if (haveMnemonic) {
            component.setDisplayedMnemonic(mnemonic);
            component.setDisplayedMnemonicIndex(mnemonicIndex);
        }
    }

    /**
     * @noinspection ALL
     */
    private void $$$loadButtonText$$$(AbstractButton component, String text) {
        StringBuffer result = new StringBuffer();
        boolean haveMnemonic = false;
        char mnemonic = '\0';
        int mnemonicIndex = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '&') {
                i++;
                if (i == text.length()) break;
                if (!haveMnemonic && text.charAt(i) != '&') {
                    haveMnemonic = true;
                    mnemonic = text.charAt(i);
                    mnemonicIndex = result.length();
                }
            }
            result.append(text.charAt(i));
        }
        component.setText(result.toString());
        if (haveMnemonic) {
            component.setMnemonic(mnemonic);
            component.setDisplayedMnemonicIndex(mnemonicIndex);
        }
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

    private static class NginxServerComboboxRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            BasicComboBoxRenderer result = (BasicComboBoxRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                result.setIcon(IconLoader.getIcon("/net/ishchenko/idea/nginx/nginx.png"));
                result.setText(((NginxServerDescriptor) value).getName());
            }
            return result;
        }
    }
}