package pfeffer.oms.core.domain.entities;

import pfeffer.oms.core.domain.enums.EnumCustomerType;

import java.util.List;

public class CustomerBO {

    private String id;

    private String firstName;

    private String lastName;

    private String fullName;

    private String email;

    private String birthdate;

    private EnumCustomerType type;

    private List<AddressBO> addresses;

    private List<TelephoneBO> telephones;

    private List<DocumentBO> documents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public EnumCustomerType getType() {
        return type;
    }

    public void setType(EnumCustomerType type) {
        this.type = type;
    }

    public List<AddressBO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressBO> addresses) {
        this.addresses = addresses;
    }

    public List<TelephoneBO> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneBO> telephones) {
        this.telephones = telephones;
    }

    public List<DocumentBO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentBO> documents) {
        this.documents = documents;
    }

}
