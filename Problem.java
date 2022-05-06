import java.util.*;
public class Problem{
    private String objective;
    private Pattern pattern;
    private int input;
    private int threshold;

    public Problem(int threshold){
        this.threshold = threshold;
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

    public void setObjective(String objective){
      this.objective = objective;
    }

    public void setPattern(Pattern pattern){
      this.pattern = pattern;
      this.pattern.setFinalFactor(-1);
      this.input = this.pattern.getInitial();
    }

    public Solution reveal(){
      Solution solution = new Solution();
      solution.setPattern(pattern);
      solution.setObjective(objective);
      return solution;
    }
}
