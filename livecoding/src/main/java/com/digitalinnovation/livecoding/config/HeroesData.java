package com.digitalinnovation.livecoding.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovation.livecoding.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovation.livecoding.constants.HeroesConstant.REGION_DYNAMO;

public class HeroesData {
  public static void main(String[] args) throws Exception {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
      .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
      .build();
    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("JogosXbox360");

    Item jogo = new Item()
      .withPrimaryKey("id", "2")
      .withString("name", "deadpool")
      .withString("violento", "maiores18")
      .withNumber("acao", 2);

    Item jogo2 = new Item()
      .withPrimaryKey("id", "3")
      .withString("name", "assassins creed")
      .withString("Ubisoft", "Ubisoft")
      .withNumber("acao", 2);

    Item hero3 = new Item()
      .withPrimaryKey("id", "4")
      .withString("name", "Capita marvel")
      .withString("universe", "marvel")
      .withNumber("films", 2);

    PutItemOutcome outcome1 = table.putItem(jogo);
    PutItemOutcome outcome2 = table.putItem(jogo2);
    PutItemOutcome outcome3 = table.putItem(hero3);

  }

}

