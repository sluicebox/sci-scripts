;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	csleep 0
)

(synonyms
	(attorney person man)
)

(local
	[local0 2]
)

(instance Clarence of Prop
	(properties
		y 92
		x 242
		view 413
	)

	(method (handleEvent event)
		(if
			(or
				(Said 'look/attorney')
				(Said 'look[<at]/bed')
				(MousedOn self event 3)
			)
			(event claimed: 1)
			(Print 260 0) ; "Clarence seems to be resting in his bed."
		)
	)
)

(instance csleep of Rgn
	(properties)

	(method (init)
		(super init:)
		(= global195 64)
		(Clarence setPri: 6 cycleSpeed: 4 setCycle: Fwd init:)
		(snores setPri: 6 init:)
		(LoadMany rsSOUND 114 115)
	)

	(method (doit)
		(if (and (== (snoring prevSignal:) -1) (== (snoring number:) 114))
			(snoring number: 115 loop: 1 prevSignal: 0 play:)
		)
		(if (== (Clarence cel:) 0)
			(snoring number: 114 loop: 1 play:)
			(snores cel: 0 setCycle: End)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'give,show/*')
					(if (and global219 global224)
						(Print 260 1) ; "Clarence must be tired. Perhaps you ought to tiptoe out and leave him alone."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'ask,tell//*<about')
					(Print 260 1) ; "Clarence must be tired. Perhaps you ought to tiptoe out and leave him alone."
				)
				((and (Said '(*,!*)>') (Said '/attorney'))
					(Print 260 1) ; "Clarence must be tired. Perhaps you ought to tiptoe out and leave him alone."
				)
			)
		)
	)
)

(instance snores of Prop
	(properties
		y 68
		x 228
		view 413
		loop 1
		cycleSpeed 1
	)
)

(instance snoring of Sound
	(properties)
)

