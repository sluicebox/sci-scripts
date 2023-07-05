;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1470)
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
	rm1470 0
)

(local
	local0
	local1
	local2
)

(instance rm1470 of PQRoom
	(properties
		picture 1470
	)

	(method (init)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(= global415 0)
		)
		(if (!= 10304 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10304)
			(gBackMusic number: 10304 loop: -1 play:)
			(Lock rsAUDIO 10304 1)
		)
		(Load rsVIEW 14707)
		(Load rsMESSAGE 1470)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(eastExit init:)
		(westExit init:)
		(if global415
			(gGame handsOn:)
			(actionTimer setReal: actionTimer 6)
		else
			(self setScript: enterRoom)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(self setScript: shootWall)
			)
			(6
				(self setScript: shootWall)
			)
			(16
				(self setScript: tossBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify)
		(switch local0
			(0
				(cond
					((and (proc4_11 65) (proc4_11 66) (== global149 2))
						(if global415
							(self setScript: bClearLeft)
						else
							(self setScript: bKilledLeft)
						)
					)
					((and (proc4_11 65) (proc4_11 67) (== global149 2))
						(if global415
							(self setScript: timeOut)
							(return -1)
						else
							(self setScript: bClearRightC0)
						)
					)
					(else
						(gCurRoom setScript: badMove)
						(return -1)
					)
				)
			)
			(1
				(cond
					((and (proc4_11 65) (proc4_11 67) (== global149 2))
						(if global415
							(self setScript: bClearRight)
						else
							(self setScript: bKilledRight)
						)
					)
					((and (proc4_11 65) (proc4_11 66) (== global149 2))
						(if global415
							(self setScript: bKilledLeft)
						else
							(self setScript: bClearLeftC0)
						)
					)
					(else
						(gCurRoom setScript: badMove)
						(return -1)
					)
				)
			)
			(2
				(cond
					((and (proc4_11 65) (proc4_11 66) (== global149 2))
						(self setScript: bClearLeft3)
					)
					((and (proc4_11 65) (proc4_11 67) (== global149 2))
						(self setScript: bKilledRight)
					)
					(else
						(gCurRoom setScript: badMove)
						(return -1)
					)
				)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(actionTimer dispose: delete:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 14707 130 47)
			)
			(1
				(gSwatInterface showHandAni: 6)
			)
			(2
				(tello
					view: 14707
					setCel: 0
					setLoop: 2
					posn: 235 82
					setPri: 500
					init:
				)
				(proc4_5)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
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
				(gMessager say: 3 16 0 0 self) ; "Status! Status!"
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
				(Load rsAUDIO 10314 14901)
				(= seconds 1)
			)
			(1
				(tello dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(2
				(gMessager say: 3 7 0 0 self) ; "Compromised!"
			)
			(3
				(gFxSound number: 14901 setLoop: 0 play: self)
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

(instance bKilledRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314 14727)
				(Load rsVIEW 14727 14902)
				(Load rsPIC 1490 1470)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 14706 180 66 self 1)
			)
			(2
				(tello dispose:)
				(Palette 2 42 254 100) ; PalIntensity
				(proc4_6 14701 -37 -41)
			)
			(3
				(gAutoRobot setPri: 375)
			)
			(4
				(gAutoRobot setPri: 270)
			)
			(5
				(proc4_5)
				(gCurRoom drawPic: 1490)
				(proc4_6 14902 0 -60 22)
			)
			(6
				(rightSide init: setPri: 420)
			)
			(7
				(leftSide init: setPri: 420)
			)
			(8
				(rightSide dispose:)
				(leftSide dispose:)
				(proc4_5)
				(gCurRoom drawPic: 1470)
				(militiaMan view: 14727 posn: 51 283 init:)
				(proc4_6 14717 167 43 0 0 270 1)
			)
			(9
				(gAutoRobot setPri: 375)
			)
			(10
				(militiaMan setCycle: End)
			)
			(11
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(12
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(13
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance bClearLeft3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 14700)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 129 2 0 self) ; "Entry Team B, prepare to clear left. Go!"
			)
			(2
				(tello dispose:)
				(proc4_6 14700 0 26 296)
			)
			(3
				(tello view: 14700 posn: 186 95 setPri: 300 setLoop: 0 init:)
				(proc4_6 14710 -7 10 0 0 400 1)
			)
			(4
				(gAutoRobot setPri: 350)
			)
			(5
				(gCurRoom newRoom: 1480)
			)
		)
	)
)

(instance badMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 43 14901 10314)
				(Load rsPIC 1461)
				(Load rsVIEW 14691)
				(= seconds 1)
			)
			(1
				(gFxSound number: 14901 setLoop: 0 play: self)
			)
			(2
				(tello dispose:)
				(gCurRoom drawPic: 1461)
				(militiaMan
					view: 14691
					posn: 245 196
					setCel: 4
					init:
					setCycle: End self
				)
				(proc4_6 14615 56 29 0 0 260 1)
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
				(gFxSound number: 14901 setLoop: 0 play: self)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance bClearRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 14701)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 121 13 1 self) ; "Entry Team B, prepare to clear right. Go!"
			)
			(2
				(tello dispose:)
				(proc4_6 14700 0 26 131)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(proc4_5)
				(tello view: 14701 setLoop: 0 posn: 417 88 setPri: 84 init:)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance bKilledLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314 14715)
				(Load rsVIEW 14715)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 14705 180 66 self 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(tello dispose:)
				(proc4_6 14702 0 0 0 0 275 1)
			)
			(3
				(militiaMan
					view: 14715
					posn: 212 234
					init:
					setCycle: End
					setPri: 10
				)
			)
			(4
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1480 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 14901)
				(Load rsVIEW 14800)
				(Load rsPIC 1480)
				(= seconds 1)
			)
			(1
				(tello dispose:)
				(gCurRoom drawPic: 1480)
				(= cycles 1)
			)
			(2
				(militiaMan
					view: 14800
					posn: 303 281
					setCel: 3
					init:
					setCycle: CT 13 1 self
				)
			)
			(3
				(gFxSound number: 14901 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(4
				(gFxSound stop:)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1490 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 14901)
				(Load rsAUDIO 14901 10314)
				(Load rsPIC 1490)
				(= seconds 2)
			)
			(1
				(if (gCast contains: tello)
					(= local1 1)
					(tello dispose:)
				)
				(gCurRoom drawPic: 1490)
				(militiaMan view: 14901 posn: 377 249 init: setPri: 10)
				(proc4_6 14900 0 80 0 0 380 1)
			)
			(2
				(if local1
					(gMessager say: 0 135 5 1) ; "Pup, you're crossing my field of fire!"
				)
			)
			(3
				(militiaMan setCycle: CT 15 1 self)
			)
			(4
				(gFxSound number: 14901 setLoop: 0 play:)
				(militiaMan setCel: 16 setCycle: End)
			)
			(5
				(gFxSound stop:)
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(6
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(7
				(= global415 0)
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(Load rsVIEW 14700)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 129 6 0 self) ; "Entry Team B, prepare to clear left. Move!"
			)
			(2
				(proc4_6 14700 0 26 0 0 500)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(tello view: 14700 posn: 233 87 setLoop: 1 setPri: 500 init:)
				(proc4_5)
				(++ local0)
				(gGame handsOn:)
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
				(Load rsAUDIO 43 14901 10314)
				(Load rsPIC 1460)
				(Load rsVIEW 14691)
				(= seconds 1)
			)
			(1
				(gFxSound number: 14901 setLoop: 0 play: self)
			)
			(2
				(if (gCast contains: tello)
					(tello dispose:)
				)
				(gCurRoom drawPic: 1460)
				(militiaMan
					view: 14691
					posn: 245 196
					setCel: 4
					init:
					setCycle: End self
				)
				(proc4_6 14614 247 73 0 0 260 1)
			)
			(3)
			(4
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(gFxSound number: 14901 setLoop: 0 play: self)
			)
			(6
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(7
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootTello of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 6007 10314)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 9028 180 66 self 1)
			)
			(2
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(3
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

(instance killedEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 14712 10314)
				(Load rsVIEW 14712)
				(= seconds 1)
			)
			(1
				(militiaMan view: 14712 posn: 143 230 init: setPri: 10)
				(proc4_6 14703 -10 -16)
			)
			(2
				(militiaMan setCycle: End)
			)
			(3
				(tello dispose:)
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

(instance killedWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 14715)
				(= seconds 1)
			)
			(1
				(militiaMan view: 14715 posn: 212 234 init: setPri: 10)
				(proc4_6 14704 0 -34 0 0 -1 1)
			)
			(2
				(gAutoRobot setPri: 380)
			)
			(3
				(militiaMan setCycle: End)
			)
			(4
				(tello dispose:)
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance bClearRightC0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 14707)
				(= seconds 1)
			)
			(1
				(tello dispose:)
				(proc4_6 14707 130 47 44)
			)
			(2
				(gSwatInterface showHandAni: 6)
			)
			(3
				(tello
					view: 14707
					setCel: 0
					setLoop: 3
					posn: 401 90
					setPri: 84
					init:
				)
				(proc4_5)
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bClearLeftC0 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 14707)
				(= seconds 1)
			)
			(1
				(tello dispose:)
				(proc4_6 14707 130 47 187)
			)
			(2
				(tello
					view: 14707
					setCel: 0
					setLoop: 4
					posn: 162 90
					setPri: 300
					init:
				)
				(proc4_6 14710 -7 10 0 0 400 1)
			)
			(3
				(gAutoRobot setPri: 350)
			)
			(4
				(gCurRoom newRoom: 1480)
			)
		)
	)
)

(instance tello of Prop
	(properties)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: 2 29 0 0 self) ; "Tello..."
			)
			(7
				(gCurRoom setScript: shootTello)
			)
			(6
				(gCurRoom setScript: shootTello)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance militiaMan of Prop
	(properties
		x 245
		y 196
		view 14691
	)

	(method (doit)
		(super doit:)
		(cond
			((== view 14691)
				(if (and (== cel 11) (not (sound1 handle:)))
					(sound1 number: 43 play:)
				)
				(if (and (== cel 18) (not (sound2 handle:)))
					(sound2 number: 43 play:)
				)
			)
			((== view 14727)
				(if (and (== cel 7) (not (sound1 handle:)))
					(sound1 number: 14727 play:)
				)
			)
			((== view 14712)
				(if (and (== cel 9) (not (sound1 handle:)))
					(sound1 number: 14712 play:)
				)
			)
			((and (== view 14715) (== cel 8) (not (sound1 handle:)))
				(sound1 number: 14715 play:)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(if local0
			(gCurRoom setScript: badMove)
		else
			(gCurRoom setScript: timeOut)
		)
		(self dispose: delete:)
	)
)

(instance eastExit of HotSpot
	(properties
		nsLeft 165
		nsTop 39
		nsRight 419
		nsBottom 246
		type 8193
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (== local0 2)
					(gCurRoom setScript: killedEast)
				else
					(gCurRoom setScript: do1490)
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
		nsTop 39
		nsRight 160
		nsBottom 304
		type 32769
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (== local0 2)
					(gCurRoom setScript: killedWest)
				else
					(gCurRoom setScript: do1480)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftSide of View
	(properties
		x 133
		view 14902
	)
)

(instance rightSide of View
	(properties
		x 491
		view 14902
		loop 1
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

