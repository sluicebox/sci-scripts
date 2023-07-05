;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4290)
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
	s1_4290 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance s1_4290 of PQRoom
	(properties
		picture 4290
	)

	(method (init)
		(super init: &rest)
		(= gMyAutoEventCode myAutoEventCode)
		(Load rsVIEW 42900)
		(gate init:)
		(northE init:)
		(eastE init:)
		(southE init:)
		((= local4 (Set new:)) add: gate)
		(gGame handsOn:)
		(roomTimer setReal: 1 roomTimer 30)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(SetFlag 156)
				(self setScript: mp5Shot)
			)
			(6
				(SetFlag 157)
				(self setScript: colt45Shot)
			)
			(16
				(global112 threwFlash: 4310)
				(self setScript: throwFlashBang)
			)
		)
	)

	(method (lashNotify)
		(cond
			((and (proc4_11 25) (proc4_11 34) (proc4_11 35) (== global149 3))
				(self setScript: ramGate)
			)
			((and (proc4_11 25) (proc4_11 35) (== global149 2))
				(self setScript: ramGate)
			)
			((and local1 (proc4_11 7) (== global149 1))
				(return -2)
			)
			((and local1 (proc4_11 7) (proc4_11 3) (== global149 2))
				(return -2)
			)
			((and local1 (proc4_11 3) (== global149 1))
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
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose:)
			(gTimers delete: roomTimer)
		)
		(if (gTimers contains: mirrorTimer)
			(mirrorTimer dispose: delete:)
		)
		(= gMyAutoEventCode 0)
		(local4 dispose:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance shootFence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 0 7 2 1 self) ; "AAHhhhhhaaaaaa!!!"
			)
			(2
				(gMessager say: 0 7 2 2 self) ; "Cease fire! Cease fire!!"
			)
			(3
				(SetFlag 155)
				(gCurRoom newRoom: 4310) ; s1_4310
			)
		)
	)
)

(instance ramGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(gMessager say: 0 24 0 1 self) ; "Ram on one-two corner!"
			)
			(1
				(proc4_6 42900 0 -59)
			)
			(2
				(denton init:)
			)
			(3
				(denton dispose:)
			)
			(4
				(gate setCycle: CT 9 1)
			)
			(5
				(ram init:)
			)
			(6
				(gAutoRobot caller: 0)
				(gSwatInterface showHandAni: 6 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gCurRoom newRoom: 4310) ; s1_4310
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
				(gCurRoom newRoom: 4310) ; s1_4310
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
				(gMessager say: 0 7 0 1 self) ; "Cease fire! Cease fire!!"
			)
			(2
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
				(gMessager say: 0 6 0 1 self) ; "Cease fire! Cease fire!!"
			)
			(2
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance denton of View
	(properties
		x 147
		y 246
		view 42900
	)
)

(instance ram of View
	(properties
		x 318
		y 306
		view 42900
		loop 1
	)
)

(instance reflection of View
	(properties
		x 13
		y 278
		view 42903
	)
)

(instance gate of Prop
	(properties
		x 246
		y 227
		view 42901
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootFence)
			)
			(6
				(gCurRoom setScript: shootFence)
			)
			(40
				(if (not local2)
					(= local2 1)
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

(instance flashBang of Prop
	(properties
		x 235
		y 245
		view 42902
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(= local1 1)
		(gMessager say: 1 29 0 1) ; "Pup, what's happening? Is the gate locked?"
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
		(gCurRoom newRoom: 4300) ; s1_4300
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
		(gCurRoom newRoom: 4280) ; s1_4280
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
				(gMessager say: 0 0 1 1) ; "Pup, what's going on?!"
				(self setReal: 2 self 30)
			)
			(2
				(gMessager say: 0 0 1 2) ; "This is Twenty David! Pup, move to side three! Now!!"
				(self setReal: 3 self 30)
			)
			(3
				(gMessager say: 0 0 1 3) ; "Pup, what's the problem?"
				(self setReal: 1 self 30)
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
		(= local2 0)
		(self dispose: delete:)
	)
)

(instance myAutoEventCode of Code
	(properties)

	(method (doit param1 param2)
		(cond
			(argc
				(if (local4 contains: param2)
					(= local3 param2)
				)
				(param1 claimed: 1)
			)
			(local3
				(local3 doVerb: 7)
			)
			(else
				(gCurRoom doVerb: 7)
			)
		)
	)
)

