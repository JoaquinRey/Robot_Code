package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IOSubsystem extends SubsystemBase{
    
    public static boolean safe_state = false;
    public static boolean manual_control = false;

    
    public void ToggleSafeState() {
        System.out.println("Safe state toggled");
        safe_state = !safe_state;
    }

}
