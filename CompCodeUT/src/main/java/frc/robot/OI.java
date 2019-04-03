/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.buttons.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public Joystick driver; //= new Joystick(RobotMap.driverJoystick.value);
  public Joystick operator; //= new Joystick(RobotMap.operatorJoystick.value);

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  Button drRightTrigger   = new JoystickButton (driver, 8);
  Button drLeftTrigger    = new JoystickButton(driver, 7);
  Button drLeftBumper     = new JoystickButton(driver, 5);
  Button drRightBumper    = new JoystickButton(driver, 6);
  Button drYellowButton   = new JoystickButton(driver, 4); 
  Button drBlueButton     = new JoystickButton(driver, 1);  
  Button drGreenButton    = new JoystickButton(driver, 2);
  Button drRedButton      = new JoystickButton(driver, 3);

  Button opBlueButton     = new JoystickButton (operator, 1); 
  Button opGreenButton    = new JoystickButton (operator, 2);
  Button opRedButton      = new JoystickButton (operator, 3);
  Button opYellowButton   = new JoystickButton (operator, 4);
  Button opLeftBumper     = new JoystickButton (operator, 5);
  Button opRightBumper    = new JoystickButton (operator, 6);
  Button opLeftTrigger    = new JoystickButton (operator, 7);
  Button opRightTrigger   = new JoystickButton (operator, 8);


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

    //Peg Push?
    opYellowButton = new JoystickButton(operator, 4); //check the number later
    opYellowButton.whenPressed(new DiscCommand(true));

    //Peg Pull?
    opRedButton = new JoystickButton(operator, 3); //check the number later
    opRedButton.whenPressed(new DiscCommand(false));

    //Elevator Up
    opGreenButton = new JoystickButton(operator, 2); //check the number later
    opGreenButton.whenPressed(new PegPush(true));

    //Elevator Down
    opBlueButton = new JoystickButton(operator, 1); //check the number later
    opBlueButton.whenPressed(new PegPush(false)); 

    //Gear Shift Down
    drRightTrigger = new JoystickButton (driver, 8); //check the number later
    drRightTrigger.whenPressed(new GearShift(true));

    //Gear Shift Up
    drLeftTrigger = new JoystickButton (driver, 7); //check the number later 
    drLeftTrigger.whenPressed(new GearShift(false));

    //Cargo wheels spin in
     opRightBumper = new JoystickButton (operator, 6); 
     opRightBumper.whileHeld(new CargoWheels(-0.85));

     //Cargo wheels spin out
     opLeftBumper = new JoystickButton (operator, 5); 
     opLeftBumper.whileHeld(new CargoWheels(0.85));


    //New Disc Mech Up
    drYellowButton = new JoystickButton(driver, 4);
    drYellowButton.whileHeld(new DiscWrist(true));
    //drYellowButton.whenPressed(new DiscWrist(true));
    
    //New Disc Mech
    drRedButton = new JoystickButton(driver, 3);
    drRedButton.whileHeld(new DiscWrist(false));
    //drRedButton.whenPressed(new DiscWrist(false));

   // drBlueButton.whenPressed(new Climber(true));
   // drGreenButton.whenPressed(new Climber(false));

    //limelight 
    //drRightBumper = new JoystickButton(driver, 6);
    //drRightBumper.whileHeld(new LL_Aim());

    //Slow Button
    drLeftBumper = new JoystickButton (driver, 5);
		drLeftBumper.whileHeld(new TankDrive(0.7));

    
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
