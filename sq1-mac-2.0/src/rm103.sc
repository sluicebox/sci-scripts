;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use Interface)
(use arcadaRegion)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm103 0
)

(local
	[local0 10]
	[local10 11]
	local21
	[local22 17] = [185 180 175 170 165 160 155 150 145 140 135 130 125 120 115 -1 0]
)

(procedure (localproc_0)
	(if ((ScriptID 700 0) saveBits:) ; arcadaRegion
		(Display 103 0 dsRESTOREPIXELS ((ScriptID 700 0) saveBits:)) ; arcadaRegion
		((ScriptID 700 0) saveBits: 0) ; arcadaRegion
	)
)

(procedure (localproc_1)
	(oneBut init: @local0 stopUpd:)
	(twoBut init: @local0)
	(threeBut init: @local0)
	(fourBut init: @local0)
	(fiveBut init: @local0)
	(sixBut init: @local0)
	(sevenBut init: @local0)
	(eightBut init: @local0 stopUpd:)
	(nineBut init: @local0 stopUpd:)
	(zeroBut init: @local0 stopUpd:)
	(enterBut init: whoToCue: EnterScript stopUpd:)
	(quitBut init: whoToCue: lowerPad stopUpd:)
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

(instance rm103 of Rm
	(properties
		picture 103
	)

	(method (init)
		(Load rsPIC 102)
		(LoadMany rsSOUND 358 340 341 342 343 344 345 346 347 348 349 350 351 352)
		(self setRegions: 700) ; arcadaRegion
		(super init:)
		(myCast add:)
		(if (!= (gLongSong number:) 355)
			(gLongSong2 number: 314 loop: -1 play:)
		)
		(egoHead init:)
		(egoArm init:)
		(exitRoom init:)
		(if (proc700_1 556 16)
			((ScriptID 700 0) rFlag1: (& ((ScriptID 700 0) rFlag1:) $ffef)) ; arcadaRegion, arcadaRegion
			((ScriptID 700 0) rFlag1: (| ((ScriptID 700 0) rFlag1:) $0020)) ; arcadaRegion, arcadaRegion
			(droid init: stopUpd:)
			(droidArm init: stopUpd:)
		)
		(gFeatures
			add: monitor console controlPanel lights egoFeat buttons
			eachElementDo: #init
		)
		(HandsOn)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: keyPad)
					(Print 103 1) ; "Somebody wasted the CRT."
				else
					(Print 103 2) ; "This is the Data Cartridge Retrieval System."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Cartridge
						(if (gCast contains: keyPad)
							(Print 103 3) ; "Cartridge viewing on this system has been rendered impossible."
						else
							(super doVerb: theVerb invItem &rest)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (dispose)
		(myCast release: dispose:)
		(super dispose: &rest)
	)
)

(instance myCast of List
	(properties)
)

(instance getTheCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 3)
			)
		)
	)
)

(instance returnToComputer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #show)
				(if (gCast contains: droidArm)
					(gLongSong2 number: 353 loop: -1 play:)
				)
				(gCurRoom drawPic: 103 10)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance lookAtMonitor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 stop: loop: 0)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(gCurRoom overlay: 102)
				(= cycles 3)
			)
			(1
				(self setScript: raisePad self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance egoGrabCart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(droidArm setCycle: CT 1 1 self)
			)
			(1
				(egoArm
					setLoop: 4
					cel: 0
					setPri: (+ (droidArm priority:) 1)
					setCycle: CT 2 1 self
				)
			)
			(2
				(gSoundEffects number: 303 loop: 1 play:)
				((ScriptID 700 0) rFlag1: (& ((ScriptID 700 0) rFlag1:) $ffdf)) ; arcadaRegion, arcadaRegion
				(droidArm setCycle: End self)
				(egoArm setCycle: End)
				(gEgo get: 0) ; Cartridge
			)
			(3
				(client setScript: getTheCart)
			)
		)
	)
)

(instance EnterScript of Script
	(properties)

	(method (dispose)
		(StrCpy @local0 {})
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_0)
				(if (not (StrLen @local0))
					(Print 103 4) ; "Please enter a Cartridge Code Sequence before pressing "ENTER"."
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(1
				(switch ((ScriptID 700 0) cartNumber:) ; arcadaRegion
					(1
						(StrCpy @local10 {BHCA})
					)
					(2
						(StrCpy @local10 {BCHE})
					)
					(3
						(StrCpy @local10 {BHBH})
					)
					(4
						(StrCpy @local10 {FCFD})
					)
					(5
						(StrCpy @local10 {HDCH})
					)
					(6
						(StrCpy @local10 {GECB})
					)
					(7
						(StrCpy @local10 {EEJF})
					)
					(8
						(StrCpy @local10 {CAED})
					)
					(9
						(StrCpy @local10 {BACI})
					)
					(10
						(StrCpy @local10 {EFGI})
					)
					(11
						(StrCpy @local10 {IBED})
					)
					(12
						(StrCpy @local10 {GFDJ})
					)
					(13
						(StrCpy @local10 {JAAI})
					)
					(14
						(StrCpy @local10 {DDHF})
					)
					(15
						(StrCpy @local10 {IJBD})
					)
					(16
						(StrCpy @local10 {ICCH})
					)
					(17
						(StrCpy @local10 {DGFJ})
					)
					(18
						(StrCpy @local10 {FCJG})
					)
					(19
						(StrCpy @local10 {FIFI})
					)
					(20
						(StrCpy @local10 {AJJG})
					)
				)
				(if
					(and
						(not (proc700_1 556 32))
						(not (gEgo has: 0)) ; Cartridge
						(== (StrCmp @local0 @local10) 0)
					)
					(HandsOff)
					(= cycles 1)
					(gGame setCursor: gWaitCursor 1 160 190)
				else
					(self changeState: 4)
				)
			)
			(2
				(gSoundEffects number: 305 loop: 1 play: self)
			)
			(3
				(Print 103 5) ; "Cartridge found. Now retrieving."
				((ScriptID 700 0) rFlag1: (| ((ScriptID 700 0) rFlag1:) $0010)) ; arcadaRegion, arcadaRegion
				(gCurRoom newRoom: 3)
			)
			(4
				(gSoundEffects number: 306 loop: 1 play:)
				(= cycles 5)
			)
			(5
				(if (== (StrCmp @local0 @local10) 0)
					(Print 103 6) ; "That cartridge is currently out on loan. Please try again later."
				else
					(switch (Random 0 4)
						(0
							(Print 103 6) ; "That cartridge is currently out on loan. Please try again later."
						)
						(1
							(Print 103 7) ; "Sorry, that cartridge is reserved. Please check again later."
						)
						(2
							(Print 103 8) ; "Sorry, that cartridge was destroyed in a freak fusion accident. Check back with us in a few months. Purchasing should have a new one in by then."
						)
						(3
							(Print 103 9) ; "Ken took that one home. That means we'll never get it back, so don't bother checking back later."
						)
						(4
							(Print 103 10) ; "Cartridge title not found."
						)
					)
				)
				(if
					(and
						(not (gEgo has: 0)) ; Cartridge
						(> global172 30)
						(< (-= global172 120) 30)
					)
					(= global172 30)
				)
				(self dispose:)
			)
		)
	)
)

(instance raisePad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor 1 160 100)
				(keyPad y: 185 ignoreActors: init:)
				(gSoundEffects number: 358 loop: 1 play:)
				(= cycles 1)
			)
			(1
				(if (!= [local22 (++ local21)] -1)
					(-- state)
					(keyPad y: [local22 local21] forceUpd:)
				)
				(= cycles 1)
			)
			(2
				(keyPad signal: (| (keyPad signal:) $0100) stopUpd:)
				(gSoundEffects stop:)
				(localproc_1)
				(HandsOn)
				(gTheIconBar disable: 0 3 4 5)
				(self dispose:)
			)
		)
	)
)

(instance lowerPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_2)
				(keyPad signal: (& (keyPad signal:) $feff))
				(= local21 15)
				(gSoundEffects number: 358 loop: 1 play:)
				(= cycles 1)
			)
			(1
				(if (>= (-- local21) 0)
					(-- state)
					(keyPad y: [local22 local21] forceUpd:)
				else
					(keyPad dispose:)
				)
				(= cycles 1)
			)
			(2
				(= local0 0)
				(keyPad dispose:)
				(gSoundEffects stop:)
				(gTheIconBar enable:)
				(HandsOn)
				(client setScript: returnToComputer)
			)
		)
	)
)

(instance keyFlashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(client setPri: 11)
				(Animate (gCast elements:) 0)
				(if register
					(beep number: register play:)
				)
				(= cycles 1)
			)
			(1
				(client setPri: 0)
				(Animate (gCast elements:) 0)
				(= cycles 1)
			)
			(2
				(User canInput: 1)
				(if (and (client whoToCue:) (not (gCurRoom script:)))
					(gCurRoom setScript: (client whoToCue:))
				)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance pushButtons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(egoArm setLoop: 3 cel: 0 setCycle: Fwd)
				(= cycles (Random 10 20))
			)
			(1
				(Print 103 11) ; "These buttons don't seem to be functioning properly."
				(egoArm setCycle: Beg)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoHead of Prop
	(properties
		x 99
		y 67
		lookStr {This is your head. (Didn't you learn this stuff a real long time ago?)}
		view 203
		loop 1
	)
)

(instance egoArm of Prop
	(properties
		x 113
		y 78
		lookStr {This is your arm.}
		view 203
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance exitRoom of Prop
	(properties
		x 281
		y 183
		description {exitRoom}
		lookStr {This button allows you to exit this screen.}
		view 502
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(self cel: 1)
				(Animate (gCast elements:) 0)
				(Animate (gCast elements:) 0)
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance droidArm of Prop
	(properties
		description {droid arm}
		lookStr {You see a data cartridge clasped in the droid's manipulator.}
		view 203
		loop 6
	)

	(method (init)
		(self x: (- (droid x:) 21) y: (- (droid y:) 37))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(SetScore 5 130)
				(gCurRoom setScript: egoGrabCart)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance droid of View
	(properties
		x 238
		y 70
		description {droid}
		lookStr {You see a data cartridge clasped in the droid's manipulator.}
		view 203
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 103 12) ; "Grabbing the droid will accomplish nothing. He's too big to carry around with you."
			)
			(4 ; Inventory
				(Print 103 13) ; "The droid has no need of that. Better keep it for yourself."
			)
			(5 ; Talk
				(Print 103 14) ; "This droid is not programmed to respond to verbal input."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance monitor of Feature
	(properties
		description {cracked monitor}
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: lookAtMonitor)
			)
			(3 ; Do
				(gCurRoom setScript: lookAtMonitor)
			)
			(4 ; Inventory
				(if (== invItem 0) ; Cartridge
					(Print 103 3) ; "Cartridge viewing on this system has been rendered impossible."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance console of Feature
	(properties
		description {data computer}
		onMeCheck 64
		lookStr {This is the Data Retrieval console.}
	)
)

(instance controlPanel of Feature
	(properties
		description {control panel}
		onMeCheck 2
		lookStr {This is the control panel for the Data Retrieval console.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: lookAtMonitor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lights of Feature
	(properties
		description {lights}
		onMeCheck 16
		lookStr {These are some highly decorative illumination devices for the console.}
	)
)

(instance egoFeat of Feature
	(properties
		description {yourself}
		onMeCheck 8
		lookStr {It's you and you're darned handsome if you do say so yourself.}
	)
)

(instance buttons of Feature
	(properties
		description {buttons}
		onMeCheck 128
		lookStr {Buttons reside here. You hate buttons. They confuse you so.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: pushButtons)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beep of Sound
	(properties)
)

(class FastHand of View
	(properties
		onMeCheck 0
		view 502
		cel 2
		priority 14
		signal 16
	)

	(method (internalEvent &tmp temp0 temp1 temp2)
		(= temp0 (User curEvent:))
		(myCast add: self)
		(gGame setCursor: 69 1)
		(self show: x: temp1 y: temp2) ; UNINIT, UNINIT
		(repeat
			(temp0 type: evNULL message: JOY_NULL modifiers: $0000 y: 0 x: 0 claimed: 0 port: 0)
			(GetEvent 32767 temp0)
			(temp0 localize:)
			(= temp1 (temp0 x:))
			(= temp2 (temp0 y:))
			(cond
				((not (InRect 224 115 295 187 temp1 temp2))
					(break)
				)
				((& (temp0 type:) evMOUSEKEYBOARD)
					(if
						(or
							(& (temp0 type:) evKEYBOARD)
							(if (& (temp0 type:) evMOUSEBUTTON)
								(not (temp0 modifiers:))
							else
								(continue)
							)
						)
						(User handleEvent: temp0)
					)
				)
				(else
					(= x temp1)
					(= y temp2)
					(if (keyFlashScript register:)
						(keyFlashScript doit:)
						(gSounds eachElementDo: #doit)
					)
					(switch (gCurRoom script:)
						(lowerPad
							(break)
						)
						(EnterScript
							(EnterScript doit:)
							(gSounds eachElementDo: #doit)
						)
					)
					(Animate (myCast elements:) 0)
					(super doit:)
				)
			)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(self hide:)
		(myCast delete: self)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (User curEvent:))
		(if (not (& (temp0 type:) $0007)) ; evMOUSEKEYBOARD | evMOUSERELEASE
			(temp0 localize:)
			(= temp1 (temp0 x:))
			(= temp2 (temp0 y:))
			(if
				(and
					(InRect 224 115 295 187 temp1 temp2)
					(not (gCurRoom script:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(self internalEvent:)
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

(instance hand of FastHand
	(properties)
)

(instance keyPad of View
	(properties
		x 238
		y 185
		z -20
		description {keypad}
		lookStr {Enter a Code Sequence to retrieve Data cartridges.}
		view 502
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 2)
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
		(if (not (gCurRoom script:))
			(self setScript: keyFlashScript self tone)
		)
	)

	(method (cue)
		(if strToCat
			(if (< (StrLen theString) maxLen)
				(localproc_0)
				(StrCat theString strToCat)
				((ScriptID 700 0) ; arcadaRegion
					saveBits:
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
			else
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
				)
			)
		)
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
		view 502
		loop 1
		cel 9
		signal 16384
		strToCat {J}
		tone 350
	)
)

