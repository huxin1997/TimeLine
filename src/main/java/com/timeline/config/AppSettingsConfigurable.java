package com.timeline.config;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import com.timeline.component.ControlPanel;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AppSettingsConfigurable implements Configurable {

    private ControlPanel controlPanel;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "SDK: Application Settings Example";
    }

    @Override
    public @Nullable JComponent createComponent() {
        controlPanel = new ControlPanel();
        return controlPanel.getPanel();
    }

    @Override
    public boolean isModified() {
        AppSettingsState settings = AppSettingsState.getInstance();
        return !controlPanel.getStartTime().equals(settings.startTime) || !controlPanel.getEndTime().equals(settings.endTime);

    }

    @Override
    public void apply() throws ConfigurationException {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.startTime = controlPanel.getStartTime();
        settings.endTime = controlPanel.getEndTime();
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        controlPanel.setStartTime(settings.startTime);
        controlPanel.setEndTime(settings.endTime);
    }
}
