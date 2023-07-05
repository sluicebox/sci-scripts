;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	local0
)

(instance rm650 of FPRoom
	(properties
		noun 28
		picture 650
		style 10
	)

	(method (init)
		(gEgo x: 330 y: 178 setScale: Scaler 149 89 184 146 normalize: init:)
		(switch gPrevRoomNum
			(240
				(gCurRoom setScript: sEnterFrom240)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gGame handsOn:)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 302 178 286 162 247 162 246 155 190 150 100 150 89 185 302 185
					yourself:
				)
		)
		(potato init: setOnMeCheck: 1 2)
		(boxes init: setOnMeCheck: 1 4)
		(barrels init: setOnMeCheck: 1 8)
		(sacks init: setOnMeCheck: 1 16)
		(horseShoe init: setOnMeCheck: 1 32)
		(paper1 init: setOnMeCheck: 1 64)
		(paper2 init: setOnMeCheck: 1 128)
		(paper3 init: setOnMeCheck: 1 256)
		(mirror init: setOnMeCheck: 1 512)
		(photo init: setOnMeCheck: 1 1024)
		(lantern init: setOnMeCheck: 1 2048)
		(pots init: setOnMeCheck: 1 4096)
		(pitcher init: setOnMeCheck: 1 8192)
		(rope init: setOnMeCheck: 1 16384)
		(buckets init: setOnMeCheck: 1 -32768)
		(pans init: setOnMeCheck: 1 2)
		(light init: setOnMeCheck: 1 4)
		(broom init: setOnMeCheck: 1 8)
		(lantern2 init: setOnMeCheck: 1 16)
		(paper4 init: setOnMeCheck: 1 32)
		(paper5 init: setOnMeCheck: 1 64)
		(paper6 init: setOnMeCheck: 1 128)
		(stove init: setOnMeCheck: 1 256)
		(backCounter init: setOnMeCheck: 1 512)
		(grinder init: setOnMeCheck: 1 1024)
		(paper7 init: setOnMeCheck: 26505)
		(if
			(and
				(not (gEgo has: 41)) ; Paper_Sack
				(not (gEgo has: 20)) ; Filled_Sack
				(not (> gCurPuzzle 9))
			)
			(paperBag init: approachVerbs: 4) ; Do
		)
		(if (== gPrevRoomNum 240)
			(frontDoor init: setCel: 3 approachVerbs: 4 3) ; Do, ???
		else
			(frontDoor init: approachVerbs: 4 3) ; Do, ???
		)
		(cond
			((IsFlag 102) 0)
			((IsFlag 36)
				(knife init: approachVerbs: 4) ; Do
			)
			(else
				(willie init: setScript: sWillieMoves)
			)
		)
		(shavings init:)
		(if (== gPrevRoomNum 240)
			0
		else
			(gGameMusic1 number: 652 flags: 1 loop: -1 play:)
		)
	)

	(method (dispose)
		(gWalkHandler delete: frontDoor)
		(gGameMusic1 fade: 80 10 16 0)
		(super dispose:)
	)
)

(instance sEnterFrom240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(doorSound number: 2650 play:)
				(gEgo setMotion: MoveTo 275 178 self)
			)
			(2
				(frontDoor setCycle: Beg self)
				(doorSound number: 2147 play:)
			)
			(3
				(gMessager say: 42 0 0) ; "The door swings open. From the back, you hear Chester say:"
				(frontDoor stopUpd:)
				(= cycles 10)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorSound number: 2146 play:)
				(frontDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 320 178 self)
			)
			(2
				(doorSound number: 2650 play: self)
			)
			(3
				(gEgo setHeading: 90)
				(gCurRoom newRoom: 240)
				(self dispose:)
			)
		)
	)
)

(instance sWillieMoves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd)
				(= seconds (Random 5 10))
			)
			(1
				(client setCycle: CT 0 1 self)
			)
			(2
				(= seconds (Random 5 10))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance willie of Actor
	(properties
		x 233
		y 151
		noun 12
		view 652
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(53 ; Medallion
				(if (== gCurPuzzle 19)
					(SetFlag 36)
					(gGame points: 2 156)
					(if (!= local0 1)
						(gMessager say: 41 0 0) ; "Willy, I'm in need a way to disguise my ear. Do you think you could do something creative with this, something in the shape of an ear, perhaps?"
						(= local0 1)
					else
						(gMessager say: 41 0 10) ; "I already tole ya, it'd make fer sum fine lost-wax casting'!"
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(43 ; Candle_Wax
				(if (== gCurPuzzle 19)
					(SetFlag 36)
					(gGame points: 2 156)
					(if (!= local0 1)
						(gMessager say: 41 0 0) ; "Willy, I'm in need a way to disguise my ear. Do you think you could do something creative with this, something in the shape of an ear, perhaps?"
						(= local0 1)
					else
						(gMessager say: 41 0 10) ; "I already tole ya, it'd make fer sum fine lost-wax casting'!"
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(52 ; Clay
				(if (== gCurPuzzle 19)
					(SetFlag 36)
					(gGame points: 2 156)
					(if (!= local0 1)
						(gMessager say: 41 0 0) ; "Willy, I'm in need a way to disguise my ear. Do you think you could do something creative with this, something in the shape of an ear, perhaps?"
						(= local0 1)
					else
						(gMessager say: 41 0 10) ; "I already tole ya, it'd make fer sum fine lost-wax casting'!"
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(cond
					((and (== gCurPuzzle 8) (== gCurPuzzle 9))
						(gMessager say: 12 2 4) ; "Willy, you know what's going on out there?"
					)
					((== gCurPuzzle 10)
						(gMessager say: 12 2 5) ; "Willy, you heard about the snail stampede?"
					)
					((== gCurPuzzle 12)
						(gMessager say: 12 2 6) ; "Well, I got rid of those snails! Aren't you proud of me?"
					)
					((== gCurPuzzle 13)
						(gMessager say: 12 2 7) ; "Willy, I got myself an assistant down at the Pharmacy."
					)
					((== gCurPuzzle 16)
						(gMessager say: 12 2 8) ; "Hey, Willy!"
					)
					((== gCurPuzzle 19)
						(gMessager say: 12 2 9) ; "Hiya, Whittlin' Willy!"
					)
					((== gAct 1)
						(gMessager say: 12 2 1) ; "Hiya, Whittlin' Willy! How's the Whittlin' going?"
					)
					((== gAct 2)
						(gMessager say: 12 2 2) ; "Hey there, Willy!"
					)
					((== gAct 3)
						(gMessager say: 12 2 3) ; "Whittlin' Willy!"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shavings of Prop
	(properties
		x 205
		y 146
		noun 45
		view 650
		loop 2
	)
)

(instance frontDoor of Prop
	(properties
		x 299
		y 144
		noun 40
		approachX 265
		approachY 178
		view 650
		priority 14
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sExitTo240)
			)
			(3 ; ???
				(gCurRoom setScript: sExitTo240)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(gWalkHandler add: frontDoor)
		(super init:)
	)
)

(instance knife of View
	(properties
		x 228
		y 133
		noun 43
		approachX 232
		approachY 155
		view 650
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(SetFlag 102)
				(gEgo get: 27 knife) ; Knife
				(gGame points: 1)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance paperBag of View
	(properties
		x 200
		y 116
		noun 44
		approachX 180
		approachY 150
		view 650
		loop 3
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 41 paperBag 2 self) ; Paper_Sack
				(gGame points: 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potato of Feature
	(properties
		x 296
		y 189
		noun 13
		nsTop 134
		nsLeft 167
		nsBottom 189
		nsRight 319
	)
)

(instance boxes of Feature
	(properties
		x 94
		y 189
		noun 14
		nsTop 149
		nsLeft 43
		nsBottom 189
		nsRight 146
	)
)

(instance barrels of Feature
	(properties
		x 162
		y 189
		noun 15
		nsTop 133
		nsLeft 126
		nsBottom 189
		nsRight 198
	)
)

(instance sacks of Feature
	(properties
		x 80
		y 189
		noun 16
		nsTop 135
		nsLeft 44
		nsBottom 173
		nsRight 117
	)
)

(instance horseShoe of Feature
	(properties
		x 34
		y 189
		noun 17
		nsTop 29
		nsLeft 13
		nsBottom 68
		nsRight 56
	)
)

(instance paper1 of Feature
	(properties
		x 17
		y 189
		noun 18
		nsBottom 38
		nsRight 34
	)
)

(instance paper2 of Feature
	(properties
		x 14
		y 189
		noun 19
		nsTop 39
		nsBottom 88
		nsRight 29
	)
)

(instance paper3 of Feature
	(properties
		x 15
		y 189
		noun 20
		nsTop 88
		nsBottom 129
		nsRight 30
	)
)

(instance mirror of Feature
	(properties
		x 20
		y 189
		noun 21
		nsTop 72
		nsBottom 96
		nsRight 40
	)
)

(instance photo of Feature
	(properties
		x 116
		y 189
		noun 29
		nsTop 92
		nsLeft 105
		nsBottom 114
		nsRight 127
	)
)

(instance lantern of Feature
	(properties
		x 111
		y 187
		noun 23
	)
)

(instance pots of Feature
	(properties
		x 92
		y 187
		noun 24
	)
)

(instance pitcher of Feature
	(properties
		x 123
		y 187
		noun 25
	)
)

(instance rope of Feature
	(properties
		x 235
		y 187
		noun 26
	)
)

(instance buckets of Feature
	(properties
		x 280
		y 130
		z 59
		noun 27
	)
)

(instance pans of Feature
	(properties
		x 193
		y 50
		noun 22
	)
)

(instance light of Feature
	(properties
		x 185
		y 115
		noun 30
	)
)

(instance broom of Feature
	(properties
		x 171
		y 50
		noun 31
	)
)

(instance lantern2 of Feature
	(properties
		x 143
		y 50
		noun 32
	)
)

(instance paper4 of Feature
	(properties
		x 223
		y 50
		noun 33
	)
)

(instance paper5 of Feature
	(properties
		x 242
		y 50
		noun 34
	)
)

(instance paper6 of Feature
	(properties
		x 253
		y 50
		noun 35
	)
)

(instance stove of Feature
	(properties
		x 268
		y 50
		noun 36
	)
)

(instance backCounter of Feature
	(properties
		x 148
		y 50
		noun 37
	)
)

(instance grinder of Feature
	(properties
		x 69
		y 187
		noun 38
	)
)

(instance paper7 of Feature
	(properties
		x 119
		y 189
		noun 39
		nsTop 69
		nsLeft 105
		nsBottom 95
		nsRight 133
	)
)

(instance doorSound of FPSound
	(properties
		flags 1
	)
)

