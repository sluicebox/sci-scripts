;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3100)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3100 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if gAutoRobot
		(= temp0 (Robot 11)) ; FrameNum
		(= temp1 global128)
		(proc4_5)
		(WalkieTalkie showFrame: temp1 temp0 0 60)
		(= global128 temp1)
	)
)

(instance s2_3100 of PQRoom
	(properties
		picture 3100
	)

	(method (init)
		(super init: &rest)
		(eastE init:)
		(southE init:)
		(westE init:)
		(robotFeat init:)
		(cond
			((< (global112 curColIdx:) 9)
				(global112 pausePath: 1)
				(self setScript: sBeforeCleared)
			)
			((IsFlag 220)
				(global112 pausePath: 1)
				(self setScript: sAfterCleared)
			)
			(else
				(gGame handsOn:)
				(if (== (global112 criticalRoom:) gCurRoomNum)
					(self setScript: sCriticalPathScript)
				)
			)
		)
	)

	(method (criticalAlert)
		(if (and (not script) (== (global112 curColIdx:) 11))
			(gCurRoom setScript: sCriticalPathScript)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gMessager say: 3 theVerb) ; "Hold your fire!! Be alert!"
			)
			(10
				(gMessager say: 3 theVerb) ; "Hold your fire!! Be alert!"
			)
			(16
				(self setScript: sFlashBang)
			)
			(43
				(gMessager say: 0 theVerb 1) ; "What is it?"
			)
			(47
				(if local0
					(gMessager say: 0 theVerb 1) ; "Looks good..."
				)
			)
			(44
				(if local0
					(gMessager say: 0 theVerb 1) ; "Affirmative. Cover me and Wixell..."
				)
			)
			(45
				(if local0
					(gMessager say: 0 theVerb 1) ; "Negative. Cover right!"
				)
			)
			(46
				(if local0
					(gMessager say: 0 theVerb 1) ; "Calm down, pup."
				)
			)
			(42
				(if local0
					(gMessager say: 0 theVerb 1) ; "What do you see?"
				)
			)
			(49
				(if local0
					(gMessager say: 0 theVerb 1) ; "Negative. Cover..."
				)
			)
			(48
				(if local0
					(gMessager say: 0 theVerb 1) ; "Area in control... It's been cleared."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(if global112
			(global112 pausePath: 0)
		)
		(super dispose:)
	)
)

(instance sCriticalPathScript of Script
	(properties)

	(method (cue param1 &tmp temp0)
		(= temp0 0)
		(if argc
			(= temp0 param1)
			(if (== argc 1)
				(= scratch param1)
			)
		)
		(super cue: temp0 &rest)
	)

	(method (dispose)
		(if gAutoRobot
			(gAutoRobot caller: 0)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(>
						(= temp0
							(switch (global112 curColIdx:)
								(11
									(global112 getPercent: 0 263)
								)
								(12
									(global112 getPercent: 264 509)
								)
								(else -1)
							)
						)
						146
					)
					(= local0 1)
				)
				(if (!= temp0 -1)
					(proc4_6 31000 0 60 temp0 0 -1 1)
				else
					(self dispose:)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 1)
					)
					(1
						(= local0 1)
						(gMessager say: 0 0 3 2) ; "Looks clear."
					)
					(2
						(localproc_0)
						(++ scratch)
						(global112 pausePath: 1)
						(gMessager say: 0 0 3 3 self) ; "Ready to move. Go!"
					)
					(3
						(proc4_5)
						(global112 pausePath: 0)
						(proc4_6 31000 0 60 175 0 -1 1)
					)
					(4
						(gSwatInterface showHandAni: 3)
					)
					(5
						(localproc_0)
						(++ scratch)
						(global112 pausePath: 1)
						(gMessager say: 0 0 3 1 self) ; "Ready to clear. Go!"
					)
					(6
						(proc4_5)
						(global112 pausePath: 0)
						(proc4_6 31000 0 60 450 0 -1 1)
					)
					(7
						(SetFlag 220)
						(gMessager say: 0 0 3 2) ; "Looks clear."
					)
					(8
						(++ state)
						(localproc_0)
						(= cycles 1)
					)
				)
			)
			(2
				(gCurRoom setScript: sAfterCleared)
			)
		)
	)
)

(instance sAfterCleared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== global108 5)
					(while (< (global112 curColIdx:) 13)
						(global112 endColumn:)
					)
					(gMessager say: 0 0 4 0 self) ; "Can you hear me out there."
				)
				(= cycles 4)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(if (== global108 4)
					(gFxSound number: 2993 loop: 0 play: self)
				)
			)
			(2
				(if (== global108 4)
					(global112 threwFlash: 3110)
				)
				(gCurRoom newRoom: 3110) ; s2_3110
			)
		)
	)
)

(instance sBeforeCleared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(gFxSound number: 2993 loop: 0 play: self)
			)
			(2
				(gCurRoom newRoom: 3080) ; s2_3080
			)
		)
	)
)

(instance sFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6)
				(cannister
					view: 31000
					loop: 0
					cel: 0
					posn: 214 153
					init:
					setCycle: End self
				)
			)
			(1
				(gFxSound number: 1002 loop: 1 play:)
				(cannister
					view: 6
					loop: 0
					cel: 0
					posn: 289 179
					setPri: 600
					init:
				)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(gMessager say: 0 16 0 0 self) ; "Status! Status!"
			)
			(7
				(= cycles 2)
			)
			(8
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sOfficerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 9012 -1 -1 self 1)
			)
			(1
				(gMessager say: 1 10 0 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				(SetFlag 100)
				(SetFlag 94)
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
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

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom newRoom: 3110) ; s2_3110
			)
			(else
				(super doVerb: theVerb)
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

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom newRoom: 3110) ; s2_3110
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom newRoom: 3070) ; s2_3070
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cannister of Prop
	(properties)
)

