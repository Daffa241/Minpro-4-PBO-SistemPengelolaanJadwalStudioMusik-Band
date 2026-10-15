/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ASUS
 */
import controller.StudioController;
import view.StudioView;

public class Main {
    public static void main(String[] args) {
        StudioController controller = new StudioController();
        StudioView view = new StudioView(controller);
        view.jalankan();
    }
}