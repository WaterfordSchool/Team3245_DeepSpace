/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Pivot;

/**
 * Get the robot set to collect balls.
 */
public class Collect extends CommandGroup {
  /**
   * Create a new collect command.
   */
  public Collect() {
    addSequential(new SetCollectionSpeed(Collector.kForward));
    addParallel(new CloseClaw());
    addSequential(new SetPivotSetpoint(Pivot.kCollect));
    addSequential(new WaitForBall());
  }
}
