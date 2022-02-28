public class Calculator {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        view.setVisible(true);

        /*String input1 = "x^3-2x^2+4x^1-8";
        Polynomial polynomial = controller.doPolynomial(input1);
        System.out.println(controller.getString(polynomial));*/

    }
}
