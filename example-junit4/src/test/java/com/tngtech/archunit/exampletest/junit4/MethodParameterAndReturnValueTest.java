package com.tngtech.archunit.exampletest.junit4;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMethods;

import javax.persistence.Entity;

import org.junit.runner.RunWith;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.properties.HasAnnotations;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.tngtech.archunit.example.methods")
public class MethodParameterAndReturnValueTest {

	@ArchTest
	static final ArchRule public_methods_in_rest_controllers_should_not_have_jpa_entities_as_parameter = 
			noMethods().that()
				.areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
				.and().arePublic()
				.should()
				.haveRawParameterTypes(DescribedPredicate.anyElementThat(HasAnnotations.Predicates.annotatedWith(Entity.class)));

	@ArchTest
	static final ArchRule public_methods_in_rest_controllers_should_not_have_jpa_entities_as_return_value = 
			noMethods().that()
			 	// check for name or package also possible
				.areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
				.and().arePublic()
				.should()
				.haveRawReturnType(HasAnnotations.Predicates.annotatedWith(Entity.class));
	
	@ArchTest
	static final ArchRule rest_mapping_methods_should_not_have_jpa_entities_as_return_value = 
			noMethods().that()
			 	.areAnnotatedWith(GetMapping.class)
			 	.or().areAnnotatedWith(PostMapping.class)
			 	.or().areAnnotatedWith(DeleteMapping.class)
			 	.or().areAnnotatedWith(PutMapping.class)
			 	.or().areAnnotatedWith(PatchMapping.class)
			 	.or().areAnnotatedWith(RequestMapping.class)
				.should()
				.haveRawReturnType(HasAnnotations.Predicates.annotatedWith(Entity.class));

}
