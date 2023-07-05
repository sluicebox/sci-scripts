;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 89)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm89 0
)

(local
	local0
	local1
	local2
	[local3 8]
)

(instance magicHit of Sound
	(properties
		number 45
		priority 1
	)
)

(instance egoShoots of Sound
	(properties
		number 33
		priority 2
	)
)

(instance rm89 of Rm
	(properties
		picture 89
		style 2
		east 93
		west 88
	)

	(method (dispose)
		(SetFlag 79)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (== (gEgo onControl: 1) 2048)
			(gCurRoom newRoom: 84)
		)
	)

	(method (init)
		(gContMusic number: 23 loop: -1 play:)
		(super init:)
		(SolvePuzzle 704 2)
		(SL enable:)
		(NormalEgo)
		(gEgo init:)
		(if
			(==
				(= local0
					(cond
						((== gPrevRoomNum 450) ; trollArena
							(= global332 0)
							2
						)
						((IsFlag 251)
							(troll
								view: 451
								posn: 65 105
								setLoop: 0
								setCel: 10
								init:
								addToPic:
							)
							3
						)
						((or (IsFlag 247) (IsFlag 250)) 0)
						(else 1)
					)
				)
				1
			)
			(Load rsVIEW 450)
			(Load rsSCRIPT 972)
			(if (gEgo knows: 23)
				(Load rsVIEW 522)
				(Load rsSOUND (SoundFX 33))
				(Load rsSOUND (SoundFX 45))
				(egoShoots number: (SoundFX 33) init:)
				(magicHit number: (SoundFX 45) init:)
			)
		)
		(switch gPrevRoomNum
			(450 ; trollArena
				(gEgo posn: 94 115 loop: 1 cel: 4)
				(self setScript: trollDies)
			)
			(84
				(if (== local0 1)
					(self setScript: trollAttacks)
				else
					(self setScript: fromAntwerp)
				)
			)
			(93
				(gEgo posn: 318 163 setMotion: MoveTo 279 164)
			)
			(else
				(gEgo posn: 6 115 setMotion: MoveTo 38 115)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/down,ground,floor,stalactite')
								(HighPrint 89 0) ; "You can watch the water ooze down the sides of the stalactites and drip to the ground."
							)
							((Said '/up,ceiling,stalagmite')
								(HighPrint 89 1) ; "You can watch the water drop down from the stalactites and ooze down the sides of the stalagmites."
							)
							((Said '[<at,around][/!*,cave,room]')
								(Print 89 2 #at -1 120 #width 300 #mode 1) ; "As your eyes adjust to the darkness, you see by the light of the fungus that this passageway twists its way through the mountain. It is cold in here, and you can smell stagnant water and faint hints of decay."
							)
							((Said '/water')
								(HighPrint 89 3) ; "The water lies in stagnant pools."
							)
							((Said '/troll,monster,creature')
								(switch local0
									(1
										(HighPrint 89 4) ; "A large Troll looms before you, a snarl on his lips."
									)
									(2
										(HighPrint 89 5) ; "The large Troll lies dying upon the slimy floor of the cave."
									)
									(3
										(HighPrint 89 6) ; "A large, dead Troll lies in a pool of blue blood."
									)
									(else
										(HighPrint 89 7) ; "You see no such creature here."
									)
								)
							)
							((Said '/north,west,south,east')
								(HighPrint 89 8) ; "You have lost your sense of direction, as the cave passage twists around."
							)
							((Said '/boulder')
								(HighPrint 89 9) ; "The rocks look slick and are slimy to the touch."
							)
							((Said '/fungus')
								(HighPrint 89 10) ; "The light from the fungus is eerie and vaguely unpleasant."
							)
							((Said '/entrance,open')
								(HighPrint 89 11) ; "The only entrance to this cave is the one you came through."
							)
						)
					)
					((Said 'hiden')
						(HighPrint 89 12) ; "There's no need for the password now."
					)
					((Said 'throw/')
						(HighPrint 89 13) ; "There is nothing here to throw it at."
					)
					((Said 'search/troll,monster,creature,body,enemy')
						(cond
							((!= local0 3)
								(HighPrint 89 14) ; "You can't do that."
							)
							((gEgo inRect: 54 78 100 125)
								(= local2 0)
								(self setScript: egoSearch)
							)
							(else
								(HighPrint 89 15) ; "You need to get closer to the dead Troll."
							)
						)
					)
					((Said 'get,get>')
						(cond
							((Said '/hair,beard')
								(cond
									((!= local0 3)
										(HighPrint 89 14) ; "You can't do that."
									)
									((gEgo inRect: 54 78 100 125)
										(= local2 1)
										(self setScript: egoSearch)
									)
									(else
										(HighPrint 89 15) ; "You need to get closer to the dead Troll."
									)
								)
							)
							((Said '/club,weapon')
								(cond
									((== local0 1)
										(HighPrint 89 16) ; "You're kidding, right?"
									)
									((!= local0 3)
										(HighPrint 89 14) ; "You can't do that."
									)
									(else
										(HighPrint 89 17) ; "The dead Troll's huge club is much too heavy for you to lift."
									)
								)
							)
							((Said '/fungus')
								(HighPrint 89 18) ; "The fungus is slimy and stuck tight to the cave walls."
							)
							((Said '/troll,stalactite,stalagmite')
								(HighPrint 89 16) ; "You're kidding, right?"
							)
							((Said '/boulder,water')
								(HighPrint 89 19) ; "You don't need it."
							)
						)
					)
					((Said 'feed/troll,monster,creature')
						(if (== local0 1)
							(HighPrint 89 20) ; "The large Troll looks as though he'd rather eat YOU!"
						else
							(HighPrint 89 14) ; "You can't do that."
						)
					)
					((Said 'listen/')
						(HighPrint 89 21) ; "You hear the constant "drip... drip..." of water."
					)
					((Said 'cast>')
						(= temp0 (SaidSpell event))
						(if (CastSpell temp0)
							(switch temp0
								(18
									(HighPrint 89 22) ; "There is no magic in this cave."
								)
								(20
									(HighPrint 89 23) ; "There is nothing here to dazzle."
								)
								(23
									(HighPrint 89 24) ; "There is nothing here to use it on."
								)
								(22
									(HighPrint 89 25) ; "There is nothing here to calm."
								)
								(17
									(HighPrint 89 26) ; "There is nothing here to open."
								)
								(else
									(HighPrint 89 27) ; "That spell is useless here."
								)
							)
						)
					)
					((Said 'fight')
						(if (IsFlag 250)
							(HighPrint 89 28) ; "The cave troll is dead."
						else
							(gCurRoom newRoom: 450) ; trollArena
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance troll of Act
	(properties
		yStep 3
		view 450
		cycleSpeed 1
		illegalBits 0
		xStep 5
		moveSpeed 1
	)
)

(instance trollAttacks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 293 59 setMotion: MoveTo 261 63)
				(troll
					posn: 179 77
					init:
					setCycle: Walk
					setMotion: MoveTo 225 68 self
				)
			)
			(1
				(HighPrint 89 29) ; "Before you can react, the Troll is upon you, and the encounter begins."
				(gCurRoom newRoom: 450) ; trollArena
			)
		)
	)
)

(instance trollDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 251)
				(SetFlag 250)
				(HandsOff)
				(troll
					view: 451
					loop: 0
					cel: 0
					illegalBits: 0
					posn: 65 105
					init:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(HandsOn)
				(= local0 3)
				(troll addToPic:)
				(client setScript: 0)
			)
		)
	)
)

(instance egoSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LookAt gEgo troll)
				(gEgo
					loop: (mod (+ (gEgo loop:) 4) 2)
					view: 510
					setCycle: End self
				)
			)
			(1
				(switch local2
					(0
						(if (IsFlag 340)
							(HighPrint 89 30) ; "You find nothing on the Troll."
						else
							(HighPrint 89 31) ; "You find nothing on the Troll but a little hair."
						)
					)
					(1
						(if (IsFlag 340)
							(HighPrint 89 32) ; "You find no more beard hair on the dead Troll."
						else
							(HighPrint 89 33) ; "You cut off the Troll's beard and put it away."
							(SetFlag 340)
							(gEgo get: 32) ; troll beard
						)
					)
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo)
				(HandsOn)
			)
		)
	)
)

(instance fromAntwerp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 293 59 setMotion: MoveTo 261 63 self)
			)
			(1
				(if (not (IsFlag 79))
					(Print 89 2 #at -1 120 #width 300 #mode 1) ; "As your eyes adjust to the darkness, you see by the light of the fungus that this passageway twists its way through the mountain. It is cold in here, and you can smell stagnant water and faint hints of decay."
				)
			)
		)
	)
)

