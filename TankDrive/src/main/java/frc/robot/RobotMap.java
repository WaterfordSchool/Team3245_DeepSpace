/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  public static int leftFrontMotor = 1;
  public static int leftRearMotor = 5;
  public static int rightFrontMotor = 2;
  public static int rightRearMotor = 6;

  /**
  //Drivetrain Mappings
  leftDriveMotor(1),
  rightDriveMotor(2),
  leftSlaveMotor(5),       
  rightSlaveMotor(6),
  //Control Mappings
  driverJoystick(0),
  operatorJoystick(1);
    
  public final int value;
  
  RobotMap(int value) {
    this.value = value;
    } */
  
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
