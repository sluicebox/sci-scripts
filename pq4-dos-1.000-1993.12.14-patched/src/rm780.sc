;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
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
	rm780 0
)

(local
	local0
	local1
	local2
)

(instance rm780 of Room
	(properties
		picture 780
		style 0
	)

	(method (init)
		(proc0_4 0)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 11 150 308 150 308 134 246 134 217 119 97 119 97 115 86 115 86 120 209 120 215 126 194 130 197 138 11 138
					yourself:
				)
		)
		(sky init:)
		(yard init:)
		(house init:)
		(street init:)
		(leftHouse init:)
		(rightHouse init:)
		(leftWindow init:)
		(rightWindow init:)
		(leftFlowers init:)
		(rightFlowers init:)
		(switch gPrevRoomNum
			(785
				(gEgo
					setHeading: 180
					normalize: 0
					posn: 93 120 0
					setScaler: Scaler 82 28 159 99
					init:
				)
				(gGame handsOn:)
				(tweets play:)
			)
			(790
				(gEgo
					setHeading: 180
					normalize: 0
					posn: 93 120 0
					setScaler: Scaler 82 28 159 99
					init:
				)
				(if
					(and
						(== gDay 3)
						(gPqFlags test: 7)
						(gPqPointFlags test: 32)
						(gPqFlags test: 105)
						(gPqFlags test: 92)
					)
					(self setScript: leaveScr)
				else
					(gGame handsOn:)
				)
				(tweets play:)
			)
			(else
				(gGame intensity: 0)
				(self setScript: enterScr)
				(gEgo
					setHeading: 270
					normalize: 0
					posn: 223 124 0
					setScaler: Scaler 82 28 159 99
					init:
				)
			)
		)
		(if (gPqFlags test: 29)
			(= local2 1)
			(PalVary 8 780) ; PalVaryNewSource
		)
		(car init: signal: (| (car signal:) $4000))
		(trunk init: approachVerbs: 4 46) ; Do, keys
		(door init: signal: (| (door signal:) $4000))
		(gTheIconBar show: 0)
		(super init: &rest)
	)

	(method (dispose)
		(if local2
			(PalVary 3) ; PalVaryKill
		)
		(super dispose:)
	)

	(method (doit)
		(if (< (gEgo y:) 122)
			(gEgo scaleSignal: (| (gEgo scaleSignal:) $0004) xStep: 2)
		)
		(if (> (gEgo y:) 121)
			(gEgo scaleSignal: (& (gEgo scaleSignal:) $fffb))
		)
		(super doit:)
		(cond
			(script 0)
			((and (gEgo inRect: 71 113 114 116) (not local0))
				(self newRoom: 785)
			)
			((< (gEgo x:) 20)
				(gGame handsOff:)
				(gCurRoom setScript: cantLeaveScr 0 1)
			)
			((> (gEgo x:) 300)
				(gGame handsOff:)
				(gCurRoom setScript: cantLeaveScr 0 -1)
			)
		)
	)
)

(instance tweets of Sound
	(properties
		number 1028
		loop -1
	)
)

(instance sndFx of Sound
	(properties)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 number: 190 loop: 1 play:)
				(sndFx number: 916 play:)
				(= seconds 3)
			)
			(1
				(sndFx number: 917 play:)
				(= seconds 3)
			)
			(2
				(gGame intensity: 100 fade: 0 100 (gGame fadeSpeed:))
				(tweets play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance trunk of Feature
	(properties
		noun 11
		approachX 274
		approachY 134
		x 275
		y 107
	)

	(method (init)
		(self
			createPoly: 295 102 303 106 303 116 300 125 255 125 255 108 249 102
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb 0) ; "Your car trunk is locked."
			)
			((== theVerb 46) ; keys
				(gCurRoom setScript: trunkScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trunkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom setInset: (ScriptID 28) self) ; trunkInset
			)
			(1
				(if local2
					(PalVary 8 780) ; PalVaryNewSource
				)
				(self dispose:)
			)
		)
	)
)

(instance car of View
	(properties
		noun 2
		x 277
		y 105
		z -20
		priority 50
		fixPriority 1
		view 779
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: enterCarScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance enterCarScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 223 124 self)
			)
			(2
				(gCurRoom newRoom: 17) ; MapRoom
			)
		)
	)
)

(instance leaveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 223 124 self)
			)
			(2
				(gPqFlags set: 20)
				(gCurRoom newRoom: 900)
			)
		)
	)
)

(instance cantLeaveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 7) ; "Don't wander off. There's work to be done!"
				(= cycles 2)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(+ (gEgo x:) (* 20 register))
						(gEgo y:)
						self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sky of Feature
	(properties
		noun 3
		y 10
	)

	(method (init)
		(self
			createPoly: 319 10 319 27 295 27 286 44 288 47 294 48 288 62 268 41 178 41 137 16 135 16 98 40 52 40 29 56 7 54 0 47 0 10
		)
		(super init: &rest)
	)
)

(instance house of Feature
	(properties
		noun 4
		y 20
	)

	(method (init)
		(self
			createPoly: 180 42 268 41 294 68 288 73 287 110 187 111 172 111 170 108 104 109 103 72 85 71 85 113 30 109 27 73 16 66 53 40 99 40 137 17
		)
		(super init: &rest)
	)
)

(instance yard of Feature
	(properties
		noun 5
		y 30
	)

	(method (init)
		(self
			createPoly: 29 109 27 119 76 119 82 114 101 114 103 119 206 119 197 111 288 110 290 80 310 79 311 91 319 91 319 135 199 137 0 136 0 86 21 86 20 75 27 74
		)
		(super init: &rest)
	)
)

(instance leftFlowers of Feature
	(properties
		noun 9
		x 48
		y 117
	)

	(method (init)
		(self createPoly: 31 109 70 110 80 115 76 118 28 118)
		(super init: &rest)
	)
)

(instance rightFlowers of Feature
	(properties
		noun 9
		x 148
		y 117
	)

	(method (init)
		(self
			createPoly: 170 109 172 112 197 112 206 118 105 118 102 113 105 109
		)
		(super init: &rest)
	)
)

(instance rightWindow of Feature
	(properties
		noun 12
		x 136
		y 101
	)

	(method (init)
		(self createPoly: 122 73 150 73 150 101 122 101)
		(super init: &rest)
	)
)

(instance leftWindow of Feature
	(properties
		noun 12
		x 50
		y 101
	)

	(method (init)
		(self createPoly: 35 72 66 72 66 101 36 101)
		(super init: &rest)
	)
)

(instance street of Feature
	(properties
		noun 6
		y 40
	)

	(method (init)
		(self createPoly: 176 138 319 136 319 153 0 153 0 137)
		(super init: &rest)
	)
)

(instance leftHouse of Feature
	(properties
		noun 7
		y 50
	)

	(method (init)
		(self createPoly: 7 54 29 56 16 66 28 73 20 75 20 85 0 84 0 48)
		(super init: &rest)
	)
)

(instance rightHouse of Feature
	(properties
		noun 8
		y 60
	)

	(method (init)
		(self
			createPoly: 319 91 313 91 311 78 290 81 289 72 294 68 290 63 295 49 288 46 296 28 319 28
		)
		(super init: &rest)
	)
)

(instance door of Prop
	(properties
		noun 1
		approachX 92
		approachY 110
		x 84
		y 74
		view 7893
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if (not cel)
					(gGame handsOff:)
					(gCurRoom setScript: goDoorScr)
				)
			)
			(
				(and
					(== theVerb 14) ; hickmanStuff
					(or
						(> gDay 3)
						(and
							(== gDay 3)
							(or
								(gPqFlags test: 7)
								(not (gEgo has: 0)) ; funeralMemo
								(not (gPqPointFlags test: 32))
								(not (gPqFlags test: 105))
								(not (gPqFlags test: 92))
							)
						)
					)
				)
				(gMessager say: noun theVerb 2 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kath of Prop
	(properties
		x 94
		y 112
		priority 6
		fixPriority 1
		view 780
	)
)

(instance val of Prop
	(properties
		x 96
		y 112
		priority 6
		fixPriority 1
		view 784
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(val setScript: 0 setCycle: 0)
				(gGame handsOff:)
				(gTheIconBar enable: 0)
				(gCurRoom newRoom: 790)
			)
			((OneOf theVerb 4 19 14 57 20) ; Do, apple, hickmanStuff, photo, wallet
				(gMessager say: 1 theVerb 4 0)
			)
			((== theVerb 22) ; handgun
				(cond
					((not local1)
						(gMessager say: 10 22 8) ; MISSING MESSAGE
						(++ local1)
					)
					(((ScriptID 32 0) doit: 10 22 9 780) 0) ; ShootHandgun
				)
			)
			((== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
				(gMessager say: 1 6 4 0) ; MISSING MESSAGE
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gPqFlags set: 4)
				(gEgo
					setMotion: PolyPath (door approachX:) (door approachY:) self
				)
			)
			(1
				(if local0
					(self setScript: knockSubScr self)
				else
					(gCurRoom newRoom: 785)
				)
			)
			(2
				(switch gDay
					(2
						(if (gPqFlags test: 6)
							(self setScript: knockDoor4Scr)
						else
							(self setScript: knockDoor1Scr)
						)
					)
					(3
						(if (or (gPqFlags test: 7) (not (gEgo has: 0))) ; funeralMemo
							(self setScript: knockDoor2Scr)
						else
							(self setScript: knockDoor3Scr)
						)
					)
					(else
						(self setScript: knockDoor2Scr)
					)
				)
			)
		)
	)
)

(instance knockDoor1Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door cel: 1)
				(val init: signal: (| (val signal:) $4000) cel: 0)
				(= cycles (val cycleSpeed:))
			)
			(1
				(sndFx number: 978 play:)
				(door cel: 2)
				(val cel: 2)
				(= cycles (val cycleSpeed:))
			)
			(2
				(door cel: 3)
				(val cel: 4)
				(= cycles (val cycleSpeed:))
			)
			(3
				(door cel: 4)
				(val cel: 7)
				(= cycles (val cycleSpeed:))
			)
			(4
				(door cel: 5)
				(val cel: 11)
				(= cycles (val cycleSpeed:))
			)
			(5
				(gMessager say: 1 0 4 0) ; MISSING MESSAGE
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(val setScript: waitScr)
				(self dispose:)
			)
		)
	)
)

(instance waitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(gGame handsOff:)
				(door cel: 4)
				(val cel: 7)
				(= cycles (val cycleSpeed:))
			)
			(2
				(door cel: 3)
				(val cel: 4)
				(= cycles (val cycleSpeed:))
			)
			(3
				(door cel: 2)
				(val cel: 2)
				(= cycles (val cycleSpeed:))
			)
			(4
				(door cel: 1)
				(val hide:)
				(= cycles (val cycleSpeed:))
			)
			(5
				(sndFx number: 979 play:)
				(door cel: 0)
				(val dispose:)
				(gGame handsOn:)
				(gTheIconBar enable: 0)
				(self dispose:)
			)
		)
	)
)

(instance knockDoor2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gMessager say: 1 4 2 0) ; "It appears no one is home at this time."
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockDoor3Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sndFx number: 978 play:)
				(door cel: 1)
				(= cycles 5)
			)
			(1
				(door cel: 2)
				(kath init: signal: (| (kath signal:) $4000) cel: 1)
				(= cycles (kath cycleSpeed:))
			)
			(2
				(door cel: 3)
				(kath cel: 4)
				(= cycles (kath cycleSpeed:))
			)
			(3
				(door cel: 4)
				(kath cel: 6)
				(= cycles (kath cycleSpeed:))
			)
			(4
				(door cel: 5)
				(kath cel: 11)
				(= cycles (kath cycleSpeed:))
			)
			(5
				(= seconds 2)
			)
			(6
				(gCurRoom newRoom: 790)
			)
		)
	)
)

(instance knockDoor4Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door cel: 1)
				(val init: signal: (| (val signal:) $4000) cel: 0)
				(= cycles (val cycleSpeed:))
			)
			(1
				(sndFx number: 978 play:)
				(door cel: 2)
				(val cel: 2)
				(= cycles (val cycleSpeed:))
			)
			(2
				(door cel: 3)
				(val cel: 4)
				(= cycles (val cycleSpeed:))
			)
			(3
				(door cel: 4)
				(val cel: 7)
				(= cycles (val cycleSpeed:))
			)
			(4
				(door cel: 5)
				(val cel: 11)
				(= cycles (val cycleSpeed:))
			)
			(5
				(gMessager say: 1 0 3 0 self) ; "My mommy feels sick. She says no visitors."
			)
			(6
				(door cel: 4)
				(val cel: 7)
				(= cycles (val cycleSpeed:))
			)
			(7
				(door cel: 3)
				(val cel: 4)
				(= cycles (val cycleSpeed:))
			)
			(8
				(door cel: 2)
				(val cel: 2)
				(= cycles (val cycleSpeed:))
			)
			(9
				(door cel: 1)
				(val dispose:)
				(= cycles (val cycleSpeed:))
			)
			(10
				(sndFx number: 979 play:)
				(door cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockSubScr of Script
	(properties)

	(method (doit)
		(if (and (== (gEgo view:) 9008) (OneOf (gEgo cel:) 5 8 11))
			(sndFx play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sndFx number: 998)
				(= cycles 2)
			)
			(1
				(gEgo view: 9008 setLoop: 0 cel: 0 setCycle: End self)
				(= register
					((Prop new:)
						view: 9008
						loop: 1
						posn: (gEgo x:) (gEgo y:) 0
						init:
						setScaler: gEgo
						yourself:
					)
				)
			)
			(2
				(gMessager say: 1 4 0 0) ; "Knocking seems less intrusive than ringing the doorbell."
				(gEgo cel: 3 setCycle: Beg self)
			)
			(3
				(= cycles 1)
			)
			(4
				(gEgo setHeading: 0 normalize: 0)
				(register dispose:)
				(= seconds 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

