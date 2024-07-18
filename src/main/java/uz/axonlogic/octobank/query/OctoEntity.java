package uz.axonlogic.octobank.query;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity(name = "octo")
public class OctoEntity {

    @Id
    private String id;

    @Column(name = "error")
    private String error;

}