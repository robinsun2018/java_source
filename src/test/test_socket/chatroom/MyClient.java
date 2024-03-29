package test.test_socket.chatroom;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient extends JFrame{

    private PrintWriter writer;
    Socket socket;
    private JTextArea ta=new JTextArea();
    private JTextField tf=new JTextField();
    Container cc;

    public MyClient(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc=this.getContentPane();

        final JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");

        tf.addFocusListener(new JTextFieldListener(tf,"请在此输入内容"));
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MyClient.this, "请输入内容！");
                }else {
                    writer.println(tf.getText());

                    ta.append(tf.getText()+"\n");
                    ta.setSelectionEnd(ta.getText().length());
                    tf.setText("");
                }


            }
        });
    }

    //焦点监听器
    class JTextFieldListener implements FocusListener{

        private String hintText;          //提示文字
        private JTextField textField;

        public JTextFieldListener(JTextField textField,String hintText) {
            this.textField=textField;
            this.hintText=hintText;
            textField.setText(hintText);   //默认直接显示
            textField.setForeground(Color.GRAY);
        }

        @Override
        public void focusGained(FocusEvent e) {

            //获取焦点时，清空提示内容
            String temp=textField.getText();
            if(temp.equals(hintText)){
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }

        }

        @Override
        public void focusLost(FocusEvent e) {

            //失去焦点时，没有输入内容，显示提示内容
            String temp=textField.getText();
            if(temp.equals("")) {
                textField.setForeground(Color.GRAY);
                textField.setText(hintText);
            }

        }

    }

    private void connect() {
        ta.append("尝试连接\n");
        try {
            //socket=new Socket("gyh.ngrok.xiaomiqiu.cn",8080);
            socket=new Socket("47.96.65.224",8080);
            writer=new PrintWriter(socket.getOutputStream(),true);

            ta.append("完成连接\n");

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //EventQueue事件队列，封装了异步事件指派机制
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                MyClient client=new MyClient("向服务器发送数据2");
                client.setSize(400,400);
                client.setVisible(true);
                client.connect();


            }
        });

    }

}
