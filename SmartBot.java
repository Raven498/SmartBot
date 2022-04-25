import java.util.ArrayList;
public class SmartBot{
    private ArrayList<Integer> dataset = new ArrayList<>();
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
}
