;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Bats)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm630 0
)

(local
	local0
)

(instance rm630 of Eco2Room
	(properties
		noun 19
		picture 630
		style 10
		north 680
		west 600
	)

	(method (init)
		(LoadMany rsVIEW 2 662)
		(jaguar init:)
		(alcove init:)
		(alcovecarve init:)
		(lgbatcarve init:)
		(footholds init:)
		(ceiling init:)
		(floor init:)
		(door init:)
		(frontcarve init:)
		(snakecarve init:)
		(crosscarve init:)
		(anvil init:)
		(niche init:)
		(exitnorth init:)
		(exitwest init:)
		(rod init:)
		(gWalkHandler addToFront: self)
		(chiropterus init:)
		(gGameSound1 number: 631 play:)
		(if (not (gCurrentRegionFlags test: 19))
			(gGameSound2 number: 630 setLoop: -1 play:)
		)
		(cond
			(
				(or
					(== gPrevRoomNum 640)
					(and (not (gEgo has: 14)) (gCurrentRegionFlags test: 3))
				)
				(jagalive
					view: 630
					loop: 1
					cel: 0
					x: 174
					y: 180
					z: 50
					approachX: 192
					approachY: 155
					noun: 21
					init:
					approachVerbs: 4 1 ; Do, Look
				)
				(stone
					view: 630
					loop: 2
					cel: 0
					x: 64
					y: 174
					setPri: 12
					ignoreActors: 1
					init:
					addToPic:
					yourself:
				)
			)
			((not (gCurrentRegionFlags test: 3))
				(jagalive init:)
			)
		)
		(if (not (gCurrentRegionFlags test: 1))
			(stone init:)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 0 189 0 186 142 186 208 160 273 160 283 155 303 155 288 141 248 141 211 104 171 104 171 98 140 98 147 104 93 125 93 135 59 145 39 152 34 145 0 151
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 44 160 140 120 189 120 213 145 145 174 84 183 53 183 76 160
					yourself:
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(600
				(self setScript: enterScript)
			)
			(680
				(self setScript: from680)
			)
			(else
				(gEgo
					x: 67
					y: 186
					init:
					normalize: 0 6
					setScale: Scaler 100 81 180 91
				)
				(= local0 2)
				(gGame handsOn:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo view:) 662) (gEgo mover:))
			(gCurRoom setScript: offHang)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (== (gEgo view:) 662)
					(gCurRoom setScript: offHang)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gGameSound2 stop:)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance exitnorth of ExitFeature
	(properties
		nsTop 64
		nsLeft 145
		nsBottom 90
		nsRight 177
		cursor 13
		exitDir 1
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(and (== (event type:) evMOUSEBUTTON) (event modifiers:))
					(not (OneOf (event type:) evMOUSEBUTTON evKEYBOARD))
				)
				(= lastCursor -1)
			)
			((OneOf (gTheCursor cel:) 10 11 12 13)
				(= temp0 (= temp1 0))
				(= temp0
					(if toX
						toX
					else
						(switch exitDir
							(1 gMouseX)
							(3 gMouseX)
							(2 320)
							(4 0)
							(else 999)
						)
					)
				)
				(= temp1
					(if toY
						toY
					else
						(switch exitDir
							(1 0)
							(3 190)
							(2
								(- gMouseY 10)
							)
							(4
								(- gMouseY 10)
							)
							(else 999)
						)
					)
				)
				(if (== (gEgo view:) 662)
					(gCurRoom setScript: offHang)
				else
					(gEgo setMotion: PolyPath temp0 temp1 jagalive)
				)
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance exitwest of ExitFeature
	(properties
		nsTop 143
		nsBottom 189
		nsRight 10
		cursor 12
		exitDir 4
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(and (== (event type:) evMOUSEBUTTON) (event modifiers:))
					(not (OneOf (event type:) evMOUSEBUTTON evKEYBOARD))
				)
				(= lastCursor -1)
			)
			((OneOf (gTheCursor cel:) 10 11 12 13)
				(= temp0 (= temp1 0))
				(= temp0
					(if toX
						toX
					else
						(switch exitDir
							(1 gMouseX)
							(3 gMouseX)
							(2 320)
							(4 0)
							(else 999)
						)
					)
				)
				(= temp1
					(if toY
						toY
					else
						(switch exitDir
							(1 0)
							(3 190)
							(2
								(- gMouseY 10)
							)
							(4
								(- gMouseY 10)
							)
							(else 999)
						)
					)
				)
				(if (gEgo has: 14)
					(gEgo setMotion: PolyPath temp0 temp1 chiropterus)
				else
					(gEgo setMotion: PolyPath temp0 temp1)
				)
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance rod of Feature
	(properties
		x 198
		y 54
		noun 22
		nsTop 52
		nsLeft 180
		nsBottom 56
		nsRight 216
		approachX 198
		approachY 115
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= (gEgo view:) 662)
					(Bats points: 5 18)
					(gCurRoom setScript: hangEgo)
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

(instance jaguar of Feature
	(properties
		x 159
		y 136
		noun 1
		nsTop 124
		nsLeft 124
		nsBottom 148
		nsRight 195
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== (jagalive view:) 630)
				(gMessager say: noun theVerb 20) ; "There's nothing more to do here. Adam has freed the jaguar."
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance alcove of Feature
	(properties
		x 50
		y 87
		noun 3
		nsTop 72
		nsLeft 40
		nsBottom 102
		nsRight 60
	)
)

(instance alcovecarve of Feature
	(properties
		x 55
		y 61
		noun 4
		nsTop 55
		nsLeft 46
		nsBottom 68
		nsRight 65
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 76))
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 76))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance lgbatcarve of Feature
	(properties
		x 190
		y 44
		z 30
		noun 5
		nsTop 47
		nsLeft 175
		nsBottom 101
		nsRight 206
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 76))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 76))
			(super doVerb: theVerb)
		)
	)
)

(instance footholds of Feature
	(properties
		x 272
		y 97
		noun 6
		nsTop 57
		nsLeft 245
		nsBottom 138
		nsRight 299
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 73))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 73))
			(super doVerb: theVerb)
		)
	)
)

(instance ceiling of Feature
	(properties
		x 56
		y 18
		noun 8
		nsBottom 37
		nsRight 113
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 73))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 73))
			(super doVerb: theVerb)
		)
	)
)

(instance floor of Feature
	(properties
		x 186
		y 113
		noun 9
		nsTop 105
		nsLeft 170
		nsBottom 115
		nsRight 232
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 73))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 73))
			(super doVerb: theVerb)
		)
	)
)

(instance door of Feature
	(properties
		x 152
		y 73
		noun 10
		nsTop 46
		nsLeft 151
		nsBottom 101
		nsRight 173
	)
)

(instance frontcarve of Feature
	(properties
		x 207
		y 173
		noun 14
		nsTop 158
		nsLeft 158
		nsBottom 189
		nsRight 256
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 74))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 74))
			(super doVerb: theVerb)
		)
	)
)

(instance snakecarve of Feature
	(properties
		x 139
		y 35
		noun 16
		nsTop 30
		nsLeft 135
		nsBottom 75
		nsRight 150
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 76))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 76))
			(super doVerb: theVerb)
		)
	)
)

(instance crosscarve of Feature
	(properties
		x 109
		y 92
		noun 17
		nsTop 76
		nsLeft 89
		nsBottom 109
		nsRight 129
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 73))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 73))
			(super doVerb: theVerb)
		)
	)
)

(instance anvil of Feature
	(properties
		x 22
		y 172
		noun 18
		nsTop 158
		nsLeft 4
		nsBottom 186
		nsRight 41
	)
)

(instance niche of Feature
	(properties
		x 73
		y 175
		noun 2
		nsTop 167
		nsLeft 60
		nsBottom 183
		nsRight 87
		approachX 67
		approachY 186
	)

	(method (init)
		(super init:)
		(self approachVerbs: 43 4 1) ; truthStone, Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; truthStone
				(gCurRoom setScript: to640)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stone of Prop
	(properties
		x 52
		y 105
		noun 13
		approachX 73
		approachY 139
		view 630
		signal 16384
		maxScale 1
	)

	(method (init)
		(super init:)
		(self cel: (self lastCel:) stopUpd: approachVerbs: 4 1 cue:) ; Do, Look
	)

	(method (cue)
		(if maxScale
			(= maxScale 0)
			(self setCycle: Beg self)
		else
			(= maxScale 1)
			(self cel: (self lastCel:) stopUpd:)
			((Timer new:) setReal: self (Random 3 5))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurrentRegionFlags test: 19)
					(gCurRoom setScript: getStone)
				else
					(gMessager say: noun theVerb 7) ; "Ouch! That stone is hot!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chiropterus of Prop
	(properties
		x 226
		y 66
		noun 20
		view 661
		signal 16384
		scaleSignal 1
		scaleX 108
		scaleY 108
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (cue)
		(gCurRoom setScript: noExit)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 42))
			(switch theVerb
				(2 ; Talk
					(gGameSound2 stop:)
					(Bats points: 1 17)
					(cond
						((!= (gEgo view:) 662)
							(cond
								((gEgo has: 14)
									(gMessager say: noun theVerb 14) ; "Be off! I've done all I can."
								)
								((gCurrentRegionFlags test: 3)
									(gMessager say: noun theVerb 13) ; "Take the ancient token, Adam!"
								)
								(
									(and
										(gCurrentRegionFlags test: 19)
										(not (gEgo has: 15))
									)
									(gMessager say: noun theVerb 11) ; "Take the Truth Stone. Until you use it, I cannot tell you how to get to the City of Gold."
								)
								(else
									(switch local0
										(0
											(++ local0)
											(gMessager say: noun theVerb 1) ; "You're making me dizzy!"
										)
										(1
											(++ local0)
											(gMessager say: noun theVerb 3) ; "How can I listen to you if I'm dizzy?"
										)
										(else
											(gMessager say: noun theVerb 10) ; "I say, climb up here! Speak to me in the manner of the temple priests who cared for us!"
										)
									)
								)
							)
						)
						((gCurrentRegionFlags test: 19)
							(super doVerb: theVerb)
						)
						(else
							(gCurrentRegionFlags set: 19)
							(gMessager say: noun theVerb 34) ; "I am Chiropterus Handwing, Guardian of the Temple."
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 42))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance jagalive of Prop
	(properties
		x 142
		y 138
		noun 1
		view 671
		priority 10
		signal 16400
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (cue)
		(gCurRoom setScript: toRiver)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 32))
			(switch theVerb
				(4 ; Do
					(if
						(or
							(== gPrevRoomNum 640)
							(and (not (gEgo has: 14)) (gCurrentRegionFlags test: 3))
						)
						(gCurRoom setScript: getFeather)
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

	(method (doit)
		(if (not (IsEcorderFlag 32))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance noExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 19 0 15 0 self) ; "Not that way! You humans are such dolts!"
			)
			(1
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: -10
					y: 160
					init:
					normalize:
					setScale: Scaler 100 81 180 91
				)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: PolyPath 25 160 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hangEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameSound1 number: 632 play:)
				(= cycles 5)
			)
			(1
				(gEgo view: 662 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance offHang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo setCycle: CT 0 -1 self)
			)
			(2
				(gEgo setLoop: 0 cel: 7 setCycle: CT 0 -1 self)
			)
			(3
				(gGameSound1 number: 631 play:)
				(gEgo normalize: 0 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toRiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo setPri: 1 setMotion: MoveTo 185 86 self)
			)
			(2
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance getStone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Bats points: 5)
				(= cycles 5)
			)
			(1
				(gEgo view: 662 setLoop: 3 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 4
					setLoop: 6
					x: 70
					y: 130
					cel: 0
					setCycle: End self
				)
			)
			(3
				(stone dispose:)
				(gEgo
					view: 662
					setLoop: 3
					x: 73
					y: 139
					cel: 3
					setCycle: CT 0 -1 self
				)
			)
			(4
				(gMessager say: 13 4 8 0 self) ; "Adam picks up the Truth Stone. It feels strangely warm to the touch."
			)
			(5
				(gCurrentRegionFlags set: 1)
				(gEgo get: 15)
				(gEgo normalize: 0 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance to640 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Bats points: 5)
				(= cycles 5)
			)
			(1
				(gGameSound2 number: 634 setLoop: 1 play:)
				(gEgo view: 5 setLoop: 3 cel: 0 setCycle: End self)
				(stone
					view: 630
					loop: 2
					cel: 0
					x: 64
					y: 174
					ignoreActors: 1
					init:
					addToPic:
					yourself:
				)
			)
			(2
				(gEgo put: 15)
				(gGameSound2 number: 637 play:)
				(jagalive setCycle: End self)
			)
			(3
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 2
					cycleSpeed: 10
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gEgo cycleSpeed: register)
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance from680 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 185
					y: 86
					init:
					setPri: 1
					normalize:
					setScale: Scaler 100 81 180 91
				)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 163 101 self)
			)
			(2
				(if (gEgo has: 14)
					(gEgo setMotion: MoveTo 198 115 self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(gEgo view: 662 setLoop: 0 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gMessager say: 19 0 18 0 self) ; "Chiropterus, help! It's Paquita."
			)
			(6
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance getFeather of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo view: 4 setLoop: 1 setCycle: CT 2 1 self)
			)
			(2
				(Bats points: 5)
				(jagalive dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo get: 14 normalize: 0 1)
				(gGame handsOn:)
				(chiropterus setScript: featherOut)
			)
		)
	)
)

(instance featherOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 20 1 14 0 self) ; "Don't just stand there gawking! You have work to do!"
			)
			(2
				(gGame handsOn:)
				(self changeState: 0)
			)
		)
	)
)

