;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4280)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4280 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(procedure (localproc_0 param1 &tmp temp0)
	(if (not local2)
		(= local2 param1)
		(= local4 (local3 indexOf: local2))
	else
		(for
			((= temp0 0))
			(and (< temp0 (local3 size:)) (< temp0 local4))
			((++ temp0))
			
			(if (== param1 (local3 at: temp0))
				(= local2 param1)
				(= local4 temp0)
				(break)
			)
		)
	)
)

(instance s1_4280 of PQRoom
	(properties
		picture 4280
	)

	(method (init)
		(super init: &rest)
		(= gMyAutoEventCode myAutoEventCode)
		(Load rsAUDIO 48)
		(Load rsVIEW 42800)
		(Load rsVIEW 42803)
		(eastE init:)
		(southE init:)
		(westE init:)
		(if (IsFlag 154)
			(northE init:)
		)
		(robotFeature init:)
		((= local3 (Set new:))
			add: enteringMen shootingLucy shootingLucy2 robotFeature
		)
		(switch gPrevRoomNum
			(4300 ; s1_4300
				(if (global112 warnedOfSuspect:)
					(if (IsFlag 152)
						(self setScript: lucyArmed)
					else
						(self setScript: lucyUnArmed)
					)
				)
			)
			(4290 ; s1_4290
				(fence init:)
				(gGame handsOn:)
				(roomTimer setReal: 1 roomTimer 30)
			)
			(else
				(cond
					((global112 flashBanged:)
						(self setScript: lucysDead)
					)
					((not (global112 usedMirror:))
						(Lock rsAUDIO 40103 0)
						(Load rsAUDIO 4280)
						(self setScript: lucyShootsYou)
					)
					((and (global112 usedMirror:) (IsFlag 154))
						(if (== (global112 curColIdx:) 4)
							(Load rsVIEW 42807)
							(self setScript: menEntersDoor)
						else
							(roomTimer setReal: 1 roomTimer 30)
							(gGame handsOn:)
						)
						(fence init:)
					)
					(
						(and
							(global112 usedMirror:)
							(IsFlag 152)
							(not (global112 warnedOfSuspect:))
						)
						(Lock rsAUDIO 40103 0)
						(Load rsAUDIO 4280)
						(self setScript: lucyShootsYou)
					)
					(
						(and
							(global112 usedMirror:)
							(or (IsFlag 152) (IsFlag 153))
							(global112 warnedOfSuspect:)
						)
						(if (IsFlag 152)
							(self setScript: lucyArmed)
						else
							(self setScript: lucyUnArmed)
						)
					)
					(else
						(fence init:)
						(gGame handsOn:)
						(roomTimer setReal: 1 roomTimer 30)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(if (and (!= script lucyArmed) (not local7))
					(SetFlag 156)
					(self setScript: shootAtRoom 0 theVerb)
				)
			)
			(6
				(if (and (!= script lucyArmed) (not local7))
					(SetFlag 157)
					(self setScript: shootAtRoom 0 theVerb)
				)
			)
			(16
				(if (IsFlag 154)
					(gCurRoom setScript: flashBangFence)
				else
					(gCurRoom setScript: flashBangLucy)
				)
			)
			(48
				(if (IsFlag 154)
					(gMessager say: 0 theVerb 0 1) ; "Sierra One reporting. Suspect not observed side one. No suspect movement side one."
				)
			)
			(44
				(= local1 1)
				(gMessager say: 0 theVerb 0 1) ; "Pup, suspect detected?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify)
		(cond
			(
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
					(and
						(proc4_11 21)
						(proc4_11 35)
						(proc4_11 28)
						(== global149 3)
					)
					(and
						(proc4_11 21)
						(proc4_11 34)
						(proc4_11 35)
						(== global149 3)
					)
				)
				(return -2)
			)
			((and local1 (proc4_11 7) (== global149 1))
				(return -2)
			)
			((and local1 (proc4_11 8) (== global149 1))
				(return -2)
			)
			(else
				(return -1)
			)
		)
	)

	(method (newRoom)
		(if (gCast contains: (ScriptID 36)) ; Mirror
			((ScriptID 36) dispose:) ; Mirror
		)
		(gBackMusic2 number: 0 stop:)
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(if (gTimers contains: mirrorTimer)
			(mirrorTimer dispose: delete:)
		)
		(= gMyAutoEventCode 0)
		(local3 dispose:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance lucyArmed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gBackMusic number: 0 stop:)
				(gBackMusic2 number: 0 stop:)
				(Lock rsAUDIO 40103 0)
				(Load rsAUDIO 42809)
				(Load rsVIEW 42809)
				(Load rsVIEW 42820)
				(SetFlag 124)
				(shootingLucy2 setPri: 5 init:)
				(proc4_6 42801 109 30 0 0 -1 1)
				(= cycles 1)
			)
			(1
				(gBackMusic number: 40108 loop: -1 play:)
				(gBackMusic2 number: 40107 loop: 1 play: self)
			)
			(2
				(gBackMusic2 number: 0 stop:)
			)
			(3
				(gSwatInterface showHandAni: 3)
			)
			(4
				(shootingLucy2 setPri: 5 init: setCycle: CT 57 1 self)
			)
			(5
				(shootingLucy2 scratch: 1 setCycle: CT 63 1 self)
			)
			(6
				(gFxSound number: 42809 setLoop: 1 play:)
				(shootingLucy2 scratch: 2 setPri: 500 setCycle: CT 76 1 self)
				(proc4_5)
				(dentonShot init: setCycle: End)
			)
			(7
				(shootingLucy2 scratch: 3 setCycle: End self)
			)
			(8
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 40109 loop: 1 play: self)
			)
			(9
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance lucyUnArmed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(Lock rsAUDIO 40103 0)
				(proc4_6 42800 -5 50 0 0 -1 1)
				(= cycles 2)
			)
			(1
				(gBackMusic number: 40108 loop: -1 play:)
				(gBackMusic2 number: 40107 loop: 1 play:)
			)
			(2
				(gSwatInterface showHandAni: 3)
			)
			(3
				(gGame handsOff:)
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 6006 loop: -1 play:)
				(UnLoad 141 40103)
			)
			(4
				(gSwatInterface showHandAni: 4)
			)
			(5
				(gEgo awardMedal: 64)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootThroughFence of Script
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
				(gMessager say: 0 6 6 1 self) ; "Ahhhh!!!"
			)
			(2
				(gMessager say: 0 6 0 1 self) ; "Cease fire! Cease fire!!"
			)
			(3
				(SetFlag 155)
				(gCurRoom newRoom: 4310) ; s1_4310
			)
		)
	)
)

(instance flashBangFence of Script
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
				(gFxSound number: 1003 setLoop: 1 play:)
				(canOverFence init: setCycle: End self)
			)
			(2
				(gFxSound number: 1002 setLoop: 1 play: self)
			)
			(3
				(global112 threwFlash: 4310)
				(gCurRoom newRoom: 4310) ; s1_4310
			)
		)
	)
)

(instance flashBangLucy of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gFxSound number: 1003 setLoop: 1 play:)
				(canAtLucy init: setCycle: End self)
			)
			(1
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(if (IsFlag 152)
					(cond
						((< (= local9 (shootingLucy2 scratch:)) 2)
							(SetFlag 98)
							(SetFlag 95)
							(= temp0 1)
						)
						((< local9 3)
							(SetFlag 98)
							(SetFlag 94)
						)
					)
				else
					(SetFlag 98)
					(SetFlag 95)
					(= temp0 1)
				)
				(proc4_5)
				(gCast eachElementDo: #dispose)
				(deadLucyOpenArm init:)
				(if temp0
					(dentonLookBody init:)
				else
					(dentonShot cel: 25 init:)
				)
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
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
			)
			(6
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootAtRoom of Script
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
				(gCurRoom drawPic: 0)
				(proc4_5)
				(gCast eachElementDo: #dispose)
				(gMessager say: 0 register 0 0 self)
			)
			(2
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance menEntersDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(enteringMen
					cel: (global112 getPercent: 0 216)
					init:
					setCycle: End self
				)
			)
			(1
				(enteringMen dispose:)
				(roomTimer setReal: 1 roomTimer 30)
				(self dispose:)
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
				(shootingLucy init: setCycle: CT 16 1 self)
				(= cycles 2)
			)
			(1
				(gBackMusic number: 40108 loop: -1 play:)
				(gBackMusic2 number: 40107 loop: 1 play:)
				(UnLoad 141 40103)
			)
			(2
				(shootingLucy setCycle: End self)
				(gFxSound number: 4280 setLoop: 1 play:)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(4
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 40109 loop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance lucysDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (global112 curColIdx:) 4)
					(enteringMen
						cel: (global112 getPercent: 0 216)
						init:
						setCycle: End
					)
				)
				(deadLucyOpenArm init:)
				(= seconds 2)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 103)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance lucyDiesJustified of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gCurRoom drawPic: 0)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gGame handsOff: showCloseUp: 42804 180 70 self 1)
			)
			(2
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
			)
			(3
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 102)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance lucyDiesPrison of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gCurRoom drawPic: 0)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gGame handsOff: showCloseUp: 42804 180 70 self 1)
			)
			(2
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
			)
			(3
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
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
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gMessager say: 0 0 3 3 self) ; "Pup! Get out of there!"
			)
			(1
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance officersShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 0)
				(enteringMen dispose:)
				(= cycles 1)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
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

(instance shotDenton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 0 stop:)
				(UnLoad 141 40103)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gGame handsOff: showCloseUp: 42805 180 70 self 1)
			)
			(1
				(gBackMusic number: 40109 loop: 1 play: self)
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

(instance dentonShot of Prop
	(properties
		x 126
		y 339
		view 42809
	)
)

(instance enteringMen of Prop
	(properties
		x 482
		y 216
		view 42807
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: officersShot)
			)
			(6
				(gCurRoom setScript: officersShot)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance canAtLucy of Prop
	(properties
		x 150
		y 335
		view 42803
	)
)

(instance canOverFence of Prop
	(properties
		x 28
		y 104
		view 42808
	)
)

(instance shootingLucy of Prop
	(properties
		x 70
		y 267
		view 4280
	)
)

(instance shootingLucy2 of Prop
	(properties
		x 94
		y 269
		view 42820
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(7
				(= local7 1)
				(if (and (= temp0 (gCurRoom script:)) (temp0 script:))
					((temp0 script:) caller: 0)
				)
				(cond
					((< scratch 1)
						(gCurRoom setScript: lucyDiesPrison)
					)
					((< scratch 2)
						(gEgo awardMedal: 32)
						(gEgo awardMedal: 4)
						(gCurRoom setScript: lucyDiesJustified)
					)
					((< scratch 3)
						(gEgo awardMedal: 32)
						(gCurRoom setScript: lucyDiesJustified)
					)
					(else
						(Lock rsAUDIO 40103 0)
						(gCurRoom newRoom: 72) ; funeralRoom
					)
				)
			)
			(6
				(= local7 1)
				(if (and (= temp0 (gCurRoom script:)) (temp0 script:))
					((temp0 script:) caller: 0)
				)
				(cond
					((< scratch 1)
						(gCurRoom setScript: lucyDiesPrison)
					)
					((< scratch 2)
						(gEgo awardMedal: 32)
						(gEgo awardMedal: 4)
						(gCurRoom setScript: lucyDiesJustified)
					)
					((< scratch 3)
						(gEgo awardMedal: 32)
						(gCurRoom setScript: lucyDiesJustified)
					)
					(else
						(Lock rsAUDIO 40103 0)
						(gCurRoom newRoom: 72) ; funeralRoom
					)
				)
			)
			(48
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dentonLookBody of View
	(properties
		x 194
		y 322
		view 42802
	)
)

(instance deadLucyOpenArm of View
	(properties
		x 14
		y 244
		view 42800
	)
)

(instance deadLucyCloseArm of View ; UNUSED
	(properties
		x 14
		y 244
		view 42800
		cel 1
	)
)

(instance reflection of View
	(properties
		x 14
		y 278
		view 42810
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
		(if (= temp0 (super onMe: param1 &rest))
			(if (== (gCurRoom script:) lucyUnArmed)
				(cond
					((and (< (Robot 11) 110) (> (param1 x:) 220)) ; FrameNum
						(= local6 1)
					)
					((< (param1 x:) 117)
						(= local5 1)
					)
				)
			)
			(if (== (gCurRoom script:) lucyArmed)
				(= local6 1)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(cond
					(local5
						(gCurRoom setScript: lucyDiesPrison)
					)
					(local6
						(gCurRoom setScript: shotDenton)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(6
				(cond
					(local5
						(gCurRoom setScript: lucyDiesPrison)
					)
					(local6
						(gCurRoom setScript: shotDenton)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(16
				(gCurRoom doVerb: theVerb)
			)
			(48
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fence of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: -1 121 81 122 89 215 0 220
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootThroughFence)
			)
			(6
				(gCurRoom setScript: shootThroughFence)
			)
			(40
				(if (not local8)
					(= local8 1)
					((ScriptID 36) init: add: reflection) ; Mirror
					(reflection setPri: 500 init:)
					(mirrorTimer setReal: mirrorTimer 10)
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
		nsBottom 48
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 4290) ; s1_4290
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(if (or (IsFlag 152) (IsFlag 153))
			(gCurRoom setScript: outtaThere)
		else
			(gCurRoom newRoom: 4300) ; s1_4300
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 40
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(if (or (IsFlag 152) (IsFlag 153))
			(gCurRoom setScript: outtaThere)
		else
			(gCurRoom newRoom: 4290) ; s1_4290
		)
	)
)

(instance southE of HotSpot
	(properties
		nsTop 312
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb)
		(if (or (IsFlag 152) (IsFlag 153))
			(gCurRoom setScript: outtaThere)
		else
			(gCurRoom newRoom: 4300) ; s1_4300
		)
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
				(gMessager say: 0 0 3 1) ; "Status?"
				(self setReal: 2 self 30)
			)
			(2
				(gMessager say: 0 0 3 2) ; "This is Twenty David! Pup, move to side three! Now!!"
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
		(= local8 0)
		(self dispose: delete:)
	)
)

(instance myAutoEventCode of Code
	(properties)

	(method (doit param1 param2)
		(cond
			(argc
				(localproc_0 param2)
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

