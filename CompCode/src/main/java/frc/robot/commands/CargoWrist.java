/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**Class CargoWrist;
 * The commands to pivot the cargo-pickup contraption are written here
 * @author Some Nerd
 * @see Robot.java OI.java Cargo.java
 */
public class CargoWrist extends Command {
  /**The constructor method
   */
  public CargoWrist() {
    requires(Robot.m_cargo);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  /**The method called before CargoWrist.execute() runs for the first time
   * Nothing to see here...
   */
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  /**The method called when a CargoWrist instance is called
   * @see Cargo.java Robot.java
   */
  protected void execute() {
    Robot.m_cargo.activate(Robot.m_oi.getOperator());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  /**The method which tells the robot if the CargoWheels.execute() command is finished
   * @return boolean
   */
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  /**The method that stop the Cargo wrist when CargoWrist.isFinished() returns true
   * Why does this exist, isFinished() only returns false. America, explain
   * @return void
   */
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
