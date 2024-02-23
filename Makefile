SRC=resume.clj
OUT=docs/index.html

build: ${SRC}
	clj -M ${SRC} | tee ${OUT} && open ${OUT}
	cp style.css docs/

watch:
	fswatch ${SRC} style.css | xargs -L1 -I{} sh -c "clj -M ${SRC} > ${OUT} || cp style.css docs/ && open ${OUT}"

deploy: build
	aws --profile resume s3 cp docs s3://resume.hatemogi.com/ --recursive --exclude '.DS_Store'
	aws --profile resume cloudfront create-invalidation --no-cli-pager --distribution-id=EOG2UY17N1S9W --paths='/*'