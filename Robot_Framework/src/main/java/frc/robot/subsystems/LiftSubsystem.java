package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase{
    

    public enum LIFT_STATE {
        RETRACT,
        EXTEND,
        FRONT_UP
    };

    private LIFT_STATE _state = LIFT_STATE.RETRACT;

    public LiftSubsystem() {

    }

}
