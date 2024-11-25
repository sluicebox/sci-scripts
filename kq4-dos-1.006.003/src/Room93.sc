;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room93 0
)

(local
	local0
	local1
)

(instance theMusic of Sound
	(properties)
)

(instance fallMusic of Sound
	(properties
		number 51
	)
)

(instance Room93 of Rm
	(properties
		picture 93
		style 16
	)

	(method (init)
		(Load rsSCRIPT 991)
		(Load rsVIEW 634)
		(Load rsVIEW 512)
		(Load rsSOUND 51)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		(Notify 604 0)
		((View new:)
			view: 634
			loop: 1
			cel: 0
			posn: 101 75
			setPri: 4
			init:
			addToPic:
		)
		((Prop new:)
			view: 512
			loop: 0
			posn: 103 63
			setPri: 3
			init:
			setCycle: Fwd
		)
		(gEgo baseSetter: (ScriptID 0 1)) ; smallBase
		(if (or (== gPrevRoomNum 92) (== gPrevRoomNum 0))
			(gEgo
				posn: 73 137
				view: 4
				setStep: 4 2
				illegalBits: $c000
				baseSetter: 0
				init:
				observeBlocks: stair1 stair2
			)
			(= local0 0)
			(if global175
				(if (> (Random 0 100) 90)
					(Print 93 0 #at -1 10 #font gSmallFont) ; "I don't know how you did it, but you managed to escape Lolotte's henchman. You might not be so lucky next time. Watch Out!!"
					(= global175 0)
				else
					((= local1 (Act new:))
						view: 141
						illegalBits: 0
						ignoreActors:
						posn: 45 134
						setStep: 6 4
						setCycle: Walk
						setScript: henchChase93
						init:
					)
				)
			)
		)
		(if (== gPrevRoomNum 88)
			(gEgo
				posn: 195 25
				view: 4
				setStep: 4 2
				setPri: 12
				baseSetter: (ScriptID 0 1) ; smallBase
				illegalBits: $8000
				init:
				observeBlocks: stair1 stair2
			)
			(= local0 1)
		)
	)

	(method (doit)
		(if (& (gEgo onControl: 0) $0040)
			(gEgo illegalBits: $8000)
			(gCurRoom newRoom: 92)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gEgo setPri: -1 illegalBits: $8000)
			(gCurRoom newRoom: 88)
		)
		(if
			(and
				local0
				(!= (gEgo script:) falling)
				(& (gEgo onControl: 0) $0004)
			)
			(gEgo setScript: falling)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0002)
				(!= (gEgo script:) falling)
			)
			(if (and (< (gEgo heading:) 180) (> (gEgo heading:) 0))
				(gEgo
					setPri: 12
					illegalBits: $8000
					baseSetter: (ScriptID 0 1) ; smallBase
				)
				(= local0 1)
			else
				(gEgo setPri: -1 illegalBits: $c000 baseSetter: 0)
				(= local0 0)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 991)
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
							(Said 'look[<around][/!*]')
							(Said 'look/room,castle,tower')
						)
						(Print 93 1) ; "You are at the bottom of the east tower. A spiral of stone steps winds to the top."
					)
					((Said 'look>')
						(cond
							((Said '/stair')
								(Print 93 2) ; "The stone steps spiral dangerously upward."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 93 3) ; "You see nothing of interest on the cold stone floor of the tower."
							)
							((or (Said '/sky') (Said '<up'))
								(Print 93 4) ; "Looking up, you see nothing special."
							)
							((Said '/stair')
								(Print 93 5) ; "The stairs spiral steeply up the stone tower."
							)
							((Said '/door')
								(Print 93 6) ; "There is an open doorway before you."
							)
							((Said '/door')
								(Print 93 7) ; "You glance quickly through the open doorway, but do not see anything of interest in the adjoining room."
							)
						)
					)
				)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(if (> (gEgo y:) 110)
					(self changeState: 10)
				else
					(self changeState: 20)
				)
			)
			(10
				(gEgo
					view: 44
					baseSetter: 0
					setStep: 8 3
					setLoop: 1
					illegalBits: 0
					setPri: 9
					setCycle: End
				)
				(if (<= (gEgo y:) 135)
					(gEgo setMotion: JumpTo 137 145 self)
				else
					(gEgo setMotion: MoveTo 137 145 self)
				)
				(fallMusic play:)
			)
			(11
				(gEgo view: 41 cel: 255 setPri: -1 setCycle: End self)
			)
			(12
				(gEgo
					view: 4
					setStep: 4 2
					setLoop: -1
					illegalBits: $c000
					setPri: -1
					setCycle: Walk
				)
				(= local0 0)
				(fallMusic dispose:)
				(User canInput: 1 canControl: 1)
				(client setScript: 0)
			)
			(20
				(User canInput: 0 canControl: 0)
				(= global105 16)
				(gEgo
					view: 44
					illegalBits: 0
					baseSetter: 0
					setPri: 9
					setMotion:
						((Jump new:)
							y:
								(if (<= (gEgo y:) 145)
									145
								else
									(gEgo y:)
								)
							gy: 4
							gx: (if (< (gEgo y:) 60) -1 else -2)
						)
						self
				)
				(fallMusic play:)
			)
			(21
				(gEgo view: 42 setPri: 3)
				(RedrawCast)
				(ShakeScreen 5)
				(= seconds 4)
			)
			(22
				(= gDeathFlag 1)
				(fallMusic dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance henchChase93 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic number: 41 loop: 1 play:)
				(local1 setMotion: Chase gEgo 15 self)
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

(instance stair1 of Blk
	(properties
		top 127
		left 192
		bottom 129
		right 194
	)
)

(instance stair2 of Blk
	(properties
		top 144
		left 167
		bottom 146
		right 169
	)
)

