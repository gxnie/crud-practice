# 은행 시스템 API 명세서
고객 정보 관리, 계좌 관리, 거래 내역 조회 ...

---

## 1. 고객 정보 관리 API

### 1.1 고객 등록
- **URL**: `/api/customers`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "name": "Robbie",
      "email": "Robbie@example.com",
      "phone": "010-1234-5678",
      "address": "123 Seoul"
    }
    ```
- **Response**:
    ```json
    {
      "id": 1,
      "name": "Robbie",
      "email": "Robbie@example.com",
      "phone": "010-1234-5678",
      "address": "123 Seoul"
    }
    ```

### 1.2 고객 조회
- **URL**: `/api/customers/{customerId}`
- **Method**: `GET`
- **Response**:
    ```json
    {
      "id": 1,
      "name": "Robbie",
      "email": "Robbie@example.com",
      "phone": "010-1234-5678",
      "address": "123 Seoul"
    }
    ```

### 1.3 고객 정보 수정
- **URL**: `/api/customers/{customerId}`
- **Method**: `PUT`
- **Request Body**:
    ```json
    {
      "name": "Robbie",
      "email": "Robbie@example.com",
      "phone": "010-1234-5678",
      "address": "123 Seoul"
    }
    ```
- **Response**:
    ```json
    {
      "id": 1,
      "name": "하진이",
      "email": "wlsdl7520@example.com",
      "phone": "010-1234-5678",
      "address": "Daegu"
    }
    ```

### 1.4 고객 삭제
- **URL**: `/api/customers/{customerId}`
- **Method**: `DELETE`
- **Response**:
    ```json
    {
      "message": "Deleted successfully"
    }
    ```

---

## 2. 계좌 관리 API

### 2.1 계좌 생성
- **URL**: `/api/accounts`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "customerId": 1,
      "accountType": "SAVINGS",
      "initialDeposit": 1000.0
    }
    ```
- **Response**:
    ```json
    {
      "accountId": 101,
      "customerId": 1,
      "accountType": "SAVINGS",
      "balance": 1000.0
    }
    ```

### 2.2 계좌 조회
- **URL**: `/api/accounts/{accountId}`
- **Method**: `GET`
- **Response**:
    ```json
    {
      "accountId": 101,
      "customerId": 1,
      "accountType": "SAVINGS",
      "balance": 1000.0
    }
    ```

### 2.3 계좌 잔액 조회
- **URL**: `/api/accounts/{accountId}/balance`
- **Method**: `GET`
- **Response**:
    ```json
    {
      "accountId": 101,
      "balance": 1000.0
    }
    ```

### 2.4 계좌 삭제
- **URL**: `/api/accounts/{accountId}`
- **Method**: `DELETE`
- **Response**:
    ```json
    {
      "message": "Deleted successfully"
    }
    ```

---

## 3. 거래 내역 API

### 3.1 거래 내역 조회
- **URL**: `/api/transactions`
- **Method**: `GET`
- **Request Parameters**:
    - `customerId`: `1`
    - `startDate`: `2024-01-01`
    - `endDate`: `2024-01-31`
- **Response**:
    ```json
    [
      {
        "transactionId": 1001,
        "accountId": 101,
        "transactionType": "DEPOSIT",
        "amount": 500.0,
        "transactionDate": "2024-01-15T10:00:00"
      },
      {
        "transactionId": 1002,
        "accountId": 101,
        "transactionType": "WITHDRAWAL",
        "amount": 200.0,
        "transactionDate": "2024-01-20T14:30:00"
      }
    ]
    ```

### 3.2 거래 생성
- **URL**: `/api/transactions`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "accountId": 101,
      "transactionType": "DEPOSIT",
      "amount": 1000.0
    }
    ```
- **Response**:
    ```json
    {
      "transactionId": 1003,
      "accountId": 101,
      "transactionType": "DEPOSIT",
      "amount": 1000.0,
      "transactionDate": "2024-02-01T11:00:00"
    }
    ```

### 3.3 특정 거래 조회
- **URL**: `/api/transactions/{transactionId}`
- **Method**: `GET`
- **Response**:
    ```json
    {
      "transactionId": 1001,
      "accountId": 101,
      "transactionType": "DEPOSIT",
      "amount": 500.0,
      "transactionDate": "2024-01-15T10:00:00"
    }
    ```
---