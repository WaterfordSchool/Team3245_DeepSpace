/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.commands.Prototype1;
import frc.robot.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  boolean flipflop = false;

  public Joystick driver; //= new Joystick(RobotMap.driverJoystick.value);
  public Joystick operator; //= new Joystick(RobotMap.operatorJoystick.value);

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  public JoystickButton drYellowButton;
  public JoystickButton drRedButton;
  public JoystickButton drLeftBumper;
  public JoystickButton drRightBumper;
  public JoystickButton drRightTrigger;
  public JoystickButton drLeftTrigger;
  public JoystickButton drStartButton;

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:


  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public OI() {
    driver = new Joystick(0);
    operator = new Joystick(1);

    drYellowButton = new JoystickButton(driver, 4);
    drYellowButton.whenPressed(new PegPushCommand());

    drRedButton = new JoystickButton(driver, 3);
    drRedButton.whenPressed(new PegPushCommand());

    drLeftBumper = new JoystickButton(driver, 5);
    drLeftBumper.whenPressed(new SetGyroSetpoint(DriveTrainPID.x_target));

    drRightBumper = new JoystickButton(driver, 6);
    drRightBumper.whenPressed(new SetGyroSetpoint(DriveTrainPID.ll_area));

    drRightTrigger = new JoystickButton(driver, 8);
    drRightTrigger.whenPressed(new DiscProto1Command());

    drLeftTrigger = new JoystickButton(driver, 7);
    drLeftTrigger.whenPressed(new DiscProto1Up());

    drStartButton = new JoystickButton(driver, 9);
    drStartButton.whenPressed(new Prototype1());

    //SmartDashboard Button
    SmartDashboard.putData("LL_Aim", new LL_Aim());
  }

  public Joystick getDriver() {
    return driver;
  }

  public Joystick getOperator() {
    return operator;
  }
}
