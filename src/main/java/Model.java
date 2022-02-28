import javax.swing.text.PlainDocument;
import java.util.Collections;
import java.util.Map;

public class Model {
    private Polynomial firstPolynomial;
    private Polynomial secondPolynomial;
    private Polynomial resultPolynomial;

    public Model() {

    }

    public Polynomial getFirstPolynomial() {
        return firstPolynomial;
    }

    public void setFirstPolynomial(Polynomial firstPolynomial) {
        this.firstPolynomial = firstPolynomial;
    }

    public Polynomial getSecondPolynomial() {
        return secondPolynomial;
    }

    public void setSecondPolynomial(Polynomial secondPolynomial) {
        this.secondPolynomial = secondPolynomial;
    }

    public Polynomial getResultPolynomial() {
        return resultPolynomial;
    }

    public void setResultPolynomial(Polynomial resultPolynomial) {
        this.resultPolynomial = resultPolynomial;
    }


}
