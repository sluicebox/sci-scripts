;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 912)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	DoUseSword 0
	DoParry 1
)

(local
	local0
	local1
)

(instance DoUseSword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (User canControl:))
				(HandsOff)
				(if global136
					(gEgo view: 46)
				else
					(gEgo view: 22)
				)
				(= local1 (gEgo illegalBits:))
				(gEgo
					ignoreActors:
					illegalBits: 0
					setCel: 0
					setCycle: End self
				)
				(= global125 4)
			)
			(1
				(= cycles 1)
			)
			(2
				(gEgo
					view: 6
					setCycle: Walk
					ignoreActors: 0
					illegalBits: local1
					setScript: 0
				)
				(HandsOn)
				(User canControl: local0)
				(User canInput: 0)
				(= global125 0)
			)
		)
	)
)

(instance DoParry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (User canControl:))
				(HandsOff)
				(= local1 (gEgo illegalBits:))
				(gEgo
					ignoreActors:
					illegalBits: 0
					view: 53
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					view: 6
					setCycle: Walk
					ignoreActors: 0
					illegalBits: local1
					setScript: 0
				)
				(= global125 0)
				(HandsOn)
				(User canControl: local0 canInput: 0)
			)
		)
	)
)

