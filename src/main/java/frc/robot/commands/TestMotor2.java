/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.TestingDashboard;
import frc.robot.subsystems.Motor2;

public class TestMotor2 extends CommandBase {
  Motor2 motor;
  /**
   * Creates a new TestMotor2.
   */
  public TestMotor2() {
    // Use addRequirements() here to declare subsystem dependencies.
    motor = Motor2.getInstance();
    addRequirements(motor);
  }

  public static void registerWithTestingDashboard() {
    Motor2 motor2 = Motor2.getInstance();
    TestMotor2 cmd = new TestMotor2();
    TestingDashboard.getInstance().registerCommand(motor2, "Basic", cmd);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
