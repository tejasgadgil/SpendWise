document.addEventListener('DOMContentLoaded', () => {
    fetchCustomers();
});

async function fetchCustomers() {
    try {
        const response = await fetch('/api');
        const customers = await response.json();

        customers.forEach(customer => {
            // Create a tab for each customer
            const customerTab = document.createElement('div');
            customerTab.classList.add('tab');
            customerTab.textContent = customer.customerName;

            // Fetch and create nested tabs for each budget
            customerTab.addEventListener('click', async () => {
                const budgetsResponse = await fetch(`/api/${customer.customerId}/budgets`);
                const budgets = await budgetsResponse.json();

                // Clear existing tabs and content
                document.getElementById('tabs').innerHTML = '';

                budgets.forEach(budget => {
                    const budgetTab = document.createElement('div');
                    budgetTab.classList.add('sub-tab');
                    budgetTab.textContent = budget.budgetName;

                    // Fetch and display transactions for this budget
                    budgetTab.addEventListener('click', async () => {
                        const transactionsResponse = await fetch(`/api/${customer.customerId}/budgets/${budget.budgetId}/transactions`);
                        const transactions = await transactionsResponse.json();

                        // Clear existing transaction list
                        document.getElementById('transactions').innerHTML = '';

                        transactions.forEach(transaction => {
                            const transactionItem = document.createElement('div');
                            transactionItem.textContent = `${transaction.transName}: ${transaction.transAmt}`;
                            document.getElementById('transactions').appendChild(transactionItem);
                        });
                    });

                    // Append budget tab to customer tab
                    customerTab.appendChild(budgetTab);
                });

                // Append customer tab to main tabs container
                document.getElementById('tabs').appendChild(customerTab);
            });

            // Append customer tab to main tabs container
            document.getElementById('tabs').appendChild(customerTab);
        });
    } catch (error) {
        console.error('Error fetching customers:', error);
    }
}



/////////////////////////////////////////

let selectedCustomerId;
let selectedBudgetId;

document.addEventListener('DOMContentLoaded', () => {
    fetchCustomers();

    document.getElementById('customerForm').addEventListener('submit', addCustomer);
    document.getElementById('budgetForm').addEventListener('submit', addBudget);
    document.getElementById('transactionForm').addEventListener('submit', addTransaction);
});

async function fetchCustomers() {
    try {
        const response = await fetch('/api');
        const customers = await response.json();
        const customerList = document.getElementById('customerList');
        customerList.innerHTML = '';
        customers.forEach(customer => {
            const li = document.createElement('li');
            li.textContent = customer.customerName;
            li.addEventListener('click', () => fetchBudgets(customer.customerId));
            customerList.appendChild(li);
        });
    } catch (error) {
        console.error('Error fetching customers:', error);
    }
}

async function fetchBudgets(customerId) {
    try {
        selectedCustomerId = customerId;
        const response = await fetch(`/api/${customerId}/budgets`);
        const budgets = await response.json();
        document.getElementById('customers').classList.add('hidden');
        document.getElementById('budgets').classList.remove('hidden');
        const budgetList = document.getElementById('budgetList');
        budgetList.innerHTML = '';
        budgets.forEach(budget => {
            const li = document.createElement('li');
            li.textContent = budget.budgetName;
            li.addEventListener('click', () => fetchTransactions(customerId, budget.budgetId));
            budgetList.appendChild(li);
        });
    } catch (error) {
        console.error('Error fetching budgets:', error);
    }
}

async function fetchTransactions(customerId, budgetId) {
    try {
        selectedBudgetId = budgetId;
        const response = await fetch(`/api/${customerId}/budgets/${budgetId}/transactions`);
        const transactions = await response.json();
        document.getElementById('budgets').classList.add('hidden');
        document.getElementById('transactions').classList.remove('hidden');
        const transactionList = document.getElementById('transactionList');
        transactionList.innerHTML = '';
        transactions.forEach(transaction => {
            const li = document.createElement('li');
            li.textContent = `${transaction.transName}: ${transaction.transAmt}`;
            transactionList.appendChild(li);
        });
    } catch (error) {
        console.error('Error fetching transactions:', error);
    }
}

async function addCustomer(event) {
    event.preventDefault();
    const customerName = document.getElementById('customerName').value;
    try {
        const response = await fetch('/api/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ customerName })
        });
        if (response.status === 201) {
            fetchCustomers();
        } else if (response.status === 409) {
            alert('Customer already exists.');
        }
    } catch (error) {
        console.error('Error adding customer:', error);
    }
}

async function addBudget(event) {
    event.preventDefault();
    const budgetName = document.getElementById('budgetName').value;
    const budgetAllotted = document.getElementById('budgetAllotted').value;
    const customerId = selectedCustomerId;
    try {
        const response = await fetch(`/api/${customerId}/budgets`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ budgetName, budgetAllotted })
        });
        if (response.status === 201) {
            fetchBudgets(customerId);
        }
    } catch (error) {
        console.error('Error adding budget:', error);
    }
}

async function addTransaction(event) {
    event.preventDefault();
    const transactionName = document.getElementById('transactionName').value;
    const transactionAmount = document.getElementById('transactionAmount').value;
    const customerId = selectedCustomerId;
    const budgetId = selectedBudgetId;
    try {
        const response = await fetch(`/api/${customerId}/budgets/${budgetId}/transactions`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ transName: transactionName, transAmt: transactionAmount })
        });
        if (response.status === 201) {
            fetchTransactions(customerId, budgetId);
        }
    } catch (error) {
        console.error('Error adding transaction:', error);
    }
}


//let selectedCustomerId;
//
//document.addEventListener('DOMContentLoaded', () => {
//    fetchCustomers();
//
//    document.getElementById('customerForm').addEventListener('submit', addCustomer);
//    document.getElementById('budgetForm').addEventListener('submit', addBudget);
//    document.getElementById('transactionForm').addEventListener('submit', addTransaction);
//});
//
//async function fetchCustomers() {
//    try {
//        const response = await fetch('/api');
//        const customers = await response.json();
//        const customerList = document.getElementById('customerList');
//        customerList.innerHTML = '';
//        customers.forEach(customer => {
//            const li = document.createElement('li');
//            li.textContent = customer.customerName;
//            li.addEventListener('click', () => fetchBudgets(customer.customerId));
//            customerList.appendChild(li);
//        });
//    } catch (error) {
//        console.error('Error fetching customers:', error);
//    }
//}
//
//async function fetchBudgets(customerId) {
//    try {
//        selectedCustomerId = customerId;
//        const response = await fetch(`/api/${customerId}/budgets`);
//        const budgets = await response.json();
//        document.getElementById('customers').classList.add('hidden');
//        document.getElementById('budgets').classList.remove('hidden');
//        const budgetList = document.getElementById('budgetList');
//        budgetList.innerHTML = '';
//        budgets.forEach(budget => {
//            const li = document.createElement('li');
//            li.textContent = budget.budgetName;
//            li.addEventListener('click', () => fetchTransactions(customerId, budget.budgetId));
//            budgetList.appendChild(li);
//        });
//    } catch (error) {
//        console.error('Error fetching budgets:', error);
//    }
//}
//
//async function fetchTransactions(customerId, budgetId) {
//    try {
//        const response = await fetch(`/api/${customerId}/transactions`);
//        const transactions = await response.json();
//        document.getElementById('budgets').classList.add('hidden');
//        document.getElementById('transactions').classList.remove('hidden');
//        const transactionList = document.getElementById('transactionList');
//        transactionList.innerHTML = '';
//        transactions.forEach(transaction => {
//            const li = document.createElement('li');
//            li.textContent = `${transaction.transName}: ${transaction.transAmt}`;
//            transactionList.appendChild(li);
//        });
//    } catch (error) {
//        console.error('Error fetching transactions:', error);
//    }
//}
//
//async function addCustomer(event) {
//    event.preventDefault();
//    const customerName = document.getElementById('customerName').value;
//    try {
//        const response = await fetch('/api/register', {
//            method: 'POST',
//            headers: { 'Content-Type': 'application/json' },
//            body: JSON.stringify({ customerName })
//        });
//        if (response.status === 201) {
//            fetchCustomers();
//        } else if (response.status === 409) {
//            alert('Customer already exists.');
//        }
//    } catch (error) {
//        console.error('Error adding customer:', error);
//    }
//}
//
//async function addBudget(event) {
//    event.preventDefault();
//    const budgetName = document.getElementById('budgetName').value;
//    const budgetAllotted = document.getElementById('budgetAllotted').value;
//    const customerId = selectedCustomerId;
//    try {
//        const response = await fetch(`/api/${customerId}/budgets`, {
//            method: 'POST',
//            headers: { 'Content-Type': 'application/json' },
//            body: JSON.stringify({ budgetName, budgetAllotted })
//        });
//        if (response.status === 201) {
//            fetchBudgets(customerId);
//        }
//    } catch (error) {
//        console.error('Error adding budget:', error);
//    }
//}
//
//async function addTransaction(event) {
//    event.preventDefault();
//    const transactionName = document.getElementById('transactionName').value;
//    const transactionAmount = document.getElementById('transactionAmount').value;
//    const customerId = selectedCustomerId;
//    try {
//        const response = await fetch(`/api/${customerId}/transactions`, {
//            method: 'POST',
//            headers: { 'Content-Type': 'application/json' },
//            body: JSON.stringify({ transName: transactionName, transAmt: transactionAmount })
//        });
//        if (response.status === 201) {
//            fetchTransactions(customerId, budgetId);
//        }
//    } catch (error) {
//        console.error('Error adding transaction:', error);
//    }
//}
//
//
////document.addEventListener('DOMContentLoaded', () => {
////    fetchCustomers();
////});
////
////async function fetchCustomers() {
////    try {
////        const response = await fetch('/api');  // Point to your local API
////        const customers = await response.json();
////        const customerList = document.getElementById('customerList');
////        customerList.innerHTML = '';
////        customers.forEach(customer => {
////            const li = document.createElement('li');
////            li.textContent = customer.customerName;
////            li.addEventListener('click', () => fetchBudgets(customer.customerId));
////            customerList.appendChild(li);
////        });
////    } catch (error) {
////        console.error('Error fetching customers:', error);
////    }
////}
////
////async function fetchBudgets(customerId) {
////    try {
////        const response = await fetch(`/api/${customerId}/budgets`);  // Point to your local API
////        const budgets = await response.json();
////        document.getElementById('customers').classList.add('hidden');
////        document.getElementById('budgets').classList.remove('hidden');
////        const budgetList = document.getElementById('budgetList');
////        budgetList.innerHTML = '';
////        budgets.forEach(budget => {
////            const li = document.createElement('li');
////            li.textContent = budget.budgetName;
////            li.addEventListener('click', () => fetchTransactions(customerId));
////            budgetList.appendChild(li);
////        });
////    } catch (error) {
////        console.error('Error fetching budgets:', error);
////    }
////}
////
////async function fetchTransactions(customerId) {
////    try {
////        const response = await fetch(`/api/${customerId}/transactions`);  // Point to your local API
////        const transactions = await response.json();
////        document.getElementById('budgets').classList.add('hidden');
////        document.getElementById('transactions').classList.remove('hidden');
////        const transactionList = document.getElementById('transactionList');
////        transactionList.innerHTML = '';
////        transactions.forEach(transaction => {
////            const li = document.createElement('li');
////            li.textContent = `${transaction.transName}: ${transaction.transAmt}`;
////            transactionList.appendChild(li);
////        });
////    } catch (error) {
////        console.error('Error fetching transactions:', error);
////    }
////}
