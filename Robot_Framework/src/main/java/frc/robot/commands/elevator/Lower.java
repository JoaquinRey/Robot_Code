package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSystem;

public class Lower extends CommandBase {
    
    private final ElevatorSystem _elevator;

    public Lower(ElevatorSystem elevator) {
        _elevator = elevator;
    }

    public void execute() {
        System.out.println("Raise command executed");
        //_elevator.DriveElevator(-1.0f);
    }

    public void end(boolean interrupted) {
        System.out.println("Lower stopped");
        _elevator.Stop();
    }

}
