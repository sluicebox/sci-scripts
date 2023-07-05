;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 309)
(include sci.sh)
(use Main)
(use Interface)
(use n361)
(use Actor)

(public
	agent 0
)

(instance agent of Act
	(properties
		view 212
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/woman,stacy][/!*]')
				(if (and (proc0_4 1616) (< (gEgo distanceTo: self) 70))
					(proc361_0
						111
						(ScriptID 360 0) ; agentEyesProp
						(ScriptID 360 1) ; agentLipsProp
						(ScriptID 360 2) ; sparkleProp
					)
				else
					(Print 309 0) ; "You see a beautiful young woman."
				)
			)
			((> (gEgo distanceTo: self) 60))
			((Said 'get,ask/name')
				(Print 309 1) ; ""My name is Stacy," the young lady replies."
			)
		)
	)
)

