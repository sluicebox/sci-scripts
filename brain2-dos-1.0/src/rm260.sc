;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	local0 = -1
	local1 = -1
	local2 = -1
	[local3 3] = [6 8 7]
	[local6 3] = [9 4 8]
	[local9 3] = [240 112 123]
	[local12 3] = [131 108 121]
	[local15 3] = [160 163 164]
	local18
	[local19 6] = [15 180 265 62 164 279]
	[local25 6] = [117 32 69 170 189 188]
	local31
	local32
	local33
)

(instance rm260 of Rm
	(properties
		noun 1
		picture 260
		north 280
		south 240
	)

	(method (init &tmp temp0)
		(= local32 0)
		(if (not (IsFlag 12))
			(corn init:)
		)
		(if (not (IsFlag 11))
			(apples init:)
		)
		(if (not (IsFlag 13))
			(antHill init:)
		)
		(if (not (IsFlag 26))
			(if (IsFlag 27)
				(appleProp init:)
				(++ local18)
			)
			(if (IsFlag 29)
				(watermellonProp init:)
				(++ local18)
			)
			(if (IsFlag 28)
				(cornProp init:)
				(++ local18)
			)
		)
		(for ((= temp0 6)) (Message msgSIZE 260 11 4 temp0 1) ((++ temp0))
		)
		(= local31 (- temp0 1))
		(scale
			cel:
				(if (IsFlag 26)
					(scale lastCel:)
				else
					0
				)
			init:
		)
		(cornF init:)
		(if (not (IsFlag 26))
			(hutDoor init:)
		)
		(applesF init:)
		(antHillF init:)
		(hutDoorF init:)
		(clothes init:)
		(goat init: actions: goatHead)
		(goatHead init:)
		(smallHuts init:)
		(palmTree init:)
		(largeHut init:)
		(metalContraption init:)
		(thePath init:)
		(pizzaHut init:)
		(dish init: setScript: rotateDish)
		(tikilights init: setCycle: Fwd)
		(ants init: setCycle: End ants)
		(fishbone init: setScript: (rotateDish new:))
		(robot init: hide:)
		(gCMusic number: 12 play: setVol: 0 setLoop: -1 fade: 127 10 10 0)
		(super init:)
	)

	(method (dispose)
		(if (and (!= local0 -1) (IsObject (ScriptID 265 0))) ; synonymPuzzle
			((ScriptID 265 0) dispose:) ; synonymPuzzle
		)
		(DisposeScript 265)
		(if (and (!= local1 -1) (IsObject (ScriptID 270 0))) ; homonymPuzzle
			((ScriptID 270 0) dispose:) ; homonymPuzzle
		)
		(DisposeScript 270)
		(if (and (!= local2 1) (IsObject (ScriptID 275 0))) ; antonymPuzzle
			((ScriptID 275 0) dispose:) ; antonymPuzzle
		)
		(DisposeScript 275)
		(DisposeScript 45)
		(super dispose: &rest)
	)
)

(instance doReward of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND [local15 register])
				(gCSoundFX number: [local15 register] setLoop: 1 play:)
				(client setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(gMessager say: [local6 register] 4 11 0 self)
			)
			(3
				(gEgo get: [local3 register])
				(proc5_12 [local3 register])
				(gGame
					setCursor: gTheCursor 1 [local9 register] [local12 register]
				)
				(if (not (gCurRoom script:))
					(gCurRoom setScript: showARobot)
				)
				(client dispose:)
			)
		)
	)
)

(instance tiltScale of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 168 172)
				(= seconds 2)
			)
			(1
				(appleProp dispose:)
				(cornProp dispose:)
				(watermellonProp dispose:)
				(gCSoundFX number: 168 setLoop: 1 play:)
				(scale setCel: 1 setLoop: 2 setCycle: End self)
			)
			(2
				(SetFlag 26)
				(gCSoundFX number: 172 setLoop: 1 play:)
				(hutDoor setCycle: End self)
			)
			(3
				(hutDoor dispose:)
				(gMessager say: 18 27 0 0 self) ; "It appears that the hut is beckoning you."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance turnHead of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 100 200))
			)
			(1
				(client cel: (Random 0 (client lastCel:)))
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance showARobot of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (not register)
					(= register (Random 1 5))
				)
				(robot
					loop: (Random 0 4)
					x: [local19 (-- register)]
					y: [local25 register]
					show:
					setCycle: End self
				)
				(DrawPic (gCurRoom picture:) 9 1)
				(Animate (gCast elements:) 0)
				(= cycles 20)
			)
			(2
				(robot setCycle: End self)
			)
			(3
				(robot setCycle: End self)
			)
			(4
				(robot hide:)
				(DrawPic (gCurRoom picture:) 9 1)
				(Animate (gCast elements:) 0)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance rotateDish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 300 900))
				(= cycles 2)
			)
			(1
				(if (> (client cel: (+ (client cel:) 1)) (client lastCel:))
					(client cel: 0)
				)
				(-= state 1)
				(= ticks register)
			)
			(2
				(client setCycle: Fwd)
				(= ticks 120)
			)
			(3
				(-= state 3)
				(client setCycle: 0)
				(= ticks 1)
			)
		)
	)
)

(instance turnGoatHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 167 setLoop: 1 play: 127)
				(client setCycle: Beg self)
			)
			(1
				(gMessager say: 19 4) ; "Is that so? Always putting the finger of blame on someone else?"
				(self dispose:)
			)
		)
	)
)

(instance robot of Prop
	(properties
		noun 16
		view 263
	)
)

(instance scale of Actor
	(properties
		x 78
		y 58
		noun 18
		view 260
		loop 2
		priority 4
		signal 4112
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 33)
				(gEgo put: 6)
				(SetFlag 27)
				(appleProp init:)
				(++ local18)
				(proc0_1)
			)
			((== theVerb 34)
				(gEgo put: 7)
				(SetFlag 29)
				(watermellonProp init:)
				(++ local18)
				(proc0_1)
			)
			((== theVerb 35)
				(gEgo put: 8)
				(SetFlag 28)
				(cornProp init:)
				(++ local18)
				(proc0_1)
			)
			((or (== theVerb 4) (== theVerb 1))
				(cond
					((not local18)
						(gMessager say: noun theVerb)
					)
					((== local18 1)
						(gMessager say: noun theVerb 12)
					)
					((== local18 2)
						(gMessager say: noun theVerb 13)
					)
					(else
						(gMessager say: noun theVerb 15)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(if (and (IsFlag 27) (IsFlag 29) (IsFlag 28) (not (IsFlag 26)))
			(scale setScript: tiltScale)
		)
	)
)

(instance dish of Actor
	(properties
		x 65
		y 16
		noun 11
		view 260
		loop 4
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(4
				(script changeState: 2)
			)
			(1
				(proc15_0 0 noun 4)
				(= temp0 1)
				(= temp1 (Random 6 local31))
				(while (Message msgSIZE 260 noun 4 temp1 temp0)
					(proc15_0 0 noun 4 temp1 temp0 0 260)
					(++ temp0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ants of Actor
	(properties
		x 121
		y 122
		view 260
		loop 10
		priority 14
		signal 16
		cycleSpeed 14
	)

	(method (onMe)
		(return 0)
	)

	(method (cue)
		(= loop 11)
		(self setCycle: Fwd)
	)
)

(instance fishbone of Actor
	(properties
		x 258
		y 19
		noun 22
		view 260
		loop 7
		cel 6
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(script changeState: 2)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tikilights of Actor
	(properties
		x 63
		y 36
		view 260
		loop 3
		cel 4
		cycleSpeed 70
	)

	(method (onMe)
		(return 0)
	)
)

(instance hutDoor of Actor
	(properties
		x 62
		y 32
		noun 14
		view 260
		loop 9
	)
)

(instance appleProp of Actor
	(properties
		x 135
		y 56
		noun 21
		view 260
		loop 8
		cel 3
		priority 9
		signal 16400
	)
)

(instance cornProp of Actor
	(properties
		x 146
		y 55
		noun 21
		view 260
		loop 8
		cel 2
		priority 9
		signal 16400
	)
)

(instance watermellonProp of Actor
	(properties
		x 141
		y 59
		noun 21
		view 260
		loop 8
		cel 1
		priority 10
		signal 16400
	)
)

(instance corn of Prop
	(properties
		x 73
		y 89
		noun 4
		view 261
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(cornF doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance apples of Prop
	(properties
		x 241
		y 133
		noun 9
		view 261
		signal 4096
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(applesF doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance antHill of Prop
	(properties
		x 123
		y 159
		noun 8
		view 261
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(antHillF doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance goatHead of Prop
	(properties
		x 293
		y 22
		noun 19
		view 260
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(self setScript: turnGoatHead)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance applesF of Feature
	(properties
		noun 9
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (and local32 (!= local32 (ScriptID 265 0))) ; synonymPuzzle
					(local32 dispose:)
					(= local32 0)
					(= [local0 local33] -1)
				)
				(cond
					((< [local0 0] 0)
						((ScriptID 265 0) init:) ; synonymPuzzle
						(= [local0 0] global114)
					)
					((!= [local0 0] global114)
						((ScriptID 265 0) dispose: init:) ; synonymPuzzle
						(= [local0 0] global114)
					)
				)
				(switch ((ScriptID 265 0) show:) ; synonymPuzzle
					(1
						((ScriptID 265 0) dispose:) ; synonymPuzzle
						(if (not (IsFlag 31))
							(apples setScript: doReward 0 0)
							(SetFlag 31)
						)
						(= [local0 0] -1)
					)
					(0
						(if (IsFlag 11)
							(= local32 (ScriptID 265 0)) ; synonymPuzzle
							(= local33 0)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cornF of Feature
	(properties
		noun 4
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (and local32 (!= local32 (ScriptID 270 0))) ; homonymPuzzle
					(local32 dispose:)
					(= local32 0)
					(= [local0 local33] -1)
				)
				(cond
					((< [local0 1] 0)
						((ScriptID 270 0) init:) ; homonymPuzzle
						(= [local0 1] global114)
					)
					((!= [local0 1] global114)
						((ScriptID 270 0) dispose: init:) ; homonymPuzzle
						(= [local0 1] global114)
					)
				)
				(switch ((ScriptID 270 0) show:) ; homonymPuzzle
					(1
						((ScriptID 270 0) dispose:) ; homonymPuzzle
						(if (not (IsFlag 32))
							(corn setScript: doReward 0 1)
							(SetFlag 32)
						)
						(= [local0 1] -1)
					)
					(0
						(if (IsFlag 12)
							(= local32 (ScriptID 270 0)) ; homonymPuzzle
							(= local33 1)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance antHillF of Feature
	(properties
		noun 8
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (and local32 (!= local32 (ScriptID 275 0))) ; antonymPuzzle
					(local32 dispose:)
					(= local32 0)
					(= [local0 local33] -1)
				)
				(cond
					((< [local0 2] 0)
						((ScriptID 275 0) init:) ; antonymPuzzle
						(= [local0 2] global114)
					)
					((!= [local0 2] global114)
						((ScriptID 275 0) dispose: init:) ; antonymPuzzle
						(= [local0 2] global114)
					)
				)
				(switch ((ScriptID 275 0) show:) ; antonymPuzzle
					(1
						((ScriptID 275 0) dispose:) ; antonymPuzzle
						(if (not (IsFlag 33))
							(antHill setScript: doReward 0 2)
							(SetFlag 33)
						)
						(= [local0 2] -1)
					)
					(0
						(if (IsFlag 13)
							(= local32 (ScriptID 275 0)) ; antonymPuzzle
							(= local33 2)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hutDoorF of Feature
	(properties
		noun 14
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (SetFlag 26))
			(gCurRoom newRoom: (gCurRoom north:))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance clothes of Feature
	(properties
		noun 6
		onMeCheck 1024
	)
)

(instance goat of Feature
	(properties
		onMeCheck 64
	)
)

(instance smallHuts of Feature
	(properties
		noun 2
		onMeCheck 32
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (and (== theVerb 4) (not (gCurRoom script:)))
			(if (< ((gUser curEvent:) y:) 116)
				(= temp1 1)
			else
				(= temp1 4)
			)
			(cond
				((> (= temp0 ((gUser curEvent:) x:)) 229)
					(+= temp1 2)
				)
				((> temp0 103)
					(+= temp1 1)
				)
			)
			(gCurRoom setScript: showARobot 0 temp1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance palmTree of Feature
	(properties
		noun 10
		onMeCheck 8
	)
)

(instance largeHut of Feature
	(properties
		noun 17
		onMeCheck 256
	)
)

(instance metalContraption of Feature
	(properties
		noun 18
		onMeCheck 2
	)
)

(instance thePath of Feature
	(properties
		noun 3
		onMeCheck 2048
	)
)

(instance pizzaHut of Feature
	(properties
		noun 20
		onMeCheck 512
	)

	(method (doVerb theVerb &tmp [temp0 2])
		(if (== theVerb 4)
			(if (not (gCurRoom script:))
				(gCurRoom setScript: showARobot 0 6)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

