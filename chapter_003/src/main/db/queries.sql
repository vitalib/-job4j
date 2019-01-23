--В системе заданы таблицы
--
--product(id, name, type_id, expired_date, price)
--
--type(id, name)
--
--Задание.


-- 1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT product.name
    FROM product
    INNER JOIN type ON product.type_id = type.id
        WHERE type.name = 'СЫР';

2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"

SELECT name
    FROM product
    WHERE name LIKE '%мороженное%';

3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT name
    FROM product
    WHERE EXTRACT(MONTH FROM now()) + 1 = EXTRACT(MONTH from expired_date);

4. Написать запрос, который выводит самый дорогой продукт.
SELECT name
    FROM product
    WHERE product.price = (SELECT max(price) FROM product) ;

5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT type.name, count(*)
    FROM type
    INNER JOIN product ON type.id = product.type_id
        GROUP BY type.id;

6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT type.name, count(*)
    FROM type
    INNER JOIN product ON type.id = product.type_id
        WHERE type.name in('СЫР', 'МОЛОКО')
    GROUP BY type.id;


7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT type_name, type_count FROM(
    SELECT
        type.name AS type_name,
        count(*) as type_count
        FROM type
        INNER JOIN product ON type.id = product.type_id
        GROUP BY type.id
    ) as types
    WHERE type_count < 10;

8. Вывести все продукты и их тип.
SELECT product.name, type.name
    FROM product
    LEFT JOIN type ON product.type_id = type.id;