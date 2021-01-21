/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.KrystalSub;


public class KrystalRightCommand extends CommandBase {
  /**
   * Creates a new KrystalRightCommand.
   */
  private static KrystalSub right;
  private static boolean krystalStatus = false;

  public KrystalRightCommand (KrystalSub subsystem, boolean krystalStatus) {
    // Use addRequirements() here to declare subsystem dependencies.
    right = subsystem;
    addRequirements(right);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    krystalStatus = true;
    right.moveRight(krystalStatus);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    krystalStatus = false;
    right.moveRight(krystalStatus);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
