import java.util.Random;
public class Pattern{
  private int[] factors;
  private int finalFactor;
  private String operation;
  private int input;
  private int initial;

  public Pattern(int[] factors, String operation, int initial){
      this.factors = factors;
      this.operation = operation;
      this.initial = initial;
  }

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

  public void setFinalFactor(){
      Random random = new Random();
      int index = random.nextInt(factors.length);
      finalFactor = factors[index];
  }
}
