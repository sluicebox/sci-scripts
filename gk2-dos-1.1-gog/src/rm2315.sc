;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2315)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Motion)
(use Actor)
(use System)

(public
	rm2315 0
)

(local
	local0
	local1
)

(instance rm2315 of ExitRoom
	(properties
		modNum 230
		picture 2315
		south 230 ; hellZooRm
	)

	(method (init)
		(super init: &rest)
		(self setRegions: 2299) ; zooRegion
		(= local1 (Random 2 3))
		(for ((= local0 0)) (< local0 local1) ((++ local0))
			(switch (Random 1 6)
				(1
					(pWolf1 init:)
				)
				(2
					(pWolf2 init:)
				)
				(3
					(pWolf3 init:)
				)
				(4
					(pWolf4 init:)
				)
				(5
					(pWolf5 init:)
				)
				(6
					(pWolf6 init:)
				)
			)
		)
		(gGame handsOn:)
	)

	(method (notify)
		(ClearFlag 443)
		(super notify: &rest)
	)
)

(class WolfProp of Prop
	(properties
		modNum 230
		x 316
		y 148
		view 20025
	)

	(method (init)
		(super init: &rest)
		(self setScript: (sFidget new:) 0 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((> global137 0)
					(cond
						((or (> gChapter 1) (gEgo has: 12)) ; invZooHair
							(gMessager say: 5 62 0 1 0 230) ; "(LOOK AT WOLVES)They don't LOOK dangerous."
						)
						((gEgo has: 10) ; invFarmHair
							(gMessager say: 8 62 0 1 0 230) ; "(LOOK AT WOLVES, THINKING OF A PLAN)Hmmm. If I could get some wolf hair, I could compare it with the hair from the farm."
						)
						(else
							(gMessager say: 4 62 0 1 0 230) ; "(FRUSTRATED)I'd really like to get a closer look at one of those wolves."
						)
					)
				)
				((> gChapter 1)
					(gMessager say: 5 62 0 1 0 230) ; "(LOOK AT WOLVES)They don't LOOK dangerous."
				)
				((not (IsFlag 430))
					(PlayScene 29)
					(SetFlag 430)
				)
				(else
					(PlayScene 1029)
					(++ global137)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pWolf1 of WolfProp
	(properties)
)

(instance pWolf2 of WolfProp
	(properties
		x 189
		y 112
		view 21025
	)
)

(instance pWolf3 of WolfProp
	(properties
		x 560
		y 124
		view 22025
	)
)

(instance pWolf4 of WolfProp
	(properties
		x 394
		y 139
		view 23025
	)
)

(instance pWolf5 of WolfProp
	(properties
		x 79
		y 152
		view 24025
	)
)

(instance pWolf6 of WolfProp
	(properties
		x 440
		y 135
		view 25025
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random register 3))
			)
			(1
				(client cel: 0 setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

