package org.usfirst.ftc.exampleteam.yourcodehere;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

import org.swerverobotics.library.SynchronousOpMode;
import org.swerverobotics.library.interfaces.TeleOp;

/**three OpModes: TeleOp, autonomous, and disabled.
 * A sample program to help me better understand how android studio works.
 */
@TeleOp(name="My First OpMode")
public class Myfirstftcprogram extends SynchronousOpMode
    {

    /* Declare here any fields you might find useful. */
        DcMotor motorLeft = null;
        DcMotor motorRight = null;
        //declares servos
        //Has to start with double
        Servo servoArm = null;
        //default servo motor positions
        double ARM_MIN = 0.2;
        double ARM_MAX = 0.8;

    @Override public void main() throws InterruptedException
        {
        /* Initialize our hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names you assigned during the robot configuration
         * step you did in the FTC Robot Controller app on the phone.
         */
            motorLeft = hardwareMap.dcMotor.get("motorLeft");
            motorRight = hardwareMap.dcMotor.get("motorRight");

            //Set motor channel modes
            motorLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            motorRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
                    // Reverse left driver motors so we don't spin when applying full power
            motorLeft.setDirection(DcMotor.Direction. REVERSE );

            //Initialize servo position to stay inside the 18 inch box
            servoArm.setPosition(ARM_MAX);


        // Wait for the game to start
        waitForStart();

        // Go go gadget robot!
        while (opModeIsActive())
            {
            if (updateGamepads())
                {
                    //Tank drive
                    motorLeft.setPower(gamepad1.left_stick_y);
                    motorLeft.setPower(gamepad1.right_stick_y);

                    //Mpve the arm
                    if(gamepad2.a)
                    {
                        servoArm.setPosition(ARM_MIN);
                    }
                    else if (gamepad2.b)
                    {
                        servoArm.setPosition(ARM_MAX);
                    }

                // The game pad state has changed. Do something with that!
                    // initialize servos
                    servoArm = hardwareMap.servo.get("servo arm");
                }

            telemetry.update();
            idle();
            }
        }
    }
