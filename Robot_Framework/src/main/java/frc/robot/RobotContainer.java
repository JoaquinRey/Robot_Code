// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import java.util.Map;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;

//Subsystems
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ElevatorSystem;
import frc.robot.subsystems.IOSubsystem;

//Constants
import frc.robot.Constants.IOConstants;

//Commands
import frc.robot.commands.drive.CartesianDrive;
import frc.robot.commands.elevator.Raise;
import frc.robot.commands.elevator.Lower;
import frc.robot.commands.elevator.ManualMove;
import frc.robot.commands.io.ToggleSafe;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */


public class RobotContainer {

  private final DriveSystem _drive = new DriveSystem();
  private final ElevatorSystem _elevator = new ElevatorSystem();
  private final IOSubsystem _io = new IOSubsystem();

  private final Joystick driver_controller = new Joystick(IOConstants.DRIVE_CONTROLLER_PORT);
  private final Joystick secondary_controller = new Joystick(IOConstants.SECONDARY_CONTROLLER_PORT);
  private final XboxController ElevatorController = new XboxController(IOConstants.ELEVATOR_CONTROLLER_PORT);

  private final Command raise = new Raise(_elevator);
  private final Command lower = new Lower(_elevator);
  private final Command safemodetoggle = new ToggleSafe(_io);

  private final JoystickButton _AButton = new JoystickButton(ElevatorController, Button.kA.value);
  private final JoystickButton _YButton = new JoystickButton(ElevatorController, Button.kY.value);
  private final JoystickButton _StartButton = new JoystickButton(ElevatorController, Button.kStart.value);
  
  private final ShuffleboardTab mainTab = Shuffleboard.getTab("Main Tab");

  private final UsbCamera _camera = CameraServer.getInstance().startAutomaticCapture(0);

  private final SendableChooser<Command> _auto = new SendableChooser<>();


  //will probably use something like this at a later time
  //private NetworkTableEntry maxSpeed = mainTab.add("Max Speed", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 1)).getEntry();

  public RobotContainer() {
    
    _drive.setDefaultCommand(new CartesianDrive(driver_controller.getX(), driver_controller.getY(), secondary_controller.getX(), _drive));
    //_elevator.setDefaultCommand(new ManualMove(_elevator, ElevatorController.getY()));

    mainTab.add("Auto Chooser", _auto).withSize(2, 1).withPosition(0, 0);
    mainTab.add("Camera", _camera).withSize(3, 3).withPosition(2, 0);

    mainTab.add("X axis", driver_controller.getX());
    mainTab.add("Y axis", driver_controller.getY());

    mainTab.add("Potentiometer Values", _elevator.getPotentiometers());

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    /** Sets commands to button presses **/
    //uncomment after testing drive
    _YButton.whenHeld(raise);
    _AButton.whenHeld(lower);
    _StartButton.whenPressed(safemodetoggle);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}
