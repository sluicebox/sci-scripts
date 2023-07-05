;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4320)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4320 0
)

(local
	local0
)

(instance s1_4320 of PQRoom
	(properties
		picture 4320
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(cornerE init:)
		(cornerWall init:)
		(global112 resetData: 0)
		(roomTimer setReal: roomTimer 30)
		(gGame handsOn:)
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
			(16
				(self setScript: throwFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify)
		(if
			(or
				(and (proc4_11 21) (proc4_11 36) (== global149 2))
				(and (proc4_11 21) (proc4_11 36) (proc4_11 28) (== global149 3))
				(and (proc4_11 17) (proc4_11 35) (proc4_11 36) (== global149 3))
				(and (proc4_11 17) (proc4_11 35) (== global149 2))
				(and (proc4_11 17) (proc4_11 36) (== global149 2))
				(and
					(proc4_11 17)
					(proc4_11 35)
					(proc4_11 36)
					(proc4_11 28)
					(== global149 4)
				)
				(and (proc4_11 17) (proc4_11 35) (proc4_11 28) (== global149 3))
				(and (proc4_11 17) (proc4_11 36) (proc4_11 28) (== global149 3))
				(and (proc4_11 17) (proc4_11 43) (== global149 2))
				(and
					(proc4_11 17)
					(proc4_11 43)
					(proc4_11 35)
					(proc4_11 36)
					(== global149 4)
				)
				(and (proc4_11 17) (proc4_11 43) (proc4_11 35) (== global149 3))
				(and (proc4_11 17) (proc4_11 43) (proc4_11 36) (== global149 3))
			)
			(self setScript: sayLash)
			(return -2)
		else
			(return -1)
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
				(gMessager say: 1 0 2 1 self) ; "Copy."
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
				(gMessager say: 0 7 0 1 self) ; "Cease fire! Cease fire!"
			)
			(2
				(gCurRoom newRoom: 4000) ; s1_4000
			)
		)
	)
)

(instance yourDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(shootingLucy setPri: 1 init: setCycle: CT 20 1 self)
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40108 loop: 1 play:)
				(UnLoad 141 40103)
			)
			(1
				(shootingLucy setCycle: End self)
				(gFxSound number: 43200 setLoop: 1 play:)
			)
			(2
				(gBackMusic number: 0 stop:)
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang setPri: 1 init: setCycle: End self)
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
				(global112 threwFlash: 4330)
				(gCurRoom newRoom: 4330) ; s1_4330
			)
		)
	)
)

(instance shootingLucy of Prop
	(properties
		x 250
		y 290
		view 43200
	)
)

(instance flashBang of Prop
	(properties
		x 232
		y 357
		view 43202
	)
)

(instance lucyUnArmed of Prop
	(properties
		x 48
		y 344
		view 43201
	)

	(method (cue)
		(= local0 0)
		((ScriptID 36) dispose:) ; Mirror
	)
)

(instance reflection of View
	(properties
		x 15
		y 342
		view 43203
	)
)

(instance cornerWall of Feature
	(properties
		nsLeft 150
		nsRight 360
		nsBottom 360
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 40) (not local0))
			(= local0 1)
			(global112 useMirror: 4340)
			((ScriptID 36) init: add: reflection lucyUnArmed) ; Mirror
			(reflection init:)
			(lucyUnArmed cel: 0 init:)
			(lucyUnArmed setCycle: End lucyUnArmed)
		else
			(gCurRoom doVerb: theVerb)
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
		(gCurRoom newRoom: 4340) ; s1_4340
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
		(gCurRoom newRoom: 4340) ; s1_4340
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 4340) ; s1_4340
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
		(gCurRoom newRoom: 4310) ; s1_4310
	)
)

(instance cornerE of HotSpot
	(properties
		nsLeft 150
		nsRight 360
		nsBottom 360
		type 2
	)

	(method (doVerb)
		(global112 slicePie: 4340)
		(if (global112 usedMirror:)
			(gCurRoom newRoom: 4330) ; s1_4330
		else
			(gCurRoom setScript: yourDead)
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
		(gMessager say: 0 0 1 1) ; "Pup, report location!!"
		(self setReal: self 30)
	)
)

