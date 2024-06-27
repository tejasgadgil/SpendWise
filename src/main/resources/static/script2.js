document.addEventListener('DOMContentLoaded', function() {
    const userId = '12345'; // Replace with actual user ID from session

    const openSidebarBtn = document.getElementById('open-sidebar');
    const closeSidebarBtn = document.getElementById('close-sidebar');
    const sidebar = document.querySelector('.sidebar');

    openSidebarBtn.addEventListener('click', function() {
        sidebar.style.left = '0';
    });

    closeSidebarBtn.addEventListener('click', function() {
        sidebar.style.left = '-300px';
    });

    // Fetch and display notifications
    fetch(`/pfm/notifications/${userId}`)
        .then(response => response.json())
        .then(data => {
            const notificationsDiv = document.getElementById('notifications');
            notificationsDiv.innerHTML = data.notifications.map(n => `<p>${n.message}</p>`).join('');
        });

    // Fetch and display transactions
    fetch(`/pfm/transactions/${userId}`)
        .then(response => response.json())
        .then(data => {
            const transactionsDiv = document.getElementById('transactions');
            transactionsDiv.innerHTML = data.transactions.map(t => `<p>${t.amount} - ${t.category} on ${t.date}</p>`).join('');
        });

    // Fetch and display budgets
    fetch(`/pfm/budget/${userId}`)
        .then(response => response.json())
        .then(data => {
            const budgetsDiv = document.getElementById('budgets');
            budgetsDiv.innerHTML = data.budgets.map(b => `<p>${b.category} - ${b.spent}/${b.monthlyLimit}</p>`).join('');
        });

    // Fetch and display goals
    fetch(`/pfm/goals/${userId}`)
        .then(response => response.json())
        .then(data => {
            const goalsDiv = document.getElementById('goals');
            goalsDiv.innerHTML = data.goals.map(g => `<p>${g.goalName} - ${g.savedAmount}/${g.targetAmount} by ${g.deadline}</p>`).join('');
        });

    // Handle add transaction form submission
    document.getElementById('add-transaction-form').addEventListener('submit', function(event) {
        event.preventDefault();
        const transaction = {
            customerId: document.getElementById('customerId').value,
            amount: document.getElementById('amount').value,
            category: document.getElementById('category').value,
            date: document.getElementById('date').value,
        };
        fetch('/pfm/transactions', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(transaction)
        })
        .then(response => response.json())
        .then(data => {
            alert(`Transaction added: ${data.transactionId}`);
            location.reload();
        });
    });

    // Handle set budget form submission
    document.getElementById('set-budget-form').addEventListener('submit', function(event) {
        event.preventDefault();
        const budget = {
            customerId: document.getElementById('budgetCustomerId').value,
            category: document.getElementById('budgetCategory').value,
            monthlyLimit: document.getElementById('monthlyLimit').value,
        };
        fetch('/pfm/budget', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(budget)
        })
        .then(response => response.json())
        .then(data => {
            alert(`Budget set: ${data.budgetId}`);
            location.reload();
        });
    });

    // Handle set goal form submission
    document.getElementById('set-goal-form').addEventListener('submit', function(event) {
        event.preventDefault();
        const goal = {
            customerId: document.getElementById('goalCustomerId').value,
            goalName: document.getElementById('goalName').value,
            targetAmount: document.getElementById('targetAmount').value,
            deadline: document.getElementById('deadline').value,
        };
        fetch('/pfm/goals', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(goal)
        })
        .then(response => response.json())
        .then(data => {
            alert(`Goal set: ${data.goalId}`);
            location.reload();
        });
    });
});
