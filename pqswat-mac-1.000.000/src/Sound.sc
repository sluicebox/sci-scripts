;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64989)
(include sci.sh)
(use Main)
(use System)

(class Sound of Obj
	(properties
		nodePtr 0
		handle 0
		flags 0
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
		sample 0
	)

	(method (new who)
		((super new:) owner: (if argc who else 0) yourself:)
	)

	(method (init)
		(= prevSignal (= signal 0))
		(gSounds add: self)
		(DoSound 2 self) ; sndINIT
	)

	(method (play callerOrVolume caller)
		(= vol 126)
		(= client 0)
		(if argc
			(if (== argc 1)
				(= client callerOrVolume)
			else
				(= client caller)
				(= vol (& callerOrVolume $007f))
			)
		)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(if (not loop)
			(= loop 1)
		)
		(DoSound 10 self) ; sndUPDATE_CUES
		(DoSound 5 self) ; sndSTOP
		(DoSound 4 self) ; sndPLAY
	)

	(method (stop)
		(if handle
			(DoSound 10 self) ; sndUPDATE_CUES
			(DoSound 5 self) ; sndSTOP
		)
	)

	(method (pause value)
		(if (not argc)
			(= value 1)
		)
		(DoSound
			6 ; sndPAUSE
			(if (and (self isKindOf: Sound) (!= self Sound)) self else 0)
			value
		)
	)

	(method (fade newVol fTicks fSteps fEnd whoCares)
		(if argc
			(if (> argc 4)
				(= client whoCares)
			)
			(DoSound 7 self newVol fTicks fSteps fEnd) ; sndFADE
		else
			(DoSound 7 self 0 25 10 1) ; sndFADE
		)
	)

	(method (setVol newVol)
		(DoSound 8 self (& newVol $007f)) ; sndSET_VOLUME
	)

	(method (setLoop newLoop)
		(DoSound 9 self newLoop) ; sndSET_LOOP
	)

	(method (check)
		(if handle
			(DoSound 10 self) ; sndUPDATE_CUES
		)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(if client
				(client cue: self)
			)
		)
	)

	(method (clean who)
		(if (or (not owner) (== owner who))
			(self dispose:)
		)
	)

	(method (dispose)
		(gSounds delete: self)
		(if nodePtr
			(DoSound 3 self) ; sndDISPOSE
			(= nodePtr 0)
		)
		(super dispose:)
	)
)

