import javax.swing.text.PlainDocument;
import java.util.Collections;
import java.util.Map;

public class Model {

    //adunarea a doua polinoame
    public Polynomial addPolynoms(Polynomial first, Polynomial second) {
        Polynomial result = new Polynomial();

        for (Monomial aux : first.getMonomialArrayList()) {
            result.getMonomialHashMap().put(aux.getPutere(), aux.getCoef());
        }
        for (Monomial aux : second.getMonomialArrayList()) {
            if(result.getMonomialHashMap().containsKey(aux.getPutere())){
                result.getMonomialHashMap().put(aux.getPutere(), aux.getCoef() + result.getMonomialHashMap().get(aux.getPutere()));
            }
            else{
                result.getMonomialHashMap().put(aux.getPutere(), aux.getCoef());
            }
        }
        return result.getPolynomial();
    }

    //scaderea a doua polinoame
    public Polynomial substractPolynoms(Polynomial first, Polynomial second) {
        Polynomial result = new Polynomial();

        for (Monomial aux : first.getMonomialArrayList()) {
            result.getMonomialHashMap().put(aux.getPutere(), aux.getCoef());
        }
        for (Monomial aux : second.getMonomialArrayList()) {
            if(result.getMonomialHashMap().containsKey(aux.getPutere())){
                result.getMonomialHashMap().put(aux.getPutere(), result.getMonomialHashMap().get(aux.getPutere()) - aux.getCoef());
            }
            else{
                result.getMonomialHashMap().put(aux.getPutere(), aux.getCoef());
            }
        }
        return result.getPolynomial();
    }
}
