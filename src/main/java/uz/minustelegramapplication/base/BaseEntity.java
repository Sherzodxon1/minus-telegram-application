package uz.minustelegramapplication.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    protected Integer id;

    @Column(name = "uuid")
    protected UUID uuid = UUID.randomUUID();

    @Column(name = "active", columnDefinition = "NUMERIC default 1")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean active = true;

}