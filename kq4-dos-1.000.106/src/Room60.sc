;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room60 0
)

(synonyms
	(room bedroom)
)

(local
	local0
	local1
	local2
)

(instance Room60 of Rm
	(properties
		picture 60
		style 16
	)

	(method (init)
		(Load rsVIEW 648)
		(Load rsVIEW 529)
		(self setRegions: 603) ; regHauntedHouse
		(super init:)
		(if gNight
			((View new:) view: 648 loop: 1 posn: 163 91 setPri: 5 addToPic:)
			((Prop new:)
				view: 536
				loop: 2
				posn: 267 76
				init:
				setPri: 13
				setCycle: Fwd
			)
		)
		(if (> global134 4)
			(Load rsVIEW 529)
			(Load rsVIEW 77)
			((= local2 (View new:))
				view: 529
				loop: 1
				cel: 0
				posn: 161 138
				init:
				stopUpd:
			)
			((= local0 (View new:))
				view: 529
				loop: 0
				cel: 0
				posn: 161 34
				init:
				stopUpd:
				setPri: (- (local2 priority:) 1)
			)
			(= local1 1)
		)
		(if (== gPrevRoomNum 68)
			(gEgo posn: 68 160 view: 4 setStep: 4 1 init:)
		else
			(gEgo posn: 161 60 view: 77 setStep: 4 1 init:)
			(self setScript: climbDown)
		)
		(if (and (< 0 global134 255) (== global133 gCurRoomNum))
			(Notify 603 -1)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 68)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					(
						(or
							(Said 'look[<around][/!*]')
							(Said 'look[<around]/room')
						)
						(Print 60 0) ; "This old bedroom must have once been very nice. You could imagine a cheery fire in the fireplace, while its occupant slept snugly in the big bed. But sadly, this room has been abandoned for years."
					)
					((Said 'look>')
						(cond
							((Said '<under/bed')
								(Print 60 1) ; "There is nothing under the bed."
							)
							((Said '/bed')
								(Print 60 2) ; "The old bed still looks comfortable."
							)
							((Said '/window')
								(if (gEgo inRect: 137 114 191 124)
									(Print 60 3) ; "You see the cemetery out the window."
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((Said '/fireplace')
								(Print 60 4) ; "The fireplace has been cold for years. There's nothing there."
							)
							((Said '/carpet,carpet')
								(Print 60 5) ; "A worn rug lies beneath the bed."
							)
							((Said '<in/chest,dresser,drawer')
								(Print 60 6) ; "The chest of drawers is empty."
							)
							((Said '/chandelier')
								(Print 60 7) ; "The lamp is old and dusty."
							)
							((Said '/chest,dresser')
								(Print 60 8) ; "A large, old chest of drawers rests against the wall."
							)
							((Said '/wall')
								(Print 60 9) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 60 10) ; "There is nothing of interest on the floor."
							)
							((Said '/ceiling')
								(if local1
									(Print 60 11) ; "You see a ladder descending into the room from an open trapdoor in the ceiling."
								else
									(Print 60 12) ; "You look up at the ceiling and notice a closed trapdoor."
								)
							)
							((Said '<in,up/trapdoor')
								(if local1
									(Print 60 13) ; "You look up through the open trapdoor, but can't see anything as it's too dark up there."
								else
									(Print 60 14) ; "The trapdoor is closed."
								)
							)
							((Said '<up')
								(if local1
									(Print 60 15) ; "You look up through the open trapdoor, but can't make out anything as it's too dark up there."
								else
									(Print 60 16) ; "You can't see anything."
								)
							)
							((Said '/ladder')
								(if local1
									(Print 60 17) ; "A ladder descends into the room from an open trapdoor in the ceiling."
								else
									(Print 60 18) ; "What ladder do YOU see to look at?"
								)
							)
							((Said '/trapdoor')
								(if local1
									(Print 60 19) ; "You see a ladder, descending into the room from an open trapdoor in the ceiling."
								else
									(Print 60 20) ; "The ceiling trapdoor is closed."
								)
							)
						)
					)
					((Said 'open/trapdoor')
						(if local1
							(Print 60 21) ; "The trapdoor is already open!"
						else
							(Print 60 22) ; "You have absolutely no way of reaching that trapdoor as it's too high. And moving the heavy furniture is out of the question. Forget it."
						)
					)
					((Said 'close/trapdoor')
						(if local1
							(Print 60 23) ; "There is no reason to close it."
						else
							(Print 60 24) ; "The trapdoor is already closed!"
						)
					)
					((Said 'open/chest,dresser,drawer')
						(Print 60 6) ; "The chest of drawers is empty."
					)
					(
						(or
							(Said 'lay,sleep[<in,down,on][/bed]')
							(Said 'get<in,in/bed')
						)
						(Print 60 25) ; "You don't have time for that!"
					)
					((Said 'climb[/ladder]')
						(if local1
							(if (< (gEgo distanceTo: local2) 10)
								(if (>= (gEgo y:) (local2 y:))
									(gEgo setScript: climbLadder)
								else
									(Print 60 26) ; "Not from this side."
								)
							else
								(Print 800 1) ; "You're not close enough."
							)
						else
							(Print 60 27) ; "You see nothing to climb."
						)
					)
					((Said 'climb')
						(Print 60 28) ; "You can't climb that here."
					)
					((Said 'pull>')
						(Print 60 29) ; "This is too heavy to move."
					)
				)
				(if (and (== global134 3) (event claimed: 0))
					(cond
						((Said 'look/ghost,woman,woman,woman')
							(Print 60 30) ; "You see the sad ghost of a beautiful young woman. She sits in her rocking chair and weeps as if her heart will break."
						)
						((Said 'look/chair')
							(Print 60 31) ; "You see the sad ghost of a beautiful young woman. She sits in her rocking chair and weeps as if her heart will break."
						)
						(
							(or
								(Said 'talk/ghost,woman,woman,woman')
								(Said 'talk[/!*]')
							)
							(Print 60 32) ; "You try to comfort the lady ghost, but she doesn't respond. It seems as if she doesn't even know you're here as she continues her deep sobbing."
						)
						((Said 'get/ghost,woman,woman,woman')
							(Print 60 33) ; "You can't get a ghost!"
						)
						((Said 'get,capture/ghost,woman,woman,woman')
							(Print 60 34) ; "You can't catch a ghost!"
						)
						((Said 'kill/ghost,woman,woman,woman')
							(Print 60 35) ; "How can you kill something that is already dead!"
						)
						(
							(or
								(Said 'kiss/ghost,woman,woman,woman')
								(Said 'kiss[/!*]')
							)
							(Print 60 36) ; "You can't, as the ghost has no substance."
						)
						((Said 'help/ghost,woman,woman,woman')
							(Print 60 37) ; "You'd like to help the sad lady ghost, but how can you do that?"
						)
						((Said 'give>')
							(if (gEgo inRect: 70 118 100 152)
								(cond
									(
										(and
											(= temp0 (gInventory saidMe:))
											(gEgo
												has: (gInventory indexOf: temp0)
											)
										)
										(if (== (gInventory indexOf: temp0) 28)
											(gEgo put: 28 -1) ; Locket
											(gGame changeScore: 2)
											(Print 60 38) ; "You hand the lovely locket to the distraught ghost. The locket seems to make her very happy as she vanishes into thin air."
											(Notify 603 -1)
										else
											(Print 60 39) ; "The lady ghost doesn't even acknowledge your presence."
										)
									)
									(temp0
										(event claimed: 0)
									)
								)
							else
								(Print 800 1) ; "You're not close enough."
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance climbLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 161 140 self
				)
			)
			(1
				(gEgo view: 77 loop: 0 setStep: 4 3 setCycle: End self)
			)
			(2
				(gEgo
					loop: 1
					cel: 0
					setPri: 12
					setCycle: Walk
					setMotion: MoveTo 161 48 self
				)
			)
			(3
				(= global204 0)
				(= global205 1)
				(client setScript: 0)
				(gCurRoom newRoom: 63)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 77
					loop: 1
					illegalBits: 0
					setStep: 3 3
					setPri: 10
					setCycle: Rev
					setMotion: MoveTo 161 140 self
				)
			)
			(1
				(gEgo
					view: 4
					loop: 3
					illegalBits: $8000
					setCycle: Walk
					setPri: -1
					setStep: 4 1
				)
				(HandsOn)
				(= global205 0)
			)
		)
	)
)

