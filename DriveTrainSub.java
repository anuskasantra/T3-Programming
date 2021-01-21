package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

/* 
 * @author Daniel Pearson
 * @author Olen Brown
 * @version 2/9/2020
 */
public class DriveTrainSub extends SubsystemBase {

  //Initiates motor controllers
  private static WPI_TalonFX leftFront;
  private static WPI_TalonFX leftBack;
  private static WPI_TalonFX leftTop;
  private static WPI_TalonFX rightFront;
  private static WPI_TalonFX rightBack;
  private static WPI_TalonFX rightTop;

  //initiates controller groups
  private final SpeedControllerGroup driveLeft;
  private final SpeedControllerGroup driveRight;

  //creates differential drive object
  private DifferentialDrive myRobot;

  public DriveTrainSub() {

    //sets ports for motor controllers
    leftFront = new WPI_TalonFX(Constants.LEFT_FRONT);
    leftBack = new WPI_TalonFX(Constants.LEFT_BACK);
    leftTop = new WPI_TalonFX(Constants.LEFT_TOP);
    rightFront = new WPI_TalonFX(Constants.RIGHT_FRONT);
    rightBack = new WPI_TalonFX(Constants.RIGHT_BACK);
    rightTop = new WPI_TalonFX(Constants.RIGHT_TOP);

    leftTop.setInverted(false);
    leftFront.setInverted(true);
    leftBack.setInverted(true);
    rightFront.setInverted(false);
    rightBack.setInverted(false);
    rightTop.setInverted(true);
    
    //sets master motors and slave motors
    leftBack.follow(leftFront);
    leftTop.follow(leftFront);
    rightBack.follow(rightFront);
    rightTop.follow(rightFront);

    //inverts one side so the robot goes in one dcvirection
    //final boolean inversion = true;
 

    //assigns controller groups
    driveLeft = new SpeedControllerGroup(leftFront, leftBack, leftTop);
    driveRight = new SpeedControllerGroup(rightFront, rightBack, rightTop);

    //assigns values to differential drive
    myRobot = new DifferentialDrive(driveLeft, driveRight);
    
  }

  @Override
  public void periodic() {

  }
  //tank drive style
  public synchronized void manualDrive(double leftVal, double rightVal) {
    if (leftVal < Constants.DEADBAND) {
      leftVal = 0;
    }
    if (rightVal < Constants.DEADBAND) {
      leftVal = 0;
    }

    myRobot.tankDrive(leftVal*Constants.MAX_DRIVETRAIN_MOTOR_POWER, rightVal*Constants.MAX_DRIVETRAIN_MOTOR_POWER);
  }
  //arcade drive style
  public synchronized void arcadeDrive(double xVal, double yVal) {
    if (Math.abs(xVal) < Constants.DEADBAND) {
      xVal = 0;
    }
    if (Math.abs(yVal) < Constants.DEADBAND) {
      yVal = 0;
    }
    myRobot.arcadeDrive(xVal*Constants.MAX_DRIVETRAIN_MOTOR_POWER, yVal*Constants.MAX_DRIVETRAIN_MOTOR_POWER);
  }
}
