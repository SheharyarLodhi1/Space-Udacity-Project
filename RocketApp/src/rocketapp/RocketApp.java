/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketapp;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 *
 * @author sheharyar
 */
public class RocketApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        final int phase1 = 1;
        final int phase2 = 2;

        long u1Cost;
        long u2Cost;
        int phase1Rockets;
        int phase2Rockets;

        ArrayList<Item> phase1Item;
        ArrayList<Item> phase2Item;

        Simulation simulation = new Simulation();

        System.out.println(" PLEASE WAIT WHILE WE ARE LOADING....................");
        phase1Item = simulation.loadItems(phase1);
        phase2Item = simulation.loadItems(phase2);

        System.out.println("STARTING SIMULATION FOR ROCKET U1...\n");
        System.out.println("=====Simulates Phase 1");
        simulation.runSimulation(simulation.loadU1(phase1Item), 1);
        System.out.println("=====Simulation is Completed\n");
        phase1Rockets = U1.getRocketU1Counter();
        System.out.println("The Rockets which are used for phase 1 are : " + phase1Rockets);

        System.out.println("=====Simulates Phase 2");
        simulation.runSimulation(simulation.loadU1(phase2Item), 1);
        System.out.println("=====Simulationis Completed\n");
        phase2Rockets = U1.getRocketU1Counter() - phase1Rockets;
        System.out.println("Rockets used for phase 2: " + phase2Rockets + "\n");

        System.out.println("Total " + U1.getRocketU1Counter() + " rockets was used.");
        u1Cost = totalCost(1);

        System.out.println("STARTING SIMULATIONS FOR OUR ROCKET U2...\n");
        System.out.println("=====Simulating Phase 2");
        simulation.runSimulation(simulation.loadU2(phase1Item), 2);
        System.out.println("=====Simulation is Completed\n");
        phase1Rockets = U2.getRocketU2Counter();
        System.out.println("Rockets used for phase 1: " + phase1Rockets);

        System.out.println("=====Simulating for Phase 2 is Started ...");
        simulation.runSimulation(simulation.loadU2(phase2Item), 2);
        System.out.println("=====Simulation Done=====Simulation Done=====Simulation Done=====\n");
        phase2Rockets = U2.getRocketU2Counter() - phase1Rockets;
        System.out.println("Rockets that are used for phase 2 are : " + phase2Rockets);

        System.out.println("Total " + U2.getRocketU2Counter() + " rockets was used." + "\n");
        u2Cost = totalCost(2);

        System.out.println("\nTotal budget needed for U1 rockets are: " + u1Cost);
        System.out.println("Total budget needed for U2 rockets are : " + u2Cost);

        if (u1Cost > u2Cost) {
            System.out.println("Using U2 rockets is cheaper in this simulation");
        } else {
            System.out.println("Using U1 rockets is cheaper in this simulation");
        }

    }

    public static long totalCost(int i) {
        return (i == 1) ? U1.getTotalCost() : U2.getTotalCost();
    }
    
}
    
