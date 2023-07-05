;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1430)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm1430 0
)

(local
	local0
	local1
)

(instance rm1430 of PQRoom
	(properties
		picture 1430
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
		(frontDoor init: setPri: 5)
		(Load rsAUDIO 53)
		(if global415
			(Load rsVIEW 14300)
		else
			(Load rsVIEW 14304)
		)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(northExit init:)
		(southExit init:)
		(glassWall init:)
		(glassWall2 init:)
		(if global415
			(self setScript: enterRoom)
		else
			(self setScript: incorrectEntry)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(actionTimer setReal: actionTimer 8)
	)

	(method (lashNotify)
		(switch local0
			(0
				(cond
					(
						(and
							(proc4_11 48)
							(proc4_11 50)
							(proc4_11 65)
							(proc4_11 66)
							(== global149 4)
						)
						(if global415
							(self setScript: aClrRightBClrLeft)
						else
							(self setScript: moronScript)
						)
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 49)
							(proc4_11 65)
							(proc4_11 67)
							(== global149 4)
						)
						(if global415
							(self setScript: moronScript)
						else
							(self setScript: aClrLeftBClrRight)
						)
					)
					((and (proc4_11 48) (proc4_11 49) (== global149 2))
						(if global415
							(self setScript: moronScript)
						else
							(= local1 1)
							(self setScript: aClrLeft)
						)
					)
					((and (proc4_11 65) (proc4_11 67) (== global149 2))
						(if global415
							(self setScript: moronScript)
						else
							(self setScript: bClrRight)
						)
					)
					(
						(or
							(and (proc4_11 49) (proc4_11 67) (== global149 2))
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 67)
								(== global149 3)
							)
							(and
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 4)
							)
						)
						(if global415
							(self setScript: moronScript)
						else
							(self setScript: aLeftBRight)
						)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(if global415
							(self setScript: moronScript)
						else
							(= local1 0)
							(self setScript: aClrLeft)
						)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(if global415
							(self setScript: moronScript)
						else
							(self setScript: bRightOnly)
						)
					)
					((and (proc4_11 48) (proc4_11 50) (== global149 2))
						(if global415
							(self setScript: aClearRight)
						else
							(self setScript: moronScript)
						)
					)
					((and (proc4_11 65) (proc4_11 66) (== global149 2))
						(if global415
							(self setScript: bClearLeft)
						else
							(self setScript: moronScript)
						)
					)
					(
						(or
							(and (proc4_11 50) (proc4_11 66) (== global149 2))
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 66)
								(== global149 3)
							)
							(and
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 4)
							)
						)
						(if global415
							(self setScript: aRightBLeft)
						else
							(self setScript: moronScript)
						)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(if global415
							(self setScript: aRightOnly)
						else
							(self setScript: moronScript)
						)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(if global415
							(self setScript: bLeftOnly)
						else
							(self setScript: moronScript)
						)
					)
					(
						(and
							(proc4_11 47)
							(proc4_11 50)
							(proc4_11 64)
							(proc4_11 66)
							(== global149 4)
						)
						(if global415
							(gGame handsOff:)
							(actionTimer dispose: delete:)
							(gMessager sayRange: 1 127 9 1 2 self) ; "Entry Team A, cover right. Entry Team B, cover left."
						else
							(self setScript: moronScript)
						)
					)
					(
						(and
							(proc4_11 47)
							(proc4_11 49)
							(proc4_11 64)
							(proc4_11 67)
							(== global149 4)
						)
						(if global415
							(self setScript: moronScript)
						else
							(gGame handsOff:)
							(actionTimer dispose: delete:)
							(gMessager sayRange: 1 125 13 1 2 self) ; "Entry Team A, cover left. Entry Team B, cover right."
						)
					)
					((and (proc4_11 47) (proc4_11 50) (== global149 2))
						(if global415
							(gGame handsOff:)
							(actionTimer dispose: delete:)
							(gMessager sayRange: 1 128 7 1 2 self) ; "Entry Team A, cover right."
						else
							(self setScript: moronScript)
						)
					)
					((and (proc4_11 47) (proc4_11 49) (== global149 2))
						(if global415
							(self setScript: moronScript)
						else
							(gGame handsOff:)
							(actionTimer dispose: delete:)
							(gMessager sayRange: 1 118 11 1 2 self) ; "Entry Team A, cover left."
						)
					)
					((and (proc4_11 64) (proc4_11 66) (== global149 2))
						(if global415
							(gGame handsOff:)
							(actionTimer dispose: delete:)
							(gMessager sayRange: 1 109 8 1 2 self) ; "Entry Team B, cover left."
						else
							(self setScript: moronScript)
						)
					)
					((and (proc4_11 64) (proc4_11 67) (== global149 2))
						(if global415
							(self setScript: moronScript)
						else
							(gGame handsOff:)
							(actionTimer dispose: delete:)
							(gMessager sayRange: 1 117 12 1 2 self) ; "Entry Team B, cover right."
						)
					)
					(else
						(return -1)
					)
				)
			)
			(1
				(cond
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(if global415
							(self setScript: moronScript)
						else
							(= local1 0)
							(self setScript: aClrLeft)
						)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(if global415
							(self setScript: moronScript)
						else
							(self setScript: bRightOnly)
						)
					)
					(
						(or
							(and (proc4_11 49) (proc4_11 67) (== global149 2))
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 67)
								(== global149 3)
							)
							(and
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 4)
							)
						)
						(if global415
							(self setScript: moronScript)
						else
							(self setScript: aLeftBRight)
						)
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 49)
							(proc4_11 65)
							(proc4_11 67)
							(== global149 4)
						)
						(if global415
							(self setScript: moronScript)
						else
							(self setScript: aClrLeftBClrRight)
						)
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 50)
							(proc4_11 65)
							(proc4_11 66)
							(== global149 4)
						)
						(if global415
							(self setScript: aClrRightBClrLeft)
						else
							(self setScript: moronScript)
						)
					)
					((and (proc4_11 48) (proc4_11 50) (== global149 2))
						(if global415
							(self setScript: aClearRight)
						else
							(self setScript: moronScript)
						)
					)
					((and (proc4_11 65) (proc4_11 66) (== global149 2))
						(if global415
							(self setScript: bClearLeft)
						else
							(self setScript: moronScript)
						)
					)
					(
						(or
							(and (proc4_11 50) (proc4_11 66) (== global149 2))
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 66)
								(== global149 3)
							)
							(and
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 4)
							)
						)
						(if global415
							(self setScript: aRightBLeft)
						else
							(self setScript: moronScript)
						)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(if global415
							(self setScript: aRightOnly)
						else
							(self setScript: moronScript)
						)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(if global415
							(self setScript: bLeftOnly)
						else
							(self setScript: moronScript)
						)
					)
					((and (proc4_11 48) (proc4_11 49) (== global149 2))
						(if global415
							(self setScript: moronScript)
						else
							(= local1 1)
							(self setScript: aClrLeft)
						)
					)
					((and (proc4_11 65) (proc4_11 67) (== global149 2))
						(if global415
							(self setScript: moronScript)
						else
							(self setScript: bClrRight)
						)
					)
					(else
						(return -1)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: shootWall 0 6)
			)
			(7
				(gCurRoom setScript: shootWall 0 7)
			)
			(16
				(gCurRoom setScript: tossBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
				(proc4_6 14300 0 -8)
			)
			(1
				(proc4_5)
				(setUpElement doit: 1)
				(gMessager say: 0 0 3 0 self) ; "Highground One reporting. Entry Team successful. Inside building."
			)
			(2
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 8)
				(self dispose:)
			)
		)
	)
)

(instance aClrLeftBClrRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14211 14220)
				(Load rsPIC 1420)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 123 4 1 self) ; "Entry Team A, prepare to clear left. Go! Entry Team B, prepare to clear right. Go!"
			)
			(2
				(setUpElement doit: 0)
				(frontDoor dispose:)
				(door1420 init:)
				(gCurRoom drawPic: 1420)
				(proc4_6 14201 0 0 0 0 -1 1)
			)
			(3
				(militiaMan
					view: 14211
					loop: 0
					cel: 0
					posn: 177 209
					init:
					setCycle: CT 7 1 self
				)
			)
			(4
				(gFxSound number: 53 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(5
				(proc4_5)
				(militiaMan dispose:)
				(door1420 dispose:)
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
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(Load rsAUDIO 1002 1003 53 1050 10314)
				(Load rsVIEW 6)
				(= seconds 2)
			)
			(1
				(if global415
					(gGame showCloseUp: 14305 180 66 self)
				else
					(gFxSound number: 1003 setLoop: 0 play: self)
				)
			)
			(2
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
				(setUpElement doit: 0)
				(frontDoor dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gMessager say: 6 16 0 1 self) ; "Status! Status!"
			)
			(7
				(gFxSound number: 53 setLoop: 0 play: self)
			)
			(8
				(gMessager say: 6 16 0 2 self) ; "Compromised!"
			)
			(9
				(gFxSound number: 53 setLoop: 0 play: self)
			)
			(10
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(11
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance moronScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14303)
				(= seconds 1)
			)
			(1
				(cond
					((and (proc4_11 64) (proc4_11 67) (== global149 2))
						(gMessager say: 1 117 8 1 self) ; "Entry Team B, cover right."
					)
					((and (proc4_11 64) (proc4_11 66) (== global149 2))
						(gMessager say: 1 109 8 1 self) ; "Entry Team B, cover left."
					)
					((and (proc4_11 47) (proc4_11 49) (== global149 2))
						(gMessager say: 1 118 7 1 self) ; "Entry Team A, cover left."
					)
					((and (proc4_11 47) (proc4_11 50) (== global149 2))
						(gMessager say: 1 128 7 1 self) ; "Entry Team A, cover right."
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(gMessager say: 1 73 8 1 self) ; "Entry Team B, move right."
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(gMessager say: 1 71 12 1 self) ; "Entry Team B, move left."
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(gMessager say: 1 120 7 1 self) ; "Entry Team A, left."
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(gMessager say: 1 131 11 1 self) ; "Entry Team A, right."
					)
					((and (proc4_11 65) (proc4_11 67) (== global149 2))
						(gMessager say: 1 121 8 1 self) ; "Entry Team B, clear right."
					)
					((and (proc4_11 65) (proc4_11 66) (== global149 2))
						(gMessager say: 1 129 12 1 self) ; "Entry Team B, clear left."
					)
					((and (proc4_11 48) (proc4_11 49) (== global149 2))
						(gMessager say: 1 122 7 1 self) ; "Entry Team A, clear left."
					)
					((and (proc4_11 48) (proc4_11 50) (== global149 2))
						(gMessager say: 1 132 11 1 self) ; "Entry Team A, clear right."
					)
					(
						(or
							(and (proc4_11 49) (proc4_11 67) (== global149 2))
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 67)
								(== global149 3)
							)
							(and
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 4)
							)
						)
						(gMessager say: 1 104 9 1 self) ; "Entry Team A, left. Entry Team B, right."
					)
					(
						(or
							(and (proc4_11 50) (proc4_11 66) (== global149 2))
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 66)
								(== global149 3)
							)
							(and
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 4)
							)
						)
						(gMessager say: 1 111 13 1 self) ; "Entry Team A, right. Entry Team B, left."
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 49)
							(proc4_11 65)
							(proc4_11 67)
							(== global149 4)
						)
						(gMessager say: 1 123 9 1 self) ; "Entry Team A, clear left. Entry Team B, clear right."
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 50)
							(proc4_11 65)
							(proc4_11 66)
							(== global149 4)
						)
						(gMessager say: 1 112 13 1 self) ; "Entry Team A, clear right. Entry Team B, clear left."
					)
					(
						(and
							(proc4_11 47)
							(proc4_11 49)
							(proc4_11 64)
							(proc4_11 67)
							(== global149 4)
						)
						(gMessager say: 1 125 9 1 self) ; "Entry Team A, cover left. Entry Team B, cover right."
					)
					(
						(and
							(proc4_11 47)
							(proc4_11 50)
							(proc4_11 64)
							(proc4_11 66)
							(== global149 4)
						)
						(gMessager say: 1 127 9 1 self) ; "Entry Team A, cover right. Entry Team B, cover left."
					)
				)
			)
			(2
				(gGame showCloseUp: 14309 180 66 self)
			)
			(3
				(militiaMan init: setPri: 10 setCycle: CT 11 1 self)
			)
			(4
				(militiaMan setCycle: End self)
				(gFxSound number: 53 setLoop: 0 play:)
			)
			(5
				(gFxSound stop:)
				(militiaMan dispose:)
				(frontDoor dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(6
				(gFxSound number: 53 setLoop: 0 play: self)
			)
			(7
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(8
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance aRightOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14691)
				(Load rsPIC 1460)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 14313 180 66 self 1)
			)
			(2
				(frontDoor dispose:)
				(setUpElement doit: 0)
				(militiaMan view: 14691 posn: 241 196 init:)
				(Palette 2 42 254 100) ; PalIntensity
				(gCurRoom drawPic: 1460)
				(proc4_6 14602 246 78 0 0 260 1)
			)
			(3
				(militiaMan setCycle: CT 9 1 self)
			)
			(4
				(gFxSound number: 53 setLoop: 0 play:)
				(militiaMan setCycle: CT 22 1 self)
			)
			(5
				(gFxSound stop:)
				(militiaMan setCycle: End self)
			)
			(6
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 53 setLoop: 0 play: self)
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

(instance bLeftOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsPIC 1461)
				(Load rsVIEW 14695)
				(Load rsAUDIO 44 10314)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 14307 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(frontDoor dispose:)
				(Palette 2 42 254 100) ; PalIntensity
				(gCurRoom drawPic: 1461)
				(proc4_6 14603 -1 12 0 0 260 1)
			)
			(3
				(militiaMan
					view: 14695
					posn: 534 408
					init:
					setCycle: CT 8 1 self
				)
			)
			(4
				(gFxSound number: 44 setLoop: 0 play:)
				(militiaMan setCycle: CT 12 1 self)
			)
			(5
				(gFxSound stop:)
				(militiaMan setCycle: End self)
			)
			(6
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(8
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance aRightBLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14691)
				(Load rsPIC 1460)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 14314 180 66 self 1)
			)
			(2
				(frontDoor dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1460)
				(= cycles 5)
			)
			(3
				(Palette 2 42 254 100) ; PalIntensity
				(militiaMan view: 14691 posn: 241 196 init:)
				(proc4_6 14601 186 61 0 0 260 1)
			)
			(4
				(militiaMan setCycle: CT 9 1 self)
			)
			(5
				(gFxSound number: 53 setLoop: 0 play:)
				(militiaMan setCycle: CT 22 1 self)
			)
			(6
				(gFxSound stop:)
				(militiaMan setCycle: End)
			)
			(7
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(8
				(gFxSound number: 53 setLoop: 0 play: self)
			)
			(9
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(10
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
				(Load rsVIEW 14211)
				(Load rsPIC 1420 1470)
				(Load rsAUDIO 6007 10314 53 13003)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(gGame showCloseUp: 14306 180 66 self 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(proc4_6 14302 5 52 25)
			)
			(3
				(proc4_5)
				(frontDoor dispose:)
				(gCurRoom drawPic: 1470)
				(proc4_6 14722 0 25 0 0 500)
			)
			(4
				(gFxSound number: 13003 setLoop: 0 play:)
			)
			(5
				(gCurRoom drawPic: 1420)
				(militiaMan
					view: 14211
					setLoop: 0
					setCel: 9
					posn: 177 209
					init:
					setCycle: End self
				)
				(gFxSound number: 53 setLoop: -1 play:)
				(proc4_6 14203 91 0)
			)
			(6
				(gFxSound stop:)
				(militiaMan dispose:)
				(proc4_5)
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
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(SetFlag 94)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance aClearRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14303)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 14312 180 66 self 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(setUpElement doit: 0)
				(proc4_6 14301 0 0 0 0 265 1)
			)
			(3
				(gAutoRobot setPri: 405)
			)
			(4
				(militiaMan init: setPri: 10 setCycle: CT 7 1 self)
			)
			(5
				(militiaMan setCycle: End self)
				(gFxSound number: 53 setLoop: 0 play:)
			)
			(6
				(gFxSound stop:)
				(militiaMan dispose:)
				(frontDoor dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 53 setLoop: 0 play: self)
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

(instance aClrRightBClrLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 112 4 0 self) ; "Entry Team A, prepare to clear right. Go! Entry Team B, prepare to clear left. Go!"
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 14300 0 -8 82 0 275)
			)
			(2
				(gAutoRobot setPri: -1)
			)
			(3
				(= global415 0)
				(gCurRoom newRoom: 1470)
			)
		)
	)
)

(instance timeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(Load rsAUDIO 53 10314)
					(Load rsVIEW 14303)
					(= seconds 1)
				else
					(self cue:)
				)
			)
			(1
				(if local0
					(gMessager say: 0 0 6 0 self) ; "Pup, what's going on in there? Denton, do you copy?"
				else
					(gMessager say: 0 0 5 0 self) ; "Pup, what's going on in there? What do you see?"
				)
			)
			(2
				(if local0
					(militiaMan init: setPri: 10 setCycle: CT 7 1 self)
				else
					(gGame handsOn:)
					(++ local0)
					(actionTimer setReal: actionTimer 6)
					(self dispose:)
				)
			)
			(3
				(militiaMan setCycle: End self)
				(gFxSound number: 53 setLoop: 0 play:)
			)
			(4
				(gFxSound stop:)
				(militiaMan dispose:)
				(setUpElement doit: 0)
				(frontDoor dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(gFxSound number: 53 setLoop: 0 play: self)
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

(instance shootYourFriend of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: actionTimer)
					(actionTimer dispose: delete:)
				)
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
					(carmike
						(gGame showCloseUp: 9008 180 66 self 1)
					)
					(denton
						(gGame showCloseUp: 9020 180 66 self 1)
					)
					(egoProp
						(gGame showCloseUp: 9028 180 66 self 1)
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

(instance shootGlassWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 14607 10314)
				(Load rsVIEW 14691 14604)
				(Load rsPIC 1461)
				(= seconds 2)
			)
			(1
				(if (== register 6)
					(gGame showCloseUp: 14311 180 66 self 1)
				else
					(gGame showCloseUp: 14310 180 66 self 1)
				)
			)
			(2
				(gMessager say: 6 6 0 0 self) ; "Compromised!"
			)
			(3
				(setUpElement doit: 0)
				(frontDoor dispose:)
				(Palette 2 42 254 100) ; PalIntensity
				(if (== caller glassWall)
					(lHole init:)
				else
					(rHole init:)
				)
				(gCurRoom drawPic: 1461)
				(militiaMan view: 14691 posn: 245 196 init:)
				(cond
					(global415
						(proc4_6 14602 246 78 35 0 260 1)
					)
					((== register 7)
						(proc4_6 14610 0 46)
					)
					(else
						(proc4_6 14612 -11 44)
					)
				)
			)
			(4
				(egoProp setCycle: End)
				(militiaMan setCycle: CT 7 1 self)
			)
			(5
				(gFxSound number: 14607 setLoop: 0 play:)
				(militiaMan setCycle: CT 21 1 self)
			)
			(6
				(proc4_5)
				(militiaMan dispose:)
				(setUpElement doit: 0)
				(if (== caller glassWall)
					(lHole dispose:)
				else
					(rHole dispose:)
				)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound stop:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(8
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
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14691)
				(Load rsPIC 1460)
				(= seconds 2)
			)
			(1
				(if (== register 6)
					(gGame showCloseUp: 14311 180 66 self 1)
				else
					(gGame showCloseUp: 14310 180 66 self 1)
				)
			)
			(2
				(gMessager say: 6 6 0 0 self) ; "Compromised!"
			)
			(3
				(frontDoor dispose:)
				(setUpElement doit: 0)
				(Palette 2 42 254 100) ; PalIntensity
				(gCurRoom drawPic: 1460)
				(if (== register 7)
					(proc4_6 14611 286 101 0 0 275 1)
				else
					(proc4_6 14613 266 87 0 0 275 1)
				)
			)
			(4
				(militiaMan
					view: 14691
					posn: 241 196
					init:
					setCycle: CT 11 1 self
				)
			)
			(5
				(militiaMan setCycle: End self)
				(gFxSound number: 53 setLoop: 0 play:)
			)
			(6
				(gFxSound stop:)
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 53 setLoop: 0 play: self)
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

(instance do1420 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(actionTimer dispose: delete:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14211)
				(Load rsPIC 1420)
				(= seconds 2)
			)
			(1
				(frontDoor dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1420)
				(militiaMan
					view: 14211
					loop: 0
					cel: 0
					posn: 177 209
					init:
					setCycle: CT 11 1 self
				)
				(proc4_6 14203 91 -15 0 0 -1 1)
			)
			(2
				(gFxSound number: 53 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(3
				(gFxSound stop:)
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
				(gFxSound number: 53 setLoop: 0 play: self)
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

(instance incorrectEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(setUpElement doit: 2)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 8)
				(self dispose:)
			)
		)
	)
)

(instance aClrLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14303)
				(= seconds 1)
			)
			(1
				(if local1
					(gMessager say: 1 122 7 1 self) ; "Entry Team A, clear left."
				else
					(gMessager say: 1 70 7 1 self) ; "Entry Team A, move left."
				)
			)
			(2
				(militiaMan init: setPri: 10 setCycle: CT 7 1 self)
			)
			(3
				(militiaMan setCycle: End self)
				(gFxSound number: 53 setLoop: 0 play:)
			)
			(4
				(gFxSound stop:)
				(frontDoor dispose:)
				(setUpElement doit: 0)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(gFxSound number: 53 setLoop: 0 play: self)
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

(instance bClrRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14303)
				(Load rsPIC 1420 1430)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 121 8 1 self) ; "Entry Team B, clear right."
			)
			(2
				(frontDoor hide:)
				(egoProp dispose:)
				(tello dispose:)
				(denton hide:)
				(carmike hide:)
				(door1420 init:)
				(gCurRoom drawPic: 1420)
				(proc4_6 14204 166 -61)
			)
			(3
				(door1420 dispose:)
				(frontDoor show:)
				(denton show:)
				(carmike show:)
				(gCurRoom drawPic: 1430)
				(militiaMan init: setPri: 10 setCycle: CT 7 1 self)
			)
			(4
				(militiaMan setCycle: End self)
				(gFxSound number: 53 setLoop: 0 play:)
			)
			(5
				(gFxSound stop:)
				(setUpElement doit: 0)
				(frontDoor dispose:)
				(militiaMan dispose:)
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
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance aLeftBRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314)
				(Load rsVIEW 14691)
				(Load rsPIC 1461)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 126 9 1 self) ; "Entry Team A, move left. Entry Team B, move right."
			)
			(2
				(frontDoor dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1461)
				(militiaMan view: 14691 posn: 241 196 init:)
				(proc4_6 14608 0 44 0 0 260 1)
			)
			(3
				(militiaMan setCycle: CT 9 1 self)
			)
			(4
				(gFxSound number: 53 setLoop: 0 play:)
				(militiaMan setCycle: CT 22 1 self)
			)
			(5)
			(6
				(gFxSound stop:)
				(militiaMan setCycle: End self)
			)
			(7
				(proc4_5)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
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

(instance aLeftOnly of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14211)
				(Load rsPIC 1420)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 70 7 1 self) ; "Entry Team A, move left."
			)
			(2
				(frontDoor dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1420)
				(militiaMan
					view: 14211
					loop: 0
					cel: 0
					posn: 177 209
					init:
					setCycle: CT 7 1 self
				)
			)
			(3
				(gFxSound number: 53 setLoop: 0 play:)
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

(instance bRightOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 14691)
				(Load rsPIC 1460)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 73 12 1 self) ; "Entry Team B, prepare to move right. Go!"
			)
			(2
				(setUpElement doit: 0)
				(frontDoor dispose:)
				(gCurRoom drawPic: 1460)
				(militiaMan view: 14691 posn: 241 196 init:)
				(proc4_6 14609 248 82 0 0 265 1)
			)
			(3
				(militiaMan setCycle: CT 9 1 self)
			)
			(4
				(gFxSound number: 53 setLoop: 0 play:)
				(militiaMan setCycle: CT 22 1 self)
			)
			(5)
			(6
				(gFxSound stop:)
				(militiaMan setCycle: End self)
			)
			(7
				(proc4_5)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
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

(instance door1420 of View
	(properties
		x 367
		y 86
		view 14220
	)
)

(instance frontDoor of View
	(properties
		x 1
		view 1430
	)
)

(instance egoProp of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
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
				(gMessager say: 3 29 0 0 self) ; "Carmichael, you copy?"
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
				(gMessager say: 4 29 0 0 self) ; "Denton, you copy?"
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
				(gMessager say: 2 29 0 0 self) ; "Tello, you copy?"
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
				(gMessager say: 5 29 0 0 self) ; "Wixell, you copy?"
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

(instance militiaMan of Prop
	(properties
		x 421
		y 181
		view 14303
	)
)

(instance lHole of Prop
	(properties
		x 499
		y 61
		view 14609
	)
)

(instance rHole of Prop
	(properties
		x 177
		y 113
		view 14608
	)
)

(instance glassWall of Feature
	(properties
		nsLeft 160
		nsTop 13
		nsRight 312
		nsBottom 247
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootGlassWall self theVerb)
			)
			(6
				(gCurRoom setScript: shootGlassWall self theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glassWall2 of Feature
	(properties
		nsLeft 469
		nsTop 2
		nsRight 522
		nsBottom 285
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootGlassWall self theVerb)
			)
			(6
				(gCurRoom setScript: shootGlassWall self theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northExit of HotSpot
	(properties
		nsLeft 314
		nsRight 462
		nsBottom 258
		type 4097
	)

	(method (doVerb)
		(= global415 1)
		(gCurRoom newRoom: 1470)
	)
)

(instance southExit of HotSpot
	(properties
		nsTop 300
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: do1420)
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
				(egoProp dispose:)
				(denton dispose:)
				(carmike dispose:)
				(wix dispose:)
			)
			(1
				(tello view: 14300 loop: 0 cel: 0 posn: -1 53 setPri: 270 init:)
				(egoProp
					view: 14300
					loop: 0
					cel: 1
					posn: -1 53
					setPri: 270
					init:
				)
				(denton
					view: 14300
					loop: 0
					cel: 2
					posn: -1 53
					setPri: 270
					init:
				)
				(carmike
					view: 14300
					loop: 0
					cel: 3
					posn: -1 53
					setPri: 270
					init:
				)
				(wix view: 14300 loop: 0 cel: 4 posn: -1 53 setPri: 270 init:)
			)
			(2
				(tello view: 14304 loop: 1 cel: 0 posn: 8 79 setPri: 270 init:)
				(egoProp
					view: 14304
					loop: 0
					cel: 0
					posn: 8 79
					setPri: 270
					init:
				)
				(denton
					view: 14304
					loop: 3
					cel: 0
					posn: -21 87
					setPri: 270
					init:
				)
				(carmike
					view: 14304
					loop: 2
					cel: 0
					posn: -20 89
					setPri: 270
					init:
				)
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

