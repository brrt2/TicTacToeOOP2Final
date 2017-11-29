package gamemanagement;

public class RefereeTestHelper {

    public int[] drawNumberGenerator(int first,int second){
        int[] arr = new int[first*second];
        for(int i=0; i<first*second; i++){
            arr[i]=i+1;
        }
        return arr;
    }

}
