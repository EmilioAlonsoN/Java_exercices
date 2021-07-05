package com.my_website.web.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Role extends AbstractPersistable<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = 3801485247386621263L;

    private String name;

    @OneToMany(targetEntity = Users.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Users> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

