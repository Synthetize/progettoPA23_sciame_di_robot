package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Model.ProgramCommand;

import java.util.ArrayList;

public class ExecuteLoopsCommands {
    ArrayList<ProgramCommand> programList;
    public ExecuteLoopsCommands(ArrayList<ProgramCommand> programList) {
        this.programList = programList;
    }

    public void repeat(int commandIndex) {
        int repeat = programList.get(commandIndex).getRepeat();
        ArrayList<ProgramCommand> repeatList = new ArrayList<>();
        int repeatIndex = commandIndex+1;

        while (programList.get(repeatIndex).getCommand() != "DONE") {
            repeatList.add(programList.get(repeatIndex));
            repeatIndex++;
        }
        //int doneIndex = repeatIndex;
        //commandIndex = doneIndex;

        //commadindex da fixare

        for (int i = 0; i < repeat; i++) {
            System.out.println("------------------" + i + "------------------");
            for (ProgramCommand command: repeatList) {
                System.out.println(command.getCommand());
            }
        }

    }

    public void forever(int commandIndex) {
        ArrayList<ProgramCommand> repeatList = new ArrayList<>();
        int repeatIndex = commandIndex+1;
        while (programList.get(repeatIndex).getCommand() != "DONE") {
            repeatList.add(programList.get(repeatIndex));
            repeatIndex++;
        }
        while (true) {
            for (ProgramCommand command: repeatList) {
                System.out.println(command.getCommand());
            }
        }

    }


}
