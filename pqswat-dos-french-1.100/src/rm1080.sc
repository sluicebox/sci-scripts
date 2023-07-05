;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1080)
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
	rm1080 0
)

(local
	local0
	local1
	local2
)

(instance rm1080 of PQRoom
	(properties
		picture 1080
	)

	(method (init)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(= global415 0)
		)
		(if (!= 10310 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10310)
			(gBackMusic number: 10310 loop: -1 play:)
			(Lock rsAUDIO 10310 1)
		)
		(if (not global415)
			(Load rsVIEW 10802 10803)
		)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(if (!= global415 3)
			(northExit init:)
		)
		(eastExit init:)
		(westExit init:)
		(cond
			((== global415 0)
				(self setScript: enterRoom)
			)
			((OneOf global415 1 2)
				(gCurRoom setScript: shootWall)
			)
			(else
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
			)
		)
	)

	(method (lashNotify)
		(switch local0
			(0
				(cond
					((== global415 3)
						(self setScript: shootWall)
						(return -1)
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 50)
							(proc4_11 64)
							(proc4_11 66)
							(== global149 4)
						)
						(self setScript: aClrRightBCoverLeft)
					)
					((and (proc4_11 48) (proc4_11 50) (== global149 2))
						(= local2 10803)
						(self setScript: aClear)
					)
					((and (proc4_11 65) (proc4_11 67) (== global149 2))
						(= local2 10805)
						(self setScript: bClear)
					)
					((and (proc4_11 48) (== global149 1))
						(= local2 10804)
						(self setScript: aClear)
					)
					((and (proc4_11 65) (== global149 1))
						(= local2 10806)
						(self setScript: bClear)
					)
					(
						(and
							(proc4_11 47)
							(proc4_11 49)
							(proc4_11 65)
							(proc4_11 67)
							(== global149 4)
						)
						(= local2 10807)
						(self setScript: bClear)
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 50)
							(proc4_11 65)
							(proc4_11 66)
							(== global149 4)
						)
						(self setScript: aClrRightBClrLeft)
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 49)
							(proc4_11 65)
							(proc4_11 67)
							(== global149 4)
						)
						(self setScript: aClrLeftBClrRight)
					)
					(else
						(self setScript: shootWall)
						(return -1)
					)
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
				(gCurRoom setScript: tossFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(egoProp view: 10803 posn: 520 415 init: setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance aClrRightBCoverLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gGame showCloseUp: 10808 180 66 self 1)
			)
			(1
				(gCurRoom newRoom: 1370)
			)
		)
	)
)

(instance aClear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(self next: shootWall)
				(gGame showCloseUp: local2 180 66 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance bClear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050 6007 10314 10802)
				(Load rsVIEW 10805)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: local2 180 66 self)
			)
			(2
				(militiaMan
					view: 10805
					posn: 397 164
					init:
					setCycle: CT 9 1 self
				)
			)
			(3
				(egoProp setCycle: CT 7 -1)
				(militiaMan setCycle: End self)
				(gFxSound number: 10802 setLoop: -1 play:)
			)
			(4
				(gFxSound stop:)
				(egoProp dispose:)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 1050 setLoop: 1 play: self)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gBackMusic number: 6007 setLoop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
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
				(gGame showCloseUp: 10811 180 66 self)
			)
			(1
				(= global415 0)
				(gCurRoom newRoom: 1330)
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
				(gGame showCloseUp: 10809 180 66 self)
			)
			(1
				(= global415 1)
				(gCurRoom newRoom: 1330)
			)
		)
	)
)

(instance tossFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44 53 1002 1003)
				(Load rsVIEW 6)
				(self next: shootWall)
				(= seconds 2)
			)
			(1
				(gFxSound number: 1003 setLoop: 0 play: self)
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
				(Load rsAUDIO 10314 10802)
				(Load rsVIEW 10804 10805)
				(switch global415
					(0
						(= global415 2)
					)
					(3
						(= global415 1)
					)
				)
				(= seconds 1)
			)
			(1
				(militiaMan
					view: 10805
					posn: 397 164
					init:
					setCycle: CT 9 1 self
				)
				(if (== global415 2)
					(self setScript: shooter2 self)
				)
			)
			(2
				(if (gCast contains: egoProp)
					(egoProp setCycle: CT 7 -1)
				)
				(militiaMan setCycle: End self)
				(gFxSound number: 10802 setLoop: -1 play:)
			)
			(3
				(gFxSound stop:)
				(if (!= global415 2)
					(self cue:)
				)
			)
			(4
				(militiaMan dispose:)
				(if (gCast contains: shooter2)
					(shooter2 dispose:)
				)
				(if (gCast contains: egoProp)
					(egoProp dispose:)
				)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shooter2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bCrow view: 10804 posn: 453 150 init: setCycle: CT 25 1 self)
			)
			(1
				(bCrow setCycle: CT 46 1 self)
				(fxSound2 number: 10802 setLoop: -1 play:)
			)
			(2
				(fxSound2 stop:)
				(bCrow setCycle: CT 55 1 self)
			)
			(3
				(bCrow setCycle: End self)
				(fxSound2 play:)
			)
			(4
				(fxSound2 dispose:)
				(caller cue:)
				(self dispose:)
			)
		)
	)
)

(instance do1370 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314 13700)
				(Load rsVIEW 13700)
				(Load rsPIC 1370)
				(= seconds 2)
			)
			(1
				(proc4_5)
				(gCurRoom drawPic: 1370)
				(egoProp dispose:)
				(militiaMan
					view: 13700
					posn: 64 352
					init:
					setCycle: CT 14 1 self
				)
			)
			(2
				(gFxSound number: 13700 setLoop: 0 play:)
				(militiaMan setCycle: CT 27 1 self)
			)
			(3
				(gFxSound stop:)
				(militiaMan setCycle: End self)
			)
			(4
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

(instance do1610 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314 16101)
				(Load rsVIEW 16100 16101)
				(Load rsPIC 1610)
				(= seconds 2)
			)
			(1
				(gCurRoom drawPic: 1610)
				(proc4_5)
				(egoProp
					view: 16100
					posn: 631 234
					init:
					setPri: 385
					setCycle: CT 14 1 self
				)
			)
			(2
				(egoProp setCycle: End self)
				(militiaMan
					view: 16101
					posn: 513 299
					init:
					setCycle: CT 14 1 self
				)
			)
			(3
				(militiaMan setCycle: CT 20 1 self)
				(gFxSound number: 16101 setLoop: 0 play:)
			)
			(4
				(militiaMan setCycle: End self)
				(gFxSound play:)
			)
			(5
				(gFxSound stop:)
			)
			(6
				(militiaMan dispose:)
				(egoProp dispose:)
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

(instance militiaMan of Prop
	(properties
		x 318
		y 325
		view 10802
	)
)

(instance bCrow of Prop
	(properties)
)

(instance egoProp of Prop
	(properties)
)

(instance northExit of HotSpot
	(properties
		nsRight 639
		nsBottom 75
		type 4097
	)

	(method (doVerb)
		(gCurRoom setScript: shootWall)
	)
)

(instance eastExit of HotSpot
	(properties
		nsLeft 590
		nsRight 639
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom setScript: do1370)
	)
)

(instance westExit of HotSpot
	(properties
		nsRight 221
		nsBottom 358
		type 32769
	)

	(method (doVerb theVerb)
		(if (== theVerb 29)
			(gCurRoom setScript: do1610)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: shootWall)
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

(instance fxSound2 of Sound
	(properties)
)

