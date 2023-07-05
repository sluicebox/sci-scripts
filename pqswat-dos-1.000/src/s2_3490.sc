;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3490)
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
	s2_3490 0
)

(local
	local0
	local1 = 1
	local2 = 1
)

(instance s2_3490 of PQRoom
	(properties
		picture 3490
	)

	(method (init)
		(super init: &rest)
		((ScriptID 4054 0) changeMusic: 29804) ; kiplandRegion
		(SetFlag 126)
		(northE init:)
		(westE init:)
		(robotFeat init:)
		(furniture init:)
		(farFurniture init:)
		(self setScript: sEntry)
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
			(10
				(if local2
					(= local2 0)
					(gMessager say: 4 theVerb 4) ; "Hold your fire!! Compromised! Be alert!"
				else
					(self setScript: shootTheRoom 0 theVerb)
				)
			)
			(6
				(if local1
					(= local1 0)
					(gMessager say: 4 theVerb 4) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gMessager say: 4 theVerb 5) ; "Hold your fire!"
				)
			)
			(16
				(self setScript: sFlashBang)
			)
			(else
				(if (and local0 (OneOf theVerb 43 47 44 45 46 42 49 48))
					(gMessager say: 0 theVerb 7)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance shootTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 register 5 0 self)
			)
			(1
				(gCurRoom setScript: patExitsAndKillsEgo)
			)
		)
	)
)

(instance sFlashBang of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6)
				(cannister
					view: 34903
					loop: 0
					cel: 0
					posn: 332 206
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
					(= global128 34900)
					(WalkieTalkie showFrame: 34900 temp0 16 114)
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
				(gMessager say: 0 16 0 0 self) ; "Compromised!"
			)
			(6
				(gCurRoom setScript: patExitsAndKillsEgo)
			)
		)
	)
)

(instance patExitsAndKillsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 2991)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(allen
					view: 34902
					loop: 0
					cel: 0
					posn: -27 142
					init:
					setCycle: CT 13 1 self
				)
			)
			(1
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 18 1 self)
			)
			(2
				(gFxSound play:)
				(allen setCycle: CT 23 1 self)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound play:)
				(allen setCycle: CT 25 1 self)
			)
			(4
				(gFxSound play:)
				(allen setCycle: CT 28 1 self)
			)
			(5
				(gFxSound play:)
				(allen setCycle: CT 31 1 self)
			)
			(6
				(allen dispose:)
				(gFxSound play: self)
			)
			(7
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(8
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(9
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance sEntry of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (== global108 4)
					(global112 startPath: 80 3490)
				else
					(global112 startPath: 81 3490)
				)
				(= temp0 0)
				(if (IsFlag 222)
					(global112 curRoomFrames: 100)
					(= temp0 100)
				)
				(proc4_6 34900 16 114 temp0 0 600 1)
				(gGame handsOn:)
			)
			(1
				(= local0 1)
			)
			(2
				(gSwatInterface showHandAni: 6)
				(gMessager say: 0 0 1 1 self) ; "Entry team in position."
			)
			(3
				(gMessager say: 0 0 2) ; "Pup? Where's my coverage? Move it!"
				(= local0 0)
			)
			(4
				(= local0 1)
			)
			(5
				(gSwatInterface showHandAni: 6)
			)
			(6
				(= local0 0)
			)
			(7
				(while (<= (global112 curColIdx:) 8)
					(global112 endColumn:)
				)
			)
			(8
				(global112 pausePath: 1)
				(= seconds 4)
			)
			(9
				(gGame handsOff:)
				(if (== global108 4)
					(gFxSound number: 2992 loop: 0 play: self)
				else
					(gCurRoom setScript: endPlot2)
				)
			)
			(10
				(gMessager say: 0 0 3 1 self) ; "I see the shooter! Let's go!"
			)
			(11
				(proc4_5)
				(gMessager say: 0 0 3 2) ; "Status!"
				(teamA
					view: 34906
					loop: 0
					cel: 0
					posn: 27 254
					init:
					setCycle: End self
				)
			)
			(12
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(13
				(gMessager sayRange: 0 0 3 3 4 self) ; "Denton to Twenty David - Suspect in control! Officer's coming out!"
			)
			(14
				(= cycles 2)
			)
			(15
				(SetFlag 97)
				(SetFlag 95)
				(gEgo awardMedal: 64)
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

(instance endPlot2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 2991)
				(allen
					view: 34902
					loop: 0
					cel: 0
					posn: -27 142
					init:
					setCycle: CT 13 1 self
				)
			)
			(1
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 18 1 self)
			)
			(2
				(gFxSound play:)
				(allen setCycle: CT 23 1 self)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound play:)
				(allen setCycle: CT 25 1 self)
			)
			(4
				(gFxSound play:)
				(allen setCycle: CT 28 1 self)
			)
			(5
				(gFxSound play:)
				(allen setCycle: CT 31 1 self)
			)
			(6
				(allen dispose:)
				(gFxSound play: self)
			)
			(7
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(8
				(SetFlag 97)
				(SetFlag 95)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
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
		(gCurRoom newRoom: 3050) ; s2_3050
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3480) ; s2_3480
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
			(16
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance teamA of Prop
	(properties)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1)) (furniture onMe: param1))
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

(instance allen of Prop
	(properties)
)

(instance furniture of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 84 238 91 225 81 216 88 207 104 206 109 193 131 194 132 181 138 170 156 170 157 156 169 155 168 126 296 132 301 172 349 180 358 176 389 176 409 210 408 238 343 253 221 278
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(if local0
					(gMessager say: 5 theVerb 7) ; "It's been cleared..."
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

(instance farFurniture of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 0 169 139 171 140 208 0 208
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(if local0
					(gMessager say: 6 theVerb 7) ; "Unknown threat. Everyone stay calm."
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

(instance cannister of Prop
	(properties)
)

