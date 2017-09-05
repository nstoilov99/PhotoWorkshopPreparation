package com.example.app.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "workshops")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @NotNull
    @Column(nullable = false)
    private String location;

    @NotNull
    @Column(name = "price_per_participant")
    private Double pricePerParticipant;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Photographer trainer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "workshops_participants",
    joinColumns = @JoinColumn(name = "workshop_id"),
    inverseJoinColumns = @JoinColumn(name = "participant_id"))
    private Set<Photographer> participants;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPricePerParticipant() {
        return this.pricePerParticipant;
    }

    public void setPricePerParticipant(Double pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public Photographer getTrainer() {
        return this.trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    public Set<Photographer> getParticipants() {
        return this.participants;
    }

    public void setParticipants(Set<Photographer> participants) {
        this.participants = participants;
    }
}
