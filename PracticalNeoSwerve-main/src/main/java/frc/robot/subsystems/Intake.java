
package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;
import static frc.robot.Constants.LauncherConstants.kIntakeSpeed;
import static frc.robot.Constants.LauncherConstants.kLeftIntakeCurrentLimit;
import static frc.robot.Constants.LauncherConstants.kLeftIntakeID;
import static frc.robot.Constants.LauncherConstants.kRightIntakeCurrentLimit;
import static frc.robot.Constants.LauncherConstants.kRightIntakeID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class CANIntake extends SubsystemBase{
    CANSparkMax lIntake;
    CANSparkMax rIntake;

    public CANIntake() {
    lIntake = new CANSparkMax(kLeftIntakeID, MotorType.kBrushless);
    rIntake = new CANSparkMax(kRightIntakeID, MotorType.kBrushless);

    lIntake.setSmartCurrentLimit(kLeftIntakeCurrentLimit);
    rIntake.setSmartCurrentLimit(kRightIntakeCurrentLimit);
    }

    public Command getIntakeNoteCommand() {
        return this.startEnd(
            () -> {
                setleftIntake(kIntakeSpeed);
            },
            () -> {
                stopIntake();
            });
    }


    public void setleftIntake(double speed) {
        lIntake.set(speed);
    }

    public void setRightIntake(double speed) {
        rIntake.set(-speed);
    }


    public void stopIntake() {
        lIntake.set(0);
        rIntake.set(0);
    }

}
