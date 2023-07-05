;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3250)
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
	s2_3250 0
)

(local
	local0
	local1
)

(instance s2_3250 of PQRoom
	(properties
		picture 3250
	)

	(method (init)
		(super init: &rest)
		(westE init:)
		(robotFeat init:)
		(cond
			((== global108 4)
				(gGame handsOn:)
				(if (< (global112 curColIdx:) 23)
					(self setScript: sElementNotInRoom)
				else
					(eastE init:)
					(self setScript: sElement)
				)
			)
			((IsFlag 249)
				(self setScript: egoEntersAndFallsLeft)
			)
			(else
				(self setScript: egoEntersAndTurnsLeft)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(global112 threwFlash: 3290)
				(self setScript: sFlashBang)
			)
			(6
				(if (not local0)
					(= local0 1)
					(gMessager say: 3 6 5) ; "Hold your fire!!!"
				else
					(self setScript: sSecondShot)
				)
			)
			(10
				(if (not local1)
					(= local1 1)
					(gMessager say: 3 10 5) ; "Hold your fire!!!"
				else
					(self setScript: sSecondShot)
				)
			)
			(else
				(if (OneOf theVerb 45 44 46 43 42 47 49)
					(if (== (global112 curColIdx:) 25)
						(gMessager say: 0 49 10) ; "Negative. Provide cover!"
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (criticalAlert)
		(if (and (not script) (== global108 4) (== (global112 curColIdx:) 23))
			(self setScript: sElement)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sSecondShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 6 6 0 self) ; "Compromised! Stairwell right!"
			)
			(1
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(2
				(gGame showCloseUp: 32501 -1 -1 self 1)
			)
			(3
				(SetFlag 243)
				(gCurRoom newRoom: 3290) ; s2_3290
			)
		)
	)
)

(instance sElement of Script
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
				(= temp0
					(switch (global112 curColIdx:)
						(23
							(global112 getPercent: 0 25)
						)
						(24
							(global112 getPercent: 26 194)
						)
						(25
							(global112 getPercent: 195 425)
						)
						(else 420)
					)
				)
				(proc4_6 32500 0 124 temp0 0 -1 1)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 1)
					)
					(1
						(gSwatInterface showHandAni: 3)
					)
					(2
						(gSwatInterface showHandAni: 4)
					)
					(3
						(gSwatInterface showHandAni: 3)
					)
					(4
						((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
						(gBackMusic2 number: 29810 loop: 1 play:)
					)
				)
			)
			(2
				(SetFlag 225)
				(gCurRoom newRoom: 3290) ; s2_3290
			)
		)
	)
)

(instance sElementNotInRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds 6)
			)
			(1
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(SetFlag 226)
				(while (< (global112 curColIdx:) 25)
					(global112 endColumn:)
				)
				(gMessager say: 0 0 1 0 self) ; "You on the stairwell! Lemme see your hands!"
			)
			(2
				(gCurRoom newRoom: 3290) ; s2_3290
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
				(global112 pausePath: 1 threwFlash: 3290)
				(cond
					((< (global112 curColIdx:) 23) 0)
					((< (global112 curColIdx:) 25)
						(proc4_5)
						(WalkieTalkie showFrame: 32503 0 0 126)
						(= global128 32503)
					)
					(else
						(proc4_5)
						(WalkieTalkie showFrame: 32504 0 85 130)
						(= global128 32504)
					)
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
				(cond
					((< (global112 curColIdx:) 23)
						(gMessager say: 3 10 6 0 self) ; "Compromised! Stairwell right!"
					)
					((< (global112 curColIdx:) 25)
						(proc4_6 32503 0 126 0 0 -1 1)
					)
					(else
						(proc4_6 32504 85 130 0 0 -1 1)
					)
				)
			)
			(7
				(if (< (global112 curColIdx:) 23)
					(global112 threwFlash: 3290)
					(gCurRoom newRoom: 3290) ; s2_3290
				else
					(SetFlag 98)
					(SetFlag 93)
					(gEgo awardMedal: 32)
					((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
					(gCurRoom newRoom: 35) ; metroExt
				)
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
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance egoEntersAndFallsLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(element
					view: 32515
					loop: 0
					cel: 0
					posn: -3 358
					init:
					setCycle: CT 68 1 self
				)
			)
			(1
				(gMessager say: 0 0 11 0 self) ; "Compromised!"
			)
			(2
				(gFxSound number: 2991 loop: 1 play:)
				(element setCycle: End self)
			)
			(3
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance egoEntersAndTurnsLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(element
					view: 32506
					loop: 0
					cel: 0
					posn: 367 358
					init:
					setCycle: CT 59 1 self
				)
			)
			(1
				(gFxSound number: 2992 loop: 1 play:)
				(element setCycle: End self)
			)
			(2
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance cannister of Prop
	(properties
		x 326
		y 273
		view 32502
	)
)

(instance element of Prop
	(properties
		x 320
		y 384
		view 32507
	)

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

(instance eastE of HotSpot
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 3290) ; s2_3290
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3270) ; s2_3270
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

