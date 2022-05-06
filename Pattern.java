import java.util.Random;
public class Pattern{
  private int[] factors;
  private int finalFactor;
  private String operation;
  private int input;
  private int initial;

  public int[] getFactors(){
      return factors;
  }

  public String getOperation(){
      return operation;
  }

  public int getInput(){
      return input;
  }

  public int getFinalFactor(){
      return finalFactor;
  }

  public int getInitial(){
      return initial;
  }

  public void setInput(int input){
      this.input = input;
  }

  public void setFactors(int[] factors){
    this.factors = factors;
  }

  public void setOperation(String operation){
    this.operation = operation;
  }

  public void setInitial(int initial){
    this.initial = initial;
  }

  public void setFinalFactor(int factor){
    if(factor == -1){
      Random random = new Random();
      int randIndex = random.nextInt(factors.length);
      finalFactor = factors[randIndex];
    }
    else{
      finalFactor = factor;
    }
  }
}
