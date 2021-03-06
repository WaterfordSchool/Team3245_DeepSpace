/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.*;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
/**Class DriveTrain
 * @author Some nerd
 * @see frc.robot.Robot
 
 */
public class DriveTrainPID extends PIDSubsystem {
  /**
   * Add your docs here.
   */

  public static final double left90 = -90;
  public static final double right90 = 90;
  public static final double x_target = 0;
  public static final double y_target = 0;
  public static final double ll_area = 10;

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public  NetworkTableEntry tx = table.getEntry("tx");
  public  NetworkTableEntry ty = table.getEntry("ty");
  public  NetworkTableEntry ta = table.getEntry("ta");



  public final ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();

  public DriveTrainPID() {
    // Intert a subsystem name and PID values here
    super("DriveTrainPID", 0.1, 0, 0);
  
    //setInputRange(-27, 27);
    setAbsoluteTolerance(1.0);
    getPIDController().setContinuous(false);
    
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
        //read values periodically
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        double return_value = 10;
    
        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    if (Robot.PID_return == 0){
      return_value = x;
    }
    else if (Robot.PID_return == 1){
      return_value = area;
    }
    return return_value;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
 
    if (Robot.PID_return == 0){
      Robot.m_driveTrain.drive(output, -output);
    }
    else if (Robot.PID_return == 1){
      Robot.m_driveTrain.drive(output, output);
    }  
  }
}
