;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Array)
(use Inset)
(use Talker)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm360 0
	impoundTalker 1
)

(local
	local0
	local1 = 3
	local2
	local3
	local4
	[local5 8] = [11 11 8 8 8 8 8 8]
	[local13 8] = [15 15 11 12 12 12 10 12]
	local21
	local22
	local23
	local24
	local25
)

(instance rm360 of Room
	(properties
		noun 16
		picture 360
	)

	(method (init)
		(proc0_4 1)
		(= local2 (IntArray newWith: 10 30 70 90 110 150 170 210 250 270 310))
		(= local3 (IntArray newWith: 10 30 63 96 129 162 195 228 261 294 327))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 17 153 309 153 309 122 267 122 220 103 90 103 85 112 88 131 17 143
					yourself:
				)
		)
		(super init: &rest)
		(building init:)
		(extraCars init:)
		(theSky init:)
		(gEgo posn: 22 160 normalize: 0 setScaler: Scaler 93 11 151 77 init:)
		(joeBob
			posn: (- (local2 at: local1) 9) 133
			setLoop: -1
			heading: 180
			setLooper: Grooper
			setCycle: StopWalk 360
			init:
		)
		(if (gPqFlags test: 44)
			(joeBob setLooper: Grooper)
		)
		(joeTeller init: joeBob 360)
		(switch gDay
			(4
				(copCar init: approachVerbs: (if (gPqFlags test: 44) 4 else 0))
				(copShadow init:)
			)
			(5
				(csCar init: approachVerbs: (if (gPqFlags test: 44) 4 else 0))
				(csShadow init:)
				(csFrontDoor
					init:
					approachVerbs: (if (gPqFlags test: 44) 4 else 0)
				)
				(csBackDoor
					init:
					approachVerbs: (if (gPqFlags test: 44) 4 else 0)
				)
				(csPlate
					init:
					approachVerbs: (if (gPqFlags test: 44) 1 else 0)
				)
			)
		)
		(gWalkHandler addToFront: self)
		(self setScript: enterRoom)
	)

	(method (handleEvent event)
		(cond
			((and inset (inset handleEvent: event)) 0)
			(
				(and
					(& (event type:) evMOVE)
					(not (gPqFlags test: 44))
					(< (event y:) 153)
				)
				(cond
					(
						(and
							(> (event x:) (gEgo x:))
							(< (gEgo x:) (local3 at: 7))
						)
						(self setScript: moveRight)
					)
					(
						(and
							(< (event x:) (gEgo x:))
							(> (gEgo x:) (local3 at: 1))
						)
						(self setScript: moveLeft)
					)
				)
				(event claimed: 1)
				(return)
			)
			((& (event type:) evMOVE)
				(if (> (event y:) 152)
					(self setScript: leaveRoom)
					(event claimed: 1)
					(return)
				else
					(event claimed: 0)
					(return)
				)
			)
			(else
				(super handleEvent: event)
				(return)
			)
		)
	)

	(method (dispose)
		(local2 dispose:)
		(local3 dispose:)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((> (gEgo y:) 152)
				(gCurRoom newRoom: 355)
			)
		)
	)
)

(instance watchEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face joeBob gEgo self)
			)
			(1
				(= ticks 120)
			)
			(2
				(Face joeBob gEgo self)
			)
			(3
				(= ticks 120)
			)
			(4
				(if (joeBob looper:)
					((joeBob looper:) dispose:)
					(joeBob looper: 0)
				)
				(if (OneOf (joeBob loop:) 7 3 6)
					(joeBob
						view:
							(switch (joeBob loop:)
								(3 365)
								(6 366)
								(7 364)
							)
						loop: 0
						cel: 0
						setCycle: End self
					)
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(5
				(joeBob
					setCycle:
						ROsc
						(Random 4 6)
						[local5 (- (joeBob view:) 361)]
						[local13 (- (joeBob view:) 361)]
						self
				)
			)
			(6
				(joeBob setCycle: Beg self)
			)
			(7
				(if (OneOf (joeBob view:) 364 365 366)
					(joeBob
						loop:
							(switch (joeBob view:)
								(365 3)
								(366 6)
								(364 7)
							)
					)
				)
				(joeBob view: 3720 setLooper: Grooper setCycle: StopWalk 360)
				(= cycles 1)
			)
			(8
				(Face joeBob gEgo self)
			)
			(9
				(= ticks 60)
			)
			(10
				(Face joeBob gEgo self)
			)
			(11
				(self changeState: 0)
			)
		)
	)
)

(instance stopWatching of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (OneOf (joeBob view:) 364 365 366)
					(joeBob setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(1
				(if (OneOf (joeBob view:) 364 365 366)
					(joeBob
						loop:
							(switch (joeBob view:)
								(365 3)
								(366 6)
								(364 7)
							)
					)
				)
				(joeBob view: 3720 setLooper: Grooper setCycle: StopWalk 360)
				(= cycles 1)
			)
			(2
				(Face joeBob gEgo self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (not (gPqFlags test: 44))
					(gEgo
						x:
							(if (gEgo cel:)
								(- (gEgo x:) 12)
							else
								(+ (gEgo x:) 23)
							)
						heading: 0
						normalize: 0
					)
					(joeBob
						view: 370
						loop: 0
						cel: 0
						x: (- (local2 at: local1) 9)
					)
					(= cycles 2)
				else
					(joeBob setScript: stopWatching self)
				)
			)
			(2
				(gEgo setMotion: PolyPath (gEgo x:) 151 self)
			)
			(3
				(joeBob setHeading: 180)
				(Face gEgo joeBob self)
			)
			(4
				(if (OneOf gDay 4 5)
					(gMessager
						say:
							3
							2
							(if (== gDay 4)
								(if (gPqFlags test: 166) 19 else 22)
							else
								21
							)
							1
							self
					)
				else
					(self cue:)
				)
			)
			(5
				(joeBob view: 370 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(if (OneOf gDay 4 5)
					(gMessager say: 3 2 (if (== gDay 4) 19 else 21) 2 self)
				else
					(self cue:)
				)
			)
			(7
				(gEgo setMotion: PolyPath (gEgo x:) 153 self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsVIEW 0 5)
				(joeBob setMotion: PolyPath (- (local2 at: local1) 9) 140 self)
				(gEgo setMotion: MoveTo (- (local3 at: local1) 12) 152 self)
			)
			(1 0)
			(2
				(joeBob setHeading: 180)
				(gEgo setHeading: 0 self)
			)
			(3
				(joeBob view: 370 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(if (gPqFlags test: 44)
					(self cue:)
				else
					(gEgo
						view: 9341
						loop: 0
						cel: 15
						x: (local3 at: local1)
						setCycle: 0
					)
					(if (gEgo looper:)
						((gEgo looper:) dispose:)
						(gEgo looper: 0)
					)
					(if (joeBob looper:)
						((joeBob looper:) dispose:)
						(joeBob looper: 0)
					)
					(joeBob
						view: 369
						loop: 1
						cel: 0
						x: (local2 at: local1)
						setCycle: 0
					)
					(= cycles 3)
				)
			)
			(5
				(if (and (== gDay 5) (not (gPqFlags test: 90)))
					(gMessager say: 3 2 11 1 self) ; "Hey, buddy, didn't they tell you up front, SID's here. Go away, ya can't come in."
				else
					(gMessager say: 3 2 3 1 self) ; "Hey, Buddy! Can I help ya?"
				)
			)
			(6
				(cond
					((gPqFlags test: 44)
						(copCar sightAngle: 40 approachVerbs: 4) ; Do
						(building sightAngle: 40)
						(extraCars sightAngle: 40)
						(joeBob
							view: 3720
							loop: 2
							sightAngle: 40
							setLooper: Grooper
							setCycle: StopWalk 360
							setScript: watchEgo
						)
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PBarredAccess
									init:
										(- (joeBob x:) 30)
										(- (joeBob y:) 3)
										(+ (joeBob x:) 30)
										(- (joeBob y:) 3)
										(+ (joeBob x:) 30)
										(+ (joeBob y:) 3)
										(- (joeBob x:) 30)
										(+ (joeBob y:) 3)
									yourself:
								)
						)
					)
					(
						(and
							(== gDay 5)
							(gPqFlags test: 90)
							(gPqFlags test: 39)
						)
						(joeBob setScript: howHelp)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance joeBobMoveRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(joeBob
					cel: 0
					setSpeed:
						(if (> (gEgo moveSpeed:) 1)
							(- (gEgo moveSpeed:) 2)
						else
							0
						)
					setCycle: End self
				)
			)
			(1
				(joeBob x: (+ (joeBob x:) 20) cel: 0)
				(if (== (joeBob x:) (local2 at: local1))
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance moveRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ local1)
				(if (gEgo cel:)
					(gEgo setCycle: Beg)
				else
					(gEgo
						x: (+ (gEgo x:) 33)
						cel: (gEgo lastCel:)
						setCycle: Beg
					)
				)
				(= cycles (+ (gEgo moveSpeed:) 2))
			)
			(1
				(joeBob setScript: joeBobMoveRight self)
			)
			(2
				(joeBob setSpeed: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance joeBobMoveLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(joeBob
					x: (- (joeBob x:) 20)
					cel: 12
					setSpeed:
						(if (> (gEgo moveSpeed:) 1)
							(- (gEgo moveSpeed:) 2)
						else
							0
						)
					setCycle: Beg self
				)
			)
			(1
				(if (== (joeBob x:) (local2 at: local1))
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance moveLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(-- local1)
				(if (gEgo cel:)
					(gEgo x: (- (gEgo x:) 33) cel: 0 setCycle: End)
				else
					(gEgo setCycle: End)
				)
				(= cycles (+ (gEgo moveSpeed:) 2))
			)
			(1
				(joeBob setScript: joeBobMoveLeft self)
			)
			(2
				(joeBob setSpeed: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stepAside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 2 9 1 self) ; "I'm looking for a patrol car that was brought in from the Hollywood and Vine area. It had been abandoned."
			)
			(1
				(gEgo
					heading: 0
					normalize: 0
					x:
						(if (gEgo cel:)
							(- (gEgo x:) 12)
						else
							(+ (gEgo x:) 23)
						)
				)
				(if (<= local1 2)
					(joeBob setCycle: (if (joeBob cel:) Beg else End) self)
				else
					(joeBob x: (- (joeBob x:) 20) cel: 12 setCycle: Beg self)
				)
			)
			(2
				(joeBob
					x:
						(if (joeBob cel:)
							(+ (joeBob x:) 14)
						else
							(- (joeBob x:) 9)
						)
					view: 3720
					loop: 2
					heading: 180
					setLoop: -1
				)
				(joeBob
					sightAngle: 40
					setLooper: Grooper
					setCycle: StopWalk 360
				)
				(= cycles 1)
			)
			(3
				(joeBob setMotion: PolyPath (- (local2 at: 3) 9) 140 self)
			)
			(4
				(gGame handsOn:)
				(gPqFlags set: 44)
				(gMessager say: 3 2 10 1 self) ; "Well, come on in, buddy!"
			)
			(5
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(- (joeBob x:) 30)
								(- (joeBob y:) 3)
								(+ (joeBob x:) 30)
								(- (joeBob y:) 3)
								(+ (joeBob x:) 30)
								(+ (joeBob y:) 3)
								(- (joeBob x:) 30)
								(+ (joeBob y:) 3)
							yourself:
						)
				)
				(= cycles 1)
			)
			(6
				(copCar sightAngle: 40 approachVerbs: 4) ; Do
				(building sightAngle: 40)
				(extraCars sightAngle: 40)
				(joeBob setScript: watchEgo)
				(self dispose:)
			)
		)
	)
)

(instance howHelp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds 10)
			)
			(1
				(gGame handsOff:)
				(joeBob
					view: 361
					loop: 0
					cel: 0
					x:
						(if (joeBob cel:)
							(+ (joeBob x:) 14)
						else
							(- (joeBob x:) 9)
						)
					setCycle: End self
				)
			)
			(2
				(= cycles 1)
			)
			(3
				(gMessager say: 3 2 3 1 self) ; "Hey, Buddy! Can I help ya?"
			)
			(4
				(joeBob setCycle: ROsc 2 11 15 self)
			)
			(5
				(joeBob setCycle: Beg self)
			)
			(6
				(joeBob view: 369 loop: 1 cel: 0 x: (local2 at: local1))
				(= cycles 1)
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance first4Talk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gMessager say: 3 2 3 2 self) ; "I'm Detective Carey, Homicide, LAPD."
				else
					(gMessager say: 3 2 2 0 self) ; "Ah, Beavis? I was told to tell you that Butthead sent me."
				)
			)
			(1
				(gGame handsOff:)
				(joeBob
					view: 361
					loop: 0
					cel: 0
					x:
						(if (joeBob cel:)
							(+ (joeBob x:) 14)
						else
							(- (joeBob x:) 9)
						)
					setCycle: End self
				)
			)
			(2
				(joeBob setCycle: ROsc 2 11 15 self)
			)
			(3
				(= cycles 1)
			)
			(4
				(gMessager say: 3 2 8 1 self) ; "Hey, buddy, what do you want?"
			)
			(5
				(joeBob setCycle: ROsc 2 11 15 self)
			)
			(6
				(joeBob setCycle: Beg self)
			)
			(7
				(joeBob view: 369 loop: 1 cel: 0 x: (local2 at: local1))
				(= cycles 1)
			)
			(8
				(gGame handsOn:)
				(= seconds 10)
			)
			(9
				(self changeState: 1)
			)
		)
	)
)

(instance second4Talk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 2 9 1 self) ; "I'm looking for a patrol car that was brought in from the Hollywood and Vine area. It had been abandoned."
			)
			(1
				(gMessager say: 3 2 1 1 self) ; "Well buddy, what's the word?"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance third4Talk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 3 2 1 2 3 self) ; "What word?"
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance first5Talk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 2 4 0 self) ; "Umm, Dano? MacGarette told me to tell you to 'Book 'im, Dano!'"
			)
			(1
				(gEgo
					heading: 0
					normalize: 0
					x:
						(if (gEgo cel:)
							(- (gEgo x:) 12)
						else
							(+ (gEgo x:) 23)
						)
				)
				(if (<= local1 2)
					(joeBob setCycle: (if (joeBob cel:) Beg else End) self)
				else
					(joeBob x: (- (joeBob x:) 20) cel: 12 setCycle: Beg self)
				)
			)
			(2
				(joeBob
					x:
						(if (joeBob cel:)
							(+ (joeBob x:) 14)
						else
							(- (joeBob x:) 9)
						)
					view: 3720
					loop: 2
					heading: 180
					setLoop: -1
				)
				(joeBob
					sightAngle: 40
					setLooper: Grooper
					setCycle: StopWalk 360
				)
				(= cycles 1)
			)
			(3
				(joeBob setMotion: PolyPath (- (local2 at: 3) 9) 140 self)
			)
			(4
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(- (joeBob x:) 30)
								(- (joeBob y:) 3)
								(+ (joeBob x:) 30)
								(- (joeBob y:) 3)
								(+ (joeBob x:) 30)
								(+ (joeBob y:) 3)
								(- (joeBob x:) 30)
								(+ (joeBob y:) 3)
							yourself:
						)
				)
				(gGame handsOn:)
				(gPqFlags set: 44)
				(gMessager say: 3 2 10 1 self) ; "Well, come on in, buddy!"
			)
			(5
				(csCar sightAngle: 40 approachVerbs: 4) ; Do
				(csFrontDoor sightAngle: 40 approachVerbs: 4) ; Do
				(csBackDoor sightAngle: 40 approachVerbs: 4) ; Do
				(csPlate sightAngle: 40 approachVerbs: 1) ; Look
				(building sightAngle: 40)
				(extraCars sightAngle: 40)
				(joeBob setScript: watchEgo)
				(self dispose:)
			)
		)
	)
)

(instance day5Talk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gMessager say: 3 2 1 2 self) ; "What word?"
				else
					(gMessager say: 3 2 3 3 self) ; "Hello, Joe Bob."
				)
			)
			(1
				(if register
					(gMessager say: 3 2 1 3 self) ; "That's right, buddy... what word! What's the word? Don't know the word, can't let you in."
				else
					(gMessager say: 3 2 1 1 self) ; "Well buddy, what's the word?"
				)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(if (not register)
					(joeBob setScript: askForCode)
				)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance askForCode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 600)
			)
			(1
				(gMessager say: 3 2 1 1 self) ; "Well buddy, what's the word?"
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance showBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local21 (gEgo x:))
				(= local22 (gEgo cel:))
				(= local23
					(if (gEgo cel:)
						(- (gEgo x:) 12)
					else
						(+ (gEgo x:) 23)
					)
				)
				((= register (Actor new:))
					name: {egoLegs}
					view: 9006
					loop: 2
					cel: 0
					x: local23
					y: (gEgo y:)
					setScaler: Scaler 93 52 151 114
					init:
				)
				(gEgo
					setSpeed: 6
					view: 9006
					loop: 0
					cel: 0
					x: local23
					setCycle: End self
				)
			)
			(1
				(gMessager say: 3 27 0 1 self) ; "Hey, buddy, that's not my job. I don't care where you're from as long as the front office says you're okey-dokey."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(register dispose:)
				(= register 0)
				(gEgo x: local21 cel: local22 view: 9341 loop: 0)
				(++ local25)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance joeBob of Actor
	(properties
		noun 3
		sightAngle 360
		x 130
		y 140
		view 3720
		loop 2
		signal 18433
		scaleSignal 1
	)

	(method (init)
		(self setScaler: Scaler 93 52 151 114)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 27) ; badge
			(cond
				((gPqFlags test: 44)
					(gMessager say: 3 27 17 0) ; "It's unnecessary to show him your badge. You already checked"
				)
				(local25
					(gMessager say: 3 27 18 1) ; "I'm telling ya, buddy, it ain't my job to approve your access to the yard. I just work on the cars."
				)
				(else
					(gCurRoom setScript: showBadge)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance joeTeller of Teller
	(properties
		sayNoun 4
		verb 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(cond
				((gPqFlags test: 44)
					(super doVerb: theVerb)
				)
				((and (not (gPqFlags test: 90)) (== gDay 5))
					(gMessager say: 3 2 11 1) ; "Hey, buddy, didn't they tell you up front, SID's here. Go away, ya can't come in."
				)
				((gPqFlags test: 39)
					(switch gDay
						(4
							(switch local0
								(0
									(++ local0)
									(gCurRoom setScript: first4Talk)
								)
								(1
									(++ local0)
									(gGame points: 2 60)
									(gCurRoom setScript: stepAside)
								)
								(else
									(super doVerb: theVerb)
								)
							)
						)
						(5
							(switch local0
								(0
									(++ local0)
									(gGame points: 2 61)
									(gCurRoom setScript: first5Talk)
								)
								(else
									(super doVerb: theVerb)
								)
							)
						)
					)
				)
				(else
					(switch gDay
						(4
							(switch local0
								(0
									(++ local0)
									(gCurRoom setScript: first4Talk 0 1)
								)
								(1
									(++ local0)
									(gCurRoom setScript: second4Talk)
								)
								(2
									(++ local0)
									(gCurRoom setScript: third4Talk)
								)
								(else
									(gMessager say: 3 2 1 3) ; "That's right, buddy... what word! What's the word? Don't know the word, can't let you in."
								)
							)
						)
						(5
							(switch local0
								(0
									(++ local0)
									(joeBob setScript: day5Talk)
								)
								(1
									(++ local0)
									(joeBob setScript: 0)
									(gMessager say: 3 2 7 1) ; "I understand a car was brought in this morning that had had two dead bodies inside. I'd like to see the car."
								)
								(2
									(++ local0)
									(joeBob setScript: day5Talk 0 2)
								)
								(else
									(gMessager say: 3 2 1 3) ; "That's right, buddy... what word! What's the word? Don't know the word, can't let you in."
								)
							)
						)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(20
				(gPqFlags set: 166)
			)
		)
		(super sayMessage:)
	)

	(method (showCases)
		(super
			showCases:
				5
				(== gDay 4)
				6
				(== gDay 4)
				20
				(== gDay 4)
				12
				(== gDay 5)
				13
				(== gDay 5)
				14
				(== gDay 5)
		)
	)
)

(instance building of Feature
	(properties
		noun 1
		sightAngle 360
		x 30
		y 45
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 0 0 71 0 71 128 0 140 yourself:)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 1 1 15 1) ; "The repair shop for the tow yard."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance extraCars of Feature
	(properties
		noun 11
		sightAngle 360
		x 150
		y 45
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 92 79 101 78 131 78 133 81 139 81 145 84 147 80 152 75 163 76 168 83 172 87 181 84 182 78 231 77 234 62 239 56 262 52 270 52 271 48 288 49 289 50 288 53 295 69 319 66 319 116 304 116 303 111 270 109 262 116 257 114 254 108 246 103 242 97 234 97 228 93 200 95 194 92 167 94 140 96 93 98 88 89 89 81
					yourself:
				)
		)
	)
)

(instance theSky of Feature
	(properties
		noun 10
		nsLeft 71
		nsRight 319
		nsBottom 86
		sightAngle 360
		x 150
		y 40
	)
)

(instance copCar of View
	(properties
		noun 2
		sightAngle 360
		approachX 152
		approachY 131
		x 159
		y 118
		priority 131
		fixPriority 1
		view 359
		signal 16384
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 93 105 229 118 244 118 244 131 93 131
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gPqFlags test: 44)
				(gCurRoom setInset: copCarInset)
			else
				(gMessager say: 7 4 1 1) ; "First, you need to gain entry into the yard."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance copShadow of View
	(properties
		noun 16
		x 159
		y 118
		priority 1
		fixPriority 1
		view 359
		cel 1
		signal 16384
	)
)

(instance copCarInset of Inset
	(properties
		picture 365
		disposeNotOnMe 1
		noun 5
	)

	(method (init)
		(gGame fade: 100 0 10)
		(doorSound number: 916 loop: 1 play:)
		(gTheIconBar disable: 3 7 show: 0)
		(super init: &rest)
		(if (not (gEgo has: 17)) ; newspaper
			(newspaper init:)
		)
		(copComputer init:)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
	)

	(method (onMe param1)
		(return (and (<= 38 (param1 x:) 281) (<= 0 (param1 y:) 152)))
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 3 7)
		(doorSound number: 917 loop: 1 play:)
		(super dispose:)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
	)
)

(instance newspaper of View
	(properties
		noun 6
		x 79
		y 126
		view 3650
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame points: 2)
			(gMessager say: noun theVerb 0 0) ; "You pick up the small piece of torn newspaper."
			(gEgo get: 17) ; newspaper
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance copComputer of Feature
	(properties
		noun 12
		x 172
		y 50
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 161 25 178 20 186 20 214 25 225 95 189 113 177 107 146 91 147 88 150 86 163 75
					yourself:
				)
		)
	)
)

(instance csCar of View
	(properties
		noun 13
		sightAngle 360
		approachX 124
		approachY 133
		approachDist 5
		x 188
		y 120
		priority 130
		fixPriority 1
		view 359
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 112 105 124 105 217 117 223 125 215 131 153 135 109 131
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gPqFlags test: 44))
				(gMessager say: 7 4 1 1) ; "First, you need to gain entry into the yard."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance csShadow of View
	(properties
		noun 16
		sightAngle 360
		x 188
		y 120
		priority 1
		view 359
		loop 1
		cel 1
		signal 16384
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 112 105 124 105 217 117 223 125 215 131 153 135 109 131
					yourself:
				)
		)
	)
)

(instance csFrontDoor of Feature
	(properties
		noun 13
		sightAngle 360
		approachX 124
		approachY 133
		x 188
		y 121
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 144 84 146 100 145 112 135 111 135 94 139 84
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gPqFlags test: 44)
				(gMessager say: 13 4 0 1) ; "To examine the car interior, you open the door."
				(gCurRoom setInset: csFrontInset)
			else
				(gMessager say: 7 4 1 1) ; "First, you need to gain entry into the yard."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance csFrontInset of Inset
	(properties
		picture 370
		disposeNotOnMe 1
		noun 8
	)

	(method (init)
		(gGame fade: 100 0 10)
		(doorSound number: 916 loop: 1 play:)
		(gTheIconBar disable: 3 7 show: 0)
		(super init: &rest)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 36 (param1 x:) 284) (<= 0 (param1 y:) 147)))
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 3 7)
		(doorSound number: 917 loop: 1 play:)
		(super dispose:)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
	)
)

(instance csBackDoor of Feature
	(properties
		noun 13
		sightAngle 360
		approachX 124
		approachY 133
		x 188
		y 121
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 134 84 138 84 134 94 134 110 126 107 128 94 132 86
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gPqFlags test: 44)
				(gMessager say: 13 4 0 1) ; "To examine the car interior, you open the door."
				(gCurRoom setInset: csBackInset)
			else
				(gMessager say: 7 4 1 1) ; "First, you need to gain entry into the yard."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance csBackInset of Inset
	(properties
		picture 375
		style 13
		disposeNotOnMe 1
		noun 9
	)

	(method (init)
		(gGame fade: 100 0 10)
		(doorSound number: 916 loop: 1 play:)
		(gTheIconBar disable: 3 7 show: 0)
		(super init: &rest)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 36 (param1 x:) 284) (<= 0 (param1 y:) 147)))
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 3 7)
		(doorSound number: 917 loop: 1 play:)
		(super dispose:)
		(FrameOut (gCast elements:) 0)
		(gGame fade: 0 100 10)
	)
)

(instance csPlate of Feature
	(properties
		noun 14
		nsLeft 182
		nsTop 111
		nsRight 198
		nsBottom 116
		sightAngle 360
		approachX 124
		approachY 133
		x 188
		y 121
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (gPqFlags test: 44)
				(gMessager say: noun theVerb 0 1) ; "Looking at the license plate, you discover...."
				(gCurRoom setInset: csPlateInset)
			else
				(gMessager say: 7 4 1 1) ; "First, you need to gain entry into the yard."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance csPlateInset of Inset
	(properties
		picture 377
		style 13
		disposeNotOnMe 1
		noun 15
	)

	(method (init)
		(gGame points: 4 58)
		(gPqFlags set: 91)
		(gTheIconBar disable: 3 7 show: 0)
		(super init: &rest)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 48 (param1 x:) 269) (<= 25 (param1 y:) 125)))
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
	)

	(method (dispose)
		(gTheIconBar enable: 3 7)
		(super dispose:)
	)
)

(instance impoundTalker of Narrator
	(properties
		x 10
		y 15
	)
)

(instance dftDoVerb of Code
	(properties)

	(method (doit)
		(return 1)
	)
)

(instance doorSound of Sound
	(properties)
)

