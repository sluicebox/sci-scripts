;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use ExitButton)
(use Str)
(use Inset)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	chapInset 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0 temp1)
	(depressView
		loop: param2
		cel: param3
		x: param4
		y: param5
		setPri: (+ (chapInset priority:) 1)
		show:
	)
	(FrameOut)
	(= temp1 1)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
		(temp0 localize: gThePlane)
		(cond
			((param1 onMe: temp0)
				(if (depressView z:)
					(depressView z: 0)
					(= temp1 1)
					(UpdateScreenItem depressView)
					(FrameOut)
				)
			)
			((not (depressView z:))
				(depressView z: 1000)
				(= temp1 0)
				(UpdateScreenItem depressView)
				(FrameOut)
			)
		)
		(temp0 dispose:)
		(= temp0 0)
	)
	(if temp0
		(temp0 dispose:)
	)
	(depressView z: 1000)
	(if (& (depressView -info-:) $0010)
		(UpdateScreenItem depressView)
	)
	(return temp1)
)

(instance chapInset of Inset
	(properties
		picture -2
		view 940
		x 63
		y 20
		priority 198
	)

	(method (init param1 param2 param3)
		(= local8 0)
		(= x (+ (Abs (gThePlane left:)) 63))
		(= y (+ (Abs (gThePlane top:)) 20))
		(super init: param1 param2 param3 1)
		(= local7 global124)
		((= global124 (Cast new:)) name: {inIntHotCast} add:)
		(gInventory eachElementDo: #enable 0)
		(halfMovie init: z: 1000)
		(scrollOff init: z: 1000)
		(quitButton init:)
		(volumeUp init:)
		(volumeDown init:)
		(bigMovie init:)
		(noScroll init:)
		(= local0 0)
		(= local1 0)
		(= local2 0)
		(= local3 0)
		(= local4 0)
		(= local5 0)
		(gauge doit:)
		(marker1 init:)
		(marker2 init:)
		(marker3 init:)
		(marker4 init:)
		(marker5 init:)
		(marker6 init:)
		(playButton init:)
		(depressView init: hide:)
		(self drawInset:)
	)

	(method (doVerb)
		(gGame pragmaFail:)
		(return 0)
	)

	(method (dispose &tmp temp0 temp1 temp2 temp3)
		(if (not local8)
			(= local8 1)
			(global124 release: dispose:)
			(= global124 local7)
			(gInventory eachElementDo: #enable 1)
			(super dispose:)
			(if local6
				(gNormalCursor setCycle: 0 cel: 0 init:)
				(FrameOut)
				(if (gGame smallSave:)
					((= register (View new:)) view: 983 setPri: 255)
					(register
						x:
							(+
								(Abs (gThePlane left:))
								(/
									(-
										320
										(CelWide
											(register view:)
											(register loop:)
											(register cel:)
										)
									)
									2
								)
							)
						y:
							(+
								(Abs (gThePlane top:))
								(/
									(-
										136
										(CelHigh
											(register view:)
											(register loop:)
											(register cel:)
										)
									)
									2
								)
							)
						z: 0
						init:
					)
					(= temp3 (GetTime))
					(while (< (- (GetTime) temp3) 120)
						(FrameOut)
					)
					(gSounds eachElementDo: #stop)
					(ClearFlag 1)
					(ClearFlag 21)
					(global108 release:)
					((ScriptID 0 5) client: 0 delete: dispose:) ; lavaDeathTimer
					((ScriptID 0 6) client: 0 delete: dispose:) ; scorpDeathTimer
					((ScriptID 0 7) client: 0 delete: dispose:) ; desertDeathTimer
					((ScriptID 0 8) client: 0 delete: dispose:) ; stormDeathTimer
					((ScriptID 0 9) client: 0 delete: dispose:) ; volcanoDeathTimer
					(gCurRoom newRoom: 30)
					(self dispose:)
				else
					(= temp1 (Str newWith: 50 {}))
					(= temp2 (Str newWith: 50 {}))
					(Message msgGET 0 1 8 0 4 (temp1 data:)) ; "Cannot save, disk is full. Exit the game anyway?"
					(Message msgGET 0 1 8 0 3 (temp2 data:)) ; "Information"
					(if
						(==
							(= temp0
								(MessageBox (temp1 data:) (temp2 data:) 52)
							)
							6
						)
						(gSounds eachElementDo: #stop)
						(ClearFlag 1)
						(ClearFlag 21)
						(global108 release:)
						(gCurRoom newRoom: 30)
					)
					(temp1 dispose:)
					(temp2 dispose:)
					(self dispose:)
				)
				(gUser input: 0 controls: 0)
			)
		)
	)
)

(instance depressView of View
	(properties
		view 940
	)
)

(instance quitButton of Feature
	(properties
		nsLeft 140
		nsTop 77
		nsRight 167
		nsBottom 88
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb)
		(if (localproc_0 self 3 1 140 76)
			(= local6 1)
			(chapInset dispose:)
		)
	)
)

(instance playButton of Feature
	(properties
		nsLeft 30
		nsTop 76
		nsRight 55
		nsBottom 86
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb)
		(if (localproc_0 self 3 0 28 76)
			(= local6 0)
			(chapInset dispose:)
		)
	)
)

(instance volumeDown of Feature
	(properties
		nsLeft 94
		nsTop 95
		nsRight 104
		nsBottom 101
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb &tmp temp0 [temp1 2])
		(if (localproc_0 self 2 1 92 87)
			(if (< (= temp0 (- (= temp0 (gGame masterVolume:)) 1)) 0)
				(= temp0 0)
			)
			(DoAudio audVOLUME (* temp0 9))
			(gGame masterVolume: temp0)
			(testMusic play:)
		)
	)
)

(instance volumeUp of Feature
	(properties
		nsLeft 94
		nsTop 86
		nsRight 104
		nsBottom 94
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb &tmp temp0 [temp1 2])
		(if (localproc_0 self 2 0 92 87)
			(if (> (= temp0 (+ (= temp0 (gGame masterVolume:)) 1)) 15)
				(= temp0 15)
			)
			(DoAudio audVOLUME (* temp0 9))
			(gGame masterVolume: temp0)
			(testMusic play:)
		)
	)
)

(instance halfMovie of View
	(properties
		x 83
		y 55
		priority 199
		fixPriority 1
		view 940
		loop 4
	)
)

(instance scrollOff of View
	(properties
		x 161
		y 55
		priority 199
		fixPriority 1
		view 940
		loop 4
		cel 1
	)
)

(instance bigMovie of Feature
	(properties
		nsLeft 85
		nsTop 57
		nsRight 98
		nsBottom 64
		y 60
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 538))
			(halfMovie z: 0)
		)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb)
		(if (IsFlag 538)
			(halfMovie z: 0)
			(ClearFlag 538)
		else
			(halfMovie z: 1000)
			(SetFlag 538)
		)
	)
)

(instance noScroll of Feature
	(properties
		nsLeft 162
		nsTop 57
		nsRight 177
		nsBottom 64
		y 60
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 97))
			(scrollOff z: 0)
		)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb &tmp temp0)
		(= temp0 (ScriptID 16 1)) ; scroller
		(if (IsFlag 97)
			(scrollOff z: 0)
			(ClearFlag 97)
			(if (global108 contains: temp0)
				(temp0 hide:)
			)
		else
			(scrollOff z: 1000)
			(SetFlag 97)
			(if (and (not (IsFlag 552)) (global108 contains: temp0))
				(temp0 show:)
			)
		)
	)
)

(instance marker1 of View
	(properties
		x 45
		y 39
		view 940
		loop 1
	)

	(method (init)
		(super init: &rest)
		(cond
			((== local0 0)
				(self setInsetRect: 0 0 1 7)
			)
			((!= local0 100)
				(self setInsetRect: 0 0 local0 7)
			)
		)
	)
)

(instance marker2 of View
	(properties
		x 62
		y 39
		view 940
		loop 1
	)

	(method (init)
		(if (!= local1 0)
			(super init: &rest)
			(if (!= local1 100)
				(self setInsetRect: 0 0 local1 7)
			)
		)
	)
)

(instance marker3 of View
	(properties
		x 79
		y 39
		view 940
		loop 1
	)

	(method (init)
		(if (!= local2 0)
			(super init: &rest)
			(if (!= local2 100)
				(self setInsetRect: 0 0 local2 7)
			)
		)
	)
)

(instance marker4 of View
	(properties
		x 96
		y 39
		view 940
		loop 1
	)

	(method (init)
		(if (!= local3 0)
			(super init: &rest)
			(if (!= local3 100)
				(self setInsetRect: 0 0 local3 7)
			)
		)
	)
)

(instance marker5 of View
	(properties
		x 113
		y 39
		view 940
		loop 1
	)

	(method (init)
		(if (!= local4 0)
			(super init: &rest)
			(if (!= local4 100)
				(self setInsetRect: 0 0 local4 7)
			)
		)
	)
)

(instance marker6 of View
	(properties
		x 130
		y 39
		view 940
		loop 1
	)

	(method (init)
		(if (!= local5 0)
			(super init: &rest)
			(if (!= local5 100)
				(self setInsetRect: 0 0 local5 7)
			)
		)
	)
)

(instance testMusic of Sound
	(properties
		flags 1
		number 910
	)
)

(instance gauge of Code
	(properties)

	(method (doit)
		(if (or (IsFlag 260) (> gChapter 1))
			(= local0 100)
		else
			(= local0 0)
			(if (IsFlag 32)
				(++ local0)
			)
			(if (IsFlag 6)
				(++ local0)
			)
			(if (IsFlag 13)
				(++ local0)
			)
			(if (IsFlag 14)
				(++ local0)
			)
			(if (IsFlag 15)
				(++ local0)
			)
			(if (IsFlag 49)
				(++ local0)
			)
			(if (IsFlag 28)
				(++ local0)
			)
			(if (IsFlag 36)
				(++ local0)
			)
			(= local0 (/ (* local0 16) 8))
		)
		(if (== gChapter 1)
			(return)
		)
		(if (or (IsFlag 261) (> gChapter 2))
			(= local1 100)
		else
			(= local1 0)
			(if (IsFlag 51)
				(++ local1)
			)
			(if (IsFlag 52)
				(++ local1)
			)
			(if (IsFlag 53)
				(++ local1)
			)
			(if (IsFlag 54)
				(++ local1)
			)
			(if (IsFlag 55)
				(++ local1)
			)
			(if (IsFlag 56)
				(++ local1)
			)
			(if (IsFlag 57)
				(++ local1)
			)
			(if (IsFlag 59)
				(++ local1)
			)
			(if (IsFlag 60)
				(++ local1)
			)
			(if (IsFlag 61)
				(++ local1)
			)
			(if (IsFlag 62)
				(++ local1)
			)
			(if (IsFlag 63)
				(++ local1)
			)
			(if (IsFlag 64)
				(++ local1)
			)
			(if (IsFlag 65)
				(++ local1)
			)
			(if (IsFlag 67)
				(++ local1)
			)
			(if (IsFlag 70)
				(++ local1)
			)
			(if (IsFlag 72)
				(++ local1)
			)
			(if (IsFlag 73)
				(++ local1)
			)
			(if (IsFlag 76)
				(++ local1)
			)
			(if (IsFlag 80)
				(++ local1)
			)
			(if (IsFlag 85)
				(++ local1)
			)
			(if (IsFlag 86)
				(++ local1)
			)
			(if (IsFlag 87)
				(++ local1)
			)
			(if (IsFlag 88)
				(++ local1)
			)
			(if (IsFlag 89)
				(++ local1)
			)
			(if (IsFlag 90)
				(++ local1)
			)
			(= local1 (/ (* local1 16) 25))
		)
		(if (== gChapter 2)
			(return)
		)
		(if (or (IsFlag 262) (> gChapter 3))
			(= local2 100)
		else
			(= local2 0)
			(if (IsFlag 127)
				(++ local2)
			)
			(if (IsFlag 100)
				(++ local2)
			)
			(if (IsFlag 101)
				(++ local2)
			)
			(if (IsFlag 109)
				(++ local2)
			)
			(if (IsFlag 123)
				(++ local2)
			)
			(if (IsFlag 122)
				(++ local2)
			)
			(if (IsFlag 125)
				(++ local2)
			)
			(if (== ((gInventory at: 39) owner:) -4) ; Crook
				(++ local2)
			)
			(= local2 (/ (* local2 16) 8))
		)
		(if (== gChapter 3)
			(return)
		)
		(if (or (IsFlag 263) (> gChapter 4))
			(= local3 100)
		else
			(= local3 0)
			(if (IsFlag 152)
				(++ local3)
			)
			(if (IsFlag 451)
				(++ local3)
			)
			(if (IsFlag 155)
				(++ local3)
			)
			(if (IsFlag 156)
				(++ local3)
			)
			(if (IsFlag 157)
				(++ local3)
			)
			(if (IsFlag 159)
				(++ local3)
			)
			(if (IsFlag 160)
				(++ local3)
			)
			(if (IsFlag 161)
				(++ local3)
			)
			(if (IsFlag 165)
				(++ local3)
			)
			(if (IsFlag 166)
				(++ local3)
			)
			(if (IsFlag 167)
				(++ local3)
			)
			(if (IsFlag 168)
				(++ local3)
			)
			(if (IsFlag 169)
				(++ local3)
			)
			(if (IsFlag 171)
				(++ local3)
			)
			(if (IsFlag 172)
				(++ local3)
			)
			(if (IsFlag 173)
				(++ local3)
			)
			(if (IsFlag 180)
				(++ local3)
			)
			(if (IsFlag 181)
				(++ local3)
			)
			(if (IsFlag 182)
				(++ local3)
			)
			(if (IsFlag 183)
				(++ local3)
			)
			(if (IsFlag 189)
				(++ local3)
			)
			(if (IsFlag 191)
				(++ local3)
			)
			(= local3 (/ (* local3 16) 22))
		)
		(if (== gChapter 4)
			(return)
		)
		(if (or (IsFlag 264) (> gChapter 5))
			(= local4 100)
		else
			(= local4 0)
			(if (IsFlag 202)
				(++ local4)
			)
			(if (IsFlag 203)
				(++ local4)
			)
			(if (IsFlag 204)
				(++ local4)
			)
			(if (IsFlag 205)
				(++ local4)
			)
			(if (IsFlag 206)
				(++ local4)
			)
			(if (IsFlag 207)
				(++ local4)
			)
			(if (IsFlag 208)
				(++ local4)
			)
			(if (IsFlag 209)
				(++ local4)
			)
			(if (IsFlag 210)
				(++ local4)
			)
			(if (IsFlag 568)
				(++ local4)
			)
			(if (IsFlag 213)
				(++ local4)
			)
			(if (IsFlag 214)
				(++ local4)
			)
			(if ((gInventory at: 72) ownedBy: 4000) ; Femur
				(++ local4)
			)
			(if (IsFlag 218)
				(++ local4)
			)
			(if (IsFlag 219)
				(++ local4)
			)
			(if (IsFlag 220)
				(++ local4)
			)
			(if (IsFlag 222)
				(++ local4)
			)
			(if (IsFlag 223)
				(++ local4)
			)
			(if (IsFlag 224)
				(++ local4)
			)
			(if (IsFlag 227)
				(++ local4)
			)
			(= local4 (/ (* local4 16) 19))
		)
		(if (== gChapter 5)
			(return)
		)
		(if (IsFlag 265)
			(= local5 100)
		else
			(= local5 0)
			(if (IsFlag 251)
				(++ local5)
			)
			(if (IsFlag 252)
				(++ local5)
			)
			(if (IsFlag 256)
				(++ local5)
			)
			(if (IsFlag 257)
				(++ local5)
			)
			(if (IsFlag 258)
				(++ local5)
			)
			(if (IsFlag 259)
				(++ local5)
			)
			(= local5 (/ (* local5 16) 6))
		)
	)
)

