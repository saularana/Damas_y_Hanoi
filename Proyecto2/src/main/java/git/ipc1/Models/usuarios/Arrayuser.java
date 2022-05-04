/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package git.ipc1.Models.usuarios;

/**
 *
 * @author HP
 */
public class Arrayuser {

    private static int idAvailable = 0;
    private Users[] list = new Users[20];

    public void addUsers(String name) {
        Users tmp = new Users(name, Arrayuser.getIdAbailable());
        list[tmp.getId()] = tmp;
    }

    private static int getIdAbailable() {
        return Arrayuser.idAvailable++;
    }
    public String getTona(int i){
        if (list[i]!=null){
        return list[i].getName();
        }
        return null;
      }
    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                break;
            }
            tmp = tmp + list[i].toString() + "\n";

        }

        return tmp;
    }

    public Users getUserEnArray(int i){
        Users resp=null;
        if (Arrayuser.isValid(i)){
            return this.list[i];
        }
        return resp;
    
    }
    public static boolean isValid(int id){
    return ((idAvailable>0)&&(id>=0)&& (id<=idAvailable));
    }
    
    
}
