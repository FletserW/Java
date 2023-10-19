/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBeans;

/**
 *
 * @author nicolas
 */
public class Contato {
    private String contato;
    private String celular;
    private String email;
    private String grupo;
    private boolean bloqueio;

    public Contato(String contato, String celular, String email, String grupo, boolean bloqueio) {
        this.contato = contato;
        this.celular = celular;
        this.email = email;
        this.grupo = grupo;
        this.bloqueio = bloqueio;
    }
    
    public void setContato(String contato){
        this.contato= contato;
    }
    public String getContato(){
        return this.contato;
    }
    
    public void setCelular(String celular){
        this.celular=celular;
    }
    public String getCelular(){
        return this.celular;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    
    public void setGrupo(String grupo){
        this.grupo=grupo;
    }
    public String getGrupo(){
        return this.grupo;
    }
    
    public void setBloqueio(boolean bloqueio){
        this.bloqueio = bloqueio;
    }
    public boolean getBloqueio(){
        return this.bloqueio;
    }
}
