## Run locally on Docker

- `git clone https://github.com/abhirockzz/javaee8-jsonb-jpa.git` 
- `mvn clean install` - this will produce `javaee8-jsonb-jpa.war` in `target` directory
- `docker build -t <image_name> .` - this will create a Docker image
- `docker run --rm -it -e ADMIN_PASSWORD=<gf_admin_password_of_your_choice> -p 8080:8080 -p 4848:4848 -p 8181:8181 <image_name>`
- what's the Docker host IP ? `docker-machine ip` (e.g. 192.168.99.100)

## Run it on Oracle Container Cloud

[See this](https://community.oracle.com/community/cloud_computing/oracle-cloud-developer-solutions/blog/2017/07/13/try-our-json-b-10-jpa-22-using-java-ee-8-on-glassfish-5#jive_content_id_Run_on_Oracle_Container_Cloud) 

## Test it...

- Fetch all employees `http://<HOST_IP>:8080/javaee8-jsonb-jpa/employees/`. You will get a JSON payload with all employees
- Fetch an employee - `http://<HOST_IP>:8080/javaee8-jsonb-jpa/employees/abhirockzz@gmail.com`. You will see a JSON payload in as a response
