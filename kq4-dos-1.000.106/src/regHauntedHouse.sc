;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 603)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	regHauntedHouse 0
)

(synonyms
	(room cottage)
)

(local
	local0
	local1
)

(class GhostWander of Motion
	(properties
		ux 0
		uy 0
		lx 0
		ly 0
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0 temp1)
		(= ux param2)
		(= uy param3)
		(= lx param4)
		(= ly param5)
		(switch (/ (Random 10 29) 10)
			(1
				(= temp0 ux)
			)
			(2
				(= temp0 lx)
			)
		)
		(switch (/ (Random 10 29) 10)
			(1
				(= temp1 uy)
			)
			(2
				(= temp1 ly)
			)
		)
		(super init: param1 temp0 temp1)
		(super doit:)
	)

	(method (doit)
		(super doit:)
		(if (client isStopped:)
			(self moveDone:)
		)
	)

	(method (moveDone)
		(self init: client ux uy lx ly)
	)
)

(instance theGhost of Act
	(properties)
)

(instance regHauntedHouse of Rgn
	(properties)

	(method (init)
		(if initialized
			(return)
		)
		(= global189 (= keep 1))
		(super init:)
		(if gNight
			(theGhost
				view: 201
				illegalBits: 0
				ignoreActors: 1
				posn: 999 999
				init:
			)
			(if (not global134)
				(= global134 1)
			)
			(self notify: global134)
		)
		(miserGhostMusic init:)
		(ladyGhostMusic init:)
		(lordGhostMusic init:)
		(boyGhostMusic init:)
	)

	(method (dispose)
		(if (== keep 0)
			(= global189 0)
			(super dispose:)
		)
	)

	(method (notify param1)
		(cond
			((and script (not argc))
				(script cue:)
			)
			((and script (< param1 0))
				(script cue: param1 &rest)
			)
			(else
				(self
					setScript:
						(switch (= global134 param1)
							(1 babyScript)
							(2 miserScript)
							(3 ladyScript)
							(4 lordScript)
							(5 boyScript)
							(else 0)
						)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(miserGhostMusic dispose:)
		(ladyGhostMusic dispose:)
		(lordGhostMusic dispose:)
		(boyGhostMusic dispose:)
		(if (IsObject script)
			(script cue: -2 newRoomNumber)
		)
		(= global135 0)
		(if (== newRoomNumber 17)
			(HandsOn)
			(lordGhostMusic keep: 0)
			(miserGhostMusic keep: 0)
			(ladyGhostMusic keep: 0)
			(boyGhostMusic keep: 0)
			(gSounds eachElementDo: #dispose)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance babyScript of Script
	(properties)

	(method (cue)
		(if (not argc)
			(super cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global133 59)
				(= seconds 5)
			)
			(1
				(Print 603 0) ; "What's that you hear?! Why, it's the sound of a crying baby, and it's coming from upstairs!"
				(= seconds 10)
			)
			(2
				(if
					(and
						(!= gCurRoomNum 61) ; HauntedTowerMiddle
						(!= gCurRoomNum 66)
						(!= gCurRoomNum 59)
						(!= gCurRoomNum 58)
					)
					(Print 603 1) ; "You hear a baby crying!"
				)
				(-- state)
				(= seconds (Random 10 30))
			)
		)
	)
)

(instance miserScript of Script
	(properties)

	(method (cue param1)
		(cond
			((not argc)
				(super cue:)
			)
			((== param1 -1)
				(= seconds 0)
				(self
					changeState:
						(cond
							((< state 4) 4)
							((< state 5) 5)
						)
				)
			)
			((== param1 -2)
				(switch global133
					(164
						(= global133 64)
						(= local0 1)
					)
					(64
						(if (== local0 1)
							(= global133 68)
						else
							(= global133 164)
						)
					)
					(68
						(if (== local0 1)
							(= global133 67)
						else
							(= global133 64)
						)
					)
					(67
						(if (== local0 1)
							(= global133 167)
						else
							(= global133 68)
						)
					)
					(167
						(= global133 67)
						(= local0 0)
					)
				)
				(if (< state 5)
					(self changeState: 2)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(Load rsVIEW 200)
				(Load rsVIEW 201)
				(= global133 164)
				(= local0 1)
				(= seconds (Random 5 10))
			)
			(1
				(Print 603 2) ; "Suddenly you hear a terrible rattling of chains from downstairs!"
				(= cycles 5)
			)
			(2
				(= seconds 3)
			)
			(3
				(if (and (!= gCurRoomNum 66) (!= gCurRoomNum 61) (!= gCurRoomNum 58)) ; HauntedTowerMiddle
					(Print 603 3) ; "The sound of loud moaning and the rattling of heavy chains disturbs you."
				)
				(-- state)
				(= seconds (Random 40 99))
			)
			(4
				(= seconds 0)
				(= global135 1)
				(miserGhostMusic loop: 1 play:)
				(switch global133
					(67
						(= temp1 145)
					)
					(68
						(= temp1 180)
					)
					(64
						(= temp1 145)
					)
				)
				(switch local0
					(0
						(= temp0 -33)
					)
					(1
						(= temp0 333)
					)
				)
				(switch local0
					(0
						(= temp2 333)
					)
					(1
						(= temp2 -33)
					)
				)
				(theGhost
					view: 201
					illegalBits: 0
					posn: temp0 temp1
					ignoreActors: 1
					init:
					setLoop: local0
					setCycle: Walk
					setMotion: MoveTo temp2 temp1
				)
			)
			(5
				(HandsOff)
				(Print 603 4) ; "You offer the bag of gold coins to the old miser ghost. He greedily snatches it from your hands, and then promptly disappears."
				(gEgo put: 13 -1) ; Gold_Coins
				(gGame changeScore: 2)
				(theGhost setLoop: setMotion: 0)
				(= seconds 2)
			)
			(6
				(theGhost
					view: 200
					cycleSpeed: 1
					setCel: 255
					setCycle: Beg self
				)
			)
			(7
				(HandsOn)
				(regHauntedHouse notify: 3)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(event claimed:)
				(!= (event type:) evSAID)
				(!= gCurRoomNum global133)
				(not (gCast contains: theGhost))
			)
			(return)
		)
		(cond
			((Said 'look/chain')
				(Print 603 5) ; "The stooped miser ghost is manacled to heavy chains he can never escape."
			)
			((Said 'get/chain')
				(Print 603 6) ; "You can't get the chains. Besides, you wouldn't want them."
			)
			((Said 'give>')
				(cond
					(
						(or
							(not (= temp0 (gInventory saidMe:)))
							(not (gEgo has: (gInventory indexOf: temp0)))
						)
						(event claimed: 0)
					)
					((> (gEgo distanceTo: theGhost) 30)
						(NotClose) ; "You're not close enough."
					)
					((!= (gInventory indexOf: temp0) 13)
						(Print 603 7) ; "The ghost of the old miser doesn't even notice you."
					)
					(else
						(self cue: -1)
					)
				)
			)
			((Said 'talk')
				(Print 603 8) ; "The old miser ghost's loud moans and groans drown out your attempted conversation."
			)
			((Said 'look')
				(Print 603 9) ; "The ghost of a stooped old miser trudges through the house, lugging heavy chains behind him. He moans loudly in frustration as he appears to be searching for something he can't find."
			)
			((Said 'kiss')
				(Print 603 10) ; "You can't, as the ghost has no substance."
			)
			((Said 'capture,get')
				(Print 603 11) ; "You can't get a ghost!"
			)
			((Said 'kill')
				(Print 603 12) ; "How can you kill something that is already dead!"
			)
			((Said 'help')
				(Print 603 13) ; "You'd like to help the old miser ghost, but how can you do that?"
			)
		)
	)
)

(instance ladyScript of Script
	(properties)

	(method (cue param1)
		(cond
			((not argc)
				(super cue:)
			)
			((== param1 -1)
				(= seconds 0)
				(self
					changeState:
						(cond
							((< state 4) 4)
							((< state 7) 7)
						)
				)
			)
			((and (== param1 -2) (< state 7))
				(self changeState: 2)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGhost posn: (theGhost x:) (+ (theGhost y:) 1000))
				(Load rsVIEW 202)
				(Load rsVIEW 203)
				(= global133 60)
				(= seconds 3)
			)
			(1
				(Print 603 14) ; "The sound of sorrowful weeping floats down from upstairs."
				(= seconds (Random 10 30))
			)
			(2
				(= seconds 3)
			)
			(3
				(if
					(and
						(!= gCurRoomNum 66)
						(!= gCurRoomNum 61) ; HauntedTowerMiddle
						(!= gCurRoomNum 58)
						(!= gCurRoomNum 60)
					)
					(Print 603 15) ; "The sound of weeping fills the house."
				)
				(-- state)
				(= seconds (Random 50 99))
			)
			(4
				(= global135 1)
				(= seconds 3)
			)
			(5
				(ladyGhostMusic loop: 1 play:)
				(theGhost
					view: 202
					posn: 85 133
					ignoreActors: 1
					cycleSpeed: 3
					loop: 0
					cel: 0
					setCycle: End self
					init:
				)
			)
			(6
				(theGhost view: 203 setCycle: Fwd)
			)
			(7
				(HandsOff)
				(theGhost view: 202 loop: 0 setCel: 255 setCycle: Beg self)
			)
			(8
				(HandsOn)
				(= global133 67)
				(regHauntedHouse notify: 4)
			)
		)
	)
)

(instance lordScript of Script
	(properties)

	(method (cue param1 param2)
		(cond
			((not argc)
				(super cue:)
			)
			((== param1 -1)
				(= seconds 0)
				(self
					changeState:
						(cond
							((< state 4) 4)
							((< state 9) 9)
						)
				)
			)
			((== param1 -2)
				(= global133
					(if (and (<= 64 param2 68) (!= param2 66) (Random 0 1))
						param2
					else
						0
					)
				)
				(self changeState: 2)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGhost posn: (theGhost x:) (+ (theGhost y:) 1000))
				(Load rsVIEW 204)
				(Load rsVIEW 206)
				(= seconds 3)
			)
			(1
				(Print 603 16) ; "What was that? A loud wailing sound comes from downstairs!"
				(= seconds (Random 3 5))
			)
			(2
				(= seconds 3)
			)
			(3
				(if (and (!= gCurRoomNum 66) (!= gCurRoomNum 61) (!= gCurRoomNum 58)) ; HauntedTowerMiddle
					(Print 603 17) ; "The sound of anguished wailing reaches you."
				)
				(-- state)
				(= seconds (Random 40 99))
			)
			(4
				(= global135 1)
				(= seconds (Random 2 5))
			)
			(5
				(= seconds 0)
				(lordGhostMusic loop: 1 play:)
				(theGhost
					view: 204
					cel: 0
					posn: 150 160
					illegalBits: 0
					cycleSpeed: 1
					ignoreActors: 1
					setStep: 4 2
					setCycle: End self
					init:
				)
			)
			(6
				(theGhost
					view: 206
					loop: (Random 0 3)
					moveSpeed: 1
					cycleSpeed: 1
					setLoop: -1
					setCycle: Walk
				)
				(if (== gCurRoomNum 68)
					(theGhost setMotion: GhostWander 78 156 225 185)
				else
					(theGhost setMotion: GhostWander 75 130 225 175)
				)
				(= seconds (Random 13 30))
			)
			(7
				(theGhost view: 204 loop: 0 setCel: 255 setCycle: Beg self)
			)
			(8
				(= state 4)
				(= seconds (Random 20 99))
			)
			(9
				(HandsOff)
				(Print 603 18) ; "You offer the Medal of Honor to the wailing ghost. He takes it from your hands with great reverence. Satisfied, he vanishes into thin air."
				(theGhost setMotion: 0)
				(= seconds 3)
			)
			(10
				(= seconds 0)
				(gEgo put: 29 -1) ; Medal
				(gGame changeScore: 2)
				(theGhost view: 204 loop: 0 setCel: 255 setCycle: Beg self)
			)
			(11
				(regHauntedHouse notify: 5)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(event claimed:)
				(!= (event type:) evSAID)
				(!= gCurRoomNum global133)
				(not global135)
			)
			(return)
		)
		(cond
			((Said 'give>')
				(cond
					(
						(or
							(not (= temp0 (gInventory saidMe:)))
							(not (gEgo has: (gInventory indexOf: temp0)))
						)
						(event claimed: 0)
					)
					((> (gEgo distanceTo: theGhost) 30)
						(NotClose) ; "You're not close enough."
					)
					((!= (gInventory indexOf: temp0) 29)
						(Print 603 19) ; "The gentleman ghost of the Lord of the Manor doesn't seem to even see you."
					)
					(else
						(self changeState: 9)
					)
				)
			)
			((Said 'talk')
				(Print 603 20) ; "You say a few words to the wailing gentleman ghost, but he ignores you as he continues his futile search."
			)
			((Said 'look')
				(Print 603 21) ; "You have encountered the gentleman ghost of the distinguished Lord of the Manor. He wails despondently as he seems to be looking for something he desperately wants."
			)
			((Said 'kiss')
				(Print 603 10) ; "You can't, as the ghost has no substance."
			)
			((Said 'get,capture/*')
				(Print 603 22) ; "You can't catch a ghost!"
			)
			((Said 'kill/*')
				(Print 603 12) ; "How can you kill something that is already dead!"
			)
			((Said 'help/*')
				(Print 603 23) ; "You'd like to help the distinguished ghost, but how can you do that?"
			)
		)
	)
)

(instance boyScript of Script
	(properties)

	(method (cue param1)
		(cond
			((not argc)
				(super cue:)
			)
			((== param1 -1)
				(= seconds 0)
				(self
					changeState:
						(cond
							((== gCurRoomNum 63) 11)
							((< state 11) 2)
						)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(theGhost posn: (theGhost x:) (+ (theGhost y:) 1000))
				(Load rsVIEW 207)
				(Load rsVIEW 208)
				(= global134 5)
				(= seconds 2)
			)
			(2
				(HandsOn)
				(boyGhostMusic dispose:)
				(cond
					((== gCurRoomNum 60)
						(= global135 1)
						(= cycles 1)
					)
					((and (!= gCurRoomNum 66) (!= gCurRoomNum 61) (!= gCurRoomNum 58)) ; HauntedTowerMiddle
						(= global135 1)
						(= seconds (Random 1 3))
					)
				)
			)
			(3
				(boyGhostMusic loop: 1 play:)
				(theGhost
					view: 207
					illegalBits: 0
					ignoreActors: 1
					setPri: -1
					loop: 0
					cel: 0
					setCycle: End self
					posn:
						(switch gCurRoomNum
							(60 159)
							(64 83)
							(65 255) ; HauntedKitchen
							(67 239)
							(68 165)
						)
						(switch gCurRoomNum
							(60 136)
							(64 124)
							(65 148) ; HauntedKitchen
							(67 136)
							(68 83)
						)
					init:
				)
				(if (== gCurRoomNum 60)
					(theGhost setPri: 10)
				)
			)
			(4
				(if (== local1 0)
					(= local1 1)
					(Print 603 24) ; "A cute, little boy ghost suddenly appears! He grins mischieviously at you, begins to giggle, and runs from the room."
				else
					(Print 603 25) ; "You hear naughty giggling as the little boy ghost runs from the room."
				)
				(theGhost
					view: 208
					moveSpeed: 0
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
				)
				(switch gCurRoomNum
					(60
						(theGhost
							setPri: 10
							setCycle: Fwd
							setMotion: MoveTo 158 15
						)
						(= global133 63)
					)
					(64
						(theGhost setPri: 9 setMotion: MoveTo 0 143 self)
						(= global133 68)
					)
					(65 ; HauntedKitchen
						(theGhost setMotion: MoveTo 240 190 self)
						(= global133 64)
					)
					(67
						(theGhost setMotion: MoveTo 300 136 self)
						(= global133 68)
					)
					(68
						(theGhost setMotion: MoveTo 193 73 self)
						(= global133 60)
					)
				)
			)
			(5
				(theGhost view: 207 loop: 0 setCel: 255 setCycle: Beg self)
			)
			(6
				(= global135 0)
				(theGhost posn: (theGhost x:) (+ (theGhost y:) 1000))
			)
			(11
				(= global135 1)
				(Load rsVIEW 209)
				(boyGhostMusic loop: 1 play:)
				(theGhost
					view: 207
					loop: 1
					cel: 0
					posn: 167 117
					setPri: 8
					cycleSpeed: 1
					setCycle: End self
					init:
				)
			)
			(12
				(theGhost
					view: 209
					loop: (Random 0 3)
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(13
				(if (== gCurRoomNum 63)
					(Print 603 26) ; "The little boy ghost laughs, and refuses to budge from his seat on top of the chest. It might help if he had a toy to play with."
				)
				(= seconds 3)
			)
			(14
				(theGhost loop: (Random 0 3))
				(-- state)
				(= cycles (Random 30 60))
			)
			(21
				(HandsOff)
				(Print 603 27) ; "You give the toy horse to the little boy ghost in hopes that he will vanish like the others before him. For a moment, you fear that he will not, as he takes time to examine it carefully. Suddenly, he grins at you, and in a twinkling, disappears."
				(gEgo put: 30 -1) ; Toy_Horse
				(gGame changeScore: 2)
				(= seconds 2)
			)
			(22
				(= global134 255)
				(theGhost
					view: 207
					loop: 1
					setCel: 255
					setCycle: Beg self
					init:
				)
			)
			(23
				(HandsOn)
				(theGhost dispose:)
				(regHauntedHouse notify: 255)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(event claimed:)
				(!= (event type:) evSAID)
				(!= gCurRoomNum global133)
				(not global135)
			)
			(return)
		)
		(cond
			((Said 'give>')
				(cond
					(
						(or
							(not (= temp0 (gInventory saidMe:)))
							(not (gEgo has: (gInventory indexOf: temp0)))
						)
						(event claimed: 0)
					)
					((> (gEgo distanceTo: theGhost) 30)
						(NotClose) ; "You're not close enough."
					)
					((!= (gInventory indexOf: temp0) 30)
						(Print 603 28) ; "The ghost of the little boy just looks at you, and laughs."
					)
					((!= gCurRoomNum 63)
						(Print 603 29) ; "This isn't the time or place."
					)
					(else
						(self changeState: 21)
					)
				)
			)
			((Said 'talk')
				(Print 603 30) ; "You try to talk to the boy ghost, but he only giggles."
			)
			((Said 'kiss')
				(Print 603 10) ; "You can't, as the ghost has no substance."
			)
			((Said 'look/ghost[<boy]')
				(if (== gCurRoomNum 63)
					(Print 603 31) ; "The ghost of the little boy giggles and teases as he sits on the chest."
				else
					(Print 603 32) ; "The ghost of a little boy, giggles and teases as he tempts you to follow him."
				)
			)
			((Said 'play/ghost[<boy]')
				(Print 603 33) ; "It's difficult to play with a ghost."
			)
			((Said 'capture,get/ghost[<boy]')
				(Print 603 11) ; "You can't get a ghost!"
			)
			((Said 'kill/*')
				(Print 603 12) ; "How can you kill something that is already dead!"
			)
			((Said 'help,save/*')
				(Print 603 34) ; "You'd like to help the little boy ghost, but how can you do that?"
			)
		)
	)
)

(instance lordGhostMusic of Sound
	(properties
		number 25
		keep 1
	)
)

(instance miserGhostMusic of Sound
	(properties
		number 23
		keep 1
	)
)

(instance ladyGhostMusic of Sound
	(properties
		number 24
		keep 1
	)
)

(instance boyGhostMusic of Sound
	(properties
		number 26
		keep 1
	)
)

