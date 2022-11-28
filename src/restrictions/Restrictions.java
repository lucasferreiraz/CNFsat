    package restrictions;

import java.util.ArrayList;
import java.util.List;

import abstractions.formulas.Atomic;
import abstractions.formulas.Formula;
import abstractions.operators.And;
import abstractions.operators.Implies;
import abstractions.operators.Not;
import functions.IDGenerator;
import semantic.Semantics;

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

    public static And restrictionTwo(Integer m, List<String> attributes){
        List<Formula> listOne = new ArrayList<>();
        List<Formula> listTwo = new ArrayList<>();

        for (int rule = 1; rule <= m ; rule++){
            for (String attribute : attributes){
                if(!attribute.equals("P")){
                    listOne.add(new Not(new Atomic(attribute + "_" + rule + "_" + "s")));
                }
            }
            listTwo.add(Semantics.bigOr(listOne));
            listOne.clear();
        }

        return Semantics.bigAnd(listTwo);
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

    public static And restrictionFive(Integer m, List<String> attributes, List<List<String>> values, Integer patients){
        List<Formula> listOne = new ArrayList<>();
        List<Formula> listTwo = new ArrayList<>();

        for(int j = 0; j < patients; j++){
            if(values.get(j).get(attributes.indexOf("P")).equals("1")){
                for (int rule = 1; rule <= m ; rule++){
                    listOne.add(new Atomic("C_" + rule + "_" + (j + 1)));
                }

                listTwo.add(Semantics.bigOr(listOne));
                listOne.clear();
            }
        }

        return Semantics.bigAnd(listTwo);
    }

    //Auxiliar methods
    private static Atomic atomicFactory(String attribute, int rule, String type){
        return new Atomic(attribute + "_" + rule + "_" + type);
    }

    private static Atomic atomicFactory(int rule, int patient){
        return new Atomic("C_" + rule + "_" + patient);
    }

}
