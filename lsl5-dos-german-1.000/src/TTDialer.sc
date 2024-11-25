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
	[local0 14]
	local14
	[local15 14] = [0 1 -16 1 19 -16 1 19 -16 1 19 -16 19 -1]
	[local29 14] = [0 -15 -69 -69 -69 -52 -52 -52 -34 -34 -34 -15 -15 -3]
	[local43 6] = [551 552 553 554 555 556]
	[local49 10]
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	local66
	local67
	local68
	local69
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
		(= local61 which)
		(if (> argc 1)
			(= local62 who)
		else
			(= local62 0)
		)
		(= local0 0)
		(= local14 0)
		(= local59 0)
		(= local60 0)
		(= local63 (User canInput:))
		(= local66 gIconSettings)
		(if (!= (= local67 ((gTheIconBar at: 0) cursor:)) 6)
			(SetupExit 1)
		)
		(HandsOff)
		(User canInput: 1 mapKeyToDir: 0)
		(gTheIconBar disable: 8)
		(gTheIconBar enable: 0 2 curIcon: (gTheIconBar at: 2))
		(gGame setCursor: 2)
		(if (gTheMusic handle:)
			(= local64 (gTheMusic vol:))
			(gTheMusic setVol: (/ local64 2))
		)
		(if (gTheMusic2 handle:)
			(= local65 (gTheMusic2 vol:))
			(gTheMusic2 setVol: (/ local65 2))
		)
		(if (== local61 1)
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
		(if (== local61 1)
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
		(if (== local61 1)
			(btnStar dispose:)
			(btnCross dispose:)
			(hangUp dispose:)
		)
		(self hide:)
		(= local14 254)
		(hangUpTimer setReal: self 2)
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
				(= local68 -1)
				(self dispose:)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (cue &tmp i)
		(switch (++ local14)
			(1
				(if (and (== local61 1) (not (ReadNumber @local0)))
					(self setScript: sInformation)
				)
			)
			(3
				(if (== local61 1)
					(= local59 (ReadNumber @local0))
					(= local0 0)
					(if (OneOf local59 411 911)
						(self setScript: sInformation)
					)
				)
			)
			(5
				(if (== local61 0)
					(if (not (StrCmp @local0 {!!!!!}))
						(= local68 -2)
					else
						(= local68 (ReadNumber @local0))
					)
					(self dispose:)
				)
			)
			(7
				(User canInput: 0)
				(= local60 (ReadNumber @local0))
				(if (and (== local61 1) (== local59 555) (== local60 1212))
					(self setScript: sInformation)
				else
					(User canInput: 0)
					(self setScript: sMessage self)
				)
			)
			(8
				(if local60
					(= local68 local60)
					(self dispose:)
				else
					(= local0 0)
					(= local14 0)
					(= local59 0)
					(= local60 0)
				)
			)
			(255
				(for ((= i 0)) (< i 10) ((++ i))
					(= [local49 i] 0)
				)
				(User canInput: local63 mapKeyToDir: 1)
				(if (!= local67 6)
					(SetupExit 0)
				)
				(RestoreIB)
				(= gIconSettings local66)
				(if (gTheMusic handle:)
					(gTheMusic setVol: local64)
				)
				(if (gTheMusic2 handle:)
					(gTheMusic2 setVol: local65)
				)
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(gCurRoom notify: local68)
				(if local62
					(local62 cue:)
				)
				(dialToneSound dispose:)
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
						(and (!= gCurRoomNum 200) (== local59 [local43 gLarryLoc]))
						(and (== gCurRoomNum 200) (== local59 556))
					)
					(= register 1)
				)
				(if (!= register 1)
					(dialToneSound number: 35 loop: 1 play:)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(1
				(if (!= register 1)
					(TPrint 20 0) ; "We're sorry, your call cannot be completed as dialed. Please hang up and try your call again. If you are having trouble, please hang up and dial your operator."
					(TPrint 20 1) ; "This is a recording."
					(TPrint 20 2 #at -1 185) ; "(As if you didn't know!)"
					(= local60 0)
				else
					(TPrint 20 3) ; "Thank you for using U. S. Sprint!"
					(dialToneSound dispose:)
					(hangUpTimer dispose: delete:)
				)
				(User canInput: 1)
				(= local68 local60)
				(client dispose:)
			)
		)
	)
)

(instance sInformation of Script
	(properties)

	(method (changeState newState &tmp [string 400])
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
					(if (== gCurRoom 200)
						{Washington, D. C.}
					else
						(switch gLarryLoc
							(1 {New York City Metropole})
							(2 {Atlantic City nicht Trampverseucht})
							(3 {Grossvaterland})
							(else {`Geben Sie hier Ihre Stadt ein'})
						)
					)
					(if (== gCurRoom 200)
						{den Potomac hinunterfliessend}
					else
						(switch gLarryLoc
							(1 {wird ausgeraubt})
							(2 {am F\81ttern der einarmigen Banditen})
							(3 {am Strand liegend})
							(else {auf der Dose sitzend!})
						)
					)
				)
				(TPrint @string)
				(= cycles 1)
			)
			(2
				(= local0 0)
				(= local14 0)
				(= local59 0)
				(= local60 0)
				(= local68 -1)
				(client dispose:)
			)
		)
	)
)

(instance dialToneSound of Sound
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
		(= x (+ (TTDialer x:) [local15 loop]))
		(= y (+ (TTDialer y:) [local29 loop] 1000))
		(if (== gCurRoomNum 258)
			(= view 11)
			(for
				((= idx (Random 1 10)))
				[local49 idx]
				((= idx (Random 1 10)))
			)
			(= [local49 idx] 1)
			(= loop idx)
		else
			(= view 10)
		)
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

	(method (handleEvent event &tmp [temp0 6] temp6 temp7 temp8)
		(= temp6 (event type:))
		(= temp7 (event message:))
		(cond
			((and (== temp6 evKEYBOARD) (== temp7 KEY_ESCAPE))
				(event claimed: 1)
			)
			(
				(or
					(and (== temp6 evMOUSEBUTTON) (self onMe: event))
					(and (== temp6 evKEYBOARD) (== temp7 KEY_RETURN) (self onMe: event))
					(and (== temp6 evKEYBOARD) (OneOf temp7 keyValue scanValue))
				)
				(event claimed: 1)
				(dialToneSound stop:)
				(if (== loop 13)
					(= local68 -1)
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
					(= temp8 (if (== gCurRoomNum 258) 256 else tone))
					(self setScript: (sButton new:) 0 temp8)
				)
			)
		)
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(client setCycle: End self)
			)
			(1
				(if register
					(dialToneSound number: register loop: 1 play:)
				)
				(= cycles 1)
			)
			(2
				(StrCat @local0 (client keyStr:))
				(client setCel: 0)
				(= cycles 1)
			)
			(3
				(TTDialer cue:)
				(= cycles 10)
			)
			(4
				(User canInput: 1)
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

