
package org.usfirst.frc3245.CompCode3245.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3245.CompCode3245.Robot;
import org.usfirst.frc3245.CompCode3245.RobotMap;

/**
 *
 */
public class ElevatorJoystick extends Command {
    private boolean limitState;
	
    public ElevatorJoystick() {

    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {  	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        limitState = Robot.elevator.elevatorLimitState();
        SmartDashboard.putBoolean("Elevator Limit State", limitState);
        if (limitState == false) {
            Robot.elevator.activate(Robot.oi.getOperator());
        }
        else {
            Robot.elevator.activate(0, 0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
