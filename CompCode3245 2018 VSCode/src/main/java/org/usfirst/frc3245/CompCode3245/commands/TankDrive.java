// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3245.CompCode3245.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3245.CompCode3245.Robot;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 *
 */
public class TankDrive extends Command {
	
    double speed;
    private boolean m_LimelightHasValidTarget = false; 
    private double m_LimelightDriveCommand = 0.0;
    private double m_LimelightSteerCommand = 0.0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public TankDrive(double kSpeed) {
    	requires(Robot.driveTrain);
    	speed = kSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Update_Limelight_Tracking();
        Robot.driveTrain.drive(Robot.oi.getDriver(), speed);
        boolean lime_drive =Robot.oi.getDriver().getRawButton(6);
        if(!lime_drive)
        
        {
          Robot.driveTrain.drive(Robot.oi.getDriver(), speed);
        }
        else
        {
          if (m_LimelightHasValidTarget) {
            Robot.driveTrain.LL_arcadeDrive(m_LimelightDriveCommand, m_LimelightSteerCommand);
          }
          else {
            Robot.driveTrain.drive(0.0,0.0);
          
        }
      }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

    public void Update_Limelight_Tracking() {
        final double STEER_K = 0.03;
        final double DRIVE_K = 0.26;
        final double DESIRED_TARGET_AREA = 13.0;
        final double MAX_DRIVE = 0.3;
        
        double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
        double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    
        SmartDashboard.putNumber("tx", tx);
    
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
        SmartDashboard.putNumber("steer command", m_LimelightSteerCommand);
    
        //drive forward until target area reaches the desired area
        double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;
    
        //doesn't let the robot drive too fast
        if (drive_cmd > MAX_DRIVE){
          drive_cmd = MAX_DRIVE;
          }
        m_LimelightDriveCommand = drive_cmd;
        SmartDashboard.putNumber("drive command", m_LimelightDriveCommand);
      }
}
