;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 279)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	pray 0
)

(synonyms
	(celie person woman)
)

(local
	local0
)

(instance Celie of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0002)))
				(|= global207 $0002)
				(= global213 2)
				(event claimed: 1)
				(Say 0 279 0) ; "Celie is the Colonel's cook. She is an overweight black lady who, on the surface, seems to be distant and unfriendly. However, you sense that she is probably a very nice person just "mindin' her own bizness." You have heard that Celie practices voodoo and you wonder about this."
			)
			(
				(and
					(& global207 $0002)
					(or (MousedOn self event 3) (Said 'look/celie'))
				)
				(event claimed: 1)
				(Print 279 1) ; "Celie sits in a pew before the pulpit, her head bent in fearful prayer."
			)
			((Said 'ask,tell//*<about')
				(Print 279 2) ; "Celie's not listening to you. She's visibly frightened and deep in prayer."
			)
			((Said 'give,show/*')
				(if (and global219 global224)
					(Print 279 3) ; "Celie's not paying any attention to you. She's too engrossed in her praying."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said '/celie>')
				(cond
					((Said 'talk')
						(= global213 2)
						(switch local0
							(0
								(Say 1 279 4) ; "What're you doin' here, girl?! Somethin' mighty turrible is happenin'! Evil spirits is all 'round us. I think we're a'goin' to die before this night is over!!"
							)
							(1
								(Say 1 279 5) ; "Pray, chile, pray! Mebbe the Good Lord'll show some pity on us and help us!"
							)
							(else
								(Print 279 6) ; "Celie is deep in prayer. She pays no more attention to you."
							)
						)
						(++ local0)
					)
					((Said 'get')
						(Print 279 7) ; "You can't get her!"
					)
					((Said 'kill')
						(Print 279 8) ; "There's no need for THAT sort of thing!"
					)
					((Said 'kiss')
						(Print 279 9) ; "You don't feel like kissing her."
					)
					((Said 'embrace')
						(Print 279 10) ; "You don't feel like hugging her."
					)
				)
			)
		)
	)
)

(instance pray of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(= global195 2)
		(if (not (& gMustDos $0008))
			(Load rsFONT 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
			(Load rsVIEW 642)
		)
		(Celie view: 481 loop: 0 posn: 142 105 init:)
		(self setScript: praying)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
	)
)

(instance praying of Script
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
				(cls)
				(User canInput: 1)
				(Celie loop: 0 setCycle: End)
			)
			(2
				(User canInput: 0)
				(Celie setCycle: Beg self)
			)
			(3
				(Celie loop: 1 setCycle: Fwd)
				(= state 0)
				(= seconds 5)
			)
		)
	)
)

