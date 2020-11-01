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

submitUpdateUser = () => {
    let updateUser = document.forms.updateUser;
    for (let i in updateUser.elements) {
        let field = updateUser.elements[i];
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
    updatesUser(user);
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

submitNewProduct = () => {
    let addProduct = document.forms.addProduct;
    for (let i in addProduct.elements) {
        let field = addProduct.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof product[field.id] === 'number') {
                product[field.id] = Number(field.value);
            } else {
                product[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(product);
    registrationProduct(product);
}

submitUpdateProduct = () => {
    let updateProduct = document.forms.updateProduct;
    for (let i in updateProduct.elements) {
        let field = updateProduct.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof product[field.id] === 'number') {
                product[field.id] = Number(field.value);
            } else {
                product[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(product);
    updatesProduct(product);
}

const product = {
    product_id: -1,
    name_product: "",
    stock_id: -1,
    amount_on_stock: -1,
    amount_on_sale: -1,
    price_product: -1,
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

registrationProduct = (product) => {
    sendRequest('POST', '/api/products', product).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
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

updatesUser = (user) => {
    console.log(user);
    sendRequest('PUT', '/api/users/' + user.user_id, user).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/users";
        } else {
            console.log(response);
        }
    });
}

updatesProduct = (product) => {
    console.log(user);
    sendRequest('PUT', '/api/products/items/' + product.product_id, product).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/products";
        } else {
            console.log(response);
        }
    });
}

deleteUser = (userId) => {
    console.log(user);
    sendRequest('DELETE', '/api/users/' + userId).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/users";
        } else {
            console.log(response);
        }
    });
}

deleteProduct = (productId) => {
    console.log(user);
    sendRequest('DELETE', '/api/products/items/' + productId).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.href = "http://localhost:8080/products";
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