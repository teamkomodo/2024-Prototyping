// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  //defines motors
  private CANSparkMax flywheelMotor1;
  private CANSparkMax flywheelMotor2;
  private CANSparkMax indexerMotor;

  //initializes the motors and resets them to factory defaults
public ShooterSubsystem(){
  flywheelMotor1 = new CANSparkMax(10, MotorType.kBrushless);
  flywheelMotor2 = new CANSparkMax(11, MotorType.kBrushless);
  indexerMotor = new CANSparkMax(0, MotorType.kBrushless);

  flywheelMotor1.restoreFactoryDefaults();
  flywheelMotor2.restoreFactoryDefaults();
  indexerMotor.restoreFactoryDefaults();

}
//moves flywheel motors
public void setFlywheelsSpeed(double percent){
  flywheelMotor1.set(percent); //Spins motor outwards
  flywheelMotor2.set(-percent*1.75); //Spins motor outwards
}

//moves indexer motor
public void setIndexerSpeed(double percent){
  indexerMotor.set(percent);
}
  // // Sets the flywheel motors to given speed
  // public void setFlywheelsSpeed(double percent) {
  //   motor1.set(percent);
  //   motor2.set(-percent);
  // }
}

//PSUEDOCODE
/*
 * Goal: Runs flywheels and indexer to shoot a note
 * How:
 * Indexer moves note to flywheels
 * flywheels spin up to speed to launch note
 * 
 * 
 */