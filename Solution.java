import java.util.Objects;
import java.util.Random;

public class Solution{
    private String objective;
    private Pattern pattern;

    public String getObjective(){
        return objective;
    }

    public void setObjective(String objective){
        this.objective = objective;
    }

    public Pattern getPattern(){
      return pattern;
    }

    public void setPattern(Pattern pattern){
      this.pattern = pattern;
    }

    public int evaluate(int input, int factor){
        int newInput = 0;
        if(Objects.equals(pattern.getOperation(), "/")){
            newInput = input / factor;
        }
        return newInput;
    }
}
