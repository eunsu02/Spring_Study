package com.likelion11.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Table(name="member")
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//identity 는 아이디 생성전략, 오토 인크리먼트를 지원함
    private Long id; //프라이빗인 이유 =  객체의 성질 4가지 중 캡슐화. 다른 클래스가 여기 못접근하게. 행위로만 소통해라. 그래서 프라이빗으로 감춘다// .

//    @Column(nullable = false)
//    private String name;
    @Column(nullable = false,unique = true,length = 20)
    private String username;
//    @Column(nullable = false)
//    private String nickName;//null x인데도 레퍼클래스로 만드는 이유? db 들어갈때 에러가 나는거임! 디비 들어가기 전에는 상관 없을때!
//    private int age; //integar 있는데도 int로 한 이유 = 자바에는 자료형이 2가지. 원시타입과 레퍼클래스.
    // jpa에서는 기본적으로 pk는 레퍼클래스. 하지만 다른 것들은 속성을 보고 결정해줌. int age에서는 nll이 안됨. 에러가 뜸.
    // 원시타입으로 해야 값이 기본적으로 뜸

    @Column(nullable = false)
    private  String password;

    //private boolean isAdult; //성인인지 아닌지 이런건 레퍼클래스로 안쓰는게 좋음.
    // 레퍼 클래스로 만들면 애초에 멤버 클래스 안에 들어갈 수 있는 값이 3개, true false null임. 애매한 상태가 생기게됨.

    @Column(nullable = false, unique = true)
    private String nickname;


    @CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    private LocalDateTime created_at = LocalDateTime.now();

    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private LocalDateTime updated_at = LocalDateTime.now();
    //box 1:1 연결
    @OneToOne(mappedBy = "member")
    private BoxEntity box;

    private boolean is_deleted = false;
    private LocalDateTime deleted_at = LocalDateTime.now().plus(30, ChronoUnit.DAYS);

    @Builder
    public MemberEntity(Long id, String username, String password, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
