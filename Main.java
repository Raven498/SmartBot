import java.util.ArrayList;
import java.util.Scanner;
public class Main{
  public static void main(String[] args) {
      //Instantiate objects
      Pattern pattern = new Pattern(); //NOTE: Java Division always rounds down
      Problem problem = new Problem(3);
      SmartBot smartBot = new SmartBot(problem);

      //Mainloop
      while(true){
        //Get and parse problem input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter factors: ");
        String factorInput = scanner.nextLine();
        System.out.println("Enter operation: ");
        String operation = scanner.nextLine();
        System.out.println("Enter initial: ");
        int initial = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter objectives: ");
        String[] objectives = scanner.nextLine().split(" ,");

        //Parse factor input
        String[] factorStr = factorInput.split(" ,");
        int[] factors = new int[factorStr.length];
        for(int i = 0; i < factorStr.length; i++){
          factors[i] = Integer.parseInt(factorStr[i]);
        }

        //Initialize Pattern
        pattern.setFactors(factors);
        pattern.setOperation(operation);
        pattern.setInitial(initial);

        //Initialize Problem with a fully initialized Pattern
        problem.setPattern(pattern);

        //Solve each objective
        for(int i = 0; i < objectives.length; i++){
          problem.setObjective(objectives[i]);
          //Keep analyzing until a solution is found
          while(true){
            for(int j = 0; j < problem.getThreshold(); j++){
                smartBot.runProblem();
            }
            Solution solution = smartBot.analyze();
            if(solution == null){
              System.out.println("No Solution");
              Solution correctSolution = problem.reveal();
              smartBot.addSolution(correctSolution);
            }
            else{
              //Finish the objective if a solution has been found
              int output = smartBot.finish(solution);
              System.out.println(output);
              break;
            }
          } //analysis loop end
        } //objective loop end
      } //mainloop end
  } //main method end
} //class end
