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
  
  Solenoid PegPush = new Solenoid(20,4); //changed DoubleSolenoid to Solenoid to accomodate new solenoinds
  Solenoid DiscMech = new Solenoid(20,5);

  //What is this method used for?

  public void DiscCartForward(){
    DiscMech.set(true);
  }

  public void DiscCartReverse(){
    DiscMech.set(false);
  }

  public void DiscCartOff(){
    DiscMech.close();
  }
  
  public void DiscScoreFoward(){
    PegPush.set(true);
  }

  public void DiscScoreReverse(){
    PegPush.set(false);
  }

  public void DiscScoreOff(){
    PegPush.close();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
