import java.util.ArrayList;
public class SmartBot{
    private ArrayList<Integer> dataset = new ArrayList<>();
    private ArrayList<Solution> solutionSet = new ArrayList<>();
    private Problem problem;

    public SmartBot(Problem problem){
        this.problem = problem;
    }

    public ArrayList<Integer> getDataset(){
        return dataset;
    }

    public void runProblem(){
        dataset.add(problem.getInput());
    }

    public Solution analyze(){
        for (Solution solution : solutionSet) {
            if (solution.getObjective().equals(problem.getObjective())) {
              for(int factor : solution.getFactors()){
                for (int j = 0; j < dataset.size(); j++) {
                  int input = dataset.get(j);
                  int newInput = solution.evaluate(input, factor);
                  if ((dataset.size() - 1) - j == 2 && newInput == dataset.get(j + 1)) {
                    solution.setFinalFactor(factor);
                    return solution;
                  }
                  if (newInput != dataset.get(j + 1)) {
                    break;
                  }
                }
              }
            }
        }
        return null;
    }

    public int finish(Solution solution){
      String objective = solution.getObjective();
      int output = 0;
      if(objective == "find initial"){
        if(solution.getOperation() == "/"){
            output = dataset.get(0) * solution.getFinalFactor();
        }
      }
      return output;
    }

  public void addSolution(Solution solution){
    solutionSet.add(solution);
  }

  public ArrayList<Solution> getSolutionSet(){
    return solutionSet;
  }
}
