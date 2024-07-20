;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use n079)
(use Talker)
(use Timer)
(use Sound)
(use User)
(use Actor)
(use System)

(public
	TTDialer 0
	unknown_610_16 1
	proc610_2 2
	proc610_3 3
)

(local
	[local0 100]
	local100
	[local101 14] = [0 1 -16 1 19 -16 1 19 -16 1 19 -16 19 -1]
	[local115 20] = [0 -15 -69 -69 -69 -52 -52 -52 -34 -34 -34 -15 -15 -3 551 552 553 554 555 556]
	local135
	local136
	local137
	local138
	[local139 69] = [9996 1 5 75 2 12 9998 3 20 74 4 28 73 5 36 72 6 45 71 7 49 9994 8 69 9993 9 85 9992 10 100 76 11 60 9990 12 85 9989 8 69 18724 13 100 23292 14 100 -6832 15 103 -24594 15 103 8837 15 103 -30981 16 100 -17883 17 100 16659 18 100 275 19 100 5695 20 100]
	local208 = 68
)

(procedure (proc610_3 param1 &tmp [temp0 30] temp30 temp31)
	(unknown_610_16
		x: 10
		y: 20
		talkWidth: 160
		showTitle: 0
		back: 67
		font: gUserFont
	)
	(if (IsFlag 57)
		(= param1 71)
		(unknown_610_16 x: -1 y: -1 talkWidth: 250)
	)
	(if (== param1 9994)
		(unknown_610_16 x: 10 y: 20 talkWidth: 180)
	)
	(for ((= temp31 0)) (<= temp31 local208) ((+= temp31 3))
		(if (== param1 [local139 temp31])
			(Message msgGET 610 1 0 1 [local139 (+ temp31 1)] @temp0)
			(= temp30 (Memory memALLOC_NONCRIT (+ (StrLen @temp0) 1)))
			(StrCpy temp30 @temp0)
			(unknown_610_16
				showTitle: 1
				name: temp30
				back: [local139 (+ temp31 2)]
			)
		)
	)
)

(procedure (proc610_2)
	(if (unknown_610_16 name:)
		(Memory memFREE (unknown_610_16 name:))
		(unknown_610_16 name: 0)
	)
)

(instance TTDialer of Prop
	(properties
		x 217
		y 118
		view 610
		priority 14
		signal 16
	)

	(method (init param1)
		(= local136 param1)
		(= local0 0)
		(= local100 0)
		(= local135 0)
		(gGame handsOff:)
		(User canInput: 1 mapKeyToDir: 0)
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
		(gMouseDownHandler addToEnd: self)
		(gKeyDownHandler addToEnd: self)
		(gCast eachElementDo: #stopUpd)
		(gTheIconBar enable: (ScriptID 0 5) curIcon: (ScriptID 0 5)) ; icon2, icon2
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(= local137 0)
		(= local138 0)
	)

	(method (dispose &tmp temp0)
		(= temp0 (Event new:))
		(temp0 dispose:)
		(User canInput: 0 canControl: 0)
		(if (not (unknown_610_16 name:))
			(proc610_3 local137)
		)
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
		(= local100 254)
		(self hide:)
		(hangUpTimer setCycle: self 2)
	)

	(method (handleEvent event)
		(cond
			((not (User canInput:)))
			((event modifiers:)
				(super handleEvent: event)
			)
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				(event claimed: 1)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (cue param1 &tmp temp0 temp1)
		(switch (++ local100)
			(1
				(= temp1 (ReadNumber @local0))
				(cond
					((== param1 (btnCross keyValue:))
						(= local137 -2)
					)
					((== param1 (btnStar keyValue:))
						(= local137 -3)
					)
					((or (IsFlag 97) (IsFlag 57))
						(= local137 temp1)
					)
					((not temp1)
						(= local137 9991)
					)
					((== temp1 9)
						(= local138 9992)
					)
					((== temp1 8)
						(= local138 9993)
					)
				)
				(if (or (== local137 9991) (IsFlag 97) (IsFlag 57))
					(self dispose:)
				)
			)
			(2
				(cond
					((OneOf (= local137 (ReadNumber @local0)) 72 73 74 75 76)
						(self dispose:)
					)
					((== (= local137 (ReadNumber @local0)) 71)
						(SetFlag 57)
						(self dispose:)
					)
				)
			)
			(3
				(switch (= local135 (ReadNumber @local0))
					(411
						(= local137 9996)
						(self dispose:)
					)
					(911
						(= local137 9998)
						(self dispose:)
					)
					(976
						(= local138 9994)
					)
					(209
						(= local138 209)
					)
					(805
						(= local138 805)
					)
				)
			)
			(4
				(cond
					((== (ReadNumber @local0) 1900)
						(= local138 9989)
					)
					((== (ReadNumber @local0) 1800)
						(= local138 9990)
					)
					((== (ReadNumber @local0) 1209)
						(= local138 9988)
						(= local0 0)
					)
					((== (ReadNumber @local0) 1805)
						(= local138 9987)
						(= local0 0)
					)
				)
			)
			(5 0)
			(6 0)
			(7
				(if local138
					(= local137 local138)
				else
					(= local137 (ReadNumber @local0))
				)
				(if (not (OneOf local137 805 9987 209 9988 9990 9989))
					(self dispose:)
				)
			)
			(8 0)
			(9 0)
			(10
				(if (OneOf local137 209 805)
					(= local137 (ReadNumber @local0))
					(self dispose:)
				)
			)
			(11
				(if (OneOf local137 9987 9988)
					(= local137 (ReadNumber @local0))
				)
				(self dispose:)
			)
			(255
				(User canInput: 0 mapKeyToDir: 1)
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(dialTone stop:)
				(hangUpTimer dispose: delete:)
				(gTheIconBar disable: (ScriptID 0 5)) ; icon2
				(gGame setCursor: gWaitCursor 1)
				(sfx dispose:)
				(dialTone dispose:)
				(super dispose:)
				(gCurRoom notify: local137)
				(if (IsObject local136)
					(local136 cue:)
				)
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
		priority 14
		signal 16
		keyValue 45
		scanValue 0
		keyStr {x}
		tone 0
	)

	(method (init &tmp temp0)
		(= x (+ (TTDialer x:) [local101 loop]))
		(= y (+ (TTDialer y:) [local115 loop] 1000))
		(= view 610)
		(self setCel: 0)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 10] temp10 temp11 temp12)
		(= temp10 (event type:))
		(= temp11 (event message:))
		(cond
			(script
				(event claimed: 1)
			)
			((and (== temp10 evKEYBOARD) (== temp11 KEY_ESCAPE))
				(event claimed: 1)
			)
			(
				(or
					(and (== temp10 evMOUSEBUTTON) (self onMe: event))
					(and (== temp10 evKEYBOARD) (== temp11 KEY_RETURN) (self onMe: event))
					(and (== temp10 evKEYBOARD) (OneOf temp11 keyValue scanValue))
				)
				(event claimed: 1)
				(dialTone stop:)
				(switch loop
					(13
						(= local137 -1)
						(TTDialer dispose:)
					)
					(11
						(= keyStr {*})
					)
					(12
						(= keyStr {#})
					)
					(else
						(Format keyStr 610 0 (- loop 1)) ; "%d"
					)
				)
				(= temp12 tone)
				(self setScript: sButton 0 temp12)
			)
		)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1 forceUpd:)
				(Animate (gCast elements:) 0)
				(if register
					(sfx number: register loop: 1 flags: -1 play:)
				)
				(= ticks 5)
			)
			(1
				(StrCat @local0 (client keyStr:))
				(client cel: 0 forceUpd:)
				(Animate (gCast elements:) 0)
				(= ticks 5)
			)
			(2
				(TTDialer cue: (client keyValue:))
				(self dispose:)
			)
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

(instance unknown_610_16 of Narrator
	(properties)
)

(instance sfx of Sound
	(properties)
)

(instance dialTone of Sound
	(properties)
)

