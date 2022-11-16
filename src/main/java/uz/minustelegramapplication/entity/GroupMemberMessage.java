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
@Table(name = "group_member_messages")
public class GroupMemberMessage extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_member_id", referencedColumnName = "id")
    private GroupMember groupMember;
    @Column(name = "group_member_id", insertable = false, updatable = false)
    private Integer groupMemberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_message_id", referencedColumnName = "id")
    private GroupMessage groupMessage;
    @Column(name = "group_message_id", insertable = false, updatable = false)
    private Integer groupMessageId;

    @Column(name = "is_view")
    private boolean is_view;  // todo fixme

}
