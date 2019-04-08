/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3245.CompCode3245.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Add your docs here.
 */
public class LVTwoBack extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public final Solenoid L2Piston = new Solenoid(1);

  public void Down(){
    L2Piston.set(true);
  }
  public void Up(){
    L2Piston.set(false);
  }
  public void Off(){
    L2Piston.close();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
