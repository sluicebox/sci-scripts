;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64959)
(include sci.sh)
(use Sound)

(class QSnd of Sound
	(properties)

	(method (check &tmp cues theSignal [str 100])
		(DoSound sndUPDATE_CUES self)
		(if (or (== signal -1) (u< signal 128))
			(return
				(if signal
					(= prevSignal signal)
					(= signal 0)
					(if client
						(client cue: self)
					)
				)
			)
		)
		(while (!= (= theSignal signal) prevSignal)
			(if client
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

