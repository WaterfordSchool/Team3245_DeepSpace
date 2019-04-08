/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * An example command.  You can replace me with your own command.
 */
public class TankDrive extends Command {

    double speed;
    private boolean m_LimelightHasValidTarget = false; 
    private double m_LimelightDriveCommand = 0.0;
    private double m_LimelightSteerCommand = 0.0;
  
    
  public TankDrive(double kSpeed) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_driveTrain);
    speed = kSpeed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Update_Limelight_Tracking();
    Robot.m_driveTrain.drive(Robot.m_oi.getDriver(), speed);
   /* boolean lime_drive =Robot.m_oi.getDriver().getRawButton(6);
    if(!lime_drive)
    {
      Robot.m_driveTrain.drive(Robot.m_oi.getDriver(), speed);
    }
    else
    {
      if (m_LimelightHasValidTarget) {
        Robot.m_driveTrain.drive(m_LimelightDriveCommand, m_LimelightSteerCommand);
      }
      else {
        Robot.m_driveTrain.drive(0.0,0.0);
     */ 
    //}
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.drive(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }

  
    public void Update_Limelight_Tracking() {
      final double STEER_K = 0.03;
      final double DRIVE_K = 0.26;
      final double DESIRED_TARGET_AREA = 13.0;
      final double MAX_DRIVE = 0.7;
    
      double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
      double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
      double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
      double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

      if (tv < 1.0){
        m_LimelightHasValidTarget = false;
        m_LimelightDriveCommand = 0.0;
        m_LimelightSteerCommand = 0.0;
        return;

      }

      m_LimelightHasValidTarget = true;

      //proportional steering
      double steer_cmd = tx * STEER_K;
      m_LimelightSteerCommand = steer_cmd;

      //drive forward until target area reaches the desired area
      double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

      //don't let the robot drive too fast
      if (drive_cmd > MAX_DRIVE){
        drive_cmd = MAX_DRIVE;
      }
      m_LimelightDriveCommand = drive_cmd;
      }


}
