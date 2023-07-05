;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2990)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_2990 0
)

(instance s2_2990 of PQRoom
	(properties
		picture 2990
	)

	(method (init)
		((ScriptID 4054 0) changeMusic: 29801) ; kiplandRegion
		(super init: &rest)
		(SetFlag 65)
		(tape init:)
		(westE init:)
		(if (not (IsFlag 208))
			(self setScript: talkToOwner)
		else
			(self setScript: sEgoEnter)
		)
	)

	(method (newRoom &tmp temp0)
		(if
			(and
				(not (IsFlag 232))
				(not (gTimers contains: (ScriptID 4054 1))) ; briefingTimer
			)
			((ScriptID 4054 1) setReal: (ScriptID 4054 1) 0 3) ; briefingTimer, briefingTimer
		)
		(super newRoom: &rest)
		(if (gCast contains: gEgo)
			(gEgo dispose: view: 0)
		)
	)

	(method (dispose)
		(SetFlag 248)
		(ClearFlag 65)
		(proc4_5)
		(super dispose:)
	)
)

(instance talkToOwner of Script
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evKEYBOARD)
			(if (== (event message:) KEY_SPACE)
				(event claimed: 1)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(self caller: 0 dispose:)
				(gCurRoom setScript: skipItScript)
			)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 208)
				(proc4_6 29900 -11 81 0 0 342 1)
			)
			(1
				(schienbly init:)
				((ScriptID 4054 2) setReal: (ScriptID 4054 2) (Random 7 20)) ; gunTimer, gunTimer
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance skipItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_5)
				(= global128 29901)
				(WalkieTalkie showFrame: 29901 28 -10 88 342)
				(schienbly init:)
				(gMessager say: 0 0 1 6 self) ; "Rooker! Pacmeyer!"
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToSchienbly of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 [temp2 2])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not register)
					(= temp0
						(cond
							((not (SetFlag 214)) 29913)
							((not (SetFlag 213)) 29914)
							((not (SetFlag 212)) 29915)
							((not (SetFlag 211)) 29916)
							((not (SetFlag 210)) 29917)
							((not (SetFlag 215)) 29918)
							(else
								(self dispose:)
								(return)
							)
						)
					)
					(gGame showCloseUp: temp0 -1 -1 self 1)
				else
					(self cue:)
				)
			)
			(1
				(if (IsFlag 215)
					(schienbly dispose:)
					(gEgo
						view: 29902
						loop: 0
						cel: 0
						posn: 38 388
						setPri: 342
						init:
					)
					(if
						(and
							(not (IsFlag 232))
							(not (gTimers contains: (ScriptID 4054 1))) ; briefingTimer
						)
						((ScriptID 4054 1) setReal: (ScriptID 4054 1) 0 3) ; briefingTimer, briefingTimer
					)
				else
					(proc4_5)
					(WalkieTalkie showFrame: 29901 28 -10 88 342)
					(= global128 temp1) ; UNINIT
				)
				(gCast eachElementDo: #show)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(if (not register)
					(gGame handsOn:)
					(self dispose:)
				else
					(gCurRoom setScript: sEgoLeave)
				)
			)
		)
	)
)

(instance sEgoEnter of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(gEgo
					view: 29902
					loop: 0
					cel: 20
					posn: 38 388
					setPri: 342
					init:
					setCycle: Beg self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_5)
				(if (or (IsFlag 248) (IsFlag 215))
					(gEgo setPri: 342 setCycle: End self)
				else
					(proc4_6 29901 -10 88 28 0 342)
				)
			)
			(1
				(gCurRoom newRoom: 2980) ; s2_2980
			)
		)
	)
)

(instance schienbly of Feature
	(properties
		nsLeft 136
		nsTop 160
		nsRight 185
		nsBottom 342
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToSchienbly)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tape of View
	(properties
		x 92
		y 278
		view 29910
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 40
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(if (== (gCurRoom script:) talkToSchienbly)
			(talkToSchienbly register: 1 seconds: 0 cue:)
		else
			(gCurRoom setScript: sEgoLeave)
		)
	)
)

