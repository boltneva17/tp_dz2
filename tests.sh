#!/bin/bash

# Run tests and capture output
test_output=$(mvn test)

# Check if tests passed
if [[ $test_output == *"BUILD SUCCESS"* ]]; then
  message="ОК"
else
  message="Первый непройденный тест:
  $test_output"
fi

curl -s -X POST "https://api.telegram.org/bot${TELEGRAM_TOKEN}/sendMessage" \
    -d "chat_id=${TELEGRAM_CHAT_ID}" \
    -d "text=${message}"
