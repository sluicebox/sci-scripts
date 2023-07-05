;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3030)
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
	s2_3030 0
)

(local
	local0 = 1
	local1
)

(instance s2_3030 of PQRoom
	(properties
		picture 3030
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 6)
		((ScriptID 4054 0) changeMusic: 29804) ; kiplandRegion
		(SetFlag 126)
		(northE init:)
		(eastE init:)
		(robotFeat init:)
		(robotFeat init:)
		(furniture init:)
		(farFurniture init:)
		(gCurRoom setScript: sOpeningSeq)
	)

	(method (newRoom)
		(global112 pausePath: 0)
		(ClearFlag 222)
		(super newRoom: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(if local0
					(= local0 0)
					(gMessager say: 6 6 3 0 self) ; "Hold your fire!! Compromised! Be alert!"
				else
					(gCurRoom setScript: sShootAtRoom)
				)
			)
			(10
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
			(45
				(if local1
					(gMessager say: 0 45 5) ; "Move up, pup!"
				)
			)
			(44
				(if local1
					(gMessager say: 0 44 5) ; "Cover me and Wixell."
				)
			)
			(46
				(if local1
					(gMessager say: 0 46 5) ; "Calm down, pup..."
				)
			)
			(48
				(if local1
					(gMessager say: 0 48 7) ; "Unknown threat... Everyone stay calm..."
				)
			)
			(43
				(if local1
					(gMessager say: 0 43 8) ; "What?"
				)
			)
			(42
				(if local1
					(gMessager say: 0 42 8) ; "What?"
				)
			)
			(47
				(if local1
					(gMessager say: 0 47 8) ; "GO!"
				)
			)
			(49
				(if local1
					(gMessager say: 0 49 8) ; "Move!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5 0)
		(if global112
			(global112 pausePath: 0)
		)
		(super dispose:)
	)
)

(instance sOpeningSeq of Script
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
				(Load rsVIEW 30305)
				(Load rsVIEW 30306)
				(Load rsVIEW 30309)
				(if (== global108 4)
					(global112 startPath: 80 3030)
				else
					(global112 startPath: 81 3030)
				)
				(gGame handsOn:)
				(if (IsFlag 222)
					(= temp0 310)
					(global112 curRoomFrames: 67)
					(pacmeyer cel: 67)
				else
					(= temp0 0)
					(pacmeyer cel: 0)
				)
				(pacmeyer init: setCycle: End)
				(proc4_6 30301 225 78 temp0 0 -1 1)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 2)
					)
					(1
						(gSwatInterface showHandAni: 6)
					)
				)
			)
			(2
				(= scratch 0)
				(proc4_6 30304 225 78 0 0 -1 1)
			)
			(3
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 2)
					)
					(1
						(gSwatInterface showHandAni: 6)
					)
					(2
						(pacmeyer setScript: movePacUp)
						(while (<= (global112 curColIdx:) 8)
							(global112 endColumn:)
						)
					)
				)
			)
			(4
				(proc4_5)
				(rhea
					posn: 258 234
					view: 30305
					loop: 0
					cel: 0
					setPri: 100
					init:
				)
				(global112 pausePath: 1)
				(= cycles 1)
			)
			(5
				(if (pacmeyer script:)
					(-- state)
				)
				(= cycles 2)
			)
			(6
				(pacmeyer dispose:)
				(proc4_6 30307 -1 116 0 0 -1 1)
			)
			(7
				(proc4_5)
				(eastE dispose:)
				(if (== global108 5)
					(global112 stopPath:)
					(pacmeyer
						view: 30307
						loop: 0
						cel: 1
						posn: 29 138
						setPri: 600
						init:
					)
					(wixell
						view: 30307
						loop: 0
						cel: 0
						posn: 29 138
						setPri: 600
						init:
					)
					(gCurRoom setScript: timeExpiredPlot2)
				else
					(= global128 30307)
					(WalkieTalkie showFrame: 30307 12 -1 116)
					(gMessager say: 0 0 1 1 self 3480) ; "Carmichael - move up to door, mirror it and see if it's clear."
				)
			)
			(8
				(rhea setCycle: End self)
				(global112 pausePath: 0)
			)
			(9
				(rhea dispose:)
				(global112 pausePath: 1)
				(while (<= (global112 curColIdx:) 10)
					(global112 endColumn:)
				)
				(gMessager say: 0 0 1 2 self 3480) ; "Looks clear."
			)
			(10
				(proc4_5)
				(global112 pausePath: 0)
				(proc4_6 30307 -1 116 13 0 -1 1)
			)
			(11
				(= local1 1)
				(global112 pausePath: 1)
				(proc4_5)
				(= global128 30307)
				(WalkieTalkie showFrame: 30307 20 -1 116)
				(gMessager say: 0 0 1 3 self 3480) ; "Pup, move up!"
			)
			(12
				(proc4_5)
				(global112 pausePath: 0)
				(proc4_6 30307 -1 116 21 0 -1 1)
			)
			(13
				(gSwatInterface showHandAni: 3)
			)
			(14
				(= local1 0)
				(global112 pausePath: 1)
				(proc4_5)
				(= global128 30307)
				(WalkieTalkie showFrame: 30307 74 -1 116)
				(gMessager say: 0 0 1 4 self 3480) ; "Ready to clear. Go!"
			)
			(15
				(proc4_5)
				(global112 pausePath: 0)
				(proc4_6 30307 -1 116 75 0 -1 1)
			)
			(16
				(gMessager say: 0 0 1 5 0 3480) ; "Looks clear."
			)
			(17
				(global112 pausePath: 1)
				(proc4_5)
				(= global128 30307)
				(WalkieTalkie showFrame: 30307 271 -1 116)
				(gMessager say: 0 0 1 6 self 3480) ; "Ready to move. Go!"
			)
			(18
				(proc4_5)
				(global112 pausePath: 0)
				(proc4_6 30307 -1 116 272 0 -1 1)
			)
			(19
				(global112 pausePath: 1)
				(proc4_5)
				(= global128 30307)
				(WalkieTalkie showFrame: 30307 356 -1 116)
				(gMessager say: 0 0 1 7 self 3480) ; "Ready to clear. Go!"
			)
			(20
				(proc4_5)
				(global112 pausePath: 0)
				(proc4_6 30307 -1 116 357 0 -1 1)
			)
			(21
				(proc4_5)
				(pacmeyer
					view: 30308
					loop: 0
					cel: 0
					setPri: 1
					posn: 291 301
					init:
				)
				(SetFlag 220)
				(gMessager sayRange: 0 0 1 8 9 self 3480) ; "Looks clear!"
			)
			(22
				(pacmeyer setCycle: End self)
			)
			(23
				(gGame handsOff:)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(24
				(gMessager say: 0 0 2 0 self) ; "One down!"
			)
			(25
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(proc4_6 30302 -70 45 0 0 -1 1)
			)
			(26
				(SetFlag 98)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance movePacUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pacmeyer
					view: 30306
					loop: 0
					cel: 0
					posn: 20 313
					setCycle: CT 18 1 self
				)
			)
			(1
				(= local1 1)
				(self setScript: sSelfAssocScript)
				(pacmeyer setCycle: CT 53 1 self)
			)
			(2
				(= local1 0)
				(pacmeyer setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance timeExpiredPlot2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_5)
				(Load rsAUDIO 29810)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gFxSound number: 29810 loop: 1 play:)
				(proc4_6 30303 144 84 0 0 1 1)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
			)
			(2
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(3
				(gMessager sayRange: 0 0 2 1 3 self) ; "One down!"
			)
			(4
				(= cycles 2)
			)
			(5
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sSelfAssocScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 1 0) ; "Pup!"
				(gSwatInterface showHandAni: 2 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gSwatInterface showHandAni: 3 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(self dispose:)
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
					view: 30300
					loop: 0
					cel: 0
					posn: 202 307
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
				(proc4_5)
				(= cycles 2)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(gMessager say: 0 16 0 0 self) ; "Compromised!"
			)
			(3
				(= cycles 2)
			)
			(4
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
				(gMessager say: 6 6 4 0 self) ; "Hold your fire!!"
			)
			(1
				(gCurRoom newRoom: 3010) ; s2_3010
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
				(if (== register pacmeyer)
					(gMessager say: 1 6 0 0 self) ; "Cease fire! Cease fire!"
				else
					(gMessager say: 2 6 0 0 self) ; "Cease fire! Cease fire!"
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

(instance pacmeyer of Prop
	(properties
		x -1
		y 313
		view 30309
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 self)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 self)
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

(instance wixell of Prop
	(properties)
)

(instance rhea of Prop
	(properties
		x 397
		y 286
		view 30301
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 self)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 self)
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

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 2)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 2)
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
		nsBottom 48
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3480) ; s2_3480
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 300
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 3050) ; s2_3050
	)
)

(instance furniture of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 313 218 316 190 339 181 356 180 358 157 393 142 393 112 524 116 532 158 583 168 642 163 641 236 439 263
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
						(gMessager say: 0 48 7) ; "Unknown threat... Everyone stay calm..."
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
					init: 198 189 224 157 327 155 365 156 362 192
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
						(gMessager say: 0 48 7) ; "Unknown threat... Everyone stay calm..."
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

(instance cannister of Prop
	(properties)
)

