/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocketapp;

/**
 *
 * @author sheharyar
 */
public interface SpaceShip {
     boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);
}
