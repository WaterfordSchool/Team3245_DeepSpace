/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3245.CompCode3245.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class HatchCover extends Subsystem {
  
  DoubleSolenoid PegPush = new DoubleSolenoid(20,0,2);

  public HatchCover(){
    PegPush.set(DoubleSolenoid.Value.kReverse);
  }

  public void DiscScoreFoward(){
    PegPush.set(DoubleSolenoid.Value.kForward);
  }

  public void DiscScoreReverse(){
    PegPush.set(DoubleSolenoid.Value.kReverse);
  }

  public void DiscScoreOff(){
    PegPush.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
