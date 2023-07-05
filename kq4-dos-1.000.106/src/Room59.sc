;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room59 0
)

(synonyms
	(ghost baby)
)

(local
	local0
	local1
)

(instance Room59 of Rm
	(properties
		picture 59
		style 16
	)

	(method (init)
		(self setRegions: 603) ; regHauntedHouse
		(Load rsVIEW 527)
		(Load rsVIEW 519)
		(Load rsVIEW 648)
		(Load rsVIEW 510)
		(Load rsVIEW 536)
		(super init:)
		((View new:) view: 510 loop: 1 cel: 0 posn: 80 104 setPri: 10 addToPic:)
		(if gNight
			((View new:)
				view: 648
				loop: 0
				cel: 0
				posn: 51 104
				setPri: 6
				addToPic:
			)
			((Prop new:)
				view: 536
				loop: 2
				cel: 1
				posn: 80 98
				init:
				setPri: 11
				setCycle: Fwd
			)
		)
		((= local0 (Prop new:))
			view: 527
			loop: 1
			posn: 147 118
			setPri: 1
			init:
			stopUpd:
		)
		(gEgo posn: 270 130 view: 4 xStep: 4 yStep: 1 init:)
		(self setScript: rm59Script)
		(if (and (== global133 59) (== global134 1))
			(rockAgain cue:)
			(rm59Script changeState: 1)
		)
	)

	(method (doit)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 62) ; HauntedMasterBedroom
		)
		(super doit:)
	)

	(method (dispose)
		(if (gSounds contains: local1)
			(local1 dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		else
			(if (== (event type:) evSAID)
				(cond
					((Said 'look>')
						(cond
							((Said '[<around][/room,bedroom,nursery]')
								(Print 59 0) ; "This old baby nursery must have once been a cheery place. Now, through neglect, cobwebs decorate the corners, wallpaper peels from the walls, and dust covers the nursery furniture."
							)
							((Said '<in/chest,dresser,drawer')
								(Print 59 1) ; "The chest of drawers is empty."
							)
							((Said '/chest,dresser')
								(Print 59 2) ; "The chest of drawers looks old and neglected."
							)
							((Said '/chair,rocker')
								(Print 59 3) ; "You imagine the mother who must have rocked her baby in this rocking chair."
							)
							((Said '/window')
								(if (gEgo inRect: 76 125 109 147)
									(Print 59 4) ; "You see the cemetery out the window."
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((or (Said '<in/cradle') (Said 'ghost[<ghost]'))
								(if (< (gEgo distanceTo: local0) 15)
									(if (!= global134 1)
										(Print 59 5) ; "The baby cradle is empty."
									else
										(Print 59 6) ; "With trepidation, you peek into the rocking cradle and see nothing. Tentatively you reach your hand into it. There is nothing there!!"
									)
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((Said '/cradle')
								(if (!= global134 1)
									(Print 59 7) ; "You see an empty cradle here."
								else
									(Print 59 8) ; "The baby cradle rocks to and fro as a baby's voice wails from within."
								)
							)
							((Said '/wall')
								(Print 59 9) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 59 10) ; "There is nothing of interest on the floor."
							)
							((Said '/horse,toy')
								(Print 59 11) ; "There is an old rocking horse here."
							)
							((Said '/carpet')
								(Print 59 12) ; "A worn pink rug adorns the floor."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'open/chest,dresser,drawer')
						(Print 59 1) ; "The chest of drawers is empty."
					)
					((Said 'sit')
						(Print 59 13) ; "That would waste your precious time."
					)
					((Said 'boulder[/cradle]')
						(cond
							((== global134 1)
								(Print 59 14) ; "The cradle is already rocking!"
							)
							((< (gEgo distanceTo: local0) 10)
								(rockAgain changeState: 0)
								(event claimed: 1)
							)
							(else
								(Print 800 1) ; "You're not close enough."
							)
						)
					)
					((Said '(get<on),mount,play/horse,toy')
						(Print 59 15) ; "You're too big for it."
					)
					((Said 'get/horse,toy')
						(Print 59 16) ; "You don't need it."
					)
				)
			)
			(if (or (event claimed:) (!= (event type:) evSAID) (!= global134 1))
				(return)
			)
			(cond
				(
					(or
						(Said 'look<in/cradle')
						(Said
							'look,(feel[<in,around]),find/cradle,(ghost[<ghost])'
						)
					)
					(if (< (gEgo distanceTo: local0) 15)
						(if (!= global134 1)
							(Print 59 5) ; "The baby cradle is empty."
						else
							(Print 59 6) ; "With trepidation, you peek into the rocking cradle and see nothing. Tentatively you reach your hand into it. There is nothing there!!"
						)
					else
						(Print 800 1) ; "You're not close enough."
					)
				)
				((Said 'talk,calm,calm')
					(Print 59 17) ; "You speak in a soft trembly voice to the fretful baby ghost. Unfortunately, the poor little thing continues its pathetic crying."
				)
				((Said 'kiss')
					(Print 59 18) ; "You'd like to, but you can't see it, or touch it."
				)
				((Said '/ghost[<ghost]>')
					(cond
						((Said 'get,hold,capture,(get<up)')
							(Print 59 19) ; "You reach your hand into the rocking cradle and feel around. There is nothing there but a strange coldness! A shiver runs down your spine as the unseen baby continues its incessant crying."
						)
						((Said 'kill')
							(Print 59 20) ; "How can you kill something that is already dead?"
						)
						((Said 'help,save')
							(Print 59 21) ; "You'd like to help the poor baby ghost, but how can you do that?"
						)
						((Said 'feed')
							(Print 59 22) ; "This baby doesn't eat!"
						)
					)
				)
				((Said 'hum[/ghost,lullaby]')
					(Print 59 23) ; "While trembling, you attempt to sing a lullaby to the whimpering baby ghost. It doesn't work. The poor thing continues its pitiful crying."
				)
				((Said 'give,throw,place,drop>')
					(cond
						(
							(or
								(not (= temp0 (gInventory saidMe:)))
								(not (gEgo has: (gInventory indexOf: temp0)))
							)
							(event claimed: 0)
						)
						((>= (gEgo distanceTo: local0) 17)
							(NotClose) ; "You're not close enough."
						)
						((!= (gInventory indexOf: temp0) 12)
							(Print 59 24) ; "Obviously, as the crying continues, the baby ghost isn't interested in it."
						)
						(else
							(Print 59 25) ; "You drop the silver rattle into the baby cradle. As you do so, the crying of the baby ghost and the rocking of the cradle cease. You breathe a big sigh of relief."
							(gEgo put: 12 59) ; Silver_Baby_Rattle
							(gGame changeScore: 2)
							(Notify 603 2)
						)
					)
				)
			)
		)
	)
)

(instance rockMeBaby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0 cycleSpeed: 1 setCycle: Fwd brTop: (- (local0 y:) 2))
			)
			(1
				(local0 stopUpd: brTop: (- (local0 y:) 2) setCel: 0)
				(= state -1)
			)
		)
	)
)

(instance rockAgain of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rockMeBaby changeState: 0)
				((= local1 (Sound new:)) number: 22 loop: 1 play: self)
			)
			(1
				(rockMeBaby cue:)
				(if (== global134 1)
					(self changeState: 0)
				)
			)
		)
	)
)

(instance rm59Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 102])
		(switch (= state newState)
			(1
				(= seconds 5)
			)
			(2
				(Print 59 26) ; "The crying baby seems to be in here."
			)
		)
	)
)

