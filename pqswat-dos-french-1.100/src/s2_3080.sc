;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3080)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3080 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if gAutoRobot
		(= temp0 (Robot 11)) ; FrameNum
		(= temp1 global128)
		(proc4_5)
		(WalkieTalkie showFrame: temp1 temp0 0 88)
		(= global128 temp1)
	)
)

(instance s2_3080 of PQRoom
	(properties
		picture 3080
	)

	(method (init)
		(super init: &rest)
		(eastE init:)
		(westE init:)
		(furn init:)
		(robotFeat init:)
		(switch gPrevRoomNum
			(3100 ; s2_3100
				(global112 stopPath:)
				(self setScript: sOneDown)
			)
			(else
				(if (not (IsFlag 220))
					(allen
						view: 30802
						cel: 0
						loop: 0
						posn: 420 229
						init:
						setPri: 1
					)
				)
				(gGame handsOn:)
				(if (== (global112 criticalRoom:) gCurRoomNum)
					(self setScript: sCriticalPathScript)
				else
					(northE init:)
				)
			)
		)
	)

	(method (criticalAlert)
		(if (and (not script) (== (global112 curColIdx:) 12))
			(northE dispose:)
			(gCurRoom setScript: sCriticalPathScript)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gMessager say: 4 theVerb) ; "Hold your fire!! Be alert!"
			)
			(10
				(gMessager say: 4 theVerb) ; "Hold your fire!! Be alert!"
			)
			(16
				(gCurRoom setScript: sFlashBang)
			)
			(else
				(if (OneOf theVerb 43 47 44 45 46 42 49 48)
					(if local0
						(gMessager say: 0 theVerb 3 0 0)
					)
				else
					(super doVerb: theVerb)
				)
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
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(12
									(global112 getPercent: 0 287)
								)
								(else -1)
							)
						)
						-1
					)
					(proc4_6 30800 0 88 temp0 0 -1 1)
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
						(= scratch 2)
						(gSwatInterface showHandAni: 2 self)
					)
					(2
						(gSwatInterface showHandAni: 3)
					)
					(3
						(= scratch 4)
						(localproc_0)
						(global112 pausePath: 1)
						(gMessager say: 0 0 7 1 self) ; "Ready to clear, ... Go!"
					)
					(4
						(proc4_5)
						(proc4_6 30800 0 88 202 0 -1 1)
					)
					(5
						(SetFlag 220)
						(gMessager say: 0 0 7 2) ; "Looks Clear"
					)
					(6
						(if (!= global108 5)
							(gFxSound number: 2992 loop: 1 play:)
						)
					)
					(7
						(localproc_0)
						(++ state)
						(gGame handsOff:)
						(if (== global108 5)
							(while (< (global112 curColIdx:) 13)
								(global112 endColumn:)
							)
							(gMessager say: 0 0 8 0 self) ; "Can you hear me out there ."
						)
						(= cycles 1)
					)
				)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(if (== global108 4)
					(gMessager say: 0 0 1 0 self) ; "Compromised! Suspect door right!"
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(if (== global108 4)
					(global112 threwFlash: 3110)
				)
				(gCurRoom newRoom: 3110) ; s2_3110
			)
		)
	)
)

(instance sOneDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen
					view: 30801
					loop: 1
					cel: 0
					x: 432
					y: 170
					init:
					setPri: 400
				)
				(element init: setCycle: CT 65 1 self)
			)
			(1
				(gSwatInterface showHandAni: 4)
				(element setCycle: CT 92 1 self)
			)
			(2
				(gMessager say: 0 0 2 0 self) ; "Pacmeyer to Ten David - One down! Suspect in control!"
			)
			(3
				(element setCycle: End self)
			)
			(4
				(SetFlag 98)
				(SetFlag 95)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sAllenShoots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if gAutoRobot
					(gAutoRobot caller: 0)
				)
				(localproc_0)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(allen setCycle: CT 8 1 self)
			)
			(1
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 10 1 self)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 15 1 self)
			)
			(3
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 18 1 self)
			)
			(4
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 21 1 self)
			)
			(5
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: End self)
			)
			(6
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(7
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(global112 threwFlash: 3110)
				(cannister init: setCycle: End self)
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
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(= cycles 1)
			)
			(3
				(gMessager say: 0 16 0 0 self) ; "Compromised!"
			)
			(4
				(gCurRoom newRoom: 3110) ; s2_3110
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
				(SetFlag 94)
				(SetFlag 98)
				(SetFlag 100)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance element of Prop
	(properties
		x 1
		y 331
		view 30801
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance allen of Prop
	(properties
		x 432
		y 170
		view 30801
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance cannister of Prop
	(properties
		x 131
		y 345
		view 30803
	)
)

(instance furn of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 196 132 183 213 172 215 171 254 209 270 320 237 377 238 406 249 443 245 537 253 603 218 601 199 586 196 576 97 546 99 501 120 404 144 321 148 233 124
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(if (not (IsFlag 220))
					(gCurRoom setScript: sAllenShoots)
				else
					(gMessager say: 3 theVerb) ; "Hold your fire!!"
				)
			)
			(10
				(if (not (IsFlag 220))
					(gCurRoom setScript: sAllenShoots)
				else
					(gMessager say: 3 theVerb) ; "Hold your fire!!"
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
		(gCurRoom newRoom: 3090) ; s2_3090
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
		(gCurRoom newRoom: 3110) ; s2_3110
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3100) ; s2_3100
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

