/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**Command DiscCommand
 * Operates the movement of the entire Disc mechanism through pneumatics
 * @author Probably Mr Joslin
 * @see PegPush Robot HatchCover
 */
public class DiscCommand extends Command {
  boolean pegPush;
  /**Constructor method for DiscCommand
   * Creates a new instance of a Double Solenoid to operate the pneumatics of the mechanism
   * @param pegPush
   */
  public DiscCommand(boolean pegPush) {
   this.pegPush = pegPush;
    requires(Robot.m_hatchCover);
  }

  // Called just before this Command runs the first time
  @Override
  /**The method that runs when the DiscCommand is first called
   * Nothing to see here
   * 404 Error: C:/Users/anyoneInRobotics/DecentSocialLife.exe is not found
   * Whoever is commenting, stop and get a life
   */
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  /**The method that runs whenever DiscCommand is called
   * It makes the cart go forward when the button is pegPush is true, then back if otherwise
   * @return void
   */
  protected void execute() {
  /*
    if(pegPush == true){
      Robot.m_hatchCover.DiscCartForward();
    }
    else {
      Robot.m_hatchCover.DiscCartReverse();
    }
    */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  /**The method that runs when DiscCommand.execute() stops running
   * @return false
   */
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  /**The method that runs once the execute() method isFinished()
   * Turns the Solenoid off.
   */
  protected void end() {
    /*
    Robot.m_hatchCover.DiscCartOff();
    */
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  /**The method that runs when some other method runs during the execute() method if they conflict
   * Ends execute().
   */
  protected void interrupted() {
    end();
  }
}
