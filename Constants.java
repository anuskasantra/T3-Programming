/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * @author Daniel Pearson
 * @version 1/9/2020
 */
public final class Constants {
    //-----------------------------Subsystems-----------------------------//

    //DriveBase
    public static final int LEFT_FRONT = 3;
    public static final int LEFT_BACK = 1;
    public static final int LEFT_TOP = 4;
    public static final int RIGHT_FRONT = 5;
    public static final int RIGHT_BACK = 2; 
    public static final int RIGHT_TOP = 0;
    //Shooter
    //public static final int SHOOTER_MOTOR = 5;
    //Intake
    public static final int INTAKE_MOTOR = 6;
    public static final int LEFTPISTON_A = 1;
    public static final int LEFTPISTON_B = 0;
    //Wheel Spinner
    //public static final int WHEEL_MOTOR = 7;
    //Elevator
    public static final int ELEVATOR_MOTOR = 9;
    //-----------------------------OI-----------------------------//
    public static final int LEFT_JOY = 0;
    public static final int RIGHT_JOY = 1;
    //-----------------------------PID VALUE-----------------------------//
    //DO NOT RUN ANYTHING OFF OF THESE VALUES
    public static final double shooterkP = .1;
    public static final double shooterkI = .01;
    public static final double shooterkD = .001;


	public static final int XBOX_PORT_ID = 0;
	public static final int GEAR_SHIFTER_REVERSE_CHANNEL = 0;
    public static final int GEAR_SHIFTER_FORWARD_CHANNEL = 0;

    public static final double MAX_DRIVETRAIN_MOTOR_POWER = .7;
    public static final double DEADBAND = 0.05;
    //shooter motors
	public static final int TOP_FLYWHEEL = 0;
    public static final int BOTTOM_FLYWHEEL = 0;

    //elevator
    public static final double ELEVATOR_MAX_SPEED = .5;
    public static final int COMPRESSOR_PORT_ID = 9;
    
    //glock PID constants
    public static final int GLOCK_P = 1;
    public static final int GLOCK_I = 1;
    public static final int GLOCK_D = 1;
    public static final int GLOCK_INTEGRAL = 1;
    public static final int GLOCK_PREVIOUS_ERROR = 1;
    public static final int GLOCK_SETPOINT = 1;

    //hubble constants
    public static final int LEFT = 6;
    public static final int RIGHT = 8;
    public static final double HUBBLE_MAX_POWER = 0.5;

    //krystal constants
    public static final int SIDE = 7;
    public static final double SIDE_MAX_POWER = 0.7;



    


}