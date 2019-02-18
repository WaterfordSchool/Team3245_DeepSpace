/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot; 
import edu.wpi.first.wpilibj.smartdashboard.*;

public class LL_Range extends Command {
  private final double m_setpoint;

  public LL_Range(double setpoint) {
    this.m_setpoint = setpoint;
    requires(Robot.m_driveTrainPID);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
  //**  Ruby u big dum */
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.PID_return = 1;
    Robot.m_driveTrainPID.enable();
    Robot.m_driveTrainPID.setSetpoint(m_setpoint);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putNumber("Gyro Angle", Robot.m_driveTrainPID.m_gyro.getAngle());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_driveTrainPID.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrainPID.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
