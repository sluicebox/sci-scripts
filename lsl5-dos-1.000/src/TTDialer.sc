;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	TTDialer 0
)

(local
	[str 100]
	buttons
	[buttonX 14] = [0 1 -16 1 19 -16 1 19 -16 1 19 -16 19 -1]
	[buttonY 14] = [0 -15 -69 -69 -69 -52 -52 -52 -34 -34 -34 -15 -15 -3]
	[prefix 6] = [551 552 553 554 555 556]
	[ATMLoops 10]
	thePrefix
	theLine
	function
	who2Cue
	userInput
	vol1
	vol2
	oldSettings
	walkType
	notifyVal
	cheatVal
)

(instance TTDialer of Prop
	(properties
		x 275
		y 89
		view 10
		priority 14
		signal 16
	)

	(method (init which who)
		(switch gCurRoomNum
			(258
				(= x 41)
				(= y 189)
			)
			(870
				(= x 41)
				(= y 89)
			)
			(else
				(= x 275)
				(= y 89)
			)
		)
		(= function which)
		(if (> argc 1)
			(= who2Cue who)
		else
			(= who2Cue 0)
		)
		(= str 0)
		(= buttons 0)
		(= thePrefix 0)
		(= theLine 0)
		(= userInput (User canInput:))
		(= oldSettings gIconSettings)
		(if (!= (= walkType ((gTheIconBar at: 0) cursor:)) 6)
			(SetupExit 1)
		)
		(HandsOff)
		(User canInput: 1 mapKeyToDir: 0)
		(gTheIconBar enable: 0 2 curIcon: (gTheIconBar at: 2))
		(gGame setCursor: 2)
		(if (gTheMusic handle:)
			(= vol1 (gTheMusic vol:))
			(gTheMusic setVol: (/ vol1 2))
		)
		(if (gTheMusic2 handle:)
			(= vol2 (gTheMusic2 vol:))
			(gTheMusic2 setVol: (/ vol2 2))
		)
		(if (== function 1)
			(dialToneSound number: 33 loop: -1 flags: 1 play: hold: 10)
		)
		(super init: stopUpd:)
		(btn0 init: stopUpd:)
		(btn1 init: stopUpd:)
		(btn2 init: stopUpd:)
		(btn3 init: stopUpd:)
		(btn4 init: stopUpd:)
		(btn5 init: stopUpd:)
		(btn6 init: stopUpd:)
		(btn7 init: stopUpd:)
		(btn8 init: stopUpd:)
		(btn9 init: stopUpd:)
		(if (== function 1)
			(btnStar init: stopUpd:)
			(btnCross init: stopUpd:)
			(hangUp init: stopUpd:)
		)
		(gMouseDownHandler addToEnd: self)
		(gKeyDownHandler addToEnd: self)
	)

	(method (dispose)
		(gTheIconBar disable:)
		(User canInput: 0 canControl: 0)
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
		(if (== function 1)
			(btnStar dispose:)
			(btnCross dispose:)
			(hangUp dispose:)
		)
		(self hide:)
		(= buttons 254)
		(hangUpTimer setReal: self 2)
	)

	(method (handleEvent event)
		(cond
			((not (User canInput:)))
			((event modifiers:)
				(super handleEvent: event)
			)
			(
				(or
					(and
						(OneOf (event type:) evMOUSEBUTTON evKEYBOARD)
						(== ((gTheIconBar at: 0) cursor:) 6)
						(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					)
					(== (event message:) JOY_UP)
				)
				(event claimed: 1)
				(= notifyVal -1)
				(self dispose:)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (cue &tmp i)
		(switch (++ buttons)
			(1
				(if (and (== function 1) (not (ReadNumber @str)))
					(self setScript: sInformation)
				)
			)
			(3
				(if (== function 1)
					(= thePrefix (ReadNumber @str))
					(= str 0)
					(if (OneOf thePrefix 411 911)
						(self setScript: sInformation)
					)
				)
			)
			(5
				(if (== function 0)
					(if (not (StrCmp @str {!!!!!}))
						(= notifyVal -2)
					else
						(= notifyVal (ReadNumber @str))
					)
					(self dispose:)
				)
			)
			(7
				(= theLine (ReadNumber @str))
				(if (and (== function 1) (== thePrefix 555) (== theLine 1212))
					(self setScript: sInformation)
				else
					(User canInput: 0)
					(self setScript: sMessage self)
				)
			)
			(8
				(if theLine
					(= notifyVal theLine)
					(self dispose:)
				else
					(= str 0)
					(= buttons 0)
					(= thePrefix 0)
					(= theLine 0)
				)
			)
			(255
				(for ((= i 0)) (< i 10) ((++ i))
					(= [ATMLoops i] 0)
				)
				(User canInput: userInput mapKeyToDir: 1)
				(if (!= walkType 6)
					(SetupExit 0)
				)
				(RestoreIB)
				(= gIconSettings oldSettings)
				(if (gTheMusic handle:)
					(gTheMusic setVol: vol1)
				)
				(if (gTheMusic2 handle:)
					(gTheMusic2 setVol: vol2)
				)
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(gCurRoom notify: notifyVal)
				(if who2Cue
					(who2Cue cue:)
				)
				(dialToneSound stop:)
				(hangUpTimer dispose: delete:)
				(gTheIconBar enable: curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(super dispose:)
			)
		)
	)
)

(instance sMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(and
							(!= gCurRoomNum 200)
							(== thePrefix [prefix gLarryLoc])
						)
						(and (== gCurRoomNum 200) (== thePrefix 556))
					)
					(= register 1)
				)
				(if (!= register 1)
					(phoneSound number: 35 play: self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (!= register 1)
					(TPrint 20 0) ; "We're sorry, your call cannot be completed as dialed. Please hang up and try your call again. If you are having trouble, please hang up and dial your operator."
					(TPrint 20 1) ; "This is a recording."
					(TPrint 20 2 67 -1 185) ; "(As if you didn't know!)"
					(= theLine 0)
				else
					(TPrint 20 3) ; "Thank you for using U. S. Sprint!"
				)
				(User canInput: 1)
				(= notifyVal theLine)
				(client dispose:)
			)
		)
	)
)

(instance sInformation of Script
	(properties)

	(method (changeState newState &tmp [string 222])
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(Format ; "You have reached Directory Assistance for the Greater %s Area. We're sorry, but we're unable to come to the phone right now. We're presently busy (yeah, busy %s!). Let us assure you that your call IS important; it's just not important to us!"
					@string
					20
					4
					(if (== gCurRoom 200)
						{Washington, D. C.}
					else
						(switch gLarryLoc
							(1 {New York City Metropolitan})
							(2 {Atlantic City Non-Tramp Infested})
							(3 {Dade County})
							(else {`Enter Your City Here'})
						)
					)
					(if (== gCurRoom 200)
						{floating down the Potomac}
					else
						(switch gLarryLoc
							(1 {getting mugged})
							(2 {feeding the slots})
							(3 {lying on the beach})
							(else {sitting on the can!})
						)
					)
				)
				(TPrint @string)
				(= cycles 1)
			)
			(2
				(= str 0)
				(= buttons 0)
				(= thePrefix 0)
				(= theLine 0)
				(= notifyVal -1)
				(client dispose:)
			)
		)
	)
)

(instance dialToneSound of Sound
	(properties)
)

(instance phoneSound of Sound
	(properties)
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

	(method (init &tmp idx)
		(= x (+ (TTDialer x:) [buttonX loop]))
		(= y (+ (TTDialer y:) [buttonY loop] 1000))
		(if (== gCurRoomNum 258)
			(= view 11)
			(for
				((= idx (Random 1 10)))
				[ATMLoops idx]
				((= idx (Random 1 10)))
			)
			(= [ATMLoops idx] 1)
			(= loop idx)
		else
			(= view 10)
		)
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
		(if
			(or
				(and (== temp10 evMOUSEBUTTON) (self onMe: event))
				(and (== temp10 evKEYBOARD) (== temp11 KEY_RETURN) (self onMe: event))
				(and (== temp10 evKEYBOARD) (OneOf temp11 keyValue scanValue))
			)
			(event claimed: 1)
			(dialToneSound stop:)
			(if (== loop 13)
				(= notifyVal -1)
				(TTDialer dispose:)
			else
				(if (and (== (event modifiers:) $000c) (== loop 1)) ; emALT | emCTRL
					(= keyStr {!})
				else
					(switch loop
						(11
							(= keyStr {#})
						)
						(12
							(= keyStr {*})
						)
						(else
							(Format keyStr 20 5 (- loop 1)) ; "%d"
						)
					)
				)
				(= temp12 (if (== gCurRoomNum 258) 256 else tone))
				(self setScript: (sButton new:) 0 temp12)
			)
		)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(if register
					(phoneSound number: register play:)
				)
				(= cycles 1)
			)
			(2
				(StrCat @str (client keyStr:))
				(TTDialer cue:)
				(client setCel: 0)
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
		tone 30
	)
)

(instance btn1 of PushButton
	(properties
		z 1000
		loop 2
		keyValue 49
		scanValue 20224
		tone 21
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 55 else 49))
		(= scanValue (if (== gCurRoomNum 258) 18176 else 20224))
		(super init:)
	)
)

(instance btn2 of PushButton
	(properties
		z 1000
		loop 3
		keyValue 50
		scanValue 20480
		tone 22
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 56 else 50))
		(= scanValue (if (== gCurRoomNum 258) 18432 else 20480))
		(super init:)
	)
)

(instance btn3 of PushButton
	(properties
		z 1000
		loop 4
		keyValue 51
		scanValue 20736
		tone 23
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 57 else 51))
		(= scanValue (if (== gCurRoomNum 258) 18688 else 20736))
		(super init:)
	)
)

(instance btn4 of PushButton
	(properties
		z 1000
		loop 5
		keyValue 52
		scanValue 19200
		tone 24
	)
)

(instance btn5 of PushButton
	(properties
		z 1000
		loop 6
		keyValue 53
		scanValue 19456
		tone 25
	)
)

(instance btn6 of PushButton
	(properties
		z 1000
		loop 7
		keyValue 54
		scanValue 19712
		tone 26
	)
)

(instance btn7 of PushButton
	(properties
		z 1000
		loop 8
		keyValue 55
		scanValue 18176
		tone 27
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 49 else 55))
		(= scanValue (if (== gCurRoomNum 258) 20224 else 18176))
		(super init:)
	)
)

(instance btn8 of PushButton
	(properties
		z 1000
		loop 9
		keyValue 56
		scanValue 18432
		tone 28
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 50 else 56))
		(= scanValue (if (== gCurRoomNum 258) 20480 else 18432))
		(super init:)
	)
)

(instance btn9 of PushButton
	(properties
		z 1000
		loop 10
		keyValue 57
		scanValue 18688
		tone 29
	)

	(method (init)
		(= keyValue (if (== gCurRoomNum 258) 51 else 57))
		(= scanValue (if (== gCurRoomNum 258) 20736 else 18688))
		(super init:)
	)
)

(instance btnCross of PushButton
	(properties
		z 1000
		loop 11
		keyValue 35
		tone 31
	)
)

(instance btnStar of PushButton
	(properties
		z 1000
		loop 12
		keyValue 42
		tone 32
	)
)

(instance hangUp of PushButton
	(properties
		z 1000
		loop 13
		keyValue 32
	)
)

