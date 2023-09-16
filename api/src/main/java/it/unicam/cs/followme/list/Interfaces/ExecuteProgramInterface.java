package it.unicam.cs.followme.list.Interfaces;

public interface ExecuteProgramInterface<R extends RobotInterface,S extends ShapeInterface> {

    String execute();

    String executeBasicCommand();

    String executeLoop();
}
