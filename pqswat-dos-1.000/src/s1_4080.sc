;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4080)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4080 0
)

(local
	local0
	local1
	local2
	local3
)

(instance s1_4080 of PQRoom
	(properties
		picture 4080
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(eastJam init:)
		(westJam init:)
		(robotFeature init:)
		(denton init:)
		(if (== gPrevRoomNum 4050) ; s1_4050
			(Lock rsAUDIO 40103 0)
			(Load rsAUDIO 40104)
			(Lock rsAUDIO 40104 1)
			(gBackMusic number: 0 stop:)
			(gBackMusic number: 40104 loop: -1 play:)
			(UnLoad 141 40103)
			(global112 startPath: 79)
		)
		(gGame handsOn:)
		(self setScript: guysGotoDoor)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(self setScript: shotGun)
			)
			(6
				(self setScript: shotGun)
			)
			(16
				(self setScript: throwFlashBang)
			)
			(45
				(self setScript: pacmeyerTurnsToPlayer)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance guysGotoDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (global112 curColIdx:)
					(0
						(= local3 239)
					)
					(1
						(= local3 (global112 getPercent: 0 25))
					)
					(3
						(= local3 (global112 getPercent: 26 42))
					)
					(4
						(= local3 (global112 getPercent: 43 85))
					)
					(6
						(= local3 (global112 getPercent: 86 239))
					)
				)
				(if (> local3 75)
					(= state 1)
				)
				(if (> local3 128)
					(= state 2)
				)
				(if (> local3 216)
					(= state 3)
				)
				(proc4_6 40800 -28 -47 local3 0 -1 1)
			)
			(1
				(global112 endColumn:)
			)
			(2
				(gSwatInterface showHandAni: 3)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(roomTimer setReal: 1 roomTimer 5)
				(self dispose:)
			)
		)
	)
)

(instance shotGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 8 0 1 self) ; "Compromised!"
			)
			(1
				(gGame handsOff: showCloseUp: 41002 180 70 self)
			)
			(2
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance throwFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(if gAutoRobot
					(gAutoRobot caller: 0)
				)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(2
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
				(proc4_5)
				(gGame showCloseUp: 40802 180 70 self 1)
			)
			(6
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance pacmeyerTurnsToPlayer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(proc4_6 40808 71 35 0 0 -1 1)
			)
			(2
				(gSwatInterface showHandAni: 2 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gSwatInterface showHandAni: 5 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gSwatInterface showHandAni: 3 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance getOutaThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 2)
			)
			(1
				(= cycles 2)
			)
			(2
				(proc4_5)
				(gGame handsOff: showCloseUp: 41002 180 70 self 1)
			)
			(3
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance carmichaelShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 40104 0)
				(roomTimer dispose: delete:)
				(proc4_5)
				(gGame
					handsOff:
					showCloseUp: 40806 180 70
					showCloseUp: 40805 180 70 self 1
				)
			)
			(1
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40104)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance pacmeyerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomTimer dispose: delete:)
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 0 stop:)
				(UnLoad 141 40104)
				(proc4_5)
				(gGame handsOff: showCloseUp: 40804 180 70 self 1)
			)
			(1
				(gBackMusic number: 40109 loop: 1 play: self)
				(gMessager say: 0 8 5 1) ; "Cease fire! Status! Cease fire!"
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance dentonShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(denton dispose:)
				(proc4_5)
				(gGame handsOff: showCloseUp: 9021 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance robotShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 9011 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance denton of View
	(properties
		x 601
		y 357
		view 40808
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: dentonShot)
			)
			(6
				(gCurRoom setScript: dentonShot)
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 160
		y 309
		view 40807
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1 &rest))
			(cond
				((< (Robot 11) 57) ; FrameNum
					(if (< (param1 x:) 158)
						(= local2 1)
					else
						(= local1 1)
					)
				)
				((or (> (Robot 11) 75) (Robot 5)) ; FrameNum, HasEnded
					(if (< (param1 x:) 230)
						(= local1 1)
					else
						(= local2 1)
					)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(cond
					(local1
						(gCurRoom setScript: carmichaelShot)
					)
					(local2
						(gCurRoom setScript: pacmeyerShot)
					)
					(else
						(gCurRoom setScript: robotShot)
					)
				)
			)
			(6
				(cond
					(local1
						(gCurRoom setScript: carmichaelShot)
					)
					(local2
						(gCurRoom setScript: pacmeyerShot)
					)
					(else
						(gCurRoom setScript: robotShot)
					)
				)
			)
			(16
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsLeft 60
		nsRight 360
		nsBottom 55
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 4100) ; s1_4100
	)
)

(instance eastJam of HotSpot
	(properties
		nsLeft 175
		nsTop 60
		nsRight 220
		nsBottom 255
		type 8194
	)

	(method (doVerb)
		(gCurRoom newRoom: 4120) ; s1_4120
	)
)

(instance westJam of HotSpot
	(properties
		nsLeft 120
		nsTop 65
		nsRight 170
		nsBottom 240
		type 32770
	)

	(method (doVerb)
		(gCurRoom newRoom: 4110) ; s1_4110
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(if (gTimers contains: roomTimer)
			(gCurRoom setScript: getOutaThere)
		else
			(gCurRoom newRoom: 4070) ; s1_4070
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(if (gTimers contains: roomTimer)
			(gCurRoom setScript: getOutaThere)
		else
			(gCurRoom newRoom: 4060) ; s1_4060
		)
	)
)

(instance southE of HotSpot
	(properties
		nsTop 310
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb)
		(if (gTimers contains: roomTimer)
			(gCurRoom setScript: getOutaThere)
		else
			(gCurRoom newRoom: 4070) ; s1_4070
		)
	)
)

(instance roomTimer of Timer
	(properties)

	(method (cue)
		(switch local0
			(1
				(gCurRoom setScript: pacmeyerTurnsToPlayer)
				(self setReal: 2 self 5)
			)
			(2
				(gCurRoom setScript: pacmeyerTurnsToPlayer)
				(self setReal: 3 self 5)
			)
			(3
				(gCurRoom setScript: pacmeyerTurnsToPlayer)
				(self setReal: 4 self 5)
			)
			(4
				(gCurRoom setScript: getOutaThere)
			)
		)
	)

	(method (setReal param1)
		(= local0 param1)
		(super setReal: &rest)
	)
)

