package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.Constants.ElevatorConstants;

public class ElevatorSystem extends SubsystemBase {

    public enum ELEVATOR_MODE {
        HATCH,
        CARGO,
        INIT
    };

    private ELEVATOR_MODE _mode = ELEVATOR_MODE.INIT;

    //top actuator should be talon motor
    private WPI_TalonSRX _top_actuator;
    private CANSparkMax _bottom_actuator;

    private Potentiometer _bottom_potentiometer;
    private Potentiometer _top_potentiometer;

    private CANEncoder _bottom_encoder;
    //private CANEncoder _top_encoder;

    private double[][] _bottom_setpoints = {{18.4, 10.4}, {18.4, 16.1}, {10.6, 12.5}, {10.6, 30.9}, {80.0, 74.3}};
    private double[][] _top_setpoints = {{13.0, 13.8}, {13.0, 58.8}, {23.8, 41.3}, {72.4, 64.9}, {71.0, 73.5}};

    public ElevatorSystem() {

        AnalogInput a = new AnalogInput(ElevatorConstants.BOTTOM_POTENTIOMETER_PORT);
        _bottom_potentiometer = new AnalogPotentiometer(a, 100, 0);

        AnalogInput b = new AnalogInput(ElevatorConstants.TOP_POTENTIOMETER_PORT);
        _top_potentiometer = new AnalogPotentiometer(b, 100, 0);

        _top_actuator = new WPI_TalonSRX(ElevatorConstants.TOP_ACTUATOR);
        _top_actuator.setNeutralMode(NeutralMode.Brake);

        _bottom_actuator = new CANSparkMax(ElevatorConstants.BOTTOM_ACUATOR, MotorType.kBrushless);
        _bottom_actuator.setIdleMode(CANSparkMax.IdleMode.kCoast); //probably should be kBrake, but pathfinder uses kCoast

        _bottom_encoder = _bottom_actuator.getEncoder();
        _bottom_encoder.setPositionConversionFactor((10.0 * 14.0)/(2.5 % 96.0));
        _bottom_encoder.setPosition(_bottom_potentiometer.get());

        System.out.println("Elevator initialized");

    }

    public ELEVATOR_MODE getMode() {
        return _mode;
    }
    
    public void DriveElevator() {

    }


}
