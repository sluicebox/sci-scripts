;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 224)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	sleeping 0
)

(synonyms
	(gertie person woman)
)

(local
	local0
)

(instance snoring of Sound
	(properties)
)

(instance sleeping of Rgn
	(properties)

	(method (init)
		(super init:)
		(= global195 1)
		(LoadMany rsFONT 41)
		(LoadMany rsVIEW 642 900)
		(LoadMany rsSOUND 29 94 95 96 114 115)
		(LoadMany rsMESSAGE 406)
		(Gertie setPri: 6 setCycle: Fwd init:)
		(snores setPri: 6 init:)
	)

	(method (doit)
		(super doit:)
		(if (and global216 (not (& gMustDos $0004)))
			(|= gMustDos $0004)
			(self setScript: (ScriptID 406 0)) ; Clock
		)
		(if (and (== (snoring prevSignal:) -1) (== (snoring number:) 114))
			(snoring number: 115 loop: 1 prevSignal: 0 play:)
		)
		(if (== (Gertie cel:) 0)
			(snoring number: 114 loop: 1 play:)
			(snores cel: 0 setCycle: End)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(= global213 1)
			(cond
				((Said 'give,show/*')
					(if (and global219 global224)
						(Print 224 0) ; "Zzzzzzzzzzzzzzz."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((or (Said 'ask,tell//*<about') (Said 'talk'))
					(switch local0
						(0
							(Say 1 224 1) ; "I'm trying to rest! It's been a long...zzzzzzzzzzzzzzz."
							(++ local0)
						)
						(1
							(Print 224 0) ; "Zzzzzzzzzzzzzzz."
						)
					)
					(event claimed: 1)
				)
				((Said '/gertie>')
					(cond
						((Said 'look')
							(if (& global207 $0001)
								(Print 224 2) ; "Gertie looks awfully tired. Perhaps you shouldn't bother her."
							else
								(|= global207 $0001)
								(Say 0 224 3) ; "Gertrude Dijon is the Colonel's widowed sister-in-law. She obviously is behind the times, as she looks like she has just stepped out of the gay '90's! A bit of a snob, she walks around with her nose up in the air and has an annoying habit of constantly playing with her many strands of pearls."
							)
						)
						((Said 'listen')
							(Print 224 4) ; "She's not talking."
						)
						((Said 'awaken,kill,embrace,kiss,get,hit,move')
							(Print 224 5) ; "Gertie's tired. Leave her alone."
						)
					)
				)
			)
		)
	)
)

(instance Gertie of Prop
	(properties
		y 86
		x 214
		view 344
		cycleSpeed 16
	)

	(method (handleEvent event)
		(cond
			((Said 'look[<at]/bed')
				(Print 224 2) ; "Gertie looks awfully tired. Perhaps you shouldn't bother her."
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {gertie})
			)
		)
	)
)

(instance snores of Prop
	(properties
		y 68
		x 228
		view 344
		loop 1
		cycleSpeed 1
	)
)

