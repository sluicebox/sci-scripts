;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24000)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Talker)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm24000 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1) ; UNUSED
	(switch param1
		(24480
			(pitchFork view: 24480 loop: 1 posn: 228 12)
		)
		(24200
			(pitchFork view: 24200 loop: 2 posn: 125 19)
		)
	)
)

(procedure (localproc_1 param1)
	(switch param1
		(24520
			(ladderTip view: 24520 loop: 1 show: posn: 77 15)
		)
		(24180
			(ladderTip view: 24180 loop: 1 show: posn: 176 60)
		)
		(24200
			(ladderTip view: 24200 loop: 1 show: posn: 140 56)
		)
		(else
			(ladderTip view: 24530 loop: 1 show: posn: 186 8)
		)
	)
)

(procedure (localproc_2 param1)
	(switch param1
		(24520
			(holePatch view: 24520 show: posn: 0 10)
		)
		(24530
			(holePatch view: 24530 show: posn: 99 25)
		)
		(24180
			(holePatch view: 24180 show: posn: 84 115)
		)
		(else
			(proc1111_0 {wrong cam angle dude})
		)
	)
)

(procedure (localproc_3 param1)
	(switch param1
		(24360
			(legs init: view: 24361 posn: 158 24 cycleSpeed: 6 setCycle: Fwd)
		)
		(24370
			(legs init: view: 24371 posn: 160 34 cycleSpeed: 6 setCycle: Fwd)
		)
		(24130
			(legs init: view: 24131 posn: 229 30 cycleSpeed: 6 setCycle: Fwd)
		)
	)
)

(procedure (localproc_4 param1)
	(switch param1
		(24480
			(ladder view: 24480 show: posn: 226 107)
		)
		(24200
			(ladder view: 24200 show: posn: 157 92)
		)
		(24360
			(ladder view: 24360 show: posn: 33 107)
		)
		(24370
			(ladder view: 24370 show: posn: 69 113)
		)
	)
)

(procedure (localproc_5 param1)
	(switch param1
		(24200
			(if (IsFlag 136)
				(pulley view: 24205 loop: 1 posn: 174 81 setPri: 5)
			else
				(pulley view: 24205 loop: 0 posn: 178 76 setPri: 5)
			)
		)
		(24520
			(pulley view: 24525 posn: 121 46 setPri: 5)
		)
		(24210
			(pulley view: 24210 posn: 113 130 setPri: 5)
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

(instance rm24000 of ScaryRoom
	(properties
		picture 24200
	)

	(method (drawPic param1)
		(switch param1
			(24480
				(pitchFork init: view: 24480 loop: 1 posn: 228 12)
			)
			(24200
				(pitchFork init: view: 24200 loop: 2 posn: 125 19)
				(cond
					((and (== gChapter 2) (<= global164 1))
						(if (not local1)
							(Load 140 24022) ; WAVE
							(Lock 140 24022 1) ; WAVE
							(= local1 24022)
						)
						(catRustle init: setVol: 15)
						(catShadow init: cycleSpeed: 7 setCycle: Blink 360)
					)
					((gCast contains: catShadow)
						(catShadow dispose:)
					)
				)
			)
			(else
				(if (gCast contains: catShadow)
					(catShadow hide:)
				)
				(pitchFork dispose:)
			)
		)
		(super drawPic: param1 &rest)
	)

	(method (init &tmp temp0 temp1 temp2)
		(KillRobot)
		(= temp2 0)
		(= temp1 0)
		(= temp0 0)
		(gGDacSound stop:)
		(switch gChapter
			(2
				(= temp2 915)
			)
			(3
				(if (IsFlag 164)
					(= temp2 915)
				else
					(= temp2 24029)
				)
			)
			(4
				(= temp2 916)
			)
			(5
				(= temp2 917)
			)
			(6
				(= temp2 918)
			)
		)
		(if temp2
			(global114 play: temp2)
		)
		(gEgo init: setScaler: Scaler 87 43 120 87)
		((ScriptID 30) init:) ; FidgetCode
		(if (> gChapter 2)
			(SetFlag 66)
		)
		(= global115 0)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(bringOnTheClowns doit:)
			)
			(24100
				(= picture 24130)
				(gEgo posn: 0 300)
				(= temp0 downLadder)
			)
			(28300
				(cond
					((not (IsFlag 66))
						(= picture 24370)
						(gEgo normalize: 3 posn: 162 120)
						(gEgo posn: 0 300)
						(= temp0 sComeIn)
					)
					(
						(and
							(== gChapter 3)
							(not (IsFlag 164))
							(not (IsFlag 407))
						)
						(= picture 24370)
						(gEgo posn: 0 300)
						(= temp0 helpMa)
					)
					((== gChapter 5)
						(if (not (IsFlag 195))
							(= picture -1)
							(= temp0 seanceScr)
						else
							(= picture 24620)
							(seanceStuff init: setPri: 5)
							(nightExit init: 3)
							(gEgo
								normalize: 3
								setScaler: Scaler 126 113 130 107
								posn: 134 141
							)
							(= temp0 (ScriptID 0 5)) ; takeLastStep
						)
					)
					(else
						(= picture 24610)
						(= temp0 sWalkIn)
					)
				)
			)
			(24610
				(bringOnTheClowns doit:)
				(cond
					(
						(and
							(== gChapter 3)
							(not (IsFlag 164))
							(not (IsFlag 407))
						)
						(= picture 24370)
						(gEgo posn: 0 300)
						(= temp0 helpMa)
					)
					((== gChapter 5)
						(if (not (IsFlag 195))
							(= picture -1)
							(= temp0 seanceScr)
						else
							(= picture 24620)
							(seanceStuff init: setPri: 5)
							(nightExit init: 3)
							(gEgo
								normalize: 3
								setScaler: Scaler 126 113 130 107
								posn: 134 141
							)
							(= temp0 (ScriptID 0 5)) ; takeLastStep
						)
					)
					((and (== gChapter 3) (not (IsFlag 164)))
						(gEgo normalize: 7 posn: 165 96)
						(= temp0 sHarrietWhines)
						(gGame handsOn:)
					)
					(else
						(gEgo normalize: 3 posn: 162 120)
						(= temp0 (ScriptID 0 5)) ; takeLastStep
					)
				)
			)
			(24010
				(if (and (== gChapter 3) (not (IsFlag 407)))
					(= picture 24370)
					(gEgo posn: 0 300)
					(= temp0 helpMa)
				else
					(gEgo normalize: 6 posn: 110 120)
					(bringOnTheClowns doit:)
					(if (and (== gChapter 3) (not (IsFlag 164)))
						(= temp0 sHarrietWhines)
						(gGame handsOn:)
					else
						(= temp0 (ScriptID 0 5)) ; takeLastStep
					)
				)
			)
			(else
				(if (not (IsFlag 66))
					(= picture 24370)
					(gEgo normalize: 3 posn: 162 120)
					(gEgo posn: 0 300)
					(= temp0 sComeIn)
				else
					(gGame handsOn:)
					(bringOnTheClowns doit:)
					(gEgo normalize: 3 posn: 162 120)
				)
			)
		)
		(if (!= gChapter 5)
			(southExit init: 11)
		else
			(gEgo fadePalette: 28100)
		)
		(super init: &rest)
		(if temp0
			(if (== temp0 sHarrietWhines)
				(sHarrietWhines register: 1 init:)
			else
				(self setScript: temp0)
			)
		)
	)
)

(instance harriet of Actor
	(properties
		nsLeft 132
		nsTop 41
		nsRight 146
		nsBottom 53
		approachX 138
		approachY 96
		x 138
		y 63
		view 3210
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PNearestAccess init: 132 41 146 41 146 53 132 53 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 164)
						(super doVerb: theVerb &rest)
					)
					((not (IsFlag 305))
						(gCurRoom setScript: clickOnLegs)
					)
					((not (IsFlag 306))
						(gCurRoom setScript: clickOnLegs2)
					)
					(else
						(gCurRoom setScript: clickOnLegsOther)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cyrus of Prop
	(properties
		nsLeft 129
		nsTop 68
		nsRight 152
		nsBottom 102
		approachX 140
		approachY 96
		x 138
		y 99
		view 3211
		signal 24609
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PNearestAccess
				init: 129 68 152 68 152 102 129 102
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 164))
					(switch (++ global176)
						(1
							(gCurRoom setScript: clickOnCyrus)
						)
						(2
							(gCurRoom setScript: clickOnCyrus2)
						)
						(else
							(gCurRoom setScript: clickOnCyrus3)
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigCyrus of Prop
	(properties
		x 250
		y 132
		view 3301
	)
)

(instance legs of Prop
	(properties
		x 160
		y 34
		view 3220
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
	)
)

(instance catShadow of Prop
	(properties
		x 112
		y 29
		view 24202
	)

	(method (doit)
		(super doit:)
		(if (and cycler (not (cycler waitCount:)))
			(if
				(and
					(not (catRustle handle:))
					(not local0)
					(== (gCurRoom picture:) 24200)
				)
				(= local0 1)
				(catRustle setLoop: 1 play:)
			)
		else
			(= local0 0)
		)
	)

	(method (init)
		(RemapColors 2 236 75) ; ByPercent
		(super init: &rest)
	)

	(method (dispose)
		(if local1
			(Lock 140 local1 0) ; WAVE
		)
		(RemapColors 0) ; Off
		(super dispose: &rest)
	)
)

(instance pitchFork of View
	(properties
		x 228
		y 12
		view 24480
		loop 1
	)
)

(instance seanceStuff of View
	(properties
		x 27
		y -4
		view 24620
	)
)

(instance ladderTip of View
	(properties
		x 140
		y 56
		view 24200
		loop 1
	)
)

(instance holePatch of View
	(properties
		y 10
		view 24520
	)
)

(instance ladder of View
	(properties
		sightAngle 180
		approachX 171
		approachY 91
		x 157
		y 92
		view 24200
		signal 16384
	)

	(method (init)
		(self createPoly: 157 43 175 92 181 90 162 42)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: climbLadder)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance catRustle of Sound
	(properties
		flags 1
		number 24022
	)

	(method (check)
		(if (and (self handle:) (!= (gCurRoom picture:) 24200))
			(self stop:)
		)
		(super check:)
	)
)

(instance pulley of Prop
	(properties
		approachX 159
		approachY 73
		x 178
		y 76
		view 24205
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PNearestAccess
				init: 180 72 180 49 198 27 200 38 205 37 202 18 176 41
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: lookPulley)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if (and (== global163 loft) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)
)

(instance loft of Feature
	(properties
		nsLeft 138
		nsTop 44
		nsRight 167
		nsBottom 53
		approachX 160
		approachY 54
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sLookLoft)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if (and (== global163 pulley) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)
)

(instance stables of Feature
	(properties
		nsLeft 126
		nsTop 61
		nsRight 146
		nsBottom 93
		approachX 136
		approachY 78
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			(switch global164
				(0
					(gCurRoom setScript: hearNoise)
				)
				(1
					(gCurRoom setScript: catJumps)
				)
				(else
					(gCurRoom setScript: normalStableScr)
				)
			)
		)
	)
)

(instance campfire of ExitFeature
	(properties
		nsLeft 0
		nsTop 107
		nsRight 96
		nsBottom 129
		approachX 40
		approachY 170
		x 18
		y 104
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(gCurRoom newRoom: 24010)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nightExit of ExitFeature
	(properties
		nsTop 100
		approachX 134
		approachY 181
		nextRoom 28300
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 142
		nsTop 111
		nsRight 291
		nsBottom 128
		approachX 160
		approachY 199
		x 120
		y 135
		nextRoom 24610
	)
)

(instance bringOnTheClowns of Code
	(properties)

	(method (doit)
		(gEgo show:)
		(campfire init: 12)
		(if (and (< gChapter 3) (<= global164 2))
			(stables init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		)
		(cond
			((< gChapter 3)
				(ladderTip init:)
				(loft init: approachVerbs: 4 3 setHotspot: 4 3 y: 90) ; Do, Move, Do, Move
				(pulley init: setPri: 5 approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
			)
			((IsFlag 136)
				(pulley init: view: 24205 loop: 1 posn: 174 81 setPri: 5)
			)
			(else
				(pulley init: view: 24205 loop: 0 posn: 178 76 setPri: 5)
			)
		)
		(if (> gChapter 2)
			(ladder init: setPri: 10)
			(if (< gChapter 6)
				(ladder approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
			)
			(localproc_4 24200)
		)
		(if (and (== gChapter 3) (not (IsFlag 164)))
			(harriet
				init:
				view: 3210
				x: 138
				y: 63
				setHotspot: 4 3 ; Do, Move
				cycleSpeed: 6
				setCycle: Fwd
			)
			(cyrus
				init:
				view: 3211
				setPri: 101
				setHotspot: 4 3 ; Do, Move
				cycleSpeed: 6
				setCycle: Fwd
			)
			(if (or (> (gEgo x:) 160) (< (gEgo y:) 100))
				(campfire
					approachX: (southExit approachX:)
					approachY: (southExit approachY:)
				)
			)
		)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (dispose)
		(gCurRoom drawPic: 24200 picture: 24200)
		(bringOnTheClowns doit:)
		(if (and (not (IsFlag 164)) (== gChapter 3))
			(gEgo posn: 165 96 normalize: 7)
		else
			(gEgo normalize: 3 posn: 162 120)
		)
		(self setScript: (ScriptID 0 5) 0 5) ; takeLastStep
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 2
						posn: 166 135
						cel: 0
						setLoop: 0
						setCycle: CT 12 1 self
					)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance sLeave of Script ; UNUSED
	(properties)

	(method (dispose)
		(gCurRoom newRoom: 28300)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_8)
					(gCurRoom drawPic: 24610 picture: 24610)
					(gEgo
						view: 3
						posn: 166 132
						cel: 0
						setLoop: 0
						setCycle: CT 12 1 self
					)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance downLadder of Script
	(properties)

	(method (dispose)
		(gEgo normalize: 2 posn: 175 100)
		(if (and (== gChapter 3) (IsFlag 164) (not (IsFlag 309)))
			(gEgo hide:)
			(= next afterRescue)
		)
		(if (not next)
			(= next (ScriptID 0 5)) ; takeLastStep
		)
		(if (gCast contains: bigCyrus)
			(bigCyrus dispose:)
		)
		(if (gCast contains: legs)
			(legs hide:)
		)
		(bringOnTheClowns doit:)
		(localproc_5 24200)
		(gCurRoom drawPic: 24200 picture: 24200)
		(ladder approachX: 175)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (and (== gChapter 3) (not (IsFlag 164)))
						(sHarrietWhines init:)
						(bigCyrus
							init:
							posn: 250 132
							cycleSpeed: 6
							setCycle: Osc
						)
						(localproc_3 24130)
					)
					(DoRobot 3350 115 0)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance helpMa of Script
	(properties)

	(method (dispose)
		(SetFlag 407)
		(SetFlag 324)
		(gEgo init: posn: 165 96 setScaler: Scaler 87 43 120 87 normalize: 1)
		(bringOnTheClowns doit:)
		(sHarrietWhines init:)
		(gCast eachElementDo: #show)
		(legs hide:)
		(gCurRoom drawPic: 24200 picture: 24200)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 324)
					(gCast eachElementDo: #hide)
					(ladder init:)
					(localproc_4 24370)
					(localproc_3 24370)
					(DoRobot 3213 88 24 gEgo 5)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance sComeIn of Script
	(properties)

	(method (dispose)
		(bringOnTheClowns doit:)
		(gEgo posn: 189 100 normalize: 1)
		(gCurRoom drawPic: 24200 picture: 24200)
		(SetFlag 66)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 2480 165 50)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance hearNoise of Script
	(properties)

	(method (dispose)
		(gCurRoom drawPic: 24200 picture: 24200)
		(gCast eachElementDo: #show)
		(= global163 0)
		(holePatch hide:)
		(gEgo posn: 152 98 normalize: 7)
		(gGame handsOn:)
		(global114 endPause:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(++ global164)
					(global114 pause:)
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 24360 picture: 24360)
					(DoRobot 2510 49 43)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance catJumps of Script
	(properties)

	(method (dispose)
		(global114 endPause:)
		(= global125 252)
		(gCurRoom newRoom: 24610)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(++ global164)
					(global114 pause:)
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 24360 picture: 24360)
					(DoRobot 2520 -13 2 gEgo 200)
				)
				(1
					(gCurRoom drawPic: 24690 picture: 24690)
					(DoRobot 2521 -20 -41)
				)
				(2
					(gCurRoom drawPic: 24360 picture: 24360)
					(DoRobot 2522 96 34 gEgo 200 1)
				)
				(3
					(self dispose:)
				)
			)
		)
	)
)

(instance normalStableScr of Script
	(properties)

	(method (dispose)
		(gCast eachElementDo: #show)
		(gEgo normalize: 8 posn: 147 97)
		(gCurRoom drawPic: 24200 picture: 24200)
		(holePatch hide:)
		(localproc_1 24200)
		(stables dispose:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(++ global164)
					(gCast eachElementDo: #hide)
					(holePatch init:)
					(localproc_1 24530)
					(localproc_2 24530)
					(gGame handsOff:)
					(gCurRoom drawPic: 24530 picture: 24530)
					(DoRobot 2530 97 53)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

(instance seanceScr of Script
	(properties)

	(method (dispose)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(= global115 0)
					(SetFlag 195)
					(gEgo hide:)
					(gCurRoom newRoom: 28300)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(PlayVMD 0 {5010.vmd} 0) ; Open
					(proc26_0 5010 self)
				)
				(1
					(gEgo hide:)
					(if (gEgo has: 9) ; invTarot
						(gEgo put: 9) ; invTarot
					)
					(SetFlag 195)
					(gCurRoom newRoom: 28300)
				)
			)
		)
	)
)

(instance climbLadder of Script
	(properties)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(gCurRoom newRoom: 24100)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 24130 picture: 24130)
					(if (and (== gChapter 3) (not (IsFlag 164)))
						(bigCyrus
							init:
							posn: 250 132
							cycleSpeed: 6
							setCycle: Osc
						)
						(localproc_3 24130)
					)
					(DoRobot 3300 113 12 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 24100)
				)
			)
		)
	)
)

(instance clickOnCyrus of Script
	(properties)

	(method (dispose)
		(gCast eachElementDo: #show)
		(localproc_4 24200)
		(gCurRoom drawPic: 24200 picture: 24200)
		(legs hide:)
		(gEgo posn: 165 96 normalize: 1)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 cyrus self 1)
				)
				(1
					(gCast eachElementDo: #hide)
					(localproc_3 24370)
					(ladder show:)
					(gCurRoom drawPic: 24370 picture: 24370)
					(localproc_4 24370)
					(DoRobot 3230 88 33 gEgo 1)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance clickOnCyrus2 of Script
	(properties)

	(method (dispose)
		(localproc_4 24200)
		(gCast eachElementDo: #show)
		(legs hide:)
		(gEgo posn: 165 96 normalize: 1)
		(gCurRoom drawPic: 24200 picture: 24200)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 cyrus self 1)
				)
				(1
					(gCast eachElementDo: #hide)
					(localproc_3 24370)
					(legs show:)
					(ladder show:)
					(localproc_4 24370)
					(gCurRoom drawPic: 24370 picture: 24370)
					(DoRobot 3250 84 26 gEgo 1)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance clickOnCyrus3 of Script
	(properties)

	(method (dispose)
		(localproc_4 24200)
		(gCast eachElementDo: #show)
		(legs hide:)
		(gEgo posn: 165 96 normalize: 1)
		(gCurRoom drawPic: 24200 picture: 24200)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 cyrus self 1)
				)
				(1
					(gCast eachElementDo: #hide)
					(localproc_3 24370)
					(localproc_4 24370)
					(gCurRoom drawPic: 24370 picture: 24370)
					(DoRobot 3260 100 24 gEgo 1)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance clickOnLegs of Script
	(properties)

	(method (dispose)
		(SetFlag 305)
		(gCast eachElementDo: #show)
		(localproc_4 24200)
		(legs hide:)
		(gEgo posn: 165 96 normalize: 1)
		(gCurRoom drawPic: 24200 picture: 24200)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 cyrus self 1)
				)
				(1
					(gCast eachElementDo: #hide)
					(localproc_3 24360)
					(localproc_4 24360)
					(gCurRoom drawPic: 24360 picture: 24360)
					(DoRobot 3271 77 37)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance clickOnLegs2 of Script
	(properties)

	(method (dispose)
		(SetFlag 306)
		(localproc_4 24200)
		(gCast eachElementDo: #show)
		(legs hide:)
		(gEgo posn: 165 96 normalize: 1)
		(gCurRoom drawPic: 24200 picture: 24200)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 cyrus self 1)
				)
				(1
					(gCast eachElementDo: #hide)
					(localproc_3 24360)
					(localproc_4 24360)
					(gCurRoom drawPic: 24360 picture: 24360)
					(DoRobot 3281 71 37)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance clickOnLegsOther of Script
	(properties)

	(method (dispose)
		(gCast eachElementDo: #show)
		(localproc_4 24200)
		(legs hide:)
		(gEgo posn: 165 96 normalize: 1)
		(gCurRoom drawPic: 24200 picture: 24200)
		(sHarrietWhines init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_13 cyrus self 1)
				)
				(1
					(gCast eachElementDo: #hide)
					(localproc_3 24360)
					(localproc_4 24360)
					(gCurRoom drawPic: 24360 picture: 24360)
					(DoRobot 3290 71 37)
				)
				(2
					(self dispose:)
				)
			)
		)
	)
)

(instance afterRescue of Script
	(properties)

	(method (dispose)
		(harriet dispose:)
		(cyrus dispose:)
		(gCast eachElementDo: #show)
		(localproc_4 24200)
		(localproc_5 24200)
		(global114 endPause:)
		(gEgo posn: 147 104 normalize: 2)
		(gCurRoom drawPic: 24200 picture: 24200)
		(gGame handsOn:)
		(SetFlag 309)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 309)
					(gCast eachElementDo: #hide)
					(pulley init:)
					(localproc_5 24200)
					(ladder init: show:)
					(localproc_4 24200)
					(gCurRoom drawPic: 24200 picture: 24200)
					(DoRobot 3450 91 42)
				)
				(1
					(pulley hide:)
					(localproc_4 24480)
					(gCurRoom drawPic: 24480 picture: 24480)
					(DoRobot 3451 0 35)
				)
				(2
					(ladder hide:)
					(gCurRoom drawPic: 24490 picture: 24490)
					(DoRobot 3452 23 -12)
				)
				(3
					(gCurRoom drawPic: 24530 picture: 24530)
					(DoRobot 3453 -20 -43)
				)
				(4
					(localproc_4 24480)
					(ladder show:)
					(gCurRoom drawPic: 24480 picture: 24480)
					(DoRobot 3454 0 45)
				)
				(5
					(ladder hide:)
					(gCurRoom drawPic: 24490 picture: 24490)
					(DoRobot 3455 -9 -36)
				)
				(6
					(ladder show:)
					(gCurRoom drawPic: 24480 picture: 24480)
					(DoRobot 3456 0 35)
				)
				(7
					(global114 pause:)
					(DoRobot 3457 -13 35)
				)
				(8
					(ladder hide:)
					(gCurRoom drawPic: 24540 picture: 24540)
					(DoRobot 3458 -4 -4)
				)
				(9
					(ladder show:)
					(gCurRoom drawPic: 24480 picture: 24480)
					(DoRobot 3459 -3 35)
				)
				(10
					(self dispose:)
				)
			)
		)
	)
)

(instance sLookLoft of Script
	(properties)

	(method (dispose)
		(if register
			(register dispose:)
			(= register 0)
		)
		(gCast eachElementDo: #show)
		(holePatch hide:)
		(localproc_1 24200)
		(gEgo posn: 165 97 normalize: 3)
		(gCurRoom drawPic: 24200 picture: 24200)
		(localproc_5 24200)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCurRoom drawPic: 24520 picture: 24520)
					(gCast delete: pulley ladderTip)
					(gCast eachElementDo: #hide)
					(gCast add: pulley ladderTip)
					(localproc_5 24520)
					((= register (Prop new:))
						view: 2470
						x: 121
						y: 97
						loop: 0
						cel: 0
						init:
						cycleSpeed: 6
						setCycle: End self
					)
					(holePatch init:)
					(localproc_1 24520)
					(localproc_2 24520)
				)
				(1
					(gCast eachElementDo: #hide)
					(localproc_2 24180)
					(localproc_1 24180)
					(gCurRoom drawPic: 24180 picture: 24180)
					(= seconds 6)
				)
				(2
					(localproc_2 24520)
					(localproc_1 24520)
					(gCurRoom drawPic: 24520 picture: 24520)
					(pulley show:)
					(localproc_5 24520)
					(register show: setCycle: Beg self)
					(= seconds 2)
				)
				(3
					(self dispose:)
				)
			)
		)
	)
)

(instance lookPulley of Script
	(properties)

	(method (dispose)
		(gCurRoom drawPic: 24200 picture: 24200)
		(if register
			(register dispose:)
			(= register 0)
		)
		(gCast eachElementDo: #show)
		(holePatch hide:)
		(localproc_1 24200)
		(localproc_5 24200)
		(gEgo posn: 176 91 normalize: 3)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast delete: pulley)
					(gCast eachElementDo: #hide)
					(gCast add: pulley)
					(localproc_5 24520)
					(holePatch init:)
					(localproc_2 24520)
					(localproc_1 24520)
					(gCurRoom drawPic: 24520 picture: 24520)
					((= register (Prop new:))
						view: 2545
						x: 120
						y: 96
						loop: 0
						cel: 0
						init:
						cycleSpeed: 6
						setCycle: End self
					)
				)
				(1
					(gCast delete: pulley)
					(gCast eachElementDo: #hide)
					(gCast add: pulley)
					(gCurRoom drawPic: 24210 picture: 24210)
					(localproc_5 24210)
					(= seconds 6)
				)
				(2
					(localproc_2 24520)
					(localproc_1 24520)
					(gCurRoom drawPic: 24520 picture: 24520)
					(localproc_5 24520)
					(register show: setCycle: Beg self)
				)
				(3
					(self dispose:)
				)
			)
		)
	)
)

