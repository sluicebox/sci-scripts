;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1460)
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
	rm1460 0
)

(local
	local0
)

(instance rm1460 of PQRoom
	(properties
		picture 1460
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (init)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(= gPrevRoomNum 1530)
			(= global415 1)
		)
		(if (!= 10305 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10305)
			(gBackMusic number: 10305 loop: -1 play:)
			(Lock rsAUDIO 10305 1)
		)
		(cond
			((== gPrevRoomNum 1490)
				(Load rsVIEW 14619 14621)
			)
			((== gPrevRoomNum 1530)
				(Load rsVIEW 14621)
			)
		)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init:)
		(cond
			((== gPrevRoomNum 1530)
				(gCurRoom setScript: roomIsClear)
			)
			((== gPrevRoomNum 1490)
				(gCurRoom setScript: inFrom1490)
			)
		)
	)

	(method (lashNotify)
		(switch local0
			(0
				(if (and (proc4_11 65) (proc4_11 66) (== global149 2))
					(gCurRoom setScript: bClearLeft)
				else
					(gCurRoom setScript: timeOut)
					(return -1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootWall)
			)
			(6
				(gCurRoom setScript: shootWall)
			)
			(16
				(gCurRoom setScript: tossBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tossBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44 53 1002 10314)
				(Load rsVIEW 6)
				(= seconds 1)
			)
			(1
				(whiteScreen init:)
				(sound1 number: 1002 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(2
				(whiteScreen dispose:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gMessager say: 6 16 0 0 self) ; "Status! Status!"
			)
			(6
				(sound1 number: 44 play: self)
				(sound2 number: 53 play: self)
			)
			(7)
			(8
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(9
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(Load rsAUDIO 6007)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 14208 180 66 self 1)
			)
			(2
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance bClearLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 129 1 2 self) ; "Entry Team B, prepare to clear left. Move!"
			)
			(1
				(gCurRoom newRoom: 1490)
			)
		)
	)
)

(instance do1470 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314)
				(Load rsVIEW 14712)
				(Load rsPIC 1470)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1470)
				(militiaMan view: 14712 posn: 196 230 init: setPri: 10)
				(proc4_6 14716 0 0 0 0 275 1)
			)
			(2
				(militiaMan setCycle: CT 28 1)
			)
			(3
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1430 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 15 10314)
				(Load rsVIEW 14208 14220 14207)
				(Load rsPIC 1420)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1420)
				(door cycleSpeed: 0 setPri: 205 init:)
				(element
					view: 14208
					setCel: 0
					setLoop: 0
					posn: 245 98
					init:
					setPri: 240
				)
				(= cycles 1)
			)
			(2
				(militiaMan
					view: 14207
					posn: 384 186
					init:
					setCycle: CT 7 1 self
				)
			)
			(3
				(militiaMan setCycle: CT 18 1 self)
				(door setCycle: End)
				(gFxSound number: 15 setLoop: 0 play:)
			)
			(4
				(militiaMan setCycle: CT 29 1 self)
				(gFxSound number: 53 setLoop: 2 play:)
			)
			(5
				(militiaMan setCycle: End self)
				(gFxSound stop:)
			)
			(6
				(militiaMan dispose:)
				(element dispose:)
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 53 setLoop: 1 play: self)
			)
			(8
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(9
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(Load rsAUDIO 44 53 1050)
				(= seconds 1)
			)
			(1
				(gFxSound number: 1050 setLoop: 1 play: self)
			)
			(2
				(gGame showCloseUp: 14632 180 66 self 1)
			)
			(3
				(sound1 number: 44 play: self)
				(sound2 number: 53 play: self)
			)
			(4)
			(5
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootYourFriend of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: actionTimer)
					(actionTimer dispose: delete:)
				)
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
					(carmike
						(gGame showCloseUp: 9008 180 66 self 1)
					)
					(denton
						(gGame showCloseUp: 9020 180 66 self 1)
					)
					(tello
						(gGame showCloseUp: 9028 180 66 self 1)
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

(instance roomIsClear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(tello view: 14621 posn: 25 411 setLoop: 2 init:)
				(wix view: 14621 posn: 257 214 init: setCycle: CT 5 1 self)
				(carmike view: 14621 setLoop: 1 setCel: 0 posn: 275 221 init:)
				(denton view: 14621 setLoop: 1 setCel: 1 posn: 275 221 init:)
			)
			(1
				(wix setCycle: End self)
				(gSwatInterface showHandAni: 6)
			)
			(2
				(northExit init:)
				(westExit init:)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance inFrom1490 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(tello
					view: 14619
					posn: 275 423
					setLoop: 0
					init:
					setCycle: End self
				)
				(wix view: 14621 posn: 257 214 init:)
				(carmike view: 14621 setLoop: 1 setCel: 0 posn: 275 221 init:)
				(denton view: 14621 setLoop: 1 setCel: 1 posn: 275 221 init:)
			)
			(1
				(= global415 1)
				(gCurRoom newRoom: 1420)
			)
		)
	)
)

(instance whatYouSay of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 143 0 0 self) ; "Repeat!"
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance westExit of HotSpot
	(properties
		nsRight 169
		nsBottom 358
		type 32769
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: do1470)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northExit of HotSpot
	(properties
		nsLeft 227
		nsRight 421
		nsBottom 249
		type 4097
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: do1430)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 367
		y 86
		view 14220
	)
)

(instance element of Prop
	(properties)
)

(instance militiaMan of Prop
	(properties
		x 445
		y 317
		view 14699
	)
)

(instance carmike of Prop
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
				(gMessager say: 4 29 0 0 self) ; "Carmichael..."
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
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
				(gMessager say: 5 29 0 0 self) ; "Denton..."
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tello of Prop
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
				(gMessager say: 2 29 0 0 self) ; "Tello..."
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
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
				(gMessager say: 3 29 0 0 self) ; "Wixell..."
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: timeOut)
		(self dispose: delete:)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(tello dispose:)
				(wix dispose:)
				(element dispose:)
				(carmike dispose:)
				(denton dispose:)
			)
		)
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

(instance sound1 of Sound
	(properties)
)

(instance sound2 of Sound
	(properties)
)

