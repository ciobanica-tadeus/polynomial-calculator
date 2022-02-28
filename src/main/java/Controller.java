import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller (Model model, View view){
        this.model = model;
        this.view = view;

        //Add listeners
        view.addAddListener(new AddListener());
    }

    class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstPolynomial = view.getPolynomial1();
                String secondPolynomial = view.getPolynomial2();



            }catch(Exception exception){

            }
        }
    }
}
