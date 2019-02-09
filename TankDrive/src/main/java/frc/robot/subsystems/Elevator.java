/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {

private final WPI_TalonSrX Elevator = RobotMap.ElevatorMotorID;


  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new ElevatorJoystick());

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

public void activate(double left. double blank) {
  RobotMap.ElevatorMotorID.arcadeDrive(left, blank);
}

public void activate(Joystick joy) {
  activate(joy.getY(), 0);
}

public void up() {
  Elevator.set(.7);
}
}
