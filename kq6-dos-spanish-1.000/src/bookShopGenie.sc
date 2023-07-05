;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 271)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	bookShopGenie 0
	genieKickingItScr 1
)

(local
	local0
	local1
)

(instance genieEye of Prop
	(properties
		x 183
		y 82
		view 902
		loop 1
	)
)

(instance genieKickingItScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 5 10))
			)
			(2
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(= ticks 60)
			)
			(4
				(if (or (not (- (Random 0 2) 1)) (not local1))
					(= local1 1)
					(genieEye init: cel: 0 setCycle: End self)
				else
					(+= state 2)
					(= cycles 2)
				)
			)
			(5
				(= ticks 6)
			)
			(6
				(genieEye dispose:)
				(= cycles 2)
			)
			(7
				(= ticks (Random 60 120))
			)
			(8
				(client setCycle: Beg self)
			)
			(9
				(= state -1)
				(= seconds (Random 10 15))
			)
		)
	)

	(method (dispose)
		(if (gCast contains: genieEye)
			(genieEye dispose:)
		)
		(super dispose:)
	)
)

(instance bookShopGenie of Actor
	(properties
		x 179
		y 117
		noun 9
		approachX 212
		approachY 123
		view 275
		priority 1
		signal 16400
		scaleSignal 1
		scaleX 113
		scaleY 113
	)

	(method (doVerb theVerb)
		(if (== theVerb 63) ; mint
			(gCurRoom setScript: (ScriptID 278)) ; giveMintScr
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(self setScript: genieKickingItScr approachVerbs: 2 0) ; Talk
	)
)

