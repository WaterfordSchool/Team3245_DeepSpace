/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer; //Attempt at making the disc mech based on time rather than being held (UNTESTED)
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.HatchCover;

public class DiscWrist extends Command {
  boolean UpOrDown;
 // double initSecs = Timer.getFPGATimestamp();
  public DiscWrist(boolean UpOrDown) {
    requires(Robot.m_hatchCover);
    this.UpOrDown = UpOrDown;
    //initSecs= Timer.getFPGATimestamp();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(UpOrDown){
      Robot.m_hatchCover.DiscUp();
    }
    else {
      Robot.m_hatchCover.DiscDown();
    }
    //while (Timer.getFPGATimestamp()-initSecs < 0.3 /*however many seconds it takes to fully run the command*/){
     // Timer.delay(0.001);
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
    //if(Timer.getFPGATimestamp()-initSecs >= 0.3){
    Robot.m_hatchCover.DiscStop();
    //}
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
