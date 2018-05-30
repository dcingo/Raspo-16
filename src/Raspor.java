import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Raspor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JTextField RSPTextField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton Button1;
    private JTextField textField8;
    private JTextField textField9;
    private JButton Button2;
    private JButton setupLogButton;
    private JTextField dMLogTextField;
    private JList list1;
    private JButton setupRSPButton;
    private JList list2;
    private JTabbedPane tabbedPane2;
    private SearchLog searchLog;

    public Raspor() {
        searchLog = new SearchLog();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            //Кнопка
                readlog();
            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                readRSP();
            }
        });
        readlog();
        setupLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                searchLog.setFileLog(dMLogTextField.getText());
                System.out.println("Новый Лог файл"+dMLogTextField.getText());
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if(list1.getSelectedIndex()>=0){
                    RSPTextField.setText(list1.getSelectedValue().toString());
                    readRSP();
                }
            }
        });
        setupRSPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(list1.getSelectedIndex()>=0){
                    RSPTextField.setText(list1.getSelectedValue().toString());
                    readRSP();
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    private void readRSP(){
        RSP rsp = new RSP();
        String str = RSPTextField.getText();
        ClassDT[][] interval = rsp.AnalizRSP(str);
        if(interval[0][0]!=null)textField1.setText(interval[0][0].toString1metod()+" - "+interval[0][1].toString1metod());
        if(interval[1][0]!=null)textField2.setText(interval[1][0].toString234metod()+" - "+interval[1][1].toString234metod());
        if(interval[2][0]!=null)textField3.setText(interval[2][0].toString234metod()+" - "+interval[2][1].toString234metod());
        if(interval[3][0]!=null)textField4.setText(interval[3][0].toString234metod()+" - "+interval[3][1].toString234metod());
        if(interval[4][0]!=null)textField5.setText(interval[4][0].toString234metod()+" - "+interval[4][1].toString234metod());
        if(interval[5][0]!=null)textField6.setText(interval[5][0].toString234metod()+" - "+interval[5][1].toString234metod());
        if(interval[6][0]!=null)textField7.setText(interval[6][0].toString234metod()+" - "+interval[6][1].toString234metod());
        textField8.setText(Double.toString(rsp.getLengthPN()));

        list2.setListData(searchLog.getDOI('2'));
    }
    private void readlog(){
        try
        {
            FileReader fr = new FileReader(searchLog.getFileLog());
            String str="";
            Vector<String> list =  new Vector<String>();
            BufferedReader br = new BufferedReader(fr);
            while(br.ready())
            {
                str = br.readLine();
                if(str.lastIndexOf("222222</telegram>")>0){
                    str = str.substring(str.lastIndexOf("<telegram>")+10,str.lastIndexOf("</telegram>"));
                    list.add(str);
                }
            }
            list1.setListData(list);

            RSPTextField.setText(list.lastElement());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) {
        Raspor dialog = new Raspor();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
