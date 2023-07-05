;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3070)
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
	s2_3070 0
)

(local
	local0
)

(instance s2_3070 of PQRoom
	(properties
		picture 3070
	)

	(method (init)
		(super init: &rest)
		(eastE init:)
		(westE init:)
		(robotFeat init:)
		(self setScript: sCriticalPathScript)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(if (not local0)
					(= local0 1)
					(gMessager say: 6 theVerb 3 0) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gMessager say: 6 theVerb 4 0) ; "Hold your fire!!"
				)
			)
			(10
				(if (not local0)
					(= local0 1)
					(gMessager say: 6 theVerb 3 0) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gMessager say: 6 theVerb 4 0) ; "Hold your fire!!"
				)
			)
			(else
				(if (OneOf theVerb 43 47 44 45 46 42 49 48)
					(if (gCast contains: pacmeyer)
						(gMessager say: 0 theVerb 6)
					else
						(gMessager say: 0 theVerb 5)
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)

	(method (criticalAlert)
		(if (and (not script) (== (global112 curColIdx:) 10))
			(global112 endColumn:)
		)
	)
)

(instance sCriticalPathScript of Script
	(properties)

	(method (dispose)
		(if gAutoRobot
			(gAutoRobot caller: 0)
		)
		(super dispose:)
	)

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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(3)
								(4
									(global112 getPercent: 0 153)
								)
								(5
									(global112 getPercent: 154 296)
								)
								(6
									(global112 getPercent: 297 438)
								)
								(7
									(global112 getPercent: 439 603)
								)
								(8
									(self setScript: pacEntersRoom)
									(global112 getPercent: 604 672)
								)
								(9
									(pacmeyer
										view: 30710
										loop: 0
										cel: (global112 getPercent: 0 122)
										posn: 400 362
										init:
										setCycle: End pacmeyer
									)
									(if (< (pacmeyer cel:) 10)
										(gSwatInterface showHandAni: 3)
									)
									(global112 getPercent: 673 876)
								)
								(else -1)
							)
						)
						-1
					)
					(proc4_6 30700 -2 101 temp0 0 -1 1)
				else
					(gGame handsOn:)
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
						(gSwatInterface showHandAni: 6)
					)
					(2
						(gSwatInterface showHandAni: 6)
					)
					(3
						(if (not script)
							(self setScript: pacGivesOrders)
						else
							(= cycles 1)
						)
					)
				)
			)
			(2
				(if script
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(= seconds 5)
			)
			(4
				(gGame handsOff:)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(5
				(gFxSound client: 0)
				(gMessager say: 0 0 2 0 self) ; "One down!"
			)
			(6
				(pacmeyer
					view: 30703
					loop: 0
					cel: 0
					posn: 235 277
					init:
					setCycle: CT 21 1 self
				)
			)
			(7
				(SetFlag 97)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance pacEntersRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pacmeyer
					view: 30701
					loop: 0
					cel: (global112 getPercent: 0 156)
					posn: 441 219
					init:
					setCycle: CT 142 1 self
				)
			)
			(1
				(gSwatInterface showHandAni: 4)
				(pacmeyer setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance pacGivesOrders of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (pacmeyer cycler:)
					(-- state)
					(= cycles 1)
				else
					(pacmeyer
						view: 30710
						loop: 0
						cel: 0
						posn: 400 362
						init:
						setCycle: End self
					)
					(gSwatInterface showHandAni: 3)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sFlashBang of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6)
				(cannister
					view: 30704
					loop: 0
					cel: 0
					posn: 210 193
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
				(if gAutoRobot
					(= temp0 (Robot 11)) ; FrameNum
					(proc4_5)
					(WalkieTalkie showFrame: 30700 temp0 -2 101)
					(= global128 30700)
				)
				(= cycles 2)
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
				(gMessager say: 0 16 0 0 self) ; "Compromised!"
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

(instance officerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(pacmeyer
						(gGame showCloseUp: 9018 -1 -1 self 1)
					)
					(else
						(gGame showCloseUp: 9012 -1 -1 self 1)
					)
				)
			)
			(1
				(if (== register pacmeyer)
					(gMessager say: 2 10 0 0 self) ; "Cease fire! Cease fire!"
				else
					(gMessager say: 1 10 0 0 self) ; "Cease fire! Cease fire!"
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(SetFlag 100)
				(SetFlag 94)
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
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
		(gCurRoom newRoom: 3100) ; s2_3100
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3110) ; s2_3110
	)
)

(instance pacmeyer of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot 0 self)
			)
			(10
				(gCurRoom setScript: officerShot 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot 0 self)
			)
			(10
				(gCurRoom setScript: officerShot 0 self)
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

