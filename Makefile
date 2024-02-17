SRC=resume.clj
OUT=index.html

build: ${SRC}
	clj -M ${SRC} | tee ${OUT} && open ${OUT}

watch:
	fswatch ${SRC} style.css | xargs -L1 -I{} sh -c "clj -M ${SRC} > ${OUT} && open ${OUT}"
