;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	proc150_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (proc150_0 param1 param2 param3 param4 &tmp temp0 temp1)
	(= local0 param1)
	(= local1 (if (> argc 1) param2 else param1))
	(if (>= argc 3)
		(= temp0 param3)
	)
	(if (>= argc 4)
		(= temp1 param4)
	)
	(if local2
		(= local2 0)
	else
		((User curEvent:) claimed: 1)
		(= local2 1)
		(= local3 global80)
		(= local5 (User controls:))
		(= local4 (User canInput:))
		(= local6 (gEgo illegalBits:))
		(= local7 (& (gEgo signal:) $4000))
		(HandsOff)
		(gEgo
			illegalBits: 0
			ignoreActors: 1
			setMotion:
				MoveTo
				(+ (local0 x:) temp0)
				(+ (local0 y:) temp1)
				gotoAct
		)
	)
	(return local2)
)

(instance gotoAct of Script
	(properties)

	(method (cue &tmp temp0)
		(Face gEgo local0)
		(User controls: local5)
		(User canInput: local4)
		(= global80 local3)
		(gEgo illegalBits: local6)
		(if (not local7)
			(gEgo ignoreActors: 0)
		)
		(if local1
			((= temp0 (User curEvent:)) type: evSAID)
			(Parse (User inputLineAddr:) temp0)
			(local1 handleEvent: temp0)
			(= local1 0)
		)
		(DisposeScript 150)
	)
)

