;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
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
	Room90 0
)

(local
	local0
	local1
)

(instance Room90 of Rm
	(properties
		picture 90
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
			cel: 1
			posn: 209 78
			setPri: 4
			init:
			addToPic:
		)
		((Prop new:)
			view: 512
			loop: 0
			posn: 209 66
			setPri: 3
			init:
			setCycle: Fwd
		)
		(if (or (== gPrevRoomNum 91) (== gPrevRoomNum 0))
			(gEgo
				posn: 255 135
				baseSetter: 0
				view: 4
				setStep: 4 1
				illegalBits: $c000
				init:
			)
			(= local0 0)
			(if global175
				(Print 90 0 #at -1 20 #font gSmallFont) ; "I don't know how you did it, but you managed to escape Lolotte's henchman. You might not be so lucky next time. Watch Out!!"
				(= global175 0)
			)
		)
		(if (== gPrevRoomNum 85)
			(gEgo
				posn: 104 39
				baseSetter: (ScriptID 0 1) ; smallBase
				view: 4
				setStep: 4 1
				illegalBits: $8000
				setPri: 12
				init:
			)
			(= local0 1)
		)
	)

	(method (doit)
		(if (& (gEgo onControl: 0) $0040)
			(gEgo setPri: -1 illegalBits: $8000 baseSetter: 0)
			(gCurRoom newRoom: 91)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gEgo setPri: -1 illegalBits: $8000 baseSetter: 0)
			(gCurRoom newRoom: 85)
		)
		(if
			(and
				(!= (self script:) fallingToDeath)
				(!= (self script:) fallingDown)
			)
			(if local0
				(cond
					((& (gEgo onControl:) $0004)
						(self setScript: fallingToDeath)
					)
					((& (gEgo onControl:) $0100)
						(self setScript: fallingDown)
					)
				)
			)
			(if (& (gEgo onControl: 1) $0002)
				(if (and (< (gEgo heading:) 180) (> (gEgo heading:) 0))
					(gEgo
						baseSetter: (ScriptID 0 1) ; smallBase
						setPri: -1
						illegalBits: $c000
					)
					(= local0 0)
				else
					(gEgo baseSetter: 0 illegalBits: $8000 setPri: 12)
					(= local0 1)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (== (event type:) evSAID) (Said 'look>'))
				(cond
					((or (Said '/dirt') (Said '<down'))
						(Print 90 1) ; "You see nothing of interest on the cold stone floor of the tower."
					)
					((Said '/wall')
						(Print 90 2) ; "You see nothing of interest on the walls."
					)
					((or (Said '/sky') (Said '<up'))
						(Print 90 3) ; "You look up, but see nothing special."
					)
					((Said '/stair')
						(Print 90 4) ; "The stairs spiral steeply up the stone tower."
					)
					((Said '/stair')
						(Print 90 5) ; "The stone steps spiral dangerously upward."
					)
					((Said '/door')
						(Print 90 6) ; "There is an open doorway before you."
					)
					((Said '/door')
						(Print 90 7) ; "You glance quickly through the open doorway, but do not see anything of interest in the adjoining room."
					)
					((or (Said '[<around][/room]') (Said '/castle,tower'))
						(Print 90 8) ; "You are at the bottom of the west tower. A spiral of stone steps winds to the top."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance fallingDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0 canControl: 0)
				(gEgo
					view: 44
					loop: 0
					illegalBits: 0
					setPri: 9
					setCycle: End
					setMotion:
						((Jump new:)
							y: 145
							gx: 2
							gy: (if (>= (gEgo y:) 145) -5 else 5)
						)
						self
				)
				(local1 number: 51 loop: 1 play:)
			)
			(1
				(gEgo view: 41 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 4
					baseSetter: 0
					illegalBits: $c000
					setPri: -1
					setCycle: Walk
				)
				(= local0 0)
				(local1 dispose:)
				(User canInput: 1 canControl: 1)
				(client setScript: 0)
				(= state -1)
			)
		)
	)
)

(instance fallingToDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0 canControl: 0)
				(= global105 16)
				(gEgo
					view: 44
					loop: 2
					illegalBits: 0
					setPri: 9
					setMotion: ((Jump new:) y: 145 gx: 2 gy: 5) self
				)
				((Sound new:) number: 51 loop: 1 play:)
			)
			(1
				(gEgo view: 42)
				(RedrawCast)
				(ShakeScreen 5)
				(= seconds 2)
			)
			(2
				(gSounds eachElementDo: #dispose)
				(= gDeathFlag 1)
				(client setScript: 0)
			)
		)
	)
)

