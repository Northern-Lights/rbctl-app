FROM docker.io/openjdk:8

ENV OUTDIR "/build"

RUN apt update && apt install -y \
	libprotoc-dev \
	gcc \
	g++

RUN git clone https://github.com/grpc/grpc-java

RUN cd grpc-java && ./gradlew installDist

# compiler is now at compiler/build/exe/java_plugin/protoc-gen-grpc-java
