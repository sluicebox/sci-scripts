;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 959)
(include sci.sh)
(use Tutorial)

(class QSnd of Tutorial
	(properties
		nodePtr 0
		handle 0
		flags 0
		number 0
		vol 127
		priority 0
		loop 1
		signal 0
		dataInc 0
		min 0
		sec 0
		frame 0
	)

	(method (pause &tmp temp0 temp1 [temp2 100])
		(DoSound sndUPDATE_CUES self)
		(if (or (== signal -1) (u< signal 128))
			(return
				(if signal
					(= nextItem signal)
					(= signal 0)
					(if (IsObject client)
						(client cue: self)
					)
				)
			)
		)
		(while (!= (= temp1 signal) nextItem)
			(if (IsObject client)
				(for ((= temp0 (- temp1 (or nextItem 127)))) temp0 ((-- temp0))
					(client cue: self)
				)
			)
			(= nextItem temp1)
		)
		(= signal 0)
		(return 1)
	)
)

