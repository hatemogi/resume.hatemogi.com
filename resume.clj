(require '[hiccup.page :as h])

(def head
  [:head
   [:meta {:charset "UTF-8"}]
   [:title "김대현 이력서"]
   [:meta {:name "description" :content "김대현 이력서"}]
   [:meta {:name "author" :content "hatemogi"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
   [:script {:src "https://kit.fontawesome.com/5f3e877657.js" :crossorigin "anonymous"}]
   [:link {:rel "stylesheet" :href "style.css"}]])

(def intro
  [:header
   [:div [:img {:src "img/profile.jpg"}]]
   [:h1 "김대현"]
   [:section [:p "시니어 백엔드 개발자"]]])

(def 우수한기술
  (->> ["Scala" "Clojure" "Haskell" "SQL"]
       (map (partial vector :li))))

(def 충분한기술
  (->> ["Python" "TypeScript" "PostgreSQL"]
       (map (partial vector :li))))

(def skills
  [:section
   [:h3 "Skills"]
   [:div {:class "skills"}
    [:div {:class "column"} [:h4 "우수한 기술"] 우수한기술]
    [:div {:class "column"} [:h4 "충분한 기술"] 충분한기술]]])

(def work-experiences [:section [:h3 "Work Experiences"]])

(def main [:main work-experiences skills])

(def body [:body intro main])

(print (str (h/html5 head body)))