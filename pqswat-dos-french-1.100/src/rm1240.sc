;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1240)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1240 0
)

(local
	local0
	local1
)

(instance rm1240 of PQRoom
	(properties
		picture 1240
	)

	(method (init)
		(if (!= 10308 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10308)
			(gBackMusic number: 10308 loop: -1 play:)
			(Lock rsAUDIO 10308 1)
		)
		(Load rsVIEW 12404)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(northExit init:)
		(westExit init:)
		(self setScript: enterRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(if (== local0 2)
					(gCurRoom setScript: do1300)
				else
					(gCurRoom setScript: shootWall)
				)
			)
			(6
				(if (== local0 2)
					(gCurRoom setScript: do1300)
				else
					(gCurRoom setScript: shootWall)
				)
			)
			(16
				(if (== local0 2)
					(gCurRoom setScript: throwBang1300)
				else
					(gCurRoom setScript: throwBang)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify)
		(switch local0
			(0
				(if
					(or
						(and (proc4_11 56) (proc4_11 51) (== global149 2))
						(and (proc4_11 56) (== global149 1))
					)
					(gCurRoom setScript: crankUpMirror)
				else
					(gCurRoom setScript: timeOut)
					(return -1)
				)
			)
			(1
				(if (and (proc4_11 46) (== global149 1))
					(gCurRoom setScript: moveScript)
				else
					(gCurRoom setScript: timeOut)
					(return -1)
				)
			)
			(2
				(gCurRoom setScript: do1300)
				(return -1)
			)
		)
	)

	(method (dispose)
		(actionTimer dispose: delete:)
		(super dispose: &rest)
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 62 1 1 self) ; "Ready to move. Go!"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 12410 161 -32)
			)
			(3
				(gGame showCloseUp: 12405 180 66 self 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(proc4_6 12407 334 -60)
			)
			(5
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance throwBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(= local1 (+ 12400 (Random 0 2)))
				(Load rsAUDIO 1002 1003 10314 local1)
				(Load rsVIEW 6 12405)
				(Load rsPIC 0)
				(= seconds 2)
			)
			(1
				(tossedFB init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 0 play:)
			)
			(2
				(tossedFB dispose:)
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 0 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(gMessager say: 5 7 0 1) ; "Compromised!"
				(whiteScreen dispose:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(gGame showCloseUp: 12404 180 66 self 1)
			)
			(7
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(8
				(gFxSound number: local1 setLoop: 0 play: self)
			)
			(9
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(10
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance throwBang1300 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 1003 10314)
				(Load rsVIEW 6 12405)
				(= seconds 1)
			)
			(1
				(tossedFB init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 0 play:)
			)
			(2
				(tossedFB dispose:)
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 0 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(whiteScreen dispose:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(gCurRoom setScript: do1300)
				(self dispose:)
			)
		)
	)
)

(instance shootWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 12400)
				(= seconds 1)
			)
			(1
				(militiaMan
					view: 12400
					x: 357
					y: 200
					init:
					setCycle: CT 30 1 self
				)
			)
			(2
				(militiaMan setCycle: CT 41 1 self)
				(gMessager say: 5 7 0 0) ; "Compromised!"
			)
			(3
				(militiaMan setCycle: End self)
				(gunShot dispose:)
			)
			(4
				(militiaMan dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 12701 10314)
				(Load rsVIEW 12700 12701)
				(Load rsPIC 1270)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1270)
				(egoProp view: 12700 posn: 237 235 init: setCycle: CT 43 1 self)
				(militiaMan
					view: 12701
					posn: 468 409
					setLoop: 0
					setCel: 0
					init:
				)
				(theBox init:)
			)
			(2
				(egoProp setCycle: End self)
				(militiaMan setCycle: CT 12 1 self)
			)
			(3
				(gFxSound number: 12701 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(4)
			(5
				(militiaMan dispose:)
				(egoProp dispose:)
				(theBox dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(6
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(7
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 12403 161 -32)
			)
			(1
				(setUpElement doit: 1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crankUpMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 12409 57)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 40 2 1 self) ; "Carmichael, ready to mirror."
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 12409 161 -32)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(setUpElement doit: 2)
				(gGame handsOn:)
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance timeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314)
				(= seconds 1)
			)
			(1
				(proc4_6 12400 286 -17)
			)
			(2
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1200 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 12014 12400)
				(Load rsPIC 1200 1240)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1200)
				(tello view: 12014 posn: 427 382 setCel: 0 init:)
				(= seconds 2)
			)
			(2
				(tello dispose:)
				(setUpElement doit: 2)
				(gCurRoom drawPic: 1240)
				(militiaMan
					view: 12400
					x: 357
					y: 200
					init:
					setCycle: CT 30 1 self
				)
			)
			(3
				(militiaMan setCycle: End self)
			)
			(4
				(militiaMan dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1290 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsPIC 1200 1290)
				(= seconds 2)
			)
			(1
				(gCurRoom drawPic: 1290)
				(proc4_6 12900 14 -17)
			)
			(2
				(gFxSound number: 53 setLoop: 0 play:)
			)
			(3
				(gCurRoom setScript: do1300)
				(self dispose:)
			)
		)
	)
)

(instance do1300 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 13000 13003)
				(Load rsAUDIO 13005 13003 10314)
				(Load rsPIC 1300)
				(= seconds 2)
			)
			(1
				(gFxSound number: 13005 setLoop: 0 play: self)
			)
			(2
				(gCurRoom drawPic: 1300)
				(tello view: 13000 posn: 367 358 init:)
				(militiaMan
					view: 13003
					posn: 91 240
					init:
					setCycle: CT 11 1 self
				)
			)
			(3
				(gFxSound number: 13003 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(4
				(militiaMan dispose:)
				(tello dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootYourFriends of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 6007 10314)
				(= seconds 1)
			)
			(1
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 1)
			)
			(2
				(switch register
					(denton
						(gGame showCloseUp: 9020 180 66 self 1)
					)
					(carMike
						(gGame showCloseUp: 9008 180 66 self 1)
					)
					(wix
						(gGame showCloseUp: 9014 180 66 self 1)
					)
				)
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(4
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance theBox of View
	(properties
		x 237
		y 235
		view 12700
		loop 1
	)
)

(instance carMike of Prop
	(properties)

	(method (cue)
		(actionTimer setReal: actionTimer 3)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 3 29 0 0 self) ; "Carmichael..."
			)
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop
	(properties)

	(method (cue)
		(actionTimer setReal: actionTimer 3)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 4 29 0 0 self) ; "Denton..."
			)
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wix of Prop
	(properties)

	(method (cue)
		(actionTimer setReal: actionTimer 3)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 2 29 0 0 self) ; "Wixell..."
			)
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tello of Prop
	(properties)
)

(instance egoProp of Prop
	(properties)
)

(instance militiaMan of Prop
	(properties)

	(method (doit)
		(if (not (gunShot handle:))
			(switch view
				(12400
					(if (and (== cel 24) (not (gunShot handle:)))
						(gunShot number: 53 play:)
					)
				)
			)
		)
		(super doit:)
	)
)

(instance tossedFB of Prop
	(properties
		x 472
		y 255
		view 12405
	)
)

(instance northExit of HotSpot
	(properties
		nsLeft 363
		nsRight 573
		nsBottom 180
		type 4097
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (== local0 2)
					(gCurRoom setScript: do1290)
				else
					(gCurRoom setScript: do1270)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance westExit of HotSpot
	(properties
		nsRight 126
		nsBottom 359
		type 32769
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (!= local0 2)
					(gCurRoom setScript: do1200)
				else
					(= global415 0)
					(gCurRoom newRoom: 1300) ; s3_1300
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(carMike dispose:)
				(denton dispose:)
				(wix dispose:)
			)
			(1
				(carMike
					view: 12404
					setLoop: 0
					setCel: 1
					posn: 348 46
					init:
					setPri: 500
				)
				(denton
					view: 12404
					setLoop: 0
					setCel: 2
					posn: 348 46
					init:
					setPri: 500
				)
				(wix
					view: 12404
					setLoop: 0
					setCel: 0
					posn: 348 46
					init:
					setPri: 500
				)
			)
			(2
				(carMike
					view: 12409
					setLoop: 0
					setCel: 2
					posn: 228 16
					init:
					setPri: 500
				)
				(denton
					view: 12409
					setLoop: 0
					setCel: 1
					posn: 228 16
					init:
					setPri: 500
				)
				(wix
					view: 12409
					setLoop: 0
					setCel: 0
					posn: 228 16
					init:
					setPri: 500
				)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(if (== local0 2)
			(gCurRoom setScript: do1300)
		else
			(gCurRoom setScript: timeOut)
		)
		(self dispose: delete:)
	)
)

(instance whiteScreen of View
	(properties
		x 289
		y 179
		priority 500
		fixPriority 1
		view 6
	)
)

(instance gunShot of Sound
	(properties)
)

