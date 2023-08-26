package it.unicam.cs.followme.app;
import it.unicam.cs.followme.list.Controller.Controller;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Handlers.RobotsHandler;

public class App {
    public static void main(String[] args) {



//        for(ProgramCommand p : programParser.parseProgram(robotProgramPath)){
//            System.out.println(p.toString());
//        }
        String env_confPath = "configurations/environment_configs.txt";
        String robotProgramPath = "configurations/program.txt";

        Controller<RobotInterface, ShapeInterface> controller = Controller.getController();
        controller.initializeEnvironment(RobotsHandler.addRobotAtChosenPosition(), env_confPath);
        controller.initializeProgram(robotProgramPath);
        controller.executeProgram(4);

//        System.out.println("SHAPE POSITIONS:");
//        for (Shape s : environment.getShapes()) {
//            System.out.println(s.toString()+"\n");
//        }
//        System.out.println("Robots positions");
//        for (Robot r : environment.getRobotPositions().keySet()) {
//            System.out.println("-----------------------------------------------------------");
//            System.out.println(r.toString());
//            System.out.println(environment.getRobotPositions().get(r).toString());
//            System.out.println(r.getProgramList());
//        }


        
    }
}
