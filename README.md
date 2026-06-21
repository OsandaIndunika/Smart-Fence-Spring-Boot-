# Smart Fence Backend

This repository contains the backend implementation of the **Smart Fence: Human–Elephant Conflict Mitigation System**, developed using **Spring Boot** and **MySQL**.

## Overview

The Smart Fence system is an IoT-based solution designed to reduce human–elephant conflicts by providing real-time monitoring and early warning alerts. This backend application processes data received from ESP32-based Smart Fence devices, stores and manages alert information, and provides APIs and WebSocket services for real-time communication with the frontend dashboard.

## Features

* Real-time processing of elephant detection alerts
* RESTful API services for data management
* WebSocket-based live notifications
* Alert history and event management
* MySQL database integration
* Location and risk-zone monitoring support
* Secure and scalable backend architecture

## Technology Stack

* Java
* Spring Boot
* Spring Data JPA
* Spring WebSocket
* MySQL
* Maven

## System Architecture

ESP32 Sensors → Spring Boot Backend → MySQL Database → WebSocket/REST API → React Dashboard

## Purpose

The backend serves as the central processing unit of the Smart Fence system, enabling real-time alert dissemination, data storage, and communication between IoT devices and monitoring applications to improve community safety and support wildlife conservation.
