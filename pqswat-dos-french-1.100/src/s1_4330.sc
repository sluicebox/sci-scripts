;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4330)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Polygon)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4330 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance s1_4330 of PQRoom
	(properties
		picture 4330
	)

	(method (init)
		(super init: &rest)
		(= gMyAutoEventCode myAutoEventCode)
		(eastE init:)
		(southE init:)
		(westE init:)
		((= local5 (Set new:)) add: lucyUnArmed)
		(cond
			((== gPrevRoomNum 4310) ; s1_4310
				(if (global112 flashBanged:)
					(self setScript: threwFlashBang4310)
				)
			)
			((global112 flashBanged:)
				(self setScript: threwFlashBang4320)
			)
			(else
				(lucyUnArmed init:)
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40103)
				(roomTimer setReal: 1 roomTimer 20)
				(gGame handsOn:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(SetFlag 156)
				(self setScript: shootRoom)
			)
			(6
				(SetFlag 157)
				(self setScript: shootRoom)
			)
			(40
				(if (not local3)
					(= local3 1)
					(reflection init:)
					((ScriptID 36) init: add: reflection) ; Mirror
					(mirrorTimer setReal: mirrorTimer 10)
				)
			)
			(16
				(self setScript: throwFlashBang)
			)
			(48
				(= local2 1)
				(gMessager say: 0 theVerb 0 1) ; "Pup, is she armed?"
			)
			(47
				(self setScript: calledClear)
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
					(and (proc4_11 21) (proc4_11 36) (== global149 2))
					(and
						(proc4_11 21)
						(proc4_11 36)
						(proc4_11 28)
						(== global149 3)
					)
					(and
						(proc4_11 17)
						(proc4_11 35)
						(proc4_11 36)
						(== global149 3)
					)
					(and (proc4_11 17) (proc4_11 35) (== global149 2))
					(and (proc4_11 17) (proc4_11 36) (== global149 2))
					(and
						(proc4_11 17)
						(proc4_11 35)
						(proc4_11 36)
						(proc4_11 28)
						(== global149 4)
					)
					(and
						(proc4_11 17)
						(proc4_11 35)
						(proc4_11 28)
						(== global149 3)
					)
					(and
						(proc4_11 17)
						(proc4_11 36)
						(proc4_11 28)
						(== global149 3)
					)
					(and (proc4_11 17) (proc4_11 43) (== global149 2))
					(and
						(proc4_11 17)
						(proc4_11 43)
						(proc4_11 35)
						(proc4_11 36)
						(== global149 4)
					)
					(and
						(proc4_11 17)
						(proc4_11 43)
						(proc4_11 35)
						(== global149 3)
					)
					(and
						(proc4_11 17)
						(proc4_11 43)
						(proc4_11 36)
						(== global149 3)
					)
					(and
						(proc4_11 17)
						(proc4_11 21)
						(proc4_11 35)
						(== global149 3)
					)
					(and
						(proc4_11 17)
						(proc4_11 21)
						(proc4_11 36)
						(proc4_11 28)
						(== global149 4)
					)
					(and (proc4_11 21) (proc4_11 42) (== global149 2))
					(and
						(proc4_11 21)
						(proc4_11 42)
						(proc4_11 36)
						(== global149 3)
					)
					(and
						(proc4_11 21)
						(proc4_11 42)
						(proc4_11 36)
						(proc4_11 28)
						(== global149 4)
					)
					(and
						(proc4_11 21)
						(proc4_11 36)
						(proc4_11 23)
						(== global149 3)
					)
					(and
						(proc4_11 21)
						(proc4_11 36)
						(proc4_11 28)
						(proc4_11 23)
						(== global149 4)
					)
				)
				(self setScript: sayLash)
				(return -2)
			)
			((and local2 (proc4_11 7) (== global149 1))
				(return -2)
			)
			((and local2 (proc4_11 8) (== global149 1))
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
		(gBackMusic loop: 1 stop:)
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (gTimers contains: mirrorTimer)
			(mirrorTimer dispose: delete:)
		)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(= gMyAutoEventCode 0)
		(local5 dispose:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance sayLash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gMessager say: 2 0 5 1 self) ; "Copy."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shootRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 0 7 0 1 self) ; "Cease fire! Status! Cease fire!!"
			)
			(2
				(gCurRoom newRoom: 4000) ; s1_4000
			)
		)
	)
)

(instance calledClear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(proc4_6 43303 158 32)
				(lucyUnArmed dispose:)
			)
			(1
				(gAutoRobot setPri: 500)
			)
			(2
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 6006 loop: -1 play:)
				(UnLoad 141 40103)
			)
			(3
				(gCurRoom drawPic: 0)
				(proc4_5)
				(gCast eachElementDo: #dispose)
				(gMessager say: 0 47 0 2 self) ; "Denton to Twenty David - Suspect in control side three. Officers coming out to side one!"
			)
			(4
				(gEgo awardMedal: 64)
				(SetFlag 101)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance threwFlashBang4310 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(deadLucy init:)
				(= cycles 2)
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

(instance threwFlashBang4320 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 43301 0 45)
				(= cycles 2)
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

(instance throwFlashBang of Script
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
				(lucyUnArmed dispose:)
				(deadLucy posn: 445 295 init:)
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
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
			)
			(6
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 103)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance talkToLucy1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomTimer setReal: 1 roomTimer 30)
				(gMessager say: 1 29 2 0 self) ; "Lucy! This is the police! We've come to talk to you!"
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance talkToLucy2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(proc4_6 43302 145 57 0 0 -1 1)
				(lucyUnArmed dispose:)
			)
			(1
				(gCurRoom newRoom: 4340) ; s1_4340
			)
		)
	)
)

(instance shootLucy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gCast eachElementDo: #dispose)
				(gGame handsOff: showCloseUp: 43304 180 70 self)
				(deadLucy posn: 445 295 init:)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40103)
				(gMessager say: 0 6 0 0) ; "Cease fire! Cease fire!!"
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance reflection of View
	(properties
		x 15
		y 278
		view 43303
	)
)

(instance deadLucy of View
	(properties
		x 159
		y 264
		view 43300
	)
)

(instance lucyUnArmed of View
	(properties
		x 588
		y 394
		view 43302
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local0)
					(= local0 1)
					(gCurRoom setScript: talkToLucy1)
				else
					(gCurRoom setScript: talkToLucy2)
				)
			)
			(7
				(gCurRoom setScript: shootLucy)
			)
			(6
				(gCurRoom setScript: shootLucy)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 235
		y 260
		view 43301
	)
)

(instance eastE of HotSpot
	(properties
		type 8193
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 552 0 638 0 638 123 605 127 585 181 595 213 611 216 607 293 630 340 631 357 554 357
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom newRoom: 4310) ; s1_4310
	)
)

(instance westE of HotSpot
	(properties
		nsRight 40
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 4310) ; s1_4310
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
		(gCurRoom newRoom: 4310) ; s1_4310
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
		(switch local1
			(1
				(gMessager say: 0 0 4 1) ; "Pup! Report! What's your status?!"
				(self setReal: 2 self 20)
			)
			(2
				(gCurRoom setScript: calledClear)
			)
		)
	)

	(method (setReal param1)
		(= local1 param1)
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
				(if (local5 contains: param2)
					(= local4 param2)
				)
				(param1 claimed: 1)
			)
			(local4
				(local4 doVerb: 7)
			)
			(else
				(gCurRoom doVerb: 7)
			)
		)
	)
)

