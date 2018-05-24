FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER Aleksey Ekimtsov "aleksey.ekimtsov@gmail.com"
VOLUME ["/app"]
COPY maven/app.jar app.jar
COPY maven/start.sh start.sh
COPY maven/wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch app.jar'
RUN chmod +x 'start.sh'
RUN chmod +x 'wait-for-it.sh'
ENTRYPOINT ["./start.sh"]