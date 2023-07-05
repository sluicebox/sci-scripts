;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Gold)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm840 0
)

(local
	local0
)

(procedure (localproc_0 param1)
	(return
		(switch param1
			(0 0)
			(1 2)
			(2 4)
		)
	)
)

(procedure (localproc_1)
	(cond
		(
			(and
				(== (Gold puz0Stat:) 0)
				(== (Gold puz1Stat:) 0)
				(== (Gold puz2Stat:) 0)
				(== (Gold puz3Stat:) 0)
				(== (Gold puz4Stat:) 0)
				(== (Gold puz5Stat:) 0)
				(== (Gold puz6Stat:) 0)
				(== (Gold puz7Stat:) 0)
				(== (Gold puz8Stat:) 0)
			)
			(return 0)
		)
		(
			(and
				(== (Gold puz0Stat:) 1)
				(== (Gold puz1Stat:) 1)
				(== (Gold puz2Stat:) 1)
				(== (Gold puz3Stat:) 1)
				(== (Gold puz4Stat:) 1)
				(== (Gold puz5Stat:) 1)
				(== (Gold puz6Stat:) 1)
				(== (Gold puz7Stat:) 1)
				(== (Gold puz8Stat:) 1)
			)
			(return 1)
		)
		(
			(and
				(== (Gold puz0Stat:) 2)
				(== (Gold puz1Stat:) 2)
				(== (Gold puz2Stat:) 2)
				(== (Gold puz3Stat:) 2)
				(== (Gold puz4Stat:) 2)
				(== (Gold puz5Stat:) 2)
				(== (Gold puz6Stat:) 2)
				(== (Gold puz7Stat:) 2)
				(== (Gold puz8Stat:) 2)
			)
			(return 2)
		)
		(else
			(return 3)
		)
	)
)

(instance rm840 of Eco2Room
	(properties
		noun 3
		picture 840
		style 10
		horizon 0
		north 860
		south 820
	)

	(method (init)
		(gGame handsOff:)
		(skylight init:)
		(foothold init:)
		(stairway init:)
		(floor init:)
		(king init:)
		(exitSouth init:)
		(gCurRoom
			addObstacle:
				(if (gCurrentRegionFlags test: 1)
					((Polygon new:)
						type: PBarredAccess
						init: 252 130 252 109 216 109 216 128 189 144 132 154 70 141 4 170 6 186 46 186 81 163 87 165 52 189 0 189 0 0 319 0 319 189 82 189 103 170 111 171 98 185 312 185 311 171
						yourself:
					)
				else
					((Polygon new:)
						type: PBarredAccess
						init: 259 135 216 128 189 144 132 154 70 141 4 170 6 186 46 186 81 163 87 165 52 189 0 189 0 0 319 0 319 189 82 189 103 170 111 171 98 185 317 185 317 176
						yourself:
					)
				)
		)
		(gGameSound1 number: 845 loop: -1 play:)
		(switch gPrevRoomNum
			(820
				(gEgo
					init:
					normalize:
					setScale: Scaler 100 70 185 90
					posn: 56 219
				)
				(self setScript: enterRoomScript)
			)
			(860
				(gEgo
					init:
					normalize:
					setScale: Scaler 100 70 185 90
					posn: 241 116
				)
				(self setScript: enterRoomScript)
			)
			(else
				(gEgo
					x: 227
					y: 146
					init:
					normalize:
					setScale: Scaler 100 70 185 90
				)
				(gGame handsOn:)
			)
		)
		(super init:)
		(snake init: stopUpd:)
		(if (not (gCurrentRegionFlags test: 1))
			(door init: setPri: 5 y: 134 stopUpd:)
		else
			(outdoors init:)
		)
		(if (not (gEgo has: 18))
			(smallPipes init: hide:)
		)
		(if (not (gEgo has: 17))
			(smallCrown init: hide:)
		)
		(panel init: cel: (if (Gold panelStat:) 3 else 0) stopUpd:)
		(if (and (== (Gold panelStat:) 1) (not (gEgo has: 18)))
			(smallPipes show:)
		)
		(if (and (== (Gold panelStat:) 2) (not (gEgo has: 17)))
			(smallCrown show:)
		)
		(if (gCurrentRegionFlags test: 1)
			(exitNorth init:)
		)
		(p0 init: cel: (localproc_0 (Gold puz0Stat:)) stopUpd:)
		(p1 init: cel: (localproc_0 (Gold puz1Stat:)) stopUpd:)
		(p2 init: cel: (localproc_0 (Gold puz2Stat:)) stopUpd:)
		(p3 init: cel: (localproc_0 (Gold puz3Stat:)) stopUpd:)
		(p4 init: cel: (localproc_0 (Gold puz4Stat:)) stopUpd:)
		(p5 init: cel: (localproc_0 (Gold puz5Stat:)) stopUpd:)
		(p6 init: cel: (localproc_0 (Gold puz6Stat:)) stopUpd:)
		(p7 init: cel: (localproc_0 (Gold puz7Stat:)) stopUpd:)
		(p8 init: cel: (localproc_0 (Gold puz8Stat:)) stopUpd:)
		(roomFeat init:)
		(gTheDoits add: roomFeat)
	)

	(method (doit)
		(super doit:)
		(if (and (not script) (gEgo inRect: 212 102 261 110))
			(self newRoom: north)
		)
	)

	(method (newRoom newRoomNumber)
		(gGameSound1 fade:)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 3) local0) ; Walk
			(gGame handsOff:)
			(self setScript: climbDownScript)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance sfx2 of Sound
	(properties)
)

(instance enterRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 820)
					(gEgo setMotion: PolyPath 101 163 self)
				else
					(gEgo setMotion: PolyPath 227 146 self)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spinStoneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch caller
					(0
						(register setCycle: CT 2 1 self)
					)
					(1
						(register setCycle: CT 4 1 self)
					)
					(2
						(register setCycle: CT 5 1 self)
					)
				)
				(sfx number: 842 loop: 1 play:)
			)
			(1
				(if (== caller 2)
					(register setCel: 0)
				)
				(= caller 0)
				(register stopUpd:)
				(switch register
					(p0
						(Gold
							puz0Stat:
								(if (== (Gold puz0Stat:) 2)
									0
								else
									(+ (Gold puz0Stat:) 1)
								)
						)
					)
					(p1
						(Gold
							puz1Stat:
								(if (== (Gold puz1Stat:) 2)
									0
								else
									(+ (Gold puz1Stat:) 1)
								)
						)
					)
					(p2
						(Gold
							puz2Stat:
								(if (== (Gold puz2Stat:) 2)
									0
								else
									(+ (Gold puz2Stat:) 1)
								)
						)
					)
					(p3
						(Gold
							puz3Stat:
								(if (== (Gold puz3Stat:) 2)
									0
								else
									(+ (Gold puz3Stat:) 1)
								)
						)
					)
					(p4
						(Gold
							puz4Stat:
								(if (== (Gold puz4Stat:) 2)
									0
								else
									(+ (Gold puz4Stat:) 1)
								)
						)
					)
					(p5
						(Gold
							puz5Stat:
								(if (== (Gold puz5Stat:) 2)
									0
								else
									(+ (Gold puz5Stat:) 1)
								)
						)
					)
					(p6
						(Gold
							puz6Stat:
								(if (== (Gold puz6Stat:) 2)
									0
								else
									(+ (Gold puz6Stat:) 1)
								)
						)
					)
					(p7
						(Gold
							puz7Stat:
								(if (== (Gold puz7Stat:) 2)
									0
								else
									(+ (Gold puz7Stat:) 1)
								)
						)
					)
					(p8
						(Gold
							puz8Stat:
								(if (== (Gold puz8Stat:) 2)
									0
								else
									(+ (Gold puz8Stat:) 1)
								)
						)
					)
				)
				(if
					(or
						(and
							(!= (Gold panelStat:) (Gold puz0Stat:))
							(== (localproc_1) 1)
						)
						(and
							(!= (Gold panelStat:) (Gold puz0Stat:))
							(== (localproc_1) 2)
						)
					)
					(client setScript: panelScript)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance panelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smallPipes hide:)
				(smallCrown hide:)
				(if (!= (panel cel:) 0)
					(panel setCycle: End self)
				else
					(= cycles 1)
				)
				(sfx number: 844 loop: 1 play:)
			)
			(1
				(panel setCycle: CT 3 1 self)
			)
			(2
				(Gold panelStat: (localproc_1))
				(switch (Gold panelStat:)
					(1
						(if (not (gCurrentRegionFlags test: 6))
							(gCurrentRegionFlags set: 6)
							(gGame points: 5)
						)
						(if (not (gEgo has: 18))
							(smallPipes show:)
						)
					)
					(2
						(if (not (gCurrentRegionFlags test: 7))
							(gCurrentRegionFlags set: 7)
							(gGame points: 5)
						)
						(if (not (gEgo has: 17))
							(smallCrown show:)
						)
					)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(gCurRoom setInset: panelInset)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 7
					y: (- (gEgo y:) 9)
					setPri:
					setCycle: CT 2 1 self
				)
			)
			(1
				(gEgo setCycle: End)
				(sfx number: 846 loop: 1 play:)
				(snake view: 844 setCycle: CT 3 1 self)
			)
			(2
				(sfx2 number: 848 loop: 1 play:)
				(snake setCycle: End self)
			)
			(3
				(gEgo setLoop: 6)
				(gEgo
					cel: (gEgo lastCel:)
					setPri: -1
					y: (+ (gEgo y:) 9)
				)
				(snake view: 840 setCel: 0 stopUpd:)
				(if (gCast contains: door)
					(door setMotion: MoveTo (door x:) 75 self)
				else
					(door
						init:
						setPri: 5
						y: 75
						setMotion: MoveTo (door x:) 134 self
					)
				)
				(sfx number: 840 loop: 1 play:)
			)
			(4
				(if (< (door y:) 100)
					(door dispose:)
					(outdoors init:)
					(exitNorth init:)
					(gCurrentRegionFlags set: 1)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 252 130 252 109 216 109 216 128 189 144 132 154 70 141 4 170 6 186 46 186 81 163 87 165 52 189 0 189 0 0 319 0 319 189 82 189 103 170 111 171 98 185 312 185 311 171
								yourself:
							)
					)
				else
					(outdoors dispose:)
					(exitNorth dispose:)
					(gCurrentRegionFlags clear: 1)
					(door stopUpd:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 259 135 216 128 189 144 132 154 70 141 4 170 6 186 46 186 81 163 87 165 52 189 0 189 0 0 319 0 319 189 82 189 103 170 111 171 98 185 317 185 317 176
								yourself:
							)
					)
				)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance climbUpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 264 135 self)
			)
			(1
				(gEgo
					view: 844
					setLoop: 6
					cel: 0
					posn: 265 135
					setCycle: End self
				)
			)
			(2
				(= local0 1)
				(gWalkHandler add: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbDownScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					normalize: 0
					setMotion:
						PolyPath
						(- (gEgo x:) 5)
						(+ (gEgo y:) 5)
						self
				)
			)
			(2
				(= local0 0)
				(gWalkHandler delete: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance panel of Prop
	(properties
		x 291
		y 165
		noun 5
		view 840
		priority 9
		signal 16400
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(switch (Gold panelStat:)
					(0
						(gMessager say: noun theVerb 12 1) ; "The panel is firmly closed."
					)
					(1
						(if (gCast contains: smallPipes)
							(gMessager say: noun theVerb 9 1) ; "A pair of ancient pipes carved from bone rests in the dark opening."
						else
							(gMessager say: noun theVerb 7 1) ; "The dark opening is now empty."
						)
					)
					(2
						(if (gCast contains: smallCrown)
							(gMessager say: noun theVerb 8 1) ; "The panel has rotated and a hiding place is revealed. A golden crown and tiny pot are inside."
						else
							(gMessager say: noun theVerb 7 1) ; "The dark opening is now empty."
						)
					)
				)
			)
			((== theVerb 4) ; Do
				(switch (Gold panelStat:)
					(0
						(gMessager say: noun 1 12 1) ; "The panel is firmly closed."
					)
					(1
						(if (gCast contains: smallPipes)
							(smallPipes doVerb: theVerb &rest)
						else
							(gMessager say: noun theVerb 7 1) ; "Adam has everything that the Old Ones hid here."
						)
					)
					(2
						(if (gCast contains: smallCrown)
							(smallCrown doVerb: theVerb &rest)
						else
							(gMessager say: noun theVerb 7 1) ; "Adam has everything that the Old Ones hid here."
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

(instance smallPipes of Prop
	(properties
		x 289
		y 169
		z 30
		view 840
		loop 2
		priority 10
		signal 16
	)

	(method (doit)
		(if (not (IsEcorderFlag 79))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 79))
			(switch theVerb
				(4 ; Do
					(if (not local0)
						(gGame handsOff:)
						(gCurRoom setScript: getSmallItemScript 0 1)
					else
						(gMessager say: 1 theVerb 13 1) ; "Adam must climb down first."
					)
				)
				(1 ; Look
					(gMessager say: 5 1 9 1) ; "A pair of ancient pipes carved from bone rests in the dark opening."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance smallCrown of Prop
	(properties
		x 289
		y 139
		view 840
		loop 3
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local0)
					(gGame handsOff:)
					(gCurRoom setScript: getSmallItemScript 0 0)
				else
					(gMessager say: 1 theVerb 13 1) ; "Adam must climb down first."
				)
			)
			(1 ; Look
				(gMessager say: 5 1 9 1) ; "A pair of ancient pipes carved from bone rests in the dark opening."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Actor
	(properties
		x 235
		noun 9
		yStep 5
		view 840
		loop 1
		priority 7
		signal 26640
	)
)

(instance snake of Prop
	(properties
		x 243
		y 48
		noun 7
		view 840
		loop 5
		priority 9
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gMessager say: noun theVerb 11 1) ; "Adam can't reach the snake from here."
			else
				(gGame handsOff:)
				(if (not (gCurrentRegionFlags test: 10))
					(gCurrentRegionFlags set: 10)
					(gGame points: 3)
				)
				(gCurRoom setScript: doorScript)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance panelInset of Inset
	(properties
		view 841
		x 317
		y 74
		priority 12
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(gEgo setPri: 11 stopUpd:)
		(door stopUpd:)
		(panel stopUpd:)
		(smallPipes stopUpd:)
		(smallCrown stopUpd:)
		(p0 stopUpd:)
		(p1 stopUpd:)
		(p2 stopUpd:)
		(p3 stopUpd:)
		(p4 stopUpd:)
		(p5 stopUpd:)
		(p6 stopUpd:)
		(p7 stopUpd:)
		(p8 stopUpd:)
		(switch (Gold panelStat:)
			(1
				(if (not (gEgo has: 18))
					(insPipes init: posn: (- x 80) (+ y 80))
				)
			)
			(2
				(if (not (gEgo has: 17))
					(insCrown init: posn: (- x 59) (+ y 80))
					(insGold init: posn: (- x 100) (+ y 80))
				)
			)
		)
	)

	(method (dispose)
		(if (gCast contains: insPipes)
			(insPipes dispose:)
		)
		(if (gCast contains: insCrown)
			(insCrown dispose:)
		)
		(if (gCast contains: insGold)
			(insGold dispose:)
		)
		(panelScript cue:)
		(gTheIconBar enable: 8)
		(gEgo setPri: -1)
		(super dispose: &rest)
	)
)

(instance getItemScript of Script
	(properties)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheDoits add: self)
				(if (== register insPipes)
					(gEgo get: 18)
					(insPipes hide:)
					(gGame points: 5)
				else
					(gEgo get: 17)
					(gEgo get: 20)
					(insCrown hide:)
					(gGame points: 10)
				)
				(= seconds 2)
			)
			(1
				(if (== register insPipes)
					(= cycles 1)
				else
					(insGold hide:)
					(= seconds 2)
				)
			)
			(2
				(gTheDoits delete: self)
				(panelInset dispose:)
				(if (== register insPipes)
					(smallPipes dispose:)
				else
					(smallCrown dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance getSmallItemScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 284 153 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(if register
					(gEgo get: 18)
					(gGame points: 5)
					(smallPipes dispose:)
				else
					(gEgo get: 17)
					(gEgo get: 20)
					(gGame points: 10)
					(smallCrown dispose:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance insPipes of Prop
	(properties
		view 841
		loop 2
		priority 13
		signal 16
	)

	(method (doit)
		(if (not (IsEcorderFlag 79))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 79))
			(switch theVerb
				(4 ; Do
					(gGame handsOff:)
					(getItemScript register: self init:)
				)
				(1 ; Look
					(gMessager say: 5 1 9 1) ; "A pair of ancient pipes carved from bone rests in the dark opening."
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance insCrown of Prop
	(properties
		view 841
		loop 1
		priority 13
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(getItemScript register: self init:)
			)
			(1 ; Look
				(gMessager say: 5 1 8 1) ; "The panel has rotated and a hiding place is revealed. A golden crown and tiny pot are inside."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance insGold of Prop
	(properties
		view 841
		loop 3
		priority 13
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(getItemScript register: self init:)
			)
			(1 ; Look
				(gMessager say: 5 1 8 1) ; "The panel has rotated and a hiding place is revealed. A golden crown and tiny pot are inside."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance p0 of Prop
	(properties
		x 101
		y 64
		noun 1
		view 842
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if (not local0)
					(gGame handsOff:)
					(gCurRoom setScript: spinStoneScript (Gold puz0Stat:) self)
				else
					(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
				)
			)
			((== theVerb 1) ; Look
				(switch (localproc_1)
					(0
						(gMessager say: noun theVerb 3 1) ; "Evenly carved stones have been carefully placed together to form this plain wall. The texture of the stone is slightly different from the rest."
					)
					(1
						(gMessager say: noun theVerb 6 1) ; "A crowned figure plays some sort of instrument."
					)
					(2
						(gMessager say: noun theVerb 5 1) ; "A crowned king seems to be dancing."
					)
					(else
						(gMessager say: noun theVerb 4 1) ; "The blocks of stone might be an image if they were not so jumbled."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance p1 of Prop
	(properties
		x 101
		y 90
		noun 1
		view 842
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gGame handsOff:)
				(gCurRoom setScript: spinStoneScript (Gold puz1Stat:) self)
			else
				(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
			)
		else
			(p0 doVerb: theVerb &rest)
		)
	)
)

(instance p2 of Prop
	(properties
		x 101
		y 115
		noun 1
		view 842
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gGame handsOff:)
				(gCurRoom setScript: spinStoneScript (Gold puz2Stat:) self)
			else
				(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
			)
		else
			(p0 doVerb: theVerb &rest)
		)
	)
)

(instance p3 of Prop
	(properties
		x 131
		y 64
		noun 1
		view 842
		loop 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gGame handsOff:)
				(gCurRoom setScript: spinStoneScript (Gold puz3Stat:) self)
			else
				(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
			)
		else
			(p0 doVerb: theVerb &rest)
		)
	)
)

(instance p4 of Prop
	(properties
		x 131
		y 90
		noun 1
		view 842
		loop 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gGame handsOff:)
				(gCurRoom setScript: spinStoneScript (Gold puz4Stat:) self)
			else
				(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
			)
		else
			(p0 doVerb: theVerb &rest)
		)
	)
)

(instance p5 of Prop
	(properties
		x 131
		y 115
		noun 1
		view 842
		loop 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gGame handsOff:)
				(gCurRoom setScript: spinStoneScript (Gold puz5Stat:) self)
			else
				(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
			)
		else
			(p0 doVerb: theVerb &rest)
		)
	)
)

(instance p6 of Prop
	(properties
		x 162
		y 64
		noun 1
		view 843
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gGame handsOff:)
				(gCurRoom setScript: spinStoneScript (Gold puz6Stat:) self)
			else
				(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
			)
		else
			(p0 doVerb: theVerb &rest)
		)
	)
)

(instance p7 of Prop
	(properties
		x 162
		y 90
		noun 1
		view 843
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gGame handsOff:)
				(gCurRoom setScript: spinStoneScript (Gold puz7Stat:) self)
			else
				(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
			)
		else
			(p0 doVerb: theVerb &rest)
		)
	)
)

(instance p8 of Prop
	(properties
		x 162
		y 115
		noun 1
		view 843
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not local0)
				(gGame handsOff:)
				(gCurRoom setScript: spinStoneScript (Gold puz8Stat:) self)
			else
				(gMessager say: noun theVerb 13 1) ; "Adam must climb down first."
			)
		else
			(p0 doVerb: theVerb &rest)
		)
	)
)

(instance exitNorth of ExitFeature
	(properties
		nsTop 70
		nsLeft 211
		nsBottom 120
		nsRight 262
		cursor 13
		exitDir 1
	)
)

(instance exitSouth of ExitFeature
	(properties
		nsTop 185
		nsLeft 59
		nsBottom 189
		nsRight 88
		cursor 10
		exitDir 3
	)
)

(instance roomFeat of Feature
	(properties
		x 160
		y 10
		nsBottom 50
		nsRight 196
	)

	(method (doit)
		(if (not (IsEcorderFlag 80))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 80))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance skylight of Feature
	(properties
		x 113
		y 16
		noun 2
		nsLeft 29
		nsBottom 32
		nsRight 198
		sightAngle 40
		approachX 127
		approachY 159
	)

	(method (doit)
		(if (not (IsEcorderFlag 80))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 80))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foothold of Feature
	(properties
		x 269
		y 79
		noun 6
		nsTop 9
		nsLeft 260
		nsBottom 149
		nsRight 279
		sightAngle 40
		approachX 264
		approachY 145
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(if local0
				(gCurRoom setScript: climbDownScript)
			else
				(if (not (gCurrentRegionFlags test: 9))
					(gCurrentRegionFlags set: 9)
					(gGame points: 2)
				)
				(gCurRoom setScript: climbUpScript)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance stairway of Feature
	(properties
		x 83
		y 177
		noun 4
		nsTop 170
		nsLeft 70
		nsBottom 184
		nsRight 96
		sightAngle 40
		approachX 83
		approachY 177
	)
)

(instance floor of Feature
	(properties
		x 159
		y 150
		noun 10
		nsTop 134
		nsBottom 189
		nsRight 319
		sightAngle 40
		approachX 159
		approachY 161
	)

	(method (doVerb theVerb)
		(if (and local0 (== theVerb 4)) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: climbDownScript)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance outdoors of Feature
	(properties
		x 237
		y 91
		noun 13
		nsTop 71
		nsLeft 212
		nsBottom 111
		nsRight 261
		sightAngle 40
	)
)

(instance king of Feature
	(properties
		x 216
		y 44
		noun 8
		nsTop 20
		nsLeft 201
		nsBottom 69
		nsRight 231
		sightAngle 40
	)
)

