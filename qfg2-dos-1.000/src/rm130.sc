;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use Talker)
(use Stage)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Extra)
(use Motion)
(use Actor)
(use System)

(public
	rm130 0
)

(local
	[str 100]
	[censer 8]
	[smoke 8]
	[censerX 8] = [133 140 148 155 170 177 184 192]
	[censerY 8] = [62 68 73 79 79 73 68 62]
	[smokeLoop 8] = [6 5 8 7 8 7 6 5]
	noticedEgo
	firstTime
	askedAbout
	askedIfNeeded
	oilCost = 20
	incenseCost = 70
	pillCost
	pillType
	doses
	doing
	[harikGenList 38] = [1 2 3 4 5 6 7 8 9 10 11 12 13 0 14 0 15 0 16 0 17 18 19 20 21 22 23 24 0 25 26 0 27 0 0 0 0 0]
	[harikSpecList 64] = [28 '//frankincense,frankincense' 30 '//(powder[<burn]),burn,powder' 34 '//pill<mana,magic' 35 '//energy,(pill<energy,stamina)' 36 '//pill<healing,health' 37 '//poison,cure,(pill<poison,cure)' -3 '//potion<disenchant' -5 '//cost<potion[<disenchant]' -4 '//cost<powder,burn' 33 '//potion' 38 '//pill,merchandise,cost' 39 '//water' 40 '//compassion,fruit' 41 '//plant' 43 '//component' 44 '//scorpion,venom' 45 '//drug' 46 '//griffin,feather' 47 '//victim,hair,fur' 49 '//prize,bulletin,courage' 50 '//ghoul,claw' 51 '//experiment' 52 '//capture' 53 '//grease' 54 '//lamp,brass' 56 '//apothecary,shop' 57 '//healing' 58 '//mana' 59 '//skull,book,bottle,urn,pan,hook,censer' -1 '//flame,fire' -2 '//earth' 0 0]
	[shelfMsg 11] = [{a Doggie dish for a Fire Elemental.} {Halloween candy.} {Old Grandpaw's High-Risk Moonshine.} {Eye of Newt (does Wayne know about this?)} {10-20-40 weight.} {leftover cooking grease.} {the kind of fiery spices that are guaranteed to reduce taste buds to ash.} {a collection of collectible cologne bottles.} {burnt offerings.} {great green gobs of greasy grimy gopher guts.} {a small quantity of "Shake 'n' Bake"}]
	[bookMsg 11] = [{"Creative Accounting for Left Brains and Numerilexics."} {"How to Build Your Own Brazier."} {"Elementary Elementals."} {"Herb's Herbs."} {"How to Make Pills Pay the Bills."} {"The Pizza Elemental: Fact or Fiction?."} {"By the Time I Am a Phoenix, I'll be Rising."} {"To Pill a Mockingbird."} {"Flame and Fortune."} {"How to Get Fired Without Losing Your Job."} {"Stupid Elemental Tricks."}]
	msgCounter
)

(procedure (PillType)
	(return
		(cond
			((or (Said '/<health,healing') (Said '//<health,healing'))
				(= pillCost 1000)
				18
			)
			((or (Said '/<mana,magic') (Said '//<mana,magic'))
				(= pillCost 1500)
				19
			)
			((or (Said '/<energy,stamina') (Said '//<energy,stamina'))
				(= pillCost 500)
				20
			)
			((or (Said '/<poison,cure') (Said '//<poison,cure'))
				(= pillCost 1200)
				48
			)
			(else 0)
		)
	)
)

(procedure (Incenser &tmp I)
	(for ((= I 0)) (< I 8) ((++ I))
		((= [censer I] (aCenser new:))
			x: [censerX I]
			y: [censerY I]
		)
		(InitAddToPics [censer I])
		((= [smoke I] (aSmoke new:))
			setLoop: [smokeLoop I]
			x: [censerX I]
			y: [censerY I]
			init:
		)
	)
)

(instance rm130 of Stage
	(properties
		picture 130
		style 4
		south 315
		bottomFromX 124
		bottomExit 1
		bottomToX 124
	)

	(method (dispose)
		(LoadMany 0 131)
		(gCSound stop:)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 135 130)
		(Load rsSOUND 130)
		(LoadMany rsTEXT 135)
		(++ gHarikVisits)
		(= firstTime (!= gHarikDay gDay))
		(= gHarikDay gDay)
		(gEgo init:)
		(NormalEgo)
		(brazSmoke init: setCycle: Fwd)
		(super init:)
		(InitAddToPics braz urn bowl scale lamp1 lamp2)
		(mortar init:)
		(leftBottle init: hide:)
		(rightBottle init: hide:)
		(harik init: setScript: mixingS)
		(harikHead init:)
		(InitFeatures
			(ScriptID 131 0) ; kettle
			(ScriptID 131 1) ; fireplace
			(ScriptID 131 2) ; niche
			bookshelf
			(ScriptID 131 3) ; ceiling
			(ScriptID 131 4) ; cupboard
			(ScriptID 131 5) ; sackOSomething
			(ScriptID 131 6) ; wheelbarrow
			(ScriptID 131 10) ; urns
			(ScriptID 131 11) ; bigUrn
			(ScriptID 131 7) ; workbench
			(ScriptID 131 8) ; workbench2
			(ScriptID 131 9) ; alcove
			(ScriptID 131 12) ; hook
			(ScriptID 131 13) ; hook2
			(ScriptID 131 14) ; skull
			(ScriptID 131 15) ; potOnStove
			shelf
		)
		(Incenser)
		(= msgCounter (Random 0 10))
		(gCSound number: 130 loop: -1 playBed:)
	)

	(method (handleEvent event &tmp saidYes)
		(= saidYes 0)
		(if (and askedIfNeeded (Said 'yes,no>'))
			(= askedIfNeeded 0)
			(if (Said 'yes')
				(event claimed: 0)
				(= saidYes 1)
			else
				(event claimed: 1)
				(Say harikHead 130 0) ; "Good. I hate to part with it unless there is a very good cause."
			)
		)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/apothecary,shop')
				)
				(HighPrint 130 1) ; "The Apothecary Shop is aflame with reds, yellows, and oranges, and smoky incense fills the air. The druggist is busy creating pills and powders."
			)
			((Said 'hello')
				(if noticedEgo
					(Say harikHead 130 2) ; "Ah, good day. I am busy as always, making up a batch of pills. If you need something, just let me know."
				else
					(self setScript: welcome)
				)
			)
			((Said 'thank')
				(if noticedEgo
					(SayThanks harikHead 130 3)
				else
					(self setScript: welcome)
				)
			)
			(
				(or
					saidYes
					(and
						(== gElementalState 5)
						(or
							(Said 'tell/elemental<earth')
							(Said 'tell//elemental<earth')
							(Said 'bargain//(powder[<burn]),burn,powder')
							(Said 'bargain/(powder[<burn]),burn,powder')
						)
					)
				)
				(= saidYes 0)
				(event claimed: 1)
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((IsFlag 37) ; fGotBurnPowder
						(Say harikHead 130 4) ; "I have already given you my very last speck of powder."
					)
					((and (!= gOrigHeroType 2) (== gElementalState 5))
						(Say harikHead 130 5 130 6) ; "I should think that someone with your particular skills would be able to think of another way to defeat the Earth Elemental."
					)
					((!= gOrigHeroType 2)
						(Say harikHead 130 7) ; "Someone with your skills can do without my Powder of Burning."
					)
					((and (TrySkill 13 50) (== gElementalState 5)) ; communication
						(HighPrint 130 8) ; "With fiery emotion, you explain to Harik that the Earth Elemental is attacking the city. At first, he seems unconvinced, but your eloquence finally sways him."
						(self setScript: givePowderS)
					)
					(else
						(Say harikHead 130 9) ; "As I said, I really could not give you the little bit that I have."
					)
				)
			)
			((or (Said 'buy,bargain/burn,powder') (Said 'bargain//burn,powder'))
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((IsFlag 37) ; fGotBurnPowder
						(Say harikHead 130 10) ; "I have already given you my very last speck of it."
					)
					(else
						(Say harikHead 130 11 130 12) ; "I only have a little left. I really couldn't part with it for any price."
						(= askedIfNeeded 1)
					)
				)
			)
			(
				(or
					(Said 'tell/(powder<burn),(elemental<earth)')
					(Said 'tell//(powder<burn),(elemental<earth)')
				)
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((<= gElementalState 5)
						(Say harikHead 130 13) ; "Yes, Powder of Burning might be of some use against an Earth Elemental."
					)
					((TrySkill 13 60) ; communication
						(Say harikHead 130 14) ; "Thank you. I wish I could have seen it, though. The fire must have been lovely."
						(SkillUsed 13 10) ; communication
					)
					(else
						(Say harikHead 130 15) ; "Humph. Nobody likes a braggart. You seem to have forgotten who gave you the Powder of Burning."
					)
				)
			)
			((or (Said 'tell/elemental<fire') (Said 'tell//elemental<fire'))
				(HighPrint 130 16) ; "You ardently describe the Fire Elemental to Harik."
				(if (not (SetFlag 178)) ; fToldHarikOfFire
					(SkillUsed 13 25) ; communication
				)
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((< gElementalState 1)
						(Say harikHead 130 17) ; "Yes, I have heard of these things. Wouldn't it be a wondrous sight!"
					)
					((== gElementalState 1)
						(Say harikHead 130 18) ; "Isn't it exciting? Of course, some people don't appreciate its beauty. They actually want to get rid of it!"
					)
					(else
						(Say harikHead 130 19) ; "I must sadly admit that it did get out of hand.  I suppose you did the right thing in vanquishing it."
					)
				)
			)
			(
				(or
					(Said 'give/elemental<fire[/attar,attar,clerk,clerk,man]')
					(Said 'give[/attar,attar,clerk,clerk,man]/elemental<fire')
				)
				(if (>= gElementalState 2)
					(HighPrint 130 20) ; "Although you know that Harik would be most generous if offered a real Fire Elemental of his own, you decide that the creature in the lamp might prove invaluable to you at some later date."
				else
					(DontHave)
				)
			)
			((or (Said 'tell/elemental<air') (Said 'tell//elemental<air'))
				(SkillUsed 13 5) ; communication
				(HighPrint 130 21) ; "You breathily describe the Air Elemental to Harik."
				(Say harikHead 130 22) ; "Such a thing is not nearly so grand as the Fire Elemental."
			)
			((or (Said 'tell/elemental<water') (Said 'tell//elemental<water'))
				(if (not (SetFlag 179)) ; fToldHarikOfWater
					(SkillUsed 13 20) ; communication
				)
				(HighPrint 130 23) ; "You fluidly describe the Water Elemental to Harik."
				(if (== gElementalState 7)
					(Say harikHead 130 24) ; "Well, I hope you figure out how to deal with it. This city will soon run out of water."
				else
					(Say harikHead 130 25) ; "Such a thing would not be nearly as grand as a Fire Elemental."
				)
			)
			((or (Said 'tell/beast') (Said 'tell//beast'))
				(SkillUsed 13 5) ; communication
				(HighPrint 130 26) ; "You give Harik a brief description of the caged beast."
				(Say harikHead 130 27) ; "That sounds most interesting. It is probably not a natural creature, but around here, who can tell? You could try a Dispel Potion on it, though."
			)
			((Said 'tell')
				(if noticedEgo
					(Say harikHead 130 28) ; "Most interesting, I'm sure, but I'm a busy man."
				else
					(self setScript: welcome)
				)
			)
			((Said 'buy/pill>')
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((= pillType (PillType))
						(= doing 0)
						(self setScript: walkOverS)
					)
					(else
						(event claimed: 1)
						(Say harikHead 130 29) ; "I have many pills for sale. Which do you want?"
					)
				)
			)
			((or (Said 'bargain//pill>') (Said 'bargain/pill>'))
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((not (= pillType (PillType)))
						(event claimed: 1)
						(Say harikHead 130 29) ; "I have many pills for sale. Which do you want?"
					)
					((TrySkill 13 60) ; communication
						(= doing 1)
						(self setScript: walkOverS)
					)
					(else
						(event claimed: 1)
						(Say harikHead 130 30) ; "There is no way that I could possibly reduce my price."
					)
				)
			)
			(
				(or
					(Said 'buy/medicine')
					(Said 'ask//medicine')
					(Said 'bargain//medicine')
					(Said 'bargain/medicine')
				)
				(Say harikHead 130 31) ; "Did you wish to buy some pills?"
			)
			((Said 'buy/frankincense>')
				(if (not noticedEgo)
					(event claimed: 1)
					(self setScript: welcome)
				else
					(event claimed: 1)
					(= doing 2)
					(self setScript: walkOverS)
				)
			)
			((or (Said 'bargain//frankincense>') (Said 'bargain/frankincense>'))
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((TrySkill 13 80) ; communication
						(event claimed: 1)
						(= doing 3)
						(self setScript: walkOverS)
					)
					(else
						(event claimed: 1)
						(Say harikHead 130 32) ; "I am trying to stay in business. The more I give, the more I lose. It shall be what I asked for, 70 centimes."
					)
				)
			)
			((Said 'buy/grease>')
				(if (not noticedEgo)
					(event claimed: 1)
					(self setScript: welcome)
				else
					(event claimed: 1)
					(= doing 4)
					(self setScript: walkOverS)
				)
			)
			((or (Said 'bargain//grease>') (Said 'bargain/grease>'))
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((TrySkill 13 80) ; communication
						(event claimed: 1)
						(= doing 5)
						(self setScript: walkOverS)
					)
					(else
						(event claimed: 1)
						(Say harikHead 130 33) ; "My price is firm."
					)
				)
			)
			(
				(or
					(Said 'bargain,buy//potion,disenchant')
					(Said 'bargain,buy/potion,disenchant')
				)
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((IsFlag 35) ; fMadeDispelPotion
						(Say harikHead 130 34) ; "I have already made this potion for you. I have no more ingredients with which to make another."
					)
					(else
						(Say harikHead 130 35 130 36) ; "If you will but bring me the ingredients, I should be happy to make the potion for you at no charge."
					)
				)
			)
			((Said 'bargain')
				(Say harikHead 130 37) ; "And just what is it you are bargaining for?"
			)
			((Said 'give/feather')
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((not (gEgo has: 28)) ; Feather
						(DontHave)
					)
					(else
						(gEgo put: 28) ; Feather
						(SetFlag 33) ; fGaveFeather
						(if (IsFlag 34) ; fGaveFruit
							(= doing 6)
						else
							(= doing 7)
						)
						(self setScript: walkOverS)
					)
				)
			)
			((Said 'give/fruit')
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((not (gEgo has: 36)) ; CompassionFruit
						(DontHave)
					)
					(else
						(gEgo put: 36) ; CompassionFruit
						(SetFlag 34) ; fGaveFruit
						(if (IsFlag 33) ; fGaveFeather
							(= doing 6)
						else
							(= doing 8)
						)
						(self setScript: walkOverS)
					)
				)
			)
			((Said 'give/hair,fur')
				(if (not noticedEgo)
					(event claimed: 1)
					(self setScript: welcome)
				else
					(Say harikHead 130 38) ; "You need to add the victim's hair to the potion I made for you just before you give it to the victim. It must be freshly collected from the victim."
				)
			)
			((Said 'get,use,eat,eat/pill>'))
			((Said 'grab')
				(SkillUsed 14 -50) ; honor
				(= noticedEgo 1)
				(Say harikHead 130 39) ; "I suggest you do not touch what you do not know. The wrong drug could easily be fatal."
			)
			((Said 'get,get')
				(= noticedEgo 1)
				(Say harikHead 130 40) ; "If you need something, I'd be pleased to sell it to you."
			)
			((Said 'make,give,show/sign[<thief]')
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((MakeSign)
						(Say harikHead 130 41) ; "Most strange. If you have an upset stomach, perhaps you should buy a Healing Pill."
					)
					(else
						(Say harikHead 130 42) ; "That was in exceptionally poor taste."
					)
				)
			)
			((Said 'attack/attar,attar,clerk,clerk,man')
				(= noticedEgo 1)
				(Say harikHead 130 43) ; "Forgive me, but I have no time for such a thing."
			)
			((Said 'give,sell/venom,tail[<scorpion]')
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((gEgo has: 29) ; ScorpionTail
						(= doing 9)
						(self setScript: walkOverS)
					)
					(else
						(DontHave)
					)
				)
			)
			((Said 'sell/venom,claw[<ghoul]')
				(cond
					((not noticedEgo)
						(event claimed: 1)
						(self setScript: welcome)
					)
					((gEgo has: 30) ; GhoulClaw
						(= doing 10)
						(self setScript: walkOverS)
					)
					(else
						(DontHave)
					)
				)
			)
		)
	)
)

(instance askLamp of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say harikHead self 135 54) ; "I get my lamps from the Brass Seller at the Bazaar."
			)
			(1
				(if (and (== gDay 6) (not (gEgo has: 33))) ; BrassLamp
					(Say harikHead self 135 55) ; "Do you need one to capture the Fire Elemental? I can let you have this one."
				else
					(self dispose:)
				)
			)
			(2
				(= doing 11)
				(client setScript: walkOverS)
			)
		)
	)
)

(instance putMoney of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HighPrint 130 44) ; "You take the money and put it away."
				(self dispose:)
			)
		)
	)
)

(instance givePowderS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say harikHead self 130 45 130 46 130 47 130 48) ; "Since you put it that way, I guess I will just have to give you the Powder of Burning."
			)
			(1
				(harik
					setScript: 0
					loop: 3
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(HighPrint 130 49) ; "You pick up the powder of burning and put it away."
				(harik cycleSpeed: 1 setScript: mixingS)
				(SolvePuzzle 697 5 2)
				(gEgo get: 39 6) ; BurningPowder
				(SetFlag 37) ; fGotBurnPowder
				(self dispose:)
			)
		)
	)
)

(instance welcome of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= noticedEgo 1)
				(Face gEgo harik)
				(Say harikHead self 130 50) ; "Ah, I did not notice you come in."
			)
			(1
				(cond
					((and firstTime (<= 3 gDay 6))
						(Say harikHead self 130 51) ; "Have you seen the Fire Elemental? It is magic of the most marvelous kind. So very beautiful, the dancing flames. If I but had such a creature at my command, the pills I would make!"
					)
					((and firstTime (OneOf gDay 12 13) (== gElementalState 5))
						(Say harikHead self 130 52) ; "I have heard that it was you that vanquished the Elemental of Air as well as of Flame. Perhaps you now need to know something about the Element of Earth."
					)
					((and firstTime (OneOf gDay 15 16))
						(Say harikHead self 130 53) ; "I have heard a rumor that you are taking a caravan to Raseir. It would be best if you purchased some extra pills to take with you."
					)
					(else
						(switch gHarikVisits
							(1
								(Say harikHead self 130 54) ; "This is the Apothecary, where one can buy many wondrous pills and oils. I am Harik. If you need something, just let me know."
							)
							(else
								(Say harikHead self 130 55) ; "Welcome back. If you see something which interests you, let me know."
							)
						)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance mixingS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(harik loop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
				(leftBottle hide:)
				(rightBottle hide:)
			)
			(1
				(if (harikHead cycler:)
					(= cycles 15)
				else
					(harik
						loop: 6
						cel: 0
						setCycle: ForwardCounter (Random 3 5) self
					)
				)
			)
			(2
				(harik loop: 2 cel: 1 setCycle: Beg self)
			)
			(3
				(if noticedEgo
					(leftBottle show:)
					(rightBottle show:)
					(harik loop: 1 cel: 0 setCycle: End self)
					(mortar hide:)
				else
					(self changeState: 0)
				)
			)
			(4
				(= cycles (Random 2 12))
			)
			(5
				(harik setCycle: Beg self)
			)
			(6
				(mortar show:)
				(= seconds (Random 2 8))
			)
			(7
				(self changeState: (if (Random 0 2) 0 else 3))
			)
		)
	)
)

(instance showFlame of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(harik setScript: 0 loop: 2 setCycle: Beg self)
				(leftBottle hide:)
				(rightBottle hide:)
				(mortar show:)
			)
			(1
				(Say harikHead self 130 56) ; "Watch this."
			)
			(2
				(leftBottle show:)
				(rightBottle show:)
				(harik loop: 4 cel: 0 setCycle: End self)
				(Face gEgo brazSmoke)
			)
			(3
				(= cycles 3)
			)
			(4
				(harik loop: 5 cel: 0)
				(gSpareSound number: 561 loop: 1 play:)
				(brazSmoke loop: 4 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(5
				(brazSmoke loop: 3 cycleSpeed: 1 setCycle: Fwd)
				(harik cycleSpeed: 1 setCycle: CT 3 1 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(harik cel: 2)
				(= cycles 2)
			)
			(8
				(harik cel: 3)
				(= cycles 6)
			)
			(9
				(harik setCycle: End self)
			)
			(10
				(= cycles 2)
			)
			(11
				(harik loop: 2 cel: 0 cycleSpeed: 0)
				(leftBottle hide:)
				(rightBottle hide:)
				(= cycles 2)
			)
			(12
				(Face gEgo harikHead)
				(switch askedAbout
					(1
						(Say harikHead self 130 57) ; "See how the flame reacts to incense? Fire is attracted to the things it burns because it is very vain."
					)
					(2
						(Say harikHead self 130 58) ; "See how the earth is consumed by the flames! Pretty amazing, isn't it? I'm sure there's a lesson to be learned from this, although I don't quite know what that might be."
					)
				)
			)
			(13
				(= cycles 1)
			)
			(14
				(switch askedAbout
					(1
						(cond
							((== gElementalState 1)
								(Say harikHead self 130 59) ; "It would be very possible to lure the Fire Elemental away from the plazas using this incense, and where it is weak from hunger and water, capture it."
							)
							((< gElementalState 1)
								(Say harikHead self 130 60) ; "You know, incense would make quite a lure for a Fire Elemental."
							)
							(else
								(Say harikHead self 130 61) ; "As you have discovered, incense is quite a lure for Fire Elementals."
							)
						)
					)
					(2
						(if (and (== gOrigHeroType 2) (not (IsFlag 37))) ; fGotBurnPowder
							(Say harikHead self 130 62) ; "Maybe you could use some magical fire to burn magical earth? I do have some Powder of Burning that might work. But it is very rare, and it makes such pretty flames! I'd hate to have it wasted."
						else
							(self cue:)
						)
					)
				)
			)
			(15
				(= cycles 1)
			)
			(16
				(Say harikHead self 130 63) ; "Now I must get back to my work. If you see something which interests you, let me know."
			)
			(17
				(harik setScript: mixingS)
				(self dispose:)
			)
		)
	)
)

(instance walkOverS of HandsOffScript
	(properties)

	(method (changeState newState &tmp howMany)
		(switch (= state newState)
			(0
				(gEgo ignoreActors: 1)
				(cond
					((gEgo inRect: 163 152 227 166)
						(self changeState: 4)
					)
					((and (< (gEgo x:) 113) (> (gEgo y:) 127))
						(self changeState: 2)
					)
					((> (gEgo y:) 148)
						(self changeState: 3)
					)
					(else
						(self changeState: 1)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 123 127 self)
			)
			(2
				(gEgo setMotion: MoveTo 113 160 self)
			)
			(3
				(gEgo setMotion: MoveTo 174 165 self)
			)
			(4
				(Face gEgo harikHead)
				(gEgo ignoreActors: 0)
				(= cycles 1)
			)
			(5
				(switch doing
					(0
						(Format @str 130 64 (/ pillCost 100)) ; "The pills you request are a mere %d dinars."
						(Say harikHead payS @str)
						(= doses 3)
						(client setScript: payS)
					)
					(1
						(Say harikHead payS 130 65) ; "Because you are such a fine person, for you I will make a special deal. I will sell you three doses of pills at regular price, and throw in a fourth dose free of charge."
						(= doses 4)
						(client setScript: payS)
					)
					(2
						(Say harikHead payS 130 66) ; "The incense will cost you but the price of my ingredients, a mere 70 centimes."
						(client setScript: payS)
					)
					(3
						(if (<= 3 gDay 6)
							(Say harikHead payS 130 67) ; "Very well. If it will save the city, you may take the incense."
						else
							(Say harikHead payS 130 68) ; "Very well. You may take the incense."
						)
						(= incenseCost 0)
						(client setScript: payS)
					)
					(4
						(Say harikHead payS 130 69) ; "The oil will cost you 20 centimes."
						(client setScript: payS)
					)
					(5
						(Say harikHead payS 130 70) ; "You speak as one born to bargain. It shall be 15 centimes."
						(= oilCost 15)
						(client setScript: payS)
					)
					(6
						(client setScript: makeDispelS)
					)
					(7
						(Say harikHead 130 71) ; "I still need the "Fruit of Compassion." You need to add the victim's hair at the last moment."
					)
					(8
						(Say harikHead 130 72) ; "I still need the feather of the Griffin. You need to add the victim's hair at the last moment."
					)
					(9
						(= howMany [gInvNum 29]) ; ScorpionTail
						(cond
							((>= gNumScorpTails 5)
								(Say harikHead 130 73) ; "I am in awe of your bravery that you have defeated so many of theses fearful monsters, but I am presently overstocked with scorpion venom, and I can purchase no more."
							)
							((== gNumScorpTails 4)
								(Say harikHead putMoney 130 74) ; "My, you are the brave and fortunate one! I am now almost completely stocked with scorpion venom. I will purchase one more scorpion tail."
								(gEgo put: 29) ; ScorpionTail
								(gEgo get: 2 20) ; Dinar
								(++ gNumScorpTails)
								(client setScript: putMoney)
							)
							(else
								(Say
									harikHead
									putMoney
									(Format @str 130 75 (* howMany 20)) ; "Ah, wonderful. I was almost out of Poison Cure Pills. Now I can make up some more. Here is your reward of %d dinars."
								)
								(gEgo put: 29 howMany) ; ScorpionTail
								(gEgo get: 2 (* howMany 20)) ; Dinar
								(+= gNumScorpTails howMany)
								(client setScript: putMoney)
							)
						)
					)
					(10
						(= howMany [gInvNum 30]) ; GhoulClaw
						(cond
							((>= gNumGhoulClaws 10)
								(Say harikHead 130 76) ; "My spine shivers at the thought of so much battle with the fiendish Ghouls, but despite your bravery, I regret that my larder of Ghoul claws is full, and I can purchase no more."
							)
							((>= gNumGhoulClaws 7)
								(Say harikHead putMoney 130 77) ; "Your valor in the face of the dreaded Ghouls is impressive. My supply of claws is almost complete, but I will yet purchase a few more."
								(if (> howMany 2)
									(= howMany 3)
								)
								(gEgo put: 30 howMany) ; GhoulClaw
								(gEgo get: 2 (* 15 howMany)) ; Dinar
								(+= gNumGhoulClaws howMany)
								(client setScript: putMoney)
							)
							(else
								(Say
									harikHead
									putMoney
									(Format @str 130 78 (* howMany 15)) ; "Now I can continue with my experiments. A thousand thanks for these, and may this reward of %d dinars gladden your heart."
								)
								(gEgo put: 30 howMany) ; GhoulClaw
								(gEgo get: 2 (* 15 howMany)) ; Dinar
								(+= gNumGhoulClaws howMany)
								(client setScript: putMoney)
							)
						)
					)
					(11
						(HighPrint 130 79) ; "You take an oil-filled lamp."
						(SolvePuzzle 624 7)
						(gEgo get: 33) ; BrassLamp
					)
				)
				(if client
					(self dispose:)
				)
			)
		)
	)
)

(instance payS of HandsOffScript
	(properties)

	(method (changeState newState &tmp item cost qty moreThanOne howMany quiet)
		(switch (= state newState)
			(1
				(cond
					((or (== doing 0) (== doing 1))
						(= item pillType)
						(= cost pillCost)
						(= qty doses)
						(= moreThanOne 1)
						(= howMany 0)
						(= quiet 0)
					)
					((or (== doing 2) (== doing 3))
						(= item 13)
						(= cost incenseCost)
						(= incenseCost 70)
						(= qty 1)
						(= moreThanOne 1)
						(= howMany 0)
						(= quiet 0)
					)
					(else
						(= item 42)
						(= cost oilCost)
						(= oilCost 20)
						(= qty 1)
						(= moreThanOne 1)
						(= howMany 0)
						(= quiet 0)
					)
				)
				(switch (Buy item cost qty moreThanOne howMany quiet)
					(1
						(Say harikHead self 130 80) ; "I'm sorry, but I can only accept the coins of Shapeir. You will need to first see the Money Changer."
					)
					(0
						(Say harikHead self 130 81) ; "I'm afraid you do not have enough money for the purchase."
					)
					(else
						(cond
							((or (== doing 0) (== doing 1))
								(if (== item 48)
									(SolvePuzzle 657 3 0)
								)
								(Say harikHead 130 82) ; "There is a special money-back guarantee with every pill I sell. If you die because of a pill, I will gladly refund your money."
							)
							((or (== doing 2) (== doing 3))
								(SolvePuzzle 607 7)
							)
							(else
								(SolvePuzzle 696 3 2)
							)
						)
						(client setScript: giveItemsS)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance giveItemsS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(harik loop: 3 cel: 0 setScript: 0 setCycle: End self)
			)
			(1
				(harik setScript: mixingS)
				(self dispose:)
			)
		)
	)
)

(instance dispelS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (IsFlag 36)) ; fHeardDispelTalk
						(SetFlag 36) ; fHeardDispelTalk
						(Say harikHead self 130 83 130 84 130 36) ; "A potion to break enchantments? I know of one in which the victim drinks the potion and the spell ends."
					)
					((not (and (gEgo has: 28) (gEgo has: 36))) ; Feather, CompassionFruit
						(Say harikHead self 130 85 130 86) ; "I cannot make the potion without all the ingredients."
					)
					((IsFlag 35) ; fMadeDispelPotion
						(Say harikHead self 130 87) ; "Oh yes. Have you had a chance to use it yet? I would be most anxious to hear how it worked."
					)
					(else
						(HighPrint 130 88) ; "You give the Fruit of Compassion and the Griffin Feather to Harik."
						(gEgo put: 28) ; Feather
						(gEgo put: 36) ; CompassionFruit
						(self setScript: makeDispelS self)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance makeDispelS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say harikHead self 130 89) ; "This will only take me a second."
			)
			(1
				(= seconds 3)
			)
			(2
				(harik setScript: 0 loop: 3 cel: 5)
				(SetFlag 35) ; fMadeDispelPotion
				(= cycles 4)
			)
			(3
				(harik loop: 2 cel: 5)
				(Say harikHead self 130 90 130 91 130 92 130 93) ; "There. I do for you what I would not for another. This is a gift for all you have done for the city."
			)
			(4
				(HighPrint 130 94) ; "You take the three potion bottles and put them away."
				(SolvePuzzle 608 7)
				(gEgo get: 21 3) ; DispelPotion
				(Say harikHead self 130 95) ; "Now, please excuse me. I really must get back to my work."
			)
			(5
				(harik setScript: mixingS)
				(self dispose:)
			)
		)
	)
)

(instance harik of Prop
	(properties
		x 188
		y 130
		description {Harik Attar}
		lookStr {The druggist seems to keep busy at his trade.}
		view 135
		loop 2
		priority 10
		signal 16400
		cycleSpeed 2
	)
)

(instance harikHead of Talker
	(properties
		x 192
		y 146
		z 30
		description {Harik Attar}
		view 135
		loop 7
		priority 11
		signal 16400
		illegalBits 0
		talkSpeed 1
		myName '//attar,attar,clerk,clerk,man'
		title {Harik Attar:}
		color 14
		back 4
		msgFile 135
	)

	(method (showText what)
		(if (not noticedEgo)
			(= noticedEgo 1)
			(gCurRoom setScript: welcome)
		else
			(switch what
				(-1
					(SolvePuzzle 606 3)
					(= askedAbout 1)
					(gCurRoom setScript: showFlame)
				)
				(-2
					(SolvePuzzle 605 3)
					(= askedAbout 2)
					(gCurRoom setScript: showFlame)
				)
				(-3
					(gCurRoom setScript: dispelS)
				)
				(-4
					(cond
						((not noticedEgo)
							(self setScript: welcome)
						)
						((IsFlag 37) ; fGotBurnPowder
							(Say harikHead 130 10) ; "I have already given you my very last speck of it."
						)
						(else
							(Say harikHead 130 11 130 12) ; "I only have a little left. I really couldn't part with it for any price."
							(= askedIfNeeded 1)
						)
					)
				)
				(-5
					(cond
						((IsFlag 35) ; fMadeDispelPotion
							(Say harikHead 130 96) ; "But I have already given the dispel potion to you."
						)
						((IsFlag 34) ; fGaveFruit
							(Say harikHead 130 97) ; "If you can but get me the Griffin's feather, I will give you the potion."
						)
						((IsFlag 33) ; fGaveFeather
							(Say harikHead 130 98) ; "If you can but get me the "Fruit of Compassion", I will give you the potion."
						)
						(else
							(Say harikHead 130 99) ; "If you can but get me the Griffin's feather and the "Fruit of Compassion", I will give you the potion."
						)
					)
				)
				(54
					(gCurRoom setScript: askLamp)
				)
				(30
					(self showMany: what 32)
				)
				(41
					(self showMany: what 42)
				)
				(54
					(self showMany: what 55)
				)
				(47
					(self showMany: what 48)
				)
				(52
					(if (IsFlag 606)
						(super showText: what)
					else
						(Say self 130 100) ; "I'm not sure what you wish to capture."
					)
				)
				(28
					(if (IsFlag 606)
						(self showMany: what 29)
					else
						(super showText: what)
					)
				)
				(else
					(super showText: what)
				)
			)
		)
	)

	(method (atSpec which)
		(return [harikSpecList which])
	)

	(method (atGen which)
		(return [harikGenList which])
	)
)

(instance aSmoke of Extra
	(properties
		shiftClick 0
		view 130
		cycleType 1
		minPause 2
		maxPause 5
		minCycles 1
		maxCycles 3
	)
)

(instance aCenser of PicView
	(properties
		shiftClick 0
		view 130
		loop 1
		signal 16384
	)
)

(instance brazSmoke of Prop
	(properties
		x 151
		y 131
		noun '/smoke'
		description {smoke}
		lookStr {The smoke from the brazier smells of sweet incense and halibut.}
		view 130
		loop 3
		priority 11
		signal 16400
		cycleSpeed 1
	)
)

(instance mortar of View
	(properties
		x 180
		y 135
		noun '/mortar'
		description {the mortar}
		lookStr {It needs a pestle to be useful.}
		view 130
		priority 11
		signal 16400
	)
)

(instance leftBottle of View
	(properties
		x 175
		y 133
		noun '/bottle'
		description {the bottle}
		lookStr {It's a bottle.__You can barely make out the label:\n"Servings per container....8\nCalories...."\nYou can't make out the rest.}
		view 130
		cel 4
		priority 11
		signal 16400
	)
)

(instance rightBottle of View
	(properties
		x 207
		y 134
		noun '/bottle'
		description {the bottle}
		lookStr {It's a bottle.__You can barely make out the label:\n"Servings per container....8\nCalories...."\nYou can't make out the rest.}
		view 130
		cel 6
		priority 11
		signal 16400
	)
)

(instance pillBag of View ; UNUSED
	(properties
		x 199
		y 144
		noun '/bag'
		description {the pill bag}
		lookStr {It's a pill bag.}
		view 130
		cel 3
		priority 11
		signal 16400
	)
)

(instance bowl of PicView
	(properties
		x 192
		y 135
		noun '/pestle,bowl'
		description {the pestle}
		lookStr {It needs a mortar to be useful.}
		view 130
		cel 2
		priority 10
		signal 16400
	)
)

(instance urn of PicView
	(properties
		x 229
		y 132
		noun '/urn'
		description {the urn}
		lookStr {It's a funerary urn.__At the top is the hole for the ashes.}
		view 130
		cel 1
		priority 11
		signal 16400
	)
)

(instance scale of PicView
	(properties
		x 246
		y 128
		noun '/climb'
		description {the scale}
		view 130
		cel 5
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 130 101) ; "It's a scale, without which Harik would be unbalanced."
			)
			(7
				(HighPrint 130 102) ; "You can't get a weigh with that. You'd get pounded."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance braz of PicView
	(properties
		x 149
		y 150
		noun '/brazier'
		description {the brazier}
		lookStr {It's a brazier, fully filled with flames.}
		view 130
		cel 7
		priority 11
		signal 16
	)
)

(instance lamp1 of PicView
	(properties
		x 231
		y 41
		noun '/lamp'
		description {the lamp}
		lookStr {It's a ceiling lamp, although the ceiling is pretty bright by itself.}
		view 130
		cel 8
		signal 16400
	)
)

(instance lamp2 of PicView
	(properties
		x 71
		y 41
		noun '/lamp'
		description {the lamp}
		lookStr {It's a ceiling lamp, although the ceiling is pretty bright by itself.}
		view 130
		cel 8
		signal 16400
	)
)

(instance bookshelf of Feature
	(properties
		x 109
		y 69
		noun '/bookcase,shelf[<book]'
		nsTop 45
		nsLeft 96
		nsBottom 94
		nsRight 123
		description {the bookshelf full of books}
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint (Format @str 130 103 [bookMsg msgCounter])) ; "There seem to be books in many languages, few of which are comprehensible to you, but you do recognize some old favorites, such as %s"
			(if (> (++ msgCounter) 10)
				(= msgCounter 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shelf of Feature
	(properties
		x 232
		y 80
		noun '/shelf'
		nsTop 46
		nsLeft 202
		nsBottom 115
		nsRight 262
		description {shelves filled with unusual objects}
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint (Format @str 130 104 [shelfMsg msgCounter])) ; "The shelves are filled with unusual objects. You see something that looks like %s."
			(if (> (++ msgCounter) 10)
				(= msgCounter 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

