import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation {

    public static void operate(int key){
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        

        try{
            FileInputStream fis = new FileInputStream(jfc.getSelectedFile());

            byte[] data = new byte[fis.available()];
            fis.read(data);

            int i=0;
            for(byte b:data){
            System.out.println(b);
            data[i] = (byte)(b^key);
            i++;
            }    

            FileOutputStream fos = new FileOutputStream(jfc.getSelectedFile());
            fos.write(data);

            fos.close();
            fis.close();

            JOptionPane.showMessageDialog(null,"Done");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello");

        JFrame f = new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto",Font.BOLD,25);

        JButton button = new JButton();
        button.setText("Open Image");;
        button.setFont(font);
        

        JTextField tf = new JTextField(10);
        tf.setFont(font);

        button.addActionListener(e->{
            System.out.println("Gresh");
            int tmp = Integer.parseInt(tf.getText());
            operate(tmp);
       });

        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(tf);

        f.setVisible(true);
    }
}