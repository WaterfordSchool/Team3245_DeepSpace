/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3245.CompCode3245.commands;

import org.usfirst.frc3245.CompCode3245.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Climber extends Command {

  boolean toClimb;
  public Climber(boolean toClimb) {
  // boolean toClimb2 = toClimb;
   this.toClimb = toClimb;

  requires(Robot.m_climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(toClimb == true){
     Robot.m_climb.Down();
    }
    else {
     Robot.m_climb.Up();
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
   Robot.m_climb.Off ();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
