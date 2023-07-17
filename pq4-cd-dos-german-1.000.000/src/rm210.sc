;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm210 0
)

(local
	local0 = 1
	local1
)

(instance rm210 of Room
	(properties
		noun 7
		picture 210
	)

	(method (init)
		(gGame handsOn:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 216 156 273 154 262 138 211 141
					yourself:
				)
		)
		(if (== gPrevRoomNum 200)
			(gEgo setHeading: 315 normalize: 0 x: 256 y: 140 init:)
			(switch gDay
				(2
					(if (gPqFlags test: 29)
						(PalVary 8 210) ; PalVaryNewSource
					)
					(if (or (gPqFlags test: 29) (gPqFlags test: 129))
						(closedSign init:)
						(= local0 0)
					)
				)
				(3
					(if (gPqFlags test: 130)
						(closedSign init:)
						(= local0 0)
					)
				)
				(4
					(if (gPqFlags test: 131)
						(closedSign init:)
						(= local0 0)
					)
				)
				(5
					(if (gPqFlags test: 132)
						(closedSign init:)
						(= local0 0)
					)
				)
			)
			(if (not local0)
				(= local1 1)
			)
		else
			(switch gDay
				(2
					(if (gPqFlags test: 129)
						(= local1 1)
					)
				)
				(3
					(if (gPqFlags test: 130)
						(= local1 1)
					)
				)
				(4
					(if (gPqFlags test: 131)
						(= local1 1)
					)
				)
				(5
					(if (gPqFlags test: 132)
						(= local1 1)
					)
				)
			)
			(self setScript: walkDownStairs)
		)
		(if (or local0 (not local1))
			(door init: approachVerbs: 4) ; Do
		else
			(door init:)
		)
		(aWindow init:)
		(wall init:)
		(rangeSign init:)
		(building init:)
		(super init: &rest)
		(if (IsHiRes)
			(hiResSign init:)
		)
		(gGlobalSound0 number: 1025 setLoop: -1 setVol: 0 play: fade: 127 4 2 0)
	)

	(method (doit)
		(super doit:)
		(cond
			((or (> (gEgo y:) 154) (> (gEgo x:) 270))
				(self newRoom: 17) ; MapRoom
			)
			(
				(and
					(not local1)
					local0
					(not script)
					(gEgo inRect: 210 140 213 142)
				)
				(self setScript: walkUpStairs)
			)
		)
	)

	(method (dispose)
		(if (gPqFlags test: 29)
			(PalVary 3) ; PalVaryKill
		)
		(super dispose:)
	)
)

(instance door of Feature
	(properties
		noun 4
		nsLeft 130
		nsTop 33
		nsRight 173
		nsBottom 98
		sightAngle 40
		x 151
		y 60
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (== gPrevRoomNum 220) local1) ; Do
				(gMessager say: noun 4 3) ; "You don't have time to shoot again. You have a case to solve."
			)
			(local0
				(super doVerb: theVerb)
			)
			((Message msgSIZE 210 noun theVerb 2 1)
				(gMessager say: noun theVerb 2 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance building of Feature
	(properties
		noun 2
		nsLeft 49
		nsRight 271
		nsBottom 148
		x 150
	)
)

(instance rangeSign of Feature
	(properties
		noun 1
		nsLeft 53
		nsTop 57
		nsRight 124
		nsBottom 152
		sightAngle 45
		x 90
		y 187
		z 80
	)

	(method (doVerb theVerb)
		(cond
			(local0
				(super doVerb: theVerb)
			)
			((Message msgSIZE 210 noun theVerb 2 1)
				(gMessager say: noun theVerb 2 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wall of Feature
	(properties
		noun 3
		x 150
		y 64
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 125 101 206 104 206 113 209 115 213 126 210 147 126 147
					yourself:
				)
		)
	)
)

(instance aWindow of Feature
	(properties
		noun 6
		x 230
		y 78
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 208 77 208 40 211 30 218 21 228 17 235 15 240 17 251 30 257 42 260 56 259 78
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			(local0
				(super doVerb: theVerb)
			)
			((Message msgSIZE 210 noun theVerb 2 1)
				(gMessager say: noun theVerb 2 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance closedSign of View
	(properties
		sightAngle 45
		x 90
		y 183
		z 80
		view 210
	)

	(method (init)
		(if (IsHiRes)
			(= view 211)
			(= loop 1)
			(= x 53)
			(= y 182)
			(= z 100)
		)
		(super init: &rest)
	)
)

(instance hiResSign of View
	(properties
		noun 1
		sightAngle 45
		x 44
		y 149
		z 100
		view 211
	)
)

(instance sfx of Sound
	(properties)
)

(instance walkUpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 9210
					x: 171
					y: 121
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(gCurRoom drawPic: -1 9)
				(gCast eachElementDo: #hide)
				(gGlobalSound0 setVol: 60)
				(gMessager say: 4 0 0 0 self) ; "You turn the knob and open the door."
			)
			(3
				(sfx number: 32 loop: 1 play:)
				(= ticks 90)
			)
			(4
				(gCurRoom newRoom: 220)
			)
		)
	)
)

(instance walkDownStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame intensity: 0)
				(gGame handsOff:)
				(= ticks 90)
			)
			(1
				(sfx number: 33 loop: 1 play:)
				(gEgo
					view: 9211
					x: 183
					y: 122
					setLoop: 2
					cel: 0
					init:
					setCycle: 0
				)
				(= ticks 90)
			)
			(2
				(gGame intensity: 100 fade: 0 100 (gGame fadeSpeed:))
				(gEgo setCycle: End self)
			)
			(3
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(4
				(gEgo x: 214 y: 141 heading: 120 normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

