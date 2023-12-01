// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.util.VorTXController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  public static VorTXController con1 = new VorTXController(0);

   public static SparkMAXSub sparksub = new SparkMAXSub(0);
   public static SparkMAXCom spark = new SparkMAXCom(sparksub);

  public static FalconSub falconsub = new FalconSub(1);
  public static FalconCom falcon = new FalconCom(falconsub);

  public static TalonSub talonsub = new TalonSub(2);
  public static TalonCom talon = new TalonCom(talonsub);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
   //  Configure the trigger bindings
    configureBindings();

    //  sparksub.setDefaultCommand(
    //    new RunCommand(
    //      spark::moveStick,
    //      sparksub
    //    )
    //  );

    // falconsub.setDefaultCommand(
    //   new RunCommand(
    //     falcon::moveStick,
    //     falconsub
    //   )
    // );

    talonsub.setDefaultCommand(
      new RunCommand(
        talon::stop,
        talonsub
      )
    );
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
// changed from onTrue to whileTrue
    con1.l2.whileTrue(
      new RunCommand(
        talon::rev, 
        talonsub
      )
    );

    con1.r2.whileTrue(
      new RunCommand(
        talon::start, 
        talonsub
      )
    );

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new InstantCommand();
  }
}
