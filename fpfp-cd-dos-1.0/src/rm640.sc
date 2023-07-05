;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use ROsc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm640 of FPRoom
	(properties
		noun 15
		picture 640
		style 100
		east 240
	)

	(method (init)
		(gEgo init: setScale: Scaler 156 101 170 130 normalize:)
		(altego view: 800 x: 103 y: 100 setPri: 1 setScale: -1 gEgo init:)
		(switch gPrevRoomNum
			(east
				(gCurRoom setScript: sEnterFrom240)
			)
			(320
				(gCurRoom setScript: sEnterFrom320)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 0 319 0 319 138 200 138 200 149 107 149 70 170 319 170
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 155 243 155 243 141 319 141
					yourself:
				)
		)
		(if (== gPrevRoomNum 320)
			(backDoor approachVerbs: 4 cel: 5 init:) ; Do
		else
			(backDoor approachVerbs: 4 init:) ; Do
		)
		(if (IsFlag 35)
			(postcards ignoreActors: addToPic: init:)
		)
		(if (and (not (gEgo has: 2)) (<= gCurPuzzle 19)) ; Boots
			(boots init:)
		)
		(if (and (not (gEgo has: 39)) (not (IsFlag 33)) (< gCurPuzzle 23)) ; Nitrous_Oxide
			(gas init:)
		)
		(cond
			((<= gAct 2)
				(barber
					loop: 1
					cel: 0
					priority: 6
					approachVerbs: 4 2 9 ; Do, Talk, Door_Key
					setScript: sCutHair
					init:
				)
				(manInChair ignoreActors: addToPic: init:)
			)
			((== gAct 3)
				(barber
					view: 644
					loop: 0
					cel: 0
					x: 140
					y: 140
					approachVerbs: 4 2 9 ; Do, Talk, Door_Key
					setCycle: Fwd
					setScript: sSingSong
					init:
				)
				(manWaiting init: setScript: sManReads)
			)
			((== gAct 4)
				(barber
					view: 642
					loop: 1
					cel: 0
					x: 170
					y: 139
					cycleSpeed: 12
					approachVerbs: 4 2 9 ; Do, Talk, Door_Key
					setScript: sPullTeeth
					init:
				)
			)
		)
		(bowl init: setOnMeCheck: 1 4)
		(bottle1 init: setOnMeCheck: 1 8)
		(bottle2 init: setOnMeCheck: 1 16)
		(bottles3 init: setOnMeCheck: 1 32)
		(stove init: setOnMeCheck: 1 64)
		(bench init: setOnMeCheck: 1 128)
		(buffalo init: setOnMeCheck: 1 256)
		(lamp init: setOnMeCheck: 1 512)
		(pitcher init: setOnMeCheck: 1 1024)
		(chair init: setOnMeCheck: 1 2048)
		(counter init: setOnMeCheck: 1 4096)
		(shelf init: setOnMeCheck: 1 8192)
		(topShelf init: setOnMeCheck: 1 16384)
		(bottomShelf1 init: setOnMeCheck: 26505)
		(bottomShelf2 init: setOnMeCheck: 26505)
		(frame1 init: setOnMeCheck: 26505)
		(frame2 init: setOnMeCheck: 26505)
		(frame3 init: setOnMeCheck: 26505)
		(cabinet init: setOnMeCheck: 26505)
		(if (== gPrevRoomNum 240)
			0
		else
			(gGameMusic2 number: 640 flags: 1 loop: -1 play:)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((proc0_1 gEgo 2)
				(gCurRoom setScript: sExitTo320)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(gGameMusic2 fade: 80 10 16 0)
	)
)

(instance sEnterFrom320 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(backDoor setCycle: Beg self)
				(gEgo x: 360 y: 138 setHeading: 0)
			)
			(1
				(gEgo setMotion: MoveTo 250 138 self)
				(backDoor stopUpd:)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo320 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 360 139 self)
			)
			(1
				(gEgo setHeading: 0)
				(= cycles 3)
			)
			(2
				(backDoor setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 320)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 330 y: 170 setMotion: MoveTo 270 170 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCutHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(barber loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(if local0
					(= cycles 5)
				else
					(cuttingSound number: 2643 play: self)
				)
			)
			(2
				(barber setCycle: CT 5 1 self)
			)
			(3
				(if local0
					(= cycles 5)
				else
					(cuttingSound number: 2643 play: self)
				)
			)
			(4
				(if (== local1 5)
					(= local1 0)
					(= cycles 1)
				else
					(++ local1)
					(self changeState: 0)
				)
			)
			(5
				(barber loop: 0 cel: 0 setCycle: ROsc 1 0 4 self)
			)
			(6
				(if (not local0)
					(cuttingSound number: 2642 play:)
				)
				(barber cel: 5)
				(= ticks 40)
			)
			(7
				(if (== local1 3)
					(= local1 0)
					(self changeState: 0)
				else
					(++ local1)
					(self changeState: 5)
				)
			)
		)
	)
)

(instance sPullTeeth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (Random 4 7) 5)
					(barber view: 642 loop: 1 cel: 0 setCycle: Fwd)
					(= seconds (Random 5 10))
				else
					(= seconds (Random 1 3))
				)
			)
			(1
				(if (== (Random 4 9) 7)
					(if (not local0)
						(cuttingSound number: 2641 play:)
					)
					(barber loop: 0 cel: 0 setCycle: End self)
				else
					(self changeState: 0)
				)
			)
			(2
				(barber view: 648 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(barber view: 647 loop: 0 cel: 0 setCycle: End self)
			)
			(5
				(UnLoad 128 647)
				(UnLoad 128 648)
				(self changeState: 0)
			)
		)
	)
)

(instance sSingSong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(switch (Random 0 3)
					(0
						(barber setCycle: CT (Random 0 9) 1 self)
					)
					(1
						(barber setCycle: CT (Random 0 9) -1 self)
					)
					(2
						(barber setCycle: CT (Random 0 9) 1 self)
					)
					(3
						(barber setCycle: CT (Random 0 9) -1 self)
					)
				)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance sManReads of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(manWaiting setCel: 0 setCycle: End self)
			)
			(1
				(manWaiting stopUpd:)
				(= seconds (Random 5 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance altego of Actor
	(properties
		x 103
		y 100
		noun 21
		view 800
		priority 1
		signal 20480
	)

	(method (init)
		(super init:)
		(self view: (gEgo view:))
	)

	(method (doit &tmp temp0)
		(= temp0 (- (gEgo y:) 125))
		(self
			loop:
				(switch (gEgo loop:)
					(0 1)
					(1 0)
					(2 5)
					(3 6)
					(4 5)
					(5 5)
					(6 6)
					(7 6)
					(8 8)
				)
			cel:
				(switch (gEgo cel:)
					(0 1)
					(1 0)
					(2 2)
					(3 3)
					(4 5)
					(5 5)
					(6 6)
					(7 6)
				)
			x:
				(+
					(- 10 temp0)
					(- (- 100 (* 2 temp0)) (/ (- (gEgo x:) 130) 5))
				)
			y: (gEgo y:)
			setPri: (- (gEgo priority:) 8)
		)
		(super doit:)
	)
)

(instance barber of Actor
	(properties
		x 146
		y 133
		noun 2
		approachX 178
		approachY 149
		view 643
		loop 1
		signal 20480
		cycleSpeed 12
		moveSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((<= gAct 1)
						(switch global136
							(0
								(gMessager say: noun theVerb 1) ; "How's business, Sal? Seems like you always have a customer these days."
								(++ global136)
							)
							(1
								(gMessager say: noun theVerb 2) ; "Howdy, Sal! How's things?"
								(++ global136)
							)
							(2
								(gMessager say: noun theVerb 3) ; "Sal..."
							)
						)
					)
					((or (== gCurPuzzle 8) (== gCurPuzzle 9))
						(gMessager say: noun theVerb 4) ; "Sal, all hell has broken loose."
					)
					((== gCurPuzzle 10)
						(gMessager say: noun theVerb 5) ; "You can breathe easier now, Sal. I took care of that problem with the horses. Turns out somebody put lentils in the feed! Ever hear of anything so dastardly?"
					)
					((== gCurPuzzle 12)
						(gMessager say: noun theVerb 6) ; "Sal! Great news! I derailed the snail stampede. Those snails are history."
					)
					((== gCurPuzzle 13)
						(gMessager say: noun theVerb 7) ; "Congratulate me, Sal. I've got an assistant now!"
					)
					((or (== gCurPuzzle 16) (== gCurPuzzle 17))
						(gMessager say: noun theVerb 9) ; "Hey, I put a fire out last night and saved the town. Proud of me?"
					)
					((== gCurPuzzle 19)
						(gMessager say: noun theVerb 8) ; "Sal, I'm heading out of town for a while."
					)
					((== gCurPuzzle 20)
						(gMessager say: noun theVerb 10) ; "Hey, Sal!"
					)
					((== gCurPuzzle 22)
						(gMessager say: noun theVerb 11) ; "Don't go out on the street, now, Salvatore! There's a lot of shootin' and nastiness goin' on out there!"
					)
				)
			)
			(1 ; Look
				(if (== gAct 3)
					(gMessager say: noun theVerb 12) ; "Salvatore O'Hanahan is taking a moment to sing a few bars from "The Barber of Seville.""
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if (== gAct 3)
					(gMessager say: noun theVerb 12) ; "Salvatore sings away, unmindful of your poking and prodding."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(57 ; Claim_Check
				(= local0 1)
				(gEgo put: 7) ; Claim_Check
				(gEgo get: -1 2) ; Boots
				(if
					(and
						(gEgo has: 38) ; Neckerchief
						(gEgo has: 10) ; Clothes
						(gEgo has: 52) ; Silver_Ear
						(gEgo has: 44) ; Pistols
					)
					(SetFlag 58)
				)
				(= local2 1)
				(gGame points: 5 0 self)
			)
			(42 ; Post_Cards
				(= local0 1)
				(gEgo put: 45) ; Post_Cards
				(gEgo get: -1 39) ; Nitrous_Oxide
				(SetFlag 35)
				(= local3 1)
				(cuttingSound stop:)
				(gGame points: 5 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(super cue:)
		(cond
			(local2
				(boots dispose:)
				(= local2 0)
				(gMessager say: 2 57) ; "Sal, do you still have that pair of boots I dropped off for a shine? I know it's been about six years now, but I just remembered I left them here!"
				(= local0 0)
			)
			(local3
				(gas dispose:)
				(= local3 0)
				(gMessager say: 2 42) ; "You hand Salvatore your French Postcards."
				(= local0 0)
			)
		)
	)
)

(instance backDoor of Prop
	(properties
		y 106
		noun 16
		approachX 310
		approachY 139
		view 640
		priority 1
		signal 16401
	)
)

(instance manWaiting of Prop
	(properties
		x 253
		y 133
		noun 26
		view 641
		signal 16384
	)
)

(instance boots of View
	(properties
		x 208
		y 118
		noun 22
		view 640
		loop 3
		signal 16384
	)
)

(instance postcards of View
	(properties
		x 233
		y 124
		z 13
		noun 23
		view 640
		loop 2
		signal 16384
	)
)

(instance gas of View
	(properties
		x 197
		y 84
		noun 24
		view 640
		loop 1
		signal 16384
	)
)

(instance manInChair of View
	(properties
		x 137
		y 114
		noun 2
		view 649
		priority 10
		signal 16400
	)
)

(instance bowl of Feature
	(properties
		x 162
		y 189
		noun 3
	)
)

(instance bottle1 of Feature
	(properties
		x 107
		y 189
		noun 4
	)
)

(instance bottle2 of Feature
	(properties
		x 70
		y 189
		noun 5
	)
)

(instance bottles3 of Feature
	(properties
		x 21
		y 189
		noun 6
	)
)

(instance stove of Feature
	(properties
		x 289
		y 146
		noun 7
	)
)

(instance bench of Feature
	(properties
		x 257
		y 123
		noun 8
	)
)

(instance buffalo of Feature
	(properties
		x 245
		y 123
		noun 9
	)
)

(instance lamp of Feature
	(properties
		x 199
		y 123
		noun 10
	)
)

(instance pitcher of Feature
	(properties
		x 70
		y 149
		noun 11
	)
)

(instance chair of Feature
	(properties
		x 134
		y 110
		noun 12
	)
)

(instance counter of Feature
	(properties
		x 88
		y 185
		noun 13
	)
)

(instance shelf of Feature
	(properties
		x 148
		y 123
		noun 14
	)
)

(instance topShelf of Feature
	(properties
		x 148
		y 80
		noun 19
	)
)

(instance bottomShelf1 of Feature
	(properties
		x 153
		y 83
		noun 20
		nsTop 76
		nsLeft 135
		nsBottom 91
		nsRight 171
	)
)

(instance bottomShelf2 of Feature
	(properties
		x 110
		y 83
		noun 20
		nsTop 76
		nsLeft 93
		nsBottom 91
		nsRight 127
	)
)

(instance frame1 of Feature
	(properties
		x 159
		y 188
		noun 15
		nsLeft 41
		nsBottom 188
		nsRight 59
	)
)

(instance frame2 of Feature
	(properties
		x 157
		y 187
		noun 15
		nsTop 167
		nsBottom 184
		nsRight 319
	)
)

(instance frame3 of Feature
	(properties
		x 157
		y 189
		noun 15
		nsLeft 307
		nsBottom 189
		nsRight 319
	)
)

(instance cabinet of Feature
	(properties
		x 191
		y 83
		noun 18
		nsTop 89
		nsLeft 177
		nsBottom 128
		nsRight 205
	)
)

(instance cuttingSound of FPSound
	(properties
		flags 1
	)
)

