;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 959)
(include sci.sh)
(use Sound)

(class QSnd of Sound
	(properties)

	(method (check &tmp cues theSignal)
		(if (u< signal 128)
			(return 0)
		)
		(while (!= (= theSignal signal) prevSignal)
			(if (IsObject client)
				(if (== theSignal -1)
					(client cue: self)
				else
					(for
						((= cues (- theSignal (or prevSignal 127))))
						cues
						((-- cues))
						
						(client cue: self)
					)
				)
			)
			(= prevSignal theSignal)
		)
		(= signal 0)
		(return 1)
	)
)

