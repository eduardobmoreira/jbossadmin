/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.eduardobm.jbossadmin;

import com.sun.tools.javac.Main;
import java.awt.Frame;


/**
 *
 * @author casto
 */
public class Jbossadmin {

    public static void main(String[] args) {
        Frame frame = new Frame("JBoss Admin");
        frame.setSize(700, 700);
        MainJDialog dialog = new MainJDialog(frame, false);
        dialog.show();
    }
}
