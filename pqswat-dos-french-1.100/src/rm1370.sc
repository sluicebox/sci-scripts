;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1370)
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
	rm1370 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm1370 of PQRoom
	(properties
		picture 1370
	)

	(method (init)
		(if (!= 10311 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10311)
			(gBackMusic number: 10311 loop: -1 play:)
			(Lock rsAUDIO 10311 1)
		)
		(Load rsAUDIO 44)
		(Load rsVIEW 13702)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(northE init:)
		(if (IsFlag 303)
			(self setScript: sDeathScene)
		else
			(self setScript: enterRoom)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 45)
				(if (== local0 1)
					(gCurRoom setScript: holdScript)
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 43 47 44 46 42 55 56 49 48)
				(if (== local0 1)
					(gCurRoom setScript: roundCorner)
				else
					(gCurRoom setScript: timeOut)
				)
			)
			((== theVerb 7)
				(gCurRoom setScript: shootWall)
			)
			((== theVerb 6)
				(gCurRoom setScript: shootWall)
			)
			((== theVerb 16)
				(gCurRoom setScript: tossFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify)
		(switch local0
			(0
				(if (and (proc4_11 46) (proc4_11 63) (== global149 2))
					(gCurRoom setScript: elementMove)
				else
					(self setScript: timeOut)
					(return -1)
				)
			)
			(1
				(if (and (proc4_11 45) (proc4_11 62) (== global149 2))
					(gCurRoom setScript: holdScript)
				else
					(gCurRoom setScript: sMilitiaMenPopUp)
					(return -1)
				)
			)
		)
	)

	(method (dispose)
		(Lock rsAUDIO 10311 0)
		(super dispose:)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 13702 0 48)
			)
			(1
				(proc4_5)
				(setUpElement doit: 1)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 10)
				(self dispose:)
			)
		)
	)
)

(instance elementMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 62 1 0 self) ; "Ready to move... Go!"
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 13705 0 53)
			)
			(2
				(setUpElement doit: 2)
				(proc4_5)
				(gGame handsOn:)
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance holdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 94 2 0 self) ; "Hold."
			)
			(1
				(gCurRoom newRoom: 1380)
			)
		)
	)
)

(instance roundCorner of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050 10314)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 13706 174 70)
			)
			(2
				(gAutoRobot setPri: 265)
			)
			(3
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 1050 init: play: self)
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

(instance tossFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 1050 6007 10314)
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
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
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
				(if local1
					(gMessager say: 6 7 4 0 self) ; "Hold fire! Denton to Twenty David. Pup firing recklessly... randomly."
				else
					(gMessager say: 6 7 3 0 self) ; "Hold fire!"
				)
			)
			(1
				(if local1
					(SetFlag 98)
					(gCurRoom newRoom: 35) ; metroExt
				else
					(++ local1)
					(gGame handsOn:)
					(actionTimer setReal: actionTimer 6)
					(self dispose:)
				)
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
					(carmike
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

(instance sGoForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050 10314)
				(Load rsVIEW 13801)
				(Load rsPIC 1380)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(if (== local0 0)
					(proc4_6 13705 0 53)
				else
					(self cue:)
				)
			)
			(2
				(proc4_6 13706 174 70)
			)
			(3
				(gAutoRobot setPri: 265)
			)
			(4
				(setUpElement doit: 1380)
				(proc4_6 13804 264 139 0 0 -1 1)
				(gCurRoom drawPic: 1380)
			)
			(5
				(proc4_5)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 1050 init: play: self)
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

(instance sMilitiaMenPopUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(Load rsAUDIO 44 13704)
				(gGame handsOff:)
				((= local3 (Prop new:))
					view: 13701
					loop: 0
					cel: 0
					posn: 334 210
					init:
					setCycle: CT 20 1 self
				)
				((= local2 (Prop new:))
					view: 13704
					loop: 0
					cel: 0
					posn: 317 217
					init:
					setCycle: CT 7 1 self
				)
			)
			(1
				(gFxSound number: 13704 loop: 0 play:)
				(local2 cel: 8 setCycle: CT 23 1)
			)
			(2
				(gFxSound number: 13704 loop: 0 play:)
				(local2 cel: 8 setCycle: CT 23 1)
				(sound1 number: 44 loop: 0 play:)
				(local3 cel: 21 setCycle: CT 33 1 self)
			)
			(3
				(local2 dispose:)
				(local3 dispose:)
				(gCurRoom newRoom: 72) ; funeralRoom
				(self dispose:)
			)
		)
	)
)

(instance do1380 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050 10314)
				(Load rsVIEW 13801)
				(Load rsPIC 1380)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 1380)
				(proc4_6 13804 264 139 0 0 -1 1)
				(gCurRoom drawPic: 1380)
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

(instance timeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050 10314)
				(= seconds 2)
			)
			(1
				(proc4_6 13704 259 115)
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

(instance sDeathScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				((= local2 (Prop new:))
					view: 13700
					loop: 0
					cel: 0
					posn: 101 343
					init:
					setCycle: CT 14 1 self
				)
			)
			(2
				(gFxSound number: 44 loop: 0 play:)
				(local2 cel: 15 setCycle: CT 27 1 self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
				(self dispose:)
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
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 2 29 0 0 self) ; "Tello..."
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

(instance carmike of Prop
	(properties)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 3 29 0 0 self) ; "Carmichael..."
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 5 29 0 0 self) ; "Wixell..."
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 4 29 0 0 self) ; "Denton..."
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

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 48
		type 4097
	)

	(method (doVerb)
		(gCurRoom setScript: sGoForward)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(wix dispose:)
				(denton dispose:)
				(carmike dispose:)
				(tello dispose:)
			)
			(1
				(wix
					view: 13702
					setCel: 0
					setLoop: 0
					posn: 1 65
					setPri: 385
					init:
				)
				(denton
					view: 13702
					setCel: 1
					setLoop: 0
					posn: 1 65
					setPri: 385
					init:
				)
				(carmike
					view: 13702
					setCel: 2
					setLoop: 0
					posn: 1 65
					setPri: 385
					init:
				)
				(tello
					view: 13702
					setCel: 3
					setLoop: 0
					posn: 1 65
					setPri: 385
					init:
				)
			)
			(2
				(wix view: 13702 setCel: 0 setLoop: 1 posn: 265 99 init:)
				(denton view: 13702 setCel: 1 setLoop: 1 posn: 265 99 init:)
				(tello view: 13702 setCel: 2 setLoop: 1 posn: 265 99 init:)
			)
			(1380
				(if (gCast contains: wix)
					(wix dispose:)
				)
				(if (gCast contains: tello)
					(tello dispose:)
				)
				(denton
					view: 13801
					setCel: 0
					setLoop: 0
					posn: 431 114
					setPri: 500
					init:
				)
				(carmike
					view: 13801
					setCel: 1
					setLoop: 0
					posn: 431 114
					setPri: 500
					init:
				)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(switch local0
			(0
				(gCurRoom setScript: timeOut)
			)
			(1
				(gCurRoom setScript: roundCorner)
			)
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

(instance sound1 of Sound
	(properties)
)

