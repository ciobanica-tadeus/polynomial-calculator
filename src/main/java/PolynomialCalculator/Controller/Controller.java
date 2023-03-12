package PolynomialCalculator.Controller;

import PolynomialCalculator.Model.Model;
import PolynomialCalculator.Model.Polynomial;
import PolynomialCalculator.Model.Monomial;
import PolynomialCalculator.View.View;


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
        view.addSubstractListener(new SubstractListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDerivateListener(new DerivateListener());
        view.addIntegrateListener(new IntegrateListener());
    }
    public Controller() {

    }

    public String getPolynomial1() {
        return view.getFirstTextField().getText();
    }

    public String getPolynomial2() {
        return view.getSecondTextField().getText();
    }

    public boolean checkIfZero(String result) {
        if (result.equals(""))
            return true;
        return false;
    }

    //transforma polinomul rezultat intr un string pentru a fi folosit pentru view
    public String doString(Polynomial polynom) {
        String output = "";
        for (Monomial iterate : polynom.getMonomialArrayList()) {
            output = output + iterate.toString();
        }
        if (!output.equals("") && output.charAt(0) == '+') {
            output = output.substring(1);
        }
        return output;
    }

    //returneaza coefficientul sub forma unui double pe baza string ului
    public double setCoefficient(String coefficient) {
        if (coefficient.equals("") || coefficient.equals("-") || coefficient.equals("+")) {
            if (coefficient.equals("")) {
                return 1.0f;
            } else if (coefficient.equals("-")) {
                return -1.0f;
            } else {
                return 1.0f;
            }

        } else {
            return Double.parseDouble(coefficient);
        }
    }

    //returneaza puterea sub forma unui integer pe baza string ului
    public int setDegree(String degree) {
        if (degree.contains("^")) {
            degree = degree.substring(1);
            return Integer.parseInt(degree);
        } else {
            return 1;
        }
    }

    //transforma string ul primit din UI intr un polinom format din mai multe monoame
    public Polynomial doPolynomial(String input) {

        Polynomial result = new Polynomial();
        Pattern pattern = Pattern.compile("([+-]?[^+-]+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            //System.out.println(matcher.group());
            if (matcher.group().contains("x")) {
                String[] splitString = matcher.group().split("x");
                if (splitString.length == 2) {
                    String coefficient = splitString[0];
                    String degree = splitString[1];
                    Monomial monomial = new Monomial(setCoefficient(coefficient), setDegree(degree));
                    result.add(monomial);
                }
                if (splitString.length == 1) {
                    for (String split : splitString) {
                        Monomial monomial = new Monomial(setCoefficient(split), 1);
                        result.add(monomial);
                    }
                }
                if (splitString.length == 0) {
                    Monomial monomial = new Monomial(1.0, 1);
                    result.add(monomial);
                }
            } else {
                Double coef = setCoefficient(matcher.group());
                Monomial monomial = new Monomial(setCoefficient(matcher.group()), 0);
                result.add(monomial);
            }
        }
        result = result.eliminateDuplicateDegree(result);
        return result;
    }

    public boolean checkIfIsCorrect(String input) {

        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            return true;
        }
        view.printMessageError();
        return false;
    }

    class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstInput = getPolynomial1();
                String secondInput = getPolynomial2();
                if (checkIfIsCorrect(firstInput) && checkIfIsCorrect(secondInput)) {
                    model.setFirstPolynomial(doPolynomial(firstInput));
                    model.setSecondPolynomial(doPolynomial(secondInput));
                    model.setResultPolynomial(model.getSecondPolynomial().addPolynoms(model.getFirstPolynomial(), model.getSecondPolynomial()));
                    String operationResult = doString(model.getResultPolynomial());
                    view.setResultTextField(checkIfZero(operationResult) ? "0" : operationResult);
                }
            } catch (Exception exception) {
                System.out.println("Exception " + exception);
            }
        }
    }

    class SubstractListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstInput = getPolynomial1();
                String secondInput = getPolynomial2();
                if (checkIfIsCorrect(firstInput) && checkIfIsCorrect(secondInput)) {
                    model.setFirstPolynomial(doPolynomial(firstInput));
                    model.setSecondPolynomial(doPolynomial(secondInput));
                    model.setResultPolynomial(model.getSecondPolynomial().substractPolynoms(model.getFirstPolynomial(), model.getSecondPolynomial()));
                    String operationResult = doString(model.getResultPolynomial());
                    view.setResultTextField(checkIfZero(operationResult) ? "0" : operationResult);
                }
            } catch (Exception exception) {
                System.out.println("Exception " + exception);
            }
        }
    }

    class MultiplyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstInput = getPolynomial1();
                String secondInput = getPolynomial2();
                if (checkIfIsCorrect(firstInput) && checkIfIsCorrect(secondInput)) {
                    model.setFirstPolynomial(doPolynomial(firstInput));
                    model.setSecondPolynomial(doPolynomial(secondInput));
                    model.setResultPolynomial(model.getSecondPolynomial().multiplyPolynoms(model.getFirstPolynomial(), model.getSecondPolynomial()));
                    String operationResult = doString(model.getResultPolynomial());
                    view.setResultTextField(checkIfZero(operationResult) ? "0" : operationResult);
                }

            } catch (Exception exception) {
                System.out.println("Exception " + exception);
            }
        }
    }

    class DerivateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstInput = getPolynomial1();
                if (checkIfIsCorrect(firstInput)) {
                    model.setFirstPolynomial(doPolynomial(firstInput));
                    model.getFirstPolynomial().derivatePolynom();
                    String operationResult = doString(model.getFirstPolynomial());
                    view.setResultTextField(checkIfZero(operationResult) ? "0" : operationResult);
                }
            } catch (Exception exception) {
                System.out.println("Exception " + exception);
            }
        }
    }

    class IntegrateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstInput = getPolynomial1();
                if (checkIfIsCorrect(firstInput)) {
                    model.setFirstPolynomial(doPolynomial(firstInput));
                    model.getFirstPolynomial().integratePolynom();
                    String operationResult = doString(model.getFirstPolynomial());
                    view.setResultTextField(checkIfZero(operationResult) ? "C" : (operationResult + "+C"));
                }
            } catch (Exception exception) {
                System.out.println("Exception " + exception);
            }
        }
    }
}
