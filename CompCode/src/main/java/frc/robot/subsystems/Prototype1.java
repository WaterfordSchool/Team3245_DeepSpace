/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.PegPush;

/**
 * Add your docs here.
 */
public class Prototype1 extends Subsystem {
  DoubleSolenoid prototypeMotorGang2 = new DoubleSolenoid(20, 0, 1);

  public void HardOn(){
    prototypeMotorGang2.set(DoubleSolenoid.Value.kForward);
  }

  public void Hardoff(){
    prototypeMotorGang2.set(DoubleSolenoid.Value.kReverse);
  }

  public void HardStop(){
    prototypeMotorGang2.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
  }
}
