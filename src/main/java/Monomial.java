public class Monomial implements Comparable<Monomial>{
    private double coef;
    private int putere;


    public Monomial (double coef, int putere ){
        this.coef = coef;
        this.putere = putere;

    }
    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public void printString(){
        // afisarea unui monom pentru a afisa un polinom
    }

    @Override
    public int compareTo(Monomial o) {
        if(this.putere == o.putere){
            return 0;
        }else{
            if(this.putere > o.putere){
                return 1;
            }
            else return -1;
        }
    }
}
