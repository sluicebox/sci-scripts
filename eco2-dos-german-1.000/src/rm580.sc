;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use Talker)
(use Feature)
(use LoadMany)
(use DPath)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm580 0
	paquitaPrint 1
)

(local
	local0 = 120
	local1
	local2
	local3
	local4
	local5
)

(instance rm580 of Rm
	(properties
		noun 11
		picture 580
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 590 591 581 50)
		(LoadMany rsSOUND 580 582 585 590 592 869)
		(gGame handsOff:)
		(gEgo
			x: 1
			y: 186
			init:
			normalize: 14
			setScale: 0
			xStep: 2
			cycleSpeed: 10
			moveSpeed: 4
			setLoop: 2
			setCel: 0
			setCycle: Fwd
			setMotion: MoveTo 319 186
			setScript: paddle 0 1
		)
		(Palette palSET_INTENSITY 1 254 70)
		(super init:)
		(gGameSound1 number: 585 loop: -1 play:)
		(gGameSound2 number: 582 loop: -1 play: hold:)
		(launchSound play: 50)
		(burnout init:)
		(water init: setOnMeCheck: 1 32)
		(roots init: setOnMeCheck: 1 16)
		(bank init: setOnMeCheck: 1 8)
		(smoke init: setOnMeCheck: 1 4)
		(sky init: setOnMeCheck: 1 2)
		(paquitaEyes init:)
		(paquitaFeat init:)
		(boatFeat init:)
		(gTheDoits add: burnout paquitaFeat boatFeat)
		(gKeyDownHandler addToFront: burnout water)
		(gMouseDownHandler addToFront: burnout water)
		(gDirectionHandler addToFront: water)
		(gWalkHandler addToFront: water)
		(self setScript: openingScript)
	)

	(method (dispose)
		(gKeyDownHandler delete: water burnout)
		(gMouseDownHandler delete: water burnout)
		(gDirectionHandler delete: water)
		(gWalkHandler delete: water)
		(gTheDoits delete: burnout paquitaFeat boatFeat)
		(super dispose:)
	)

	(method (doit)
		(gUser canControl: 0)
		(cond
			((and (gEgo edgeHit:) (not local3) (not (== local4 4)))
				(= local3 1)
				(++ local4)
				(gGame handsOff:)
				(gEgo
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 365 (gEgo y:) self
				)
			)
			((and (not (gEgo mover:)) (not (== local4 4)))
				(gEgo setLoop: 2 setCycle: Fwd setMotion: MoveTo 319 186)
			)
		)
		(if (not (IsFlag 5))
			(Palette palANIMATE 72 77 5 78 85 5)
		)
		(super doit: &rest)
	)

	(method (cue &tmp temp0)
		(super cue:)
		(if
			(and
				(== (gCurRoom script:) openingScript)
				(< (openingScript state:) 5)
			)
			(openingScript register: 1 ticks: 0 cycles: 0 state: 4 cue:)
		)
		(gEgo
			posn: 45 (gEgo y:)
			setLoop: 2
			setCycle: Fwd
			edgeHit: 0
			xStep: 3
			setMotion: MoveTo 319 186
		)
		(spot dispose:)
		(spotLight dispose:)
		(launch dispose:)
		(splash dispose:)
		(launchSound fade: 50 25 10 0)
		(gCurRoom drawPic: (if (== (gCurRoom curPic:) 580) 590 else 580) 12)
		(if (openingScript register:)
			(Palette palSET_INTENSITY 1 255 60)
		)
		(gGame handsOn:)
		(gUser canControl: 0)
		(= local3 0)
		(cond
			((== local4 4)
				(whirlpool init: setCycle: Fwd)
				(front init: setCycle: Fwd)
				(stump init:)
				(stumpWater init: setCycle: Fwd)
				(gCurRoom setScript: crashAndSpin)
			)
			((>= local4 2)
				(spot
					x: (if (== (= temp0 (gCurRoom curPic:)) 580) 10 else 11)
					y: (if (== temp0 580) 138 else 132)
					cel: 0
					init:
					setScript: spotLight
				)
				(launch posn: -57 184)
				(splash posn: -57 184)
			)
		)
	)
)

(instance openingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(= ticks 45)
			)
			(2
				(gMessager say: 11 0 4 0 self) ; "I have a bad feeling. Paddle faster!"
			)
			(3
				(gGame handsOn:)
				(gTheIconBar disable: 1 2 3 4 5 6 7)
				(gUser canControl: 0)
				(launchSound fade: 100 25 10 0)
			)
			(4
				(gGame handsOff:)
				(= ticks 10)
			)
			(5
				(gMessager say: 11 0 1 0 self) ; "Oh no! It is that bad one! He has a boat!"
			)
			(6
				(gGameSound2 release:)
				(= cycles 2)
			)
			(7
				(gGame handsOn:)
				(gUser canControl: 0)
			)
		)
	)

	(method (doit)
		(if (== state 3)
			(Palette palSET_INTENSITY 1 255 (Max 40 (+ (/ (-- local0) 2) 40)))
			(if (> (gEgo x:) 270)
				(self cue:)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance spareSound of Sound
	(properties)
)

(instance launchSound of Sound
	(properties
		number 580
		loop -1
	)
)

(instance burnout of Feature
	(properties
		x 160
		y 100
		nsBottom 190
		nsRight 320
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(not (IsEcorderFlag 55))
				(or
					(and
						(== (gTheCursor loop:) 8)
						(OneOf (gTheCursor cel:) 8 10)
					)
					(and (== (gTheCursor loop:) 10) (== (gTheCursor cel:) 4))
				)
				(or
					(& (= temp0 (event type:)) evMOUSEBUTTON)
					(and (& temp0 evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(not (event modifiers:))
			)
			(event claimed: 1)
			(self perform: gWriteEcorderData 55 55)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 55))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 55))
			(super doVerb: theVerb)
		)
	)
)

(instance water of Feature
	(properties
		x 320
		y 180
		noun 1
		onMeCheck 32
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (event type:))
		(= temp2 (event message:))
		(cond
			(
				(or
					(and
						(= temp0
							(or
								(== ((gTheIconBar curIcon:) cursor:) 0)
								(& temp1 evMOVE)
								(and
									(== (gTheCursor loop:) 4)
									(== (gTheCursor cel:) 5)
								)
							)
						)
						(& temp1 $0040) ; direction
						(OneOf temp2 JOY_RIGHT JOY_LEFT)
					)
					(and
						temp0
						(self onMe: event)
						(or (& temp1 evMOUSEBUTTON) (and (& temp1 evKEYBOARD) (== temp2 KEY_RETURN)))
						(or
							(<=
								(= temp3 (event x:))
								(- (= temp4 (gEgo x:)) 5)
							)
							(>= temp3 (+ temp4 5))
						)
						(not (event modifiers:))
					)
				)
				(event claimed: 1)
				(if (== (gEgo loop:) 2)
					(gEgo
						setScript:
							paddle
							0
							(if (& temp1 $0040) ; direction
								(== temp2 JOY_RIGHT)
							else
								(>= (event x:) (gEgo x:))
							)
					)
				)
			)
			((and temp0 (gEgo onMe: event))
				(event claimed: 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance boatFeat of Feature
	(properties
		y 188
		z 1
		noun 6
		nsTop 173
		nsBottom 182
	)

	(method (doit)
		(self
			x: (gEgo x:)
			nsLeft: (gEgo nsLeft:)
			nsRight: (gEgo nsRight:)
		)
		(super doit:)
	)
)

(instance paquitaFeat of Feature
	(properties
		y 188
		z 21
		noun 13
		nsTop 151
	)

	(method (doit)
		(self
			x: (+ (gEgo x:) 35)
			nsLeft: (- (gEgo nsRight:) 20)
			nsRight: (gEgo nsRight:)
			nsBottom: (+ (gEgo nsTop:) 23)
		)
		(super doit:)
	)
)

(instance roots of Feature
	(properties
		x 320
		y 156
		noun 2
		onMeCheck 16
	)
)

(instance bank of Feature
	(properties
		x 320
		y 125
		noun 3
		onMeCheck 8
	)
)

(instance smoke of Feature
	(properties
		x 320
		y 85
		noun 4
		onMeCheck 4
	)
)

(instance sky of Feature
	(properties
		x 320
		y 32
		noun 5
		onMeCheck 2
	)
)

(instance stump of View
	(properties
		x 174
		y 178
		view 591
		loop 1
		priority 12
		signal 16400
	)
)

(instance paquitaEyes of View
	(properties
		noun 13
		view 14
		signal 16384
	)

	(method (doit)
		(self
			x: (gEgo x:)
			y: (gEgo y:)
			setPri: (+ (gEgo priority:) 1)
			loop: (+ (gEgo loop:) 3)
			cel: (gEgo cel:)
		)
		(super doit: &rest)
	)
)

(instance spot of Prop
	(properties
		x 10
		y 138
		noun 8
		view 580
		signal 2048
		cycleSpeed 12
	)
)

(instance whirlpool of Prop
	(properties
		x 255
		y 186
		view 591
		loop 2
		priority 12
		signal 16400
	)
)

(instance front of Prop
	(properties
		x 255
		y 186
		view 591
		loop 3
		priority 13
		signal 16400
	)
)

(instance stumpWater of Prop
	(properties
		x 174
		y 178
		view 591
		priority 14
		signal 16400
		cycleSpeed 10
	)
)

(instance launch of Actor
	(properties
		x -57
		y 184
		noun 9
		view 581
		loop 1
		signal 18432
		xStep 2
	)

	(method (doit)
		(if (and (< x 0) (not mover))
			(self setMotion: MoveTo 0 184)
		)
		(super doit:)
	)
)

(instance splash of Actor
	(properties
		x -57
		y 184
		view 581
		signal 18432
		cycleSpeed 12
		xStep 2
	)

	(method (doit)
		(if (and (< x 0) (not mover))
			(self setCycle: Fwd setMotion: MoveTo 0 184)
		)
		(super doit:)
	)
)

(instance paquita of Actor
	(properties
		x 135
		y 154
		noun 10
		view 16
		loop 4
		priority 15
		signal 18448
	)
)

(instance paddle of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= temp1
					(cond
						((< (= temp0 (gEgo moveSpeed:)) 4) 1)
						((> temp0 14) 3)
						(else 2)
					)
				)
				(if
					(<
						(= temp0
							(if register
								(- temp0 temp1)
							else
								(+ temp0 temp1)
							)
						)
						0
					)
					(= temp0 0)
				)
				(gEgo
					setLoop: (if register 0 else 1)
					moveSpeed: temp0
					xStep:
						(if register
							(if (== (openingScript state:) 3) 4 else 3)
						else
							2
						)
					setCel: 0
					setMotion: MoveTo 319 186
					setCycle: End self
				)
			)
			(1
				(if register
					(if (< local1 0)
						(= local1 (= local2 0))
						(gEgo moveSpeed: 4)
					)
					(++ local1)
				else
					(if (> local1 0)
						(= local1 (= local2 0))
						(gEgo moveSpeed: 4)
					)
					(-- local1)
				)
				(+= local2 10)
				(cond
					((not (= temp2 (gCurRoom script:)))
						(gCurRoom setScript: glider)
					)
					((and (== temp2 openingScript) (== (temp2 state:) 0))
						(openingScript cue:)
					)
				)
				(gEgo setLoop: 2 setCycle: Fwd setScript: 0)
			)
		)
	)
)

(instance glider of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 16)
			)
			(1
				(if (not (mod (-- local2) 10))
					(if (> local1 0)
						(-- local1)
						(gEgo
							moveSpeed: (Min (+ (gEgo moveSpeed:) 1) 4)
						)
					else
						(= local1 0)
						(gEgo moveSpeed: 4)
					)
				)
				(if (not local1)
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance spotLight of Script
	(properties)

	(method (doit)
		(if
			(or
				(and (not state) (> (gEgo x:) 140))
				(and (> (gEgo x:) 315) (not (gCast contains: launch)))
			)
			(self cue:)
			(launchSound fade: 100 25 10 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(if (not local5)
					(= local5 1)
					(gMessager say: 11 0 2 0 self) ; "He is right behind you! Faster!"
				else
					(self cue:)
				)
			)
			(2
				(spot view: (gCurRoom curPic:) setCycle: End self)
			)
			(3
				(spot setCycle: Beg)
			)
			(4
				(launch init:)
				(splash init:)
				(= state 0)
				(spot dispose:)
			)
		)
	)
)

(instance crashAndSpin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKeyDownHandler delete: water)
				(gMouseDownHandler delete: water)
				(gDirectionHandler delete: water)
				(gWalkHandler delete: water)
				(water dispose:)
				(paquitaEyes dispose:)
				(paquitaFeat dispose:)
				(boatFeat dispose:)
				(Load rsVIEW 16)
				(gEgo
					setLoop: 1
					setCycle: Fwd
					cycleSpeed: 4
					moveSpeed: 4
					setMotion: MoveTo 101 182 self
				)
			)
			(1
				(gEgo view: 16 setCycle: 0 setLoop: 2 setCel: 0)
				(paquita
					posn: (+ (gEgo x:) 35) (- (gEgo y:) 28)
					init:
					setScript: upUpAndAway
				)
				(= cycles 2)
			)
			(2
				(gEgo
					x:
						(if (< (gEgo cel:) 5)
							(+ (gEgo x:) 9)
						else
							(gEgo x:)
						)
					setCel: (+ (gEgo cel:) 1)
				)
				(= ticks 10)
			)
			(3
				(if (== (gEgo cel:) 3)
					(gGameSound2 stop:)
					(spareSound number: 590 loop: 1 play: 127)
				)
				(if (< (gEgo cel:) 6)
					(-= state 2)
				)
				(self cue:)
			)
			(4
				((= register (Actor new:))
					view: (gEgo view:)
					setLoop: (gEgo loop:)
					setCel: (gEgo cel:)
					setPri: 12
					x: (gEgo x:)
					y: (gEgo y:)
					init:
					setCycle: End self
				)
				(gEgo
					posn: 158 158
					setLoop: 3
					setCel: 0
					setPri: 13
					setCycle: CT 4 1 self
				)
			)
			(5
				(spareSound number: 869 loop: 1 play:)
				(= ticks (gEgo cycleSpeed:))
			)
			(6
				(gEgo setCycle: End self)
				(register
					setStep: 6 4
					setPri: 15
					setMotion: MoveTo (+ (register x:) 30) (+ (register y:) 50)
				)
			)
			(7
				(front setPri: 14)
				(gEgo
					view: 591
					posn: 232 180
					setLoop: 4
					setCel: 0
					setStep: 6 4
					setSpeed: 1
					setCycle: Fwd
					setMotion:
						DPath
						239
						178
						258
						177
						278
						178
						295
						181
						297
						188
						278
						189
						262
						191
						246
						189
						234
						183
						252
						181
						267
						184
						277
						188
						265
						192
						253
						195
						244
						193
						246
						192
						254
						197
						258
						204
						258
						212
						self
				)
			)
			(8
				((paquita script:) cue:)
				(self dispose:)
			)
		)
	)
)

(instance upUpAndAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client
					view: 50
					setLoop: 6
					setCel: 0
					scaleX: 110
					scaleY: 110
					scaleSignal: 5
					setStep: 6 4
					posn: (+ (client x:) 42) (+ (client y:) 29)
					setSpeed: 3
					setCycle: Fwd
					setMotion: MoveTo 225 120
				)
			)
			(2
				(gMessager say: 11 0 3 0 self) ; "Oh, Adam! Wait! I will save you!"
			)
			(3
				(client setLoop: 4 setMotion: MoveTo 245 153 self)
			)
			(4
				(spareSound number: 592 loop: 1 play:)
				(client
					view: 16
					posn: 238 156
					setLoop: 5
					setCel: 0
					setPri: 13
					scaleX: 128
					scaleY: 128
					setScale:
					cycleSpeed: 10
					setCycle: CT 5 1 self
				)
			)
			(5
				(client cycleSpeed: 5 setCycle: End self)
			)
			(6
				(gTheIconBar curInvIcon: 0)
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance egoActions of Actions ; UNUSED
	(properties)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4 2) ; Look, Do, Talk
			(gMessager say: 14 theVerb)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance paquitaPrint of Narrator
	(properties
		keepWindow 1
		back 56
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

