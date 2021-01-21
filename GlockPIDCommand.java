/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.Constants;
import frc.robot.subsystems.GlockSub;



public class GlockPIDCommand extends CommandBase {
  private static TalonFX top;
  private static GlockSub shoot;
  /*int P = Constants.GLOCK_P;
  int I = Constants.GLOCK_I;
  int D = Constants.GLOCK_D;*/
  int integral = Constants.GLOCK_INTEGRAL;
  int previous_error = Constants.GLOCK_PREVIOUS_ERROR;
  int setpoint = Constants.GLOCK_SETPOINT;
  double velocity = top.getSelectedSensorVelocity();
  //Gyro gyro;
  DifferentialDrive robotDrive;
  private static boolean glockStatus = false;
  public GlockPIDCommand(GlockSub subsystem, boolean glockStatus){
    top = new TalonFX(Constants.TOP_FLYWHEEL); 
    addRequirements(shoot);
}
 
public void setSetpoint(int setpoint)
{
    this.setpoint = setpoint;
}

/*public void PID(){
    double error = setpoint - velocity; // Error = Target - Actual
    this.integral += (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
    double derivative = (error - this.previous_error) / .02;
    this.rcw = P*error + I*this.integral + D*derivative;
}
*/
 
/*public void bangBang(){
    double error = setpoint - velocity;
    if (error < 10){
      velocity += 0.01;
      top.set(TalonFXControlMode.Velocity, velocity);
      bangBang();
    }
    else if (error > 10){
      velocity -= 0.01;
      top.set(TalonFXControlMode.Velocity, velocity);
      bangBang();
    }
}
*/
     


  /**
   * Creates a new GlockPIDCommand.
   */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    glockStatus = true;
    shoot.bangBang(glockStatus);
    //PID();
    //robotDrive.arcadeDrive(0, rcw);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    glockStatus = false;
    shoot.bangBang(glockStatus);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
