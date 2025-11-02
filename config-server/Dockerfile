# sıfır bir makinede(freedos) bu propjeyi nasıl kuraurım?
# işletim sistemi -> java -> maven/gradle -> project source code -> run

#FROM: yeni bir katmana başlıyorum, buradan başlat
#FROM debian: yeni oluşturulacak image'aişletim sistemi kurulmuş oluyor

#diğer katmanları içeriyor, katmanlarıyla beraber geliyor.işletim sistemi kurmayı hızlandırdık.
FROM maven:3.9-eclipse-temurin-21-alpine
# işletim sistemi -> java -> maven aşamaarı yapılmış oldu

# project source code -> run
#projenin kodlarını kurulan ubuntuya alma
#app klasörüne geçiş   cd desktop gibi
WORKDIR /app
# sol taraf ana dizin, sağ taraftaki docker'daki işletim sistemi
COPY . .
# bütün dosyaları docker'ın içindeki işletim sistemindeki app klasörüne taşı

# docker'da da jar dosyası oluşmalı ki son halini alsın
RUN mvn dependency:purge-local-repository
RUN mvn clean package -DskipTests

ENTRYPOINT ["java", "-jar","target/config-server-0.0.1-SNAPSHOT.jar"]