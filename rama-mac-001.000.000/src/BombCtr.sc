;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 137)
(include sci.sh)
(use Main)
(use newYorkRegion)
(use n1111)
(use Print)
(use Sound)
(use Actor)
(use System)

(class BombCtr of Set
	(properties
		tenHourDigit 0
		hourDigit 0
		tenMinDigit 0
		minDigit 0
		tenSecDigit 0
		secsDigit 0
		xPos 0
		yPos 0
		colon1 0
		colon2 0
		chirp 1
	)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp2 (/ (= temp1 (/ (= temp0 (NukeTimer seconds:)) 3600)) 10))
		(= temp1 (mod temp1 10))
		(= temp5 (/ (= temp4 (/ (= temp3 (mod temp0 3600)) 60)) 10))
		(= temp4 (mod temp4 10))
		(= temp6 (/ (= temp3 (mod temp3 60)) 10))
		(= temp7 (mod temp3 10))
		((= tenHourDigit (Digit new:)) x: xPos y: yPos cel: temp2 init: param1)
		((= hourDigit (Digit new:))
			x: (tenHourDigit nsRight:)
			y: yPos
			cel: temp1
			init: param1
		)
		((= colon1 (Digit new:))
			x: (hourDigit nsRight:)
			y: yPos
			cel: 10
			init: param1
		)
		((= tenMinDigit (Digit new:))
			x: (colon1 nsRight:)
			y: yPos
			cel: temp5
			init: param1
		)
		((= minDigit (Digit new:))
			x: (tenMinDigit nsRight:)
			y: yPos
			cel: temp4
			init: param1
		)
		((= colon2 (Digit new:))
			x: (minDigit nsRight:)
			y: yPos
			cel: 10
			init: param1
		)
		((= tenSecDigit (Digit new:))
			x: (colon2 nsRight:)
			y: yPos
			cel: temp6
			init: param1
		)
		((= secsDigit (Digit new:))
			x: (tenSecDigit nsRight:)
			y: yPos
			cel: temp7
			init: param1
		)
		(self
			add:
				tenHourDigit
				hourDigit
				tenMinDigit
				minDigit
				tenSecDigit
				secsDigit
				colon1
				colon2
		)
		(super init: &rest)
		(Load rsAUDIO 5012)
	)

	(method (hide)
		(self eachElementDo: #hide)
	)

	(method (show)
		(self eachElementDo: #show)
	)

	(method (updateBombCtr param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (/ (= temp1 (/ param1 3600)) 10))
		(= temp1 (mod temp1 10))
		(= temp2 (/ (= temp3 (/ (= temp6 (mod param1 3600)) 60)) 10))
		(= temp3 (mod temp3 10))
		(= temp4 (/ (= temp6 (mod temp6 60)) 10))
		(= temp5 (mod temp6 10))
		(tenHourDigit cel: temp0)
		(hourDigit cel: temp1)
		(tenMinDigit cel: temp2)
		(minDigit cel: temp3)
		(tenSecDigit cel: temp4)
		(secsDigit cel: temp5)
		(if (minDigit isNotHidden:)
			(UpdateScreenItem tenHourDigit)
			(UpdateScreenItem hourDigit)
			(UpdateScreenItem tenMinDigit)
			(UpdateScreenItem minDigit)
			(UpdateScreenItem tenSecDigit)
			(UpdateScreenItem secsDigit)
		)
		(if
			(and
				chirp
				(not temp5)
				(not (and (proc201_5) (NukeTimer isCountDown:)))
			)
			(bmbTimerSnd play:)
		)
	)

	(method (isActive)
		(self size:)
	)

	(method (dispose)
		(super dispose: &rest)
		(= hourDigit
			(= tenMinDigit
				(= minDigit
					(= tenSecDigit (= secsDigit (= colon1 (= colon2 0))))
				)
			)
		)
	)
)

(class Digit of View
	(properties)

	(method (init)
		(cond
			((IsFlag 1)
				(= view 207)
				(= loop 4)
			)
			((== gCurRoomNum 8115) ; HumanBombCloseUp
				(= view 8015)
				(= loop 0)
			)
			(else
				(= view 220)
				(= loop 0)
			)
		)
		(super init: &rest)
		(self setPri: 250 ignoreActors: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(if (BombCtr chirp:)
				(BombCtr chirp: 0)
				(Prints {Timer Chirp off})
			else
				(BombCtr chirp: 1)
				(Prints {Timer Chirp on})
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bmbTimerSnd of Sound
	(properties
		flags 5
		number 5012
	)
)

