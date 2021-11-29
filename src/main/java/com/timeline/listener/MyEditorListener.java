package com.timeline.listener;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class MyEditorListener implements FileEditorManagerListener {
// WindowManagerEx.getInstanceEx().getFrame(e.getProject()).getRootPane().getContentPane().add(new JButton("666"),BorderLayout.LINE_END);
    @Override
    public void fileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
        FileEditor[] allEditors = source.getAllEditors();
        System.out.println("source = " + source + ", file = " + file);
    }
}
