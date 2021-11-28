package com.timeline.component;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class ControlPanelDialog extends DialogWrapper {

    private ControlPanel controlPanel;

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    protected ControlPanelDialog(@Nullable Project project) {
        super(project);
        setSize(400, 300);
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        controlPanel = new ControlPanel();
        return controlPanel.getPanel();
    }

    public long computeOriginTimeBetween() {
        return getMinutesOfToady(getEndTime()) - getMinutesOfToady(getStartTime());
    }

    public long computeNowTimeBetween() {
        return getMinutesOfToady(getEndTime()) - getMinutesOfToady(new Date());
    }

    private Date getEndTime() {
        return (Date) controlPanel.spinner2.getValue();
    }

    private Date getStartTime() {
        return (Date) controlPanel.spinner1.getValue();
    }

    private long getMinutesOfToady(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (calendar.get(Calendar.HOUR_OF_DAY) * 3600) + (calendar.get(Calendar.MINUTE) * 60) + calendar.get(Calendar.SECOND);
    }


}
