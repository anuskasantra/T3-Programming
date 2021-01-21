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

public class KrystalSub extends SubsystemBase {
  /**
   * Creates a new KrystalSub.
   */
  private static WPI_TalonSRX side;

  public KrystalSub() {
    side = new WPI_TalonSRX(Constants.SIDE);

  }

  public void moveLeft(boolean krystalStatus) {
    if(krystalStatus){
      side.set(Constants.SIDE_MAX_POWER);
    }
    else{
      side.set(0);
    }
  }

    public void moveRight(boolean krystalStatus) {
      if(krystalStatus){
        side.set(Constants.SIDE_MAX_POWER*-1);
      }
      else{
        side.set(0);
      }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
