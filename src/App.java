import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;

import restrictions.Restrictions;

public class App {

    public static void main(String[] args) throws Exception {
        
        List<String> attributes = new ArrayList<>();
        List<List<String>> values = new ArrayList<>();

        readData(attributes, values, args[0]);

        Integer patients = values.size();
        Integer m = Integer.parseInt(args[1]);
        
        ISolver solver = SolverFactory.newDefault();
        solver.newVar(1000000);
        solver.setExpectedNumberOfClauses(500000);

        List<List<Integer>> list = Restrictions.restrictionOne(m, attributes);

        
        for(List<Integer> clause : list){
            
            int c[] = clause.stream().map(i -> (i == null ? 0 : i)).mapToInt(Integer::intValue).toArray();
            solver.addClause(new VecInt(c));
        }
        

        IProblem problem = solver;

        for(int i = 0; i < problem.findModel().length; i++){
            int a[] = problem.findModel();
            System.out.println(a[i]);
        }
            

    }

    public static void readData(List<String> attributes, List<List<String>> values, String fileName){

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
            App.class.getResourceAsStream("/data/" + fileName)))) {
            
            //points to the first line of the file
            String line = br.readLine();
            for(String s : line.split(",")){
                attributes.add(s);
            }

            //points to the second line of the file
            line = br.readLine();

            while(line != null){
                List<String> tmp = Arrays.asList(line.split(","));
                values.add(tmp);
                
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}   
