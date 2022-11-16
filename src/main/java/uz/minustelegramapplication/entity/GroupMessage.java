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
@Table(name = "group_messages")
public class GroupMessage extends BaseEntity {

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;
    @Column(name = "group_id", insertable = false, updatable = false)
    private Integer groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User user;
    @Column(name = "sender_id", insertable = false, updatable = false)
    private Integer userId;

    @Column(name = "is_view")
    private boolean is_view; // todo fixme

    @Column(name = "data")
    private String data;   // todo fixme


}
