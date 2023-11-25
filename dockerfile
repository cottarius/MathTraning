FROM bellsoft/liberica-openjdk-alpine:latest
COPY . ./project
RUN mkdir ./out
RUN javac -sourcepath -d out ./project/src/Main.java
CMD java -classpath ./out src.Main