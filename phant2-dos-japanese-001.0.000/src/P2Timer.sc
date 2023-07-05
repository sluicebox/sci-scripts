;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63013)
(include sci.sh)
(use Main)
(use invItems)
(use n63002)
(use Timer)
(use Menu)

(class P2Timer of Timer
	(properties
		scene 0
		whoDoit 0
		nextRoom 0
		kind 0
		length 0
		disposer 0
	)

	(method (doit &tmp temp0)
		(= temp0 seconds)
		(super doit: &rest)
		(if (!= temp0 seconds)
			(PrintDebug {%s %d} (self name:) seconds)
		)
	)

	(method (start param1 param2)
		(if (== argc 2)
			(= kind param1)
			(= length param2)
		)
		(= cuee self)
		(self set: kind length)
		(gCast add: self)
	)

	(method (restart param1 param2)
		(if (== argc 2)
			(= kind param1)
			(= length param2)
		)
		(= cuee self)
		(self set: kind length)
	)

	(method (addDisposer param1 &tmp temp0 temp1)
		(if disposer
			(if (disposer isKindOf: Set)
				(disposer add: param1)
			else
				(= temp1 (Set new: self))
				(temp1 add: disposer param1)
				(= disposer temp1)
			)
		else
			(= disposer param1)
		)
	)

	(method (cue)
		(if disposer
			(disposer dispose:)
			(= disposer 0)
		)
		(if (and scene (== nextRoom 0))
			(proc63002_7 scene)
		)
		(if whoDoit
			(whoDoit doit:)
		)
		(if nextRoom
			(if scene
				(= global209 scene)
			)
			(gCurRoom newRoom: nextRoom)
		)
	)

	(method (dispose)
		(if (and disposer (disposer isKindOf: Set))
			(disposer release: dispose:)
		)
		(gCast delete: self)
		(= plane (= cuee (= cuer (= register (= cueSelector 0)))))
	)
)

(class NurseTimer of P2Timer
	(properties
		initialized 0
	)

	(method (init param1 param2)
		(self start: param1 param2 &rest)
		(= initialized 1)
		(= cueSelector 20)
	)

	(method (cue)
		(gGame handsOff:)
		(SetFlag 348)
		(SetFlag 371)
		(SetFlag 372)
		(gP2SongPlyr fadeOut: 0)
		(= global209 200)
		(gCurRoom newRoom: 900) ; mapRoom
		(InvPlane recalc: 1)
	)
)

(class AllieTimerCh4 of P2Timer
	(properties)
)

(class knockingTimer of P2Timer
	(properties
		initialized 0
		knockOnce 0
		knocks 0
	)

	(method (init param1 param2)
		(= initialized 1)
		(self start: param1 param2 &rest)
		(= cueSelector 20)
	)

	(method (cue)
		(if (not (IsFlag 506))
			(SetFlag 506)
		)
		(if knockOnce
			(if (> knocks 5)
				(gP2SoundFX play: (Random 2808 2809))
			else
				(gP2SoundFX play: 2807)
			)
			(+= knocks 1)
		else
			(gP2SoundFX play: 2806)
			(self knockOnce: 1)
			(= knocks 1)
		)
	)

	(method (reset &tmp temp0)
		(= temp0 (Random 4 8))
		(= cuee self)
		(self set: kind temp0)
	)

	(method (dispose)
		(if (IsFlag 506)
			(self reset:)
		else
			(= initialized 0)
			(super dispose: &rest)
		)
	)
)

(class surgeryTimer of P2Timer
	(properties
		initialized 0
	)

	(method (init param1 param2)
		(= initialized 1)
		(self start: param1 param2 &rest)
		(= cueSelector 20)
	)

	(method (cue)
		(= global209 700)
		(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
	)

	(method (dispose)
		(= initialized 0)
		(super dispose: &rest)
	)
)

