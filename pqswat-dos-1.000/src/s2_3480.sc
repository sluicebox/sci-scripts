;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3480)
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
	s2_3480 0
)

(local
	local0 = 1
	local1
	local2 = 1
	local3
	local4
)

(procedure (localproc_0 &tmp temp0)
	(if gAutoRobot
		(= temp0 (- (Robot 11) 1)) ; FrameNum
		(proc4_5)
		(WalkieTalkie showFrame: 34800 temp0 0 89)
		(= global128 34800)
	)
)

(instance s2_3480 of PQRoom
	(properties
		picture 3480
	)

	(method (init)
		(super init: &rest)
		(if (== global108 5)
			(Load rsAUDIO 29810)
		)
		(robotFeat init:)
		(furniture init:)
		(farFurniture init:)
		(northE init:)
		(sliceHotspot init:)
		(if (== (global112 criticalRoom:) gCurRoomNum)
			(self setScript: sCriticalPath)
		)
		(gGame handsOn:)
	)

	(method (criticalAlert)
		(if (and (not script) (== (global112 curColIdx:) 9))
			(self setScript: sCriticalPath)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if local0
					(= local0 0)
					(gMessager say: 6 6 3 0 self) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gCurRoom setScript: sShootAtRoom)
				)
			)
			(6
				(if local0
					(= local0 0)
					(gMessager say: 6 6 3 0 self) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gCurRoom setScript: sShootAtRoom)
				)
			)
			(16
				(gCurRoom setScript: sFlashBang)
			)
			(48
				(if local1
					(gMessager say: 0 theVerb 7) ; "Unknown threat... Everyone stay calm."
				)
			)
			(else
				(if (OneOf theVerb 45 44 46 43 42 47 49)
					(if local1
						(gMessager say: 0 theVerb 5)
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(if global112
			(global112 pausePath: 0)
		)
		(proc4_5)
		(super dispose:)
	)
)

(instance sCriticalPath of Script
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= scratch 0)
				(= local3 34800)
				(switch (global112 curColIdx:)
					(9
						(= local4 (global112 curRoomFrames:))
						(if (< (global112 curRoomFrames:) 80)
							(elementA
								view: 34810
								loop: 0
								posn: 640 110
								cel: (global112 getPercent: 0 75)
								cycleSpeed: 12
								init:
								setCycle: End
							)
						else
							(elementA
								view: 34811
								loop: 0
								cel: 0
								posn: 536 135
								init:
							)
						)
					)
					(10
						(elementA
							view: 34811
							loop: 0
							cel: (global112 curRoomFrames:)
							posn: 536 135
							init:
							setCycle: CT 31 1 self
						)
						(= scratch 13)
						(= local4 175)
						(WalkieTalkie showFrame: local3 175 0 89)
						(= global128 34800)
						(return)
					)
					(11
						(= local4 (global112 getPercent: 121 520))
					)
					(12
						(= local4 (global112 getPercent: 521 717))
					)
					(13
						(= local4 (global112 getPercent: 717 791))
					)
					(else
						(self dispose:)
						(return)
					)
				)
				(if local3
					(proc4_6 local3 0 89 local4 0 400 1)
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
						(if (== global108 5)
							(localproc_0)
							(gCurRoom setScript: timeExpiredPlot2)
						else
							(= scratch 2)
							(localproc_0)
							(global112 pausePath: 1)
							(gMessager say: 0 0 1 1 self) ; "Carmichael - move up to door, mirror it and see if it's clear."
						)
					)
					(2
						(= scratch 3)
						(global112 pausePath: 0)
						(if (elementA cycler:)
							(= cycles 1)
							(return)
						)
						(elementA
							view: 34811
							loop: 0
							cel: 0
							cycleSpeed: 6
							posn: 536 135
							setCycle: CT 31 1 self
						)
					)
					(3
						(= scratch 4)
						(elementA setPri: 10 setCycle: End self)
					)
					(4
						(elementA dispose:)
						(global112 pausePath: 1)
						(if (== (global112 curColIdx:) 10)
							(global112 endColumn:)
						)
						(= scratch 5)
						(gMessager sayRange: 0 0 1 2 4 self) ; "Looks clear."
					)
					(5
						(global112 pausePath: 0)
						(proc4_6 34800 0 89 176 0 400 1)
					)
					(6
						(gAutoRobot setPri: 10)
					)
					(7
						(gMessager say: 0 0 1 5) ; "Looks clear."
					)
					(8
						(localproc_0)
						(global112 pausePath: 1)
						(= scratch 9)
						(gMessager say: 0 0 1 6 self) ; "Ready to move. Go!"
					)
					(9
						(global112 pausePath: 0)
						(proc4_6 34800 0 89 432 0 10 1)
					)
					(10
						(localproc_0)
						(global112 pausePath: 1)
						(= scratch 11)
						(gMessager say: 0 0 1 7 self) ; "Ready to clear. Go!"
					)
					(11
						(global112 pausePath: 0)
						(proc4_6 34800 0 89 526 0 10 1)
					)
					(12
						(SetFlag 220)
						(gMessager say: 0 0 1 8) ; "Looks clear!"
					)
					(13
						(localproc_0)
						(global112 pausePath: 1)
						(= scratch 14)
						(gMessager say: 0 0 1 9 self) ; "Pup! ... Ready to move. Go!"
					)
					(14
						(global112 pausePath: 0)
						(proc4_6 34800 0 89 717 0 10 1)
					)
				)
			)
			(2
				(gGame handsOff:)
				(gFxSound number: 2993 loop: 0 play: self)
			)
			(3
				(gMessager say: 0 0 2 0 self) ; "One down!"
			)
			(4
				(proc4_5)
				(proc4_6 34801 241 96 0 0 -1 1)
			)
			(5
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
				(cannister
					view: 34802
					loop: 0
					cel: 0
					posn: 251 195
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
					(= register (Robot 11)) ; FrameNum
					(proc4_5)
					(WalkieTalkie showFrame: 34800 register 0 89)
					(= global128 34800)
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
				(gMessager say: 0 16 0 0) ; "Compromised!"
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(allen
					view: 34804
					loop: 0
					cel: 0
					posn: 513 231
					init:
					setCycle: CT 5 1 self
				)
			)
			(6
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 9 1 self)
			)
			(7
				(gFxSound play:)
				(allen setCycle: CT 12 1 self)
			)
			(8
				(gFxSound play:)
				(allen setCycle: CT 21 1 self)
			)
			(9
				(gFxSound play:)
				(allen setCycle: CT 25 1 self)
			)
			(10
				(gFxSound play:)
				(allen setCycle: CT 33 1 self)
			)
			(11
				(gFxSound play:)
				(allen setCycle: End self)
			)
			(12
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(13
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(14
				(= cycles 2)
			)
			(15
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(gMessager say: 6 6 4 0 self) ; "Hold your fire!! Two trailers! Now! Officer coming out!"
			)
			(1
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
				(self dispose:)
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
				(switch register
					(1
						(gGame showCloseUp: 9018 -1 -1 self 1)
					)
					(2
						(gGame showCloseUp: 9014 -1 -1 self 1)
					)
					(else
						(= register 2)
						(gGame showCloseUp: 9012 -1 -1 self 1)
					)
				)
			)
			(1
				(gMessager say: register 10 0 0 self)
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

(instance timeExpiredPlot2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 1 3 self) ; "Pup, move up!"
			)
			(1
				(= seconds 4)
			)
			(2
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(proc4_5)
				(pacmeyer
					view: 34800
					loop: 0
					cel: 0
					posn: 8 144
					setPri: 500
					init:
				)
				(allen
					view: 34804
					loop: 0
					cel: 0
					posn: 513 231
					init:
					setCycle: CT 5 1 self
				)
			)
			(3
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 9 1 self)
			)
			(4
				(gFxSound play:)
				(allen setCycle: CT 12 1 self)
			)
			(5
				(gFxSound play:)
				(allen setCycle: CT 21 1 self)
			)
			(6
				(gFxSound play:)
				(allen setCycle: CT 25 1 self)
			)
			(7
				(gFxSound play:)
				(allen setCycle: CT 33 1 self)
			)
			(8
				(gFxSound play:)
				(allen setCycle: End self)
			)
			(9
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(10
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(11
				(gFxSound client: 0)
				(gMessager sayRange: 0 0 2 1 3 self) ; "One down!"
			)
			(12
				(= cycles 2)
			)
			(13
				(SetFlag 98)
				(SetFlag 95)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance makeTeamEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(while (< (global112 curColIdx:) 9)
					(global112 endColumn:)
				)
				(self setScript: sCriticalPath)
				(= seconds 4)
			)
			(1
				(gCurRoom newRoom: 3110) ; s2_3110
			)
		)
	)
)

(instance pacmeyer of Prop
	(properties)
)

(instance allen of Prop
	(properties)
)

(instance elementA of Prop
	(properties
		x 650
		y 114
		view 34810
	)

	(method (init)
		(self setPri: 400)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 0)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 0)
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

	(method (onMe param1 &tmp temp0 temp1)
		(if (= temp0 (super onMe: param1 &rest))
			(= temp1 (/ (Abs (- nsRight nsLeft)) 2))
			(= scratch (if (> (- nsLeft (param1 x:)) temp1) 1 else 2))
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 scratch)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 scratch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance furniture of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 443 276 455 254 444 242 450 229 471 227 481 211 509 216 508 177 542 159 569 159 568 151 582 148 598 149 598 101 640 100 640 357
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(if local1
					(if (< (global112 curColIdx:) 8)
						(gMessager say: 0 48 7) ; "Unknown threat... Everyone stay calm."
					else
						(gMessager say: 0 48 6) ; "It's been cleared..."
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

(instance farFurniture of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 250 212 248 199 279 173 405 166 470 163 468 212 389 218 318 209
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(if local1
					(if (not (IsFlag 220))
						(gMessager say: 0 48 7) ; "Unknown threat... Everyone stay calm."
					else
						(gMessager say: 0 48 6) ; "It's been cleared..."
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

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(global112 pausePath: 1)
		(gCurRoom newRoom: 3130) ; s2_3130
	)
)

(instance sliceHotspot of HotSpot
	(properties
		nsLeft 341
		nsTop 102
		nsRight 605
		nsBottom 241
		type 8194
	)

	(method (doVerb)
		(if (and (not (gCurRoom script:)) (< (global112 curColIdx:) 9))
			(gCurRoom setScript: makeTeamEnter)
		else
			(gCurRoom newRoom: 3110) ; s2_3110
		)
	)
)

(instance cannister of Prop
	(properties)
)

