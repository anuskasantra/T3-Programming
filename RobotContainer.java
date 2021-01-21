package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PIDCommand;
//import flanagan.integration.Integration;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//Subsystems
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.PneumaticDogShifterSub;
import frc.robot.subsystems.ElevatorSub;
import frc.robot.subsystems.HubbleSub;
import frc.robot.subsystems.KrystalSub;
import frc.robot.subsystems.GlockSub;

//Commands
import frc.robot.commands.ControllerDriveCommand;
import frc.robot.commands.*;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.HubbleForwardCommand;
import frc.robot.commands.KrystalLeftCommand;
import frc.robot.commands.KrystalRightCommand;
import frc.robot.commands.GlockPIDCommand;

/**
 * @author Daniel Pearson
 * @version 1/9/2020
 */

@SuppressWarnings("unused")
public class RobotContainer {
  private DriveTrainSub drivetrain = new DriveTrainSub();
  private XboxController controller = new XboxController(Constants.XBOX_PORT_ID);
  // private PneumaticDogShifterSub shifter = new PneumaticDogShifterSub();
  private ElevatorSub elevator = new ElevatorSub();
  private HubbleSub hubble = new HubbleSub();
  private KrystalSub krystal = new KrystalSub();
  private JoystickButton aButton = new JoystickButton(controller, 1);
  private JoystickButton yButton = new JoystickButton(controller, 4);
  private JoystickButton bButton = new JoystickButton(controller, 2);
  private JoystickButton leftBumper = new JoystickButton(controller, 5);
  private JoystickButton rightBumper = new JoystickButton(controller, 6);


  //private GlockSub glock = new GlockSub();
  //private Integration integrate = new Integration();
  //private Limelight vision = new Limelight();
  //private Intake intake = new Intake();
  //private Pneumatics pneumatics = new Pneumatics();
//nicole was

  public RobotContainer() {
    // Configure the button bindings
    configDefaultCommands();
    configureButtonBindings();
  }
  private void configureButtonBindings() {
  }

  public void configDefaultCommands(){
    drivetrain.setDefaultCommand(new ControllerDriveCommand(drivetrain, controller.getX(Hand.kRight), controller.getY(Hand.kLeft)));
    aButton.whileHeld(new ElevatorUpCommand(elevator, controller.getAButtonPressed()));
    yButton.whileHeld(new ElevatorDownCommand(elevator, controller.getYButtonPressed()));
    bButton.whileHeld(new HubbleForwardCommand(hubble, controller.getBButtonPressed()));
    leftBumper.whileHeld(new KrystalLeftCommand(krystal, controller.getBumperPressed(Hand.kLeft)));
    rightBumper.whileHeld(new KrystalLeftCommand(krystal, controller.getBumperPressed(Hand.kRight)));

    //elevator.setDefaultCommand(new ElevatorDefault(elevator));
   // elevator.setDefaultCommand(new ElevatorUpCommand(elevator, controller.getYButtonPressed()));
    //elevator.setDefaultCommand(new ElevatorDownCommand(elevator, controller.getAButtonPressed()));
    //hubble.setDefaultCommand(new HubbleForwardCommand(hubble, controller.getBButtonPressed()));
    //krystal.setDefaultCommand(new KrystalLeftCommand(krystal, controller.getBumperPressed(Hand.kLeft)));
    //krystal.setDefaultCommand(new KrystalRightCommand(krystal, controller.getBumperPressed(Hand.kRight)));
    //glock.setDefaultCommand(new GlockPIDCommand(glock, controller.getXButtonPressed()));

    //shifter.setDefaultCommand(new TorqueModeCommand(shifter, controller.getAButton()));


  }

  private Hand getRawAxis(int value) {
    return null;
  }

  public Command getAutonomousCommand() {
    return null;
  }
}