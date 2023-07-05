;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use Scaler)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm730 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm730 of Rm
	(properties
		noun 5
		picture 730
		style 10
	)

	(method (init)
		(nest init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(water init:)
		(eagle init:)
		(super init:)
		((ScriptID 1749) setupTalker: 4) ; Harpy
		((ScriptID 1009) setupTalker: 6) ; EgoTalker
		(self setScript: sEnter)
		(gGameSound1 number: 730 setLoop: -1 play:)
	)

	(method (doit)
		(if (not inset)
			(super doit:)
		)
	)
)

(instance eagle of Actor
	(properties
		x 239
		noun 3
		yStep 10
		view 741
		loop 1
		priority 6
		signal 12304
		cycleSpeed 0
		xStep 10
		moveSpeed 0
	)

	(method (doit)
		(if (not (IsEcorderFlag 44))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 46) ; golden_feather
				(gGameSound1 number: 731 setLoop: -1 play:)
				(gCurRoom setScript: goToTown)
			)
			((== theVerb 55) ; E-corder
				(if (not (IsEcorderFlag 44))
					(self perform: gWriteEcorderData theVerb 44)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(switch theVerb
					(2 ; Talk
						(self setScript: eTalk)
					)
					(1 ; Look
						(super doVerb: theVerb &rest)
					)
					(else
						(self setScript: KO 0 theVerb)
					)
				)
			)
		)
	)
)

(instance nest of Feature
	(properties
		x 114
		y 1
		noun 1
		nsTop 35
		nsLeft 65
		nsBottom 82
		nsRight 164
		sightAngle 40
		approachX 114
		approachY 58
	)
)

(instance tree1 of Feature
	(properties
		x 157
		y 189
		noun 2
		nsTop 95
		nsLeft 149
		nsBottom 153
		nsRight 165
		sightAngle 40
		approachX 157
		approachY 124
	)
)

(instance tree2 of Feature
	(properties
		x 211
		y 189
		noun 2
		nsTop 98
		nsLeft 202
		nsBottom 141
		nsRight 220
		sightAngle 40
		approachX 211
		approachY 119
	)
)

(instance tree3 of Feature
	(properties
		x 272
		y 189
		noun 2
		nsTop 128
		nsLeft 267
		nsBottom 174
		nsRight 290
		sightAngle 40
		approachX 272
		approachY 151
	)
)

(instance water of Feature
	(properties
		x 192
		y 100
		noun 4
		nsTop 124
		nsLeft 103
		nsBottom 187
		nsRight 282
		sightAngle 40
		approachX 192
		approachY 155
	)

	(method (doit)
		(if (not (IsEcorderFlag 14))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (IsEcorderFlag 14))
			(self perform: gWriteEcorderData theVerb 14)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance eTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 2 0 1 self) ; "Um..."
			)
			(1
				(eagle cel: 0)
				(= ticks 60)
			)
			(2
				(gMessager say: 3 2 0 2 self) ; "We have NOT given you permission to speak!"
			)
			(3
				(eagle setCycle: End self)
			)
			(4
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 11
					cel: 0
					x: 85
					y: 40
					cycleSpeed: 6
					moveSpeed: 0
					yStep: 5
					signal: (| (gEgo signal:) $5000)
					setPri: -1
					setLoop: 1
					setMotion: drop 85 87 self
					init:
				)
			)
			(1
				(gEgo loop: 2 cel: 0 x: 104 y: 67)
				(= cycles 1)
			)
			(2
				(= ticks 100)
			)
			(3
				(eagle loop: 0 cel: 0 setMotion: MoveTo 137 66 self)
			)
			(4
				(eagle setCycle: End self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gMessager say: 5 0 2 0 self) ; "Impostor! YOU are not OUR dinner."
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(gEgo
					view: 730
					loop: 0
					cel: 0
					x: (- (gEgo x:) 26)
					y: (- (gEgo y:) 4)
				)
				(= cycles 2)
			)
			(9
				(eagle
					view: 740
					loop: 0
					cel: 0
					x: 138
					y: 66
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(10
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(client setScript: promptScript)
			)
		)
	)
)

(instance promptScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
				(= register 0)
			)
			(1
				(if (eagle script:)
					(= register 1)
				else
					(gGame handsOff:)
					(eagle cel: 0)
				)
				(= cycles 1)
			)
			(2
				(cond
					((not local3)
						(if register
							(self cue:)
						else
							(= local3 1)
							(gMessager say: 5 0 1) ; "We have commanded you to leave at once! Do you defy our royal will?"
							(eagle setCycle: End self)
						)
					)
					(register
						(self cue:)
					)
					(else
						(gMessager say: 5 0 3) ; "We have commanded you to leave, now BE OFF!"
						(self setScript: KO self)
					)
				)
			)
			(3
				(if (not register)
					(gGame handsOn:)
					(gTheIconBar disable: 0)
				)
				(self init:)
			)
		)
	)
)

(instance KO of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(eagle cel: 0)
				(= cycles 5)
			)
			(1
				(if (Message msgSIZE 730 3 register 0 1)
					(gMessager say: 3 register 0 0 self)
				else
					(self cue:)
				)
			)
			(2
				(eagle loop: 1 setCycle: End self)
			)
			(3
				(gGameSound2 number: 735 loop: 1 play:)
				(eagle setCycle: Beg)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo loop: 2 cel: 0 x: 77 y: 67 setCycle: End self)
			)
			(5
				(gEgo loop: 3 cel: 0 x: 82 y: 66 setCycle: End self)
			)
			(6
				(gEgo loop: 0 cel: 0)
				(eagle loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance goToTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(eagle cel: 0)
				(gEgo loop: 5 put: 14 cel: 0 setCycle: End self)
			)
			(1
				(gGame points: 10)
				(= cycles 20)
			)
			(2
				(gMessager say: 3 46 0 0 self) ; "It has been many generations since we have received this sign!"
			)
			(3
				(gEgo scaleSignal: 0)
				(gTheIconBar disable:)
				(gCast
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
				)
				(gFeatures
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
				)
				(gCurRoom picture: 0)
				(DrawPic 888 (gCurRoom style:) 1)
				(= cycles 3)
			)
			(4
				(gCurRoom picture: 0)
				(DrawPic 40 100 1)
				(townCover init:)
				(= cycles 3)
			)
			(5
				(gEgo
					view: 18
					loop: 0
					cel: 0
					x: -30
					y: 200
					init:
					illegalBits: 0
					moveSpeed: 2
					origStep: 1542
					signal: 24576
					setScale: Scaler 128 0 189 20
					setCycle: Walk
					setMotion: MoveTo 300 20
				)
				((= register (Actor new:))
					view: 770
					setLoop: 1
					cel: 0
					x: 200
					y: -150
					origStep: 1028
					scaleSignal: 1
					scaleX: 127
					scaleY: 127
					moveSpeed: 4
					setPri: 12
					setCycle: Fwd
					init:
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					setMotion: MoveTo 100 75 self
				)
			)
			(6
				(= ticks 60)
			)
			(7
				(register
					loop: 2
					cel: 1
					setCycle: Beg self
					cycleSpeed: 12
					setScale: Scaler 127 0 75 20
				)
			)
			(8
				(register
					loop: 0
					cel: 0
					cycleSpeed: 6
					moveSpeed: 1
					origStep: 1542
					setCycle: Fwd
					setMotion: MoveTo 300 25 self
				)
			)
			(9
				(gTheIconBar enable: curInvIcon: 0)
				(gCurRoom newRoom: 800)
			)
		)
	)

	(method (doit &tmp temp0)
		(if (and (IsObject register) (> (register y:) -20))
			(if (== (gGameSound2 prevSignal:) -1)
				(gGameSound2 number: 734 setLoop: -1 play:)
			else
				(if (and (!= (gGameSound1 number:) 732) (>= (register y:) 0))
					(gGameSound1 number: 732 setLoop: -1 play:)
				)
				(if
					(!=
						(= temp0
							(Min 127 (/ (* (register scaleX:) 100) 128))
						)
						(gGameSound2 vol:)
					)
					(gGameSound2 setVol: temp0)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gGameSound1 stop:)
		(gGameSound2 stop:)
		(super dispose:)
	)
)

(instance occasionalCycle of Cycle ; UNUSED
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(if (>= argc 2)
			(= client param1)
			(if (>= argc 3)
				(= cycleDir param3)
				(if (>= argc 4)
					(= local0 param4)
					(if (>= argc 5)
						(= local1 param5)
					)
				)
			)
		)
		(= completed (= cycleCnt 0))
		(self cycleDone:)
	)

	(method (doit &tmp temp0)
		(= temp0 (self nextCel:))
		(cond
			(local2
				(-- local2)
			)
			((or (> temp0 (client lastCel:)) (< temp0 0))
				(self cycleDone:)
			)
			(else
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(= local2 (Random local0 local1))
		(client
			cel:
				(if (= cycleDir 1)
					0
				else
					(client lastCel:)
				)
		)
		(= cycleCnt (GetTime))
	)
)

(instance drop of MoveTo
	(properties)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(if argc
			(= temp0 (gEgo x:))
			(= temp1 (gEgo y:))
			(= local4 (/ (GetDistance temp0 temp1 x y) 5))
			(= local5 (- (GetDistance temp0 temp1 x y) local4))
		)
	)

	(method (doit)
		(super doit:)
		(if (<= (GetDistance (gEgo x:) (gEgo y:) x y) local5)
			(-= local5 local4)
			(gEgo cel: (+ (gEgo cel:) 1))
		)
	)
)

(instance townCover of View
	(properties
		x 219
		y 60
		view 770
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self addToPic:)
	)
)

