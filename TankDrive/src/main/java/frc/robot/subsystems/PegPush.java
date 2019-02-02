/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * Add your docs here.
 */
public class PegPush extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //new solenoid called
  DoubleSolenoid LittleDog = new DoubleSolenoid(20, 0, 1);
  
  public void DiscScore(){
    LittleDog.set(DoubleSolenoid.Value.kForward);
    Timer.delay(3);
    LittleDog.set(DoubleSolenoid.Value.kReverse);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
