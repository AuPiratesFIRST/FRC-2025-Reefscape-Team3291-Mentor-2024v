package frc.robot.lib.config;

import edu.wpi.first.math.geometry.Rotation2d;

public class SwerveModuleConfig {
   // Used to identify the module
   public final int moduleId;

   // CAN IDs for the drive motor, turning motor, and absolute encoder
   public final int driveMotorId;
   public final boolean driveMotorInverted;

   public final double drivingMotorKPositionFactor;

   public final double drivingMotorKVelocityFactor;

   public final double drivingMotorkP;

   public final double drivingMotorkI;

   public final double drivingMotorkD;

   public final double drivingMotorkFF;

   public final int turningMotorId;
   public final boolean turningMotorInverted;

   public final double turningEncoderKPositionFactor;

   public final double turningEncoderKVelocityFactor;

   public final double turningMotorkP;

   public final double turningMotorkI;

   public final double turningMotorkD;

   public final double turningMotorkFF;

   public final int absoluteEncoderId;
   public final boolean absoluteEncoderInverted;

   // Angle offset of the module
   public final Rotation2d offset;

   // Multiplier for the angle of the module
   public final double angleMultipler;

   /* 
    * Constructor for the SwerveModuleConfig class
    * 
    * @param moduleId The ID of the module
    * @param driveMotorId The CAN ID of the drive motor
    * @param turningMotorId The CAN ID of the turning motor
    * @param absoluteEncoderId The CAN ID of the absolute encoder
    * @param offset The angle offset of the module
    * @param angleMultipler The multiplier for the angle of the module
    */
   public SwerveModuleConfig(
      int moduleId, 
      int driveMotorId,
      boolean driveMotorInverted,
      int turningMotorId, 
      boolean turningMotorInverted,
      int absoluteEncoderId, 
      boolean absoluteEncoderInverted,
      Rotation2d offset,
      double angleMultipler,
      double drivingMotorKPositionFactor,
      double drivingMotorKVelocityFactor,
      double drivingMotorkP,
      double drivingMotorkI,
      double drivingMotorkD,
      double drivingMotorkFF,
      double turningEncoderKPositionFactor,
      double turningEncoderKVelocityFactor,
      double turningMotorkP,
      double turningMotorkI,
      double turningMotorkD,
      double turningMotorkFF
   ) {
      this.moduleId = moduleId;

      this.driveMotorId = driveMotorId;
      this.driveMotorInverted = driveMotorInverted;
      this.drivingMotorKPositionFactor = drivingMotorKPositionFactor;
      this.drivingMotorKVelocityFactor = drivingMotorKVelocityFactor;
      this.drivingMotorkP = drivingMotorkP;
      this.drivingMotorkI = drivingMotorkI;
      this.drivingMotorkD = drivingMotorkD;
      this.drivingMotorkFF = drivingMotorkFF;

      this.turningMotorId = turningMotorId;
      this.turningMotorInverted = turningMotorInverted;
      this.turningEncoderKPositionFactor = turningEncoderKPositionFactor;
      this.turningEncoderKVelocityFactor = turningEncoderKVelocityFactor;
      this.turningMotorkP = turningMotorkP;
      this.turningMotorkI = turningMotorkI;
      this.turningMotorkD = turningMotorkD;
      this.turningMotorkFF = turningMotorkFF;
      
      this.absoluteEncoderId = absoluteEncoderId;
      this.absoluteEncoderInverted = absoluteEncoderInverted;

      this.offset = offset;
      this.angleMultipler = angleMultipler; 
   }
}
