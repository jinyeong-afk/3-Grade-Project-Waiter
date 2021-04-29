# Waiter <음식점 예약 프로그램>
Waiter 프로그램은 음식점을 직접 가서 줄을 서지 않고 온라인으로 예약할 수 있는 프로그램이다.


# 1차 회의록





## 플랫폼

Restarurant reservation

### 내용

- 음식점 좌석 예약 및 번호표 발급
- 메뉴 조회
- 음식점 정보
- 음식점 리뷰

## 기능구현



## 관리자(직원)

#### 주문 현황

> 테이블, 메뉴 

#### 재고 관리

#### 대기 순번

#### 결제

> 주문 -> 음식 가격 -> 가격을 총합한 것

#### 가게 정보(메뉴판 및 영업시간) 수정

#### 블랙리스트



## 사용자 (손님)

#### 매장검색

> 관심 매장 등록 등

#### 가게 정보 확인

> 메뉴판 및 영업시간 확인

---

#### 테이블 예약

> 실시간 좌석 현황, 번호표 , 예상 대기시간, 예약 내역 확인, 예약 수정

#### 음식주문 

---

#### 리뷰 작성

---





# 개발 프로세스

### 스크럼

빡세게 한번 만들고 남은 시간동안 유지보수

개발 주기는 1~4주 정도로 하고 개발 주기마다 실제 동작할 수 있는 결과를 제공하라.
(설명:너무 짧으면 개발(분석/설계/개발/테스트) 할 수 있는 시간이 부족하고, 너무 길면 느슨해지고 재작업의 양도 늘어나므로 적용해보면서 필요시 조율 필요)

- 제품 관리자 

- 스크럼 마스터

- 스크럼 개발 팀

  ## 3.1. 제품 책임자(Product Owner)

  비즈니스 목표를 충족시키는 제품을 만들기 위해 제품 백 로그를 관리하고 제품을 검토합니다.

  - 제품 백로그(요구사항) 관리/설명
  - 제품 백로그의 우선순위 관리
  - 만족스럽게 개발되었는지 확인

  ![img](https://miro.medium.com/max/60/0*12Jqw8Vatb4HnpLo.png?q=20)

  ![img](https://miro.medium.com/max/1303/0*12Jqw8Vatb4HnpLo.png)

## 3.2. 스크럼 마스터(ScrumMaster)

Product Owner와 Development Team이 가치(Value)와 원칙(Principle)으로 성공적인 제품을 만들고, 조직 변화를 촉진하고 민첩한 작업 방식을 수립하여 유지할 수 있도록 책임을 가집니다.

- 팀을 보호하고 장애 요소를 해결
- 일일 스크럼 회의를 진행
- 모니터링 및 Tracking

![img](https://miro.medium.com/max/60/0*CrBaWMVWUL-Qf-KA.png?q=20)

![img](https://miro.medium.com/max/1264/0*CrBaWMVWUL-Qf-KA.png)

이미지 출처 : https://www.romanpichler.com/blog/every-great-product-owner-needs-great-scrummaster/

## 3.3. 개발 팀 (Developer)

최선의 기술로 백로그를 개발하여 고객을 만족시킵니다.

# 4. Scrum 주요 용어

- **제품 백로그(Product Backlog) :** 개발할 제품의 요구사항인 사용자 스토리 집합이며, 우선순위로 관리

![img](https://miro.medium.com/max/60/0*Zkg1N28LvlI0J4tV.jpg?q=20)

![img](https://miro.medium.com/max/500/0*Zkg1N28LvlI0J4tV.jpg)

이미지 출처 : https://www.softwaretestinghelp.com/user-story-acceptance-criteria/

- **사용자 스토리(User Story)** : 과거 요구사항 명세처럼 업무 범위를 구체화하기 위한 개발자 입장이 아닌, User Story는 사용자가 사용하는 관점에서 어떤 가치를 제공할 것인지를 설명
  (해설 : PO는 이 기능이 누구에게 무슨 value를 제공하는지를 설명하고, 향후 개발자는 그 기능의 Value를 제공하기 위한 기술적인 역할과 책임을 가짐)

![img](https://miro.medium.com/max/60/1*QroqEzw6bxFGQYLhFILQCw.png?q=20)

![img](https://miro.medium.com/max/954/1*QroqEzw6bxFGQYLhFILQCw.png)









사장 > 매장 관리자

손님 > 모든 매장을 볼 수 있어야함 / 검색해서 조회 / 

최고 관리자 > 불량 매장 및 불량 리뷰 관리





## 매장 관리자

2 

이규철

송진영

## 매장 사용자

2 

허세진

박성호

## 최고 관리자

1

박경민



# 다음주

- 디자인 패턴 적용할 내용 조사

  

## 역할 분담

프론트 / 백 / 디비 

### 사전 준비

GUI  > 세진, 성호

디비 > 진영, 규철, 경민

백 > 다같이 1.5개씩

