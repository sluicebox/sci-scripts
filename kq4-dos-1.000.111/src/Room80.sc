;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room80 0
)

(local
	local0
)

(instance fallMusic of Sound
	(properties)
)

(instance Room80 of Rm
	(properties
		picture 80
	)

	(method (init)
		(Load rsVIEW 603)
		(Load rsSOUND 52)
		(super init:)
		(= gIndoors 0)
		((= local0 (Prop new:)) view: 603 posn: 288 117 init: stopUpd:)
		(if (or (== gPrevRoomNum 79) (== gPrevRoomNum 0))
			(gEgo posn: 279 167 view: 2 xStep: 2 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 92)
			(gEgo view: 2 posn: 266 123 xStep: 2 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 94)
			(gEgo view: 2 posn: 185 135 xStep: 2 yStep: 1 init:)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0010)
			(gCurRoom newRoom: 94)
		)
		(if (& (gEgo onControl:) $1000)
			(gCurRoom newRoom: 79)
		)
		(if (& (gEgo onControl: 1) $0004)
			(self setScript: falling)
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'open/door')
						(if (< (gEgo distanceTo: local0) 25)
							(HandsOff)
							(gEgo setMotion: 0)
							(local0 ignoreActors: 1 setCycle: End doDoor)
						else
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said 'look>')
						(cond
							((Said '/around,room')
								(Print 80 0) ; "You are standing before Lolotte's dark castle on the edge of the rocky mountain. There is a small stable next to it."
							)
							((Said '/castle')
								(Print 80 1) ; "Lolotte's sinister castle is situated on a rocky ledge of the steep craggy mountain. A small stable is located beside it."
							)
							((Said '/barn')
								(Print 80 2) ; "The crude thatch-roofed stable is located near the dark castle, on the edge of a cliff."
							)
							((Said '/cliff')
								(Print 80 3) ; "The mountains are rocky and steep. The castle perches precariously upon a large ledge."
							)
							((Said '/path')
								(Print 80 4) ; "The narrow path leads down the mountain."
							)
							((Said '/door')
								(Print 80 5) ; "The door has hideous carvings."
							)
						)
					)
				)
			)
		)
	)
)

(instance doDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gCurRoom newRoom: 92)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gEgo
					view: 17
					setStep: 5 6
					setLoop: 3
					setMotion: MoveTo (- (gEgo x:) 15) 230 self
				)
				(fallMusic number: 52 loop: 1 play:)
			)
			(1
				(= seconds 3)
			)
			(2
				(fallMusic dispose:)
				(ShakeScreen 6)
				(= seconds 3)
			)
			(3
				(= gDeathFlag 1)
			)
		)
	)
)

