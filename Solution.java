import java.util.Objects;
import java.util.Random;

public class Solution extends Pattern{
    private String objective;

    public Solution(int[] factors, String operation, int initial) {
        super(factors, operation, initial);
    }

    public String getObjective(){
        return objective;
    }

    public void setObjective(String objective){
        this.objective = objective;
    }

    public int evaluate(int input){
        int newInput = 0;
        if(Objects.equals(getOperation(), "/")){
            newInput = input / getFinalFactor();
        }
        return newInput;
    }
}
