/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.TestingDashboard;


public class Motor1 extends SubsystemBase {
  private static Motor1 m_motor1;
  private Talon m_motor;

  /**
   * Creates a new Motor1.
   */
  private Motor1() {
    m_motor = new Talon(RobotMap.M2_Motor);
  }

  public static Motor1 getInstance() {
    if (m_motor1 == null) {
      m_motor1 = new Motor1();
      TestingDashboard.getInstance().registerSubsystem(m_motor1, "Motor1");
    }
    return m_motor1;
  }

  public void spin(double speed) {
    m_motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
