package dto;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.annotations.OptimisticLockType;
import util.HibernateUtil;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL,
                                    dynamicUpdate = true)
@Table(name = "posts", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id") })
public class PostEntity implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user", unique = false, nullable = false)
    private Integer user;

    @Column(name = "text", unique = false, nullable = true)
    private String text;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void save() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
    }

    public void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(this);
        session.getTransaction().commit();
    }
}