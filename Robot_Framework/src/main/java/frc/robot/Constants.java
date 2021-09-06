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
        public static final int ELEVATOR_CONTROLLER_PORT = 2;

        // probably dont need these
        //public static final int JOYSTICK_X_AXIS = 0;
        //public static final int JOYSTICK_Y_AXIS = 1;

        public static final int A_BUTTON = 1;
        public static final int B_BUTTON = 2;
        public static final int X_BUTTON = 3;
        public static final int Y_BUTTON = 4;
        public static final int LEFT_SHOULDER_BUTTON = 5;
        public static final int RIGHT_SHOULDER_BUTTON = 6;
        public static final int BACK = 7;
        public static final int START = 8;
        public static final int LEFT_JOYSTICK_PUSH = 9;
        public static final int RIGHT_JOYSTICK_PUSH = 10;

        public static final int X_AXIS_LEFT_JOYSTICK = 0;
        public static final int Y_AXIS_LEFT_JOYSTICK = 1;
        public static final int LEFT_TRIGGER = 2;
        public static final int RIGHT_TRIGGER = 3;
        public static final int X_AXIS_RIGHT_JOYSTICK = 4;
        public static final int Y_AXIS_RIGHT_JOYSTICK = 5;

    
        
    }

    public static final class ElevatorConstants {
        public static final int TOP_ACTUATOR = 0;
        public static final int BOTTOM_ACUATOR = 1;

        public static final int BOTTOM_POTENTIOMETER_PORT = 0;
        public static final int TOP_POTENTIOMETER_PORT = 1;

        public static final double ELEVATOR_SPEED = 0.5;
    }

    public static final class BuildConstants {
        /** This is for things like wheel size and measurements from the build team **/

    }
}
