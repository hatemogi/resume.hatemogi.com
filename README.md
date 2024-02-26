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
<section>
```

조금 더 단순해지는 정도이지만, 추가로, 저 표현 중간중간 clojure표현식을 그대로 쓸 수 있다는 점이 매력입니다.



## Prepare


```sh
$ brew install clojure fswatch awscli
```

## Build

```sh
$ make build
```


## Watch

```sh
$ make watch
```

## Deploy

```sh
$ make deploy
```

저는 S3에 올려서 CloudFront로 연결해두었습니다만, GitHub Pages에 준비하셔도 문제 없이 공개하실 수 있습니다.


## Acknowledgment

### 활용글꼴

* [넥슨 Lv.2 고딕](https://noonnu.cc/font_page/435)
* [고운돋움](https://noonnu.cc/font_page/734)
