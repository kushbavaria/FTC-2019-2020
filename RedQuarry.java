package org.firstinspires.ftc.teamcode;

public class RedQuarry extends AutoMasterClass{
    private ALLIANCE_COLOR allianceColor = ALLIANCE_COLOR.RED;

    @Override
    public void runOpMode() {
        initialize();
        initVuforia();

        try {
            move(0,.3,2);
            pause(.1);
            SKYSTONE_POSITION position = determineSkystonePlacement(allianceColor);
            double inchOff = moveToBlock(allianceColor, position);
            strafe(.3,0,"right",40);
            pause(.1);
            strafe(.3,0,"right",8);
            pause(.1);
            strafe(.3,0,"right", inchOff);
            move(0, -.3, 2);
            pause(.1);
            while (currentAngle() > -90) {
                heartbeat();
                telemetry.addData("Status", currentAngle());
                telemetry.update();
                turn("left", .3);
            }
            halt();
            pause(.1);
            closeClaw();
            move(0,.3,500.0/17);
            openClaw();
        }
        catch (Exception e){
            telemetry.addData("Exception: ", e);
            telemetry.update();
        }

    }
}
