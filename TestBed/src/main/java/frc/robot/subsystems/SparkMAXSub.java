// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SparkMAXSub extends SubsystemBase {
  static CANSparkMax neo;
  
  //** Creates a new ExampleSubsystem. */
  public SparkMAXSub(int ID) {
    neo = new CANSparkMax(ID, MotorType.kBrushless);
    neo.setIdleMode(IdleMode.kBrake);
  }

  public void move(double percentSpeed){
    neo.set(-percentSpeed);
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
