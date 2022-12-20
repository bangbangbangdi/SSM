## 自动装配
> 描述：根据指定的策略，在IOC容器中匹配某个bean，自动为bean中的类类型的属性或接口类型的属性赋值

> 如何开启：可以通过bean标签中的autowire属性设置自动装配的策略

> 自动装配的策略：
> 1. no，default：表示不装配，即bean中的属性不会自动匹配某个bean为属性赋值，
> 此时属性使用默认值
> 2. byType：根据要赋值的属性和类型，在IOC容器中匹配到某个bean，为属性赋值
> 3. byName：根据要赋值的属性的属性名，在IOC容器中匹配到某个bean的id，为属性赋值

> 注意：
> 1. 若通过类型没有找到任何一个类型匹配的bean，此时不装配，属性使用默认值
> 2. 若通过类型找到了多个类型匹配的bean，此时会抛出异常
>  
> 总结：当使用byType实现自动装配时，需要IOC容器中有且仅有一个类型匹配的bean
> 能够为属性赋值。当类型匹配有多个时，此时可以使用byName实现自动