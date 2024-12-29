// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.commands.driveTrain.Drive;
import frc.robot.subsystems.SwerveDriveTrain;

public class RobotContainer {
  // Subsystems
  protected SwerveDriveTrain swerveDriveTrain = new SwerveDriveTrain();

  // Operator Interface
  protected CommandJoystick driverJoystick = new CommandJoystick(0);
  protected CommandJoystick operatorJoystick = new CommandJoystick(1);

  // Autonomous Commands
  SendableChooser<Command> autoChooser;

  public RobotContainer() {
    configureBindings();

    autoChooser = AutoBuilder.buildAutoChooser();

    // Put the chooser on the dashboard
    SmartDashboard.putData("Autonomous", autoChooser);
  }

  private void configureBindings() {
    // Bind the driver joystick to the swerve drive train
    swerveDriveTrain.setDefaultCommand(
      new Drive(
        swerveDriveTrain, 
        () -> driverJoystick.getRawAxis(1), 
        () -> driverJoystick.getRawAxis(0), 
        () -> driverJoystick.getRawAxis(4)));
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}
