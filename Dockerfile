FROM frolvlad/alpine-oraclejdk8:slim
COPY build/libs/hotel_booking-0.1.0.jar hotel_booking-0.1.0.jar
CMD java -jar hotel_booking-0.1.0.jar
EXPOSE 8080