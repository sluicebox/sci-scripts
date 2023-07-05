;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	Room78 0
)

(synonyms
	(kiss kiss embrace)
	(cobra cobra)
)

(local
	local0
	local1
	[local2 18]
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
)

(instance Room78 of Rm
	(properties
		picture 78
	)

	(method (init)
		(= east 78)
		(= west 77)
		(= horizon 40)
		(= gIndoors 0)
		(if gNight
			(= picture 178)
		)
		(super init:)
		(self setRegions: 513) ; swampReg
		(Load rsVIEW 330)
		(Load rsVIEW 69)
		(Load rsVIEW 59)
		(Load rsVIEW 55)
		(Load rsVIEW 21)
		(Load rsVIEW 515)
		(Load rsVIEW 888)
		(Load rsSOUND 50)
		(Load rsSOUND 39)
		(Load rsSOUND 40)
		(Load rsSOUND 55)
		(Load rsVIEW 508)
		(= local25 (Prop new:))
		(= local26 (Prop new:))
		(local25
			view: 650
			loop: 3
			cel: 1
			posn: 126 88
			setPri: 0
			setCycle: Fwd
			init:
		)
		(local26
			view: 650
			loop: 5
			cel: 0
			posn: 74 143
			setPri: 0
			setCycle: Fwd
			init:
		)
		(= global105 12)
		(switch gPrevRoomNum
			(west
				(gEgo
					view: 2
					loop: 0
					cel: 0
					posn: 3 167
					setCycle: Walk
					setScript: boardActions
				)
			)
			(0
				(gEgo
					view: 2
					loop: 0
					cel: 0
					posn: 3 167
					setCycle: Walk
					setScript: boardActions
				)
			)
		)
		(gEgo view: 2 xStep: 2 yStep: 1 init:)
		(gEgo edgeHit: 0)
		(= [local2 0] 5)
		(= [local2 1] 167)
		(= [local2 2] 27)
		(= [local2 3] 170)
		(= [local2 4] 42)
		(= [local2 5] 167)
		(= [local2 6] 61)
		(= [local2 7] 169)
		(= [local2 8] 79)
		(= [local2 9] 166)
		(= [local2 10] 98)
		(= [local2 11] 169)
		(= [local2 12] 117)
		(= [local2 13] 170)
		(= [local2 14] 124)
		(= [local2 15] 162)
		(if ((Inv at: 25) ownedBy: 78) ; Magic_Fruit
			(= local23 (Prop new:))
			(local23
				view: 508
				posn: 187 147
				setLoop: 0
				cycleSpeed: 1
				setPri: 12
				setScript: fruitActions
				init:
			)
		)
		(= local21 (Act new:))
		(local21
			view: 330
			posn: 196 164
			cel: 0
			setLoop: 0
			setScript: snakeActions
			init:
		)
		(if ((Inv at: 22) ownedBy: 78) ; Board
			(= local24 (View new:))
			(local24
				view: 515
				cel: 0
				loop: 0
				ignoreActors:
				setPri: 12
				posn: 121 169
				init:
			)
		)
		(gCurRoom setScript: jump)
		(= global205 1)
		(User canInput: 1)
	)

	(method (dispose)
		(DisposeScript 991)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'hop,hop')
					(cond
						((> (gEgo x:) 109)
							(Print 78 0) ; "Not from here!"
						)
						((and (== local0 5) ((Inv at: 22) ownedBy: 78)) ; Board
							(if
								(and
									(gEgo inRect: 92 164 109 172)
									(!= (gEgo loop:) 1)
								)
								(Print 78 1) ; "Just walk there."
							else
								(jump changeState: 1)
							)
						)
						((== global105 13)
							(Print 78 2) ; "Just move there."
						)
						(else
							(jump changeState: 1)
						)
					)
				)
				((Said 'play/flute')
					(if (== (gEgo view:) 2)
						(if (gEgo has: 0) ; Silver_Flute
							(if (== (snakeActions state:) 20)
								(Print 78 3) ; "The snake is already mesmerized."
							else
								(snakeActions changeState: 20)
							)
							(if (not global155)
								(gGame changeScore: 4)
								(= global155 1)
							)
						else
							(Print 800 2) ; "You don't have it."
						)
					else
						(Print 800 3) ; "You can't do that now."
					)
				)
				((Said 'get/fruit')
					(cond
						((gEgo has: 25) ; Magic_Fruit
							(Print 78 4) ; "You already have it."
						)
						((and (== local22 2) (gEgo inRect: 171 157 195 167))
							(if ((Inv at: 25) ownedBy: 78) ; Magic_Fruit
								(Print 78 5) ; "Ok."
								((Sound new:) number: 50 loop: 1 play:)
								(local23 dispose:)
								((Inv at: 25) moveTo: gEgo) ; Magic_Fruit
								(gGame changeScore: 10)
							else
								(Print 78 6) ; "How could you do that?"
							)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				((Said 'get/board')
					(cond
						((not ((Inv at: 22) ownedBy: 78)) ; Board
							(Print 78 7) ; "It's not there."
						)
						((> (gEgo x:) 109)
							(Print 78 0) ; "Not from here!"
						)
						((or (!= (gEgo onControl: 1) 1024) (!= local0 5))
							(Print 78 8) ; "Not here."
						)
						(else
							(boardActions changeState: 10)
						)
					)
				)
				((Said 'lay,place/board')
					(cond
						((not (gEgo has: 22)) ; Board
							(DontHave) ; "You don't have it."
						)
						((> (gEgo x:) 109)
							(Print 78 0) ; "Not from here!"
						)
						((or (!= (gEgo onControl: 1) 1024) (!= local0 5))
							(Print 78 8) ; "Not here."
						)
						(else
							(boardActions changeState: 1)
						)
					)
				)
				((Said 'give/*[/cobra]>')
					(if (= temp0 (gInventory saidMe:))
						(if (gEgo has: (gInventory indexOf: temp0))
							(Print 78 9) ; "The snake does not require anything from you."
						else
							(DontHave) ; "You don't have it."
						)
					else
						(Print 78 10) ; "You can't give that."
						(event claimed: 1)
					)
				)
				((and (Said 'throw/*[/cobra]>') (= temp0 (gInventory saidMe:)))
					(if (gEgo has: (gInventory indexOf: temp0))
						(Print 78 11) ; "The snake would not be affected by that."
					else
						(event claimed: 0)
					)
				)
				((Said 'look>')
					(cond
						((Said '/cobra')
							(cond
								((== (snakeActions state:) 21)
									(Print 78 12) ; "The large cobra seems completely under your spell...but not for long!"
								)
								(((Inv at: 25) ownedBy: 78) ; Magic_Fruit
									(Print 78 13) ; "A HUGE cobra protects the small tree that bears the wondrous fruit; the fruit that your father's life depends upon."
								)
								(else
									(Print 78 14) ; "A HUGE cobra protects the small island."
								)
							)
						)
						((Said '/forest')
							(if ((Inv at: 25) ownedBy: 78) ; Magic_Fruit
								(Print 78 15) ; "The tree is small and scrawny. It looks like it's taken almost every ounce of its strength to produce this one, wondrous fruit."
							else
								(Print 78 16) ; "The small tree looks bare and lonely without its marvelous fruit. Oh, well; in a mere hundred years it'll have another one."
							)
						)
						((Said '/fruit')
							(cond
								(((Inv at: 25) ownedBy: 78) ; Magic_Fruit
									(Print 78 17) ; "You see a single glistening fruit upon the scrawny tree."
								)
								((gEgo has: 25) ; Magic_Fruit
									((Inv at: 25) showSelf:) ; Magic_Fruit
								)
								(else
									(Print 78 18) ; "You don't see one here."
								)
							)
						)
						((Said '/island')
							(if ((Inv at: 25) ownedBy: 78) ; Magic_Fruit
								(Print 78 19) ; "A tiny tree grows on this little swamp island. Hanging from a small branch is a large, glistening fruit."
							else
								(Print 78 20) ; "A tiny tree grows on this little swamp island."
							)
						)
						((Said '/grass,tuft')
							(Print 78 21) ; "The grass tufts lead to the small island."
						)
						((Said '[<around][/marsh,room]')
							(Print
								(Format ; "You see a small island in the middle of the huge swamp. Upon this island grows a scrawny little tree. %s Unfortunately, a huge cobra protects it."
									@global300
									78
									22
									(if ((Inv at: 25) ownedBy: 78) ; Magic_Fruit
										{A large, glistening fruit hangs from a small branch.}
									else
										{}
									)
								)
							)
						)
					)
				)
				(
					(and
						(Said '*[/cobra]>')
						(cond
							((Said 'talk')
								(Print 78 23) ; "Cobras don't usually talk."
								1
							)
							((Said 'kill')
								(Print 78 24) ; "You have NO way of killing a big cobra."
								1
							)
							((Said 'get,capture/*')
								(Print 78 25) ; "You wouldn't want the cobra!"
								1
							)
							((Said 'kiss')
								(Print 78 26) ; "That is NOT a good idea!"
								1
							)
							((Said 'hit/*')
								(Print 78 27) ; "You couldn't get close enough. Besides, the cobra's too big!"
								1
							)
						)
					)
					1
				)
			)
		)
	)
)

(instance jump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if (== (gEgo loop:) 0)
					(++ local0)
					(+= local1 2)
				else
					(-- local0)
					(-= local1 2)
				)
				(if (== local0 -1)
					(gCurRoom newRoom: 77)
					(return)
				)
				(HandsOff)
				(= local20 (gEgo viewer:))
				(gEgo viewer: 0)
				(gEgo view: 69 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setCycle: CT 1 -1 self)
			)
			(3
				(gEgo xStep: 6 yStep: 4)
				(cond
					((== (gEgo loop:) 0)
						(gEgo setLoop: 2 cel: 0 setCycle: End)
						(gEgo
							setMotion:
								JumpTo
								[local2 local1]
								[local2 (+ local1 1)]
								self
						)
					)
					((== (gEgo loop:) 1)
						(gEgo setLoop: 3 cel: 0 setCycle: End)
						(gEgo
							setMotion:
								JumpTo
								[local2 local1]
								[local2 (+ local1 1)]
								self
						)
					)
					((== (gEgo loop:) 2)
						(gEgo viewer: local20)
						(gEgo
							setMotion: JumpTo (gEgo x:) (+ (gEgo y:) 6)
						)
					)
					((== (gEgo loop:) 3)
						(gEgo viewer: local20)
						(gEgo
							setMotion: JumpTo (gEgo x:) (- (gEgo y:) 6)
						)
					)
				)
			)
			(4
				(if (== local0 6)
					(gEgo viewer: local20)
				)
				(if (== (gEgo loop:) 2)
					(gEgo cel: 0 setLoop: -1 loop: 4 setCycle: End self)
				else
					(gEgo cel: 0 setLoop: -1 loop: 5 setCycle: End self)
				)
			)
			(5
				(if (== (gEgo loop:) 4)
					(gEgo view: 2 loop: 0 cel: 0 xStep: 2 yStep: 1)
				else
					(gEgo view: 2 loop: 1 cel: 0 xStep: 2 yStep: 1)
				)
				(HandsOn)
				(gEgo viewer: local20)
				(gEgo view: 2 setCycle: Walk)
				(if (and (== local0 5) (== local22 0))
					(snakeActions changeState: 1)
				)
			)
			(10
				(Print 78 0) ; "Not from here!"
			)
		)
	)
)

(instance snakeActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== local22 1) (gEgo inRect: 170 157 217 170))
			(= local22 3)
			(snakeActions changeState: 10)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local27 (Sound new:))
				(local27 number: 39 init: play:)
				(local21 setCycle: End self)
			)
			(2
				(local21 setLoop: 1 setCycle: Fwd)
				(= local22 1)
			)
			(10
				(HandsOff)
				(gSounds eachElementDo: #dispose)
				(= local27 (Sound new:))
				(local27 number: 40 init: play:)
				(gEgo viewer: 0)
				(if (< (gEgo x:) 194)
					(local21 cel: 0 setLoop: 2 setCycle: End self)
				else
					(local21 cel: 0 setLoop: 3 setCycle: End self)
				)
			)
			(11
				(gEgo
					view: 59
					illegalBits: 0
					ignoreActors:
					cel: 0
					setCycle: End self
				)
			)
			(12
				(Print 78 28) ; "OH!! He gotcha! You die a painful death of snake poisoning."
				(local21 setLoop: 1 setCycle: Fwd)
				(= seconds 5)
			)
			(13
				(= gDeathFlag 1)
			)
			(20
				(HandsOff)
				(= global105 0)
				(gEgo view: 55 setMotion: 0 loop: 0 setCycle: Fwd)
				((= local28 (Prop new:))
					view: 888
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 1
					setCycle: Fwd
					posn: (+ (gEgo x:) 10) (- (gEgo y:) 27)
					init:
				)
				(gSounds eachElementDo: #dispose)
				((= local29 (Sound new:)) number: 55 play: self)
				(local21 setLoop: 4 setCycle: Fwd)
				(= local22 2)
			)
			(21
				(Print 78 29 #at -1 20) ; "Nervously, you raise the flute to your mouth and begin to play a melodic tune to the big cobra, who begins to sway with the music. Soon, the snake is mesmerized by it, and falls into an hypnotic trance."
				(gEgo view: 2 setCycle: Walk)
				(local28 dispose:)
				(= global105 12)
				((ScriptID 0 4) setReal: self 15) ; timer1
				(HandsOn)
			)
			(22
				(self changeState: 2)
			)
		)
	)
)

(instance boardActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 3)
			(if (gEgo inRect: 101 (- (local24 y:) 4) 150 (+ (local24 y:) 4))
				(= global132 1)
			else
				(= global132 0)
			)
		else
			(= global132 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo view: 21 loop: 0 cel: 0 setCycle: End self)
				(if (not global201)
					(= global201 1)
					(gGame changeScore: 2)
				)
			)
			(2
				(= local24 (View new:))
				(local24
					view: 515
					cel: 0
					loop: 0
					ignoreActors:
					setPri: 12
					posn: 121 (gEgo y:)
					init:
				)
				((Inv at: 22) moveTo: 78) ; Board
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
			)
			(10
				(HandsOff)
				(gEgo view: 21 loop: 0 cel: 0 setCycle: End self)
			)
			(11
				(local24 dispose:)
				((Inv at: 22) moveTo: gEgo) ; Board
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo view: 2 loop: 1 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

(instance fruitActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 5) setReal: self (Random 2 10)) ; timer2
			)
			(1
				(local23 cel: 0 setCycle: End self)
			)
			(2
				(local23 cel: 0)
				(self changeState: 0)
			)
		)
	)
)

