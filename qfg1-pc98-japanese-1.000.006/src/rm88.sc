;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm88 0
)

(local
	local0
	local1
	local2
	[local3 4]
	local7
	local8
	local9
	[local10 4]
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

(instance rm88 of Rm
	(properties
		picture 88
		style 2
		east 89
	)

	(method (dispose)
		(SetFlag 78)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (< (gEgo x:) 140)
			(switch local0
				(1
					(self setScript: trollOut)
				)
			)
		)
	)

	(method (init)
		(super init:)
		(pile init: addToPic:)
		(drip init: setScript: dripScript)
		(= local9 (Random 0 5))
		(= [local7 0] 36)
		(= [local8 0] 133)
		(= [local7 1] 94)
		(= [local8 1] 146)
		(= [local7 2] 135)
		(= [local8 2] 158)
		(= [local7 3] 212)
		(= [local8 3] 160)
		(= [local7 4] 292)
		(= [local8 4] 161)
		(= [local7 5] 67)
		(= [local8 5] 153)
		(SL enable:)
		(NormalEgo)
		(gEgo init:)
		(if
			(==
				(= local0
					(cond
						((IsFlag 251) 0)
						((IsFlag 250)
							(troll
								view: 451
								posn: 80 158
								setLoop: 0
								setCel: 10
								init:
								addToPic:
							)
							4
						)
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
				(gEgo posn: 135 160 loop: 1)
				(= global332 0)
				(self setScript: trollDies)
			)
			(else
				(gEgo posn: 318 150 setMotion: MoveTo 255 150)
				(if (not (IsFlag 78))
					(HighPrint 88 0) ; "There is a strong odor of decay and other nasty smells filling the air. A pile of something unpleasant lies near the center of this cave."
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look,look>')
						(cond
							((Said '/down,ground,floor,stalactite')
								(HighPrint 88 1) ; "You can watch the water ooze down the sides of the stalactites and drip to the ground."
							)
							((Said '/up,ceiling,stalagmite')
								(HighPrint 88 2) ; "You can watch the water drop down from the stalactites and ooze down the sides of the stalagmites."
							)
							((Said '[<at,around][/!*,cave,room]')
								(HighPrint 88 0) ; "There is a strong odor of decay and other nasty smells filling the air. A pile of something unpleasant lies near the center of this cave."
							)
							((Said '/water')
								(HighPrint 88 3) ; "The water has been polluted by various other disgusting liquids."
							)
							((Said '/collection,item,bone,armor')
								(HighPrint 88 4) ; "It looks as if someone has piled up bones, bits of armor, and things you can't quite make out and probably don't want to know about. It smells disgusting."
							)
							((Said '/troll,monster,creature')
								(switch local0
									(2
										(HighPrint 88 5) ; "A mean-looking Troll looms before you, a snarl on his lips."
									)
									(3
										(HighPrint 88 6) ; "The Troll lies dying upon the slimy floor of the cave."
									)
									(4
										(HighPrint 88 7) ; "A dead Troll lies in a pool of blue blood."
									)
									(else
										(HighPrint 88 8) ; "You see no such creature here."
									)
								)
							)
							((Said '/north,west,south,east')
								(HighPrint 88 9) ; "You have lost your sense of direction, as the cave passage twists around."
							)
							((Said '/boulder')
								(HighPrint 88 10) ; "The rocks look slick and are slimy to the touch."
							)
							((Said '/fungus')
								(HighPrint 88 11) ; "The light from the fungus is eerie and vaguely unpleasant."
							)
							((Said '/entrance,open,open,open')
								(HighPrint 88 12) ; "The only entrance to this cave is the one you came through."
							)
						)
					)
					((Said 'throw/')
						(HighPrint 88 13) ; "There is nothing here to throw it at."
					)
					((Said 'search/troll,monster,creature,body,enemy')
						(cond
							((!= local0 4)
								(HighPrint 88 14) ; "You can't do that."
							)
							((gEgo inRect: 64 144 106 165)
								(= local2 0)
								(self setScript: egoSearch)
							)
							(else
								(HighPrint 88 15) ; "You need to get closer to the dead Troll."
							)
						)
					)
					((Said 'goseke')
						(HighPrint 88 16) ; "The password is for the hidden passage, not the troll's home."
					)
					(
						(Said
							'get,get,search/collection,junk,item,collection,silver,gold,loot,[!*]'
						)
						(if (gEgo inRect: 39 140 120 157)
							(= local2 1)
							(self setScript: egoSearch)
						else
							(HighPrint 88 17) ; "Get closer to the pile of junk."
						)
					)
					((Said 'get,get,get>')
						(cond
							((Said '/hair,beard')
								(cond
									((!= local0 4)
										(HighPrint 88 14) ; "You can't do that."
									)
									((gEgo inRect: 64 144 106 165)
										(= local2 2)
										(self setScript: egoSearch)
									)
									(else
										(HighPrint 88 15) ; "You need to get closer to the dead Troll."
									)
								)
							)
							((Said '/club,weapon')
								(cond
									((== local0 2)
										(HighPrint 88 18) ; "You're kidding, right?"
									)
									((!= local0 4)
										(HighPrint 88 14) ; "You can't do that."
									)
									(else
										(HighPrint 88 19) ; "The dead Troll's huge club is much too heavy for you to lift."
									)
								)
							)
							((Said '/fungus')
								(HighPrint 88 20) ; "The fungus is slimy and stuck tight to the cave walls."
							)
							((Said '/troll,stalactite,stalagmite')
								(HighPrint 88 18) ; "You're kidding, right?"
							)
							((Said '/boulder,water')
								(HighPrint 88 21) ; "You don't need it."
							)
							((Said '/armor,leather,chain')
								(HighPrint 88 22) ; "The armor is corroded and valueless."
							)
						)
					)
					((Said 'feed/troll,monster,creature')
						(if (== local0 2)
							(HighPrint 88 23) ; "This Troll looks as though he'd rather eat YOU!"
						else
							(HighPrint 88 14) ; "You can't do that."
						)
					)
					((Said 'listen/')
						(if (or (== local0 0) (== local0 4))
							(HighPrint 88 24) ; "You hear the constant "drip... drip..." of water."
						else
							(HighPrint 88 25) ; "You hear the constant "drip... drip..." of water, and the unmistakeable sound of something breathing nearby."
						)
					)
					((Said 'cast>')
						(= temp0 (SaidSpell event))
						(if (CastSpell temp0)
							(switch temp0
								(18
									(HighPrint 88 26) ; "There is no magic in this cave."
								)
								(20
									(HighPrint 88 27) ; "There is nothing here to dazzle."
								)
								(23
									(HighPrint 88 28) ; "There is nothing here to use that spell on."
								)
								(22
									(HighPrint 88 29) ; "There is nothing here to calm."
								)
								(17
									(HighPrint 88 30) ; "There is nothing here to open."
								)
								(else
									(HighPrint 88 31) ; "That spell is useless here."
								)
							)
						)
					)
					((Said 'attack')
						(if (IsFlag 250)
							(HighPrint 88 32) ; "The cave troll is dead."
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

(instance drip of Prop
	(properties
		y 204
		x 79
		view 88
		loop 1
	)
)

(instance pile of View
	(properties
		y 150
		x 60
		view 88
	)
)

(instance trollOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 2)
				(HandsOff)
				(troll
					posn: 249 127
					init:
					setCycle: Walk
					setMotion: MoveTo 183 154 self
				)
			)
			(1
				(HighPrint 88 33) ; "Before you can notice him, a Troll sneaks up behind you, and the encounter begins."
				(gCurRoom newRoom: 450) ; trollArena
			)
		)
	)
)

(instance trollKills of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(troll loop: 2 cel: 0 setCycle: End)
				(= cycles 1)
			)
			(2
				(troll loop: 3 cel: 0 setCycle: End)
				(gEgo
					view: 516
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(= cycles 12)
			)
			(4
				(EgoDead ; "The Troll's brute force was too much for your skull."
					88
					34
					80
					{WHATA TROLL!%j\c5\dd\c4\b2\b3 \c4\db\d9!}
					82
					800
					0
					0
				)
			)
		)
	)
)

(instance trollDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 3)
				(SetFlag 250)
				(troll
					view: 451
					loop: 0
					cel: 0
					posn: 80 158
					init:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(= local0 4)
				(troll addToPic:)
				(client setScript: 0)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drip
					posn: [local7 local9] [local8 local9]
					setPri: 15
					setCycle: End self
				)
			)
			(1
				(= local9 (Random 0 5))
				(self changeState: 0)
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
							(HighPrint 88 35) ; "There is nothing of value on the Troll."
						else
							(HighPrint 88 36) ; "You find nothing on the Troll but a little hair."
						)
					)
					(1
						(HighPrint 88 37) ; "You dig around in the pile until the odor almost makes you sick."
						(if (IsFlag 335)
							(HighPrint 88 38) ; "You find nothing more of value."
						else
							(SetFlag 335)
							(HighPrint 88 39) ; "You find 30 silvers and 5 gold."
							(gEgo get: 2 5) ; gold
							(gEgo get: 1 30) ; silver
						)
					)
					(2
						(if (IsFlag 340)
							(HighPrint 88 40) ; "There is no beard hair left on the Troll."
						else
							(HighPrint 88 41) ; "You cut some beard hair and put it away."
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

