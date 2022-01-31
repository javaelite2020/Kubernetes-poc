FROM tomcat:9.0-alpine
COPY k8s-product-catalog-web/target/k8s-product-catalog-v1.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]