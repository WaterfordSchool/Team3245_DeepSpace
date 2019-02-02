/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Compressor;


/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  public static Compressor compressor = new Compressor(20);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  AnalogInput m_pressureSensor = new AnalogInput(1);

  private static final double KMAXPRESSURE = 2.55;
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public Pneumatics(){

  }

  public static void init(){
    compressor.start();
  }
  public boolean isPressurised() {
    if (Robot.isReal()){
      return KMAXPRESSURE <= m_pressureSensor.getVoltage();
    } else {
      return true;
    }
  }

  public void writePressure() {
    SmartDashboard.putNumber("Pressure", m_pressureSensor.getVoltage());
  }
}
