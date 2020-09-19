/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.TestingDashboard;

public class Motor3 extends SubsystemBase {
  private static Motor3 m_motor3;
  private VictorSP m_motor;
  private Encoder encoder;

  /**
   * Creates a new Motor3.
   */
  private Motor3() {
    m_motor = new VictorSP(RobotMap.M3_Motor);
    encoder = new Encoder(RobotMap.M3_EncoderA, RobotMap.M3_EncoderB);
  }

  public static Motor3 getInstance() {
    if (m_motor3 == null) {
      m_motor3 = new Motor3();
      TestingDashboard.getInstance().registerSubsystem(m_motor3, "Motor3");
    }
    return m_motor3;
  }

  public void spin(double speed) {
    m_motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
