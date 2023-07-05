;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 454)
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
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm454 0
)

(local
	local0 = 100
	local1
	local2
)

(instance rm454 of LBRoom
	(properties
		noun 11
		picture 454
		style 11
		east 450
		vanishingY 20
	)

	(method (init)
		(LoadMany rsVIEW 423 451 858 424 454)
		(LoadMany rsSOUND 1 451 452 453 450)
		(LoadMany rsSCRIPT 2450)
		(switch gPrevRoomNum
			(666
				(gGame handsOff:)
				(gGameMusic2 number: 450 flags: 1 loop: -1 play:)
				(Palette palSET_INTENSITY 0 255 100)
				(= style 100)
				(gEgo
					normalize: 831
					x: 211
					y: 120
					loop: 2
					setScale: Scaler 131 30 190 21
					init:
				)
				(lid1 init: stopUpd: approachVerbs: 1 4 2 6 setPri: 7) ; Look, Do, Talk, Ask
				(gCurRoom setScript: sEnterTunnel)
			)
			(455
				(gGame handsOff:)
				(= style 100)
				(gEgo
					ignoreActors:
					x: 248
					y: 121
					view: 454
					loop: 2
					cel: (gEgo lastCel:)
					init:
				)
				(gCurRoom setScript: sFinishIt)
			)
			(456 ; magRosetta
				(= style 100)
				(gGame handsOn:)
				(gEgo
					init:
					posn: 96 135
					setScale: Scaler 131 30 190 21
					normalize: 831
				)
				(lid1 init: stopUpd: approachVerbs: 1 4 2 6 setPri: 7) ; Look, Do, Talk, Ask
			)
			(else
				(gEgo
					init:
					posn: 160 160
					setScale: Scaler 131 30 190 21
					normalize: (if (== gAct 5) 426 else 831)
				)
				(lid1 init: stopUpd: approachVerbs: 1 4 2 6 setPri: 7) ; Look, Do, Talk, Ask
				(gGame handsOn:)
			)
		)
		(if (== gAct 5)
			(cond
				((< gHowFast 5)
					(= local2 85)
				)
				((< gHowFast 10)
					(= local2 60)
				)
				((<= gHowFast 15)
					(= local2 35)
				)
			)
			(if (not (HaveMouse))
				(= local2 (* 2 local2))
			)
			(self setRegions: 94) ; PursuitRgn
			(gCurRoom obstacles: (List new:))
			((ScriptID 2454 0) doit: (gCurRoom obstacles:)) ; poly2454Code
		else
			(self setRegions: 90) ; MuseumRgn
		)
		(super init:)
		(if (or (and (== gAct 2) (TimeCheck $8120 1)) (> gAct 2)) ; can 8:15 pm occur?
			(blood init: approachVerbs: 1 4 8 stopUpd: cel: global127) ; Look, Do, magnifier
			(footprint init: stopUpd: approachVerbs: 1 4 8) ; Look, Do, magnifier
			(if (and (== gAct 2) (TimeCheck $8120 1)) ; can 8:15 pm occur?
				(deadPippin init: stopUpd: setPri: 6)
			)
			(if (not (gEgo has: 20)) ; ankhMedallion
				(medallion init: stopUpd: approachVerbs: 1 4 8) ; Look, Do, magnifier
			)
		)
		(lid2
			init:
			stopUpd:
			cel: (if global115 3 else 2)
			approachVerbs: 1 4 2 6 ; Look, Do, Talk, Ask
			setPri: 7
		)
		(poster init: approachVerbs: 1 4) ; Look, Do
		(post init: approachVerbs: 1 4) ; Look, Do
		(mummy1 init: approachVerbs: 1 4 2 6) ; Look, Do, Talk, Ask
		(secretDoor1 init: approachVerbs: 1 4 2 6) ; Look, Do, Talk, Ask
		(secretDoor2 init: approachVerbs: 1 4 2 6) ; Look, Do, Talk, Ask
		(mummy3 init: approachVerbs: 1 4 2 6) ; Look, Do, Talk, Ask
		(rosetta init: approachVerbs: 1 4 6 2 8) ; Look, Do, Ask, Talk, magnifier
		(pyramid init:)
		(pyramid2 init:)
		(eastExitFeature init:)
	)

	(method (notify)
		(if (== gAct 5)
			(if (gCurRoom script:)
				((gCurRoom script:) next: sDie)
			else
				(gCurRoom setScript: sDie)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (< global127 6) (== gAct 2) (TimeCheck $8120 1)) ; can 8:15 pm occur?
			(++ global127)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(DisposeScript 2454)
		(super dispose: &rest)
	)
)

(instance sEnterTunnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(secretDoor1
					setMotion: MoveTo (- (secretDoor1 x:) 10) (secretDoor1 y:)
				)
				(secretDoor2
					setMotion:
						MoveTo
						(+ (secretDoor2 x:) 8)
						(secretDoor2 y:)
						self
				)
			)
			(2
				(gEgo setMotion: MoveFwd 25 self)
			)
			(3
				(secretDoor1
					setMotion: MoveTo (+ (secretDoor1 x:) 10) (secretDoor1 y:)
				)
				(secretDoor2
					setMotion:
						MoveTo
						(- (secretDoor2 x:) 8)
						(secretDoor2 y:)
						self
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
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
				(gEgo setMotion: PolyPath 180 160 self)
			)
			(1
				(oriley
					init:
					setScale: Scaler 131 30 190 21
					setCycle: Walk
					setMotion: PChase gEgo 22 self
				)
				(gGameMusic1 number: 3 flags: 1 loop: 1 play:)
			)
			(2
				(oriley view: 424)
				(oriley cel: 0)
				(Face gEgo oriley)
				(Face oriley gEgo)
				(= cycles 4)
			)
			(3
				(oriley setCycle: End self)
			)
			(4
				(thudSound play:)
				(gEgo view: 858 setCycle: End self)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sOpenRedCoffin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lid1 hide:)
				(gEgo
					view: 454
					setLoop: 2
					cel: 0
					posn: 248 121
					cycleSpeed: 6
					setCycle: End self
				)
				(nCreak number: 452 play:)
			)
			(1
				(gMessager say: 6 4 (if (== gAct 5) 1 else 2) 0 self)
			)
			(2
				(gEgo setCycle: Beg self)
				(nCreak number: 453 play:)
			)
			(3
				(nCreak number: 455 play:)
				(lid1 show:)
				(gEgo normalize: 831)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHandleTheCase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= global115 1)
				else
					(= global115 0)
				)
				(gGame handsOff:)
				(lid2 hide:)
				(gEgo
					view: 454
					loop: 3
					cel:
						(if register
							0
						else
							(gEgo lastCel:)
						)
					posn: 184 122
					cycleSpeed: 6
					setCycle: (if register End else Beg) self
				)
				(nCreak number: (if register 452 else 453) play:)
			)
			(1
				(if (not register)
					(nCreak number: 455 play:)
				)
				(lid2 cel: (if register 3 else 2) stopUpd: show:)
				(gEgo normalize: 831)
				(gEgo setHeading: 0)
				(= seconds 3)
			)
			(2
				(if (!= gAct 5)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sORileyComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oriley
					init:
					setScale: Scaler 131 30 190 21
					setCycle: Walk
					setMotion: PolyPath 300 172 self
				)
			)
			(1
				(= seconds 4)
			)
			(2
				(oriley setMotion: PolyPath 340 172 self)
			)
			(3
				((ScriptID 94 1) setReal: (ScriptID 94 1) local2) ; pursuitTimer, pursuitTimer
				(SetFlag 47)
				(self dispose:)
			)
		)
	)
)

(instance sHide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 number: 17 flags: 1 loop: -1 play:)
				(gGame handsOff:)
				(SetFlag 90)
				(if (IsFlag 39)
					((ScriptID 94 1) dispose: delete:) ; pursuitTimer
				)
				(if global115
					(= cycles 1)
				else
					(self setScript: sHandleTheCase self 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo 178 120 self)
			)
			(2
				(gEgo setHeading: 180)
				(= cycles 1)
			)
			(3
				(lid2 hide:)
				(gEgo
					view: 454
					loop: 4
					cel: 0
					setPri: 6
					posn: 184 122
					setCycle: End self
				)
				(nCreak number: 453 play:)
			)
			(4
				(nCreak number: 455 play:)
				(if (IsFlag 39)
					(self setScript: sORileyComes self)
				else
					(= ticks 120)
				)
			)
			(5
				(gEgo setCycle: Beg self)
				(nCreak number: 452 play:)
			)
			(6
				(lid2 show:)
				(gEgo normalize: 426)
				(= seconds 3)
			)
			(7
				(if (IsFlag 39)
					(gMessager say: 16 0 0 0 self) ; "You hear the sound of someone breaking down a door in the next room!"
					(gGameMusic2 number: 444 flags: 5 loop: 1 play:)
				else
					(= cycles 1)
				)
				(gEgo show:)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(8
				(= global115 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetAnkh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 451 loop: 4 cel: 0 setCycle: CT 5 1 self)
			)
			(1
				(medallion dispose:)
				(gEgo setCycle: End self)
				(gEgo get: 20) ; ankhMedallion
			)
			(2
				(gEgo normalize: 831)
				((ScriptID 21 0) doit: 789) ; addCluesCode, Ankh Medallion
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFinishIt of Script
	(properties)

	(method (doit)
		(if (and local1 local0)
			(Palette palSET_INTENSITY 0 255 (-- local0))
			(if (not local0)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic1 number: 450 flags: 1 loop: -1 play:)
				(= cycles 2)
			)
			(1
				(oriley view: 818 posn: 330 160 init:)
				(= cycles 1)
			)
			(2
				(oriley setCycle: StopWalk -1 setMotion: PChase gEgo 22 self)
			)
			(3
				(= cycles 5)
			)
			(4
				(lid1 init: stopUpd: cel: 1)
				(gEgo
					normalize: 831
					setScale: Scaler 131 30 190 21
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 10)
				)
				(Face gEgo oriley)
				(= cycles 5)
			)
			(5
				((ScriptID 22 0) doit: $8120) ; triggerAndClock, 8:15 pm
				(= seconds 10)
			)
			(6
				(gMessager say: 13 0 0 0 self) ; "You scream like a banshee, lass! Did you kill the man, then?"
			)
			(7
				(= local1 1)
				(gTheIconBar disable: 7)
				(gGameMusic1 number: 454 flags: 1 loop: 1 play: self)
			)
			(8 0)
			(9
				(gCurRoom newRoom: 26) ; actBreak
			)
		)
	)
)

(instance sUhOh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lid1 hide:)
				(gEgo
					view: 454
					setLoop: 2
					cel: 0
					posn: 248 121
					cycleSpeed: 6
					setCycle: 0
				)
				(= cycles 1)
			)
			(1
				(gGameMusic2 number: 451 flags: 1 loop: 1 play: self)
			)
			(2
				(gEgo setCycle: End self)
				(nCreak number: 452 play: self)
			)
			(3 0)
			(4
				(lid1 cel: 1 stopUpd: show:)
				(gCurRoom newRoom: 455)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		x 340
		y 172
		view 423
	)
)

(instance secretDoor1 of Actor
	(properties
		x 211
		y 121
		noun 5
		approachX 213
		approachY 130
		view 454
		loop 6
		signal 18432
	)
)

(instance secretDoor2 of Actor
	(properties
		x 212
		y 121
		noun 5
		approachX 213
		approachY 130
		view 454
		loop 6
		cel 1
		signal 18432
	)
)

(instance lid1 of Prop
	(properties
		x 248
		y 121
		noun 6
		view 454
		loop 5
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (and (== gAct 2) (TimeCheck $8120 1)) ; can 8:15 pm occur?
					(gCurRoom setScript: sUhOh)
				else
					(gCurRoom setScript: sOpenRedCoffin)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lid2 of Prop
	(properties
		x 184
		y 122
		noun 4
		view 454
		loop 5
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(global115
						(gCurRoom setScript: sHandleTheCase 0 0)
					)
					((and (== gAct 5) (not (IsFlag 90)))
						(gCurRoom setScript: sHide)
					)
					((== gAct 5)
						(gMessager say: 15 4 1) ; "You're in too much of a hurry to do that again."
					)
					(else
						(gCurRoom setScript: sHandleTheCase 0 1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadPippin of View
	(properties
		x 244
		y 118
		view 454
		loop 1
		signal 16384
	)
)

(instance footprint of View
	(properties
		x 228
		y 128
		approachX 214
		approachY 126
		view 451
		loop 3
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(8 ; magnifier
				(gCurRoom setInset: inFootPrint)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance medallion of View
	(properties
		x 227
		y 122
		noun 1
		approachX 214
		approachY 126
		view 451
		loop 3
		cel 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(8 ; magnifier
				(gGame points: 1 136)
				(gCurRoom setInset: inAnkh)
			)
			(4 ; Do
				(gCurRoom setScript: sGetAnkh)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance blood of View
	(properties
		x 235
		y 120
		noun 2
		approachX 214
		approachY 126
		view 451
		priority 3
		signal 16400
	)
)

(instance poster of Feature
	(properties
		x 36
		y 81
		noun 8
		nsTop 72
		nsLeft 30
		nsBottom 90
		nsRight 42
		sightAngle 40
		approachX 60
		approachY 139
	)
)

(instance post of Feature
	(properties
		x 135
		y 189
		noun 7
		nsTop 15
		nsLeft 115
		nsBottom 189
		nsRight 155
		sightAngle 40
		approachX 181
		approachY 169
	)
)

(instance rosetta of Feature
	(properties
		x 76
		y 73
		noun 12
		sightAngle 40
		onMeCheck 4
		approachX 96
		approachY 135
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(8 ; magnifier
				(if (== gAct 5)
					(gMessager say: 17) ; "You don't have time for that! Someone's chasing you!"
				else
					(gGame points: 1 137)
					((ScriptID 21 0) doit: 1025) ; addCluesCode, Hieroglyphs
					(for ((= temp0 1)) (< temp0 14) ((++ temp0))
						((ScriptID 21 0) doit: (+ temp0 1088)) ; addCluesCode
					)
					(gCurRoom newRoom: 456) ; magRosetta
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mummy1 of Feature
	(properties
		x 176
		y 87
		noun 4
		sightAngle 40
		onMeCheck 2
		approachX 181
		approachY 127
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (== gAct 5) (not (IsFlag 90)))
						(gCurRoom setScript: sHide)
					)
					((== gAct 5)
						(gMessager say: 15 4 1) ; "You're in too much of a hurry to do that again."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mummy3 of Feature
	(properties
		x 245
		y 89
		noun 6
		sightAngle 40
		onMeCheck 16
		approachX 249
		approachY 129
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (and (== gAct 2) (TimeCheck $8120 1)) ; can 8:15 pm occur?
					(gCurRoom setScript: sUhOh)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pyramid of Feature
	(properties
		x 58
		y 178
		noun 9
		onMeCheck 64
	)
)

(instance pyramid2 of Feature
	(properties
		x 58
		y 178
		noun 10
		onMeCheck 16384
	)
)

(instance inAnkh of Inset
	(properties
		view 451
		loop 2
		x 202
		y 101
		disposeNotOnMe 1
		noun 1
	)

	(method (init)
		(super init: &rest)
		(gNarrator x: 10 y: 140)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self dispose:)
				(gCurRoom setScript: sGetAnkh)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gNarrator x: -1 y: -1)
		(super dispose:)
	)
)

(instance inFootPrint of Inset
	(properties
		view 451
		loop 1
		x 204
		y 112
		disposeNotOnMe 1
		noun 3
	)

	(method (init)
		(super init: &rest)
		(gNarrator x: 10 y: 140)
	)

	(method (dispose)
		(gNarrator x: -1 y: -1)
		(super dispose:)
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		nsTop 118
		nsLeft 314
		nsBottom 189
		nsRight 319
		cursor 14
		exitDir 2
		noun 14
	)
)

(instance nCreak of Sound
	(properties
		flags 5
	)
)

(instance thudSound of Sound
	(properties
		flags 5
		number 80
	)
)

