/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class Shifter extends Subsystem {
public final DoubleSolenoid gearPiston = new DoubleSolenoid(20, 2, 4); //Drivetrain PCM is 20


public void DownShift(){
  gearPiston.set(DoubleSolenoid.Value.kForward);
}

public void UpShift(){
 gearPiston.set(DoubleSolenoid.Value.kReverse);
}

public void ShiftOff (){
  gearPiston.set(DoubleSolenoid.Value.kOff);
}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
