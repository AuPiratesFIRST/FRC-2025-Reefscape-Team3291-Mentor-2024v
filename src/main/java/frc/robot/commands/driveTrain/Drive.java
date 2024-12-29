// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.driveTrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveDriveTrain;

public class Drive extends Command {
  private final SwerveDriveTrain swerveDriveTrain;
  private final DoubleSupplier translationSupplier;
  private final DoubleSupplier strafeSupplier;
  private final DoubleSupplier rotationSupplier;
  
  /** Creates a new Drive. */
  public Drive(
    SwerveDriveTrain swerveDriveTrain,
    DoubleSupplier translationSupplier,
    DoubleSupplier strafeSupplier,
    DoubleSupplier rotationSupplier
  ) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.swerveDriveTrain = swerveDriveTrain;
    addRequirements(swerveDriveTrain);

    this.translationSupplier = translationSupplier;
    this.strafeSupplier = strafeSupplier;
    this.rotationSupplier = rotationSupplier;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
