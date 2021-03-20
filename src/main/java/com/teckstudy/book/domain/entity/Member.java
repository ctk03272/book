package com.teckstudy.book.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Where(clause = "deleted = false")
public class Member extends BaseEntity {

    @Id @GeneratedValue
    private Long member_sn;

    @Column(length = 30)
    private String member_id;

    @Column(length = 30)
    private String password;

    @Column(length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(length = 20)
    private String birthday;

    @Column(length = 20)
    private String phone_number;

    @Column(length = 100)
    private String address;

    @ColumnDefault("0")
    private boolean sns_yn;

//    @Convert(converter = MemberStatus.class)
    @Enumerated(EnumType.STRING)
    private MemberStatus member_status;

    public Member(String member_id, String password, String name, Gender sex, String birthday, String phone_number, String address, boolean sns_yn, MemberStatus member_status) {
        this.member_id = member_id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phone_number = phone_number;
        this.address = address;
        this.sns_yn = sns_yn;
        this.member_status = member_status;
    }

    //    private Order order_sn;

}
