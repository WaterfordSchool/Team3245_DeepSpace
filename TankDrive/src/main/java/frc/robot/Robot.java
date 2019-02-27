/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.commands.GearShift;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Cargo;
import frc.robot.subsystems.DiscPrototype1;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrainPID;
import frc.robot.subsystems.HatchCover;
import frc.robot.subsystems.Prototype1;
import frc.robot.subsystems.Shifter;
import frc.robot.RobotMap;
import edu.wpi.cscore.UsbCamera; //Full HD camera
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer; //Full HD Camera

import com.sun.jdi.Value;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CameraServerJNI;
import edu.wpi.cscore.CvSink; //Full HD Camera
import edu.wpi.cscore.CvSource; //Full HD Camera
import edu.wpi.cscore.MjpegServer; //Full HD Camera
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static OI m_oi;
  public static Cargo m_cargo = new Cargo();
  public static DriveTrain m_driveTrain = new DriveTrain();
  public static HatchCover m_hatchCover = new HatchCover();
  public static DriveTrainPID m_driveTrainPID = new DriveTrainPID();
  public static Prototype1 m_Prototype1 = new Prototype1();
  public static DiscPrototype1 m_discProto = new DiscPrototype1();
  //public static GearShift m_Shifter = new Shifter();
  //public static UsbCamera m_Camera= new UsbCamera("reee", " 10.32.45.182");

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public  NetworkTableEntry tx = table.getEntry("tx");
  public  NetworkTableEntry ty = table.getEntry("ty");
  public  NetworkTableEntry ta = table.getEntry("ta");

  public static int PID_return = 0;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    new Thread(() -> {
      UsbCamera m_Camera =  CameraServer.getInstance().startAutomaticCapture("camera1", 0); // Simple Genius Camera Code wpilib
      
      //it said add new camera server object
      //CameraServer.getInstance().addCamera();
      m_Camera.setResolution(320, 240);
      m_Camera.setFPS(30);

      CvSink cvSink = CameraServer.getInstance().getVideo();
      CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 320, 240);

      Mat source = new Mat();
      Mat output = new Mat();

      while(!Thread.interrupted()) {
        cvSink.grabFrame(source);
        Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
        outputStream.putFrame(output);
      }
    }).start();

    

  
    


    m_oi = new OI();

    m_chooser.setDefaultOption("Default Auto", new TankDrive(1.0));
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    Robot.m_driveTrainPID.m_gyro.reset();
    SmartDashboard.putNumber("Gyro Angle", Robot.m_driveTrainPID.m_gyro.getAngle());

  }



/**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  } 

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    
    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);

    SmartDashboard.putNumber("Gyro Angle", Robot.m_driveTrainPID.m_gyro.getAngle());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    SmartDashboard.putNumber("Gyro Angle", Robot.m_driveTrainPID.m_gyro.getAngle());

  }

  public static void setPID(int value) {
    PID_return = value;
  }

  public int getPID() {
    return PID_return;
  }
}
