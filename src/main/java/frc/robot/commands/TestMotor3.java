/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.TestingDashboard;
import frc.robot.subsystems.Motor3;

public class TestMotor3 extends CommandBase {
  Motor3 motor;
  /**
   * Creates a new TestMotor3.
   */
  public TestMotor3() {
    // Use addRequirements() here to declare subsystem dependencies.
    motor = Motor3.getInstance();
    addRequirements(motor);
  }

  public static void registerWithTestingDashboard() {
    Motor3 motor3 = Motor3.getInstance();
    TestMotor3 cmd = new TestMotor3();
    TestingDashboard.getInstance().registerCommand(motor3, "Basic", cmd);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motor.spin(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motor.spin(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
