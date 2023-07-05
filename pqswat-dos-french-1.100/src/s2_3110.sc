;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3110)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s2_3110 0
)

(local
	local0 = 1
	local1
	local2
	local3
	local4 = -3
	local5 = 101
	local6
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (and gAutoRobot (or (not argc) param1))
		(= local2 (Robot 11)) ; FrameNum
		(proc4_5)
		(WalkieTalkie showFrame: local3 local2 local4 local5)
		(= global128 local3)
	)
	(if (and argc (not param1))
		(proc4_6 global128 local4 local5 param2 0 500 1)
	)
)

(instance s2_3110 of PQRoom
	(properties
		picture 3110
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(westE init:)
		(furnitures init:)
		(door init:)
		(if (== global108 5)
			(eastEPlot2 init:)
		)
		(robotFeat init:)
		(cond
			((== gPrevRoomNum 3160) ; s2_3160
				(self setScript: egoLiesDead)
			)
			((and (OneOf gPrevRoomNum 3080 3100) (global112 flashBanged:)) ; s2_3080, s2_3100
				(if (IsFlag 220)
					(self setScript: sFurnitureCleared)
				else
					(self setScript: sFurnNotCleared)
				)
			)
			(else
				(gGame handsOn:)
				(if
					(and
						(== global108 4)
						(== (global112 criticalRoom:) gCurRoomNum)
					)
					(self setScript: sCriticalPath1Script)
				)
				(if
					(and
						(== global108 5)
						(== (global112 criticalRoom:) gCurRoomNum)
					)
					(self setScript: sCriticalPath2Script)
				)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(6
				(if local0
					(= local0 0)
					(gMessager say: 6 6 7) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gCurRoom setScript: sShootAtRoom)
				)
			)
			(10
				(if local0
					(= local0 0)
					(gMessager say: 6 6 7) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gCurRoom setScript: sShootAtRoom)
				)
			)
			(16
				(gCurRoom setScript: sFlashBang)
			)
			(else
				(if (OneOf theVerb 43 47 44 45 46 42 49 48)
					(= temp0 (= temp1 -1))
					(if gAutoRobot
						(= temp0 (Robot 11)) ; FrameNum
					)
					(cond
						((> (global112 curColIdx:) 13) 0)
						((OneOf theVerb 43 42 48)
							(cond
								((< (global112 curColIdx:) 13)
									(switch theVerb
										(42
											(gMessager say: 0 theVerb 12 0) ; "What do you see?"
										)
										(43
											(gMessager say: 0 theVerb 12 0) ; "What is it?"
										)
										(48)
									)
								)
								((== (global112 curColIdx:) 13)
									(switch theVerb
										(42
											(gMessager say: 0 theVerb 18 0) ; "What is it, pup?"
										)
										(43
											(gMessager say: 0 theVerb 18 0) ; "What is it, pup?"
										)
										(48)
									)
								)
								(else 0)
							)
							(return)
						)
						((< (global112 curColIdx:) 13)
							(= temp1 12)
						)
						(
							(and
								(== global108 5)
								(OneOf theVerb 47 44 45 46 49)
							)
							(if (== (global112 curColIdx:) 13)
								(= temp1 23)
							)
						)
						((and (== (global112 curColIdx:) 13) (<= 642 temp0 675))
							(= temp1 11)
						)
					)
					(if (!= temp1 -1)
						(gMessager say: 0 theVerb temp1 0)
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(if (gTimers contains: flashBangTimer)
			(flashBangTimer dispose: delete:)
		)
		(if global112
			(global112 pausePath: 0)
		)
		(ClearFlag 220)
		(proc4_5)
		(super dispose:)
	)
)

(instance egoLiesDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 31105 loop: 0 cel: 0 posn: 31 255 init:)
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(1
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance sCriticalPath1Script of Script
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
				(Load rsVIEW 59)
				(= local3 31100)
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(9
									(global112 getPercent: 0 54)
								)
								(10
									(global112 getPercent: 55 535)
								)
								(11
									(global112 getPercent: 536 553)
								)
								(12
									(global112 getPercent: 554 570)
								)
								(13
									(global112 getPercent: 571 858)
								)
								(else -1)
							)
						)
						-1
					)
					(proc4_6 31100 local4 local5 temp0 0 500 1)
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
						(gMessager say: 0 0 27 1 self) ; "Carmichael - move up to door, mirror it and see if it's clear."
					)
					(2
						(localproc_0)
						(= scratch 3)
						(global112 pausePath: 1)
						(if (not (gTalkers size:))
							(= cycles 2)
						)
					)
					(3
						(global112 pausePath: 0)
						(localproc_0 0 55)
					)
					(4
						(gSwatInterface showHandAni: 6)
					)
					(5
						(gSwatInterface showHandAni: 4)
					)
					(6
						(while (<= (global112 curColIdx:) 13)
							(global112 endColumn:)
						)
					)
				)
			)
			(2
				(proc4_5)
				(gGame handsOn:)
				(= seconds 8)
			)
			(3
				(global112 pausePath: 1)
				(self setScript: pupWhereAreYou self)
			)
			(4
				(global112 pausePath: 0)
				(= seconds 8)
			)
			(5
				(gGame handsOff:)
				(self setScript: timeExpiredPlot1)
			)
		)
	)
)

(instance sCriticalPath2Script of Script
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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsVIEW 6)
				(global112 leftEarly: 1)
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(12
									(global112 getPercent: 0 405)
								)
								(13
									(global112 getPercent: 397 633)
								)
								(else -1)
							)
						)
						-1
					)
					(= local4 -17)
					(= local5 108)
					(proc4_6 31108 local4 108 temp0 0 -1 1)
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
						(self setScript: plot2AssocScript)
					)
					(2
						(global112 pausePath: 1)
						(proc4_5)
						(= global128 31108)
						(WalkieTalkie showFrame: 31108 131 local4 local5)
					)
					(3
						(global112 pausePath: 0)
						(proc4_5)
						(proc4_6 31108 local4 local5 132 0 -1 1)
					)
					(4
						(gGame handsOff:)
						(self setScript: flashView)
						(global112 leftEarly: 0)
						(SetFlag 249)
					)
					(5
						(gGame handsOn:)
						(global112 pausePath: 1)
						(while (<= (global112 curColIdx:) 13)
							(global112 endColumn:)
						)
					)
				)
			)
			(2
				(proc4_5)
				(= seconds 6)
			)
			(3
				(gCurRoom setScript: timeExpiredPlot1)
			)
		)
	)
)

(instance plot2AssocScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gFxSound number: 2991 loop: 1 play:)
				(= seconds 2)
			)
			(1
				(gMessager sayRange: 0 0 20 2 3 self) ; "Yeaaa!"
			)
			(2
				(gFxSound number: 2992 loop: 1 play:)
				(= seconds 3)
			)
			(3
				(client cue: 3)
				(self dispose:)
			)
		)
	)
)

(instance flashView of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
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
			(1
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(= cycles 2)
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
				(self dispose:)
			)
		)
	)
)

(instance pupWhereAreYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 3 0 self) ; "Pup! Where are you?""
			)
			(1
				(= cycles 2)
			)
			(2
				(global112 pausePath: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance timeExpiredPlot1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global112 stopPath:)
				(proc4_6 31107 29 130 0 0 -1 1)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(SetFlag 98)
				(SetFlag 94)
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
				(if local6
					(gMessager say: 1 10 0 0 self) ; "Cease fire! Cease fire!"
				else
					(gMessager say: 2 10 0 0 self) ; "Cease fire! Cease fire!"
				)
			)
			(2
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sFurnitureCleared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 31102 -2 119 0 0 -1 1)
			)
			(1
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sFurnNotCleared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hector init: setCycle: End)
				(swatGuys init: setCycle: End)
				(gMessager say: 0 0 26 0 self) ; "Hold it! Keep your hands in the air and turn away from me."
			)
			(1
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sShootAtRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if gAutoRobot
					(gAutoRobot pause: 1)
				)
				(gMessager say: 6 6 8 0 self) ; "Hold your fire!! Two trailers! Now! Officer coming out!"
			)
			(1
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
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
					view: 31103
					loop: 0
					cel: 0
					posn: 168 266
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
				(if (not (IsFlag 244))
					(proc4_5)
					(WalkieTalkie showFrame: 31109 0 -12 106)
					(= global128 31109)
				)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(= cycles 2)
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
				(if (not (IsFlag 244))
					(SetFlag 244)
					(proc4_5)
					(while (<= (global112 curColIdx:) 13)
						(global112 endColumn:)
					)
					(proc4_6 31109 -12 106 0 0 -1 1)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(7
				(gGame handsOn:)
				(flashBangTimer setReal: flashBangTimer 5)
				(self dispose:)
			)
		)
	)
)

(instance element of Prop ; UNUSED
	(properties
		x 448
		y 278
		view 31100
	)
)

(instance hector of Prop
	(properties
		x 120
		y 223
		view 31110
	)
)

(instance swatGuys of Prop
	(properties
		x 152
		y 265
		view 31109
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1)) (door onMe: param1))
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(10
				(gCurRoom setScript: sOfficerShot)
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

(instance furnitures of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 195 153 197 155 199 230 311 233 345 229 413 261 473 277 639 290 637 0 494 0 494 84 350 101 348 144
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(cond
					((< (global112 curColIdx:) 13)
						(gMessager say: 0 theVerb 16 0) ; "It's been cleared..."
					)
					((== (global112 curColIdx:) 13)
						(gMessager say: 0 theVerb 14 0) ; "It's been cleared..."
					)
					(else 0)
				)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance door of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 28 58 156 61 158 233 28 245
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(cond
					((< (global112 curColIdx:) 13)
						(gMessager say: 0 theVerb 15 0) ; "I don't see anything..."
					)
					((== (global112 curColIdx:) 13)
						(gMessager say: 0 theVerb 13 0) ; "Unconfirmed..."
					)
					(else 0)
				)
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
		nsBottom 48
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3140) ; s2_3140
	)
)

(instance westE of HotSpot
	(properties
		nsRight 40
		nsBottom 360
		type 32771
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55
				(if (== global108 4)
					(if (IsFlag 244)
						(global112 slicePie: 3170)
						(gCurRoom newRoom: 3170) ; s2_3170
					else
						(gCurRoom newRoom: 3160) ; s2_3160
					)
				else
					(gCurRoom newRoom: 3160) ; s2_3160
				)
			)
			(29
				(cond
					((== global108 4)
						(if (IsFlag 244)
							(gCurRoom newRoom: 3170) ; s2_3170
						else
							(gCurRoom newRoom: 3150) ; s2_3150
						)
					)
					((IsFlag 249)
						(gCurRoom newRoom: 3150) ; s2_3150
					)
					(else
						(gCurRoom newRoom: 3160) ; s2_3160
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eastEPlot2 of HotSpot
	(properties
		nsLeft 122
		nsTop 43
		nsRight 199
		nsBottom 235
		type 8195
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55
				(global112 slicePie: 3230)
				(gCurRoom newRoom: 3230) ; s2_3230
			)
			(29
				(gCurRoom newRoom: 3220) ; s2_3220
			)
		)
	)
)

(instance flashBangTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: timeExpiredPlot1)
	)
)

(instance cannister of Prop
	(properties)
)

