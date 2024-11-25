;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use System)

(public
	rm072 0
)

(instance rm072 of Rm
	(properties
		picture 72
		north 74
		south 71
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(super init:)
		(switch gPrevRoomNum
			(71
				(gEgo
					init:
					posn:
						(cond
							((< (gEgo x:) 67) 67)
							((< (gEgo x:) 193) 193)
							(else
								(gEgo x:)
							)
						)
						187
				)
				(RedrawCast)
				(if global256
					(gLongSong number: 71 loop: -1 priority: 0 play:)
				else
					(gLongSong number: 51 loop: -1 priority: 0 play:)
				)
				(Print 72 0) ; "You reach the rim of the decayed cinder cone and are overwhelmed by the sight. An impressive machine of staggering size sits in the middle of the volcanic crater."
			)
			(74
				(gCurRoom setScript: EnterScript)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (== (gEgo onControl:) 3) (not (gCurRoom script:)))
			(self setScript: LeaveScript)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look/device,building,generator')
				(cond
					((not global256)
						(if global170
							(Print 72 1) ; "It's pointing to a small moon high in the Ortegian sky.  Pulsating circular energy fields are being emitted into space toward the moon."
						else
							(Print 72 2) ; "It's pointing into the Ortegian sky. Pulsating circular energy fields are being emitted into space."
						)
					)
					(global170
						(Print 72 3) ; "It's pointing to a small moon high in the Ortegian sky.  The beam is no longer being emitted."
					)
					(else
						(Print 72 4) ; "It's pointing into the Ortegian sky. The beam is no longer being emitted."
					)
				)
			)
			((Said 'look/beam')
				(if (not global256)
					(if global170
						(Print 72 5) ; "The pulsating energy field is being emitted into space toward Pestulon."
					else
						(Print 72 6) ; "The pulsating energy field is being emitted into space."
					)
				else
					(Print 72 7) ; "It's no longer beaming."
				)
			)
			((Said 'look/butte')
				(Print 72 8) ; "The rim of the crater towers over you. Though somewhat eroded, it is still quite tall."
			)
		)
	)
)

(instance EnterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 3
					setLoop: 0
					illegalBits: 0
					posn: 217 156
					init:
					setMotion: MoveTo 241 132 self
				)
			)
			(1
				(gEgo setLoop: 2 setMotion: MoveTo 241 144 self)
			)
			(2
				(gEgo setLoop: -1 illegalBits: $8000 setPri: -1)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance LeaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 3
					setLoop: 1
					illegalBits: 0
					setMotion: MoveTo 217 156 self
				)
			)
			(1
				(gEgo setLoop: -1)
				(HandsOn)
				(if global256
					(++ global593)
				)
				(gCurRoom newRoom: 74)
			)
		)
	)
)

