// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

public class Shooter extends SubsystemBase {
  static TalonFX leftFalcon;
  static TalonFX rightFalcon;
  
  //** Creates a new ExampleSubsystem. */
  public Shooter(int leftShooterID, int rightShooterID) {
    leftFalcon = new TalonFX(leftShooterID);
    rightFalcon = new TalonFX(rightShooterID);
    leftFalcon.setNeutralMode(NeutralMode.Coast);
    rightFalcon.setNeutralMode(NeutralMode.Coast);
    leftFalcon.setInverted(true);
    rightFalcon.follow(leftFalcon);
  }

  public void move(double percentSpeed){
    leftFalcon.set(TalonFXControlMode.PercentOutput, -percentSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
