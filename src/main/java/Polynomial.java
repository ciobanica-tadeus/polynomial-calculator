import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> monomialArrayList = new ArrayList<>();
    private HashMap<Integer, Double> monomialHashMap = new HashMap<>();;

    public Polynomial() {

    }
    
    public Polynomial(String input){
        //"x^3-2x^2+4x^1-8*x^0"
        Pattern pattern = Pattern.compile("(-?\\d*)[xX]?[\\^]?(\\d+)");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            System.out.println( matcher.group());
            System.out.println("Coef : " +  matcher.group(1));
            System.out.println("Putere : " +  matcher.group(2));
            if( matcher.group().contains("x") ){
                if( matcher.group(1) == null){
                    Monomial result = new Monomial(1,Integer.parseInt(matcher.group(2)));
                    monomialArrayList.add(result);
                }else{
                    Monomial result = new Monomial(Integer.parseInt(matcher.group(1)),Integer.parseInt(matcher.group(2)));
                    monomialArrayList.add(result);
                }
            }else{
                Monomial result = new Monomial(Integer.parseInt(matcher.group()), 0);
                monomialArrayList.add(result);
            }
        }
    }

    public HashMap<Integer, Double> getMonomialHashMap() {
        return monomialHashMap;
    }

    public void add(Monomial monomial) {
        monomialArrayList.add(monomial);
    }

    public ArrayList<Monomial> getMonomialArrayList() {
        return monomialArrayList;
    }

    public void setMonomialArrayList(ArrayList<Monomial> monomialArrayList) {
        this.monomialArrayList = monomialArrayList;
    }

    //transforma hashmap ul in arraylist de monoame deja sortat in ordinea crescatoare
    public Polynomial getPolynomial() {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : monomialHashMap.entrySet()) {
            Monomial monomial = new Monomial(entry.getValue(), entry.getKey());
            result.add(monomial);
        }
        result.monomialArrayList.sort(Collections.reverseOrder());
        return result;
    }


    public static void main(String[] args) {
        //x^2+2x+4
        //-x^3-2x^2+4x-8
        Monomial f1 = new Monomial(2, 1);
        Monomial f2 = new Monomial(1, 2);
        Monomial f3 = new Monomial(0, 4);
        Polynomial polynomial1 = new Polynomial();
        polynomial1.add(f1);
        polynomial1.add(f2);
        polynomial1.add(f3);
        String input1 = "x^3-2x^2+4x^1-8";
        Polynomial polynomial = new Polynomial(input1);

        /*Monomial f7 = new Monomial(3, -1);
        Monomial f4 = new Monomial(2, -2);
        Monomial f5 = new Monomial(1, 4);
        Monomial f6 = new Monomial(0, -8);
        Polynomial polynomial2 = new Polynomial();
        polynomial2.add(f7);
        polynomial2.add(f4);
        polynomial2.add(f5);
        polynomial2.add(f6);

        Model model = new Model();
        Polynomial result = new Polynomial();
        result = model.addPolynoms(polynomial1, polynomial2);//addPolynoms(polynomial1, polynomial2);
        for (Monomial i : result.monomialArrayList){
            System.out.print(i.getCoef()+ "*x^" + i.getPutere() + "+");
        }
        System.out.println();*/

    }
}
