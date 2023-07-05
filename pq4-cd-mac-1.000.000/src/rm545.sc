;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 545)
(include sci.sh)
(use Main)
(use TellerIcon)
(use n045)
(use Str)
(use Print)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm545 0
	blockTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 2]
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
)

(instance rm545 of Room
	(properties
		noun 24
		picture 545
	)

	(method (doRemap)
		(gGame doRemap: 2 243 80)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(proc45_0)
		(if (OneOf gPrevRoomNum 500 6) ; speedRoom
			(gGlobalSound0 number: 983 setLoop: -1 setVol: 82 play:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 189 135 198 135 198 129 193 129 193 119 274 119 274 110 117 107 117 112 189 119
					yourself:
				)
		)
		(gGame handsOff:)
		(door init: approachVerbs: 4) ; Do
		(chair init: approachVerbs: 4) ; Do
		(desk init:)
		(floor init:)
		(banner init:)
		(poster1 init:)
		(poster2 init:)
		(poster3 init:)
		(poster4 init:)
		(poster5 init:)
		(poster6 init:)
		(poster7 init:)
		(poster8 init:)
		(poster9 init:)
		(poster10 init:)
		(poster11 init:)
		(poster12 init:)
		(poster13 init:)
		(poster14 init:)
		(poster15 init:)
		(if (== gPrevRoomNum 500)
			(gPqFlags set: 1)
			(if (not (gPqFlags test: 8))
				(gPqFlags set: 36)
			)
			(gEgo put: 43) ; parkerID
		)
		(block init:)
		(self setScript: sEnter)
		(super init: &rest)
		(proc0_4 1)
	)

	(method (newRoom)
		(gEgo stopView: 5)
		(super newRoom: &rest)
	)

	(method (cue)
		(switch (++ local15)
			(1
				(gGame intensity: 0)
				(sfx number: 32 loop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 540)
			)
		)
	)
)

(instance poster1 of Feature
	(properties
		noun 5
		nsLeft 131
		nsTop 40
		nsRight 139
		nsBottom 49
		sightAngle 40
		approachX 135
		approachY 44
		approachDist 0
		x 135
		y 44
	)

	(method (doVerb theVerb)
		(cond
			(local16
				(super doVerb: theVerb)
			)
			((and (== theVerb 1) (or (not local10) (not local11))) ; Look
				(= local10 noun)
				(= local11 theVerb)
				(gEgo setScript: lookFlyers)
			)
			((== theVerb 1) ; Look
				(gEgo setScript: lookFlyers)
			)
			((or (not local10) (not local11))
				(super doVerb: theVerb)
			)
			(else
				(= noun local10)
				(super doVerb: local11)
			)
		)
	)
)

(instance poster2 of Feature
	(properties
		noun 9
		nsLeft 150
		nsTop 40
		nsRight 160
		nsBottom 51
		sightAngle -1
		approachX 155
		approachY 45
		approachDist 0
		x 155
		y 45
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster3 of Feature
	(properties
		noun 10
		nsLeft 162
		nsTop 39
		nsRight 169
		nsBottom 48
		sightAngle 40
		approachX 165
		approachY 43
		approachDist 0
		x 165
		y 43
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster4 of Feature
	(properties
		noun 11
		nsLeft 174
		nsTop 39
		nsRight 182
		nsBottom 48
		sightAngle 40
		approachX 178
		approachY 43
		approachDist 0
		x 178
		y 43
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster5 of Feature
	(properties
		noun 12
		nsLeft 184
		nsTop 40
		nsRight 192
		nsBottom 50
		sightAngle 40
		approachX 188
		approachY 45
		approachDist 0
		x 188
		y 45
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster6 of Feature
	(properties
		noun 14
		nsLeft 196
		nsTop 39
		nsRight 205
		nsBottom 50
		sightAngle 40
		approachX 200
		approachY 44
		approachDist 0
		x 200
		y 44
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster7 of Feature
	(properties
		noun 15
		nsLeft 207
		nsTop 39
		nsRight 216
		nsBottom 51
		sightAngle 40
		approachX 211
		approachY 45
		approachDist 0
		x 211
		y 45
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster8 of Feature
	(properties
		noun 16
		nsLeft 127
		nsTop 55
		nsRight 137
		nsBottom 66
		sightAngle 40
		approachX 132
		approachY 60
		approachDist 0
		x 132
		y 60
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster9 of Feature
	(properties
		noun 17
		nsLeft 139
		nsTop 54
		nsRight 147
		nsBottom 68
		sightAngle 40
		approachX 143
		approachY 61
		approachDist 0
		x 143
		y 61
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster10 of Feature
	(properties
		noun 18
		nsLeft 149
		nsTop 52
		nsRight 159
		nsBottom 65
		sightAngle 40
		approachX 154
		approachY 58
		approachDist 0
		x 154
		y 58
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster11 of Feature
	(properties
		noun 19
		nsLeft 161
		nsTop 53
		nsRight 170
		nsBottom 66
		sightAngle 40
		approachX 165
		approachY 59
		approachDist 0
		x 165
		y 59
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster12 of Feature
	(properties
		noun 20
		nsLeft 174
		nsTop 54
		nsRight 182
		nsBottom 65
		sightAngle 40
		approachX 178
		approachY 59
		approachDist 0
		x 178
		y 59
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster13 of Feature
	(properties
		noun 21
		nsLeft 184
		nsTop 53
		nsRight 194
		nsBottom 67
		sightAngle 40
		approachX 189
		approachY 60
		approachDist 0
		x 189
		y 60
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster14 of Feature
	(properties
		noun 22
		nsLeft 195
		nsTop 51
		nsRight 205
		nsBottom 64
		sightAngle 40
		approachX 200
		approachY 57
		approachDist 0
		x 200
		y 57
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance poster15 of Feature
	(properties
		noun 13
		nsLeft 206
		nsTop 52
		nsRight 215
		nsBottom 66
		sightAngle 40
		approachX 210
		approachY 59
		approachDist 0
		x 210
		y 59
	)

	(method (doVerb theVerb)
		(if local16
			(super doVerb: theVerb)
		else
			(= local10 noun)
			(= local11 theVerb)
			(poster1 doVerb: theVerb)
		)
	)
)

(instance door of Feature
	(properties
		noun 7
		nsLeft 228
		nsTop 23
		nsRight 271
		nsBottom 105
		sightAngle 40
		approachX 233
		approachY 109
		approachDist 0
		x 249
		y 64
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(self onMe: event)
				(== (event message:) JOY_DOWNRIGHT)
			)
			(if (& (gEgo signal:) $0800)
				(self doVerb: (event message:))
				(event claimed: 1)
				(return)
			else
				(getToWork state: 2 ticks: 0 cue:)
				(super handleEvent: event)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((& (gEgo signal:) $0800)
						(super doVerb: theVerb)
					)
					((and (== gDay 5) (not (gPqFlags test: 158)))
						(if local6
							(gPqFlags set: 158)
							(gGame
								intensity: 100
								fade: 100 0 (gGame fadeSpeed:) gCurRoom
							)
						else
							(gMessager say: 1 2 39) ; "Carey, I'm not finished with you yet..."
						)
					)
					(else
						(gGame
							intensity: 100
							fade: 100 0 (gGame fadeSpeed:) gCurRoom
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance banner of Feature
	(properties
		noun 8
		nsLeft 119
		nsTop 4
		nsRight 209
		nsBottom 19
		x 155
		y 4
	)
)

(instance desk of Feature
	(properties
		noun 4
		x 148
		y 130
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 120 85 174 88 173 127 142 148 41 148 44 115 112 89
					yourself:
				)
		)
	)
)

(instance floor of Feature
	(properties
		noun 6
		x 226
		y 128
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 175 105 276 106 276 147 144 147 175 128
					yourself:
				)
		)
	)
)

(instance blockTeller of Teller
	(properties)

	(method (showCases)
		(super
			showCases:
				22
				(!= gDay 5)
				21
				(!= gDay 5)
				23
				(!= gDay 5)
				24
				(!= gDay 5)
				36
				(and (not local6) (== gDay 5))
				37
				(and (not local6) (== gDay 5))
		)
	)

	(method (sayMessage)
		(if (or (== iconValue 36) (== iconValue 37))
			(if (== iconValue 36)
				(gGame points: 4)
			else
				(gGame points: 5)
			)
			(doDay5 cue:)
			(= local6 1)
		)
		(super sayMessage:)
	)
)

(instance block of Prop
	(properties
		noun 1
		x 104
		y 131
		z 30
		priority 140
		fixPriority 1
		view 545
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (and (== gDay 5) (== theVerb 2) (not local6)) ; Talk
			(gMessager say: 1 2 33) ; "Lieutenant, it's not my fault,... I mean, it's that reporter. She's always stirring things up. She's making my job impossible."
			(blockTeller init: self 545 2 5)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance chair of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 195
		approachY 135
		approachDist 0
		x 190
		y 135
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 209 93 233 94 238 83 246 85 242 99 248 137 239 128 238 118 213 118 209 136 205 126 208 115 203 107 204 103 209 102
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gEgo script:))
					(gEgo setScript: sitDown)
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

(instance bobbyTell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gPqFlags clear: 36)
				(gMessager say: 1 0 20 0 self) ; "Carey, I have information about the child found this morning in the convenience store dumpster."
			)
			(2
				(blockTeller init: block 545 2 5)
				(self dispose:)
			)
		)
	)
)

(instance blockTalker of Narrator
	(properties
		x 50
		y 15
		modeless 2
	)
)

(instance chewOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= cycles 2)
			)
			(1
				1
				(if (gPqPointFlags test: 6)
					(= register 25)
				else
					(= register 26)
				)
				(= local2 1)
				(= local3 5)
				(self setScript: (chewYak new:) 0 register)
				(= global124 1)
				(= gDay 2)
				(block cycleSpeed: 8 setCycle: End self)
			)
			(2
				2
				(block loop: 1 cel: 0 setCycle: End self)
			)
			(3
				3
				(block loop: 2 cel: 0 setCycle: End self)
			)
			(4
				4
				(block setCycle: Fwd)
				(if script
					(script caller: self)
				else
					(self cue:)
				)
			)
			(5
				(block setCycle: 0)
				(gEgo setCycle: End self)
			)
			(6
				5
				(= local2 6)
				(= local3 11)
				(self setScript: (chewYak new:) 0 register)
				(gEgo setCycle: Beg self)
				(block setCycle: Fwd)
			)
			(7
				(if script
					(script caller: self)
				else
					(self cue:)
				)
			)
			(8
				(block setCycle: 0)
				(gEgo setCycle: End self)
			)
			(9
				(gMessager say: 1 0 register 12 self)
			)
			(10
				(= local2 13)
				(= local3 0)
				(self setScript: (chewYak new:) 0 register)
				(block view: 547 loop: 0 cel: 0 setCycle: End self)
			)
			(11
				(block setCycle: Beg self)
			)
			(12
				(block view: 545 loop: 0 cel: 0 setCycle: Fwd)
				(if script
					(script caller: self)
				else
					(self cue:)
				)
			)
			(13
				(block setCycle: 0)
				(gEgo view: 9545 setLoop: 0 1)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(14
				(gEgo stopView: 9125)
				(gEgo
					heading: 270
					setPri: -1
					normalize: 9120 1
					setScaler: Scaler 91 66 133 105
				)
				(self dispose:)
			)
		)
	)
)

(instance chewOut2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= ticks 120)
			)
			(1
				1
				(= register 4)
				(gPqFlags set: 16)
				(= local2 1)
				(= local3 0)
				(self setScript: (chewYak new:) self register)
				(block cycleSpeed: 8 setCycle: End)
			)
			(2
				2
				(block loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 1 0 register 2 self)
			)
			(4
				(= local2 3)
				(= local3 4)
				(self setScript: (chewYak new:) 0 register)
				(block loop: 2 cel: 0 setCycle: End self)
			)
			(5
				4
				(block setCycle: Fwd)
				(if script
					(script caller: self)
				else
					(self cue:)
				)
			)
			(6
				(block setCycle: 0)
				(gMessager say: 1 0 register 5 self)
			)
			(7
				5
				(= local2 6)
				(= local3 0)
				(self setScript: (chewYak new:) self register)
				(block setCycle: Fwd)
			)
			(8
				(block setCycle: 0)
				(gMessager say: 1 0 register 8 self)
			)
			(9
				(gMessager say: 1 0 register 9 self)
				(block setCycle: Fwd)
			)
			(10
				(block setCycle: 0)
				(gMessager say: 1 0 register 10 self)
			)
			(11
				5
				(= local2 11)
				(= local3 18)
				(self setScript: (chewYak new:) self register)
				(block setCycle: Fwd)
			)
			(12
				(block setCycle: 0)
				(gMessager say: 1 0 register 19 self)
			)
			(13
				5
				(= local2 20)
				(= local3 23)
				(self setScript: (chewYak new:) self register)
				(block setCycle: Fwd)
			)
			(14
				(block setCycle: Beg self)
			)
			(15
				(gEgo setCycle: Beg self)
			)
			(16
				(gEgo stopView: 9125)
				(gEgo
					heading: 270
					setPri: -1
					normalize: 9120 1
					setScaler: Scaler 91 66 133 105
				)
				(self dispose:)
			)
		)
	)
)

(instance getToWork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 900 1200))
			)
			(1
				(if (or local9 (gTalkers size:) (Print dialog:))
					(-- state)
				else
					(= local17 1)
				)
				(= ticks 90)
			)
			(2
				(gMessager sayRandom: 1 0 2 self)
			)
			(3
				(= local17 0)
				(self init:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(block
			cel:
				(- 10 (/ (GetAngle 103 95 (gEgo x:) (- (gEgo y:) 80)) 10))
		)
	)

	(method (init)
		(if argc
			(block view: 549 loop: 0 cycleSpeed: 8 cel: 0)
		)
		(super init: &rest)
	)
)

(instance doDay5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 32 0 self) ; "I'm glad you're here, Carey... I wanted to talk to you about your newest TV appearance."
			)
			(2
				(gGame handsOn:)
			)
			(3
				(blockTeller dispose:)
				(client setScript: getToWork)
			)
		)
	)

	(method (doit)
		(super doit:)
		(block
			cel:
				(- 10 (/ (GetAngle 103 95 (gEgo x:) (- (gEgo y:) 80)) 10))
		)
	)

	(method (init)
		(if argc
			(block view: 549 cycleSpeed: 8 loop: 0 cel: 0)
		)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 500)
					(if (== gDay 3)
						(gEgo view: 9545 setLoop: 0 1)
						(gEgo
							cel: (gEgo lastCel:)
							x: 195
							y: 135
							setPri: 135
							setScaler: Scaler 91 66 133 105
							heading: 270
							init:
						)
						(self setScript: chewOut2 self)
					else
						(gEgo
							view: 9546
							setLoop: 0 1
							cel: 0
							x: 195
							y: 135
							setPri: 135
							setScaler: Scaler 91 66 133 105
							heading: 270
							init:
						)
						(= global124 1)
						(self setScript: chewOut self)
					)
				else
					(gEgo stopView: 9125)
					(gEgo
						x: 235
						y: 108
						setHeading: 180
						setScaler: Scaler 91 66 133 105
						normalize: 9120 1
						init:
						setMotion: MoveTo 235 120
					)
					(cond
						((and (gPqFlags test: 36) (!= global124 1))
							(self setScript: bobbyTell self)
						)
						((and (== gDay 5) (not (gPqFlags test: 158)))
							(= local5 1)
							(client setScript: doDay5)
						)
						(else
							(= next blockOnPhone)
							(self dispose:)
						)
					)
				)
				(sfx number: 33 loop: 1 play:)
			)
			(1
				(gGame handsOn:)
				(if (== gPrevRoomNum 500)
					(client setScript: getToWork)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance lookFlyers of Script
	(properties)

	(method (doit)
		(if (and (== state 1) local14 (not (Print dialog:)))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or local17 (gTalkers size:) (Print dialog:))
					(-- state)
					(= local14 0)
					(= ticks 60)
				else
					(= local9 1)
					(= ticks 90)
				)
			)
			(1
				(if (not local13)
					(= local13 (Str newWith: 400 {}))
				)
				(Message msgGET 545 local10 local11 0 1 (local13 data:))
				(= local14 (local13 size:))
				(= ticks (Max 240 (* (/ (* 24 local14) 10) gTextSpeed)))
				(proc45_1)
				(Print
					fore: 28
					back: -1
					shadowText: 1
					modeless: 2
					addText: local13
					plane: (ScriptID 0 5) ; transPlane
					init:
				)
				(local13 dispose:)
			)
			(2
				(if (Print dialog:)
					((Print dialog:) dispose:)
				)
				(proc45_2)
				(= local11 0)
				(= local10 0)
				(= local13 0)
				(= cycles 2)
			)
			(3
				(= local9 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blockOnPhone of Script
	(properties)

	(method (init)
		(if argc
			(block view: 550 loop: 1 cycleSpeed: 8 cel: 0)
			(UpdateScreenItem block)
		)
		(super init: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (gEgo x:))
				(cond
					((> (gEgo y:) 121)
						(= register 3)
					)
					((< temp0 127)
						(= register 8)
					)
					((< temp0 134)
						(= register 7)
					)
					((< temp0 148)
						(= register 6)
					)
					((< temp0 174)
						(= register 5)
					)
					((< temp0 200)
						(= register 4)
					)
					(else
						(= register 3)
					)
				)
				(block loop: 1 setCycle: CT register 1 self)
			)
			(1
				(= cycles 2)
				(= local12 (Random 0 5))
			)
			(2
				(if (or local9 (gTalkers size:) (Print dialog:))
					(-- state)
					(= ticks 90)
				else
					(gGame handsOff:)
					(= local17 1)
					(= ticks 90)
				)
			)
			(3
				(if (or local9 (gTalkers size:) (Print dialog:))
					(-= state 2)
					(= local17 0)
					(= ticks 90)
				else
					(if (> (++ local12) 6)
						(= local12 1)
					)
					(gMessager say: 1 0 9 local12 self)
				)
			)
			(4
				(block setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(= state -1)
				(= local17 0)
				(self setScript: yak self (Random 1 3))
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local16 1)
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo
					view: 9545
					setLoop: 0 1
					cel: 0
					setScaler: 0
					heading: 270
					setPri: 135
					setCycle: End self
				)
			)
			(2
				(gGame handsOn:)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (init)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(= local0 (event x:))
			(= local1 (event y:))
			(self setScript: standUp self)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local16 0)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					heading: 270
					setPri: -1
					normalize: 9120 1
					setScaler: Scaler 91 66 133 105
				)
				(self dispose:)
			)
		)
	)
)

(instance yak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(block loop: 0 cycleSpeed: 8 setCycle: Fwd)
				(= ticks (Random 50 120))
			)
			(1
				(block setCycle: End self)
			)
			(2
				(if (or local9 (gTalkers size:) (Print dialog:))
					(-- state)
				else
					(= local17 1)
				)
				(= ticks 90)
			)
			(3
				(gMessager sayRandom: 1 0 29 self)
			)
			(4
				(= ticks 90)
			)
			(5
				(= local17 0)
				(if (-- register)
					(= state -1)
					(= ticks (Random 100 200))
				else
					(block setCycle: Beg self)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance chewYak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or local9 (gTalkers size:) (Print dialog:))
					(-- state)
				else
					(= local4 0)
					(= local17 1)
				)
				(= ticks 90)
			)
			(1
				(if local3
					(gMessager sayRange: 1 0 register local2 local3 self)
				else
					(gMessager say: 1 0 register local2 self)
				)
			)
			(2
				(= ticks 90)
			)
			(3
				(= local4 1)
				(= local17 0)
				(self dispose:)
			)
		)
	)
)

