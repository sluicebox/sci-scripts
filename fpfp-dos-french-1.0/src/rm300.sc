;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm300 of FPRoom
	(properties
		noun 1
		picture 300
		style 10
		east 310
		south 220
	)

	(method (init)
		(gEgo init: setScale: Scaler 75 48 182 41 normalize:)
		(switch gPrevRoomNum
			(east
				(= style 11)
				(gGame handsOn:)
			)
			(south
				(gEgo x: 44)
				(gGame handsOn:)
			)
			(680
				(gGame handsOn:)
			)
			(540
				(srini
					init:
					stopUpd:
					setScale: Scaler 75 48 182 41
					approachVerbs: 4 2 ; Do, Talk
				)
				(gCurRoom setScript: sAfterPractice)
			)
			(else
				(gEgo x: 44 y: 184)
				(gGame handsOn:)
			)
		)
		(super init:)
		(cond
			((== gCurPuzzle 14) 0)
			((== gPrevRoomNum 540)
				(gGameMusic1 number: 185 loop: -1 play:)
			)
			(else
				(gGameMusic2 number: 2300 loop: -1 play:)
			)
		)
		(if (<= (gEgo y:) 80)
			(SetFlag 50)
			(gCurRoom
				addObstacle:
					(cond
						((and (>= gCurPuzzle 13) (IsFlag 97))
							(= local1
								((Polygon new:)
									type: PBarredAccess
									init: 319 189 0 189 0 0 319 0 319 41 301 41 268 26 292 13 287 10 252 27 233 22 242 16 210 12 160 35 178 43 186 38 201 40 206 49 203 53 282 90 319 80
									yourself:
								)
							)
						)
						((and (>= gCurPuzzle 11) (<= gCurPuzzle 13))
							(= local0
								((Polygon new:)
									type: PBarredAccess
									init: 319 189 0 189 0 0 319 0 319 41 301 41 268 26 292 13 287 10 252 27 233 22 242 16 210 12 160 35 172 40 215 20 261 32 213 60 282 90 319 80
									yourself:
								)
							)
						)
						(else
							(= local0
								((Polygon new:)
									type: PBarredAccess
									init: 319 189 0 189 0 0 319 0 319 41 301 41 268 26 292 13 287 10 252 27 233 22 242 16 210 12 160 35 282 90 319 80
									yourself:
								)
							)
						)
					)
					((Polygon new:)
						type: PBarredAccess
						init: 191 33 216 22 228 27 203 39
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 310 55 282 75 265 65 289 47
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					(if
						(or
							(and (>= gCurPuzzle 17) (<= gCurPuzzle 18))
							(== gPrevRoomNum 540)
						)
						((Polygon new:)
							type: PBarredAccess
							init: 279 128 174 73 174 68 152 60 136 62 138 69 170 81 176 88 159 90 141 92 87 87 70 94 83 106 73 113 51 111 38 119 72 134 0 189 0 0 319 0 319 102
							yourself:
						)
					else
						((Polygon new:)
							type: PBarredAccess
							init: 277 123 174 73 176 69 151 59 136 60 136 66 170 81 171 86 159 90 139 90 124 90 87 87 40 105 41 124 72 134 0 189 0 0 319 0 319 102
							yourself:
						)
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 171 319 189 61 189 138 129
						yourself:
					)
			)
			(ClearFlag 50)
		)
		(outhouseDoor init: approachVerbs: (if (IsFlag 50) 0 else 4) stopUpd:)
		(tree init: setOnMeCheck: 1 8)
		(bottomBuilding init: setOnMeCheck: 1 16)
		(hangman init: setOnMeCheck: 1 32)
		(eastBuilding init: setOnMeCheck: 1 64)
		(buildingSign init: setOnMeCheck: 1 128)
		(outhouse init: setOnMeCheck: 1 256)
		(westBuilding init: setOnMeCheck: 1 512)
		(fencePosts init: setOnMeCheck: 1 1024)
		(angelPost init: setOnMeCheck: 1 1024)
		(desert init: setOnMeCheck: 1 -32768)
		(boulder init: setOnMeCheck: 1 8192)
		(graveYard init: setOnMeCheck: 1 16384)
		(cactus init: setOnMeCheck: 1 64)
		(stone1 init: setOnMeCheck: 1 2)
		(stone2 init: setOnMeCheck: 1 4)
		(stone3 init: setOnMeCheck: 1 8)
		(stone4 init: setOnMeCheck: 1 16)
		(stone5 init: setOnMeCheck: 1 32)
		(stone6 init: setOnMeCheck: 1 64)
		(stone7 init: setOnMeCheck: 1 128)
		(stone8 init: setOnMeCheck: 1 256)
		(fence
			init:
			setOnMeCheck: 1 4
			approachVerbs: (if (IsFlag 50) 0 else 34)
		)
		(noose init: cycleSpeed: 13 setScript: sNooseSwings)
		(cond
			((<= gCurPuzzle 10)
				(emptyGrave init: addToPic:)
			)
			((and (>= gCurPuzzle 11) (<= gCurPuzzle 13))
				(digger init: setCycle: Fwd)
				(= local3 1)
			)
			((and (> gCurPuzzle 13) (<= gCurPuzzle 19))
				(if (IsFlag 97)
					(dirtPile init: stopUpd: approachVerbs: 4 63) ; Do, Shovel
				else
					(filledGrave init: stopUpd: approachVerbs: 4 63) ; Do, Shovel
				)
			)
			((>= gCurPuzzle 20)
				(filledGrave init: stopUpd: approachVerbs: 4) ; Do
			)
		)
		(if (and (>= gCurPuzzle 17) (<= gCurPuzzle 18))
			(srini
				init:
				stopUpd:
				setScale: Scaler 75 48 182 41
				approachVerbs:
					(if (IsFlag 50)
						0
					else
						4
						2
					)
			)
		)
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
	)

	(method (dispose)
		(cond
			((== gCurPuzzle 14) 0)
			((== gPrevRoomNum 540)
				(gGameMusic1 fade:)
			)
			(else
				(gGameMusic2 fade:)
			)
		)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sOuthouseGag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorSound number: 2146 play:)
				(outhouseDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 14 139 self)
			)
			(2
				(= ticks 70)
			)
			(3
				(gEgo setMotion: MoveTo 28 138 self)
			)
			(4
				(gEgo setMotion: MoveTo 55 144 self)
			)
			(5
				(gEgo setMotion: MoveTo 41 158 self)
			)
			(6
				(Face gEgo outhouseDoor)
				(= cycles 10)
			)
			(7
				(gMessager say: 34 0 0 0 self) ; "Hmmmm...not much privacy, but the ventilation is EXCELLENT!"
			)
			(8
				(doorSound number: 2147 play:)
				(outhouseDoor setCycle: Beg self)
			)
			(9
				(outhouseDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNooseSwings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
			)
			(1
				(noose setCycle: Fwd)
				(= seconds (Random 1 5))
			)
			(2
				(noose setCycle: CT 0 1 self)
			)
			(3
				(noose stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance sAfterPractice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo srini)
				(= cycles 10)
			)
			(1
				(gMessager say: 19 0 0 0 self) ; "Say, Freddy Pharkas! You are not so bad after all at this shooting gig!"
			)
			(2
				(gGame handsOn: setCursor: 0 1)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyDigsGrave of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gEgo cel:) 3)
			(graveDigger play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (gEgo moveSpeed:))
				(Narrator modeless: 1)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 303
					loop: 1
					cel: 0
					x: 203
					y: 39
					setPri: 2
					cycleSpeed: 12
					scaleSignal: 0
					setCycle: Fwd
				)
				(gGame points: 2 131)
				(gMessager say: 11 63 0 0 self) ; "You start to dig up the freshly-laid grave."
			)
			(2
				(Narrator modeless: 0)
				(proc0_15 1 4 self)
			)
			(3
				((gCurRoom obstacles:) delete: local0)
				(local0 dispose:)
				(gCurRoom
					addObstacle:
						(= local1
							((Polygon new:)
								type: PBarredAccess
								init: 319 189 0 189 0 0 319 0 319 41 301 41 268 26 292 13 287 10 252 27 233 22 242 16 210 12 160 35 178 43 186 38 201 40 206 49 203 53 282 90 319 80
								yourself:
							)
						)
				)
				(SetFlag 62)
				(SetFlag 97)
				(dirtPile init: stopUpd: approachVerbs: 4) ; Do
				(filledGrave dispose:)
				(= cycles 1)
			)
			(4
				(gEgo
					cycleSpeed: local2
					moveSpeed: local2
					scaleSignal: 1
					normalize:
					setHeading: 135
				)
				(= cycles 15)
			)
			(5
				(proc0_15 0 4 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyFillsGrave of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gEgo cel:) 3)
			(graveDigger play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (gEgo moveSpeed:))
				(Narrator modeless: 1)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 303
					loop: 0
					cel: 0
					x: 203
					y: 39
					cycleSpeed: 12
					scaleSignal: 0
					setCycle: Fwd
				)
				(gMessager say: 14 63 0 0 self) ; "You begin the arduous task of replacing the heaping mound of dirt, one shovelful at a time..."
			)
			(2
				(Narrator modeless: 0)
				(proc0_15 1 4 self)
			)
			(3
				(ClearFlag 97)
				(filledGrave init: stopUpd: approachVerbs: 63 4) ; Shovel, Do
				(dirtPile dispose:)
				(openGrave dispose:)
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						(= local0
							((Polygon new:)
								type: PBarredAccess
								init: 319 189 0 189 0 0 319 0 319 41 301 41 268 26 292 13 287 10 252 27 233 22 242 16 210 12 160 35 282 90 319 80
								yourself:
							)
						)
				)
				(= cycles 1)
			)
			(4
				(gEgo
					cycleSpeed: local2
					moveSpeed: local2
					scaleSignal: 1
					normalize:
					setHeading: 135
				)
				(= cycles 15)
			)
			(5
				(proc0_15 0 4 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJumpIntoGrave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (gEgo moveSpeed:))
				(LoadMany rsSOUND 2112)
				(gEgo
					view: 304
					loop: 0
					cel: 0
					x: 216
					y: 36
					cycleSpeed: 10
					scaleSignal: 0
					setCycle: CT 6 1 self
				)
			)
			(1
				(doorSound number: 2112 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo hide:)
				(= cycles 10)
			)
			(3
				(gEgo get: -1 14) ; Deposit_Key
				(gMessager say: 14 4 5 0 self) ; "You carefully search through the many pockets of Graves's three-dollar suit, until you discover..."
			)
			(4
				(gGame points: 5)
				(if (gEgo has: 31) ; Letter
					(gEgo put: 31) ; Letter
					(gMessager say: 14 62 5 0 self) ; "In a touching display of emotion (and a hidden desire to carry a little less around with you), you fold up Philip's letter and place it under his folded hands."
				else
					(= cycles 1)
				)
			)
			(5
				(gEgo
					view: 304
					loop: 1
					cel: 0
					x: 220
					y: 38
					show:
					setCycle: End self
				)
			)
			(6
				(gEgo
					view: 800
					x: 206
					y: 39
					cycleSpeed: local2
					moveSpeed: local2
					setCycle: StopWalk -1
					scaleSignal: 1
					setHeading: 135
				)
				(= cycles 15)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance srini of Actor
	(properties
		x 67
		y 107
		noun 17
		approachX 90
		approachY 108
		view 801
		loop 4
		cel 4
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((IsFlag 50)
						(gMessager say: noun 2 2) ; "Don't yell from here. You'll wake the dead!"
					)
					((== gCurPuzzle 19)
						(gMessager say: noun 2 8) ; "Srini, what are you waiting for?"
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(1 ; Look
				(if (== gCurPuzzle 19)
					(gMessager say: noun 2 8) ; "Srini, what are you waiting for?"
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

(instance digger of Prop
	(properties
		x 211
		y 46
		noun 12
		view 301
		cel 2
		signal 20480
	)

	(method (doit)
		(super doit:)
		(if (and local3 (== (self cel:) 3))
			(graveDigger play: self)
			(= local3 0)
		)
	)

	(method (cue)
		(= local3 1)
	)
)

(instance dirtPile of View
	(properties
		x 175
		y 48
		noun 13
		approachX 202
		approachY 41
		view 302
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 50))
						(gMessager say: noun theVerb 2) ; "You can't reach that pile of dirt from here."
					)
					((not (IsFlag 73))
						(SetFlag 73)
						(gEgo get: 8 dirtPile 1) ; Clay
						(gGame points: 1 150)
					)
					((IsFlag 73)
						(gMessager say: noun theVerb 3) ; "You've already got enough clay for one game."
					)
					(else
						(super doVerb: 4 &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(openGrave init: approachVerbs: 1 4 9 setOnMeCheck: 1 8192) ; Look, Do, Door_Key
	)
)

(instance shovel of View
	(properties
		x 224
		y 40
		z 13
		noun 10
		approachX 211
		approachY 41
		view 301
		loop 1
		priority 3
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 50)
					(gEgo get: 51 shovel 2 self) ; Shovel
					(gGame points: 1 129)
				else
					(gMessager say: noun theVerb 6) ; "You can't reach the shovel from out here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance filledGrave of View
	(properties
		x 225
		y 39
		noun 11
		approachX 203
		approachY 39
		view 305
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 50))
						(gMessager say: noun theVerb 6) ; "You can't reach the grave from this side of the fence."
					)
					((and (IsFlag 62) (not (IsFlag 73)))
						(SetFlag 73)
						(gEgo get: 8 dirtPile 1) ; Clay
						(gGame points: 1 150)
					)
					((IsFlag 73)
						(gMessager say: noun theVerb 3) ; "You don't need any more clay from the grave."
					)
					(else
						(super doVerb: 4 &rest)
					)
				)
			)
			(63 ; Shovel
				(if (IsFlag 50)
					(gEgo setScript: sFreddyDigsGrave)
				else
					(gMessager say: noun theVerb 6) ; "You can't dig up the grave from here!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 224 56 208 47 204 42 242 27 266 35
					yourself:
				)
		)
		(if (and (not (gEgo has: 51)) (< gAct 4)) ; Shovel
			(shovel init: stopUpd: approachVerbs: 4) ; Do
		)
	)
)

(instance outhouseDoor of Prop
	(properties
		x 22
		y 151
		noun 18
		approachX 41
		approachY 158
		view 300
		priority 12
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 50)
					(gMessager say: noun 4 2) ; "You can't get to the outhouse from inside the cemetery!"
				else
					(gEgo setScript: sOuthouseGag)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance noose of Prop
	(properties
		x 124
		y 155
		noun 15
		view 126
		priority 15
		signal 16
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance emptyGrave of View
	(properties
		x 205
		y 14
		noun 30
		view 305
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 259 32 254 42 228 32 237 26
					yourself:
				)
		)
	)
)

(instance fence of Feature
	(properties
		x 82
		y 91
		noun 16
		approachX 82
		approachY 91
	)

	(method (doVerb theVerb)
		(switch theVerb
			(34 ; Empty_Bottles
				(cond
					((IsFlag 50)
						(gMessager say: noun 34 2) ; "You can't reach the fence from here. But keep stretching; you'll add inches to your biceps and tone those lateral obliques!"
					)
					((and (IsFlag 54) (== gCurPuzzle 17))
						(gCurRoom newRoom: 540)
					)
					(else
						(gMessager say: noun 34 1) ; "There's no point in setting up target practice until you're ready to start shooting!"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 258
		y 121
		noun 2
	)
)

(instance bottomBuilding of Feature
	(properties
		x 200
		y 154
		noun 3
	)
)

(instance hangman of Feature
	(properties
		x 157
		y 165
		z 10
		noun 4
	)
)

(instance eastBuilding of Feature
	(properties
		x 295
		y 163
		noun 5
	)
)

(instance buildingSign of Feature
	(properties
		x 78
		y 157
		noun 7
	)
)

(instance outhouse of Feature
	(properties
		x 19
		y 124
		noun 8
	)
)

(instance westBuilding of Feature
	(properties
		x 3
		y 143
		noun 6
	)
)

(instance fencePosts of Feature
	(properties
		x 250
		y 63
		noun 9
	)
)

(instance boulder of Feature
	(properties
		x 250
		y 63
		noun 20
		nsLeft 13
		nsBottom 61
		nsRight 129
	)
)

(instance desert of Feature
	(properties
		x 250
		y 63
		noun 21
	)
)

(instance graveYard of Feature
	(properties
		x 250
		y 1
		noun 30
	)
)

(instance openGrave of Feature
	(properties
		x 250
		y 63
		noun 14
		approachX 203
		approachY 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 50)
					(if (gEgo has: 14) ; Deposit_Key
						(gMessager say: noun theVerb 4) ; "What are you looking for, gold fillings? C'mon, you've defiled Phil Graves' unfilled grave enough already!"
					else
						(gEgo setScript: sJumpIntoGrave)
					)
				else
					(gMessager say: noun theVerb 6) ; "You can't reach the open grave from here."
				)
			)
			(63 ; Shovel
				(if (IsFlag 50)
					(gEgo setScript: sFreddyFillsGrave)
				else
					(gMessager say: noun theVerb 6) ; "You can't use the shovel on the grave from out here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 224 56 208 47 204 42 242 27 266 35
					yourself:
				)
		)
	)
)

(instance stone1 of Feature
	(properties
		x 187
		y 195
		z 185
		noun 22
		nsTop 6
		nsLeft 178
		nsBottom 20
		nsRight 196
	)
)

(instance stone2 of Feature
	(properties
		x 212
		y 195
		z 185
		noun 23
		nsTop 11
		nsLeft 202
		nsBottom 28
		nsRight 223
	)
)

(instance stone3 of Feature
	(properties
		x 244
		y 196
		z 170
		noun 24
		nsTop 14
		nsLeft 232
		nsBottom 39
		nsRight 256
	)
)

(instance stone4 of Feature
	(properties
		x 293
		y 193
		z 150
		noun 25
		nsTop 35
		nsLeft 285
		nsBottom 52
		nsRight 301
	)
)

(instance stone5 of Feature
	(properties
		x 304
		y 195
		z 180
		noun 26
		nsTop 8
		nsLeft 297
		nsBottom 22
		nsRight 312
	)
)

(instance stone6 of Feature
	(properties
		x 273
		y 195
		z 190
		noun 27
		nsLeft 268
		nsBottom 11
		nsRight 278
	)
)

(instance stone7 of Feature
	(properties
		x 257
		y 194
		z 180
		noun 28
		nsTop 7
		nsLeft 251
		nsBottom 19
		nsRight 263
	)
)

(instance stone8 of Feature
	(properties
		x 235
		y 197
		z 190
		noun 29
		nsTop 2
		nsLeft 228
		nsBottom 12
		nsRight 243
	)
)

(instance cactus of Feature
	(properties
		x 135
		y 173
		z 140
		noun 32
		nsTop 12
		nsLeft 108
		nsBottom 54
		nsRight 163
	)
)

(instance angelPost of Feature
	(properties
		x 273
		y 77
		noun 33
		nsTop 32
		nsLeft 256
		nsBottom 122
		nsRight 291
	)
)

(instance graveDigger of FPSound
	(properties
		flags 1
		number 2301
	)
)

(instance doorSound of FPSound
	(properties
		flags 1
	)
)

