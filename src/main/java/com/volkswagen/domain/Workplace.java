package com.volkswagen.domain;

import java.util.ArrayList;
import java.util.List;

import static com.volkswagen.utils.string.StringUtils.removeBlanks;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Workplace {

    private final int x;

    private final int y;

    private static final String WORKPLACE_RAW_INPUT_PATTERN = "[0-9]{2}";

    private final List<Robot> finishedRobots = new ArrayList<>();

    Workplace(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Workplace coordinate cannot be negative");
        }
        this.x = x;
        this.y = y;
    }

    public static Workplace from(String rawValue) {

        if (rawValue == null) {
            throw new IllegalArgumentException("Raw workplace input cannot be null");
        }

        String trimmed = removeBlanks(rawValue);

        if (!maches(trimmed)) {
            throw new IllegalArgumentException("Invalid raw workplace input");
        }

        return new Workplace(
                parseInt(valueOf(trimmed.charAt(0))),
                parseInt(valueOf(trimmed.charAt(1)))
        );
    }

    public boolean isOutside(int x, int y) {
        return x > this.x || y > this.y;
    }

    public boolean isOutside(RobotPosition robotPosition) {
        return isOutside(robotPosition.x(), robotPosition.y());
    }

    public boolean hasObstacleIn(int x, int y) {

        /*
        TODO: Correctly implements the logic to detect possible collisions
        between the robot trying to perform a movement and the robots already finished and parked in a particular position.

        The code returns false, pending a correct implementation.
         */

        return false;
    }


    public void addFinishedRobot(Robot robot) {

       /*
       TODO: Updates an auxiliary data structure to record the robots that have already finished their movements.
        */

    }

    private static boolean maches(String rawValue) {
        return rawValue.matches(WORKPLACE_RAW_INPUT_PATTERN);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public List<Robot> finishedRobots() {
        return finishedRobots;
    }
}
