// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int FRONT_LEFT = 11;
        public static final int FRONT_RIGHT = 10;
        public static final int BACK_RIGHT = 13;
        public static final int BACK_LEFT = 12;

    }

    public static final class IOConstants {
        public static final int DRIVE_CONTROLLER_PORT = 0;
        public static final int SECONDARY_CONTROLLER_PORT = 1;

        // probably dont need these
        //public static final int JOYSTICK_X_AXIS = 0;
        //public static final int JOYSTICK_Y_AXIS = 1;



    
        
    }

    public static final class ElevatorConstants {
        public static final int TOP_ACTUATOR = 0;
        public static final int BOTTOM_ACUATOR = 1;

        public static final int BOTTOM_POTENTIOMETER_PORT = 0;
        public static final int TOP_POTENTIOMETER_PORT = 1;

        public static final double LIFT_MOTOR_SPEED = 0.5;
    }
}
