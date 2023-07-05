;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm701 0
)

(local
	local0 = 1
	local1
	local2 = 1
	local3
)

(instance rm701 of Eco2Room
	(properties
		picture 700
		style 10
		west 700
	)

	(method (doVerb)
		(return 0)
	)

	(method (init)
		(if (== gPrevRoomNum 700)
			(= style 12)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 136 114 136 136 90 136 90 114
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 82 87 82 100 54 100 54 87
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 150 90 150 104 120 104 120 90
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 188 82 188 94 160 94 160 82
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 275 107 275 118 218 118 218 98 266 98
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 307 86 307 108 279 108 268 97 268 86
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 185 200 185 200 156 315 156 315 80 0 80 0 0 319 0 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 3 109 53 109 53 135 3 135
					yourself:
				)
		)
		(gEgo x: 15 init: normalize: setScale: Scaler 100 35 189 80)
		(if (== (gEgo view:) 10)
			(gEgo loop: 0 setCycle: StopWalk 13)
		)
		(rock init:)
		(if (not (gCurrentRegionFlags test: 6))
			(monkey init:)
		)
		(if (not (gCurrentRegionFlags test: 3))
			(jawBone init:)
		)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
		(roots1 init:)
		(roots2 init:)
		(roots3 init:)
		(roots4 init:)
		(water init:)
		(gWalkHandler addToFront: water)
		(exitwest init:)
		(super init:)
		(gGame handsOn:)
		(Animate (gCast elements:) 1)
		(cond
			((not (gCurrentRegionFlags test: 7))
				(gCurrentRegionFlags set: 7)
				(gMessager say: 2 0 4) ; "Oh, woe is me! I'm eagle fodder! Boohoo!"
			)
			((and (== (gEgo view:) 702) (not (gCurrentRegionFlags test: 9)))
				(= gGameTime (GetTime))
				(gMessager say: 2 0 5) ; "Look at this! Cool, huh?"
				(gEgo setMotion: PolyPath 140 160)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: water)
		(super dispose:)
	)
)

(instance exitwest of ExitFeature
	(properties
		nsTop 71
		nsBottom 189
		nsRight 8
		cursor 12
		exitDir 4
	)

	(method (handleEvent)
		(= toX 0)
		(= toY ((User curEvent:) y:))
		(super handleEvent: &rest)
	)
)

(instance tree1 of Feature
	(properties
		x 28
		y 69
		noun 5
		nsTop 14
		nsLeft 17
		nsBottom 104
		nsRight 40
		sightAngle 40
		approachX 28
		approachY 59
	)
)

(instance tree2 of Feature
	(properties
		x 65
		y 69
		noun 5
		nsTop 37
		nsLeft 56
		nsBottom 85
		nsRight 74
		sightAngle 40
		approachX 65
		approachY 61
	)
)

(instance tree3 of Feature
	(properties
		x 111
		y 69
		noun 5
		nsTop 14
		nsLeft 100
		nsBottom 106
		nsRight 122
		sightAngle 40
		approachX 111
		approachY 60
	)
)

(instance tree4 of Feature
	(properties
		x 138
		y 69
		noun 5
		nsTop 40
		nsLeft 133
		nsBottom 88
		nsRight 144
		sightAngle 40
		approachX 138
		approachY 64
	)
)

(instance tree5 of Feature
	(properties
		x 174
		y 69
		noun 5
		nsTop 44
		nsLeft 168
		nsBottom 80
		nsRight 181
		sightAngle 40
		approachX 174
		approachY 62
	)
)

(instance tree6 of Feature
	(properties
		x 244
		y 59
		noun 5
		nsTop 6
		nsLeft 224
		nsBottom 98
		nsRight 264
		sightAngle 40
		approachX 244
		approachY 52
	)
)

(instance tree7 of Feature
	(properties
		x 285
		y 69
		noun 5
		nsTop 24
		nsLeft 275
		nsBottom 84
		nsRight 295
		sightAngle 40
		approachX 285
		approachY 54
	)
)

(instance roots1 of Feature
	(properties
		x 28
		y 115
		noun 7
		nsTop 105
		nsLeft 14
		nsBottom 126
		nsRight 42
		sightAngle 40
		approachX 28
		approachY 115
	)
)

(instance roots2 of Feature
	(properties
		x 110
		y 116
		noun 7
		nsTop 107
		nsLeft 98
		nsBottom 125
		nsRight 123
		sightAngle 40
		approachX 110
		approachY 116
	)
)

(instance roots3 of Feature
	(properties
		x 246
		y 105
		noun 7
		nsTop 98
		nsLeft 224
		nsBottom 112
		nsRight 268
		sightAngle 40
		approachX 246
		approachY 105
	)
)

(instance roots4 of Feature
	(properties
		x 287
		y 94
		noun 7
		nsTop 85
		nsLeft 274
		nsBottom 103
		nsRight 301
		sightAngle 40
		approachX 287
		approachY 94
	)
)

(instance water of Feature
	(properties
		x 159
		y 163
		noun 6
		nsTop 80
		nsBottom 189
		nsRight 319
		sightAngle 360
		approachX 159
		approachY 169
	)

	(method (onMe param1)
		(if (super onMe: param1 &rest)
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== ((gTheIconBar curInvIcon:) message:) 55)
					(not (IsEcorderFlag 14))
					(IsEcorderFlag 22)
				)
				(= y 200)
			else
				(= y 31)
			)
			(return 1)
		)
		(return 0)
	)

	(method (doit)
		(if (and (not (IsEcorderFlag 14)) (not (monkey onMe: gMouseX gMouseY)))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(or (& (event type:) evMOVE) (== (event message:) JOY_DOWNRIGHT))
				(self onMe: event)
			)
			(cond
				(
					(and
						(or (< (event x:) 200) (< (event y:) 130))
						(self doVerb: 3)
					)
					(event claimed: 1)
					(return 1)
				)
				((== (event message:) JOY_DOWNRIGHT)
					(super handleEvent: event &rest)
					(return)
				)
				(else
					(event claimed: 0)
					(return 0)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(cond
			((self perform: gWriteEcorderData theVerb 14))
			(
				(and
					(not local0)
					(or (== theVerb 3) (== theVerb 4)) ; Walk, Do
					(gEgo inRect: 229 156 256 160)
				)
				(gEgo setScript: jumpIn)
			)
			((== theVerb 3) ; Walk
				(return 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)
)

(instance lilyPad of View
	(properties
		x 192
		y 181
		view 700
		loop 1
		signal 16384
	)
)

(instance jawBone of View
	(properties
		x 250
		y 258
		z 100
		noun 3
		view 700
		loop 4
		priority 12
		signal 16400
	)

	(method (onMe param1)
		(if (super onMe: param1 &rest)
			(if local0
				(= sightAngle 180)
			else
				(= sightAngle 26505)
			)
			(return 1)
		)
		(return 0)
	)

	(method (doit)
		(if (not (IsEcorderFlag 43))
			(self perform: gCheckEcorderIcon self)
		)
		(if (and (not local1) (self onMe: gEgo) (not local0))
			(= local1 1)
			(gEgo setScript: findBone)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 43))
			(switch theVerb
				(4 ; Do
					(if local0
						(super doVerb: theVerb &rest)
					else
						(gEgo setScript: getJaw)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance rock of View
	(properties
		x 208
		y 140
		noun 4
		approachX 233
		approachY 156
		view 700
		loop 2
		priority 12
		signal 20496
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(if (== (gEgo view:) 702)
			(= approachX 192)
			(= approachY 181)
		)
		(super init:)
		(self addToPic:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCurrentRegionFlags test: 4)
				(if local0
					(= local0 0)
					(self approachVerbs:)
					(if (== (gEgo view:) 702)
						(gCurRoom setScript: giveLily)
					else
						(gCurRoom setScript: climbRock)
					)
				else
					(super doVerb: theVerb &rest)
				)
			else
				(monkey setScript: monkeyHowl)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance monkeyTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 360))
			)
			(1
				(sFX2 number: 704 loop: 1 play: self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance monkey of Actor
	(properties
		x 285
		y 164
		noun 1
		view 710
		priority 13
		signal 22544
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(= approachX (rock approachX:))
		(= approachY (rock approachY:))
		(self setCycle: Fwd)
		(monkey setScript: monkeyTalkScr)
		(super init:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 22))
			(self perform: gCheckEcorderIcon self)
		)
		(cond
			((not (gCurrentRegionFlags test: 4))
				(if
					(and
						(<
							(self distanceTo: gEgo)
							(if (not loop) 85 else 65)
						)
						(not script)
						(> (gEgo y:) 125)
					)
					(monkey setScript: monkeyHowl)
				)
			)
			(
				(and
					(not (gCurrentRegionFlags test: 10))
					(< (self distanceTo: gEgo) 100)
					(== (gEgo view:) 702)
				)
				(gCurrentRegionFlags set: 10)
				(gMessager say: 1 2 5) ; "I bet I could swim out of here on that!"
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55 ; E-corder
				(if (not (IsEcorderFlag 22))
					(self perform: gWriteEcorderData theVerb 22)
				else
					(super doVerb: theVerb)
				)
			)
			(12 ; fruit
				(gGame points: 5)
				(gCurRoom setScript: tossFruit)
			)
			(4 ; Do
				(if _approachVerbs
					(rock doVerb: theVerb &rest)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(if (not (gCurrentRegionFlags test: 13))
					(gCurrentRegionFlags set: 13)
					(gGame points: 1)
				)
				(if (or (== (gEgo view:) 702) (gCurrentRegionFlags test: 11))
					(if (gCurrentRegionFlags test: 4)
						(if (== (gEgo view:) 702)
							(gCurrentRegionFlags set: 10)
							(gMessager say: 1 2 5) ; "I bet I could swim out of here on that!"
						else
							(gMessager say: 1 2 8) ; "I need a way out of here!"
						)
					else
						(gMessager say: 1 2 1) ; "At least bring me something to eat! I don't want to die hungry!"
					)
				else
					(gCurrentRegionFlags set: 11)
					(gMessager say: 1 2 6) ; "Just stay back, you, you HUMAN!"
				)
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 4)
					(gMessager say: 1 1 2) ; "The monkey sniffs from time to time. He watches Adam quietly."
				else
					(gMessager say: 1 1 1) ; "A howler monkey sobs hysterically on a rock that juts out of the floodwater."
				)
			)
			(13 ; amulet
				(if (gCurrentRegionFlags test: 4)
					(gMessager say: 1 13 2) ; "Forest Heart can't help me get away from the eagle."
				else
					(gMessager say: 1 13 1) ; "What does Forest Heart have to do with my problems?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance getJaw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 240 157 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo view: 5 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(jawBone dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(gGame points: 5)
				(gEgo
					get: 15
					normalize: 0
					signal: (| (gEgo signal:) $0010)
					priority: 13
				)
				(gCurrentRegionFlags set: 3)
				(= cycles 2)
			)
			(5
				(gMessager say: 3 0 7 0 self) ; "Adam picks up the piranha jawbone."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance findBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: 0
					view: 701
					loop: 2
					setSpeed: 6
					setCycle: End self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo cel: 0 setCycle: End self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gEgo
					normalize: 0
					signal: (| (gEgo signal:) $0010)
					priority: 13
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (not state) (== (gEgo cel:) 0))
			(sFX number: 722 setLoop: 1 play:)
		)
		(super doit:)
	)
)

(instance giveLily of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 10)
				(if (== (monkey y:) 164)
					(monkey setCycle: CT 8 1 self)
				else
					(self cue:)
				)
				(gCurrentRegionFlags set: 6)
				(gEgo setHeading: 180 self)
			)
			(1)
			(2
				(if (== (monkey y:) 164)
					(monkey loop: 4 setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(if (== (monkey loop:) 4)
					(monkey x: 262 y: 138 loop: 1 cel: 0)
				)
				(gEgo view: 701 loop: 5 cel: 0 setCycle: End self)
			)
			(4
				(gEgo view: 701 loop: 3 cel: 3 setCycle: Beg self)
				(lilyPad init:)
			)
			(5
				(= cycles 5)
			)
			(6
				(gMessager say: 4 4 5 0 self) ; "Gee, thanks! I thought I was toast."
			)
			(7
				(gEgo view: 10 loop: 2 setCycle: StopWalk 13)
				(monkey
					loop: 5
					cel: 0
					x: 195
					y: 184
					signal: (| (monkey signal:) $0010)
					priority: 14
					setCycle: End self
				)
			)
			(8
				(gEgo setMotion: PolyPath 230 157 self)
				(monkey
					setLoop: 3
					cel: 0
					setCycle: Walk
					setMotion: MoveTo -25 (- (lilyPad y:) 20) self
				)
				(sFX number: 600 setLoop: 1 play:)
				(lilyPad dispose:)
			)
			(9
				(= local2 0)
				(self setScript: climbRock 0 270)
				(gGameSound1
					number: 200
					setLoop: -1
					setVol: 0
					play:
					fade: 127 100 20 0
				)
				(gGameSound2 fade: 0 100 20 1)
			)
			(10
				(Load rsSOUND 723)
				(gEgo
					view: 19
					loop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
				(= ticks 15)
			)
			(11
				(sFX number: 723 loop: 1 play:)
			)
			(12
				(= ticks 10)
			)
			(13
				(gEgo loop: 1 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(14
				(monkey dispose:)
				(gCurRoom style: 10)
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance jumpIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rock approachVerbs: 4) ; Do
				(monkey approachVerbs: 4) ; Do
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 229 156 self)
			)
			(2
				(gEgo view: 701 setLoop: 7 cel: 0 setCycle: CT 10 1 self)
			)
			(3
				(sFX number: 869 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					x: (- (gEgo x:) 70)
					y: (- (gEgo y:) 5)
					loop: 3
					cel: 3
					setScale: Scaler 100 35 189 80
					setCycle: Beg self
				)
			)
			(5
				(gEgo normalize: 10 setCycle: StopWalk 13)
				((gCurRoom obstacles:) delete: local3)
				(local3 dispose:)
				(gGame handsOn:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance tossFruit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gEgo inRect: 0 139 204 189)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 150 160 self)
				)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gMessager say: 2 0 9 0 self) ; "Here! Catch!"
			)
			(3
				(if (== (monkey y:) 164)
					(monkey setCycle: CT 8 1 self)
				else
					(monkey loop: 1 cel: 0)
					(self cue:)
				)
			)
			(4
				(if (== (monkey y:) 164)
					(monkey loop: 4 cel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(5
				(if (== (monkey loop:) 4)
					(monkey x: 262 y: 138 loop: 1 cel: 0)
				)
				(gEgo view: 701 loop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(6
				((= register (Actor new:))
					view: 701
					setLoop: 1
					x: (gEgo x:)
					y: (- (gEgo y:) 20)
					setCycle: Fwd
					setPri: 15
					setMotion: JumpTo 232 99 self
					init:
				)
				(sFX number: 715 setLoop: 1 play:)
				(gCurrentRegionFlags set: 4)
				(gEgo put: 16 setCycle: End)
				(register
					xStep: 5
					scaleSignal: (| (register scaleSignal:) $0004)
				)
			)
			(7
				(gEgo view: 10 setCycle: StopWalk 13)
				(monkey setCycle: CT 2 1)
				(register setMotion: MoveTo 246 104 self)
			)
			(8
				(register dispose:)
				(monkey cel: 3)
				(= cycles 2)
			)
			(9
				(gMessager say: 2 0 3 0 self) ; "For me? Really! Hey, I don't know what to say."
			)
			(10
				(sFX number: 716 setLoop: 1 play:)
				(monkey setCycle: End self)
			)
			(11
				(monkey view: 710 loop: 2 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance monkeyHowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsObject ((gEgo looper:) oldMover:))
					(((gEgo looper:) oldMover:) dispose:)
					((gEgo looper:) oldMover: 0)
				)
				(gEgo setMotion: 0)
				(if (== (monkey y:) 164)
					(monkey setCycle: CT 8 1 self)
				else
					(sFX number: 205 setLoop: 1 play:)
					(monkey setCycle: End self)
				)
			)
			(1
				(if (== (monkey y:) 164)
					(monkey loop: 4 cel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (== (monkey loop:) 4)
					(sFX number: 702 setLoop: 1 play:)
					(monkey x: 262 y: 138 loop: 2 cel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(gMessager say: 1 4 1 1) ; "Hssss! Stay away! I'll bite you!"
				(monkey cel: 0)
				(gEgo
					setMotion:
						PolyPath
						(if (< (gEgo x:) (monkey x:))
							(- (gEgo x:) 20)
						else
							(gEgo x:)
						)
						(if (< (gEgo y:) (monkey y:))
							(- (gEgo y:) 15)
						else
							(gEgo y:)
						)
						self
				)
			)
			(4
				(gEgo setHeading: 100 self)
			)
			(5
				(= cycles 3)
			)
			(6
				(if (gCurrentRegionFlags test: 8)
					(self cue:)
				else
					(gMessager say: 1 4 1 2 self) ; "Come on, I won't hurt you."
				)
			)
			(7
				(if (gCurrentRegionFlags test: 8)
					(self cue:)
				else
					(gMessager say: 1 4 1 3 self) ; "It's not that. I've been stuck here for hours and I'm sooooo hungry."
					(gCurrentRegionFlags set: 8)
				)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(monkey approachVerbs:)
				((= local3 (Polygon new:))
					type: PContainedAccess
					init: 254 160 255 156 229 156 229 160
					yourself:
				)
				((gCurRoom obstacles:) add: local3)
				(= cycles 5)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(if (gCurrentRegionFlags test: 6)
					(self cue:)
				else
					(gMessager say: 1 4 2 0 self) ; "I guess you can climb up."
				)
			)
			(3
				(gEgo
					signal: (| (gEgo signal:) $0010)
					priority: 13
					x: 234
					y: 157
					view: 701
					loop: 6
					cel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(4
				(if (== (monkey y:) 164)
					(monkey setCycle: CT 8 1 self)
				else
					(self cue:)
				)
			)
			(5
				(if (== (monkey y:) 164)
					(monkey loop: 4 setCycle: End self)
				else
					(self cue:)
				)
			)
			(6
				(if (== (monkey loop:) 4)
					(monkey x: 262 y: 138 loop: 1 cel: 0)
				)
				(gEgo
					view: 0
					normalize:
					signal: (| (gEgo signal:) $0010)
					priority: 13
				)
				(if register
					(gEgo setHeading: register self)
				else
					(self cue:)
				)
			)
			(7
				(if local2
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sFX of Sound
	(properties)
)

(instance sFX2 of Sound
	(properties)
)

