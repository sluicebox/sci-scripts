;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 989)
(include sci.sh)
(use Main)
(use System)

(class Sound of Obj
	(properties
		state 0
		number 0
		priority 0
		loop 1
		handle 0
		client 0
		signal 0
		keep 0
		prevSignal 0
	)

	(method (init)
		(= state (= signal 0))
		(gSounds add: self)
		(DoSound sndINIT self)
	)

	(method (play caller &tmp oldInfo)
		(= oldInfo -info-)
		(|= -info- $0002)
		(self dispose:)
		(= -info- oldInfo)
		(if (not loop)
			(= loop 1)
		)
		(self init:)
		(= client (if argc caller else 0))
		(DoSound sndPLAY self)
	)

	(method (playMaybe)
		(self play: &rest)
		(if (== state 2)
			(self dispose:)
		)
	)

	(method (check &tmp [temp0 40])
		(if signal
			(if (IsObject client)
				(client cue: self)
			)
			(if (== (= prevSignal signal) -1)
				(= state 4)
			)
			(= signal 0)
		)
	)

	(method (delete)
		(if (== state 4)
			(self dispose:)
		)
	)

	(method (dispose)
		(if keep
			(if handle
				(DoSound sndSTOP handle)
			)
		else
			(gSounds delete: self)
			(if handle
				(DoSound sndDISPOSE handle)
				(= handle 0)
			)
			(super dispose:)
		)
	)

	(method (pause value)
		(DoSound sndPAUSE value)
	)

	(method (changeState)
		(DoSound sndUPDATE self)
	)
)

