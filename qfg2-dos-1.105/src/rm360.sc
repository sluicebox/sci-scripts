;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use Talker)
(use Flame)
(use Full)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm360 0
	ferrari 1
	bartender 2
	barMoveTimer 3
	wipeTimer 4
	waitTimer 5
	seatEgo 6
	KillEgo 7
)

(local
	[tempStr 50]
	seenDoor
	drinkType
	[drinkPrice 4] = [0 50 75 100]
	slingsDrunk
	[ferrariGenList 38] = [20 21 22 19 19 19 19 19 19 19 23 19 24 19 25 19 19 19 26 27 19 28 19 29 30 19 19 19 19 19 19 19 31 19 19 19 19 19]
	[ferrariSpecList 34] = [0 '//bird,falcon' 1 '//barman,barman' 2 '//room,cost' 3 '//bill,bill' 4 '//night' 5 '//ugarte' 6 '//game' 7 '//ability' 8 '//news' 9 '//ad[<ad]' 10 '//performance' 11 '//order' 12 '//service' 13 '//info' 14 '//khaveen' 15 '//someone' 0 0]
	[wilmerSpecList 16] = [0 '//drink' 1 '//water' 2 '//waterman,(man<water)' 3 '//coffee' 4 '//sling<djinn' 5 '//senor,(ferrari<senor)' 6 '//ferrari' 0 0]
	[pts1 10] = [152 32 135 117 167 118 158 72 205 26]
	[pts2 6] = [197 20 228 58 266 13]
	[pts3 6] = [257 21 321 69 321 8]
	[pts4 6] = [321 93 312 132 321 148]
	[pts5 12] = [1 157 119 129 140 134 138 159 85 181 1 191]
	[pts7 14] = [184 114 183 118 178 121 182 125 186 125 190 122 186 119]
	[pts8 8] = [186 93 182 99 186 101 190 99]
	[pts9 10] = [238 95 234 101 236 104 240 104 242 101]
	[pts10 14] = [295 100 294 104 291 106 292 109 299 109 300 107 297 103]
	[pts11 18] = [113 78 119 79 119 119 112 122 116 123 125 123 128 122 121 118 121 77]
	[pts12 10] = [124 78 123 93 126 93 130 87 127 78]
	[pts13 24] = [182 126 169 127 165 133 171 137 167 144 171 147 194 147 197 140 196 133 203 128 203 123 189 122]
	[pts14 18] = [158 124 183 120 220 123 225 129 210 142 189 146 160 143 152 138 148 131]
)

(procedure (KillEgo msg theTitle)
	(EgoDead 0 369 msg #icon 999 1 4 #title theTitle)
)

(procedure (BuyDrink what)
	(switch (CheckFunds [drinkPrice what])
		(0
			(Say bartender 360 0) ; "Hey! You want a free drink, go find a free world!"
		)
		(1
			(Say bartender 360 1) ; "We only accept Raseirian coin here, Foreigner."
		)
		(2
			(= drinkType what)
			(GiveMoney [drinkPrice drinkType])
			(switch drinkType
				(1
					(HighPrint 360 2) ; "You get a small glass of tepid, stale-tasting water."
				)
				(2
					(HighPrint 360 3) ; "The coffee has been boiled for hours, it would appear, and it best resembles brown ooze. You can understand why people remember Raseirish Coffee."
				)
				(3
					(HighPrint 360 4) ; "This drink sizzles in the glass."
					(HighPrint 360 5) ; "(It's the only way to get the glasses here clean!)"
				)
			)
		)
	)
)

(procedure (DrinkDrink what)
	(cond
		((== drinkType 0)
			(HighPrint 360 6) ; "There is one prerequisite. You need a drink."
		)
		((!= what drinkType)
			(switch drinkType
				(1
					(HighPrint 360 7) ; "You only have water."
				)
				(2
					(HighPrint 360 8) ; "You have only a cup of coffee."
				)
				(3
					(HighPrint 360 9) ; "You have a Djinn Sling, remember?"
				)
			)
		)
		(else
			(switch drinkType
				(1
					(HighPrint 360 10) ; "It is very dull, but it does quench the thirst."
				)
				(2
					(HighPrint 360 11) ; "It tastes very bitter, yet the flavor is oddly likable."
				)
				(3
					(if (== (++ slingsDrunk) 3)
						(KillEgo 8 {Been slung once too often})
					else
						(HighPrint 360 12) ; "Wow! You now know where the drink got its name. You feel as if you've just been slung by a Djinn."
					)
				)
			)
			(= drinkType 0)
		)
	)
)

(instance rm360 of Rm
	(properties
		picture 360
		style 6
	)

	(method (init &tmp shadowPeople)
		(LoadMany rsVIEW 0 100 360 361 363 365)
		(LoadMany rsTEXT 365 363)
		(LoadMany rsSCRIPT 951)
		(LoadMany rsSOUND 361)
		(= gNow (+ (* gDay 100) gTimeODay))
		(if (< gInnLastHere 2600)
			(= gInnLastHere 0)
		)
		(if (and (>= gTimeODay 4) (== gInnState 4))
			(++ gInnState)
		)
		(if (and (>= gTimeODay 4) (== gInnState 6) (!= gPrevRoomNum 370))
			(++ gInnState)
		)
		(if (and (>= gTimeODay 4) (== gInnState 1) (!= gPrevRoomNum 370))
			(++ gInnState)
		)
		(= global76 1)
		(super init:)
		(if (or (>= gTimeODay 4) (!= gDay 28))
			(ferrari init:)
		)
		(bartender init:)
		(NormalEgo)
		(if
			(not
				(= shadowPeople
					(+
						(mod (+ gDay gTimeODay) 28)
						(or (== gTimeODay 4) (== gTimeODay 5))
					)
				)
			)
			(= shadowPeople 1)
		)
		(if (> (mod shadowPeople 2) 0)
			(gAddToPics add: customer1)
		)
		(if (> (mod shadowPeople 3) 0)
			(gAddToPics add: customer2)
		)
		(if (> (mod shadowPeople 4) 0)
			(gAddToPics add: customer3)
		)
		(InitFeatures curtains bar lamps perch hole)
		(InitAddToPics table1 table2 table3 table4 table5 shelf1 shelf2 parrot)
		(if (not (IsFlag 55)) ; fLampTaken
			(oilLamp init:)
		)
		(if (or (== gTimeODay 4) (== gTimeODay 5))
			(flame1 init:)
			(InitAddToPics thieves drunk)
		)
		(if (OneOf gPrevRoomNum 380 361 401)
			(gCSound number: 361 loop: -1 priority: 0 playBed:)
		)
		(switch gPrevRoomNum
			(380
				(self setScript: (ScriptID 367 0)) ; enterScript
			)
			(400
				(self setScript: (ScriptID 367 0)) ; enterScript
			)
			(361
				(self setScript: (ScriptID 368 0)) ; sleepScript
			)
			(else
				(self setScript: (ScriptID 366 0)) ; beginScript
			)
		)
		(poly1 points: @pts1 size: 5)
		(poly2 points: @pts2 size: 3)
		(poly3 points: @pts3 size: 3)
		(poly4 points: @pts4 size: 3)
		(poly5 points: @pts5 size: 6)
		(poly7 points: @pts7 size: 7)
		(poly8 points: @pts8 size: 4)
		(poly9 points: @pts9 size: 5)
		(poly10 points: @pts10 size: 7)
		(poly11 points: @pts11 size: 9)
		(poly12 points: @pts12 size: 5)
		(poly13 points: @pts13 size: 12)
		(poly14 points: @pts14 size: 9)
		(self addObstacle: poly14)
	)

	(method (dispose)
		(= gInnLastHere gNow)
		(if (== gNewRoomNum 380)
			(gCSound fade:)
		)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(LoadMany 0 367 366 368 364)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((!= gCurRoomNum gNewRoomNum))
			((and (gCast contains: ferrari) (& (gEgo onControl: 1) $0010))
				(if
					(and
						(IsFlag 113) ; fSpose2Sit
						(not (IsFlag 171)) ; fInvited2Sit
						(!= (gEgo script:) seatEgo)
					)
					(SetFlag 171) ; fInvited2Sit
					(Say ferrari self 360 13) ; "Welcome to the Blue Parrot. I am Ferrari, Signor Ferrari. Sit down, my dear sir, relax. You are among friends here."
				)
			)
			((gEgo script:))
			((& (gEgo onControl: 1) $4000)
				(cond
					(gNight
						(gCurRoom setScript: goToSleep)
					)
					((not seenDoor)
						(HighPrint 360 14) ; "There is a large, closed door blocking your way. Apparently, the sleeping rooms are only accessible at night."
						(= seenDoor 1)
					)
				)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(self setScript: byeScript)
			)
			((and (== gInnState 1) (or (== gTimeODay 4) (== gTimeODay 5)))
				(++ gInnState)
			)
			((and (or (== gTimeODay 4) (== gTimeODay 5)) (== gDay 29))
				(self setScript: toJailS)
			)
			((and (!= (bartender x:) 99) (& (gEgo onControl: 1) $0002))
				(bartender setMotion: MoveTo 99 139)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 360 15) ; "Through the haze of smoke, you see a place that reminds you a bit of a dream which turned into a nightmare."
			)
			(
				(or
					(Said 'lockpick[/lock]')
					(Said 'use/(lockpick[<lock]),lockpick')
					(Said 'unlock')
				)
				(if (& (gEgo onControl: 1) $4000)
					(HighPrint 360 16) ; "You think back to Ferrari's warning, and decide that practicing on this lock is a little too dangerous. Better wait until evening when the door will be unlocked."
				else
					(event claimed: 0)
				)
			)
			((Said 'open,open/door')
				(HighPrint 360 17) ; "It is locked. Apparently, the sleeping rooms are only accessible at night."
			)
			((Said 'talk,talk,ask')
				(if (IsFlag 113) ; fSpose2Sit
					(HighPrint 360 18) ; "The person glares at you, then glances nervously over at Signor Ferrari."
				else
					(event claimed: 0)
				)
			)
			((Said 'sat')
				(if (gCast contains: ferrari)
					(if (== (gEgo view:) 361)
						(HighPrint 360 19) ; "You're already seated, remember?"
					else
						(gEgo setScript: seatEgo)
					)
				else
					(HighPrint 360 20) ; "There's no need to sit at this time."
				)
			)
			((Said 'stand,(get,get<up)')
				(if (not (== (gEgo view:) 361))
					(HighPrint 360 21) ; "You'll have to sit down before you get up."
				else
					(event claimed: 0)
				)
			)
			((Said 'attack,kill,attack,cast,throw')
				(KillEgo 6 {Don't DO that!})
			)
			((Said 'tell')
				(if (gCast contains: ferrari)
					(Say ferrari 360 22) ; "That is all very interesting."
				else
					(HighPrint 360 23) ; "No one pays any attention to you."
				)
			)
			((Said 'drink>')
				(cond
					((and (== drinkType 0) (Said '/water'))
						(event claimed: 0)
					)
					((== drinkType 0)
						(event claimed: 1)
						(HighPrint 360 24) ; "Great idea! You'll need a drink, though."
					)
					((Said '/water')
						(DrinkDrink 1)
					)
					((Said '/coffee')
						(DrinkDrink 2)
					)
					((Said '/sling')
						(DrinkDrink 3)
					)
					((Said '/*')
						(DrinkDrink 0)
					)
					(else
						(event claimed: 1)
						(DrinkDrink drinkType)
					)
				)
			)
			((Said 'eat,get,use,eat,eat/pill>')
				(event claimed: 0)
			)
			((Said 'get,get/lamp,grease')
				(HighPrint 360 25) ; "You don't see one you could get without being noticed."
			)
			((Said 'order,buy>')
				(cond
					((== (gEgo view:) 361)
						(event claimed: 1)
						(Say ferrari 360 26) ; "If you wish to buy a drink you must go talk to Wilmer."
					)
					((not (& (gEgo onControl: 1) $0002))
						(event claimed: 1)
						(Say bartender 360 27) ; "If you want a drink, come up to the front of the bar."
					)
					((!= drinkType 0)
						(event claimed: 1)
						(Say bartender 360 28) ; "You've already got a drink."
					)
					((or (Said '/drink') (Said '[/!*]'))
						(Say bartender 360 29) ; "What do you want?"
					)
					((or (Said 'water') (Said '/water'))
						(BuyDrink 1)
					)
					((or (Said 'coffee') (Said '/coffee'))
						(BuyDrink 2)
					)
					((or (Said 'sling,djinn') (Said '/sling,djinn'))
						(BuyDrink 3)
					)
					(else
						(event claimed: 1)
						(Say bartender 360 30) ; "I only serve the good stuff, and that ain't it."
					)
				)
			)
		)
	)
)

(instance byeScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and gNight (== gInnState 8))
						(HighPrint 360 31) ; "As you reach the front door, you suddenly realize the strain of the day's events. You are in no condition to go anywhere other than bed."
						(= cycles 1)
					)
					(
						(and
							gNight
							(not (IsFlag 98)) ; fFerrariPOed
							(!= gInnState 6)
							(gCast contains: ferrari)
						)
						(Say ferrari self 360 32) ; "In case you were not aware of the matter, my dear sir, it is against the law in Raseir to be abroad at night."
					)
					(else
						(self changeState: 3)
					)
				)
			)
			(1
				(gEgo setHeading: 0 setMotion: MoveFwd 20 self)
			)
			(2
				(self changeState: 6)
			)
			(3
				(gEgo setMotion: MoveTo 160 250 self)
			)
			(4
				(cond
					((== gInnState 6)
						(self cue:)
					)
					(gNight
						(KillEgo 2 {Persona non Grata})
					)
					((IsFlag 113) ; fSpose2Sit
						(KillEgo 1 {You took too long})
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(= gRoomExitDir 4)
				(gCurRoom newRoom: 380)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance goToSleep of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (IsFlag 99) (== gDay 27)) ; fThiefShown
					(Say ferrari self 360 33) ; "I should like to speak with you tomorrow about the use of your skills. As head of all illegal activity in Raseir, I am an influential and respected man, and I have no intention of letting an amateur jeopardize my position, if you understand my meaning. Good night, for now."
				else
					(self cue:)
				)
			)
			(1
				(if (IsFlag 166) ; f361
					(= gInnState 9)
				else
					(= gInnState 4)
				)
				(gCSound fade:)
				(gCurRoom newRoom: 361)
			)
		)
	)
)

(instance seatEgo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(waitTimer dispose:)
				(gEgo setMotion: PolyPath 230 163 self)
			)
			(1
				(gEgo setPri: 12 setMotion: MoveTo 256 171 self)
			)
			(2
				(cond
					((OneOf gInnState 1 3 6 8)
						(Say ferrari self 360 34) ; "Please do not disturb me. I need to think."
					)
					((not (IsFlag 113)) ; fSpose2Sit
						(HighPrint 360 35) ; "Ferrari ignores you."
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(if (or (OneOf gInnState 1 3 6 8) (not (IsFlag 113))) ; fSpose2Sit
					(self changeState: 8)
				else
					(gEgo setHeading: 135 self)
				)
			)
			(4
				(gEgo view: 361 setLoop: 0 setCel: 0 setCycle: End self)
				(ClearFlag 113) ; fSpose2Sit
			)
			(5
				(gEgo
					posn: (+ (gEgo x:) 8) (- (gEgo y:) 10)
					setLoop: 1
					setCel: 0
				)
				(= cycles 2)
			)
			(6
				(if (== gInnState 7)
					(self setScript: giveBird self)
				else
					(= cycles 1)
				)
			)
			(7
				(gCurRoom newRoom: 370)
			)
			(8
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 20)
						(- (gEgo y:) 10)
						self
				)
			)
			(9
				(if (not (== (gEgo view:) 361))
					(gEgo setPri: -1)
				)
				(self dispose:)
			)
		)
	)
)

(instance giveBird of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 47) ; Bird
					(gEgo setLoop: 5 cycleSpeed: 1 setCycle: CT 5 1 self)
				else
					(KillEgo 7 {You should have given him the bird})
				)
			)
			(1
				(ferrariArm
					setLoop: 5
					setCel: 0
					cycleSpeed: 1
					setCycle: CT 4 1 self
				)
				(swishTimer dispose: delete:)
				(headTimer dispose: delete:)
			)
			(2
				(gEgo
					posn: (- (gEgo x:) 8) (+ (gEgo y:) 14)
					setLoop: 0
					setCel: 4
					cycleSpeed: 0
				)
				(ferrariArm setCycle: End self)
				(SolvePuzzle 708 3 2)
				(gEgo use: 47 1) ; Bird
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance headScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< register 6)
					(= register 0)
				)
				(if register
					(ferrariHead cycleSpeed: 1 setCycle: Beg self)
				else
					(ferrariHead cycleSpeed: 1 setCycle: End self)
				)
			)
			(1
				(= cycles 4)
			)
			(2
				(if register
					(ferrariHead setCycle: CT 2 1 self)
				else
					(ferrariHead setCycle: CT 2 -1 self)
				)
			)
			(3
				(ferrariHead cycleSpeed: 0)
				(StartTimer headTimer 4 10)
				(self dispose:)
			)
		)
	)
)

(instance toJailS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 360 36) ; "You see several guards burst into the inn."
				(HighPrint 360 37 80 {Guard:}) ; "You are under arrest for breaking the law of Raseir on this day, the 29th of the Serpent, Year of the Djinn. Come quietly, or you will be taken by force."
				(= cycles 1)
			)
			(1
				(gCurRoom drawPic: 2)
				(gCast eachElementDo: #hide)
				(Print 360 38) ; "You follow the guard through the dark streets, past the gates of the palace, and into the dungeon of Raseir."
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 440)
				(self dispose:)
			)
		)
	)
)

(instance ferrari of Talker
	(properties
		x 280
		y 165
		description {Ferrari}
		lookStr {The huge man has a very jovial expression as he proceeds to swat a fly with the tail of some sort of animal.}
		view 365
		loop 4
		priority 13
		signal 16400
		illegalBits 0
		tLoop -1
		myName '//ferrari,man,senor'
		title {Signor Ferrari:}
		color 2
		msgFile 365
	)

	(method (init)
		(super init: &rest)
		(ferrariArm init:)
		(ferrariHead init:)
		(ferrariMouth init: hide:)
		(StartTimer headTimer 2)
		(StartTimer swishTimer 2)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'make,give,show/sign[<thief]')
				(if (MakeSign)
					(SolvePuzzle 709 5 2)
					(Say ferrari 360 39 360 40) ; "Ah, when I first saw you, I said to myself, there is a man who knows how to play the game. I appreciate that in a man."
					(SetFlag 99) ; fThiefShown
				else
					(Say ferrari 360 41) ; "Ha ha, heh! You seem very sure of yourself, don't you?"
				)
			)
			((Said 'look,look/whip,flyswatter,swat[<fly]')
				(HighPrint 360 42) ; "The man at the corner table uses his whip as a fly-swatter."
			)
		)
	)

	(method (talkTo event)
		(self respond: event 0 &rest)
	)

	(method (respond event)
		(cond
			((IsFlag 113) ; fSpose2Sit
				(event claimed: 1)
				(Say self 360 43) ; "I asked you to SIT DOWN! Please."
			)
			((== gInnState 1)
				(event claimed: 1)
				(HighPrint 360 44) ; "Ferrari just gestures you away with his fly-swatter. You find the bartender glaring at you."
			)
			((and (== gInnState 3) (not (IsFlag 111))) ; fUgartePaid
				(event claimed: 1)
				(Say self 360 45) ; "I do not know what Ugarte has to say, and I am most intrigued. Perhaps you should relieve our curiosity and pay the man."
			)
			((== gInnState 6)
				(event claimed: 1)
				(Say self 360 46) ; "You should hurry. There is little time."
			)
			((== gInnState 8)
				(event claimed: 1)
				(HighPrint 360 47) ; "Ferrari just stares at the black bird."
			)
			((== gInnState 9)
				(event claimed: 1)
				(HighPrint 360 48) ; "Ferrari avoids your eye and your question as he studiously swats flies."
			)
			(else
				(super respond: event &rest)
			)
		)
	)

	(method (atSpec which)
		(return [ferrariSpecList which])
	)

	(method (atGen which)
		(return [ferrariGenList which])
	)

	(method (messages)
		(ferrariHead setLoop: 2 setCycle: Fwd)
		(headTimer dispose:)
		(ferrariMouth setCycle: Fwd show:)
		(super messages: &rest)
	)

	(method (endTalk)
		(ferrariMouth hide:)
		(ferrariHead setLoop: 3 setCel: 2 setCycle: 0)
		(StartTimer headTimer 2)
		(super endTalk: &rest)
	)

	(method (onMe theObj)
		(return
			(or
				(super onMe: theObj)
				(ferrariArm onMe: theObj)
				(ferrariHead onMe: theObj)
			)
		)
	)
)

(instance ferrariArm of Prop
	(properties
		x 280
		y 165
		view 365
		priority 15
		signal 16
	)
)

(instance ferrariHead of Prop
	(properties
		x 289
		y 154
		view 365
		loop 3
		priority 14
		signal 16400
	)
)

(instance ferrariMouth of Prop
	(properties
		x 289
		y 154
		view 365
		loop 2
		priority 15
		signal 16
		cycleSpeed 1
	)
)

(instance bartender of Talker
	(properties
		x 98
		y 139
		description {the bartender}
		lookStr {The man glares back at you.__This is not the face you associate with bartenders.__It reminds you more of Bruno from Spielburg.__Definitely not a man to mess with.}
		view 363
		loop 8
		priority 12
		signal 2064
		illegalBits 0
		tLoop -1
		talkSpeed 1
		myName '//barman,barman,man'
		title {Wilmer the Bartender:}
		color 1
		msgFile 363
	)

	(method (init)
		(super init: &rest)
		(StartTimer wipeTimer 2)
		(StartTimer barMoveTimer 3 8)
	)

	(method (talkTo event)
		(event claimed: 1)
		(self respond: event &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evSAID) (IsFlag 113) (== gInnState 6)) ; fSpose2Sit
				(event claimed: 1)
				(Say self 360 49) ; "Do as Signor Ferrari orders."
			)
		)
	)

	(method (atSpec which)
		(return [wilmerSpecList which])
	)

	(method (atGen which)
		(if which
			(return 7)
		else
			(return 8)
		)
	)

	(method (messages)
		(barMoveTimer dispose:)
		(self setMotion: 0)
		(wipeTimer dispose:)
		(barMouth
			posn: (- x 4) (- y 17)
			setPri: (+ priority 1)
			setCycle: Fwd
			ignoreActors: 1
			init:
		)
		(super messages: &rest)
	)

	(method (endTalk)
		(barMouth dispose:)
		(StartTimer barMoveTimer 3 8)
		(StartTimer wipeTimer 2)
		(super endTalk: &rest)
	)
)

(instance barMouth of Prop
	(properties
		view 363
		loop 10
		cycleSpeed 1
	)
)

(instance headTimer of Timer
	(properties)

	(method (cue)
		(ferrariHead setScript: headScript 0 (Random 1 10))
	)
)

(instance swishTimer of Timer
	(properties)

	(method (cue)
		(ferrariArm setCycle: Full 1)
		(StartTimer self 2 10)
	)
)

(instance wipeTimer of Timer
	(properties)

	(method (cue)
		(bartender setCycle: CT 0 1)
		(StartTimer self 1 4)
	)
)

(instance barMoveTimer of Timer
	(properties)

	(method (cue &tmp theX theY rnd ratio)
		(= ratio (/ (+ (* (= rnd (* (- (Random 1 9) 5) 4)) 44) 5) 10))
		(= theY (- (bartender y:) rnd))
		(= theX (+ (bartender x:) ratio))
		(if (< 137 theY 141)
			(= theY 139)
			(= theX 99)
		)
		(if (and (< 0 theX 110) (not (& (gEgo onControl: 1) $0002)))
			(bartender setMotion: MoveTo theX theY)
		)
		(StartTimer self 3 8)
	)
)

(instance waitTimer of Timer
	(properties)

	(method (cue)
		(if (gEgo script:)
			(self dispose:)
		else
			(KillEgo 1 {You took too long})
		)
	)
)

(instance table1 of PicView
	(properties
		x 272
		y 189
		noun '/table'
		description {the table}
		lookStr {The table is cracked and worn.}
		view 100
		priority 13
		signal 16
	)
)

(instance table2 of PicView
	(properties
		x 185
		y 141
		noun '/table'
		description {the table}
		lookStr {The table is stained and marred.}
		view 100
		cel 1
		priority 10
		signal 16
	)
)

(instance table3 of PicView
	(properties
		x 296
		y 123
		noun '/table'
		description {the table}
		lookStr {The table is broken and wobbly.}
		view 100
		cel 2
		priority 9
		signal 16
	)
)

(instance table4 of PicView
	(properties
		x 238
		y 116
		noun '/table'
		description {the table}
		lookStr {The table is cracked and worn.}
		view 100
		cel 3
	)
)

(instance table5 of PicView
	(properties
		x 185
		y 111
		noun '/table'
		description {the table}
		lookStr {The table is stained and marred.}
		view 100
		cel 4
		priority 7
		signal 16
	)
)

(instance drunk of PicView
	(properties
		x 185
		y 146
		noun '/bum,man[<bum]'
		description {the drunk}
		lookStr {This patron looks to have enjoyed the house specialty, the Djinn Sling, to excess.}
		view 360
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly13))
	)
)

(instance customer1 of PicView
	(properties
		x 79
		y 178
		noun '/customer,man'
		description {the customer}
		lookStr {You see a customer, probably a regular.}
		view 360
		loop 3
	)
)

(instance customer2 of PicView
	(properties
		x 60
		y 189
		noun '/customer,man'
		description {the customer}
		lookStr {You see a customer enjoying his drink.}
		view 360
		loop 3
		cel 1
	)
)

(instance customer3 of PicView
	(properties
		x 39
		y 185
		noun '/customer,man'
		description {the customer}
		lookStr {You see a customer near the bar.}
		view 360
		loop 4
	)
)

(instance thieves of PicView
	(properties
		x 298
		y 105
		noun '/thief,man'
		description {the thieves}
		lookStr {These two look like they belong (and enjoy being) in dark alleys.}
		view 360
		cel 1
		priority 9
		signal 16
	)
)

(instance shelf1 of PicView
	(properties
		x 30
		y 119
		noun '/shelf'
		description {the shelf}
		lookStr {The shelf contains several types of glassware, each of which appears to be supporting several types of bacteria.}
		view 360
		loop 1
		priority 11
		signal 16
	)
)

(instance shelf2 of PicView
	(properties
		x 30
		y 92
		noun '/shelf'
		description {the shelf}
		lookStr {The shelf is dirtier than the bar only because the customers keep the bar clean with their dirty shirt sleeves.}
		view 360
		loop 1
		cel 1
		priority 11
		signal 16
	)
)

(instance parrot of PicView
	(properties
		x 121
		y 123
		noun '/bird,parrot'
		description {the parrot}
		lookStr {It is an ex-parrot.__It had one too many (that is to say one) Djinn Sling.__Actually, it's just pining for the fjords.}
		view 360
		loop 2
		signal 16384
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly12))
	)
)

(instance oilLamp of View
	(properties
		x 186
		y 100
		noun '/lamp,grease'
		description {the oil lamp}
		lookStr {It is an unlit oil lamp.}
		view 100
		loop 2
		cel 10
		priority 7
		signal 16401
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(if (& (gEgo onControl: 1) $0004)
				(HighPrint 360 50) ; "You stealthily nab the oil lamp."
				(oilLamp dispose:)
				(gEgo get: 42) ; Oil
				(SetFlag 55) ; fLampTaken
			else
				(HighPrint 360 51) ; "If you're going to steal a lamp, you'd better choose one in a less conspicuous corner of the room."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance flame1 of Flame
	(properties
		x 184
		y 130
		z 15
		noun '/flame'
		description {the flame}
		lookStr {The oil lamp is burning dimly.}
		view 100
		loop 3
	)
)

(instance curtains of Feature
	(properties
		noun '/curtain,curtain'
		description {the drapes}
		lookStr {These drapes must have been very beautiful once.}
	)

	(method (onMe theObj)
		(return
			(or
				(AvoidPath (theObj x:) (theObj y:) poly1)
				(AvoidPath (theObj x:) (theObj y:) poly2)
				(AvoidPath (theObj x:) (theObj y:) poly3)
				(AvoidPath (theObj x:) (theObj y:) poly4)
			)
		)
	)
)

(instance bar of Feature
	(properties
		noun '/bar,counter'
		description {the bar}
		lookStr {The old bar shows the stains of a thousand and one drinks.}
	)

	(method (onMe theObj)
		(return
			(and
				(AvoidPath (theObj x:) (theObj y:) poly5)
				(not (customer1 onMe: theObj))
				(not (customer2 onMe: theObj))
				(not (customer3 onMe: theObj))
			)
		)
	)
)

(instance lamps of Feature
	(properties
		noun '/lamp'
		description {the lamp}
		lookStr {It is an oil-burning lamp.}
	)

	(method (onMe theObj)
		(return
			(or
				(AvoidPath (theObj x:) (theObj y:) poly7)
				(AvoidPath (theObj x:) (theObj y:) poly8)
				(AvoidPath (theObj x:) (theObj y:) poly9)
				(AvoidPath (theObj x:) (theObj y:) poly10)
			)
		)
	)
)

(instance perch of Feature
	(properties
		x 120
		y 99
		noun '/perch'
		nsTop 79
		nsLeft 118
		nsBottom 120
		nsRight 122
		description {the perch}
		lookStr {It's primary use is to keep the parrot off the dirty floor.}
	)

	(method (onMe theObj)
		(return (AvoidPath (theObj x:) (theObj y:) poly11))
	)
)

(instance hole of Feature
	(properties
		x 119
		y 151
		noun 'chasm'
		nsTop 150
		nsLeft 117
		nsBottom 153
		nsRight 122
		description {the hole}
		lookStr {So, how do you feel about this as a hole?}
	)
)

(instance poly1 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly7 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly8 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly9 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly10 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly11 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly12 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly13 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly14 of Polygon
	(properties
		type PBarredAccess
	)
)

