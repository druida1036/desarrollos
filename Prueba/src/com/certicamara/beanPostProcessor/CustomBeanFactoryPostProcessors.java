package com.certicamara.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanFactoryPostProcessors implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(null);

		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (String curName : beanNames) {
			// Check that we're not parsing our own bean definition,
			// to avoid failing on unresolvable placeholders in properties file
			// locations.

			
			BeanDefinition bd = beanFactory.getBeanDefinition(curName);
			System.out.println("postPBF "+curName+" definition "+bd.getDependsOn());
//			try {
//				visitor.visitBeanDefinition(bd);
//			} catch (Exception ex) {
//				throw new BeanDefinitionStoreException(bd.getResourceDescription(), curName, ex.getMessage(), ex);
//			}

		}

	}

}
