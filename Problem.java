import java.util.*;
public class Problem{
    private String objective;
    private Pattern pattern;
    private int input;
    private int threshold;

    public Problem(String objective, Pattern pattern, int threshold){
        this.objective = objective;
        this.pattern = pattern;
        this.threshold = threshold;
        this.pattern.setFinalFactor(-1);
        this.input = this.pattern.getInitial();
    }

    public String getObjective(){
        return objective;
    }

    public Pattern getPattern(){
        return pattern;
    }

    public int getInput(){
        if(Objects.equals(pattern.getOperation(), "/")){
            input = input / pattern.getFinalFactor();
        }
        return input;
    }

    public int getThreshold(){
        return threshold;
    }

    public void setInput(int input){
        this.input = input;
    }

    public Solution reveal(){
      int[] factors = pattern.getFactors();
      String operation = pattern.getOperation();
      int initial = pattern.getInitial();
      Solution solution = new Solution(factors, operation, initial, objective);
      return solution;
    }
}
