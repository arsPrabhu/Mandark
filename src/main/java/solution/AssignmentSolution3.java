package solution;

import pojo.AlphaNumericString;

import java.util.ArrayList;
import java.util.List;

public class AssignmentSolution3 {

    public static List<List<String>> solution(List<String> inputStringList){

        List<AlphaNumericString> alphaNumericStringList=new ArrayList<>();
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();

        for(int i=0;i<inputStringList.size();i++){
            AlphaNumericString alphaNumericString=new AlphaNumericString();
            alphaNumericString.setCharacter(inputStringList.get(i).replaceAll("[^A-Za-z]", ""));
            alphaNumericString.setInteger(Integer.parseInt(inputStringList.get(i).replaceAll("[^0-9]", "")));
            alphaNumericString.setIndex(i);
            alphaNumericStringList.add(alphaNumericString);
        }

        alphaNumericStringList.sort((a,b)->{
            if(a.getCharacter().equalsIgnoreCase(b.getCharacter())){
                return a.getIndex()-b.getIndex();
            }
            return a.getCharacter().compareTo(b.getCharacter());
        });

        alphaNumericStringList.forEach(alphaNumericString -> {
            list1.add(inputStringList.get(alphaNumericString.getIndex()));
        });

        alphaNumericStringList.sort((a,b)->{
            if(a.getCharacter().equalsIgnoreCase(b.getCharacter())){
                return b.getInteger()- a.getInteger();
            }
            return a.getCharacter().compareTo(b.getCharacter());
        });

        alphaNumericStringList.forEach(alphaNumericString -> {
            list2.add(inputStringList.get(alphaNumericString.getIndex()));
        });

        return List.of(list1,list2);

    }

}
