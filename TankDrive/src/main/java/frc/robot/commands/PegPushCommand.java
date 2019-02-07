/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PegPushCommand extends Command {
  boolean peg_forward2 = false;
  boolean flipflop = false;
  public PegPushCommand() {
    //peg_forward2 = peg_forward;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_hatchCover);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (flipflop == false) {
      flipflop = true;
    } else {
      flipflop = false;
    }

    if (flipflop == true) {
      Robot.m_hatchCover.DiscScoreForward();
    }else{
      Robot.m_hatchCover.DiscScoreReverse();
    }
    Timer.delay(.1);
    isFinished();

    /*if (peg_forward2 == true) {
    Robot.m_hatchCover.DiscScoreForward();
    }
    else {Robot.m_hatchCover.DiscScoreReverse();
    }
*/
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
      return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_hatchCover.DiscScoreOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
