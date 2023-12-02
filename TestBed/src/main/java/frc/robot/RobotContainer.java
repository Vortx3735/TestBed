// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/*
Right back drive = 1
left front drive = 2
left back drive = 3
index motor = 4
Shooter left is 5
shooter right = 6
turret rotation = 7
intake = 8
right front drive = 10
left climper = 15
climber right = 17
PDP = 0
 * 
 */

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
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
/*
Right back drive = 1
left front drive = 2
left back drive = 3
index motor = 4
Shooter left is 5
shooter right = 6
turret rotation = 7
intake = 8
right front drive = 10
left climper = 15
climber right = 17
PDP = 0
 * 
 */
  public static FalconSub RightBackMotor = new FalconSub(1);
  public static FalconCom RightBack = new FalconCom(RightBackMotor);

  public static FalconSub LeftFrontMotor = new FalconSub(2);
  public static FalconCom LeftFront = new FalconCom(LeftFrontMotor);

  public static FalconSub LeftBackMotor = new FalconSub(3);
  public static FalconCom LeftBack = new FalconCom(LeftBackMotor);

  public static FalconSub RightFrontMotor = new FalconSub(10);
  public static FalconCom RightFront = new FalconCom(RightFrontMotor);

   public static TalonSub talonsub = new TalonSub(4);
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

    RightBackMotor.setDefaultCommand(
      new InstantCommand(
        RightBack::stop,
        RightBackMotor
      )
    );
    RightFrontMotor.setDefaultCommand(
      new InstantCommand(
        RightFront::stop,
        RightFrontMotor
      )
    );
    LeftBackMotor.setDefaultCommand(
      new InstantCommand(
        LeftBack::stop,
        LeftBackMotor
      )
    );
    LeftFrontMotor.setDefaultCommand(
      new InstantCommand(
        LeftFront::stop,
        LeftFrontMotor
      )
    );



    //  talonsub.setDefaultCommand(
    //    new RunCommand(
    //      talon::stop,
    //      talonsub
    //    )
    //  );
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
    
    //  con1.l2.whileTrue(
    //    new RunCommand(
    //      talon::rev, 
    //      talonsub
    //    )
    //  );

    //  con1.r2.whileTrue(
    //    new RunCommand(
    //      talon::start, 
    //      talonsub
    //    )
    //   );

/*
Right back drive = 1
left front drive = 2
left back drive = 3
index motor = 4
Shooter left is 5
shooter right = 6
turret rotation = 7
intake = 8
right front drive = 10
left climper = 15
climber right = 17
PDP = 0
 * 
 */
    con1.triangle.whileTrue(
      new ParallelCommandGroup(
          new RunCommand(
          RightFront::rev,
          RightFrontMotor
        ),
        new RunCommand(
          RightBack::rev,
          RightBackMotor
        ),
        new RunCommand(
          LeftFront::start,
          LeftFrontMotor
        ),
        new RunCommand(
          LeftBack::start,
          LeftBackMotor
        )
      )
    );
      
    con1.cross.whileTrue(
      new ParallelCommandGroup(
          new RunCommand(
          RightFront::start,
          RightFrontMotor
        ),
        new RunCommand(
          RightBack::start,
          RightBackMotor
        ),
        new RunCommand(
          LeftFront::rev,
          LeftFrontMotor
        ),
        new RunCommand(
          LeftBack::rev,
          LeftBackMotor
        )
      )

    );
      
    con1.square.whileTrue(
      new ParallelCommandGroup(
          new RunCommand(
          RightFront::start,
          RightFrontMotor
        ),
        new RunCommand(
          RightBack::start,
          RightBackMotor
        ),
        new RunCommand(
          LeftFront::start,
          LeftFrontMotor
        ),
        new RunCommand(
          LeftBack::start,
          LeftBackMotor
        )
      )

    );
      
    con1.circle.whileTrue(
      new ParallelCommandGroup(
          new RunCommand(
          RightFront::rev,
          RightFrontMotor
        ),
        new RunCommand(
          RightBack::rev,
          RightBackMotor
        ),
        new RunCommand(
          LeftFront::rev,
          LeftFrontMotor
        ),
        new RunCommand(
          LeftBack::rev,
          LeftBackMotor
        )
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
