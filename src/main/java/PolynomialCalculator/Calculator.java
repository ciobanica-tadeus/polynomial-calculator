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
    }
}
