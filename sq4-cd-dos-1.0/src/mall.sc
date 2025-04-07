;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use RegionPath)
(use Inertia)
(use Sq4Narrator)
(use Sq4Feature)
(use Print)
(use PolyPath)
(use StopWalk)
(use Motion)
(use Game)
(use System)

(public
	mall 0
	enS 1
	exS 2
	TestMallFlag 3
	eSwimCode 4
	proc700_5 5
	sp1 6
	sp2 7
	shopper3 9
	newSpeedCode 10
)

(local
	[local0 43] = [32767 400 324 90 -5 90 32767 370 78 231 324 87 32767 375 78 233 324 87 32767 380 -5 142 324 127 32767 385 -5 142 324 158 32767 390 -5 89 239 233 32767 395 -5 88 230 238 -32768]
	[local43 43] = [32767 400 -5 145 324 145 32767 395 324 179 -5 3 32767 390 324 173 -5 0 32767 385 324 116 -5 100 32767 380 324 87 -5 101 32767 375 324 -3 -5 169 32767 370 324 -3 -5 169 -32768]
	[local86 8] = [3 6 0 4 2 5 1 7]
)

(procedure (TestMallFlag param1 param2 param3)
	(if (& (param1 param2:) param3)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc700_5 param1)
	(if param1
		(= gUseObstacles 1)
		(gEgo illegalBits: 0)
		(if (IsObject (gEgo mover:))
			(gEgo
				setMotion: PolyPath ((gEgo mover:) x:) ((gEgo mover:) y:)
			)
		)
	else
		(= gUseObstacles 0)
		(gEgo illegalBits: $8000)
	)
)

(procedure (localproc_0 param1)
	(if
		(and
			(gEgo mover:)
			(not (param1 z:))
			(& (param1 signal:) $0400)
			(< (gEgo distanceTo: param1) 35)
		)
		(gEgo setMotion: 0)
	)
)

(instance newSpeedCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(if argc
			(= gGameSpeed param1)
			(for
				((= temp0 (FirstNode (gCast elements:))))
				temp0
				((= temp0 temp2))
				
				(= temp2 (NextNode temp0))
				(if
					(or
						(not (IsObject (= temp1 (NodeValue temp0))))
						(not (temp1 respondsTo: #setSpeed))
					)
				else
					(temp1 setSpeed: param1 &rest)
				)
			)
		)
		(return gGameSpeed)
	)
)

(class mall of Rgn
	(properties
		enterBelt 0
		whichBelt 0
		rFlag1 0
		rFlag2 0
		rFlag3 0
		rFlag4 0
	)

	(method (offScreen)
		(return
			(or
				(< (gEgo nsRight:) 0)
				(> (gEgo nsLeft:) 319)
				(< (gEgo nsBottom:) 0)
				(> ((gEgo _head:) nsTop:) 189)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (IsFlag 24)
			(++ global110)
			(if (and (IsFlag 25) (> global110 2))
				(ClearFlag 25)
			)
		)
		(= keep
			(OneOf
				newRoomNumber
				370
				371
				375
				376
				380
				381
				385
				386
				387
				390
				391
				395
				396
				397
				398
				399
				400
				405
				406
				410
				411
				290 ; astro
			)
		)
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(Load rsVIEW 370)
		(Load rsVIEW 7)
		(newSpeedCode doit: gGameSpeed)
		(if (and (IsFlag 22) (not (IsFlag 30)))
			(if (!= gCurRoomNum 390)
				(SetFlag 30)
				(shopperPath2
					x: 239
					y: 233
					dx: 3
					dy: 1
					b-moveCnt: 0
					b-i1: 258
					b-i2: -78
					b-di: 138
					b-xAxis: 1
					b-incr: 1
					completed: 0
					xLast: 92
					yLast: 146
					currentRoom: 390
					value: 35
					intermediate: 0
				)
				(shopperPath3
					x: -5
					y: 0
					dx: -2
					dy: -1
					b-moveCnt: 0
					b-i1: 34
					b-i2: -624
					b-di: -523
					b-xAxis: 1
					b-incr: -1
					completed: 0
					xLast: 262
					yLast: 140
					currentRoom: 390
					value: 17
					intermediate: 0
				)
				(shopper2
					x: 95
					y: 148
					z: 1000
					heading: 120
					xLast: 95
					yLast: 148
				)
				(shopper3
					x: 260
					y: 139
					z: 1000
					heading: 298
					xLast: 260
					yLast: 139
				)
			else
				(shopper2 z: 20000)
				(shopper3 z: 20000)
			)
		)
		(if (!= gCurRoomNum 387)
			(shopper2
				view: (if (IsFlag 30) 7 else 384)
				setCycle: Walk
				setStep: 4 2
				setSpeed: gGameSpeed
				init:
				setMotion: shopperPath2
			)
			(shopper3
				view: (if (IsFlag 30) 7 else 388)
				setCycle: Walk
				setStep: 5 2
				setSpeed: gGameSpeed
				init:
				setMotion: shopperPath3
			)
		)
		(if (and (!= gPrevRoomNum 396) (not (OneOf gCurRoomNum 405 406 410 411)))
			(= temp0
				(switch (gEgo view:)
					(0 4)
					(402 14)
					(373 374)
				)
			)
			(gEgo setCycle: StopWalk temp0)
		)
		(if (OneOf gCurRoomNum 370 375 380 385 390 395 400)
			(belts init:)
			(restOfMall init:)
			(gEgo setScript: nearScript)
		)
	)
)

(instance enS of Script
	(properties)

	(method (init)
		(gEgo illegalBits: 0)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(or
				(not (gEgo onControl:))
				(<= (gEgo x:) 0)
				(>= (gEgo x:) 319)
				(<= (gEgo y:) (gCurRoom horizon:))
				(>= (gEgo y:) 189)
			)
			0
		else
			(gEgo illegalBits: $8000)
			(self dispose:)
			(HandsOn)
		)
		(register who: gEgo doit:)
	)
)

(instance exS of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(gEgo setMotion: 0)
		(if (mall offScreen:)
			(gCurRoom newRoom: register)
		else
			((mall enterBelt:) who: gEgo doit:)
		)
	)
)

(instance moveNear of Motion
	(properties)

	(method (doit &tmp temp0)
		(if (self onTarget:)
			(self moveDone:)
		else
			(if (!= (client heading:) (GetAngle (client x:) (client y:) x y))
				(InitBresen self)
			)
			(super doit:)
		)
	)
)

(instance nearScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(!= (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(not (gUser controls:))
					(!= (event type:) evVERB)
					(event modifiers:)
				)
				(super handleEvent: event)
			)
			(else
				(client
					setMotion:
						(if gUseObstacles PolyPath else moveNear)
						(event x:)
						(event y:)
				)
				(gUser prevDir: 0)
				(event claimed: 1)
			)
		)
	)
)

(instance eSwimCode of Inertia
	(properties
		maxInertia 5
	)
)

(instance spSwimCode of Inertia ; UNUSED
	(properties
		maxInertia 4
	)
)

(instance shopper2 of Sq4Actor
	(properties
		z 1000
		view 367
		signal 8192
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(localproc_0 self)
		(cond
			(script)
			((StepOn self 1)
				(if (not cycler)
					(self
						view: (if (IsFlag 30) 7 else 384)
						setCycle: Walk
						setCel: -1
						setStep: 4 2
					)
					(InitBresen mover)
				)
			)
			(else
				(if cycler
					(self
						view: (if (IsFlag 30) 13 else 367)
						setCycle: 0
						setCel: 0
						setStep: 2 2
					)
					(InitBresen mover)
				)
				(= loop
					[local86
						(/
							(umod (+ heading (/ 180 (NumLoops self))) 360)
							(/ 360 (NumLoops self))
						)
					]
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 30)
					(gNarrator modNum: 376 say: 17) ; "It's one of Vohaul's Sequel Policemen!"
				else
					(gNarrator modNum: 700 say: 6) ; "This guy (or is it a gal?) doesn't look like anybody or anything you've ever seen before."
				)
			)
			(4 ; Do
				(gNarrator modNum: 700 say: 2) ; "These guys are scary looking. It wouldn't be a good idea to mess with them."
			)
			(2 ; Talk
				(gNarrator modNum: 700 say: 7) ; "The being, unable to understand your language, acts as though it doesn't see you."
			)
			(6 ; Smell
				(gNarrator modNum: 700 say: 8) ; "Taking in a whiff of air, you instantly notice it has three feet."
			)
			(7 ; Taste
				(gNarrator modNum: 700 say: 1) ; "As much as we enjoy seeing you get in trouble, we must warn you that this type of behavior is universally considered either rude or amorous, which could get you either killed or married."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shopper3 of Sq4Actor
	(properties
		z 1000
		view 368
		signal 8192
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(localproc_0 self)
		(cond
			(script)
			((StepOn self 1)
				(if (not cycler)
					(self
						view: (if (IsFlag 30) 7 else 388)
						setCycle: Walk
						setCel: -1
						setStep: 5 2
					)
					(InitBresen mover)
				)
			)
			(else
				(if cycler
					(self
						view: (if (IsFlag 30) 13 else 368)
						setCycle: 0
						setCel: 0
						setStep: 2 2
					)
					(InitBresen mover)
				)
				(= loop
					[local86
						(/
							(umod (+ heading (/ 180 (NumLoops self))) 360)
							(/ 360 (NumLoops self))
						)
					]
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 30)
					(gNarrator modNum: 376 say: 17) ; "It's one of Vohaul's Sequel Policemen!"
				else
					(gNarrator modNum: 700 say: 9) ; "This guy looks like The Living Torso. He probably works for an intergalactic freak show."
				)
			)
			(4 ; Do
				(gNarrator modNum: 700 say: 2) ; "These guys are scary looking. It wouldn't be a good idea to mess with them."
			)
			(2 ; Talk
				(switch (Random 1 20)
					(19
						(wierdNar say: 1) ; "Mr. Carlos sent me. I want to know about the sheep."
						(Prints
							{"Mr. Carlos sent me. I want to know about the sheep."}
						)
					)
					(else
						(gNarrator modNum: 700 say: 10) ; "It doesn't have the slightest notion as to what you might be saying."
					)
				)
			)
			(6 ; Smell
				(gNarrator modNum: 700 say: 11) ; "Uhmm! Sulfur! This shopper smells as though it comes from a planet where the only showers are volcanic ones."
			)
			(7 ; Taste
				(gNarrator modNum: 700 say: 1) ; "As much as we enjoy seeing you get in trouble, we must warn you that this type of behavior is universally considered either rude or amorous, which could get you either killed or married."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sp1 of Sq4Actor
	(properties
		view 7
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 376 say: 17) ; "It's one of Vohaul's Sequel Policemen!"
			)
			(2 ; Talk
				(gNarrator modNum: 376 say: 1) ; "That would be most unwise!"
			)
			(6 ; Smell
				(gNarrator modNum: 376 say: 2) ; "Seeing as how these guys are trying to kill you, your best line of defense would be a straight one out of here."
			)
			(7 ; Taste
				(gNarrator modNum: 700 say: 3) ; "You'd best stay out of sight of this guy!"
			)
			(4 ; Do
				(gNarrator modNum: 376 say: 2) ; "Seeing as how these guys are trying to kill you, your best line of defense would be a straight one out of here."
			)
			(8 ; buckazoid
				(gNarrator modNum: 376 say: 5) ; "The Sequel Police are closely monitored by Vohaul. Bribing them would be out of the question."
			)
			(9 ; rope
				(gNarrator modNum: 376 say: 6) ; "Even if you were to lasso a Sequel Policeman, what would you do with him?"
			)
			(11 ; rabbit
				(gNarrator modNum: 700 say: 4) ; "Don't throw the bunny at the Sequel Policeman! He may have a hare trigger."
			)
			(12 ; battery
				(gNarrator modNum: 700 say: 12) ; "No way! That would be assualt with intent to emit battery!"
			)
			(14 ; gum
				(gNarrator modNum: 376 say: 7) ; "Try as you might, the gum just gets stuck to your fingers."
			)
			(17 ; pen
				(gNarrator modNum: 700 say: 5) ; "He's going to SHOOT you, not write you a ticket!"
			)
			(18 ; atmCard
				(gNarrator modNum: 376 say: 5) ; "The Sequel Police are closely monitored by Vohaul. Bribing them would be out of the question."
			)
			((OneOf theVerb 20 21 22 23) ; cigar, matches, diskette, laptop
				(gNarrator modNum: 376 say: 4) ; "You'd better not. You might need that later."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sp2 of Sq4Actor
	(properties
		view 7
		signal 24576
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 376 say: 17) ; "It's one of Vohaul's Sequel Policemen!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shopperPath2 of RegionPath
	(properties
		value 17
		theRegion 700
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== currentRoom gCurRoomNum)
				(!= (client script:) spOnBelt)
				(not (spOnBelt client:))
				(IsFlag 30)
			)
			(client setScript: spOnBelt)
		)
	)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance shopperPath3 of RegionPath
	(properties
		value 17
		theRegion 700
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== currentRoom gCurRoomNum)
				(!= (client script:) spOnBelt)
				(not (spOnBelt client:))
				(IsFlag 30)
			)
			(client setScript: spOnBelt)
		)
	)

	(method (at param1)
		(return [local43 param1])
	)
)

(instance egoBumpScript of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp1
					(GetAngle
						(register x:)
						(register y:)
						(gEgo x:)
						(gEgo y:)
					)
				)
				(= temp1 (umod (+ temp1 45) 360))
				(gEgo
					view: 370
					cel: 0
					setMotion: 0
					x: temp0 ; UNINIT
					setCycle: End self
				)
			)
			(1
				(gUser canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance egoStandScript of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo view: 0 setCycle: Walk)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance spOnBelt of Script
	(properties)

	(method (init)
		(super init: &rest)
		(SetFlag 3)
	)

	(method (doit)
		(cond
			((gCurRoom script:)
				(client setCel: 0)
				(Face client gEgo)
			)
			(
				(and
					(== state 0)
					(< 40 (client y:) 170)
					(< 20 (client x:) 300)
					(not (gCurRoom script:))
				)
				(self cue:)
			)
			((!= gCurRoomNum ((client mover:) currentRoom:))
				(HandsOn)
				(self dispose:)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0 0)
			(1
				(HandsOff)
				(ClearFlag 30)
				(Face client gEgo self)
			)
			(2
				(client setCel: 0 view: 13 setCycle: End)
				(gEgo view: 26 cel: 0 setCycle: End self)
			)
			(3
				(EgoDead 8 17) ; "Zap zap, you're dead."
			)
		)
	)
)

(instance belts of Sq4Feature
	(properties
		sightAngle 180
	)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $0006))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 700 say: 13) ; "This belt way is great! No more tired, aching feet. No more walking just for the sake of going somewhere."
			)
			(4 ; Do
				(gNarrator modNum: 700 say: 14) ; "You scrape some coating from the surface of the belt. Now there's probably toe jam from all corners of the universe wedged up under your fingernail!"
			)
			(6 ; Smell
				(gNarrator modNum: 700 say: 15) ; "You attempt to smell the moving walkway and end up filing down your nose slightly."
			)
			(7 ; Taste
				(gNarrator modNum: 700 say: 16) ; "Very well, you give the moving walkway a warm kiss. Now you both feel special."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance restOfMall of Sq4Feature
	(properties
		sightAngle 180
	)

	(method (onMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 700 say: 17) ; "It's just another vital part of the Galaxy Galleria Shopping Mall."
			)
			(6 ; Smell
				(gNarrator modNum: 380 say: 11) ; "The mall has that high-rent, low-occupancy smell...like any office building in downtown Los Angeles."
			)
			(7 ; Taste
				(gNarrator modNum: 380 say: 12) ; "It's against the Third Law of Mall Security to be caught licking mall components."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wierdNar of Sq4Narrator
	(properties
		modNum 700
		talkerNum 13
	)
)

