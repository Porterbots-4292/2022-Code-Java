package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.playingwithfusion.CANVenom;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    // Initialize all variables
    private CANVenom m_leftFrontController = new CANVenom(Constants.kMotorLeftFrontID);
    private CANVenom m_leftRearController = new CANVenom(Constants.kMotorLeftRearID);
    private CANVenom m_rightFrontController = new CANVenom(Constants.kMotorRightFrontID);
    private CANVenom m_rightRearController = new CANVenom(Constants.kMotorRightRearID);

    public Drivetrain(){
        // Set the left and right rear motors to follow the front ones 
        m_leftRearController.follow(m_leftFrontController);
        m_rightRearController.follow(m_rightFrontController);

        // P.S You might have to invert some motors here
        // m_rightRearController.setInverted(true);
    }

    // This function will make it so that you can pass in a 
    // value for forward movement and rotation and the robot
    // will move and rotate as intended  
    public void drive(double forward, double rotation){
        
        m_leftFrontController.set(forward + rotation);
        m_rightFrontController.set(forward - rotation);
    }
}
