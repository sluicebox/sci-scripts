;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use eRS)
(use Interface)
(use RandCycle)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	faxHere
	limoCueCount
	missedDayTrotter
	lastSec
	tvOn
	windowOpen
	tDrive = 5
	onPhone
	driving
	dreaming
	phonedDesmond
	whichFax
	lookedAtDT
	faxPaperCue
	driverCue
	armCue
	okToExit
	[dreamPts 17] = [0 1 117 120 0 2 148 98 0 3 195 115 0 4 199 124 -32768]
	dreamDone
	[unused 3]
)

(instance rm200 of LLRoom
	(properties
		lookStr {You've always wondered what it would be like to travel by limousine.}
		picture 200
	)

	(method (init &tmp num)
		(if (!= gPrevRoomNum 205)
			(gTheMusic number: 0 client: 0 stop:)
			(gTheMusic2 number: 0 client: 0 stop:)
		)
		(LoadMany rsVIEW 200 206)
		(HandsOn)
		(SetupExit 1)
		(User canControl: 0)
		(windowL init: stopUpd:)
		(switch gPrevRoomNum
			(500
				(SetFlag 9)
			)
			(600
				(= gPattiLoc 1)
			)
			(690
				(= gPattiLoc 1)
				(SetFlag 29)
			)
			(700
				(SetFlag 10)
			)
			(800
				(= gPattiLoc 2)
			)
			(890
				(= gPattiLoc 2)
				(SetFlag 28)
			)
			(900
				(SetFlag 11)
			)
		)
		(if gEgoIsLarry
			(LoadMany rsVIEW 204 201)
			(gEgo
				init:
				view: 201
				posn: 67 188 0
				setPri: 14
				setCycle: 0
				setLoop: 0
				cycleSpeed: 6
				setCel: 0
				show:
				forceUpd:
				edgeHit: 0
			)
			(faxMachine init: y: 113 z: 0)
			(if (!= gPrevRoomNum 205)
				(HandsOff)
				(Delay 2 2 gCurRoom)
			)
			(driver init: view: 204 setLoop: 2 stopUpd:)
			(driverBody init: view: 204 setCel: 1 setLoop: 0 stopUpd:)
			(driverEyes init: view: 204)
			(if (!= gPrevRoomNum 250)
				(gTheIconBar disable: 0)
			else
				(= okToExit 1)
			)
			(driversWindow init: description: {Bobbi})
			(tv init: hide:)
		else
			(LoadMany rsVIEW 203 202)
			(if (OneOf gPrevRoomNum 800 600 425)
				(gTheIconBar enable: 0)
				(= okToExit 1)
			else
				(gTheIconBar disable: 0)
			)
			(driver init: view: 203 setLoop: 2)
			(driverBody init: view: 203 setCel: 1 setLoop: 0)
			(driverEyes init: view: 203)
			(gEgo
				init:
				view: 202
				setLoop: 6
				posn: 65 88 -100
				setPri: 14
				setCel: 0
				setCycle: 0
				ignoreActors: 1
				show:
				cycleSpeed: 6
				forceUpd:
				edgeHit: 0
			)
			(legs init: setScript: sLegs)
			(if (not (IsFlag 30))
				(bottle init: stopUpd:)
			)
			(if (and (IsFlag 28) (IsFlag 29))
				(Delay 20 1 gCurRoom)
				(HandsOff)
				(= gPattiDest 3)
			)
			(driversWindow init: description: {Bobby})
			(faxMachine init:)
		)
		(phone init: stopUpd:)
		(glass init: stopUpd:)
		(theTv init:)
		(rightDoor init:)
		(stereo init:)
		(bottles_Glasses init:)
		(fishTank init:)
		(tapes init:)
		(vcr init:)
		(fish
			init:
			setCycle: Fwd
			posn: (Random 241 304) (Random 87 106)
			setScript: sFishScript
		)
		(if (and (== gLarryLoc 1) (not (IsFlag 31)) (== gPrevRoomNum 250))
			(dayTrotter init:)
		)
		(Load rsPIC 1)
		(Load rsSCRIPT 941)
		(super init:)
		(switch gPrevRoomNum
			(205
				(HandsOff)
				(= driving 1)
				(gCurRoom drawPic: 200 11 setScript: sDrive)
			)
			(890
				(gCurRoom drawPic: 200 7)
			)
			(else
				(gCurRoom drawPic: 200)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 205)
			(gTheMusic fade: 0 15 10 1)
		else
			(gTheMusic stop:)
			(= gDestination 0)
		)
		(gTheMusic2 stop:)
		(tvSnd stop: dispose:)
		(SetupExit 0)
		(gTheTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if dreaming
			(Palette palANIMATE 56 63 2)
		)
	)

	(method (cue)
		(if gEgoIsLarry
			(switch (++ limoCueCount)
				(1
					(if (OneOf gPrevRoomNum 190 250)
						(Delay 2 1 self)
					else
						(Say gEgo 200 0 108 self) ; "Geez," you think, "no matter where I go, no matter which limousine rental company I use, no matter which driver I get... all these limos look alike!"
					)
				)
				(2
					(if (not (not (OneOf gPrevRoomNum 205 250)))
						(= limoCueCount 0)
						(HandsOn)
						(User canControl: 0)
					else
						(Delay 2 1 self)
					)
				)
				(3
					(SetFlag 8)
					(gEgo stopUpd:)
					(driver doVerb: 4 7)
				)
			)
		else
			(HandsOff)
			(Say gEgo 200 1) ; ""Home, Bobby!" you signal to your driver, and he nods in ready agreement."
			(= gDestination 425)
			(gCurRoom setScript: sDream)
		)
	)

	(method (notify what)
		(= phonedDesmond 0)
		(switch what
			(2779
				(= phonedDesmond 1)
			)
			(-1
				(TPrint 200 2) ; "You change your mind and hang up the telephone."
			)
			(else
				(TPrint 200 3) ; "Hmmm. Wrong number."
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Walk
				(if (and (== ((gTheIconBar at: 0) cursor:) 6) (not driving))
					(SetupExit 0)
					(gCurRoom newRoom: gPrevRoomNum)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sFishScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (< gMeanWhiles 3)
					(fish setLoop: 1)
				else
					(fish setLoop: 3)
				)
				(if (not gEgoIsLarry)
					(self changeState: 10)
				else
					(= cycles 1)
				)
			)
			(1
				(= start state)
				(= cycles 1)
			)
			(2
				(if (< (fish x:) 262)
					(if (< gMeanWhiles 3)
						(fish setLoop: 1)
					else
						(fish setLoop: 3)
					)
					(fish
						setMotion: MoveTo (Random 270 304) (Random 87 106) self
					)
				else
					(if (< gMeanWhiles 3)
						(fish setLoop: 0)
					else
						(fish setLoop: 2)
					)
					(fish
						setMotion: MoveTo (Random 241 250) (Random 87 106) self
					)
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
			(10
				(= start state)
				(= cycles 1)
			)
			(11
				(if (< (fish x:) 262)
					(= register 1)
					(fish
						setLoop: 1
						setMotion: MoveTo (Random 270 304) (Random 87 106) self
					)
				else
					(= register 0)
					(fish
						setLoop: 0
						setMotion: MoveTo (Random 241 250) (Random 87 106) self
					)
				)
			)
			(12
				(if (not (Random 0 2))
					(if register
						(fish setLoop: 3)
					else
						(fish setLoop: 2)
					)
					(= seconds (Random 1 3))
				else
					(= seconds 1)
				)
			)
			(13
				(self init:)
			)
		)
	)
)

(instance fish of Actor
	(properties
		x 245
		y 100
		description {the fish}
		sightAngle 40
		lookStr {There's a carsick goldfish in the limousine's aquarium.}
		view 206
		detailLevel 3
	)

	(method (checkDetail param1)
		(super checkDetail: &rest)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 200 4) ; "As much as you would love to pet the little fishie, he would prefer to be left alone."
			)
			(5 ; Talk
				(TPrint 200 5) ; "Do you think talking to fish will make them grow?"
			)
			(10 ; Zipper
				(TPrint 200 6) ; "Geez, you are the little sick-o, aren't you!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance glass of Actor
	(properties
		x 156
		y 38
		description {the privacy window}
		sightAngle 40
		lookStr {A piece of soundproof glass blocks conversation between you and your driver.}
		yStep 4
		view 200
		cel 3
		priority 3
		signal 26640
		detailLevel 3
		illegalBits 0
		xStep 4
	)

	(method (cue)
		(super cue:)
		(if (not windowOpen)
			(= windowOpen 1)
		else
			(= windowOpen 0)
		)
		(self stopUpd:)
		(HandsOn)
		(User canControl: 0)
		(if (or driving (not okToExit) (not (== ((gTheIconBar at: 0) cursor:) 6)))
			(gTheIconBar disable: 0)
		)
	)
)

(instance dayTrotter of View
	(properties
		x 8
		y 187
		description {the DayTrotter\05}
		view 200
		cel 1
		priority 4
		signal 22544
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 200 7) ; "Look! Some poor unfortunate traveler forgot his appointment calendar."
				(= lookedAtDT 1)
			)
			(3 ; Do
				(HandsOff)
				(gEgo stopUpd:)
				(arm
					init:
					view: 201
					setLoop: 2
					setCel: 0
					posn: 67 164
					setCycle: CT 2 1 arm
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance legs of Prop
	(properties
		x 73
		y 181
		description {your leg}
		lookStr {You've always felt your legs were one of your better assets.}
		view 202
		loop 3
		priority 13
		signal 18448
		detailLevel 3
	)

	(method (checkDetail param1)
		(super checkDetail: &rest)
		(cond
			((not detailLevel))
			((& signal $0001)
				(|= signal $0100)
			)
			((& signal $0002)
				(&= signal $feff)
			)
		)
	)

	(method (onMe evt)
		(return
			(and
				(!= (OnControl CONTROL (evt x:) (evt y:)) 8)
				(super onMe: evt)
			)
		)
	)
)

(instance theTv of Feature
	(properties
		x 161
		y 91
		nsTop 64
		nsLeft 117
		nsBottom 118
		nsRight 205
		description {the television set}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if tvOn
					(TPrint 200 8) ; "This is a good show, but one you've seen before!"
				else
					(TPrint 200 9) ; "This show is SO boring."
					(TPrint 200 10 67 -1 185) ; "(Oh, wait. The television isn't on!)"
				)
			)
			(3 ; Do
				(if gEgoIsLarry
					(tvSnd number: 201 loop: 1 play:)
					(if tvOn
						(= tvOn 0)
						(tv hide:)
						(TPrint 200 11) ; "You turn the television set off."
					else
						(= tvOn 1)
						(tv show:)
						(TPrint 200 12) ; "You turn the television set on."
					)
				else
					(TPrint 200 13) ; "It's broken."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tv of Prop
	(properties
		x 162
		y 110
		nsTop 63
		nsLeft 116
		nsBottom 118
		nsRight 206
		description {the television set}
		sightAngle 40
		view 205
		priority 7
		detailLevel 3
	)

	(method (doit)
		(super doit:)
		(if tvOn
			(tv setCel: (Random 0 3))
		)
	)

	(method (doVerb)
		(theTv doVerb: &rest)
	)
)

(instance phone of Prop
	(properties
		x 161
		y 271
		z 100
		nsTop 162
		nsLeft 143
		nsBottom 174
		nsRight 186
		description {the telephone}
		sightAngle 40
		view 200
		loop 1
		priority 10
		signal 18448
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 200 14) ; "A cellular phone rests conveniently beside you."
			)
			(3 ; Do
				(self setScript: sPhone)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dreamProp1 of Prop
	(properties
		view 231
		priority 15
		signal 16400
	)
)

(instance dreamProp2 of Prop
	(properties
		view 231
		priority 15
		signal 16400
	)
)

(instance dreamProp3 of Prop
	(properties
		view 231
		priority 15
		signal 16400
	)
)

(instance arm of Prop
	(properties
		view 201
		priority 14
		signal 16400
	)

	(method (cue)
		(super cue:)
		(switch (++ armCue)
			(1
				(if (not missedDayTrotter)
					(Points 12)
				)
				(gEgo get: 11) ; DayTrotter
				(SetFlag 31)
				(dayTrotter dispose:)
				(Delay 2 1 self)
			)
			(2
				(self setCycle: Beg self)
			)
			(3
				(= armCue 0)
				(if (not lookedAtDT)
					(TPrint 200 7) ; "Look! Some poor unfortunate traveler forgot his appointment calendar."
				)
				(TPrint 200 15) ; "Yeah, too bad for the other guy. He'll never know. Besides, he would probably want you to have it!"
				(if (not missedDayTrotter)
					(HandsOn)
					(User canControl: 0)
					(if
						(or
							driving
							(not okToExit)
							(not (== ((gTheIconBar at: 0) cursor:) 6))
						)
						(gTheIconBar disable: 0)
						(self dispose:)
					)
				else
					(gCurRoom newRoom: gDestination)
				)
			)
		)
	)
)

(instance bottle of View
	(properties
		x 41
		y 111
		description {the champagne bottle}
		sightAngle 40
		view 200
		priority 5
		signal 2064
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 200 16) ; "A chilled bottle of champagne awaits your pleasure."
			)
			(3 ; Do
				(HandsOff)
				(SetFlag 30)
				(gCurRoom setScript: sGetBottle)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance vcr of Feature
	(properties
		x 162
		y 152
		z 100
		nsTop 45
		nsLeft 114
		nsBottom 60
		nsRight 211
		description {the video recorder}
		sightAngle 40
		lookStr {A professional quality videotape player rests above the television set.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 200 17) ; "Too bad it's broken."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tapes of Feature
	(properties
		x 245
		y 257
		z 200
		nsTop 45
		nsLeft 211
		nsBottom 70
		nsRight 279
		description {the video tapes}
		sightAngle 40
		lookStr {There are many videotapes in that rack that you would love to see. Unfortunately, the VCR is broken!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 200 18) ; "You have no way to play those tapes since the limo's videotape player is broken."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fishTank of Feature
	(properties
		x 266
		y 94
		nsTop 71
		nsLeft 217
		nsBottom 118
		nsRight 316
		description {the aquarium}
		sightAngle 40
		lookStr {How bizarre! A limousine with an aquarium!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (not (Random 0 10))
					(TPrint 200 19) ; "You would love to grab the little fishy and pet him and make him your friend and take him home and the two of you grow old together and spend his final years resting in a small bowl of briny water on your nightstand."
				else
					(TPrint 200 4) ; "As much as you would love to pet the little fishie, he would prefer to be left alone."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dreamBubble of Prop
	(properties
		view 207
		priority 15
		signal 18448
	)
)

(instance bottles_Glasses of Feature
	(properties
		name {bottles&Glasses}
		x 73
		y 178
		z 100
		nsTop 46
		nsLeft 31
		nsBottom 111
		nsRight 115
		description {the bottles and glasses}
		sightAngle 40
		onMeCheck 4
		lookStr {There are enough bottles of liquor and glasses to throw a party. All you need now is some friends!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (gCast contains: bottle)
					(bottle doVerb: 3)
				else
					(TPrint 200 20) ; "Leave the bottles and glasses alone."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stereo of Feature
	(properties
		x 165
		y 248
		z 100
		nsTop 117
		nsLeft 110
		nsBottom 178
		nsRight 222
		description {the stereo}
		sightAngle 40
		lookStr {The limousine's stereo has both a cassette tape player and a CD.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 200 21) ; "Both the CD player and the cassette deck are broken."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rightDoor of Feature
	(properties
		x 286
		y 146
		nsTop 123
		nsLeft 253
		nsBottom 170
		nsRight 319
		description {the cabinet door}
		sightAngle 40
		onMeCheck 2
		lookStr {A small, locked liquor compartment rests beneath the right front passenger's seat. You wonder when it will be your turn to live high on the hog.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 200 22) ; "The cabinet is locked!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sRoll of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(dreamProp1 setLoop: (Random 0 1) setCycle: End self)
			)
			(1
				(= cycles (Random 4 10))
			)
			(2
				(dreamProp1 setCycle: Beg self)
			)
			(3
				(= cycles (Random 4 10))
			)
			(4
				(self init:)
			)
		)
	)
)

(instance driverEyes of Prop
	(properties
		x 155
		y 6
		description {the mirror}
		view 204
		loop 1
		priority 1
		signal 26640
		detailLevel 3
	)
)

(instance sLegs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(legs setCycle: Fwd cycleSpeed: (Random 6 10))
				(= cycles (Random 20 40))
			)
			(2
				(legs setCel: 0 stopUpd:)
				(= cycles (Random 10 30))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance windowL of Prop
	(properties
		x 17
		y 46
		description {the window}
		view 208
		priority 14
		signal 26640
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 200 23) ; "If you roll down the windows, you'll spoil the air-conditioned comfort in which you ride."
			)
			(2 ; Look
				(if driving
					(TPrint 200 24) ; "It looks like you are moving."
				else
					(TPrint 200 25) ; "Bored silly, you find yourself staring out the windows!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tvSnd of Sound
	(properties)
)

(instance faxMachine of Feature
	(properties
		x 59
		y 213
		z 100
		nsTop 101
		nsLeft 31
		nsBottom 125
		nsRight 87
		description {the fax machine}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 200 26) ; "How wonderful. Your own personal fax machine."
				(TPrint 200 27 67 -1 185) ; "(Doesn't everybody travel like this?)"
			)
			(3 ; Do
				(if (and whichFax (not phonedDesmond))
					(HandsOff)
					(faxPaper doVerb: 3)
				else
					(TPrint 200 28) ; "The fax machine has no way to dial out. If you want to make a telephone call, your cellular phone rests right beside your right hand."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance driverBody of Prop
	(properties
		x 114
		y 34
		description {your limo driver}
		view 204
		priority 1
		signal 26640
		detailLevel 3
	)
)

(instance driversWindow of Feature
	(properties
		x 160
		y 119
		z 100
		nsTop -1
		nsLeft 49
		nsBottom 42
		nsRight 269
		sightAngle 40
		lookStr {You are sealed off from your driver by that big soundproof glass window.}
	)

	(method (doVerb)
		(driver doVerb: &rest)
	)
)

(instance sGetBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 202
					setLoop: 1
					setCel: 0
					cycleSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setLoop: 2 setCel: 0)
				(= cycles 1)
			)
			(2
				(gEgo cycleSpeed: 6 setCycle: CT 3 1 self)
			)
			(3
				(bottle dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo setLoop: 6 setCel: 0 posn: 65 88 get: 4) ; A_Blank_Videotape_c
				(if
					(or
						driving
						(not okToExit)
						(not (== ((gTheIconBar at: 0) cursor:) 6))
					)
					(gTheIconBar disable: 0)
				)
				(Points 6)
				(= cycles 2)
			)
			(5
				(HandsOn)
				(User canControl: 0)
				(if (not okToExit)
					(gTheIconBar disable: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDrive of Script
	(properties)

	(method (doit &tmp [str 10])
		(super doit:)
		(if (not (-- tDrive))
			(driverBody setCel: (Random 0 2))
			(= tDrive (Random 5 10))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= driving 1)
				(if gEgoIsLarry
					(HandsOn)
					(User canControl: 0)
					(gTheIconBar disable: 0)
				)
				(gTheMusic number: 204 loop: -1 play: 127)
				(if (== gPrevRoomNum 205)
					(windowL cycleSpeed: 3 setCycle: Fwd)
					(= state 29)
					(= seconds 3)
				else
					(windowL cycleSpeed: 6 setCycle: Fwd)
					(= seconds 5)
				)
			)
			(1
				(windowL cycleSpeed: 3)
				(= seconds 5)
			)
			(2
				(windowL cycleSpeed: 0)
				(if gEgoIsLarry
					(= seconds 4)
				else
					(= seconds 12)
				)
			)
			(3
				(= start state)
				(= cycles 2)
			)
			(4
				(cond
					(onPhone
						(self init:)
					)
					((and (not gEgoIsLarry) (not dreamDone))
						(self init:)
					)
					((and gEgoIsLarry (not (OneOf gPrevRoomNum 205 250)))
						(gCurRoom newRoom: 205)
					)
					(else
						(= seconds 3)
					)
				)
			)
			(5
				(windowL cycleSpeed: 3)
				(= seconds 3)
			)
			(6
				(= start state)
				(= cycles 1)
			)
			(7
				(if onPhone
					(self init:)
				else
					(HandsOff)
					(driver setCycle: End)
					(driverEyes setCycle: End)
					(= state 29)
					(= cycles 2)
				)
			)
			(30
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gTheMusic fade: 0 15 10 0)
				(if gEgoIsLarry
					(TPrint 200 29 80 {Bobbi} 108) ; "Sir, we have arrived at your destination!" says your driver. "I hope your journey was a pleasant one."
					(driver setCycle: End)
					(driverEyes setCycle: End)
					(= ticks 90)
				else
					(++ state)
					(gTheMusic2 fade: 0 15 10 1)
					(= seconds 2)
				)
			)
			(31
				(ClearFlag 1)
				(if (!= gDestination 250)
					(ClearFlag 38)
				)
				(if (and (== gDestination 900) (gEgo has: 10)) ; Some_Change
					(Say gEgo 200 30) ; "Thank you for an excellent journey, my good woman," you tell your chauffeur. "I'll leave a little something for you on the seat back here."
					(gEgo put: 10) ; Some_Change
					(= gQuarters 0)
				)
				(if (and (== gDestination 500) (not (gEgo has: 11))) ; DayTrotter
					(TPrint 200 31) ; "As you are ready to exit the limousine, you notice a small leather binder on the seat beside you. You feel certain the limo company will make no attempt to locate its rightful owner, so you take it, vowing to search relentlessly until you find its owner and return his missing DayTrotter\05 to him!"
					(= missedDayTrotter 1)
					(dayTrotter doVerb: 3 &rest)
				else
					(if (and (IsFlag 9) (gEgo has: 11)) ; DayTrotter
						(gEgo put: 11 put: 13 put: 12) ; DayTrotter, Credit_Cards, Money
						(TPrint 200 32) ; "You think, "Who wants a stupid old DayTrotter\05 anyway?" So you leave it and all the things that came with it on the seat of your limo. "Let somebody else hassle with that thing!" you think. "I've got better things to do!""
					)
					(gCurRoom newRoom: gDestination)
				)
			)
			(32
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 1 10)
				(CenterDisplay 2 gColWhite 200 33)
				(= seconds 3)
			)
			(33
				(switch gDestination
					(425 0)
					(800
						(= gPattiLoc 2)
					)
					(600
						(= gPattiLoc 1)
					)
				)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance driver of Prop
	(properties
		x 114
		y 34
		description {your limo driver}
		view 204
		priority 2
		signal 26640
		detailLevel 3
	)

	(method (cue)
		(super cue:)
		(switch (++ driverCue)
			(1
				(HandsOff)
				(driver setCycle: End)
				(driverEyes setCycle: End)
				(Delay 2 0 self)
			)
			(2
				(switch gDestination
					(250
						(TPrint 200 34 80 {Bobbi}) ; "Airport, eh?" says Bobbi. "It's a great place--if you like flying!"
						(Delay 2 1 self)
					)
					(500
						(TPrint 200 35 80 {Bobbi}) ; "Hard Disk Cafe, eh?" says Bobbi. "It's a great place--if you like computers!"
						(Delay 2 1 self)
					)
					(700
						(TPrint 200 36 80 {Bobbi}) ; "Tramp's Casino, eh?" says Bobbi. "It's a great place--if you like gambling!"
						(Delay 2 1 self)
					)
					(900
						(TPrint 200 37 80 {Bobbi}) ; "Doc Pulliam's, eh?" says Bobbi. "It's a great place--if you like pain!"
						(Delay 2 1 self)
					)
					(600
						(TPrint 200 38 80 {Bobby}) ; "The Shill Building, eh?" says Bobby. "It's a great place--if you like music!"
						(if (== gPrevRoomNum 800)
							(SetFlag 28)
						)
						(Delay 2 1 self)
					)
					(800
						(TPrint 200 39 80 {Bobby}) ; "K-RAP Radio, eh?" says Bobby. "It's a great place--if you like rap!"
						(if (== gPrevRoomNum 600)
							(SetFlag 29)
						)
						(Delay 2 1 self)
					)
				)
			)
			(3
				(driver setCycle: Beg)
				(driverEyes setCycle: Beg)
				(arm setCycle: Beg self)
			)
			(4
				(= driverCue 0)
				(gEgo startUpd:)
				(arm dispose:)
				(if gEgoIsLarry
					(gCurRoom setScript: sDrive)
				else
					(gCurRoom setScript: sDream)
				)
			)
		)
	)

	(method (doVerb theVerb invItem &tmp [str 80])
		(switch theVerb
			(2 ; Look
				(if gEgoIsLarry
					(switch gLarryLoc
						(0
							(TPrint 200 40) ; "Bobbi Bang, your limo driver, is as cute as a button."
						)
						(1
							(TPrint 200 41) ; "Bobbi Bangue, your present limo driver, is as cute as a pin."
						)
						(2
							(TPrint 200 42) ; "Bobbi Bahng, your latest limo driver, is as cute as a baby's bottom."
						)
						(3
							(TPrint 200 43) ; "Bobbi Biang, your current limo driver, is as cute as any limo driver you've ever had."
						)
					)
				else
					(TPrint 200 44) ; "Bobby Bang, your limo driver for the entire tour, is about as cute as guys come."
				)
			)
			(3 ; Do
				(cond
					(driving
						(TPrint 200 45) ; "Please leave your driver alone!"
					)
					(gEgoIsLarry
						(TPrint 200 46) ; "You tap on the glass, but there is no answer."
					)
					(else
						(HandsOff)
						(gTheMusic number: 202 loop: 1 play:)
						(if (not windowOpen)
							(glass setMotion: MoveTo (glass x:) 78 glass)
						else
							(glass setMotion: MoveTo (glass x:) 38 glass)
						)
					)
				)
			)
			(5 ; Talk
				(cond
					(driving
						(Format ; "Please leave the driver alone! %se's doing the best %se can!"
							@str
							200
							47
							(if gEgoIsLarry {Sh} else {H})
							(if gEgoIsLarry {sh} else {h})
						)
						(TPrint @str)
					)
					(gEgoIsLarry
						(switch (Random 1 2)
							(1
								(TPrint 200 48) ; "You try to get the driver's attention, but she ignores you."
							)
							(2
								(TPrint 200 49) ; "The driver points to her ear and shrugs, indicating she is unable to hear you through the soundproof glass window."
							)
						)
						(TPrint 200 50) ; "Perhaps you could show her where you want to go."
					)
					(windowOpen
						(TPrint 200 51 80 {Bobby}) ; "Hello, Miss. Thanks for lowering that window. I'm sorry, but I can't hear you anyway--I'm deaf! Just show me where you want to go."
					)
					(else
						(TPrint 200 52) ; "The intercom from the driver's compartment crackles to life, "I'm sorry, but I can't hear you through the soundproof glass!""
					)
				)
			)
			(10 ; Zipper
				(cond
					(gEgoIsLarry
						(Say gEgo 200 53) ; "Hey, Baby! How about you crawling back here and letting me drive for a change?!"
						(TPrint 200 54) ; "She ignores you completely."
						(TPrint 200 55 67 -1 185) ; "(An experience not wholly unfamiliar to you!)"
					)
					((== gPattiLoc 1)
						(TPrint 200 56 80 {Bobby}) ; "I thought I already tried that!"
					)
					((IsFlag 29)
						(TPrint 200 57 80 {Bobby}) ; "I thought I tried that when we were in Baltimore?!"
					)
					(driving
						(TPrint 200 58 80 {Bobby}) ; "Hey, baby," says Bobby Bang, "if you're serious about that, maybe I should stop the car?!"
					)
					(else
						(TPrint 200 59 80 {Bobby}) ; "Hey, baby," says Bobby Bang, "that's okay with me! Let's wait until we get to Baltimore!"
					)
				)
			)
			(4 ; Inventory
				(if gEgoIsLarry
					(if gDestination
						(TPrint 200 60 80 {Bobbi}) ; "Please!" she shouts through the intercom, "It's not safe to bother me while I'm driving!"
					else
						(switch invItem
							(7 ; AeroDork_Gold_Card
								(if (== gPrevRoomNum 250)
									(TPrint 200 61 80 {Bobbi}) ; "You're at the airport now!"
								else
									(gEgo stopUpd:)
									(arm
										init:
										view: 201
										setLoop: 1
										posn: 96 163
										setCel: 0
										cycleSpeed: 8
										setCycle: End self
									)
									(= gDestination 250)
								)
							)
							(6 ; Hard_Disk_Cafe_Napkin
								(cond
									((!= gLarryLoc 1)
										(TPrint 200 62 80 {Bobbi}) ; "Waddayou, crazy?" shouts Bobbi, "I ain't gonna haul you all the way to New York City!"
									)
									((not (OneOf gPrevRoomNum 205 250))
										(TPrint 200 63 80 {Bobbi}) ; "Waddayou, crazy?" shouts Bobbi, "you're already there!"
									)
									((IsFlag 9)
										(TPrint 200 64 80 {Bobbi}) ; "You have no need to return to New York City."
									)
									(else
										(gEgo stopUpd:)
										(arm
											init:
											view: 201
											setLoop: 1
											posn: 96 163
											setCel: 0
											setCycle: End self
										)
										(= gDestination 500)
									)
								)
							)
							(16 ; Tramp_Casino_Matchbook
								(cond
									((!= gLarryLoc 2)
										(TPrint 200 65 80 {Bobbi}) ; "Waddayou, crazy?" shouts Bobbi, "I ain't gonna haul you all the way to Atlantic City!"
									)
									((not (OneOf gPrevRoomNum 205 250))
										(TPrint 200 63 80 {Bobbi}) ; "Waddayou, crazy?" shouts Bobbi, "you're already there!"
									)
									((IsFlag 10)
										(TPrint 200 66) ; "You have no need to return to Atlantic City."
									)
									(else
										(gEgo stopUpd:)
										(arm
											init:
											view: 201
											setLoop: 1
											posn: 96 163
											setCel: 0
											setCycle: End self
										)
										(= gDestination 700)
									)
								)
							)
							(20 ; Doc_Pulliam_s_Card
								(cond
									((!= gLarryLoc 3)
										(TPrint 200 67 80 {Bobbi}) ; "Waddayou, crazy?" shouts Bobbi, "I ain't gonna haul you all the way to Miami."
									)
									((not (OneOf gPrevRoomNum 205 250))
										(TPrint 200 63 80 {Bobbi}) ; "Waddayou, crazy?" shouts Bobbi, "you're already there!"
									)
									((IsFlag 11)
										(TPrint 200 68) ; "You have no need to return to Miami."
									)
									(else
										(gEgo stopUpd:)
										(arm
											init:
											view: 201
											setLoop: 1
											posn: 96 163
											setCel: 0
											setCycle: End self
										)
										(= gDestination 900)
									)
								)
							)
							(else
								(super doVerb: theVerb invItem &rest)
							)
						)
					)
				else
					(switch invItem
						(3 ; A_Blank_Videotape_b
							(cond
								((== gPattiLoc 1)
									(TPrint 200 69 80 {Bobby}) ; "Oh, come on, lady!" says Bobby, "that's where you are now!"
								)
								((IsFlag 29)
									(TPrint 200 70 80 {Bobby}) ; "Oh, come on, lady!" says Bobby, "I'm not taking you back there!"
								)
								(gDestination
									(TPrint 200 71 80 {Bobby}) ; "I'm sorry, lady," says Bobby, "But I can only handle one destination at a time!"
								)
								(else
									(Points 8 95)
									(arm
										view: 202
										init:
										setLoop: 4
										setCel: 0
										posn: 98 182
										setCycle: End self
									)
									(+= gPattiDest 1)
									(= gDestination 600)
									(= phonedDesmond 0)
									(faxPaper setScript: 0)
								)
							)
						)
						(7 ; AeroDork_Gold_Card
							(cond
								((== gPattiLoc 2)
									(TPrint 200 69 80 {Bobby}) ; "Oh, come on, lady!" says Bobby, "that's where you are now!"
								)
								((IsFlag 28)
									(TPrint 200 70 80 {Bobby}) ; "Oh, come on, lady!" says Bobby, "I'm not taking you back there!"
								)
								(gDestination
									(TPrint 200 71 80 {Bobby}) ; "I'm sorry, lady," says Bobby, "But I can only handle one destination at a time!"
								)
								(else
									(Points 8 95)
									(arm
										view: 202
										init:
										setLoop: 4
										setCel: 0
										posn: 98 182
										setCycle: End self
									)
									(+= gPattiDest 2)
									(= gDestination 800)
									(= phonedDesmond 0)
									(faxPaper setScript: 0)
								)
							)
						)
						(0 ; Camcorder
							(switch ((Inv at: 0) state:) ; Camcorder
								(0
									(TPrint 200 72) ; "Your driver stares blankly at the totally blank DataMan."
								)
								(1
									(cond
										((== gPattiLoc 1)
											(TPrint 200 69 80 {Bobby}) ; "Oh, come on, lady!" says Bobby, "that's where you are now!"
										)
										((IsFlag 29)
											(TPrint 200 70 80 {Bobby}) ; "Oh, come on, lady!" says Bobby, "I'm not taking you back there!"
										)
										(gDestination
											(TPrint 200 71 80 {Bobby}) ; "I'm sorry, lady," says Bobby, "But I can only handle one destination at a time!"
										)
										(else
											(Points 8 95)
											(arm
												view: 202
												init:
												setLoop: 5
												setCel: 0
												posn: 96 184
												setCycle: End self
											)
											(+= gPattiDest 1)
											(= gDestination 600)
											(= phonedDesmond 0)
											(faxPaper setScript: 0)
										)
									)
								)
								(2
									(cond
										((== gPattiLoc 2)
											(TPrint 200 69 80 {Bobby}) ; "Oh, come on, lady!" says Bobby, "that's where you are now!"
										)
										((IsFlag 28)
											(TPrint 200 70 80 {Bobby}) ; "Oh, come on, lady!" says Bobby, "I'm not taking you back there!"
										)
										(gDestination
											(TPrint 200 71 80 {Bobby}) ; "I'm sorry, lady," says Bobby, "But I can only handle one destination at a time!"
										)
										(else
											(Points 8 95)
											(arm
												view: 202
												init:
												setLoop: 5
												setCel: 0
												posn: 96 184
												setCycle: End self
											)
											(+= gPattiDest 2)
											(= gDestination 800)
											(= phonedDesmond 0)
											(faxPaper setScript: 0)
										)
									)
								)
							)
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sDream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(driver setScript: sDrive)
				(legs setScript: 0 setCel: 0)
				(= seconds 8)
			)
			(1
				(= dreaming 1)
				(gTheMusic fade: 0 15 5 0)
				(gTheMusic2 stop:)
				(= seconds 2)
			)
			(2
				(gTheMusic2 number: 320 loop: -1 play: 0 fade: 127 15 10 0)
				(TPrint 200 73 67 -1 185 108) ; "As you drift off to sleep, you begin to dream."
				(tv dispose:)
				(fish setScript: 0 stopUpd:)
				(dreamBubble init: setLoop: 0 setCel: 1 posn: 117 120)
				(= ticks 90)
			)
			(3
				(dreamBubble setCel: 2 posn: 148 98)
				(= ticks 90)
			)
			(4
				(dreamBubble setCel: 3 posn: 195 115)
				(= ticks 90)
			)
			(5
				(dreamBubble setCel: 4 posn: 199 124)
				(= ticks 90)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(dreamBubble dispose:)
				(fish hide:)
				(bottle hide:)
				(tv hide:)
				(switch (++ gPattiDream)
					(1
						(gCurRoom overlay: 230)
						(dreamProp1
							init:
							view: 231
							setLoop: 0
							posn: 205 90
							setScript: sRoll
						)
					)
					(2
						(gCurRoom overlay: 235)
						(dreamProp1
							init:
							view: 235
							posn: 123 69
							cycleSpeed: 6
							setCycle: RandCycle
						)
						(dreamProp2
							init:
							view: 236
							posn: 231 87
							cycleSpeed: 8
							setCycle: RandCycle
						)
					)
					(3
						(gCurRoom overlay: 240)
						(gTheMusic2 number: 241 play:)
						(dreamProp1
							init:
							view: 240
							setLoop: 0
							setCel: 0
							cycleSpeed: 8
							setCycle: Fwd
							posn: 258 93
							setPri: 13
						)
						(dreamProp2
							init:
							view: 241
							setLoop: 0
							posn: 260 106
							setPri: 12
							cycleSpeed: 10
							setCycle: RandCycle
						)
						(dreamProp3
							init:
							view: 241
							setLoop: 1
							setCel: 0
							cycleSpeed: 5
							setCycle: End
							posn: 203 31
							setPri: 14
						)
					)
				)
				(= seconds 3)
			)
			(7
				(switch gPattiDream
					(1
						(Say gEgo 200 74) ; ""Oh, Donald!" you moan in your dream."
						(TPrint 200 75 80 {Donald}) ; ""The Donald," he corrects you."
						(Say gEgo 200 76) ; "MY Donald," you correct him! "I so love this little boat you bought me..."
						(TPrint 200 77 80 {The Donald}) ; "...I'm going to name it `The Tramp Pianist!'"
					)
					(2
						(Say gEgo 200 78) ; "Oh, Willi," you moan in your dream. "Put down that keyboard and practice a little touch typing on me!"
						(TPrint 200 79 80 {Willie}) ; "Not now, Patti!" he replies, "I'm about to finish cutting a deal with IBM!"
					)
					(3
						(Say gEgo 200 80) ; "Oh, OH, OOOOOHHHHHH!" you shout in your dream! "I just love it when you do that!"
						(TPrint 200 81 80 {Sir Francis}) ; ""I just hope my three nephews don't come in about now!" he replies."
					)
				)
				(= dreamDone 1)
			)
		)
	)
)

(instance sPhone of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 36)
				(gEgo startUpd:)
				(= cycles 2)
			)
			(1
				(= onPhone 1)
				(if gEgoIsLarry
					(gEgo
						setLoop: 0
						setCel: 0
						cycleSpeed: 8
						setCycle: CT 5 1 self
					)
					(= register 5)
				else
					(gEgo stopUpd:)
					(arm
						init:
						view: 202
						posn: 65 188
						setLoop: 0
						cycleSpeed: 8
						setCycle: CT 3 1 self
					)
					(legs setScript: 0 setCel: 0 stopUpd:)
				)
			)
			(2
				(phone hide:)
				(gTheMusic2 number: 36 loop: 1 play:)
				(if gEgoIsLarry
					(gEgo setCycle: End self)
				else
					(arm setCycle: End self)
				)
			)
			(3
				(cond
					(gEgoIsLarry
						(TPrint 200 82 80 {Bobbi}) ; "I'm sorry, Sir," crackles the driver's voice through the intercom, "but my cellular telephone won't work in this area. Too much interference or something."
						(TPrint 200 83 80 {Bobbi}) ; "Besides, I'm sure you were not given authorization for cellular calls."
						(Say gEgo 200 84) ; "DAMN! And all your life you've wanted to try a cell phone!"
						(++ state)
						(= cycles 2)
					)
					((and (IsFlag 103) (IsFlag 104))
						(User canInput: 1)
						((ScriptID 20 0) init: 1 self) ; TTDialer
					)
					(phonedDesmond
						(TPrint 200 85) ; "Hang up! You have an incoming fax! Don't tie up the line."
						(++ state)
						(= cycles 2)
					)
					((not whichFax)
						(User canInput: 1)
						((ScriptID 20 0) init: 1 self) ; TTDialer
					)
					(else
						(TPrint 200 86) ; "You don't need to use the phone right now. But perhaps later."
						(++ state)
						(= cycles 2)
					)
				)
			)
			(4
				(HandsOff)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(if phonedDesmond
					(TPrint 200 87) ; "You dial Inspector Desmond's office telephone. Soon a familiar voice answers."
					(TPrint 200 88 80 {Desmond}) ; "Hello, this is Desmond."
					(cond
						((and (IsFlag 103) (IsFlag 104))
							(Say gEgo 200 89) ; "Hi ya, Boss!" you say cheerfully. "I just wanted to tell you, I've found the information I need on Reverse Biaz and P. C. Hammer and I'm on my way."
							(TPrint 200 90 80 {Desmond}) ; "Good job, Patti!" exclaims Desmond, "I knew you wouldn't let us down!"
							(Say gEgo 200 91) ; "Thanks, Inspector!" you say cheerfully. "I hope I'll be talking to you soon!"
						)
						((and (not (IsFlag 103)) (not (IsFlag 104)))
							(Say gEgo 200 92) ; "Hi ya, Boss!" you say cheerfully. "I was wondering if I might get some information from you."
							(TPrint 200 93 80 {Desmond}) ; "Sure, Patti!" replies Desmond. "What is it you're looking for?"
							(= whichFax
								(switch
									(Print ; "Inspector, please fax me some information about..."
										200
										94
										#button
										{ReverseBiaz}
										1
										#button
										{PCHammer}
										2
										#title
										{You}
									)
								)
							)
						)
						((IsFlag 103)
							(Say gEgo 200 95) ; "Inspector," you ask, "could you please fax me some information about P. C. Hammer?"
							(TPrint 200 96 80 {Desmond}) ; "Sure, Patti!" replies Desmond. "I'll get someone right on it. Bye."
							(= whichFax 2)
						)
						((IsFlag 104)
							(Say gEgo 200 97) ; "Inspector," you ask, "could you please fax me some information about Reverse Biaz?"
							(TPrint 200 96 80 {Desmond}) ; "Sure, Patti!" replies Desmond. "I'll get someone right on it. Bye."
							(= whichFax 1)
						)
					)
					(if whichFax
						(faxPaper init: hide: setScript: sFax)
					)
				)
				(= ticks 50)
			)
			(5
				(if gEgoIsLarry
					(gEgo setCycle: CT 5 -1 self)
				else
					(arm setCycle: CT 3 -1 self)
				)
			)
			(6
				(phone show:)
				(gTheMusic2 number: 36 loop: 1 play:)
				(if gEgoIsLarry
					(gEgo setCycle: Beg self)
				else
					(arm setCycle: Beg self)
				)
			)
			(7
				(if (not gEgoIsLarry)
					(legs startUpd: setScript: sLegs)
					(arm dispose:)
				)
				(= onPhone 0)
				(= ticks 10)
			)
			(8
				(if (and whichFax (not faxHere))
					(HandsOff)
				else
					(HandsOn)
					(User canControl: 0)
					(if
						(or
							driving
							(not okToExit)
							(not (== ((gTheIconBar at: 0) cursor:) 6))
						)
						(gTheIconBar disable: 0)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sFax of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 203)
				(= seconds 3)
			)
			(1
				(gTheMusic number: 203 loop: 1 play:)
				(TPrint 200 98) ; "The fax machine awakens..."
				(= ticks 90)
			)
			(2
				(faxPaper
					show:
					ignoreActors: 1
					moveSpeed: 5
					posn: 55 225
					setMotion: MoveTo 55 215 self
				)
			)
			(3
				(= phonedDesmond 0)
				(HandsOn)
				(User canControl: 0)
				(if
					(or
						driving
						(not okToExit)
						(not (== ((gTheIconBar at: 0) cursor:) 6))
					)
					(gTheIconBar disable: 0)
				)
				(= faxHere 1)
				(self dispose:)
			)
		)
	)
)

(instance faxPaper of Actor
	(properties
		x 55
		y 225
		z 100
		description {the fax}
		yStep 1
		view 200
		cel 2
		priority 6
		signal 22544
		detailLevel 3
		xStep 1
	)

	(method (cue)
		(super cue:)
		(switch (++ faxPaperCue)
			(1
				(HandsOff)
				(self hide:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo setLoop: 6)
				(Delay 2 1 self)
			)
			(3
				(switch whichFax
					(1
						(Points 13 103)
						(TPrint 200 99) ; "You grab the fax from the machine. The header says "Reverse Biaz.""
						(gEgo get: 3) ; A_Blank_Videotape_b
					)
					(2
						(Points 13 104)
						(TPrint 200 100) ; "You grab the fax from the machine. The header says "P. C. Hammer.""
						(gEgo get: 7) ; AeroDork_Gold_Card
					)
				)
				(= faxPaperCue 0)
				(= whichFax 0)
				(= faxHere 0)
				(HandsOn)
				(User canControl: 0)
				(if
					(or
						driving
						(not okToExit)
						(not (== ((gTheIconBar at: 0) cursor:) 6))
					)
					(gTheIconBar disable: 0)
				)
				(self dispose:)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gEgo view: 202 setLoop: 1 setCel: 0 setCycle: CT 6 1 self)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

