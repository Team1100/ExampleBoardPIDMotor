/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.TestingDashboard;
import frc.robot.subsystems.Motor1;


public class TestMotor1 extends CommandBase {
  Motor1 motor;
  /**
   * Creates a new TestMotor1.
   */
  public TestMotor1() {
    // Use addRequirements() here to declare subsystem dependencies.
    motor = Motor1.getInstance();
    addRequirements(motor);
  }

  public static void registerWithTestingDashboard() {
    Motor1 motor1 = Motor1.getInstance();
    TestMotor1 cmd = new TestMotor1();
    TestingDashboard.getInstance().registerCommand(motor1, "Basic", cmd);
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
