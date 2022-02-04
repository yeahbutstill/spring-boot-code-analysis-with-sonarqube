# spring-boot-code-analysis-with-sonarqube

What is SonarQube ? SonarQube is an open source platform to perform automatic reviews with static analysis of code. What
is static code analysis? Computer code that is performed without actually executing programs. Source code will be
checked for compliance with a predefined set of rules or best practices set by the organization. SonarQube also checks
the duplication of code, Lack of unit tests, potential bugs, no coding standard and not enough or too many comments or
incorrect comments.

* Setup Postgre in Docker

```shell
docker run --rm \
--name ist-db \
-e POSTGRES_DB=istdb \
-e POSTGRES_USER=ist \
-e POSTGRES_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v "$PWD/istdb-data:/var/lib/postgresql/data" \
-p 5432:5432 \
postgres:13
```

* Login psql

```shell
  psql -h 127.0.0.1 -U ist istdb
```
