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
(use Actor)
(use System)

(public
	rm301 0
	shameen 1
	shema 2
	lickIt 3
	rmDoor 4
	swDoor 5
	innMusic 6
	food 7
	chair 8
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(HighPrint 301 0) ; "You suddenly realize that you don't have enough money to purchase what you want."
	(HighPrint 301 1) ; "Blustering, you say to Shema: "Your prices are too high for me!""
	(HighPrint 301 2) ; "As your face turns scarlet with embarrassment, Shema smiles and says:"
	(HighPrint 301 3) ; "We are sorry not to be able to show more generosity, but we, too, are victims of hard and evil times."
	(shema setScript: (ScriptID 169 0)) ; goingIn
)

(instance rm301 of Rm
	(properties
		picture 301
		south 300
	)

	(method (dispose)
		(SetFlag 89)
		(gMouseHandler delete: self)
		((ScriptID 166 0) dispose:) ; merchant
		(super dispose:)
		(DisposeScript 165)
	)

	(method (init)
		(LoadMany rsVIEW 301 303 304 302)
		(LoadMany rsSCRIPT 165 166 167 168 169 170)
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
		(chair init: stopUpd:)
		(swDoor init: stopUpd:)
		(rmDoor
			cel: (if (== gPrevRoomNum 302) 2 else 0)
			setPri: 8
			init:
			ignoreActors:
			stopUpd:
		)
		(fire init: setCycle: Fwd startUpd:)
		(if
			(and
				(or (== gTimeOfDay 4) (== gTimeOfDay 5))
				(or (not (IsFlag 115)) (== (Random 0 1) 0))
			)
			(SetFlag 115)
			((ScriptID 166 0) init:) ; merchant
			(gCast delete: (ScriptID 166 0)) ; merchant
			(gCast addToFront: (ScriptID 166 0)) ; merchant
		)
		(shameen init:)
		(switch gPrevRoomNum
			(302
				(gEgo posn: 50 130 setMotion: MoveTo 70 130)
				(rmDoor setCycle: Beg)
			)
			(else
				(gEgo posn: 200 188 setMotion: MoveTo 200 175)
			)
		)
		(innMusic init: play:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					(
						(or
							(Said 'nap,rent,get,pay,buy/room,lodging')
							(Said 'go/nap')
						)
						(if (not (gEgo inRect: 200 120 319 160))
							(HighPrint 301 4) ; "You must pay the innkeeper for a room."
						)
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,room,building,hotel]')
								(HighPrint 301 5) ; "This looks like an alpine inn, complete with dishes on the wall and heavy beams on the ceiling. It is pleasantly warm, and the aroma of strange spices fills the air."
							)
							(
								(Said
									'/shameen,cat,katta,creature,owner,innkeeper,keeper'
								)
								(HighPrint 301 6) ; "You see a small, cat-like creature known as a Katta. You've heard that Kattas are common in the southern deserts."
							)
							((Said '/shema,hostess,girl,woman')
								(if (IsFlag 301)
									(HighPrint 301 7) ; "You see a rather attractive female Katta wearing her native costume."
								else
									(HighPrint 301 8) ; "She's not here."
								)
							)
							((Said '/man,abdulla')
								(if (gCast contains: (ScriptID 166 0)) ; merchant
									(HighPrint 301 9) ; "The merchant is a rather fat man with a small moustache and beard. He wears a turban."
								else
									(HighPrint 301 10) ; "He's not here."
								)
							)
							((Said '/table')
								(HighPrint 301 11) ; "The tables look like they have been rough-cut from some of the local pines."
								(HighPrint 301 12) ; "One of the tables must have been made for some tall folks, perhaps Goons, Ogres, or Centaurs."
							)
							((Said '/chair')
								(HighPrint 301 13) ; "The chair is finely made, in contrast to the rough-hewn tables."
							)
							((Said '/door')
								(HighPrint 301 14) ; "The door with the window in it must be the door to the kitchen. The other door goes elsewhere in the Inn."
							)
							((Said '/wall')
								(HighPrint 301 15) ; "The walls have an ancient, solid look, well-worn and comfortable."
							)
							((or (Said '<up') (Said '/ceiling,beam'))
								(HighPrint 301 16) ; "The heavy timbers look substantial."
							)
							((or (Said '<down') (Said '/floor,carpet'))
								(HighPrint 301 17) ; "The oak planking is well-worn, and the carpet is clean, but becoming threadbare."
							)
							((Said '/mantle')
								(HighPrint 301 18) ; "The mantle above the hearth is a solid slab of wood. There is nothing on it."
							)
							((Said '/andiron,implement')
								(HighPrint 301 19) ; "The fireplace tools are placed neatly by the hearth, along with the proprietor."
							)
							((Said '/cup,mug,drink,beverage,tea,coffee')
								(switch global341
									(2
										(HighPrint 301 20) ; "The beverage is more fragrant than most."
									)
									(3
										(HighPrint 301 21) ; "You practically licked the inside of the cup. That was delicious."
									)
									(else
										(HighPrint 301 22) ; "You have no cup."
									)
								)
							)
							(
								(Said
									'/plate,bowl,food,breakfast,lamb,chicken,soup'
								)
								(switch global340
									(2
										(HighPrint 301 23) ; "The food looks unusual, but smells delicious."
									)
									(3
										(HighPrint 301 24) ; "You practically licked the plate clean. That was delicious."
									)
									(else
										(HighPrint 301 25) ; "The plates on the wall are strictly for decoration. Dishes with food on them are much more useful, if you're hungry."
									)
								)
							)
						)
					)
					((Said 'open/door')
						(cond
							((== (gEgo onControl: 1) 16384)
								(HighPrint 301 26) ; "For all that this door appears to be free to swing back and forth, it doesn't budge when you try to open it."
							)
							((== (gEgo onControl: 1) 8192)
								(HighPrint 301 27) ; "The door appears to be stuck fast."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'talk/man')
						(NotClose)
					)
					((Said 'pay[/man,shameen,abdulla,shema]')
						(HighPrint 301 28) ; "For what?"
					)
					((Said 'odor/food,lamb,chicken,soup,spice,aroma')
						(HighPrint 301 29) ; "The aromas are enticing."
					)
					((Said 'stand')
						(if (IsFlag 254)
							(HighPrint 301 30) ; "You're already standing."
						else
							(event claimed: 0)
						)
					)
					((or (Said 'sat<down') (Said 'sat[/chair]'))
						(if (not (IsFlag 254))
							(if (gEgo inRect: 100 135 175 180)
								(gEgo setScript: (ScriptID 170 0)) ; sitScript
								(shameen setScript: (ScriptID 165 1)) ; shameenClaps
							else
								(HighPrint 301 31) ; "Move closer to the chair."
							)
						else
							(HighPrint 301 32) ; "You're already sitting down."
						)
					)
					((Said 'eat')
						(switch global340
							(0
								(if (IsFlag 254)
									(HighPrint 301 33) ; "If you're hungry, order a meal."
								else
									(HighPrint 301 34) ; "If you're hungry, you should sit down and order a meal."
								)
							)
							(1
								(HighPrint 301 35) ; "You haven't been served yet."
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
								(gEgo setScript: eatIt)
							)
							(3
								(HighPrint 301 36) ; "Both meal and drink have been consumed."
							)
						)
					)
					((Said 'drink')
						(switch global341
							(0
								(if (IsFlag 254)
									(HighPrint 301 37) ; "If you're thirsty, order a drink."
								else
									(HighPrint 301 38) ; "If you're thirsty, you should sit down and order something to drink."
								)
							)
							(1
								(HighPrint 301 35) ; "You haven't been served yet."
							)
							(2
								(gEgo setScript: eatIt)
							)
							(3
								(HighPrint 301 39) ; "The drink you ordered is all gone."
							)
						)
					)
					((or (Said '/hostess') (Said 'order,get/food,drink'))
						(if (IsFlag 254)
							(cond
								(
									(or
										(IsFlag 112)
										(== global340 1)
										(== global340 2)
									)
									(HighPrint 301 40) ; "You have already ordered."
								)
								((> gFreeMeals 1)
									(HighPrint 301 41) ; "You're not hungry."
								)
								(gFreeMeals
									(HighPrint 301 42) ; "There's no need. You're not hungry."
								)
								((not (gCast contains: (ScriptID 301 2))) ; shema
									(= global340 0)
									(= global341 0)
									((ScriptID 301 2) init:) ; shema
									(gCast delete: (ScriptID 301 2)) ; shema
									(gCast addToFront: (ScriptID 301 2)) ; shema
								)
								((and 0 (not ((ScriptID 301 2) script:))) ; shema
									(= global340 0)
									(= global341 0)
									((ScriptID 301 2) ; shema
										setScript: (ScriptID 168 0) ; comingOut
									)
								)
								(else
									(HighPrint 301 43) ; "Shema will be back soon."
								)
							)
						else
							(HighPrint 301 34) ; "If you're hungry, you should sit down and order a meal."
						)
					)
				)
			)
		)
	)
)

(instance shameen of Prop
	(properties
		view 302
		loop 4
	)

	(method (init)
		(self posn: 238 119 setPri: 9 ignoreActors:)
		(self setScript: (ScriptID 165 0)) ; shameensIntro
		(super init:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed shameen event 3)
					(HighPrint 301 6) ; "You see a small, cat-like creature known as a Katta. You've heard that Kattas are common in the southern deserts."
				)
			)
			(evSAID
				(cond
					((Said 'talk/man,cat,katta,shameen')
						(HighPrint 301 44) ; "Very good food, very good drink, finest in town. Sit, rest, you will be served by my Shema."
					)
					((or (Said 'nap,rent,get,pay,buy[/room]') (Said 'go/nap'))
						(cond
							((< 750 gClock 2550)
								(HighPrint 301 45) ; "It's too early to go to bed; you don't feel tired enough to sleep."
							)
							((IsFlag 125)
								(HighPrint 301 46) ; "You are sure that you would not be able to sleep, because you are so hungry."
							)
							((not (gEgo inRect: 200 120 319 160))
								(HighPrint 301 4) ; "You must pay the innkeeper for a room."
							)
							((Purchase local2)
								(SetFlag 122)
								(shameen setScript: (ScriptID 167 0)) ; rentARoom
							)
							(else
								(HighPrint 301 47) ; "Because your silver is too low, you must find other accomodations. Perhaps you can find work somewhere."
							)
						)
					)
					((Said 'ask>')
						(= local5 1)
						(cond
							((Said '//tavern,bar')
								(HighPrint 301 48) ; "The tavern is located in the northwest corner of our town."
							)
							((Said '//abenteuer,hall[<club,about]')
								(HighPrint 301 49) ; "The Guild Hall is just down the street from here."
							)
							((Said '//zara,magic,shop')
								(HighPrint 301 50) ; "Zara's magic shop is next door to my Inn. You can't miss it."
							)
							((Said '//hotel,(fable<hero),replace,journey')
								(HighPrint 301 51) ; "I have run this inn for three years now, with Shema."
								(HighPrint 301 52) ; "We had thought to return to Shapeir, my homeland, with Abdulla Doo, but Alas, Fate has decreed otherwise."
							)
							((Said '//room,bed,nap,rest,lodging,cost')
								(HighPrint 301 53) ; "Very nice room. Very soft beds, finest in town. Only five silvers a night."
							)
							(
								(Said
									'//food,lamb,chicken,soup,drink,breakfast,coffee,tea'
								)
								(HighPrint 301 44) ; "Very good food, very good drink, finest in town. Sit, rest, you will be served by my Shema."
							)
							(
								(Said
									'//weapon,blade,dagger,shield,equipment,armor'
								)
								(HighPrint 301 54) ; "I have little knowledge of these things. Perhaps if you shop around...""
							)
							((Said '//abdulla,man')
								(if (gCast contains: (ScriptID 166 0)) ; merchant
									(HighPrint 301 55) ; "Poor Abdulla sits. He tries to forget his loss in food and drink. I think he will not be sorry if you join him at his table."
								else
									(HighPrint 301 56) ; "My friend, Abdulla, is recovering from his robbery last week. He should be here around suppertime."
								)
							)
							((Said '//monster,ogre,goon,centaur')
								(HighPrint 301 57) ; "The world is filled with many kinds of creatures, both good and bad."
							)
							((Said '//hamlet,valley')
								(HighPrint 301 58) ; "Although in this valley I now have friends, I miss my homeland terribly."
							)
							((Said '//ale,sweat,breath,wine')
								(HighPrint 301 59) ; "My apologies, Wanderer, but for such drink you must go to the tavern at the other end of town."
							)
							((Said '//robbery,loss,alm,gold,silver')
								(HighPrint 301 60) ; "Alas, the brigands stole all of Abdulla's wealth and mine own when they robbed his caravan. Now I am forced to stay in this wet, cold land."
							)
							((Said '//loot,caravan,destiny')
								(HighPrint 301 61) ; "I hoped to return to my homeland with the profits Abdulla, Shema, and I would make from the caravan. Now, I fear, we will remain here unless someone defeats the brigands and returns our stolen treasures."
							)
							((Said '//spice')
								(HighPrint 301 62) ; "Hot spice. Hot! I hope you like!"
							)
							((Said '//home,desert,south,land')
								(HighPrint 301 63) ; "We live far to the south in the desert lands. Someday, we may yet return there."
							)
							((Said '//labor,hero,fame,adventure,hall,abenteuer')
								(HighPrint 301 64) ; "Work of an adventurous sort is available. You must go to the Hall of the Adventurer's Guild."
							)
							((Said '//bandit')
								(HighPrint 301 65) ; "I know little about them except that they must be wealthy now."
							)
							((Said '//name')
								(HighPrint 301 66) ; "I am Shameen, mate of Shema, innkeeper to the town of Spielburg."
							)
							((Said '//shema,companion,mate,wife,woman')
								(HighPrint 301 67) ; "Shema is my mate and the light of my life. If you sit down, she will be happy to serve you."
							)
							((Said '//katta,cat,people,sand')
								(HighPrint 301 68) ; "We Katta are a race of desert dwellers, wanderers of the endless sands.""
							)
							((Said '//shameen,keeper,innkeeper,owner,you')
								(HighPrint 301 69) ; "I am but a poor unfortunate, forced to seek my fortune in this cold land, far from my homeland, Shapeir, and my people."
							)
							((Said '//magic,spell,potion,wand,scroll')
								(HighPrint 301 70) ; "We of the Katta know only low and simple spells."
							)
							((Said '//*')
								(= local5 0)
								(switch local0
									(0
										(HighPrint 301 71) ; "Alas, this humble innkeeper is ignorant of that about which you ask."
									)
									(1
										(HighPrint 301 72) ; "A thousand pardons! I am a fool and have no answer for your question."
									)
									(2
										(HighPrint 301 73) ; "Forgive me, that I am unable to speak with knowledge on that subject."
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

(instance lickIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ local1)
				(shameen setLoop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(if (< local1 (Random 2 5))
					(self changeState: 0)
				else
					(= local1 0)
					(shameen setLoop: 4 cel: 0 cycleSpeed: 0 stopUpd:)
					(= seconds (Random 5 15))
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance shema of Act
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
			setScript: (ScriptID 168 0) ; comingOut
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
					(HighPrint 301 74) ; "Shema, mate of Shameen the innkeeper."
				)
			)
			(evSAID
				(if
					(and
						(IsFlag 301)
						(< ((ScriptID 301 2) distanceTo: gEgo) 30) ; shema
					)
					(cond
						((Said 'talk/shema,girl,katta,cat,hostess')
							(HighPrint 301 75) ; "It is my pleasure to serve you."
						)
						((Said 'yes,please')
							(if global114
								(HighPrint 301 76) ; "Then you shall order food or drink."
								(= global114 0)
							else
								(HighPrint 301 77) ; "I am so sorry. I do not understand."
							)
						)
						((Said 'no')
							(if global114
								(HighPrint 301 78) ; "Then please enjoy our table and our fire."
								(= global114 0)
								(shema setScript: (ScriptID 169 0)) ; goingIn
							else
								(HighPrint 301 77) ; "I am so sorry. I do not understand."
							)
						)
						((Said 'ask>')
							(cond
								((Said '//food,breakfast,lamb,chicken,soup')
									(HighPrint 301 79) ; "We have very good stew of newborn lamb along with honey chicken for a mere 3 silvers."
								)
								((Said '//drink,coffee,tea')
									(HighPrint 301 80) ; "We have rich black coffee, freshly ground and brewed as only my people do. Such coffee will bring you to your full alertness."
									(HighPrint 301 81) ; "We also have a tea of the rarest herbs, which will quench the thirst of the desert. Each is only one silver."
								)
								((Said '//ale,wine,sweat,breath')
									(HighPrint 301 82) ; "For that sort of beverage you must go to the tavern."
								)
								((Said '//spice')
									(HighPrint 301 62) ; "Hot spice. Hot! I hope you like!"
								)
								((Said '//name,shema')
									(HighPrint 301 83) ; "I am called Shema, mate of Shameen, your humble servant."
								)
								((Said '//shameen')
									(HighPrint 301 84) ; "Shameen is of the oldest and finest ancestry of the Katta people."
								)
								((Said '//desert,home,sand,sun,south')
									(HighPrint 301 85) ; "Shapeir is a land of desert sands, flowers, fruit, and beauty. How I wish to return."
								)
								((Said '//*')
									(HighPrint 301 86) ; "She merely blushes, as if embarrassed. She appears to be very shy."
								)
							)
						)
						((Said 'pay[/food,drink,shema]')
							(if (or (== global340 2) (== global341 2))
								(HighPrint 301 87) ; "You just did."
							else
								(HighPrint 301 88) ; "Please pay for your order after I bring it."
							)
						)
						((Said 'buy,order,get>')
							(cond
								((or (== global340 1) (== global340 2))
									(HighPrint 301 40) ; "You have already ordered."
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
											(HighPrint 301 89) ; "With great pleasure will I serve you a fine meal."
											(= global342 100)
											(= global340 1)
											(= global341 1)
											(shema setScript: (ScriptID 169 0)) ; goingIn
										)
										(else
											(HighPrint 301 43) ; "Shema will be back soon."
										)
									)
								)
								((Said '/drink,coffee,tea,cup,cup')
									(cond
										((not (Purchase local3))
											(localproc_0)
										)
										((== global341 global340 0)
											(HighPrint 301 90) ; "I will fetch that which will satisfy your thirst."
											(= global342 100)
											(= global341 1)
											(shema setScript: (ScriptID 169 0)) ; goingIn
										)
									)
								)
								((Said '/nothing')
									(HighPrint 301 91) ; "Very well."
									(shema setScript: (ScriptID 169 0)) ; goingIn
								)
								((Said '<up>'))
								((Said '*')
									(HighPrint 301 92) ; "I am sorry that our inn has not what you desire."
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance food of View
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
						(HighPrint 301 23) ; "The food looks unusual, but smells delicious."
					)
					(3
						(HighPrint 301 24) ; "You practically licked the plate clean. That was delicious."
					)
				)
			)
		)
	)
)

(instance eatIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: food)
					(food setCel: 5)
				)
				(= cycles 2)
			)
			(1
				(if (== global340 2)
					(HighPrint 301 93) ; "The food tastes surprisingly good."
					(= global340 3)
				)
				(self cue:)
			)
			(2
				(if (== global341 2)
					(HighPrint 301 94) ; "The beverage goes down smoothly and well."
					(= global341 3)
				)
				(SetFlag 302)
				(gEgo setScript: (ScriptID 170 0)) ; sitScript
			)
		)
	)
)

(instance swDoor of Prop
	(properties
		y 107
		x 168
		view 301
		loop 1
		cycleSpeed 1
	)
)

(instance rmDoor of Prop
	(properties
		y 140
		x 30
		view 301
		loop 4
	)
)

(instance fire of Prop
	(properties
		y 137
		x 285
		view 301
		loop 3
		cycleSpeed 1
	)
)

(instance chair of Prop
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

(instance innMusic of Sound
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
				(HighPrint 301 11) ; "The tables look like they have been rough-cut from some of the local pines."
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
				(HighPrint 301 95) ; "The odor of cooking food wafts through the kitchen door."
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
				(HighPrint 301 96) ; "Collection of designer plates loaned to the Hero's Inn by Mary Meister."
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
					(Said 'look/fire,log,chimney,brick')
				)
				(HighPrint 301 97) ; "The warmth of the fire feels good on such a chilly day. The proprietor of the inn apparently thinks so, too. Cats always seem to gravitate to a warm hearth."
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
				(HighPrint 301 98) ; "This table must have been made for some tall folks, perhaps Goons, Ogres, or Centaurs."
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
				(HighPrint 301 99) ; "A door to some other room. Perhaps the proprietor can tell you what's in there."
			)
		)
	)
)

