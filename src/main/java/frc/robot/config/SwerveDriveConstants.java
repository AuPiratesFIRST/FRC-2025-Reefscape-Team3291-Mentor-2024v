package frc.robot.config;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import frc.robot.lib.config.SwerveModuleConfig;

public class SwerveDriveConstants {
        private SwerveDriveConstants() {
        }

        /*
         * The width of the robot from the center of the left wheel to the center of the
         * right wheel.
         * 
         * UPDATE THIS VALUE TO MATCH YOUR ROBOT!
         */
        private static final double TRACK_WIDTH = Units.inchesToMeters(23.5);

        // The half of the track width
        private static final double HALF_TRACK_WIDTH = TRACK_WIDTH / 2.0;

        /*
         * The length of the robot from the center of the front wheel to the center of
         * the back wheel.
         * 
         * UPDATE THIS VALUE TO MATCH YOUR ROBOT!
         */
        private static final double WHEEL_BASE = Units.inchesToMeters(23.5);

        // The half of the wheel base
        private static final double HALF_WHEEL_BASE = WHEEL_BASE / 2.0;

        /*
         * The location of the modules on the robot as a Translation2d. The angle is the
         * angle of the module relative to the front of the robot. In this coordinate
         * system, the x-axis is positive in the forward direction and the y-axis is
         * positive to the left.
         * 
         * +x is forward, -x is backward
         * +y is left, -y is right
         * +z is up, -z is down
         * 
         * See coordinate system here:
         * https://docs.wpilib.org/en/stable/docs/software/basic-programming/coordinate-
         * system.html#wpilib-coordinate-system
         */
        public static final Translation2d FRONT_LEFT_WHEEL_KINEMATICS = new Translation2d(
                        HALF_WHEEL_BASE,
                        HALF_TRACK_WIDTH);

        public static final Translation2d FRONT_RIGHT_WHEEL_KINEMATICS = new Translation2d(
                        HALF_WHEEL_BASE,
                        -HALF_TRACK_WIDTH);

        public static final Translation2d BACK_LEFT_WHEEL_KINEMATICS = new Translation2d(
                        -HALF_WHEEL_BASE,
                        HALF_TRACK_WIDTH);

        public static final Translation2d BACK_RIGHT_WHEEL_KINEMATICS = new Translation2d(
                        -HALF_WHEEL_BASE,
                        -HALF_TRACK_WIDTH);

        // The Front Left Module Configuration
        private static final class FrontLeftModuleConfig {
                public static final int MODULE_ID = 0;

                public static final int DRIVE_MOTOR = 1;
                public static final boolean DRIVE_MOTOR_INVERTED = false;

                public static final double DRIVE_ENCODER_K_POSITION_FACTOR = 1.0;
                public static final double DRIVE_ENCODER_K_VELOCITY_FACTOR = 1.0;

                public static final double DRIVE_MOTOR_K_P = 1.0;
                public static final double DRIVE_MOTOR_K_I = 1.0;
                public static final double DRIVE_MOTOR_K_D = 1.0;
                public static final double DRIVE_MOTOR_K_FF = 1.0;

                public static final int TURNING_MOTOR = 2;
                public static final boolean TURNING_MOTOR_INVERTED = false;

                public static final double TURNING_ENCODER_K_POSITION_FACTOR = 1.0;
                public static final double TURNING_ENCODER_K_VELOCITY_FACTOR = 1.0;

                public static final double TURNING_MOTOR_K_P = 1.0;
                public static final double TURNING_MOTOR_K_I = 1.0;
                public static final double TURNING_MOTOR_K_D = 1.0;
                public static final double TURNING_MOTOR_K_FF = 1.0;
                
                
                public static final int ABSOLUTE_ENCODER = 3;
                public static final boolean ABSOLUTE_ENCODER_INVERTED = false;
                
                public static final Rotation2d OFFSET = Rotation2d.fromDegrees(45);
                public static final double ANGLE_MULTIPLIER = 1.0;

                private FrontLeftModuleConfig() {
                }
        }

        /*
         * The Front Left Module Configuration.   This is to keep
         * the configuration of the modules in one place.
         */
        public static final SwerveModuleConfig FRONT_LEFT_MODULE = new SwerveModuleConfig(
                        FrontLeftModuleConfig.MODULE_ID,
                        FrontLeftModuleConfig.DRIVE_MOTOR,
                        FrontLeftModuleConfig.DRIVE_MOTOR_INVERTED,
                        FrontLeftModuleConfig.TURNING_MOTOR,
                        FrontLeftModuleConfig.TURNING_MOTOR_INVERTED,
                        FrontLeftModuleConfig.ABSOLUTE_ENCODER,
                        FrontLeftModuleConfig.ABSOLUTE_ENCODER_INVERTED,
                        FrontLeftModuleConfig.OFFSET,
                        FrontLeftModuleConfig.ANGLE_MULTIPLIER,
                        FrontLeftModuleConfig.DRIVE_ENCODER_K_POSITION_FACTOR,
                        FrontLeftModuleConfig.DRIVE_ENCODER_K_VELOCITY_FACTOR,
                        FrontLeftModuleConfig.DRIVE_MOTOR_K_P,
                        FrontLeftModuleConfig.DRIVE_MOTOR_K_I,
                        FrontLeftModuleConfig.DRIVE_MOTOR_K_D,
                        FrontLeftModuleConfig.DRIVE_MOTOR_K_FF,
                        FrontLeftModuleConfig.TURNING_ENCODER_K_POSITION_FACTOR,
                        FrontLeftModuleConfig.TURNING_ENCODER_K_VELOCITY_FACTOR,
                        FrontLeftModuleConfig.TURNING_MOTOR_K_P,
                        FrontLeftModuleConfig.TURNING_MOTOR_K_I,
                        FrontLeftModuleConfig.TURNING_MOTOR_K_D,
                        FrontLeftModuleConfig.TURNING_MOTOR_K_FF);

        // The Front Right Module Configuration
        private static final class FrontRightModuleConfig {
                public static final int MODULE_ID = 1;
                
                public static final int DRIVE_MOTOR = 4;
                public static final boolean DRIVE_MOTOR_INVERTED = false;

                public static final double DRIVE_ENCODER_K_POSITION_FACTOR = 1.0;
                public static final double DRIVE_ENCODER_K_VELOCITY_FACTOR = 1.0;

                public static final double DRIVE_MOTOR_K_P = 1.0;
                public static final double DRIVE_MOTOR_K_I = 1.0;
                public static final double DRIVE_MOTOR_K_D = 1.0;
                public static final double DRIVE_MOTOR_K_FF = 1.0;

                public static final int TURNING_MOTOR = 5;
                public static final boolean TURNING_MOTOR_INVERTED = false;

                public static final double TURNING_ENCODER_K_POSITION_FACTOR = 1.0;
                public static final double TURNING_ENCODER_K_VELOCITY_FACTOR = 1.0;

                public static final double TURNING_MOTOR_K_P = 1.0;
                public static final double TURNING_MOTOR_K_I = 1.0;
                public static final double TURNING_MOTOR_K_D = 1.0;
                public static final double TURNING_MOTOR_K_FF = 1.0;
                

                public static final int ABSOLUTE_ENCODER = 6;
                public static final boolean ABSOLUTE_ENCODER_INVERTED = false;

                public static final Rotation2d OFFSET = Rotation2d.fromDegrees(45);
                public static final double ANGLE_MULTIPLIER = 1.0;

                private FrontRightModuleConfig() {
                }
        }

        /*
         * The Front Right Module Configuration.   This is to keep
         * the configuration of the modules in one place.
         */
        public static final SwerveModuleConfig FRONT_RIGHT_MODULE = new SwerveModuleConfig(
                        FrontRightModuleConfig.MODULE_ID,
                        FrontRightModuleConfig.DRIVE_MOTOR,
                        FrontRightModuleConfig.DRIVE_MOTOR_INVERTED,
                        FrontRightModuleConfig.TURNING_MOTOR,
                        FrontRightModuleConfig.TURNING_MOTOR_INVERTED,
                        FrontRightModuleConfig.ABSOLUTE_ENCODER,
                        FrontRightModuleConfig.ABSOLUTE_ENCODER_INVERTED,
                        FrontRightModuleConfig.OFFSET,
                        FrontRightModuleConfig.ANGLE_MULTIPLIER,
                        FrontRightModuleConfig.DRIVE_ENCODER_K_POSITION_FACTOR,
                        FrontRightModuleConfig.DRIVE_ENCODER_K_VELOCITY_FACTOR,
                        FrontRightModuleConfig.DRIVE_MOTOR_K_P,
                        FrontRightModuleConfig.DRIVE_MOTOR_K_I,
                        FrontRightModuleConfig.DRIVE_MOTOR_K_D,
                        FrontRightModuleConfig.DRIVE_MOTOR_K_FF,
                        FrontRightModuleConfig.TURNING_ENCODER_K_POSITION_FACTOR,
                        FrontRightModuleConfig.TURNING_ENCODER_K_VELOCITY_FACTOR,
                        FrontRightModuleConfig.TURNING_MOTOR_K_P,
                        FrontRightModuleConfig.TURNING_MOTOR_K_I,
                        FrontRightModuleConfig.TURNING_MOTOR_K_D,
                        FrontRightModuleConfig.TURNING_MOTOR_K_FF);

        // The Back Left Module Configuration
        public static final class BackLeftModuleConfig {
                public static final int MODULE_ID = 2;

                public static final int DRIVE_MOTOR = 7;
                public static final boolean DRIVE_MOTOR_INVERTED = false;

                public static final double DRIVE_ENCODER_K_POSITION_FACTOR = 1.0;
                public static final double DRIVE_ENCODER_K_VELOCITY_FACTOR = 1.0;

                public static final double DRIVE_MOTOR_K_P = 1.0;
                public static final double DRIVE_MOTOR_K_I = 1.0;
                public static final double DRIVE_MOTOR_K_D = 1.0;
                public static final double DRIVE_MOTOR_K_FF = 1.0;

                public static final int TURNING_MOTOR = 8;
                public static final boolean TURNING_MOTOR_INVERTED = false;

                public static final double TURNING_ENCODER_K_POSITION_FACTOR = 1.0;
                public static final double TURNING_ENCODER_K_VELOCITY_FACTOR = 1.0;

                public static final double TURNING_MOTOR_K_P = 1.0;
                public static final double TURNING_MOTOR_K_I = 1.0;
                public static final double TURNING_MOTOR_K_D = 1.0;
                public static final double TURNING_MOTOR_K_FF = 1.0;
                
                
                public static final int ABSOLUTE_ENCODER = 9;
                public static final boolean ABSOLUTE_ENCODER_INVERTED = false;

                public static final Rotation2d OFFSET = Rotation2d.fromDegrees(45);
                public static final double ANGLE_MULTIPLIER = 1.0;

                private BackLeftModuleConfig() {
                }
        }

        /*
         * The Back Left Module Configuration.   This is to keep
         * the configuration of the modules in one place.
         */
        public static final SwerveModuleConfig BACK_LEFT_MODULE = new SwerveModuleConfig(
                        BackLeftModuleConfig.MODULE_ID,
                        BackLeftModuleConfig.DRIVE_MOTOR,
                        BackLeftModuleConfig.DRIVE_MOTOR_INVERTED,
                        BackLeftModuleConfig.TURNING_MOTOR,
                        BackLeftModuleConfig.TURNING_MOTOR_INVERTED,
                        BackLeftModuleConfig.ABSOLUTE_ENCODER,
                        BackLeftModuleConfig.ABSOLUTE_ENCODER_INVERTED,
                        BackLeftModuleConfig.OFFSET,
                        BackLeftModuleConfig.ANGLE_MULTIPLIER,
                        BackLeftModuleConfig.DRIVE_ENCODER_K_POSITION_FACTOR,
                        BackLeftModuleConfig.DRIVE_ENCODER_K_VELOCITY_FACTOR,
                        BackLeftModuleConfig.DRIVE_MOTOR_K_P,
                        BackLeftModuleConfig.DRIVE_MOTOR_K_I,
                        BackLeftModuleConfig.DRIVE_MOTOR_K_D,
                        BackLeftModuleConfig.DRIVE_MOTOR_K_FF,
                        BackLeftModuleConfig.TURNING_ENCODER_K_POSITION_FACTOR,
                        BackLeftModuleConfig.TURNING_ENCODER_K_VELOCITY_FACTOR,
                        BackLeftModuleConfig.TURNING_MOTOR_K_P,
                        BackLeftModuleConfig.TURNING_MOTOR_K_I,
                        BackLeftModuleConfig.TURNING_MOTOR_K_D,
                        BackLeftModuleConfig.TURNING_MOTOR_K_FF);

        // The Back Right Module Configuration
        public static final class BackRightModuleConfig {
                public static final int MODULE_ID = 3;

                public static final int DRIVE_MOTOR = 10;
                public static final boolean DRIVE_MOTOR_INVERTED = false;

                public static final double DRIVE_ENCODER_K_POSITION_FACTOR = 1.0;
                public static final double DRIVE_ENCODER_K_VELOCITY_FACTOR = 1.0;

                public static final double DRIVE_MOTOR_K_P = 1.0;
                public static final double DRIVE_MOTOR_K_I = 1.0;
                public static final double DRIVE_MOTOR_K_D = 1.0;
                public static final double DRIVE_MOTOR_K_FF = 1.0;

                public static final int TURNING_MOTOR = 11;
                public static final boolean TURNING_MOTOR_INVERTED = false;

                public static final double TURNING_ENCODER_K_POSITION_FACTOR = 1.0;
                public static final double TURNING_ENCODER_K_VELOCITY_FACTOR = 1.0;

                public static final double TURNING_MOTOR_K_P = 1.0;
                public static final double TURNING_MOTOR_K_I = 1.0;
                public static final double TURNING_MOTOR_K_D = 1.0;
                public static final double TURNING_MOTOR_K_FF = 1.0;
                
                public static final int ABSOLUTE_ENCODER = 12;
                public static final boolean ABSOLUTE_ENCODER_INVERTED = false;

                public static final Rotation2d OFFSET = Rotation2d.fromDegrees(45);
                public static final double ANGLE_MULTIPLIER = 1.0;

                private BackRightModuleConfig() {
                }
        }

        /*
         * The Back Right Module Configuration.   This is to keep
         * the configuration of the modules in one place.
         */
        public static final SwerveModuleConfig BACK_RIGHT_MODULE = new SwerveModuleConfig(
                        BackRightModuleConfig.MODULE_ID,
                        BackRightModuleConfig.DRIVE_MOTOR,
                        BackRightModuleConfig.DRIVE_MOTOR_INVERTED,
                        BackRightModuleConfig.TURNING_MOTOR,
                        BackRightModuleConfig.TURNING_MOTOR_INVERTED,
                        BackRightModuleConfig.ABSOLUTE_ENCODER,
                        BackRightModuleConfig.ABSOLUTE_ENCODER_INVERTED,
                        BackRightModuleConfig.OFFSET,
                        BackRightModuleConfig.ANGLE_MULTIPLIER,
                        BackRightModuleConfig.DRIVE_ENCODER_K_POSITION_FACTOR,
                        BackRightModuleConfig.DRIVE_ENCODER_K_VELOCITY_FACTOR,
                        BackRightModuleConfig.DRIVE_MOTOR_K_P,
                        BackRightModuleConfig.DRIVE_MOTOR_K_I,
                        BackRightModuleConfig.DRIVE_MOTOR_K_D,
                        BackRightModuleConfig.DRIVE_MOTOR_K_FF,
                        BackRightModuleConfig.TURNING_ENCODER_K_POSITION_FACTOR,
                        BackRightModuleConfig.TURNING_ENCODER_K_VELOCITY_FACTOR,
                        BackRightModuleConfig.TURNING_MOTOR_K_P,
                        BackRightModuleConfig.TURNING_MOTOR_K_I,
                        BackRightModuleConfig.TURNING_MOTOR_K_D,
                        BackRightModuleConfig.TURNING_MOTOR_K_FF); 
}
