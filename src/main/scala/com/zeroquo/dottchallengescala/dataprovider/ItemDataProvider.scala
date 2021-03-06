package com.zeroquo.dottchallengescala.dataprovider

import java.time.{LocalDate, LocalDateTime, LocalTime, Month}

import com.zeroquo.dottchallengescala.usecase.entity.Item
import com.zeroquo.dottchallengescala.usecase.entity.Product

import scala.annotation.tailrec
import scala.util.Random

object ItemDataProvider {

  def generateRandomItemsList: List[Item] = {

    val listRandomSize = new Random().nextInt(5) + 1

    val itemList = getAllItens

    def fillList(size: Int) : List[Item] = {
      @tailrec
      def filler(x: Int = 0, list: List[Item] = Nil) : List[Item] =
        if(x == size) list
        else filler(x + 1, itemList(new Random().nextInt(itemList.size)) :: list)

      filler()
    }

    fillList(listRandomSize)
  }

  def getAllItens: List[Item] =
    List(Item(cost = 10.0, shippingFee = 2.0, taxAmount = 10.0, product =
      Product(name = "Zelda Breath of the Wild", category = "Game", weight = 20.0, price = 50.0,
        creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Fast RMX (Shin'en Multimedia)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "I am Setsuna (Square Enix)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "New Frontier Days: Founding Pioneers (Arc System Works)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Othello (Arc System Works)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Shovel Knight: Treasure Trove (Yacht Club Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Shovel Knight: Specter of Torment (Yacht Club Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Vroom in the Night Sky (Poisoft)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Snake Pass (Sumo Digital)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.MARCH, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Graceful Explosion Machine (Vertex Pop)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.APRIL, 6), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Jackbox Party Pack 3 (Jackbox Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.APRIL, 13), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Slime-san (Fabraz)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.JUNE, 8), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Mighty Gunvolt Burst (Inti Creates)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.JUNE, 15), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Oceanhorn: Monster of Uncharted Seas (FDG Entertainment)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.JUNE, 22), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "GoNNER (Raw Fury Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.JUNE, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Bulb Boy (Bulbware)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.JULY, 6), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Shephy (Arc System Works)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.JULY, 6), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Vaccine (Rainy Frog)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.JULY, 6), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Implosion (Flyhigh Works)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.JULY, 6), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "J.B. Harold Murder Club (Riverhill Soft)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.AUGUST, 10), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Ironcast (Ripstone)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.AUGUST, 10), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Phantom Trigger (TinyBuild)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.AUGUST, 10), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Double Dragon IV (Arc System Works)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.SEPTEMBER, 7), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Pankapu (Plug In Digital)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.SEPTEMBER, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Wulverblade (Darwind Media)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.SEPTEMBER, 30), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Earth Atlantis (Headup Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.OCTOBER, 5), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Stardew Valley (Chucklefish Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.OCTOBER, 5), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Yono and the Celestial Elephants (Plug In Digital)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.OCTOBER, 12), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Sparkle 2 EVO (Forever Entertainment)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.NOVEMBER, 2), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Super Beat Sports (Harmonix)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.NOVEMBER, 2), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Wheels of Aurelia (MixedBag)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.NOVEMBER, 2), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Frederic: Resurrection of Music (Forever Entertainment)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "FruitFall Crush (System 3)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Guns, Gore and Cannoli (Crazy Monkey)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Max: The Curse of Brotherhood (Stage Clear Studios)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Mom Hid My Game! (Kemco)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Puzzle Box Maker (Bplus)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "The Coma: Recut (Digerati)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Energy Cycle (Sometimes You)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 25), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Sparkle Unleashed (10tons)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2017, Month.DECEMBER, 25), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Rocket League: Collector's Edition", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 16), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Lost Sphear (Square Enix)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JANUARY, 23), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Dragon Quest Builders (Square Enix)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.FEBRUARY, 9), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Overcooked (Team17)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.FEBRUARY, 13), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Attack on Titan 2 (Koei Tecmo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 20), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "PriPara: All Idol Perfect Stage (Takara Tomy)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 22), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Atelier Lydie & Suelle: The Alchemists and the Mysterious Paintings (Koei Tecmo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 27), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Aokana: Four Rhythm Across the Blue (Sprite)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Thimbleweed Park (Limited Run Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.MARCH, 30), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Penny-Punching Princess (NIS America)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Wild Guns Reloaded (Natsume-Atari/Natsume Inc.)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 17), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "NeoAtlas 1469 (Artdink)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 19), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Gal Gun 2 (Inti Creates)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 24), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Hello Kitty Kruisers (Rising Star Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 24), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Max: The Curse of Brotherhood (Wired Productions)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 24), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "De Blob (THQ Nordic)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JUNE, 26), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Wolfenstein 2: The New Colossus (Bethesda)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JUNE, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Crash Bandicoot N. Sane Trilogy (Activision)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JUNE, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Runbow (Merge Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Shining Resonance Refrain (Sega)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 10), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Captain Toad: Treasure Tracker (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 13), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Octopath Traveler (Square Enix)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 13), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Sonic Mania Plus (SEGA)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 17), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Adventure Time: Pirates of the Enchiridion (Outright Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 17), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Mega Man X Legacy Collection 1 + 2 (Capcom)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 24), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Hello Neighbor (Gearbox Software)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 27), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Code of Princess EX (Nicalis)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 31), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Flipping Death (Rising Star Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 31), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Titan Quest (THQ Nordic)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 31), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Touhou Genso Wanderer Reloaded (NIS America)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.JULY, 31), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Overcooked! 2 (Team17)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 7), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Dead Cells (Motion Twin)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 7), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Layton's Mystery Journey: Katrielle and the Millionaires' Conspiracy DX (Level-5)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 9), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Runbow Deluxe Edition (Merge Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 10), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Slain: Back to Hell (Merge Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 14), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Tennis World Tour (Maximum Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 14), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "The Coma: Recut (Merge Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 14), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "VOEZ (PM Studios)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 14), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Penguin Wars", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 15), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "All-Star Fruit Racing (PQube)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Candle: The Power of the Flame (Merge Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Dead Cells (Merge Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Little Dragon Cafe (Aksys Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 24), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Blade Strangers (Nicalis)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "de Blob 2 (THQ Nordic)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Monster Hunter Generations Ultimate (Capcom)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Victor Vran: Overkill Edition (Wired Productions)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Flinthook (Limited Run Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Mercenary Kings (Limited Run Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.AUGUST, 31), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Mercenaries Saga Chronicles (PM Studios)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 25), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Moonlighter (Merge Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 25), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Valkyria Chronicles 4: Memoirs From Battle Edition (SEGA)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 25), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Chicken Range", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Dragon Ball FighterZ (Bandai Namco Entertainment)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "FIFA 19 (Electronic Arts)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Monster Boy and the Cursed Kingdom (FDG Entertainment/Sega)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "The Lost Child (NIS America)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Katamari Damacy REROLL (Bandai Namco)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.DECEMBER, 1), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Super Smash Bros. Ultimate (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.DECEMBER, 7), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Sega Genesis Classics (Sega)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.DECEMBER, 7), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Kunio-kun: The World Classics Collection (Arc System Works)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2018, Month.DECEMBER, 25), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Fitness Boxing (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.JANUARY, 4), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "River City Girls (Limited Run Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 5), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Tetris 99 (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 6), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "NBA 2K20 (2K Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 6), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "DAEMON X MACHINA (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 13), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Star Wars Pinball (Zen Studios)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 13), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "LEGO Jurassic World (Warner Bros.)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 17), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "The Legend of Zelda: Link's Awakening (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 20), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Ni no Kuni: Wrath of the White Witch (Bandai Namco)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 20), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Dead by Daylight (Behaviour Interactive)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 24), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Contra: Rogue Corps (Konami)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 24), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Digimon Story Cyber Sleuth: Complete Edition (Bandai Namco)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 18), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "A Hat in Time (Humble Bundle)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 18), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Story of Seasons: Friends of Mineral Town (Marvelous)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 19), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Disney Classic Games: Aladdin and The Lion King (Nighthawk Interactive)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Super Monkey Ball: Banana Blitz HD (Sega)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Resident Evil Triple Pack (Capcom)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Vampyr (Maximum Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Atelier Ryza: Ever Darkness & the Secret Hideout (Koei Tecmo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 29), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Luigi's Mansion 3 (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 31), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Disgaea 4 Complete+ (NIS America)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 1), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Mario & Sonic at the Olympic Games Tokyo 2019 (Sega)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 5), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Garfield Kart: Furious Racing (Maximum Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 5), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Just Dance 2019 (Ubisoft)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 5), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Layton's Mystery Journey: Katrielle and the Millionaires' Conspiracy (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 8), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "New Super Lucky's Tale (Playful)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 8), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Pokémon Sword and Shield (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 15), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Jumanji: The Video Game (Outright Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 15), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Doom Eternal (Bethesda)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 22), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Neverwinter Nights: Enhanced Edition (Skybound Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2019, Month.DECEMBER, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Tokyo Mirage Sessions ♯FE Encore (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.JANUARY, 2), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Mega Man Zero/ZX Legacy Collection (Capcom)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.JANUARY, 5), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Rune Factory 4 Special (XSEED Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.JANUARY, 13), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Final Fantasy: Crystal Chronicles Remastered Edition (Square Enix)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.JANUARY, 31), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Gods & Monsters (Ubisoft)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.FEBRUARY, 21), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Animal Crossing: New Horizons (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.MARCH, 3), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Trials of Mana (Square Enix)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.APRIL, 1), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Digimon Survive (Bandai Namco)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.APRIL, 1), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Deadly Premonition 2: A Blessing In Disguise (Rising Star Games)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.APRIL, 1), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Little Nightmares 2 (Bandai Namco)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.APRIL, 4), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "No More Heroes III (Marvelous)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.APRIL, 5), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Langrisser I & II (NIS America)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.APRIL, 28), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Xenoblade Chronicles: Definitive Edition (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.MAY, 19), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Clubhouse Games: 51 Worldwide Classics (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.JUNE, 7), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Paper Mario: The Origami King (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.JULY, 2), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Just Dance 2021 (Ubisoft)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.NOVEMBER, 1), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Bayonetta 3 (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.NOVEMBER, 2), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Famicom Detective Club (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.NOVEMBER, 22), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Metroid Prime 4 (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 23), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "The Legend of Zelda (Nintendo)", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2020, Month.DECEMBER, 25), LocalTime.of(0, 0, 0)))),
      Item(cost = 20.0, shippingFee = 3.0, taxAmount = 20.0, product =
        Product(name = "Overcooked", category = "Game", weight = 20.0, price = 40.0,
          creationDate = LocalDateTime.of(LocalDate.of(2021, Month.JANUARY, 1), LocalTime.of(0, 0, 0))))
    )
}
