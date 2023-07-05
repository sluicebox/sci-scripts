;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use Inset)
(use PChase)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm420 0
)

(local
	local0
	local1
)

(instance rm420 of LBRoom
	(properties
		picture 420
		north 350
		east 430
		west 500
		vanishingX 0
	)

	(method (init)
		(gGame handsOff:)
		(LoadMany rsVIEW 420 423 424 426 831)
		(if (or (> gAct 3) (and (== gAct 3) (TimeCheck $2140 1))) ; can 2:15 am occur?
			(LoadMany rsPIC 556 429)
			(LoadMany rsSOUND 3 80 6 84)
		)
		(Load rsSOUND 19)
		(gEgo
			init:
			normalize: (if (== gAct 5) 426 else 831)
			setScale: Scaler 100 0 190 0
		)
		(if (== gAct 5)
			(if (IsFlag 34)
				(gGame handsOn:)
				(gGameMusic1 number: 16 flags: 1 setLoop: -1 play:)
				(self setRegions: 94) ; PursuitRgn
				(gCurRoom obstacles: (List new:))
				((ScriptID 2420 0) doit: (gCurRoom obstacles:)) ; poly2420Code
				(oriley init: setScale: 165 setCycle: Walk)
			else
				(self setScript: sCopyFail)
			)
		else
			(self setRegions: 90) ; MuseumRgn
		)
		(switch gPrevRoomNum
			(north
				(self setScript: sEnterNorth)
			)
			(east
				(if
					(and
						(or
							(> gAct 3)
							(and (== gAct 3) (TimeCheck $2140 1)) ; can 2:15 am occur?
						)
						(not (IsFlag 67))
					)
					(self setScript: sLookitDeadErnie 0 1)
				else
					(gGame handsOn:)
				)
				(gEgo y: 187)
			)
			(west
				(self setScript: sEnterWest)
			)
			(18
				(gEgo posn: 264 164)
				(gEgo setHeading: 180)
			)
			(else
				(gEgo posn: 185 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(= local0
			(cond
				((< gHowFast 5) 85)
				((< gHowFast 10) 60)
				((<= gHowFast 15) 35)
			)
		)
		(if (not (HaveMouse))
			(= local0 (* 2 local0))
		)
		(if (and (== gAct 5) (!= script sCopyFail))
			(oRileyTimer setTicks: 300 oRileyTimer)
		)
		(if (or (> gAct 3) (and (== gAct 3) (TimeCheck $2140 1))) ; can 2:15 am occur?
			(ernie addToPic: approachVerbs: 4 1 8) ; Do, Look, magnifier
		)
		(southExitFeature init:)
		(wall init:)
		(floor init:)
		(tuskSupport init:)
		(dinoSkeleton init:)
		(skull init:)
		(leftPic init:)
		(rightPic init:)
		(mastodon init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(self setScript: sExitNorth)
			)
			((StepOn gEgo 4)
				(gGame handsOff:)
				(gEgo edgeHit: EDGE_LEFT)
				(gCurRoom newRoom: (gCurRoom west:))
			)
		)
	)

	(method (newRoom newRoomNumber)
		(switch gAct
			(2
				(if (== newRoomNumber 350)
					(if (gGameMusic2 handle:)
						(gGameMusic2 stop:)
						(gGameMusic1 pause: 0)
					)
					(gGameMusic1 fade: 127 5 5 0)
				)
			)
			(3
				(if (and (== newRoomNumber 430) (TimeCheck $b102 1) (not (IsFlag 72))) ; can 11:15 pm occur?
					(= newRoomNumber 435)
				)
			)
			(5
				((ScriptID 94 1) setReal: (ScriptID 94 1) local0) ; pursuitTimer, pursuitTimer
				(DisposeScript 2420)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (notify)
		(if (== gAct 5)
			(if (and (gCurRoom script:) (not (== (gCurRoom script:) sDie)))
				((gCurRoom script:) next: sDie)
			else
				(gCurRoom setScript: sDie)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		y 155
		view 423
	)

	(method (cue)
		(if (not (gCurRoom script:))
			(gGame handsOff:)
			(gCurRoom setScript: sDie)
		)
	)
)

(instance ernie of View
	(properties
		x 175
		y 189
		z 71
		noun 9
		approachX 199
		approachY 180
		view 420
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(gGame points: 1 158)
		(switch theVerb
			(1 ; Look
				(if (== gAct 5)
					(gMessager say: 27) ; "You don't have time for that now! Someone's chasing you!"
				else
					(gTheIconBar disable: 7)
					(gCurRoom setScript: sDeadErnie)
				)
			)
			(8 ; magnifier
				(self doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wall of Feature
	(properties
		y 1
		noun 1
		sightAngle 40
		onMeCheck 512
	)
)

(instance floor of Feature
	(properties
		y 1
		noun 2
		sightAngle 40
		onMeCheck 1024
	)
)

(instance tuskSupport of Feature
	(properties
		y 1
		noun 3
		sightAngle 40
		onMeCheck 128
	)
)

(instance dinoSkeleton of Feature
	(properties
		y 1
		noun 4
		sightAngle 40
		onMeCheck 64
	)
)

(instance skull of Feature
	(properties
		y 1
		noun 5
		sightAngle 40
		onMeCheck 8
	)
)

(instance leftPic of Feature
	(properties
		y 1
		noun 6
		sightAngle 40
		onMeCheck 32
	)
)

(instance rightPic of Feature
	(properties
		y 1
		noun 7
		sightAngle 40
		onMeCheck 16
	)
)

(instance mastodon of Feature
	(properties
		y 1
		noun 8
		sightAngle 40
		onMeCheck 260
	)
)

(instance inDeadErnie of Inset
	(properties
		picture 429
		hideTheCast 1
	)

	(method (init)
		(super init: &rest)
		(= local1 gDoVerbCode)
		(= gDoVerbCode exitDoVerbCode)
		(proc0_8 1)
		(gWalkHandler addToFront: self)
		(feSuspenders init:)
		(feShirt init:)
		(feTusks init:)
		(feRtArm init:)
		(feLtArm init:)
		(feSupport init:)
		(feShoe init:)
		(fePants init:)
		(feEye init:)
		(feSkull init:)
		(feEar init:)
		(feNeck init:)
		(feMouth init:)
		(feHead init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(inDeadErnie dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(= gDoVerbCode local1)
		(gWalkHandler delete: self)
		(gTheIconBar enable: 7)
		(super dispose:)
	)
)

(instance exitDoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(if (== param1 13)
			(inDeadErnie dispose:)
		else
			(proc0_6 param2 param1)
		)
	)
)

(instance feSuspenders of Feature
	(properties
		y 1
		noun 11
		sightAngle 40
		onMeCheck 16384
	)
)

(instance feShirt of Feature
	(properties
		y 1
		noun 12
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(if (not (gEgo has: 25)) ; warthogHairs
					(inDeadErnie setInset: inWartHairs)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance feTusks of Feature
	(properties
		y 1
		noun 13
		sightAngle 40
		onMeCheck 4096
	)
)

(instance feRtArm of Feature
	(properties
		y 1
		noun 14
		sightAngle 40
		onMeCheck 2048
	)
)

(instance feLtArm of Feature
	(properties
		y 1
		noun 15
		sightAngle 40
		onMeCheck 1024
	)
)

(instance feSupport of Feature
	(properties
		y 1
		noun 16
		sightAngle 40
		onMeCheck 512
	)
)

(instance feShoe of Feature
	(properties
		y 1
		noun 17
		sightAngle 40
		onMeCheck 256
	)
)

(instance fePants of Feature
	(properties
		y 1
		noun 18
		sightAngle 40
		onMeCheck 128
	)
)

(instance feEye of Feature
	(properties
		y 1
		noun 19
		sightAngle 40
		onMeCheck 64
	)
)

(instance feSkull of Feature
	(properties
		y 1
		noun 20
		sightAngle 40
		onMeCheck 32
	)
)

(instance feEar of Feature
	(properties
		y 1
		noun 21
		sightAngle 40
		onMeCheck 16
	)
)

(instance feNeck of Feature
	(properties
		y 1
		noun 22
		sightAngle 40
		onMeCheck 8
	)
)

(instance feMouth of Feature
	(properties
		y 1
		noun 23
		sightAngle 40
		onMeCheck 4
	)
)

(instance feHead of Feature
	(properties
		y 1
		noun 24
		sightAngle 40
		onMeCheck 2
	)
)

(instance inWartHairs of Inset
	(properties
		view 420
		loop 1
		x 126
		y 57
		disposeNotOnMe 1
		noun 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 159)
				(gEgo get: 25) ; warthogHairs
				((ScriptID 21 0) doit: 794) ; addCluesCode, Animal Hair
				(self dispose:)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 setMotion: MoveFwd 20 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sLookitDeadErnie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gEgo setMotion: PolyPath 280 185 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Face gEgo ernie)
				(= ticks 120)
			)
			(2
				(ernie doVerb: 1)
				(if register
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 300 140
					setHeading: 180
					setMotion: MoveFwd 20 self
				)
				(if (and (== gAct 2) (not (TimeCheck $8120 1))) ; can 8:15 pm occur?
					((ScriptID 32 0) ; aHeimlich
						init:
						view: 814
						room: gCurRoomNum
						posn: 154 179
						setLoop: 8
						setCel: 6
						noun: 1
					)
					(gGameMusic1 pause:)
					(gGameMusic2 number: 19 flags: 1 setLoop: 1 play:)
				)
			)
			(1
				(cond
					((and (== gAct 2) (not (TimeCheck $8120 1))) ; can 8:15 pm occur?
						(gCurRoom setScript: sHeimlichShoos)
					)
					(
						(and
							(or
								(> gAct 3)
								(and (== gAct 3) (TimeCheck $2140 1)) ; can 2:15 am occur?
							)
							(not (IsFlag 67))
						)
						(self setScript: sLookitDeadErnie self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 2 150 setHeading: 135 setMotion: MoveFwd 20 self)
			)
			(1
				(if
					(and
						(or
							(> gAct 3)
							(and (== gAct 3) (TimeCheck $2140 1)) ; can 2:15 am occur?
						)
						(not (IsFlag 67))
					)
					(self setScript: sLookitDeadErnie self)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDeadErnie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WrapMusic pause:)
				(if (IsFlag 67)
					(fooSound number: 6 loop: -1 flags: 1 play:)
					(= cycles 1)
				else
					(SetFlag 67)
					(gCast eachElementDo: #hide)
					(DrawPic 556)
					(gAddToPics eachElementDo: #dispose release:)
					(wrapMusic init: -1 3 6)
					(sFX number: 84 flags: 5 loop: 1 play:)
					(= ticks 180)
				)
			)
			(1
				(gCurRoom setInset: inDeadErnie self)
			)
			(2
				(gCast eachElementDo: #show)
				(ernie addToPic:)
				(= cycles 2)
			)
			(3
				(fooSound fade: 0 12 30 1)
				(if (gSounds contains: (wrapMusic wrapSound:))
					(wrapMusic dispose: 1)
				)
				(WrapMusic pause: 0)
				(if (and (== gAct 3) (not (TimeCheck $2140))) ; has 2:15 am occurred?
					((ScriptID 22 0) doit: $2140) ; triggerAndClock, 2:15 am
				)
				(proc0_8 0)
				(self dispose:)
			)
		)
	)
)

(instance sHeimlichShoos of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gMessager say: 3 0 83 0 self 1889) ; "Back to ze rotunda, Fraulein. Zee rest uf ze Museum ist off-limits, und you are zpooking der masterdons."
			)
			(2
				(gEgo setMotion: PolyPath 300 142 self)
			)
			(3
				(client setScript: sExitNorth)
			)
		)
	)
)

(instance sDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oriley view: 424)
				(Face gEgo oriley)
				(= cycles 1)
			)
			(1
				(gGameMusic1 number: 3 flags: 1 loop: 1 play:)
				(= cycles 4)
			)
			(2
				(oriley cel: 0 setCycle: End self)
			)
			(3
				(sFX number: 80 flags: 5 loop: 1 play:)
				(gEgo
					view: 858
					posn: (+ (gEgo x:) 13) (gEgo y:)
					setCycle: End self
				)
			)
			(4
				(= seconds 4)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sCopyFail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 26 0 0 0 self) ; "You've failed the copy protection! I'm so ashamed by this turn of events that I refuse to go any further."
			)
			(2
				(= seconds 5)
			)
			(3
				(= global145 3) ; "The first three rules of journalism: research, research, research."
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 166
		nsLeft 314
		nsBottom 189
		nsRight 319
		cursor 14
		exitDir 2
		noun 25
	)
)

(instance oRileyTimer of Timer
	(properties)

	(method (cue)
		(oriley setMotion: PChase gEgo 20 oriley)
	)
)

(instance wrapMusic of WrapMusic
	(properties)

	(method (init)
		(= wrapSound fooSound)
		(super init: &rest)
	)
)

(instance fooSound of Sound
	(properties)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

