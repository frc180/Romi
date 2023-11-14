// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousDistance extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(Drivetrain drivetrain) {
    // new TurnDegrees(0.5, 360, drivetrain).repeatedly())
    // new RepeatCommand(new TurnDegrees(0.5, 360, drivetrain)))
    
    addCommands(
      //new DriveArc(.5, Math.PI, 6, false, drivetrain)
        new DriveDistance(0.5, 11.5, drivetrain),
        new TurnDegrees(0.5, 70, drivetrain),
        new DriveDistance(0.5, 10.5, drivetrain),
        new TurnDegrees(-0.5, 70, drivetrain),
        new DriveDistance(0.5, 8, drivetrain),
        new TurnDegrees(-0.5, 60, drivetrain),
        new DriveDistance(0.5, 16, drivetrain),
        new TurnDegrees(0.5, 80, drivetrain),
        new DriveDistance(0.5, 11, drivetrain),
        new TurnDegrees(0.5, 70, drivetrain),
        new DriveDistance(0.5, 20.5, drivetrain),
        new TurnDegrees(-0.5, 35, drivetrain),
        new DriveDistance(0.75, 15.25, drivetrain)
    );
  }
}
