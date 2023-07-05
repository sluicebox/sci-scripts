;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24610)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Sound)
(use System)

(public
	rm24610 0
)

(instance sHarrietWhines of Script
	(properties)

	(method (doit)
		(if (IsFlag 164)
			(if (gGDacSound handle:)
				(gGDacSound stop:)
			)
			(self dispose:)
		)
		(if
			(and
				(gGDacSound handle:)
				(gEgo robot:)
				(not (OneOf ((gEgo robot:) robot:) 3400 3350 3300))
			)
			(gGDacSound stop:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(Lock 140 24030 0) ; WAVE
		(Lock 140 24031 0) ; WAVE
		(Lock 140 24032 0) ; WAVE
		(Lock 140 24034 0) ; WAVE
		(Lock 140 24035 0) ; WAVE
		(Lock 140 24036 0) ; WAVE
		(gGDacSound client: 0)
		(= next 0)
		(if scratch
			(scratch release: dispose:)
			(= scratch 0)
		)
		(super dispose: &rest)
	)

	(method (init &tmp temp0)
		(Lock 140 24030 1) ; WAVE
		(Lock 140 24031 1) ; WAVE
		(Lock 140 24032 1) ; WAVE
		(Lock 140 24034 1) ; WAVE
		(Lock 140 24035 1) ; WAVE
		(Lock 140 24036 1) ; WAVE
		(= scratch (Set new:))
		(for ((= temp0 0)) (< temp0 100) ((++ temp0))
			(scratch add: (Random 24030 24036))
		)
		(scratch delete: 24033)
		(= next -1)
		(gGDacSound setLoop: 1)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (cue)
		(self changeState: (+ state 1))
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (and (& register $0001) (!= (gCurRoom number:) 24100))
					(gGame handsOff:)
					(self setScript: (ScriptID 0 5) self 5) ; takeLastStep
				else
					(self cue:)
				)
				(= register 0)
			)
			(1
				(switch gCurRoomNum
					(24610
						(gGDacSound setVol: 40)
					)
					(24010
						(gGDacSound setVol: 40)
					)
					(24000
						(gGDacSound setVol: 60)
					)
					(24100
						(gGDacSound setVol: 100)
					)
					(28300
						(self dispose:)
					)
				)
				(self cue:)
			)
			(2
				(if (IsFlag 164)
					(self dispose:)
					(return)
				else
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(not (IsFlag 164))
						(not (gCurRoom inset:))
						(not
							(and
								(gEgo robot:)
								(not
									(OneOf
										((gEgo robot:) robot:)
										3400
										3350
										3300
									)
								)
							)
						)
					)
					(if (== (++ next) (scratch size:))
						(scratch release:)
						(for ((= temp0 0)) (< temp0 100) ((++ temp0))
							(scratch add: (Random 24030 24036))
						)
						(scratch delete: 24033)
						(= next 0)
					)
					(gGDacSound number: (scratch at: next) play:)
				)
				(self cue:)
			)
			(4
				(= seconds (Random 5 12))
			)
			(5
				(self changeState: 3)
			)
		)
	)
)

(instance rm24610 of ScaryRoom
	(properties
		picture 24610
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 28300)
			(global114 stop: 1)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init &tmp temp0)
		(= temp0 0)
		(proc1111_6)
		(gEgo init: setScaler: Scaler 98 83 129 122)
		(switch gPrevRoomNum
			(900)
			(28300
				(gEgo posn: 166 132 normalize: 2)
				(if (and (== gChapter 3) (not (IsFlag 164)))
					(sHarrietWhines register: 1 init:)
				else
					(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
				)
			)
			(24000
				(gEgo posn: 166 132 normalize: 6)
				(cond
					((and (== gChapter 3) (not (IsFlag 164)))
						(sHarrietWhines register: 1 init:)
					)
					((!= global125 252)
						(gCurRoom setScript: (ScriptID 0 5) 0 5 1) ; takeLastStep
					)
					(else
						(= global125 0)
					)
				)
			)
			(else
				(gEgo posn: 166 132 normalize: 3)
				(if (and (== gChapter 3) (not (IsFlag 164)))
					(sHarrietWhines register: 1 init:)
				else
					(gCurRoom setScript: (ScriptID 0 5) 0 5 41) ; takeLastStep
				)
			)
		)
		(toDriveway init: 1)
		(toCampfire init: 3)
		(toMainCH init: 12)
		(super init: &rest)
		(gGame handsOn:)
		(switch gChapter
			(1
				(if (IsFlag 39)
					(= temp0 915)
				)
			)
			(2
				(= temp0 915)
			)
			(3
				(if (IsFlag 164)
					(= temp0 915)
				else
					(= temp0 24029)
				)
			)
			(4
				(= temp0 916)
			)
			(5
				(= temp0 917)
			)
			(6
				(= temp0 918)
			)
		)
		(if temp0
			(global114 play: temp0)
		)
	)
)

(instance toDriveway of ExitFeature
	(properties
		nsLeft 151
		nsTop 33
		nsRight 171
		nsBottom 121
		approachX 159
		approachY 48
		x 161
		y 77
		nextRoom 28300
	)
)

(instance toMainCH of ExitFeature
	(properties
		nsLeft 0
		nsTop 67
		nsRight 62
		approachX 136
		approachY 162
		x 31
		y 96
		nextRoom 24000
	)
)

(instance toCampfire of ExitFeature
	(properties
		nsLeft 123
		nsTop 121
		nsRight 220
		approachX 161
		approachY 182
		x 171
		y 124
		nextRoom 24010
	)
)

(instance harrietSnores of Sound ; UNUSED
	(properties
		number 24045
	)
)

