# https://resume.hatemogi.com

2024년, 오랜만에 이력서를 정돈하였습니다. 이래저래, 오래된 이력까지 다 긁어모으는 김에, 이번에는 웹페이지로도 작성해 보았습니다. [Clojure](https://clojure.org)를 이용해서 간결한 edn표현으로 작성한 내용을 HTML로 변환하는 재미가 쏠쏠했습니다.

혹시, 이력서를 웹페이지 버전으로 작성하려는데, 클로저 EDN 표현도 조금 다룰 줄 안신다면, 이 템플릿을 활용해서 이력서를 웹페이지 버전으로 준비해보시는 것도 좋을 것 같습니다.

## Example

```clojure
[:section [:h2 "취미"]
 [:article.취미
  [:div.컬럼.고딕
   [:div "달리기"]
   [:div "누적 2,500㎞ 달림"]
   [:div "하프마라톤 PB 1시간 49분 (5:08/㎞)"]]]]
```

예를들어, 위 EDN 표현은, 아래 HTML로 변환됩니다.

```html
<section>
  <h2>취미</h2>
  <article class="취미">
    <div class="컬럼 고딕">
      <div>달리기</div>
      <div>누적 2,500㎞ 달림</div>
      <div>하프마라톤 PB 1시간 49분 (5:08/㎞)</div>
    </div>
  </article>
</section>
```

조금 더 단순해지는 정도이지만, 추가로, 저 표현 중간중간 clojure표현식을 그대로 쓸 수 있다는 점이 매력입니다.

```clojure
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
                   :미디엄 "https://medium.com/happyprogrammer-in-jeju/3bad70af3176"}]))])
```

이런식으로 데이터와 HTML 뼈대를 분리해서 중복표현을 줄일 수 있습니다. 대신 클로저 문법을 조금 알아야 하겠죠. 😉


## Prepare

macOS 기준으로는 아래와 같이 준비합니다.


```sh
$ brew install clojure fswatch awscli
```

## Build

```sh
$ make build
```

일회성으로 `docs/index.html`을 생성합니다.

## Watch

```sh
$ make watch
```

지속적으로 편집하고자 할 때는, `make watch`를 걸어둡니다. `resume.clj` 파일이 변경될 때마다 `index.html`을 만듭니다.

## Deploy

```sh
$ make deploy
```

저는 S3에 올려서 CloudFront로 연결해두었습니다만, GitHub Pages에 준비하셔도 문제 없이 공개하실 수 있습니다.

## 라이선스

이 템플릿은 HTML이력서 작성이 필요한 누구나 마음대로 사용하실 수 있습니다.

## Acknowledgment

### 활용글꼴

* [넥슨 Lv.2 고딕](https://noonnu.cc/font_page/435)
* [고운돋움](https://noonnu.cc/font_page/734)

