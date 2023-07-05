;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4270)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4270 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance s1_4270 of PQRoom
	(properties
		picture 4270
	)

	(method (init)
		(super init: &rest)
		(= gMyAutoEventCode myAutoEventCode)
		(Load rsVIEW 42701)
		(robotFeature init:)
		(closedDoor init:)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(host init: hide:)
		((= local2 (Set new:)) add: denton robotFeature)
		(switch gPrevRoomNum
			(4020 ; s1_4020
				(if (>= (global112 curColIdx:) 2)
					(self setScript: showTeamEnter)
				)
				(roomTimer setReal: 1 roomTimer 30)
				(cornerOfHouse init:)
				(gGame handsOn:)
			)
			(4030 ; s1_4030
				(if
					(and
						(global112 usedMirror:)
						(global112 warnedOfSuspect:)
						(or (IsFlag 152) (IsFlag 153))
					)
					(global112 resetData: 0)
					(SetFlag 70)
					(if (>= (global112 curColIdx:) 2)
						(self setScript: showTeamEnter2)
					else
						(self setScript: gonnaGetLucy)
					)
					(gGame handsOn:)
					(cornerOfHouse2 init:)
				else
					(cornerOfHouse init:)
					(gGame handsOn:)
				)
			)
		)
	)

	(method (criticalAlert)
		(if (and (== (global112 curColIdx:) 2) (not script))
			(self setScript: showTeamEnter)
		)
	)

	(method (lashNotify)
		(if
			(or
				(and (proc4_11 21) (== global149 1))
				(and
					(proc4_11 21)
					(proc4_11 34)
					(proc4_11 35)
					(proc4_11 28)
					(== global149 4)
				)
				(and (proc4_11 21) (proc4_11 35) (== global149 2))
				(and (proc4_11 21) (proc4_11 35) (proc4_11 28) (== global149 3))
				(and (proc4_11 21) (proc4_11 34) (proc4_11 35) (== global149 3))
			)
			(if (and (global112 usedMirror:) (not (IsFlag 154)))
				(self setScript: lashedSuspect)
				(return -2)
			else
				(gMessager say: 0 48 5 1) ; "Sierra One reporting. Suspect not observed side one. No suspect movement side one."
			)
		else
			(return -1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(SetFlag 156)
				(host setScript: mp5Shot)
			)
			(6
				(SetFlag 157)
				(host setScript: colt45Shot)
			)
			(16
				(global112 threwFlash: 4280)
				(host setScript: throwFlashbang)
			)
			(45
				(if (global112 usedMirror:)
					(gMessager say: 0 45 4 1) ; "Pup, what is it?"
				)
			)
			(42
				(gMessager say: 0 43 0) ; "What is it?"
			)
			(49
				(if (global112 usedMirror:)
					(gMessager say: 0 49 4 1) ; "What!? What is it?"
				else
					(gMessager say: 0 49 5 1) ; "Pup! Get to side three. Move before you compromise this mission!"
				)
			)
			(44
				(if (global112 usedMirror:)
					(gMessager say: 0 44 4 1) ; "Pup, suspect detected?"
				else
					(gMessager say: 0 44 5 1) ; "Pup, I've got you covered."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom)
		(if (gCast contains: (ScriptID 36)) ; Mirror
			((ScriptID 36) dispose:) ; Mirror
		)
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(if (gTimers contains: mirrorTimer)
			(mirrorTimer dispose: delete:)
		)
		(ClearFlag 70)
		(= gMyAutoEventCode 0)
		(local2 dispose:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance showTeamEnter of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (global112 curColIdx:)
					(2
						(= local4 (global112 getPercent: 0 62))
					)
					(3
						(= local4 (global112 getPercent: 63 86))
					)
					(4
						(= local4 (global112 getPercent: 87 357))
					)
				)
				(= temp0 400)
				(if (> local4 90)
					(= state 3)
				)
				(if (> local4 193)
					(gAutoRobot setPri: -1)
					(closedDoor dispose:)
					(= state 4)
				)
				(if (> local4 288)
					(= state 5)
				)
				(proc4_6 42700 43 -63 local4 0 temp0 1)
			)
			(1
				(gSwatInterface showHandAni: 8 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gSwatInterface showHandAni: 2)
			)
			(4
				(gAutoRobot setPri: -1)
				(closedDoor dispose:)
			)
			(5
				(gSwatInterface showHandAni: 6)
			)
			(6
				(denton setPri: 350 init:)
				(proc4_5)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance showTeamEnter2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (global112 curColIdx:)
					(2
						(= local4 (global112 getPercent: 0 62))
					)
					(3
						(= local4 (global112 getPercent: 63 86))
					)
					(4
						(= local4 (global112 getPercent: 87 357))
					)
				)
				(if (> local4 90)
					(= state 3)
				)
				(if (> local4 193)
					(closedDoor dispose:)
					(= state 4)
				)
				(if (> local4 288)
					(closedDoor dispose:)
					(= state 5)
				)
				(proc4_6 42700 43 -63 local4 0 -1 1)
			)
			(1
				(gSwatInterface showHandAni: 8 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gSwatInterface showHandAni: 2)
			)
			(4
				(closedDoor dispose:)
			)
			(5
				(gSwatInterface showHandAni: 6)
			)
			(6
				(denton setPri: 350 init: setCycle: CT 33 1 self)
				(proc4_5)
			)
			(7
				(self setScript: doHandAni)
				(= cycles 1)
			)
			(8
				(denton setCycle: CT 113 1 self)
			)
			(9
				(denton setPri: 5 setCycle: CT 120 1 self)
			)
			(10
				(gCurRoom newRoom: 4280) ; s1_4280
			)
		)
	)
)

(instance gonnaGetLucy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(closedDoor dispose:)
				(denton setPri: 350 init: setCycle: CT 33 1 self)
			)
			(1
				(self setScript: doHandAni)
				(= cycles 1)
			)
			(2
				(denton setCycle: CT 113 1 self)
			)
			(3
				(denton setPri: 5 setCycle: CT 120 1 self)
			)
			(4
				(gCurRoom newRoom: 4280) ; s1_4280
			)
		)
	)
)

(instance lashedSuspect of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(= cycles 2)
			)
			(1
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gMessager say: 1 24 7 1 self) ; "Copy."
			)
			(3
				(global112 suspectSpotted: 4290)
				(gCurRoom newRoom: 4300) ; s1_4300
			)
		)
	)
)

(instance mp5Shot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gMessager say: 0 7 0 1 self) ; "Cease fire! Cease fire!!"
			)
			(1
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
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gMessager say: 0 6 0 1 self) ; "Cease fire! Cease fire!!"
			)
			(1
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance throwFlashbang of Script
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
				(gCurRoom newRoom: 4280) ; s1_4280
			)
		)
	)
)

(instance doHandAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSwatInterface showHandAni: 4 self)
			)
			(1
				(gSwatInterface showHandAni: 3 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance lucyEscapes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					((ScriptID 36) dispose:) ; Mirror
					(= local3 0)
				)
				(ClearFlag 153)
				(SetFlag 154)
				(gFxSound number: 40309 setLoop: 1 play:)
			)
			(1
				(self dispose:)
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
				(gMessager say: 0 0 1 3) ; "Pup! Get out of there!"
			)
			(1
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance dentShootsBack of Script
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
				(proc4_5)
				(gGame showCloseUp: 42703 180 70 self 1)
			)
			(2
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance notifyOfLucy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gSwatInterface showHandAni: 7 self)
			)
			(1
				(global112 suspectSpotted: 4290)
				(gCurRoom newRoom: 4300) ; s1_4300
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 10
		y 215
		view 42705
	)
)

(instance denton of Prop
	(properties
		x 125
		y 329
		view 42701
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: dentShootsBack)
			)
			(6
				(gCurRoom setScript: dentShootsBack)
			)
			(48
				(if
					(and
						(global112 usedMirror:)
						(or (IsFlag 152) (IsFlag 153))
					)
					(gCurRoom setScript: notifyOfLucy)
				else
					(gMessager say: 0 48 5 1) ; "Sierra One reporting. Suspect not observed side one. No suspect movement side one."
				)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance lucyUnArmed of Prop
	(properties
		x 52
		y 344
		view 42703
	)

	(method (cue)
		(= local3 0)
		((ScriptID 36) dispose:) ; Mirror
	)
)

(instance lucyArmed of Prop
	(properties
		x 36
		y 344
		view 42704
	)

	(method (cue)
		(= local3 0)
		((ScriptID 36) dispose:) ; Mirror
	)
)

(instance host of Prop
	(properties
		y 2000
		view 56
	)
)

(instance closedDoor of View
	(properties
		x 461
		y 222
		view 42706
	)
)

(instance reflection of View
	(properties
		x 15
		y 343
		view 42702
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1 &rest))
				(not
					(or
						(> (param1 x:) 468)
						(and (> (Robot 11) 50) (< (param1 x:) 260)) ; FrameNum
					)
				)
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: dentShootsBack)
			)
			(6
				(gCurRoom setScript: dentShootsBack)
			)
			(16
				(gCurRoom doVerb: theVerb)
			)
			(48
				(if
					(and
						(global112 usedMirror:)
						(or (IsFlag 152) (IsFlag 153))
					)
					(gCurRoom setScript: notifyOfLucy)
				else
					(gMessager say: 0 48 5 1) ; "Sierra One reporting. Suspect not observed side one. No suspect movement side one."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cornerOfHouse of Feature
	(properties
		nsLeft 90
		nsTop 50
		nsRight 185
		nsBottom 220
	)

	(method (doVerb theVerb)
		(switch theVerb
			(40
				(if (not local3)
					(= local3 1)
					(global112 useMirror: 4290)
					(cond
						((IsFlag 152)
							((ScriptID 36) init: add: reflection lucyArmed) ; Mirror
							(lucyArmed setPri: 450 cel: 0 init:)
							(reflection setPri: 440 init:)
							(lucyArmed setCycle: End lucyArmed)
						)
						((IsFlag 153)
							((ScriptID 36) init: add: reflection lucyUnArmed) ; Mirror
							(lucyUnArmed setPri: 450 cel: 0 init:)
							(reflection setPri: 440 init:)
							(lucyUnArmed setCycle: End lucyUnArmed)
						)
						(else
							((ScriptID 36) init: add: reflection) ; Mirror
							(reflection setPri: 440 init:)
							(mirrorTimer setReal: mirrorTimer 10)
						)
					)
				)
			)
			(48
				(if
					(and
						(global112 usedMirror:)
						(or (IsFlag 152) (IsFlag 153))
					)
					(gCurRoom setScript: notifyOfLucy)
				else
					(gMessager say: 0 48 5 1) ; "Sierra One reporting. Suspect not observed side one. No suspect movement side one."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cornerOfHouse2 of Feature
	(properties
		nsLeft 90
		nsTop 50
		nsRight 185
		nsBottom 220
	)

	(method (doVerb theVerb)
		(switch theVerb
			(40
				(if (not local3)
					(= local3 1)
					(global112 useMirror: 4290)
					(cond
						((IsFlag 152)
							((ScriptID 36) init: add: reflection lucyArmed) ; Mirror
							(lucyArmed setPri: 450 cel: 0 init:)
							(reflection setPri: 440 init:)
							(lucyArmed setCycle: End lucyArmed)
						)
						((IsFlag 153)
							((ScriptID 36) init: add: reflection lucyUnArmed) ; Mirror
							(lucyUnArmed setPri: 450 cel: 0 init:)
							(reflection setPri: 440 init:)
							(lucyUnArmed setCycle: End lucyUnArmed)
						)
						(else
							((ScriptID 36) init: add: reflection) ; Mirror
							(reflection setPri: 440 init:)
							(mirrorTimer setReal: mirrorTimer 10)
						)
					)
				)
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
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(cond
			((or (not (global112 usedMirror:)) (IsFlag 154))
				(gCurRoom newRoom: 4280) ; s1_4280
			)
			((not (global112 warnedOfSuspect:))
				(if (IsFlag 152)
					(gCurRoom newRoom: 4280) ; s1_4280
				else
					(gCurRoom setScript: lucyEscapes)
				)
			)
		)
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
		(gCurRoom newRoom: 4020) ; s1_4020
	)
)

(instance westE of HotSpot
	(properties
		nsLeft 60
		nsTop 50
		nsRight 200
		nsBottom 220
		type 32771
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55
				(global112 slicePie: 4290)
				(cond
					((or (not (global112 usedMirror:)) (IsFlag 154))
						(gCurRoom newRoom: 4280) ; s1_4280
					)
					((not (global112 warnedOfSuspect:))
						(if (IsFlag 152)
							(gCurRoom newRoom: 4280) ; s1_4280
						else
							(gCurRoom setScript: lucyEscapes)
						)
					)
				)
			)
			(29
				(cond
					((or (not (global112 usedMirror:)) (IsFlag 154))
						(gCurRoom newRoom: 4280) ; s1_4280
					)
					((not (global112 warnedOfSuspect:))
						(if (IsFlag 152)
							(gCurRoom newRoom: 4280) ; s1_4280
						else
							(gCurRoom setScript: lucyEscapes)
						)
					)
				)
			)
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
		(gCurRoom newRoom: 4020) ; s1_4020
	)
)

(instance roomTimer of Timer
	(properties)

	(method (doit)
		(if (or (gCurRoom script:) (not (gTalkers size:)))
			(super doit: &rest)
		)
	)

	(method (cue)
		(switch local0
			(1
				(gMessager say: 0 0 1 1) ; "Pup, what is it? Go!!"
				(self setReal: 2 self 30)
			)
			(2
				(gMessager say: 0 0 1 2) ; "It's Rooker! Move to side three! Now!!"
				(self setReal: 3 self 30)
			)
			(3
				(gCurRoom setScript: outtaThere)
			)
		)
	)

	(method (setReal param1)
		(= local0 param1)
		(super setReal: &rest)
	)
)

(instance mirrorTimer of Timer
	(properties)

	(method (cue)
		((ScriptID 36) dispose:) ; Mirror
		(= local3 0)
		(self dispose: delete:)
	)
)

(instance myAutoEventCode of Code
	(properties)

	(method (doit param1 param2)
		(cond
			(argc
				(if (local2 contains: param2)
					(= local1 param2)
				)
				(param1 claimed: 1)
			)
			(local1
				(local1 doVerb: 7)
			)
			(else
				(gCurRoom doVerb: 7)
			)
		)
	)
)

