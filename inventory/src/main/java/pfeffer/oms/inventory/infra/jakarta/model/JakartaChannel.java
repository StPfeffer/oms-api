package pfeffer.oms.inventory.infra.jakarta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "channel")
public class JakartaChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "channel_id", nullable = false, unique = true)
    private String channelId;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<JakartaChannelStock> stockTypes;


}
