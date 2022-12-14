package com.manager.passwordProject.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="passwords", schema="public")
public class Password extends AbstractEntity {
    @Getter
    @Setter
    @Column(name="name", nullable=false)
    private String name;

    @Getter
    @Setter
    @Column(name="details")
    private String detail;

    @Getter
    @Setter
    @Column(name="url")
    private String url;

    @Getter
    @Setter
    @Column(name="password", nullable=false)
    private String password;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name="user_id", nullable=false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private User user;
}
