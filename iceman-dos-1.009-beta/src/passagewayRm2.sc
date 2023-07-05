;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	passagewayRm2 0
)

(instance passagewayRm2 of Rm
	(properties
		picture 36
		east 34
		west 37
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(east
				(gEgo x: 283 y: 72 loop: 1)
			)
			(35 ; storageRm
				(gEgo x: 311 y: 159 loop: 1)
			)
			(else
				(gIceGlobalSound number: 11 loop: -1 owner: gGame priority: 1 play:)
				(gEgo x: 31 y: 72 loop: 0)
			)
		)
		(gEgo init:)
	)

	(method (newRoom newRoomNumber)
		(if (> (gEgo y:) 80)
			(= newRoomNumber 35) ; storageRm
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(Print 36 0) ; "This passageway connects the machinery and engine room compartments."
				(Print 36 1) ; "This is a special "shielded" passageway that is located over the boats nuclear reactor."
			)
			((Said 'look/reactor')
				(Print 36 2) ; "The reactor is of no special interest."
			)
			((Said 'get/reactor')
				(Print 36 3) ; "Even if you could get it, it would be extremely hazardous to your health."
			)
		)
	)
)

