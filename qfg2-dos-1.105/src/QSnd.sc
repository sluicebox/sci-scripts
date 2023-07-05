;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 959)
(include sci.sh)
(use Sound)

(class QSnd of Sound
	(properties)

	(method (check &tmp cues theSignal [str 100])
		(DoSound 11 self) ; sndUPDATE_CUES
		(if (or (== signal -1) (u< signal 128))
			(return
				(if signal
					(= prevSignal signal)
					(= signal 0)
					(if (IsObject client)
						(client cue: self)
					)
				)
			)
		)
		(while (!= (= theSignal signal) prevSignal)
			(if (IsObject client)
				(for
					((= cues (- theSignal (or prevSignal 127))))
					cues
					((-- cues))
					
					(client cue: self)
				)
			)
			(= prevSignal theSignal)
		)
		(= signal 0)
		(return 1)
	)
)

