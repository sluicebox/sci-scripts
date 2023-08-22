;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 514)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use eRS)
(use MCyc)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm514 0
)

(local
	local0 = 26229
	[local1 4] = [13 23 33 50]
	[local5 4] = [23 33 43 55]
	[local9 7]
	local16
	[local17 29] = [1 0 161 77 1 0 161 82 1 0 161 87 1 0 161 92 1 0 161 97 1 0 161 102 1 0 161 109 -32768]
)

(procedure (localproc_0)
	(Display
		{8888888888}
		dsCOORD
		(+ (keyPad x:) 18)
		(+ (keyPad y:) 9)
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

(instance rm514 of SQRoom
	(properties
		lookStr {The programming chamber looks like a museum of bio-mechanical hell.}
		picture 514
		style 10
		east 515
	)

	(method (init)
		(LoadMany rsVIEW 500 502)
		(LoadMany rsSOUND 102 124 154 155 101)
		(gEgo init:)
		(alarm1 init: stopUpd:)
		(alarm2 init: stopUpd:)
		(alarm3 init: stopUpd:)
		(if (not (IsFlag 68))
			(smallKeyPad init:)
			(doorTop init: stopUpd:)
			(doorBottom init: stopUpd:)
		else
			(chamber init: addToPic:)
		)
		(self setRegions: 704) ; brain
		(super init:)
		(brain
			makePolygon: 0 0 319 0 319 113 178 113 173 78 165 78 165 70 152 70 152 78 140 78 136 126 319 126 319 189 0 189
		)
		(self setScript: enterScript 0 (== gPrevRoomNum 515))
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 16)
				(gCurRoom newRoom: 544)
			)
			((StepOn gEgo 8)
				(brain exitDir: 90)
			)
		)
	)
)

(instance alarm1 of Prop
	(properties
		x 251
		y 70
		description {alarm light}
		lookStr {It's either an eye or a light bulb -- you're not sure which.}
		view 505
	)
)

(instance alarm2 of Prop
	(properties
		x 152
		y 77
		z 60
		description {alarm light}
		lookStr {It looks like a light of some kind.}
		view 505
		loop 1
		priority 9
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (and cycler (== cel 0))
			(gLongSong2 number: 101 loop: 1 play:)
		)
	)
)

(instance alarm3 of Prop
	(properties
		x 85
		y 61
		description {alarm light}
		lookStr {You get the feeling you're being watched.}
		view 505
		loop 2
	)
)

(instance enterDown of Prop
	(properties
		view 502
		loop 1
		cel 11
		priority 15
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 0]) y: (+ (keyPad y:) [local5 3]))
	)
)

(instance doorTop of Prop
	(properties
		x 139
		y 9
		description {top door}
		lookStr {The heavy iron door looks impenetrable.}
		view 500
	)
)

(instance doorBottom of Prop
	(properties
		x 161
		y 72
		description {bottom door}
		lookStr {The heavy iron door looks impenetrable.}
		view 500
		loop 1
		priority 2
		signal 16400
	)

	(method (onMe)
		(return (and (super onMe: &rest) (not (smallKeyPad onMe: &rest))))
	)
)

(instance lightTop of Prop
	(properties
		x 159
		y 30
		description {top light}
		lookStr {The light looks fluorescent.}
		view 500
		loop 3
	)
)

(instance lightBottom of Prop
	(properties
		x 159
		y 75
		description {bottom light}
		lookStr {The light looks fluorescent.}
		view 500
		loop 4
		signal 16384
	)
)

(instance chamber of View
	(properties
		x 161
		y 76
		description {chamber}
		lookStr {The chamber's interior is filled with hoses, tubes, and wires, and one computer terminal.}
		view 500
		loop 2
		priority 2
		signal 16400
	)
)

(instance droid of SecurityDroid
	(properties
		x 320
		y 122
		z 44
		description 8103
		lookStr 8118
		view 506
		cycleSpeed 1
		room 514
		level 2
	)

	(method (init)
		(= body droidBody)
		(super init: &rest)
		(self setCycle: Fwd)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(self setPri: 13)
		(if script
		else
			(= temp0 (self distanceTo: gEgo))
			(cond
				((== attacks 3)
					(self attack: 1)
				)
				((< temp0 50)
					(self attack: 1)
				)
				((< temp0 100)
					(self attack: 0)
				)
			)
		)
	)
)

(instance droidBody of Prop
	(properties
		view 506
		loop 1
	)

	(method (doit)
		(super doit:)
		(self
			x: (droid x:)
			y: (droid y:)
			setPri: (droid priority:)
			signal: (| (droid signal:) $4000)
		)
	)
)

(instance smallKeyPad of Feature
	(properties
		x 160
		y 56
		nsTop 52
		nsLeft 154
		nsBottom 61
		nsRight 166
		description {keypad}
		sightAngle 90
		lookStr {You see a small keypad.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: keyPadScript)
			)
			(2 ; Look
				(gCurRoom setScript: keyPadScript)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
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
		cel 1
		priority 8
	)

	(method (init)
		(super init: &rest)
		(self signal: 273)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(User mapKeyToDir: 0)
		(gTheIconBar disable:)
		(oneBut init: @local9 who: oneDown)
		(twoBut init: @local9 who: twoDown)
		(threeBut init: @local9 who: threeDown)
		(fourBut init: @local9 who: fourDown)
		(fiveBut init: @local9 who: fiveDown)
		(sixBut init: @local9 who: sixDown)
		(sevenBut init: @local9 who: sevenDown)
		(eightBut init: @local9 who: eightDown)
		(nineBut init: @local9 who: nineDown)
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
		(enterDown init: hide:)
		(hand init: hide: x: (+ (keyPad x:) 50) y: (+ (keyPad y:) 20))
		(gTheIconBar curIcon: (gTheIconBar at: 1))
		(super init:)
	)

	(method (dispose)
		(super dispose: &rest)
		(User mapKeyToDir: 1)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(oneBut dispose:)
		(twoBut dispose:)
		(threeBut dispose:)
		(fourBut dispose:)
		(fiveBut dispose:)
		(sixBut dispose:)
		(sevenBut dispose:)
		(eightBut dispose:)
		(nineBut dispose:)
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
		(enterDown dispose:)
		(hand dispose:)
		(super dispose:)
		(gTheIconBar enable:)
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
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(cond
					(
						(and
							(== (event message:) KEY_RETURN)
							(InRect nsLeft nsTop nsRight nsBottom event)
						)
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
			(++ local16)
			(Display
				theString
				dsCOORD
				(+ (keyPad x:) 18 (* (- maxLen (StrLen theString)) 4))
				(+ (keyPad y:) 9)
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
				(= temp0 (ReadNumber @local9))
				(= temp2 (StrLen @local9))
				(= local9 0)
				(keyPad dispose:)
				(if (== temp0 local0)
					(gCurRoom setScript: openDoorScript)
				else
					(gCurRoom setScript: alarmScript)
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToEnd: self)
		(self x: (+ (keyPad x:) [local1 3]) y: (+ (keyPad y:) [local5 0]))
		(localproc_1 self 8 33)
	)

	(method (dispose)
		(super dispose: &rest)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
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
				(= local9 0)
				(keyPad dispose:)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self x: (+ (keyPad x:) [local1 0]) y: (+ (keyPad y:) [local5 3]))
		(localproc_1 self 19 8)
	)

	(method (dispose)
		(super dispose: &rest)
		(beep number: 865 play:)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
	)
)

(instance oneBut of KeyPadButton
	(properties
		strToCat {1}
		keyEquiv 49
		maxLen 10
		tone 854
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 0]) y: (+ (keyPad y:) [local5 0]))
		(localproc_1 self 8 8)
	)
)

(instance twoBut of KeyPadButton
	(properties
		strToCat {2}
		keyEquiv 50
		maxLen 10
		tone 855
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 1]) y: (+ (keyPad y:) [local5 0]))
		(localproc_1 self 8 8)
	)
)

(instance threeBut of KeyPadButton
	(properties
		strToCat {3}
		keyEquiv 51
		maxLen 10
		tone 856
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 2]) y: (+ (keyPad y:) [local5 0]))
		(localproc_1 self 8 8)
	)
)

(instance fourBut of KeyPadButton
	(properties
		strToCat {4}
		keyEquiv 52
		maxLen 10
		tone 857
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 0]) y: (+ (keyPad y:) [local5 1]))
		(localproc_1 self 8 8)
	)
)

(instance fiveBut of KeyPadButton
	(properties
		strToCat {5}
		keyEquiv 53
		maxLen 10
		tone 858
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 1]) y: (+ (keyPad y:) [local5 1]))
		(localproc_1 self 8 8)
	)
)

(instance sixBut of KeyPadButton
	(properties
		strToCat {6}
		keyEquiv 54
		maxLen 10
		tone 859
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 2]) y: (+ (keyPad y:) [local5 1]))
		(localproc_1 self 8 8)
	)
)

(instance sevenBut of KeyPadButton
	(properties
		strToCat {7}
		keyEquiv 55
		maxLen 10
		tone 860
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 0]) y: (+ (keyPad y:) [local5 2]))
		(localproc_1 self 8 8)
	)
)

(instance eightBut of KeyPadButton
	(properties
		strToCat {8}
		keyEquiv 56
		maxLen 10
		tone 861
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 1]) y: (+ (keyPad y:) [local5 2]))
		(localproc_1 self 8 8)
	)
)

(instance nineBut of KeyPadButton
	(properties
		strToCat {9}
		keyEquiv 57
		maxLen 10
		tone 862
	)

	(method (init)
		(super init: &rest)
		(self x: (+ (keyPad x:) [local1 2]) y: (+ (keyPad y:) [local5 2]))
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
		(self x: (+ (keyPad x:) [local1 0]) y: (+ (keyPad y:) [local5 0]))
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
		(self x: (+ (keyPad x:) [local1 1]) y: (+ (keyPad y:) [local5 0]))
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
		(self x: (+ (keyPad x:) [local1 2]) y: (+ (keyPad y:) [local5 0]))
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
		(self x: (+ (keyPad x:) [local1 0]) y: (+ (keyPad y:) [local5 1]))
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
		(self x: (+ (keyPad x:) [local1 1]) y: (+ (keyPad y:) [local5 1]))
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
		(self x: (+ (keyPad x:) [local1 2]) y: (+ (keyPad y:) [local5 1]))
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
		(self x: (+ (keyPad x:) [local1 0]) y: (+ (keyPad y:) [local5 2]))
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
		(self x: (+ (keyPad x:) [local1 1]) y: (+ (keyPad y:) [local5 2]))
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
		(self x: (+ (keyPad x:) [local1 2]) y: (+ (keyPad y:) [local5 2]))
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(HandsOff)
				(if register
					(= temp0 318)
					(= temp1 122)
					(= temp2 288)
					(= temp3 122)
				else
					(= temp0 164)
					(= temp1 75)
					(= temp2 164)
					(= temp3 100)
				)
				(gEgo
					setPri: -1
					posn: temp0 temp1
					setMotion: PolyPath temp2 temp3 self
				)
			)
			(1
				(HandsOn)
				(if (gCast contains: doorTop)
					(gEgo observeControl: 2)
				)
				(SetScore 88 10)
				(self dispose:)
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable:)
				(SetScore 89 10)
				(gLongSong2 number: 124 loop: 1 vol: 127 play: self)
			)
			(1
				(gLongSong2 number: 154 loop: -1 play:)
				(doorTop cycleSpeed: 1 setCycle: End)
				(doorBottom setPri: 2 cycleSpeed: 1 setCycle: MCyc @local17 self)
				(smallKeyPad dispose:)
			)
			(2
				(gLongSong2 number: 155 loop: 1 play:)
				(doorTop dispose:)
				(doorBottom dispose:)
				(lightTop init: cycleSpeed: 1 setCycle: End)
				(lightBottom init: cycleSpeed: 1 setCycle: End self)
			)
			(3
				(HandsOn)
				(gTheIconBar enable:)
				(chamber init: addToPic:)
				(lightTop dispose:)
				(lightBottom dispose:)
				(gEgo ignoreControl: 2)
				(SetFlag 68)
				(self dispose:)
			)
		)
	)
)

(instance keyPadScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (> (gEgo distanceTo: smallKeyPad) 30)
					(gEgo setMotion: PolyPath 164 77 self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOn)
				(keyPad init:)
				(self dispose:)
			)
		)
	)
)

(instance alarmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(alarm1 setCycle: Fwd)
				(alarm2 setCycle: Fwd)
				(alarm3 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(droid init: setMotion: PolyPath (gEgo x:) (gEgo y:))
				(self dispose:)
			)
		)
	)
)

