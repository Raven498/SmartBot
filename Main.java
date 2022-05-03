import java.util.ArrayList;
public class Main{
  public static void main(String[] args) {
      int[] factorSet = {2, 3, 4, 5, 6, 7, 8};
      String[] objectiveSet = {"find next", "find initial"};
      for(int i = 0; i < objectiveSet.length; i++){
        Pattern pattern = new Pattern(new int[] {factorSet[i]}, "/", 100000000); //NOTE: Java Division always rounds down
        Problem problem = new Problem(objectiveSet[i], pattern, 3);
        SmartBot smartBot = new SmartBot(problem);
        while(true){
          for(int j = 0; j < problem.getThreshold(); j++){
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
}
