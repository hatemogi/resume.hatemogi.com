(require '[hiccup.core :refer [html]])

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