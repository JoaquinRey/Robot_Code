package frc.robot.commands.io;

import frc.robot.subsystems.IOSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ToggleSafe extends CommandBase{
    
    private final IOSubsystem _io;

    public ToggleSafe(IOSubsystem io) {
        _io = io;
    }

    public void execute() {
        _io.ToggleSafeState();
    }

    public void end(boolean interrupted) {
        
    }

}
