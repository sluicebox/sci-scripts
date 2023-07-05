;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1390)
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
	rm1390 0
)

(local
	local0
)

(instance rm1390 of PQRoom
	(properties
		picture 1390
	)

	(method (init)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(= global415 0)
		)
		(if (!= 10313 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10313)
			(gBackMusic number: 10313 loop: -1 play:)
			(Lock rsAUDIO 10313 1)
		)
		(if global415
			(Load rsAUDIO 13904 13905 10314)
			(Load rsVIEW 13900 13904 13905)
		else
			(Load rsAUDIO 13903 10314)
			(Load rsVIEW 13901 13903 13906)
		)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(if global415
			(self setScript: egoEnters)
		else
			(self setScript: elementEnters)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(self setScript: tossBang)
			)
			(6
				(self setScript: yerDed)
			)
			(7
				(self setScript: yerDed)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yerDed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(if (gCast contains: hoodedGuy)
					(gCurRoom setScript: hoodedGuyKills)
				else
					(hoodedGuy
						view: 13903
						posn: 237 144
						init:
						setCycle: CT 26 1 self
					)
				)
			)
			(1
				(gCurRoom setScript: hoodedGuyKills)
			)
		)
	)
)

(instance tossBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: actionTimer)
					(actionTimer dispose: delete:)
				)
				(gGame handsOff:)
				(Load rsAUDIO 44 53 1002 1050 10314)
				(Load rsVIEW 6)
				(= seconds 2)
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
				(sound1 number: 1050 play: self)
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

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(egoProp view: 13900 posn: 195 436 init: setCycle: CT 24 1 self)
			)
			(1
				(militiaMan view: 13904 posn: 99 198 init: setCycle: End)
				(bCrow view: 13905 posn: 334 298 init: setCycle: End self)
				(egoProp setPri: 380 setCycle: End self)
			)
			(2)
			(3
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance elementEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rifle init: setPri: 220)
				(proc4_6 13901 -12 30 0 0 225)
			)
			(1
				(setUpElement doit: 1)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 8)
				(self dispose:)
			)
		)
	)
)

(instance hoodedGuyPopsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hoodedGuy
					view: 13903
					posn: 237 144
					init:
					setCycle: CT 26 1 self
				)
			)
			(1
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 4)
				(self dispose:)
			)
		)
	)
)

(instance hoodedGuyKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hoodedGuy setCycle: End self)
				(gFxSound number: 13903 setLoop: 1 play:)
			)
			(1
				(gFxSound stop:)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance killHoodedGuy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 6006)
				(= seconds 1)
			)
			(1
				(hoodedGuy setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gMessager say: 0 0 3 0 self) ; "Suspects in control."
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6006 loop: -1 play:)
				(Lock rsAUDIO 6006 1)
				(gCurRoom newRoom: 1520)
			)
		)
	)
)

(instance killCrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gGame showCloseUp: 13924 180 66 self 1)
			)
			(1
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance killMilitiaMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gGame showCloseUp: 13925 180 66 self 1)
			)
			(1
				(= cycles 5)
			)
			(2
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(self cue:)
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance eatHotDeath of Script
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
					(carMike
						(gGame showCloseUp: 9008 180 66 self 1)
					)
					(tello
						(gGame showCloseUp: 9028 180 66 self 1)
					)
					(denton
						(gGame showCloseUp: 9020 180 66 self 1)
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
				(gSwatInterface replaceInvItem:)
				(SetFlag 94)
				(SetFlag 98)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance egoProp of Prop
	(properties)
)

(instance bCrow of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gMessager say: 7 29 0 0 0) ; "Keep your hands in the air!"
			)
			(7
				(gCurRoom setScript: killCrow)
			)
			(6
				(gCurRoom setScript: killCrow)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((not (== view 13905)))
			((and (== cel 6) (not (sound2 handle:)))
				(sound2 number: 13905 play:)
			)
		)
	)
)

(instance militiaMan of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gMessager say: 7 29 0 0 0) ; "Keep your hands in the air!"
			)
			(7
				(gCurRoom setScript: killMilitiaMan)
			)
			(6
				(gCurRoom setScript: killMilitiaMan)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((not (== view 13904)))
			((and (== cel 12) (not (sound1 handle:)))
				(sound1 number: 13904 play:)
			)
		)
	)
)

(instance hoodedGuy of Prop
	(properties)

	(method (doVerb theVerb)
		(actionTimer dispose: delete:)
		(switch theVerb
			(29
				(gCurRoom setScript: hoodedGuyKills)
			)
			(7
				(gCurRoom setScript: killHoodedGuy)
			)
			(6
				(gCurRoom setScript: killHoodedGuy)
			)
		)
	)
)

(instance wix of Prop
	(properties)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: 5 29 0 0 self) ; "Wixell..."
			)
			(6
				(gCurRoom setScript: eatHotDeath 0 self)
			)
			(7
				(gCurRoom setScript: eatHotDeath 0 self)
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: 4 29 0 0 self) ; "Denton..."
			)
			(6
				(gCurRoom setScript: eatHotDeath 0 self)
			)
			(7
				(gCurRoom setScript: eatHotDeath 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carMike of Prop
	(properties)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: 3 29 0 0 self) ; "Carmichael..."
			)
			(6
				(gCurRoom setScript: eatHotDeath 0 self)
			)
			(7
				(gCurRoom setScript: eatHotDeath 0 self)
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: 2 29 0 0 self) ; "Tello..."
			)
			(6
				(gCurRoom setScript: eatHotDeath 0 self)
			)
			(7
				(gCurRoom setScript: eatHotDeath 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rifle of View
	(properties
		x 175
		y 292
		view 13901
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 48
		type 4097
	)

	(method (doVerb))
)

(instance eastE of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb))
)

(instance southE of HotSpot
	(properties
		nsTop 312
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb))
)

(instance westE of HotSpot
	(properties
		nsRight 48
		nsBottom 360
		type 32769
	)

	(method (doVerb))
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(switch local0
			(0
				(gCurRoom setScript: hoodedGuyPopsUp)
			)
			(1
				(gCurRoom setScript: hoodedGuyKills)
			)
		)
		(self dispose: delete:)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(1
				(militiaMan
					view: 13906
					setCel: 1
					setLoop: 0
					setPri: 195
					posn: -9 120
					init:
				)
				(bCrow view: 13906 setCel: 0 setLoop: 0 posn: -9 120 init:)
				(denton
					view: 13906
					setCel: 2
					setLoop: 0
					posn: -9 120
					setPri: 225
					init:
				)
				(carMike
					view: 13906
					setCel: 3
					setLoop: 0
					posn: -9 120
					setPri: 225
					init:
				)
				(tello
					view: 13906
					setCel: 4
					setLoop: 0
					posn: -9 120
					setPri: 225
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

(instance sound1 of Sound
	(properties)
)

(instance sound2 of Sound
	(properties)
)

