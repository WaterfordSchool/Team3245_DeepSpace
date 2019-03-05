// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3245.CompCode3245;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.IFollower;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveTrainLeftFrontMotor, driveTrainLeftRearMotor, driveTrainRightFrontMotor, driveTrainRightRearMotor;
    public static WPI_TalonSRX elevatorMotor;
    public static DifferentialDrive driveTrainTDrive, elevatorEDrive;
    public static Encoder driveTrainLeftEncoder, driveTrainRightEncoder;
    public static ADXRS450_Gyro driveTrainGyro1;
    public static WPI_TalonSRX ElevatorMotor;
    public static WPI_TalonSRX LeftCartWheel;
    public static WPI_TalonSRX RightCartWheel;
    public static WPI_TalonSRX LeftCartArm;
    public static WPI_TalonSRX RightCartArm;
    public static WPI_TalonSRX RightIntakeMotor, LeftIntakeMotor, WristMotor;
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        //Drive Train
        driveTrainLeftFrontMotor = new WPI_TalonSRX(5);
        //LiveWindow.addActuator("DriveTrain", "Left Front Motor", (WPI_TalonSRX) driveTrainLeftFrontMotor);
        //driveTrainLeftFrontMotor.setInverted(false);
        driveTrainLeftRearMotor = new WPI_TalonSRX(1);
        //LiveWindow.addActuator("DriveTrain", "Left Rear Motor", (WPI_TalonSRX) driveTrainLeftRearMotor);
        //driveTrainLeftRearMotor.follow(driveTrainLeftFrontMotor);
        SpeedControllerGroup m_left = new SpeedControllerGroup(driveTrainLeftFrontMotor, driveTrainLeftRearMotor);
        
        driveTrainRightFrontMotor = new WPI_TalonSRX(6);
        driveTrainRightRearMotor = new WPI_TalonSRX(2);
        SpeedControllerGroup m_right = new SpeedControllerGroup(driveTrainRightFrontMotor, driveTrainRightRearMotor);
        
        driveTrainTDrive = new DifferentialDrive(m_left, m_right);
        //driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        //driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        //Gyro
        driveTrainGyro1 = new ADXRS450_Gyro();
        LiveWindow.addSensor("DriveTrain", "Gyro 1", driveTrainGyro1);
        //driveTrainGyro1.setSensitivity(0.007);
        
        
        //Encoders
        driveTrainLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "Left Encoder", driveTrainLeftEncoder);
        driveTrainLeftEncoder.setDistancePerPulse(1.0);
        driveTrainLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        
        driveTrainRightEncoder = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "Right Encoder", driveTrainRightEncoder);
        driveTrainRightEncoder.setDistancePerPulse(1.0);
        driveTrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);

        //Intake
        //intakeIntakeMotor = new WPI_TalonSRX(5);
       // LiveWindow.addActuator("Intake", "Intake Motor", (WPI_TalonSRX) intakeIntakeMotor);
        //intakeIntakeMotor.setInverted(false);
        
        //Elevator

        ElevatorMotor = new WPI_TalonSRX(7);
        //LiveWindow.addActuator("Elevator", "Elevator Motor", (WPI_TalonSRX) elevatorMotor);
        //elevatorMotor.setInverted(false);        
        
        elevatorEDrive = new DifferentialDrive(ElevatorMotor, WristMotor);

        
        //Cart
        LeftCartWheel = new WPI_TalonSRX(11);
        RightCartWheel = new WPI_TalonSRX(12);
        LeftCartArm = new WPI_TalonSRX(9);
        RightCartArm = new WPI_TalonSRX(10);
        
        LeftIntakeMotor = new WPI_TalonSRX(31);
        RightIntakeMotor = new WPI_TalonSRX(30);
        
        WristMotor = new WPI_TalonSRX(4);
          

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
