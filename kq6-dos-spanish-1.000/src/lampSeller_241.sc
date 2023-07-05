;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 241)
(include sci.sh)
(use Main)
(use n913)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	lampSeller 0
	lampSellerScr 1
)

(instance lampSeller of Actor
	(properties
		x 19
		y 128
		noun 4
		approachX 58
		approachY 128
		_approachVerbs -32766
		view 2431
		priority 7
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; huntersLamp
				(self setScript: (ScriptID 11 2)) ; lampTradeScr
			)
			(2 ; Talk
				(cond
					(((ScriptID 10 0) isSet: 16) ; rgCrown
						(self setScript: (ScriptID 11 3) 0 24) ; talkToSellerScr
					)
					((not ((ScriptID 10 0) isSet: 8)) ; rgCrown
						((ScriptID 10 0) setIt: 8) ; rgCrown
						(self setScript: (ScriptID 11 3) 0 22) ; talkToSellerScr
					)
					(((ScriptID 10 0) isSet: 8) ; rgCrown
						(self setScript: (ScriptID 11 3) 0 23) ; talkToSellerScr
					)
				)
			)
			(else
				(if (OneOf theVerb 1 5) ; Look, Do
					(gMessager say: noun theVerb 0 0 0 240)
				else
					(self setScript: (ScriptID 11 3) 0 -1) ; talkToSellerScr
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(polePoly init:)
		(self setScript: lampSellerScr)
	)

	(method (dispose)
		(super dispose:)
		(polePoly dispose:)
	)
)

(instance lampSellerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 241 0) loop: 0 cel: 0 setCycle: 0 setSpeed: 6) ; lampSeller
				(if register
					(= register 0)
				else
					(= register 1)
					(= state
						(switch (Random 0 2)
							(0 4)
							(1 5)
							(2 6)
						)
					)
					(-- state)
				)
				(= seconds (Random 5 8))
			)
			(1
				(if (not (gCurRoom script:))
					((ScriptID 241 0) loop: 2 cel: 0 setCycle: End) ; lampSeller
					(if (& gMsgType $0002)
						(if (<= (gEgo y:) 130)
							(= cycles 1)
						else
							(gMessager say: 1 0 19 1 self 240) ; "Old lamps for new!"
						)
					else
						(= cycles 6)
					)
				else
					(= cycles (= state 2))
				)
			)
			(2
				(SetFlag 59)
				(if (not (& gMsgType $0002))
					(gMessager say: 1 0 19 1 self 240) ; "Old lamps for new!"
				else
					(= ticks 6)
				)
			)
			(3
				(ClearFlag 59)
				(= state -1)
				(self cue:)
			)
			(4
				((ScriptID 241 0) ; lampSeller
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(= state -1)
			)
			(5
				((ScriptID 241 0) loop: 3 cel: 0) ; lampSeller
				(= seconds (Random 2 4))
				(= state -1)
			)
			(6
				((ScriptID 241 0) loop: 4 cel: 0) ; lampSeller
				(= ticks 45)
			)
			(7
				((ScriptID 241 0) loop: 5 cel: 0 setCycle: End self) ; lampSeller
				(= state -1)
			)
		)
	)

	(method (dispose)
		(ClearFlag 59)
		(= register 0)
		(super dispose:)
	)
)

(instance polePoly of Feature
	(properties
		x 19
		y 129
		noun 15
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PContainedAccess
				init: 21 134 36 123 39 117 44 124 30 137
				yourself:
			)
		)
		(super init: &rest)
	)
)

