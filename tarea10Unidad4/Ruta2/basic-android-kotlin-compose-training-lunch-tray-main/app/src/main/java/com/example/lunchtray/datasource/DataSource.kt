/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * No puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia en:
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que la ley lo exija o se acuerde por escrito, este archivo
 * se distribuye "TAL CUAL", sin garantías de ningún tipo.
 */

package com.example.lunchtray.datasource

import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.model.MenuItem.SideDishItem

/**
 * Objeto singleton que representa la fuente de datos del menú.
 * Contiene listas de entradas, guarniciones y acompañamientos que se muestran en los fragmentos del menú.
 */
object DataSource {

    /**
     * Lista de entradas principales disponibles en el menú.
     * Cada entrada incluye nombre, descripción y precio.
     */
    val entreeMenuItems = listOf(
        EntreeItem(
            name = "Cauliflower",
            description = "Coliflor entera, marinada, rostizada y frita",
            price = 7.00,
        ),
        EntreeItem(
            name = "Three Bean Chili",
            description = "Frijoles negros, rojos y pintos cocinados lentamente con cebolla",
            price = 4.00,
        ),
        EntreeItem(
            name = "Mushroom Pasta",
            description = "Pasta penne con champiñones, albahaca y tomates en ajo y aceite de oliva",
            price = 5.50,
        ),
        EntreeItem(
            name = "Spicy Black Bean Skillet",
            description = "Vegetales de temporada, frijoles negros y especias, servido con aguacate y cebolla encurtida",
            price = 5.50,
        )
    )

    /**
     * Lista de guarniciones disponibles en el menú.
     */
    val sideDishMenuItems = listOf(
        SideDishItem(
            name = "Summer Salad",
            description = "Tomates, lechuga, duraznos, aguacate y aderezo balsámico",
            price = 2.50,
        ),
        SideDishItem(
            name = "Butternut Squash Soup",
            description = "Sopa de calabaza asada con pimientos y aceite de chile",
            price = 3.00,
        ),
        SideDishItem(
            name = "Spicy Potatoes",
            description = "Papas rústicas asadas y fritas con mezcla de especias",
            price = 2.00,
        ),
        SideDishItem(
            name = "Coconut Rice",
            description = "Arroz con leche de coco, lima y azúcar",
            price = 1.50,
        )
    )

    /**
     * Lista de acompañamientos disponibles para el menú.
     */
    val accompanimentMenuItems = listOf(
        AccompanimentItem(
            name = "Lunch Roll",
            description = "Panecillo fresco horneado en casa",
            price = 0.50,
        ),
        AccompanimentItem(
            name = "Mixed Berries",
            description = "Mezcla de fresas, moras azules, frambuesas y arándanos",
            price = 1.00,
        ),
        AccompanimentItem(
            name = "Pickled Veggies",
            description = "Pepinos y zanahorias encurtidos, preparados en casa",
            price = 0.50,
        )
    )
}
