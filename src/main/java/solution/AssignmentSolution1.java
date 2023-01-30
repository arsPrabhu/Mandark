package solution;

import java.util.List;

public class AssignmentSolution1 {

    public static Integer solution(List<Integer> firstArray, List<Integer> secondArray){
        Integer temp;
        for(int i=0;i<firstArray.size();i++){
            if(firstArray.get(i)>secondArray.get(i)){
                temp=firstArray.get(i);
                firstArray.set(i,secondArray.get(i));
                secondArray.set(i,temp);
            }
        }
        Integer maxOfFirstArray=Integer.MIN_VALUE;
        Integer maxOfSecondArray=Integer.MIN_VALUE;
        for(int i=0;i<firstArray.size();i++){
            if(maxOfFirstArray<firstArray.get(i)) maxOfFirstArray=firstArray.get(i);
            if(maxOfSecondArray<secondArray.get(i)) maxOfSecondArray=secondArray.get(i);
        }
        return maxOfFirstArray*maxOfSecondArray;
    }

}
