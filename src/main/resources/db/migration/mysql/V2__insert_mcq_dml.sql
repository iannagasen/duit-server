-- /*
INSERT INTO topic
VALUES (1, 'AWS');

INSERT INTO question_types 
VALUES 
(1, 'MCQ'), 
(2, 'IDENTIFICATION');

INSERT INTO mcq
VALUES 
(1, 1, 'Which of the following is a key feature of Amazon EC2');

INSERT INTO identification
VALUES 
(1, 1, 'Auto Scaling', 'Give a key feature of Amazon EC2', null);


INSERT INTO mcq_choices 
VALUES (
  1, 1,
  'Auto Scaling',
  'Auto Scaling is a key feature of Amazon EC2 that allows you to automatically adjust the number of instances in an EC2 fleet based on demand. It helps maintain application availability, optimize performance, and reduce costs by scaling up or down as needed',
  'Y'
),
(
  2, 1,
  'Content Delivery Network (CDN)',
  'CDN is not a key feature of Amazon EC2. It is a separate service offered by Amazon called Amazon CloudFront',
  'N'
),
(
  3, 1,
  'Relational Database Service (RDS)',
  'RDS is not a key feature of Amazon EC2. It is a separate managed database service offered by Amazon.',
  'N'
),
(
  4, 1,
  'Object Storage Service (S3)',
  'S3 is not a key feature of Amazon EC2. It is a separate storage service offered by Amazon',
  'N'
);
-- */

/***** Generated by GPT *****/
-- INSERT statements for mcq table
INSERT INTO mcq (topic_id, question)
VALUES (1, 'What is the default storage type of Amazon RDS?');

INSERT INTO mcq (topic_id, question)
VALUES (1, 'Which AWS service provides a fully-managed Kubernetes control plane?');

INSERT INTO mcq (topic_id, question)
VALUES (1, 'Which AWS service is used for serverless computing?');

INSERT INTO mcq (topic_id, question)
VALUES (1, 'What AWS service is used for data warehousing and big data analytics?');

INSERT INTO mcq (topic_id, question)
VALUES (1, 'Which AWS service is used for content delivery and caching?');

INSERT INTO mcq (topic_id, question)
VALUES (1, 'What AWS service provides a scalable and fully managed Apache Kafka service?');

INSERT INTO mcq (topic_id, question)
VALUES (1, 'Which AWS service provides a managed graph database?');

-- INSERT statements for mcq_choices table
INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (1, 'Amazon EBS', 'Amazon Elastic Block Store (EBS) is the default storage type for Amazon RDS.', 'Y');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (1, 'Amazon S3', 'Amazon Simple Storage Service (S3) is not the default storage type for Amazon RDS.', 'N');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (1, 'Amazon DynamoDB', 'Amazon DynamoDB is a NoSQL database and not the default storage type for Amazon RDS.', 'N');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (2, 'Amazon EKS', 'Amazon Elastic Kubernetes Service (EKS) provides a fully-managed Kubernetes control plane.', 'Y');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (2, 'Amazon ECS', 'Amazon Elastic Container Service (ECS) is a container orchestration service, but it is not fully-managed like EKS.', 'N');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (3, 'AWS Lambda', 'AWS Lambda is a serverless computing service that lets you run code without provisioning or managing servers.', 'Y');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (3, 'Amazon EC2', 'Amazon Elastic Compute Cloud (EC2) is not serverless, as it requires you to provision and manage virtual machines.', 'N');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (4, 'Amazon Redshift', 'Amazon Redshift is a fully-managed data warehousing and big data analytics service.', 'Y');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (4, 'Amazon RDS', 'Amazon RDS is a managed relational database service and not specifically designed for big data analytics.', 'N');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (5, 'Amazon CloudFront', 'Amazon CloudFront is a content delivery network (CDN) service that delivers content with low latency and high data transfer speeds.', 'Y');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (6, 'Amazon MSK', 'Amazon Managed Streaming for Apache Kafka (MSK) provides a scalable and fully managed Apache Kafka service.', 'Y');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (6, 'Amazon SQS', 'Amazon Simple Queue Service (SQS) is a fully managed message queuing service, not Apache Kafka.', 'N');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (7, 'Amazon Neptune', 'Amazon Neptune is a fully managed graph database service.', 'Y');

INSERT INTO mcq_choices (mcq_id, choice, explanation, is_correct)
VALUES (7, 'Amazon DynamoDB', 'Amazon DynamoDB is a NoSQL database, not a graph database.', 'N');
/****************************/

