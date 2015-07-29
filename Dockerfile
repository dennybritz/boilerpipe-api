FROM java:8-jre

# Install sbt
RUN echo "deb http://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list && \
  apt-get update && \
  apt-get install -y --force-yes sbt && \
  apt-get clean

COPY . /app
WORKDIR /app

RUN sbt clean && \
  sbt compile && \
  sbt stage

ENV PORT 80
EXPOSE 80

CMD ["./target/universal/stage/bin/boilerpipe-api"]
