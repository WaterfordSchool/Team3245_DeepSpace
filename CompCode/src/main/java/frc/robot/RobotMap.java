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

 //Drivetrain TalonSRX Motor Controllers IDs
 public static int leftFrontMotorID = 1;
 public static int leftRearMotorID = 5;
 public static int rightFrontMotorID = 2;
 public static int rightRearMotorID = 6;

 //Elevator TalonSRX Motor Controllers IDs

 public static int ElevatorMotorID = 5;
 public static int SnakeWristMotorID = 6;
 public static int SnakeWheelsID = 8;

 //PCM Port Numbers for Pneumatics
 public static int DiscPushPort = 3;
 public static int GearShiftPort = 6;
 public static int PegPushPort = 4;

 
}
