package org.example;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Crear enumeración TipoPromocion
            TipoPromocion happyHour = TipoPromocion.HAPPY_HOUR;
            TipoPromocion verano = TipoPromocion.VERANO;
            TipoPromocion invierno = TipoPromocion.INVIERNO;

            // Crear unidades de medida
            UnidadMedida porciones8 = UnidadMedida.builder().denominacion("8 Porciones").build();
            UnidadMedida porciones4 = UnidadMedida.builder().denominacion("4 Porciones").build();
            UnidadMedida litro = UnidadMedida.builder().denominacion("1 Litro").build();

            entityManager.persist(porciones8);
            entityManager.persist(porciones4);
            entityManager.persist(litro);

            // Crear imágenes
            Imagen imagen1 = new Imagen(null, "Pizza grande Hawaiana");
            Imagen imagen2 = new Imagen(null, "Pizza grande Napolitana");
            Imagen imagen3 = new Imagen(null, "Pizza grande Muzza");
            Imagen imagen4 = new Imagen(null, "Pizza chica Hawaiana");
            Imagen imagen5 = new Imagen(null, "Pizza chica Napolitana");
            Imagen imagen6 = new Imagen(null, "Pizza chica Muzza");
            Imagen imagen7 = new Imagen(null, "Cerveza Andes");
            Imagen imagen8 = new Imagen(null, "Cerveza Quilmes");
            Imagen imahappy1 = new Imagen(null, "Promoción Happy Hour 1");
            Imagen imahappy2 = new Imagen(null, "Promoción Happy Hour 2");
            Imagen verano1 = new Imagen(null, "Promoción Verano 1");
            Imagen verano2 = new Imagen(null, "Promoción Verano 2");
            Imagen invierno1 = new Imagen(null, "Promoción Invierno 1");
            Imagen invierno2 = new Imagen(null, "Promoción Invierno 2");

            // Persistir imágenes
            entityManager.persist(imagen1);
            entityManager.persist(imagen2);
            entityManager.persist(imagen3);
            entityManager.persist(imagen4);
            entityManager.persist(imagen5);
            entityManager.persist(imagen6);
            entityManager.persist(imagen7);
            entityManager.persist(imagen8);
            entityManager.persist(imahappy1);
            entityManager.persist(imahappy2);
            entityManager.persist(verano1);
            entityManager.persist(verano2);
            entityManager.persist(invierno1);
            entityManager.persist(invierno2);

            // Crear artículos y relacionarlos con sus imágenes y unidades de medida
            Articulo pizzaGrandeHawaiana = Articulo.builder()
                    .denominacion("Pizza grande Hawaiana")
                    .precioVenta(1000.0)
                    .precioCompra(800.0)
                    .stockActual(50)
                    .stockMaximo(100)
                    .imagen(imagen1)
                    .unidadMedida(porciones8)
                    .build();

            Articulo pizzaChicaHawaiana = Articulo.builder()
                    .denominacion("Pizza chica Hawaiana")
                    .precioVenta(600.0)
                    .precioCompra(450.0)
                    .stockActual(60)
                    .stockMaximo(120)
                    .imagen(imagen4)
                    .unidadMedida(porciones4)
                    .build();

            Articulo pizzaGrandeNapolitana = Articulo.builder()
                    .denominacion("Pizza grande Napolitana")
                    .precioVenta(1100.0)
                    .precioCompra(450.0)
                    .stockActual(60)
                    .stockMaximo(120)
                    .imagen(imagen2)
                    .unidadMedida(porciones8)
                    .build();

            Articulo pizzaChicaNapolitana = Articulo.builder()
                    .denominacion("Pizza chica Napolitana")
                    .precioVenta(650.0)
                    .precioCompra(450.0)
                    .stockActual(60)
                    .stockMaximo(120)
                    .imagen(imagen5)
                    .unidadMedida(porciones4)
                    .build();

            Articulo pizzaGrandeMuzza = Articulo.builder()
                    .denominacion("Pizza grande Muzza")
                    .precioVenta(950.0)
                    .precioCompra(450.0)
                    .stockActual(60)
                    .stockMaximo(120)
                    .imagen(imagen3)
                    .unidadMedida(porciones8)
                    .build();

            Articulo pizzaChicaMuzza = Articulo.builder()
                    .denominacion("Pizza chica Muzza")
                    .precioVenta(550.0)
                    .precioCompra(450.0)
                    .stockActual(60)
                    .stockMaximo(120)
                    .imagen(imagen6)
                    .unidadMedida(porciones4)
                    .build();

            Articulo cervezaAndes = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioVenta(300.0)
                    .precioCompra(450.0)
                    .stockActual(60)
                    .stockMaximo(120)
                    .imagen(imagen7)
                    .unidadMedida(litro)
                    .build();

            Articulo cervezaQuilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(350.0)
                    .precioCompra(450.0)
                    .stockActual(60)
                    .stockMaximo(120)
                    .imagen(imagen8)
                    .unidadMedida(litro)
                    .build();

            // Persistir artículos
            entityManager.persist(pizzaGrandeHawaiana);
            entityManager.persist(pizzaChicaHawaiana);
            entityManager.persist(pizzaGrandeNapolitana);
            entityManager.persist(pizzaChicaNapolitana);
            entityManager.persist(pizzaGrandeMuzza);
            entityManager.persist(pizzaChicaMuzza);
            entityManager.persist(cervezaAndes);
            entityManager.persist(cervezaQuilmes);

            // Crear promociones y relacionarlas con artículos e imágenes
            Set<Articulo> articulosHappyHour = new HashSet<>();
            articulosHappyHour.add(pizzaGrandeHawaiana);
            articulosHappyHour.add(pizzaGrandeMuzza);
            articulosHappyHour.add(cervezaQuilmes);

            Set<Imagen> imagenesHappyHour = new HashSet<>();
            imagenesHappyHour.add(imahappy1);
            imagenesHappyHour.add(imahappy2);

            Promocion promocionHappyHour = Promocion.builder()
                    .denominacion("Promoción Happy Hour")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now().plusMonths(1))
                    .horaDesde(LocalTime.of(17, 0))
                    .horaHasta(LocalTime.of(20, 0))
                    .descripcionDescuento("Descuento especial Happy Hour")
                    .precioPromocional(1500.0)
                    .tipoPromocion(happyHour)
                    .articulos(articulosHappyHour)
                    .promoImagen(imagenesHappyHour)
                    .build();

            entityManager.persist(promocionHappyHour);

            Set<Articulo> articulosVerano = new HashSet<>();
            articulosVerano.add(pizzaChicaHawaiana);
            articulosVerano.add(pizzaGrandeNapolitana);
            articulosVerano.add(cervezaQuilmes);
            articulosVerano.add(cervezaAndes);

            Set<Imagen> imagenesVerano = new HashSet<>();
            imagenesVerano.add(verano1);
            imagenesVerano.add(verano2);

            Promocion promocionVerano = Promocion.builder()
                    .denominacion("Promoción Verano")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now().plusMonths(3))
                    .horaDesde(LocalTime.of(12, 0))
                    .horaHasta(LocalTime.of(23, 0))
                    .descripcionDescuento("Descuento especial Verano")
                    .precioPromocional(2000.0)
                    .tipoPromocion(verano)
                    .articulos(articulosVerano)
                    .promoImagen(imagenesVerano)
                    .build();

            entityManager.persist(promocionVerano);

            Set<Articulo> articulosInvierno = new HashSet<>();
            articulosInvierno.add(pizzaGrandeHawaiana);
            articulosInvierno.add(pizzaChicaMuzza);
            articulosInvierno.add(cervezaQuilmes);

            Set<Imagen> imagenesInvierno = new HashSet<>();
            imagenesInvierno.add(invierno1);
            imagenesInvierno.add(invierno2);

            Promocion promocionInvierno = Promocion.builder()
                    .denominacion("Promoción Invierno")
                    .fechaDesde(LocalDate.now())
                    .fechaHasta(LocalDate.now().plusMonths(2))
                    .horaDesde(LocalTime.of(18, 0))
                    .horaHasta(LocalTime.of(22, 0))
                    .descripcionDescuento("Descuento especial Invierno")
                    .precioPromocional(1600.0)
                    .tipoPromocion(invierno)
                    .articulos(articulosInvierno)
                    .promoImagen(imagenesInvierno)
                    .build();

            entityManager.persist(promocionInvierno);

            entityManager.getTransaction().commit();

            // Mostrar las promociones creadas
            System.out.println("Promociones:");
            System.out.println(promocionHappyHour);
            System.out.println(promocionVerano);
            System.out.println(promocionInvierno);

        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
    }
}
