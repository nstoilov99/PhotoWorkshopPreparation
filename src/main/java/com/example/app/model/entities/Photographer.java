package com.example.app.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "photographers")
public class Photographer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    private String lastName;


    @Basic
    private String phone;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "primary_camera_id", referencedColumnName = "id")
    private BasicCamera primaryCamera;

    @NotNull
    @OneToOne
    @JoinColumn(name = "secondary_camera_id", referencedColumnName = "id")
    private BasicCamera secondaryCamera;

    @OneToMany(mappedBy = "owner", targetEntity = Lens.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Lens> lenses;

    @OneToMany(mappedBy = "owner", targetEntity = Accessory.class)
    private List<Accessory> accessories;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BasicCamera getPrimaryCamera() {
        return this.primaryCamera;
    }

    public void setPrimaryCamera(BasicCamera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public BasicCamera getSecondaryCamera() {
        return this.secondaryCamera;
    }

    public void setSecondaryCamera(BasicCamera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public List<Lens> getLenses() {
        return this.lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }

    public List<Accessory> getAccessories() {
        return this.accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " | " + (lenses == null ? "0" : lenses.size());
    }
}
