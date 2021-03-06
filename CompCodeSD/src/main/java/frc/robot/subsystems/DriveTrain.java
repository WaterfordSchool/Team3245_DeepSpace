/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.networktables.NetworkTableInstance;

import oi.limelightvision.limelight.frc.LimeLight;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private LimeLight _limelight;
  public final WPI_TalonSRX leftFront; //= new WPI_TalonSRX(RobotMap.leftFrontMotor);
  public final WPI_TalonSRX leftRear; //= new WPI_TalonSRX(RobotMap.leftRearMotor);
  public final WPI_TalonSRX rightFront; //= new WPI_TalonSRX(RobotMap.rightFrontMotor);
  public final WPI_TalonSRX rightRear; //= new WPI_TalonSRX(RobotMap.rightRearMotor);

  //public final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFront, leftRear);
  //public final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFront, rightRear);

  public final DifferentialDrive tDrive; // = new DifferentialDrive(leftMotors, rightMotors);
  public DriveTrain () {
    leftFront = new WPI_TalonSRX(RobotMap.leftFrontMotorID);
    leftRear = new WPI_TalonSRX(RobotMap.leftRearMotorID);
    rightFront = new WPI_TalonSRX(RobotMap.rightFrontMotorID);
    rightRear = new WPI_TalonSRX(RobotMap.rightRearMotorID);

    leftFront.setInverted(false);
    leftRear.setInverted(false);
    rightFront.setInverted(true);
    rightRear.setInverted(true);
    
    leftRear.follow(leftFront);
    rightRear.follow(rightFront);

    tDrive = new DifferentialDrive(leftFront, rightFront);


  } 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new TankDrive(1.0));
  }

  public void drive(double left, double right) {
      tDrive.tankDrive(-left, right);
  }


  public void drive(Joystick joy, double kSpeed) {
      drive(kSpeed*joy.getY(), kSpeed*joy.getRawAxis(3));
  }

   //Instantiate Gear Shift Solenoid
   

/*
   public void DownShift(){
      gearPiston.set(DoubleSolenoid.Value.kForward);
   }
   
   public void UpShift(){
     gearPiston.set(DoubleSolenoid.Value.kReverse);
   }
   
    public void ShiftOff (){
      gearPiston.set(DoubleSolenoid.Value.kOff);
    }
   
   
*/
  public LimeLight gLimeLight(){
    return _limelight;
  }
}
