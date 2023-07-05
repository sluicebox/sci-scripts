;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24100)
(include sci.sh)
(use Main)
(use scaryInvInit)
(use n1111)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm24100 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1)
	(switch param1
		(24430
			(if (IsFlag 136)
				(pulley view: 24435 loop: 1 posn: 218 116)
			else
				(pulley view: 24435 loop: 0 posn: 219 118)
			)
		)
		(24100
			(if (IsFlag 136)
				(pulley view: 24105 loop: 1 posn: 188 131)
			else
				(pulley view: 24105 loop: 0 posn: 210 130)
			)
		)
		(24150
			(if (IsFlag 136)
				(pulley view: 24155 loop: 1 posn: 219 132)
			else
				(pulley view: 24155 loop: 0 posn: 235 130)
			)
		)
		(else
			(pulley posn: 5 1000)
		)
	)
)

(procedure (localproc_1 param1)
	(switch param1
		(24400
			(pitchfork view: 24150 loop: 0 posn: 0 1000)
		)
		(24410
			(pitchfork view: 24410 loop: 0 posn: 128 118)
		)
		(24100
			(pitchfork view: 24100 loop: 1 posn: 140 84)
		)
		(24150
			(pitchfork view: 24151 loop: 1 posn: 160 89)
		)
		(24440
			(pitchfork view: 24150 loop: 0 posn: 185 126)
		)
		(24390
			(pitchfork view: 24150 loop: 0 posn: 222 95)
		)
		(24430
			(pitchfork view: 24430 loop: 0 posn: 128 118)
		)
		(else
			(pitchfork view: 24150 loop: 0 posn: 95 106)
		)
	)
)

(procedure (localproc_2 param1)
	(switch param1
		(24100
			(harriet view: 3313 posn: 77 93)
			(if local5
				(harriet cycleSpeed: local5)
			)
			(legs view: 3315 posn: 79 119)
		)
		(24150
			(harriet view: 3314 loop: 1 posn: 90 94 setCycle: Osc cycleSpeed: 6)
			(legs view: 3314 loop: 0 posn: 99 119)
		)
	)
)

(procedure (localproc_3 param1)
	(switch param1
		(24100
			(ladder view: 24100 loop: 0 posn: 166 109)
		)
		(24150
			(ladder view: 24151 posn: 183 116)
		)
	)
)

(procedure (localproc_4 param1)
	(switch param1
		(24100
			(localproc_0 24100)
			(localproc_3 24100)
			(localproc_1 24100)
			(localproc_2 24100)
		)
		(24150
			(localproc_0 24150)
			(localproc_3 24150)
			(localproc_1 24150)
			(localproc_2 24150)
		)
	)
)

(instance sHarrietWhines of Script
	(properties)

	(method (doit)
		(if (IsFlag 164)
			(if (gGDacSound handle:)
				(gGDacSound stop:)
			)
			(self dispose:)
		)
		(if
			(and
				(gGDacSound handle:)
				(gEgo robot:)
				(not (OneOf ((gEgo robot:) robot:) 3400 3350 3300))
			)
			(gGDacSound stop:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(Lock 140 24030 0) ; WAVE
		(Lock 140 24031 0) ; WAVE
		(Lock 140 24032 0) ; WAVE
		(Lock 140 24034 0) ; WAVE
		(Lock 140 24035 0) ; WAVE
		(Lock 140 24036 0) ; WAVE
		(gGDacSound client: 0)
		(= next 0)
		(if scratch
			(scratch release: dispose:)
			(= scratch 0)
		)
		(super dispose: &rest)
	)

	(method (init &tmp temp0)
		(Lock 140 24030 1) ; WAVE
		(Lock 140 24031 1) ; WAVE
		(Lock 140 24032 1) ; WAVE
		(Lock 140 24034 1) ; WAVE
		(Lock 140 24035 1) ; WAVE
		(Lock 140 24036 1) ; WAVE
		(= scratch (Set new:))
		(for ((= temp0 0)) (< temp0 100) ((++ temp0))
			(scratch add: (Random 24030 24036))
		)
		(scratch delete: 24033)
		(= next -1)
		(gGDacSound setLoop: 1)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (cue)
		(self changeState: (+ state 1))
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (and (& register $0001) (!= (gCurRoom number:) 24100))
					(gGame handsOff:)
					(self setScript: (ScriptID 0 5) self 5) ; takeLastStep
				else
					(self cue:)
				)
				(= register 0)
			)
			(1
				(switch gCurRoomNum
					(24610
						(gGDacSound setVol: 40)
					)
					(24010
						(gGDacSound setVol: 40)
					)
					(24000
						(gGDacSound setVol: 60)
					)
					(24100
						(gGDacSound setVol: 100)
					)
					(28300
						(self dispose:)
					)
				)
				(self cue:)
			)
			(2
				(if (IsFlag 164)
					(self dispose:)
					(return)
				else
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(not (IsFlag 164))
						(not (gCurRoom inset:))
						(not
							(and
								(gEgo robot:)
								(not
									(OneOf
										((gEgo robot:) robot:)
										3400
										3350
										3300
									)
								)
							)
						)
					)
					(if (== (++ next) (scratch size:))
						(scratch release:)
						(for ((= temp0 0)) (< temp0 100) ((++ temp0))
							(scratch add: (Random 24030 24036))
						)
						(scratch delete: 24033)
						(= next 0)
					)
					(gGDacSound number: (scratch at: next) play:)
				)
				(self cue:)
			)
			(4
				(= seconds (Random 5 12))
			)
			(5
				(self changeState: 3)
			)
		)
	)
)

(instance rm24100 of ScaryRoom
	(properties
		picture 24430
		west 24000
		stepSound 4
	)

	(method (init)
		(gUser canControl: 1)
		(gEgo init: setScaler: Scaler 82 80 86 84)
		((ScriptID 30) init:) ; FidgetCode
		(ladder init: hide: setHotspot: 4 3 36) ; Do, Move, invPitchfork
		(pitchfork init: approachVerbs: 0 setPri: 0)
		(localproc_1 (gCurRoom picture:))
		(if (IsFlag 136)
			(pulley init: view: 24435 loop: 1 posn: 218 116 setPri: 1)
		else
			(pulley init: view: 24435 loop: 0 posn: 219 118 setPri: 1)
		)
		(if
			(and
				(not (IsFlag 164))
				(or (and (not (IsFlag 137)) (not (IsFlag 136))) (IsFlag 136))
			)
			(pulley setHotspot: 4 3) ; Do, Move
		)
		(if (and (IsFlag 164) (not (IsFlag 165)))
			(hole init: setHotspot: 1 3) ; ???, Move
		)
		(if (== gChapter 3)
			(SetFlag 324)
		)
		(switch gPrevRoomNum
			(900
				(= local0 sEnter)
			)
			(24110
				(= picture 24400)
				(localproc_1 24400)
				(pulley hide:)
				(gEgo hide:)
				(= local0 fromHole)
			)
			(else
				(= local0 sEnter)
			)
		)
		(super init: &rest)
		(if local0
			(self setScript: local0)
		else
			(gGame handsOn:)
		)
	)
)

(instance invPitchfork of ScaryInventory
	(properties
		view 9881
		verb 36
		hiliteView 9881
		loliteView 9882
	)
)

(instance pitchforkCursor of ScaryCursor
	(properties
		view 9882
	)
)

(instance fromHole of Script
	(properties)

	(method (dispose)
		(if (gCast contains: biggerHole)
			(biggerHole dispose:)
		)
		(gCast eachElementDo: #show)
		(localproc_3 24100)
		(localproc_1 24100)
		(localproc_0 24100)
		(gCurRoom drawPic: 24100 picture: 24100)
		(gEgo posn: 129 86 normalize: 0)
		((ScriptID 0 5) register: 5) ; takeLastStep
		(= next (ScriptID 0 5)) ; takeLastStep
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(biggerHole init:)
					(proc1111_7 3421 74 34 gEgo 60)
				)
				(1
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(proc1111_6)
			(self dispose:)
		)
	)
)

(instance clickHarriet of Script
	(properties)

	(method (dispose)
		(= local1 2)
		(localproc_1 24100)
		(gCast eachElementDo: #show)
		(gCurRoom drawPic: 24100 picture: 24100)
		(gEgo posn: 113 88 normalize: 1)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and (!= (gEgo view:) 5) (!= (gEgo view:) 1))
						(proc1111_13 register self 1)
					else
						(self cue:)
					)
				)
				(1
					(gCast eachElementDo: #hide)
					(localproc_1 24400)
					(gCurRoom drawPic: 24400 picture: 24400)
					(proc1111_7 3320 2 -26)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance clickHarriet2 of Script
	(properties)

	(method (dispose)
		(= local1 2)
		(gCast eachElementDo: #show)
		(gEgo posn: 113 88 normalize: 1)
		(gCurRoom drawPic: 24100 picture: 24100)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 24399 picture: 24399)
					(proc1111_7 3330 -12 -45 gEgo 75)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance clickHarriet3 of Script ; UNUSED
	(properties)

	(method (dispose)
		(= local1 2)
		(localproc_4 24100)
		(gEgo posn: 113 88 normalize: 1)
		(gCurRoom drawPic: 24100 picture: 24100)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (!= local1 2)
						(proc1111_13 register self 1)
					else
						(self cue:)
					)
				)
				(1
					(localproc_4 24150)
					(gCurRoom drawPic: 24150 picture: 24150)
					(proc1111_7 3340 108 33)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (dispose)
		(if (and (== gChapter 3) (not (IsFlag 164)))
			(pitchfork setHotspot: 4 3) ; Do, Move
			(harriet init: setCycle: Osc approachVerbs: 0 setHotspot: 4 3) ; Do, Move
			(= local5 (harriet cycleSpeed:))
			(legs init: setPri: 100 setCycle: Fwd cycleSpeed: 6)
			(Load rsVIEW 3362)
			(Load rsPIC 24150)
			(sHarrietWhines init:)
		)
		(ladder show:)
		(localproc_3 24100)
		(localproc_1 24100)
		(gEgo posn: 129 86 normalize: 5)
		(gCurRoom drawPic: 24100 picture: 24100)
		(localproc_0 24100)
		(pulley setPri: 5)
		(= local1 0)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and (== gChapter 3) (not (IsFlag 164)))
						(localproc_1 24430)
						(proc1111_7 3351 119 29 gEgo 5)
					else
						(proc1111_7 3312 153 49 gEgo 5)
					)
				)
				(1
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance downLadder of Script
	(properties)

	(method (dispose)
		(gCurRoom newRoom: 24000)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(gCast delete: gEgo)
			(gCast eachElementDo: #dispose)
			(gCast add: gEgo)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast delete: gEgo pulley pitchfork)
					(gCast eachElementDo: #dispose)
					(gCast add: pitchfork gEgo pulley)
					(self cue:)
				)
				(1
					(gEgo hide:)
					(localproc_1 24430)
					(localproc_0 24430)
					(gCurRoom drawPic: 24430 picture: 24430)
					(if (and (== gChapter 3) (not (IsFlag 164)))
						(proc1111_7 3352 119 29 gEgo -1 1)
					else
						(gEgo
							view: 3311
							show:
							setScale: 0
							loop: 0
							cel: 0
							posn: 190 121
							setCycle: End self
						)
					)
				)
				(2
					(= cycles 2)
				)
				(3
					(self dispose:)
				)
			)
		)
	)
)

(instance clink of Sound
	(properties
		flags 1
		number 24033
	)
)

(instance putForkDown of Script
	(properties)

	(method (dispose)
		(= local1 1)
		(if (not local3)
			(localproc_4 24100)
			(gCurRoom drawPic: 24100 picture: 24100)
			(gEgo posn: 129 86 normalize: 4 setScaler: Scaler 82 80 86 84)
		)
		(harriet setHotspot: 4 3) ; Do, Move
		(gGame handsOn:)
		((ScriptID 0 9) enable: 1) ; lookIcon
		(ClearFlag 234)
		(= global192 0)
		(= global118 0)
		(= global193 0)
		(= global161 0)
		(gUser message: (gUser dftMessage:))
		(gCurrentControl select: 3 gNormalCursor)
		(gGame setCursor: gNormalCursor 1)
		(pitchfork init: setPri: 0 setHotspot: 4 3 approachVerbs: 0) ; Do, Move
		(wall dispose:)
		(harriet setHotspot: 4 3) ; Do, Move
		(if (not (IsFlag 137))
			(pulley setHotspot: 4 3) ; Do, Move
		)
		(if local3
			(= next downLadder)
		else
			(sHarrietWhines init:)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(localproc_4 24150)
					(gCurRoom drawPic: 24150 picture: 24150)
					(gEgo
						posn: 143 94
						setScale: 0
						view: 3362
						setCel: 0
						setCycle: CT 27 1 self
					)
				)
				(1
					(clink play:)
					(gEgo setCycle: End self)
				)
				(2
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance sGetFork of Script
	(properties)

	(method (dispose)
		(= local1 1)
		(if (gCast contains: pitchfork)
			(pitchfork dispose:)
		)
		(localproc_2 24100)
		(localproc_3 24100)
		(localproc_0 24100)
		(gCurRoom drawPic: 24100 picture: 24100)
		(gEgo view: 3362 posn: 129 86 setCel: 0 setCycle: 0)
		(wall init: setHotspot: 4 36) ; Do, invPitchfork
		(harriet setHotspot: 36 36) ; invPitchfork, invPitchfork
		(if (not (IsFlag 136))
			(pulley setHotspot: 36 36) ; invPitchfork, invPitchfork
		)
		(= global118 0)
		(= global161 invPitchfork)
		(= global192 pitchforkCursor)
		(gUser message: -1)
		(gCurrentControl select: 36 pitchforkCursor)
		(gGame setCursor: pitchforkCursor 1)
		(gGame handsOn:)
		((ScriptID 0 9) enable: 0) ; lookIcon
		(SetFlag 234)
		(sHarrietWhines register: 0)
		(sHarrietWhines init:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(switch local1
						(2
							(gEgo setHeading: 90 self 20)
							(++ state)
						)
						(1
							(++ state)
							(= cycles 1)
						)
						(0
							(gEgo setHeading: 45 self 13)
							(++ state)
						)
						(else
							(self cue:)
						)
					)
				)
				(1
					(gEgo
						posn: 124 86
						view: 7001
						cel: 0
						loop: 1
						setCycle: CT 22 1 self
					)
				)
				(2
					(localproc_0 24150)
					(localproc_2 24150)
					(localproc_3 24150)
					(Load 140 24033) ; WAVE
					(gCurRoom drawPic: 24150 picture: 24150)
					(gEgo
						posn: 143 94
						view: 3362
						setCel: 54
						setScale: 0
						setCycle: CT 27 -1 self
						setLoop: 0 1
					)
					(pitchfork dispose:)
				)
				(3
					(gEgo setCycle: Beg self)
					(clink play:)
				)
				(4
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance sForkOnPulley of Script
	(properties)

	(method (dispose)
		((ScriptID 0 9) enable: 1) ; lookIcon
		(ClearFlag 234)
		(= global192 0)
		(= global118 0)
		(= global193 0)
		(= global161 0)
		(= global162 1)
		(gUser message: (gUser dftMessage:))
		(gCurrentControl select: 3 gNormalCursor)
		(gGame setCursor: gNormalCursor 1)
		(SetFlag 136)
		(pulley dispose:)
		(pulley init: setHotspot: 4 3) ; Do, Move
		(gCast eachElementDo: #show)
		(pitchfork init:)
		(localproc_1 24100)
		(localproc_3 24100)
		(localproc_2 24100)
		(localproc_0 24100)
		(gCurRoom drawPic: 24100 picture: 24100)
		(gEgo posn: 129 86 setScaler: Scaler 82 80 86 84 normalize: 4)
		(harriet setHotspot: 4 3) ; Do, Move
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= global162 1)
					(pulley hide:)
					(localproc_3 24150)
					(localproc_1 24150)
					(localproc_2 24150)
					(gCurRoom drawPic: 24150 picture: 24150)
					(proc1111_7 3400 -2 -1)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance freeHarriet of Script
	(properties)

	(method (dispose)
		(pitchfork init: setHotspot: 0)
		(localproc_1 24100)
		(gEgo posn: 154 87 normalize: 2)
		(= global162 1)
		(SetFlag 164)
		(pulley setHotspot: 0)
		(harriet dispose:)
		(biggerHole dispose:)
		(legs dispose:)
		(hole init: setHotspot: 1 3) ; ???, Move
		(gCast eachElementDo: #show)
		(localproc_0 24100)
		(localproc_3 24100)
		(gCurRoom drawPic: 24100 picture: 24100)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= global162 1)
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 24400)
					(proc1111_7 3401 -11 -27 gEgo 60)
				)
				(1
					(gCurRoom drawPic: 24450)
					(proc1111_7 3411 -12 -43 gEgo 1)
				)
				(2
					(biggerHole init:)
					(gCurRoom drawPic: 24400)
					(proc1111_7 3412 -7 -31 gEgo 60)
				)
				(3
					(biggerHole hide:)
					(gCurRoom drawPic: 24440)
					(proc1111_7 3413 6 -25)
				)
				(4
					(biggerHole show:)
					(gCurRoom drawPic: 24400 picture: 24400)
					(proc1111_7 3414 20 2 gEgo 60)
				)
				(5
					(biggerHole dispose:)
					(gCurRoom drawPic: 24730 picture: 24730)
					(proc1111_7 3415 -50 -35)
				)
				(6
					(pitchfork show:)
					(localproc_1 24430)
					(if (gCast contains: pulley)
						(pulley show:)
						(localproc_0 24430)
					)
					(gCurRoom drawPic: 24430 picture: 24430)
					(proc1111_7 3416 132 37)
				)
				(7
					(self dispose:)
				)
			)
		)
	)
)

(instance reachForPulley of Script
	(properties)

	(method (dispose)
		(localproc_4 24100)
		(gCurRoom drawPic: 24100 picture: 24100)
		(gEgo normalize: 4)
		(gGame handsOn:)
		(sHarrietWhines init:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 pulley self 1)
				)
				(1
					(localproc_4 24150)
					(gCurRoom drawPic: 24150 picture: 24150)
					(proc1111_7 3380 165 34)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance forkHarriet of Script
	(properties)

	(method (dispose)
		(gCast eachElementDo: #show)
		(harriet setHotspot: 4 3) ; Do, Move
		(= local4 1)
		(= local1 2)
		(gCurRoom drawPic: 24100 picture: 24100)
		(gGame handsOn:)
		(sHarrietWhines init:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(= local4 1)
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 24399 picture: 24399)
					(proc1111_7 3370 0 -45)
				)
				(1
					(gCurRoom drawPic: 24400 picture: 24400)
					(proc1111_7 3371 -11 -34)
				)
				(2
					(gCurRoom drawPic: 24399 picture: 24399)
					(proc1111_7 3372 -8 -45)
				)
				(3
					(gCurRoom drawPic: 24400 picture: 24400)
					(proc1111_7 3373 -5 -40)
				)
				(4
					(self dispose:)
				)
			)
		)
	)
)

(instance lookInHole of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 270 self)
				)
				(1
					(gCast eachElementDo: #hide)
					(gGame handsOff:)
					(biggerHole init:)
					(gCurRoom drawPic: 24400 picture: 24400)
					(proc1111_7 3420 60 10 gEgo 60 1)
				)
				(2
					(gCurRoom newRoom: 24110)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gCast eachElementDo: #hide)
					(= global115 0)
					(gCurRoom newRoom: 24110)
				)
			)
		)
	)
)

(instance ladder of Prop
	(properties
		approachX 172
		approachY 93
		x 172
		y 93
		view 24100
	)

	(method (init)
		(self createPoly: 142 69 168 67 187 129 156 129)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: downLadder)
			)
			(36 ; invPitchfork
				(= local3 1)
				(gCurRoom setScript: putForkDown)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pulley of Prop
	(properties
		approachX 219
		approachY 86
		x 219
		y 118
		view 24435
	)

	(method (init)
		(= onMeCheck
			(if (IsFlag 136)
				((Polygon new:) init: 182 25 204 25 204 69 182 69 yourself:)
			else
				((Polygon new:)
					init: 210 61 265 16 272 56 262 54 261 26 210 91
					yourself:
				)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36 ; invPitchfork
				(if (not (IsFlag 136))
					(gCurRoom setScript: sForkOnPulley)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(cond
					((IsFlag 164)
						(super doVerb: theVerb)
					)
					((IsFlag 136)
						(gCurRoom setScript: freeHarriet)
					)
					(else
						(gCurRoom setScript: reachForPulley)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance biggerHole of View
	(properties
		x 60
		y 56
		view 24400
	)
)

(instance pitchfork of View
	(properties
		approachX 140
		approachY 86
		x 128
		y 118
		view 24430
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetFork)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance legs of Actor
	(properties
		x 79
		y 119
		view 3315
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
	)
)

(instance harriet of Actor
	(properties
		approachX 77
		approachY 86
		x 77
		y 93
		view 3313
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36 ; invPitchfork
				(= local1 2)
				(gCurRoom setScript: forkHarriet)
			)
			(4 ; Do
				(= local1 2)
				(switch global205
					(0
						(++ global205)
						(gCurRoom setScript: clickHarriet 0 self)
					)
					(1
						(++ global205)
						(gCurRoom setScript: clickHarriet2 0 self)
					)
					(else
						(gCurRoom setScript: clickHarriet2 0 self)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hole of Feature
	(properties
		nsLeft 63
		nsTop 85
		nsRight 94
		nsBottom 92
		approachX 104
		approachY 120
		x 104
		y 120
		z 24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; ???
				(gCurRoom setScript: lookInHole)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wall of Feature
	(properties
		nsLeft 112
		nsTop 49
		nsRight 157
		nsBottom 87
		approachX 134
		approachY 68
		x 134
		y 68
	)

	(method (doVerb theVerb)
		(if (== theVerb 36) ; invPitchfork
			(gCurRoom setScript: putForkDown)
		else
			(super doVerb: theVerb)
		)
	)
)

