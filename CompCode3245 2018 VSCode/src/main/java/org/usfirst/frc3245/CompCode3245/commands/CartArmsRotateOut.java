package org.usfirst.frc3245.CompCode3245.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3245.CompCode3245.Robot;
import org.usfirst.frc3245.CompCode3245.RobotMap;


/**
 *
 */
public class CartArmsRotateOut extends Command {

    public CartArmsRotateOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.cartArms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		setTimeout(0.9);
		//Robot.cart.rotateArm(armSpeed);
		Robot.cartArms.rotateArm(0.15);
		SmartDashboard.putNumber("Left Cart Wheel Speed", RobotMap.LeftCartWheel.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.cartArms.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
