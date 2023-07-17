;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use Inset)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm380 0
	Jebba_the_Hop_b 1
	Stellar_b 2
	Commander_Kielbasa 3
)

(local
	local0 = 9
	local1
	[local2 5] = [241 308 49 79 248]
	[local7 5] = [124 96 71 68 80]
	local12 = 99
	local13
	local14
	local15
	local16
	local17
	local18
)

(instance rm380 of SQRoom
	(properties
		noun 1
		picture 380
	)

	(method (init &tmp temp0)
		(Load 140 483) ; WAVE
		(Lock 140 483 1) ; WAVE
		(Load 140 484) ; WAVE
		(Lock 140 484 1) ; WAVE
		(Load rsFONT 70)
		(Load rsVIEW 9401)
		(Load rsVIEW 901)
		(Load rsVIEW 997)
		(Load rsVIEW 9400)
		(Load rsVIEW 3630)
		(Load rsVIEW 382)
		(Load rsVIEW 3861)
		(Jebba_the_Hop_a
			init:
			setScaler: Scaler 100 85 105 69
			ignoreActors:
			setCycle: Walk
		)
		(if (not (IsFlag 412))
			(= local13 1)
			(Jebba_the_Hop_a
				approachX: 104
				approachY: 78
				approachVerbs: 2 ; Talk
				setScript: jebbaBeakers
			)
		else
			(= local13 2)
			(Load rsVIEW 3850)
			(Jebba_the_Hop_a setScript: jebbaConsole)
		)
		(hairView init:)
		(if
			(and
				(== ((gInventory at: 108) owner:) 380) ; Wad_Of_Hair
				(not (IsFlag 424))
				(not (IsFlag 110))
			)
			(hairView x: 83 y: 77)
		)
		(if (not (IsFlag 412))
			(Stellar_a
				view: 3840
				x: 189
				y: 46
				z: 30
				setPri: 1
				init:
				setScript: doHerBack
			)
		)
		(super init:)
		(gGSound1 number: 380 setLoop: -1 play:)
		(gGSound2 number: 387 setLoop: -1 play:)
		(Load rsVIEW 900)
		(gGame handsOff:)
		(comPost init: approachVerbs: 4 105) ; Do, Data_Cart
		(cond
			((IsFlag 110)
				(ClearFlag 110)
				(gEgo
					normalize:
					cel: 3
					setScaler: Scaler 100 85 105 69
					posn: 2 77
					init:
				)
				(gCurRoom setScript: sStellarTalks)
			)
			((and (== gPrevRoomNum 460) (or (== gComPostNextRoomNum 0) (== gComPostNextRoomNum 380)))
				(gEgo
					normalize:
					cel: 3
					setScaler: Scaler 100 85 105 69
					posn: 2 77
					init:
				)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 460)
				(gCurRoom setScript: sExitThruComPost)
			)
			(else
				(gCurRoom setScript: sEnterRoom)
			)
		)
		(= temp0 (Random 0 4))
		(Doctor
			init:
			posn: [local2 temp0] [local7 temp0]
			loop: (Random 0 3)
			setCel: 0
			setScaler: Scaler 100 85 105 69
		)
		(cabinet init:)
		(if (not (IsFlag 411))
			(cabinet approachVerbs: 4) ; Do
		)
		(case1 init:)
		(leftCrate init: approachVerbs: 4) ; Do
		(middleCrate init: approachVerbs: 4) ; Do
		(rightCrate init: approachVerbs: 4) ; Do
		(dnaMachine init: approachVerbs: 4 104 94) ; Do, Wad_Of_Hair, Pga_Hair
		(bed1 init: approachVerbs: 4) ; Do
		(bed2 init: approachVerbs: 4) ; Do
		(bed3 init: approachVerbs: 4) ; Do
		(bed4 init: approachVerbs: 4) ; Do
		(counterTop init: approachVerbs: 4) ; Do
		(bigCase init:)
		(plusPad init: approachVerbs: 4 104 94) ; Do, Wad_Of_Hair, Pga_Hair
		(rightCase init: approachVerbs: 4) ; Do
		(panel1 init: approachVerbs: 4) ; Do
		(panel2 init: approachVerbs: 4) ; Do
		(scaleThing init: approachVerbs: 4) ; Do
		(keyboardThing init: approachVerbs: 4) ; Do
		(pMidBackMonitor init:)
		(pRightFrontMon init:)
		(pRightBackDisplay init:)
		(pLeftBackDisplay init:)
		(pVatReadout init:)
		(PalCycle 0 180 182 1 30) ; Start
		(PalCycle 0 183 185 1 15) ; Start
		(PalCycle 0 186 188 1 10) ; Start
		(PalCycle 0 189 190 1 15) ; Start
		(PalCycle 0 193 197 1 5) ; Start
	)

	(method (dispose)
		(Lock 140 483 0) ; WAVE
		(Lock 140 484 0) ; WAVE
		(gEgo normalize: setScale: 0)
		(super dispose:)
	)
)

(instance jebbaBeakers of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 3 88 3 137 308 137 308 91 290 78 228 66 40 66 25 75 2 75 2 78 19 78
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 116 87 130 73 207 73 237 97 291 105 291 121 43 121 43 104 96 87
							yourself:
						)
				)
				(Jebba_the_Hop_a setMotion: PolyPath 153 73 self)
			)
			(1
				(Jebba_the_Hop_a setMotion: MoveTo 153 78 self)
			)
			(2
				(jebbaHead
					x: (Jebba_the_Hop_a x:)
					y: (Jebba_the_Hop_a y:)
					init:
					setScaler: Scaler 100 85 105 69
					setScript: jebbaHeadScript
				)
				(Jebba_the_Hop_a setScript: jebbaAtBeakers)
				(Doctor setScript: controlDoc)
				(self dispose:)
			)
		)
	)
)

(instance jebbaAtBeakers of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(jebbaHead z: 0)
				(Jebba_the_Hop_a view: 384 setLoop: 0 1 setCel: 0)
				(= seconds (Random 15 30))
			)
			(1
				(Jebba_the_Hop_a
					view: 385
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
				(jebbaHead z: 1000)
			)
			(2
				(= state -1)
				(= seconds (Random 2 8))
			)
		)
	)
)

(instance jebbaTalk of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(jebbaHead z: 0)
				(Jebba_the_Hop_a setScript: 0 view: 384 setLoop: 0 setCel: 0)
				(gMessager say: 28 2 register 0 self)
			)
			(1
				(Jebba_the_Hop_a setScript: jebbaAtBeakers)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jebbaTalk2 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(jebbaHead z: 0)
				(Jebba_the_Hop_a setScript: 0 view: 384 setLoop: 0 setCel: 0)
				(gMessager say: 12 4 0 0 self) ; "I'm sorry, Mr. Wilco. The sequencer is for use by trained personnel only. Obviously, you don't fit that description. I'm afraid I can't allow you to use it."
			)
			(1
				(Jebba_the_Hop_a setScript: jebbaAtBeakers)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJebbaYell of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(jebbaHead z: 0)
				(Jebba_the_Hop_a
					view: 385
					setLoop: 1 1
					setCel: 0
					setCycle: End
					setScript: 0
				)
				(gMessager say: 12 4 0 0 self) ; "I'm sorry, Mr. Wilco. The sequencer is for use by trained personnel only. Obviously, you don't fit that description. I'm afraid I can't allow you to use it."
			)
			(1
				(Jebba_the_Hop_a setScript: jebbaAtBeakers)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jebbaConsole of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 3 88 3 137 308 137 308 91 290 78 228 66 40 66 25 75 2 75 2 78 19 78
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 41 105 92 97 102 87 219 87 228 97 291 105 291 121 41 121
							yourself:
						)
				)
				(Jebba_the_Hop_a setMotion: PolyPath 164 123 self)
			)
			(1
				(Jebba_the_Hop_a setPri: 122 setMotion: MoveTo 164 109 self)
			)
			(2
				(Jebba_the_Hop_a
					view: 3850
					setLoop: 0
					setCel: 0
					setScript: jebbaCycle
				)
				(Doctor setScript: controlDoc)
			)
		)
	)
)

(instance jebbaPanel of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 3 88 3 137 308 137 308 91 296 82 206 82 206 66 40 66 25 75 2 75 2 78 19 78
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 41 105 92 97 102 87 219 87 228 97 291 105 291 121 41 121
							yourself:
						)
				)
				(Jebba_the_Hop_a setMotion: PolyPath 260 80 self)
			)
			(1
				(Jebba_the_Hop_a
					view: 3850
					setLoop: 1
					setCel: 0
					setPri: 73
					setScript: jebbaCycle
				)
				(Doctor setScript: controlDoc)
			)
		)
	)
)

(instance jebbaCycle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Jebba_the_Hop_a setCel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 4 20))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance controlDoc of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (< (Random 0 99) 50)
					(= cycles 1)
				else
					(= seconds (Random 1 5))
				)
			)
			(1
				(client view: 381 setPri: -1 setCycle: Walk)
				(while (== (= temp0 (Random 0 5)) local12)
				)
				(= local12 temp0)
				(switch temp0
					(0
						(if (== (gCurRoom script:) getMorphine)
							(self setScript: sDocButtonsNorth self)
						else
							(self setScript: sDocCabinet self)
						)
					)
					(1
						(if
							(and
								(== (Jebba_the_Hop_a view:) 3850)
								(== (Jebba_the_Hop_a loop:) 1)
							)
							(self cue:)
						else
							(self setScript: sDocButtonsEast self)
						)
					)
					(2
						(self setScript: sDocButtonsNorth self)
					)
					(3
						(self setScript: sDocButtonsNorth2 self)
					)
					(4
						(if (!= (Jebba_the_Hop_a view:) 3850)
							(self cue:)
						else
							(self setScript: sDocBeaker self)
						)
					)
					(5
						(if (== (gCurRoom script:) getMorphine)
							(self setScript: sDocButtonsNorth self)
						else
							(self setScript: sDocComputer self)
						)
					)
				)
			)
			(2
				(if (< (Random 0 99) 50)
					(= state -1)
					(= cycles 1)
				else
					(= temp0 (Random 0 4))
					(client
						view: 381
						setCycle: Walk
						setMotion: PolyPath [local2 temp0] [local7 temp0] self
					)
				)
			)
			(3
				(client
					setLoop:
						(switch (client loop:)
							(0 0)
							(1 1)
							(else 2)
						)
					view: 386
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sDocCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Doctor setMotion: PolyPath 300 117 self)
			)
			(1
				(Doctor setHeading: 270 self)
			)
			(2
				(Doctor
					view: 382
					setScale: 0
					setLoop: 0
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(sfx1 number: 483 play:)
				(Doctor setCycle: CT 22 1 self)
			)
			(4
				(sfx1 number: 484 play:)
				(Doctor setCycle: End self)
			)
			(5
				(Doctor setScaler: Scaler 100 85 105 69)
				(self dispose:)
			)
		)
	)
)

(instance sDocButtonsEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Doctor setMotion: PolyPath 277 78 self)
			)
			(1
				(Doctor setHeading: 90 self)
			)
			(2
				(Doctor view: 3860 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sDocButtonsNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Doctor setMotion: PolyPath 120 71 self)
			)
			(1
				(Doctor setHeading: 0 self)
			)
			(2
				(Doctor view: 3860 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(pLeftBackDisplay setCycle: ForwardCounter (Random 3 10))
				(self dispose:)
			)
		)
	)
)

(instance sDocButtonsNorth2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Doctor setMotion: PolyPath 214 71 self)
			)
			(1
				(Doctor setHeading: 0 self)
			)
			(2
				(Doctor view: 3860 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(pRightBackDisplay setCycle: ForwardCounter (Random 3 10))
				(pMidBackMonitor setCycle: ForwardCounter (Random 3 10))
				(self dispose:)
			)
		)
	)
)

(instance sDocBeaker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Doctor setMotion: PolyPath 225 95 self)
			)
			(1
				(Doctor setMotion: PolyPath 225 100 self)
			)
			(2
				(Doctor setHeading: 180 self)
			)
			(3
				(Doctor
					setScale: 0
					view: 3861
					setLoop: 0
					setPri: 122
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(pVatReadout setCycle: ForwardCounter (Random 3 10))
				(Doctor
					setCycle: Walk
					setPri: -1
					view: 381
					setScaler: Scaler 100 85 105 69
					setMotion: PolyPath 225 95 self
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sDocComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Doctor setMotion: PolyPath 230 124 self)
			)
			(1
				(Doctor setHeading: 0 self)
			)
			(2
				(Doctor
					view: 3861
					setLoop: 1
					x: 226
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(Doctor x: 230)
				(pRightFrontMon setCycle: ForwardCounter (Random 3 10))
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(sfx1 number: 941 loop: 1 play:)
				(gEgo
					view: 364
					loop: 0
					cel: 0
					posn: 2 77
					setSpeed: local0
					setCycle: End self
					setScaler: Scaler 100 85 105 69
					init:
				)
			)
			(2
				(gEgo normalize: cel: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitThruComPost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normalize:
					cel: 3
					posn: 2 77
					setScaler: Scaler 100 85 105 69
					init:
				)
				(= ticks 40)
			)
			(1
				(gEgo setHeading: 180)
				(= ticks 90)
			)
			(2
				(sfx1 number: 926 loop: 1 play:)
				(gEgo
					view: 3630
					loop: 0
					cel: 0
					posn: 2 77
					setSpeed: local0
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: gComPostNextRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance getMorphine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(Load 140 483) ; WAVE
				(Load 140 484) ; WAVE
				(gEgo
					setSpeed: 8
					view: 389
					setLoop: 0
					setCel: 0
					x: 292
					y: 119
					setCycle: CT 3 1 self
				)
			)
			(2
				(sfx1 number: 483 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo get: 70) ; Morphin
				(gGame points: 3 411)
				(cabinet approachVerbs: 0)
				(gEgo setLoop: 1 1 setCel: 0 setCycle: CT 8 1 self)
			)
			(4
				(sfx1 number: 484 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo normalize: 1 setSpeed: gEgoSpeed)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class Doctor of Actor
	(properties
		noun 30
		view 381
		dX 0
		dY 0
		dClient 0
		waitCycles 0
		NEAR_DIST 30
		WAIT_TIME 60
	)

	(method (doit)
		(super doit: &rest)
		(switch waitCycles
			(0
				(if
					(and
						(<
							(GetDistance x y (gEgo x:) (gEgo y:) 60)
							NEAR_DIST
						)
						mover
					)
					(= dX (mover finalX:))
					(= dY (mover finalY:))
					(= dClient (mover client:))
					(self setMotion: 0)
					(= waitCycles WAIT_TIME)
				)
			)
			(1
				(if (> (GetDistance x y (gEgo x:) (gEgo y:) 60) NEAR_DIST)
					(= waitCycles 0)
					(self setMotion: PolyPath dX dY dClient)
				else
					(= waitCycles WAIT_TIME)
				)
			)
			(else
				(-- waitCycles)
			)
		)
	)
)

(instance Jebba_the_Hop_a of Actor
	(properties
		name {Jebba the Hop}
		noun 28
		sightAngle 40
		approachX 104
		approachY 78
		x 42
		y 95
		view 383
	)

	(method (init)
		(self setStep: 6 4)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((IsFlag 91)
						(gMessager say: noun theVerb 3) ; "He ignores you. What did you expect him to do? He helped you and it's time for you to move along. We have adventuring to do."
					)
					((IsFlag 412)
						(SetFlag 91)
						(gCurRoom setScript: jebbaTalk 0 2)
					)
					((and local14 (not (IsFlag 90)))
						(SetFlag 90)
						(gGame points: 1 423)
						(gCurRoom setScript: jebbaTalk 0 1)
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

(instance jebbaHead of Prop
	(properties
		noun 28
		view 384
		loop 2
	)

	(method (init)
		(= approachX (Jebba_the_Hop_a approachX:))
		(= approachY (Jebba_the_Hop_a approachY:))
		(self approachVerbs: 2) ; Talk
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(Jebba_the_Hop_a doVerb: theVerb &rest)
	)
)

(instance jebbaHeadScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (< (Random 0 99) 50)
					(= cycles 1)
				else
					(= seconds (Random 10 25))
				)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCycle: CT (Random 0 10) -1 self)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance pMidBackMonitor of Prop
	(properties
		x 148
		y 23
		priority 23
		fixPriority 1
		view 380
		signal 18433
	)

	(method (init)
		(super init:)
	)
)

(instance pRightFrontMon of Prop
	(properties
		x 207
		y 84
		scaleX 0
		scaleY 0
		priority 120
		fixPriority 1
		view 380
		loop 1
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance pRightBackDisplay of Prop
	(properties
		x 222
		y 28
		scaleX 0
		scaleY 0
		priority 28
		fixPriority 1
		view 380
		loop 2
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance pLeftBackDisplay of Prop
	(properties
		x 125
		y 28
		scaleX 0
		scaleY 0
		priority 28
		fixPriority 1
		view 380
		loop 2
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance pVatReadout of Prop
	(properties
		x 220
		y 55
		scaleX 0
		scaleY 0
		priority 122
		fixPriority 1
		view 380
		loop 3
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance pLeftFrontMonitor of Prop ; UNUSED
	(properties
		x 96
		y 87
		scaleX 0
		scaleY 0
		priority 122
		fixPriority 1
		view 380
		loop 4
		signal 2049
	)

	(method (init)
		(super init:)
	)
)

(instance comPost of Feature
	(properties
		noun 2
		nsLeft 3
		nsTop 43
		nsRight 12
		nsBottom 49
		sightAngle 40
		approachX 2
		approachY 77
		x 2
		y 76
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 4) (== theVerb 105)) ; Do, Data_Cart
			(if (and (IsFlag 412) (not (IsFlag 424)))
				(gCurRoom setScript: useCart2)
			else
				(gCurRoom newRoom: 460)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance case1 of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 162
		approachY 124
		x 300
		y 32
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 96 23 96 26 97 26 112 32 110 101 110 104 112 104 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bed1 of Feature
	(properties
		noun 8
		nsLeft 36
		nsTop 7
		nsRight 138
		nsBottom 67
		sightAngle 40
		approachX 107
		approachY 69
		x 107
		y 68
	)
)

(instance bed2 of Feature
	(properties
		noun 9
		nsLeft 139
		nsTop 7
		nsRight 235
		nsBottom 67
		sightAngle 40
		approachX 196
		approachY 69
		x 196
		y 38
	)
)

(instance bed3 of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 261
		approachY 75
		x 262
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 236 6 293 10 302 13 302 82 294 76 236 66
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bed4 of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 297
		approachY 88
		x 298
		y 88
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 303 14 310 17 310 87 303 82
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftCrate of Feature
	(properties
		noun 13
		sightAngle 40
		approachX 17
		approachY 129
		x 17
		y 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 0 95 22 95 27 99 27 138 0 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance middleCrate of Feature
	(properties
		noun 15
		sightAngle 40
		approachX 79
		approachY 138
		x 79
		y 139
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 0 136 32 110 101 110 104 113 104 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightCrate of Feature
	(properties
		noun 14
		sightAngle 40
		approachX 281
		approachY 135
		x 281
		y 136
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 247 138 247 111 252 106 319 106 319 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance dnaMachine of Feature
	(properties
		noun 12
		sightAngle 40
		approachX 78
		approachY 124
		x 78
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 62 0 101 0 101 27 99 27 99 54 97 56 93 59 69 59 69 57 65 57 65 28 62 26
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 104 94) ; Do, Wad_Of_Hair, Pga_Hair
			(cond
				((and (IsFlag 90) (not (IsFlag 412)))
					(gCurRoom setInset: iDNA rm380 rm380 1)
				)
				((not (IsFlag 412))
					(= local14 1)
					(gCurRoom setScript: sJebbaYell)
				)
				((and (< gAct 2) (not (IsFlag 412)))
					(gCurRoom setScript: jebbaTalk2)
				)
				(else
					(gDoVerbCode doit: theVerb)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance counterTop of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 162
		approachY 124
		x 162
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 53 110 102 110 105 112 105 120 124 120 139 104 187 104 201 120 245 120 246 110 252 106 264 106 264 97 260 88 270 88 271 83 256 73 237 73 233 75 232 70 224 67 224 65 229 63 228 54 217 54 217 64 222 65 222 75 216 75 202 68 188 68 188 56 183 56 183 68 179 68 179 56 174 56 174 68 171 68 171 56 165 56 165 68 162 68 162 56 156 56 156 68 153 68 153 56 147 56 147 68 120 68 108 76 99 76 98 74 74 74 58 85 53 97
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bigCase of Feature
	(properties
		noun 17
		sightAngle 40
		approachX 126
		approachY 94
		x 26
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 247 138 247 110 253 106 319 106 319 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance plusPad of Feature
	(properties
		noun 18
		sightAngle 40
		approachX 78
		approachY 124
		x 78
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 66 82 91 82 98 77 98 74 94 74 93 73 79 73 77 74 74 74 65 79
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "It's the DNA sequencer scanning bed. This is where you put the food, er, specimen you desire to scan."
			)
			(else
				(dnaMachine doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightCase of Feature
	(properties
		noun 19
		sightAngle 40
		approachX 227
		approachY 124
		x 227
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 271 88 271 83 265 78 256 73 237 73 236 75 235 77 240 80 235 80 232 79 232 69 229 69 224 67 224 65 229 64 229 54 217 54 217 64 219 65 222 65 222 78 216 78 216 80 231 80 234 82 240 82 244 83 256 83 261 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance panel1 of Feature
	(properties
		noun 24
		sightAngle 40
		approachX 78
		approachY 124
		x 78
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PNearestAccess init: 61 87 93 87 91 95 56 95 yourself:)
		)
		(super init: &rest)
	)
)

(instance panel2 of Feature
	(properties
		noun 24
		sightAngle 40
		approachX 108
		approachY 124
		x 108
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 97 87 121 87 120 95 95 95
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance scaleThing of Feature
	(properties
		noun 23
		sightAngle 40
		approachX 219
		approachY 124
		x 219
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 204 80 220 80 225 84 228 97 204 97 204 85 208 85 204 82
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance keyboardThing of Feature
	(properties
		noun 20
		sightAngle 40
		approachX 245
		approachY 124
		x 245
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 226 85 228 96 262 96 256 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cabinet of Feature
	(properties
		noun 31
		sightAngle 40
		approachX 292
		approachY 119
		x 282
		y 119
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 411))
					(gCurRoom setScript: getMorphine)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 262 88 265 96 265 105 280 105 280 90 271 85 271 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance Jebba_the_Hop_b of SmallTalker
	(properties
		name {Jebba the Hop}
		talkView 385
		talkLoop 2
	)

	(method (init)
		(= client jebbaHead)
		(super init:)
	)
)

(instance iDNA of Inset
	(properties
		picture 810
		disposeNotOnMe 1
		noun 25
	)

	(method (init)
		(Load rsVIEW 810)
		(Load rsVIEW 811)
		(Load rsVIEW 812)
		(gTheIconBar setupExit: 1)
		(super init: &rest)
		(if (and (== ((gInventory at: 108) owner:) 380) (not (IsFlag 412))) ; Wad_Of_Hair
			(sample_Scan init: &rest)
		)
		(if (not (IsFlag 425))
			(stellInBack init: &rest)
		)
		(imprintButton init: &rest)
		(redLight init: &rest)
		(greenLight init: &rest z: 1000)
		(blendGadget init: &rest)
		(cloneGadget init: &rest)
		(sequenceGadget init: &rest)
		(scanButton init: &rest)
		(randomLights init: &rest)
		(scannerGadget init: &rest)
		(datacartGadget init: &rest z: 1000)
		(if (and local16 (not (IsFlag 412)))
			(datacartGadget z: 0 setCel: 8)
		)
		(docInBack init: &rest x: -80 y: 121 doit: setScript: sWalkAround)
		(scannerFeature init: &rest)
		(self drawInset:)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(param1 localize: plane)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= 26 temp0 295) (<= 0 temp1 138)))
	)

	(method (doit &tmp temp0)
		(= temp0 (gUser curEvent:))
		(if
			(and
				(not (temp0 type:))
				(not ((gTheIconBar plane:) onMe: (gUser curEvent:)))
				(!= gTheCursor gWaitCursor)
			)
			(temp0 localize: plane)
			(cond
				((not (self onMe: temp0))
					(if (!= gTheCursor gTheExitCursor)
						(gGame setCursor: gTheExitCursor 1)
					)
				)
				((!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gTheIconBar setupExit: 0)
		(gTheIconBar enable: 5 6)
		(if local1
			(gTheIconBar enable: 7)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		(if
			(and
				(== ((gInventory at: 108) owner:) 380) ; Wad_Of_Hair
				(not (IsFlag 424))
				(not (IsFlag 110))
			)
			(hairView x: 83 y: 77)
		else
			(hairView x: -500 y: -500)
		)
		(User canInput: 1)
		(super dispose:)
	)
)

(instance scannerFeature of Feature
	(properties
		nsLeft 103
		nsTop 45
		nsRight 206
		nsBottom 105
		x 153
		y 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(104 ; Wad_Of_Hair
				(gEgo put: 108 380) ; Wad_Of_Hair
				(sample_Scan init: &rest)
			)
			(94 ; Pga_Hair
				(gEgo put: 78) ; Pga_Hair
				((gInventory at: 108) moveTo: 380) ; Wad_Of_Hair
				(sample_Scan init: &rest)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance imprintButton of Prop
	(properties
		x 225
		y 128
		priority 128
		fixPriority 1
		view 810
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and local15 (not local16))
					(iDNA setScript: imprintCart)
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

(instance redLight of Prop
	(properties
		x 223
		y 114
		priority 114
		fixPriority 1
		view 810
		loop 1
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)
)

(instance greenLight of Prop
	(properties
		x 237
		y 114
		priority 114
		fixPriority 1
		view 810
		loop 2
		cel 1
	)

	(method (init)
		(super init:)
	)
)

(instance blendGadget of Prop
	(properties
		x 191
		y 134
		priority 134
		fixPriority 1
		view 810
		loop 3
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)
)

(instance cloneGadget of Prop
	(properties
		x 190
		y 127
		priority 127
		fixPriority 1
		view 810
		loop 4
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)
)

(instance sequenceGadget of Prop
	(properties
		x 188
		y 121
		priority 121
		fixPriority 1
		view 810
		loop 5
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)
)

(instance scanButton of Prop
	(properties
		x 186
		y 114
		priority 114
		fixPriority 1
		view 810
		loop 6
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(== ((gInventory at: 108) owner:) 380) ; Wad_Of_Hair
						(not (IsFlag 412))
					)
					(sfx1 number: 382 play:)
					(iDNA setScript: scanIt)
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

(instance randomLights of Prop
	(properties
		x 271
		y 133
		priority 133
		fixPriority 1
		view 810
		loop 7
		cel 4
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)
)

(instance scannerGadget of Actor
	(properties
		x 151
		y 12
		priority 36
		fixPriority 1
		view 811
		moveSpeed 1
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)
)

(instance sample_Scan of Prop
	(properties
		name {sample&Scan}
		x 153
		y 75
		priority 75
		fixPriority 1
		view 811
		loop 2
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)
)

(instance datacartGadget of Prop
	(properties
		x 228
		y 134
		priority 134
		fixPriority 1
		view 812
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local16
					(self x: -500)
					(gGame points: 1 412)
					(gEgo get: 26) ; Data_Cart
					(gCurRoom setScript: useCart)
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

(instance docInBack of Actor
	(properties
		x -80
		y 121
		priority 30
		fixPriority 1
		view 813
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
		(self setStep: 12 8 setCycle: Fwd ignoreActors:)
	)
)

(instance stellInBack of Prop
	(properties
		x 272
		y 15
		priority 20
		fixPriority 1
		view 811
		loop 3
	)

	(method (init)
		(if (not (gCast contains: self))
			(super init:)
		)
	)
)

(instance imprintCart of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(imprintButton setCel: 0 setCycle: End self)
			)
			(1
				(sfx1 number: 386 setLoop: -1 play:)
				(imprintButton setCel: 0)
				(randomLights setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(randomLights setCycle: 0 setCel: 0)
				(sfx1 number: 384 setLoop: 1 play:)
				(datacartGadget z: 0 cycleSpeed: 12 setCycle: End self)
			)
			(3
				(redLight z: 0)
				(greenLight z: 1000)
				(= local16 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scanIt of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 5 422)
				(scanButton setCel: 0 setCycle: End self)
			)
			(1
				(scanButton setCel: 0)
				(scannerGadget
					setStep: 1 1
					setLoop: 0 1
					setMotion: MoveTo 151 36 self
				)
			)
			(2
				(sfx1 number: 383 play:)
				(sample_Scan setLoop: 1 setCycle: End self)
			)
			(3
				(= local15 1)
				(sample_Scan setLoop: 2 1 setCel: 0)
				(sfx1 number: 382 play:)
				(scannerGadget setMotion: MoveTo 151 12 self)
			)
			(4
				(blendGadget setCel: 0 setCycle: End self)
			)
			(5
				(sfx1 number: 386 setLoop: 1 play:)
				(= ticks 60)
			)
			(6
				(blendGadget setCel: 0)
				(cloneGadget setCel: 0 setCycle: End self)
			)
			(7
				(sfx1 number: 386 setLoop: 1 play:)
				(= ticks 60)
			)
			(8
				(cloneGadget setCel: 0)
				(sequenceGadget setCel: 0 setCycle: End self)
			)
			(9
				(sfx1 number: 386 setLoop: 1 play:)
				(= ticks 60)
			)
			(10
				(sequenceGadget setCel: 0)
				(= ticks 60)
			)
			(11
				(sfx1 number: 386 setLoop: 1 play:)
				(redLight z: 1000)
				(greenLight z: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkAround of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 10 35))
			)
			(1
				(docInBack setLoop: 0 setMotion: MoveTo 380 121 self)
			)
			(2
				(= seconds (Random 10 35))
			)
			(3
				(docInBack
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo -80 121 self
				)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sStellarTalks of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(Stellar_a
					init:
					z: 0
					setScaler: Scaler 100 85 105 69
					setLoop: 4 1
					setCel: 1
					posn: 32 77
				)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 90 self)
				(Load rsVIEW 380)
			)
			(2
				(gMessager sayRange: 0 0 5 3 4 self) ; "I got some information from the sample I ran through the DNA sequencer."
			)
			(3
				(gMessager sayRange: 0 0 4 2 16 self) ; "I don't know for sure, Roger, but it seems a bit suspicious."
			)
			(4
				(kielProp init: setLoop: 7 setCel: 0 posn: 257 26 setCycle: Fwd)
				(cond
					((< (Doctor y:) 103)
						(if (< (Doctor x:) 246)
							(= local18 0)
						else
							(= local18 3)
						)
					)
					((< (Doctor x:) 203)
						(= local18 0)
					)
					(else
						(= local18 3)
					)
				)
				(Doctor
					setCycle: 0
					setScript: 0
					setMotion: 0
					view: 381
					setLoop: 4
					setCel: local18
				)
				(gMessager say: 0 0 4 17 self) ; "Attention. We are now orbiting the Delta Burksilon V colony as requested by StarCon. Most of you know your assignments as they have been broadcast to your ComPosts. Please represent StarCon properly. Kielbasa out."
				(Stellar_a setScript: sTurnRight)
			)
			(5
				(kielProp dispose:)
				(Doctor view: 386 setLoop: 0 setCycle: Fwd)
				(Stellar_a setScript: 0 setCel: 2)
				(= cycles 6)
			)
			(6
				(Stellar_a setCel: 1)
				(= cycles 6)
			)
			(7
				(gMessager sayRange: 0 0 4 18 20 self) ; "You'd better get moving since you don't know yet what your assignment is. I have some checking around to do. We'll talk later."
			)
			(8
				(gEgo setHeading: 0 self)
			)
			(9
				(gEgo
					view: 3841
					setLoop: 0 1
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(10
				(= gComPostNextRoomNum 390)
				(gEgo put: 26) ; Data_Cart
				(gCurRoom setScript: sExitThruComPost)
			)
		)
	)
)

(instance useCart of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(iDNA dispose:)
				(= cycles 3)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useCart2 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 91)
				(gMessager say: 2 33 0 0 self) ; "Neat! I've always wanted to try one of these on the ComPost."
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame points: 3 424)
				(= cycles 80)
			)
			(3
				(SetFlag 110)
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance doHerBack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sTurnRight of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(Stellar_a setCel: 3)
				(= cycles 6)
			)
			(2
				(Stellar_a setCel: 0)
				(= cycles 6)
			)
		)
	)
)

(instance Stellar_a of Actor
	(properties
		name {Stellar}
		noun 32
		sightAngle 40
		view 905
	)
)

(instance Stellar_b of SmallTalker
	(properties
		name {Stellar}
		talkView 388
		talkLoop 1
	)

	(method (init)
		(= client Stellar_a)
		(super init:)
	)
)

(instance Commander_Kielbasa of Talker
	(properties
		name {Commander Kielbasa}
	)

	(method (init)
		(super init: 0 0 0)
	)
)

(instance kielProp of Prop
	(properties
		view 380
	)
)

(instance hairView of View
	(properties
		x -500
		y -500
		view 380
		loop 5
	)

	(method (init)
		(self ignoreActors:)
		(self setPri: 120)
		(super init: &rest)
	)
)

(instance sfx1 of Sound
	(properties)
)

