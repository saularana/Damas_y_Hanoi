/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.ipc1.Models.usuarios;

/**
 *
 * @author HP
 */
public class Users {
    private String name;

    public Users(String name, int id) {
        this.name = name;
        this.id = id;
        
    }

    @Override
    public String toString() {
        return this.getId()+ ") " + this.getName() ;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()>2){
        this.name = name;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;
    
}
