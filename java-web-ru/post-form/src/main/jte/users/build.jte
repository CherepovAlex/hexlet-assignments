@template.layout.page(
    content = @`
        <h1>Регистрация</h1>
        <form action="/users" method="post" class="col-3">
            <div class="mb-3">
                <label class="form-label">
                    Имя
                    <input type="text" name="firstName" class="form-control" required />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Фамилия
                    <input type="text" name="lastName" class="form-control" required />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Email
                    <input type="email" name="email" class="form-control" required />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Пароль
                    <input type="password" name="password" class="form-control" required />
                </label>
            </div>
            <button type="submit" class="btn btn-primary">Зарегистрировать</button>
        </form>
    `
)