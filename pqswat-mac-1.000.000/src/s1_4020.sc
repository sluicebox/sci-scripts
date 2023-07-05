;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4020)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use swatInvInit)
(use HotSpot)
(use RobotDoVerb)
(use Print)
(use ROsc)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4020 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 &tmp temp0)
	(if (not (IsFlag 4))
		(if (IsFlag 124)
			(switch (Random 0 1)
				(0
					(SetFlag 154)
				)
				(1
					(SetFlag 153)
				)
			)
		else
			(switch (Random 0 2)
				(0
					(SetFlag 154)
				)
				(1
					(SetFlag 152)
				)
				(2
					(SetFlag 153)
				)
			)
		)
	else
		(Palette 2 42 254 100) ; PalIntensity
		(repeat
			(if
				(!=
					(= temp0
						(Print
							fore: 255
							addButton: 154 {Side 2, No Lucy} 5 5
							addButton: 152 {Side 2, Armed Lucy} 5 20
							addButton: 153 {Side 2, Unarmed Lucy} 5 35
							init:
						)
					)
					-1
				)
				(SetFlag temp0)
				(break)
			)
		)
	)
)

(instance s1_4020 of PQRoom
	(properties
		picture 4020
	)

	(method (init)
		(super init: &rest)
		(= global432 myTalkerStopCheck)
		(= gMyAutoEventCode myAutoEventCode)
		(Load rsVIEW 40201)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(leftCorner init:)
		(robotFeature init:)
		(dummyFeature init:)
		((= local3 (Set new:)) add: denton robotFeature dummyFeature)
		(if (OneOf gPrevRoomNum 4030 4270) ; s1_4030, s1_4270
			(gCurRoom setScript: backedOut)
		else
			(localproc_0)
			(SetFlag 104)
			(gCurRoom setScript: getWeaponsReady)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(global112 threwFlash: 4000)
				(if (== script getWeaponsReady)
					(self setScript: flashDuringTimer)
				else
					(self setScript: flashAfterTimer)
				)
			)
			(7
				(SetFlag 156)
				(self setScript: mp5Shot)
			)
			(6
				(SetFlag 157)
				(self setScript: colt45Shot)
			)
			(40
				(if (== script getWeaponsReady)
					(gMessager say: 0 40 4 1) ; "Hold!!!"
				else
					(gMessager say: 0 40 5 1) ; "Move up!"
				)
			)
			(43
				(if (== script getWeaponsReady)
					(gMessager say: 0 43 4 1) ; "Calm down..."
				else
					(gMessager say: 0 43 5 1) ; "Pup! What is it?"
				)
			)
			(47
				(if (== script getWeaponsReady)
					(gMessager say: 0 47 4 1) ; "Settle down..."
				else
					(gMessager say: 0 47 5 1) ; "What the hell are you doing, Pup? Move to side three!"
				)
			)
			(44
				(if (== script getWeaponsReady)
					(gMessager say: 0 44 4 1) ; "Correct, Pup. Cover your man."
				)
			)
			(45
				(if (== script getWeaponsReady)
					(gMessager say: 0 45 4 1) ; "Disregard..."
				)
			)
			(46
				(if (== script getWeaponsReady)
					(gMessager say: 0 46 4 1) ; "Calm down..."
				else
					(gMessager say: 0 46 5 1) ; "Hurry is right! Side three. Now!"
				)
			)
			(42
				(if (== script getWeaponsReady)
					(gMessager say: 0 42 4 1) ; "What is it?"
				else
					(gMessager say: 0 42 5 1) ; "What?! What do you see?"
				)
			)
			(49
				(if (== script getWeaponsReady)
					(gMessager say: 0 49 4 1) ; "Disregard."
				else
					(gMessager say: 0 49 5 1) ; "Pup! Get to side three. Move before you compromise this mission!"
				)
			)
			(48
				(if (== script getWeaponsReady)
					(gMessager say: 0 48 4 0) ; "Saunders, confirm suspect?!"
				else
					(gMessager say: 0 48 5 1) ; "Sierra One reporting. Suspect not observed side one. No suspect movement side one."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (getInvItem param1)
		(if
			(and
				(!= (((proc19_3 3) data:) weaponSetting:) 2)
				(== param1 6)
				(== script getWeaponsReady)
				(or
					(== (getWeaponsReady state:) 2)
					(== (getWeaponsReady state:) 5)
				)
				(!= (getWeaponsReady state:) 4)
			)
			(gMessager say: 0 6 4 1) ; "MP5, Pup! MP5!"
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(or
					(== script getWeaponsReady)
					(and (== script readyGo) (== (script state:) 0))
				)
				(== newRoomNumber 4030) ; s1_4030
			)
			(global112 leftEarly: 1)
		)
		(cond
			((== (gSwatInterface curInvItem:) (proc19_3 0))
				(SetFlag 158)
			)
			((== (gSwatInterface curInvItem:) (proc19_3 3))
				(SetFlag 159)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(= global432 0)
		(= gMyAutoEventCode 0)
		(local3 dispose:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance getWeaponsReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(WalkieTalkie showFrame: 40200 0 232 100)
				(= global128 40200)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 2 1 self) ; "MP5s... full-auto!"
			)
			(2
				(= seconds 10)
			)
			(3
				(if (== (((proc19_3 3) data:) weaponSetting:) 2)
					(gCurRoom setScript: readyGo)
				else
					(= cycles 1)
				)
			)
			(4
				(gMessager say: 0 0 2 1 self) ; "MP5s... full-auto!"
			)
			(5
				(= seconds 10)
			)
			(6
				(if (!= (((proc19_3 3) data:) weaponSetting:) 2)
					(gCurRoom setScript: outtaThere)
				else
					(gCurRoom setScript: readyGo)
				)
			)
		)
	)
)

(instance readyGo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 2 2) ; "Ready... Go!"
				(= ticks 120)
			)
			(1
				(proc4_6 40200 232 100)
				(SetFlag 162)
				(global112 startPath: 78)
			)
			(2
				(if gAutoRobot
					(gAutoRobot setPri: 270)
				)
			)
			(3
				(gMessager say: 0 0 2 3 self) ; "Pup! Get moving!"
				(denton init: setCycle: ROsc -1 0 141)
				(= local1 1)
			)
			(4
				(gGame handsOn:)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance backedOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (global112 curColIdx:)
					(0
						(= local4 216)
					)
					(1
						(= local4 (global112 getPercent: 0 30))
					)
					(2
						(= local4 (global112 getPercent: 31 140))
					)
					(3
						(= local4 (global112 getPercent: 141 216))
					)
					(4
						(= local4 216)
					)
				)
				(if (> local4 109)
					(proc4_6 40200 232 100 local4 0 270 1 0)
				else
					(proc4_6 40200 232 100 local4 0 -1 1 0)
				)
				(= seconds 1)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 0 0 3 4 self) ; "Pup! Get back here!"
			)
			(2
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance flashDuringTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(proc4_5)
				(proc4_6 40202 205 85 0 0 -1 1)
				(gFxSound number: 1003 setLoop: 1 play:)
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
				(gMessager say: 0 16 4 1) ; "Compromised! Get down!"
			)
			(6
				(if gAutoRobot
					(gAutoRobot setPri: 270)
				)
			)
			(7
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance flashAfterTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
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
				(gMessager say: 0 16 5 1 self) ; "Get that idiot out of there! Now!"
			)
			(6
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance colt45Shot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gMessager say: 0 7 0 1 self) ; "Cease fire! Cease fire!"
			)
			(2
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance mp5Shot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gMessager say: 0 7 0 1 self) ; "Cease fire! Cease fire!"
			)
			(2
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance robotShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(if local1
					(denton dispose:)
				)
				(proc4_5)
				(gGame handsOff: showCloseUp: 9011 180 70 self 1)
			)
			(2
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40103)
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
				(= ticks 1)
			)
			(1
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(denton dispose:)
				(proc4_5)
				(gGame handsOff: showCloseUp: 9021 180 70 self 1)
			)
			(2
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40103)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
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
				(gMessager say: 0 0 3 4 self) ; "Pup! Get back here!"
			)
			(1
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance arrowClick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gMessager say: 0 0 1 1 self) ; "Get that idiot out of there!"
			)
			(1
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance dummyFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 587 126 610 126 615 145 632 161 630 177 635 187 634 208 607 253 618 298 608 305 573 302 573 294 590 288 579 255 589 206 582 188 562 195 533 194 534 189 593 152
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: robotShot)
			)
			(6
				(gCurRoom setScript: robotShot)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: robotShot)
			)
			(6
				(gCurRoom setScript: robotShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 369
		y 153
		view 40204
	)
)

(instance denton of Prop
	(properties
		x 243
		y 263
		view 40201
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: dentonShot)
			)
			(6
				(gCurRoom setScript: dentonShot)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 4030) ; s1_4030
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
		(gCurRoom setScript: arrowClick)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(if (not (global112 curColIdx:))
			(global112 startPath: 78)
		)
		(gCurRoom newRoom: 4270) ; s1_4270
	)
)

(instance southE of HotSpot
	(properties
		nsTop 300
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb)
		(gCurRoom setScript: arrowClick)
	)
)

(instance leftCorner of HotSpot
	(properties
		nsLeft 180
		nsTop 105
		nsRight 280
		nsBottom 230
		type 8194
	)

	(method (doVerb)
		(gCurRoom newRoom: 4030) ; s1_4030
	)
)

(instance roomTimer of Timer
	(properties)

	(method (cue)
		(switch local0
			(1
				(gMessager say: 0 0 3 1) ; "SWAT pup! Get your ass in gear! Get moving!"
				(self setReal: 2 self 30)
			)
			(2
				(gMessager say: 0 0 3 2) ; "It's Rooker! Move it! Now!!"
				(self setReal: 3 self 30)
			)
			(3
				(gMessager say: 0 0 3 3) ; "Pup! Get out of there!"
				(self setReal: 4 self 30)
			)
			(4
				(gCurRoom setScript: outtaThere)
			)
		)
	)

	(method (setReal param1)
		(= local0 param1)
		(super setReal: &rest)
	)
)

(instance myAutoEventCode of Code
	(properties)

	(method (doit param1 param2)
		(cond
			(argc
				(if (local3 contains: param2)
					(= local2 param2)
				)
				(param1 claimed: 1)
			)
			(local2
				(local2 doVerb: 7)
			)
			(else
				(gCurRoom doVerb: 7)
			)
		)
	)
)

(instance myTalkerStopCheck of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

