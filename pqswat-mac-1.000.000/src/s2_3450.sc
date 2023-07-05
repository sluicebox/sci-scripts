;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3450)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use swatInvInit)
(use RobotDoVerb)
(use Array)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3450 0
)

(local
	local0
	local1
)

(instance s2_3450 of PQRoom
	(properties
		picture 3450
	)

	(method (init)
		(Load rsAUDIO 29807)
		(Load rsVIEW 34530 34510)
		(Load rsVIEW 34531 34503 34500 34520)
		(Load rsAUDIO 29809 29810)
		(super init: &rest)
		(if (!= (gBackMusic number:) 29807)
			(gBackMusic number: 29807 loop: -1 play:)
		)
		(robotFeat init:)
		(self setScript: endingScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gMessager say: 2 6 0) ; "Hold your fire!!"
			)
			(10
				(gMessager say: 2 10 0) ; "Hold your fire!!"
			)
			(44
				(gMessager say: 0 44 0) ; "Yes! Cover Denton!"
			)
			(49
				(gMessager say: 0 49 0) ; "Negative! Move!!"
			)
			(45
				(gMessager say: 0 49 0) ; "Negative! Move!!"
			)
			(16
				(self setScript: sDetonate)
			)
		)
	)

	(method (dispose)
		(gBackMusic fade: 0 50 5 1)
		(proc4_5)
		(if local0
			(local0 dispose:)
			(= local0 0)
		)
		(super dispose: &rest)
	)
)

(instance endingScript of Script
	(properties)

	(method (dispose)
		(gNarrator modeless: scratch)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(hector
					view: 34530
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 129 202
					init:
					setCycle: End
				)
				(wixell
					view: 34510
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: -21 426
					setPri: 360
					init:
					setCycle: CT 12 1 self
				)
			)
			(1
				(= scratch (gNarrator modeless:))
				(gNarrator modeless: 2)
				(denton
					view: 34500
					loop: 0
					cel: 0
					posn: -7 198
					cycleSpeed: 5
					init:
					setCycle: End self
				)
				(gMessager say: 0 0 1 0) ; "You! Freeze!"
			)
			(2
				(hector view: 34531)
				(denton view: 34503)
				(pacmeyer
					view: 34520
					cycleSpeed: 12
					loop: 0
					cel: 0
					posn: 306 122
					setPri: 430
					init:
				)
				(= cycles 5)
			)
			(3
				(wixell cel: 12 setCycle: End self)
			)
			(4
				(WalkieTalkie showFrame: 34540 local1 269 -18)
				(= global128 34540)
				(if (< (++ local1) 10)
					(-- state)
					(= ticks 10)
				else
					(= cycles 1)
				)
			)
			(5
				(wixell setCycle: End)
				(pacmeyer setCycle: End)
				(= cycles 1)
			)
			(6
				(gBackMusic number: 29809 play:)
				(gBackMusic2 number: 29810 loop: 0 play:)
				(= cycles 3)
			)
			(7
				(proc4_6 34540 269 -18 11 0 -1 1)
				(= ticks 60)
			)
			(8
				(self setScript: watchCursor)
			)
			(9
				(gGame handsOff:)
				(watchCursor dispose:)
			)
			(10
				(self setScript: 0)
				(gCurRoom newRoom: 3440) ; s2_3440
			)
		)
	)
)

(instance watchCursor of Script
	(properties)

	(method (init)
		(= local0 (IntArray new: 4))
		(super init: &rest)
	)

	(method (doit)
		(if (and local0 gAutoRobot)
			(gAutoRobot setNowSeen: local0)
		)
		(if (and scratch gRobotDoVerb (not (gRobotDoVerb onMe: (gUser curEvent:))))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if local0
			(local0 dispose:)
			(= local0 0)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 300)
			)
			(1
				(if
					(and
						(== (gSwatInterface curIcon:) (proc19_3 21))
						(> (((proc19_3 21) data:) roundsLeft:) 0)
					)
					(= scratch 1)
				else
					(= cycles 1)
				)
			)
			(2
				(global112 leftEarly: 1)
				(gCurRoom newRoom: 3440) ; s2_3440
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
					(denton
						(gMessager say: 1 6 0 0 self) ; "Cease fire! Cease fire!"
					)
					(wixell
						(gMessager say: 1 6 0 0 self) ; "Cease fire! Cease fire!"
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(switch register
					(pacmeyer
						(gGame showCloseUp: 9018 180 66 self)
					)
					(denton
						(gGame showCloseUp: 9019 180 66 self)
					)
					(wixell
						(gGame showCloseUp: 9014 180 66 self)
					)
				)
			)
			(2
				(SetFlag 94)
				(SetFlag 98)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sAllenShot of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(watchCursor dispose:)
				(if (<= (= temp0 (- (Robot 11) 1)) 186) ; FrameNum
					(proc4_6 34540 269 -18 186 0 -1 1)
				else
					(proc4_6 34540 269 -18 temp0 0 -1 1)
				)
			)
			(1
				(if (> temp0 415) ; UNINIT
					(self cue:)
				)
			)
			(2
				(gCurRoom newRoom: 3440) ; s2_3440
			)
		)
	)
)

(instance sHectorShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 34304 180 66 self)
			)
			(1
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #dispose)
				(gFxSound number: 3450 play: self)
			)
			(2
				(SetFlag 93)
				(SetFlag 98)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sDetonate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 1002 34502 6)
				(Load rsAUDIO 1002 35)
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(cannister init: setCycle: End self)
			)
			(2
				(whiteScreen init:)
				(gFxSound number: 1002 loop: 0 play:)
				(hector posn: 78 239 view: 34501)
				(WalkieTalkie showFrame: 34501 0 -21 78)
				(if (gCast contains: wixell)
					(wixell dispose:)
				)
				(if (gCast contains: denton)
					(denton dispose:)
				)
				(if (gCast contains: pacmeyer)
					(pacmeyer dispose:)
				)
				(cannister dispose:)
				(= cycles 2)
			)
			(3
				(whiteScreen dispose:)
				(Palette 2 42 254 1000) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(4
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(5
				(Palette 2 42 254 200) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(6
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(7
				(proc4_6 34501 30 98 0 0 -1 1)
			)
			(8
				(proc4_5)
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #dispose)
				(gFxSound number: 35 loop: 0 play: self)
			)
			(9
				(gFxSound number: 35 loop: 0 play: self)
			)
			(10
				(gFxSound number: 35 loop: 0 play: self)
			)
			(11
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance whiteScreen of View
	(properties
		x 289
		y 179
		priority 500
		fixPriority 1
		view 6
	)
)

(instance denton of Prop
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
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance wixell of Prop
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
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance hector of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sHectorShot)
			)
			(10
				(gCurRoom setScript: sHectorShot)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
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
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sAllenShot)
			)
			(10
				(gCurRoom setScript: sAllenShot)
			)
			(180
				(super doVerb: theVerb)
			)
			(179
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance cannister of Prop
	(properties
		x 5
		y 223
		view 34502
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (doit)
		(if (> cel 12)
			(self setPri: -1)
		)
		(super doit:)
	)
)

