/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import frc.robot.commands.GlockPIDCommand;

public class GlockSub extends SubsystemBase {
  private static TalonFX top;
  int integral = Constants.GLOCK_INTEGRAL;
  int previous_error = Constants.GLOCK_PREVIOUS_ERROR;
  int setpoint = Constants.GLOCK_SETPOINT;
  double velocity = top.getSelectedSensorVelocity();
  //private static TalonFX bottom;
  //GlockPIDCommand ugh = new GlockPIDCommand();
  //{ugh.PID();}

  //private final SpeedControllerGroup flywheel;

  public GlockSub() {
    top = new TalonFX(Constants.TOP_FLYWHEEL);
   // bottom = new TalonFX(Constants.BOTTOM_FLYWHEEL);

    //bottom.follow(top);

    //flywheel = new SpeedControllerGroup(bottom, top);

  }

  public void bangBang(boolean glockStatus){
    double error = setpoint - velocity;
    if (error < 10){
      velocity += 0.01;
      top.set(TalonFXControlMode.Velocity, velocity);
      bangBang(true);
    }
    else if (error > 10){
      velocity -= 0.01;
      top.set(TalonFXControlMode.Velocity, velocity);
      bangBang(true);
    }
}

  @Override
  public void periodic() {
  //top.set(ControlMode.PercentOutput, GlockPIDCommand.power);


  }
}
