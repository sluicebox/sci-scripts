;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Inset)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm420 0
	FHTalker 1
)

(local
	local0
	local1
)

(instance rm420 of Rm
	(properties
		noun 17
		picture 420
		style 10
		north 400
		west 400
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 2) ; Talk
				(super doVerb: theVerb &rest)
			)
			((not (gCurrentRegionFlags test: 26))
				(gMessager say: 17 2 8) ; "Move closer to my heart, child. I am too weak to speak louder."
			)
			((not (gCurrentRegionFlags test: 34))
				(gMessager say: 17 0 6) ; "I await your answer, child. Take this branch if you will help me."
			)
			((gCurrentRegionFlags test: 40)
				(gMessager say: 17 2 10) ; "Forest Heart is resting. She's too weak to speak again."
			)
			(else
				(gCurrentRegionFlags set: 40)
				(gMessager say: 17 2 9) ; "The Wise One - I bet that's the shaman. How do I find him?"
			)
		)
	)

	(method (doit)
		(cond
			((== (gEgo onControl: 1) 4096)
				(if local1
					(= local1 0)
					(Palette palSET_INTENSITY 207 235 100)
				)
			)
			((not local1)
				(= local1 1)
				(Palette palSET_INTENSITY 207 235 75)
			)
		)
		(super doit: &rest)
	)

	(method (init)
		(gEgo init: normalize: 423)
		(super init:)
		(seat init: setOnMeCheck: 1 2)
		(path1 init: setOnMeCheck: 1 4100)
		(pool init: setOnMeCheck: 1 8)
		(path2 init: setOnMeCheck: 1 16)
		(path3 init: setOnMeCheck: 1 32)
		(pedestal init: setOnMeCheck: 1 64)
		(podSeeds init:)
		(if (not (gCurrentRegionFlags test: 27))
			(cup init:)
		)
		(ripple init:)
		(if (and (gCurrentRegionFlags test: 26) (not (gCurrentRegionFlags test: 34)))
			(treeLimb
				cel: (treeLimb lastCel:)
				priority: 0
				approachVerbs: 4 ; Do
				init:
			)
		)
		(if (or (not (gCurrentRegionFlags test: 24)) (not (gCurrentRegionFlags test: 34)))
			(gGameSound2 number: 420 setLoop: -1 play:)
			(gCurRoom setScript: forestCartoon)
		else
			(gGameSound2 number: 421 setLoop: -1 play:)
		)
		(cond
			((gCurrentRegionFlags test: 20)
				(seat approachVerbs: 4) ; Do
				(treeLimb approachVerbs: 4) ; Do
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 142 15 155 92 189 177 189 259 187 259 165 158 174 63 165 42 149 171 149 222 137 231 128 230 118 198 106 155 98 142 92 143 88 184 80 170 79 134 86 126 93 157 104 192 109 216 119 217 132 196 139 60 142 34 136 0 132
							yourself:
						)
				)
				(exitWest init:)
				(gEgo
					setLoop: 4
					normalize: 423
					setPri: 10
					posn: 1 132
					setScale: Scaler 90 70 189 79
					setMotion: MoveTo 20 142
				)
			)
			((gCurrentRegionFlags test: 21)
				(exitNorth1 init:)
				(podSeeds approachVerbs: 4) ; Do
				(gEgo
					x: 81
					y: 124
					setScale: Scaler 60 40 100 60
					setMotion: PolyPath 107 109
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 73 84 94 95 95 114 91 123 105 128 109 116 110 109 120 93 130 90 130 75 91 72 69 72 57 81
							yourself:
						)
				)
				(self horizon: 20)
			)
			((gCurrentRegionFlags test: 22)
				(cup approachVerbs: 4) ; Do
				(ripple approachVerbs: 4) ; Do
				(gEgo
					posn: 287 60
					setScale: Scaler 60 40 100 60
					setMotion: PolyPath 294 63
				)
				(pool approachVerbs: 19) ; barkCup
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 319 101 242 83 313 73 297 55 264 50 264 63 295 68 301 72 222 82 296 102 290 105 260 107 259 109 319 109
							yourself:
						)
				)
				(exitNorth2 init:)
				(self horizon: 59)
			)
		)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
	)

	(method (dispose)
		(if (not (gCurrentRegionFlags test: 26))
			(gCurrentRegionFlags set: 25)
		)
		(gGameSound2 fade:)
		(super dispose:)
	)

	(method (cue)
		(gCurRoom newRoom: 400)
	)
)

(instance exitWest of ExitFeature
	(properties
		nsTop 97
		nsBottom 133
		nsRight 20
		cursor 12
		exitDir 4
		toX -10
		toY 135
	)
)

(instance exitNorth1 of ExitFeature
	(properties
		nsTop 93
		nsLeft 59
		nsBottom 125
		nsRight 91
		cursor 13
		exitDir 1
		toX 91
		toY 123
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
				(= temp0 toX)
				(= temp1 toY)
				(gEgo setMotion: PolyPath toX toY gCurRoom)
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance exitNorth2 of ExitFeature
	(properties
		nsTop 23
		nsLeft 232
		nsBottom 63
		nsRight 296
		cursor 13
		exitDir 1
	)
)

(instance seat of Feature
	(properties
		x 163
		y 5
		noun 1
		onMeCheck 2
		approachX 180
		approachY 78
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (gCurrentRegionFlags test: 26) (not (gCurrentRegionFlags test: 34)))
						(gMessager say: 17 0 6 0) ; "I await your answer, child. Take this branch if you will help me."
					)
					((and (not (gCurrentRegionFlags test: 26)) (gCurrentRegionFlags test: 20))
						(gCurRoom setScript: heartCartoon)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(2 ; Talk
				(rm420 doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance path1 of Feature
	(properties
		x 9
		y 7
		noun 4
		onMeCheck 4100
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(rm420 doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pool of Feature
	(properties
		x 302
		y 106
		noun 2
		onMeCheck 8
		approachX 302
		approachY 106
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; barkCup
				(if (gCurrentRegionFlags test: 22)
					(gCurRoom setScript: egoGetsSappy)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance path2 of Feature
	(properties
		x 67
		y 5
		noun 5
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(rm420 doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance path3 of Feature
	(properties
		x 70
		y 5
		noun 15
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(rm420 doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pedestal of Feature
	(properties
		x 141
		y 5
		noun 18
		onMeCheck 64
	)
)

(instance cup of View
	(properties
		x 262
		y 84
		noun 3
		approachX 260
		approachY 108
		view 420
		loop 5
		priority 7
		signal 16401
		scaleSignal 1
		scaleX 72
		scaleY 72
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurrentRegionFlags test: 22)
					(gEgo get: 11)
					(gCurrentRegionFlags set: 27)
					(gGame points: 5)
					(gMessager say: 3 4 12) ; "Adam picks up the bark cup."
					(self dispose:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance podSeeds of View
	(properties
		x 58
		y 76
		noun 19
		approachX 71
		approachY 76
		view 420
		loop 5
		cel 1
		signal 16385
		scaleSignal 1
		scaleX 74
		scaleY 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55 ; E-corder
				(if (not (IsEcorderFlag 13))
					(self perform: gWriteEcorderData theVerb 13)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if (gCurrentRegionFlags test: 21)
					(if (gCurrentRegionFlags test: 28)
						(super doVerb: theVerb &rest)
					else
						(gEgo get: 12)
						(gMessager say: 19 4 12) ; "Adam gathers some of the spicy pods."
						(gCurRoom setScript: pickUp 0 0)
						(gCurrentRegionFlags set: 28)
					)
				else
					(gMessager say: 19 4 11) ; "Adam can't get that from here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 13))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance ripple of Prop
	(properties
		x 278
		y 120
		approachX 302
		approachY 106
		view 420
		loop 6
		signal 1
		cycleSpeed 7
	)

	(method (init)
		(super init: &rest)
		(self setScript: drip)
	)

	(method (doVerb theVerb)
		(pool doVerb: theVerb &rest)
	)
)

(instance treeLimb of Actor
	(properties
		x 97
		y 21
		noun 9
		approachX 125
		approachY 181
		view 420
		loop 4
		priority 11
		signal 26641
		cycleSpeed 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurrentRegionFlags test: 20)
					(gEgo get: 10)
					(gCurRoom setScript: pickUp 0 self)
					(gCurrentRegionFlags set: 34)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance egoGetsSappy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 5)
				(gEgo setMotion: PolyPath 260 108 self)
			)
			(1
				(gEgo
					view: 422
					setLoop: 1
					setCel: 0
					setScale: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(gCurrentRegionFlags set: 16)
				((gInventory at: 11) cel: 13 message: 26 noun: 32)
			)
			(2
				(gEgo normalize: 423 2 setScale: Scaler 60 40 100 60)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance forestCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 4)
			)
			(1
				(= ticks 60)
			)
			(2
				(cond
					((and (gCurrentRegionFlags test: 26) (not (gCurrentRegionFlags test: 34)))
						(gMessager say: 17 0 6 0 self) ; "I await your answer, child. Take this branch if you will help me."
					)
					((gCurrentRegionFlags test: 25)
						(gMessager say: 17 0 2 0 self) ; "Come closer to my heart, Adam. I have grown too weak to speak aloud."
					)
					(else
						(if (DoSound sndGET_AUDIO_CAPABILITY)
							(sFX number: 422 loop: 1 play:)
						)
						(gMessager say: 17 0 3 0 self) ; "Welcome, child."
						(gCurrentRegionFlags set: 24)
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance heartCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 5)
				(gEgo setHeading: 220 self)
				(gCurrentRegionFlags set: 26)
				(gGameSound2 number: 421 setLoop: -1 play:)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 422
					setLoop: 0
					setScale: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(3
				(= ticks 120)
			)
			(4
				(gMessager say: 17 0 4 0 self) ; "Adam, my end grows near. Soon, I will die."
			)
			(5
				(= ticks 60)
			)
			(6
				(gCurRoom setInset: deadSeedling)
				(Animate (gCast elements:) 1)
				(= ticks 120)
			)
			(7
				(gMessager say: 17 0 5 0 self) ; "Yet no seedling lives to carry on my line. A shaking of the ground destroyed my child."
			)
			(8
				(= cycles 2)
			)
			(9
				(deadSeedling dispose:)
				(= ticks 60)
			)
			(10
				(treeLimb
					init:
					approachVerbs: 4 ; Do
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(11
				(treeLimb posn: 127 173 loop: 5 cel: 2 stopUpd:)
				(sFX number: 425 setLoop: 1 play:)
				(= ticks 80)
			)
			(12
				(treeLimb priority: 0)
				(= ticks 60)
			)
			(13
				(gMessager say: 17 0 16 0 self) ; "If you will help me, take this branch. It is the first of my gifts."
			)
			(14
				(= ticks 60)
			)
			(15
				(gEgo setCycle: Beg self)
			)
			(16
				(gEgo
					normalize: 423 1
					setScale: Scaler 90 70 189 79
					setPri: 10
				)
				(seat approachVerbs: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deadSeedling of Inset
	(properties
		view 99
		x 3
		y 88
	)

	(method (drawInset)
		(super drawInset: &rest)
		(insetView stopUpd:)
	)
)

(instance drip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (Random 0 3)
					(-- state)
					(= ticks 60)
				else
					(= cycles 2)
				)
			)
			(1
				(= local0 0)
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
			(2
				(register dispose:)
				(= register 0)
				(gGameSound1 number: 387 loop: 1 play:)
				(ripple cel: 0 setCycle: End self)
			)
			(3
				(ripple stopUpd:)
				(= ticks 360)
				(= state -1)
			)
		)
	)

	(method (doit)
		(if (and (IsObject register) (>= (register y:) local0))
			(register
				yStep: (+ (register yStep:) 1)
				setMotion: MoveTo 278 116 self
			)
			(= local0 (+ (register y:) (register yStep:) 1))
		)
		(super doit:)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 5)
				(if (< (gEgo cel:) 4)
					(gEgo
						scaleX: 128
						scaleY: 128
						view: 5
						loop: (gEgo cel:)
						cel: 0
						setSpeed: 6
						setCycle: CT 3 1 self
					)
				else
					(gEgo
						view: 5
						loop: (mod (gEgo cel:) 2)
						cel: 0
						setSpeed: 6
						setCycle: CT 3 1 self
					)
				)
			)
			(1
				(if (IsObject register)
					(register dispose:)
				)
				(gEgo setCycle: End self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					normalize: 423
					setPri: (if (gCurrentRegionFlags test: 20) 10 else -1)
				)
				(= cycles 2)
			)
			(4
				(if (== register treeLimb)
					(gMessager say: 9 4 13 0 self) ; "Thank you, child. If you find the Wise One, he will tell you more."
				else
					(self cue:)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance FHTalker of Narrator
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

(instance sFX of Sound
	(properties)
)

