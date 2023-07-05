;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Motion)
(use Actor)
(use System)

(public
	agentEyesProp 0
	agentLipsProp 1
	sparkleProp 2
)

(instance agentEyesProp of Prop
	(properties
		y 77
		x 145
		view 302
	)

	(method (init)
		(super init: &rest)
		(self setScript: agentsFeaturesPropScript)
	)
)

(instance agentsFeaturesPropScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(agentLipsProp setCycle: End self)
			)
			(2
				(sparkleProp setCycle: End self)
			)
			(3
				(sparkleProp setCycle: Beg self)
			)
			(4
				(= seconds 2)
			)
			(5
				(agentLipsProp setCycle: Beg self)
			)
			(6
				(= seconds 5)
			)
			(7
				(self init:)
			)
		)
	)
)

(instance agentLipsProp of Prop
	(properties
		y 104
		x 141
		view 302
		loop 1
	)
)

(instance sparkleProp of Prop
	(properties
		y 97
		x 153
		view 302
		loop 2
		priority 7
		signal 16
	)

	(method (delete)
		(super delete:)
		(DisposeScript 360)
	)
)

