// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  //Flywheel motors
  Spark motor1;
  Spark motor2;

  // Indexer motor
  Spark indexer;

  // Creates the motors
  public ShooterSubsystem(int motor1ID, int motor2ID, int indexerID) {
    motor1 = new Spark(motor1ID);
    motor2 = new Spark(motor2ID);
    indexer = new Spark(indexerID);
  }

  // Sets the flywheel motors to given speed
  public void setFlywheelsSpeed(double percent) {
    motor1.set(percent);
    motor2.set(-percent);
  }
  
  // Sets the indexer motor to given speed
  public void setIndexerSpeed(double percent) {
    indexer.set(percent);
  }
}