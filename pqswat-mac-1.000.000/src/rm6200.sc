;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6200)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm6200 0
)

(instance rm6200 of PQRoom
	(properties
		picture 6200
	)

	(method (init)
		(ClearFlag 12)
		(Load rsVIEW 64006)
		(Load rsVIEW 13)
		(cond
			((IsFlag 75)
				(charmichael init: setCycle: End)
				(tony init: setCycle: End)
				(denton init: setCycle: End)
				(wixell init: setCycle: End)
				(pacmeyer view: 60009 loop: 1 cel: 0 posn: 9 143 init:)
				(gEgo
					view: 60009
					loop: 0
					cel: 0
					setPri: 100
					posn: -1 148
					init:
				)
				(self setScript: showEntry)
			)
			((and (IsFlag 98) (IsFlag 93))
				(gBackMusic fade: 0 2 21 1)
				(= picture 6200)
				(gCurRoom setScript: badTacticsHostageDies)
			)
			((IsFlag 101)
				(= picture 6200)
				(gCurRoom setScript: improveComm)
			)
			(else
				(gBackMusic fade: 0 2 21 1)
				(= picture 6400)
				(if (not (IsFlag 102))
					(gEgo
						view: 64006
						setLoop: 0
						setCel: 0
						posn: 446 377
						setPri: 280
						init:
					)
					(wixell
						view: 64006
						setLoop: 0
						setCel: 1
						posn: -33 364
						setPri: 280
						init:
					)
					(charmichael
						view: 64006
						setLoop: 0
						setCel: 2
						posn: 270 357
						setPri: 338
						init:
					)
					(tony
						view: 64006
						setLoop: 0
						setCel: 3
						posn: 507 359
						setPri: 280
						init:
					)
					(denton
						view: 64006
						setLoop: 0
						setCel: 4
						posn: 32 375
						setPri: 330
						init:
					)
				)
				(cond
					((and (IsFlag 97) (IsFlag 93))
						(self setScript: timeOutHostageDies)
					)
					((and (or (IsFlag 97) (IsFlag 98)) (IsFlag 94))
						(self setScript: officerDies)
					)
					((and (or (IsFlag 97) (IsFlag 98)) (IsFlag 95))
						(self setScript: suspectKilled)
					)
					((and (IsFlag 97) (IsFlag 96))
						(self setScript: timeOutSurrender)
					)
					((or (IsFlag 98) (IsFlag 96))
						(self setScript: suspectSurrenders)
					)
					((IsFlag 102)
						(= picture 6000)
						(self setScript: justifiedShooting)
					)
					((and (IsFlag 102) (IsFlag 99))
						(= picture 6000)
						(self setScript: justifiedSuccessful)
					)
					((IsFlag 98)
						(self setScript: timeOutSurrender)
					)
					(else
						(self setScript: greatJob)
					)
				)
				(ClearFlag 93)
				(ClearFlag 94)
				(ClearFlag 95)
				(ClearFlag 96)
				(ClearFlag 97)
				(ClearFlag 98)
				(ClearFlag 99)
				(ClearFlag 101)
				(ClearFlag 102)
			)
		)
		(super init: &rest)
		(if (or (IsFlag 87) (IsFlag 88))
			(SetFlag 107)
		)
		(if (or (IsFlag 89) (IsFlag 90))
			(SetFlag 108)
		)
	)

	(method (dispose)
		(proc4_5)
		(if
			(and
				(not (IsFlag 75))
				(not (IsFlag 64))
				(not (IsFlag 63))
				(not (IsFlag 100))
				(not (IsFlag 103))
			)
			(gGame setCallUp: (gGame callUpTime:))
		)
		(super dispose: &rest)
	)
)

(instance showEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo dispose:)
				(pacmeyer setCycle: CT 18 1 self)
			)
			(3
				(gCurRoom newRoom: 6000)
			)
		)
	)
)

(instance timeOutHostageDies of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 64001)
				(Load rsVIEW 64002)
				(Load rsVIEW 64003)
				(Load rsVIEW 64004)
				(Load rsVIEW 64005)
				(proc4_6 60037 207 89 0 0 100 1)
			)
			(1
				(proc4_5)
				(gGame showCloseUp: 60039 180 66)
				(proc4_6 60038 207 89 0 0 100 1)
			)
			(2
				(gEgo view: 64001 setCycle: End)
				(wixell view: 64002 setCycle: End)
				(charmichael view: 64003 setCycle: End)
				(tony view: 64004 setCycle: End)
				(denton view: 64005 setCycle: End)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(4
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 64)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 64)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance officerDies of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 64001)
				(Load rsVIEW 64002)
				(Load rsVIEW 64003)
				(Load rsVIEW 64004)
				(Load rsVIEW 64005)
				(proc4_6 60040 192 82 0 0 100)
			)
			(1
				(proc4_5)
				(gGame showCloseUp: 60041 180 66)
				(proc4_6 60040 192 82 49 0 100 1)
			)
			(2
				(gEgo view: 64001 setCycle: End)
				(wixell view: 64002 setCycle: End)
				(charmichael view: 64003 setCycle: End)
				(tony view: 64004 setCycle: End)
				(denton view: 64005 setCycle: End)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(4
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 64)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 64)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance suspectKilled of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 64001)
				(Load rsVIEW 64002)
				(Load rsVIEW 64003)
				(Load rsVIEW 64004)
				(Load rsVIEW 64005)
				(proc4_6 60042 192 60 0 0 100 1)
			)
			(1
				(gEgo view: 64001 setCycle: End)
				(wixell view: 64002 setCycle: End)
				(charmichael view: 64003 setCycle: End)
				(tony view: 64004 setCycle: End)
				(denton view: 64005 setCycle: End)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(3
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 64)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 64)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance timeOutSurrender of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 64001)
				(Load rsVIEW 64002)
				(Load rsVIEW 64003)
				(Load rsVIEW 64004)
				(Load rsVIEW 64005)
				(proc4_6 60044 215 79 0 0 100 1)
			)
			(1
				(gEgo view: 64001 setCycle: End)
				(wixell view: 64002 setCycle: End)
				(charmichael view: 64003 setCycle: End)
				(tony view: 64004 setCycle: End)
				(denton view: 64005 setCycle: End)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(3
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 63)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 63)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance badTacticsHostageDies of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tableTop setPri: 276 init:)
				(proc4_6 60045 0 121 0 0 275 1)
			)
			(1
				(gAutoRobot setPri: 280)
			)
			(2
				(gAutoRobot setPri: 275)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(4
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(if (not (IsFlag 100))
							(SetFlag 64)
						)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(if (not (IsFlag 100))
							(SetFlag 64)
						)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance suspectSurrenders of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 64001)
				(Load rsVIEW 64002)
				(Load rsVIEW 64003)
				(Load rsVIEW 64004)
				(Load rsVIEW 64005)
				(proc4_6 60046 215 89 0 0 100 1)
			)
			(1
				(gEgo view: 64001 setCycle: End)
				(wixell view: 64002 setCycle: End)
				(charmichael view: 64003 setCycle: End)
				(tony view: 64004 setCycle: End)
				(denton view: 64005 setCycle: End)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(3
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 63)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 63)
						(ClearFlag 68)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance improveComm of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tableTop setPri: 276 init:)
				(proc4_6 60047 -5 132 0 0 275 1)
			)
			(1
				(WalkieTalkie setPri: 277)
			)
			(2
				(WalkieTalkie setPri: 275)
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(= cycles 1)
			)
			(4
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance justifiedShooting of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 60004 388 80 0 0 200 1)
			)
			(1
				(gGame showCloseUp: 60065 180 66 self 1)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(3
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 67)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 67)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance justifiedSuccessful of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 60004 388 80 0 0 200 1)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(2
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 67)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(SetFlag 67)
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance greatJob of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(self changeState: 99)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 60048 213 89 0 0 100 1)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= cycles 1)
			)
			(2
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
			(99
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(= scratch (proc4_10 1))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(4
						(gGame getDisc: 1 1)
						(gCurRoom newRoom: 100)
					)
				)
			)
		)
	)
)

(instance tableTop of Prop
	(properties
		x 43
		y 233
		view 62005
	)
)

(instance charmichael of Prop
	(properties
		x 211
		y 312
		priority 250
		fixPriority 1
		view 62001
	)
)

(instance tony of Prop
	(properties
		x 131
		y 334
		priority 275
		fixPriority 1
		view 62002
	)
)

(instance denton of Prop
	(properties
		x 81
		y 334
		priority 280
		fixPriority 1
		view 62003
	)
)

(instance wixell of Prop
	(properties
		x 420
		y 365
		priority 310
		fixPriority 1
		view 62004
	)
)

(instance pacmeyer of Prop
	(properties)
)

