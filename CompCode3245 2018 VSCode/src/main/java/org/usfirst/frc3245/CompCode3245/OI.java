// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3245.CompCode3245;

import org.usfirst.frc3245.CompCode3245.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc3245.CompCode3245.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick driver;
    public Joystick operator;
    public JoystickButton opGreenButton, opYellowButton;
    public JoystickButton opBlueButton, opRedButton;
    public Joystick opLeftJoystick, opRightJoystick;
    public JoystickButton DpadUp, DpadDown, DpadLeft, DpadRight;
    public JoystickButton drRightTrigger, drLeftTrigger, drYellowButton, drRightBumper, drLeftBumper;
    public JoystickButton opRightTrigger, opLeftTrigger, opRightBumper, opLeftBumper;
	


    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	
    	driver = new Joystick(0);
        operator = new Joystick(1);
   
        //Driver Controls
        	//Cube Scoring Command
        	drRightTrigger = new JoystickButton (driver, 6);
        	drRightTrigger.whenPressed(new CubeScoringCommand ());
        
		//Operator Controls
		
			//PegPush
			drYellowButton = new JoystickButton (driver, 4);
			drYellowButton.whenPressed(new PegPushCommand(true));

        	//Intake
        	//opLeftJoy wrist up and down
			//Intake Wrist Up
        	opRightTrigger = new JoystickButton (operator, 8);
        	opRightTrigger.whileHeld(new IntakeWheelsIn());

        	//Intake Wrist Down
        	opLeftTrigger = new JoystickButton (operator, 7);
        	opLeftTrigger.whileHeld(new IntakeWheelsInLeft());
        	
        	// Intake Wheels In
        	
        	opRightBumper = new JoystickButton(operator, 6);
        	opRightBumper.whileHeld(new IntakeWheelsOut());
        	
        	//Intake Wheels Out
        	
        	opLeftBumper = new JoystickButton(operator, 5);
        	opLeftBumper.whileHeld(new IntakeWheelsOutLeft());
     
        	//Cart
        	// opGreenButton cart wheels in
        	opGreenButton = new JoystickButton (operator, 2);
        	opGreenButton.whileHeld(new PegPushCommand(false));
        	// opYellowButton cart wheels out
        	opYellowButton = new JoystickButton (operator, 4);
        	opYellowButton.whileHeld(new PegPushCommand(true));
        	// opBlueButton rotate arms in
        	opBlueButton = new JoystickButton (operator, 1);
        	opBlueButton.whileHeld(new DiscMech(false));
        	// opRedButton rotate arms out
        	opRedButton =  new JoystickButton (operator, 3);
        	opRedButton.whileHeld(new DiscMech(true));
			
			//test
        	//FastButton
        	drLeftBumper = new JoystickButton (driver, 5);
        	drLeftBumper.whileHeld(new TankDrive(1.0));

        // SmartDashboard Buttons
        //SmartDashboard.putData("Autonomous Command", new AutonomousCommand()); Do we need this?
        SmartDashboard.putData("Intake Cube", new IntakeCube());
        SmartDashboard.putData("Gyro Turn 90", new GyroTurn(90, 0.3, 0, 0));
        SmartDashboard.putData("Gyro Turn -90", new GyroTurn(-90, 0.3, 0, 0));


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }


	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriver() {
        return driver;
    }

    public Joystick getOperator() {
        return operator;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

