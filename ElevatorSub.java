/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import frc.robot.commands.ElevatorDefault;

public class ElevatorSub extends SubsystemBase {
  /**
   * Creates a new ElevatorSub. Nicole Calderon was here swag moneyyy jdflkjkldsjgkl
   */
  private static WPI_TalonSRX motor;
  
  public ElevatorSub() {
    motor = new WPI_TalonSRX(Constants.ELEVATOR_MOTOR);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void moveUp(boolean elevatorStatus) {
  if(elevatorStatus){
    motor.set(Constants.ELEVATOR_MAX_SPEED);
  }
  else{
    motor.set(0);
  }
  }
  public void stop(){
    motor.set(0);
  }
  public void moveDown(boolean elevatorStatus) {
    if(elevatorStatus){
      motor.set(Constants.ELEVATOR_MAX_SPEED*-1);
    }
    else{
      motor.set(0);
    }

}
}
