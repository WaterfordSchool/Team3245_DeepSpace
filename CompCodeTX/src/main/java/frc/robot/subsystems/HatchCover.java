/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import java.security.Timestamp;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class HatchCover extends Subsystem {
  
  //DoubleSolenoid PegPush = new DoubleSolenoid(21,0,1); //The second PCM's number is 21
  //DoubleSolenoid DiscMech = new DoubleSolenoid(21,2,3); // The second PCM's number is 21
  WPI_TalonSRX DiscMech2 = new WPI_TalonSRX(RobotMap.DiscMech2ID);
  
/*
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

  public void DiscCartForward(){
    DiscMech.set(DoubleSolenoid.Value.kForward);
  }

  public void DiscCartReverse(){
    DiscMech.set(DoubleSolenoid.Value.kReverse);
  }

  public void DiscCartOff(){
    DiscMech.set(DoubleSolenoid.Value.kOff);
  }
  */

  //New Disc Mech

  public void DiscDown(){
    //fpgat = new bla bla AMES
    DiscMech2.set(0.5);
  }

  public void DiscUp(){
    DiscMech2.set(-0.5);
  }

  public void DiscStop(){
    DiscMech2.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
