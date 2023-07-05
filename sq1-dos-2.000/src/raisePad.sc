;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use User)
(use Actor)
(use System)

(public
	raisePad 0
	lowerPad 1
	enterScript 2
	keyFlashScript 3
	quitScript 4
)

(local
	[local0 10]
	[local10 10]
	local20
	local21
	local22
	[local23 17] = [185 180 175 170 165 160 155 150 145 140 135 130 125 120 115 -1 0]
)

(procedure (localproc_0)
	(if local20
		(Display 400 0 dsRESTOREPIXELS local20)
		(= local20 0)
	)
)

(procedure (localproc_1)
	(oneBut init: @local0)
	(twoBut init: @local0)
	(threeBut init: @local0)
	(fourBut init: @local0)
	(fiveBut init: @local0)
	(sixBut init: @local0)
	(sevenBut init: @local0)
	(eightBut init: @local0)
	(nineBut init: @local0)
	(zeroBut init: @local0)
	(enterBut init: whoToCue: (ScriptID 400 2)) ; enterScript
	(quitBut init: whoToCue: quitScript)
	(hand init: hide: x: (+ (keyPad x:) 50) y: (+ (keyPad y:) 20))
)

(procedure (localproc_2)
	(oneBut dispose:)
	(twoBut dispose:)
	(threeBut dispose:)
	(fourBut dispose:)
	(fiveBut dispose:)
	(sixBut dispose:)
	(sevenBut dispose:)
	(eightBut dispose:)
	(nineBut dispose:)
	(zeroBut dispose:)
	(enterBut dispose:)
	(quitBut dispose:)
	(hand dispose:)
)

(instance raisePad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(keyPad y: 185 ignoreActors: init:)
				(gSoundEffects number: 358 loop: 1 play:)
				(= cycles 1)
			)
			(1
				(if (!= [local23 (++ local21)] -1)
					(-- state)
					(keyPad y: [local23 local21] forceUpd:)
				)
				(= cycles 1)
			)
			(2
				(keyPad signal: (| (keyPad signal:) $0101))
				(gSoundEffects stop:)
				(localproc_1)
				(HandsOn)
				(gTheIconBar disable: 0 3 4 5)
				(client register: 1)
				(self dispose:)
			)
		)
	)
)

(instance lowerPad of Script
	(properties)

	(method (dispose)
		((ScriptID 49 2) cycles: 1) ; robotAsksScript
		(beep dispose:)
		(super dispose:)
		(DisposeScript 400)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(keyPad signal: (& (keyPad signal:) $feff))
				(= local21 15)
				(localproc_2)
				(gSoundEffects number: 358 loop: 1 play:)
				(= cycles 3)
			)
			(1
				(if (>= (-- local21) 0)
					(-- state)
					(keyPad y: [local23 local21] forceUpd:)
				else
					(keyPad dispose:)
				)
				(= cycles 1)
			)
			(2
				(= local0 0)
				(gSoundEffects stop:)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (dispose)
		(StrCpy @local0 {})
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_0)
				(cond
					((not (StrLen @local0))
						(Print 400 1) ; "Please enter a Navigational Grid Code before pressing "ENTER"."
						(self dispose:)
					)
					((< (StrLen @local0) 4)
						(Print 400 2) ; "Invalid code. A complete set must be entered."
						(self dispose:)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(switch global186
					(1
						(StrCpy @local10 {GFCB})
					)
					(2
						(StrCpy @local10 {DICJ})
					)
					(3
						(StrCpy @local10 {JBEI})
					)
					(4
						(StrCpy @local10 {EAEB})
					)
					(5
						(StrCpy @local10 {IIBA})
					)
					(6
						(StrCpy @local10 {EGHD})
					)
					(7
						(StrCpy @local10 {CBBJ})
					)
					(8
						(StrCpy @local10 {HFFH})
					)
					(9
						(StrCpy @local10 {ICDE})
					)
					(10
						(StrCpy @local10 {BIAA})
					)
					(11
						(StrCpy @local10 {GHJB})
					)
					(12
						(StrCpy @local10 {HAAD})
					)
					(13
						(StrCpy @local10 {DAIB})
					)
					(14
						(StrCpy @local10 {DDDG})
					)
					(15
						(StrCpy @local10 {BACH})
					)
					(16
						(StrCpy @local10 {ABHC})
					)
					(17
						(StrCpy @local10 {GJDH})
					)
					(18
						(StrCpy @local10 {CAHC})
					)
					(19
						(StrCpy @local10 {BGBB})
					)
					(20
						(StrCpy @local10 {IJFE})
					)
				)
				(cond
					((== (StrCmp @local0 @local10) 0)
						(Print 400 3) ; "Okay, I'm plotting our course."
						(= global189 2)
						((ScriptID 49 2) setScript: lowerPad) ; robotAsksScript
						(= cycles 1)
					)
					((== (++ local22) 3)
						(= global189 1)
						(Print 400 3) ; "Okay, I'm plotting our course."
						((ScriptID 49 2) setScript: lowerPad) ; robotAsksScript
						(= cycles 1)
					)
					(else
						(Print 400 4) ; "Sorry. That is an incorrect code. Please try again."
						(= ticks 1)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance keyFlashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setPri: 11)
				(if register
					(beep number: 341 play:)
					(= register 0)
				)
				(= cycles 2)
			)
			(1
				(client setPri: 0)
				(= cycles 1)
			)
			(2
				(if (client whoToCue:)
					(client setScript: (client whoToCue:))
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance quitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 49 2) setScript: lowerPad) ; robotAsksScript
				(self dispose:)
			)
		)
	)
)

(class KeyPadButton of Prop
	(properties
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		theString 0
		strToCat 0
		maxLen 4
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

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(self flash:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (flash)
		(self setScript: (Clone keyFlashScript) 0 tone)
		(if (and strToCat (< (StrLen theString) maxLen))
			(localproc_0)
			(StrCat theString strToCat)
			(= local20
				(Display
					theString
					dsCOORD
					(+ (keyPad x:) 5)
					(+ (- (keyPad y:) 10) 20)
					dsCOLOR
					global142
					dsALIGN
					alLEFT
					dsFONT
					30
					dsSAVEPIXELS
				)
			)
		)
	)
)

(instance beep of Sound
	(properties)
)

(instance hand of View
	(properties
		onMeCheck 0
		view 502
		cel 2
		priority 15
		signal 16
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (User curEvent:))
		(if (and (not (& signal $8000)) (not (& (temp0 type:) $0007))) ; evMOUSEKEYBOARD | evMOUSERELEASE
			(temp0 localize:)
			(= temp1 (temp0 x:))
			(= temp2 (temp0 y:))
			(cond
				(
					(and
						(InRect 224 115 295 187 temp1 temp2)
						(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					)
					(gGame setCursor: 69 1)
					(self show: x: temp1 y: temp2)
				)
				((not (& signal $0080))
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
					(self hide:)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if (== gTheCursor 69)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		)
		(super dispose:)
	)
)

(instance keyPad of View
	(properties
		x 238
		y 185
		z -20
		description {keypad}
		lookStr {Please enter a Navigational Code Sequence to allow course plotting.}
		view 502
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 7)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gTheIconBar disable: 0)
	)

	(method (dispose)
		(super dispose: &rest)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(HandsOn)
	)
)

(instance enterBut of KeyPadButton
	(properties
		x 270
		y 139
		description {Enter}
		lookStr {This button confirms entry of the code you keyed-in and begins the search for the corresponding cartridge.}
		view 502
		loop 1
		cel 11
		signal 16384
		tone 351
	)
)

(instance quitBut of KeyPadButton
	(properties
		x 248
		y 169
		description {Off}
		lookStr {Press this button if you want to turn the keypad off.}
		view 502
		loop 1
		cel 12
		signal 16384
		tone 352
	)
)

(instance oneBut of KeyPadButton
	(properties
		x 238
		y 139
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		signal 16384
		strToCat {A}
		tone 341
	)
)

(instance twoBut of KeyPadButton
	(properties
		x 248
		y 139
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 1
		signal 16384
		strToCat {B}
		tone 342
	)
)

(instance threeBut of KeyPadButton
	(properties
		x 258
		y 139
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 2
		signal 16384
		strToCat {C}
		tone 343
	)
)

(instance fourBut of KeyPadButton
	(properties
		x 238
		y 149
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 3
		signal 16384
		strToCat {D}
		tone 344
	)
)

(instance fiveBut of KeyPadButton
	(properties
		x 248
		y 149
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 4
		signal 16384
		strToCat {E}
		tone 345
	)
)

(instance sixBut of KeyPadButton
	(properties
		x 258
		y 149
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 5
		signal 16384
		strToCat {F}
		tone 346
	)
)

(instance sevenBut of KeyPadButton
	(properties
		x 238
		y 159
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 6
		signal 16384
		strToCat {G}
		tone 347
	)
)

(instance eightBut of KeyPadButton
	(properties
		x 248
		y 159
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 7
		signal 16384
		strToCat {H}
		tone 348
	)
)

(instance nineBut of KeyPadButton
	(properties
		x 258
		y 159
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 8
		signal 16384
		strToCat {I}
		tone 349
	)
)

(instance zeroBut of KeyPadButton
	(properties
		x 238
		y 169
		description {button}
		lookStr {These buttons allow you to enter a code into the computer.}
		view 502
		loop 1
		cel 9
		signal 16384
		strToCat {J}
		tone 350
	)
)

