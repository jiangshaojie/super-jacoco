
#基础镜像
FROM java:8
WORKDIR /opt/his
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
ADD target/super-jacoco.jar /opt/his/super-jacoco.jar
ADD run.sh /opt/his/run.sh
#port
EXPOSE 50006

#执行
CMD ["bash","/opt/his/run.sh"]
#ENTRYPOINT ["bash","/opt/his/run.sh"]
