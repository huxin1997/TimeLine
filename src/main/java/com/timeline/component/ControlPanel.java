package com.timeline.component;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlPanel {
    private JPanel panel;
    private JButton button1;
    public JSpinner spinner1;
    public JSpinner spinner2;
    public SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    public ControlPanel() {
        panel.setSize(400, 300);
        spinner1.setModel(getSpinnerDateModel());
        spinner2.setModel(getSpinnerDateModel());
        spinner1.setEditor(getDateEditor(spinner1));
        spinner1.setBounds(34, 67, 219, 22);
        spinner2.setEditor(getDateEditor(spinner2));
        spinner2.setBounds(34, 67, 219, 22);
        spinner1.setValue(new Date());
        spinner2.setValue(new Date());

        button1.addActionListener(actionEvent -> {
            System.out.println(spinner1.getValue());
        });
    }

    @NotNull
    private JSpinner.DateEditor getDateEditor(JSpinner year) {
        JSpinner.DateEditor editor = new JSpinner.DateEditor(year,
                "HH:mm");
        return editor;
    }

    @NotNull
    private SpinnerDateModel getSpinnerDateModel() {
        SpinnerDateModel model = new SpinnerDateModel();
        return model;
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getStartTime() {
        return sdf.format(((Date) spinner1.getValue()));
    }
    public String getEndTime() {
        return sdf.format(((Date) spinner2.getValue()));
    }

    public void setStartTime(String time) {


        try {
            spinner1.setValue((sdf.parse(time)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void setEndTime(String time) {
        try {
            spinner2.setValue((sdf.parse(time)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
