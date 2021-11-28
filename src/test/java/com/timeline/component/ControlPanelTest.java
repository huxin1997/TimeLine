package com.timeline.component;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

class ControlPanelTest {

    @Test
    void name() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setContentPane(new ControlPanel().getPanel());
        jFrame.show(true);
    }

    public static void main(String[] args) throws ParseException {
//        JFrame jFrame = new JFrame();
//        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        JPanel panel1 = new ControlPanel().getPanel1();
//
//        jFrame.setContentPane(panel1);
//        jFrame.show(true);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        System.out.println((calendar.get(Calendar.HOUR_OF_DAY) * 60) + (calendar.get(Calendar.MINUTE)));

    }
}
