/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DiscPrototype1 extends Subsystem {
 
  public final WPI_TalonSRX prototypeMotorGang1 = new WPI_TalonSRX(1);
  
  public void protoDown() {

    prototypeMotorGang1.set(0.7);

  }
  
  public void protoUp(){
    prototypeMotorGang1.set(-0.7);
  }

  @Override
  public void initDefaultCommand() {
   

  }
}
