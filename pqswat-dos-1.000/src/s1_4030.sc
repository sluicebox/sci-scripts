;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4030)
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
	s1_4030 0
)

(local
	local0
	local1
	local2
	local3
)

(instance s1_4030 of PQRoom
	(properties
		picture 4030
	)

	(method (init)
		(super init: &rest)
		(= gMyAutoEventCode myAutoEventCode)
		(Load rsVIEW 40304)
		(Load rsVIEW 40308)
		(Load rsVIEW 40310)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(cornerOfHouse init:)
		(robotFeature init:)
		(door init:)
		(host init: hide:)
		((= local1 (Set new:)) add: denton robotFeature)
		(if (global112 leftEarly:)
			(self setScript: lucyShootsYou)
		else
			(if (>= (global112 curColIdx:) 2)
				(self setScript: guysGotoDoor)
			)
			(gGame handsOn:)
		)
	)

	(method (criticalAlert)
		(if (and (== (global112 curColIdx:) 2) (not script))
			(self setScript: guysGotoDoor)
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
				(gMessager say: 0 48 7 1) ; "Sierra One reporting. Suspect not observed side one. Repeat, no suspect movement side one."
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
				(host setScript: throwFlashBang)
			)
			(45
				(gMessager say: 0 45 0 1) ; "What is it?"
			)
			(44
				(if (global112 usedMirror:)
					(gMessager say: 0 44 8 1) ; "Suspect?"
				else
					(gMessager say: 0 44 7 1) ; "I've got you..."
				)
			)
			(46
				(gMessager say: 0 46 0 1) ; "Hurry is right! Side three! Now!"
			)
			(48
				(if (or (global112 usedMirror:) (IsFlag 154))
					(gMessager say: 0 48 7 1) ; "Sierra One reporting. Suspect not observed side one. Repeat, no suspect movement side one."
				else
					(global112 suspectSpotted: 4290)
					(gCurRoom newRoom: 4270) ; s1_4270
				)
			)
			(43
				(gMessager say: 0 43 0 1) ; "What is it?"
			)
			(42
				(gMessager say: 0 42 0 1) ; "Where?! What is it?"
			)
			(47
				(gMessager say: 0 47 0 1) ; "Move with caution..."
			)
			(49
				(if (global112 usedMirror:)
					(gMessager say: 0 49 8 1) ; "What!? What is it?"
				else
					(gMessager say: 0 49 7 1) ; "Pup! Get to side three. Move before you compromise this mission!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: (ScriptID 36)) ; Mirror
			((ScriptID 36) dispose:) ; Mirror
		)
		(if
			(and
				(== (global112 curColIdx:) 4)
				gAutoRobot
				(> (Robot 11) 460) ; FrameNum
				(== newRoomNumber 4270) ; s1_4270
			)
			(global112 endColumn:)
		)
		(gBackMusic2 number: 0 stop:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(if (gTimers contains: reactTimer)
			(reactTimer dispose: delete:)
		)
		(if (gTimers contains: mirrorTimer)
			(mirrorTimer dispose: delete:)
		)
		(= gMyAutoEventCode 0)
		(local1 dispose:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance guysGotoDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (global112 curColIdx:)
					(2
						(= local3 (global112 getPercent: 0 85))
					)
					(3
						(= local3 (global112 getPercent: 86 113))
					)
					(4
						(= local3 (global112 getPercent: 114 493))
					)
				)
				(= temp0 400)
				(if (> local3 90)
					(= temp0 280)
					(= state 1)
				)
				(if (> local3 131)
					(= temp0 280)
					(= state 2)
				)
				(if (> local3 153)
					(= temp0 280)
					(= state 3)
				)
				(if (> local3 168)
					(= temp0 280)
					(= state 4)
				)
				(if (> local3 180)
					(= temp0 -1)
					(= state 5)
				)
				(if (> local3 272)
					(= temp0 -1)
					(= state 6)
				)
				(if (> local3 422)
					(= temp0 -1)
					(= state 7)
				)
				(proc4_6 40300 160 56 local3 0 temp0 1)
			)
			(1
				(gAutoRobot setPri: 280)
			)
			(2
				(gSwatInterface showHandAni: 8)
			)
			(3
				(gSwatInterface showHandAni: 2)
			)
			(4
				(gSwatInterface showHandAni: 5)
			)
			(5
				(gAutoRobot setPri: -1)
			)
			(6
				(door cel: 0 setCycle: End)
			)
			(7
				(gSwatInterface showHandAni: 6)
			)
			(8
				(reactTimer setReal: reactTimer 5)
				(self dispose:)
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
				(if (gTimers contains: reactTimer)
					(reactTimer dispose: delete:)
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
				(gMessager say: 1 24 9 1 self) ; "Copy."
			)
			(3
				(global112 suspectSpotted: 4290)
				(gCurRoom newRoom: 4270) ; s1_4270
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
				(if (gTimers contains: reactTimer)
					(reactTimer dispose: delete:)
				)
				(gMessager say: 0 7 0 1 self) ; "Cease fire! Cease fire!"
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
				(if (gTimers contains: reactTimer)
					(reactTimer dispose: delete:)
				)
				(gMessager say: 0 6 0 1 self) ; "Cease fire! Cease fire!"
			)
			(1
				(gCurRoom newRoom: 4010) ; s1_4010
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
				(if (gTimers contains: reactTimer)
					(reactTimer dispose: delete:)
				)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
				(Load rsVIEW 6)
			)
			(1
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
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
				(gCurRoom newRoom: 4280) ; s1_4280
			)
		)
	)
)

(instance lucyShootsYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: reactTimer)
					(reactTimer dispose: delete:)
				)
				(proc4_6 40305 92 114 0 0 1 1)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic2 number: 40107 loop: 1 play:)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40103)
			)
			(2
				(gMessager say: 0 51 3 1) ; "Suspect, 1/2 corner."
			)
			(3
				(gBackMusic number: 0 stop:)
				(SetFlag 98)
				(SetFlag 96)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance lucyShootsAndDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shootingLucy setPri: 1 init: setCycle: CT 8 1 self)
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40103)
				(gMessager say: 0 0 1 1) ; "Armed suspect! 1/2 corner!"
			)
			(1
				(proc4_5)
				(officerShoots setPri: 500 init: setCycle: End)
				(shootingLucy setCycle: CT 35 1 self)
				(gFxSound number: 40308 setLoop: 1 play:)
			)
			(2
				(shootingLucy setCycle: End self)
				(gFxSound number: 51 setLoop: 1 play:)
			)
			(3
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 40109 loop: 1 play:)
				(gMessager say: 0 0 1 2 self) ; "Sierra One to Twenty David - Suspect neutralized."
			)
			(4
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance lucyEscapes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: reactTimer)
					(reactTimer dispose: delete:)
				)
				(if local2
					((ScriptID 36) dispose:) ; Mirror
					(= local2 0)
				)
				(gFxSound number: 40309 setLoop: 1 play:)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance capturedLucy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 2 1 self) ; "Lucy! It's the police! Where are you?"
			)
			(1
				(= seconds 4)
			)
			(2
				(gMessager say: 0 0 2 2 self) ; "Pacmeyer to Ten David - Suspect in control! Officers coming out."
			)
			(3
				(proc4_5)
				(denton setPri: 500 setCycle: Fwd init:)
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 6006 loop: -1 play:)
				(UnLoad 141 40103)
				(proc4_6 40302 317 40)
			)
			(4
				(gAutoRobot setPri: 355)
			)
			(5
				(gEgo awardMedal: 64)
				(SetFlag 98)
				(SetFlag 96)
				(gCurRoom newRoom: 35) ; metroExt
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
				(proc4_5)
				(gGame showCloseUp: 40304 180 70 self 1)
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
				(gSwatInterface showHandAni: 7 self)
			)
			(1
				(global112 suspectSpotted: 4290)
				(gCurRoom newRoom: 4270) ; s1_4270
			)
		)
	)
)

(instance shootingLucy of Prop
	(properties
		x 179
		y 217
		view 40308
	)
)

(instance officerShoots of Prop
	(properties
		x 183
		y 306
		view 40304
	)
)

(instance door of Prop
	(properties
		x 512
		y 220
		view 40310
	)
)

(instance denton of Prop
	(properties
		x 184
		y 306
		view 40302
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
					(gMessager say: 0 48 7 1) ; "Sierra One reporting. Suspect not observed side one. Repeat, no suspect movement side one."
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
		y 343
		view 40307
	)

	(method (cue)
		(= local2 0)
		((ScriptID 36) dispose:) ; Mirror
	)
)

(instance lucyArmed of Prop
	(properties
		x 36
		y 344
		view 40309
	)

	(method (cue)
		(= local2 0)
		((ScriptID 36) dispose:) ; Mirror
	)
)

(instance flashBang of Prop
	(properties
		x 80
		y 125
		view 40301
	)
)

(instance host of Prop
	(properties
		y 2000
		view 56
	)
)

(instance reflection of View
	(properties
		x 15
		y 342
		view 40311
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

(instance robotFeature of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1 &rest))
				(not
					(or
						(> (param1 x:) 480)
						(and (> (Robot 11) 75) (< (param1 x:) 290)) ; FrameNum
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
			(48
				(if
					(and
						(global112 usedMirror:)
						(or (IsFlag 152) (IsFlag 153))
					)
					(gCurRoom setScript: notifyOfLucy)
				else
					(gMessager say: 0 48 7 1) ; "Sierra One reporting. Suspect not observed side one. Repeat, no suspect movement side one."
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
		nsLeft 110
		nsTop 65
		nsRight 220
		nsBottom 220
	)

	(method (doVerb theVerb)
		(switch theVerb
			(40
				(if (not local2)
					(= local2 1)
					(global112 useMirror: 4290)
					(cond
						((IsFlag 152)
							((ScriptID 36) init: add: reflection lucyArmed) ; Mirror
							(lucyArmed cel: 0 init:)
							(reflection init:)
							(lucyArmed setCycle: End lucyArmed)
						)
						((IsFlag 153)
							((ScriptID 36) init: add: reflection lucyUnArmed) ; Mirror
							(lucyUnArmed cel: 0 init:)
							(reflection init:)
							(lucyUnArmed setCycle: End lucyUnArmed)
						)
						(else
							((ScriptID 36) init: add: reflection) ; Mirror
							(reflection init:)
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
					(gMessager say: 0 48 7 1) ; "Sierra One reporting. Suspect not observed side one. Repeat, no suspect movement side one."
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
					(ClearFlag 153)
					(SetFlag 154)
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

(instance westE of HotSpot
	(properties
		nsLeft 110
		nsTop 65
		nsRight 220
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
							(ClearFlag 153)
							(SetFlag 154)
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
							(ClearFlag 153)
							(SetFlag 154)
							(gCurRoom setScript: lucyEscapes)
						)
					)
				)
			)
		)
	)
)

(instance reactTimer of Timer
	(properties)

	(method (cue)
		(cond
			((or (IsFlag 153) (IsFlag 152))
				(Load rsAUDIO 40308)
				(gCurRoom setScript: lucyShootsAndDies)
			)
			((IsFlag 154)
				(gCurRoom setScript: capturedLucy)
			)
		)
		(self dispose: delete:)
	)
)

(instance mirrorTimer of Timer
	(properties)

	(method (cue)
		((ScriptID 36) dispose:) ; Mirror
		(= local2 0)
		(self dispose: delete:)
	)
)

(instance myAutoEventCode of Code
	(properties)

	(method (doit param1 param2)
		(cond
			(argc
				(if (local1 contains: param2)
					(= local0 param2)
				)
				(param1 claimed: 1)
			)
			(local0
				(local0 doVerb: 7)
			)
			(else
				(gCurRoom doVerb: 7)
			)
		)
	)
)

