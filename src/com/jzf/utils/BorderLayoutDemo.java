package com.jzf.utils;

import javax.swing.*;
import java.awt.*;
public class BorderLayoutDemo
{
    public static void main(String[] agrs)
    {
        JFrame frame=new JFrame("Java第三个GUI程序");    //创建Frame窗口
        frame.setSize(700,700);
        frame.setPreferredSize(new Dimension(700 ,700));
        frame.setLayout(new BorderLayout());    //为Frame窗口设置布局为BorderLayout
        JButton button1=new JButton ("上");
        JButton button2=new JButton("左");
        JButton button3=new JButton("中");
        JButton button4=new JButton("右");
        JButton button5=new JButton("下");

        JPanel jp1,jp2;
        JPanel jp3,jp4;
        JButton jb1,jb2,jb3,jb4,jb5,jb6;

        jp1=new JPanel();
        jp2=new JPanel();
        jb1=new JButton("西瓜");
        jb2=new JButton("苹果");
        jb3=new JButton("荔枝");
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);

        jp1.setLayout(new BorderLayout());
        jp3=new JPanel();
        jp3.setPreferredSize(new Dimension(200 ,700));
        jp3.setLayout(new FlowLayout());
        jp4=new JPanel();

        JLabel jl1=new JLabel("西瓜1");
        jl1.setPreferredSize(new Dimension(200 ,20));
        JLabel jl2=new JLabel("苹果1");
        jl2.setPreferredSize(new Dimension(200 ,20));
        System.out.println(frame.getSize());
        JLabel jl3=new JLabel("西瓜2");
        jl3.setPreferredSize(new Dimension(200 ,20));
        jl3.setBackground(Color.red);
        jl3.setOpaque(true);
        jp3.add(jl1);
        jp3.add(jl3);

        jp4.add(jl2);

        jp1.add(jp3,BorderLayout.WEST);
        jp1.add(jp4,BorderLayout.EAST);



        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.WEST);
        frame.add(jp1,BorderLayout.CENTER);
        frame.add(jp2,BorderLayout.SOUTH);
        frame.setBounds(300,200,700,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

