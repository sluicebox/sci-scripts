;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use Talker)
(use Plaza)
(use Merchant)
(use KattaMerchant)
(use PlazaDoor)
(use n301)
(use Polygon)
(use ForwardCounter)
(use LoadMany)
(use Extra)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rmSPlazaGates 0
	kattaInnSign 1
)

(local
	fireElemental
	[string 25]
	[string2 10]
	beenNearMapStand
	beenNearFlowerStand
	boughtAnything
	makingExitSpeech
	oldTalkLoop
	beggarIsHere
	[lishaGreeting 21] = [16 32 0 300 0 12 31 5 300 1 9 30 3 300 2 5 29 1 300 3 -1]
	[alichicaGenList 38] = [1 2 3 0 4 5 6 7 8 0 0 10 0 0 11 12 13 0 14 0 15 16 17 18 19 20 23 24 25 26 27 0 28 0 0 0 0 0]
	[alichicaSpecList 16] = [35 '//duck,viaduct' 39 '//souvenir' 43 '//map' 44 '//compass' -1 '//stand' 40 '//dinar,cent' -2 '//sock,trashcan,feet,turban,ashtray,guide,keychain,chain,bookend' 0 0]
	[lishaSpecList 14] = [29 '//bouquet,plant,merchandise' 32 '//sitar,charmer' 30 '//musician' 31 '//serpent' 33 '//bazaar' -1 '//alichica,ali,alichica' 0 0]
)

(procedure (GiveToMusician)
	(switch (CheckFunds 1)
		(2
			(GiveMoney 1)
			(SkillUsed 14 10) ; honor
			(HighPrint 300 43) ; "The musician nods and smiles while he plays."
		)
		(1
			(HighPrint 300 44) ; "The musician has no need of your Spielburgian money."
		)
		(else
			(HighPrint 300 45) ; "You haven't any to give."
		)
	)
)

(procedure (SayLishaGreeting theCaller &tmp i)
	(for
		((= i 0))
		(and (!= [lishaGreeting i] -1) (< gDay [lishaGreeting i]))
		((+= i 5))
	)
	(if
		(and
			(!= [lishaGreeting i] -1)
			(not (IsFlag [lishaGreeting (+ i 1)]))
			(!= gElementalState 1)
			(> gElementalState [lishaGreeting (+ i 2)])
		)
		(Say lisha theCaller [lishaGreeting (+ i 3)] [lishaGreeting (+ i 4)])
		(SetFlag [lishaGreeting (+ i 1)])
	else
		(theCaller cue:)
	)
)

(instance rmSPlazaGates of Plaza
	(properties
		north 704
		south 290
	)

	(method (init)
		(self
			addObstacle:
				(poly1
					init: 0 0 146 0 146 95 87 132 27 181 119 181 120 189 0 189
					yourself:
				)
				(poly2
					init: 168 0 319 0 319 189 205 189 205 181 306 181 285 168 256 162 248 150 249 133 178 100 171 95
					yourself:
				)
		)
		(SetFlag 16) ; fShapeir
		(LoadMany rsSCRIPT 972 969)
		(LoadMany rsVIEW 0 300)
		(if (== gElementalState 1)
			(LoadMany rsVIEW 18 19 61 21 340)
		)
		(if (and (<= 0 gTimeODay 4) (<= gDay 4))
			(Load rsVIEW 305)
			(Load rsTEXT 305)
		)
		(= saveIllegal -32768)
		(if
			(and
				(== gDay 8)
				(not (IsFlag 150)) ; fReturnedSaurus300
				(gEgo has: 50) ; Saurus
				(== gPrevRoomNum 100)
			)
			(SaurusEncounterInit)
		else
			(= entranceScript scrEntrance)
		)
		(super init:)
		(kattaInnDoor init:)
		(InitAddToPics alleySign leftShadow rightShadow leftBlock rightBlock)
		(if (<= 0 gTimeODay 4)
			(if (<= gDay 4)
				(++ gNAlichicaVisits)
				(alichica init:)
				(|= saveIllegal $0800)
			)
			(if (and (<= 0 gTimeODay 4) (not (IsElementalInRoom)))
				(sitar init:)
				(lisha init:)
				(|= saveIllegal $3000)
			)
			(if (OneOf gDay 7 10 15)
				(= beggarIsHere 1)
				((ScriptID 302 0) init:) ; beggar
			)
		)
		(if (IsFlag 181) ; fBurntTailSign
			(kattaInnSign
				view: 340
				loop: 9
				cel: 1
				description: {the very burnt sign}
				forceUpd:
				init:
			)
		else
			(kattaInnSign init:)
		)
		(if (== gElementalState 1)
			(= topFromY 40)
			(gCSound number: 140 loop: -1 playBed:)
			((= fireElemental (ScriptID 309 0)) setCycle: Fwd init:) ; fireElemental
		else
			(kattaInnSign addToPic:)
		)
	)

	(method (cue)
		(cond
			(makingExitSpeech
				(= makingExitSpeech 0)
				(super doit:)
			)
			((and (== gElementalState 1) (fireElemental following:) (== inOut 2))
				(= north 303)
				(= inOut 3)
			)
			(else
				(super cue:)
			)
		)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			(makingExitSpeech)
			(
				(and
					(or (gEgo edgeHit:) (& (gEgo onControl: 1) $0010))
					(gCast contains: alichica)
					(== inOut 3)
					(not (IsFlag 108)) ; fVisitedAlichica
				)
				(if (not boughtAnything)
					(= makingExitSpeech 1)
					(gEgo setMotion: 0)
					(Say alichica self 300 4) ; "Whatsa matta you? You no like a big deal when you see it?"
				)
				(SetFlag 108) ; fVisitedAlichica
			)
			((and (== gElementalState 1) (gEgo edgeHit:))
				(super doit:)
				(if (< (fireElemental y:) 75)
					(= inOut 2)
					(= gRoomExitDir 1)
					(gCurRoom newRoom: 303)
				)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (dispose)
		(DisposeScript 301)
		(DisposeScript 302)
		(DisposeScript 309)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look<in,inner/waterbag')
				(if (gEgo has: 37) ; Waterskin
					(HighPrint 300 5) ; "You can't see inside the waterskin."
				else
					(HighPrint 300 6) ; "waterskin? What waterskin?"
				)
			)
		)
	)
)

(instance kattaInnDoor of PlazaDoor
	(properties
		x 253
		y 117
		noun '/door[<hotel]'
		description {the door to the Inn}
		lookStr {If you can believe the sign, the door leads to the Katta's Tail Inn.}
		view 301
		loop 3
		priority 6
		signal 16400
		entranceTo 100
		exitDir 1
		xOut 278
		yOut 115
		xIn 230
		yIn 115
	)

	(method (isLocked)
		(return 0)
	)
)

(instance alichica of Merchant
	(properties
		x 87
		y 99
		description {Alichica}
		lookStr {This guy looks like he could play the piano, but strangely.}
		view 305
		loop 1
		priority 7
		signal 16400
		illegalBits 0
		tLoop 1
		myName '//man,merchant,alichica,ali,alichica'
		title {Alichica:}
		color 15
		back 4
		msgFile 305
	)

	(method (init)
		(super init:)
		(InitAddToPics map alichicaStand backOfStand)
		((gCurRoom merchants:) add: self)
		(self addWares: mapWare compassWare)
		(if (== gDay 4)
			(self setPri: 8)
		)
	)

	(method (showSelf)
		(Say self 300 7) ; "My name, he is Alichica"
	)

	(method (has)
		(if (>= gDay 4)
			(if (Said '/forest')
				(Say self 300 8) ; "Ehhh...you wood knot want it."
			else
				(Say self 300 9) ; "Sorry boss, all I got is a buncha burnt wood."
			)
			(return -1)
		else
			(return (super has:))
		)
	)

	(method (sell)
		(if (== curWare mapWare)
			(SolvePuzzle 621 7)
		)
		(if (== curWare compassWare)
			(SolvePuzzle 620 7)
		)
		(super sell: &rest)
	)

	(method (saySoldBegin)
		(if (== curWare mapWare)
			(self setScript: alichicaBuyMap self (curWare curPrice:))
		else
			(self setScript: alichicaBuyCompass self (curWare curPrice:))
		)
	)

	(method (saySoldEnd)
		(= boughtAnything 1)
	)

	(method (sayDoesntHave)
		(self setScript: alichicaRanOut)
	)

	(method (sayNotEnoughMoney)
		(Say self 300 10) ; "Hey! What you think this is, a charity? You ain't gotta the money."
	)

	(method (sayMoneyNeedsChanging)
		(Say self 300 11) ; "Wait a minute! What you think I am, a money changer?  You money, itsa no good. You need to getta this changed to dinars and centimes before you can buya something."
	)

	(method (sayNotCloseEnough)
		(Say self 300 12) ; "Hey you! Come over here if you wanta buy something!"
	)

	(method (sayBargainSuccess)
		(Say self self 305 45) ; "All right, you drive a hard bargain. I give-a you this and you give-a me 50 centimes."
	)

	(method (sayBargainFailure)
		(Say self self 305 46) ; "Okay, okay, we make a deal. I sella you this for only 150 centimes."
	)

	(method (atGen which)
		(return [alichicaGenList which])
	)

	(method (atSpec which)
		(return [alichicaSpecList which])
	)

	(method (showText what)
		(switch what
			(20
				(self showMany: what 22)
			)
			(35
				(self showMany: what 38)
			)
			(4
				(if (== (alichicaStand cel:) 1)
					(Say self msgFile what)
				else
					(self showText: 0)
				)
			)
			(-1
				(self showText: (if (== (alichicaStand cel:) 1) 42 else 41))
			)
			(-2
				(self setScript: alichicaRanOut)
			)
			(else
				(super showText: what)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((Said 'ask//fire')
				(if (== gDay 4)
					(Say alichica 300 13) ; "It's hot, it's red, it's something you cook with, it burned my stand down."
				)
			)
			((or (Said 'why/duck') (Said '/viaduct'))
				(self showMany: 35 38)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (doit)
		(super doit:)
		(if (gCurRoom script:)
			(return)
		)
		(if
			(and
				(not beenNearMapStand)
				(not (IsFlag 108)) ; fVisitedAlichica
				(< (gEgo distanceTo: alichica) 60)
			)
			(Say self 300 14 300 15 300 16) ; "You look like sucha fine person, have I gotta deal for you!"
			(= beenNearMapStand 1)
		)
	)
)

(instance mapWare of Ware
	(properties
		invItem 22
		noun '//map>'
		price 100
		lowPrice 50
		highPrice 150
		canBuyMultiple 0
	)
)

(instance compassWare of Ware
	(properties
		invItem 23
		noun '//compass>'
		price 100
		lowPrice 50
		highPrice 150
		canBuyMultiple 0
	)
)

(instance alichicaStand of PicView
	(properties
		x 77
		y 124
		noun '/stand[<alichica,ali,alichica]'
		description {Alichica's stand}
		view 300
		priority 8
		signal 16400
	)

	(method (init)
		(super init:)
		(if (== gDay 4)
			(= cel 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== (alichicaStand cel:) 1)
					(HighPrint 300 17) ; "The stand seems to have been badly burned."
				else
					(HighPrint 300 18) ; "The odd character at this stand seems vaguely familiar."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance map of PicView
	(properties
		x 60
		y 90
		noun '/map'
		description {the map on the wall}
		lookStr {It is a map of the streets and alleys of Shapeir.}
		view 300
		cel 2
		priority 6
		signal 16400
	)
)

(instance backOfStand of PicView
	(properties
		x 92
		y 118
		z 16
		shiftClick 0
		view 300
		cel 3
		priority 7
		signal 16400
	)
)

(instance lisha of KattaMerchant
	(properties
		x 8
		y 168
		description {Lisha, the Flower Lady}
		lookStr {You see a charming young Katta with a smile for you.}
		priority 12
		signal 16400
		myName '//lisha,catperson,merchant,girl,woman'
		title {Lisha:}
		clothesColor 6
	)

	(method (init)
		(super init:)
		(InitAddToPics flowerStand)
		(self addWares: flowers)
	)

	(method (sell)
		(super sell: &rest)
		(curWare price: 10)
	)

	(method (sayMoneyNeedsChanging)
		(if (IsFlag 185) ; fFreeFlowers
			(Say self self 300 19) ; "I am sorry, but I really cannot afford to give you any more free flowers. Please visit the Money Changer."
		else
			(SetFlag 185) ; fFreeFlowers
			(Say self self 300 20) ; "You will need to go to the Changer of Money to trade your coins for those of Shapeir. But since you are a Hero to my people, you may have some of my flowers anyway."
			(curWare price: 0)
			(= cueMethod 643)
		)
	)

	(method (sayNotEnoughMoney)
		(Say self self 300 21) ; "Since you are a friend of my people, then you may have some flowers even though you have not the money."
		(curWare price: 0)
		(= cueMethod 643)
	)

	(method (saySoldBegin)
		(Say self self 300 22) ; "I hope these flowers will bring you happiness."
	)

	(method (saySoldEnd)
		(HighPrint 300 23) ; "You put the flowers away."
	)

	(method (sayBargainSuccess)
		(Say self self msgFile 34)
	)

	(method (sayBargainFailure)
		(Say self self msgFile 35)
	)

	(method (sayNotCloseEnough)
		(Say self 300 24) ; "Please approach my flower stand if you wish to buy my flowers, Effendi."
	)

	(method (showSelf)
		(Say self 300 25) ; "My name is Lisha, which means "Quiet One" in the language of the Katta."
	)

	(method (atIndividualSpec which)
		(return [lishaSpecList which])
	)

	(method (showText what)
		(switch what
			(-1
				(if (gCast contains: alichica)
					(Say self 300 26) ; "A strange sort of person, even for a human."
				else
					(Say self 300 27) ; "The strange man decided to leave town with his friend of the golden hair and strange social behavior. He said something about going to "Fredonia.""
				)
			)
			(else
				(super showText: what)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (gCurRoom script:)
			(return)
		)
		(if (and (not beenNearFlowerStand) (< (gEgo distanceTo: lisha) 60))
			(Say self 300 28) ; "Flowers of beauty, flowers of fragrances most wonderful.  Flowers to bring cheer to your day."
			(= beenNearFlowerStand 1)
		)
	)
)

(instance flowers of Ware
	(properties
		invItem 26
		noun '//plant,bouquet>'
		price 10
		lowPrice 5
	)
)

(instance flowerStand of PicView
	(properties
		x 20
		y 172
		noun '/stand,bouquet'
		description {the flower stand}
		lookStr {The flowers at the flower stand are very beautiful indeed, and the charming young Katta girl has a smile for you.}
		view 300
		loop 8
		priority 11
		signal 16400
	)
)

(instance sitar of Prop
	(properties
		x 282
		y 152
		noun '/sitar,charmer,musician,catperson'
		description {Sitar, the snake charmer}
		lookStr {He looks like a charming fellow.}
		view 302
		loop 1
		cel 1
		priority 11
		signal 16912
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(snakeSound init: play:)
		(self setCycle: Fwd)
		(snake init:)
		((gCurRoom merchants:) add: self)
		(InitAddToPics snakeBasket snakeRug)
	)

	(method (dispose)
		(snakeSound dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((Said 'ask,talk,talk/sitar,charmer,musician,catperson')
				(HighPrint 300 29) ; "The musician seems too busy to answer you."
			)
			((Said 'give,throw/alm,cent,alm[/sitar,charmer,musician,catperson]')
				(if (not (< (gEgo distanceTo: sitar) 60))
					(HighPrint 300 30) ; "You're not close enough to the musician."
					(event claimed: 1)
				else
					(GiveToMusician)
				)
			)
			((Said 'get,get,grab/alm,cent,alm')
				(SkillUsed 14 -20) ; honor
				(HighPrint 300 31) ; "You don't dare, with such a vicious snake so near."
			)
			((Said 'look,look/sitar,charmer,musician,catperson')
				(HighPrint 300 32) ; "You see a Katta musician playing some sort of musical instrument and charming a dangerous-looking snake. There are some brass coins thrown onto his carpet."
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)
)

(instance snake of Extra
	(properties
		x 267
		y 143
		noun '/serpent,cobra'
		description {the charmer's snake}
		view 302
		loop 2
		priority 11
		signal 16912
		cycleSpeed 2
		cycleType 2
		hesitation 1
		minCycles 0
		maxCycles 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 300 33) ; "The snake took a wrong turn one day and wound up listening to a Katta who likes to think he's Benny Goodman."
			)
			(7
				(HighPrint 300 34) ; "You need a snake like you need a five-pound desert mosquito of your very own."
			)
			(9
				(HighPrint 300 35) ; "Charmed, I'm sure."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance snakeRug of PicView
	(properties
		x 285
		y 158
		noun '/carpet'
		description {the snake charmer's rug}
		lookStr {The rug's design is charming.}
		view 302
		priority 0
		signal 16400
	)
)

(instance snakeBasket of PicView
	(properties
		x 266
		y 149
		noun '/basket'
		description {the snake's basket}
		lookStr {It ain't much, but the snake calls it home.}
		view 302
		cel 1
		priority 11
		signal 16
	)
)

(instance kattaInnSign of View
	(properties
		x 255
		y 43
		noun '/sign[<hotel]'
		description {the sign of the Katta's Tail Inn}
		view 301
		cel 5
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== view 340)
					(HighPrint 300 36) ; "The Katta's Tail Inn sign has been burned beyond recognition"
				else
					(HighPrint 300 37) ; "The sign says that the door leads to the Katta's Tail Inn."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alleySign of PicView
	(properties
		x 160
		y 46
		noun '/sign[<alley,bearing,street]'
		description {the alley sign}
		lookStr {The symbol on the sign indicates "North".__The sign itself reads "Junub Tarik," which means "South Street."}
		view 310
		loop 2
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance leftShadow of PicView
	(properties
		x 69
		y 189
		shiftClick 0
		view 300
		loop 5
		priority 0
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance rightShadow of PicView
	(properties
		x 257
		y 189
		shiftClick 0
		view 300
		loop 5
		priority 0
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance leftBlock of PicView
	(properties
		x 14
		y 189
		shiftClick 0
		view 300
		loop 6
		priority 15
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance rightBlock of PicView
	(properties
		x 305
		y 189
		shiftClick 0
		view 300
		loop 6
		priority 15
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance scrEntrance of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (gCast contains: alichica))
						(self cue:)
					)
					((== (alichicaStand cel:) 1)
						(Say alichica self 300 38) ; "Fire sale today!  I sella you real wood burned by real Fire Elemental. Be the first on your block to owna this."
					)
					((IsFlag 108) ; fVisitedAlichica
						(Say
							alichica
							self
							305
							(ChooseFromCycle (- gNAlichicaVisits 1) 29 34)
						)
					)
					(else
						(Say alichica self 300 39 300 40 300 41 300 42) ; "You! Stranger! You justa in luck. I gotta everything you need right here."
					)
				)
			)
			(1
				(if (gCast contains: lisha)
					(SayLishaGreeting self)
				else
					(self cue:)
				)
			)
			(2
				(if beggarIsHere
					(self setScript: (ScriptID 302 1) self) ; beggarSpeech
				else
					(self cue:)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance alichicaBuyCompass of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: alichicaLookForNoMap self)
			)
			(1
				(= oldTalkLoop (alichica tLoop:))
				(alichica cycleSpeed: 0 tLoop: -1)
				(Say
					alichica
					self
					(Format ; "Here you go, boss. One compass for %s."
						@string
						300
						46
						(if (== register 100)
							{one dinar}
						else
							(Format @string2 300 47 register) ; "%d centimes"
						)
					)
				)
			)
			(2
				(HighPrint 300 48 67 -1 40) ; "You pay for the compass and put it away."
				(alichica tLoop: oldTalkLoop)
				(Say alichica self 300 49) ; "You no gonna regret this, boss. Guaranteed the best in town or you no getta you money back."
				(self dispose:)
			)
		)
	)
)

(instance alichicaRanOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: alichicaLookForNoMap self)
			)
			(1
				(alichica cycleSpeed: 0)
				(Say alichica 300 50) ; "Sorry, boss--I justa ran outa them. Maybe you come back tomorrow and I still notta have it."
				(self dispose:)
			)
		)
	)
)

(instance alichicaLookFor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say alichica self 300 51) ; "Lemme see if I got one."
			)
			(1
				(alichica loop: 4 cel: 255 setCycle: Beg self)
			)
			(2
				(alichica loop: 2 cycleSpeed: 1 setCycle: ForwardCounter 2 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance alichicaLookForNoMap of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: alichicaLookFor self)
			)
			(1
				(alichica loop: 4 cel: 0 setCycle: End self)
			)
			(2
				(alichica loop: 1 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance alichicaBuyMap of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: alichicaLookFor self)
			)
			(1
				(alichica loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(= oldTalkLoop (alichica tLoop:))
				(alichica cycleSpeed: 0 tLoop: -1)
				(Say
					alichica
					self
					(Format ; "Here you go, boss. One map for %s."
						@string
						300
						52
						(if (== register 100)
							{one dinar}
						else
							(Format @string2 300 47 register) ; "%d centimes"
						)
					)
				)
			)
			(3
				(HighPrint 300 53 67 -1 40) ; "You pay for the map and put it away."
				(alichica tLoop: oldTalkLoop)
				(Say alichica self 300 49) ; "You no gonna regret this, boss. Guaranteed the best in town or you no getta you money back."
				(self dispose:)
			)
		)
	)
)

(instance snakeSound of Sound
	(properties
		number 305
		priority 5
		loop -1
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

