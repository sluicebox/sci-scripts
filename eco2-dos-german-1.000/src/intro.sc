;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use MCyc)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	intro 0
)

(local
	[local0 47] = [0 0 128 62 1 0 129 62 2 0 160 103 -3599 104 3 0 205 105 4 0 238 117 -3856 91 -3599 128 1 0 270 117 2 0 295 115 -3599 106 3 0 310 107 -3599 160 13 0 325 99 -32768]
	[local47 77] = [0 0 128 62 1 0 129 62 2 0 160 103 -3599 104 3 0 205 105 4 0 238 117 -3856 91 -3599 128 1 0 270 117 2 0 295 115 -3599 106 3 0 310 107 -3599 89 4 0 312 102 5 0 273 95 6 0 265 85 7 0 265 79 -3599 81 8 0 250 73 -3599 21 7 0 247 69 -3599 18 6 0 242 68 -32768]
	local124
	local125
	local126 = 20
	local127
	local128
	local129
	local130
	[local131 3]
	local134
	local135
	local136
	[local137 5]
	local142
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(cond
		(param1
			(if (> local142 3)
				(= local142 0)
			else
				(++ local142)
			)
		)
		((< local142 1)
			(= local142 4)
		)
		(else
			(-- local142)
		)
	)
	(= temp0 (+ ([local137 local142] nsLeft:) (/ local135 2)))
	(= temp1 (+ ([local137 local142] nsTop:) (/ local136 2)))
	(SetCursor temp0 temp1)
)

(instance intro of Rm
	(properties
		picture 60
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 92 98 95)
		(super init: &rest)
		(gTheIconBar disable:)
		(gTheIconBar curIcon: (gTheIconBar at: 0))
		(gUser canInput: 1)
		(gGame setCursor: 996)
		(self setScript: startupScr)
	)

	(method (handleEvent event)
		(if local134
			(event claimed: 1)
		)
		(if
			(and
				local134
				(or
					(and (& (event type:) evMOUSEBUTTON) (not (event modifiers:)))
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(self setScript: quitScr)
		)
		(event claimed:)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(if (!= (gGameSound1 prevSignal:) -1)
			(gGameSound1 stop:)
		)
		(if (!= (gGameSound2 prevSignal:) -1)
			(gGameSound2 stop:)
		)
		(if (!= (theSound3 prevSignal:) -1)
			(theSound3 stop: dispose:)
		)
		(super dispose:)
	)
)

(instance startupScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gear1Glint init:)
				(gear2Glint init:)
				(gear3Glint init:)
				(logoGlint init:)
				(gGameSound1 number: 1 loop: 1 play:)
				(= cycles 2)
			)
			(1
				(gear1Glint setCycle: End self)
			)
			(2
				(= ticks 10)
			)
			(3
				(gear2Glint setCycle: End self)
			)
			(4
				(= ticks 20)
			)
			(5
				(gear3Glint setCycle: End self)
			)
			(6
				(= ticks 20)
			)
			(7
				(logoGlint setCycle: End self)
			)
			(8
				(if (!= (gGameSound1 prevSignal:) -1)
					(-- state)
				)
				(= cycles 4)
			)
			(9
				(= ticks 40)
			)
			(10
				(gear1Glint dispose: delete:)
				(gear2Glint dispose: delete:)
				(gear3Glint dispose: delete:)
				(logoGlint dispose: delete:)
				(gCurRoom drawPic: 20)
				(gGameSound1 number: 30 loop: -1 play:)
				(= ticks 100)
			)
			(11
				(credits init: x: (proc0_13 12 50 6 50 50))
				(= ticks 400)
			)
			(12
				(credits dispose:)
				(= cycles 2)
			)
			(13
				(gGameSound1 fade: 70 5 5 0)
				(gGame setCursor: 999)
				(cPanel init:)
				(= local142 1)
				(localproc_0 0)
			)
		)
	)
)

(instance creditsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gTheIconBar disable:)
				(gMouseDownHandler add: gCurRoom)
				(gKeyDownHandler add: gCurRoom)
				(User canInput: 1)
				(= local134 1)
				(gGame setCursor: 996)
				(gGameSound1 fade: 127 5 5 0)
				(= ticks 300)
			)
			(2
				(gGameSound2 number: 40 loop: -1 play: 1 fade: 127 5 5 0)
				(smallPlane init:)
				(= ticks 120)
			)
			(3
				(credits init: x: (proc0_13 12 50 6 50 50))
				(earth init: setCycle: Fwd)
				(= ticks 320)
			)
			(4
				(credits dispose:)
				(earth dispose:)
				(= ticks 120)
			)
			(5
				(credits view: 93 loop: 0)
				(self setScript: showCredit self 0)
			)
			(6
				(= cycles 2)
			)
			(7
				(self setScript: showCredit self 1)
			)
			(8
				(smallPlane script: 0 setCycle: 0)
				(gGameSound2 fade: 70 5 5 0)
				(detonatorInset init:)
				(detonatorArm init:)
				(= ticks 80)
			)
			(9
				(theSound3 number: 290 loop: 1 play:)
				(detonatorArm setCycle: End self)
			)
			(10
				(= ticks 60)
			)
			(11
				(gGameSound2 fade: 127 5 5 0)
				(detonatorInset dispose:)
				(detonatorArm dispose:)
				(smallPlane script: planeMotionScr setCycle: Fwd)
				(= cycles 2)
			)
			(12
				(= ticks 30)
			)
			(13
				(theSound3 number: 90 loop: 1 play: self)
				(mushroomCloud init: setCycle: End self)
			)
			(14 0)
			(15
				(= cycles 2)
			)
			(16
				(theSound3 dispose:)
				(mushroomCloud dispose:)
				(= cycles 2)
			)
			(17
				(gMessager say: 0 0 1 0 self 40) ; "Did you see that flash of light?"
			)
			(18
				(= ticks 30)
			)
			(19
				(self setScript: showCredit self 2)
			)
			(20
				(= cycles 2)
			)
			(21
				(self setScript: showCredit self 3)
			)
			(22
				(= cycles 2)
			)
			(23
				(self setScript: showCredit self 4)
			)
			(24
				(gGameSound1 fade:)
				(= ticks 60)
			)
			(25
				(gGameSound1 number: 95 loop: -1 play:)
				(gGameSound2 fade: 70 8 5 0)
				(thePlane script: 0)
				(gMessager say: 0 0 2 0 self) ; "I felt the earth shake! Then I found the seedling bent over. What shall we do?"
			)
			(26
				(gGameSound2 fade: 127 5 7 0)
				(= ticks 30)
			)
			(27
				(thePlane script: planeMotionScr)
				(= ticks 60)
			)
			(28
				(gGameSound1 fade:)
				(= cycles 2)
			)
			(29
				(if (smallPlane script:)
					((smallPlane script:) caller: self)
				else
					(= cycles 2)
				)
			)
			(30
				(gGameSound2 fade: 50 8 5 0)
				(smallPlane dispose:)
				(self setScript: plane1Scr self)
			)
			(31
				(gGameSound1 number: 30 play: 0 fade: 127 5 5 0)
				(= cycles 2)
			)
			(32
				(credits loop: 1)
				(self setScript: showCredit self 0)
			)
			(33
				(= cycles 2)
			)
			(34
				(self setScript: showCredit self 1)
			)
			(35
				(= cycles 2)
			)
			(36
				(credits loop: 2)
				(self setScript: showCredit self 0)
			)
			(37
				(= cycles 2)
			)
			(38
				(credits view: 9301 loop: 3)
				(self setScript: showCreditTwoColumns self 1)
			)
			(39
				(credits loop: 4)
				(self setScript: showCreditRetainTitle self 1)
			)
			(40
				(credits loop: 5)
				(self setScript: showCreditStackThree self 1)
			)
			(41
				(credits view: 9302 loop: 6)
				(self setScript: showCreditTwoColumns self 1)
			)
			(42
				(= cycles 2)
			)
			(43
				(credits loop: 7)
				(self setScript: showCreditTwoColumns self 1)
			)
			(44
				(credits loop: 8)
				(self setScript: showCreditStackThree self)
			)
			(45
				(= cycles 2)
			)
			(46
				(credits view: 9303 loop: 9)
				(self setScript: showCreditStackThree self)
			)
			(47
				(= cycles 2)
			)
			(48
				(credits loop: 10)
				(self setScript: showCreditRetainTitle self 1)
			)
			(49
				(= cycles 2)
			)
			(50
				(credits loop: 11)
				(self setScript: showCreditRetainTitle self 1)
			)
			(51
				(= cycles 2)
			)
			(52
				(credits loop: 12)
				(self setScript: showCreditStackThree self 1)
			)
			(53
				(= cycles 2)
			)
			(54
				(credits view: 9304 loop: 0)
				(self setScript: showCredit self 0)
			)
			(55
				(= cycles 2)
			)
			(56
				(credits loop: 1)
				(self setScript: showCredit self 0)
			)
			(57
				(= cycles 2)
			)
			(58
				(credits loop: 2)
				(self setScript: showCredit self 0)
			)
			(59
				(= cycles 2)
			)
			(60
				(credits loop: 3)
				(self setScript: showCredit self 0)
			)
			(61
				(gGameSound1 client: self fade:)
			)
			(62
				(self setScript: plane2Scr self)
			)
			(63
				(= ticks 180)
			)
			(64
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(class MyMoveCycle of MCyc
	(properties)

	(method (nextCel &tmp temp0 temp1)
		(cond
			((== (= temp0 (WordAt points value)) -3856)
				(client view: (WordAt points (+ value 1)))
				(+= value (* cycleDir 2))
				(self nextCel:)
				(return)
			)
			((== temp0 -3599)
				(= temp1 (WordAt points (+ value 1)))
				(+= value (* cycleDir 2))
				(client scaleX: temp1 scaleY: temp1)
				(self nextCel:)
				(return)
			)
		)
		(if (> local124 1)
			(client cycleSpeed: (+ (client cycleSpeed:) 1))
		else
			(++ local124)
		)
		(client
			loop: temp0
			cel: (WordAt points (+ value 1))
			x: (WordAt points (+ value 2))
			y: (WordAt points (+ value 3))
		)
		(+= value (* cycleDir 4))
		(if
			(or
				(and (== cycleDir 1) (>= value size))
				(and (== cycleDir -1) (< value 0))
			)
			(self cycleDone:)
		)
	)
)

(instance plane1Scr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 90 91)
				(gCurRoom drawPic: 41 9)
				(Palette palSET_FROM_RESOURCE 100)
				(gGameSound1 number: 45 loop: -1 play:)
				(= ticks 120)
			)
			(1
				(gGameSound2 fade: 127 15 9 0 client self)
			)
			(2
				(= ticks 60)
			)
			(3
				(thePlane init:)
				(= cycles 2)
			)
			(4
				(gGameSound2 client: 0 fade:)
				(thePlane cycleSpeed: 2 setCycle: MyMoveCycle @local0 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(thePlane cycleSpeed: 6 setScript: planeToRightScr self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance plane2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local134 0)
				(PalVary pvINIT 41 4 64 1)
				(= ticks 240)
			)
			(1
				(PalVary pvUNINIT)
				(= local134 1)
				(gGameSound2 play: 0 fade: 127 10 12 0 client: self)
			)
			(2
				(gGameSound2 client: 0 fade: 0 10 10 1)
				(thePlane
					setLoop: -1
					scaleX: 128
					scaleY: 128
					view: 90
					loop: 0
					cel: 0
					posn: 128 62
					cycleSpeed: 2
					setCycle: MyMoveCycle @local47 self
				)
			)
			(3
				(= ticks 10)
			)
			(4
				(thePlane hide:)
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance planeToRightScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thePlane
					signal: (| (thePlane signal:) $0800)
					setCycle: End thePlane
					setStep: 1 1
					moveSpeed: 7
					setMotion: MoveTo (+ (thePlane x:) 20) (thePlane y:)
				)
				(self cue:)
			)
			(1
				(thePlane
					scaleX: (- (thePlane scaleX:) 4)
					scaleY: (- (thePlane scaleY:) 4)
				)
				(if (> (thePlane scaleX:) 20)
					(-- state)
				)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance showCredit of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0
					(/
						(-
							320
							(CelWide
								(= local129 (credits view:))
								(= local130 (credits loop:))
								register
							)
						)
						2
					)
				)
				(= temp1 (/ (- 190 (CelHigh local129 local130 register)) 2))
				(credits posn: temp0 temp1 cel: register x: init:)
				(= ticks 300)
			)
			(1
				(credits dispose:)
				(= ticks 60)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance showCreditRetainTitle of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local129 (credits view:))
				(= local130 (credits loop:))
				(= temp0 (/ (- 320 (CelWide local129 local130 0)) 2))
				(= temp1
					(/
						(-
							190
							(+
								(= temp2 (CelHigh local129 local130 0))
								(CelHigh local129 local130 1)
								10
							)
						)
						2
					)
				)
				(credits posn: temp0 temp1 init:)
				(creditsColumn1
					view: local129
					loop: local130
					cel: 1
					posn:
						(/ (- 320 (CelWide local129 local130 1)) 2)
						(+ temp2 5 temp1)
					init:
				)
				(= ticks 240)
			)
			(1
				(if register
					(= register 0)
					(self dispose:)
				else
					(creditsColumn1 dispose:)
					(= ticks 30)
				)
			)
			(2
				(creditsColumn1
					x:
						(/
							(-
								320
								(CelWide
									local129
									local130
									(+ (creditsColumn1 cel:) 1)
								)
							)
							2
						)
					cel: (+ (creditsColumn1 cel:) 1)
					init:
				)
				(= ticks 240)
			)
			(3
				(creditsColumn1 dispose:)
				(credits dispose:)
				(= ticks 60)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance showCreditTwoColumns of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(= temp0
					(CelWide
						(= local129 (credits view:))
						(= local130 (credits loop:))
						1
					)
				)
				(= temp1 (CelWide local129 local130 2))
				(= temp2
					(/
						(-
							190
							(+
								(= temp4
									(Max
										(CelHigh local129 local130 1)
										(CelHigh local129 local130 2)
									)
								)
								(CelHigh local129 local130 0)
								5
								(if register
									(+ (CelHigh local129 local130 3) 5)
								else
									0
								)
							)
						)
						2
					)
				)
				(= temp3 (/ (- 320 (+ temp0 temp1 10)) 2))
				(credits
					view: local129
					loop: local130
					cel: 0
					posn: (/ (- 320 (CelWide local129 local130 0)) 2) temp2
					init:
				)
				(creditsColumn1
					view: local129
					loop: local130
					cel: 1
					posn: temp3 (+ temp2 (CelHigh local129 local130 0) 5)
					init:
				)
				(creditsColumn2
					view: local129
					loop: local130
					cel: 2
					posn: (+ temp3 temp0 10) (creditsColumn1 y:)
					init:
				)
				(if register
					(creditsBottomRow
						view: local129
						loop: local130
						cel: 3
						posn:
							(/ (- 320 (CelWide local129 local130 3)) 2)
							(+ temp2 (CelHigh local129 local130 0) temp4 10)
						init:
					)
				)
				(= ticks 300)
			)
			(1
				(credits dispose:)
				(creditsColumn1 dispose:)
				(creditsColumn2 dispose:)
				(if register
					(creditsBottomRow dispose:)
				)
				(= ticks 60)
			)
			(2
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance showCreditStackThree of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(switch (= state newState)
			(0
				(= temp5
					(CelWide
						(= local129 (credits view:))
						(= local130 (credits loop:))
						0
					)
				)
				(= temp6 (CelWide local129 local130 1))
				(= temp7 (CelWide local129 local130 2))
				(= temp8 (CelWide local129 local130 3))
				(= temp1 (CelHigh local129 local130 0))
				(= temp2 (CelHigh local129 local130 1))
				(= temp3 (CelHigh local129 local130 2))
				(if (not register)
					(= temp4 (CelHigh local129 local130 3))
				)
				(= temp0
					(/
						(-
							190
							(+
								temp1
								temp2
								temp3
								(if (not register) temp4 else 0)
								(if (not register) 15 else 8)
							)
						)
						2
					)
				)
				(credits posn: (/ (- 320 temp5) 2) temp0 init:)
				(creditsColumn1
					view: local129
					loop: local130
					cel: 1
					posn: (/ (- 320 temp6) 2) (+ temp0 temp1 5)
					init:
				)
				(creditsColumn2
					view: local129
					loop: local130
					cel: 2
					posn: (/ (- 320 temp7) 2) (+ temp0 temp1 temp2 10)
					init:
				)
				(if (not register)
					(creditsBottomRow
						view: local129
						loop: local130
						cel: 3
						posn: (/ (- 320 temp8) 2) (+ temp0 temp1 temp2 temp3 15)
						init:
					)
				)
				(= ticks 300)
			)
			(1
				(credits dispose:)
				(creditsColumn1 dispose:)
				(creditsColumn2 dispose:)
				(if (not register)
					(creditsBottomRow dispose:)
				)
				(= ticks 60)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance credits of Prop
	(properties
		x 50
		y 50
		view 92
	)
)

(instance creditsColumn1 of Prop
	(properties
		view 92
	)
)

(instance creditsColumn2 of Prop
	(properties
		view 92
	)
)

(instance creditsBottomRow of Prop
	(properties
		view 92
	)
)

(instance detonatorInset of Actor
	(properties
		x 151
		y 4
		view 95
		loop 1
	)
)

(instance detonatorArm of Actor
	(properties
		x 230
		y 64
		view 95
	)
)

(instance planeInset of Actor ; UNUSED
	(properties
		x 24
		y 38
		view 98
		loop 1
	)
)

(instance adamMouth of Actor ; UNUSED
	(properties
		x 67
		y 91
		view 98
	)
)

(instance AdamEyes of Actor ; UNUSED
	(properties
		x 69
		y 87
		view 98
		loop 2
	)
)

(instance NoahMouth of Actor ; UNUSED
	(properties
		x 97
		y 63
		view 97
		cel 9
	)
)

(instance NoahEyes of Actor ; UNUSED
	(properties
		x 103
		y 56
		view 97
		loop 2
	)
)

(instance seedlingInset of Actor ; UNUSED
	(properties
		x 19
		y 24
		view 96
	)
)

(instance thePlane of Actor
	(properties
		x 128
		y 62
		view 90
		cycleSpeed 3
	)

	(method (cue)
		(if (and script (IsObject script))
			(script dispose:)
		)
	)

	(method (init)
		(super init: &rest)
		(self setScale:)
	)
)

(instance smallPlane of Actor
	(properties
		x -20
		y 150
		view 98
		loop 5
		signal 2048
		xStep 1
		moveSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd setScript: planeMotionScr)
	)
)

(instance planeMotionScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if local126
					(-- local126)
				)
				(if (and (not local126) (not local125) (Random 0 1))
					(= local125 (= temp0 (+ (smallPlane x:) 1)))
					(if (not local128)
						(= local128
							(if (Random 0 1)
								(= local128 1)
							else
								(= local128 -1)
							)
						)
					else
						(= local128
							(if (== local128 -1)
								(= local128 1)
							else
								(= local128 -1)
							)
						)
					)
				else
					(= temp0 (+ (smallPlane x:) 1))
				)
				(smallPlane x: temp0)
				(if local125
					(cond
						((> local127 2)
							(= local126 20)
							(= local127 0)
							(= local125 0)
						)
						((== local125 temp0)
							(smallPlane y: (+ (smallPlane y:) local128))
							(++ local127)
						)
						((== (- temp0 local125) 4)
							(smallPlane y: (+ (smallPlane y:) local128))
							(= local125 temp0)
							(++ local127)
						)
					)
				)
				(-- state)
				(if (> (smallPlane x:) 335)
					(self dispose:)
				else
					(= ticks 8)
				)
			)
		)
	)
)

(instance mushroomCloud of Prop
	(properties
		x 225
		y 161
		view 98
		loop 4
		cycleSpeed 16
	)
)

(instance earth of Prop
	(properties
		x 126
		y 58
		view 92
		loop 3
		priority 15
		signal 16
		cycleSpeed 14
	)
)

(instance gear1Glint of Prop
	(properties
		x 69
		y 68
		view 61
	)
)

(instance gear2Glint of Prop
	(properties
		x 199
		y 58
		view 61
		loop 2
	)
)

(instance logoGlint of Prop
	(properties
		x 140
		y 77
		view 61
		loop 1
	)
)

(instance gear3Glint of Actor
	(properties
		x 149
		y 154
		view 61
		loop 3
	)
)

(instance theSound3 of Sound
	(properties)
)

(instance theButton of View
	(properties
		view 94
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self hide:)
		(= local135 (CelWide view loop cel))
		(= local136 (CelHigh view loop cel))
	)

	(method (show param1)
		(= x (param1 nsLeft:))
		(= y (param1 nsTop:))
		(super show:)
		(Animate (gCast elements:) 0)
	)

	(method (hide)
		(super hide:)
		(Animate (gCast elements:) 0)
	)
)

(class CreditButton of Feature
	(properties
		y 200
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(= nsBottom (+ nsTop local136))
		(= nsRight (+ nsLeft local135))
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((event claimed:)
				(return 1)
			)
			((self onMe: event)
				(if (& evMOUSERELEASE (event type:))
					(event claimed: 1)
					(return)
				)
				(cond
					((& evMOUSEBUTTON (event type:))
						(repeat
							(= temp1 (Event new:))
							(temp1 localize:)
							(cond
								((self onMe: temp1)
									(if (& (theButton signal:) $0088)
										(theButton show: self)
									)
								)
								((not (& (theButton signal:) $0088))
									(theButton hide:)
								)
							)
							(= temp0 (& (temp1 type:) evMOUSERELEASE))
							(temp1 dispose:)
							(breakif temp0)
						)
						(if (not (& (theButton signal:) $0008))
							(theButton hide:)
							(self doVerb:)
						else
							(theButton hide:)
						)
						(event claimed: 1)
						(return)
					)
					((and (& evKEYBOARD (event type:)) (== (event message:) KEY_RETURN))
						(theButton show: self)
						(theButton hide:)
						(self doVerb:)
						(event claimed: 1)
						(return)
					)
					(else
						(return 0)
					)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance theCredits of CreditButton
	(properties
		nsTop 52
		nsLeft 209
	)

	(method (doVerb)
		(cPanel dispose:)
		(gCurRoom setScript: creditsScr)
	)
)

(instance playIt of CreditButton
	(properties
		nsTop 68
		nsLeft 209
	)

	(method (doVerb)
		(gCurRoom newRoom: 100)
	)
)

(instance restoreIt of CreditButton
	(properties
		nsTop 84
		nsLeft 209
	)

	(method (doVerb)
		(gGame restore:)
	)
)

(instance instructions of CreditButton
	(properties
		nsTop 100
		nsLeft 209
	)

	(method (doVerb)
		(gMessager say: 0 0 0 0 0 12) ; "SALES ORDER INFORMATION  To place a domestic order with Sierra On-Line, call (800) 326-6654 from 7:00 a.m. through 7:00 p.m. Pacific Time, Monday through Friday, for convenient, person-to-person service, or if you prefer, you may place your order via Fax (209) 683-4297 (Please include your name, address, phone number, credit card number and expiration date)."
	)
)

(instance quitIt of CreditButton
	(properties
		nsTop 116
		nsLeft 209
	)

	(method (doVerb)
		(= gQuit 1)
	)
)

(instance cPanel of View
	(properties
		x 92
		y 37
		view 94
	)

	(method (init)
		(super init: &rest)
		(theButton init:)
		(= [local137 0] (theCredits init: yourself:))
		(= [local137 1] (playIt init: yourself:))
		(= [local137 2] (restoreIt init: yourself:))
		(= [local137 3] (instructions init: yourself:))
		(= [local137 4] (quitIt init: yourself:))
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gTheIconBar disable:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or (& (event type:) evKEYBOARD) (& (event type:) $0040)) ; direction
				(OneOf (event message:) KEY_TAB KEY_SHIFTTAB JOY_UP JOY_DOWN)
			)
			(localproc_0 (OneOf (event message:) KEY_TAB JOY_DOWN))
			(event claimed: 1)
			(return)
		)
	)

	(method (dispose &tmp temp0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			([local137 temp0] dispose:)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance quitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom newRoom: 100)
			)
		)
	)
)

