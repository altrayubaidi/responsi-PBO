/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsimvc;

/**
 *
 * @author Acer
 */
public class MVC {
    Model m = new Model();
    View v = new View();
    Controller controller = new Controller(m,v);
}
