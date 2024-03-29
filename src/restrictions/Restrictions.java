package restrictions;

import java.util.ArrayList;
import java.util.List;

import abstractions.formulas.Atomic;
import functions.IDGenerator;

public class Restrictions {

    public static List<List<Integer>> restrictionOne(Integer m, List<String> attributes){
        List<Integer> listOne = new ArrayList<>();
        List<List<Integer>> listTwo = new ArrayList<>();

        for (int rule = 1; rule <= m ; rule++) {
            for (String attribute : attributes) {
                if(!attribute.equals("P")){
                    listOne.add(
                        IDGenerator.Generate(atomicFactory(attribute, rule, "le"))
                        );
                    listOne.add(
                        IDGenerator.Generate(atomicFactory(attribute, rule, "gt"))
                    );
                    listOne.add(
                        IDGenerator.Generate(atomicFactory(attribute, rule, "s"))
                    );
                    listTwo.add(List.copyOf(listOne));
                    listOne.clear();

                    listOne.add(
                        -IDGenerator.Generate(atomicFactory(attribute, rule, "le"))
                    );
                    listOne.add(
                        -IDGenerator.Generate(atomicFactory(attribute, rule, "gt"))
                    );
                    listTwo.add(List.copyOf(listOne));
                    listOne.clear();

                    listOne.add(
                        -IDGenerator.Generate(atomicFactory(attribute, rule, "le"))
                    );
                    listOne.add(
                        -IDGenerator.Generate(atomicFactory(attribute, rule, "s"))
                    );
                    listTwo.add(List.copyOf(listOne));
                    listOne.clear();

                    listOne.add(
                        -IDGenerator.Generate(atomicFactory(attribute, rule, "gt"))
                    );
                    listOne.add(
                        -IDGenerator.Generate(atomicFactory(attribute, rule, "s"))
                    );
                    listTwo.add(List.copyOf(listOne));
                    listOne.clear();

                }
            }
        }

        return listTwo;

    }

    public static List<List<Integer>> restrictionTwo(Integer m, List<String> attributes){
        List<Integer> listOne = new ArrayList<>();
        List<List<Integer>> listTwo = new ArrayList<>();

        for (int rule = 1; rule <= m ; rule++){
            for (String attribute : attributes){
                if(!attribute.equals("P")){
                    listOne.add(
                        -IDGenerator.Generate(atomicFactory(attribute, rule, "s"))
                    );
                }
            }
            listTwo.add(List.copyOf(listOne));
            listOne.clear();
        }

        return listTwo;
    }

    public static List<List<Integer>> restrictionThree(Integer m, List<String> attributes, List<List<String>> values, Integer patients){
        List<Integer> listOne = new ArrayList<>();
        List<List<Integer>> listTwo = new ArrayList<>();

        for (int j = 0; j < patients; j++) {

            Boolean checkValue = values.get(j).get(attributes.indexOf("P")).equals("0");

            if (checkValue){
                for (int rule = 1; rule <= m; rule++) {
                    for (String attribute : attributes) {
                        if (!attribute.equals("P")) {
                            if (values.get(j).get(attributes.indexOf(attribute)).equals("0")) {
                                listOne.add(
                                    IDGenerator.Generate(atomicFactory(attribute, rule, "le"))
                                );
                            } else {
                                listOne.add(
                                    IDGenerator.Generate(atomicFactory(attribute, rule, "gt"))
                                );
                            }
                        }
                    }
                    listTwo.add(List.copyOf(listOne));
                    listOne.clear();
                }
            }
        }

        return listTwo;
    }

    public static List<List<Integer>> restrictionFour(Integer m, List<String> attributes, List<List<String>> values, Integer patients){
        List<Integer> listOne = new ArrayList<>();
        List<List<Integer>> listTwo = new ArrayList<>();

        for(int j = 0; j < patients; j++){
            if(values.get(j).get(attributes.indexOf("P")).equals("1")){
                for (int rule = 1; rule <= m ; rule++){
                    for (String attribute : attributes){
                        if(!attribute.equals("P")){
                            if(values.get(j).get(attributes.indexOf(attribute)).equals("0")){
                                listOne.add(
                                    -IDGenerator.Generate(atomicFactory(attribute, rule, "le"))
                                );
                                listOne.add(
                                    -IDGenerator.Generate(atomicFactory(rule, j))
                                );
                            } else {
                                listOne.add(
                                    -IDGenerator.Generate(atomicFactory(attribute, rule, "gt"))
                                );
                                listOne.add(
                                    -IDGenerator.Generate(atomicFactory(rule, j))
                                );
                            }
                            listTwo.add(List.copyOf(listOne));
                        }
                        listOne.clear();
                    }
                }
            }
        }

        return listTwo;
    }

    public static List<List<Integer>> restrictionFive(Integer m, List<String> attributes, List<List<String>> values, Integer patients){
        List<Integer> listOne = new ArrayList<>();
        List<List<Integer>> listTwo = new ArrayList<>();

        for(int j = 0; j < patients; j++){
            if(values.get(j).get(attributes.indexOf("P")).equals("1")){
                for (int rule = 1; rule <= m ; rule++){
                    listOne.add(
                        IDGenerator.Generate(atomicFactory(rule, j))
                    );
                }
                listTwo.add(List.copyOf(listOne));
            }
            listOne.clear();
        }

        return listTwo;
    }

    //Auxiliar methods
    protected static Atomic atomicFactory(String attribute, int rule, String type){
        return new Atomic(attribute + "_" + rule + "_" + type);
    }

    protected static Atomic atomicFactory(int rule, int patient){
        return new Atomic("C_" + rule + "_" + (patient + 1));
    }

}
