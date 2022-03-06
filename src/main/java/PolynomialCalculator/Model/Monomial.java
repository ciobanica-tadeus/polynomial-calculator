package PolynomialCalculator.Model;

public class Monomial implements Comparable<Monomial> {
    private double coef;
    private int putere;


    public Monomial(double coef, int putere) {
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

    public void setCoef(double coef) {
        this.coef = coef;
    }

    @Override
    public int compareTo(Monomial o) {
        if (this.putere == o.putere) {
            return 0;
        } else {
            if (this.putere > o.putere) {
                return 1;
            } else return -1;
        }
    }

    @Override
    public String toString() {
        String finalMonom = "";
        if (coef == 1.0 || coef == -1.0) {
            if (coef == 1.0) {
                finalMonom = finalMonom + "+";
            }
            /*if (coef == -1.0) {
                finalMonom = finalMonom + "-";
            }*/
            if (putere > 0 && putere != 1) {
                if(coef  == -1.0){
                    finalMonom = finalMonom + "-";
                }
                finalMonom = finalMonom + "x^" + putere;
            } else if (putere == 1) {
                finalMonom = finalMonom + coef + "x";
            } else {
                finalMonom = finalMonom + coef;
            }

        } else if (coef != 0.0) {
            if (coef > 0.0) {
                if (putere > 0 && putere != 1) {
                    finalMonom = finalMonom + "+" + coef + "x^" + putere;
                } else if (putere == 1) {
                    finalMonom = finalMonom + "+" + coef + "x";
                } else {
                    finalMonom = finalMonom + "+" + coef;
                }
            } else {
                if (putere > 0 && putere != 1) {
                    finalMonom = finalMonom + coef + "x^" + putere;
                } else if (putere == 1) {
                    finalMonom = finalMonom + coef + "x";
                } else {
                    finalMonom = finalMonom + coef;
                }
            }
        }
        return finalMonom;
    }
}
