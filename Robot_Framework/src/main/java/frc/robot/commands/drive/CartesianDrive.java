package frc.robot.commands.drive;

import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CartesianDrive extends CommandBase{

    private final DriveSystem _drive;
    private final double x_val;
    private final double y_val;


    public CartesianDrive(double _x,double _y, DriveSystem drive) {
        _drive = drive;
        x_val = _x;
        y_val = _y;
    }


    public void execute() {
        System.out.println("Drive executed");
        _drive.CartesianDrive(x_val, y_val, 0);
    }

    public void end(boolean interrupted) {
        _drive.StopDrive();
    }
}
