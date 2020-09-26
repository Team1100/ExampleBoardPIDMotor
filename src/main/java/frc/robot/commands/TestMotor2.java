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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestMotor2 extends CommandBase {
  Motor2 motor;
  private double inputSpeed;
  private Timer timer;
  private double period;
  /**
   * Creates a new TestMotor2.
   */
  public TestMotor2() {
    // Use addRequirements() here to declare subsystem dependencies.
    motor = Motor2.getInstance();
    timer = new Timer();
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
    inputSpeed = -1;
    timer.start();
    period = SmartDashboard.getNumber("motorPeriod", 1.0);
    motor.spin(inputSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.hasPeriodPassed(period)) {
      inputSpeed += 0.1;
      motor.spin(inputSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motor.spin(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean finished = inputSpeed == 1.0;
    return finished;
  }
}
