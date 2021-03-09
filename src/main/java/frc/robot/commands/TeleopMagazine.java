package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotConfig;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Magazine;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//spin magazine on xbox input
public class TeleopMagazine extends CommandBase {
    public TeleopMagazine() {
        addRequirements(Magazine.getInstance());
    }

    @Override
    public void initialize() {
        Magazine.getInstance().stop();
    }

    @Override
    public void execute() {
        boolean runTop = OI.getINSTANCE().getXboxRightBumper() && !Robot.getLinebreakTop().lineBroken();
        boolean runBottom = OI.getINSTANCE().getXboxRightBumper() && !(Robot.getLinebreakBottom().lineBroken() && Robot.getLinebreakTop().lineBroken());
        Magazine.getInstance().run(runTop, false, runBottom, false);
    }

    @Override
    public void end(boolean interrupted) {
        Magazine.getInstance().stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}