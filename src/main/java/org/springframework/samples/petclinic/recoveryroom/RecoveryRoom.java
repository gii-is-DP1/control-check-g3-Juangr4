package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.lang.NonNull;
import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RecoveryRooms")
public class RecoveryRoom extends NamedEntity {
    
    @NonNull
    @Min(0)
    @Column(name = "size")
    private double size;
    
    @Column(name = "secure")
    boolean secure;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    RecoveryRoomType roomType;
}
