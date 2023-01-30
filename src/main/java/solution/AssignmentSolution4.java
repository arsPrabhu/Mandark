package solution;

public class AssignmentSolution4 {

    public static double solution(int[] startPoint,String path){

        int[] temp={startPoint[0],startPoint[1]};

        for(int i=0;i<path.length();i++){
            switch (path.charAt(i)) {
                case 'N':
                    temp[1]+=1;
                    break;
                case 'E':
                    temp[0]+=1;
                    break;
                case 'S':
                    temp[1]-=1;
                    break;
                case 'W':
                    temp[0]-=1;
                    break;
            }
        }

        return Math.sqrt(Math.pow((temp[0]-startPoint[0]),2)+Math.pow((temp[1]-startPoint[1]),2));
    }

}
