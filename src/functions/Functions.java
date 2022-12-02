package functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

import abstractions.formulas.Atomic;

public class Functions {

    public static int[] interpretation(List<List<Integer>> formula){
        ISolver solver = SolverFactory.newDefault();
        solver.newVar(1000000);
        solver.setExpectedNumberOfClauses(500000);

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
            int atoms[] = problem.findModel();
            return atoms;
        } catch (TimeoutException e) {
            e.printStackTrace();
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

    public static boolean hasSolution(List<List<Integer>> formula) throws TimeoutException{
        ISolver solver = SolverFactory.newDefault();
        solver.newVar(1000000);
        solver.setExpectedNumberOfClauses(500000);

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

        return problem.isSatisfiable();
    }

    public static int[] copy(int array[]){
        int vector[] = Arrays.copyOf(array, array.length);
        return vector;
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
