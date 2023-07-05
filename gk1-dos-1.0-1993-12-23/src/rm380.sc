;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use sHRoom8)
(use Array)
(use Talker)
(use Scaler)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm380 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm380 of Room
	(properties
		noun 1
		picture 380
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 380)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 144 144 310 132 287 103 226 103 229 115 226 129 191 131 181 128 174 114 92 113 91 111 75 110 51 120 66 122 54 130 18 146
					yourself:
				)
		)
		(gEgo
			view: 900
			signal: (| (gEgo signal:) $1000)
			scaleSignal: (| (gEgo scaleSignal:) $0004)
			state: 2
			setCycle: StopWalk -1
			ignoreActors: 1
			setScaler: Scaler 100 94 108 102
		)
		(if (and (!= gPrevRoomNum 50) (!= gPrevRoomNum 390)) ; interrogation
			(gGkMusic1
				number: 380
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(cond
			((== gPrevRoomNum 390)
				(= gNarrator grannyNarrator)
				(gEgo init: posn: 234 102 setMotion: PolyPath 234 120)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 78 126 75 121 81 114 101 115 122 115 126 119 113 126 97 127
							yourself:
						)
				)
			)
			((== gPrevRoomNum 50) ; interrogation
				(= gNarrator grannyNarrator)
				(gEgo view: 381 setCel: 5 setLoop: 0 init: posn: 175 117)
				(= local0 1)
			)
		)
		(clock init:)
		(chair init:)
		(firePlace init:)
		(oilLamp init:)
		(flowers init:)
		(grandmaPic init:)
		(grandpaPic init:)
		(knitBasket init:)
		(magazineBin init:)
		(miscPhotos init:)
		(light init:)
		(tree init:)
		(sofa init:)
		(stairs init:)
		(tableLamp init:)
		(woodBin init:)
		(frontDoor init:)
		(oilLampFlame init:)
		(oilLampReflection init:)
		(oilLampReflection2 init:)
		(granny init:)
		(Load rsVIEW 382)
		(Load rsVIEW 384)
		(Load rsVIEW 386)
		(gWalkHandler add: stairs)
		(gWalkHandler add: self)
		(if (and (!= gPrevRoomNum 50) (!= gPrevRoomNum 390)) ; interrogation
			(gCurRoom setScript: egoEnters)
		)
		(= local2 (IntArray with: 3 5 6 7))
	)

	(method (dispose)
		(local2 dispose:)
		(if (and (!= gNewRoomNum 50) (!= gNewRoomNum 390)) ; interrogation
			(gGkMusic1 fade:)
		)
		(= gNarrator GKNarrator)
		(gEgo setPri: -1 setScale: 0)
		(if (not (IsFlag 203))
			(SetFlag 203)
		)
		(gWalkHandler delete: stairs)
		(gWalkHandler delete: self)
		(DisposeScript 64935)
		(DisposeScript 64939)
		(DisposeScript 64941)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local0
					(gEgo setScript: standUp)
					(return 1)
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

(instance grannyNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self
			fore: global220
			back: global214
			font: gUserFont
			talkWidth: 314
			x: 0
			y: 157
		)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(26 47)
				(else global220)
			)
		)
		(switch global180
			(1
				(cond
					((and (== global180 1) (== (gEgo view:) 381))
						(= local6 (gEgo cycleSpeed:))
						(= temp0 381)
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: 2
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					)
					((== (gEgo view:) 901)
						(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
							(= temp0 (+ (gEgo view:) 1000))
						else
							(if (== (gEgo view:) 900)
								(= temp0
									(+ (gEgo view:) 1010 (gEgo cel:))
								)
							else
								(= temp0
									(+ (gEgo view:) 1039 (gEgo cel:))
								)
							)
							(switch (Random 0 2)
								(0 1)
								(1
									(+= temp0 10)
								)
								(2
									(= temp0 (+ (gEgo view:) 1000))
								)
							)
						)
						(= local6 (gEgo cycleSpeed:))
						(= temp1 (gEgo cel:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: temp1
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
						)
						(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
							(gEgo setCycle: ForRepeat)
						else
							(gEgo setCycle: Fwd)
						)
					)
				)
			)
			(26
				(if (not (== (granny script:) knitAway))
					(granny
						view: 384
						setCel: 0
						setLoop: 1
						cycleSpeed: 9
						setCycle: RandCycle (* (param1 size:) 4) 0 1
					)
					(= local1 1)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if local1
			(granny setLoop: 0 setCel: 4 setCycle: 0)
			(= local1 0)
		)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setCel: (gEgo oldCel:)
				talking: 0
				cycleSpeed: local6
			)
			(if (== (gEgo view:) 381)
				(gEgo setCycle: 0 setLoop: (gEgo oldLoop:) 1)
			else
				(gEgo setCycle: StopWalk -1 setLoop: (gEgo oldLoop:))
			)
		)
		(super dispose:)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(knitAway dispose:)
				(if (IsFlag 203)
					(= local3 (Random 0 3))
				)
				(= cycles 5)
			)
			(1
				(gGkSound1 number: 381 setLoop: 1 play:)
				(granny view: 385 setCel: 7 setLoop: 0 setCycle: Beg self)
			)
			(2
				(granny view: 384 setCel: 4 setLoop: 0 setCycle: Beg self)
			)
			(3
				(granny
					view: 382
					setPri: 4
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 75 118 self
				)
			)
			(4
				(granny view: 386 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(5
				(if (IsFlag 203)
					(gMessager say: 20 0 (local2 at: local3) 1 self)
				else
					(gMessager say: 20 0 2 1 self) ; "Gabriel! I'm so glad you stopped by!"
				)
			)
			(6
				(granny view: 386 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(7
				(gEgo
					init:
					setPri: 3
					ignoreActors: 1
					setLoop: 0 1
					posn: 30 114
					setMotion: MoveTo 101 117 self
				)
			)
			(8
				(if (IsFlag 203)
					(gMessager say: 20 0 (local2 at: local3) 2 self)
				else
					(gMessager say: 20 0 2 2 self) ; "Sorry it's been a while, Grandma."
				)
			)
			(9
				(gGkSound1 number: 373 setLoop: 1 play:)
				(Face gEgo granny)
				(granny view: 386 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(10
				(if (IsFlag 203)
					(gMessager say: 20 0 (local2 at: local3) 3)
				else
					(gMessager say: 20 0 2 3) ; "Not at all! Give us a kiss."
				)
				(granny view: 382 setCycle: StopWalk -1)
				(Face granny gEgo self)
			)
			(11
				(= cycles 2)
			)
			(12
				(granny view: 383 setCel: 0 setLoop: 3 setCycle: Osc 1 self)
				(gEgo hide:)
				(UpdateScreenItem granny)
			)
			(13
				(if (not (IsFlag 203))
					(gMessager say: 20 0 2 4) ; "Now come and sit down! Tell me how you're doing!"
				)
				(gEgo
					show:
					posn: 100 118
					setCycle: StopWalk -1
					setMotion: PolyPath 175 117 self
				)
				(granny
					view: 382
					setLoop: 0
					setSpeed: 9
					setCycle: StopWalk -1
					setMotion: PolyPath 157 113 self
				)
			)
			(14)
			(15
				(Face gEgo 0 117 self)
			)
			(16
				(granny view: 384 loop: 0 cel: 0 setCycle: End self)
				(gEgo view: 381 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(17)
			(18
				(= gNarrator grannyNarrator)
				(gGame handsOn:)
				(= local0 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 78 126 75 121 81 114 101 115 122 115 126 119 113 126 97 127
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance climbTheStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: standUp self)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gGame handsOff:)
				(if (IsFlag 204)
					(gMessager say: 5 63 17 0 self) ; "I'm going up to the attic again."
				else
					(gMessager say: 5 63 16 0 self) ; "I'm going to go up to the attic, Gran."
				)
			)
			(3
				(gEgo ignoreActors: 1 setMotion: PolyPath 226 102 self)
			)
			(4
				(gCurRoom newRoom: 390)
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
				(gEgo setMotion: PolyPath 175 117 self)
				(= local0 1)
			)
			(1
				(Face gEgo 0 117 self)
				(knitAway dispose:)
			)
			(2
				(granny view: 385 setLoop: 0 setCel: 7 setCycle: Beg self)
				(gEgo view: 381 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(3)
			(4
				(gMessager say: 8 8 8 0 self) ; "That's it. Take a load off, Hon."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 381 setCel: 5 setLoop: 0 setCycle: Beg self)
			)
			(1
				(granny setScript: knitAway)
				(= local0 0)
				(gEgo normalize: 1 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateGranny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local0)
					(self setScript: sitDown self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(= global178 26)
				(gMessager say: 19 10 0 0 self) ; "Can we talk, Gran?"
			)
			(2
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance talkToGranny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 384)
				(if (and (not (IsFlag 202)) (not (gEgo has: 6))) ; sketchBook
					(gMessager say: 19 11 15 0 self) ; "How have you been, Gran?"
				else
					(gMessager say: 19 11 local4 0 self)
				)
			)
			(1
				(SetFlag 202)
				(gGame handsOn:)
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
				(= gNarrator GKNarrator)
				(if local0
					(gEgo view: 381 setCel: 5 setLoop: 0 setCycle: Beg self)
				else
					(gEgo setMotion: PolyPath 175 117 self)
				)
			)
			(1
				(gEgo normalize: 1 900)
				(= cycles 2)
			)
			(2
				(gMessager say: 2 6 0 1 self) ; "Well, Gran, I'd better get going."
				(= local0 0)
			)
			(3
				(if (granny script:)
					(knitAway dispose:)
					(granny view: 385 setCel: 7 setLoop: 0 setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(4
				(gMessager say: 2 6 0 2) ; "All right, Dear."
				(granny
					view: 384
					setCel: 4
					setLoop: 0
					setPri: 3
					setCycle: Beg self
				)
			)
			(5
				(gEgo setPri: 4 setMotion: PolyPath 129 116 self)
				(granny
					view: 383
					setCel: 0
					setLoop: 2
					cycleSpeed: 9
					moveSpeed: 9
					setCycle: End
				)
			)
			(6
				(granny setCycle: Beg self)
			)
			(7
				(gEgo setPri: 4 setMotion: PolyPath 79 116 self)
				(granny
					view: 382
					setCycle: StopWalk -1
					setMotion: PolyPath 99 116 self
				)
			)
			(8
				(Face gEgo granny)
			)
			(9
				(gEgo hide:)
				(granny view: 383 setCel: 0 setLoop: 4 setCycle: Osc 1 self)
			)
			(10
				(if (not (IsFlag 203))
					(gMessager say: 2 6 (Random 18 22) 0 self)
				else
					(= cycles 1)
				)
				(gEgo show:)
				(granny view: 382 setLoop: 1)
			)
			(11
				(Face gEgo 0 116 self)
			)
			(12
				(gEgo
					view: 387
					setCel: 0
					setLoop: 0
					posn: 75 116
					setCycle: End self
				)
			)
			(13
				(gEgo normalize:)
				(gCurRoom newRoom: 205)
			)
		)
	)
)

(instance showSomethingToGranny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local0)
					(self setScript: sitDown self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(if
					(not
						(OneOf
							local5
							116
							104
							31
							129
							115
							33
							4
							121
							120
							64
							122
							73
							74
							114
						)
					)
					(= gNarrator GKNarrator)
					(gEgo view: 381 loop: 1 cel: 0 setCycle: End self)
				)
				(gMessager say: 19 0 0 1 self) ; "Does this mean anything to you, Gran?"
			)
			(2
				(if
					(OneOf
						local5
						116
						104
						31
						129
						115
						33
						4
						121
						120
						64
						122
						73
						74
						114
					)
					(= cycles 1)
				)
			)
			(3
				(= gNarrator GKNarrator)
				(granny view: 384 loop: 2 cel: 0 setCycle: End self)
				(gMessager say: 19 0 0 2 self) ; "Sorry, no, Gabriel."
			)
			(4)
			(5
				(if
					(not
						(OneOf
							local5
							116
							104
							31
							129
							115
							33
							4
							121
							120
							64
							122
							73
							74
							114
						)
					)
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(6
				(granny setLoop: 0 setCel: 4 setCycle: 0)
				(= cycles 1)
			)
			(7
				(= gNarrator grannyNarrator)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance importantShow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local0)
					(self setScript: sitDown self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(= gNarrator GKNarrator)
				(gEgo view: 381 loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 19 local5 0 1 self)
			)
			(2)
			(3
				(= gNarrator grannyNarrator)
				(gMessager say: 19 local5 0 2 self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knitAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(granny view: 385 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(granny loop: 1 cel: 0 cycleSpeed: 10 setCycle: Osc 3 self)
			)
			(2
				(= seconds 4)
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance granny of Actor
	(properties
		noun 19
		sightAngle 20
		x 157
		y 113
		view 385
		loop 1
		yStep 1
		signal 20513
		scaleSignal 4
	)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 50) ; interrogation
			(self view: 384 loop: 0 cel: 4)
		else
			(self setScript: knitAway)
		)
	)

	(method (doVerb theVerb)
		(= local5 theVerb)
		(switch theVerb
			(11 ; Talk
				(if (not local0)
					(gEgo setScript: sitDown)
				else
					(= local4 (Random 9 14))
					(gEgo setScript: talkToGranny)
				)
			)
			(10 ; Ask
				(gEgo setScript: interrogateGranny)
			)
			(17 ; murderPhoto
				(gMessager say: noun theVerb 0 0) ; "Gabriel doesn't want to upset his grandmother with that photograph!"
			)
			(else
				(cond
					((OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
						(super doVerb: theVerb)
					)
					((OneOf local5 36 39 14 41 15 32)
						(gEgo setScript: importantShow)
					)
					(else
						(gEgo setScript: showSomethingToGranny)
					)
				)
			)
		)
	)
)

(instance oilLampFlame of Prop
	(properties
		noun 9
		sightAngle 20
		x 299
		y 106
		view 380
		signal 4129
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle setPri: 171)
	)
)

(instance oilLampReflection of Prop
	(properties
		noun 9
		sightAngle 20
		x 299
		y 106
		view 380
		loop 1
		signal 4129
		detailLevel 2
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle setPri: 170)
	)
)

(instance oilLampReflection2 of Prop
	(properties
		noun 9
		sightAngle 20
		x 299
		y 106
		view 380
		loop 2
		signal 4129
		detailLevel 3
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle setPri: 170)
	)
)

(instance clock of Feature
	(properties
		noun 11
		sightAngle 20
		x 273
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 51 280 51 280 78 271 89 261 89
					yourself:
				)
		)
		(super init:)
	)
)

(instance chair of Feature
	(properties
		noun 8
		sightAngle 20
		x 199
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 181 96 201 95 210 82 220 87 211 103 209 115 204 115 202 114 191 114 187 117 181 112
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if local0
					(gMessager say: 8 8 1 0) ; "Gabriel's already using the chair."
				else
					(gEgo setScript: sitDown)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance firePlace of Feature
	(properties
		noun 4
		sightAngle 20
		x 14
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 19 131 5 129 0 132 0 95 31 90 36 91 34 115 26 121 28 125 42 129 21 138
					yourself:
				)
		)
		(super init:)
	)
)

(instance oilLamp of Feature
	(properties
		noun 9
		sightAngle 20
		x 302
		y 195
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 277 145 270 132 272 126 284 121 285 115 283 110 290 103 281 102 274 92 274 86 288 68 290 26 299 23 309 25 312 70 319 81 319 106 313 113 313 119 319 120 319 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance flowers of Feature
	(properties
		noun 10
		sightAngle 20
		x 261
		y 143
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 130 245 128 233 104 241 97 241 93 250 94 246 89 253 91 259 84 264 87 269 84 272 90 281 103 290 104 282 110 283 114 270 129 274 138 275 145 244 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance grandmaPic of Feature
	(properties
		noun 7
		sightAngle 20
		x 110
		y 63
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 99 67 100 54 108 47 115 47 124 56 123 69 114 76 108 76
					yourself:
				)
		)
		(super init:)
	)
)

(instance grandpaPic of Feature
	(properties
		noun 6
		sightAngle 20
		x 154
		y 58
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 68 143 56 150 47 159 47 167 56 168 66 159 77 154 77
					yourself:
				)
		)
		(super init:)
	)
)

(instance knitBasket of Feature
	(properties
		noun 13
		sightAngle 20
		x 101
		y 118
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 111 98 108 114 118 105 123 87 120
					yourself:
				)
		)
		(super init:)
	)
)

(instance magazineBin of Feature
	(properties
		noun 16
		sightAngle 20
		x 199
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 187 117 189 114 202 113 204 116 209 117 207 122 208 125 189 125
					yourself:
				)
		)
		(super init:)
	)
)

(instance miscPhotos of Feature
	(properties
		noun 15
		sightAngle 20
		x 90
		y 143
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 135 198 130 204 132 206 138 214 119 238 116 242 123 239 133 242 146 191 144
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 0 67 9 73 11 81 17 80 15 76 26 75 32 90 13 94 0 94
					yourself:
				)
		)
		(super init:)
	)
)

(instance light of Feature
	(properties
		noun 12
		sightAngle 20
		x 131
		y 49
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 135 28 133 32 133 46 138 51 138 56 132 61 125 57 125 51 131 46 131 32 127 28
					yourself:
				)
		)
		(super init:)
	)
)

(instance tree of Feature
	(properties
		noun 17
		sightAngle 20
		x 85
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 79 99 82 96 73 89 73 68 77 61 92 58 97 74 96 81 85 92 85 96 90 98 92 102 89 108 80 108
					yourself:
				)
		)
		(super init:)
	)
)

(instance sofa of Feature
	(properties
		noun 3
		sightAngle 20
		x 133
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 92 96 88 98 84 95 86 92 96 82 107 82 126 76 139 75 155 82 173 81 181 96 175 97 173 95 171 111 96 111
					yourself:
				)
		)
		(super init:)
	)
)

(instance stairs of Feature
	(properties
		noun 5
		sightAngle 20
		x 227
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 220 88 215 82 215 51 235 51 247 74 247 94 241 100 215 101
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: climbTheStairs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tableLamp of Feature
	(properties
		noun 18
		sightAngle 20
		x 189
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 77 186 67 191 68 195 80 193 89 184 89
					yourself:
				)
		)
		(super init:)
	)
)

(instance woodBin of Feature
	(properties
		noun 14
		sightAngle 20
		x 37
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 26 120 35 111 44 110 48 118 55 119 53 127 46 128 28 125
					yourself:
				)
		)
		(super init:)
	)
)

(instance frontDoor of Feature
	(properties
		noun 2
		sightAngle 20
		x 54
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 48 70 52 72 108 44 118 38 116
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gEgo setScript: leaveRoom)
			)
			(8 ; Operate
				(gEgo setScript: leaveRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

