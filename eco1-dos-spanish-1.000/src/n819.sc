;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 819)
(include sci.sh)
(use Main)
(use Smopper)
(use StopWalk)
(use Grooper)
(use System)

(public
	SetFlag 3
	ClearFlag 4
	IsFlag 5
	NormalEgo 6
	NormalDelph 7
	proc819_8 8
	Face 9
)

(procedure (NormalEgo param1 param2 param3 &tmp temp0)
	(= temp0 0)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
			(if (> argc 2)
				(= temp0 param3)
			)
		)
	)
	(if (not temp0)
		(= temp0 801)
	)
	(gEgo
		signal: 4096
		z: 0
		setLoop: -1
		setLoop: gStopGroop
		setPri: -1
		setMotion: 0
		illegalBits: 0
		ignoreActors: 0
		ignoreHorizon: 1
		setStep: 4 3
		moveSpeed: (gGame egoMoveSpeed:)
		cycleSpeed: (gGame egoMoveSpeed:)
	)
	(cond
		((OneOf gNewRoomNum 380 400 381)
			(gEgo view: 800 setCycle: StopWalk temp0 setStep: 2 2)
		)
		((OneOf gNewRoomNum 320 321 322 335)
			(gEgo view: 822 setCycle: Smopper 818 668 0 12)
		)
		(else
			(gEgo
				view: 802
				ignoreHorizon: 0
				setCycle: Smopper 805 814 815 12
			)
		)
	)
)

(procedure (NormalDelph)
	(gDelph
		signal: 4096
		view: 831
		z: 100
		lookStr: 0
		setLoop: -1
		setLoop: delphStopGroop
		setPri: -1
		setMotion: 0
		illegalBits: 0
		ignoreActors: 1
		ignoreHorizon: 1
		setStep: 5 4
		moveSpeed: 4
		cycleSpeed: 8
		setCycle: Smopper 836 0 0 20
	)
)

(procedure (IsFlag param1)
	(return (& [global150 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(|= [global150 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global150 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (and (IsObject temp3) temp3))
)

(procedure (proc819_8 param1 param2)
	(if (< param1 0)
		(= param1 0)
	)
	(if (> param1 255)
		(= param1 255)
	)
	(if (< param2 0)
		(= param2 0)
	)
	(if (> param2 15)
		(= param2 15)
	)
	(return (if (not (<= 2 global102 16)) param1 else param2))
)

(instance delphStopGroop of Grooper
	(properties)
)

