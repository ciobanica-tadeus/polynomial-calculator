package PolynomialCalculator.Model;
import PolynomialCalculator.Controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void addPolynoms() {
        PolynomialTest polynomialTest = new PolynomialTest();
        Controller controller = new Controller();
        Polynomial polynomial = new Polynomial();
        assertEquals("4.0x^5-x^3+2.0x^2-6.0x", controller.doString(polynomial.addPolynoms(controller.doPolynomial("4x^5-3x^4+x^2-8x+1"),
                controller.doPolynomial("3x^4-x^3+x^2+2x-1"))));

    }

    @Test
    void substractPolynoms() {
        PolynomialTest polynomialTest = new PolynomialTest();
        Controller controller = new Controller();
        Polynomial polynomial = new Polynomial();
        assertEquals("4.0x^5-6.0x^4+x^3-10.0x+2.0",controller.doString(polynomial.substractPolynoms(controller.doPolynomial("4x^5-3x^4+x^2-8x+1"),
                        controller.doPolynomial("3x^4-x^3+x^2+2x-1"))));
    }

    @Test
    void multiplyPolynoms() {
        PolynomialTest polynomialTest = new PolynomialTest();
        Controller controller = new Controller();
        Polynomial polynomial = new Polynomial();
        assertEquals("12.0x^9-13.0x^8+7.0x^7+8.0x^6-35.0x^5+15.0x^4-7.0x^3-16.0x^2+10.0x-1.0",
                controller.doString(polynomial.multiplyPolynoms(controller.doPolynomial("4x^5-3x^4+x^2-8x+1"),
                        controller.doPolynomial("3x^4-x^3+x^2+2x-1"))));
    }

    @Test
    void derivatePolynom() {
        PolynomialTest polynomialTest = new PolynomialTest();
        Controller controller = new Controller();
        Polynomial polynomial = controller.doPolynomial("4x^5-3x^4+x^2-8x+1");
        polynomial.derivatePolynom();
        assertEquals("20.0x^4-12.0x^3+2.0x-8.0", controller.doString(polynomial));
    }

    @Test
    void integratePolynom() {
        PolynomialTest polynomialTest = new PolynomialTest();
        Controller controller = new Controller();
        Polynomial polynomial = controller.doPolynomial("x^3+4x^2+5");
        polynomial.integratePolynom();
        assertEquals("0.25x^4+1.33x^3+5.0x",controller.doString(polynomial));
    }
}