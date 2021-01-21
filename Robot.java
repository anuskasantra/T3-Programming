/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ControllerDriveCommand;
import frc.robot.subsystems.DriveTrainSub;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.XboxController.Axis;

//subsystems
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.subsystems.PneumaticDogShifterSub;
import frc.robot.subsystems.ElevatorSub;
import frc.robot.subsystems.HubbleSub;
import frc.robot.subsystems.KrystalSub;
import frc.robot.subsystems.GlockSub;

//commands
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.HubbleForwardCommand;
import frc.robot.commands.KrystalLeftCommand;
import frc.robot.commands.KrystalRightCommand;
import frc.robot.commands.GlockPIDCommand;


//import java.util.ResourceBundle.Control;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  // private final DifferentialDrive m_robotDrive = new DifferentialDrive(new
  // TalonFX());

  private RobotContainer m_robotContainer;

  public static DriveTrainSub drivetrain = new DriveTrainSub();
  private XboxController controller = new XboxController(Constants.XBOX_PORT_ID);
  //04private PneumaticDogShifterSub shifter = new PneumaticDogShifterSub();
  private ElevatorSub elevator = new ElevatorSub();
  private HubbleSub hubble = new HubbleSub();
  private KrystalSub krystal = new KrystalSub();
  //private GlockSub glock = new GlockSub();

  //public Compressor compressor = new Compressor(Constants.COMPRESSOR_PORT_ID);
  private final Timer m_timer = new Timer();
   


  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    /*
    compressor.setClosedLoopControl(true);
    compressor.setClosedLoopControl(false);
    compressor.start();
    
    boolean enabled = compressor.enabled();
    boolean pressureSwitch = compressor.getPressureSwitchValue();
    double current = compressor.getCompressorCurrent();
    */

    
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {

    // schedule the autonomous command (example)
    //startTime = Timer.getFPGATimestamp();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    
      m_timer.reset();
      m_timer.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    //double time = Timer.getFPGATimestamp();
    //if (startTime - time < 2);\{}
    
    if (m_timer.get() > 12.0) {
      drivetrain.manualDrive(1.0, 1.0); // drive forwards half speed
    }
    else{
      drivetrain.manualDrive(0, 0); // drive forwards half speed
    }
    
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
    CommandScheduler.getInstance().run();
    drivetrain.setDefaultCommand(
        new ControllerDriveCommand(drivetrain, -controller.getX(Hand.kLeft), controller.getY(Hand.kRight)));
    /*elevator.setDefaultCommand(new ElevatorUpCommand(elevator, controller.getYButtonPressed()));
    elevator.setDefaultCommand(new ElevatorDownCommand(elevator, controller.getAButtonPressed()));
    hubble.setDefaultCommand(new HubbleForwardCommand(hubble, controller.getBButtonPressed()));
    krystal.setDefaultCommand(new KrystalLeftCommand(krystal, controller.getBumperPressed(Hand.kLeft)));
    krystal.setDefaultCommand(new KrystalRightCommand(krystal, controller.getBumperPressed(Hand.kRight)));
    //glock.setDefaultCommand(new GlockPIDCommand(glock, controller.getXButtonPressed()));
*/

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
