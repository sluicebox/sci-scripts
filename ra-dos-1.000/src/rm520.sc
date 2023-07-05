;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm520 0
	cobraLoose 1
)

(local
	[local0 2] = [0 1]
	local2
	local3
	local4
	local5 = 1
	local6 = 1
	local7
	local8
	local9 = 100
	local10
)

(instance rm520 of LBRoom
	(properties
		noun 58
		picture 520
		north 666
		south 510
		vanishingX 0
	)

	(method (init)
		(LoadMany rsVIEW 520 521 522 523 524 525 526 527 528 529 563 820 561 831)
		(LoadMany rsPIC 521 522 523)
		(LoadMany rsSOUND 520 524 521 522 523 525 441 481 49 721)
		(gEgo init: normalize: 831 setScale: Scaler 120 100 190 0)
		(self setRegions: 90) ; MuseumRgn
		(switch gPrevRoomNum
			(south
				(gEgo x: 160)
				(gGame handsOn:)
			)
			(456 ; magRosetta
				(gEgo x: 209 y: 127)
			)
			(else
				(gEgo posn: 109 125 setHeading: 62)
			)
		)
		(gGame handsOn:)
		(super init:)
		(cond
			(
				(and
					(or
						(> gAct 4)
						(and (== gAct 4) (TimeCheck $4108 1)) ; can 4:15 am occur?
					)
					(!= gPrevRoomNum 525)
					(!= gPrevRoomNum 456) ; magRosetta
					(not (TimeCheck $4108)) ; has 4:15 am occurred?
				)
				(gGameMusic2 number: 521 loop: -1 flags: 1 play:)
			)
			((!= gPrevRoomNum 456) ; magRosetta
				(gGameMusic2 number: 520 loop: -1 flags: 1 play:)
			)
		)
		(if (and (== gPrevRoomNum 525) (not (TimeCheck $4108))) ; has 4:15 am occurred?
			((Timer new:) setReal: self 2)
		)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $4108 1))) ; can 4:15 am occur?
			(if (not (IsFlag 80))
				(cobraDoor init:)
				(= local5 0)
				(= local2 sCobraLoose)
			else
				(cobra init: approachVerbs: 4 1 8 stopUpd:) ; Do, Look, magnifier
			)
		else
			(mountedSkull init: approachVerbs: 4 1 8 stopUpd:) ; Do, Look, magnifier
			(cobra init: approachVerbs: 4 1 8 stopUpd:) ; Do, Look, magnifier
		)
		(if (not (IsFlag 49))
			(rosettaCloth init: approachVerbs: 4 1 8 stopUpd:) ; Do, Look, magnifier
		)
		(if
			(and
				(or
					(< gAct 4)
					(and (== gAct 4) (not (TimeCheck $3104))) ; has 3:15 am occurred?
				)
				(not (IsFlag 48))
			)
			(snakeOil init: approachVerbs: 4 1 8 stopUpd:) ; Do, Look, magnifier
		)
		(secretDoor init: stopUpd:)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $4108 1))) ; can 4:15 am occur?
			(deadCountess init: stopUpd: approachVerbs: 1 8) ; Look, magnifier
		else
			(intercom init: stopUpd: approachVerbs: 4 1 8) ; Do, Look, magnifier
		)
		(ratBack init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(ratFore init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(rosetta init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(hieroglyphics init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(certificate init:)
		(skeletonLegs init:)
		(cobraCage init:)
		(bookShelf init:)
		(jars init:)
		(chair init:)
		(skeletonFore init:)
		(desk init:)
		(windowView init:)
		(drapes init:)
		(roachTop init:)
		(roachBottom init:)
		(displayCase init:)
		(cages init:)
		(lizards init:)
		(bookcase init:)
		(lizardTable init:)
		(standRat init:)
		(if local2
			(gCurRoom setScript: local2)
		)
		(southExitFeature init:)
	)

	(method (cue)
		(if local10
			(super newRoom: 26) ; actBreak
		else
			(gGameMusic2 number: 520)
			((ScriptID 22 0) doit: $4108) ; triggerAndClock, 4:15 am
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local4 (StepOn gEgo 16))
				(self setScript: sDropCobraGetBitten)
			)
			(
				(and
					(> (gEgo y:) 185)
					(or
						(== (gEgo view:) 522)
						(== (gEgo view:) 528)
						(== (gEgo view:) 529)
					)
				)
				(gCurRoom setScript: sDropCobraGetBitten)
			)
			((> (gEgo y:) 185)
				(= local4 1)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 456) ; magRosetta
				(super newRoom: newRoomNumber)
			)
			((and (== gAct 4) (gEgo has: 31)) ; grapes
				(= newRoomNumber 26) ; actBreak
				(WrapMusic dispose:)
				((ScriptID 22 0) doit: $001f) ; triggerAndClock
				(gGameMusic2 number: 524 loop: 1 flags: 1 play: self)
				(= local10 1)
			)
			(else
				(gGameMusic2 fade:)
				(super newRoom: newRoomNumber)
			)
		)
		((ScriptID 90 2) setPri: -1) ; aOlympia
	)
)

(instance cobra of Actor
	(properties
		x 85
		y 58
		noun 16
		approachX 78
		approachY 122
		view 521
		loop 3
		priority 2
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inCobra)
			)
			(8 ; magnifier
				(gCurRoom setInset: inCobra)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cobraLoose of Actor
	(properties
		x 77
		y 178
		view 521
		cycleSpeed 12
	)

	(method (doit)
		(if (and (not local4) (not (cobraDoor script:)) (not local5))
			(cond
				(
					(and
						local8
						(or
							(< (gEgo distanceTo: self) 40)
							(> (gEgo distanceTo: self) local9)
						)
					)
					(cobraDoor setScript: sCobraStrike)
				)
				((and (< (gEgo x:) (self x:)) local6)
					(= local6 0)
					(self setScript: sCobraTurn)
				)
				((and (> (gEgo x:) (self x:)) (not local6))
					(= local6 1)
					(self setScript: sCobraTurn)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; snakeOil
				(switch local3
					(0
						(if (< (gEgo y:) 152)
							(gEgo setMotion: MoveTo 158 130)
							(= local3 1)
						else
							(gEgo setMotion: MoveTo 160 189)
							(= local3 11)
						)
					)
					(else
						(if (gEgo has: 14) ; snakeOil
							(++ local3)
						)
					)
				)
				(cond
					((or (> local3 13) (and (> local3 3) (< local3 9)))
						(= global150 0)
						(-- local3)
						(gMessager say: 30 0 5) ; "That's it...I'm out of oil. Now what?"
					)
					((> global150 0)
						(-- global150)
						(cobraDoor setScript: sLauraOil)
					)
					(else
						(gMessager say: 30 0 5) ; "That's it...I'm out of oil. Now what?"
					)
				)
			)
			(30 ; snakeLasso
				(switch local3
					(3
						(gEgo setScript: 0)
						(= local4 1)
						(cobraDoor setScript: sLauraLasso3)
					)
					(13
						(gEgo setScript: 0)
						(= local4 1)
						(cobraDoor setScript: sLauraLasso13)
					)
					(else
						(cobraDoor setScript: sCobraStrike)
					)
				)
			)
			(4 ; Do
				(cobraDoor setScript: sCobraStrike)
			)
			(1 ; Look
				(gCurRoom setScript: sShowCobraLoose)
			)
			(8 ; magnifier
				(gCurRoom setScript: sShowCobraLoose)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cobraDoor of Prop
	(properties
		x 108
		y 28
		noun 29
		view 521
		loop 8
		cel 6
		priority 2
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self doVerb: 30)
			)
			(30 ; snakeLasso
				(cond
					(local4
						(self setScript: sPutCobraBack)
					)
					((== (self cel:) 0)
						(self setCycle: End)
					)
					(else
						(self setCycle: Beg)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bigCobra of View
	(properties
		x 34
		y 79
		view 521
		loop 13
		cel 3
		priority 15
		signal 16
	)
)

(instance rosettaCloth of View
	(properties
		x 223
		y 105
		noun 21
		approachX 210
		approachY 131
		view 521
		loop 13
		priority 9
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(or
						(== (gEgo view:) 522)
						(== (gEgo view:) 528)
						(== (gEgo view:) 529)
					)
					(gMessager say: 58 0 7) ; "Laura, you have a big snake to attend to. Don't do that."
				else
					(gCurRoom setScript: sRemoveCloth)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance snakeOil of View
	(properties
		x 113
		y 104
		z 10
		noun 30
		approachX 130
		approachY 145
		view 520
		loop 3
		priority 8
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inSnakeOil)
			)
			(8 ; magnifier
				(self doVerb: 1)
			)
			(4 ; Do
				(self doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mountedSkull of Prop
	(properties
		x 98
		y 74
		noun 31
		approachX 91
		approachY 141
		view 520
		loop 4
		priority 8
		signal 16
		cycleSpeed 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(
						(or
							(== (gEgo view:) 522)
							(== (gEgo view:) 528)
							(== (gEgo view:) 529)
						)
						(gMessager say: 58 0 7) ; "Laura, you have a big snake to attend to. Don't do that."
					)
					((MuseumRgn nobodyAround:)
						(self setScript: sSecretDoor)
					)
					(else
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance secretDoor of Prop
	(properties
		x 294
		y 159
		view 524
		loop 1
		cycleSpeed 12
	)
)

(instance intercom of View
	(properties
		x 179
		y 96
		noun 32
		approachX 152
		approachY 135
		view 520
		loop 3
		cel 1
		priority 8
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: inIntercom)
			)
			(8 ; magnifier
				(self doVerb: 1)
			)
			(4 ; Do
				(self doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deadCountess of View
	(properties
		x 111
		y 89
		heading 90
		noun 33
		approachX 109
		approachY 125
		view 524
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local5
					(gEgo setHeading: 62)
					(gGame points: 1 163)
					(gCurRoom newRoom: 525)
				else
					(gMessager say: 58 0 7) ; "Laura, you have a big snake to attend to. Don't do that."
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

(instance ratFore of Feature
	(properties
		x 281
		y 200
		noun 14
		onMeCheck 4
		approachX 225
		approachY 171
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(gCurRoom setInset: inRatFore)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ratBack of Feature
	(properties
		x 88
		y 21
		noun 14
		nsTop 14
		nsLeft 74
		nsBottom 29
		nsRight 103
		approachX 80
		approachY 113
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(gCurRoom setInset: inRatBack)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rosetta of Feature
	(properties
		x 293
		y 104
		heading 90
		noun 34
		sightAngle 40
		onMeCheck 256
		approachX 210
		approachY 131
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(8 ; magnifier
				(if
					(or
						(== (gEgo view:) 522)
						(== (gEgo view:) 528)
						(== (gEgo view:) 529)
					)
					(gMessager say: 58 0 7) ; "Laura, you have a big snake to attend to. Don't do that."
				else
					(gGame points: 1 137)
					((ScriptID 21 0) doit: 1025) ; addCluesCode, Hieroglyphs
					(for ((= temp0 14)) (< temp0 27) ((++ temp0))
						((ScriptID 21 0) doit: (+ temp0 1088)) ; addCluesCode
					)
					(gCurRoom newRoom: 456) ; magRosetta
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance certificate of Feature
	(properties
		y 1
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(cond
					((and (<= 188 gMouseX 206) (<= 20 gMouseY 43))
						(= x 197)
						(= y 31)
						(= z 0)
						(= noun 2)
					)
					((and (<= 185 gMouseX 210) (<= 51 gMouseY 72))
						(= x 197)
						(= y 61)
						(= z 0)
						(= noun 3)
					)
					((and (<= 222 gMouseX 240) (<= 17 gMouseY 37))
						(= x 231)
						(= y 27)
						(= z 0)
						(= noun 4)
					)
					((and (<= 246 gMouseX 274) (<= 15 gMouseY 38))
						(= x 260)
						(= y 26)
						(= z 0)
						(= noun 5)
					)
				)
			)
		)
	)
)

(instance skeletonLegs of Feature
	(properties
		x 302
		y 134
		noun 6
		nsLeft 285
		nsBottom 68
		nsRight 319
		sightAngle 40
	)
)

(instance cobraCage of Feature
	(properties
		x 93
		y 46
		noun 7
		nsTop 29
		nsLeft 78
		nsBottom 63
		nsRight 109
		sightAngle 40
		approachX 81
		approachY 116
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local4
					(cobraDoor setScript: sPutCobraBack)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(30 ; snakeLasso
				(self doVerb: 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bookShelf of Feature
	(properties
		x 91
		y 70
		noun 8
		nsTop 65
		nsLeft 78
		nsBottom 76
		nsRight 104
		sightAngle 40
	)
)

(instance jars of Feature
	(properties)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(cond
					((and (<= 81 gMouseX 88) (<= 79 gMouseY 90))
						(= x 85)
						(= y 83)
						(= z 0)
						(= noun 9)
					)
					((and (<= 92 gMouseX 101) (<= 79 gMouseY 87))
						(= x 96)
						(= y 83)
						(= z 0)
						(= noun 10)
					)
					((and (<= 80 gMouseX 90) (<= 90 gMouseY 97))
						(= x 85)
						(= y 93)
						(= z 0)
						(= noun 11)
					)
				)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 144
		y 82
		noun 12
		nsTop 76
		nsLeft 134
		nsBottom 88
		nsRight 154
		sightAngle 40
	)
)

(instance skeletonFore of Feature
	(properties
		x 260
		y 164
		noun 13
		sightAngle 40
		onMeCheck 2
	)
)

(instance desk of Feature
	(properties
		y 88
		noun 15
		sightAngle 40
		onMeCheck 8
	)
)

(instance windowView of Feature
	(properties
		y 47
		noun 28
		sightAngle 40
		onMeCheck 16
	)
)

(instance drapes of Feature
	(properties
		y 12
		noun 17
		sightAngle 40
		onMeCheck 32
	)
)

(instance roachTop of Feature
	(properties
		y 55
		noun 18
		sightAngle 40
		onMeCheck 64
	)
)

(instance roachBottom of Feature
	(properties
		y 102
		noun 19
		sightAngle 40
		onMeCheck -32768
	)
)

(instance displayCase of Feature
	(properties
		x 320
		y 77
		noun 20
		sightAngle 40
		onMeCheck 128
	)
)

(instance cages of Feature
	(properties
		x 320
		y 128
		noun 22
		sightAngle 40
		onMeCheck 512
	)
)

(instance lizards of Feature
	(properties
		y 180
		noun 23
		sightAngle 40
		onMeCheck 1024
	)
)

(instance bookcase of Feature
	(properties
		y 1
		noun 25
		sightAngle 40
		onMeCheck 4096
	)
)

(instance lizardTable of Feature
	(properties
		y 183
		noun 26
		sightAngle 40
		onMeCheck 8192
	)
)

(instance standRat of Feature
	(properties
		x 260
		y 180
		noun 27
		sightAngle 40
		onMeCheck 16384
	)
)

(instance inCobra of Inset
	(properties
		view 521
		loop 13
		cel 1
		x 77
		y 23
		disposeNotOnMe 1
		noun 54
	)

	(method (init)
		(if (not (or (> gAct 4) (and (== gAct 4) (TimeCheck $4108 1)))) ; can 4:15 am occur?
			(fang init:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if
					(or
						(> gAct 4)
						(and (== gAct 4) (TimeCheck $4108 1)) ; can 4:15 am occur?
					)
					(gMessager say: noun 1 8) ; "The cobra displays one deadly fang. He seems to mean business."
				else
					(gMessager say: noun 1 9) ; "It's Barney, Olympia's pet cobra."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(fang dispose:)
		(super dispose:)
	)
)

(instance hieroglyphics of Feature
	(properties
		x 250
		y 65
		heading 90
		noun 24
		sightAngle 90
		onMeCheck 2048
		approachX 210
		approachY 131
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if
					(or
						(== (gEgo view:) 522)
						(== (gEgo view:) 528)
						(== (gEgo view:) 529)
					)
					(gMessager say: 58 0 7) ; "Laura, you have a big snake to attend to. Don't do that."
				else
					(gGame handsOff:)
					(gCurRoom setScript: sHieroglyphics)
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

(instance fang of View
	(properties
		x 93
		y 32
		view 521
		loop 13
		cel 2
		priority 15
		signal 16
	)
)

(instance inSnakeOil of Inset
	(properties
		view 520
		loop 2
		x 127
		y 33
		priority 15
		disposeNotOnMe 1
		noun 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gCurRoom setScript: sOlympiaOil)
		(super dispose:)
	)
)

(instance inIntercom of Inset
	(properties
		view 520
		x 162
		y 79
		disposeNotOnMe 1
		noun 39
	)
)

(instance inRatFore of Inset
	(properties
		view 520
		loop 1
		x 232
		y 147
		priority 15
		disposeNotOnMe 1
		noun 40
	)
)

(instance inRatBack of Inset
	(properties
		view 520
		loop 1
		x 72
		y 6
		disposeNotOnMe 1
		noun 41
	)
)

(instance inHieroglyphics of Inset
	(properties
		picture 522
		noun 24
	)

	(method (init)
		(super init: &rest)
		(proc0_8 1)
		(gWalkHandler addToFront: self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= picture (if (== picture 522) 523 else 522))
				(sFX number: 525 flags: 1 play:)
				(DrawPic picture (if (== picture 522) 11 else 12))
			)
			(13 ; Exit Icon
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(proc0_8 0)
		(super dispose:)
	)
)

(instance sHieroglyphics of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic2 fade: 80 20 20 0)
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #hide)
				(gGame handsOff:)
				(User canInput: 1)
				(gTheIconBar enable: 0 2 1)
				(gCurRoom setInset: inHieroglyphics self)
			)
			(2
				(if (not (gEgo has: 14)) ; snakeOil
					(snakeOil show:)
				)
				(gGame handsOn:)
				(gCast eachElementDo: #show)
				(= cycles 1)
			)
			(3
				(gGameMusic2 fade: 127 20 20 0)
				(self dispose:)
			)
		)
	)
)

(instance sRemoveCloth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 215 126 self)
			)
			(1
				(rosettaCloth dispose:)
				(SetFlag 49)
				(gEgo view: 521 setLoop: 14 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo normalize: 831 setHeading: 90)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOlympiaOil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo stopUpd:)
				(if (== ((ScriptID 90 2) room:) gCurRoomNum) ; aOlympia
					((ScriptID 90 2) ; aOlympia
						setPri: 13
						setMotion: DPath 128 183 102 160 95 125 self
					)
				else
					((ScriptID 90 2) ; aOlympia
						moveTo: gCurRoomNum
						posn: 170 250
						setPri: 13
						setMotion: DPath 128 183 102 160 95 125 self
					)
				)
			)
			(1
				(Face (ScriptID 90 2) gEgo) ; aOlympia
				(= cycles 1)
			)
			(2
				(SetFlag 48)
				((ScriptID 90 2) ; aOlympia
					view: 525
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(snakeOil dispose:)
				((ScriptID 90 2) setCycle: Beg self) ; aOlympia
			)
			(5
				((ScriptID 90 2) ; aOlympia
					view: 820
					setLoop: -1
					setCycle: Walk
					setMotion:
						MoveTo
						(+ ((ScriptID 90 2) x:) 10) ; aOlympia
						((ScriptID 90 2) y:) ; aOlympia
						self
				)
			)
			(6
				((ScriptID 90 2) setHeading: 180) ; aOlympia
				(= cycles 1)
			)
			(7
				((ScriptID 90 2) setCycle: StopWalk -1) ; aOlympia
				(= ticks 120)
			)
			(8
				(gMessager say: 1 0 1 0 self 1520) ; "Good evening, Miss Bow!"
			)
			(9
				((ScriptID 90 2) ; aOlympia
					view: 820
					setCycle: Walk
					setMotion: DPath 102 160 128 183 170 250 self
				)
			)
			(10
				((ScriptID 90 2) moveTo: -2) ; aOlympia
				(gEgo startUpd:)
				((Inv at: 14) owner: 0) ; snakeOil
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCobraLoose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= ticks 180)
			)
			(2
				(sFX number: 522 flags: 1 play:)
				(= cycles 2)
			)
			(3
				(gEgo setHeading: 270)
				(= ticks 60)
			)
			(4
				(cobraLoose
					init:
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 86 158 self
				)
			)
			(5
				(Face gEgo cobraLoose)
				(cobraLoose setCycle: End self)
			)
			(6
				(cobraLoose
					setLoop: 9
					setCel: 0
					posn: 90 159
					setCycle: End self
				)
			)
			(7
				(cobraLoose setLoop: 11 setCel: 0 posn: 92 159 setCycle: Fwd)
				(= ticks 30)
			)
			(8
				(sFX number: 522 flags: 1 play:)
				(bigCobra init:)
				(= ticks 180)
			)
			(9
				(bigCobra dispose:)
				(= local8 1)
				(gEgo setScript: sCobraTimer)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowCobraLoose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sFX number: 522 flags: 1 play:)
				(bigCobra
					init:
					x: (- (cobraLoose x:) 58)
					y: (- (cobraLoose y:) 80)
				)
				(= ticks 180)
			)
			(1
				(bigCobra dispose:)
				(= ticks 60)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLauraOil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScript: 0)
				(if (< local3 9)
					(gEgo setMotion: PolyPath 158 130 self)
				else
					(gEgo setMotion: PolyPath 160 179 self)
				)
			)
			(1
				(switch local3
					(1
						(= local7 0)
					)
					(2
						(= local7 0)
					)
					(3
						(= local7 1)
					)
					(11
						(= local7 2)
					)
					(12
						(= local7 2)
					)
					(13
						(= local7 3)
					)
				)
				(gEgo view: 522 setLoop: local7 setCel: 0 setCycle: End self)
			)
			(2
				(switch local3
					(1
						(cobraLoose setLoop: 0 setMotion: MoveTo 147 177 self)
					)
					(2
						(cobraLoose setLoop: 0 setMotion: MoveTo 213 171 self)
					)
					(3
						(= local9 120)
						(cobraLoose setLoop: 0 setMotion: MoveTo 260 150 self)
					)
					(11
						(cobraLoose setLoop: 0 setMotion: MoveTo 128 134 self)
					)
					(12
						(cobraLoose setLoop: 0 setMotion: MoveTo 187 133 self)
					)
					(13
						(cobraLoose
							setLoop: 15
							setMotion: PolyPath 207 107 self
						)
					)
				)
			)
			(3
				(gEgo normalize: 831)
				(Face gEgo cobraLoose)
				(= cycles 1)
			)
			(4
				(cobraLoose setLoop: 4 setCel: 0 setCycle: End self)
			)
			(5
				(if (< (cobraLoose x:) (gEgo x:))
					(cobraLoose setLoop: 9 setCel: 0 setCycle: End self)
				else
					(cobraLoose setLoop: 10 setCel: 0 setCycle: End self)
				)
			)
			(6
				(if (< (cobraLoose x:) (gEgo x:))
					(cobraLoose setLoop: 11 setCel: 0 setCycle: Fwd)
				else
					(cobraLoose setLoop: 12 setCel: 0 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(7
				(if (< (gEgo x:) (cobraLoose x:))
					(= local6 0)
				else
					(= local6 1)
				)
				(gEgo setScript: sCobraTimer)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLauraLasso3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 216 151 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo view: 522 setCycle: 0 setLoop: 5 setCel: 0)
				(= ticks 30)
			)
			(3
				(cobraLoose setLoop: 3 setCel: 0 setCycle: 0)
				(= cycles 1)
			)
			(4
				(gEgo setCycle: CT 3 1 self)
			)
			(5
				(cobraLoose hide: dispose:)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					view: 528
					setLoop: 0
					setCel: 0
					posn: 220 152
					setLoop: -1
					setCycle: StopWalk 529
				)
				(= ticks 60)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLauraLasso13 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 1)
				(gEgo normalize: 831 setMotion: MoveTo 209 127 self)
			)
			(1
				(gEgo
					view: 522
					setScale: Scaler 110 90 190 0
					setLoop: 6
					setCel: 0
					setCycle: StopWalk
				)
				(= cycles 1)
			)
			(2
				(cobraLoose hide: dispose:)
				(gEgo view: 522 setLoop: 6 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					view: 528
					setLoop: 3
					setCel: 6
					posn: 211 128
					setLoop: -1
					setCycle: StopWalk 529
				)
				(= ticks 60)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCobraStrike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo cobraLoose)
				(= local4 1)
				(cobraLoose illegalBits: 0 ignoreActors: 1)
				(if local6
					(cobraLoose
						setLoop: 0
						setCycle: Fwd
						setMotion:
							PolyPath
							(- (gEgo x:) 34)
							(+ (gEgo y:) 10)
							self
					)
				else
					(cobraLoose
						setLoop: 1
						setCycle: Fwd
						setMotion:
							PolyPath
							(+ (gEgo x:) 35)
							(+ (gEgo y:) 11)
							self
					)
				)
			)
			(1
				(gGameMusic2 stop:)
				(sFX number: 523 flags: 1 play:)
				(if local6
					(cobraLoose
						setLoop: 2
						setCel: 0
						posn: (- (gEgo x:) 21) (+ (gEgo y:) 6)
						setCycle: CT 4 1 self
					)
				else
					(cobraLoose
						setLoop: 3
						setCel: 0
						posn: (+ (gEgo x:) 21) (+ (gEgo y:) 7)
						setCycle: CT 4 1 self
					)
				)
			)
			(2
				(cobraLoose setCycle: End self)
				(sFX number: 481 flags: 5 setLoop: 1 play:)
			)
			(3
				(gEgo
					view: 523
					setLoop: 0
					setCel: 0
					posn: (+ (gEgo x:) 15) (+ (gEgo y:) 1)
					setCycle: End self
				)
			)
			(4
				(= global145 11) ; "Your dying thought is, "Venom I ever going to learn?""
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sPutCobraBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 0)
				(gEgo setCycle: Walk setMotion: PolyPath 132 95 self)
			)
			(1
				(gEgo
					view: 522
					setLoop: 4
					setCel: 0
					posn: 126 98
					setCycle: CT 6 1 self
				)
			)
			(2
				(cobraDoor setCycle: End self)
			)
			(3
				(gGameMusic2 fade:)
				(gEgo setCycle: CT 9 1 self)
			)
			(4
				(cobra init: stopUpd:)
				(= cycles 1)
			)
			(5
				(gEgo setCycle: End)
				(cobraDoor setCycle: Beg self)
			)
			(6
				(sFX number: 441 flags: 5 setLoop: 1 play:)
				(gGame points: 1 164)
				(= local5 1)
				(SetFlag 80)
				(cobraLoose hide:)
				(gEgo
					normalize: 831
					setScale: Scaler 120 100 190 0
					signal: 16384
					setHeading: 270
				)
				(gGameMusic2 number: 520 loop: -1 flags: 1 play:)
				(= cycles 1)
			)
			(7
				(cobraDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDropCobraGetBitten of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 0)
				(gEgo view: 522 setLoop: 7 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(cobraLoose
					show:
					setLoop: 4
					setCel: 3
					x: (+ (gEgo x:) 4)
					y: (+ (gEgo y:) 3)
				)
				(gEgo view: 523 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(= global145 11) ; "Your dying thought is, "Venom I ever going to learn?""
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sCobraTurn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local6
					(cobraLoose setLoop: 5 setCel: 0 setCycle: End self)
				else
					(cobraLoose setLoop: 4 setCel: 0 setCycle: End self)
				)
			)
			(1
				(if local6
					(cobraLoose setLoop: 11 setCel: 0 setCycle: End self)
				else
					(cobraLoose setLoop: 12 setCel: 0 setCycle: End self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sCobraTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
			)
			(1
				(gEgo setScript: sCobraStrike)
				(self dispose:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsLeft 115
		nsBottom 189
		nsRight 245
		cursor 11
		exitDir 3
		noun 57
	)
)

(instance sSecretDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 93 122 self)
			)
			(1
				(Face gEgo mountedSkull)
				(= cycles 4)
			)
			(2
				(gEgo view: 561 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo cycleSpeed: 12 setCycle: Beg self)
				(sFX number: 49 flags: 5 setLoop: 1 play:)
				(mountedSkull setCycle: End self)
			)
			(4 0)
			(5
				(gEgo normalize: 831)
				(Face gEgo secretDoor)
				(sFX number: 721 flags: 5 setLoop: 1 play:)
				(secretDoor setCycle: End self)
			)
			(6
				(sFX stop:)
				(gEgo setMotion: PolyPath 315 167 self)
			)
			(7
				(gEgo setMotion: MoveTo 330 167 self)
			)
			(8
				(gEgo setPri: 2)
				(sFX number: 721 flags: 5 setLoop: 1 play:)
				(secretDoor setCycle: Beg self)
			)
			(9
				(sFX stop:)
				(secretDoor stopUpd:)
				(gCurRoom newRoom: (gCurRoom north:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

