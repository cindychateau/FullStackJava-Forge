public class ProjectTest {
    public static void main(String[] args) {

        Project p1 = new Project();
        p1.setNombre("Proyecto1");
        p1.setDescripcion("Descripcion1");
        p1.setCosto(100.0);
        System.out.println(p1.elevatorPitch());

        Project p2 = new Project("Proyecto2");
        p2.setDescripcion("Descripcion2");
        p2.setCosto(200.0);
        System.out.println(p2.elevatorPitch());

        Project p3 = new Project("Proyecto3", "Descripcion3");
        p3.setCosto(300.0);
        System.out.println(p3.elevatorPitch());

        Portfolio portfolio = new Portfolio();
        portfolio.addProject(p1);
        portfolio.addProject(p2);
        portfolio.addProject(p3);
        portfolio.showPortfolio();
    }
}
