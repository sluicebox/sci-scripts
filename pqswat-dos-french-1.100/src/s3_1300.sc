;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1300)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s3_1300 0
)

(local
	local0
	local1
	local2
	local3
)

(instance s3_1300 of PQRoom
	(properties
		picture 1300
	)

	(method (init)
		(if (and global102 (OneOf gPrevRoomNum 15 8)) ; mainMenu, sierraLogo
			(= global415 0)
			(= local1 0)
		)
		(if (!= 10309 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10309)
			(gBackMusic number: 10309 loop: -1 play:)
			(Lock rsAUDIO 10309 1)
		)
		(switch global415
			(1
				(Load rsVIEW 13008)
			)
			(2
				(Load rsAUDIO 13003 10314)
				(Load rsVIEW 13003)
			)
			(else
				(Load rsVIEW 13016)
			)
		)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 1240)
				(= local1 0)
			)
			((== gPrevRoomNum 1200)
				(= local1 1)
			)
		)
		(eastExit init:)
		(westExit init:)
		(switch global415
			(1
				(tello view: 13008 setCel: 12 setLoop: 0 posn: 463 363 init:)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
			)
			(2
				(gCurRoom setScript: deathEnter)
			)
			(else
				(self setScript: enterRoom)
			)
		)
	)

	(method (lashNotify)
		(switch local0
			(0
				(cond
					((and (proc4_11 62) (== global149 1) (== global415 0))
						(= local2 107)
						(= local3 1)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 64) (== global149 1) (== global415 0))
						(= local2 108)
						(= local3 1)
						(gCurRoom setScript: sayThis)
					)
					(
						(and
							(proc4_11 64)
							(proc4_11 66)
							(== global149 2)
							(== global415 0)
						)
						(= local2
							(if (proc4_11 64)
								(and (proc4_11 66) (== global149 2))
							)
						)
						(= local3 1)
						(gCurRoom setScript: sayThis)
					)
					(else
						(if (!= global415 2)
							(gCurRoom setScript: timeOut)
						)
						(return -1)
					)
				)
			)
			(1
				(if
					(and
						(or
							(and (proc4_11 48) (== global149 1))
							(and (proc4_11 48) (proc4_11 49) (== global149 2))
						)
						(== global415 0)
					)
					(self setScript: aClearLeft)
				else
					(gCurRoom setScript: timeOut)
					(return -1)
				)
			)
			(2
				(if
					(and
						(proc4_11 45)
						(proc4_11 62)
						(== global149 2)
						(== global415 0)
					)
					(gCurRoom setScript: holdScript)
				else
					(self setScript: timeOut3)
					(return -1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== local0 0) (OneOf theVerb 43 47 46 42 55 56 49 48))
				(gCurRoom setScript: timeOut)
			)
			((== theVerb 7)
				(gCurRoom setScript: telloShootWall)
			)
			((== theVerb 6)
				(gCurRoom setScript: telloShootWall)
			)
			((== theVerb 16)
				(if local0
					(gCurRoom setScript: elementBang)
				else
					(gCurRoom setScript: telloBang)
				)
			)
			((< local0 2)
				(gCurRoom setScript: timeOut)
				(return -1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(actionTimer dispose: delete:)
		(super dispose: &rest)
	)

	(method (cue)
		(gGame handsOn:)
		(super cue:)
	)
)

(instance telloBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 1003 13003)
				(Load rsVIEW 6 13003 13008 13012 13014)
				(= seconds 2)
			)
			(1
				(theBang init: setCycle: CT 3 1 self)
			)
			(2
				(theBang setCycle: End self)
				(gFxSound number: 1003 setLoop: 0 play:)
			)
			(3
				(theBang dispose:)
				(gFxSound number: 1002 setLoop: 0 play:)
				(whiteScreen init:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(tello view: 13008 posn: 467 374 cel: 0 setCycle: End)
				(militiaMan
					view: 13003
					posn: 95 240
					init:
					setCycle: CT 11 1 self
				)
				(bCrow view: 13014 posn: 129 255 init: setCycle: End)
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
				(gFxSound number: 13003 setLoop: 0 play: self)
				(militiaMan setCycle: End)
			)
			(8
				(bCrow dispose:)
				(militiaMan dispose:)
				(tello dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 13003 setLoop: 0 play: self)
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

(instance elementBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 1003 13006 10314)
				(Load rsVIEW 6 13005 13012 13015)
				(= seconds 2)
			)
			(1
				(theBang init: setCycle: CT 3 1 self)
			)
			(2
				(theBang setCycle: End self)
				(gFxSound number: 1003 setLoop: 0 play:)
			)
			(3
				(theBang dispose:)
				(gFxSound number: 1002 setLoop: 0 play:)
				(whiteScreen init:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(bCrow view: 13005 posn: 9 213 init: setCycle: CT 4 1 self)
				(militiaMan view: 13015 posn: 8 200 init: setCycle: End)
				(if (== local0 1)
					(setUpElement doit: 0)
					(proc4_6 13009 12 46 0 0 -1 1)
				else
					(= seconds 1)
				)
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
				(gFxSound number: 13006 setLoop: 0 play:)
				(bCrow setCycle: End self)
			)
			(8
				(if (== local0 1)
					(proc4_5)
				else
					(setUpElement doit: 0)
				)
				(bCrow dispose:)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 13006 setLoop: 0 play: self)
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

(instance holdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 94 3 0 self) ; "Hold."
			)
			(1
				(= global415 0)
				(gCurRoom newRoom: 1080)
			)
		)
	)
)

(instance aClearLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 13010 57)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 0 4 0 self) ; "Entry Team A... Ready to clear... Go!"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 13011 16 39 0 0 275 1)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(gSwatInterface showHandAni: 6)
			)
			(5
				(gSwatInterface showHandAni: 6)
			)
			(6
				(gSwatInterface showHandAni: 6)
			)
			(7
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

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(tello view: 13016 setLoop: 1 posn: 472 117 setCel: 0 init:)
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
				(Load rsAUDIO 1050 10314 13003)
				(Load rsVIEW 13003)
				(= seconds 1)
			)
			(1
				(militiaMan
					view: 13003
					posn: 95 240
					init:
					setCycle: CT 11 1 self
				)
			)
			(2
				(if (== (tello view:) 13008)
					(tello setCycle: End self)
				else
					(self cue:)
				)
				(gFxSound number: 13003 setLoop: -1 play:)
				(militiaMan setCycle: End self)
			)
			(3)
			(4
				(gFxSound stop:)
				(setUpElement doit: 0)
				(militiaMan dispose:)
				(tello dispose:)
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
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance timeOut3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 13005 13015)
				(Load rsAUDIO 10314 6007 13015)
				(= seconds 2)
			)
			(1
				(bCrow view: 13005 x: 8 y: 208 init: setCycle: CT 3 1 self)
				(militiaMan view: 13015 x: 8 y: 210 init: setCycle: End self)
			)
			(2
				(gFxSound number: 13015 setLoop: -1 play:)
				(bCrow setCycle: End self)
			)
			(3)
			(4
				(gFxSound stop:)
				(bCrow dispose:)
				(militiaMan dispose:)
				(setUpElement doit: 0)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance telloShootWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 13003 10314)
				(Load rsAUDIO 13003 13014)
				(= seconds 1)
			)
			(1
				(militiaMan
					view: 13003
					posn: 95 240
					init:
					setCycle: CT 11 1 self
				)
				(if local0
					(bCrow view: 13014 posn: 129 255 init: setCycle: End self)
				)
			)
			(2
				(gFxSound number: 13003 setLoop: -1 play:)
				(if local0
					(militiaMan setCycle: End)
				else
					(militiaMan setCycle: End self)
				)
			)
			(3
				(gFxSound stop:)
				(self cue:)
			)
			(4
				(militiaMan dispose:)
				(if (gCast contains: bCrow)
					(bCrow dispose:)
				)
				(if (gCast contains: tello)
					(tello dispose:)
				)
				(if local0
					(setUpElement doit: 0)
				)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 13003 setLoop: 1 play: self)
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

(instance do1600 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 16001 10314)
				(Load rsPIC 1600)
				(Load rsVIEW 16001 16000)
				(= seconds 2)
			)
			(1
				(tello dispose:)
				(gCurRoom drawPic: 1600)
				(militiaMan view: 16001 posn: 401 358 init: setPri: 500)
				(egoProp
					view: 16000
					posn: 195 406
					init:
					setPri: 375
					setCycle: CT 7 1 self
				)
			)
			(2
				(militiaMan setCycle: CT 25 1 self)
				(egoProp setCycle: End self)
			)
			(3
				(militiaMan setCycle: End self)
				(gFxSound number: 16001 setLoop: 0 play:)
			)
			(4)
			(5
				(militiaMan dispose:)
				(egoProp dispose:)
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

(instance do1370 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314)
				(Load rsPIC 1370)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1370)
				(proc4_6 13704 251 102)
			)
			(2
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(3
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
				(Load rsAUDIO 13005 10314 13014)
				(Load rsPIC 1240 1300)
				(Load rsVIEW 13014 10314)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(gCurRoom drawPic: 1240)
				(gFxSound number: 13005 setLoop: 0 play: self)
			)
			(2
				(gCurRoom drawPic: 1300)
				(bCrow view: 13014 posn: 126 255 init: setCycle: End self)
				(militiaMan
					view: 13003
					posn: 95 240
					init:
					setCycle: CT 11 1 self
				)
				(proc4_6 13001 0 79 0 0 -1 1)
			)
			(3
				(gFxSound number: 13014 setLoop: 1 play:)
				(militiaMan setCycle: End self)
			)
			(4)
			(5
				(gFxSound stop:)
				(militiaMan dispose:)
				(bCrow dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 13005 setLoop: 0 play: self)
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

(instance death1240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 13005 10314 13015)
				(Load rsPIC 1240 1300)
				(Load rsVIEW 13005 13015 13007)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(proc4_5)
				(gCurRoom drawPic: 1240)
				(gFxSound number: 13005 setLoop: 0 play: self)
			)
			(2
				(gCurRoom drawPic: 1300)
				(element view: 13007 posn: 9 295 init:)
				(bCrow view: 13005 x: 8 y: 208 init: setCycle: CT 3 1 self)
				(militiaMan view: 13015 x: 8 y: 210 init: setCycle: End self)
			)
			(3
				(gFxSound number: 13015 setLoop: -1 play:)
				(bCrow setCycle: End self)
			)
			(4)
			(5
				(gFxSound stop:)
				(bCrow dispose:)
				(militiaMan dispose:)
				(element dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 13005 setLoop: 0 play: self)
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

(instance aTeamEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 13016)
				(= seconds 1)
			)
			(1
				(tello dispose:)
				(proc4_6 13016 15 38)
			)
			(2
				(setUpElement doit: 1)
				(gGame handsOn:)
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance deathEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 13010 151 36 0 0 -1 1)
			)
			(1
				(militiaMan
					view: 13003
					posn: 95 240
					init:
					setCycle: CT 11 1 self
				)
			)
			(2
				(gFxSound number: 13003 setLoop: 0 play:)
				(militiaMan setCycle: End)
			)
			(3
				(proc4_5)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
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

(instance tello1240 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 13003 13005 10314)
				(Load rsPIC 1240 1300)
				(Load rsVIEW 13000 13003)
				(= seconds 2)
			)
			(1
				(tello dispose:)
				(gCurRoom drawPic: 1240)
				(gFxSound number: 13005 setLoop: 0 play: self)
			)
			(2
				(gCurRoom drawPic: 1300)
				(tello view: 13000 posn: 367 358 init:)
				(militiaMan
					view: 13003
					posn: 95 240
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
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance killElement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 13006 10314)
				(Load rsVIEW 13005 13015)
				(= seconds 1)
			)
			(1
				(bCrow view: 13005 posn: 12 210 init: setCycle: CT 4 1 self)
				(militiaMan view: 13015 posn: 5 206 init: setCycle: End)
			)
			(2
				(gFxSound number: 13006 setLoop: 0 play:)
				(bCrow setCycle: End self)
			)
			(3
				(setUpElement doit: 0)
				(proc4_5)
				(bCrow dispose:)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
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

(instance theBang of Prop
	(properties
		x 143
		y 317
		view 13012
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
				(gCurRoom setScript: timeOut)
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
				(gCurRoom setScript: timeOut)
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
				(gCurRoom setScript: timeOut)
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
				(gCurRoom setScript: timeOut)
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

(instance whiteScreen of View
	(properties
		x 289
		y 179
		priority 500
		fixPriority 1
		view 6
	)
)

(instance egoProp of Prop
	(properties)
)

(instance element of Prop
	(properties)
)

(instance eastExit of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(switch local0
			(0
				(if (== local1 1)
					(gCurRoom newRoom: 1200)
				else
					(gCurRoom setScript: tello1240)
				)
			)
			(1
				(gCurRoom setScript: do1240)
			)
			(2
				(gCurRoom setScript: death1240)
			)
		)
	)
)

(instance westExit of HotSpot
	(properties
		nsRight 48
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(if (== local1 1)
			(gCurRoom setScript: do1600)
		else
			(if local0
				(= global415 local0)
			else
				(= global415 3)
			)
			(gCurRoom newRoom: 1080)
		)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(wix dispose:)
				(tello dispose:)
				(denton dispose:)
				(carmike dispose:)
			)
			(1
				(wix view: 13016 posn: 248 112 setPri: 275 setCel: 0 init:)
				(tello
					view: 13016
					posn: 248 112
					setPri: 275
					setLoop: 0
					setCel: 1
					init:
				)
				(denton view: 13016 posn: 248 112 setPri: 275 setCel: 2 init:)
				(carmike view: 13016 posn: 248 112 setPri: 275 setCel: 3 init:)
			)
			(2
				(tello view: 13010 posn: 37 140 setLoop: 0 setCel: 0 init:)
				(denton view: 13010 posn: 37 140 setLoop: 0 setCel: 1 init:)
				(carmike view: 13010 posn: 37 140 setLoop: 0 setCel: 2 init:)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(cond
			((and (== local0 0) (== global415 1))
				(gCurRoom setScript: timeOut)
			)
			((and (== local0 0) (== global415 0))
				(gCurRoom setScript: aTeamEnter)
			)
			((== local0 2)
				(gCurRoom setScript: timeOut3)
			)
			(else
				(gCurRoom setScript: killElement)
			)
		)
		(self dispose: delete:)
	)
)

(instance sayThis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 local2 local3 0 self)
			)
			(1
				(actionTimer setReal: actionTimer 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

