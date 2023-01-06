FROM maven:3.8.7-amazoncorretto-17
ADD . ./btcturk-api-automation
WORKDIR /btcturk-api-automation


ENTRYPOINT mvn clean test -am -DtestXmlFile=paralelTest.xml -Dapi=java