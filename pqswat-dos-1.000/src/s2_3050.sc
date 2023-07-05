;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3050)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	s2_3050 0
)

(local
	local0
	local1 = 1
	local2 = 1
)

(procedure (localproc_0 &tmp temp0)
	(if gAutoRobot
		(= temp0 (- (Robot 11) 1)) ; FrameNum
		(proc4_5)
		(WalkieTalkie showFrame: 30500 temp0 56 102)
		(= global128 30500)
	)
)

(instance s2_3050 of PQRoom
	(properties
		picture 3050
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(westE init:)
		(robotFeat init:)
		(self setScript: sCriticalPathScript)
		(gGame handsOn:)
	)

	(method (dispose)
		(proc4_5)
		(if global112
			(global112 pausePath: 0)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(if local1
					(= local1 0)
					(gMessager say: 4 theVerb 4 0 self) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gMessager say: 4 theVerb 5 0 self) ; "Hold your fire!!"
				)
			)
			(10
				(if local2
					(= local2 0)
					(gMessager say: 4 6 4) ; "Hold your fire!! Compromised! Be alert!"
				else
					(self setScript: sSecondShot)
				)
			)
			(16
				(gCurRoom setScript: sFlashBang)
			)
			(else
				(if (and local0 (OneOf theVerb 45 44 46 48 43 42 47 49))
					(gMessager say: 0 theVerb 6 0)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance sSecondShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 10 5 0 self) ; "Hold your fire!!"
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(2
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(2
									(global112 getPercent: 0 10)
								)
								(3
									(global112 getPercent: 11 66)
								)
								(4
									(global112 getPercent: 67 236)
								)
								(5
									(global112 getPercent: 237 369)
								)
								(6
									(global112 getPercent: 370 504)
								)
								(7
									(global112 getPercent: 505 633)
								)
								(8
									(global112 getPercent: 634 702)
								)
								(9
									(global112 getPercent: 703 1015)
								)
								(else -1)
							)
						)
						-1
					)
					(proc4_6 30500 56 102 temp0 0 -1 1)
				else
					(self dispose:)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 2)
					)
					(1
						(= local0 1)
					)
					(2
						(gSwatInterface showHandAni: 6)
						(gMessager say: 0 0 1 1) ; "Entry team in position."
					)
					(3
						(= local0 0)
					)
					(4
						(gMessager say: 0 0 2 1) ; "Pup? Where's my coverage? Move it!"
					)
					(5
						(= local0 1)
					)
					(6
						(gSwatInterface showHandAni: 6)
					)
					(7
						(= local0 0)
					)
					(8
						(while (<= (global112 curColIdx:) 8)
							(global112 endColumn:)
						)
					)
					(9
						(gGame handsOff:)
						(gunShotSound number: 2991 loop: 0 play:)
					)
					(10
						(global112 pausePath: 1)
						(localproc_0)
						(++ state)
						(gMessager say: 0 0 3 1 self) ; "I see the shooter. Lets go!"
					)
				)
			)
			(2
				(proc4_5)
				(proc4_6 30500 56 102 965 0 -1 1)
			)
			(3
				(proc4_5)
				(gMessager sayRange: 0 0 3 2 4 self) ; "Status!"
			)
			(4
				(= cycles 2)
			)
			(5
				(emtTeam
					view: 30501
					loop: 0
					cel: 0
					posn: 73 113
					setPri: 500
					init:
					setCycle: End self
				)
			)
			(6
				(SetFlag 97)
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
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
				(cannister posn: 134 256 init: setCycle: End self)
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
				(localproc_0)
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
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(patAllen
					view: 30502
					loop: 0
					cel: 0
					posn: 279 196
					init:
					setCycle: CT 7 1 self
				)
			)
			(6
				(gunShotSound number: 35 loop: 1 play:)
				(patAllen setCycle: CT 10 1 self)
			)
			(7
				(gunShotSound number: 35 loop: 1 play:)
				(patAllen setCycle: CT 13 1 self)
			)
			(8
				(gMessager say: 0 16 0 0 self) ; "Compromised!"
				(gunShotSound number: 35 loop: 1 play:)
				(patAllen setCycle: CT 15 1 self)
			)
			(9
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gunShotSound number: 35 loop: 1 play:)
				(patAllen setCycle: CT 18 1 self)
			)
			(10
				(gunShotSound number: 35 loop: 1 play:)
				(patAllen setCycle: CT 24 1 self)
			)
			(11
				(gunShotSound number: 35 loop: 1 play:)
				(patAllen setCycle: End self)
			)
			(12
				(gunShotSound number: 2993 loop: 1 play: self)
			)
			(13
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
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance element of Prop ; UNUSED
	(properties
		x 107
		y 380
		view 30500
	)
)

(instance cannister of Prop
	(properties
		x 301
		y 365
		view 30503
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

(instance patAllen of Prop
	(properties)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3130) ; s2_3130
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 116
		nsTop 69
		nsRight 327
		nsBottom 236
		type 8194
	)

	(method (doVerb)
		(gCurRoom newRoom: 3080) ; s2_3080
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

(instance gunShotSound of Sound
	(properties)
)

(instance emtTeam of Prop
	(properties)
)

(instance furniture of Feature ; UNUSED
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 178 254 188 234 175 223 181 208 201 206 209 192 237 189 234 157 260 149 260 141 287 141 288 133 312 131 313 90 321 87 450 99 451 113 476 111 525 119 525 157 579 157 614 204 606 236 587 247 587 268 521 308 521 320 500 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(if (and local0 (< (global112 curColIdx:) 8))
					(gMessager say: 0 48 7) ; "It's been cleared..."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance farFurniture of Feature ; UNUSED
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: -1 200 -1 151 37 152 130 151 133 161 147 161 150 150 178 159 206 183 204 194 117 202 55 203
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(if local0
					(gMessager say: 0 48 8) ; "Unknown threat... Everyone stay calm..."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

