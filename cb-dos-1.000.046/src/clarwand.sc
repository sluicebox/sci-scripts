;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	clarwand 0
)

(synonyms
	(attorney person man)
)

(local
	[local0 14] = [37 151 150 159 35 182 77 163 116 128 280 137 148 175]
	[local14 14] = [0 0 -20 140 -20 176 -20 124 110 105 319 113 259 240]
	[local28 14] = [90 134 340 145 108 240 119 240 -20 136 205 116 -20 170]
	[local42 8] = [22 23 29 30 8 7 6 18]
	local50
)

(instance clarwand of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0008))
			(Load rsFONT 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
			(Load rsVIEW 642)
		)
		(LoadMany rsMESSAGE 243 291)
		(Load rsVIEW 906)
		(= [global377 6] 291)
		(if (== [gCycleTimers 3] 0)
			(= [gCycleTimers 3] 700)
			(= gJeevesChoresState 0)
		)
		(Clarence illegalBits: -32768 ignoreHorizon: 1)
		(if
			(and
				(== [local42 (- 7 gJeevesChoresState)] gCurRoomNum)
				(>= [gCycleTimers 3] (* (- 6 gJeevesChoresState) 100))
			)
			(|= global208 $0040)
			(= [gCycleTimers 3] (- 699 (* gJeevesChoresState 100)))
			(= local50 1)
			(Clarence
				setAvoider: ((Avoid new:) offScreenOK: 1)
				setCycle: Walk
				posn: [local0 (* gJeevesChoresState 2)] [local0 (+ (* gJeevesChoresState 2) 1)]
				setMotion:
					MoveTo
					[local28 (* gJeevesChoresState 2)]
					[local28 (+ (* gJeevesChoresState 2) 1)]
				init:
			)
			(self setScript: clarActions)
		)
	)

	(method (doit)
		(if
			(and
				(== (mod [gCycleTimers 3] 100) 0)
				(== [local42 (/ [gCycleTimers 3] 100)] gCurRoomNum)
			)
			(= local50 1)
			(|= global208 $0040)
			(= gJeevesChoresState (- 7 (/ [gCycleTimers 3] 100)))
			(Clarence
				setAvoider: ((Avoid new:) offScreenOK: 1)
				setCycle: Walk
				posn: [local14 (* gJeevesChoresState 2)] [local14 (+ (* gJeevesChoresState 2) 1)]
				setMotion:
					MoveTo
					[local28 (* gJeevesChoresState 2)]
					[local28 (+ (* gJeevesChoresState 2) 1)]
				init:
			)
			(self setScript: clarActions)
		)
		(super doit:)
	)

	(method (dispose)
		(if local50
			(if (> (Clarence y:) 200)
				(++ gJeevesChoresState)
				(if (== [local42 (- 7 gJeevesChoresState)] 22)
					(= [gCycleTimers 3] 1)
				else
					(= [gCycleTimers 3] (- 699 (* gJeevesChoresState 100)))
				)
			else
				(= [gCycleTimers 3] (- 620 (* gJeevesChoresState 100)))
			)
		)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				global208
				(Said 'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>')
			)
			(Clarence setScript: (ScriptID 243 0)) ; atsgl
			((Clarence script:) handleEvent: event)
		)
	)
)

(instance clarActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(if
					(and
						(== (Clarence x:) [local28 (* gJeevesChoresState 2)])
						(== (Clarence y:) [local28 (+ (* gJeevesChoresState 2) 1)])
					)
					(= state 1)
				else
					(= state 0)
				)
				(= cycles 1)
			)
			(2
				(= local50 0)
				(++ gJeevesChoresState)
				(if (== [local42 (- 7 gJeevesChoresState)] 22)
					(= [gCycleTimers 3] 1)
				else
					(= [gCycleTimers 3] (- 699 (* gJeevesChoresState 100)))
				)
				(&= global208 $ffbf)
				(= [global377 6] 0)
				(Clarence dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance Clarence of Act
	(properties
		view 400
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'talk/attorney')
				(Print 203 0) ; "Clarence isn't in the mood to talk."
			)
			((and (MousedOn self event 3) (not (& global207 $0040)))
				(event claimed: 1)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(event claimed: 1)
				(Print 203 1) ; "Well, well. Who do we have here? Why, it's Clarence!"
			)
		)
	)
)

