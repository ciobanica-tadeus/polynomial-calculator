import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame = new JFrame("View");
    private JLabel mainLabel = new JLabel("Polynomial Calculator");
    private JLabel firstPolynomial = new JLabel("First Polynomial");
    private JLabel secondPolynomial = new JLabel("Second Polynomial");
    private JTextField firstTextField = new JTextField();
    private JTextField secondTextField = new JTextField();
    private JPanel panel = new JPanel();

    public View (){
        mainLabel.setBounds(150,10,200,30);
        firstPolynomial.setBounds(10,50,200,30);
        secondPolynomial.setBounds(10,90,200,30);
        firstTextField.setBounds(150,50,200,30);
        secondTextField.setBounds(150,90,200,30);
        panel.add(mainLabel);
        panel.add(firstPolynomial);
        panel.add(secondPolynomial);
        panel.add(firstTextField);
        panel.add(secondTextField);
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        frame.setSize(500,400);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        View view = new View();
    }
}
