;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use LoadMany)
(use Sound)
(use User)
(use Actor)
(use System)

(public
	rm65 0
)

(local
	local0
	[local1 4]
	local5
	local6
)

(procedure (localproc_0 param1) ; UNUSED
	(if (== param1 0)
		(return 160)
	else
		(return (+ 111 (* (- param1 (* 3 (/ (- param1 1) 3))) 25)))
	)
)

(procedure (localproc_1 param1) ; UNUSED
	(if (== param1 0)
		(return 73)
	else
		(return (+ 99 (* (/ (- param1 1) 3) 17)))
	)
)

(procedure (localproc_2)
	(= local0 (Display 65 0 dsCOORD 100 42 dsCOLOR global136 dsALIGN alLEFT dsFONT 2 dsSAVEPIXELS)) ; "Enter Code:"
)

(instance rm65 of SQRoom
	(properties
		lookStr {This is the control keypad, which is used to input instructions to the Star Generator.}
		picture 65
		style 7
	)

	(method (init &tmp temp0)
		(LoadMany rsSOUND 358 340 341 342 343 344 345 346 347 348 349 350 351 352)
		(oneBut init: @local1)
		(twoBut init: @local1)
		(threeBut init: @local1)
		(fourBut init: @local1)
		(fiveBut init: @local1)
		(sixBut init: @local1)
		(sevenBut init: @local1)
		(eightBut init: @local1)
		(nineBut init: @local1)
		(enterBut init: whoToCue: EnterScript)
		(quitBut init: whoToCue: quitScript)
		(hand init: hide: x: 150 y: 70)
		(super init:)
		(HandsOn)
		(gTheIconBar disable: 0 4 5)
		(localproc_2)
	)
)

(instance hand of View
	(properties
		view 502
		cel 2
		priority 15
		signal 16
	)

	(method (dispose)
		(if (== gTheCursor 69)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		)
		(super dispose: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (User curEvent:))
		(if (not (& (temp0 type:) $0007)) ; evMOUSEKEYBOARD | evMOUSERELEASE
			(temp0 localize:)
			(= temp1 (temp0 x:))
			(= temp2 (temp0 y:))
			(cond
				((InRect 123 60 198 136 temp1 temp2)
					(gGame setCursor: 69 1)
					(self show: x: temp1 y: temp2)
				)
				((== gTheCursor 69)
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
					(self hide:)
				)
			)
		)
		(super doit:)
	)
)

(class PadButton of Prop
	(properties
		view 165
		cycleSpeed 6
		theString 0
		strToCat 0
		keyEquiv 0
		maxLen 8
		tone 0
		whoToCue 0
	)

	(method (init param1)
		(super init:)
		(self setPri: 0)
		(= theString param1)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (User controls:)
			(switch (event type:)
				(evKEYBOARD
					(cond
						(
							(and
								(== (event message:) KEY_RETURN)
								(InRect nsLeft nsTop nsRight nsBottom event)
							)
							(event claimed: 1)
							(self flash:)
						)
						((== (event message:) keyEquiv)
							(event claimed: 1)
							(self flash:)
						)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(event claimed: 1)
						(self flash:)
					)
				)
			)
		else
			(event claimed: 1)
		)
	)

	(method (flash)
		(self setScript: (Clone keyFlashScript) 0 tone)
		(if strToCat
			(if (>= (StrLen theString) 4)
				(StrCpy theString {})
			)
			(StrCat theString strToCat)
			(if local5
				(Display 65 1 dsRESTOREPIXELS local5)
			)
			(= local5
				(Display theString dsCOORD 161 42 dsCOLOR global142 dsALIGN alLEFT dsFONT 2 dsSAVEPIXELS)
			)
		)
	)
)

(instance enterBut of PadButton
	(properties
		x 160
		y 73
		cel 1
		signal 16384
		tone 351
	)
)

(instance quitBut of PadButton
	(properties
		x 248
		y 169
		view 502
		loop 3
		signal 16384
		tone 352
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(and
						(== (event type:) evKEYBOARD)
						(OneOf (event message:) KEY_X KEY_x)
					)
					(MousedOn self event)
					(InRect nsLeft nsTop nsRight nsBottom event)
				)
				(event claimed: 1)
				(self flash:)
			)
		)
	)
)

(instance oneBut of PadButton
	(properties
		x 136
		y 99
		loop 1
		cel 1
		signal 16384
		strToCat {1}
		keyEquiv 49
		tone 341
	)
)

(instance twoBut of PadButton
	(properties
		x 161
		y 99
		loop 2
		cel 1
		signal 16384
		strToCat {2}
		keyEquiv 50
		tone 342
	)
)

(instance threeBut of PadButton
	(properties
		x 186
		y 99
		loop 3
		cel 1
		signal 16384
		strToCat {3}
		keyEquiv 51
		tone 343
	)
)

(instance fourBut of PadButton
	(properties
		x 136
		y 116
		loop 4
		cel 1
		signal 16384
		strToCat {4}
		keyEquiv 52
		tone 344
	)
)

(instance fiveBut of PadButton
	(properties
		x 161
		y 116
		loop 5
		cel 1
		signal 16384
		strToCat {5}
		keyEquiv 53
		tone 345
	)
)

(instance sixBut of PadButton
	(properties
		x 186
		y 116
		loop 6
		cel 1
		signal 16384
		strToCat {6}
		keyEquiv 54
		tone 346
	)
)

(instance sevenBut of PadButton
	(properties
		x 136
		y 133
		loop 7
		cel 1
		signal 16384
		strToCat {7}
		keyEquiv 55
		tone 347
	)
)

(instance eightBut of PadButton
	(properties
		x 161
		y 133
		loop 8
		cel 1
		signal 16384
		strToCat {8}
		keyEquiv 56
		tone 348
	)
)

(instance nineBut of PadButton
	(properties
		x 186
		y 133
		loop 9
		cel 1
		signal 16384
		strToCat {9}
		keyEquiv 57
		tone 349
	)
)

(instance EnterScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (not (StrLen @local1))
					(self dispose:)
				else
					(= cycles 3)
				)
			)
			(1
				(HandsOff)
				(Display 65 1 dsRESTOREPIXELS local5)
				(Display 65 1 dsRESTOREPIXELS local0)
				(= temp0 (ReadNumber @local1))
				(= local1 0)
				(if (== temp0 global184)
					(= register 1)
					(SetFlag 53)
				)
				(= cycles 30)
			)
			(2
				(self setScript: flashText self (if register 1 else 0))
			)
			(3
				(if (not register)
					(HandsOn)
					(gTheIconBar disable: 0 4 5)
					(localproc_2)
					(self dispose:)
				else
					(= register 0)
					(= cycles 9)
				)
			)
			(4
				(gCurRoom newRoom: 64)
			)
		)
	)
)

(instance flashText of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= local6 0)
	)

	(method (dispose)
		(= local5 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(if (not (IsFlag 172))
						(gLongSong2 number: 626 loop: -1 play:)
					)
					(= local5
						(Display 65 2 dsCOORD 107 42 dsCOLOR global136 dsALIGN alLEFT dsFONT 2 dsSAVEPIXELS) ; "Self Destruct Engaged"
					)
					(SetScore 10 172)
				else
					(gLongSong2 number: 521 loop: 1 play:)
					(= local5
						(Display 65 3 dsCOORD 111 42 dsCOLOR global136 dsALIGN alLEFT dsFONT 2 dsSAVEPIXELS) ; "Invalid Code Entered"
					)
				)
				(= cycles 15)
			)
			(1
				(if (not register)
					(gLongSong2 stop:)
				)
				(Display 65 1 dsRESTOREPIXELS local5)
				(= cycles 6)
			)
			(2
				(if (<= (++ local6) 3)
					(self changeState: 0)
				else
					(= local6 0)
					(self changeState: 3)
				)
			)
			(3
				(if register
					(gLongSong2 number: 619 loop: 1 play:)
					(= local5
						(Display 65 4 dsCOORD 125 42 dsCOLOR global136 dsALIGN alLEFT dsFONT 2 dsSAVEPIXELS) ; "Have a nice day"
					)
					(= cycles 15)
				else
					(self dispose:)
				)
			)
			(4
				(Display 65 1 dsRESTOREPIXELS local5)
				(= cycles 6)
			)
			(5
				(if (<= (++ local6) 3)
					(self changeState: 3)
				else
					(= register 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance beep of Sound
	(properties)
)

(instance keyFlashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setPri: 11)
				(if register
					(beep number: register play:)
					(= register 0)
				)
				(= cycles 6)
			)
			(1
				(client setPri: 0)
				(= cycles 3)
			)
			(2
				(if (client whoToCue:)
					(gCurRoom setScript: (client whoToCue:))
				)
				(client setScript: 0)
			)
		)
	)
)

(instance quitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom newRoom: 64)
			)
		)
	)
)

