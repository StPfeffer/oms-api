package pfeffer.oms.inventory.domain.dtos;

import pfeffer.oms.inventory.domain.enums.EnumCustomerType;

import java.util.List;

public class CustomerDTO {

    private String id;

    private String firstName;

    private String lastName;

    private String fullName;

    private String email;

    private String birthdate;

    private EnumCustomerType type;

    private List<AddressDTO> addresses;

    private List<TelephoneDTO> telephones;

    private List<DocumentDTO> documents;

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

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    public List<TelephoneDTO> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneDTO> telephones) {
        this.telephones = telephones;
    }

    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }

}
