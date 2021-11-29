package com.timeline.component;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.psi.PsiElement;
import com.intellij.ui.JBColor;
import com.intellij.ui.awt.RelativePoint;
import com.intellij.ui.popup.BalloonPopupBuilderImpl;
import groovy.util.logging.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * @author huxin
 */
@Slf4j
public class Dialog extends AnAction {


    @Override
    public void actionPerformed(AnActionEvent e) {


        // TODO: insert action logic here
        PsiElement element = e.getData(CommonDataKeys.PSI_ELEMENT);
        Editor editor = e.getData(CommonDataKeys.EDITOR);


        JComponent component = editor.getComponent();
//        JComponent contentComponent = editor.getContentComponent();
//        JComponent headerComponent = editor.getHeaderComponent();

        ControlPanelDialog controlPanelDialog = new ControlPanelDialog(e.getProject());
        boolean b = controlPanelDialog.showAndGet();
        Messages.showMessageDialog("" + element, "Information", Messages.getInformationIcon());


        new Timer(500, actionEvent -> {
            new BalloonPopupBuilderImpl(Map.of(), new JButton("1")).createBalloon().show(RelativePoint.fromScreen(component.getLocationOnScreen()), Balloon.Position.atRight);
        });

        JPanel jPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                BasicStroke bs = new BasicStroke(10.1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

                super.paint(g);
                Graphics2D gp2d = (Graphics2D) g;
                gp2d.setColor(JBColor.BLUE);
                gp2d.setPaint(new GradientPaint(0, 0, JBColor.BLUE, 200, 400, JBColor.RED));

                long originTimeBetween = controlPanelDialog.computeOriginTimeBetween();
                long nowTimeBetween = controlPanelDialog.computeNowTimeBetween();
                float rate = 1 - (1F * nowTimeBetween / originTimeBetween);
                int y = (int) (component.getHeight() * rate);
                gp2d.fillRect(0, 0, 10, 1000);
                System.out.println("rate:" + rate + " y:" + y);
            }
        };


        jPanel.setPreferredSize(new Dimension(10, 800));
//        component.getParent().add(jPanel, BorderLayout.LINE_END);
//        WindowManagerEx.getInstanceEx().getFrame(e.getProject()).getRootPane().getContentPane().add(jPanel,BorderLayout.LINE_END)
    }


}
