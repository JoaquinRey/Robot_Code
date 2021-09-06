// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

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

  private final JoystickButton _AButton = new JoystickButton(ElevatorController, IOConstants.A_BUTTON);
  private final JoystickButton _YButton = new JoystickButton(ElevatorController, IOConstants.Y_BUTTON);
  private final JoystickButton _StartButton = new JoystickButton(ElevatorController, IOConstants.START);
  
  
  public RobotContainer() {
    
    _drive.setDefaultCommand(new CartesianDrive(driver_controller.getX(), driver_controller.getY(), secondary_controller.getX(), _drive));
    _elevator.setDefaultCommand(new ManualMove(_elevator, ElevatorController.getY()));

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
