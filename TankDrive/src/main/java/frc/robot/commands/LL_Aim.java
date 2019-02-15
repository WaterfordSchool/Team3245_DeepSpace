/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LL_Aim extends Command {
  private double kpAim = 0.035;
  private double m_steeringAdjust;
  private double m_headingError;
  private double left_command;
  private double right_command;

  public LL_Aim() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {



  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double tx = Robot.m_driveTrain.gLimeLight().getdegRotationToTarget();
    boolean targetFound = Robot.m_driveTrain.gLimeLight().getIsTargetFound();

    if(targetFound){
      m_headingError = tx;
      m_steeringAdjust = m_headingError * kpAim;

      left_command+=m_steeringAdjust;
      right_command-=m_steeringAdjust; 
    }else{
      m_headingError = 0;
      m_steeringAdjust = 0;

      left_command+=m_steeringAdjust;
      right_command-=m_steeringAdjust; 

    }

    Robot.m_driveTrain.drive(left_command, right_command);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
