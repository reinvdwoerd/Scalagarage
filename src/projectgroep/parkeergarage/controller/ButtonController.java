package projectgroep.parkeergarage.controller;

import java.awt.*;

import javax.swing.*;

import projectgroep.parkeergarage.logic.ParkeerLogic;
import projectgroep.parkeergarage.main.Simulator;

@SuppressWarnings("serial")
public class ButtonController extends AbstractController {
    int width = 80;

    JButton OneStep = new JButton("+1") {{
        setBounds(141, 572, width, 26);
        addActionListener(e -> parkeerLogic.tickSimulator());
    }};

    JButton StepBack = new JButton("-1") {{
        setBounds(10, 572, width, 26);
        addActionListener(e -> parkeerLogic.GetHistory());
    }};

    JButton Play = new JButton("Play") {{
        setBounds(10, 624, width, 23);
        addActionListener(e -> parkeerLogic.play());
    }};

    JButton Pause = new JButton("Pause") {{
        setBounds(144, 624, width, 23);
        addActionListener(e -> parkeerLogic.pause());
    }};

    JButton Reset = new JButton("Reset") {{
        setBounds(66, 681, 89, 23);
        addActionListener(e -> sim.restart(parkeerLogic.settings));
    }};


    ParkeerLogic parkeerLogic;
    Simulator sim;
    ParkeerLogic tickfor;
    ParkeerLogic tickback;

    public ButtonController(Simulator simulator, ParkeerLogic parkeerLogic) {
        this.parkeerLogic = parkeerLogic;
        this.sim = simulator;

        Container contentPane = simulator.getScreen().getContentPane();

        contentPane.add(Play);
        contentPane.add(Pause);
        contentPane.add(OneStep);
        contentPane.add(StepBack);
        contentPane.add(Reset);
    }
}
