package mq.springboot.responsiry.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "t_user")
@Entity
public class UserEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;

    public UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
