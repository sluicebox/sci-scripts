;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm301 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0)
	(HighPrint 301 0) ; "You suddenly realize that you don't have enough money to purchase what you want."
	(HighPrint 301 1) ; "Blustering, you say to Shema: "Your prices are too high for me!""
	(HighPrint 301 2) ; "As your face turns scarlet with embarrassment, Shema smiles and says:"
	(HighPrint 301 3) ; "We are sorry not to be able to show more generosity, but we, too, are victims of hard and evil times."
	(Shema setScript: goingIn)
)

(procedure (localproc_1)
	(HighPrint 301 4) ; "I am sorry, but I'm much too broken to talk about such things right now.  I have lost everything!"
)

(instance rm301 of Rm
	(properties
		picture 301
		south 300
	)

	(method (dispose)
		(SetFlag 89)
		(gMouseHandler delete: self)
		(merchant dispose:)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 301 303 304 302)
		(LoadMany rsSOUND 21 50)
		(rm301 style: (if (== gPrevRoomNum 302) 16 else 2))
		(super init:)
		(gMouseHandler add: self)
		(self
			setFeatures:
				onSleepDoor
				onLargeTable
				onFireplace
				onKitchenDoor
				onPlates
				onTable
		)
		(SL enable:)
		(self setLocales: 801)
		(= local2 5)
		(= local3 1)
		(= local4 3)
		(ClearFlag 254)
		(ClearFlag 303)
		(ClearFlag 112)
		(ClearFlag 302)
		(ClearFlag 300)
		(ClearFlag 301)
		(ClearFlag 111)
		(= global114 0)
		(NormalEgo)
		(gEgo init:)
		(tools init:)
		(shamLeg init:)
		(gAddToPics add: tools shamLeg doit:)
		(Chair init: stopUpd:)
		(SwDoor init: stopUpd:)
		(RmDoor
			cel: (if (== gPrevRoomNum 302) 2 else 0)
			setPri: 8
			init:
			ignoreActors:
			stopUpd:
		)
		(Fire init: setCycle: Fwd startUpd:)
		(if
			(and
				(or (== gTimeOfDay 4) (== gTimeOfDay 5))
				(or (not (IsFlag 115)) (== (Random 0 1) 0))
			)
			(SetFlag 115)
			(merchant init:)
			(gCast delete: merchant)
			(gCast addToFront: merchant)
		)
		(Shameen init:)
		(switch gPrevRoomNum
			(302
				(gEgo posn: 50 130 setMotion: MoveTo 70 130)
				(RmDoor setCycle: Beg)
			)
			(else
				(gEgo posn: 200 188 setMotion: MoveTo 200 175)
			)
		)
		(InnMusic init: play:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((and (not gNight) (Said 'japaneserestorsleep>')))
					(
						(or
							(Said 'nap,nap,rent,get,get,pay,buy/room,lodging')
							(Said 'go/nap,nap')
						)
						(if (not (gEgo inRect: 200 120 319 160))
							(HighPrint 301 5) ; "You must pay the innkeeper for a room."
						)
					)
					((Said 'look,look>')
						(cond
							((Said '[<at,around][/!*,room,building,hotel]')
								(HighPrint 301 6) ; "This looks like an alpine inn, complete with dishes on the wall and heavy beams on the ceiling. It is pleasantly warm, and the aroma of strange spices fills the air."
							)
							(
								(Said
									'/shameen,cat,katta,creature,owner,innkeeper,keeper'
								)
								(HighPrint 301 7) ; "You see a small, cat-like creature known as a Katta. You've heard that Kattas are common in the southern deserts."
							)
							((Said '/shema,hostess,girl,woman')
								(if (IsFlag 301)
									(HighPrint 301 8) ; "You see a rather attractive female Katta wearing her native costume."
								else
									(HighPrint 301 9) ; "She's not here."
								)
							)
							((Said '/man,abdulla')
								(if (gCast contains: merchant)
									(HighPrint 301 10) ; "The merchant is a rather fat man with a small moustache and beard. He wears a turban."
								else
									(HighPrint 301 11) ; "He's not here."
								)
							)
							((Said '/table')
								(HighPrint 301 12) ; "The tables look like they have been rough-cut from some of the local pines."
								(HighPrint 301 13) ; "One of the tables must have been made for some tall folks, perhaps Goons, Ogres, or Centaurs."
							)
							((Said '/chair')
								(HighPrint 301 14) ; "The chair is finely made, in contrast to the rough-hewn tables."
							)
							((Said '/door')
								(HighPrint 301 15) ; "The door with the window in it must be the door to the kitchen. The other door goes elsewhere in the Inn."
							)
							((Said '/wall')
								(HighPrint 301 16) ; "The walls have an ancient, solid look, well-worn and comfortable."
							)
							((or (Said '<up') (Said '/ceiling,beam'))
								(HighPrint 301 17) ; "The heavy timbers look substantial."
							)
							((or (Said '<down') (Said '/floor,carpet'))
								(HighPrint 301 18) ; "The oak planking is well-worn, and the carpet is clean, but becoming threadbare."
							)
							((Said '/mantle')
								(HighPrint 301 19) ; "The mantle above the hearth is a solid slab of wood. There is nothing on it."
							)
							((Said '/andiron,implement')
								(HighPrint 301 20) ; "The fireplace tools are placed neatly by the hearth, along with the proprietor."
							)
							(
								(Said
									'/cup,mug,mug,drink,drink,beverage,tea,coffee'
								)
								(switch global341
									(2
										(HighPrint 301 21) ; "The beverage is more fragrant than most."
									)
									(3
										(HighPrint 301 22) ; "You practically licked the inside of the cup. That was delicious."
									)
									(else
										(HighPrint 301 23) ; "You have no cup."
									)
								)
							)
							(
								(Said
									'/plate,bowl,food,breakfast,lamb,chicken,soup'
								)
								(switch global340
									(2
										(HighPrint 301 24) ; "The food looks unusual, but smells delicious."
									)
									(3
										(HighPrint 301 25) ; "You practically licked the plate clean. That was delicious."
									)
									(else
										(HighPrint 301 26) ; "The plates on the wall are strictly for decoration. Dishes with food on them are much more useful, if you're hungry."
									)
								)
							)
						)
					)
					((Said 'open,open,open/door')
						(cond
							((== (gEgo onControl: 1) 16384)
								(HighPrint 301 27) ; "For all that this door appears to be free to swing back and forth, it doesn't budge when you try to open it."
							)
							((== (gEgo onControl: 1) 8192)
								(HighPrint 301 28) ; "The door appears to be stuck fast."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'talk,talk/man')
						(NotClose)
					)
					((Said 'pay[/man,shameen,abdulla,shema]')
						(HighPrint 301 29) ; "For what?"
					)
					(
						(Said
							'smell,smell,odor/food,lamb,chicken,soup,spice,aroma'
						)
						(HighPrint 301 30) ; "The aromas are enticing."
					)
					((Said 'stand,stand')
						(if (IsFlag 254)
							(HighPrint 301 31) ; "You're already standing."
						else
							(event claimed: 0)
						)
					)
					((or (Said 'sat<down') (Said 'sat[/chair]'))
						(if (not (IsFlag 254))
							(if (gEgo inRect: 100 135 175 180)
								(gEgo setScript: sitScript)
								(Shameen setScript: shameenClaps)
							else
								(HighPrint 301 32) ; "Move closer to the chair."
							)
						else
							(HighPrint 301 33) ; "You're already sitting down."
						)
					)
					((Said 'eat,eat')
						(switch global340
							(0
								(if (IsFlag 254)
									(HighPrint 301 34) ; "If you're hungry, order a meal."
								else
									(HighPrint 301 35) ; "If you're hungry, you should sit down and order a meal."
								)
							)
							(1
								(HighPrint 301 36) ; "You haven't been served yet."
							)
							(2
								(cond
									((IsFlag 125)
										(ClearFlag 125)
										(ClearFlag 124)
									)
									((IsFlag 124)
										(ClearFlag 124)
										(= gFreeMeals 1)
									)
									(else
										(= gFreeMeals 2)
									)
								)
								(SolvePuzzle 721 1)
								(gEgo setScript: EatIt)
							)
							(3
								(HighPrint 301 37) ; "Both meal and drink have been consumed."
							)
						)
					)
					((Said 'drink,drink')
						(switch global341
							(0
								(if (IsFlag 254)
									(HighPrint 301 38) ; "If you're thirsty, order a drink."
								else
									(HighPrint 301 39) ; "If you're thirsty, you should sit down and order something to drink."
								)
							)
							(1
								(HighPrint 301 36) ; "You haven't been served yet."
							)
							(2
								(gEgo setScript: EatIt)
							)
							(3
								(HighPrint 301 40) ; "The drink you ordered is all gone."
							)
						)
					)
					(
						(or
							(Said '/hostess')
							(Said 'order,get,get/food,drink,drink')
						)
						(if (IsFlag 254)
							(cond
								(
									(or
										(IsFlag 112)
										(== global340 1)
										(== global340 2)
									)
									(HighPrint 301 41) ; "You have already ordered."
								)
								((> gFreeMeals 1)
									(HighPrint 301 42) ; "You're not hungry."
								)
								(gFreeMeals
									(HighPrint 301 43) ; "There's no need. You're not hungry."
								)
								((not (gCast contains: Shema))
									(= global340 0)
									(= global341 0)
									(Shema init:)
									(gCast delete: Shema)
									(gCast addToFront: Shema)
								)
								((and 0 (not (Shema script:)))
									(= global340 0)
									(= global341 0)
									(Shema setScript: comingOut)
								)
								(else
									(HighPrint 301 44) ; "Shema will be back soon."
								)
							)
						else
							(HighPrint 301 35) ; "If you're hungry, you should sit down and order a meal."
						)
					)
				)
			)
		)
	)
)

(instance Shameen of Prop
	(properties
		view 302
		loop 4
	)

	(method (init)
		(self posn: 238 119 setPri: 9 ignoreActors:)
		(self setScript: shameensIntro)
		(super init:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed Shameen event 3)
					(HighPrint 301 7) ; "You see a small, cat-like creature known as a Katta. You've heard that Kattas are common in the southern deserts."
				)
			)
			(evSAID
				(cond
					((Said 'talk,talk/man,cat,katta,shameen')
						(HighPrint 301 45) ; "Very good food, very good drink, finest in town. Sit, rest, you will be served by my Shema."
					)
					((and (not gNight) (Said 'japaneserestorsleep>')))
					(
						(or
							(Said 'nap,nap,rent,get,get,pay,buy[/room]')
							(Said 'go/nap,nap')
						)
						(cond
							((< 750 gClock 2550)
								(HighPrint 301 46) ; "It's too early to go to bed; you don't feel tired enough to sleep."
							)
							((IsFlag 125)
								(HighPrint 301 47) ; "You are sure that you would not be able to sleep, because you are so hungry."
							)
							((not (gEgo inRect: 200 120 319 160))
								(HighPrint 301 48) ; "You must pay the innkeeper for a room."
							)
							((Purchase local2)
								(SetFlag 122)
								(Shameen setScript: rentARoom)
							)
							(else
								(HighPrint 301 49) ; "Because your silver is too low, you must find other accomodations. Perhaps you can find work somewhere."
							)
						)
					)
					((Said 'ask>')
						(= local5 1)
						(cond
							((Said '//tavern,bar,bar')
								(HighPrint 301 50) ; "The tavern is located in the northwest corner of our town."
							)
							((Said '//abenteuer,hall[<club,about]')
								(HighPrint 301 51) ; "The Guild Hall is just down the street from here."
							)
							((Said '//zara,magic,shop')
								(HighPrint 301 52) ; "Zara's magic shop is next door to my Inn. You can't miss it."
							)
							((Said '//hotel,(fable<hero),replace,journey')
								(HighPrint 301 53) ; "I have run this inn for three years now, with Shema."
								(HighPrint 301 54) ; "We had thought to return to Shapeir, my homeland, with Abdulla Doo, but Alas, Fate has decreed otherwise."
							)
							((Said '//room,bed,nap,nap,rest,rest,lodging,cost')
								(HighPrint 301 55) ; "Very nice room. Very soft beds, finest in town. Only five silvers a night."
							)
							(
								(Said
									'//food,lamb,chicken,soup,drink,drink,breakfast,coffee,tea'
								)
								(HighPrint 301 56) ; "Very good food, very good drink, finest in town. Sit, rest, you will be served by my Shema."
							)
							(
								(Said
									'//weapon,blade,dagger,shield,equipment,armor'
								)
								(HighPrint 301 57) ; "I have little knowledge of these things. Perhaps if you shop around...""
							)
							((Said '//abdulla,man')
								(if (gCast contains: merchant)
									(HighPrint 301 58) ; "Poor Abdulla sits. He tries to forget his loss in food and drink. I think he will not be sorry if you join him at his table."
								else
									(HighPrint 301 59) ; "My friend, Abdulla, is recovering from his robbery last week. He should be here around suppertime."
								)
							)
							((Said '//monster,ogre,goon,centaur')
								(HighPrint 301 60) ; "The world is filled with many kinds of creatures, both good and bad."
							)
							((Said '//hamlet,valley')
								(HighPrint 301 61) ; "Although in this valley I now have friends, I miss my homeland terribly."
							)
							((Said '//ale,sweat,breath,wine')
								(HighPrint 301 62) ; "My apologies, Wanderer, but for such drink you must go to the tavern at the other end of town."
							)
							((Said '//robbery,loss,alm,gold,silver')
								(HighPrint 301 63) ; "Alas, the brigands stole all of Abdulla's wealth and mine own when they robbed his caravan. Now I am forced to stay in this wet, cold land."
							)
							((Said '//loot,caravan,destiny')
								(HighPrint 301 64) ; "I hoped to return to my homeland with the profits Abdulla, Shema, and I would make from the caravan. Now, I fear, we will remain here unless someone defeats the brigands and returns our stolen treasures."
							)
							((Said '//spice')
								(HighPrint 301 65) ; "Hot spice. Hot! I hope you like!"
							)
							((Said '//home,desert,south,land,land')
								(HighPrint 301 66) ; "We live far to the south in the desert lands. Someday, we may yet return there."
							)
							(
								(Said
									'//labor,labor,hero,fame,adventure,hall,abenteuer'
								)
								(HighPrint 301 67) ; "Work of an adventurous sort is available. You must go to the Hall of the Adventurer's Guild."
							)
							((Said '//bandit')
								(HighPrint 301 68) ; "I know little about them except that they must be wealthy now."
							)
							((Said '//name')
								(HighPrint 301 69) ; "I am Shameen, mate of Shema, innkeeper to the town of Spielburg."
							)
							((Said '//shema,companion,mate,wife,woman')
								(HighPrint 301 70) ; "Shema is my mate and the light of my life. If you sit down, she will be happy to serve you."
							)
							((Said '//katta,cat,people,sand')
								(HighPrint 301 71) ; "We Katta are a race of desert dwellers, wanderers of the endless sands.""
							)
							((Said '//shameen,keeper,innkeeper,owner,you')
								(HighPrint 301 72) ; "I am but a poor unfortunate, forced to seek my fortune in this cold land, far from my homeland, Shapeir, and my people."
							)
							((Said '//magic,spell,potion,wand,scroll')
								(HighPrint 301 73) ; "We of the Katta know only low and simple spells."
							)
							((Said '//*')
								(= local5 0)
								(switch local0
									(0
										(HighPrint 301 74) ; "Alas, this humble innkeeper is ignorant of that about which you ask."
									)
									(1
										(HighPrint 301 75) ; "A thousand pardons! I am a fool and have no answer for your question."
									)
									(2
										(HighPrint 301 76) ; "Forgive me, that I am unable to speak with knowledge on that subject."
									)
								)
								(if (== local0 2)
									(= local0 0)
								else
									(++ local0)
								)
							)
						)
						(if local5
							(SolvePuzzle 719 1)
						)
					)
				)
			)
		)
	)
)

(instance LickIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ local1)
				(Shameen setLoop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(if (< local1 (Random 2 5))
					(self changeState: 0)
				else
					(= local1 0)
					(Shameen setLoop: 4 cel: 0 cycleSpeed: 0 stopUpd:)
					(= seconds (Random 5 15))
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance Shema of Act
	(properties
		view 303
	)

	(method (init)
		(super init:)
		(self
			illegalBits: 0
			ignoreActors:
			posn: 155 99
			setCycle: Walk
			setScript: comingOut
		)
	)

	(method (doit)
		(if (> global114 1)
			(-- global114)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed self event 3)
					(HighPrint 301 77) ; "Shema, mate of Shameen the innkeeper."
				)
			)
			(evSAID
				(if (and (IsFlag 301) (< (Shema distanceTo: gEgo) 30))
					(cond
						((Said 'talk,talk/shema,girl,katta,cat,hostess')
							(HighPrint 301 78) ; "It is my pleasure to serve you."
						)
						((Said 'yes,please')
							(if global114
								(HighPrint 301 79) ; "Then you shall order food or drink."
								(= global114 0)
							else
								(HighPrint 301 80) ; "I am so sorry. I do not understand."
							)
						)
						((Said 'no')
							(if global114
								(HighPrint 301 81) ; "Then please enjoy our table and our fire."
								(= global114 0)
								(Shema setScript: goingIn)
							else
								(HighPrint 301 80) ; "I am so sorry. I do not understand."
							)
						)
						((Said 'ask>')
							(cond
								((Said '//food,breakfast,lamb,chicken,soup')
									(HighPrint 301 82) ; "We have very good stew of newborn lamb along with honey chicken for a mere 3 silvers."
								)
								((Said '//drink,drink,coffee,tea')
									(HighPrint 301 83) ; "We have rich black coffee, freshly ground and brewed as only my people do. Such coffee will bring you to your full alertness."
									(HighPrint 301 84) ; "We also have a tea of the rarest herbs, which will quench the thirst of the desert. Each is only one silver."
								)
								((Said '//ale,wine,sweat,breath')
									(HighPrint 301 85) ; "For that sort of beverage you must go to the tavern."
								)
								((Said '//spice')
									(HighPrint 301 65) ; "Hot spice. Hot! I hope you like!"
								)
								((Said '//name,shema')
									(HighPrint 301 86) ; "I am called Shema, mate of Shameen, your humble servant."
								)
								((Said '//shameen')
									(HighPrint 301 87) ; "Shameen is of the oldest and finest ancestry of the Katta people."
								)
								((Said '//desert,home,sand,sun,south')
									(HighPrint 301 88) ; "Shapeir is a land of desert sands, flowers, fruit, and beauty. How I wish to return."
								)
								((Said '//*')
									(HighPrint 301 89) ; "She merely blushes, as if embarrassed. She appears to be very shy."
								)
							)
						)
						((Said 'pay[/food,drink,drink,shema]')
							(if (or (== global340 2) (== global341 2))
								(HighPrint 301 90) ; "You just did."
							else
								(HighPrint 301 91) ; "Please pay for your order after I bring it."
							)
						)
						((Said 'buy,order,get,get>')
							(cond
								((or (== global340 1) (== global340 2))
									(HighPrint 301 41) ; "You have already ordered."
								)
								(
									(Said
										'/food,breakfast,lamb,chicken,soup,plate,bowl'
									)
									(cond
										((not (Purchase local4))
											(localproc_0)
										)
										((== global341 global340 0)
											(HighPrint 301 92) ; "With great pleasure will I serve you a fine meal."
											(= global342 100)
											(= global340 1)
											(= global341 1)
											(Shema setScript: goingIn)
										)
										(else
											(HighPrint 301 44) ; "Shema will be back soon."
										)
									)
								)
								((Said '/drink,drink,coffee,tea,cup,cup')
									(cond
										((not (Purchase local3))
											(localproc_0)
										)
										((== global341 global340 0)
											(HighPrint 301 93) ; "I will fetch that which will satisfy your thirst."
											(= global342 100)
											(= global341 1)
											(Shema setScript: goingIn)
										)
									)
								)
								((Said '/nothing')
									(HighPrint 301 94) ; "Very well."
									(Shema setScript: goingIn)
								)
								((Said '<up>'))
								((Said '*')
									(HighPrint 301 95) ; "I am sorry that our inn has not what you desire."
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance Food of View
	(properties
		y 136
		x 127
		view 301
		loop 5
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed self event 3)
				(switch global340
					(2
						(HighPrint 301 24) ; "The food looks unusual, but smells delicious."
					)
					(3
						(HighPrint 301 96) ; "You practically licked the plate clean. That was delicious."
					)
				)
			)
		)
	)
)

(instance EatIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: Food)
					(Food setCel: 5)
				)
				(= cycles 2)
			)
			(1
				(if (== global340 2)
					(HighPrint 301 97) ; "The food tastes surprisingly good."
					(= global340 3)
				)
				(self cue:)
			)
			(2
				(if (== global341 2)
					(HighPrint 301 98) ; "The beverage goes down smoothly and well."
					(= global341 3)
				)
				(SetFlag 302)
				(gEgo setScript: sitScript)
			)
		)
	)
)

(instance SwDoor of Prop
	(properties
		y 107
		x 168
		view 301
		loop 1
		cycleSpeed 1
	)
)

(instance RmDoor of Prop
	(properties
		y 140
		x 30
		view 301
		loop 4
	)
)

(instance Fire of Prop
	(properties
		y 137
		x 285
		view 301
		loop 3
		cycleSpeed 1
	)
)

(instance Chair of Prop
	(properties
		y 154
		x 141
		view 301
		loop 5
		cel 4
	)
)

(instance tools of PV
	(properties
		y 154
		x 287
		view 301
		loop 5
	)
)

(instance shamLeg of PV
	(properties
		y 129
		x 238
		view 302
		loop 3
		cel 1
		priority 9
	)
)

(instance InnMusic of Sound
	(properties
		number 21
	)
)

(instance onTable of RFeature
	(properties
		nsTop 129
		nsLeft 64
		nsBottom 140
		nsRight 135
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onTable event 3)
				(HighPrint 301 12) ; "The tables look like they have been rough-cut from some of the local pines."
			)
		)
	)
)

(instance onKitchenDoor of RFeature
	(properties
		nsTop 58
		nsLeft 168
		nsBottom 108
		nsRight 201
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKitchenDoor event 3)
				(HighPrint 301 99) ; "The odor of cooking food wafts through the kitchen door."
			)
		)
	)
)

(instance onPlates of RFeature
	(properties
		nsTop 41
		nsLeft 65
		nsBottom 82
		nsRight 247
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(and
					(not (MouseClaimed onKitchenDoor event 3))
					(MouseClaimed onPlates event 3)
				)
				(HighPrint 301 100) ; "Collection of designer plates loaned to the Hero's Inn by Mary Meister."
			)
		)
	)
)

(instance onFireplace of RFeature
	(properties
		nsTop 81
		nsLeft 265
		nsBottom 140
		nsRight 291
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(MouseClaimed onFireplace event 3)
					(Said 'look,look/fire,log,chimney,brick')
				)
				(HighPrint 301 101) ; "The warmth of the fire feels good on such a chilly day. The proprietor of the inn apparently thinks so, too. Cats always seem to gravitate to a warm hearth."
			)
		)
	)
)

(instance onLargeTable of RFeature
	(properties
		nsTop 84
		nsLeft 91
		nsBottom 95
		nsRight 140
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onLargeTable event 3)
				(HighPrint 301 102) ; "This table must have been made for some tall folks, perhaps Goons, Ogres, or Centaurs."
			)
		)
	)
)

(instance onSleepDoor of RFeature
	(properties
		nsTop 73
		nsLeft 29
		nsBottom 126
		nsRight 45
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSleepDoor event 3)
				(HighPrint 301 103) ; "A door to some other room. Perhaps the proprietor can tell you what's in there."
			)
		)
	)
)

(instance shameensIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 10)
			)
			(1
				(if (and (!= gPrevRoomNum 0) (not (IsFlag 89)))
					(Shameen cycleSpeed: 1 setCycle: End self)
				else
					(HandsOn)
					(ClearFlag 300)
					(Shameen setScript: LickIt)
				)
			)
			(2
				(SetFlag 300)
				(Shameen stopUpd:)
				(HighPrint 301 104) ; "Welcome! Welcome, traveler, to the Hero's Tale Inn! I am Shameen, at your service. May you find what you seek here."
				(HandsOn)
				(= cycles 100)
			)
			(3
				(Shameen cel: 2 setCycle: Beg self)
			)
			(4
				(ClearFlag 300)
				(Shameen stopUpd: setScript: LickIt)
			)
		)
	)
)

(instance shameenClaps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 300)
					(self cue:)
				else
					(Shameen setCycle: CT 2 1 self)
				)
			)
			(1
				(SetFlag 300)
				(Shameen setLoop: 5 cel: 0 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 12)
			)
			(2
				(Shameen setLoop: 4 cel: 2 cycleSpeed: 0 setCycle: 0 stopUpd:)
				(= cycles 50)
			)
			(3
				(Shameen setCycle: Beg self)
			)
			(4
				(ClearFlag 300)
				(Shameen stopUpd: setScript: LickIt)
			)
		)
	)
)

(instance merchant of Prop
	(properties
		view 302
		loop 1
	)

	(method (dispose)
		(mLegs dispose:)
		(mMug dispose:)
		(super dispose:)
	)

	(method (init)
		(self posn: 109 129 setPri: 12 ignoreActors: stopUpd:)
		(mLegs init:)
		(mMug init:)
		(gAddToPics add: mLegs mMug doit:)
		(super init:)
	)

	(method (doit)
		(if (and (gEgo inRect: 40 135 160 180) (not local6))
			(= local6 1)
			(merchant setScript: emotionalMerchant)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed self event 3)
					(HighPrint 301 10) ; "The merchant is a rather fat man with a small moustache and beard. He wears a turban."
				)
			)
			(evSAID
				(if
					(and
						(gEgo inRect: 40 135 160 180)
						(not
							(and
								(IsFlag 301)
								(< (Shema distanceTo: gEgo) 30)
							)
						)
					)
					(cond
						((Said 'give,offer/breakfast,food,ration')
							(cond
								((== global340 2)
									(SolvePuzzle 736 2)
									(= local8 8)
									(= global340 3)
									(HighPrint 301 105) ; "The merchant consumes your meal in record time."
									(= global341 3)
									(HighPrint 301 106) ; "He then procedes to finish your drink in one gulp."
									(emotionalMerchant changeState: 1)
								)
								((gEgo has: 3) ; food
									(SolvePuzzle 736 2)
									(HighPrint 301 107) ; "The merchant gratefully accepts your food ration, and consumes it in record time."
									(-- [gInvNum 3]) ; food
									(= local8 8)
									(emotionalMerchant changeState: 1)
								)
								(else
									(HighPrint 301 108) ; "You can't give what you don't have."
								)
							)
						)
						((Said 'give,offer/drink,drink')
							(if (== global341 2)
								(SolvePuzzle 736 2)
								(= local8 8)
								(= global341 3)
								(HighPrint 301 109) ; "The merchant finishes your drink in one gulp."
								(emotionalMerchant changeState: 1)
							else
								(HighPrint 301 108) ; "You can't give what you don't have."
							)
						)
						((Said 'give,offer/alm,silver,gold')
							(if (Purchase 1)
								(Purchase 9)
								(SolvePuzzle 736 2)
								(= local8 8)
								(emotionalMerchant changeState: 1)
							)
						)
						((Said 'talk,talk/man,abdulla')
							(HighPrint 301 4) ; "I am sorry, but I'm much too broken to talk about such things right now.  I have lost everything!"
						)
						((Said 'look,look/turban')
							(HighPrint 301 110) ; "It is the merchant's hat."
						)
						((Said 'look,look/hat')
							(HighPrint 301 111) ; "It is the merchant's turban."
						)
						((Said 'ask>')
							(= local7 1)
							(cond
								((Said '//bandit,robbery')
									(= local8 1)
									(emotionalMerchant changeState: 1)
								)
								(
									(or
										(Said '//leader')
										(Said '//face,voice<leader')
									)
									(HighPrint 301 112) ; "There were about twelve brigands, including a Minotaur, if you can believe it! Their leader was wearing a hooded cloak. I could not see the face, but he had a high-pitched voice. There was also some sort of warlock who giggled a lot."
								)
								((Said '//cloak')
									(HighPrint 301 113) ; "Although worn with age, the brigand leader's cloak must have, at one time, been an exquisite garment. No doubt it was stolen, as were all of my goods!"
								)
								((Said '//warlock,mage')
									(HighPrint 301 114) ; "Perhaps it was my eyes that deceived me, but I could swear there was Gnome blood in that odd magician."
								)
								((Said '//wizard')
									(HighPrint 301 115) ; "The magician who travels with the brigands is no wizard."
								)
								((Said '//turban')
									(= local7 0)
									(HighPrint 301 116) ; "It is my hat."
								)
								((Said '//hat')
									(= local7 0)
									(HighPrint 301 117) ; "It is my turban."
								)
								((Said '//name,abdulla')
									(HighPrint 301 118) ; "I am Abdulla Doo, son of Ali, grandson of Hasan, and formerly Master Merchant of Shapeir. Now I am but a penniless burden upon my friends."
								)
								((Said '//friend')
									(HighPrint 301 119) ; "Even though they, too, lost a fortune when the brigands stole from me, Shameen and Shema are caring for this frail shadow of a great man."
								)
								((Said '//ali,dad,grandfather')
									(HighPrint 301 120) ; "Oh, I cannot bear to talk about my family at this sad time!"
								)
								((Said '//desert,home,sand,sun')
									(= local8 4)
									(emotionalMerchant changeState: 1)
								)
								((Said '//danger,time')
									(HighPrint 301 121) ; "You must not have heard of the brigands who prey upon the innocent and unwary."
								)
								((Said '//drygoods,possession')
									(HighPrint 301 122) ; "All that I once owned is gone, alas!"
								)
								((Said '//valley,pass,pass')
									(HighPrint 301 123) ; "Who would have thought that there could be such trouble entering this valley during the off-season?"
								)
								(
									(Said
										'//katta,cat,shema,shameen,kindness,innkeeper,owner,keeper'
									)
									(HighPrint 301 124) ; "My good friends Shema and Shameen, owners of this inn, are the finest of all the Katta people that ever graced Shapeir! But for their kindness, I would have starved long since."
								)
								((Said '//magic')
									(= local8 6)
									(emotionalMerchant changeState: 1)
								)
								((Said '//guard,assistant')
									(= local8 7)
									(emotionalMerchant changeState: 1)
								)
								(
									(or
										(Said '//bull,bull')
										(Said '//head<bull,bull')
									)
									(HighPrint 301 125) ; "If you have never seen such a beast before, you may count yourself lucky. It is like a giant of a man with a bull's head."
								)
								((Said '//*')
									(= local7 0)
									(localproc_1)
								)
							)
							(if local7
								(SolvePuzzle 720 5)
							)
						)
					)
				)
			)
		)
	)
)

(instance emotionalMerchant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(merchant setLoop: 1 cel: 0 setCycle: End self)
			)
			(1
				(merchant setLoop: 0 cel: 0 setCycle: End)
				(= cycles 5)
			)
			(2
				(merchant setLoop: 0 cel: 2)
				(= cycles 2)
			)
			(3
				(merchant setLoop: 0 cel: 3)
				(= cycles 2)
			)
			(4
				(merchant setCycle: Beg self)
			)
			(5
				(merchant setLoop: 1 cel: 4 stopUpd:)
				(= cycles 2)
			)
			(6
				(switch local8
					(0
						(self changeState: 7)
					)
					(1
						(HighPrint 301 126) ; "Two weeks ago, I was about to become wealthy beyond my dreams. I, Abdulla Doo, would be the first merchant into the valley this year. But my life was shattered by those vile brigands!"
						(++ local8)
						(self changeState: 1)
					)
					(2
						(HighPrint 301 127) ; "The band of brigands ambushed us just as we crossed the pass into the valley. They first used some magic which blinded us. Then they overwhelmed my six guards and my assistants."
						(++ local8)
						(self changeState: 1)
					)
					(3
						(HighPrint 301 128) ; "All of my trade goods were taken from me, right before my very eyes! Why the brigand leader spared my life, I do not know. I am now but a beggar, living off the generosity of my friends."
					)
					(4
						(HighPrint 301 129) ; "Ah, Shapeir! Beautiful land of golden sands and shining sun! The heart of civilization! Alas, she is plagued with fierce Djinni and Efreets, who seek to drive all men and Kattas from the land."
						(++ local8)
						(self changeState: 1)
					)
					(5
						(HighPrint 301 130) ; "But I can speak no more of the homeland I shall never see again. Instead, I will die in this cold, forsaken land, bereft of all I love!"
					)
					(6
						(HighPrint 301 131) ; "Alas, had I known magic, perhaps I could have turned the tide against those abominable brigands. Their magic did not seem so strong, but they outnumbered my poor caravan by two to one!"
					)
					(7
						(HighPrint 301 132) ; "My guards are all gone, killed or run away like dogs! I, too, would be lying dead had not the strange brigand leader spared my life, for what reason I know not!"
					)
					(8
						(HighPrint 301 133) ; "Your kindness overwhelms me. I can tell you will someday be a great hero."
						(if (not (IsFlag 347))
							(= local8 9)
							(SetFlag 347)
							(self changeState: 1)
						)
					)
					(9
						(HighPrint 301 134) ; "Now you will have a secret. Among the items they stole from me was a magic rug. I alone know the words to command it."
						(= local8 10)
						(self changeState: 1)
					)
					(10
						(HighPrint 301 135) ; "If you help recover my treasure, I will take you, Shameen, and Shema back to our land by way of the flying carpet. Shapeir needs powerful heroes, too!"
					)
				)
			)
			(7
				(merchant stopUpd:)
				(if (not (IsFlag 116))
					(SetFlag 116)
					(HighPrint 301 136) ; "Oh, it is indeed sad and dangerous times we live in when a man who struggles daily to keep from starving should be robbed of all his earthly possessions!"
				else
					(HighPrint 301 137) ; "Hello again, my friend."
				)
			)
		)
	)
)

(instance mLegs of PV
	(properties
		y 148
		x 110
		view 302
		loop 3
	)
)

(instance mMug of PV
	(properties
		y 131
		x 96
		view 301
		loop 5
		cel 3
		priority 12
	)
)

(instance rentARoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 128)
					(self changeState: 4)
				else
					(SolvePuzzle 722 1)
					(if (IsFlag 300)
						(self cue:)
					else
						(Shameen setCycle: CT 2 1 self)
						(SetFlag 300)
					)
				)
			)
			(1
				(HandsOff)
				(HighPrint 301 138) ; "May you dream of all the rewards you deserve."
				(HighPrint 301 139) ; "You thank Shameen and pay him 5 silvers for the room."
				(Shameen setLoop: 4 cel: 2 setCycle: Beg)
				(RmDoor setCycle: End self)
			)
			(2
				(ClearFlag 300)
				(gEgo ignoreActors: illegalBits: 0)
				(if (gEgo inRect: 239 125 319 133)
					(gEgo setMotion: MoveTo (gEgo x:) 130 self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo setMotion: MoveTo 10 130 self)
			)
			(4
				(SetFlag 128)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 16)
				(self cue:)
			)
			(5
				(ClearFlag 122)
				(gCurRoom newRoom: 302)
			)
		)
	)
)

(instance comingOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(InnMusic stop: number: 50 play:)
				(HandsOff)
				(if (or (== global340 1) (== global341 1))
					(Shema view: 304 startUpd:)
				)
				(Shema setMotion: MoveTo 192 99 self)
			)
			(1
				(Shema loop: 2)
				(SwDoor loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(Shema setMotion: MoveTo 192 122 self)
				(SetFlag 301)
			)
			(3
				(SwDoor setCycle: Beg self)
				(Shema setMotion: MoveTo 130 144)
			)
			(4
				(SwDoor loop: 1 cel: 0)
				(= cycles 2)
			)
			(5
				(SwDoor cel: 2)
				(= cycles 2)
			)
			(6
				(SwDoor cel: 0)
				(= cycles 1)
			)
			(7
				(SwDoor cel: 1)
				(= cycles 1)
			)
			(8
				(SwDoor cel: 0 stopUpd:)
				(= cycles 14)
			)
			(9
				(Shema loop: 2 ignoreActors: 0)
				(= cycles 2)
			)
			(10
				(if (and (!= global340 1) (!= global341 1))
					(HighPrint 301 140) ; "I am Shema. Allow me to serve you, Wanderer from Afar. Do you wish food or drink?"
					(= global114 50)
					(HandsOn)
					(User canControl: 0)
				else
					(HighPrint 301 141) ; "I bring you that which you ordered. May it please and satisfy you."
					(cond
						((== global340 1)
							(= global340 2)
							(= global341 2)
						)
						((== global341 1)
							(= global341 2)
						)
					)
					(self cue:)
				)
			)
			(11
				(Shema view: 303)
				((View new:)
					view: 301
					loop: 5
					cel: 2
					posn: 130 131
					init:
					ignoreActors:
					setPri: 12
					stopUpd:
				)
				(if (== global340 2)
					(Food ignoreActors: setPri: 12 init: stopUpd:)
				)
				(HighPrint 301 142) ; "You thank Shema and pay her."
				(SetFlag 112)
				(= cycles 5)
			)
			(12
				(Shema setScript: goingIn)
			)
		)
	)
)

(instance goingIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 112)
				(SetFlag 111)
				(Shema ignoreActors: setMotion: MoveTo 192 114 self)
			)
			(1
				(Shema loop: 3)
				(self cue:)
			)
			(2
				(SwDoor loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(Shema setMotion: MoveTo 192 99 self)
			)
			(4
				(ClearFlag 111)
				(SwDoor setCycle: Beg self)
				(Shema setMotion: MoveTo 155 99)
			)
			(5
				(ClearFlag 301)
				(SwDoor loop: 1 cel: 0)
				(= cycles 2)
			)
			(6
				(SwDoor cel: 1)
				(= cycles 2)
			)
			(7
				(SwDoor cel: 0)
				(= cycles 1)
			)
			(8
				(SwDoor cel: 2)
				(= cycles 1)
			)
			(9
				(ClearFlag 112)
				(SwDoor cel: 0 stopUpd:)
				(HandsOn)
				(User canControl: 0)
				(Shema stopUpd: setScript: 0)
			)
		)
	)
)

(instance sitScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((> global342 1)
				(-- global342)
			)
			((== global342 1)
				(= global342 0)
				(if (not (Shema script:))
					(Shema setScript: comingOut)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(if (or (Said 'stand,stand') (Said 'get,get<up'))
					(cond
						((and (IsFlag 301) (< (Shema distanceTo: gEgo) 30))
							(self changeState: 8)
							(Shema setScript: goingIn self)
						)
						((or (== global340 1) (== global341 1))
							(HighPrint 301 143) ; "You should wait for Shema to bring you what you ordered."
						)
						((== global340 2)
							(HighPrint 301 144) ; "Eat your meal first."
						)
						((== global341 2)
							(HighPrint 301 145) ; "Finish your drink."
						)
						(else
							(self changeState: 9)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 302)
					(ClearFlag 302)
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				(Chair ignoreActors:)
				(if (< (gEgo x:) 158)
					(gEgo
						illegalBits: 0
						setMotion: MoveTo 145 (gEgo y:) self
					)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo (gEgo x:) 157)
					(= cycles 5)
				)
			)
			(2
				(if (> (gEgo x:) 145)
					(gEgo setMotion: MoveTo 145 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 154)
				(= cycles 2)
			)
			(4
				(Chair posn: 156 154)
				(= cycles 3)
			)
			(5
				(gEgo ignoreActors: hide:)
				(Chair
					setLoop: 6
					setCel: 0
					setPri: 12
					posn: 141 154
					ignoreActors: 0
				)
				(= cycles 2)
			)
			(6
				(Chair setCycle: End)
				(SetFlag 254)
				(= cycles 15)
			)
			(7
				(cond
					((not (gCast contains: Shema))
						(Shema init:)
						(gCast delete: Shema)
						(gCast addToFront: Shema)
					)
					((and (not (IsFlag 301)) (not (Shema script:)))
						(Shema setScript: comingOut)
					)
				)
			)
			(9
				(User canInput: 0)
				(Chair setCycle: Beg self)
			)
			(10
				(Chair setLoop: 5 setCel: 4 setPri: 6 posn: 141 154 stopUpd:)
				(gEgo loop: 1 show:)
				(= cycles 3)
			)
			(11
				(gEgo setMotion: MoveTo (gEgo x:) 160 self)
			)
			(12
				(Chair setPri: -1)
				(ClearFlag 254)
				(= global340 0)
				(= global341 0)
				(HandsOn)
				(gEgo illegalBits: -32768 ignoreActors: 0 setScript: 0)
			)
		)
	)
)

