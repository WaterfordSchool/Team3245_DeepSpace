/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3245.CompCode3245.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3245.CompCode3245.Robot;

import edu.wpi.first.wpilibj.RobotBase;

public class DiscMech extends Command {
  boolean discMech;
  public DiscMech(boolean discMech2) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    discMech = discMech2;

    requires(Robot.hatchCover);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(discMech == true){
      Robot.hatchCover.DiscCartForward();
    }
    else{
      Robot.hatchCover.DiscCartReverse();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.hatchCover.DiscCartOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
