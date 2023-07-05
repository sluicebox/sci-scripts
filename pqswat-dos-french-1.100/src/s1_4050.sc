;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4050)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use swatInvInit)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4050 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance s1_4050 of PQRoom
	(properties
		picture 4050
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 40404)
		(= global432 myTalkerStopCheck)
		(doorBell init:)
		(robotFeature init:)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(westJam init:)
		(eastJam init:)
		(host init: hide:)
		(if (== gPrevRoomNum 4250) ; s1_4250
			(self setScript: pacEscortsLucy)
		else
			(door setPri: 460 init:)
			(self setScript: enterHouse)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 8)
				(= local3 1)
				(if local2
					(self setScript: shotGun)
				else
					(host setScript: enterCompromised)
				)
			)
			((== theVerb 6)
				(= local3 1)
				(if local2
					(self setScript: shotGun)
				else
					(host setScript: enterCompromised)
				)
			)
			((== theVerb 16)
				(global112 threwFlash: 4060)
				(cond
					(local0
						(self setScript: threwInFull)
					)
					(local1
						(self setScript: threwInHalf)
					)
					(else
						(= local3 1)
						(host setScript: enterFlashed)
					)
				)
			)
			((OneOf theVerb 43 47 44 45 46 42 49 48)
				(cond
					(local0
						(gMessager say: 0 theVerb 14)
					)
					(local1
						(gMessager say: 0 theVerb 12)
					)
					(else
						(gMessager say: 0 theVerb 13)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (getInvItem param1)
		(if (== param1 6)
			(gMessager say: 0 6 3 1 0 4040) ; "Pup, put that down! You're on shotgun!"
		)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(= global432 0)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance enterHouse of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Load rsMESSAGE 4050)
				(= seconds 1)
			)
			(1
				(proc4_6 40400 462 95 0 0 500)
				(= cycles 2)
			)
			(2
				(= temp0 (proc19_3 4))
				(temp0 doVerb: 29)
				(= temp1 ((temp0 data:) reloadSnd:))
				((temp0 data:) reloadSnd: 0)
				(temp0 doVerb: 38)
				((temp0 data:) reloadSnd: temp1)
				(proc4_6 40403 319 59 0 0 500)
				(gMessager say: 0 0 1 1 0 4040) ; "Carmichael, ready to open door. Go."
			)
			(3
				(door setCycle: End self)
			)
			(4
				(door dispose:)
				(gGame handsOn:)
				(proc4_6 40405 336 -42)
			)
			(5
				(gSwatInterface showHandAni: 6)
			)
			(6
				(proc4_5)
				(scout init: setCycle: End self)
				(gMessager say: 0 0 1 2 0 4040) ; "Ready to enter door..."
			)
			(7
				(= local2 1)
				(scout dispose:)
				(if local3
					(= cycles 1)
				else
					(gGame handsOff: showCloseUp: 40401 180 70 self 1)
				)
			)
			(8
				(proc4_6 40506 12 -50)
				(Palette 2 42 254 100) ; PalIntensity
				(= cycles 2)
			)
			(9
				(gGame handsOn:)
			)
			(10
				(gSwatInterface showHandAni: 2)
			)
			(11
				(gMessager say: 0 0 4 0) ; "Go!"
			)
			(12
				(= local1 1)
			)
			(13
				(= local0 1)
				(gMessager say: 0 0 5 0) ; "Pacmeyer to Ten David - Entry team in."
				(roomTimer setReal: 1 roomTimer 10)
				(self dispose:)
			)
		)
	)
)

(instance enterFlashed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (not local2)
					(-- state)
				else
					((gCurRoom script:) dispose:)
				)
				(= cycles 1)
			)
			(2
				(proc4_6 40504 177 -72 0 0 -1 1)
				(gFxSound number: 1003 setLoop: 1 play:)
			)
			(3
				(gFxSound number: 1002 setLoop: 1 play:)
				(flash setPri: 400 init:)
				(= cycles 2)
			)
			(4
				(flash dispose:)
			)
			(5
				(gMessager say: 0 0 6 0 self) ; "Suspect down!"
			)
			(6
				(= cycles 2)
			)
			(7
				(gCurRoom newRoom: 4060) ; s1_4060
			)
		)
	)
)

(instance threwInFull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_5)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(flash setPri: 400 init:)
				(flashBang dispose:)
				(= cycles 2)
			)
			(2
				(proc4_6 40505 221 35 0 0 -1 1 0)
				(flash dispose:)
				(gMessager sayRange: 0 16 11 1 2 self) ; "Status! This was a soft probe! Status!"
			)
			(3
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 4060) ; s1_4060
			)
		)
	)
)

(instance threwInHalf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(= cycles 1)
			)
			(1
				(if gAutoRobot
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(proc4_5)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
			)
			(3
				(gFxSound number: 1002 setLoop: 1 play:)
				(flash setPri: 400 init:)
				(flashBang dispose:)
				(= cycles 2)
			)
			(4
				(proc4_6 40505 221 35 0 0 -1 1 0)
				(flash dispose:)
				(gMessager sayRange: 0 16 11 1 2 self) ; "Status! This was a soft probe! Status!"
			)
			(5
				(= cycles 2)
			)
			(6
				(gCurRoom newRoom: 4060) ; s1_4060
			)
		)
	)
)

(instance shotGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(= cycles 1)
			)
			(1
				(if gAutoRobot
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(proc4_6 40507 174 30)
			)
			(3
				(gMessager say: 0 8 0 0 self) ; "Cease fire! Cease fire! Suspect in control!"
			)
			(4
				(proc4_6 40503 186 16)
				(= cycles 2)
			)
			(5
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 6006 loop: -1 play:)
				(UnLoad 141 40103)
			)
			(6
				(gEgo awardMedal: 64)
				(SetFlag 98)
				(SetFlag 96)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance enterCompromised of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 8 7 1 self) ; "Cease fire! Cease fire!"
			)
			(2
				(if (not local2)
					(-- state)
				else
					((gCurRoom script:) dispose:)
				)
				(= cycles 1)
			)
			(3
				(proc4_6 40502 157 -40)
			)
			(4
				(proc4_6 40507 174 30)
			)
			(5
				(SetFlag 151)
				(gCurRoom newRoom: 4060) ; s1_4060
			)
		)
	)
)

(instance pacEscortsLucy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 40503 186 16)
			)
			(1
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance rangBell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 40401 setLoop: 1 play: self)
			)
			(1
				(gMessager say: 0 16 10 1 self) ; "Compromised!"
			)
			(2
				(gMessager say: 0 0 1 1 self 4020) ; "Get that idiot out of there!"
			)
			(3
				(Lock rsAUDIO 40103 0)
				(Lock rsAUDIO 6007 1)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40103)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance outtaThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 1 1 self 4020) ; "Get that idiot out of there!"
			)
			(1
				(Lock rsAUDIO 40103 0)
				(Lock rsAUDIO 6007 1)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40103)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance showPacmeyer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: saveRobot: 1 showCloseUp: 40518 180 70 self)
			)
			(1
				(gGame saveRobot: 0 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showDenton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: saveRobot: 1 showCloseUp: 40519 180 70 self)
			)
			(1
				(gGame saveRobot: 0 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shotCop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 9011 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
				(gMessager say: 0 register 0 1)
			)
			(2
				(Lock rsAUDIO 6007 1)
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance scout of Prop
	(properties
		x 471
		y 410
		view 40404
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shotCop 0 theVerb)
			)
			(6
				(gCurRoom setScript: shotCop 0 theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 172
		y 359
		view 40599
	)
)

(instance host of Prop
	(properties
		y 2000
		view 56
	)
)

(instance flashBang of Prop
	(properties
		x 515
		y 260
		view 40514
	)
)

(instance flash of View
	(properties
		x 200
		view 40501
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shotCop 0 theVerb)
			)
			(6
				(gCurRoom setScript: shotCop 0 theVerb)
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

(instance doorBell of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 542 268 551 268 552 295 541 295
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 29)
			(gCurRoom setScript: rangBell)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsLeft 200
		nsRight 510
		nsBottom 100
		type 4097
	)

	(method (doVerb)
		(if local2
			(gCurRoom newRoom: 4060) ; s1_4060
		else
			(gMessager say: 0 0 2 0 0 4040) ; "Don't rush me!"
		)
	)
)

(instance eastJam of HotSpot
	(properties
		nsLeft 350
		nsTop 100
		nsRight 510
		nsBottom 310
		type 8195
	)

	(method (doVerb)
		(if local2
			(gCurRoom newRoom: 4080) ; s1_4080
		else
			(gMessager say: 0 0 2 0 0 4040) ; "Don't rush me!"
		)
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 310
		type 8195
	)

	(method (doVerb)
		(host setScript: showPacmeyer)
	)
)

(instance westJam of HotSpot
	(properties
		nsLeft 200
		nsTop 100
		nsRight 350
		nsBottom 310
		type 32771
	)

	(method (doVerb)
		(if local2
			(gCurRoom newRoom: 4060) ; s1_4060
		else
			(gMessager say: 0 0 2 0 0 4040) ; "Don't rush me!"
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 310
		type 32771
	)

	(method (doVerb)
		(host setScript: showPacmeyer)
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
		(if local0
			(host setScript: showDenton)
		else
			(host setScript: showPacmeyer)
		)
	)
)

(instance roomTimer of Timer
	(properties)

	(method (cue)
		(switch local4
			(1
				(gMessager say: 0 0 3 1) ; "Move IT!"
				(self setReal: 2 self 5)
			)
			(2
				(gMessager say: 0 0 3 2) ; "Pup - Move! NOW!"
				(self setReal: 3 self 5)
			)
			(3
				(gCurRoom setScript: outtaThere)
				(self dispose: delete:)
			)
		)
	)

	(method (setReal param1)
		(= local4 param1)
		(super setReal: &rest)
	)
)

(instance myTalkerStopCheck of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

