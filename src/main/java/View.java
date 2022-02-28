import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame = new JFrame("View");
    private JLabel mainLabel = new JLabel("Calculator Polinomial");
    private JLabel firstPolynom = new JLabel("Primul polinom  = ");
    private JLabel secondPolynom = new JLabel("Al doilea polinom  = ");
    private JTextField firstTextField = new JTextField();
    private JTextField secondTextField = new JTextField();
    private JButton addBtn = new JButton("Adunare (+)");
    private JButton substractBtn = new JButton("Scadere (-)");
    private JButton multiplyBtn = new JButton("Inmultire (x)");
    private JButton divideBtn = new JButton("Impartire(/)");
    private JButton derivateBtn = new JButton("Derivare ");
    private JButton integrateBtn = new JButton("Integrare ");
    private JLabel resultPolynom = new JLabel("Rezultatul   = ");
    private JTextField resultTextField = new JTextField();
    private JPanel contentPane = new JPanel();

    public View (){
        mainLabel.setBounds(160,8,200,30);
        firstPolynom.setBounds(10,50,200,30);
        secondPolynom.setBounds(10,90,200,30);
        firstTextField.setBounds(150,50,200,30);
        secondTextField.setBounds(150,90,200,30);
        resultPolynom.setBounds(10,130,200,30);
        resultTextField.setBounds(150,130,200,30);
        addBtn.setBounds(20,180,150,30);
        substractBtn.setBounds(180,180,150,30);
        multiplyBtn.setBounds(20,220,150,30);
        divideBtn.setBounds(180,220,150,30);
        derivateBtn.setBounds(20,260,150,30);
        integrateBtn.setBounds(180,260,150,30);

        contentPane.add(mainLabel);
        contentPane.add(firstPolynom);
        contentPane.add(secondPolynom);
        contentPane.add(firstTextField);
        contentPane.add(secondTextField);
        contentPane.add(addBtn);
        contentPane.add(substractBtn);
        contentPane.add(multiplyBtn);
        contentPane.add(divideBtn);
        contentPane.add(derivateBtn);
        contentPane.add(integrateBtn);
        contentPane.add(resultPolynom);
        contentPane.add(resultTextField);
        contentPane.setBackground(Color.CYAN);
        contentPane.setLayout(null);
        frame.setSize(400,380);
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public String getPolynomial1(){
        return firstTextField.getText();
    }

    public String getPolynomial2(){
        return secondTextField.getText();
    }

    public void addAddListener (ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        View view = new View();
    }
}
