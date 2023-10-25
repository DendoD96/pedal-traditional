## Deploying the Application

This document outlines the steps to deploy the Java application on two machines using JBoss 7.4 in domain mode. The application utilizes two databases; an MSSQL Server running on a Windows Server 2012 VM, and a PostgresQL database running on the main machine.

### Pre-Requisites

1. JBoss 7.4 installed on both machines. If not installed, refer to the [JBoss 7.4 Installation Guide](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.0/html/installation_guide/).
2. Ensure that the Windows Server 2012 VM is set up and running.
3. Ensure that PostgreSQL is installed on the main machine.

### Setting up JBoss in Domain Mode

Follow the instructions provided in the [Red Hat Documentation](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.0/html/configuration_guide/domain_management#set_up_domain_two_machines) to set up JBoss 7.4 in domain mode on two machines.

### Setting up the Databases

#### MSSQL Server on Windows Server 2012 VM:

1. Connect to the Windows Server 2012 VM.
2. Run the `employees.sql` script to set up the necessary tables in the MSSQL database.

```bash
sqlcmd -S <SERVER_NAME> -U <USERNAME> -P <PASSWORD> -i employees.sql
```

#### PostgreSQL Server on Main Machine
On the main machine, run the users.sql script to set up the necessary tables in the PostgreSQL database.

```bash
psql -U <USERNAME> -d <DATABASE_NAME> -a -f users.sql
```

### Deploying the Application
Find the .war file in the /out/artifacts/bike_commerce_jar folder. 
Copy the application .war file to the deployments directory of the domain controller.
Start the domain controller and host controllers on both machines

```bash
./domain.sh -c domain.xml
```
