package functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

import abstractions.formulas.Atomic;
import abstractions.formulas.Formula;
import abstractions.operators.And;
import abstractions.operators.Implies;
import abstractions.operators.Not;
import abstractions.operators.Or;

public class Functions {

    private static Set<String> setAtoms = new HashSet<String>();

    private static HashMap<String, Boolean> result = new HashMap<>();

    //returns a list of atoms from a formula
    public static List<String> atoms(Formula formula) {
        if (formula instanceof Atomic) {
            setAtoms.add(formula.toString());
        }
        if (formula instanceof Not) {
            Not negation = (Not) formula;
            atoms(negation.getInner());
        }
        if (formula instanceof Or){
            Or or = (Or) formula;
            atoms(or.getLeft());
            atoms(or.getRight());
        }
        if (formula instanceof And){
            And and = (And) formula;
            atoms(and.getLeft());
            atoms(and.getRight());
        }
        if (formula instanceof Implies){
            Implies implies = (Implies) formula;
            atoms(implies.getLeft());
            atoms(implies.getRight());
        }

        List<String> listAtoms = setAtoms.stream()
                                         .collect(Collectors.toList());

        return listAtoms;
    }

    public static Boolean truthValue(Formula formula, HashMap<String, Boolean> interpretation){

        if (formula instanceof Atomic){
            return interpretation.get(formula.toString());
        }
        if (formula instanceof Not){
            Not not = (Not) formula;
            Boolean result = truthValue(not.getInner(), interpretation);
            return !result;
        }
        if (formula instanceof Implies){
            Implies implies = (Implies) formula;
            Boolean left = truthValue(implies.getLeft(), interpretation);
            Boolean right = truthValue(implies.getRight(), interpretation);

            return ((left && !right) ? false : true);
        }
        if (formula instanceof Or){
            Or or = (Or) formula;
            Boolean left = truthValue(or.getLeft(), interpretation);
            Boolean right = truthValue(or.getRight(), interpretation);

            return ((left || right) ? true : false);
        }
        if (formula instanceof And){
            And and = (And) formula;
            Boolean left = truthValue(and.getLeft(), interpretation);
            Boolean right = truthValue(and.getRight(), interpretation);

            return ((left && right) ? true : false);
        }

        return null;
    }

    public static List<Atomic> interpretationLiterals(List<List<Integer>> formula){
        ISolver solver = SolverFactory.newDefault();
        solver.newVar(1000000);
        solver.setExpectedNumberOfClauses(500000);

        List<Atomic> literals = new ArrayList<>();

        for(List<Integer> clause : formula){
            
            int c[] = new int[toPrimitiveInt(clause).length];
            c = toPrimitiveInt(clause);

            try {
                solver.addClause(new VecInt(c));
                c = new int[0];
            } catch (ContradictionException e) {
                e.printStackTrace();
            }
        }
        
        IProblem problem = solver;

        try {
            int size = problem.findModel().length;
            int atoms[] = problem.findModel();

            for(int i = 0; i < size; i++){
                if(atoms[i] > 0){
                    literals.add(
                        (Atomic) IDGenerator.getLiteral(atoms[i])
                    );
                } else {
                    literals.add(
                        new Atomic("\u00AC(" + (Atomic) IDGenerator.getLiteral(atoms[i]) + ")")
                    );
                }
                
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return literals;

    }

    public static HashMap<String, Boolean> satisfabilityBruteForce(Formula formula){

        Stack<String> stackAtoms = stackAtoms(atoms(formula));
        HashMap<String, Boolean> initialInterpretation = new HashMap<>();

        return satisfability(formula, stackAtoms, initialInterpretation);

    }

    private static HashMap<String, Boolean> satisfability(Formula formula, Stack<String> listAtoms, HashMap<String, Boolean> interpretation){

        HashMap<String, Boolean> interpretationOne;
        HashMap<String, Boolean> interpretationTwo;

        if (listAtoms.isEmpty()){
            if (truthValue(formula, interpretation)){
                return interpretation;
            } else {
                return null;
            }
        }
        
        String atomic = listAtoms.pop();

        interpretationOne = copy(interpretation);
        interpretationOne.put(atomic, true);

        interpretationTwo = copy(interpretation);
        interpretationTwo.put(atomic, false);

        result = satisfability(formula, copy(listAtoms), interpretationOne);

        
        if (result != null){
            return result;
        } else {

            return satisfability(formula, copy(listAtoms), interpretationTwo); 
        }

    }

    //utilitary methods
    //convert a list of atomics to a stack of atomics
    private static Stack<String> stackAtoms(List<String> listAtoms){
        Stack<String> stack = new Stack<String>();

        for(String atomic : listAtoms){
            stack.push(atomic);
        }

        return stack;
    }

    //creates and returns a copy of an interpretation
    public static HashMap<String, Boolean> copy(HashMap<String, Boolean> original){

        HashMap<String, Boolean> secondMap = new HashMap<>();

        for(Map.Entry<String, Boolean> entry : original.entrySet()){
            secondMap.put(entry.getKey(), entry.getValue());
        }

        return secondMap;
    }

    //creates and returns a copy of an stack
    private static Stack<String> copy(Stack<String> original){
        Stack<String> secondStack = new Stack<>();

        Iterator<String> intItr = original.iterator();
        while(intItr.hasNext())  {
            secondStack.push(intItr.next());
        }

        return secondStack;
    }

    public static int[] toPrimitiveInt(List<Integer> list){

        List<Integer> vector = List.copyOf(list);

        int array[] = new int[vector.size()];

        array = vector.stream()
                            .map(i -> (i == null ? 0 : i))
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        return array;
    }

}
