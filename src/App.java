import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import functions.Functions;
import restrictions.AuxiliarBuilders;
import restrictions.Restrictions;

public class App {

    public static void main(String[] args) throws Exception {
        
        List<String> attributes = new ArrayList<>();
        List<List<String>> values = new ArrayList<>();

        readData(attributes, values, args[0]);

        Integer patients = values.size();
        Integer m = Integer.parseInt(args[1]);

        List<List<Integer>> f1 = Restrictions.restrictionOne(m, attributes);
        List<List<Integer>> f2 = Restrictions.restrictionTwo(m, attributes);
        List<List<Integer>> f3 = Restrictions.restrictionThree(m, attributes, values, patients);
        List<List<Integer>> f4 = Restrictions.restrictionFour(m, attributes, values, patients);
        List<List<Integer>> f5 = Restrictions.restrictionFive(m, attributes, values, patients);

        List<List<Integer>> finalFormula = new ArrayList<>();

        finalFormula.addAll(f1);
        finalFormula.addAll(f2);
        finalFormula.addAll(f3);
        finalFormula.addAll(f4);
        finalFormula.addAll(f5);

        System.out.println(attributes);

        for(int i = 0; i < values.size(); i++){
            System.out.println(values.get(i));
        }

        System.out.println("\nNumber of supposed rules: " + m);

        System.out.println("\nInterpretation: --------------->");
        

        if(Functions.hasSolution(finalFormula)){
            System.out.println(Functions.interpretationLiterals(finalFormula));

            System.out.println("\nFor " + m + " rules, it was possible to generate a set such that:");
            System.out.println(AuxiliarBuilders.rulesSet(m, attributes, finalFormula));
            System.out.println("\n");

            System.out.println("In this way, applying to the Dataset above, we conclude the pathology of all " + patients + " patients in such a way that:\n");

            List<String> reports = AuxiliarBuilders.checkPatology(m, patients, attributes, values, finalFormula);

            for (String report : reports) {
                System.out.println(report);
            }
        } else {
            System.out.println("The assumed number of rules does not generate a satisfiable formula, or...");
            System.out.println("the generated formula is not satisfiable. D;");
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
