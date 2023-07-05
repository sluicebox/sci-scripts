;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 959)
(include sci.sh)
(use Sound)

(class QSnd of Sound
	(properties)

	(method (check &tmp cues theSignal)
		(if (or (u< signal 128) (== signal -1))
			(return (super check:))
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

