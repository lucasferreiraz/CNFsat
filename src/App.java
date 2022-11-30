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
        List<List<Integer>> f3 = Restrictions.restrictionThree(m, attributes, values, patients);
        List<List<Integer>> f4 = Restrictions.restrictionFour(m, attributes, values, patients);
        List<List<Integer>> f5 = Restrictions.restrictionFive(m, attributes, values, patients);

        List<List<Integer>> finalFormula = new ArrayList<>();

        finalFormula.addAll(f1);
        finalFormula.addAll(f3);
        finalFormula.addAll(f4);
        finalFormula.addAll(f5);

        System.out.println(Functions.interpretationLiterals(finalFormula));

        System.out.println(AuxiliarBuilders.rulesSet(m, attributes, finalFormula));

        List<String> reports = AuxiliarBuilders.checkPatology(m, patients, attributes, values, finalFormula);

        for (String report : reports) {
            System.out.println(report);
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
