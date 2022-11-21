package uz.minustelegramapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.minustelegramapplication.base.BaseEntity;
import uz.minustelegramapplication.enums.ChannelType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "channels")
public class Channel extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User owner;
    @Column(name = "owner_id")
    private Integer ownerId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "channel_type")
    private ChannelType channelType;

}
