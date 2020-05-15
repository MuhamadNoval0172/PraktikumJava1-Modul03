import javax.swing.*;
import java.awt.event.ActionEvent;

public class Mahasiswa extends JFrame {
    JLabel label1 = new JLabel("NPM");
    JLabel label2 = new JLabel("Nama");
    JLabel label3 = new JLabel("Fakultas");
    JLabel label4 = new JLabel("Jenis Kelamin");
    JLabel label5 = new JLabel("Agama");
    JLabel label6 = new JLabel("Alamat");

    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();

    String[] messageStrings = {"Teknologi Informasi","Kesehatan","Kedokteran"};
    JComboBox comboBox1 = new JComboBox(messageStrings);

    //RadioButton
    JRadioButton laki = new JRadioButton("Laki-laki");
    JRadioButton perempuan = new JRadioButton("Perempuan");
    ButtonGroup groupRadio=new ButtonGroup();
    public ButtonGroup getGroupRadio() {
        groupRadio.add(laki);
        groupRadio.add(perempuan);
        return groupRadio;
    }

    String[] agama = {"Islam","Kristen","Budha","Khatolik"};
    JComboBox comboBox2 = new JComboBox(agama);

    JTextArea textArea = new JTextArea();
    JButton button1 = new JButton("Proses");
    JButton button2 = new JButton("Reset");

    Mahasiswa(){
        setSize(640,380);
        setLocationRelativeTo(null);
        setTitle("Data Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void meletakkanData(){
        getContentPane().setLayout(null);

        getContentPane().add(label1);
        getContentPane().add(label2);
        getContentPane().add(label3);
        getContentPane().add(label4);
        getContentPane().add(label5);
        getContentPane().add(label6);
        getContentPane().add(textField1);
        getContentPane().add(textField2);
        getContentPane().add(textField3);
        getContentPane().add(comboBox1);
        getContentPane().add(comboBox2);
        getContentPane().add(laki);
        getContentPane().add(perempuan);
        getContentPane().add(textArea);
        getContentPane().add(button1);
        getContentPane().add(button2);

        label1.setBounds(16,40,100,25);
        textField1.setBounds(124,40,150,25);
        label2.setBounds(16,80,100,25);
        textField2.setBounds(124,80,150,25);
        label3.setBounds(16,120,100,25);
        comboBox1.setBounds(124,120,150,25);
        label4.setBounds(16,160,100,25);
        laki.setBounds(124,160,80,25);
        perempuan.setBounds(205,160,100,25);
        label5.setBounds(16,200,100,25);
        comboBox2.setBounds(124,200,150,25);
        label6.setBounds(16,240,100,25);
        textField3.setBounds(124,240,150,25);
        button1.setBounds(124,280,80,25);
        button2.setBounds(210,280,80,25);
        textArea.setBounds(310,40,300,100);
    }
    void menambahkanLlistener(){
        button1.addActionListener(actionEvent ->{
            int jawab = JOptionPane.showOptionDialog(this, "Lanjutkan Proses?","KONFIRMASI",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            switch (jawab){
                case JOptionPane.YES_OPTION:
                    int npm = Integer.parseInt(textField1.getText());
                    String nama = textField2.getText();
                    String alamat = textField3.getText();

                    String fakultas,agama;
                    fakultas =(String)comboBox1.getSelectedItem();
                    agama = (String)comboBox2.getSelectedItem();

                    String jkelamin;
                    if (laki.isSelected()){
                        jkelamin ="Laki-laki";
                    }else{
                        jkelamin ="Perempuan";
                    }
                    textArea.setText(textArea.getText()+"NPM                 : "+npm);
                    textArea.setText(textArea.getText()+"\nNama              : "+nama);
                    textArea.setText(textArea.getText()+"\nFakultas          : "+fakultas);
                    textArea.setText(textArea.getText()+"\nJenis Kelamin: "+jkelamin);
                    textArea.setText(textArea.getText()+"\nAgama             : "+agama);
                    textArea.setText(textArea.getText()+"\nAlamat             : "+alamat);
            }
        });
        button2.addActionListener(actionEvent ->{
            int jawab = JOptionPane.showOptionDialog(this, "Apakah Anda Ingit Mereset?","Reset",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            switch (jawab){
                case JOptionPane.YES_OPTION:
                    textArea.setText("");
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField1.requestFocus(); //pointer kembali ke input npm
                    break;
            }
        });
    }
}
