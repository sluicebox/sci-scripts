;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1012)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use SoundManager)
(use RegionSFX)
(use n1111)
(use VMDMovie)
(use Feature)
(use Sound)
(use System)

(public
	hubCampLocker3 0
)

(local
	local0
)

(instance hubCampLocker3 of CloseupLocation
	(properties)

	(method (init)
		(self heading: 0)
		(cond
			((IsFlag 80)
				(if local0
					(super init: 1129)
				else
					(super init: 1127)
				)
			)
			(local0
				(super init: 1029)
			)
			(else
				(super init: 1027)
			)
		)
		(lockerHandle init:)
		(SoundManager pauseMusic: 1 10 20)
	)

	(method (newRoom)
		(if (not (OneOf curPic 1127 1027))
			(gGame handsOff:)
			(self setScript: doorClose self)
		else
			(super newRoom: &rest)
		)
	)

	(method (dispose)
		(SoundManager pauseMusic: 0 10 20)
		(= local0 0)
		(super dispose: &rest)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
			(= local0 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
		)
	)
)

(instance lockerHandle of Feature
	(properties
		nsBottom 239
		nsLeft 295
		nsRight 431
		nsTop 167
	)

	(method (init)
		(if (and (not local0) (IsFlag 82))
			(super init:)
			(self setHotspot: 2)
			(lock_0 init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (and (IsFlag 84) (IsFlag 85))
					(ClearFlag 79)
				)
				(cond
					((proc1111_24 83)
						(gCurRoom setScript: puckScript)
					)
					((IsFlag 80)
						(gCurRoom drawPic: 1129)
					)
					(else
						(gCurRoom drawPic: 1029)
					)
				)
				(= local0 1)
				(self dispose:)
				(lock_0 dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puckScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global122 notify: 83)
				(= seconds 3)
			)
			(1
				(gGame handsOn:)
				(Pucks_Intro play:)
				(SetFlag 83)
				(proc70_1 114 1)
				(FrameOut)
				(gGame handsOff:)
				(endOfSpeech play: self)
			)
			(2
				(if (and (proc1111_24 79) (IsFlag 85) (IsFlag 84))
					(sChairReturns play: 100 self pan: 10)
				else
					(= cycles 1)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChairReturns of RegionSFX
	(properties
		number 1054
		loop 1
	)
)

(instance Pucks_Intro of VMDMovie
	(properties
		movieName 38941
		endPic 1029
	)
)

(instance endOfSpeech of Sound
	(properties
		number 38941
		flags 1
	)
)

(instance doorClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 80)
					(gCurRoom drawPic: 1127)
				else
					(gCurRoom drawPic: 1027)
				)
				(FrameOut)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance lock_0 of Feature
	(properties
		noun 21
		x 329
		y 161
		nsBottom 201
		nsLeft 300
		nsRight 359
		nsTop 121
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

