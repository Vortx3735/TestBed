// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class TalonSub extends SubsystemBase {
  static TalonSRX talon;
  
  //** Creates a new ExampleSubsystem. */
  public TalonSub(int ID) {
    talon = new TalonSRX(ID);
    talon.setNeutralMode(NeutralMode.Coast);
  }

  public void move(double percentSpeed){
    talon.set(TalonSRXControlMode.PercentOutput, -percentSpeed);
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
