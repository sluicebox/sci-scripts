;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Actor)

(public
	RotProp 0
)

(class RotProp of Prop
	(properties
		baseView -1
		rotating 0
		waitDefault 10
		waitCnt 0
		myFeat 0
	)

	(method (init param1 param2 param3 param4)
		(= x (+ param2 (/ (- param4 param2) 2)))
		(= y (+ param1 (/ (- param3 param1) 2)))
		(super init:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(= rotating 1)
				(= waitCnt waitDefault)
				(if (> gMouseX 60)
					(self rotate: 7)
				else
					(self rotate: 3)
				)
				(event claimed: 1)
			)
			(evMOUSERELEASE
				(= rotating 0)
				(event claimed: 1)
			)
			(evNULL
				(if rotating
					(if (<= (-- waitCnt) 0)
						(= waitCnt waitDefault)
						(if (> gMouseX 60)
							(self rotate: 7)
						else
							(self rotate: 3)
						)
						(event claimed: 1)
					)
				else
					(super handleEvent: event)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (rotate param1)
		(switch param1
			(3
				(++ cel)
				(if (> cel 15)
					(= cel 0)
				)
			)
			(7
				(-- cel)
				(if (< cel 0)
					(= cel 15)
				)
			)
		)
		(UpdateScreenItem self)
	)
)

