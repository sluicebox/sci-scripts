;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 989)
(include sci.sh)
(use Main)
(use System)

(class Sound of Obj
	(properties
		nodePtr 0
		handle 0
		number 0
		vol 127
		priority 0
		loop 1
		signal 0
		prevSignal 0
		dataInc 0
		min 0
		sec 0
		frame 0
		client 0
		owner 0
		soundOn 1
		nextNumber 0
		nextLoop -1
	)

	(method (new who)
		((super new:) owner: (if argc who else 0) yourself:)
	)

	(method (init)
		(= prevSignal (= signal 0))
		(gSounds add: self)
		(DoSound 5 self) ; sndINIT
	)

	(method (play param1 param2 param3 param4)
		(= nextNumber (if (>= argc 3) param3 else 0))
		(= nextLoop (if (>= argc 4) param4 else -1))
		(if (and (>= argc 1) (>= param1 0))
			(= number param1)
		)
		(if (not loop)
			(= loop 1)
		)
		(= client (if (>= argc 2) param2 else 0))
		(self init:)
		(if soundOn
			(DoSound 7 self 0) ; sndPLAY
		)
	)

	(method (playBed param1 param2 param3 param4)
		(= nextNumber (if (>= argc 3) param3 else 0))
		(= nextLoop (if (>= argc 4) param4 else -1))
		(if (and (>= argc 1) (>= param1 0))
			(= number param1)
		)
		(if (not loop)
			(= loop 1)
		)
		(= client (if (>= argc 2) param2 else 0))
		(self init:)
		(if soundOn
			(DoSound 7 self 1) ; sndPLAY
		)
	)

	(method (stop doCue)
		(= nextNumber 0)
		(if (and argc (not doCue))
			(= client 0)
		)
		(if nodePtr
			(DoSound 8 self) ; sndSTOP
		)
	)

	(method (pause value)
		(if (not argc)
			(= value 1)
		)
		(DoSound 9 (if (self isMemberOf: Sound) self else 0) value) ; sndPAUSE
	)

	(method (fade param1 param2 param3 param4 param5)
		(= nextNumber 0)
		(if (and (> argc 4) param5)
			(= client 0)
		)
		(if argc
			(DoSound 10 self param1 param2 param3 param4) ; sndFADE
		else
			(DoSound 10 self 15 20 10 1) ; sndFADE
		)
	)

	(method (send param1 param2 param3)
		(if (<= 1 param1 15)
			(DoSound 12 self param1 param2 param3) ; sndSEND_MIDI
		)
	)

	(method (changeState)
		(DoSound 4 self) ; sndUPDATE
	)

	(method (check)
		(DoSound 11 self) ; sndUPDATE_CUES
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(if (IsObject client)
				(client cue: self nextNumber nextLoop)
			)
		)
	)

	(method (clean who)
		(if (or (not owner) (== owner who))
			(self dispose:)
		)
	)

	(method (dispose doCue)
		(if (and argc (not doCue))
			(= client 0)
		)
		(gSounds delete: self)
		(if nodePtr
			(DoSound 6 self) ; sndDISPOSE
			(= nodePtr 0)
		)
		(super dispose:)
	)

	(method (cue))

	(method (toggle))
)

