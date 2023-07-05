;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 151)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	proc151_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (proc151_0 param1 param2 param3)
	(= local4 (if (> argc 2) param3 else 0))
	(= local5 param1)
	(= local6 (param2 script:))
	(param2 script: 0)
	(param2 setScript: doAction)
)

(instance doAction of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local3 (gEgo cycler:))
				(gEgo cycler: 0)
				(gEgo
					view: 70
					loop: (if (== local5 1) 0 else 1)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(= local0 global80)
				(= local2 (User controls:))
				(= local1 (User canInput:))
				(HandsOff)
			)
			(1
				(gEgo
					view: 0
					loop: 3
					cycleSpeed: 0
					setCycle: 0
					cycler: local3
				)
				(User controls: local2)
				(User canInput: local1)
				(= global80 local0)
				(if local4
					(local4 cue:)
				)
				(client setScript: 0 setScript: local6)
				(DisposeScript 151)
			)
		)
	)
)

