package com.jzf.utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class TimeThreadFrame extends JFrame{
    // 定义组件
    private JLabel lblTime;
    private JTextField txtInput;
    private JButton btnEnter;
    // 构造方法
    public TimeThreadFrame(){
// 设置窗体的相关属性
        super("TimerThread");
        this.setSize(300,200);
        this.setLayout(null);
        this.setLocation(100,50);
// 创建组件
        this.lblTime = new JLabel("请输入倒计时时间");
        this.lblTime.setBounds(30,20,200,30);
        this.txtInput = new JTextField();
        this.txtInput.setBounds(30,70,100,30);
        this.btnEnter = new JButton("确定");
        this.btnEnter.setBounds(150,70,70,30);
// 给JTextField注册监听
        this.txtInput.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent ke) {
            }
            public void keyReleased(KeyEvent ke) {
            }
            public void keyTyped(KeyEvent ke) {
                txtInput_KeyTyped(ke);
            }
        });
// 给JButton注册监听
        this.btnEnter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                btnEnter_ActionPerformed(ae);
            }
        });
// 将各组件添加到窗体上
        add(lblTime);
        add(txtInput);
        add(btnEnter);
// 显示窗体
        this.setVisible(true);
    }
    // 输入时的事件处理，控制用户只能输入数字
    public void txtInput_KeyTyped(KeyEvent ke){
        if(ke.getKeyChar() < '0' || ke.getKeyChar() > '9'){
            ke.setKeyChar('\0');
        }
    }
    // 点击按钮时的事件处理，核心！
    public void btnEnter_ActionPerformed(ActionEvent ae){
// 获得用户输入的倒计时时间
        String strTime = this.txtInput.getText();
        if(strTime.equals("")){
// 检测用户是否输入
            this.lblTime.setText("您尚未输入，请输入！");
        }
        else{
            Integer time = Integer.parseInt(strTime);
// 创建线程
            TimeThread tt = new TimeThread(this.lblTime,time);
            tt.start();
// 创建Timer
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                // 启动其他程序
                public void run() {
                    System.out.print("ok");
                }
            }, time * 1000);

        }
    }
    // 启动窗体
    public static void main(String[] args){
        new TimeThreadFrame();
    }
}

// 时间线程类
class TimeThread extends Thread{
    private JLabel lblTime;
    private static int time;
    // 构造方法传入，显示事件的JLabel和倒计时的时间。
    public TimeThread(JLabel lblTime, int time){
        this.lblTime = lblTime;
        this.time = time;
    }
    // run方法
    public void run(){
        while(time > 0){
// 显示所剩时间
            this.lblTime.setText("所剩时间：" + time);
// 所剩时间减少
            time--;
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
} 