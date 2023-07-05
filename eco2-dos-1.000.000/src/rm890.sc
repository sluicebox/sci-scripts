;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 890)
(include sci.sh)
(use Main)
(use Scaler)
(use ROsc)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm890 0
)

(local
	[local0 5] = [0 0 20 0 0]
	local5
	local6
	[local7 3]
	local10
	local11
	local12
	[local13 5]
	local18
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(cond
		(param1
			(if (> local18 3)
				(= local18 0)
			else
				(++ local18)
			)
		)
		((< local18 1)
			(= local18 4)
		)
		(else
			(-- local18)
		)
	)
	(= temp0 (+ ([local13 local18] nsLeft:) (/ local11 2)))
	(= temp1 (+ ([local13 local18] nsTop:) (/ local12 2)))
	(SetCursor temp0 temp1)
)

(instance rm890 of Rm
	(properties
		picture 890
		style 10
	)

	(method (init)
		(super init: &rest)
		(gTheIconBar disable:)
		(gGameSound1 number: 890 loop: 1 play: 127)
		(wf0 init: setCycle: Fwd)
		(wf1 init: setCycle: Fwd)
		(wf2 init: setCycle: Fwd)
		(wf3 init: setCycle: Fwd)
		(wf4 init: setCycle: Fwd)
		(wf5 init: setCycle: Fwd)
		(wf6 init: setCycle: Fwd)
		(wf7 init: setCycle: Fwd)
		(wf8 init: setCycle: Fwd)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(gGame setCursor: 996)
		(self setScript: creditsScript)
	)

	(method (handleEvent event)
		(if
			(or
				(and
					(== (event type:) evMOUSEBUTTON)
					(not (& (event modifiers:) emSHIFT))
					(not (& (event modifiers:) emCTRL))
				)
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			)
			(self setScript: bringUpPanel)
			(event claimed: 1)
		else
			(event claimed: 0)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gGameSound1 fade:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance wf0 of Prop
	(properties
		x 264
		y 76
		view 890
		cel 2
		detailLevel 3
	)
)

(instance wf1 of Prop
	(properties
		x 217
		y 105
		view 890
		loop 1
		detailLevel 3
	)
)

(instance wf2 of Prop
	(properties
		x 193
		y 145
		view 890
		loop 2
		cel 3
		detailLevel 3
	)
)

(instance wf3 of Prop
	(properties
		x 47
		y 80
		view 890
		loop 3
		detailLevel 3
	)
)

(instance wf4 of Prop
	(properties
		x 81
		y 96
		view 890
		loop 4
		cel 3
		detailLevel 3
	)
)

(instance wf5 of Prop
	(properties
		x 62
		y 93
		view 890
		loop 5
		cel 1
		detailLevel 3
	)
)

(instance wf6 of Prop
	(properties
		x 96
		y 123
		view 890
		loop 6
		cel 3
		detailLevel 3
	)
)

(instance wf7 of Prop
	(properties
		x 136
		y 132
		view 890
		loop 7
		cel 1
		detailLevel 3
	)
)

(instance wf8 of Prop
	(properties
		x 105
		y 156
		view 890
		loop 8
		cel 3
		detailLevel 3
	)
)

(instance bringUpPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gCurRoom drawPic: 888 10)
				(gCast eachElementDo: #dispose)
				(= cycles 5)
			)
			(1
				(gGame handsOn:)
				(SetFlag 7)
				(gTheIconBar disable:)
				(gGame setCursor: 999)
				(cPanel init:)
				(= local18 1)
				(localproc_0 0)
			)
		)
	)
)

(instance egoFlying of Actor
	(properties
		x -50
		y 265
		view 891
		cel 5
		priority 14
		signal 24592
		scaleSignal 5
		illegalBits 0
		moveSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 174 1 189 8 setStep: 4 4 setCycle: Fwd)
	)
)

(instance babyBat of Actor
	(properties
		x -15
		y 124
		view 892
		loop 1
		signal 18432
		moveSpeed 2
	)
)

(instance paquita of Actor
	(properties
		x -20
		y 106
		view 892
		priority 14
		signal 18448
	)
)

(instance sBabyLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(babyBat setCycle: ROsc -1 0 1 setMotion: MoveTo 50 144 self)
			)
			(1
				(babyBat setCycle: End self)
			)
			(2
				(babyBat setLoop: 2 setCel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sPaqLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(paquita setMotion: MoveTo 28 131 self)
			)
			(1
				(paquita setCycle: End self)
			)
			(2
				(paquita setLoop: 3 setCel: 0)
				(= cycles 1)
			)
			(3
				(paquita stopUpd:)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance creditsScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(egoFlying init: setMotion: MoveTo 159 56 self)
			)
			(2
				(egoFlying setCycle: CT 0 1 self)
			)
			(3
				(egoFlying
					setScale: Scaler 100 6 58 8
					setLoop: 2
					setCel: 10
					setStep: 1 1
					setSpeed: 6
					posn: 194 58
					setCycle: Fwd
					setMotion: MoveTo 190 30 self
				)
				(babyBat init: setScript: sBabyLand self)
			)
			(4 0)
			(5
				(paquita init: setScript: sPaqLand self)
				(egoFlying setMotion: MoveTo 207 8 self)
			)
			(6
				(egoFlying dispose:)
				(paquita setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(babyBat setCycle: End self)
			)
			(8
				(= cycles 2)
			)
			(9
				(paquita stopUpd:)
				(babyBat stopUpd:)
				(UnLoad 128 891)
				(= local10 1)
				(gGame setCursor: 996)
				(Load rsVIEW 931)
				(= cycles 3)
			)
			(10
				(= ticks 300)
			)
			(11
				(credits view: 931 loop: 0)
				(self setScript: showCredit self 0)
			)
			(12
				(= cycles 2)
			)
			(13
				(self setScript: showCredit self 1)
			)
			(14
				(= cycles 2)
			)
			(15
				(self setScript: showCredit self 2)
			)
			(16
				(= cycles 2)
			)
			(17
				(self setScript: showCredit self 3)
			)
			(18
				(= cycles 2)
			)
			(19
				(self setScript: showCredit self 4)
			)
			(20
				(= cycles 2)
			)
			(21
				(credits loop: 1)
				(self setScript: showCredit self 0)
			)
			(22
				(= cycles 2)
			)
			(23
				(self setScript: showCredit self 1)
			)
			(24
				(= cycles 2)
			)
			(25
				(credits loop: 2)
				(self setScript: showCredit self 0)
			)
			(26
				(= cycles 2)
			)
			(27
				(credits view: 9311 loop: 0)
				(self setScript: showCreditTwoColumns self 1)
			)
			(28
				(= cycles 2)
			)
			(29
				(credits loop: 1)
				(self setScript: showCreditStackThree self)
			)
			(30
				(= cycles 2)
			)
			(31
				(credits loop: 2)
				(self setScript: showCreditStackThree self)
			)
			(32
				(= cycles 2)
			)
			(33
				(credits view: 9312 loop: 0)
				(self setScript: showCreditTwoColumns self 1)
			)
			(34
				(= cycles 2)
			)
			(35
				(credits loop: 1)
				(self setScript: showCreditTwoColumns self 1)
			)
			(36
				(= cycles 2)
			)
			(37
				(credits loop: 2)
				(self setScript: showCreditStackThree self)
			)
			(38
				(= cycles 2)
			)
			(39
				(credits view: 9313 loop: 0)
				(self setScript: showCreditStackThree self)
			)
			(40
				(= cycles 2)
			)
			(41
				(credits loop: 1)
				(self setScript: showCreditStackThree self)
			)
			(42
				(= cycles 2)
			)
			(43
				(credits loop: 2)
				(self setScript: showCreditStackThree self)
			)
			(44
				(= cycles 2)
			)
			(45
				(credits loop: 3)
				(self setScript: showCreditStackThree self)
			)
			(46
				(= cycles 2)
			)
			(47
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 888 10)
				(= cycles 10)
			)
			(48
				(= ticks 120)
			)
			(49
				(= temp0 (/ (- 320 (CelWide 92 0 0)) 2))
				(= temp1 (/ (- 190 (CelHigh 92 0 0)) 2))
				(credits
					view: 92
					loop: 0
					cel: 0
					posn: temp0 temp1
					init:
					setPri: 14
				)
				(= cycles 1)
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
								(= local5 (credits view:))
								(= local6 (credits loop:))
								register
							)
						)
						2
					)
				)
				(= temp1 (/ (- 190 (CelHigh local5 local6 register)) 2))
				(credits posn: temp0 temp1 cel: register x: init:)
				(= cycles 2)
			)
			(1
				(= ticks 300)
			)
			(2
				(credits dispose:)
				(= ticks 60)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance showCreditRetainTitle of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local5 (credits view:))
				(= local6 (credits loop:))
				(= temp0 (/ (- 320 (CelWide local5 local6 0)) 2))
				(= temp1
					(/
						(-
							190
							(+
								(= temp2 (CelHigh local5 local6 0))
								(CelHigh local5 local6 1)
								10
							)
						)
						2
					)
				)
				(credits posn: temp0 temp1 init:)
				(creditsColumn1
					view: local5
					loop: local6
					cel: 1
					posn:
						(/ (- 320 (CelWide local5 local6 1)) 2)
						(+ temp2 5 temp1)
					init:
				)
				(= cycles 2)
			)
			(1
				(= ticks 240)
			)
			(2
				(creditsColumn1 dispose:)
				(= ticks 30)
			)
			(3
				(creditsColumn1
					x:
						(/
							(-
								320
								(CelWide
									local5
									local6
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
			(4
				(creditsColumn1 dispose:)
				(credits dispose:)
				(= ticks 60)
			)
			(5
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
						(= local5 (credits view:))
						(= local6 (credits loop:))
						1
					)
				)
				(= temp1 (CelWide local5 local6 2))
				(= temp2
					(/
						(-
							190
							(+
								(= temp4
									(Max
										(CelHigh local5 local6 1)
										(CelHigh local5 local6 2)
									)
								)
								(CelHigh local5 local6 0)
								5
								(if register
									(+ (CelHigh local5 local6 3) 5)
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
					view: local5
					loop: local6
					cel: 0
					posn: (/ (- 320 (CelWide local5 local6 0)) 2) temp2
					init:
				)
				(creditsColumn1
					view: local5
					loop: local6
					cel: 1
					posn: temp3 (+ temp2 (CelHigh local5 local6 0) 5)
					init:
				)
				(creditsColumn2
					view: local5
					loop: local6
					cel: 2
					posn: (+ temp3 temp0 10) (creditsColumn1 y:)
					init:
				)
				(if register
					(creditsBottomRow
						view: local5
						loop: local6
						cel: 3
						posn:
							(/ (- 320 (CelWide local5 local6 3)) 2)
							(+ temp2 (CelHigh local5 local6 0) temp4 10)
						init:
					)
				)
				(= cycles 2)
			)
			(1
				(= ticks 300)
			)
			(2
				(credits dispose:)
				(creditsColumn1 dispose:)
				(creditsColumn2 dispose:)
				(if register
					(creditsBottomRow dispose:)
				)
				(= ticks 60)
			)
			(3
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
						(= local5 (credits view:))
						(= local6 (credits loop:))
						0
					)
				)
				(= temp6 (CelWide local5 local6 1))
				(= temp7 (CelWide local5 local6 2))
				(= temp8 (CelWide local5 local6 3))
				(= temp1 (CelHigh local5 local6 0))
				(= temp2 (CelHigh local5 local6 1))
				(= temp3 (CelHigh local5 local6 2))
				(= temp4 (CelHigh local5 local6 3))
				(= temp0 (/ (- 190 (+ temp1 temp2 temp3 temp4 15)) 2))
				(credits posn: (/ (- 320 temp5) 2) temp0 init:)
				(creditsColumn1
					view: local5
					loop: local6
					cel: 1
					posn: (/ (- 320 temp6) 2) (+ temp0 temp1 5)
					init:
				)
				(creditsColumn2
					view: local5
					loop: local6
					cel: 2
					posn: (/ (- 320 temp7) 2) (+ temp0 temp1 temp2 10)
					init:
				)
				(creditsBottomRow
					view: local5
					loop: local6
					cel: 3
					posn: (/ (- 320 temp8) 2) (+ temp0 temp1 temp2 temp3 15)
					init:
				)
				(= cycles 2)
			)
			(1
				(= ticks 300)
			)
			(2
				(credits dispose:)
				(creditsColumn1 dispose:)
				(creditsColumn2 dispose:)
				(creditsBottomRow dispose:)
				(= ticks 60)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance credits of Prop
	(properties
		x 50
		y 50
		view 931
		priority 14
		signal 16
	)
)

(instance creditsColumn1 of Prop
	(properties
		view 931
		priority 14
		signal 16
	)
)

(instance creditsColumn2 of Prop
	(properties
		view 931
		priority 14
		signal 16
	)
)

(instance creditsBottomRow of Prop
	(properties
		view 931
		priority 14
		signal 16
	)
)

(instance theButton of View
	(properties
		view 94
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self hide:)
		(= local11 (CelWide view loop cel))
		(= local12 (CelHigh view loop cel))
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
		(= nsBottom (+ nsTop local12))
		(= nsRight (+ nsLeft local11))
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
							(event claimed: 1)
							(self doVerb:)
							(return 0)
						else
							(theButton hide:)
							(event claimed: 1)
						)
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
		(gGame restart:)
	)
)

(instance playIt of CreditButton
	(properties
		nsTop 68
		nsLeft 209
	)

	(method (doVerb)
		(gGame restart:)
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
		(= [local13 0] (theCredits init: yourself:))
		(= [local13 1] (playIt init: yourself:))
		(= [local13 2] (restoreIt init: yourself:))
		(= [local13 3] (instructions init: yourself:))
		(= [local13 4] (quitIt init: yourself:))
		(gMouseDownHandler addToFront: self)
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
			([local13 temp0] dispose:)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

