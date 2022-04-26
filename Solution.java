import java.util.Objects;
import java.util.Random;

public class Solution extends Pattern{
    private String objective;

    public Solution(int[] factors, String operation, int initial, String objective) {
        super(factors, operation, initial);
        this.objective = objective;
    }

    public String getObjective(){
        return objective;
    }

    public void setObjective(String objective){
        this.objective = objective;
    }

    public int evaluate(int input, int factor){
        int newInput = 0;
        if(Objects.equals(getOperation(), "/")){
            newInput = input / factor;
        }
        return newInput;
    }
}
