package PolynomialCalculator.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private ArrayList<Monomial> monomialArrayList = new ArrayList<>();
    private HashMap<Integer, Double> monomialHashMap = new HashMap<>();

    public Polynomial() {

    }

    public void add(Monomial monomial) {
        monomialArrayList.add(monomial);
    }

    public HashMap<Integer, Double> getMonomialHashMap() {
        return monomialHashMap;
    }

    public ArrayList<Monomial> getMonomialArrayList() {
        return monomialArrayList;
    }

    public void setMonomialArrayList(ArrayList<Monomial> monomialArrayList) {
        this.monomialArrayList = monomialArrayList;
    }

    public void setMonomialHashMap(HashMap<Integer, Double> monomialHashMap) {
        this.monomialHashMap = monomialHashMap;
    }

    public void printPolynom(Polynomial polynomial) {
        System.out.println("Afisare polinom!!");
        for (Monomial traverse : polynomial.getMonomialArrayList()) {
            System.out.println("Coeficient : " + traverse.getCoef() + " Putere : " + traverse.getPutere());

        }
    }

    //restrange un polinom daca acesta are 2 termeni de aceiasi putere
    public Polynomial eliminateDuplicateDegree(Polynomial polynomial) {
        HashMap<Integer, Double> monomialHashMap = new HashMap<>();
        for (Monomial t : polynomial.getMonomialArrayList()) {
            if (monomialHashMap.containsKey(t.getPutere())) {
                monomialHashMap.replace(t.getPutere(), monomialHashMap.get(t.getPutere()) + t.getCoef());
            } else {
                monomialHashMap.put(t.getPutere(), t.getCoef());
            }
        }
        polynomial.setMonomialHashMap(monomialHashMap);
        return polynomial.fromHashToArrayList();

    }

    //transforma hashmap ul in arraylist de monoame deja sortat in ordinea crescatoare
    public Polynomial fromHashToArrayList() {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : monomialHashMap.entrySet()) {
            Monomial monomial = new Monomial(entry.getValue(), entry.getKey());
            result.add(monomial);
        }
        result.monomialArrayList.sort(Collections.reverseOrder());
        return result;
    }

    //adunarea a doua polinoame
    public Polynomial addPolynoms(Polynomial first, Polynomial second) {

        for (Monomial aux : first.monomialArrayList) {
            monomialHashMap.put(aux.getPutere(), aux.getCoef());
        }
        for (Monomial aux : second.monomialArrayList) {
            if (monomialHashMap.containsKey(aux.getPutere())) {
                monomialHashMap.put(aux.getPutere(), aux.getCoef() + monomialHashMap.get(aux.getPutere()));
            } else {
                monomialHashMap.put(aux.getPutere(), aux.getCoef());
            }
        }
        return fromHashToArrayList();
    }

    //scaderea a doua polinoame
    public Polynomial substractPolynoms(Polynomial first, Polynomial second) {

        for (Monomial aux : first.monomialArrayList) {
            monomialHashMap.put(aux.getPutere(), aux.getCoef());
        }
        for (Monomial aux : second.monomialArrayList) {
            if (monomialHashMap.containsKey(aux.getPutere())) {
                monomialHashMap.put(aux.getPutere(), monomialHashMap.get(aux.getPutere()) - aux.getCoef());
            } else {
                monomialHashMap.put(aux.getPutere(), -aux.getCoef());
            }
        }
        return fromHashToArrayList();
    }

    //inmultirea a doua polinoame
    public Polynomial multiplyPolynoms(Polynomial first, Polynomial second) {

        for (int i = 0; i < first.monomialArrayList.size(); i++) {
            for (int j = 0; j < second.monomialArrayList.size(); j++) {
                int power = first.monomialArrayList.get(i).getPutere() + second.monomialArrayList.get(j).getPutere();
                if (monomialHashMap.containsKey(power)) {
                    monomialHashMap.put(power, monomialHashMap.get(power) +
                            first.monomialArrayList.get(i).getCoef() * second.monomialArrayList.get(j).getCoef());
                } else {
                    monomialHashMap.put(first.monomialArrayList.get(i).getPutere()
                                    + second.monomialArrayList.get(j).getPutere(),
                            first.monomialArrayList.get(i).getCoef() * second.monomialArrayList.get(j).getCoef());
                }

            }
        }
        return fromHashToArrayList();
    }

    //deriva primul polinom din UI
    public void derivatePolynom() {
        ArrayList<Monomial> derivate = new ArrayList<Monomial>();
        for (Monomial traversePolynom : this.monomialArrayList) {
            if (traversePolynom.getPutere() > 0) {
                derivate.add(new Monomial(traversePolynom.getCoef() * (double) traversePolynom.getPutere(), traversePolynom.getPutere() - 1));
            }
        }
        this.setMonomialArrayList(derivate);
    }

    //integreaza primul polinom din UI
    public void integratePolynom() {
        ArrayList<Monomial> integrate = new ArrayList<Monomial>();
        for (Monomial traversePolynom : this.monomialArrayList) {
            //System.out.print(traversePolynom.getCoef() / (traversePolynom.getPutere() + 1f) + "     ==>  ");
            double roundTwoPoints = (double) (Math.round(traversePolynom.getCoef() / (traversePolynom.getPutere() + 1f) * 100.0 )/ 100.0);
            //System.out.println(roundTwoPoints);
            integrate.add(new Monomial(roundTwoPoints, traversePolynom.getPutere() + 1));
        }
        this.setMonomialArrayList(integrate);
    }

}
