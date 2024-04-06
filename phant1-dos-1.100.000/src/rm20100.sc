;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20100)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm20100 0
)

(instance rm20100 of ScaryRoom
	(properties
		picture 20100
		stepSound 4
	)

	(method (drawPic param1)
		(cond
			(
				(and
					(or (== gChapter 6) (and (== gChapter 5) (IsFlag 291)))
					(== param1 20200)
					(not (IsFlag 216))
				)
				(if (gCast contains: myShimmer)
					(myShimmer show:)
				else
					(myShimmer init:)
				)
				(myShimmer setCycle: Fwd)
			)
			((gCast contains: myShimmer)
				(myShimmer hide:)
			)
		)
		(super drawPic: param1 &rest)
	)

	(method (init)
		(KillRobot)
		(gEgo init: normalize: show: setScaler: Scaler 100 47 130 98 z: 0)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(if
					(and
						(not (gCast contains: hammer))
						(not (gEgo has: 5)) ; invHammer
						(not (IsFlag 128))
					)
					(hammer init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
				)
			)
			(20200
				(self setScript: sEnterFrom20200)
			)
			(else
				(if (or 1 (IsFlag 27))
					(= picture 20290)
				)
				(self setScript: sWalkDownStairs)
			)
		)
		(upStairsExit init:)
		(if (not (IsFlag 28))
			(dustyR init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
			(dustyL init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(if (and (< gChapter 6) (not (IsFlag 33)))
			(milStone init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		)
		(super init:)
		(northExit1 init:)
		(northExit2 init:)
		(northExit3 init:)
		(northExit4 init:)
		(lantern init: cycleSpeed: 10)
		(gEgo setIntensity: 80 1)
		((ScriptID 30) init:) ; FidgetCode
		(if (and (< 2 gChapter 6) (not (IsFlag 351)))
			(if (gGDacSound handle:)
				(gGDacSound setVol: 20)
			else
				(gGDacSound number: 20026 setLoop: -1 play: setVol: 30)
			)
		)
		(global114 play: 20000)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 20200)
			(gEgo setIntensity: 100 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance dustyL of Feature
	(properties
		sightAngle 360
		approachX 145
		approachY 117
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 51 90 53 109 81 127 120 117 122 73 113 70 106 74 95 71 82 74 76 70 63 71 58 81 58 88
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: lookBarrel 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dustyR of Feature
	(properties
		sightAngle 360
		approachX 145
		approachY 117
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 72 140 112 155 108 155 98 154 96 157 90 151 89 151 78
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: lookBarrel 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance milStone of Feature
	(properties
		sightAngle 360
		approachX 175
		approachY 93
		approachDist 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 66 146 57 153 56 154 46 162 46 162 56 172 56 184 71 182 97 174 98 172 97 156 97 159 89 153 88 153 78 148 74 141 70
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sLookMilstone 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit1 of Trigger
	(properties
		approachX 175
		approachY 93
		approachDist 10
		y 1
		exitDir 1
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 155 97 155 106 150 109 202 124 206 119 200 115 199 102 183 95 175 97 167 96
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(= global201 1)
			(gCurRoom setScript: sExitNorth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit2 of Trigger
	(properties
		approachX 147
		approachY 109
		approachDist 10
		exitDir 13
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 141 112 141 135 187 136 200 125 150 109
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(= global201 2)
			(gCurRoom setScript: sExitNorth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit3 of Trigger
	(properties
		approachX 100
		approachY 122
		approachDist 10
		exitDir 13
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 82 129 121 117 121 129 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(= global201 3)
			(gCurRoom setScript: sExitNorth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance northExit4 of Trigger
	(properties
		approachX 50
		approachY 128
		approachDist 10
		exitDir 13
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 31 107 41 100 51 103 51 109 80 129 31 129
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 21) ; Do, Exit
			(= global201 4)
			(gCurRoom setScript: sExitNorth 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance myShimmer of Prop
	(properties
		x 6
		y 70
		priority 5
		view 20200
	)
)

(instance hammer of View
	(properties
		approachX 191
		approachY 106
		x 179
		y 107
		priority 4
		fixPriority 1
		view 609
		signal 26657
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 103 176 109 189 109 188 104
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sGetHammer 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance upStairsExit of Trigger
	(properties
		approachX 268
		approachY 122
		approachDist 10
		exitDir 1
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 253 38 252 121 281 127 290 101 292 101 292 33
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 21 4) ; Exit, Do
			(gCurRoom setScript: sWalkUpStairs 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lookBarrel of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 register self)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(= global115 0)
		(= global125 13)
		(gCurRoom newRoom: 20200)
		(super dispose: &rest)
	)
)

(instance sLookMilstone of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (== (gEgo x:) 187)
						(proc1111_13 register self 1)
					else
						(proc1111_13 register self)
					)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(= global115 0)
		(= global125 46)
		(= global201 4)
		(= gNewRoomNum 20200)
		(super dispose: &rest)
	)
)

(instance lantern of Actor
	(properties
		priority 4
		fixPriority 1
		view 20301
	)

	(method (init)
		(cond
			((== (gCurRoom picture:) 20100)
				(self
					view: 20100
					setScaler: Scaler 1 68 65 64
					x: 293
					y: 58
					setCycle: Fwd
				)
			)
			((== (gCurRoom picture:) 20300)
				(self
					view: 20301
					x: 118
					y: 39
					setScaler: Scaler 1 81 45 44
					setLoop: 0 1
					setCycle: Fwd
				)
			)
			((== (gCurRoom picture:) 20290)
				(self
					view: 20290
					setScaler: Scaler 1 100 47 46
					x: 128
					y: 46
					setLoop: 0 1
					setCycle: Fwd
				)
			)
			((== (gCurRoom picture:) 20230)
				(self
					view: 20230
					setScaler: Scaler 1 172 75 74
					x: 161
					y: 74
					setLoop: 1 1
					setCycle: Fwd
				)
			)
		)
		(super init: &rest)
	)
)

(instance sWalkUpStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((== (gEgo x:) 262)
							(gEgo
								setScale: 0
								setScaler: 0
								x: 115
								y: 110
								view: 7203
								cel: 0
								heading: 180
								setLoop: 0 1
							)
							(gCurRoom drawPic: 20300 picture: 20300)
							(hammer dispose:)
							(lantern init: cycleSpeed: 10)
							(= register 0)
							(= cycles 2)
						)
						(register
							(-- state)
							(proc1111_13 register self)
							(= register 0)
						)
						(else
							(gEgo
								view: 6
								normalize: 6
								heading: 45
								setScale: 0
								setScaler: 0
								x: 112
								y: 113
								cel: 0
								setLoop: 0 1
							)
							(gCurRoom drawPic: 20300 picture: 20300)
							(lantern init: cycleSpeed: 10)
							(if (gCast contains: hammer)
								(hammer dispose:)
							)
							(= register 1)
							(= cycles 2)
						)
					)
				)
				(1
					(gEgo setCycle: End self)
				)
				(2
					(if register
						(-- state)
						(gEgo
							view: 7603
							cel: 0
							setLoop: 0 1
							setCycle: End self
						)
						(= register 0)
					else
						(gEgo hide:)
						(DoRobot 540 -75 -38 gEgo -1 1)
						(gCurRoom drawPic: 20230 picture: 20230)
						(lantern init: cycleSpeed: 10)
					)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
		)
		(= global115 0)
		(gGDacSound stop:)
		(gCurRoom newRoom: 1800)
		(super dispose: &rest)
	)
)

(instance sFx of Sound
	(properties)
)

(instance sGetHammer of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load 140 20011) ; WAVE
					(proc1111_13 register self)
				)
				(1
					(hammer dispose:)
					(lantern dispose:)
					(gEgo
						setPri: -1
						view: 600
						setScale: 0
						setScaler: 0
						cel: 0
						setLoop: 0 1
						x: 252
						y: 91
						setCycle: CT 15 1 self
					)
					(gCurRoom drawPic: 20310 picture: 20310)
				)
				(2
					(sFx number: 20011 setLoop: 1 play:)
					(gEgo setCycle: End self)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(hammer dispose:)
			(KillRobot)
		)
		(= global115 0)
		(gEgo
			view: 7
			heading: 315
			normalize: 7
			setScaler: Scaler 100 47 130 98
			x: 190
			y: 109
			get: 5 ; invHammer
		)
		(gCurRoom drawPic: 20100 picture: 20100)
		(lantern init: cycleSpeed: 10)
		(SetFlag 128)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(== register northExit1)
						(OneOf (gEgo x:) 187 166)
					)
					(= global201 11)
					(proc1111_13 register self 1)
				else
					(proc1111_13 register self)
				)
			)
			(1
				(gCurRoom newRoom: 20200)
			)
		)
	)
)

(instance sWalkDownStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 472
						cel: 0
						x: 95
						y: 134
						setScaler: 0
						setScale: 0
						init:
					)
					(= register (gEgo cycleSpeed:))
					(gEgo cycleSpeed: 8)
					(lantern init: cycleSpeed: 10)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: CT 14 1 self)
				)
				(2
					(gEgo
						view: 5
						heading: 225
						cel: 9
						x: 262
						y: 125
						setScaler: Scaler 100 47 130 98
					)
					(gCurRoom drawPic: 20100 picture: 20100)
					(lantern init: cycleSpeed: 10)
					(if (and (not (gEgo has: 5)) (not (IsFlag 128))) ; invHammer
						(hammer init: approachVerbs: 0 setHotspot: 4 3 z: 0) ; Do, Move
					)
					(= cycles 2)
				)
				(3
					(gEgo setCycle: End self)
				)
				(4
					(if
						(and
							(or
								(== gChapter 6)
								(and (== gChapter 5) (IsFlag 291))
							)
							(not (IsFlag 216))
							(not (IsFlag 391))
						)
						(gCast eachElementDo: #hide)
						(gCurRoom drawPic: 20200 picture: 20200)
						(SetFlag 391)
						(= seconds 7)
					else
						(self dispose:)
					)
				)
				(5
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if
						(and
							(or
								(== gChapter 6)
								(and (== gChapter 5) (IsFlag 291))
							)
							(not (IsFlag 216))
							(not (IsFlag 391))
						)
						(gEgo setCycle: 0)
						(gCast eachElementDo: #hide)
						(gCurRoom drawPic: 20200 picture: 20200)
						(SetFlag 391)
						(= seconds 4)
					else
						(self dispose:)
					)
				)
				(1
					(self dispose:)
				)
			)
		)
	)

	(method (dispose)
		(KillRobot)
		(if
			(and
				(or (== gChapter 6) (and (== gChapter 5) (IsFlag 291)))
				(not (IsFlag 216))
				(gCast contains: myShimmer)
			)
			(gCast eachElementDo: #show)
			(gCurRoom drawPic: 20100 picture: 20100)
		)
		(if global115
			(gEgo
				view: 5
				heading: 225
				normalize: 5
				x: 262
				y: 125
				setScaler: Scaler 100 47 130 98
			)
			(gCurRoom drawPic: 20100 picture: 20100)
			(lantern init: cycleSpeed: 10)
		)
		(gEgo cycleSpeed: register)
		(= global115 0)
		(SetFlag 27)
		(if
			(and
				(not (gCast contains: hammer))
				(not (gEgo has: 5)) ; invHammer
				(not (IsFlag 128))
			)
			(hammer init: approachVerbs: 0 setHotspot: 4 3 z: 0) ; Do, Move
		)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sEnterFrom20200 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch global201
					(1
						(gEgo
							view: 4
							heading: 124
							x: 166
							y: 135
							setScaler: Scaler 100 47 130 98
							normalize: 4
							init:
							cel: 0
							setLoop: 0 1
						)
					)
					(2
						(gEgo
							view: 4
							heading: 124
							setScaler: Scaler 100 47 130 98
							normalize: 4
							init:
							x: 187
							y: 123
							cel: 0
							setLoop: 0 1
						)
						(milStone approachX: 160)
					)
					(3
						(gEgo
							view: 4
							heading: 158
							setScaler: Scaler 100 47 130 98
							normalize: 4
							init:
							x: 216
							y: 114
							setLoop: 0 1
							cel: 0
						)
						(upStairsExit approachX: 240)
					)
				)
				(if
					(and
						(not (gCast contains: hammer))
						(not (gEgo has: 5)) ; invHammer
						(not (IsFlag 128))
					)
					(hammer init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
				)
				(= global201 0)
				(= cycles 2)
			)
			(1
				(gGame handsOff:)
				(if global115
					(self dispose:)
				else
					(gEgo setCycle: End self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(gEgo cel: (gEgo lastCel:))
		)
		(= global115 0)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

