;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 823)
(include sci.sh)
(use Main)
(use Motion)

(public
	proc823_0 0
)

(procedure (proc823_0 param1 param2)
	(if (>= argc 1)
		(gEgo view: param1)
		(if (>= argc 2)
			(gEgo loop: param2)
		)
	)
	(gEgo
		setLoop: -1
		setPri: -1
		setMotion: 0
		setStep: 3 2
		setCycle: Walk
		illegalBits: -32768
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
		observeControl: -32768
	)
	(DisposeScript 823)
)

