import java.util.ArrayList;
public class Main{
  public static void main(String[] args) {
      Pattern pattern = new Pattern(new int[]{2, 3}, "/", 150); //NOTE: Java Division always rounds down
      Problem problem = new Problem("find initial", pattern, 5);
      SmartBot smartBot = new SmartBot(problem);
      while(true){
        for(int i = 0; i < problem.getThreshold(); i++){
            smartBot.runProblem();
        }
        Solution solution = smartBot.analyze();
        if(solution == null){
          Solution correctSolution = problem.reveal();
          smartBot.addSolution(correctSolution);
        }
        else{
          int output = smartBot.finish(solution);
          System.out.println(output);
          break;
        }
      }
  }
}
