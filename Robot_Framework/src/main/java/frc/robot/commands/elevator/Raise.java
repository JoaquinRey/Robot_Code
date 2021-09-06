package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSystem;

public class Raise extends CommandBase {
    
    private final ElevatorSystem _elevator;

    public Raise(ElevatorSystem elevator) {
        _elevator = elevator;
    }

    public void execute() {
        System.out.println("Raise command executed");
    }

    public void end(boolean interrupted) {
        
    }

}
