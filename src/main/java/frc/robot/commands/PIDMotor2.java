/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Motor2;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class PIDMotor2 extends PIDCommand {
  /**
   * Creates a new PIDMotor2.
   */
  public PIDMotor2() {
    super(
        // The controller that the command will use
        new PIDController(3.768, 0, 0),
        // This should return the measurement
        () -> Motor2.getInstance().getSpeed(),
        // This should return the setpoint (can also be a constant)
        () -> 70,
        // This uses the output
        output -> {
          double output_max = 10000;
          double output_min = -10000;
          if (output < output_max && output > output_min) {
            Motor2.getInstance().spin(output/output_max);
          } else if (output > output_max) {
            Motor2.getInstance().spin(1);
          } else if (output < output_min) {
            Motor2.getInstance().spin(-1);
          }
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Motor2.getInstance());
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(5);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
