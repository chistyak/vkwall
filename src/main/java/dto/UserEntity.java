package dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;


@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL,
                                        dynamicUpdate = true)
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id") })
public class UserEntity implements Serializable {


    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "last_post_id", unique = false, nullable = true)
    private Integer lastPostId = 0;

    @OneToMany(mappedBy = "user")
    public Set<PostEntity> getPosts(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Set<PostEntity> set = new HashSet<PostEntity>(session
                        .createCriteria(PostEntity.class)
                        .add(Restrictions.like("user", this.getId()))
                        .list());
        return set;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getLastPostId() {
        return lastPostId;
    }

    public void setLastPostId(int lastPostId) {
        this.lastPostId = lastPostId;
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