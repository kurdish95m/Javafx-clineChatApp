/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author kurd
 */
public class UserInfo {

    String username;
    String ipAddress;
    String portNumber;

    public UserInfo(String username, String ipAddress, String portNumber) {
        this.username = username;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "username=" + username + ", ipAddress=" + ipAddress + ", portNumber=" + portNumber + '}';
    }
    
}
