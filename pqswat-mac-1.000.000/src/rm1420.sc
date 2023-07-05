;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1420)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1420 0
)

(local
	local0
	local1
)

(instance rm1420 of PQRoom
	(properties
		picture 1420
	)

	(method (init)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(= global415 1)
		)
		(if (!= 10306 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10306)
			(gBackMusic number: 10306 loop: -1 play:)
			(Lock rsAUDIO 10306 1)
		)
		(Load rsVIEW 14205)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(door cycleSpeed: 0 setPri: 205 init:)
		(if global415
			(self setScript: setUpOnDoor)
		else
			(self setScript: enterRoom)
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
				(gCurRoom setScript: throwBang)
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
						(and (proc4_11 52) (proc4_11 51) (== global149 2))
						(and (proc4_11 52) (== global149 1))
					)
					(gCurRoom setScript: openDoor)
				else
					(self setScript: timeOut)
					(return -1)
				)
			)
			(1
				(if
					(or
						(and (proc4_11 56) (proc4_11 51) (== global149 2))
						(and (proc4_11 56) (== global149 1))
					)
					(gCurRoom setScript: mirror)
				else
					(self setScript: timeOut)
					(return -1)
				)
			)
			(2
				(cond
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
						(gCurRoom setScript: aRightBLeft)
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
						(gCurRoom setScript: aLeftBRight)
					)
					(else
						(self setScript: timeOut)
						(return -1)
					)
				)
			)
			(3
				(if (and (proc4_11 46) (proc4_11 63) (== global149 2))
					(gCurRoom setScript: goTo1200)
				else
					(gCurRoom setScript: timeOut)
					(return -1)
				)
			)
		)
	)
)

(instance throwBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44 53 1002 10314)
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

(instance goTo1200 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(setUpElement doit: 0)
				(proc4_6 14205 -5 (proc4_16 39 39 11 11 11) 421 0 -1 1)
			)
			(1
				(door setCycle: End)
			)
			(2
				(gCurRoom newRoom: 1200)
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
				(Load rsVIEW 14205)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 104 4 0 self) ; "Denton, Carmichael, and Wixell, go left. Tello, go right. I'll follow Tello right."
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 14205 -5 (proc4_16 39 39 11 11 11) 381)
			)
			(3
				(setUpElement doit: 4)
				(proc4_5)
				(++ local0)
				(gGame handsOn:)
				(= global415 0)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
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
				(Load rsVIEW 14205)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 111 4 0 self) ; "Denton, Carmichael, and Wixell, go right. Tello, go left. I'll follow Tello left."
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 14205 -5 (proc4_16 39 39 11 11 11) 381)
			)
			(3
				(setUpElement doit: 4)
				(proc4_5)
				(++ local0)
				(gGame handsOn:)
				(= global415 1)
				(actionTimer setReal: actionTimer 6)
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
				(Load rsVIEW 14205)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 14205 -5 (proc4_16 39 39 11 11 11) 160)
				(door setPri: 215)
			)
			(2
				(setUpElement doit: 3)
				(proc4_5)
				(door setPri: 205)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 14205)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 14205 -5 (proc4_16 39 39 11 11 11) 61)
			)
			(2
				(door cel: 1)
			)
			(3
				(setUpElement doit: 2)
				(proc4_5)
				(++ local0)
				(gGame handsOn:)
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
				(Load rsAUDIO 15 53 10314)
				(Load rsVIEW 14207)
				(= seconds 1)
			)
			(1
				(militiaMan
					view: 14207
					posn: 384 186
					init:
					setCycle: CT 7 1 self
				)
			)
			(2
				(militiaMan setCycle: CT 19 1 self)
				(door setCycle: End)
				(gFxSound number: 15 setLoop: 0 play:)
			)
			(3
				(militiaMan setCycle: CT 29 1 self)
				(gFxSound number: 53 setLoop: 2 play:)
			)
			(4
				(militiaMan setCycle: End self)
				(gFxSound stop:)
			)
			(5
				(door dispose:)
				(militiaMan dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(6
				(gFxSound number: 53 setLoop: 1 play: self)
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

(instance shootYourFriends of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(actionTimer dispose: delete:)
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
					(tello
						(gGame showCloseUp: 9028 180 66 self 1)
					)
					(wix
						(gGame showCloseUp: 9014 180 66 self 1)
					)
					(denton
						(gGame showCloseUp: 9020 180 66 self 1)
					)
					(carMike
						(gGame showCloseUp: 9008 180 66 self 1)
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
				(gMessager say: 6 7 0 2 self) ; "Get him outta there!"
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance setUpOnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 14205 -5 (proc4_16 39 39 11 11 11))
			)
			(1
				(setUpElement doit: 1)
				(proc4_5)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoProp of Prop
	(properties)
)

(instance denton of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(= local1 4)
				(gCurRoom setScript: sayYou)
			)
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
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

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(= local1 5)
				(gCurRoom setScript: sayYou)
			)
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
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

(instance carMike of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(= local1 3)
				(gCurRoom setScript: sayYou)
			)
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
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

(instance tello of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(= local1 2)
				(gCurRoom setScript: sayYou)
			)
			(7
				(gCurRoom setSCript: shootYourFriends 0 self)
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

(instance militiaMan of Prop
	(properties
		x 384
		y 186
		view 14207
	)
)

(instance door of Prop
	(properties
		x 367
		y 86
		view 14220
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(if (!= (gCurRoom script:) sayYou)
			(gCurRoom setScript: timeOut)
			(self dispose: delete:)
		)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(denton dispose:)
				(carMike dispose:)
				(wix dispose:)
				(tello dispose:)
				(egoProp dispose:)
			)
			(1
				(denton
					view: 14205
					setCel: 0
					setLoop: 0
					setPri: 240
					posn: 103 60
					init:
				)
				(carMike
					view: 14205
					setCel: 1
					setLoop: 0
					setPri: 240
					posn: 103 60
					init:
				)
				(wix
					view: 14205
					setCel: 2
					setLoop: 0
					setPri: 240
					posn: 103 60
					setPri: 300
					init:
				)
				(tello
					view: 14205
					setCel: 3
					setLoop: 0
					setPri: 240
					posn: 103 60
					init:
				)
				(egoProp
					view: 14205
					setCel: 4
					setLoop: 0
					setPri: 240
					posn: 103 60
					setPri: 400
					init:
				)
			)
			(2
				(denton
					view: 14205
					setCel: 0
					setLoop: 1
					setPri: 240
					posn: 88 64
					init:
				)
				(carMike
					view: 14205
					setCel: 1
					setLoop: 1
					setPri: 240
					posn: 88 64
					init:
				)
				(wix
					view: 14205
					setCel: 2
					setLoop: 1
					setPri: 240
					posn: 88 64
					init:
				)
				(tello
					view: 14205
					setCel: 3
					setLoop: 1
					setPri: 240
					posn: 88 64
					init:
				)
				(egoProp
					view: 14205
					setCel: 4
					setLoop: 1
					setPri: 240
					posn: 88 64
					init:
				)
			)
			(3
				(denton
					view: 14205
					setCel: 0
					setLoop: 2
					setPri: 240
					posn: 87 61
					init:
				)
				(carMike
					view: 14205
					setCel: 1
					setLoop: 2
					setPri: 240
					posn: 87 61
					init:
				)
				(wix
					view: 14205
					setCel: 2
					setLoop: 2
					setPri: 240
					posn: 87 61
					init:
				)
				(tello
					view: 14205
					setCel: 3
					setLoop: 2
					setPri: 240
					posn: 87 61
					init:
				)
				(egoProp
					view: 14205
					setCel: 4
					setLoop: 2
					setPri: 240
					posn: 87 61
					init:
				)
			)
			(4
				(denton
					view: 14205
					setCel: 0
					setLoop: 3
					setPri: 240
					posn: 88 65
					init:
				)
				(carMike
					view: 14205
					setCel: 1
					setLoop: 3
					setPri: 240
					posn: 88 65
					init:
				)
				(wix
					view: 14205
					setCel: 2
					setLoop: 3
					setPri: 240
					posn: 88 65
					init:
				)
				(tello
					view: 14205
					setCel: 3
					setLoop: 3
					setPri: 240
					posn: 88 65
					init:
				)
				(egoProp
					view: 14205
					setCel: 4
					setLoop: 3
					setPri: 240
					posn: 88 65
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

(instance sayYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: local1 29 0 0 self)
			)
			(1
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 3)
				(self dispose:)
			)
		)
	)
)

