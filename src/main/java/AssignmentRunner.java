import solution.AssignmentSolution1;
import solution.AssignmentSolution2;
import solution.AssignmentSolution3;
import solution.AssignmentSolution4;

import java.util.Arrays;
import java.util.List;

public class AssignmentRunner {

    public static void main(String[] args) {

        System.out.println(AssignmentSolution1.solution
                (Arrays.asList(1,2,3,2,3,4,5,3,5,6,7,8),Arrays.asList(2,1,5,3,4,6,4,3,2,3,1,2)));
        AssignmentSolution2.solution();
        System.out.println(AssignmentSolution3.solution(List.of("d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77")));
        System.out.println(AssignmentSolution4.solution(new int[]{0,0},"NNNNEEENE"));

    }

}
