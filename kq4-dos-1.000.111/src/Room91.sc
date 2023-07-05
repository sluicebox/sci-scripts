;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
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
	Room91 0
)

(local
	local0
)

(instance theMusic of Sound
	(properties)
)

(instance Room91 of Rm
	(properties
		picture 91
		style 16
	)

	(method (init)
		(Load rsVIEW 141)
		(Load rsVIEW 636)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		(Notify 604 0)
		((Prop new:)
			view: 636
			loop: 0
			posn: 133 61
			setPri: 15
			init:
			setCycle: Fwd
		)
		(if (or (== gPrevRoomNum 92) (== gPrevRoomNum 0))
			(gEgo posn: 291 153 view: 4 setStep: 4 1 init:)
			(if global175
				(gEgo x: 275)
				((= local0 (Act new:))
					view: 141
					posn: (+ (gEgo x:) 25) (gEgo y:)
					illegalBits: 0
					setStep: 6 4
					setCycle: Walk
					init:
					setScript: henchChase
				)
			)
		)
		(if (== gPrevRoomNum 89)
			(gEgo posn: 253 124 view: 4 xStep: 4 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 90)
			(gEgo posn: 27 154 view: 4 setStep: 4 1 init:)
			(if global175
				((= local0 (Act new:))
					view: 141
					posn: (- (gEgo x:) 30) (gEgo y:)
					illegalBits: 0
					setStep: 6 4
					setCycle: Walk
					init:
					setScript: henchChase
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 90)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gCurRoom newRoom: 92)
		)
		(if (& (gEgo onControl: 0) $0010)
			(gCurRoom newRoom: 89)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 81)
			(= global175 0)
		)
		(super newRoom: newRoomNumber)
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
					(
						(or
							(Said 'look[/!*]')
							(Said 'look[<around][/room,castle]')
						)
						(Print 91 0) ; "This is a rather cheerless dining room. Eating here would NOT be a pleasant experience."
					)
					((Said 'look>')
						(cond
							((Said '<under/table')
								(Print 91 1) ; "There is nothing under the table."
							)
							((Said '/table')
								(Print 91 2) ; "The great dining table looks big enough to seat Lolotte and at least eight of her despicable henchmen."
							)
							((Said '<behind,under/tapestries')
								(Print 91 3) ; "There is nothing but a wall behind the tapestry."
							)
							((Said '/tapestries,painting')
								(Print 91 4) ; "There's a most unusual tapestry hanging on the wall."
							)
							((Said '/chandelier,candle,candelabra')
								(Print 91 5) ; "An interesting chandelier above the dining table casts flickering shadows around the room."
							)
							((Said '/door')
								(Print 91 6) ; "You see three open doorways."
							)
							((Said '/wall')
								(Print 91 7) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 91 8) ; "There is nothing of importance on the floor."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'sit>')
						(Print 91 9) ; "You don't have time for that!"
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance henchChase of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic number: 41 loop: 1 play:)
				(client setMotion: Chase gEgo 15 self)
			)
			(1
				(User canControl: 0 canInput: 0)
				(gEgo moveSpeed: 0 setMotion: 0)
				(theMusic number: 42 loop: 1 play:)
				(= seconds 4)
			)
			(2
				(= global205 1)
				(gCurRoom newRoom: 81)
			)
		)
	)
)

