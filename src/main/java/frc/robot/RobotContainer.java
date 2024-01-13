package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.ShooterSubsystem;

import static frc.robot.Constants.*;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // Subsystem definitions should be public for auto reasons
  public final ShooterSubsystem shooterSubsystem = new ShooterSubsystem(Constants.FLYWHEEL_1_PORT, Constants.FLYWHEEL_2_PORT);
  public double flywheelSpeed = 0.5;

  private final CommandXboxController driverXBoxController = new CommandXboxController(XBOX_CONTROLLER_PORT);

  // The container for the robot. Contains subsystems, OI devices, and commands
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    
    // Defines buttons on the xbox controller
    Trigger xButton = driverXBoxController.x();
    Trigger yButton = driverXBoxController.y();

    // Left Bumper starts outtake (sets flywheels speed) 
    // leftBumper.onTrue(Commands.runEnd(() -> {
    //     shooterSubsystem.setFlywheelsSpeed(10);
    // }, () -> {
    //     shooterSubsystem.setFlywheelsSpeed(0);
    // }, shooterSubsystem));
    xButton.onTrue(Commands.runOnce(() -> {shooterSubsystem.setFlywheelsSpeed(flywheelSpeed);}));
    xButton.onFalse(Commands.runOnce(() -> {shooterSubsystem.setFlywheelsSpeed(0);}));

    yButton.onTrue(Commands.runOnce(() -> {flywheelSpeed += 0.05;}));
    yButton.onFalse(Commands.runOnce(() -> {flywheelSpeed -= 0.05;}));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}