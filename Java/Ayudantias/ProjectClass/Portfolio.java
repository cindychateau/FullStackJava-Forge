import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> projects;

    public Portfolio() {
        this.projects = new ArrayList<Project>();
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public Double getPortfolioCost() {
        Double suma = 0.0;
        for (int i = 0; i < this.projects.size(); i++) {
            suma += this.projects.get(i).getCosto();
        }
        return suma;
    }

    public void showPortfolio() {
        for (int i = 0; i < this.projects.size(); i++) {
            System.out.println(this.projects.get(i).elevatorPitch());
        }
        System.out.println("Costo Total: " + getPortfolioCost());
    }
}
