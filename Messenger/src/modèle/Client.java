/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modèle;

import java.io.IOException;

/**
 *
 * @author blood
 */
public interface Client {
    public void lancerClient()throws IOException;
    public void envoyerClient();
    public void recevoirClient() throws IOException;
}
