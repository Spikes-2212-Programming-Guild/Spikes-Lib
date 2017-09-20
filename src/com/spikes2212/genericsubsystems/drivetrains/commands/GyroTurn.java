package com.spikes2212.genericsubsystems.drivetrains.commands;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import edu.wpi.first.wpilibj.command.Command;

import java.util.function.Supplier;

public class GyroTurn extends Command {

    private Supplier<Double> absoluteLeftSpeedSupplier;
    private Supplier<Double> absoluteRightSpeedSupplier;
    private Supplier<Double> targetDegreeSupplier;
    private Supplier<Double> currentDegreeSupplier;

    private TankDrivetrain drivetrain;
    public GyroTurn(TankDrivetrain drivetrain,Supplier<Double> absoluteLeftSpeedSupplier, Supplier<Double> absoluteRightSpeedSupplier,
                    Supplier<Double> targetDegreeSupplier, Supplier<Double> currentDegreeSupplier) {
        this.drivetrain = drivetrain;
        this.absoluteLeftSpeedSupplier = absoluteLeftSpeedSupplier;
        this.absoluteRightSpeedSupplier = absoluteRightSpeedSupplier;
        this.currentDegreeSupplier = currentDegreeSupplier;
        this.targetDegreeSupplier = targetDegreeSupplier;
    }

    public GyroTurn(TankDrivetrain drivetrain, double absoluteLeftSpeed, double absoluteRightSpeed,
                    double targetDegree, Supplier<Double> currentDegreeSupplier ) {
        this(drivetrain, ()->absoluteLeftSpeed, ()->absoluteRightSpeed, ()->targetDegree, currentDegreeSupplier);
    }
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
