

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
public class NxtTeleOp extends OpMode {

  public void init() {

  }

  DcMotor wheelR;
  DcMotor wheelL;

  //Servo clawR;
  //Servo clawL;

  @Override
  public void start () {
    wheelR = hardwareMap.dcMotor.get("motor_1");
    wheelL = hardwareMap.dcMotor.get("motor_2");
  }

  @Override
  public void loop () {
    float throttle = -gamepad1.left_stick_y;
    float direction = gamepad1.left_stick_x;

    float right = throttle - direction;
    float left = throttle + direction;

    wheelR.setPower(right);
    wheelL.setPower(left);
  }

 @Override
 public void stop() {

  }
}
