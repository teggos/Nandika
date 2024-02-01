// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.Supplier;

/** 
 * Drive command. Passes arcade drive inputs to the {@link Drivetrain drivetrain} subsystem.
 */
public class Drive extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drivetrain;
  private final Supplier<Double> m_speedSupplier;
  private final Supplier<Double> m_rotateSupplier;

  /**
   * Creates a new Drive command.
   *
   * @param drivetrain Drivetrain subsystem.
   */
  public Drive(Drivetrain drivetrain, Supplier<Double> speedSupplier, Supplier<Double> rotateSupplier) {
    m_drivetrain = drivetrain;
    m_speedSupplier = speedSupplier;
    m_rotateSupplier = rotateSupplier;
    // Declare drivetrain subsystem dependency.
    addRequirements(drivetrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_speedSupplier.get(), m_rotateSupplier.get());  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Command is run until closed by container
    return false;
  }
}
