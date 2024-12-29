package frc.robot.subsystems.swerveDriveLib;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.CANcoderConfigurator;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.pathplanner.lib.util.PIDConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import frc.robot.config.NEOConstants;
import frc.robot.lib.config.SwerveModuleConfig;

public class SwerveModule {
    private CANSparkMax driveMotor;
    private RelativeEncoder driveEncoder;
    private SparkPIDController drivePIDController;

    private CANSparkMax turningMotor;
    private RelativeEncoder turningEncoder;
    private SparkPIDController turningPIDController;
    
    // CANCoder object for the absolute encoder
    private CANcoder absoluteEncoder;

    private SwerveModuleConfig config;

    /*
     * Constructor for the SwerveModule class
     * 
     * @param config The configuration of the module
     * 
     */
    public SwerveModule(SwerveModuleConfig config) {
        CANcoderConfigurator absoluteEncoderConfig;
        MagnetSensorConfigs magnetSensorConfig = new MagnetSensorConfigs();

        // Create a new CANSparkMax object for the drive motor
        driveMotor = new CANSparkMax(config.driveMotorId, CANSparkMax.MotorType.kBrushless);

        // Set the motor to the default settings
        driveMotor = configureMotor(driveMotor);

        // Set the motor to the inverted state, if configured so
        driveMotor.setInverted(config.driveMotorInverted);

        driveEncoder = driveMotor.getEncoder();

        drivePIDController = driveMotor.getPIDController();

        driveEncoder.setPositionConversionFactor(config.drivingMotorKPositionFactor);
        driveEncoder.setVelocityConversionFactor(config.drivingMotorKVelocityFactor);

        // Set the PID gains for the drive motor. Note these are example gains, and you
        // may need to tune them for your own robot!
        drivePIDController.setP(config.drivingMotorkP);
        drivePIDController.setI(config.drivingMotorkI);
        drivePIDController.setD(config.drivingMotorkD);
        drivePIDController.setFF(config.drivingMotorkFF);

        // Create a new CANSparkMax object for the turning motor
        turningMotor = new CANSparkMax(config.turningMotorId, CANSparkMax.MotorType.kBrushless);

        // Set the motor to the default settings
        turningMotor = configureMotor(turningMotor);

        // Set the motor to the inverted state, if configured so
        turningMotor.setInverted(config.turningMotorInverted);

        turningEncoder = turningMotor.getEncoder();

        turningPIDController = turningMotor.getPIDController();
        turningPIDController.setFeedbackDevice(turningEncoder);

        // Apply position and velocity conversion factors for the turning encoder. We
        // want these in radians and radians per second to use with WPILib's swerve
        // APIs.
        turningEncoder.setPositionConversionFactor(config.turningEncoderKPositionFactor);
        turningEncoder.setVelocityConversionFactor(config.turningEncoderKVelocityFactor);

        // Enable PID wrap around for the turning motor. This will allow the PID
        // controller to go through 0 to get to the setpoint i.e. going from 350 degrees
        // to 10 degrees will go through 0 rather than the other direction which is a
        // longer route.
        turningPIDController.setPositionPIDWrappingEnabled(true);
        turningPIDController.setPositionPIDWrappingMinInput(0);
        turningPIDController.setPositionPIDWrappingMaxInput(90);
        
        // Set the PID gains for the turning motor. Note these are example gains, and you
        // may need to tune them for your own robot!
        turningPIDController.setP(config.turningMotorkP);
        turningPIDController.setI(config.turningMotorkI);
        turningPIDController.setD(config.turningMotorkD);
        turningPIDController.setFF(config.turningMotorkFF);

        // Create a new CANcoder object for the absolute encoder
        absoluteEncoder = new CANcoder(config.absoluteEncoderId);

        // Set the absolute encoder to the default settings
        absoluteEncoderConfig = absoluteEncoder.getConfigurator();
        absoluteEncoderConfig.apply(new CANcoderConfiguration());
        absoluteEncoderConfig.refresh(magnetSensorConfig);
        absoluteEncoderConfig.apply(magnetSensorConfig
            .withAbsoluteSensorRange(AbsoluteSensorRangeValue.Unsigned_0To1)
            .withSensorDirection(SensorDirectionValue.CounterClockwise_Positive)
        ); 

        this.config = config;

        driveMotor.burnFlash();
        turningMotor.burnFlash();

        driveEncoder.setPosition(0);
        turningEncoder.setPosition(absoluteEncoder.getAbsolutePosition().refresh().getValue() * 360);
    }

    /*
     * Configures the motor with the default settings
     * 
     * @param motor The motor to configure
     * 
     * @return The configured motor
     */
    private CANSparkMax configureMotor(CANSparkMax motor) {
        motor.restoreFactoryDefaults();
        // motor.setSmartCurrentLimit(NEOConstants.CURRENT_LIMIT);
        motor.setOpenLoopRampRate(0.1);
        motor.setClosedLoopRampRate(0.1);
        // motor.enableVoltageCompensationLimit(NEOConstants.SAFE_VOLTAGE_LIMIT);
        motor.enableVoltageCompensation(NEOConstants.SAFE_VOLTAGE_LIMIT);

        return motor;
    }

    /*
     * Gets the ID of the module
     */
    public int getModuleId() {
        return config.moduleId;
    }

    public void setDesiredState(SwerveModuleState desiredState) {
        double driveOutput = desiredState.speedMetersPerSecond;
        double turnOutput = desiredState.angle.getDegrees();

        turningPIDController.setReference(turnOutput, ControlType.kPosition);
        drivePIDController.setReference(driveOutput, ControlType.kVelocity);
    }

    public double getDistance() {
        return driveEncoder.getPosition();
    }

    public Rotation2d getAngle() {
        return Rotation2d.fromDegrees(turningEncoder.getPosition());
    }
}
