# СберУниверситет
## Школа Java Developer (Поток 16)
Студент
## _Ельцов Дмитрий Александрович_
### Описание
В данном репозитории предоставлены выполненные домашние работы.
### Оглавление
[Домашнее задание №1 Знакомство с Java - main Java classes and packages](https://github.com/demon-may-cry/sberuniversity/tree/main?tab=readme-ov-file#домашнее-задание-1-знакомство-с-java---main-java-classes-and-packages)

[Домашнее задание №2 Коллекции Java – collection framework](https://github.com/demon-may-cry/sberuniversity/tree/main?tab=readme-ov-file#домашнее-задание-2-коллекции-java--collection-framework)

[Домашнее задание №3 Обобщенные классы – Generics](https://github.com/demon-may-cry/sberuniversity/tree/main?tab=readme-ov-file#домашнее-задание-3-обобщенные-классы--generics)

[Домашнее задание №4 Обработка исключений – Exception handling](https://github.com/demon-may-cry/sberuniversity/blob/main/README.md#домашнее-задание-4-обработка-исключений--exception-handling)

[Домашнее задание №5 Рефлексия, проксирование и аннотации – Reflection, Proxy, Annotations](https://github.com/demon-may-cry/sberuniversity/blob/main/README.md#домашнее-задание-5-рефлексия-проксирование-и-аннотации--reflection-proxy-annotations)

[Домашнее задание №6 Средства сборки, модульное тестирование - Module, Build tools, Testing]()

## Домашнее задание №1 _Знакомство с Java - main Java classes and packages_
**Цель:** познакомится со статическими и нестатическими блоками, определить, как и в какой последовательности вызываются блоки и конструкторы базового класса и наследников.

**Задание:**
Написать абстрактный класс _Parent_, реализовать:
1. приватное поле *Name*
2. статический блок, выводящий на экран «_Parent:static 1_»
3. нестатический блок, выводящий на экран «_Parent:instance 1_»
4. статический блок, выводящий на экран «_Parent:static 2_»
5. конструктор без параметров, выводящий на экран «_Parent:constructor_»
6. нестатический блок, выводящий на экран «_Parent:instance 2_»
7. конструктор c параметром _Name_, выводящий на экран «_Parent:name-constructor_»
   
Написать класс _Child_, расширяющий класс _Parent_, реализовать:
1. статический блок, выводящий на экран «_Child:static 1_»
2. нестатический блок, выводящий на экран «_Child:instance 1_»
3. статический блок, выводящий на экран «_Child:static 2_»
4. конструктор без параметров, выводящий на экран «_Child:constructor_»
5. конструктор c параметром _Name_, выводящий на экран «_Child:name-constructor_»
6. нестатический блок, выводящий на экран «_Child:instance 2_»
   
Создать два объекта _Child()_, _Child(“Ivan”)_

[Выполненое домашнее задание №1](HW1_MainJavaClassesAndPackages/src/main/java/ru/sberuniversity/classesandpackages)

[К оглавлению](https://github.com/demon-may-cry/sberuniversity/blob/main/README.md#оглавление)

## Домашнее задание №2 _Коллекции Java – collection framework_
**Цель:** познакомиться с коллекциями

**Задание №1:**
Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.

**Задание №2:**
Написать простой класс телефонный справочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода _add()_ можно добавлять записи. С помощью метода _get()_ искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

> Примечание: Не реализуйте ничего лишнего, чего нет в задании (не добавляйте имя, отчество, адрес и проч, не надо делать взаимодействие через консоль и т.д.) Тестировать методы _add()_ и _get()_, вызывая из метода _main_.

[Выполненое домашнее задание №2](HW2_CollectionsFramework/src/main/java/ru/sberuniversity/collections)

[К оглавлению](https://github.com/demon-may-cry/sberuniversity/blob/main/README.md#оглавление)

## Домашнее задание №3 _Обобщенные классы – Generics_
**Цель:** познакомиться с обощенными классами _Generics_

**Задание №1:**
Параметризовать CountMap из [репозитория](https://github.com/sbtjavaschool/generics) и реализовать его.
```
public interface CountMap {
   // добавляет элемент в этот контейнер.
   void add(Object o);

   //Возвращает количество добавлений данного элемента
   int getCount(Object o);

   //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
   int remove(Object o);

   //количество разных элементов
   int size();

   //Добавить все элементы из source в текущий контейнер, 
   // при совпадении ключей,     суммировать значения
   void addAll(CountMap source);

   //Вернуть java.util.Map. ключ - добавленный элемент, 
   // значение - количество его добавлений
   Map toMap();

   //Тот же самый контракт как и toMap(), только всю информацию записать в destination
   void toMap(Map destination);
}
```
Пример использования:
```
CountMap<Integer> map = new CountMapImpl<>();

map.add(10);
map.add(10);
map.add(5);
map.add(6);
map.add(5);
map.add(10);

// int count = map.getCout(5);  // 2
// int count = map.getCout(6);  // 1
// int count = map.getCout(10); // 3
```
**Задание №2:**
Параметризовать методы, используя правило PECS, и реализовать их.
```
public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static List newArrayList() { }

    public static int indexOf(List source, Object o) { }

    public static List limit(List source, int size) { }

    public static void add(List source, Object o) { }

    public static void removeAll(List removeFrom, List c2) { }

    public static boolean containsAll(List c1, List c2) { }

    public static boolean containsAny(List c1, List c2) { }

    public static List range(List list, Object min, Object max) { }

    public static List range(List list, Object min, Object max, Comparator comparator) { }
}
```
Пояснения к некоторым методам.
```
//true если первый лист содержит все элементы второго
public static boolean containsAll(List c1, List c2) {
}

//true если первый лист содержит хотя-бы 1 второго
public static boolean containsAny(List c1, List c2) {
}   

//Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max. 
// Элементы сравнивать через Comparable.
// Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
public static List range(List list, Object min, Object max) {
}

//Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max. 
// Элементы сравнивать через Comparable.
// Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
public static List range(List list, Object min, Object max, Comparator comparator) {
}
```

[Выполненое домашнее задание №3](HW3_Generics/src/main/java/ru/sberuniversity/generics)

[К оглавлению](https://github.com/demon-may-cry/sberuniversity/blob/main/README.md#оглавление)

## Домашнее задание №4 _Обработка исключений – Exception handling_
**Цель:** научиться выявлять и обрабатывать исключения

**Задание №1:**
Реализовать интерфейс _Terminal_, c помощью которого можно:
- Проверить состояние счета
- Снять/положить деньги

Доступ к терминалу (терминал для одного счета) предоставляется только после ввода корректного пин-кода (4 цифры). Каждое нажатие должно восприниматься системой как ввод очередного символа пин-кода.

При вводе нецифрового символа система должна выдать предупреждение, но при этом данное действие не считается критичной ошибкой ввода и состояние системы должно восстановиться к последнему корректному состоянию.

При вводе 3 неправильных пин-кодов аккаунт блокируется на 10 сек (при попытке обратиться к нему в течение этого времени должно вызываться исключение _AccountIsLockedException_ c информацией об оставшемся времени до снятия блокировки).

Класть и снимать деньги можно только, если сумма кратна 100.

Поскольку банкоматы, установленные на улице, сами «ничего не делают» с вашим счетом (они лишь делают проверку введенных данных и отправляют запросы на удаленный), то сервер (_TerminalServer_) может вызывать свои исключения, например, при недостатке средств на счете для совершения операции.

Класс терминал может содержать следующие поля:
```
class TerminalImpl {
    private final TerminalServer server;
    private final PinValidator pinValidator; 
   ...
}
```
Часть команд терминал делегирует этим классам.

Интерфейс терминала и список исключений остается на ваш дизайн. В каждом ексепшене должно быть описание, что нужно сделать, чтобы избежать его в дальнейшем.

_TerminalServer_ и _PinValidator_ могут кидать свои собственные исключения. Конечный пользователь не должен видеть эти исключения, ему должны показываться человеко-читабельные сообщения об ошибках

Логика по показу сообщений конечному пользователю и бизнес логика терминала с обработкой исключений должна быть в разных классах, чтобы можно было легко менять интрефейс вывода сообщений (на консоль, через графический интерфейс и т.д.)

**Задание №2:**
Реализуйте метод _readContent(String url)_, который отображает на экран содержимое сайта, ссылка на который задаётся параметром url.
Напишите программу, считывающую из консоли строку (URL ресурса) и вызывающую метод _readContent_. В том случае, если введённый URL неправильного формата или нет доступа до указанного ресурса, пользователю предлагается повторить ввод.

**Задание №3:**
Вопросы для самоконтроля:
1. Правильно ли написан следующий код:
   ```
   try {
    
   } finally {
    
   }
   ```
   **Ответ:** Да, т.к. блок _finally_ выполнится независимо от того, было исключение или нет
2. Какие исключения могут быть перехвачены следующим обработчиком:
   ```
   catch (Exception e) {
     
   }
   ```
   Что не так с использованием такого обработчика?
   
    **Ответ:** Обработчик _catch (Exception e)_ перехватывает любые исключения, так как улавливает исключения типа _Exception_. Использование такого обработчика может быть плохой реализацией, т.к. теряется информация о типе выданного исключения.
4. Имеется ли ошибка в написании такого обработчика исключения? Скомпилируется ли этот код?
   ```
   try {

   } catch (Exception e) {
    
   } catch (ArithmeticException a) {
    
   }
   ```
   **Ответ:** Данный код не скомпилиируется, т.к. имеется ошибка. Обработчки исключений должны находится в порядке от наиболее конкретного исключения к наиболее общему. _ArithmeticException_ более конкретное, чем _Exception_. Для правильного выполнения данного кода, необходимо разместить _ArithmeticException_ в первый блок _catch_, а _Exception_ во второй блок _catch_.
5. Сопоставьте каждую ситуацию из первого списка с пунктом второго списка:
   |Ситуация                                                                                                           | Вариант                   |
   |-------------------------------------------------------------------------------------------------------------------|----------------------------|
   |A. _int[] A; A[0] = 0;_                                                                                            |1. Ошибка;                  |
   |B. JVM начинает запускать вашу программу, но обнаруживает, что не может найти классы Java платформы;               |2. Проверяемое исключение;  |
   |C. Программа читает входной поток и достигает маркера конца потока;                                                |3. Ошибка компиляции;       |
   |D. После достижения маркера конца входного потока, но до закрытия самого потока, программа пытаться считать данные.|4. Исключение не произойдёт.|
   
   **Ответ:** A-3, B-1, C-4, D-2

   [Выполненое домашнее задание №4](HW4_ExceptionHandling)
   
   [К оглавлению](https://github.com/demon-may-cry/sberuniversity/blob/main/README.md#оглавление)

## Домашнее задание №5 _Рефлексия, проксирование и аннотации – Reflection, Proxy, Annotations_
**Цель:** познакомиться с механизмом рефлексии, проксированием и аннотациями. Научиться создавать собственные аннотации.

**Задание №1:**
Имплементировать следующий интерфейс в классе _CalculatorImpl_
```
public interface Calculator{
	/**
	* Расчет факториала числа.
	* @param number 
	*/
	int calc (int number);
}
```
**Задание №2:**
Вывести на консоль все методы класса, включая все родительские методы (включая приватные)

**Задание №3:**
Вывести все геттеры класса

**Задание №4:**
Проверить что все String константы имеют значение = их имени
```
public static final String MONDAY = "MONDAY";
```

**Задание №5:**
Реализовать кэширующий прокси

**Задание №6:**
Создать свою аннотацию Metric. Реализовать proxy класс PerformanceProxy, который в случае, если метод аннотирован Metric, будет выводить на консоль время выполнения метода. Т.е. написав:
```
public interface Calculator{
	/**
	* Расчет факториала числа.
	* @param number 
	*/
	@Metric
	int calc (int number);
}
```
И использовав его 
```
Calculator  calculator=new PerformanceProxy(new Calculator()));
System.out.println(calculator.calc(3));
```
Должны увидеть:
```
Время работы метода: ххххх (в наносек)
6
```

**Задание №7:**
Реализовать следующий класс по документации
```
public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {... }
}
```
**Задание №8:**
Вопросы для самоконтроля:
1. Почему на любом объекте можем вызвать метод _getClass()_?
   
   **Ответ:** Метод _getClass()_ можно вызвать на любом объекте в Java, потому что он является частью класса Object, который является базовым классом для всех других классов в Java
2. Почему на любом классе можем вызвать .class?
   
   **Ответ:** Обращение к .class после имени типа возвращает объект типа Class. Этот объект содержит информацию о типе (класс или интерфейс) и используется в тех местах, где нужно передать информацию о типе
3. В чём отличие динамического прокси от статического? Приведите преимущества и недостатки.

   **Ответ:** Динамические прокси создаются во время выполнения, с использованием механизма Reflection. Для этого прокси должен реализовывать хотя бы один интерфейс. Статический прокси создаются вручную (собственной реализацией интерфейса). Реализация прокси-класса фиксирована во время написания кода.
   
   Динамический прокси:
   
      Плюсы:
      - Не нужно создавать вручную новые классы для прокси, все происходит динамически
      - Один прокси может быть использован для множества интерфейсов
      - Можно добавить поведение или изменить логику во время выполнения
        
      Минусы:
      - Работает только с интерфейсами (не с классами)
      - Сложнее понимать и отлаживать из-за использования Reflection
      - Производительность ниже, чем у статического прокси
        
   Статический прокси:
   
      Плюсы:
      - Код легко читается, объект прокси полностью под контролем
      - Не требует использования рефлексии, проще и производительнее
        
      Минусы:
      - Нужно писать прокси вручную для каждого интерфейса
      - Не поддерживает динамических сценариев (например, если интерфейс или реализации часто меняются)

6. Есть ли разница в инициализации класса через _new_ и статический метод _newInstance()_?

   **Ответ:** Ключевое слово _new_ создает экземпляр класса, выделяя память для нового экземпляра указанного типа. Метод _newInstance()_ в Java используется для динамического создания экземпляра объекта данного класса. Метод _newInstance()_ работает медленнее, чем _new_ из-за того, что тип объекта нельзя жёстко запрограммировать в байт-код, а также из-за того, что JVM может проверять разрешения, чтобы убедиться, что у вас есть права на создание объекта. Она также частично небезопасна, потому что всегда использует конструктор без параметров, и если у объекта нет конструктора без параметров, возникает исключение.
   
8. Можно ли с помощью рефлексии изменить значения полей аннотации?

   **Ответ:** Да, Java позволяет создавать новые аннотации на основе существующих. Класс Java предоставляет метод _getAnnotation()_ для получения доступа к аннотациям класса. Java класс содержит _Map_ для управления аннотациями и хранит в себе класс аннотаций в качестве ключей и объект аннотаций в качестве значений. Чтобы изменить аннотацию во время выполнения, необходимо обновить _Map_. [В разных версиях JDK реализация данного подхода отличается.](https://www.baeldung.com/java-reflection-change-annotation-params)

[Выполненое домашнее задание №5](HW5_ReflectionProxyAnnotations/src/main/java/ru/sberuniversity/reflectionproxyannotations)

[К оглавлению](https://github.com/demon-may-cry/sberuniversity/blob/main/README.md#оглавление)

## Домашнее задание №6 _Средства сборки, модульное тестирование - Module, Build tools, Testing_
**Цель:** познакомиться со средствами сборки Maven. Научиться создавать собственные тесты с использованием JUnit5 и Mock.

**Задание №1:**
Вопросы для самоконтроля:
1. Что означает аннотация _@Before_?
   
   **Ответ:** Аннотация _@Before_ используется для указания метода, который будет выполняться перед каждым тестом. Это полезно, когда необходимо инициализировать или сбросить состояние тестового объекта перед каждым тестом.

2. Как в тесте проверить, что метод должен бросить исключение?
   **Ответ:** В JUnit 5, чтобы написать тестовый код, который вызовет исключение, необходимо использовать Assertions.assertThrows().

3. Что такое _mock_? _Spy_?
   **Ответ:** _Mock_ — это объект-заглушка, имитирующий поведение реального объекта. _Spy_ — это частично реальный объект, но с возможностью отслеживать вызовы методов и изменять их поведение.

4. Для чего применяется статический метод _Mockito.verify_?
   **Ответ:** Метод _verify()_ в Mockito используется для проверки, был ли вызван метод объекта. Он используется, чтобы убедиться, что метод был вызван с определенными параметрами, количеством раз, когда он вызывался, и т.д.

**Задание №2:**
Реализуйте свой итератор массива объектов. Напишите тесты для проверки его работоспособности. Оформите сборку кода через maven.

**Задание №3:**
Спроектировать дизайн социальной сети. В данном задании интересует разбитие приложения на модули, взаимодействие интерфейсов, а не реализация конкретных классов.

Социальные сети обычно предлагают большой набор сервисов: поиск/добавление друзей, просмотр профилей, загрузка и просмотр фото, общение через чат или стены, рекомендации, подарки и куча других сервисов. Все эти сервисы должны находится в отдельных модулях и иметь связи между собой.
Ваша задача создать _maven_ проект, создать модули для каждого сервиса, прописать зависимости одних модулей от других. В каждом модуле должны быть интерфейсы и доменная модель данного сервиса + в некоторых модулях нужна примерная реализация интерфейсов, где показано как используются интерфейсы других модулей.
Написать юнит тесты к классам из данного задания (с помощью JUnit 5 + Mockito)

[Выполненое домашнее задание №6]()

[К оглавлению](https://github.com/demon-may-cry/sberuniversity/blob/main/README.md#оглавление)
