import java.util.ArrayList;
public class SmartBot{
    private ArrayList<Integer> dataset = new ArrayList<>();
    private ArrayList<Solution> solutionSet = new ArrayList<>();
    private Problem problem;
    private String[] objectiveSet = {"find initial", "find next"};

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
        System.out.println(solutionSet);
        for (Solution solution : solutionSet) {
            if (solution.getObjective().equals(problem.getObjective())) {
              for(int factor : solution.getPattern().getFactors()){
                for (int j = 0; j < dataset.size(); j++) {
                  int input = dataset.get(j);
                  int newInput = solution.evaluate(input, factor);
                  if ((dataset.size() - 1) - j == 2 && newInput == dataset.get(j + 1)) {
                    solution.getPattern().setFinalFactor(factor);
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
      if(objective.equals(objectiveSet[0])){
        if(solution.getPattern().getOperation().equals("/")){
          output = dataset.get(0) * solution.getPattern().getFinalFactor();
        }
      }
      else if(objective.equals(objectiveSet[1])){
        if(solution.getPattern().getOperation().equals("/")){
          output = dataset.get(dataset.size() - 1) / solution.getPattern().getFinalFactor();
        }
      }
      return output;
    }

  public void clear(){
    dataset.clear();
  }

  public void addSolution(Solution solution){
    solutionSet.add(solution);
  }

  public ArrayList<Solution> getSolutionSet(){
    return solutionSet;
  }
}
