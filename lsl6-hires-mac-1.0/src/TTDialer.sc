;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryTalker)
(use Str)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Actor)
(use System)

(public
	TTDialer 0
	unknown_610_15 1
	proc610_2 2
	proc610_3 3
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 14] = [0 1 -16 1 19 -16 1 19 -16 1 19 -16 19 -1]
	[local20 20] = [0 -15 -69 -69 -69 -52 -52 -52 -34 -34 -34 -15 -15 -3 551 552 553 554 555 556]
	local40
	local41
	local42
	local43
	[local44 69] = [96 1 5 75 2 12 98 3 20 74 4 28 73 5 36 72 6 45 71 7 49 94 8 69 93 9 85 92 10 100 76 11 60 90 12 85 89 8 69 18724 13 100 23292 14 100 58704 15 103 40942 15 103 8837 15 103 34555 16 100 47653 17 100 16659 18 100 275 19 100 49852 20 100]
	local113 = 68
)

(procedure (proc610_2)
	(if (unknown_610_15 name:)
		((unknown_610_15 name:) dispose:)
		(unknown_610_15 name: 0)
	)
	(if local2
		(local2 dispose:)
		(= local2 0)
	)
)

(procedure (proc610_3 param1 &tmp temp0 temp1)
	(= temp1 param1)
	(= local4 (Str new: 30))
	(if (IsFlag 57)
		(= temp1 71)
	)
	(for ((= temp0 0)) (<= temp0 local113) ((+= temp0 3))
		(if (== temp1 [local44 temp0])
			(Message msgGET 610 1 0 1 [local44 (+ temp0 1)] (local4 data:))
			(= local3 (Str copy: local4))
			(unknown_610_15 showTitle: 1 name: local3)
		)
	)
	(local4 dispose:)
	(= local4 0)
)

(class cObj of Obj
	(properties)
)

(instance TTDialer of Prop
	(properties
		x 217
		y 118
		priority 189
		fixPriority 1
		view 610
	)

	(method (init param1)
		(proc79_11 10 11 12 13 14 15 16 17 18 19 20 21 22)
		(roomFeat init:)
		(= local41 param1)
		(= local2 (Str new:))
		(= global166 (ScriptID 0 5)) ; icon2
		(gGame handsOn:)
		(gUser canControl: 0 canInput: 1)
		(gTheIconBar
			disableIcon:
				(ScriptID 0 3) ; icon0
				(ScriptID 0 6) ; icon3
				(ScriptID 0 4) ; icon1
				(ScriptID 0 7) ; icon4
				(ScriptID 0 9) ; icon6
			show:
		)
		((ScriptID 0 11) init: exitCue) ; iconExit
		(dialTone number: 22 loop: -1 flags: -1 play:)
		(super init:)
		(btn0 init:)
		(btn1 init:)
		(btn2 init:)
		(btn3 init:)
		(btn4 init:)
		(btn5 init:)
		(btn6 init:)
		(btn7 init:)
		(btn8 init:)
		(btn9 init:)
		(btnStar init:)
		(btnCross init:)
		(hangUp init:)
	)

	(method (dispose &tmp temp0)
		(roomFeat dispose:)
		(gGame handsOff:)
		(if (not local42)
			(= local42 (local2 asInteger:))
		)
		(if (not (unknown_610_15 name:))
			(proc610_3 local42)
		)
		(btn0 hide:)
		(btn1 hide:)
		(btn2 hide:)
		(btn3 hide:)
		(btn4 hide:)
		(btn5 hide:)
		(btn6 hide:)
		(btn7 hide:)
		(btn8 hide:)
		(btn9 hide:)
		(btnStar hide:)
		(btnCross hide:)
		(hangUp hide:)
		(= local5 254)
		(self hide:)
		(hangUpTimer setCycle: self 2)
	)

	(method (cue param1 param2 &tmp temp0)
		(if (!= local5 254)
			((param2 script:) dispose:)
			(param2 script: 0)
		)
		(switch (++ local5)
			(1
				(= temp0 (local2 asInteger:))
				(cond
					((== param1 (btnCross keyValue:))
						(= local42 -2)
					)
					((== param1 (btnStar keyValue:))
						(= local42 -3)
					)
					((or (IsFlag 97) (IsFlag 57))
						(= local42 temp0)
					)
					((or (== temp0 8) (== temp0 1))
						(= local43 93)
						(local2 dispose:)
						(= local2 0)
					)
					((not temp0)
						(= local42 91)
					)
					((== temp0 9)
						(= local43 92)
					)
				)
				(if (or (== local42 91) (IsFlag 97) (IsFlag 57))
					(self dispose:)
				)
			)
			(2
				(cond
					((OneOf (local2 asInteger:) 72 73 74 75 76)
						(self dispose:)
					)
					((== (local2 asInteger:) 71)
						(SetFlag 57)
						(self dispose:)
					)
				)
			)
			(3
				(switch (local2 asInteger:)
					(411
						(= local42 96)
						(self dispose:)
					)
					(911
						(= local42 98)
						(self dispose:)
					)
					(976
						(= local43 94)
					)
					(209
						(= local43 209)
					)
					(805
						(= local43 805)
					)
				)
			)
			(4
				(cond
					((== (local2 asInteger:) 1900)
						(= local43 89)
					)
					((== (local2 asInteger:) 1800)
						(= local43 90)
					)
					((== (local2 asInteger:) 1209)
						(= local43 88)
						(local2 dispose:)
						(= local2 0)
					)
					((== (local2 asInteger:) 1805)
						(= local43 87)
						(local2 dispose:)
						(= local2 0)
					)
				)
			)
			(5 0)
			(6 0)
			(7
				(cond
					((== local43 93)
						(= local42 (local2 asInteger:))
						(self dispose:)
					)
					(local43
						(= local42 local43)
					)
					(else
						(= local42 (local2 asInteger:))
					)
				)
				(if (not (OneOf local43 209 805 93 87 88 90 89))
					(self dispose:)
				)
			)
			(8 0)
			(9 0)
			(10
				(if (OneOf local43 209 805)
					(= local42 (local2 asInteger:))
					(self dispose:)
				)
			)
			(11
				(if (OneOf local42 87 88)
					(= local42 (local2 asInteger:))
				)
				(self dispose:)
			)
			(255
				(if (not local0)
					((ScriptID 0 11) dispose:) ; iconExit
				)
				(hangUpTimer dispose: delete:)
				(gGame setCursor: gWaitCursor)
				(= local43 0)
				(= local1 0)
				(= local3 0)
				(= local4 0)
				(= local5 0)
				(= local40 0)
				(= local0 0)
				(dialTone number: 0 dispose:)
				(sfx number: 0 dispose:)
				(proc79_12 10 11 12 13 14 15 16 17 18 19 20 21 22)
				(super dispose:)
				(btn0 dispose:)
				(btn1 dispose:)
				(btn2 dispose:)
				(btn3 dispose:)
				(btn4 dispose:)
				(btn5 dispose:)
				(btn6 dispose:)
				(btn7 dispose:)
				(btn8 dispose:)
				(btn9 dispose:)
				(btnStar dispose:)
				(btnCross dispose:)
				(hangUp dispose:)
				(gCurRoom notify: local42)
				(if local41
					(local41 cue:)
				)
				(= local41 0)
				(= local42 0)
			)
			(else
				(= gQuit 1)
			)
		)
	)
)

(instance hangUpTimer of Timer
	(properties)
)

(class PushButton of Prop
	(properties
		priority 190
		fixPriority 1
		view 610
		keyValue 45
		scanValue 0
		keyStr 0
		tone 0
	)

	(method (init &tmp temp0)
		(self cel: 0)
		(= x (+ (TTDialer x:) [local6 loop] 5))
		(= y (+ (TTDialer y:) [local20 loop] 1000))
		(= keyStr (Str with: {x}))
		(super init:)
	)

	(method (dispose)
		(if script
			(script dispose:)
			(= script 0)
		)
		(keyStr dispose:)
		(self keyStr: 0)
		(super dispose:)
	)

	(method (doVerb)
		(if (not (sButton client:))
			(dialTone stop:)
			(switch loop
				(13
					(= local42 -1)
				)
				(11
					(keyStr at: 1 42)
				)
				(12
					(keyStr at: 1 14848)
				)
				(else
					(keyStr format: {%d} (- loop 1))
				)
			)
			(self setScript: sButton 0 tone)
		)
	)
)

(instance btn0 of PushButton
	(properties
		z 1000
		loop 1
		keyValue 48
		scanValue 20992
		tone 10
	)
)

(instance btn1 of PushButton
	(properties
		z 1000
		loop 2
		keyValue 49
		scanValue 20224
		tone 11
	)
)

(instance btn2 of PushButton
	(properties
		z 1000
		loop 3
		keyValue 50
		scanValue 20480
		tone 12
	)
)

(instance btn3 of PushButton
	(properties
		z 1000
		loop 4
		keyValue 51
		scanValue 20736
		tone 13
	)
)

(instance btn4 of PushButton
	(properties
		z 1000
		loop 5
		keyValue 52
		scanValue 19200
		tone 14
	)
)

(instance btn5 of PushButton
	(properties
		z 1000
		loop 6
		keyValue 53
		scanValue 19456
		tone 15
	)
)

(instance btn6 of PushButton
	(properties
		z 1000
		loop 7
		keyValue 54
		scanValue 19712
		tone 16
	)
)

(instance btn7 of PushButton
	(properties
		z 1000
		loop 8
		keyValue 55
		scanValue 18176
		tone 17
	)
)

(instance btn8 of PushButton
	(properties
		z 1000
		loop 9
		keyValue 56
		scanValue 18432
		tone 18
	)
)

(instance btn9 of PushButton
	(properties
		z 1000
		loop 10
		keyValue 57
		scanValue 18688
		tone 19
	)
)

(instance btnCross of PushButton
	(properties
		z 1000
		loop 12
		keyValue 42
		tone 21
	)
)

(instance btnStar of PushButton
	(properties
		z 1000
		loop 11
		keyValue 35
		tone 20
	)
)

(instance hangUp of PushButton
	(properties
		z 1000
		loop 13
		keyValue 32
	)
)

(instance unknown_610_15 of LarryTalker
	(properties)
)

(instance dialTone of Sound
	(properties)
)

(instance sfx of Sound
	(properties)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 1)
				(UpdateScreenItem client)
				(if register
					(sfx number: register loop: 1 play: self)
				else
					(= cycles 2)
				)
			)
			(1
				(if (not local2)
					(= local2 (Str new:))
				)
				(local2 cat: (client keyStr:))
				(if
					(and
						(not local43)
						(OneOf (local2 asInteger:) 72 73 74 75 76)
					)
					(= local1 1)
				)
				(client setCel: 0)
				(UpdateScreenItem client)
				(= cycles 2)
			)
			(2
				(= register 0)
				(if (== local42 -1)
					(TTDialer dispose:)
				else
					(TTDialer cue: (client keyValue:) client)
				)
			)
		)
	)
)

(instance roomFeat of Feature
	(properties
		y 200
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 320 0 320 154 0 154 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb))
)

(instance exitCue of cObj
	(properties)

	(method (cue)
		(= local0 1)
		(= local42 -1)
		((ScriptID 0 11) dispose:) ; iconExit
		(TTDialer dispose:)
	)
)

