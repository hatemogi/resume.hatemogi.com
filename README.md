# https://resume.hatemogi.com

2024년, 오랜만에 이력서를 정돈하였습니다. 이래저래, 오래된 이력까지 다 긁어모으는 김에, 이번에는 웹페이지로도 작성해 보았습니다. [Clojure](https://clojure.org)를 이용해서 간결한 edn표현으로 작성한 내용을 HTML로 변환하는 재미가 쏠쏠했습니다.

혹시, 이력서를 웹페이지 버전으로 작성하려는데, 클로저 EDN 표현도 조금 다룰 줄 안신다면, 이 템플릿을 활용해서 이력서를 웹페이지 버전으로 준비해보시는 것도 좋을 것 같습니다.

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
