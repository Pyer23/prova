////////////////////////////////////////////////////////////////////
// [Marco] [Dello Iacovo] [1193421]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import java.time.LocalDate;

public class User {

    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;

    public User(String _name, String _surname, LocalDate _dateOfBirth, String _email, String _phoneNumber){
        this.name          = _name;
        this.surname       = _surname;
        this.email         = _email;
        if(_dateOfBirth == null) {
            throw new IllegalArgumentException("La data di nascita è null");
        }
        if(_dateOfBirth.isBefore(LocalDate.now())) {
            this.dateOfBirth   = _dateOfBirth;
        }else {
            throw new IllegalArgumentException("La data di nascita deve essere precedente alla data odierna");
        }
        
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    
}