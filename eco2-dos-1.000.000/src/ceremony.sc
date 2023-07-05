;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	ceremony 0
	FHTalker2 1
)

(local
	[local0 5]
	[local5 5] = [437 438 437 436 435]
	local10
	local11
	local12
	local13
	local14
)

(instance ceremony of Rm
	(properties
		noun 7
		picture 420
		style 10
	)

	(method (doit)
		(if local14
			(cond
				((== (gEgo onControl: 1) 4096)
					(if local11
						(= local11 0)
						(Palette palSET_INTENSITY 207 235 100)
					)
				)
				((not local11)
					(= local11 1)
					(Palette palSET_INTENSITY 207 235 75)
				)
			)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(= local13 (DoSound sndGET_AUDIO_CAPABILITY))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 142 15 155 92 189 177 189 259 187 259 165 158 174 63 165 42 149 171 149 226 136 230 118 198 106 155 98 142 92 143 88 174 82 166 81 134 86 126 93 157 104 192 109 216 119 217 132 196 139 60 142 34 136 0 132
					yourself:
				)
		)
		((ScriptID 1319) setupTalker: 6) ; Potter
		((ScriptID 1329) setupTalker: 4) ; Chief
		((ScriptID 1359) setupTalker: 6) ; Weaver
		((ScriptID 1369) setupTalker: 4) ; Drumboy
		((ScriptID 1069) setupTalker: 4) ; Shaman
		((ScriptID 1009) setupTalker: 6) ; EgoTalker
		(ripple init:)
		(shaman init: approachX: 155 approachY: 83 stopUpd: approachVerbs: 18) ; bough
		(chief init: stopUpd:)
		(boy init: stopUpd:)
		(weaver init:)
		(sisnkid init: stopUpd:)
		(= local14 (== (Graph grGET_COLOURS) 256))
		(gEgo
			loop: 8
			cel: 6
			x: 155
			y: 83
			setScale: Scaler 90 70 189 79
			init:
			normalize: 423
			setPri: 10
		)
		(gCurRoom setScript: ceremonialScript)
		(seat init: setOnMeCheck: 1 2)
		(path1 init: setOnMeCheck: 1 4)
		(pool init: setOnMeCheck: 1 8)
		(path2 init: setOnMeCheck: 1 16)
		(path3 init: setOnMeCheck: 1 32)
		(pedestal init: setOnMeCheck: 1 64)
	)
)

(instance seat of Feature
	(properties
		x 163
		y -10
		noun 8
		sightAngle 40
		onMeCheck 2
	)
)

(instance path1 of Feature
	(properties
		x 9
		y -50
		noun 1
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb)
		(gMessager say: 1 0 0) ; "A winding path leads to the center of the hollow."
	)
)

(instance pool of Feature
	(properties
		x 302
		y -50
		noun 6
		sightAngle 40
		onMeCheck 8
		approachX 302
		approachY 106
	)

	(method (doVerb)
		(gMessager say: 6 0 0) ; "A fragrant pool of sap glimmers in the dim light."
	)
)

(instance path2 of Feature
	(properties
		x 67
		y -50
		noun 2
		sightAngle 40
		onMeCheck 16
	)

	(method (doVerb)
		(gMessager say: 2 0 0) ; "A small space is hollowed out among the roots."
	)
)

(instance path3 of Feature
	(properties
		x 70
		y -50
		noun 3
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb)
		(gMessager say: 3 0 0) ; "The path is saturated with sap."
	)
)

(instance pedestal of Feature
	(properties
		x 141
		y -50
		noun 4
		sightAngle 40
		onMeCheck 64
	)

	(method (doVerb)
		(gMessager say: 4 0 0) ; "The roots seem to form a winding pathway."
	)
)

(instance chief of Prop
	(properties
		x 287
		y 65
		noun 12
		view 420
		loop 1
		priority 10
		signal 16400
	)
)

(instance shaman of Prop
	(properties
		x 173
		y 79
		noun 9
		view 421
		priority 6
		signal 16400
		scaleSignal 1
		scaleX 89
		scaleY 89
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(if (== theVerb 18) ; bough
			(gEgo put: 10)
			(gGame points: 5)
			(gCurRoom setScript: partyTime)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance boy of Prop
	(properties
		x 272
		y 106
		noun 17
		view 420
		loop 3
		priority 10
		signal 16400
	)
)

(instance weaver of Prop
	(properties
		x 93
		y 75
		noun 15
		view 420
		priority 9
		signal 16400
	)
)

(instance sisnkid of Prop
	(properties
		x 69
		y 48
		noun 16
		view 420
		loop 2
		priority 10
		signal 16400
	)
)

(instance blossom of Prop
	(properties
		x 18
		y -10
		noun 5
		approachX 66
		approachY 178
		view 420
		loop 9
		priority 15
		signal 20496
		scaleSignal 1
		scaleX 171
		scaleY 171
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo get: 7)
			(gCurRoom setScript: pickUp)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ripple of Prop
	(properties
		x 278
		y 120
		noun 6
		view 420
		loop 6
		signal 16400
		cycleSpeed 7
	)

	(method (doit)
		(cond
			(script
				(super doit:)
			)
			((not (Random 0 5000))
				(self setScript: drip)
			)
		)
	)
)

(instance prompt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(if (IsFlag 5)
					(self cue:)
				else
					(gMessager say: 7 0 2 0 self) ; "The Green Memory is the key. Give it to me!"
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame points: 5 handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(gEgo
					setScale: 0
					scaleX: 128
					scaleY: 128
					view: 422
					loop: 2
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(3
				(gGameSound1 client: 0 hold: 0)
				(blossom dispose:)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gMessager say: 5 0 7 0 self) ; "It is said that Forest Heart blooms only when her end is near."
			)
			(6
				(gEgo loop: 4 cel: 0 setCycle: End)
				(= cycles 2)
			)
			(7
				(= ticks 20)
			)
			(8
				(if local13
					(gGameSound2 number: 423 loop: 1 play:)
				)
				(gMessager say: 7 0 10 0 self) ; "Remember me..."
			)
			(9
				(if local14
					(PalVary pvINIT 420 10)
				)
				(= register local12)
				(= cycles 2)
			)
			(10
				([local0 register] cycleSpeed: 10 setCycle: Beg self)
				(gGameSound2 number: [local5 register] loop: 1 play:)
			)
			(11
				(if (> (-- register) -1)
					(-= state 2)
					(= ticks 20)
				else
					(self cue:)
				)
			)
			(12
				(if (not (== (gGameSound1 prevSignal:) -1))
					(gGameSound1 client: self)
				else
					(= cycles 2)
				)
			)
			(13
				(gCurRoom setScript: blackScreen)
				(self dispose:)
			)
		)
	)
)

(instance drip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local10 0)
				((= register (Actor new:))
					view: 420
					loop: 7
					cel: 0
					x: 278
					y: 0
					moveSpeed: 4
					priority: 15
					yStep: 1
					signal: 26640
					init:
					setMotion: MoveTo 278 116 self
				)
			)
			(1
				(register dispose:)
				(= register 0)
				(ripple cel: 0 setCycle: End self)
			)
			(2
				(ripple stopUpd:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (IsObject register) (>= (register y:) local10))
			(register
				yStep: (+ (register yStep:) 1)
				setMotion: MoveTo 278 116 self
			)
			(= local10 (+ (register y:) (register yStep:) 1))
		)
		(super doit:)
	)
)

(instance ceremonialScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameSound1 number: 427 play: hold: 1)
				(= seconds 3)
			)
			(1
				(shaman startUpd: setCycle: End self)
			)
			(2
				(shaman cel: 0 stopUpd:)
				(gMessager say: 7 0 1 0 self) ; "We are gathered, the descendants of the First Ones."
			)
			(3
				(gGame handsOn:)
				(weaver stopUpd:)
				(client setScript: prompt)
			)
		)
	)
)

(instance partyTime of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shaman startUpd: loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(gMessager say: 9 18 0 0 self) ; "Forest Heart gave me this. Is that what you want?"
			)
			(2
				(shaman setCycle: End self)
				(gEgo setHeading: 180 self)
			)
			(3)
			(4
				(gGameSound1 hold: 2)
				(shaman loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(shaman loop: 2 cel: 12 setCycle: CT 9 -1 self)
			)
			(6
				(gMessager say: 7 0 3 0 self) ; "I, Sinchi, call on you all. Dream with me."
			)
			(7
				(shaman setCycle: End self)
			)
			(8
				(gGameSound1 hold: 3)
				(shaman loop: 1 cel: 0 setCycle: End self)
			)
			(9
				(shaman loop: 2 cel: 12 setCycle: CT 9 -1 self)
			)
			(10
				(gMessager say: 7 0 4 0 self) ; "The years have passed. We no longer live as we once did."
			)
			(11
				(shaman setCycle: End self)
			)
			(12
				(gGameSound1 hold: 4)
				(shaman loop: 1 cel: 0 setCycle: End self)
			)
			(13
				(shaman loop: 2 cel: 12 setCycle: CT 9 -1 self)
			)
			(14
				(gMessager say: 7 0 5 0 self) ; "We planted her and cared for her. She gave us everything. The memory of who we were slept."
			)
			(15
				(shaman stopUpd:)
				(gGameSound1 number: 429 loop: 1 play: self)
				((= register (View new:))
					view: 428
					loop: 0
					cel: 0
					x: 4
					y: 7
					priority: 15
					signal: 17
					init:
				)
				(DrawPic 420 9 1)
			)
			(16
				(gGameSound1 client: 0)
				(= ticks 200)
			)
			(17
				(gGameSound1 number: 427 play:)
				(register dispose:)
				(= register 0)
				(DrawPic 420 9 1)
				(= cycles 30)
			)
			(18
				(gMessager say: 7 0 6 0 self) ; "Our ancient home lies before you! It is Cibola! The City of Gold."
			)
			(19
				(gGameSound1 fade: 0 80 20 1)
				(gGameSound2
					number: 433
					setLoop: 1
					play: 0 self
					fade: 127 80 20 0
				)
			)
			(20
				((= [local0 register] (Prop new:))
					view: 420
					loop: 13
					cel: 0
					x: 124
					scaleSignal: 1
					scaleX: 84
					scaleY: 84
					y: 29
					cycleSpeed: 10
					signal: 4112
					priority: 5
					init:
					setCycle: End
				)
				(++ register)
				(= cycles 65)
			)
			(21
				((= [local0 register] (Prop new:))
					view: 420
					loop: 11
					cel: 0
					x: 224
					y: 11
					signal: 4112
					priority: 5
					scaleSignal: 1
					scaleX: 90
					scaleY: 90
					init:
					cycleSpeed: 10
					setCycle: End
				)
				(++ register)
				(= cycles 58)
			)
			(22
				((= [local0 register] (Prop new:))
					view: 420
					loop: 12
					cel: 0
					x: 157
					y: 1
					scaleSignal: 1
					scaleX: 80
					scaleY: 80
					init:
					signal: 4112
					priority: 5
					cycleSpeed: 10
					setCycle: End
				)
				(++ register)
				(= cycles 56)
			)
			(23
				((Prop new:)
					view: 420
					loop: 9
					cel: 0
					x: 228
					y: -10
					scaleSignal: 1
					scaleX: 92
					scaleY: 92
					priority: 6
					signal: 4112
					init:
					cycleSpeed: 8
					setScript: (loopScript new:) 0 8
				)
				(= cycles 40)
			)
			(24
				((Prop new:)
					view: 420
					loop: 8
					cel: 0
					x: 270
					y: -15
					scaleSignal: 1
					scaleX: 92
					scaleY: 92
					init:
					signal: 4112
					priority: 3
					cycleSpeed: 8
					setScript: (loopScript new:) 0 8
				)
				(= cycles 38)
			)
			(25
				((Prop new:)
					view: 420
					loop: 8
					cel: 0
					x: 90
					y: -15
					scaleSignal: 1
					scaleX: 117
					scaleY: 117
					signal: 20496
					priority: 5
					init:
					cycleSpeed: 8
					setScript: (loopScript new:) 0 7
				)
				(= cycles 34)
			)
			(26
				((Prop new:)
					view: 420
					loop: 8
					cel: 0
					x: 67
					y: -15
					init:
					signal: 4112
					priority: 5
					cycleSpeed: 8
					setScript: (loopScript new:) 0 5
				)
				((= [local0 register] (Prop new:))
					view: 420
					loop: 10
					cel: 0
					x: 168
					y: 21
					scaleSignal: 1
					scaleX: 88
					scaleY: 88
					init:
					signal: 4112
					priority: 5
					cycleSpeed: 10
					setCycle: End
				)
				(++ register)
				(= cycles 36)
			)
			(27
				((Prop new:)
					view: 420
					loop: 8
					cel: 0
					x: 175
					y: -10
					priority: 7
					signal: 4112
					init:
					cycleSpeed: 8
					setScript: (loopScript new:) 0 5
				)
				((Prop new:)
					view: 420
					loop: 9
					cel: 0
					x: 7
					y: -10
					init:
					signal: 4096
					cycleSpeed: 8
					setScript: (loopScript new:) 0 5
				)
				((= [local0 register] (Prop new:))
					view: 420
					loop: 13
					cel: 0
					x: 261
					y: 14
					scaleSignal: 1
					scaleX: 84
					scaleY: 84
					init:
					cycleSpeed: 10
					signal: 4112
					priority: 5
					setCycle: End
				)
			)
			(28
				(blossom
					init:
					cycleSpeed: 15
					setCycle: End self
					approachVerbs: 4 ; Do
				)
			)
			(29
				(blossom loop: 14 cel: 0 x: 70 y: 187 setScale: 0)
				(gGameSound2 stop:)
				(gGameSound1 number: 434 loop: 1 client: 0 play: hold: 1)
				(= local12 register)
				(for ((= temp0 0)) (<= temp0 register) ((++ temp0))
					([local0 temp0] stopUpd:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance loopScript of Script
	(properties)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (- 5 gHowFast))
		(if (and (< gHowFast 3) (> register temp0))
			(-= register temp0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End self)
			)
			(1
				(if register
					(self init: client 0 (-- register))
				else
					(client dispose:)
				)
			)
		)
	)
)

(instance delayScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles register)
			)
			(1
				(client setMotion: MoveTo (client x:) 57)
				(self dispose:)
			)
		)
	)
)

(instance blackScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local14
					(PalVary pvREVERSE 0)
					(Palette palSET_INTENSITY 1 255 0)
				)
				(= cycles 1)
			)
			(1
				(Load rsVIEW 424)
				(gGameSound1 number: 430 setLoop: -1 play:)
				(gTheIconBar disable:)
				(= register 0)
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 888 -32758 1)
				(= ticks 65)
			)
			(2
				(if local14
					(Palette palSET_INTENSITY 1 255 0)
				)
				(= cycles 50)
				((View new:)
					view: 424
					signal: 16400
					loop: 0
					cel: 0
					x: 101
					y: 33
					priority: 0
					init:
				)
				((Actor new:)
					view: 424
					signal: 18448
					loop: 1
					cel: 0
					x: 171
					y: 209
					yStep: 2
					priority: 12
					moveSpeed: 10
					setMotion: MoveTo 171 162
					init:
				)
				((Actor new:)
					view: 424
					signal: 18448
					loop: 2
					cel: 0
					x: 170
					y: 172
					priority: 14
					yStep: 2
					moveSpeed: 10
					setCycle: Fwd
					setMotion: MoveTo 170 125
					init:
				)
				((Actor new:)
					view: 424
					signal: 18448
					loop: 2
					cel: 2
					x: 189
					y: 63
					scaleSignal: 1
					scaleX: 48
					scaleY: 48
					yStep: 1
					moveSpeed: 18
					setCycle: Fwd
					setMotion: MoveTo 189 50
					init:
				)
				((Actor new:)
					view: 424
					signal: 18448
					loop: 2
					cel: 2
					x: 122
					y: 63
					scaleSignal: 1
					scaleX: 48
					scaleY: 48
					yStep: 1
					moveSpeed: 18
					setCycle: Fwd
					setMotion: MoveTo 122 53
					init:
				)
				((Prop new:)
					view: 424
					signal: 16400
					priority: 1
					loop: 3
					cel: 0
					x: 154
					y: 137
					cycleSpeed: 50
					setCycle: End
					init:
				)
				((View new:)
					view: 424
					signal: 16400
					loop: 4
					cel: 0
					posn: 89 163
					priority: 15
					init:
					yourself:
				)
			)
			(3
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 888 9 1)
				(= ticks 60)
			)
			(4
				(if local14
					(Palette palSET_INTENSITY 1 255 100)
				)
				((View new:)
					view: 426
					loop: 0
					cel: 0
					x: 76
					y: 86
					priority: 0
					signal: 16
					init:
				)
				(DrawPic 888 9 1)
				(= ticks 240)
			)
			(5
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 888 9 1)
				(= ticks 100)
			)
			(6
				((Prop new:)
					view: 425
					loop: 0
					cel: 0
					x: 10
					y: 18
					priority: 1
					signal: 16
					cycleSpeed: 15
					setCycle: End self
					init:
				)
				(DrawPic 888 9 1)
			)
			(7
				(gNarrator back: 62 color: 0)
				(gMessager say: 7 0 8 1 self) ; "Run to the river! Save yourselves!"
			)
			(8
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 888 9 1)
				(= ticks 100)
			)
			(9
				((Prop new:)
					view: 427
					loop: 1
					cel: 0
					x: 217
					y: 107
					priority: 1
					signal: 16
					cycleSpeed: 15
					setCycle: End self
					init:
				)
				(DrawPic 888 9 1)
			)
			(10
				(gNarrator back: 67 color: 0)
				(gMessager say: 7 0 8 2 self) ; "I can't get out!"
			)
			(11
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(DrawPic 888 9 1)
				(= cycles 10)
			)
			(12
				(gNarrator y: 5 x: 10 back: 67 color: 0)
				(gMessager say: 7 0 9 1 self) ; "I can't find you!"
			)
			(13
				(gNarrator y: 100 x: 175 back: 67 color: 0)
				(gMessager say: 7 0 9 2 self) ; "There's so much smoke!"
			)
			(14
				(gNarrator y: 75 x: 10 back: 67 color: 0)
				(gMessager say: 7 0 9 3 self) ; "Someone answer! Please!"
			)
			(15
				(gNarrator y: 10 x: 60 back: 67 color: 0)
				(gMessager say: 7 0 9 4 self) ; "I can't find the river!"
			)
			(16
				(gNarrator back: 68 color: 68)
				(= ticks 240)
			)
			(17
				(gCurRoom newRoom: 440)
			)
		)
	)

	(method (doit)
		(if (and local14 (== state 2))
			(Palette palSET_INTENSITY 1 255 (* (- 50 cycles) 2))
		)
		(super doit:)
	)
)

(instance FHTalker2 of Narrator
	(properties
		x 50
		y 5
		talkWidth 220
		keepWindow 1
		font 4000
		color 7
		back 16
	)

	(method (display param1 &tmp temp0)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= saveCursor gTheCursor)
			(gGame setCursor: 996)
		else
			(= saveCursor 0)
		)
		(= underBits
			(Display param1 dsALIGN alCENTER dsCOORD x y dsWIDTH talkWidth dsCOLOR color dsFONT font dsSAVEPIXELS)
		)
	)

	(method (dispose &tmp temp0)
		(= temp0 0)
		(Display @temp0 dsRESTOREPIXELS underBits)
		(super dispose: &rest)
	)
)

