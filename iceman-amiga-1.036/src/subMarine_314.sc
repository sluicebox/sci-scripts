;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 314)
(include sci.sh)
(use Main)
(use Interface)
(use Submarine_806)
(use n821)
(use Game)
(use System)

(public
	subMarine 0
)

(class subMarine of Rgn
	(properties
		roomFlags 0
		nutSize 0
		washerSize 0
		cylDiam 0
		holeSize 0
		dist1 0
		head1 0
		dist2 0
		head2 0
		suitRoom 0
		msg12 0
		msg34 0
		msg56 0
		pointFlag1 0
		pointFlag2 0
		invStatus1 0
		invStatus2 0
		invStatus3 0
		invStatus4 0
	)

	(method (init)
		(super init: &rest)
		(Submarine init: floor: 1000)
		(self setScript: subMarineScript)
		(gIceGlobalSound number: 11 loop: -1 owner: self play:)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(= keep
			(OneOf
				newRoomNumber
				25 ; controlRm
				26 ; scopeViewRm
				27 ; controlPanel
				28 ; bridgeRm
				29
				30 ; captsQuartersRm
				31 ; egosQuartersRm
				32 ; galleyRm
				33 ; torpedoRm
				34 ; machineRm
				35 ; storageRm
				36 ; passagewayRm2
				37 ; engineRm
				38 ; escapeHatchRm
				39 ; diceRm
				40 ; chartRm
				41 ; hatchTubeRm
				42 ; bHatchTubeRm
				51 ; scubaCycle
				50 ; launchDiver
			)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'use/device[<electronic]')
				(if (gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
					(Print 314 0) ; "The highly sophisticated electronic device in your possession may cause damage to other sensitive equipment if turned on at this time."
				else
					(event claimed: 0)
				)
			)
			((Said '/cylinder>')
				(cond
					((== gCurRoomNum 33)) ; torpedoRm
					(
						(and
							(not (proc0_4 4352))
							(or (Said 'look') (Said 'measure'))
						)
						(Print 314 1) ; "Sorry, not enough memory."
						(event claimed: 1)
					)
					((Said 'look')
						((ScriptID 318 0) doit:) ; lookCyl
					)
					((Said 'measure')
						((ScriptID 318 1) doit:) ; measureCyl
					)
				)
			)
		)
	)

	(method (doit)
		(Submarine doit:)
		(super doit:)
	)
)

(instance subMarineScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(3
				(= cycles 2000)
			)
			(4
				(if (>= argc 2)
					(= cycles 1)
				else
					(EgoDead 7 0 0 314 2) ; "You shouldn't take what the Captain says lightly. Next time follow orders."
				)
			)
			(8
				(= cycles 400)
			)
			(9
				(if (< argc 2)
					(EgoDead 7 0 0 314 3) ; "The Russian destroyer has put a torpedo in the side of the Blackhawk, thanks to you!"
				else
					(= cycles 0)
				)
			)
			(15
				(= cycles 12000)
			)
			(16
				(if (>= argc 2)
					(= cycles 1)
				else
					(EgoDead 7 0 0 314 4) ; "Having taken too much time, the mission has been scrubbed!"
				)
			)
			(else 0)
		)
	)
)

