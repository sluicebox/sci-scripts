;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm600 0
)

(instance rm600 of Room
	(properties
		noun 19
		picture 600
	)

	(method (init)
		(proc0_4 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 16 152 308 158 308 151 214 151 207 137 266 137 266 132 293 132 293 136 308 136 308 129 207 131 190 125 186 125 184 128 123 131 122 135 12 137
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 44 141 76 141 76 149 44 149
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 118 137 146 137 146 143 118 143
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 153 134 202 134 203 143 153 143
					yourself:
				)
		)
		(super init: &rest)
		(car init: setPri: 150 signal: (| (car signal:) $5000))
		(if (!= gPrevRoomNum 605)
			(gEgo x: 238 y: 154 setHeading: 270)
		else
			(gEgo
				x:
					(switch global158
						(0 142)
						(1 116)
						(2 210)
					)
				y:
					(switch global158
						(0 137)
						(1 137)
						(2 132)
					)
				setHeading:
					(switch global158
						(0 180)
						(1 270)
						(2 90)
					)
			)
			(= global158 0)
		)
		(gEgo setScaler: Scaler 62 46 151 136 init: normalize: 0)
		(if
			(or
				(and (== gPrevRoomNum 605) (gPqFlags test: 169))
				(and
					(!= gPrevRoomNum 605)
					(> gDay 4)
					(not (gPqFlags test: 101))
				)
			)
			(gPqFlags set: 169)
			(mitch init: approachVerbs: 1 4) ; Look, Do
		)
		(leftWindow init: approachVerbs: 1) ; Look
		(rightWindow init: approachVerbs: 1) ; Look
		(booth init: approachVerbs: 1 4) ; Look, Do
		(leftDoor init: approachVerbs: 4) ; Do
		(rightDoor init: approachVerbs: 4) ; Do
		(mainSign init:)
		(otherSign init:)
		(pole init:)
		(rightPole init:)
		(loadingSign init:)
		(leftShops init:)
		(rightShops init:)
		(theater init:)
		(rightTree init:)
		(leftTree init:)
		(trunk init: approachVerbs: 46) ; keys
		(if (!= gPrevRoomNum 605)
			(self setScript: carScript)
		else
			(soundScript init:)
			(gGame handsOn:)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((and (> gDay 4) (gEgo inRect: 115 120 216 130))
				(gCurRoom newRoom: 605)
			)
			((gEgo inRect: 296 126 3111 151)
				(gEgo x: 295 setMotion: 0)
				(gMessager say: 0 0 2 0) ; "Don't wander off. You have an investigation to complete."
			)
			((gEgo inRect: 11 137 25 150)
				(gEgo x: 26 setMotion: 0)
				(gMessager say: 0 0 2 0) ; "Don't wander off. You have an investigation to complete."
			)
		)
	)
)

(instance carScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound1 number: 101 loop: -1 play:)
				(gEgo setMotion: PolyPath 212 148 self)
			)
			(1
				(soundScript init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (init)
		(gTheDoits add: self)
		(= state -1)
		(self cue:)
	)

	(method (cue)
		(self changeState: (+ state 1))
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(switch (Random 1 3)
						(1 905)
						(2 906)
						(3 907)
					)
				)
				(gGlobalSound0 number: temp0 setLoop: 1 play: self)
			)
			(1
				0
				(= state -1)
				(= seconds (Random 5 60))
			)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
	)
)

(instance sFx of Sound ; UNUSED
	(properties)
)

(instance knockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo z: 1000)
				(egoLegs init: signal: (| (egoLegs signal:) $4800))
				(altEgo
					view: 9008
					loop: 0
					cel: 0
					x: (gEgo x:)
					y: (gEgo y:)
					setScaler: Scaler 62 46 151 136
					init:
					signal: (| (altEgo signal:) $4000)
					setCycle: End self
				)
			)
			(1
				(= cycles 1)
			)
			(2
				(altEgo dispose:)
				(egoLegs dispose:)
				(gEgo z: 0)
				(= ticks 20)
			)
			(3
				(gMessager say: 0 4 1 0 self) ; "You knock, but receive no answer."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance altEgo of Prop
	(properties
		noun 18
	)
)

(instance egoLegs of Prop
	(properties
		noun 3
		view 9008
		loop 1
	)

	(method (init)
		(self x: (gEgo x:) y: (gEgo y:) setScaler: Scaler 62 46 151 136)
		(super init:)
	)
)

(instance rmSFX of Sound ; UNUSED
	(properties)
)

(instance rmSounds of Sound ; UNUSED
	(properties)
)

(instance mitch of View
	(properties
		noun 2
		approachX 160
		approachY 137
		x 160
		y 107
		view 600
	)
)

(instance car of Prop
	(properties
		noun 1
		x 283
		y 153
		view 601
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGlobalSound1 stop:)
			(gCurRoom newRoom: 17) ; MapRoom
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pole of Feature
	(properties
		noun 3
		nsLeft 52
		nsRight 66
		nsBottom 144
		sightAngle 40
		approachX 59
		approachY 72
		approachDist 0
		x 59
		y 72
	)
)

(instance rightPole of Feature
	(properties
		noun 3
		nsLeft 274
		nsRight 286
		nsBottom 134
		sightAngle 40
		approachX 280
		approachY 67
		approachDist 0
		x 280
		y 67
	)
)

(instance loadingSign of Feature
	(properties
		noun 4
		nsLeft 131
		nsTop 114
		nsRight 137
		nsBottom 140
		sightAngle 40
		approachX 134
		approachY 127
		approachDist 0
		x 134
		y 127
	)
)

(instance leftShops of Feature
	(properties
		noun 5
		nsLeft 1
		nsRight 51
		nsBottom 133
		sightAngle 40
		approachX 26
		approachY 66
		approachDist 0
		x 26
		y 66
	)
)

(instance rightShops of Feature
	(properties
		noun 6
		nsLeft 288
		nsTop 91
		nsRight 319
		nsBottom 125
		sightAngle 40
		approachX 303
		approachY 108
		approachDist 0
		x 303
		y 108
	)
)

(instance theater of Feature
	(properties
		noun 7
		nsLeft 68
		nsTop 22
		nsRight 275
		nsBottom 133
		sightAngle 40
		approachX 171
		approachY 77
		approachDist 0
		x 171
		y 77
	)
)

(instance leftWindow of Feature
	(properties
		noun 8
		nsLeft 74
		nsTop 91
		nsRight 112
		nsBottom 126
		sightAngle 40
		approachX 90
		approachY 135
		approachDist 30
		x 93
		y 108
	)
)

(instance rightWindow of Feature
	(properties
		noun 9
		nsLeft 211
		nsTop 91
		nsRight 251
		nsBottom 121
		sightAngle 40
		approachX 235
		approachY 133
		approachDist 30
		x 231
		y 106
	)
)

(instance leftTree of Feature
	(properties
		noun 13
		nsTop 8
		nsRight 50
		nsBottom 70
		sightAngle 40
		x 25
		y 70
	)

	(method (init)
		(self createPoly: 1 10 11 10 19 20 64 33 62 68 1 74)
		(super init:)
	)
)

(instance rightTree of Feature
	(properties
		noun 14
		nsLeft 258
		nsTop 32
		nsRight 319
		nsBottom 90
		sightAngle 40
		approachX 288
		approachY 61
		approachDist 0
		x 288
		y 90
	)

	(method (init)
		(self createPoly: 256 44 253 62 267 87 319 94 319 26 277 29)
		(super init:)
	)
)

(instance mainSign of Feature
	(properties
		noun 15
		nsLeft 98
		nsTop 48
		nsRight 225
		nsBottom 71
		sightAngle 40
		approachX 161
		approachY 59
		approachDist 0
		x 161
		y 59
	)
)

(instance otherSign of Feature
	(properties
		noun 15
		nsLeft 239
		nsRight 256
		nsBottom 71
		sightAngle 40
		approachX 247
		approachY 35
		approachDist 0
		x 247
		y 35
	)
)

(instance booth of Feature
	(properties
		noun 10
		nsLeft 142
		nsTop 90
		nsRight 176
		nsBottom 124
		sightAngle 40
		approachX 160
		approachY 137
		approachDist 0
		x 159
		y 107
	)

	(method (doVerb theVerb)
		(cond
			((< gDay 5)
				(if (== theVerb 4) ; Do
					(gCurRoom setScript: knockScript 0 2)
				else
					(super doVerb: theVerb)
				)
			)
			((> gDay 4)
				(gCurRoom newRoom: 605)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftDoor of Feature
	(properties
		noun 11
		nsLeft 113
		nsTop 91
		nsRight 142
		nsBottom 126
		sightAngle 40
		approachX 130
		approachY 134
		approachDist 0
		x 127
		y 108
	)

	(method (doVerb theVerb)
		(cond
			((< gDay 5)
				(if (== theVerb 4) ; Do
					(gCurRoom setScript: knockScript 0 1)
				else
					(super doVerb: theVerb)
				)
			)
			((> gDay 4)
				(if (== theVerb 4) ; Do
					(gCurRoom newRoom: 605)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightDoor of Feature
	(properties
		noun 12
		nsLeft 178
		nsTop 90
		nsRight 199
		nsBottom 125
		sightAngle 40
		approachX 187
		approachY 134
		approachDist 0
		x 188
		y 107
	)

	(method (doVerb theVerb)
		(cond
			((< gDay 5)
				(if (== theVerb 4) ; Do
					(gCurRoom setScript: knockScript 0 1)
				else
					(super doVerb: theVerb)
				)
			)
			((> gDay 4)
				(if (== theVerb 4) ; Do
					(gCurRoom newRoom: 605)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trunk of Feature
	(properties
		heading 90
		noun 16
		nsLeft 249
		nsTop 123
		nsRight 281
		nsBottom 141
		sightAngle 40
		approachX 293
		approachY 145
		approachDist 20
		x 265
		y 148
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; keys
				(gCurRoom setScript: toTrunkScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toTrunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom setInset: (ScriptID 28) self) ; trunkInset
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

