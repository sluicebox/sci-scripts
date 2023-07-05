;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm074 0
)

(local
	local0
	local1
)

(instance rm074 of Rm
	(properties
		picture 74
		south 72
		west 73
	)

	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(self setRegions: 600) ; ortega
		(Load rsVIEW 68)
		(Load rsVIEW 97)
		(super init:)
		(switch gPrevRoomNum
			(72
				(gEgo init: illegalBits: 16384 setPri: 14 posn: 225 187)
			)
			(73
				(if global255
					(gCurRoom setScript: UpStairs)
				else
					(gEgo posn: 2 (gEgo y:) init:)
				)
			)
			(75
				(if global256
					(gLongSong number: 71 loop: -1 priority: 0 play:)
				else
					(gLongSong number: 51 loop: -1 priority: 0 play:)
				)
				(gCurRoom setScript: DownLadder)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not script)
			(if local0
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

	(method (doit &tmp temp0)
		(super doit:)
		(if local0
			(gCurRoom newRoom: 73)
		)
		(if local1
			(gCurRoom newRoom: 75)
		)
		(if (== (gEgo view:) 68)
			(if (> (gEgo y:) 174)
				(gEgo setPri: 13)
			else
				(gEgo setPri: -1)
			)
		)
		(if
			(and
				(not (gCurRoom script:))
				(== (gEgo onControl:) 5)
				(!= (gEgo view:) 68)
			)
			(self setScript: DownStairs)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look>')
				(cond
					((Said '[/area,around]')
						(if (== (gEgo view:) 0)
							(Print 74 0) ; "You are on a platform on the rim of the volcanic crater. A stairway leads down to the base of the massive force field generator."
						else
							(Print 74 1) ; "You are at the base of the massive generator. A ladder leads up to the top."
						)
					)
					((Said '/lava')
						(Print 74 2) ; "There's not too much lava around here. This is one of the few stable spots on the surface of Ortega."
					)
					((Said '/ladder')
						(Print 74 3) ; "A ladder runs to the top of the generator."
					)
					((Said '/stair')
						(Print 74 4) ; "The stairs lead to the base of the generator."
					)
					((Said '/banister')
						(Print 74 5) ; "For people that have trouble with stairs, the rail can be helpful."
					)
					((Said '/machine,building,generator')
						(cond
							((not global256)
								(if global170
									(Print 74 6) ; "It's pointing to a small moon high in the Ortegian sky.  Pulsating circular energy fields are being emitted into space toward the moon."
								else
									(Print 74 7) ; "It's pointing into the Ortegian sky. Pulsating circular energy fields are being emitted into space."
								)
							)
							(global170
								(Print 74 8) ; "It's pointing to a small moon high in the Ortegian sky.  The beam is no longer being emitted. %g Das Ding zeigt auf einen kleinen Mond hoch droben im orteganischen Himmel. Es wird kein Energiestrahl mehr ausgesandt."
							)
							(else
								(Print 74 9) ; "It's pointing into the Ortegian sky. The beam is no longer being emitted."
							)
						)
					)
					((Said '/beam')
						(if (not global256)
							(if global170
								(Print 74 10) ; "The pulsating energy field is being emitted into space toward Pestulon."
							else
								(Print 74 11) ; "The pulsating energy field is being emitted into space."
							)
						else
							(Print 74 12) ; "It's no longer beaming."
						)
					)
					((Said '/pedestal')
						(Print 74 13) ; "It was built to give easy access over the rocky surface."
					)
				)
			)
			((Said 'up,climb,(climb[<up])[/ladder]')
				(if (gEgo inRect: 146 108 163 112)
					(gCurRoom setScript: UpLadder)
				else
					(Print 74 14) ; "You're not close enough to the ladder."
				)
			)
		)
	)
)

(instance DownStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setLoop: 1
					illegalBits: 0
					setMotion: MoveTo 88 216 self
				)
			)
			(1
				(= local0 1)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance UpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 0
					posn: 88 216
					setLoop: 0
					setPri: 14
					setStep: 3 2
					illegalBits: 0
					init:
				)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 138 175 self)
			)
			(2
				(gEgo setLoop: -1 illegalBits: 16384)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance UpLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(RedrawCast)
				(gEgo
					posn: 154 107
					view: 97
					setLoop: 0
					setMotion: MoveTo 154 65 self
				)
			)
			(1
				(gEgo posn: 153 65 setMotion: MoveTo 153 31 self)
			)
			(2
				(gEgo posn: 152 31 setMotion: MoveTo 152 13 self)
			)
			(3
				(gEgo posn: 151 13 setMotion: MoveTo 151 -2 self)
			)
			(4
				(HandsOn)
				(= local1 1)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance DownLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					posn: 151 -2
					view: 97
					illegalBits: 0
					setLoop: 0
					setMotion: MoveTo 151 13 self
				)
			)
			(1
				(gEgo posn: 152 13 setMotion: MoveTo 152 31 self)
			)
			(2
				(gEgo posn: 153 31 setMotion: MoveTo 153 65 self)
			)
			(3
				(gEgo posn: 154 65 setMotion: MoveTo 154 109 self)
			)
			(4
				(gEgo view: 68 setLoop: -1 setStep: 2 2 illegalBits: -32768)
				(= cycles 2)
			)
			(5
				(gEgo loop: 3)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

