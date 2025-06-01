;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 541)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use MoveToY)
(use eRS)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm541 0
)

(local
	[local0 3] = [9 20 31]
	[local3 3] = [7 17 27]
	[local6 5] = [6 16 26 36 48]
	local11
	[local12 4]
)

(procedure (localproc_0)
	(Display
		{888}
		dsCOORD
		(+ (keyPad x:) 54)
		(+ (keyPad y:) [local0 local11])
		dsCOLOR
		global129
		dsALIGN
		alLEFT
		dsFONT
		30
	)
)

(procedure (localproc_1 param1 param2 param3)
	(param1
		nsLeft: (param1 x:)
		nsTop: (param1 y:)
		nsRight: (+ (param1 x:) param2)
		nsBottom: (+ (param1 y:) param3)
	)
)

(instance rm541 of SQRoom
	(properties
		picture 541
		north 525
		south 540
		vanishingX 0
		vanishingY -30
	)

	(method (init &tmp temp0 temp1 temp2)
		(LoadMany rsVIEW 516 502 517 515)
		(Load rsCURSOR 69)
		(Load rsSOUND 854 855 856 857 858 859 860 861 862 863 885 153)
		(gEgo init:)
		(self setRegions: 704) ; brain
		(super init:)
		(gLongSong number: 885 loop: -1 vol: 127 playBed:)
		(brain
			makePolygon: 0 0 33 0 215 189 0 189
			makePolygon: 40 0 318 0 319 189 241 189 219 165 192 157
			level: 2
		)
		(gGame setCursor: 69 1)
		(smallKeyPad init:)
		(= temp1 0)
		(if (>= (= temp2 global185) 4096)
			(= temp1 1)
			(-= temp2 4096)
		)
		(if temp1
			(smoke0 setCel: 3 init: stopUpd:)
			(smoke1 setCel: 3 init: stopUpd:)
			(smoke2 setCel: 3 init: stopUpd:)
		)
		(= temp0 (mod temp2 16))
		(beam0 setLoop: temp1 setCel: temp0 init:)
		(= temp0 (mod (/= temp2 16) 16))
		(beam1 setLoop: temp1 setCel: temp0 init:)
		(= temp0 (/= temp2 16))
		(beam2 setLoop: temp1 setCel: temp0 init:)
		(switch gPrevRoomNum
			(north
				(self setScript: enterScript 0 1)
			)
			(else
				(self setScript: enterScript 0 3)
			)
		)
		(roomFeature init:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber (gCurRoom south:)) (brain formatting:))
			(EgoDead 0 19) ; "As you leave the laser tunnel, you hear a metallic voice announce that the formatting program is beginning, erasing all data in the super computer and dashing all hopes of regaining your son!"
		else
			(gLongSong fade:)
			(if (gCast contains: smoke0)
				(= global185 4096)
			else
				(= global185 0)
			)
			(= global185
				(+
					(= global185
						(+
							(+= global185 (* (beam2 cel:) 256))
							(* (beam1 cel:) 16)
						)
					)
					(beam0 cel:)
				)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((== ((gInventory at: 12) state:) 1) ; cigar
				(self setScript: smokeScript)
				((gInventory at: 12) state: 0) ; cigar
			)
			((StepOn gEgo 8)
				(brain exitDir: (if (> (gEgo y:) 100) 135 else 315))
			)
		)
	)
)

(instance smallKeyPad of Feature
	(properties
		x 248
		y 147
		nsTop 136
		nsLeft 240
		nsBottom 158
		nsRight 256
		description {keypad}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(gCurRoom setScript: startKeyPadScript)
			)
			(1 ; Look
				(gCurRoom setScript: startKeyPadScript)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beam0 of Prop
	(properties
		x 190
		y 157
		description {beam}
		sightAngle 90
		view 516
		cel 9
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if loop
			(= lookStr {The beams glow dully in the smokey air.})
		else
			(= lookStr {You see what looks like beam emitters, but no beams.})
		)
	)

	(method (cue)
		(rotate stop:)
		(super cue:)
		(gNarrator enable: 0)
		(self setScript: 0)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (gCurRoom script:))
				(!= cel 7)
				(<
					(GetDistance (self x:) (self y:) (gEgo x:) (gEgo y:))
					5
				)
			)
			(gCurRoom setScript: egoFryScript)
		)
	)
)

(instance beam1 of Prop
	(properties
		x 151
		y 117
		description {beam}
		sightAngle 90
		view 516
		cel 5
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if loop
			(= lookStr {The beams glow dully in the smokey air.})
		else
			(= lookStr {You see what looks like beam emitters, but no beams.})
		)
	)

	(method (cue)
		(rotate stop:)
		(super cue:)
		(gNarrator enable: 0)
		(self setScript: 0)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (gCurRoom script:))
				(!= cel 7)
				(<
					(GetDistance (self x:) (self y:) (gEgo x:) (gEgo y:))
					5
				)
			)
			(gCurRoom setScript: egoFryScript)
		)
	)
)

(instance beam2 of Prop
	(properties
		x 110
		y 77
		description {beam}
		sightAngle 90
		view 516
		cel 13
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if loop
			(= lookStr {The beams glow dully in the smokey air.})
		else
			(= lookStr {You see what looks like beam emitters, but no beams.})
		)
	)

	(method (cue)
		(rotate stop:)
		(super cue:)
		(gNarrator enable: 0)
		(self setScript: 0)
		(if (and (== cel 7) (== (beam0 cel:) 7) (== (beam1 cel:) 7))
			(SetScore 59 15)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (gCurRoom script:))
				(!= cel 7)
				(<
					(GetDistance (self x:) (self y:) (gEgo x:) (gEgo y:))
					5
				)
			)
			(gCurRoom setScript: egoFryScript)
		)
	)
)

(instance smoke0 of Prop
	(properties
		x 191
		y 122
		view 517
		priority 1
		signal 16384
		cycleSpeed 2
	)
)

(instance smoke1 of Prop
	(properties
		x 168
		y 94
		view 517
		loop 1
		priority 1
		signal 16384
		cycleSpeed 2
	)
)

(instance smoke2 of Prop
	(properties
		x 130
		y 54
		view 517
		loop 2
		priority 1
		signal 16384
		cycleSpeed 2
	)
)

(instance blinker of Prop
	(properties
		view 502
		loop 2
		priority 14
		signal 16400
	)

	(method (doit)
		(super doit:)
		(self x: (+ (keyPad x:) 53) y: (+ (keyPad y:) [local0 local11] 4))
	)
)

(instance hand of View
	(properties
		view 502
		cel 2
		priority 15
		signal 16
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (User curEvent:))
		(if (not (& (temp0 type:) $0007)) ; evMOUSEKEYBOARD | evMOUSERELEASE
			(GlobalToLocal temp0)
			(= temp1 (temp0 x:))
			(= temp2 (+ (temp0 y:) 10))
			(if
				(InRect
					(keyPad x:)
					(keyPad y:)
					(+
						(keyPad x:)
						(CelWide (keyPad view:) (keyPad loop:) (keyPad cel:))
					)
					(+
						(keyPad y:)
						(CelHigh (keyPad view:) (keyPad loop:) (keyPad cel:))
					)
					temp1
					temp2
				)
				(gGame setCursor: 69 1)
				(self show: x: temp1 y: temp2)
			else
				(gGame setCursor: gNormalCursor 1)
				(self hide:)
			)
		)
		(super doit:)
	)
)

(instance keyPad of View
	(properties
		x 220
		y 40
		view 502
	)

	(method (init)
		(super init: &rest)
		(self signal: 257)
		(gWalkHandler addToFront: self)
		(gPrints addToFront: self)
		(User mapKeyToDir: 0)
		(gNarrator disable:)
		(oneBut init: @local12 who: oneDown)
		(twoBut init: @local12 who: twoDown)
		(threeBut init: @local12 who: threeDown)
		(fourBut init: @local12 who: fourDown)
		(fiveBut init: @local12 who: fiveDown)
		(sixBut init: @local12 who: sixDown)
		(sevenBut init: @local12 who: sevenDown)
		(eightBut init: @local12 who: eightDown)
		(nineBut init: @local12 who: nineDown)
		(zeroBut init: @local12 who: zeroDown)
		(enterBut init:)
		(quitBut init:)
		(oneDown init: hide:)
		(twoDown init: hide:)
		(threeDown init: hide:)
		(fourDown init: hide:)
		(fiveDown init: hide:)
		(sixDown init: hide:)
		(sevenDown init: hide:)
		(eightDown init: hide:)
		(nineDown init: hide:)
		(zeroDown init: hide:)
		(enterDown init: hide:)
		(hand init: hide: x: (+ (keyPad x:) 50) y: (+ (keyPad y:) 20))
		(blinker init: setCycle: Fwd)
		(gNarrator curIcon: (gNarrator at: 1))
	)

	(method (dispose)
		(super dispose: &rest)
		(User mapKeyToDir: 1)
		(gGame setCursor: ((gNarrator curIcon:) cursor:) 1)
		(gPrints delete: self)
		(gWalkHandler delete: self)
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
		(oneDown dispose:)
		(twoDown dispose:)
		(threeDown dispose:)
		(fourDown dispose:)
		(fiveDown dispose:)
		(sixDown dispose:)
		(sevenDown dispose:)
		(eightDown dispose:)
		(nineDown dispose:)
		(zeroDown dispose:)
		(enterDown dispose:)
		(blinker dispose:)
		(hand dispose:)
		(HandsOn)
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(event claimed: 1)
		)
	)
)

(class KeyPadButton of Feature
	(properties
		theString 0
		strToCat 0
		keyEquiv 0
		maxLen 0
		who 0
		tone 0
	)

	(method (init param1)
		(super init:)
		(= theString param1)
		(gWalkHandler addToFront: self)
		(gPrints addToFront: self)
	)

	(method (dispose)
		(gPrints delete: self)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(cond
					((InRect nsLeft nsTop nsRight nsBottom event)
						(event claimed: 1)
						(self doit:)
					)
					((== (event message:) keyEquiv)
						(event claimed: 1)
						(self doit:)
					)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(event claimed: 1)
					(self doit:)
				)
			)
		)
	)

	(method (doit)
		(who setScript: (Clone keyFlashScript) 0 tone)
		(if (< (StrLen theString) maxLen)
			(localproc_0)
			(StrCat theString strToCat)
			(Display
				theString
				dsCOORD
				(+ (keyPad x:) 54 (* (- maxLen (StrLen theString)) 4))
				(+ (keyPad y:) [local0 local11])
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

(instance beep of Sound
	(properties)
)

(instance rotate of Sound
	(properties
		number 153
	)
)

(instance keyFlashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client show:)
				(beep number: register play:)
				(= cycles 2)
			)
			(1
				(client hide: setScript: 0)
			)
		)
	)
)

(class CA of Cycle
	(properties
		celCnt 0
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(= celCnt (if (< param2 1) 1 else param2))
		(if (== argc 3)
			(= caller param3)
		)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (client lastCel:))
		(= temp0 (self nextCel:))
		(client cel: (if (> temp0 temp1) 0 else temp0))
		(-- celCnt)
		(if (not celCnt)
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
	)
)

(instance enterBut of Feature
	(properties)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((super handleEvent: event))
			(
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(MousedOn self event)
				)
				(event claimed: 1)
				(enterDown setScript: (Clone keyFlashScript) 0 864)
				(localproc_0)
				(= temp0 (ReadNumber @local12))
				(= temp2 (StrLen @local12))
				(= local12 0)
				(if (or (> temp0 360) (< temp0 1) (< temp2 3))
					0
				else
					(gNarrator disable:)
					(= temp1 (/ temp0 12))
					(switch local11
						(0
							(if (not temp1)
								(beam0 cue:)
							else
								(rotate play:)
								(beam0 setCycle: CA temp1 beam0)
							)
						)
						(1
							(if (not temp1)
								(beam1 cue:)
							else
								(rotate play:)
								(beam1 setCycle: CA temp1 beam1)
							)
						)
						(2
							(if (not temp1)
								(beam2 cue:)
							else
								(rotate play:)
								(beam2 setCycle: CA temp1 beam2)
							)
						)
					)
				)
				(if (> (++ local11) 2)
					(= local11 0)
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
		(gPrints addToEnd: self)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 3]))
		(localproc_1 self 19 8)
	)

	(method (dispose)
		(super dispose: &rest)
		(gWalkHandler delete: self)
		(gPrints delete: self)
	)
)

(instance quitBut of Feature
	(properties)

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
				(= local12 0)
				(keyPad dispose:)
				(gNarrator enable:)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
		(gPrints addToFront: self)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 4]))
		(localproc_1 self 19 8)
	)

	(method (dispose)
		(super dispose: &rest)
		(beep number: 865 play:)
		(gWalkHandler delete: self)
		(gPrints delete: self)
	)
)

(instance oneBut of KeyPadButton
	(properties
		strToCat {1}
		keyEquiv 49
		maxLen 3
		tone 854
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 0]))
		(localproc_1 self 8 8)
	)
)

(instance twoBut of KeyPadButton
	(properties
		strToCat {2}
		keyEquiv 50
		maxLen 3
		tone 855
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 1]) y: (+ (keyPad y:) [local6 0]))
		(localproc_1 self 8 8)
	)
)

(instance threeBut of KeyPadButton
	(properties
		strToCat {3}
		keyEquiv 51
		maxLen 3
		tone 856
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 2]) y: (+ (keyPad y:) [local6 0]))
		(localproc_1 self 8 8)
	)
)

(instance fourBut of KeyPadButton
	(properties
		strToCat {4}
		keyEquiv 52
		maxLen 3
		tone 857
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 1]))
		(localproc_1 self 8 8)
	)
)

(instance fiveBut of KeyPadButton
	(properties
		strToCat {5}
		keyEquiv 53
		maxLen 3
		tone 858
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 1]) y: (+ (keyPad y:) [local6 1]))
		(localproc_1 self 8 8)
	)
)

(instance sixBut of KeyPadButton
	(properties
		strToCat {6}
		keyEquiv 54
		maxLen 3
		tone 859
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 2]) y: (+ (keyPad y:) [local6 1]))
		(localproc_1 self 8 8)
	)
)

(instance sevenBut of KeyPadButton
	(properties
		strToCat {7}
		keyEquiv 55
		maxLen 3
		tone 860
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 2]))
		(localproc_1 self 8 8)
	)
)

(instance eightBut of KeyPadButton
	(properties
		strToCat {8}
		keyEquiv 56
		maxLen 3
		tone 861
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 1]) y: (+ (keyPad y:) [local6 2]))
		(localproc_1 self 8 8)
	)
)

(instance nineBut of KeyPadButton
	(properties
		strToCat {9}
		keyEquiv 57
		maxLen 3
		tone 862
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 2]) y: (+ (keyPad y:) [local6 2]))
		(localproc_1 self 8 8)
	)
)

(instance zeroBut of KeyPadButton
	(properties
		strToCat {0}
		keyEquiv 48
		maxLen 3
		tone 863
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 2]) y: (+ (keyPad y:) [local6 3]))
		(localproc_1 self 8 8)
	)
)

(instance oneDown of Prop
	(properties
		view 502
		loop 1
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 0]))
	)
)

(instance twoDown of Prop
	(properties
		view 502
		loop 1
		cel 1
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 1]) y: (+ (keyPad y:) [local6 0]))
	)
)

(instance threeDown of Prop
	(properties
		view 502
		loop 1
		cel 2
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 2]) y: (+ (keyPad y:) [local6 0]))
	)
)

(instance fourDown of Prop
	(properties
		view 502
		loop 1
		cel 3
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 1]))
	)
)

(instance fiveDown of Prop
	(properties
		view 502
		loop 1
		cel 4
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 1]) y: (+ (keyPad y:) [local6 1]))
	)
)

(instance sixDown of Prop
	(properties
		view 502
		loop 1
		cel 5
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 2]) y: (+ (keyPad y:) [local6 1]))
	)
)

(instance sevenDown of Prop
	(properties
		view 502
		loop 1
		cel 6
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 2]))
	)
)

(instance eightDown of Prop
	(properties
		view 502
		loop 1
		cel 7
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 1]) y: (+ (keyPad y:) [local6 2]))
	)
)

(instance nineDown of Prop
	(properties
		view 502
		loop 1
		cel 8
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 2]) y: (+ (keyPad y:) [local6 2]))
	)
)

(instance zeroDown of Prop
	(properties
		view 502
		loop 1
		cel 9
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 2]) y: (+ (keyPad y:) [local6 3]))
	)
)

(instance enterDown of Prop
	(properties
		view 502
		loop 1
		cel 10
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local3 0]) y: (+ (keyPad y:) [local6 3]))
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== register 1)
					(= temp0 47)
					(= temp1 7)
					(= temp2 33)
					(= temp3 135)
				else
					(= temp0 277)
					(= temp1 242)
					(= temp2 (- 189 (* (gEgo yStep:) 4)))
					(= temp3 315)
				)
				(gEgo
					illegalBits: 0
					x: temp0
					y: temp1
					setHeading: temp3
					setMotion: MoveToY temp2 self
				)
			)
			(1
				(gEgo illegalBits: $8000 setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoFryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(beam0 setPri: 9)
				(beam1 setPri: 7)
				(beam2 setPri: 3)
				(gEgo view: 515 setLoop: 4 setCycle: Fwd)
				(gLongSong2 number: 139 vol: 127 loop: 1 play:)
				(= cycles 8)
			)
			(1
				(gEgo setLoop: 5 setCel: 0 cycleSpeed: 1 setCycle: End)
				(= seconds 5)
			)
			(2
				(EgoDead 8) ; "We're glad you could play SQIV.__As usual, you've been a real pantload."
			)
		)
	)
)

(instance smokeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 216 181 self)
			)
			(1
				(gEgo view: 515 setLoop: 2 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
				(gLongSong2 number: 846 vol: 127 loop: 1 play:)
			)
			(3
				(smoke0 init: setCycle: End)
				(= cycles 2)
			)
			(4
				(NormalEgo 7 0)
				(beam0
					setLoop: 1
					lookStr: {The beams glow dully in the smokey air.}
				)
				(smoke1 init: setCycle: End)
				(= cycles 2)
			)
			(5
				(beam1
					setLoop: 1
					lookStr: {The beams glow dully in the smokey air.}
				)
				(smoke2 init: setCycle: End self)
			)
			(6
				(smoke0 stopUpd:)
				(smoke1 stopUpd:)
				(smoke2 stopUpd:)
				(beam2
					setLoop: 1
					lookStr: {The beams glow dully in the smokey air.}
				)
				(= cycles 6)
			)
			(7
				(Print 541 0) ; "You cast the old stogie to the ground."
				(gEgo put: 12 gCurRoomNum) ; cigar
				(SetScore 58 10)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance startKeyPadScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (smallKeyPad x:) (smallKeyPad y:) self
				)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(HandsOn)
				(keyPad init:)
				(self dispose:)
			)
		)
	)
)

(instance roomFeature of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {laser tunnel}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (>= global185 4096)
					(Print 541 1) ; "Thin cigar smoke fills the long tunnel, making the laser beams glow dully."
				else
					(Print 541 2) ; "This long tunnel contains three circular steel bands, each containing nozzle-like projections."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

