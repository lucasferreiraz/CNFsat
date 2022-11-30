package functions;

import java.util.HashMap;
import java.util.Map.Entry;

import abstractions.formulas.Formula;

public class IDGenerator {

    private static Integer ID = 0;

    private static HashMap<Formula, Integer> literals = new HashMap<>();
    
    public IDGenerator(Formula formula) { 
        literals.put(formula, Generate(formula));
    }
    
    private static Boolean hasFormula(Formula formula){
        return literals.containsKey(formula) ? true : false;
    }
    
    public static Integer Generate(Formula formula){
        if(!hasFormula(formula)){

            ID++;
            literals.put(formula, ID);

            return literals.get(formula);

        }

        return literals.get(formula);
    }

    public Integer getID() {
        return ID;
    }

    public static HashMap<Formula, Integer> getLiterals() {
        return literals;
    }

    public static Formula getLiteral(int value){

        for(Entry<Formula, Integer> entry: literals.entrySet()) {
            if(entry.getValue().equals(Math.abs(value))) {
              return entry.getKey();
            }
        }

        return null;
    }


}
