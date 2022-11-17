package uz.minustelegramapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import uz.minustelegramapplication.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "channel_messages")
public class ChannelMessage extends BaseEntity {

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    private Channel channel;
    @Column(name = "channel_id", insertable = false, updatable = false)
    private Integer channelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;
    @Column(name = "sender_id", insertable = false, updatable = false)
    private Integer senderId;

    @Column(name = "is_view", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isView = false; // todo base qisa boladimi

    @Column(name = "data_time", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime dataTime = LocalDateTime.now();

}
