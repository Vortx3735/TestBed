// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.SparkMAXSub;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class SparkMAXCom extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final SparkMAXSub sparkMax;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SparkMAXCom(SparkMAXSub inputSpark) {
    sparkMax = inputSpark;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sparkMax);
  }

  public void moveStick() {
    if (MathUtil.applyDeadband(-RobotContainer.con1.getRightY(), 0.1) == 0)
    {
      sparkMax.move(0);
    } else
    {
      sparkMax.move(-RobotContainer.con1.getRightY());
    }
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
