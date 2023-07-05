;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4060)
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
	s1_4060 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(switch (global112 curColIdx:)
		(1
			(return 3)
		)
		(2
			(return 3)
		)
		(3
			(return 2)
		)
		(else
			(return 0)
		)
	)
)

(instance s1_4060 of PQRoom
	(properties
		picture 4060
	)

	(method (init)
		(super init: &rest)
		(eastE init:)
		(westE init:)
		(southE init:)
		(robotFeature init:)
		(switch gPrevRoomNum
			(4050 ; s1_4050
				(if (or (IsFlag 151) (global112 flashBanged:))
					(self setScript: lucysDead)
				else
					(Lock rsAUDIO 40103 0)
					(Load rsAUDIO 40104)
					(Lock rsAUDIO 40104 1)
					(gBackMusic number: 0 stop:)
					(gBackMusic number: 40104 loop: -1 play:)
					(UnLoad 141 40103)
					(globalTimer setReal: globalTimer 60)
					(global112 startPath: 79)
					(self setScript: from4050)
				)
			)
			(4080 ; s1_4080
				(if global433
					(globalTimer setReal: globalTimer global433)
				else
					(globalTimer setReal: globalTimer 60)
				)
				(self setScript: from4080)
			)
			(4070 ; s1_4070
				(if global433
					(globalTimer setReal: globalTimer global433)
				else
					(globalTimer setReal: globalTimer 60)
				)
				(roomTimer setReal: 1 roomTimer 10)
				(gGame handsOn:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(self setScript: shootRoom)
			)
			(6
				(self setScript: shootRoom)
			)
			(16
				(self setScript: throwFlashBang)
			)
			(43
				(if (!= (localproc_0) 0)
					(super doVerb: theVerb)
				)
			)
			(47
				(switch (localproc_0)
					(3
						(gMessager say: 0 theVerb 5) ; "Confirmed."
					)
					(2
						(gMessager say: 0 theVerb 6) ; "Appears to be..."
					)
				)
			)
			(44
				(switch (localproc_0)
					(3
						(gMessager say: 0 theVerb 5) ; "I'm covering you... You cover Carmichael..."
					)
					(2
						(gMessager say: 0 theVerb 6) ; "I'll make the calls..."
					)
				)
			)
			(45
				(if (!= (localproc_0) 0)
					(super doVerb: theVerb)
				)
			)
			(46
				(switch (localproc_0)
					(3
						(gMessager say: 0 theVerb 5) ; "Calm down..."
					)
					(2
						(gMessager say: 0 theVerb 6 2) ; "Calm down... Move with caution."
					)
				)
			)
			(42
				(if (!= (localproc_0) 0)
					(super doVerb: theVerb)
				)
			)
			(49
				(switch (localproc_0)
					(3
						(gMessager say: 0 theVerb 5) ; "What for?"
					)
					(2
						(gMessager say: 0 theVerb 6) ; "No. Continue to probe. Area clear of threat."
					)
				)
			)
			(48
				(switch (localproc_0)
					(3
						(gMessager say: 0 theVerb 5) ; "Under control... Clear of threat."
					)
					(2
						(gMessager say: 0 theVerb 6) ; "Under control..."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (gTimers contains: globalTimer) (== newRoomNumber 4070)) ; s1_4070
			(= global433 (globalTimer seconds:))
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(if (gTimers contains: globalTimer)
			(globalTimer dispose: delete:)
		)
		(proc4_5)
		(super dispose:)
	)
)

(instance from4050 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(proc4_6 40601 14 54 0 0 200 1)
			)
			(1
				(gSwatInterface showHandAni: 3)
			)
			(2
				(gSwatInterface showHandAni: 3)
			)
			(3
				(roomTimer setReal: 1 roomTimer 10)
				(self dispose:)
			)
		)
	)
)

(instance from4080 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(switch (global112 curColIdx:)
					(0
						(= state 2)
						(self cue:)
						(return)
					)
					(1
						(= local3 (global112 getPercent: 0 45))
					)
					(2
						(= local3 (global112 getPercent: 46 65))
					)
					(3
						(= local3 (global112 getPercent: 66 178))
					)
					(4
						(= local3 (global112 getPercent: 179 221))
					)
					(5
						(= state 2)
						(self cue:)
						(return)
					)
					(6
						(= state 2)
						(self cue:)
						(return)
					)
				)
				(if (> local3 50)
					(= state 1)
				)
				(if (> local3 160)
					(= state 2)
				)
				(proc4_6 40601 14 54 local3 0 200 1)
			)
			(1
				(gSwatInterface showHandAni: 3)
			)
			(2
				(gSwatInterface showHandAni: 3)
			)
			(3
				(roomTimer setReal: 1 roomTimer 10)
				(self dispose:)
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
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
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
				(switch (localproc_0)
					(3
						(gGame handsOff: showCloseUp: 40604 180 70 self 1)
					)
					(2
						(gGame handsOff: showCloseUp: 40604 180 70 self 1)
					)
					(else
						(proc4_5)
						(proc4_6 40602 203 49 0 0 200 1)
					)
				)
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

(instance shootRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
				)
				(proc4_5)
				(gGame handsOff: showCloseUp: 40604 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
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
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
				)
				(Lock rsAUDIO 40104 0)
				(proc4_5)
				(gGame handsOff: showCloseUp: 40521 180 70 self 1)
			)
			(1
				(gBackMusic number: 40109 loop: 1 play: self)
				(gMessager say: 0 8 3 1) ; "Cease fire! Status! Cease fire!"
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

(instance carmichaelShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
				)
				(Lock rsAUDIO 40104 0)
				(proc4_5)
				(gGame handsOff: showCloseUp: 40517 180 70 self 1)
			)
			(1
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40104)
				(gMessager say: 0 8 2 1) ; "Cease fire! Cease fire!"
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

(instance lucysDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(deadLucy setPri: 1 init:)
				(pacmeyer setPri: 500 init: setCycle: End self)
				(proc4_6 40600 347 58 0 0 -1 1 0)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40104)
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

(instance getOutaThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
				)
				(proc4_5)
				(gGame handsOff: showCloseUp: 40607 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance deadLucy of View
	(properties
		x 372
		y 276
		view 40600
	)
)

(instance pacmeyer of Prop
	(properties
		x -14
		y 245
		view 40605
	)
)

(instance flashBang of Prop
	(properties
		x 382
		y 414
		view 40604
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1 &rest))
			(cond
				((and (< (global112 curColIdx:) 3) (< (param1 x:) 280))
					(= local1 1)
				)
				(
					(and
						(< (global112 curColIdx:) 3)
						(> (param1 x:) 355)
						(< (Robot 11) 45) ; FrameNum
					)
					(= local2 1)
				)
				(
					(and
						(< (global112 curColIdx:) 3)
						(> (param1 x:) 480)
						(> (Robot 11) 44) ; FrameNum
					)
					(= local2 1)
				)
				((> (global112 curColIdx:) 2)
					(= local1 1)
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
						(gCurRoom setScript: pacmeyerShot)
					)
					(local2
						(gCurRoom setScript: carmichaelShot)
					)
					(else
						(gCurRoom doVerb: theVerb)
					)
				)
			)
			(6
				(cond
					(local1
						(gCurRoom setScript: pacmeyerShot)
					)
					(local2
						(gCurRoom setScript: carmichaelShot)
					)
					(else
						(gCurRoom doVerb: theVerb)
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

(instance eastE of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 4080) ; s1_4080
	)
)

(instance westE of HotSpot
	(properties
		nsRight 40
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 4070) ; s1_4070
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
		(gCurRoom newRoom: 4070) ; s1_4070
	)
)

(instance roomTimer of Timer
	(properties)

	(method (doit)
		(if (not (gTalkers size:))
			(super doit:)
		)
	)

	(method (cue)
		(switch local0
			(1
				(gMessager say: 0 0 1 1) ; "Pup! Cover right!"
				(self setReal: 2 self 5)
			)
			(2
				(gMessager say: 0 0 1 1) ; "Pup! Cover right!"
				(self setReal: 3 self 5)
			)
			(3
				(gMessager say: 0 0 1 1) ; "Pup! Cover right!"
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

(instance globalTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: getOutaThere)
	)
)

