INSERT INTO customer (customer_id, customer_name) VALUES (1, 'John Doe');
INSERT INTO customer (customer_id, customer_name) VALUES (2, 'Riya');
INSERT INTO budget (budget_id, budget_name, budget_owner_customer_id, budget_allotted, budget_spent) VALUES (1, 'Monthly Budget', 1, 1000, 0);
INSERT INTO transaction (trans_id, trans_name, trans_amt, transaction_budget_id, transaction_customer_id) VALUES (1, 'Groceries', 100, 1, 1);