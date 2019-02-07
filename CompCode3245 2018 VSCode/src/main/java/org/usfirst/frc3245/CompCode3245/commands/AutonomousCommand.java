// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3245.CompCode3245.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
    public AutonomousCommand(double primaryTurn) {
    	addParallel(new CAClampIn());
    	addSequential(new DriveStr8(), 2.3);
    	addParallel(new CAClampIn());
    	addSequential(new GyroTurn(primaryTurn, 0.045, 0, 0), 1.5);
    	addParallel(new CAClampIn());
    	addSequential(new DriveStr8(), .3);
    	addParallel(new CAClampIn());
    	addSequential(new ElevatorUp(), 1.5);
    	addSequential(new CubeScoringCommand());
    }
}