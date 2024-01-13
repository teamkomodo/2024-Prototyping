// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  //Flywheel motors
  CANSparkMax motor1;
  CANSparkMax motor2;

  // Indexer motor
  Spark indexer;

  // Creates the motors
  public ShooterSubsystem(int motor1ID, int motor2ID) {
    motor1 = new CANSparkMax(motor1ID, MotorType.kBrushless);
    motor2 = new CANSparkMax(motor2ID, MotorType.kBrushless);
    //indexer = new Spark(0);
  }

  // Sets the flywheel motors to given speed
  public void setFlywheelsSpeed(double percent) {
    motor1.set(percent);
    motor2.set(-percent);
  }
  
  // Sets the indexer motor to given speed
  // public void setIndexerSpeed(double percent) {
  //   indexer.set(percent);
  // }
}