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
	)

	(method (new who)
		((super new:) owner: (if argc who else 0) yourself:)
	)

	(method (init)
		(= prevSignal (= signal 0))
		(gSounds add: self)
		(DoSound sndINIT self)
	)

	(method (play caller &tmp oldInfo)
		(= oldInfo argc)
		(if (and argc (IsObject [caller (- argc 1)]))
			(= client [caller (= oldInfo (- argc 1))])
		else
			(= client 0)
		)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(if (not loop)
			(= loop 1)
		)
		(if oldInfo
			(= vol caller)
		else
			(= vol 127)
		)
		(DoSound sndPLAY self 0)
	)

	(method (stop)
		(if handle
			(DoSound sndUPDATE_CUES self)
			(DoSound sndSTOP self)
		)
	)

	(method (pause value)
		(if (not argc)
			(= value 1)
		)
		(DoSound sndPAUSE (if (self isMemberOf: Sound) self else 0) value)
	)

	(method (hold where)
		(if (not argc)
			(= where 1)
		)
		(DoSound sndSET_HOLD self where)
	)

	(method (release)
		(DoSound sndSET_HOLD self 0)
	)

	(method (fade newVol fTicks fSteps fEnd &tmp argCount)
		(= argCount argc)
		(if (and argc (IsObject [newVol (- argc 1)]))
			(= client [newVol (= argCount (- argc 1))])
		)
		(if argCount
			(DoSound sndFADE self newVol fTicks fSteps fEnd)
		else
			(DoSound sndFADE self 0 25 10 1)
		)
	)

	(method (mute value channel &tmp i theVal)
		(if (not argc)
			(= theVal 1)
		else
			(= theVal value)
		)
		(if (< argc 2)
			(for ((= i 1)) (< i 17) ((++ i))
				(DoSound sndSEND_MIDI self i 176 78 theVal)
			)
		else
			(DoSound sndSEND_MIDI self channel 176 78 theVal)
		)
	)

	(method (setVol newVol)
		(DoSound sndSET_VOLUME self newVol)
	)

	(method (setPri newPri)
		(DoSound sndSET_PRIORITY self newPri)
	)

	(method (setLoop newLoop)
		(DoSound sndSET_LOOP self newLoop)
	)

	(method (send channel command value1 value2)
		(if (<= 1 channel 15)
			(if (< command 128)
				(DoSound sndSEND_MIDI self channel 176 command value1)
			else
				(DoSound sndSEND_MIDI self channel command value1 value2)
			)
		)
	)

	(method (check)
		(if handle
			(DoSound sndUPDATE_CUES self)
		)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(if (IsObject client)
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
			(DoSound sndDISPOSE self)
			(= nodePtr 0)
		)
		(super dispose:)
	)

	(method (playBed newVol &tmp argCount)
		(= argCount argc)
		(if (and argc (IsObject [newVol (- argc 1)]))
			(= client [newVol (= argCount (- argc 1))])
		else
			(= client 0)
		)
		(self init:)
		(if (not loop)
			(= loop 1)
		)
		(if argCount
			(= vol newVol)
		else
			(= vol 127)
		)
		(DoSound sndPLAY self 1)
	)

	(method (changeState)
		(DoSound sndUPDATE self)
	)
)

