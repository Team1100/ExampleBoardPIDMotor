/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.TestingDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Motor2 extends SubsystemBase {
  private static Motor2 m_motor2;
  WPI_TalonSRX m_motor;
  private Encoder encoder;
  
  /**
   * Creates a new Motor2.
   */
  private Motor2() {
    m_motor = new WPI_TalonSRX(RobotMap.M2_Motor);
    encoder = new Encoder(RobotMap.M2_EncoderA, RobotMap.M2_EncoderB);
  }

  public static Motor2 getInstance() {
    if (m_motor2 == null) {
      m_motor2 = new Motor2();
      TestingDashboard.getInstance().registerSubsystem(m_motor2, "Motor2");
    }
    return m_motor2;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}