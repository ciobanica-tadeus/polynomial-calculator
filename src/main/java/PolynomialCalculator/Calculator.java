package PolynomialCalculator;

import PolynomialCalculator.Controller.Controller;
import PolynomialCalculator.Model.Model;
import PolynomialCalculator.View.View;

public class Calculator {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        view.setVisible(true);



        /*String input1 = "ce fac?";
        String input2 = "x-2";
        controller.checkIfIsCorrect(input2);
        *//*model.setFirstPolynomial(controller.doPolynomial(input1));
        model.setSecondPolynomial(controller.doPolynomial(input2));
        model.setResultPolynomial(model.getSecondPolynomial().multiplyPolynoms(model.getFirstPolynomial(), model.getSecondPolynomial()));
        model.getResultPolynomial().printPolynom(model.getResultPolynomial());*//*
        //System.out.println("Rezultatul: " + controller.doString(result));*/
//        Polynomial polynomial = controller.doPolynomial("x^3+4x^2+5");
//        polynomial.integratePolynom();
//        String result = controller.doString(polynomial);
//        System.out.println(result);
    }
}
