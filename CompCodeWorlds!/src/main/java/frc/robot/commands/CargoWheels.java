/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied be the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**Class CargoWheels;
 * The commands to run the wheels of the cargo-pickup contraption are written here
 * IDK why this exists because its never actually called as far as I know
 * @author Some Nerd
 * @see Robot.java OI.java
 */
public class CargoWheels extends Command {
  double speed;

  /** Constructor method which sets the speed of the ball-pickup contraption
   * @param speed The speed of the motor to pick up the cargo
   */
  public CargoWheels(double speed) {
    this.speed = speed;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  /**The method called before CargoWheels.execute() runs for the first time
   * Nothing to see here...
   */
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  /**The method called when a CargoWheels instance is called, spins the
   * wheels at the speed set when first instanciated
   * @return void
   */
  protected void execute() {

    Robot.m_cargo.inSpin(speed);
    
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  /**The method which tells the robot if the Cargowheels.execute() command is finished
   * @return boolean
   */
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  /**The method that stops the wheels after CargoWheels.isFinished() returns true
   * There is no way CargoWheels.isFinished() can return true so why does this exist?
   * @return void
   */
  protected void end() {
    Robot.m_cargo.stopWheels();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  /**The method called when Cargo.java is told to do something else while a method,
   * most likely CargoWheels.execute(), is running. Runs CargoWheels.end(), which 
   * stops the wheels.
   * @see CargoWheels.end()
   * @return void
   */
  protected void interrupted() {
    end();
  }
}
