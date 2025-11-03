# MULTI STAGE
# .jar ile çalışan başka bir stage yazarak boyutu küçült
# katmana isim ver "as" ile.   1.stage
FROM maven:3.9-eclipse-temurin-21-alpine AS builder

WORKDIR /build
# sol taraf ana dizin, sağ taraftaki docker'daki işletim sistemi
COPY pom.xml ./
# pom.xml'i alıp dependency'leri ona göre indiriyor ki, onlar kopyalanmakla uğraşılmasın, docker kendi indirsin
RUN mvn -DskipTests dependency:purge-local-repository
# bağımlılıkları atlayarak kopyalayacak
COPY . .

RUN mvn clean package -DskipTests

# 2. katman. sadece runtime yapacak
FROM eclipse-temurin:21-jre AS runtime

# /build/target/*-SANPSHOT.jar  dosyasını /app/app.jar'a kopyala
COPY --from=builder /build/target/*-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]