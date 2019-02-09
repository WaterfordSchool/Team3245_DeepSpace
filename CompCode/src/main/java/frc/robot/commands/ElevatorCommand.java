/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
package org.usfirst.frc3245.CompCode3245.commands;
//see if you need this package ^
import org.usfirst.frc3245.CompCode3245.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorCommand extends Command {
  public ElevatorCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Elevator);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(gearShift == true){
      Robot.Elevator.up();
    }
    else {
      Robot.Elevator.down();
    }
  
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
    //return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.Elevator.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
