// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.config.SwerveDriveConstants;
import frc.robot.subsystems.swerveDriveLib.SwerveModule;

public class SwerveDriveTrain extends SubsystemBase {

  private SwerveModule[] swerveModules;
  private SwerveDriveKinematics swerveDriveKinematics;
  private AHRS gyro;
  private SwerveDriveOdometry swerveDriveOdometry;

  /** Creates a new SwerveDriveTrain. */
  public SwerveDriveTrain() {
    // Create a new SwerveModule array with the module locations specified in
    swerveModules = new SwerveModule[4];

    // Create a new SwerveDriveKinematics object with the module locations
    // specified in SwerveDriveConstants
    swerveDriveKinematics = new SwerveDriveKinematics(
        SwerveDriveConstants.FRONT_LEFT_WHEEL_KINEMATICS,
        SwerveDriveConstants.FRONT_RIGHT_WHEEL_KINEMATICS,
        SwerveDriveConstants.BACK_LEFT_WHEEL_KINEMATICS,
        SwerveDriveConstants.BACK_RIGHT_WHEEL_KINEMATICS);

    // Create a new AHRS object for the gyro
    gyro = new AHRS();

    /*
     * Create a new SwerveDriveOdometry object with the module locations, 
     * current angle of the gyro, and the SwerveDriveKinematics object
     */
    swerveDriveOdometry = new SwerveDriveOdometry(
        swerveDriveKinematics,
        gyro.getRotation2d(),
        new SwerveModulePosition[]{
          new SwerveModulePosition(),
          new SwerveModulePosition(),
          new SwerveModulePosition(),
          new SwerveModulePosition()
        });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    swerveDriveOdometry.update(
        gyro.getRotation2d(),
        getModulePositions());
  }

  public void drive() {
    double xSpeed = Units.inchesToMeters(14);
    double ySpeed = Units.inchesToMeters(14);
    double rotateSpeed = Units.degreesToRadians(30);

    ChassisSpeeds testSpeeds = new ChassisSpeeds(
        xSpeed,
        ySpeed,
        rotateSpeed);

    SwerveModuleState[] moduleStates = swerveDriveKinematics.toSwerveModuleStates(testSpeeds);

    for (int i = 0; i < swerveModules.length; i++) {
      swerveModules[i].setDesiredState(moduleStates[i]);
    }
  }

  public SwerveModulePosition[] getModulePositions() {
    return new SwerveModulePosition[]{
      new SwerveModulePosition(swerveModules[0].getDistance(), swerveModules[0].getAngle()),
      new SwerveModulePosition(swerveModules[1].getDistance(), swerveModules[1].getAngle()),
      new SwerveModulePosition(swerveModules[2].getDistance(), swerveModules[2].getAngle()),
      new SwerveModulePosition(swerveModules[3].getDistance(), swerveModules[3].getAngle())
    };
  }
}
