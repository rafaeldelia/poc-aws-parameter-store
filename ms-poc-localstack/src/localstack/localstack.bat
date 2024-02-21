@echo off
aws --endpoint http://localhost:4566 --profile localstack ssm put-parameter --name "/config/ms-poc-localstack_localstack/helloWorld" --value "HEELLOOO" --type String