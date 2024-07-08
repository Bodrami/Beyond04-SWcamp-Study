package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =          // ApplicationContext은 컨테이너라고 생각하면 된다.
                    new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName: beanNames) {
            System.out.println("beanName: " + beanName);
        }
        // 콩 꺼내는 방법
        /* 설명 1. bean의 id를 이용해서 bean을 가져오는 방법 */
//        MemberDTO member = (MemberDTO)context.getBean("member");  확인용

        /* 설명 2. bean의 클래스 메타 정보(bean의 타입)를 전달하여 가져오는 방법 */
//        MemberDTO member = context.getBean(MemberDTO.class);  확인용

        /* 설명 3. bean의 id와 클래스 메타 정보를 전달하여 가져오는 방법 */
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);
    }
}
