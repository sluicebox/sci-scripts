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
		signal 0
		prevSignal 0
		client 0
		owner 0
	)

	(method (new who)
		((super new:) owner: (if argc who else 0) yourself:)
	)

	(method (init)
		(= state (= signal 0))
		(gSounds add: self)
		(DoSound sndINIT self)
	)

	(method (play caller &tmp oldInfo)
		(self stop:)
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

	(method (check)
		(if signal
			(if (IsObject client)
				(client cue: self)
			)
			(= prevSignal signal)
			(= signal 0)
		)
	)

	(method (stop doCue)
		(if (and argc (not doCue))
			(= client 0)
		)
		(if handle
			(DoSound sndSTOP handle)
		)
	)

	(method (dispose doCue)
		(if (and argc (not doCue))
			(= client 0)
		)
		(gSounds delete: self)
		(if handle
			(DoSound sndDISPOSE handle)
			(= handle 0)
		)
		(super dispose:)
	)

	(method (pause value)
		(DoSound sndPAUSE value)
	)

	(method (changeState)
		(DoSound sndUPDATE self)
	)

	(method (clean who)
		(if (or (not owner) (== owner who))
			(self dispose:)
		)
	)

	(method (fade doCue)
		(if (and argc (not doCue))
			(= client 0)
		)
		(DoSound sndFADE handle)
	)
)

