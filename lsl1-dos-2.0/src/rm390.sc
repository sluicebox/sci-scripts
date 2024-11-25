;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use RandCycle)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	pouredWine
	doneForeplay
	knifeTimer
	radioTimer
	fawnDollars
	[DIVEPTS 33] = [3 0 45 92 3 1 45 92 3 2 50 85 3 3 53 83 3 4 59 74 3 5 70 79 3 6 76 81 3 7 98 99 -32768]
)

(instance rm390 of LLRoom
	(properties
		picture 390
	)

	(method (init &tmp foo)
		(= foo 991)
		(if gDebugging
			(SetFlag 12) ; fFawnInRoom
			(gEgo get: 11) ; pocketKnife
		)
		(if (> gDebugging 1)
			(SetFlag 24) ; fOrderedWine
		)
		(if (> gDebugging 2)
			(= pouredWine 1)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 235 96 85 96 85 100 157 117 157 128 137 138 57 156 38 177 70 182 210 182 210 171 221 162 254 154 240 136 214 114 241 114 248 95 248 0 319 0 319 189 0 189 0 0 235 0
					yourself:
				)
		)
		(LoadMany rsVIEW 390 391 392 808)
		(LoadMany rsSOUND 390 395 140 801 802)
		(gTheMusic loop: -1 vol: 127 flags: 1)
		(gTheMusic2 number: 395 loop: 1 vol: 127 flags: 1)
		(gTheMusic3 setLoop: 1 flags: 1)
		(gEgo
			x: 241
			y: 88
			init:
			illegalBits: 0
			setHeading: 180
			actions: egoActions
		)
		(gEHead actions: egoActions)
		(HandsOff)
		(gCurRoom setScript: sEnter)
		(super init:)
		(door init: cycleSpeed: global101 approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(fawn
			init:
			cycleSpeed: global101
			moveSpeed: global101
			approachVerbs: 2 3 4 10 11 5 ; Look, Do, Inventory, Zipper, Taste/Smell, Talk
		)
		(ribbon init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(if (IsFlag 41) ; fTurnedOnRadio
			(gTheMusic number: 390 play: 127)
			(if (not (IsFlag 24)) ; fOrderedWine
				(= radioTimer
					(Random (* (+ 1 global101) 200) (* (+ 1 global101) 300))
				)
			)
		)
		(if (IsFlag 24) ; fOrderedWine
			(Load rsVIEW 393 803)
			(LoadMany rsSOUND 171 393 394 396 167 111)
			(wine init: approachVerbs: 2 3 4 10 11) ; Look, Do, Inventory, Zipper, Taste/Smell
		)
		(theBed init:)
		(theWindow init:)
		(theRadio init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(painting init:)
		(iceBucket init: approachVerbs: 2 3 4 10 11) ; Look, Do, Inventory, Zipper, Taste/Smell
		(theChair init:)
		(painting2 init:)
		(sculpture init:)
		(flower init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			(knifeTimer
				(if (== (-- knifeTimer) 1)
					(Print 390 0) ; "Since you have no way of cutting the ribbon and it's far too tightly tied for you to loosen, it looks like this is the end for you, Larry."
					(Death 391 7)
					(Format @gYourPart 390 1) ; "...he's currently tied up"
					(GameOver 390 2)
				)
			)
			(radioTimer
				(if (> radioTimer 1)
					(-- radioTimer)
				)
				(if (and (== radioTimer 1) (not (gCurRoom script:)))
					(= radioTimer
						(Random (* (+ global101 1) 600) (* (+ global101 2) 600))
					)
					(HandsOff)
					(gCurRoom setScript: sDoCommercial)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 12) ; fFawnInRoom
					(Print 390 3) ; "You are in the casino hotel's honeymoon suite. The heart-shaped bed is just waiting for you and Fawn. There is a radio by the bed. This place is perfect for your wedding night!"
					(Print 390 4) ; "The dim lighting sets the perfect atmosphere. What a lovely room!"
					(Print 390 5 #at -1 140) ; "(You've always been a fan of the "Early American Gaudy" school of decorating.)"
				else
					(Print 390 6) ; "This is the honeymoon suite. The heart-shaped bed seemed perfect for you and Fawn. Too bad things worked out like this!"
				)
			)
			(5 ; Talk
				(if (== (gEgo view:) 391)
					(Print 390 7) ; "FAWN!! You scum-sucking gutterslug, get back in here!"
					(Print 390 8) ; "Unfortunately, your touching plea goes unheeded."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(if (== (gEgo view:) 391)
					(Print 390 9) ; "You can't. You're tied to a bed!"
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
)

(class egoActions of Code
	(properties)

	(method (doVerb theVerb invItem)
		(if (not (== (gEgo view:) 391))
			(switch theVerb
				(10 ; Zipper
					(cond
						((not (IsFlag 24)) ; fOrderedWine
							(Print 390 10) ; "Hey, don't rush it, buster! Can't a gal even have a drink first?" she "wines." "Geez, what a romantic!"
						)
						((not pouredWine)
							(Print 390 11) ; ""Aren't you going to pour the wine?" she says, her eyes flashing."
						)
						((not doneForeplay)
							(Print 390 12) ; "Ain'cha never heard of `foreplay,' Larry?" says Fawn. "I ain' no rabbit, you know!"
						)
						((and (== (gEgo x:) 153) (== (gEgo y:) 132))
							(HandsOff)
							(gCurRoom setScript: sGetHim)
						)
					)
				)
			)
			(return)
		else
			(switch theVerb
				(3 ; Do
					(Print 390 13) ; "You can't. She fastened you quite securely!"
				)
				(5 ; Talk
					(Print 390 7) ; "FAWN!! You scum-sucking gutterslug, get back in here!"
					(Print 390 8) ; "Unfortunately, your touching plea goes unheeded."
				)
				(4 ; Inventory
					(switch invItem
						(11 ; pocketKnife
							(HandsOff)
							(gCurRoom setScript: sCutLoose)
						)
						(else
							(Print 390 9) ; "You can't. You're tied to a bed!"
						)
					)
				)
				(else
					(Print 390 9) ; "You can't. You're tied to a bed!"
				)
			)
			(return)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(door setCycle: End self)
				(gTheMusic3 number: 801 play:)
			)
			(2
				(gEgo setMotion: PolyPath 238 103 self)
			)
			(3
				(door setCycle: Beg)
				(gTheMusic3 number: 802 play:)
				(gEgo illegalBits: $8000 setMotion: PolyPath 211 106 self)
			)
			(4
				(= cycles 10)
			)
			(5
				(if (and (IsFlag 24) (not (IsFlag 36))) ; fOrderedWine, fSeenDeliveryBoyGag
					(SetFlag 36) ; fSeenDeliveryBoyGag
					(Print 390 14 #at -1 20) ; "Oh, Larry, it's you!" Fawn says. "I thought it was that cute, young delivery boy again."
					(Print 390 15) ; "Hmm. What does she mean by that? Oh, well. You decide to let it pass. After all, this IS your wedding night!"
				else
					(Print 390 16 #at -1 20) ; "Oh, Larry!" oozes Fawn, "I've been waiting patiently right here on the bed just for you."
				)
				(fawn setScript: sFawn)
				(door stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetHim of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (gTheMusic prevSignal:) -1) state (IsFlag 41)) ; fTurnedOnRadio
			(gTheMusic number: 390 loop: -1 vol: 127 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= radioTimer 0)
				(Print 390 17) ; "She says, "Lie down, Larry. I have a special little surprise for you!""
				(gEgo egoSpeed: setMotion: PolyPath 89 100 self)
				(fawn
					setScript: 0
					cycleSpeed: gLarrySpeed
					moveSpeed: gLarrySpeed
					setLoop: 0
					setCel: 3
					setCycle: Beg fawn
				)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(Print 390 18 #at -1 19 #width 280) ; "Then she says, "Close your eyes," and you do because you're sure that, finally, success is at hand."
				(gTheMusic pause: 0 number: 396 loop: 1 play:)
				(fawn hide: setMotion: 0)
				(gEgo
					egoSpeed:
					view: 391
					setLoop: 6
					setCel: 0
					x: 72
					y: 116
					setPri: 9
				)
				(= seconds 4)
			)
			(3
				(Print 390 19 #at -1 20) ; ""Oh, Fawn!" you moan."
				(= seconds 4)
			)
			(4
				(Print 390 20 #at -1 20) ; "Ooh, Baby! That feels so good! Ooooooooooh!!"
				(= seconds 4)
			)
			(5
				(Print 390 21 #at -1 20) ; "Say, Fawn, when are you going to get undressed?"
				(= seconds 4)
			)
			(6
				(Print 390 22 #at -1 20) ; "Hey, what are you doing with the ribbon?"
				(= seconds 4)
			)
			(7
				(Print 390 23 #at -1 20) ; "Oh, I see! We're gonna get kinky our first time?"
				(= seconds 2)
			)
			(8
				(gTheMusic3 number: 171 loop: -1 play:)
				(gEgo egoSpeed: 0 setLoop: 0 setCel: 0 setCycle: RandCycle)
				(= seconds 6)
			)
			(9
				(gTheMusic3 stop:)
				(if (not (IsFlag 41)) ; fTurnedOnRadio
					(gTheMusic fade:)
				)
				(if (> gLarryDollars 10)
					(= fawnDollars (- gLarryDollars 10))
					(= gLarryDollars 10)
				else
					(= fawnDollars (- gLarryDollars 1))
					(= gLarryDollars 1)
				)
				(gEgo egoSpeed: x: 45 y: 92 setLoop: 1 setCel: 0 setCycle: 0)
				(fawn show: view: 612 setCycle: Walk setLoop: -1)
				(= seconds 3)
			)
			(10
				(Print 390 24) ; "When Fawn has you securely tied to the bed, she leaps from the bed, grabs your wallet, and says, "You forgot to pay me for the wine!""
				(Printf 390 25 fawnDollars) ; "It came to $%d.00, including the tip."
				(= cycles (* (+ 1 global101) 5))
			)
			(11
				(fawn setMotion: PolyPath 230 96 self)
			)
			(12
				(Print 390 26) ; "Wait, Fawn!" you shout, "Come back! This is our wedding night!"
				(door setCycle: End self)
				(gTheMusic3 number: 801 setLoop: 1 play:)
			)
			(13
				(Print 390 27) ; "So long, sucker!"
				(= seconds 3)
			)
			(14
				(Print 390 28) ; "FAWN! Come back!" you shout. "This isn't funny!!"
				(fawn setMotion: PolyPath 241 88 self)
			)
			(15
				(ClearFlag 12) ; fFawnInRoom
				(gTheMusic3 number: 802 play:)
				(door setCycle: Beg self)
			)
			(16
				(= seconds 2)
			)
			(17
				(fawn dispose:)
				(Print 390 29) ; "Hmmm. Does it count if a guy "consummates" by himself?"
				(= seconds 2)
			)
			(18
				(Print 390 30) ; "Larry, it seems "the honeymoon's over.""
				(if (not (gEgo has: 11)) ; pocketKnife
					(= knifeTimer (* (+ 1 global101) 300))
				)
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sCutLoose of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (gTheMusic prevSignal:) -1) (IsFlag 41)) ; fTurnedOnRadio
			(gTheMusic number: 390 loop: -1 vol: 127 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 390 31) ; "Right! Using the pocket knife you got from the old bum by the convenience store, you saw through the ribbon holding you to the bed."
				(gEgo egoSpeed: (+ gLarrySpeed 1) setCycle: End self)
			)
			(1
				(gEgo setLoop: 2 setCel: 0)
				(gTheMusic3 number: 393 loop: 1 play:)
				(theObject
					init:
					cycleSpeed: gLarrySpeed
					moveSpeed: gLarrySpeed
					view: 391
					loop: 5
					x: 79
					y: 90
					setStep: 15 15
					setPri: 14
					setCycle: Fwd
					setMotion: MoveTo 74 44 self
				)
			)
			(2
				(theObject setMotion: MoveTo 69 90 self)
			)
			(3
				(theObject setLoop: 4 x: 73 y: 92)
				(= seconds 3)
			)
			(4
				(gTheMusic3 number: 394 loop: 1 play:)
				(theObject dispose:)
				(gEgo setCycle: CT 2 1 self)
			)
			(5
				(ribbon setCel: 1 stopUpd:)
				(gEgo setCycle: End self)
			)
			(6
				(Points 53 10)
				(= seconds 3)
			)
			(7
				(gEgo setLoop: 3 setCel: 0 setCycle: MCyc @DIVEPTS self)
			)
			(8
				(gEgo
					setPri: -1
					view: 803
					setLoop: 1
					setCel: 255
					setCycle: Beg self
				)
			)
			(9
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(10
				(NormalEgo 0)
				(= seconds 3)
			)
			(11
				(Printf 390 32 gLarryDollars (if (== gLarryDollars 1) {} else {s})) ; "You grab your wallet and look inside. Oh, well. At least she didn't find the %d buck%s you hid in that secret compartment. With your consummate gambling skills, you should be back on your feet in no time!"
				(ribbon approachX: 89)
				(ribbon approachY: 100)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(door setCycle: End self)
				(gTheMusic3 number: 801 play:)
			)
			(1
				(gEgo illegalBits: 0 setMotion: PolyPath 241 88 self)
			)
			(2
				(gTheMusic3 number: 802 play:)
				(door setCycle: Beg self)
			)
			(3
				(gTheMusic fade:)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sGetRibbon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: view: 808 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(Print 390 33) ; "Good idea. You never know when a nice piece of ribbon will come in handy."
				(gEgo get: 16) ; ribbon
				(ribbon dispose:)
				(Points 76 3)
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDoRadio of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Points 94 1)
				(gEgo egoSpeed: view: 808 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(if register
					(gTheMusic3 number: 140 loop: 1 play:)
					(if (== (gTheMusic number:) 390)
						(gTheMusic pause: 0)
					else
						(gTheMusic number: 390 play:)
					)
					(Print 390 34) ; "Sounds like a nice mellow station..."
					(Print 390 35) ; "The tuning knob on the radio is stuck. Looks like you're stuck with the Easy Listening station."
					(if (not (IsFlag 24)) ; fOrderedWine
						(= radioTimer
							(Random
								(* (+ 1 global101) 200)
								(* (+ 1 global101) 300)
							)
						)
					)
				else
					(gTheMusic pause: 1)
					(= radioTimer 0)
					(gTheMusic3 number: 140 loop: 1 play:)
					(Print 390 36) ; "Click."
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFawn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fawn setCycle: End self)
				(= seconds (Random 3 5))
			)
			(1
				(fawn setCel: 0 setLoop: (Random 1 2) setCycle: End)
				(= seconds (Random 5 10))
			)
			(2
				(= start 1)
				(self init:)
			)
		)
	)
)

(instance sPourWine of Script
	(properties)

	(method (changeState newState &tmp foo)
		(switch (= state newState)
			(0
				(= pouredWine 1)
				(gEgo
					egoSpeed:
					normal: 0
					view: 393
					setLoop: 0
					setCel: 0
					setCycle: CT 1 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(wine dispose:)
			)
			(2
				(gEgo
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath 153 132 self
				)
			)
			(3
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(5
				(Print 390 37 #at -1 19 #width 280) ; "You carefully remove the bottle from the ice bucket, unscrew the cap, and pour two glasses. She downs her glass immediately, you refill it, and she does it again. Her eyes meet yours, and you're sure luck is with you this time!"
				(gEgo setLoop: 5 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(gEgo setLoop: 6 setCel: 0 setCycle: End self)
			)
			(7
				(gEgo setLoop: 9 setCel: 0 setCycle: End self)
			)
			(8
				(= cycles 20)
			)
			(9
				(fawn setScript: 0 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(10
				(gEgo setLoop: 10 setCel: 0 setCycle: End self)
			)
			(11
				(gTheMusic3 number: 111 loop: -1 play:)
				(gEgo setLoop: 11 setCycle: Fwd)
				(fawn setCycle: CT 5 -1)
				(= seconds 3)
			)
			(12
				(gTheMusic3 stop:)
				(gEgo setLoop: 12 setCel: 0 setCycle: End self)
			)
			(13
				(= cycles 10)
			)
			(14
				(= foo 991)
				(gEgo setLoop: 13 setCel: 0 setCycle: End self)
				(fawn setCycle: Beg)
			)
			(15
				(theObject
					init:
					cycleSpeed: gLarrySpeed
					moveSpeed: gLarrySpeed
					view: 393
					loop: 14
					cel: 1
					x: 191
					y: 96
					yStep: 5
					setPri: 7
					setCycle: Fwd
					setMotion: JumpTo 228 96 self
				)
				(gEgo setLoop: 2)
			)
			(16
				(gTheMusic3 number: 167 loop: 1 play:)
				(gEgo setCycle: Walk setMotion: PolyPath 54 160 self)
			)
			(17
				(gEgo setLoop: 0 setCel: 5 setCycle: CT 1 -1 self)
			)
			(18
				(wine init:)
				(gEgo setCycle: Beg self)
			)
			(19
				(theObject dispose:)
				(NormalEgo 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDoCommercial of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 1) (== (gTheMusic2 prevSignal:) -1))
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic vol: 0 pause: 1 changeState:)
				(Print 390 38 #at -1 20 #dispose) ; "The radio interrupts the lovely Frank Sinatra medley with an obnoxious singing commercial..."
				(= seconds 6)
			)
			(1
				(gTheMusic2 play:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 390 39 #at -1 20 #dispose) ; "We're Ajax Liquor, And we're proud to say, We deliver 'cross The U.S.A. You're out of luck If you want to dine, But if you just need booze, Dial 555-8039!"
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gTheMusic pause: 0 fade: 127 10 5 0)
				(Print 390 40 #at -1 20 #dispose) ; "And now, back to our music."
				(= seconds 4)
				(Points 80 1)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 257
		y 19
		description {the door}
		sightAngle 40
		approachX 230
		approachY 96
		view 390
		loop 2
		priority 6
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(if (== (gEgo view:) 391)
			(Print 390 9) ; "You can't. You're tied to a bed!"
		else
			(switch theVerb
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: sExit)
				)
				(else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance ribbon of View
	(properties
		x 64
		y 102
		description {the ribbon}
		sightAngle 40
		approachX 116
		approachY 143
		view 390
		priority 8
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((== cel 1)
						(Print 390 41) ; "The remains of the ribbon are lying on the bed."
					)
					((== (gEgo view:) 391)
						(Print 390 42) ; "Isn't it amazing how a simple ribbon can hold you so securely?"
					)
					(else
						(Print 390 43) ; "Isn't that cute? The honeymoon suite bed is decorated like a giant box of candy--complete with a cute red ribbon."
					)
				)
			)
			(3 ; Do
				(cond
					((== (gEgo view:) 391)
						(Print 390 44) ; "You can't do anything. Fawn has you fastened quite securely!"
					)
					((self cel:)
						(HandsOff)
						(gCurRoom setScript: sGetRibbon)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(11 ; pocketKnife
						(if (== (gEgo view:) 391)
							(HandsOff)
							(gCurRoom setScript: sCutLoose)
						else
							(super doVerb: theVerb invItem)
						)
					)
					(else
						(if (== (gEgo view:) 391)
							(Print 390 9) ; "You can't. You're tied to a bed!"
						else
							(super doVerb: theVerb invItem)
						)
					)
				)
			)
			(5 ; Talk
				(if (== (gEgo view:) 391)
					(Print 390 7) ; "FAWN!! You scum-sucking gutterslug, get back in here!"
					(Print 390 45) ; "Unfortunately, your pleas go unheeded."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(11 ; Taste/Smell
				(Print 390 46) ; "The ribbon smells Fawny."
			)
			(else
				(if (== (gEgo view:) 391)
					(Print 390 9) ; "You can't. You're tied to a bed!"
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance wine of View
	(properties
		x 31
		y 160
		z 31
		description {the wine}
		sightAngle 40
		approachX 54
		approachY 160
		view 390
		loop 1
		priority 12
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(if (== (gEgo view:) 391)
			(Print 390 9) ; "You can't. You're tied to a bed!"
		else
			(switch theVerb
				(2 ; Look
					(Print 390 47) ; "Hmmm. Was "Tuesday" a good year?"
				)
				(3 ; Do
					(if (not (IsFlag 12)) ; fFawnInRoom
						(Print 390 48) ; "You grab the bottle that once held the suggestion of a happy marriage but now holds nothing more than the bitter dregs of your "honeymoon-gone-bad." You unscrew the top and fortify your courage with a long, hard belt! You screw the lid down tight and quickly replace the bottle in the wine bucket."
					else
						(HandsOff)
						(gCurRoom setScript: sPourWine)
					)
				)
				(4 ; Inventory
					(switch invItem
						(14 ; hammer
							(Print 390 49) ; "You can't. It's the same brand that people can't break when they want to christen a ship!"
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
				(else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance fawn of Person
	(properties
		x 137
		y 132
		description {Fawn}
		sightAngle 40
		approachX 153
		approachY 132
		view 392
		signal 16384
		illegalBits 0
	)

	(method (cue)
		(super cue:)
		(self setLoop: -1 view: 612 setCycle: Walk setMotion: PolyPath 104 100)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					(pouredWine
						(Print 390 50) ; "She looks ready, Larry."
					)
					((IsFlag 24) ; fOrderedWine
						(Print 390 51) ; "She looks like she could use some of that wine."
					)
					(else
						(Print 390 52) ; "She is so beautiful you want to do wonderful things to, er, ah, FOR her."
					)
				)
			)
			(5 ; Talk
				(cond
					((not (IsFlag 24)) ; fOrderedWine
						(if (Random 0 1)
							(Print 390 53) ; "You know, a little wine would help me get in the mood, Larry."
						else
							(Print 390 54) ; "I'd think the least a gentleman would do is to buy a lady a bottle of wine."
						)
					)
					((not pouredWine)
						(Print 390 11) ; ""Aren't you going to pour the wine?" she says, her eyes flashing."
					)
					(else
						(Print 390 55) ; "I'm ready when you are, honey!"
						(Print 390 56 #at -1 140) ; "(Come on, Larry; what are you waiting for?)"
					)
				)
			)
			(3 ; Do
				(cond
					((not (IsFlag 24)) ; fOrderedWine
						(Print 390 57) ; "She doesn't appear to be in the mood yet, Larry."
					)
					((not pouredWine)
						(Print 390 11) ; ""Aren't you going to pour the wine?" she says, her eyes flashing."
					)
					(else
						(Print 390 58) ; ""Ahh, that feels nice!" sighs Fawn."
						(Print 390 59 #at -1 140) ; "(You presume a little foreplay never hurts.)"
						(= doneForeplay 1)
					)
				)
			)
			(10 ; Zipper
				(cond
					((not (IsFlag 24)) ; fOrderedWine
						(Print 390 10) ; "Hey, don't rush it, buster! Can't a gal even have a drink first?" she "wines." "Geez, what a romantic!"
					)
					((not pouredWine)
						(Print 390 11) ; ""Aren't you going to pour the wine?" she says, her eyes flashing."
					)
					((not doneForeplay)
						(Print 390 60) ; "Ain'cha never heard of `foreplay,' Larry?" "I ain' no rabbit, you know!"
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sGetHim)
					)
				)
			)
			(11 ; Taste/Smell
				(Print 390 61) ; "Fawn smells like a dream."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance theObject of Actor
	(properties
		view 391
		signal 18448
		illegalBits 0
		xStep 1
	)
)

(instance theRadio of Feature
	(properties
		x 65
		y 98
		z 27
		nsTop 62
		nsLeft 53
		nsBottom 81
		nsRight 78
		description {the radio}
		sightAngle 40
		approachX 85
		approachY 96
		lookStr {It's pretty complicated. There's a knob that says "Power."}
	)

	(method (doVerb theVerb invItem)
		(if (== (gEgo view:) 391)
			(Print 390 9) ; "You can't. You're tied to a bed!"
		else
			(switch theVerb
				(3 ; Do
					(HandsOff)
					(if (IsFlag 41) ; fTurnedOnRadio
						(ClearFlag 41) ; fTurnedOnRadio
						(gCurRoom setScript: sDoRadio 0 0)
					else
						(SetFlag 41) ; fTurnedOnRadio
						(gCurRoom setScript: sDoRadio 0 1)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance theBed of Feature
	(properties
		x 62
		y 100
		nsTop 92
		nsLeft 11
		nsBottom 139
		nsRight 113
		description {the bed}
		sightAngle 40
		lookStr {You love the thought of a heart-shaped bed!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 390 62) ; "You have more important things on your mind than sitting."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		x 15
		y 112
		z 59
		nsTop 15
		nsBottom 92
		nsRight 30
		description {the window}
		sightAngle 40
		lookStr {Out the window the lights of Lost Wages spread before you like some cheap trick.}
	)

	(method (doVerb theVerb invItem)
		(if (== (gEgo view:) 391)
			(Print 390 9) ; "You can't. You're tied to a bed!"
		else
			(switch theVerb
				(3 ; Do
					(Print 390 63) ; "This window doesn't open."
				)
				(4 ; Inventory
					(Print 390 64) ; "You are unable to break the window."
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance painting of Feature
	(properties
		x 145
		y 93
		z 49
		nsTop 18
		nsLeft 105
		nsBottom 71
		nsRight 185
		description {the painting}
		sightAngle 40
		lookStr {To you, it looks like dozens of spermatozoa attacking a Whitman's sampler!}
	)
)

(instance iceBucket of Feature
	(properties
		x 30
		y 166
		z 37
		nsTop 120
		nsLeft 24
		nsBottom 139
		nsRight 37
		description {the ice bucket}
		sightAngle 40
		approachX 54
		approachY 160
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: wine)
					(Print 390 65) ; "The ice bucket holds your fancy bottle of wine."
				else
					(Print 390 66) ; "An ice bucket waits beside the bed for that bottle of wine you didn't bring!"
				)
			)
			(3 ; Do
				(if (gCast contains: wine)
					(wine doVerb: theVerb invItem)
				else
					(Print 390 67) ; "You can't. Room service glued it to the table."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance vase of Feature ; UNUSED
	(properties
		x 123
		y 164
		nsTop 140
		nsLeft 113
		nsBottom 189
		nsRight 134
		description {the vase}
		sightAngle 40
		lookStr {How sweet. Fawn has placed the rose you gave her in that vase. What a romantic she is!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 390 68) ; "Oh, just leave the rose in its vase."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theChair of Feature
	(properties
		x 259
		y 163
		nsTop 138
		nsLeft 232
		nsBottom 189
		nsRight 286
		description {chair}
		sightAngle 40
		lookStr {You can just picture Fawn using that chair in the morning.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 390 69) ; "You're in the Honeymoon Suite and you all you want to do is sit on a chair?!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance painting2 of Feature
	(properties
		x 288
		y 120
		z 60
		nsTop 20
		nsLeft 258
		nsBottom 101
		nsRight 319
		description {the painting}
		sightAngle 40
		lookStr {How clever! A painting of the opposite side of the room. Many hotels would just install a mirror.}
	)
)

(instance sculpture of Feature
	(properties
		x 258
		y 180
		nsTop 43
		nsLeft 197
		nsBottom 189
		nsRight 319
		description {the sculpture}
		sightAngle 40
		onMeCheck 4096
		lookStr {Wait a minute! What are those sculptures doing?!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance flower of Feature
	(properties
		x 263
		y 135
		z 49
		nsTop 75
		nsLeft 256
		nsBottom 97
		nsRight 271
		description {the rose}
		sightAngle 40
		approachX 235
		approachY 132
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 12) ; fFawnInRoom
					(Print 390 70) ; "Why, Fawn," you say, "you placed my rose in a different vase."
					(Print 390 71) ; "But, of course, my dear," she replies, "but let's not talk about flora at a time like this!"
				else
					(Print 390 72) ; "You hope at least the rose pricked Fawn."
				)
			)
			(3 ; Do
				(if (IsFlag 12) ; fFawnInRoom
					(Print 390 73) ; "You only gave it to her a little while ago. Don't take it now."
				else
					(Print 390 74) ; "Why take it? You don't want to remember Fawn (that scum-sucking gutterslug!)."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

