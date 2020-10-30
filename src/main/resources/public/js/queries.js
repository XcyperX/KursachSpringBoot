submitNewUser = () => {
    let createUser = document.forms.createUser;
    for (let i in createUser.elements) {
        let field = createUser.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof user[field.id] === 'number') {
                user[field.id] = Number(field.value);
            } else {
                user[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(user);
    registrationUser(user);
}

submitNewStock = () => {
    let addStock = document.forms.addStock;
    for (let i in addStock.elements) {
        let field = addStock.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof stock[field.id] === 'number') {
                stock[field.id] = Number(field.value);
            } else {
                stock[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(stock);
    registrationStock(stock);
}

submitNewRole = () => {
    let addRole = document.forms.addRole;
    for (let i in addRole.elements) {
        let field = addRole.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof role[field.id] === 'number') {
                role[field.id] = Number(field.value);
            } else {
                role[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(role);
    registrationRole(role);
}

const role = {
    role_id: -1,
    name: ""
}

const stock = {
    stock_id: -1,
    name: ""
}

const user = {
    user_id: -1,
    username: "",
    password: "",
    stock_id: -1,
    role_id: -1
}

registrationRole = (role) => {
    sendRequest('POST', '/api/roles', role).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

registrationStock = (stock) => {
    sendRequest('POST', '/api/stocks', stock).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

registrationUser = (user) => {
    sendRequest('POST', '/api/users', user).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

sendRequest = (method, url, body) => {
    const headers = {
        'Content-Type': 'application/json'
    }
    console.log(body);
    if (body !== null) {
        return fetch(url, {
            method: method,
            body: JSON.stringify(body),
            headers: headers
        });
    } else {
        return fetch(url, {
            method: method,
            headers: headers
        });
    }
}