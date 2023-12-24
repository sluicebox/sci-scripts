;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PAvoider)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
)

(local
	[aAppleManPolyPts 8]
	lookedOnce
	appleManTimer
	paidWith
	doorState
)

(instance rm300 of LLRoom
	(properties
		lookStr {You are outside the lovely Lost Wages Casino and Hotel. You hear the sounds of money changing hands within. A tasteful modern sculpture decorates a fountain.}
		picture 300
		north 310
		east 400
		west 170
	)

	(method (newRoom)
		(LoadMany 0 927)
		(super newRoom: &rest)
	)

	(method (init)
		(LoadMany rsSOUND 300 301)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 128 128 115 135 100 137 105 142 117 142 117 147 35 147 11 143 9 136 38 130 35 119 0 124 0 0 319 0 319 141 282 141 282 132 301 132 301 128 210 128 196 108 179 108 164 128
					yourself:
				)
		)
		(aDoorLeft init: stopUpd: approachVerbs: 3 10 11) ; Do, Zipper, Taste/Smell
		(aDoorRight init: stopUpd: approachVerbs: 3 10 11) ; Do, Zipper, Taste/Smell
		(switch gPrevRoomNum
			(400
				(self style: 11)
				(gEgo y: 143)
			)
			(310
				(gEgo setPri: 6 posn: 185 120)
			)
			(170
				(gEgo y: 154)
			)
			(200 0)
			(else
				(gEgo posn: 160 150)
			)
		)
		(gEgo init:)
		(tit init: cycleSpeed: gHowFast setCycle: Fwd)
		(knee init: cycleSpeed: gHowFast setCycle: Fwd)
		(hip init: cycleSpeed: gHowFast setCycle: Fwd)
		(fountain init: cycleSpeed: gHowFast setCycle: Fwd)
		(fPlant init:)
		(fSign init:)
		(fLights init:)
		(statue init:)
		(super init:)
		(if (ObjInRoom 3)
			(if (IsFlag 100) ; fApplemanTgl
				(= appleManTimer (Random 100 300))
				(LoadMany rsVIEW 302 808)
				(Load rsSOUND 302)
				(aAppleMan cycleSpeed: gHowFast moveSpeed: gHowFast init:)
				(appleHead cycleSpeed: gHowFast init:)
			)
			(ToggleFlag 100)
		)
		(self setRegions: 700) ; sidewalk
		(fountainSFX play:)
		(if (== gPrevRoomNum 310)
			(self setScript: sFromCasino)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (<= (gEgo x:) 50) (<= (gEgo y:) 130))
				(gCurRoom newRoom: 170)
			)
			((== script sFromCasino))
			((== script sToCasino))
			(
				(and
					(gEgo inRect: 143 123 230 135)
					(or (== doorState 0) (== doorState 3))
				)
				(if (aDoorLeft script:)
					((aDoorLeft script:) dispose:)
				)
				(aDoorLeft setScript: sAutoDoorOpen)
			)
			((< (gEgo y:) 124)
				(gCurRoom setScript: sToCasino)
			)
			(
				(and
					(not (gEgo inRect: 143 123 230 135))
					(or (== doorState 1) (== doorState 2))
				)
				(if (aDoorLeft script:)
					((aDoorLeft script:) dispose:)
				)
				(aDoorLeft setScript: sAutoDoorClose)
			)
			(script)
			(
				(and
					appleManTimer
					(> (gEgo x:) 50)
					(or (== 1 (-- appleManTimer)) (> (gEgo x:) 260))
				)
				(= appleManTimer 0)
				(aAppleMan setScript: sAppleMan)
			)
		)
	)
)

(instance sToCasino of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 6 setMotion: MoveTo 185 121 self)
				(if (aDoorLeft script:)
					((aDoorLeft script:) dispose:)
				)
				(aDoorLeft setScript: sAutoDoorClose)
			)
			(1 0)
			(2
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance sFromCasino of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 6 posn: 185 120)
				(if (aDoorLeft script:)
					((aDoorLeft script:) dispose:)
				)
				(aDoorLeft setScript: sAutoDoorOpen)
			)
			(1
				(gEgo setPri: -1 setMotion: MoveTo 185 136 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sAutoDoorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorSFX play:)
				(aDoorLeft setMotion: MoveTo 101 124 self)
				(aDoorRight setMotion: MoveTo 275 124 self)
				(= doorState 1)
			)
			(1 0)
			(2
				(doorSFX stop:)
				(aDoorLeft stopUpd:)
				(aDoorRight stopUpd:)
				(= doorState 2)
				(if (== (gCurRoom script:) sFromCasino)
					(sFromCasino cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sAutoDoorClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorSFX play:)
				(aDoorLeft setMotion: MoveTo 141 124 self)
				(aDoorRight setMotion: MoveTo 235 124 self)
				(= doorState 3)
			)
			(1 0)
			(2
				(doorSFX stop:)
				(aDoorLeft stopUpd:)
				(aDoorRight stopUpd:)
				(= doorState 0)
				(if (== (gCurRoom script:) sToCasino)
					(sToCasino cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sAppleMan of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 5) (gEgo mover:))
			(= seconds 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic number: 302 setLoop: 1 flags: 1 play:)
				(aAppleMan setCycle: Walk setMotion: PolyPath 49 151 self)
			)
			(1
				(appleHead setCycle: ForwardCounter 3 self)
				(aAppleMan setLoop: 6 setCel: 0 setCycle: End)
			)
			(2
				(Print 300 0 #at -1 20) ; "Apples. Apples! APPLES for sale!!"
				(aAppleMan
					setLoop: -1
					setCycle: Walk
					setMotion: PChase gEgo 45 self
				)
			)
			(3
				(= cycles 3)
			)
			(4
				(aAppleMan setLoop: 7 setCel: 0 setCycle: End)
				(appleHead setCycle: ForwardCounter 4 self)
			)
			(5
				(Printf 300 1 10 10) ; "Hello, sir," says the skinny young man in the barrel. "Would you help out a poor unfortunate by purchasing an apple? The price is reasonable: only $%d.00."
				(= seconds 7)
			)
			(6
				(appleHead setCycle: ForwardCounter 2 self)
				(aAppleMan setCycle: Beg)
			)
			(7
				(if (gEgo mover:)
					(Print 300 2) ; "Hey, come back!" says the man. "Are you sure you don't want to buy an apple?"
				else
					(Print 300 3) ; "I presume that means `No,'" he says pleasantly. "Very well then, perhaps some other time."
				)
				(= seconds 2)
			)
			(8
				(aAppleMan
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath -30 155 self
				)
			)
			(9
				(aAppleMan dispose:)
				(appleHead dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sBuyApple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(aAppleMan setLoop: 6 setCel: 0 setMotion: 0)
				(= cycles 1)
			)
			(1
				(= cycles 1)
			)
			(2
				2
				(gEgo
					setCycle: Walk
					setAvoider: PAvoider
					setMotion:
						PolyPath
						(+ (aAppleMan x:) 29)
						(aAppleMan y:)
						self
				)
			)
			(3
				3
				(Face gEgo aAppleMan)
				(appleHead setCycle: ForwardCounter 2)
				(aAppleMan setCycle: End self)
			)
			(4
				4
				(cond
					((== paidWith 4)
						(Print 300 4) ; "Wow! Thanks a lot, Mister!" shouts the poor misfortunate, "I'll gladly trade you an apple for a diamond ring!"
						(Print 300 5) ; "But don't you think you might have needed this later?"
						(gEgo put: 4 0) ; ring
					)
					((== ((gInventory at: 3) owner:) gEgo) ; apple
						(Printf 300 6 10 10) ; "You know," says the man, peering deep into his barrel, "I'm all out! But thank you for your continued support. And for the $%d.00!"
						(= state 7)
					)
					(else
						(Printf 300 7 10 10) ; "Thank you, sir," says the skinny young man in the barrel. "For helping out a poor unfortunate by purchasing an apple at a reasonable $%d.00."
						(Points 51 3)
					)
				)
				(= cycles 1)
			)
			(5
				(gEgo
					view: 808
					setLoop: (if (< (gEgo x:) (aAppleMan x:)) 0 else 1)
					setAvoider: 0
					setCel: 0
				)
				(aAppleMan setLoop: 7 setCycle: End self)
			)
			(6
				6
				(gEgo setCel: 1 setCycle: End)
				(aAppleMan setLoop: 8 setCel: 0 setCycle: End self)
			)
			(7
				7
				(gEgo setCycle: Beg self)
			)
			(8
				8
				(cond
					((== paidWith 4)
						(Print 300 8) ; "If you have any other jewelry you'd like to swap, be sure to let me know!"
						(gEgo get: 3) ; apple
					)
					((>= gLarryDollars 10)
						(-= gLarryDollars 10)
						(Print 300 9) ; ""Please call again, whenever you are in the neighborhood," says the man. And with that, he walks away into the night."
						(gEgo get: 3) ; apple
					)
					(else
						(Print 300 10) ; "You know, I'm a little short of funds myself," you say to the man in the barrel. "Perhaps next time, ok?"
						(Print 300 11) ; "He says nothing, but walks away dejectedly into the Lost Wages night."
					)
				)
				(= cycles 30)
			)
			(9
				9
				(if (not (gCurRoom script:))
					(HandsOn)
					(NormalEgo)
				)
				(aAppleMan
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath -30 155 self
				)
			)
			(10
				11
				(self dispose:)
			)
		)
	)
)

(instance sLookInBarrel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(aAppleMan setMotion: 0 setLoop: 6 setCel: 0)
				(gEgo setMotion: PChase aAppleMan 25 self)
			)
			(1
				(Face gEgo aAppleMan)
				(= cycles 5)
			)
			(2
				(if (not register)
					(Print 300 12) ; "Peering down inside the poor man's barrel you say, "Wow! You really did lose everything!""
					(if (not (gCurRoom script:))
						(HandsOn)
					)
					(= state 3)
					(= cycles 1)
				else
					(appleHead setCycle: ForwardCounter 2 self)
					(aAppleMan setLoop: 10 setCel: 0)
				)
			)
			(3
				(Print 300 13) ; "Oh no, you don't!" exclaims the man. "Keep your hands out of my barrel!"
				(= cycles 10)
			)
			(4
				(if (not (gCurRoom script:))
					(NormalEgo 1)
					(HandsOn)
				)
				(aAppleMan
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath -30 155 self
				)
			)
			(5
				(aAppleMan dispose:)
				(self dispose:)
			)
		)
	)
)

(instance fountainSFX of Sound
	(properties
		number 301
		loop -1
	)
)

(instance doorSFX of Sound
	(properties
		number 300
	)
)

(instance aAppleMan of Person
	(properties
		x -15
		y 150
		description {the apple salesman}
		view 302
		priority 13
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(if (!= (aAppleMan script:) sBuyApple)
							(aAppleMan setScript: sBuyApple)
							(= paidWith 0)
						else
							(Print 300 14) ; "Why don't you catch him next time around, Larry?"
						)
					)
					(4 ; ring
						(if (!= (aAppleMan script:) sBuyApple)
							(aAppleMan setScript: sBuyApple)
							(= paidWith 4)
						else
							(Print 300 14) ; "Why don't you catch him next time around, Larry?"
						)
					)
					(1 ; breathSpray
						(Print 300 15) ; "No, thanks," he says, "I'm broke, not odiferous!"
					)
					(3 ; apple
						(Print 300 16) ; "I don't want that thing back!"
					)
					(5 ; whiskey
						(Print 300 17) ; "No, thanks, I don't drink!"
					)
					(7 ; rose
						(Print 300 18) ; "Sweet, but I'm busted! What do I need with a rose?"
					)
					(8 ; lubber
						(Print 300 19) ; "I'm selling apples, not cucumbers!"
					)
					(10 ; discoPass
						(Print 300 20) ; "I can't afford to buy a drink in THAT place!"
					)
					(11 ; pocketKnife
						(Print 300 21) ; "What do you think? I want to slash my wrists?"
						(Print 300 22) ; "No, thanks, Mister. I deal in cash only."
					)
					(12 ; wine
						(Print 300 23) ; "No, thanks, I don't drink!"
					)
					(14 ; hammer
						(Print 300 24) ; "You take a swing at the apple salesman, but miss."
						(Print 300 25 #at -1 140) ; "(You never were any good at hack-and-slash games!)"
					)
					(else
						(Print 300 26) ; "Sorry," replies the apple salesman to your generous offer, "but I'm broke, not stupid!"
					)
				)
			)
			(2 ; Look
				(if lookedOnce
					(aAppleMan setScript: sLookInBarrel 0 0)
				else
					(Print 300 27) ; "He's yet another poor soul who donated his everything so the shrine of Lost Wages could continue to flourish."
					(= lookedOnce 1)
				)
			)
			(5 ; Talk
				(Print 300 28) ; "Hey, Buddy," you joke. "How's your Pippin?"
				(Print 300 29) ; "He mutters under his breath, "(10,000 comedians out of work in this town...)""
			)
			(3 ; Do
				(aAppleMan setScript: sLookInBarrel 0 1)
			)
			(10 ; Zipper
				(Print 300 30) ; "Sorry, buddy, but this is MY night in the barrel!"
			)
			(11 ; Taste/Smell
				(Print 300 31) ; "He smells of decomposed apple cores and fresh pork rind."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance aDoorLeft of Actor
	(properties
		x 141
		y 124
		description {an automatic, motion-sensing door}
		approachX 189
		approachY 133
		view 300
		loop 4
		priority 7
		signal 2064
	)

	(method (doVerb theVerb invItem)
		(aDoorRight doVerb: theVerb invItem)
	)
)

(instance aDoorRight of Actor
	(properties
		x 235
		y 124
		description {an automatic, motion-sensing door}
		approachX 189
		approachY 133
		view 300
		loop 4
		cel 1
		priority 7
		signal 2064
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 300 32) ; "Isn't it funny how every time you reach out to touch these doors, they open?"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance aAppleManPoly of Polygon ; UNUSED
	(properties
		type PBarredAccess
	)
)

(instance appleHead of Prop
	(properties
		description {the apple salesman}
		view 302
		loop 4
	)

	(method (doit)
		(super doit:)
		(if (OneOf (aAppleMan loop:) 6 7 9 8 10)
			(appleHead x: (+ (aAppleMan x:) 2) y: (aAppleMan y:) z: 35)
		else
			(appleHead z: 1000)
		)
	)

	(method (doVerb theVerb invItem)
		(aAppleMan doVerb: theVerb invItem)
	)
)

(instance tit of Prop
	(properties
		x 310
		y 34
		description {the sculpture}
		sightAngle 40
		view 300
		loop 1
		priority 15
		signal 16400
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(statue doVerb: theVerb invItem)
	)
)

(instance hip of Prop
	(properties
		x 294
		y 90
		description {the sculpture}
		sightAngle 40
		view 300
		loop 3
		priority 15
		signal 16400
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(statue doVerb: theVerb invItem)
	)
)

(instance knee of Prop
	(properties
		x 276
		y 129
		description {the sculpture}
		sightAngle 40
		view 300
		loop 2
		priority 15
		signal 16400
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(statue doVerb: theVerb invItem)
	)
)

(instance fountain of Prop
	(properties
		x 291
		y 165
		description {the fountain}
		lookStr {That water sure looks cold.}
		view 300
		priority 15
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 300 33) ; "That water sure is deep."
			)
			(10 ; Zipper
				(Print 300 34) ; "Use the restroom at Lefty's instead."
			)
			(11 ; Taste/Smell
				(Print 300 35) ; "The water tastes rather metallic and a little acidic."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fPlant of Feature
	(properties
		x 64
		y 116
		nsTop 90
		nsLeft 23
		nsBottom 143
		nsRight 105
		description {the plant}
		sightAngle 40
		lookStr {Which is more lifelike, the plant or the pot?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 300 36) ; "The plant feels like someone spit apple juice on it earlier!"
			)
			(5 ; Talk
				(Print 300 37) ; "Do you think talking to artificial plants will make them grow?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fSign of Feature
	(properties
		x 151
		y 17
		z 100
		nsTop 1
		nsLeft 42
		nsBottom 33
		nsRight 260
		description {the sign}
		sightAngle 40
		lookStr {The sign above the door says "CASINO," in large, uneven letters.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 300 38) ; "You can't reach that sign from down here!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fLights of Feature
	(properties
		x 143
		y 146
		z 100
		nsTop 34
		nsLeft 28
		nsBottom 58
		nsRight 259
		description {the lights over the door}
		sightAngle 40
		lookStr {These are only a few of the millions of lights that surround this casino, you just can't see the others!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 300 39) ; "You can't reach the lights."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance statue of Feature
	(properties
		x 249
		y 94
		nsLeft 179
		nsBottom 188
		nsRight 319
		description {the sculpture}
		sightAngle 40
		onMeCheck 4096
		lookStr {From the David Niven, Myrna Loy School of Design.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 300 40) ; "You and the sculpture have absolutely no common interests."
			)
			(3 ; Do
				(Print 300 41) ; "It feels like metal."
			)
			(10 ; Zipper
				(Print 300 42) ; "Jeez, Larry; take a cold shower or something!"
			)
			(11 ; Taste/Smell
				(Print 300 43) ; "It tastes rather metallic."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

