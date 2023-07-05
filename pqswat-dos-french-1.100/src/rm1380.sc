;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1380)
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
	rm1380 0
)

(local
	local0
)

(instance rm1380 of PQRoom
	(properties
		picture 1380
	)

	(method (init)
		(if (!= 10312 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10312)
			(gBackMusic number: 10312 loop: -1 play:)
			(Lock rsAUDIO 10312 1)
		)
		(Load rsVIEW 13801)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(self setScript: enterRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46)
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
				(if
					(or
						(and (proc4_11 56) (proc4_11 51) (== global149 2))
						(and (proc4_11 56) (== global149 1))
					)
					(gCurRoom setScript: mirror)
				else
					(actionTimer dispose: delete:)
					(gCurRoom setScript: crowKills)
					(return -1)
				)
			)
			(1
				(cond
					((and (proc4_11 46) (== global149 1))
						(return -1)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(gCurRoom setScript: initBang)
					)
					(else
						(actionTimer dispose: delete:)
						(gCurRoom setScript: crowKills)
						(return -1)
					)
				)
			)
		)
	)

	(method (dispose)
		(actionTimer dispose: delete:)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(setUpElement doit: 1)
				(northE init:)
				(eastE init:)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 10)
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
				(Load rsAUDIO 44 53 10314)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 13806 180 66 self 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(setUpElement doit: 0)
				(proc4_6 13802 52 39 25)
			)
			(3
				(gAutoRobot setPri: 356)
			)
			(4
				(sound1 number: 44 play:)
			)
			(5
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(sound1 number: 44 play: self)
				(sound2 number: 53 play: self)
			)
			(6)
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

(instance tossBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44 53 1002 10314)
				(Load rsVIEW 6 13800 13805)
				(= seconds 2)
			)
			(1
				(theBang init: setCycle: End self)
			)
			(2
				(theBang dispose:)
				(whiteScreen init:)
				(sound1 number: 1002 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(setUpElement doit: 0)
				(= cycles 2)
			)
			(3
				(element
					view: 13800
					posn: 428 386
					setPri: 500
					init:
					setCycle: End self
				)
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
			)
			(6
				(element dispose:)
				(gGame showCloseUp: 13806 180 66 self 1)
			)
			(7
				(Palette 2 42 254 100) ; PalIntensity
				(proc4_6 13802 52 39 25)
			)
			(8
				(gAutoRobot setPri: 356)
			)
			(9
				(sound1 number: 44 play:)
			)
			(10
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(sound1 number: 44 play: self)
				(sound2 number: 53 play: self)
			)
			(11)
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

(instance initBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 6)
				(whiteScreen init: hide:)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 16 2 0 self) ; "Denton, you flashbang. Standby. Ready... Initiate!"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 13801 15 -11 202)
			)
			(3
				(whiteScreen show:)
				(Palette 2 42 254 500) ; PalIntensity
				(= cycles 2)
			)
			(4
				(whiteScreen dispose:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
			)
			(7
				(gAutoRobot setPri: 356)
			)
			(8
				(eastE nsBottom: 360)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 10)
				(self dispose:)
			)
		)
	)
)

(instance mirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 53)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 13801 15 -11 0 0 500)
			)
			(2
				(gSwatInterface showHandAni: 7)
			)
			(3
				(proc4_5)
				(setUpElement doit: 2)
				(gGame handsOn:)
				(++ local0)
				(actionTimer setReal: actionTimer 8)
				(self dispose:)
			)
		)
	)
)

(instance shootYourFriend of Script
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
				(SetFlag 94)
				(SetFlag 98)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance crowKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 1050 10314)
				(= seconds 1)
			)
			(1
				(proc4_6 13804 264 139 0 0 -1 1)
			)
			(2
				(proc4_5)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 1050 init: play: self)
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance elementDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 44 53 13005 10314)
				(= seconds 1)
			)
			(1
				(gFxSound number: 13005 setLoop: 0 play: self)
			)
			(2
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(sound1 number: 44 play: self)
				(sound2 number: 53 play: self)
			)
			(3)
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

(instance theBang of Prop
	(properties
		x 78
		y 161
		view 13805
	)
)

(instance element of Prop
	(properties)
)

(instance tello of Prop
	(properties)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 2 29 0 0 self) ; "Tello..."
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: 5 29 0 0 self) ; "Wixell..."
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
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
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(6
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: 4 29 0 0 self) ; "Denton..."
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 419
		nsBottom 240
		type 4099
	)

	(method (doVerb)
		(if (!= local0 2)
			(= global415 1)
		else
			(= global415 0)
		)
		(gCurRoom newRoom: 1390)
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 420
		nsRight 640
		nsBottom 140
		type 8195
	)

	(method (doVerb)
		(if (!= local0 2)
			(= global415 1)
		else
			(= global415 0)
		)
		(gCurRoom newRoom: 1390)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(switch local0
			(0
				(gCurRoom setScript: crowKills)
			)
			(1
				(gCurRoom setScript: crowKills)
			)
			(else
				(gCurRoom setScript: elementDies)
			)
		)
		(self dispose: delete:)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(denton dispose:)
				(tello dispose:)
				(wix dispose:)
				(carMike dispose:)
			)
			(1
				(denton
					view: 13801
					setCel: 0
					setLoop: 0
					posn: 431 114
					setPri: 500
					init:
				)
				(carMike
					view: 13801
					setCel: 1
					setLoop: 0
					posn: 431 114
					setPri: 500
					init:
				)
			)
			(2
				(denton
					view: 13801
					setCel: 0
					setLoop: 1
					posn: 407 114
					setPri: 500
					init:
				)
				(carMike
					view: 13801
					setCel: 1
					setLoop: 1
					posn: 407 114
					setPri: 500
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

(instance sound3 of Sound ; UNUSED
	(properties)
)

