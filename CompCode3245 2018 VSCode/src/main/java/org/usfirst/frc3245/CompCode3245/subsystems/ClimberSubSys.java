/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3245.CompCode3245.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Add your docs here.
 */
public class ClimberSubSys extends Subsystem {
  
  Solenoid climber1 = new Solenoid(0);
  Solenoid climber2 = new Solenoid(6);


// please fix asap
  public void upsiedaisy(){
    climber1.set(true);
    climber2.set(true);

  }

  public void downsiedaisy(){
    climber1.set(false);
    climber2.set(false);
  }

  public void daisyoff(){
    climber1.close();
    climber2.close();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
