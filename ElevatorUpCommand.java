/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSub;


public class ElevatorUpCommand extends CommandBase {
  /**
   * Creates a new ElevatorUpCommand.
   */
  private static ElevatorSub up;
  private static boolean elevatorStatus = false;

  public ElevatorUpCommand(ElevatorSub subsystem, boolean elevatorStatus) {
    up = subsystem;
    addRequirements(up);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevatorStatus = true;
    up.moveUp(elevatorStatus);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  elevatorStatus = false;
  up.moveUp(elevatorStatus);


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
