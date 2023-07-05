;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	Town 0
)

(instance Town of Locale
	(properties)

	(method (init)
		(if (not (OneOf gCurRoomNum 300 310 320 330 333 334))
			(gContMusic stop:)
		)
		(super init: &rest)
	)

	(method (handleEvent event &tmp [temp0 5])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'cast')
						(HighPrint 801 0) ; "Your spells seem to have no effect here."
					)
					((Said 'nap')
						(HighPrint 801 1) ; "You really can't sleep here."
					)
					((and (gEgo has: 16) (Said 'open/box,musicbox')) ; music box
						(HighPrint 801 2) ; "That would be a very bad idea. Someone would hear you playing the Sheriff's music box, and you would probably be arrested."
					)
					((Said 'throw,fight,hit,cut,kill[/*]')
						(if (== gCurRoomNum 334)
							(event claimed: 0)
						else
							(gEndBattle number: 92 loop: 1 play:)
							(HighPrint 801 3) ; "Despite your intentions, you feel a calmness and a sense of peace descend upon you as you even consider thoughts of violence."
						)
					)
				)
			)
		)
	)
)

