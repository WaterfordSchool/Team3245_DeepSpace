package org.usfirst.frc3245.CompCode3245.subsystems;

import org.usfirst.frc3245.CompCode3245.Robot;
import org.usfirst.frc3245.CompCode3245.RobotMap;
import org.usfirst.frc3245.CompCode3245.commands.ElevatorJoystick;
import org.usfirst.frc3245.CompCode3245.commands.ElevatorUp;
import org.usfirst.frc3245.CompCode3245.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.AnalogTrigger;;


/**
 *
 */
public class Elevator extends Subsystem {
    AnalogTrigger elevatorLimit = new AnalogTrigger(0);

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final WPI_TalonSRX ElevatorMotor = RobotMap.ElevatorMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ElevatorJoystick());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void activate(double left, double blank) {
    	RobotMap.elevatorEDrive.arcadeDrive(left, blank);
    }
    public void activate(Joystick joy) {
    	//activate(joy.getAxis(AxisType.kThrottle), 0);
    	activate(joy.getY(),0);
    }
    public void up() {
    	ElevatorMotor.set(.7);
    }
    public void down() {
    	ElevatorMotor.set(-.7);
    }
    public boolean elevatorLimitState() {
        return elevatorLimit.getTriggerState();
    }
    public void stop() {
    	ElevatorMotor.set(0);
    }
}
