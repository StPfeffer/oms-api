package pfeffer.oms.inventory.jakarta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "channels")
public class JakartaChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public JakartaChannel() {
    }

    public JakartaChannel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
