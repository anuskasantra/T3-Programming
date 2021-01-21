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

//
public class HubbleSub extends SubsystemBase {
  /**
   * Creates a new HubbleSub.
   */
  private static WPI_TalonSRX left;
  private static WPI_TalonSRX right;

  public HubbleSub() {
    left = new WPI_TalonSRX(Constants.LEFT);
    right = new WPI_TalonSRX(Constants.RIGHT);

    right.follow(left);
  }

  public void moveForward(boolean hubbleStatus){
    if(hubbleStatus){
      left.set(Constants.HUBBLE_MAX_POWER);
      right.set(-Constants.HUBBLE_MAX_POWER);
      //if hubble goes the wrong way, multiply the power by negative 1
    }
    else{
      left.set(0);
      right.set(0);
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
