(require '[hiccup.page :as h]
         '[clojure.string :as str])

(def li (partial map (partial vector :li)))

(def 헤더
  [:head
   [:meta {:charset "UTF-8"}]
   [:title "김대현 이력서"]
   [:meta {:name "description" :content "김대현 이력서"}]
   [:meta {:name "author" :content "hatemogi"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
   [:link {:rel "stylesheet"
           :href "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
           :integrity "sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
           :crossorigin "anonymous" :referrerpolicy "no-referrer"}]
   [:link {:rel "stylesheet" :href "style.css"}]])

(def 소셜링크
  (map
   (fn [{link :link icon :icon}]
     [:a {:href link :target "_blank"} [:i {:class (str "fab " icon)}]])
   [{:link "https://github.com/hatemogi" :icon "fa-github-alt"}
    {:link "https://www.linkedin.com/in/hatemogi/" :icon "fa-linkedin-in"}
    {:link "https://medium.com/@hatemogi/" :icon "fa-medium"}
    {:link "https://www.youtube.com/hatemogi101/" :icon "fa-youtube"}]))

(def 머리말
  [:header
   [:div [:img {:src "img/profile.jpg"}]]
   [:h1 "김대현"]
   [:section [:p "시니어 백엔드 개발자"] 소셜링크]])

(def 스킬셋
  [:section [:h2 "보유기술"]
   [:article.skills
    [:div.컬럼
     [:div [:h3 "우수한 기술"] (li ["Scala" "Clojure" "Haskell" "Elm" "Java"])]
     [:div [:h3 "충분한 기술"] (li ["Python" "TypeScript" "Kotlin" "Go" "PostgreSQL" "Amazon Web Services" "Google Cloud Platform" "Netty" "Docker"])]
     [:div [:h3 "경험한 기술"] (li ["Rust" "C" "Kubernetes"])]]
    [:div
     [:h3 "외국어"]
     [:p "🇺🇸 듣기/읽기 상급, 말하기/쓰기 중급. TOEFL CBT 260"]
     [:p "🇯🇵 듣기/말하기 상급. 읽기/쓰기 초급"]]]])


(def 경력
  [:section [:h2 "경력"]
   (map
    (fn [{기간 :기간 회사명 :회사명 직위 :직위 스택 :스택 한일 :한일}]
      [:article.경력
       [:div.컬럼 [:div.강조 회사명] [:div 직위] [:div 기간]]
       [:div.기술스택 (str/join ", " 스택)]
       [:ul.job-description (li 한일)]])
    [{:기간 "2022.5 - 현재" :회사명 "컨스택츠 코리아" :직위 "백엔드 개발자"
      :스택 ["Haskell" "Scala" "Elm" "PostreSQL" "Google Cloud Platform"]
      :한일 ["Haskell로 신규 백엔드 시스템을 구축 중입니다."]}
     {:기간 "2020.3 - 2022.5" :회사명 "라인+" :직위 "ADS > MONAD > Lead"
      :스택 ["Scala" "PostgreSQL" "Kafka"]
      :한일 ["LINE메신저 타임라인 서비스 광고 수익 배분 시스템 개발"
           "Scala로 개발해서 운영하며, 개발팀을 구축해 리딩했습니다."
           "일본과 대만에 성공적 서비스"]}
     {:기간 "2018.9 - 2020.2" :회사명 "NHN" :직위 "Dooray개발실 > 수석"
      :스택 ["Kotlin" "Java" "MySQL" "Akka" "Netty"]
      :한일 ["업무용 메신저 백엔드를 담당"
           "고성능 Java Akka 프레임워크 기반 메시징 서버 개발"
           "서버당 최대 5만 세션을 처리하는 실험"
           "현업에서도 동시접속 6천 이상을 가볍게 처리"
           "Java Netty기반 SMTP 서버, LDAP 서버 개발"
           "CalDAV 서버 개발"]}
     {:기간 "2004.5 - 2015.3" :회사명 "카카오" :직위 "CTO Staff > 개발리더"
      :스택 ["Java" "MySQL" "Ruby" "Linux" "C"]
      :한일 ["클라우드기술팀 > 팀장 > 사내 클라우드 플랫폼 구축 운영"
           "사내Git저장소 서비스 개발 및 전파"
           "Daum 캘린더 > RubyOnRails로 개발. 국내 최초급 AJAX 웹앱"
           "마이피플 > C 채팅 부하분산 서버 개발 "
           "Daum카페 > Java 한줄메모장 개발"
           "일본 도쿄 지사 근무 18개월"]}
     {:기간 "2000.1 - 2003.4" :회사명 "한국물류정보통신" :직위 "시스템팀 > 사원"
      :스택 ["Java" "C" "UNIX"]
      :한일 ["네트워크 관리자. 방화벽, 라우터, 스위치 장비 관리. 보안 네트워크 구축"
           "각종 UNIX 환경, C언어로 TCP / X.25 통신망 EDI 문서 중계 시스템 개발"]}])])

(def 학력
  [:section [:h2 "학력"]
   [:article.학력
    [:div.학교 [:div.강조 "홍익대학교 컴퓨터공학과 졸업"] [:div.기간 "1996 - 2000"]]
    [:div.설명 [:div "전공성적우수 장학금 2학기분 수령"] [:div "졸업과제: 리얼타임 리눅스 RTLinux 커널 분석"]]]])

(def 발표경험
  [:section [:h2 "발표 경험"]
   (map (fn [{주제 :주제 링크 :링크 영상 :영상}]
          [:article.발표
           (if 링크
             [:a {:href 링크} [:div.title 주제]]
             [:div.title 주제])])
        [{:주제 "인프콘2023 - 함수형 프로그래밍 3대장 경험기: 클로저, 스칼라, 하스켈"
          :링크 "https://www.inflearn.com/conf/infcon-2023/session-detail?id=744"
          :영상 "https://www.inflearn.com/course/lecture?courseSlug=인프콘2023-다시보기&unitId=177889"}
         {:주제 "LiftIO 2022 - 두 다리 뻗고 자는 (탄탄한) 함수형 프로그래밍"
          :링크 "https://festa.io/events/2876"}
         {:주제 "LiftIO 2021 - 연속된 우연으로 꾸려진 개발팀의 함수형 Scala 활용기"
          :링크 "https://liftio.org/2021/"}
         {:주제 "라인 백엔드 개발자의 함수형 프로그래밍 언어 실전 사용기"
          :영상 "https://www.youtube.com/watch?v=H6JxxWL6bJI"}
         {:주제 "2017년 제6 회 리스프 세미나 — 클로저 소개"
          :링크 "https://medium.com/happyprogrammer-in-jeju/클로저-소개-제6회-리스프-세미나-발표-dc6700e0821d"}
         {:주제 "PyCon2016 라이트닝톡 — 개발하는 라이더의 연비계산"
          :링크 "https://medium.com/happyprogrammer-in-jeju/파이콘-2016-라이트닝-토크-발표-후기-763135a2a623"
          :영상 "https://www.youtube.com/watch?v=46UkzB-3z3Y"}
         {:주제 "DevOn2013 — 사내Git저장소개발사례" :링크 "https://www.slideshare.net/hatemogi/devon2013-git"}])])

(def 사이드프로젝트
  [:section [:h2 "사이드 프로젝트"]
   (map (fn [{제목 :제목 링크 :링크}]
          [:article.사이드프로젝트 [:h4 제목]])
        [{:제목 "스타벅스 WiFi 자동 연결 앱" :링크 ""}
         {:제목 "큐브 풀이 연습 3D 웹페이지" :링크 ""}
         {:제목 "마크다운 to TufteCSS" :링크 ""}
         {:제목 "한글 자소별 색상 구분 타자연습 웹앱" :링크 ""}])])

(def 교육
  [:section [:h2 "교육 수료"]
   (map (fn [{주제 :주제 연도 :연도 수료증 :수료증}]
          [:article.course
           [:div.title 연도 ", " 주제 " " [:a {:href 수료증} "[수료증]"]]])
        [{:주제 "Introduction to TensorFlow for Artificial Intelligence, Machine Learning, and Deep Learning"
          :연도 2022
          :수료증 "https://coursera.org/share/34d3458e34c700f354ab36b780e739c6"}
         {:주제 "Convolutional Neural Networks in TensorFlow"
          :연도 2022
          :수료증 "https://coursera.org/share/83e63aa087183fbe753ae0d99a4a0e7d"}
         {:주제 "Natural Language Processing in TensorFlow"
          :연도 2022
          :수료증 "https://coursera.org/share/34d3458e34c700f354ab36b780e739c6"}
         {:주제 "Sequences, Time Series and Prediction"
          :연도 2022
          :수료증 "https://coursera.org/share/72e4bc85275b4234a9c0384ea6053979"}
         {:주제 "Effective Programming in Scala"
          :연도 2021
          :수료증 "https://coursera.org/share/e3adcc29353c58ae20733d4075c2a97c"}
         {:주제 "Functional Program Design in Scala"
          :연도 2019
          :수료증 "https://coursera.org/share/7ff7f8b81abfbc9df1e81974e1a0c256"}
         {:주제 "Big Data Analysis with Scala and Spark"
          :연도 2019
          :수료증 "https://coursera.org/share/ffd008aeadbb568643b17d7c5f58077a"}
         {:주제 "Kotlin for Java Developers"
          :연도 2019
          :수료증 "https://coursera.org/share/1fea494a120389564cf16c6dcc815888"}
         {:주제 "Functional Programming Principles in Scala"
          :연도 2013
          :수료증 "https://www.coursera.org/api/legacyCertificates.v1/spark/statementOfAccomplishment/971423~66457/pdf"}])])

(def 꼬리말 [:footer [:p "@hatemogi"]])

(def 본문 [:main 경력 스킬셋 발표경험 사이드프로젝트 학력 교육])

(def 바디 [:body 머리말 본문 꼬리말])

(print (str (h/html5 헤더 바디)))