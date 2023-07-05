;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm073 0
)

(instance rm073 of Rm
	(properties
		picture 73
		east 74
		south 74
	)

	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(self setRegions: 600) ; ortega
		(Load rsVIEW 68)
		(super init:)
		(gEgo view: 68 setStep: 2 2 illegalBits: -32768 setLoop: -1 init:)
		(if global255
			(self setScript: WalkIn)
		else
			(gEgo posn: 316 (gEgo y:))
		)
	)

	(method (newRoom newRoomNumber &tmp [temp0 50])
		(if (not script)
			(if (> (gEgo y:) 140)
				(= global255 1)
			else
				(= global255 0)
			)
			(if global256
				(++ global593)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '[/area,around]')
						(Print 73 0) ; "You stand at the massive base of a force beam generator. This unit can generate a force field powerful enough to encircle a small moon."
					)
					((Said '/lava')
						(Print 73 1) ; "There's not too much lava around here. This is one of the few stable spots on the surface of Ortega."
					)
					((Said '/device,building,generator')
						(cond
							((not global256)
								(if global170
									(Print 73 2) ; "It's pointing to a small moon high in the Ortegian sky.  Pulsating circular energy fields are being emitted into space toward the moon."
								else
									(Print 73 3) ; "It's pointing into the Ortegian sky. Pulsating circular energy fields are being emitted into space."
								)
							)
							(global170
								(Print 73 4) ; "It's pointing to a small moon high in the Ortegian sky.  The beam is no longer being emitted."
							)
							(else
								(Print 73 5) ; "It's pointing into the Ortegian sky. The beam is no longer being emitted."
							)
						)
					)
					((Said '/beam')
						(if (not global256)
							(if global170
								(Print 73 6) ; "The pulsating energy field is being emitted into space toward Pestulon."
							else
								(Print 73 7) ; "The pulsating energy field is being emitted into space."
							)
						else
							(Print 73 8) ; "It's no longer beaming."
						)
					)
				)
			)
			((Said 'climb')
				(Print 73 9) ; "There's nothing to climb here."
			)
		)
	)
)

(instance WalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 195 197
					loop: 3
					setPri: -1
					setMotion: MoveTo 195 187 self
				)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

