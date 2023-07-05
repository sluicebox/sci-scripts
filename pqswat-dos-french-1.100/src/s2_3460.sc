;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3460)
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
	s2_3460 0
)

(instance s2_3460 of PQRoom
	(properties
		picture 3460
	)

	(method (init)
		(Load rsAUDIO 29807)
		(super init: &rest)
		(if (!= (gBackMusic number:) 29807)
			(gBackMusic number: 29807 loop: -1 play:)
		)
		(westE init:)
		(robotFeat init:)
		(self setScript: enterRoom)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 3450) ; s2_3450
			(gBackMusic fade: 0 50 3 1)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(global112 threwFlash: 3460)
				(gCurRoom setScript: flashRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance enterRoom of Script
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(WalkieTalkie showFrame: 34600 0 0 99)
				(= ticks 1)
			)
			(1
				(WalkieTalkie killRobot:)
				(proc4_6 34600 0 99 0 0 -1 1)
			)
			(2
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(self cue:)
					)
					(1
						(self setScript: doHandSigs)
					)
					(2
						(proc4_5)
						(denton init:)
						(wixell init:)
						(pacmeyer init:)
						(gGame handsOn:)
						(= scratch 3)
						(= seconds 5)
					)
					(3
						(gGame handsOff:)
						(proc4_5)
						(denton dispose:)
						(wixell dispose:)
						(pacmeyer dispose:)
						(proc4_6 34600 0 99 77 0 -1 1)
					)
					(4
						(Palette 2 42 254 0) ; PalIntensity
						(FrameOut)
					)
				)
			)
			(3
				(SetFlag 97)
				(SetFlag 96)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance doHandSigs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSwatInterface showHandAni: 2 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gSwatInterface showHandAni: 3)
				(self dispose:)
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
				(proc4_5)
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #dispose)
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
			(1
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(flashObj
					view: 34601
					loop: 0
					cel: 0
					posn: 385 89
					setPri: 400
					init:
					setCycle: End self
				)
			)
			(1
				(gFxSound number: 1002 loop: 0 play:)
				(Palette 2 42 254 1000) ; PalIntensity
				(FrameOut)
				(flashObj dispose:)
				(= cycles 2)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(Palette 2 42 254 200) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(4
				(proc4_5)
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #dispose)
				(gFxSound number: 44 loop: 0 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 312
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3450) ; s2_3450
	)
)

(instance pacmeyer of Prop
	(properties
		x 292
		y 112
		view 34602
	)

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
	(properties
		x 292
		y 112
		view 34602
		cel 1
	)

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

(instance denton of Prop
	(properties
		x 292
		y 112
		view 34602
		cel 2
	)

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
				(gCurRoom setScript: officerShot)
			)
			(10
				(gCurRoom setScript: officerShot)
			)
			(180
				(super doVerb: theVerb)
			)
			(179
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flashObj of Prop
	(properties)
)

