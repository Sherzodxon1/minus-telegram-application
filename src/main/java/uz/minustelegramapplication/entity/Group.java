package uz.minustelegramapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.minustelegramapplication.base.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "link")
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    @Column(name = "owner_id", insertable = false, updatable = false)
    private Integer ownerId;

}
