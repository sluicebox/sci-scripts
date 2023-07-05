;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 378)
(include sci.sh)
(use Main)
(use servent)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	ClarSit 0
)

(synonyms
	(attorney person man)
)

(local
	local0
	[local1 2]
	local3
)

(instance Jeeves of servent
	(properties)
)

(instance ClarSit of Rgn
	(properties)

	(method (init)
		(super init:)
		(LoadMany rsMESSAGE 243 218)
		(LoadMany rsSYNC 7)
		(= global208 64)
		(= [global377 6] 218)
		(ClarAss init: stopUpd:)
		(Clarence setPri: 6 init: setScript: clarActions)
		(Smoke setPri: 6 init: hide:)
		(if (not (& global194 $0002))
			(|= global194 $0002)
			(Jeeves
				view: 444
				posn: -15 98
				setCycle: Walk
				guest1: ClarAss
				exitX: -10
				exitY: 98
				itemX: 178
				itemY: 108
				setAvoider: ((Avoid new:) offScreenOK: 1)
				init:
			)
		)
	)

	(method (doit)
		(if (< local3 50)
			(++ local3)
		else
			(= global167 1)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 204)
		(DisposeScript 975)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/attorney')
							(if (& global207 $0040)
								(Print 378 0) ; "Clarence sits sullenly at the bar, a slight scowl on his face."
							else
								(event claimed: 0)
							)
						)
						((Said '/butt')
							(SetFlag 13)
							(Print 378 1) ; "That's a big cigar!"
						)
						((Said '/drink,glass')
							(Print 378 2) ; "Clarence is drinking cognac at the bar."
						)
					)
				)
				((Said 'talk>')
					(if (Said '/attorney')
						(Print 378 3) ; "Clarence sits there, smoking his cigar. He doesn't answer."
					)
				)
				((Said 'listen/attorney')
					(Print 378 4) ; "Clarence isn't talking."
				)
				((Said 'get/butt')
					(Print 378 5) ; "He wouldn't give it to you!"
				)
				((Said 'get/drink,glass')
					(Print 378 6) ; "You don't care for liquor...remember?"
				)
			)
		)
	)
)

(instance clarActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Clarence loop: 5 cel: 0 setCycle: End self)
			)
			(1
				(Clarence loop: 4 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(Smoke cel: 0 setCycle: End self show:)
				(if (< local0 1)
					(++ local0)
					(= state 0)
				else
					(= local0 0)
				)
			)
			(3
				(Smoke cel: 0 hide:)
				(Clarence loop: 1 cel: 5 cycleSpeed: 2 setCycle: Beg)
				(= seconds (Random 6 12))
			)
			(4
				(Clarence loop: 2 cel: 0 setCycle: End)
				(= seconds (Random 6 12))
				(= state -1)
			)
		)
	)
)

(instance Clarence of Prop
	(properties
		y 74
		x 171
		view 401
		loop 1
	)

	(method (handleEvent event)
		(cond
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
				(Print 378 0) ; "Clarence sits sullenly at the bar, a slight scowl on his face."
			)
		)
	)
)

(instance ClarAss of Prop
	(properties
		y 102
		x 168
		view 401
		cel 2
	)
)

(instance Smoke of Prop
	(properties
		y 60
		x 167
		view 401
		loop 6
	)
)

