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
                for (int j = 0; j < dataset.size(); j++) {
                    int input = dataset.get(j);
                    int newInput = solution.evaluate(input);
                    if ((dataset.size() - 1) - j == 2 && newInput == dataset.get(j + 1)) {
                        return solution;
                    }
                    if (newInput != dataset.get(j + 1)) {
                        break;
                    }
                }
            }
        }
        return null;
    }
}
