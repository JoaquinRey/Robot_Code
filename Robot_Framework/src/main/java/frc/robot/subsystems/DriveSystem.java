package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

import frc.robot.Constants.DriveConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSystem extends SubsystemBase{
    
    private final CANSparkMax _front_left_motor;
    private final CANSparkMax _front_right_motor;
    private final CANSparkMax _back_right_motor;
    private final CANSparkMax _back_left_motor;

    private final MecanumDrive _drive;

    public DriveSystem() {

        System.out.println(DriveConstants.FRONT_LEFT);

        _front_left_motor = new CANSparkMax(DriveConstants.FRONT_LEFT, MotorType.kBrushless);
        _front_right_motor = new CANSparkMax(DriveConstants.FRONT_RIGHT, MotorType.kBrushless);
        _back_right_motor = new CANSparkMax(DriveConstants.BACK_RIGHT, MotorType.kBrushless);
        _back_left_motor = new CANSparkMax(DriveConstants.BACK_LEFT, MotorType.kBrushless);
    
        _drive = new MecanumDrive(_front_left_motor, _back_left_motor, _front_right_motor, _back_right_motor);

        _front_left_motor.setInverted(true);
        _back_left_motor.setInverted(true);

    }

    public void CartesianDrive(double _y, double _x, double _rot) {
        _drive.driveCartesian(_y, _x, _rot);
    }

    public void StopDrive() {
        _drive.stopMotor();
    }

}
