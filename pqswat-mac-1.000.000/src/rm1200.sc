;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1200)
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
	rm1200 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm1200 of PQRoom
	(properties
		picture 1200
	)

	(method (init)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(= global415 0)
		)
		(if (!= 10307 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10307)
			(gBackMusic number: 10307 loop: -1 play:)
			(Lock rsAUDIO 10307 1)
		)
		(cond
			((== gPrevRoomNum 1300) ; s3_1300
				(Load rsVIEW 12018)
			)
			(global415
				(Load rsVIEW 12018)
			)
			(else
				(Load rsVIEW 12020)
			)
		)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 1300) ; s3_1300
				(leftExit init:)
				(northExit init:)
				(rightExit init:)
				(setUpElement doit: 1)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
			)
			(global415
				(self setScript: enterRoom)
			)
			(else
				(self setScript: wrongEnter)
			)
		)
	)

	(method (cue)
		(actionTimer setReal: actionTimer 3)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(if local2
					(self setScript: shootAgain)
				else
					(actionTimer dispose: delete:)
					(++ local2)
					(gGame handsOff:)
					(gMessager say: 2 7 3 0 self) ; "Cease fire!"
				)
			)
			(6
				(if local2
					(self setScript: shootAgain)
				else
					(actionTimer dispose: delete:)
					(++ local2)
					(gGame handsOff:)
					(gMessager say: 2 7 3 0 self) ; "Cease fire!"
				)
			)
			(16
				(if global415
					(gCurRoom setScript: tossFlashBang)
				else
					(gCurRoom setScript: wrongEnterBang)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify)
		(switch local1
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
						(gCurRoom setScript: do1300)
					)
					(
						(and
							(proc4_11 48)
							(proc4_11 50)
							(proc4_11 64)
							(proc4_11 66)
							(== global149 4)
						)
						(self setScript: aClRtBCovLft)
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
							(self setScript: shootAgain)
							(return -1)
						else
							(= local3 103)
							(self setScript: bTeamDies)
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
							(self setScript: shootAgain)
							(return -1)
						else
							(= local3 104)
							(self setScript: bTeamDies)
						)
					)
					(
						(or
							(and (proc4_11 75) (== global149 1))
							(and (proc4_11 74) (proc4_11 75) (== global149 2))
						)
						(if global415
							(self setScript: shootAgain)
							(return -1)
						else
							(= local5 2)
							(self setScript: initFlashBang)
						)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(if global415
							(self setScript: shootAgain)
							(return -1)
						else
							(= local5 1)
							(self setScript: initFlashBang)
						)
					)
					(else
						(gCurRoom setScript: shootAgain)
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

(instance aClRtBCovLft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 102 1 0 self) ; "Tello, hold and cover left. Entry team A, prepare to clear stairs. Move!"
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 12019 0 -57 0 0 -1 1)
			)
			(2
				(gCurRoom newRoom: 1240)
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
				(proc4_6 12000 0 -57 0 0 390)
			)
			(1
				(gSwatInterface showHandAni: 6)
			)
			(2
				(proc4_6 12018 0 -57)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(leftExit init:)
				(northExit init:)
				(rightExit init:)
				(setUpElement doit: 1)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance initFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 1002 10314)
				(Load rsVIEW 6 12400)
				(Load rsPIC 1240)
				(= seconds 2)
			)
			(1
				(switch local5
					(1
						(gMessager say: 1 105 4 1 self) ; "Denton, prepare to flashbang stairs."
					)
					(2
						(gMessager say: 1 106 5 1 self) ; "Tello, prepare to flashbang stairs."
					)
				)
			)
			(2
				(switch local5
					(1
						(gGame showCloseUp: 12012 180 66 self 1)
					)
					(2
						(gGame showCloseUp: 12011 180 66 self 1)
					)
				)
			)
			(3
				(switch local5
					(1
						(gMessager say: 1 105 4 2) ; "Ready... Go!"
					)
					(2
						(gMessager say: 1 106 5 2) ; "Ready... Go!"
					)
				)
				(self cue:)
			)
			(4
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 0 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(setUpElement doit: 0)
				(proc4_6 12010 109 -22 11 0 -1 1)
				(FrameOut)
				(= cycles 2)
			)
			(5
				(whiteScreen dispose:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(7
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(8
				(gAutoRobot setPri: 375)
			)
			(9)
			(10
				(proc4_5)
				(gCurRoom drawPic: 1240)
				(militiaMan
					view: 12400
					setLoop: 0
					setCel: 12
					posn: 357 200
					init:
					setCycle: End self
				)
			)
			(11
				(militiaMan dispose:)
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

(instance tossFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 1003 53 10314)
				(Load rsVIEW 6 12008)
				(= seconds 2)
			)
			(1
				(gFxSound number: 1003 setLoop: 0 play: self)
			)
			(2
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 0 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(setUpElement doit: 0)
				(dudes view: 12008 posn: 301 366 init: setCycle: CT 20 1 self)
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
				(gMessager say: 2 16 0 0) ; "Compromised!"
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
			)
			(6
				(dudes setCycle: End self)
			)
			(7
				(dudes dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 53 setLoop: 0 play: self)
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

(instance do1300 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 13005 13003 10314)
				(Load rsVIEW 12001 12014 13000 13003)
				(Load rsPIC 1300)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 12014 180 66 self 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(setUpElement doit: 0)
				(dudes view: 12001 posn: 315 323 init: setCycle: End)
				(tello
					view: 12014
					posn: 407 371
					init:
					setPri: 500
					setCycle: End self
				)
			)
			(3
				(gFxSound number: 13005 setLoop: 0 play: self)
			)
			(4
				(dudes dispose:)
				(gCurRoom drawPic: 1300)
				(tello view: 13000 posn: 367 358 init:)
				(militiaMan
					view: 13003
					posn: 91 240
					init:
					setCycle: CT 11 1 self
				)
			)
			(5
				(gFxSound number: 13003 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(6
				(militiaMan dispose:)
				(tello dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(8
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 12400)
				(Load rsPIC 1240)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1240)
				(militiaMan
					view: 12400
					x: 357
					y: 200
					init:
					setCycle: CT 41 1 self
				)
			)
			(2
				(militiaMan setCycle: End self)
				(gunShot dispose:)
			)
			(3
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(5
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
			(2
				(if (== local4 7)
					(setUpElement doit: 0)
					(Palette 2 42 254 100) ; PalIntensity
					(switch register
						(tello
							(proc4_6 12002 165 4 0 0 -1 1)
						)
						(denton
							(proc4_6 12004 167 23 0 0 -1 1)
						)
						(carmike
							(proc4_6 12003 165 4 0 0 -1 1)
						)
						(wix
							(proc4_6 12005 159 48 0 0 -1 1)
						)
					)
				else
					(self cue:)
				)
			)
			(3
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(5
				(if (== local4 6)
					(gBackMusic number: 6007 loop: 1 play:)
					(Lock rsAUDIO 6007 1)
					(SetFlag 94)
					(SetFlag 98)
					(SetFlag 100)
					(gCurRoom newRoom: 35) ; metroExt
				else
					(gCurRoom newRoom: 72) ; funeralRoom
				)
			)
		)
	)
)

(instance shootAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 12016)
				(Load rsAUDIO 51 10314)
				(Load rsPIC 1200 1240)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1240)
				(proc4_6 12402 364 -31 0 0 500)
			)
			(2
				(dudes
					view: 12016
					posn: 305 381
					cel: 16
					init:
					setCycle: End self
				)
				(gCurRoom drawPic: 1200)
			)
			(3
				(dudes dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1220 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsPIC 1200 1220)
				(= seconds 2)
			)
			(1
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 1220)
				(= seconds 6)
			)
			(2
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 1200)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance wrongEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 12009 -7 -59)
			)
			(1
				(gSwatInterface showHandAni: 6)
			)
			(2
				(proc4_6 12020 -7 -59)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(leftExit init:)
				(northExit init:)
				(rightExit init:)
				(setUpElement doit: 2)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance bTeamDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 12400)
				(Load rsPIC 1240)
				(= seconds 2)
			)
			(1
				(if local3
					(gMessager say: 1 local3 2 0 self)
				else
					(self cue:)
				)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 12021 -7 -59)
			)
			(3
				(gCurRoom drawPic: 1240)
				(proc4_6 12406 87 -98 0 0 -1 1)
			)
			(4
				(militiaMan
					view: 12400
					setLoop: 0
					setCel: 0
					posn: 357 200
					init:
					setCycle: End self
				)
			)
			(5
				(militiaMan hide:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
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

(instance wrongEnterBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 1003 53 10314)
				(Load rsVIEW 6 12006)
				(= seconds 2)
			)
			(1
				(gFxSound number: 1003 setLoop: 0 play: self)
			)
			(2
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 0 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(setUpElement doit: 0)
				(gMessager say: 2 16 0 0) ; "Compromised!"
				(FrameOut)
				(= cycles 2)
			)
			(3
				(proc4_6 12013 195 18 0 0 -1 1)
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
				(militiaMan init: cel: 8 setCycle: End self)
			)
			(7)
			(8
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
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

(instance militiaMan of Prop
	(properties
		x 152
		y 198
		view 12006
	)

	(method (doit)
		(if (not (gunShot handle:))
			(switch view
				(12006
					(if (and (== cel 17) (not (gunShot handle:)))
						(gunShot number: 53 play:)
					)
				)
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

(instance tello of Prop
	(properties
		view 12000
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local4 theVerb)
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(= local4 theVerb)
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 3 29 0 0 self) ; "Tello..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carmike of Prop
	(properties
		view 12000
		cel 1
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local4 theVerb)
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(= local4 theVerb)
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 5 29 0 0 self) ; "Carmichael..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wix of Prop
	(properties
		view 12000
		cel 2
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local4 theVerb)
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(= local4 theVerb)
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 6 29 0 0 self) ; "Wixell..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop
	(properties
		view 12000
		cel 3
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local4 theVerb)
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(= local4 theVerb)
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(gGame handsOff:)
				(gMessager say: 4 29 0 0 self) ; "Denton..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dudes of Prop
	(properties)

	(method (doit)
		(if (not (gunShot handle:))
			(switch view
				(12016
					(cond
						((== cel 20)
							(gunShot number: 51 init:)
						)
						((OneOf cel 25 27 32)
							(gunShot play:)
						)
					)
				)
			)
		)
		(super doit:)
	)
)

(instance leftExit of HotSpot
	(properties
		nsTop 39
		nsRight 111
		nsBottom 359
		type 32769
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if global415
					(= global415 1)
					(gCurRoom newRoom: 1300) ; s3_1300
				else
					(= global415 2)
					(gCurRoom newRoom: 1300) ; s3_1300
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightExit of HotSpot
	(properties
		nsLeft 219
		nsTop 24
		nsRight 311
		nsBottom 263
		type 8193
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: do1240)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northExit of HotSpot
	(properties
		nsRight 218
		nsBottom 165
		type 4097
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: do1220)
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
				(tello dispose:)
				(carmike dispose:)
				(wix dispose:)
				(denton dispose:)
			)
			(1
				(tello view: 12018 posn: 387 369 init: setLoop: 0 setCel: 2)
				(carmike view: 12018 posn: 387 369 init: setLoop: 0 setCel: 0)
				(wix view: 12018 posn: 387 369 init: setLoop: 0 setCel: 1)
				(denton view: 12018 posn: 387 369 init: setLoop: 0 setCel: 3)
			)
			(2
				(carmike view: 12020 posn: 296 420 init: setLoop: 0 setCel: 0)
				(denton view: 12020 posn: 296 420 init: setLoop: 0 setCel: 1)
				(wix view: 12020 posn: 296 420 init: setLoop: 0 setCel: 2)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(self dispose: delete:)
		(gCurRoom setScript: shootAgain)
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

