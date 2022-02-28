import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        //Add listeners
        view.addAddListener(new AddListener());
    }

    public String getPolynomial1() {
        //System.out.println(view.getFirstTextField().getText());
        return view.getFirstTextField().getText();
    }

    public String getPolynomial2() {
        return view.getSecondTextField().getText();
    }

    //transforma polinomul rezultat intr un string pentru a fi folosit pentru view
    public String getString(Polynomial polynom) {
        String output = "";
        for (Monomial iterate : polynom.getMonomialArrayList()) {
            if (iterate.getCoef() != 1.0) {
                if(iterate.getCoef() > 0 && !output.equals("")){
                    output = output + "+";
                }
                if (iterate.getPutere() > 0) {
                    output = output + Double.toString(iterate.getCoef()) + "x^" + Integer.toString(iterate.getPutere());
                }
                if( iterate.getPutere() == 0){
                    output = output + Double.toString(iterate.getCoef());
                }
            } else {
                output = output + "x^" + Integer.toString(iterate.getPutere());
            }
        }
        return output;
    }

    public Polynomial doPolynomial(String input) {
        //"x^3-2x^2+4x^1-8*x^0"
        Polynomial result = new Polynomial();
        Pattern pattern = Pattern.compile("(-?\\d*)[xX]?[\\^]?(\\d+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            //System.out.println(matcher.group());
            //System.out.println("Putere : " + matcher.group(2));
            if (matcher.group().contains("x")) {
                if (matcher.group(1).equals("")) {
                    Monomial monomial = new Monomial(1, Integer.parseInt(matcher.group(2)));
                    result.add(monomial);
                    System.out.println("Coef : " + monomial.getCoef());
                    System.out.println("Putere : " + monomial.getPutere());
                } else {
                    Monomial monomial = new Monomial(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                    result.add(monomial);
                    System.out.println("Coef : " + monomial.getCoef());
                    System.out.println("Putere : " + monomial.getPutere());
                }
            } else {
                Monomial monomial = new Monomial(Integer.parseInt(matcher.group()), 0);
                System.out.println("Coef : " + monomial.getCoef());
                System.out.println("Putere : " + monomial.getPutere());
                result.add(monomial);
            }
        }
        return result;
    }

     class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstInput = getPolynomial1();
                String secondInput = getPolynomial2();
                model.setFirstPolynomial(doPolynomial(firstInput));
                model.setSecondPolynomial(doPolynomial(secondInput));
                model.setResultPolynomial(model.getSecondPolynomial().addPolynoms(model.getFirstPolynomial(), model.getSecondPolynomial()));
                String operationResult = getString(model.getResultPolynomial());
                System.out.println(operationResult);
                view.setResultTextField(operationResult);

            } catch (Exception exception) {
                System.out.println("Exception " + exception);
            }
        }
    }

}
