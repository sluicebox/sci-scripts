;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 515)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm515 0
	teddyTalker 1
)

(local
	local0
	local1 = 1
	local2 = 1
)

(instance rm515 of Room
	(properties
		noun 7
		picture 515
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(buttons init:)
		(gWalkHandler addToFront: self)
		(gEgo setTalker: egoTalker)
		(switch gDay
			(2
				(if (and (gPqFlags test: 32) (not (gPqFlags test: 29)))
					(self setScript: sEnter)
					(counterGuy init:)
				else
					(gGame handsOn:)
					(door init:)
				)
			)
			(3
				(if ((gInventory at: 0) owner:) ; funeralMemo
					(gGame handsOn:)
					(door init:)
				else
					(self setScript: sEnter)
					(counterGuy init:)
				)
			)
			(4
				(if ((gInventory at: 23) owner:) ; boneBaggie
					(gGame handsOn:)
					(door init:)
				else
					(self setScript: sEnter)
					(counterGuy init:)
				)
			)
			(5
				(if (gPqFlags test: 101)
					(gGame handsOn:)
					(door init:)
				else
					(self setScript: sEnter)
					(counterGuy init:)
				)
			)
			(else
				(gGame handsOn:)
				(door init:)
			)
		)
		(if (not (gCast contains: door))
			(fileCabinets init:)
			(thePhoto init:)
			(theWindows init:)
			(noSmokingSign init:)
			(rightB init:)
			(leftB init:)
			(sky init:)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (not (gCast contains: door))
				(gMessager say: noun 2 13 0) ; "Are you talking to me, Detective?"
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(self newRoom: 512)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance teddyTalker of Narrator
	(properties
		x 85
		y 10
	)
)

(instance egoTalker of Narrator
	(properties
		x 40
		y 85
	)
)

(instance myHead of Prop
	(properties
		x 184
		y 62
		priority 12
		view 5153
		loop 1
	)

	(method (init)
		(|= signal $4000)
		(|= signal $1000)
		(super init:)
	)

	(method (doVerb &tmp temp0)
		(= temp0 (counterGuy actions:))
		(temp0 doVerb: &rest)
	)
)

(instance door of View
	(properties
		noun 9
		x 170
		y 98
		view 515
	)
)

(instance counterGuy of Prop
	(properties
		noun 1
		x 182
		y 100
		view 5153
	)

	(method (init)
		(|= signal $1000)
		(myHead init:)
		(teddyTell init: self 515 2 5)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			(script
				(switch theVerb
					(2 ; Talk
						(gMessager say: noun (script register:) 3 0 script)
					)
					(else
						(switch theVerb
							(10 ; ammoBaggie
								(= local0 1)
							)
							(else
								(= local0 0)
							)
						)
						(gMessager say: noun theVerb 0)
					)
				)
			)
			((OneOf theVerb 4 1 2 27 66) ; Do, Look, Talk, badge, parkerID
				(super doVerb: theVerb)
			)
			(else
				(self setScript: takeStuff 0 theVerb)
			)
		)
	)
)

(instance teddyTell of Teller
	(properties)

	(method (doVerb theVerb)
		(cond
			((client script:)
				(if local0
					(super doVerb: theVerb)
					(if (== iconValue -999)
						(gMessager say: 2 0 10 0 self) ; "Detective, this is not an item for Property."
					)
				else
					(client doVerb: theVerb)
				)
			)
			((== theVerb 2) ; Talk
				(switch local1
					(1
						(++ local1)
						(gMessager sayRandom: 1 2 4)
					)
					(else
						(gCurRoom setScript: chat)
					)
				)
			)
			(else
				(client doVerb: theVerb)
			)
		)
		(return 1)
	)

	(method (sayMessage)
		(switch iconValue
			(5
				(gEgo put: 1) ; ammoBaggie
				(if (not (gPqFlags test: 168))
					(gGame points: 2)
				)
				(gMessager
					say:
						2
						((client script:) register:)
						iconValue
						0
						(client script:)
				)
			)
			(6
				(gPqFlags set: 168)
				(gMessager say: 2 ((client script:) register:) iconValue 0 self)
			)
			(7
				(gPqFlags set: 168)
				(gMessager say: 2 ((client script:) register:) iconValue 0 self)
			)
		)
		(return 1)
	)

	(method (cue)
		(if (== iconValue -999)
			(= local0 0)
			((client script:) cue:)
		else
			(self doVerb: 2)
		)
	)
)

(instance chat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gMessager sayRandom: 1 2 9 self))
			)
			(1
				(gMessager say: 1 2 8 register self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance takeStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(myHead hide:)
				(counterGuy view: 5154 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(counterGuy loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(User input: 1)
				(gTheIconBar enable: 3 curIcon: (gTheIconBar at: 3))
				(gGame setCursor: ((gTheIconBar at: 3) cursorView:) 1)
				(client doVerb: register)
			)
			(4
				(gGame handsOff:)
				(if local0
					(gGame points: 3)
					(counterGuy loop: 2 cel: 0 cycleSpeed: 8 setCycle: End self)
				else
					(counterGuy setCycle: Beg self)
				)
			)
			(5
				(if local0
					(counterGuy loop: 3 cel: 0 setCycle: End self)
				else
					(counterGuy loop: 0)
					(counterGuy cel: (counterGuy lastCel:) setCycle: Beg self)
				)
			)
			(6
				(counterGuy view: 5153 loop: 0 cel: 0 cycleSpeed: 6)
				(myHead show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myHead setCycle: Fwd)
				(= ticks 120)
			)
			(1
				(myHead setCycle: 0 cel: 0)
				(gMessager sayRandom: 1 0 1 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance noSmokingSign of Feature
	(properties
		noun 5
		nsLeft 44
		nsTop 14
		nsRight 62
		nsBottom 31
		x 53
		y 22
	)
)

(instance leftB of Feature
	(properties
		noun 11
		nsLeft 85
		nsTop 29
		nsRight 107
		nsBottom 75
		sightAngle 40
		approachX 96
		approachY 52
		approachDist 0
		x 96
		y 15
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb)
		else
			(theWindows doVerb: theVerb)
		)
	)
)

(instance rightB of Feature
	(properties
		noun 10
		nsLeft 236
		nsTop 22
		nsRight 251
		nsBottom 78
		sightAngle 40
		approachX 243
		approachY 50
		approachDist 0
		x 243
		y 15
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb)
		else
			(theWindows doVerb: theVerb)
		)
	)
)

(instance buttons of Feature
	(properties
		noun 8
		x 100
		y 20
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 42 54 52 58 52 58 43 64 43 64 53 67 53 67 61 64 62 64 74 56 74 56 63 46 63 46 75 41 75 41 53 48 53 48 42
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((gCast contains: door)
					(gMessager say: noun theVerb 16) ; "You ring the bell but receive no answer."
				)
				((== local2 1)
					(++ local2)
					(gMessager say: noun theVerb 13) ; "No need to ring the bell. Teddy is standing right in front of you."
				)
				(else
					(gMessager say: noun theVerb 14) ; "Excuse me, Detective, but that is very annoying. Please don't ring the bell."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sky of Feature
	(properties
		noun 12
		x 100
		y 20
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 130 10 130 65 116 65 116 70 107 70 107 36 102 32 83 28 83 13
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 249 3 249 20 235 20 235 78 200 78 200 6
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb)
		else
			(theWindows doVerb: theVerb)
		)
	)
)

(instance theWindows of Feature
	(properties
		noun 3
		x 100
		y 10
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 76 13 130 10 130 65 118 65 116 70 105 70 103 76 76 77
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 177 7 250 2 250 80 198 79 196 75 191 74 188 70 177 72
					yourself:
				)
		)
	)
)

(instance thePhoto of Feature
	(properties
		noun 4
		nsLeft 144
		nsTop 42
		nsRight 158
		nsBottom 58
		x 151
		y 50
	)
)

(instance fileCabinets of Feature
	(properties
		noun 6
		x 100
		y 99
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 77 78 139 81 139 94 76 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 172 83 199 84 200 81 267 84 266 99 171 96
					yourself:
				)
		)
	)
)

