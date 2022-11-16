package uz.minustelegramapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.minustelegramapplication.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_messages")
public class ChatMessage extends BaseEntity {

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", referencedColumnName = "id")
    private Chat chat;
    @Column(name = "chat_id", insertable = false, updatable = false)
    private Integer chatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;
    @Column(name = "sender_id", insertable = false, updatable = false)
    private Integer senderId;

    @Column(name = "is_view")
    private boolean isView = false;

    @Column(name = "data_time", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime dataTime = LocalDateTime.now();

}
