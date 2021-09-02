package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

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
    private CANSparkMax _top_actuator;
    private CANSparkMax _bottom_actuator;

    private Potentiometer _bottom_potentiometer;
    private Potentiometer _top_potentiometer;

    private CANEncoder _bottom_encoder;
    private CANEncoder _top_encoder;


    public ElevatorSystem() {
        _top_actuator = new CANSparkMax(ElevatorConstants.TOP_ACTUATOR, MotorType.kBrushless);
        _bottom_actuator = new CANSparkMax(ElevatorConstants.BOTTOM_ACUATOR, MotorType.kBrushless);



    }

    


}
