(require '[hiccup.page :refer [html5]]
         '[clojure.string :as str])

(def li (partial map (partial vector :li)))

(def 헤더
  [:head
   [:meta {:charset "UTF-8"}]
   [:title "김대현 이력서"]
   [:meta {:name "description" :content "김대현 이력서"}]
   [:meta {:name "author" :content "hatemogi"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
   [:meta {:property "og:title" :content "김대현 이력서"}]
   [:meta {:property "og:description" :content "시니어 백엔드 개발자 김대현 이력서"}]
   [:meta {:property "og:type" :content "website"}]
   [:meta {:property "og:image" :content "https://hatemogi.com/img/hatemogi.png"}]
   [:meta {:property "og:image:width" :content "1024"}]
   [:meta {:property "og:image:height" :content "1024"}]
   [:meta {:property "og:url" :content "https://resume.hatemogi.com/"}]
   [:link {:rel "shortcut icon" :href "favicon.png"}]
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
   [:h1.강조 "김대현"]
   [:section [:p "시니어 백엔드 개발자"] 소셜링크]])

(def 스킬셋
  [:section [:h2 "보유기술"]
   [:article.skills
    [:div.컬럼
     [:div [:h3 "우수한 기술"] (li ["Scala" "Clojure" "Haskell" "Elm" "Java"])]
     [:div [:h3 "충분한 기술"] (li ["TypeScript" "JavaScript" "Kotlin" "PostgreSQL" "Amazon Web Services" "Google Cloud Platform" "Netty" "Docker"])]
     [:div [:h3 "경험한 기술"] (li ["Rust" "Go" "Python" "C" "C++" "Pascal" "Assembly" "Kubernetes"])]]
    [:div
     [:h3 "외국어"]
     [:div.컬럼
      [:div "🇺🇸 English 듣기/읽기 상급, 말하기/쓰기 중급. TOEFL CBT 260"]
      [:div "🇯🇵 日本語 듣기/말하기 중급. 읽기/쓰기 초급"]]]]])


(def 경력
  [:section [:h2 "경력"]
   (map
    (fn [{기간 :기간 회사명 :회사명 직위 :직위 스택 :스택 한일 :한일}]
      [:article.경력
       [:div.컬럼 [:div.강조.고딕 회사명] [:div.고딕 직위] [:div 기간]]
       [:div.기술스택 (str/join ", " 스택)]
       [:ul.한일 (li 한일)]])
    [{:기간 "2022.5 - 현재" :회사명 "컨스택츠 코리아" :직위 "백엔드 개발자"
      :스택 ["Haskell" "Scala" "Elm" "PostreSQL" "Google Cloud Platform"]
      :한일 ["Haskell로 신규 백엔드 시스템을 구축 중입니다."]}
     {:기간 "2020.3 - 2022.5" :회사명 "라인+" :직위 "ADS > MONAD > Lead"
      :스택 ["Scala" "PostgreSQL" "Kafka"]
      :한일 ["LINE 메신저 타임라인 서비스 광고 수익 배분 시스템 개발"
           "함수형 Scala로 개발해서 운영, 개발팀을 구축해 리딩"
           "일본과 대만에 성공적 서비스"]}
     {:기간 "2018.9 - 2020.2" :회사명 "NHN" :직위 "Dooray개발실 > 수석"
      :스택 ["Kotlin" "Java" "MySQL" "Akka" "Netty"]
      :한일 ["업무용 메신저 백엔드를 담당"
           "고성능 Java Akka 프레임워크 기반 메시징 서버 개발"
           "서버당 최대 5만 세션을 처리하는 실험"
           "현업에서도 동시접속 6천 이상을 가볍게 처리"
           "Java Netty기반 SMTP 서버, LDAP 서버 개발"
           "CalDAV 서버 개발"]}
     {:기간 "2004.5 - 2015.3" :회사명 "카카오 (Daum)" :직위 "CTO Staff > 개발리더"
      :스택 ["Java" "MySQL" "Ruby" "Linux" "C"]
      :한일 ["Daum 클라우드기술팀 > 팀장 > 사내 클라우드 플랫폼 구축 운영"
           "Daum 사내Git저장소 서비스 개발 및 전파"
           "Daum 캘린더 > RubyOnRails로 개발. 국내 최초급 Web2.0 웹앱 "
           "Daum 마이피플 > C 채팅 부하분산 서버 개발"
           "Daum 카페 > Java 한줄메모장 개발. 1일 3억 페이지뷰 처리"
           "Daum 일본 도쿄 지사 근무 18개월"]}
     {:기간 "2000.1 - 2003.4" :회사명 "한국물류정보통신" :직위 "시스템팀 > 사원"
      :스택 ["Java" "C" "UNIX"]
      :한일 ["네트워크 관리자. 방화벽, 라우터, 스위치 장비 관리. 보안 네트워크 구축"
           "각종 UNIX 환경, C언어로 TCP/X.25 통신망 EDI 문서 중계 시스템 유지보수"]}])])

(def 학력
  [:section [:h2 "학력"]
   [:article.학력
    [:div.학교.컬럼 [:div.강조.고딕 "홍익대학교 > 공과대학 > 컴퓨터공학 > 공학사"] [:div.기간 "1996 - 2000"]]
    [:div.설명 [:div "전공성적우수 장학금 2학기분 수령"] [:div "졸업과제: 리얼타임 리눅스 RTLinux 커널 분석"]]]])

(def 발표경험
  [:section [:h2 "발표 경험"]
   (map (fn [{주제 :주제 링크 :링크 영상 :영상 유튜브 :유튜브 미디엄 :미디엄 깃허브 :깃허브}]
          [:article.발표
           [:div.고딕 주제 " "
            (when 링크 [:a {:href 링크} [:i {:class "fa-solid fa-link"}]]) " "
            (when 깃허브 [:a {:href 깃허브} [:i {:class "fa-brands fa-github"}]]) " "
            (when 미디엄 [:a {:href 미디엄} [:i {:class "fa-brands fa-medium"}]]) " "
            (when 유튜브 [:a {:href 유튜브} [:i {:class "fa-brands fa-youtube"}]])]])
        [{:주제 "인프콘2023 - 함수형 프로그래밍 3대장 경험기: 클로저, 스칼라, 하스켈"
          :링크 "https://www.inflearn.com/conf/infcon-2023/session-detail?id=744"
          :영상 "https://www.inflearn.com/course/lecture?courseSlug=인프콘2023-다시보기&unitId=177889"}
         {:주제 "LiftIO 2022 - 두 다리 뻗고 자는 (탄탄한) 함수형 프로그래밍"
          :링크 "https://festa.io/events/2876"
          :깃허브 "https://github.com/hatemogi/liftio2022"
          :미디엄 "https://medium.com/happyprogrammer-in-jeju/liftio-2022-오프닝-발표-기초-탄탄-함수형-프로그래밍-59e0a3233a32"}
         {:주제 "LiftIO 2021 - 연속된 우연으로 꾸려진 개발팀의 함수형 Scala 활용기"
          :링크 "https://liftio.org/2021/"
          :깃허브 "https://github.com/hatemogi/liftio2021-scala"}
         {:주제 "2021, 라인 백엔드 개발자의 함수형 프로그래밍 언어 실전 사용기"
          :유튜브 "https://www.youtube.com/watch?v=H6JxxWL6bJI"}
         {:주제 "2017, 제6회 리스프 세미나 — 클로저 소개"
          :미디엄 "https://medium.com/happyprogrammer-in-jeju/클로저-소개-제6회-리스프-세미나-발표-dc6700e0821d"}
         {:주제 "PyCon2016 라이트닝톡 — 개발하는 라이더의 연비계산"
          :미디엄 "https://medium.com/happyprogrammer-in-jeju/파이콘-2016-라이트닝-토크-발표-후기-763135a2a623"
          :유튜브 "https://www.youtube.com/watch?v=46UkzB-3z3Y"}
         {:주제 "DevOn2013 — 사내Git저장소개발사례" :링크 "https://www.slideshare.net/hatemogi/devon2013-git"}])])

(def 사이드프로젝트
  [:section [:h2 "사이드 프로젝트"]
   (map (fn [{제목 :제목 링크 :링크 미디엄 :미디엄 데모 :데모 유튜브 :유튜브 깃허브 :깃허브 연도 :연도}]
          [:article.사이드프로젝트
           [:div.고딕
            (when 연도 (str 연도 ", "))
            제목 " "
            (when 링크 [:a {:href 링크} [:i {:class "fa-solid fa-link"}]]) " "
            (when 미디엄 [:a {:href 미디엄 :title "설명글"} [:i {:class "fa-brands fa-medium"}]]) " "
            (when 깃허브 [:a {:href 깃허브 :title "소스코드"} [:i {:class "fa-brands fa-github"}]]) " "
            (when 데모 [:a {:href 데모 :title "데모"} [:i {:class "fa-solid fa-laptop-code"}]]) " "
            (when 유튜브 [:a {:href 유튜브 :title "유튜브영상"} [:i {:class "fa-brands fa-youtube"}]])]])
        (sort-by :연도 >
                 [{:연도 2023 :제목 "우아한 고성능 프로그래밍 언어 Rust 입문 및 활용 강의 제작"
                   :링크 "https://inf.run/LPYW" :깃허브 "https://github.com/hatemogi/rust-course"}
                  {:연도 2023 :제목 "Elm으로 만든 탁구 점수판 웹앱"}
                  {:연도 2023 :제목 "AWS Lambda와 Rust로 만든 수익 알리미"
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/aws%EC%97%90-%EC%84%9C%EB%B2%84%EB%A6%AC%EC%8A%A4-rust%EB%A1%9C-%EC%88%98%EC%9D%B5-%EC%95%8C%EB%A6%AC%EB%AF%B8-%EB%A7%8C%EB%93%A0-%EC%9D%B4%EC%95%BC%EA%B8%B0-a2eda678f6bc"}
                  {:연도 2017 :제목 "스타벅스 WiFi 자동 연결 앱"
                   :미디엄 "https://hatemogi.medium.com/list/wifi-199c3b2cb80f"}
                  {:연도 2022 :제목 "TypeScript와 three.js로 만든 큐브 연습용 웹페이지"
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/큐브-연습용-웹페이지-개발기-0-76e638752776"
                   :깃허브 "https://github.com/hatemogi/rurucube"
                   :데모 "https://hatemogi.github.io/rurucube/"}
                  {:연도 2019 :제목 "GitHub 한글화 실험 프로젝트"
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/github-%ED%95%9C%EA%B8%80%ED%99%94-%EC%8B%A4%ED%97%98-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-5b9e040d1d75"
                   :깃허브 "https://github.com/hatemogi/github-ko-ext"
                   :데모 "https://chromewebstore.google.com/detail/github-%ED%95%9C%EA%B8%80%ED%99%94/phhgannnkapemfnciphmbpenaflbngmm?pli=1"}
                  {:연도 2016 :제목 "마크다운 to TufteCSS"
                   :미디엄 "https://hatemogi.medium.com/list/44cdde970749"
                   :깃허브 "https://github.com/hatemogi/tufdown"
                   :데모 "https://hatemogi.github.io/tufdown/"}
                  {:연도 2019 :제목 "한글 자소별 색상 구분 타자연습 웹앱"
                   :미디엄 "https://hatemogi.medium.com/list/4a0f1c85e308"
                   :깃허브 "https://github.com/hatemogi/hallatype"
                   :데모 "http://type.hatemogi.com"}
                  {:연도 2015 :제목 "클로저 배우는 연습문제 모음 번역"
                   :깃허브 "https://github.com/hatemogi/clojure-koans"
                   :데모 "https://clojurekoans.hatemogi.com/"}
                  {:연도 2019 :제목 "Go로 만든, 로그 파일 색칠러"
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/colorlog-%EB%A1%9C%EA%B7%B8-%ED%8C%8C%EC%9D%BC-%EC%83%89%EC%B9%A0%EB%9F%AC-%EA%B0%9C%EB%B0%9C%EA%B8%B0-ad14433a0a75"
                   :깃허브 "https://github.com/hatemogi/colorlog"}
                  {:연도 2016 :제목 "클로저 기반 한글 프로그래밍 언어 실험, misaeng"
                   :깃허브 "https://github.com/hatemogi/misaeng"}
                  {:연도 2014 :제목 "Dvorak자판과 함께 쓰는, macOS 한글 입력기 (IME)"
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/dvorak%EA%B3%BC-%ED%95%9C%EA%B8%80-%EC%9E%85%EB%A0%A5%EA%B8%B0-%EA%B0%9C%EB%B0%9C-8940bc4714a1"
                   :깃허브 "https://github.com/hatemogi/AewolInput"}
                  {:연도 2014 :제목 "유의적 버전 Sematic Versioning 한국어 번역"
                   :깃허브 "https://github.com/hatemogi/semver"
                   :링크 "https://semver.org/lang/ko/"}
                  {:연도 1998 :제목 "wkobo, X11용 2D 슈팅 게임을 Windows용으로 포팅 개발"
                   :링크 "https://www.old-games.com/download/3123/wkobo"}
                  {:연도 1994 :제목 "직접 제작한 한글 그래픽 라이브러리를 활용해 만든 3인용 테트리스 게임"
                   :유튜브 "https://www.youtube.com/watch?v=U0ZhSs5a3Ws"}]))])

(def 교육
  [:section [:h2 "교육 수료"]
   (map (fn [{주제 :주제 연도 :연도 수료증 :수료증}]
          [:article.course
           [:div 연도 ", " 주제 " "
            (when 수료증 [:a {:href 수료증 :title "수료증"} [:i {:class "fa-solid fa-certificate"}]])]])
        (sort-by :연도 >
                 [{:연도 2022 :주제 "Introduction to TensorFlow for Artificial Intelligence, Machine Learning, and Deep Learning"
                   :수료증 "https://coursera.org/share/34d3458e34c700f354ab36b780e739c6"}
                  {:연도 2022 :주제 "Convolutional Neural Networks in TensorFlow"
                   :수료증 "https://coursera.org/share/83e63aa087183fbe753ae0d99a4a0e7d"}
                  {:연도 2022 :주제 "Natural Language Processing in TensorFlow"
                   :수료증 "https://coursera.org/share/34d3458e34c700f354ab36b780e739c6"}
                  {:연도 2022 :주제 "Sequences, Time Series and Prediction"
                   :수료증 "https://coursera.org/share/72e4bc85275b4234a9c0384ea6053979"}
                  {:연도 2021 :주제 "Effective Programming in Scala"
                   :수료증 "https://coursera.org/share/e3adcc29353c58ae20733d4075c2a97c"}
                  {:연도 2019 :주제 "Functional Program Design in Scala"
                   :수료증 "https://coursera.org/share/7ff7f8b81abfbc9df1e81974e1a0c256"}
                  {:연도 2019 :주제 "Big Data Analysis with Scala and Spark"
                   :수료증 "https://coursera.org/share/ffd008aeadbb568643b17d7c5f58077a"}
                  {:연도 2019 :주제 "Kotlin for Java Developers"
                   :수료증 "https://coursera.org/share/1fea494a120389564cf16c6dcc815888"}
                  {:연도 2013 :주제 "Functional Programming Principles in Scala"
                   :수료증 "https://www.coursera.org/api/legacyCertificates.v1/spark/statementOfAccomplishment/971423~66457/pdf"}
                  {:연도 2011 :주제 "Erlang OTP Course, San Francisco 교육 수료"
                   :수료증 "/img/ErlangOTP.jpg"}
                  {:연도 2006 :주제 "연세대학교 > 경영대학원 > 연세-Daum MBA 과정 수료"}
                  {:연도 2001 :주제 "Java Architecture Planning & Design for J2EE 교육 수료"
                   :수료증 "/img/J2EE.jpg"}
                  {:연도 2000 :주제 "Sun Certified Java Programmer for JAVA2 자격증 취득"
                   :수료증 "/img/SCJP2.jpg"}
                  {:연도 1999 :주제 "정보처리기사 자격증 취득"}]))])

(def 인기글
  [:section [:h2 "인기 글"]
   (map (fn [{주제 :주제 미디엄 :미디엄 연도 :연도}]
          [:article.인기글
           [:div.title 연도 ", " 주제 " "
            (when 미디엄 [:a {:href 미디엄 :title "설명글"} [:i {:class "fa-brands fa-medium"}]]) " "]])
        (sort-by :연도 >
                 [{:주제 "개알못인 당신이 웹개발을 시작한다면 (1)"
                   :연도 2017
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/%EA%B0%9C%EC%95%8C%EB%AA%BB%EC%9D%B8-%EB%8B%B9%EC%8B%A0%EC%9D%B4-%EC%9B%B9%EA%B0%9C%EB%B0%9C%EC%9D%84-%EC%8B%9C%EC%9E%91%ED%95%9C%EB%8B%A4%EB%A9%B4-1-9415c014a130"}
                  {:주제 "다음 캘린더 서비스 개발 비하인드 스토리"
                   :연도 2020
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/%EB%8B%A4%EC%9D%8C-%EC%BA%98%EB%A6%B0%EB%8D%94-%EC%84%9C%EB%B9%84%EC%8A%A4%EC%9D%98-%EB%B9%84%ED%95%98%EC%9D%B8%EB%93%9C-%EC%8A%A4%ED%86%A0%EB%A6%AC-ec0faac67f05"}]))])

(def 꼬리말 [:footer [:p "@hatemogi"]])

(def 본문 [:main 경력 스킬셋 발표경험 사이드프로젝트 학력 교육 인기글])

(def 바디 [:body 머리말 본문 꼬리말])

(-> (html5 헤더 바디) str print)