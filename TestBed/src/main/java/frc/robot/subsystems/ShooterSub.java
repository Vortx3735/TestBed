// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

public class ShooterSub extends SubsystemBase {
  static TalonFX falconLeft;
  static TalonFX falconRight;
  
  //** Creates a new ExampleSubsystem. */
  public ShooterSub(int IDLeft, int IDRight) {
    falconLeft = new TalonFX(IDLeft);
    falconRight = new TalonFX(IDRight);

    falconLeft.setNeutralMode(NeutralMode.Coast);
    falconRight.setNeutralMode(NeutralMode.Coast);

    falconLeft.follow(falconRight);
    falconLeft.setInverted(true);
  }

  public void move(double percentSpeed){
    falconRight.set(TalonFXControlMode.PercentOutput, -percentSpeed);
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
