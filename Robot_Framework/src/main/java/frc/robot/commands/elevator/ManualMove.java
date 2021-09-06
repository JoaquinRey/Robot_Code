package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSystem;

public class ManualMove extends CommandBase {
    
    private final ElevatorSystem _elevator;
    private final double _lift;

    public ManualMove(ElevatorSystem elevator, double lift) {
        _elevator = elevator;
        _lift = lift;
    }

    public void execute() {
        //System.out.println("Manual moving");
        _elevator.DriveElevator(_lift);
    }

    public void end(boolean interrupted) {
        _elevator.Stop();
    }

}
