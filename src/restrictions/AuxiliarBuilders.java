package restrictions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import functions.Functions;

public class AuxiliarBuilders {
    
    public static List<String> rulesSet(Integer m, List<String> attributes, HashMap<String, Boolean> interpretation){
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();

        HashMap<String, Boolean> interpretationCopy = Functions.copy(interpretation);

        for(int rule = 1; rule <= m; rule++){
            for(String attribute : attributes){
                if(!attribute.equals("P")){
                    if(!interpretationCopy.get(attribute + "_" + rule + "_" + "s")){
                        if(interpretationCopy.get(attribute + "_" + rule + "_" + "gt")){
                            String attributeModified = attribute.replaceFirst("<=", ">");
                            listOne.add(attributeModified);
                        } else {
                            listOne.add(attribute);
                        }
                    }
                }
            }
            listTwo.add(listOne + " \u21D2 P");
            listOne.clear();
        }

        return listTwo;
    }

    public static Set<String> checkPatology(Integer m, Integer p, List<String> attributes, List<List<String>> values, HashMap<String, Boolean> interpretation){
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();

        Set<String> set = new HashSet<>();

        HashMap<String, Boolean> interpretationCopy = Functions.copy(interpretation);

        return sickList(m, p, attributes, values, interpretationCopy, listOne, listTwo, set);

    }

    private static Set<String> sickList(Integer m, Integer p, List<String> attributes, List<List<String>> values, HashMap<String, Boolean> interpretation, List<String> listOne, List<String> listTwo, Set<String> set) {

        for(int patient = 0; patient < p; patient++){
            for(int rule = 1; rule <= m; rule++){
                int s = 0;
                for(String attribute : attributes){
                    if(!attribute.equals("P")){
                        if(!interpretation.get(attribute + "_" + rule + "_" + "s")){
                            if(!interpretation.get(attribute + "_" + rule + "_" + "gt")){
                                String attributeModified = attribute.replaceFirst("<=", ">");
                                listOne.add(attributeModified);
                                if(values.get(patient).get(attributes.indexOf(attribute)).equals("0")) { s=s+1 ; }
                            } else {
                                listOne.add(attribute);
                                if(values.get(patient).get(attributes.indexOf(attribute)).equals("1")) { s=s+1; }
                            }
                        }
                    }
                }

                /* 
                if(!(s == listOne.size())){
                    if(listTwo.contains(diagnosis(patient, 0))){ ; }
                    else if(listTwo.contains(diagnosis(patient, 1))){ ; }  
                    else{ listTwo.add(diagnosis(patient, 0)); }
                }else{
                    if(listTwo.contains(diagnosis(patient, 0))){
                        listTwo.remove(diagnosis(patient, 0));
                        listTwo.add(diagnosis(patient, 1)); }
                    else if(listTwo.contains(diagnosis(patient, 1))){ ; }
                    else{ listTwo.add(diagnosis(patient, 1)); } 
                }
                listOne.clear();
                */

                
                if(s == listOne.size()){
                    if(set.contains(diagnosis(patient, 0))){
                        set.remove(diagnosis(patient, 0));
                        set.add(diagnosis(patient, 1));
                    }
                } else {
                    set.add(diagnosis(patient, 0));
                }
                listOne.clear();
                
            }
        }

        return set;
    }

    private static String diagnosis(int patient, int patology){
       return (patology == 1) ? "Patient " + (patient + 1) + " has patoloy" : "Patient " + (patient + 1) + " has no patoloy";
    }

}
