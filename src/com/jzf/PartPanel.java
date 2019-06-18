package com.jzf;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;


public class PartPanel extends JPanel {


    private static final long serialVersionUID = 1L;




    public PartPanel() {
        super();
        setOpaque(true);
        setSize(100,100);

        setPreferredSize(new Dimension(100,100));
        setBackground(new Color(36, 179, 193));
        JLabel nameLabel = new JLabel("圆角面板", JLabel.CENTER);
        nameLabel.setForeground(Color.white);
        nameLabel.setBounds(0, 0, 100, 100);
        nameLabel.setAlignmentY(0.1f);
        add(nameLabel);
    }

    @Override
    public void paint(Graphics g) {
        int fieldX = 0;
        int fieldY = 0;
        int fieldWeight = getSize().width;
        int fieldHeight = getSize().height;
        RoundRectangle2D rect = new RoundRectangle2D.Double(fieldX, fieldY, fieldWeight, fieldHeight,  100, 100);
        g.setClip(rect);
        super.paint(g);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("圆角面板");
        frame.setLayout(null);
        frame.setBounds(500, 300, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PartPanel panel = new PartPanel();
        panel.setLocation(100, 100);
        frame.add(panel);
        frame.setVisible(true);
    }
}
