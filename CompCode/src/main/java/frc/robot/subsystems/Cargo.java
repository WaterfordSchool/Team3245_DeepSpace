/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class Cargo extends Subsystem {
  public final WPI_TalonSRX wristMotor = new WPI_TalonSRX(RobotMap.SnakeWristMotorID);
  public final WPI_TalonSRX wheelsMotor = new WPI_TalonSRX(RobotMap.SnakeWheelsID);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void activate(Joystick joy) {
    //activate(joy.getAxis(AxisType.kThrottle), 0);
    wristMotor.set(joy.getRawAxis(3));
  }
  public void up() {
    wristMotor.set(.7);
  }
  public void down() {
    wristMotor.set(-.7);
  }
  public void stopWrist() {
    wristMotor.set(0);
  }
  public void inSpin(){
    wheelsMotor.set(0.7);
  }
  public void outSpin(){
    wheelsMotor.set(-0.7);
  }
  public void stopWheels(){
    wheelsMotor.set(0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
