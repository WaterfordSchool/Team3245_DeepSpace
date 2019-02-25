/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Prototype1 extends Subsystem {
  DoubleSolenoid crashOnRoadExcuses = new DoubleSolenoid(20, 0, 1);

  public void PrototypeForward(){
    crashOnRoadExcuses.set(DoubleSolenoid.Value.kForward);
  }

  public void PrototypeReverse(){
    crashOnRoadExcuses.set(DoubleSolenoid.Value.kReverse);
  }

  public void PrototypeOff(){
    crashOnRoadExcuses.set(DoubleSolenoid.Value.kOff);
  }
  
  @Override
  public void initDefaultCommand() {
  }
}
