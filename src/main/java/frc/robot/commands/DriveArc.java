// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveArc extends CommandBase {
  private final Drivetrain m_drive;
  private final double m_radians;
  private final double m_radius;
  private final boolean m_rightDom;
  private final double m_speedRatio;
  private final double m_speed;

  // x*(r-R)/(r+R)

  /**
   * Creates a new DriveDistance. This command will drive your your robot for a desired distance at
   * a desired speed.
   *
   * @param speed The speed at which the robot will drive
   * @param inches The number of inches the robot will drive
   * @param drive The drivetrain subsystem on which this command will run
   */
  public DriveArc(double speed, double arcRadians, double arcRadius, boolean rightDominant, Drivetrain drive) {
    m_radians = arcRadians;
    m_radius = arcRadius;
    m_speed = speed;
    m_drive = drive;
    m_rightDom = rightDominant;
    m_speedRatio = (arcRadius - Constants.robotRadius)/(arcRadius + Constants.robotRadius);
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    System.out.println(m_speedRatio);
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_rightDom){
      m_drive.tankDrive(m_speed * m_speedRatio, m_speed);
    }
    else{
      m_drive.tankDrive(m_speed, m_speed * m_speedRatio);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    return Math.abs(m_drive.getAverageDistanceInch()) >= m_radius * m_radians;
  }
}
