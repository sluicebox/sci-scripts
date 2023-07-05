;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2340)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm2v34 0
)

(local
	[local0 10] = [43 50 57 64 71 78 85 92 99 106]
)

(instance rm2v34 of ShiversRoom
	(properties
		picture 2340
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2341)
		else
			(hsButton init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(Panel init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2000
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2010
	)
)

(instance hsButton of HotSpot
	(properties)

	(method (init)
		(self createPoly: 132 114 127 115 127 121 135 121 135 114 133 114)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 2)
			(gSounds stop: 10224)
			(gSounds play: 10224 0 82 0)
		)
	)
)

(instance Panel of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 2340
	)

	(method (init)
		(if (IsFlag 2)
			(self view: 2340)
		else
			(self view: 2341)
		)
		(super init: &rest)
		(if (IsFlag 3)
			(self setLoop: 0 setCel: (self lastCel:))
		)
	)

	(method (onMe param1)
		(if (and (< 19 (param1 y:) 125) (< 87 (param1 x:) 175))
			(return 1)
		else
			(return 0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (self onMe: event)
			(cond
				(
					(and
						(not (IsFlag 3))
						(not (IsFlag 2))
						(& (event type:) evMOUSEBUTTON)
						(< 112 (event y:) 122)
						(< 123 (event x:) 139)
					)
					(event claimed: 1)
					(gCurRoom setScript: sOpenPanel)
				)
				(
					(and
						(IsFlag 3)
						(& (event type:) evMOUSEBUTTON)
						(< 112 (event y:) 122)
						(< 123 (event x:) 139)
					)
					(gSounds stop: 10225)
					(gSounds play: 10225 0 90 0)
					(event claimed: 1)
					(gSounds play: 10219 0 122 0)
					(self setLoop: 0 setCel: (self lastCel:))
					(self setCycle: Beg)
					(ClearFlag 3)
				)
				(
					(and
						(IsFlag 3)
						(== (event type:) evMOUSEBUTTON)
						(< 37 (event y:) 106)
						(< 116 (event x:) 147)
					)
					(event claimed: 1)
					(self setLoop: 2)
					(= temp2 cel)
					(repeat
						(= temp0 (Event new:))
						(temp0 localize: gThePlane)
						(= temp1 (temp0 y:))
						(for ((= temp3 0)) (< temp3 10) ((++ temp3))
							(if (> [local0 temp3] temp1)
								(break)
							)
						)
						(= cel temp3)
						(if (!= temp2 cel)
							(= temp2 cel)
							(UpdateScreenItem self)
							(FrameOut)
						)
						(if (& (temp0 type:) evMOUSERELEASE)
							(if (>= cel 4)
								(self setCel: 8)
								(UpdateScreenItem self)
								(FrameOut)
								(ClearFlag 3)
								(SetFlag 2)
								(proc951_15 6750)
								(self setScript: sClosePanel)
								(break)
							)
							(self setCel: 0)
							(UpdateScreenItem self)
							(FrameOut)
							(break)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance sOpenPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10225 0 92 self)
				(Panel setLoop: 6 setCel: 1 setPri: 30 1)
			)
			(1
				(SetFlag 3)
				(gSounds play: 10218 0 122 0)
				(Panel setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClosePanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PrintDebug {hands off})
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gSounds play: 10220 0 122 0)
				(gSounds play: 10219 0 90 0)
				(Panel setLoop: 3 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(2
				(gSounds play: 10221 0 122 self)
				(gCurRoom drawPic: 2342)
				(Panel hide:)
			)
			(3
				(proc951_7 20204)
				(proc951_9 20204)
				(gSounds play: 10222 0 122 self)
			)
			(4
				(gCurRoom drawPic: 2340)
				(gSounds play: 20204 -1 122 0)
				(gSounds stop: 10222)
				(hsButton init:)
				(PrintDebug {hands on})
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

