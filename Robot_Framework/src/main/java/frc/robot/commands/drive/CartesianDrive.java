package frc.robot.commands.drive;

import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CartesianDrive extends CommandBase{

    private final DriveSystem _drive;
    private final double x_val;
    private final double y_val;
    private final double z_val;


    public CartesianDrive(double _x, double _y, double _z, DriveSystem drive) {
        _drive = drive;
        x_val = _x;
        y_val = _y;
        z_val = _z;
    }


    public void execute() {
        //System.out.println("Drive executed");
        _drive.CartesianDrive(x_val, y_val, z_val);
    }

    public void end(boolean interrupted) {
        _drive.StopDrive();
    }
}
