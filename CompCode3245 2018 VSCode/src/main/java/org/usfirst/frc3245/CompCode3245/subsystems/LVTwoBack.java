/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3245.CompCode3245.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class LVTwoBack extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public final DoubleSolenoid L2Piston = new DoubleSolenoid(0, 0, 1);

  public void Down(){
    L2Piston.set(DoubleSolenoid.Value.kForward);
  }
  public void Up(){
    L2Piston.set(DoubleSolenoid.Value.kReverse);
  }
  public void Off(){
    L2Piston.set(DoubleSolenoid.Value.kOff);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
