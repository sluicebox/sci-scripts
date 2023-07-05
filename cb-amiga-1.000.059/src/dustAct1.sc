;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	dustAct1 0
)

(synonyms
	(fifi person woman)
)

(local
	local0
	[local1 2]
)

(instance dustAct1 of Rgn
	(properties)

	(method (init)
		(super init:)
		(= global195 16)
		(LoadMany rsVIEW 470 904)
		(Fifi
			view: 464
			setAvoider: (Avoid new:)
			illegalBits: -16378
			init:
			setScript: fifiActions
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
	)
)

(instance fifiActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Fifi
					view: 464
					setPri: -1
					setCycle: Walk
					illegalBits: -16378
					ignoreActors: 0
				)
				(Fifi
					setMotion:
						MoveTo
						(switch local0
							(0 225)
							(1 62)
							(2 106)
							(3 208)
							(4 151)
							(5 166)
							(6 196)
							(7 209)
						)
						(switch local0
							(0 153)
							(1 167)
							(2 115)
							(3 108)
							(4 93)
							(5 93)
							(6 93)
							(7 108)
						)
						self
				)
			)
			(1
				(Fifi
					view: 470
					setPri: (if (== local0 1) 14 else -1)
					cel: 0
					illegalBits: 0
					loop:
						(switch local0
							(0 1)
							(1 5)
							(2 1)
							(3 4)
							(4 1)
							(5 0)
							(6 4)
							(7 4)
						)
					setCycle: End self
				)
			)
			(2
				(Fifi
					loop:
						(switch local0
							(0 3)
							(1 7)
							(2 3)
							(3 6)
							(4 3)
							(5 2)
							(6 6)
							(7 6)
						)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(3
				(Fifi cel: 2 setCycle: Beg self)
				(if (< local0 7)
					(++ local0)
				else
					(= local0 0)
				)
				(= state -1)
			)
		)
	)
)

(instance Fifi of Act
	(properties
		y 140
		x 196
	)

	(method (handleEvent event)
		(cond
			((Said 'give,show/*')
				(if (and global219 global224)
					(Print 380 0) ; "Fifi doesn't have time for idle chitchat. She's too busy cleaning the Colonel's study."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'ask,tell//*<about')
				(Print 380 0) ; "Fifi doesn't have time for idle chitchat. She's too busy cleaning the Colonel's study."
			)
			((or (MousedOn self event 3) (Said 'look/fifi'))
				(event claimed: 1)
				(if (not (& global207 $0010))
					(|= global207 $0010)
					(= global213 5)
					(Say 0 380 1) ; "Fifi is the Colonel's pretty French maid. You surmise that she is probably very apt in her duties...whatever THEY may be! Fifi is young, blonde, and sexy. Although she seems to have a vivacious personality, you can sense a certain cunning underneath it all."
				else
					(Print 380 2) ; "Currently, Fifi looks to be busily cleaning the Colonel's study."
				)
			)
			((Said '/fifi>')
				(cond
					((Said 'get')
						(Print 380 3) ; "You can't get her!"
					)
					((Said 'kill')
						(Print 380 4) ; "There's no need for THAT sort of thing!"
					)
					((Said 'kiss')
						(Print 380 5) ; "You don't feel like kissing her."
					)
					((Said 'embrace')
						(Print 380 6) ; "You don't feel like hugging her."
					)
					((Said 'talk')
						(Print 380 0) ; "Fifi doesn't have time for idle chitchat. She's too busy cleaning the Colonel's study."
					)
				)
			)
		)
	)
)

