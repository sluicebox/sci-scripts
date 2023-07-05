;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use n045)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	local0
	local1
	local2
)

(instance rm510 of Room
	(properties
		noun 7
		picture 510
	)

	(method (doRemap)
		(gGame doRemap: 2 243 85)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(proc45_0)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 31 101 38 152 319 152 319 123 288 128 159 142 104 121 105 109 197 108 197 101
					yourself:
				)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 520)
			(gEgo
				x: 180
				y: 105
				setHeading: 270
				normalize: 0
				setScaler: Scaler 110 41 153 99
				init:
			)
			(self setScript: sEnter)
		else
			(gGlobalSound2 number: 983 setLoop: -1 flags: 5 play:)
			(gEgo
				x: 319
				y: 189
				setHeading: 315
				normalize: 0
				setScaler: Scaler 110 41 153 99
				init:
			)
			(self setScript: sEnter)
		)
		(guard init: approachVerbs: 4 2 74) ; Do, Talk, candyBar
		(if (IsHiRes)
			(leftSign init:)
			(dareSign init:)
			(hiResFlags init:)
		)
		(banner init:)
		(lobbyFlags init:)
		(lobbySign init:)
		(counter init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((>= (gEgo y:) 152)
				(gGlobalSound0 fade: 0 4 2 1)
				(gCurRoom newRoom: 505)
			)
			((and (<= (gEgo y:) 108) (>= (gEgo x:) 182))
				(gCurRoom newRoom: 520)
			)
			((InRect 0 100 41 150 gEgo)
				(if (not local2)
					(= local2 1)
					(gMessager say: 6 75 0 0) ; "You haven't solved the case yet. Why are you going to the jail?"
				)
			)
			(else
				(= local2 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 520)
			(gEgo get: 43) ; parkerID
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gGlobalSound2 number: 0 stop:)
		(super dispose: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 520)
					(gEgo setMotion: MoveTo 160 105 self)
				else
					(gEgo setMotion: MoveTo 244 150 self)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guard of Prop
	(properties
		noun 1
		sightAngle 20
		approachX 208
		approachY 138
		x 221
		y 91
		priority 120
		fixPriority 1
		view 510
	)

	(method (doit)
		(super doit:)
		(= cycleSpeed (gEgo cycleSpeed:))
		(if (not local0)
			(if (== gPrevRoomNum 520)
				(if (>= (gEgo y:) 121)
					(= local0 1)
					(self setScript: sideGreet)
				)
			else
				(= local0 1)
				(if (gEgo has: 43) ; parkerID
					(self approachX: 244 approachY: 150)
					(self setScript: stopEgo)
				else
					(self setScript: frontGreet)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(if (not local1)
					(++ local1)
					(if (gEgo has: 43) ; parkerID
						(gMessager say: 1 2 2) ; "Hey, Bill, how you doing?"
					else
						(super doVerb: theVerb)
					)
				else
					(gCurRoom setScript: randomConv)
				)
			)
			((gEgo has: 43) ; parkerID
				(if (== theVerb 74) ; candyBar
					(gEgo put: 48) ; candyBar
				)
				(if (Message msgSIZE 510 noun theVerb 2 1)
					(gMessager say: noun theVerb 2)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(if (== theVerb 74) ; candyBar
					(gEgo put: 48) ; candyBar
				)
				(super doVerb: theVerb)
			)
		)
	)
)

(instance randomConv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gMessager sayRandom: 1 2 3 self))
			)
			(1
				(gMessager say: 1 2 4 register self)
			)
			(2
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance stopEgo of Script
	(properties)

	(method (init)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gGame handsOff:)
				(guard view: 511 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 1 2 5 0 self) ; "Halt! No entrance without proper identification."
			)
			(3
				(guard setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(= state -1)
				(= cycles 1)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(if (or (< (event x:) 235) (< (event y:) 150))
				(if (gEgo has: 43) ; parkerID
					(event claimed: 1)
					(self cue:)
					(return 1)
				else
					(event claimed: 0)
					(guard approachX: 205 approachY: 136)
					(self dispose:)
				)
			else
				(event claimed: 0)
				(self dispose:)
			)
		else
			(return 0)
		)
	)

	(method (doit)
		(guard approachX: (gEgo x:) approachY: (gEgo y:))
		(super doit:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance frontGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sideGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard view: 512 cel: 0 setCycle: End self)
			)
			(1
				(guard setCycle: Beg self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance leftSign of View
	(properties
		noun 5
		x 31
		y 62
		priority 1000
		fixPriority 1
		view 10510
	)
)

(instance dareSign of View
	(properties
		noun 2
		x 94
		y 51
		view 10510
		loop 1
	)
)

(instance hiResFlags of View
	(properties
		noun 3
		x 166
		y 18
		view 10510
		loop 2
	)
)

(instance counter of Feature
	(properties
		noun 8
		x 200
		y 30
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 114 81 169 84 260 81 261 89 278 88 277 114 275 116 274 121 167 135 117 119 117 114 114 112
					yourself:
				)
		)
	)
)

(instance banner of Feature
	(properties
		noun 2
		nsLeft 61
		nsTop 35
		nsRight 113
		nsBottom 62
		x 85
		y 45
	)
)

(instance lobbyFlags of Feature
	(properties
		noun 3
		x 152
		y 18
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 133 16 139 18 139 8 146 13 146 4 152 4 170 27 170 28 167 27 169 29 176 36 174 36 166 31 183 47 181 48 163 35 159 41 158 54 157 58 151 55 149 50 147 54 144 54 142 56 139 58 138 61 137 62 135 62 136 60 135 50 136 25 136 20
					yourself:
				)
		)
	)
)

(instance lobbySign of Feature
	(properties
		noun 5
		x 25
		y 75
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 6 41 47 44 48 90 30 90 30 154 25 153 25 90 5 90
					yourself:
				)
		)
	)
)

