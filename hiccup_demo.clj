(require '[hiccup2.core :refer [html]])

(str (html [:div]))

(html [:div])

(html [:div [:span] [:span]])

(html [:div "안녕하세요"])

(html [:div "굿" "이브닝"])

(html [:div {:class "foo"} "안녕하세요"])

(html [:div 42])

(html [:div '("foo" "bar")])

(html [:ul (for [i (range 3)] [:li i])])

(html [:div#foo "안녕하세요"])

(html [:div.foo "안녕하세요"])

(html [:div#foo.bar.baz "안녕하세요"])

(def 취미
  [:section [:h2 "취미"]
   [:article.취미
    [:div.컬럼.고딕 [:div "달리기"] [:div "누적 2,800㎞ 달림"]
     [:div "하프마라톤 PB 1시간 48분 "
      [:a {:href "img/half-marathon.png" :title "기록증"} [:i {:class "fa-solid fa-certificate"}]]]]]])

(html 취미)

(def 인기글
  [:section [:h2 "인기 글"]
   (map (fn [{주제 :주제 미디엄 :미디엄 연도 :연도}]
          [:article.인기글
           [:div.고딕 연도 ", " 주제 " "
            (when 미디엄 [:a {:href 미디엄 :title "설명글"} [:i {:class "fa-brands fa-medium"}]]) " "]])
        (sort-by :연도 >
                 [{:주제 "개알못인 당신이 웹개발을 시작한다면 (1)"
                   :연도 2017
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/9415c014a130"}
                  {:주제 "다음 캘린더 서비스 개발 비하인드 스토리"
                   :연도 2015
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/ec0faac67f05"}
                  {:주제 "3/8 판교 긴급 출장 24시"
                   :연도 2016
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/3bad70af3176"}]))
   [:blockquote "개발 블로그 삼아 미디엄에 글을 적기도 합니다. 그 중 조회수 기준으로 호응이 좋았던 글입니다. "
    "글에 개인 성향이 잘 드러나는 것은 물론이고, "
    "개발할 때 코드를 작성하는 것과, 사람이 읽을 글을 작성하는 것에 공통점이 많다고 생각하여 이력서에도 적었습니다."]])

(html 인기글)