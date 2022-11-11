import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import abstractions.operators.And;
import functions.Functions;
import restrictions.AuxiliarBuilders;
import restrictions.Restrictions;
import semantic.Semantics;

public class App {
    public static void main(String[] args) throws Exception {

        List<String> attributes = new ArrayList<>();
        List<List<String>> values = new ArrayList<>();
        readData(attributes, values);

        Integer patients = values.size();

        Integer m = 2;

        And f1 = Restrictions.restrictionOne(m, attributes);
        And f2 = Restrictions.restrictionTwo(m, attributes);
        And f3 = Restrictions.restrictionThree(m, attributes, values, patients);
        And f4 = Restrictions.restrictionFour(m, attributes, values, patients);
        And f5 = Restrictions.restrictionFive(m, attributes, values, patients);

        And F = Semantics.bigAnd(Arrays.asList(f1, f2, f3, f4, f5));

        HashMap<String, Boolean> interpretation = Functions.satisfabilityBruteForce(F);

        System.out.println(attributes);

        for(int i = 0; i < values.size(); i++){
            System.out.println(values.get(i));
        }

        System.out.println("\nNumber of supposed rules: " + m);

        System.out.println("\nInterpretation: --------------->");
        System.out.println(Functions.satisfabilityBruteForce(F));

        
        if(interpretation != null){

            System.out.println("\nFor " + m + " rules, it was possible to generate a set such that:");
            System.out.println(AuxiliarBuilders.rulesSet(m, attributes, interpretation));
            System.out.println("\n");

            System.out.println("In this way, applying to the Dataset above, we conclude the pathology of all " + patients + " patients in such a way that:\n");

            List<String> reports = AuxiliarBuilders.checkPatology(m, patients, attributes, values, interpretation);
            //List<String> list = new ArrayList<String>(reports);
            //Collections.sort(list);

            for (String report : reports) {
                System.out.println(report);
            }
        } else {
            System.out.println("The assumed number of rules does not generate a satisfiable formula, or...");
            System.out.println("the generated formula is not satisfiable. D;");
        }
        
    }

    public static void readData(List<String> attributes, List<List<String>> values){

        String absolutePath = new File("").getAbsolutePath();
        String relativePath = "/src/data/column_bin_3a_3p_alt.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath + relativePath))) {
            
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
