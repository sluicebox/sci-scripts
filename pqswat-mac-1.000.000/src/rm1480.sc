;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1480)
(include sci.sh)
(use Main)
(use PQRoom)
(use swatInvInit)
(use HotSpot)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1480 0
)

(local
	local0
)

(instance rm1480 of PQRoom
	(properties
		picture 1480
	)

	(method (init)
		(if (!= 10304 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10304)
			(gBackMusic number: 10304 loop: -1 play:)
			(Lock rsAUDIO 10304 1)
		)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init:)
		(= global114 myShootCode)
		(northExit init:)
		(southExit init:)
		(desk init:)
		(deskFeat init:)
		(backWindow init:)
		(sideWindow1 init:)
		(sideWindow2 init:)
		(if (OneOf gPrevRoomNum 1470 15 8) ; mainMenu, sierraLogo
			(actionTimer setReal: actionTimer 10)
		)
		(gGame handsOn:)
	)

	(method (lashNotify)
		(self setScript: timeOut)
		(return -1)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(self setScript: timeOut 0 theVerb)
			)
			(6
				(self setScript: timeOut 0 theVerb)
			)
			(16
				(self setScript: tossBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(= global114 0)
		(actionTimer dispose: delete:)
		(super dispose: &rest)
	)
)

(instance tossBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1003 1002 14901 10314)
				(Load rsVIEW 6 14803 14805)
				(= seconds 2)
			)
			(1
				(flashBang init: setCycle: End self)
				(sound1 number: 1003 play:)
			)
			(2
				(flashBang dispose:)
				(sound1 number: 1002 play:)
				(whiteScreen init:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(mrEastman view: 14803 posn: 361 297 init: setPri: 400)
				(= cycles 2)
			)
			(3
				(whiteScreen dispose:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(gMessager sayRange: 3 16 0 1 3 self) ; "Status! Status!"
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
				(mrEastman setCycle: End)
			)
			(7
				(mrEastman dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(8
				(gFxSound number: 14901 setLoop: 0 play: self)
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

(instance timeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 14801 14800 14806)
				(Load rsAUDIO 48 50 51 52 14901 10314)
				(= seconds 1)
			)
			(1
				(switch register
					(7
						(switch (((proc19_3 3) data:) weaponSetting:)
							(0
								(gFxSound number: 48 setLoop: 0 play: self)
							)
							(1
								(if (== caller deskFeat)
									(deskHoles init: setPri: 355)
								)
								(gFxSound number: 51 setLoop: 0 play: self)
							)
							(2
								(if (== caller deskFeat)
									(deskHoles
										init:
										setPri: 355
										setCycle: CT 2 1
									)
								)
								(gFxSound number: 52 setLoop: 0 play: self)
							)
						)
					)
					(6
						(if (== caller deskFeat)
							(deskHoles init: setPri: 355)
						)
						(gFxSound number: 50 setLoop: 0 play: self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(mrEastman
					view: 14801
					posn: 405 239
					init:
					setPri: 400
					setCycle: CT 5 1 self
				)
			)
			(3
				(mrEastman setCycle: End)
				(militiaMan
					view: 14800
					posn: 303 281
					setCel: 3
					init:
					setCycle: CT 13 1 self
				)
			)
			(4
				(gFxSound number: 14901 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(5
				(gFxSound stop:)
				(militiaMan dispose:)
				(mrEastman dispose:)
				(if (gCast contains: deskHoles)
					(deskHoles dispose:)
				)
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

(instance shootBackWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 45 48 50 51 52 14901 10314)
				(Load rsVIEW 14800 14806)
				(= seconds 1)
			)
			(1
				(switch register
					(7
						(switch (((proc19_3 3) data:) weaponSetting:)
							(0
								(gFxSound number: 48 setLoop: 0 play: self)
							)
							(1
								(backHoles init:)
								(gFxSound number: 51 setLoop: 0 play: self)
							)
							(2
								(backHoles init: setCycle: End)
								(gFxSound number: 52 setLoop: 0 play: self)
							)
						)
					)
					(6
						(backHoles init:)
						(gFxSound number: 50 setLoop: 0 play: self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gMessager say: 1 7 0 1 self) ; "Highground One. Side two, level one, opening two..."
			)
			(3
				(militiaMan
					view: 14800
					posn: 303 281
					setCel: 3
					init:
					setCycle: CT 13 1 self
				)
			)
			(4
				(gFxSound number: 14901 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(5
				(gMessager say: 1 7 0 2 self) ; "Suspect movement!"
			)
			(6
				(militiaMan dispose:)
				(backHoles dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 45 setLoop: 0 play: self)
			)
			(8
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(9
				(= global415 0)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootSideWindow1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 45 48 50 51 52 14901 10314)
				(Load rsVIEW 14800 14806)
				(= seconds 1)
			)
			(1
				(switch register
					(7
						(switch (((proc19_3 3) data:) weaponSetting:)
							(0
								(gFxSound number: 48 setLoop: 0 play: self)
							)
							(1
								(sideHoles1 init:)
								(gFxSound number: 51 setLoop: 0 play: self)
							)
							(2
								(sideHoles1 init: setCycle: End)
								(gFxSound number: 52 setLoop: 0 play: self)
							)
						)
					)
					(6
						(sideHoles1 init:)
						(gFxSound number: 50 setLoop: 0 play: self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gMessager say: 2 7 0 1 self) ; "Highground One. Side one, level one..."
			)
			(3
				(militiaMan
					view: 14800
					posn: 303 281
					setCel: 3
					init:
					setCycle: CT 13 1 self
				)
			)
			(4
				(gFxSound number: 14901 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(5
				(gMessager say: 2 7 0 2 self) ; "Suspect movement!"
			)
			(6
				(militiaMan dispose:)
				(sideHoles1 dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 45 setLoop: 0 play: self)
			)
			(8
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(9
				(= global415 0)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootSideWindow2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 45 48 50 51 52 14901 10314)
				(Load rsVIEW 14800 14806)
				(= seconds 1)
			)
			(1
				(switch register
					(7
						(switch (((proc19_3 3) data:) weaponSetting:)
							(0
								(gFxSound number: 48 setLoop: 0 play: self)
							)
							(1
								(sideHoles2 init:)
								(gFxSound number: 51 setLoop: 0 play: self)
							)
							(2
								(sideHoles2 init: setCycle: End)
								(gFxSound number: 52 setLoop: 0 play: self)
							)
						)
					)
					(6
						(sideHoles2 init:)
						(gFxSound number: 50 setLoop: 0 play: self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gMessager say: 2 7 0 1 self) ; "Highground One. Side one, level one..."
			)
			(3
				(militiaMan
					view: 14800
					posn: 303 281
					setCel: 3
					init:
					setCycle: CT 13 1 self
				)
			)
			(4
				(gFxSound number: 14901 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(5
				(gMessager say: 2 7 0 2 self) ; "Suspect movement!"
			)
			(6
				(militiaMan dispose:)
				(sideHoles2 dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 45 setLoop: 0 play: self)
			)
			(8
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(9
				(= global415 0)
				(gCurRoom newRoom: 72) ; funeralRoom
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

(instance militiaMan of Prop
	(properties
		x 303
		y 281
		view 14800
	)
)

(instance mrEastman of Prop
	(properties
		x 405
		y 239
		view 14801
	)
)

(instance flashBang of Prop
	(properties
		x 287
		y 196
		view 14805
	)
)

(instance backHoles of Prop
	(properties
		x 294
		y 88
		view 14806
	)
)

(instance sideHoles1 of Prop
	(properties
		x 1
		y 98
		view 14806
		loop 2
	)
)

(instance sideHoles2 of Prop
	(properties
		x 127
		y 99
		view 14806
		loop 1
	)
)

(instance deskHoles of Prop
	(properties
		x 237
		y 230
		view 14806
		loop 3
	)
)

(instance backWindow of Feature
	(properties
		nsLeft 305
		nsTop 25
		nsRight 403
		nsBottom 168
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootBackWindow 0 theVerb)
			)
			(6
				(gCurRoom setScript: shootBackWindow 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sideWindow1 of Feature
	(properties
		nsRight 77
		nsBottom 167
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootSideWindow1 0 theVerb)
			)
			(6
				(gCurRoom setScript: shootSideWindow1 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sideWindow2 of Feature
	(properties
		nsLeft 78
		nsRight 154
		nsBottom 167
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootSideWindow2 0 theVerb)
			)
			(6
				(gCurRoom setScript: shootSideWindow2 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deskFeat of Feature
	(properties
		nsLeft 188
		nsTop 199
		nsRight 402
		nsBottom 310
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: timeOut self theVerb)
			)
			(7
				(gCurRoom setScript: timeOut self theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northExit of HotSpot
	(properties
		nsRight 639
		nsBottom 233
		type 4097
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: timeOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of HotSpot
	(properties
		nsTop 234
		nsRight 639
		nsBottom 359
		y 100
		type 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: timeOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of HotSpot
	(properties
		nsLeft 188
		nsTop 199
		nsRight 402
		nsBottom 310
		y 200
		type 32770
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55
				(gCurRoom newRoom: 1530)
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

(instance sound1 of Sound
	(properties)
)

(instance myShootCode of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

