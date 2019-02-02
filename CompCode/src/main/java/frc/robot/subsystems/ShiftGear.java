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
public class ShiftGear extends Subsystem {
  
  //Instantiate Gear Shift Solenoid
  DoubleSolenoid gearPiston = new DoubleSolenoid(20, 4, 7);


public void DownShift(){
   gearPiston.set(DoubleSolenoid.Value.kForward);
}

public void UpShift(){
  gearPiston.set(DoubleSolenoid.Value.kReverse);
}




  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
