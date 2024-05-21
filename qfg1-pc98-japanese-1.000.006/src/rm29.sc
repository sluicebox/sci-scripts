;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Interface)
(use n802)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm29 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(procedure (localproc_0 param1 param2 &tmp [temp0 400])
	(Format @temp0 &rest)
	(Print @temp0 #at -1 5 #mode 1 #width param2 #dispose #time param1)
)

(procedure (localproc_1)
	(= local5 1)
	(= local7 1)
	(SetFlag 143)
)

(procedure (localproc_2)
	(= local5 5)
	(= local7 1)
)

(instance Magic of Prop
	(properties
		view 530
		cycleSpeed 2
	)
)

(instance leftDoor of Prop
	(properties
		view 29
	)
)

(instance rightDoor of Prop
	(properties
		view 29
		loop 1
	)
)

(instance gargoyle of Prop
	(properties
		view 29
		loop 2
	)
)

(instance gargoyleHead of Prop
	(properties
		view 29
		loop 5
		cel 1
		cycleSpeed 1
	)
)

(instance rm29 of Rm
	(properties
		picture 29
		style 8
		horizon 157
		north 30
	)

	(method (dispose)
		(SetFlag 19)
		(super dispose:)
	)

	(method (init)
		(Load rsSCRIPT 802)
		(Load rsVIEW 29)
		(Load rsVIEW 530)
		(super init:)
		(gKeyHandler add: self)
		(SL enable:)
		(EgoGait 0 0) ; walking
		(gargoyle cycleSpeed: 2 posn: 155 88 init: stopUpd:)
		(gargoyleHead
			ignoreActors:
			posn: 156 75
			setPri: 15
			setCycle: Fwd
			init:
			hide:
			stopUpd:
		)
		(leftDoor
			cel: (if (== gPrevRoomNum 30) 2 else 0)
			posn: 144 156
			init:
			stopUpd:
		)
		(rightDoor
			cel: (if (== gPrevRoomNum 30) 2 else 0)
			posn: 167 156
			init:
			stopUpd:
		)
		(self setScript: walkIn)
	)

	(method (doit)
		(cond
			(local7
				(= local7 0)
				(gargoyle setScript: 0)
				(self setScript: teleportOut)
			)
			((and local0 (== (gEgo edgeHit:) EDGE_BOTTOM))
				(gCurRoom newRoom: 28)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event))
			(
				(and
					local10
					(== local9 1)
					(proc802_2
						event
						(switch (gGame parseLang:)
							(1 @global401)
							(else @global594)
						)
					)
				)
				(askQuestions changeState: 0)
			)
			((!= (event type:) evSAID))
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/!*,house,mansion,north]')
						(HighPrint 29 0) ; "You see the purple home of someone who must enjoy its precarious perch upon the peak."
					)
					((Said '/gargoyle,creature')
						(HighPrint 29 1) ; "The stone creature looks like it's bored. Wouldn't you be?"
					)
					((Said '/cliff,boulder')
						(HighPrint 29 2) ; "The cliff walls are steep, and it's a long way to the snow fields below."
					)
					((Said '/hill,peak,east')
						(HighPrint 29 3) ; "You can see the mist flowing around the edges of the Wolf's Bane Peaks."
					)
					((Said '/ice')
						(HighPrint 29 4) ; "Below you, the snow glistens."
					)
					((or (Said '<up') (Said '/sky'))
						(HighPrint 29 5) ; "It is cloudless. It seems that you are above the clouds."
					)
					((or (Said '<down') (Said '/ground,path,south'))
						(HighPrint 29 6) ; "Looking down and to the south, you see the tortuous path you climbed to get here. You'd hate to have to do that again."
					)
					((Said '/castle,west,forest')
						(HighPrint 29 7) ; "Looking below you to the west, you can see the Baron's Castle surrounded by the forest."
					)
					((Said '/window')
						(HighPrint 29 8) ; "From outside, you can see that the interior of the house is curiously furnished."
					)
					((Said '/door')
						(if local4
							(HighPrint 29 9) ; "It's about time the gargoyle opened the door for you."
						else
							(HighPrint 29 10) ; "You'd like to look at it more closely, if only the gargoyle would let you."
						)
					)
				)
			)
			((Said 'throw,attack,attack,kill,hit')
				(localproc_2)
			)
			((Said 'cast>')
				(switch (= temp0 (SaidSpell event))
					(18
						(if (CastSpell temp0)
							(HighPrint 29 11) ; "You detect a strange, magical aura in this place."
						)
					)
					(20
						(if (CastSpell temp0)
							(localproc_2)
						)
					)
					(23
						(if (CastSpell temp0)
							(localproc_2)
						)
					)
					(17
						(if (CastSpell temp0)
							(if local4
								(HighPrint 29 12) ; "The door is already open."
							else
								(localproc_2)
							)
						)
					)
				)
			)
			((and (not gNight) (Said 'japaneserestorsleep>')))
			((or (Said 'nap,nap[/!*]') (Said 'go[<to]/nap,nap'))
				(= local5 4)
				(= local7 1)
			)
			(local10
				(if (Said 'ask,where,what,why,who,how')
					(= local5 2)
					(= local7 1)
					(SetFlag 143)
				else
					(switch local9
						(1
							(localproc_1)
						)
						(2
							(switch local8
								(1
									(if
										(or
											(Said '/magenta,pink')
											(Said '//magenta,pink')
										)
										(askQuestions changeState: 0)
									else
										(localproc_1)
									)
								)
								(2
									(if
										(or
											(Said '/hero,fame,wizard')
											(Said '//hero,fame,wizard')
										)
										(askQuestions changeState: 0)
									else
										(localproc_1)
									)
								)
								(3
									(if
										(or
											(Said '/fenrus,erasmus,wizard')
											(Said '//fenrus,erasmus,wizard')
										)
										(askQuestions changeState: 0)
									else
										(localproc_1)
									)
								)
							)
						)
						(3
							(if (IsFlag 154)
								(switch local8
									(1
										(if
											(or
												(Said '/yorick')
												(Said '//yorick')
											)
											(askQuestions changeState: 0)
										else
											(localproc_1)
										)
									)
									(2
										(if (or (Said '/baba') (Said '//baba'))
											(askQuestions changeState: 0)
										else
											(localproc_1)
										)
									)
									(3
										(if (or (Said '/karl') (Said '//karl'))
											(askQuestions changeState: 0)
										else
											(localproc_1)
										)
									)
									(4
										(if
											(or
												(Said 'maybe')
												(Said '/maybe')
												(Said '//maybe')
											)
											(askQuestions changeState: 0)
										else
											(localproc_1)
										)
									)
								)
							else
								(switch local8
									(1
										(if
											(or
												(Said '/baron')
												(Said '//baron')
											)
											(askQuestions changeState: 0)
										else
											(localproc_1)
										)
									)
									(2
										(if
											(or
												(Said '/erana')
												(Said '//erana')
											)
											(askQuestions changeState: 0)
										else
											(localproc_1)
										)
									)
									(3
										(if
											(or
												(Said '/blowfish')
												(Said '//blowfish')
											)
											(= local5 3)
											(= local7 1)
											(SetFlag 143)
										else
											(= local6 1)
											(askQuestions changeState: 0)
										)
									)
								)
							)
						)
					)
				)
				(event claimed: 1)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(UseStamina 30)
				(cond
					((< [gEgoStats 15] 20) ; stamina
						(= local2 1)
					)
					((< [gEgoStats 15] 60) ; stamina
						(= local1 1)
					)
				)
				(= local10 1)
				(cond
					(local2
						(gEgo
							cycleSpeed: 2
							moveSpeed: 2
							view: 515
							setLoop: 2
							posn: 142 233
							setMotion: MoveTo 148 183 self
						)
					)
					(local1
						(gEgo
							cycleSpeed: 1
							moveSpeed: 1
							view: 515
							setLoop: 2
							posn: 142 233
							setMotion: MoveTo 148 183 self
						)
					)
					(else
						(gEgo posn: 135 213 setMotion: MoveTo 152 180 self)
					)
				)
				(gEgo init:)
			)
			(1
				(cond
					(local2
						(gEgo setLoop: 1 cel: 0 setCycle: End)
						(= cycles 30)
					)
					(local1
						(gEgo
							cycleSpeed: 2
							moveSpeed: 2
							setLoop: 0
							cel: 0
							setCycle: CT 5 1
						)
						(= cycles 20)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(cond
					(local2
						(gEgo setCycle: Beg self)
					)
					(local1
						(gEgo setCycle: End self)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if local2
					(gEgo setLoop: 0 cel: 7 forceUpd:)
					(= cycles 5)
				else
					(self cue:)
				)
			)
			(4
				(= local0 1)
				(cond
					((not (IsFlag 19))
						(HighPrint 29 13) ; "You feel as though you have just scaled the Matterhorn in full armor. What a climb!"
						(HighPrint 29 14) ; "After you finally catch your breath, you see that you have reached the rather eccentric-looking house that you saw from below."
						(HighPrint 29 15) ; "There is an ugly gargoyle above the entrance."
						(self cue:)
					)
					(local2
						(HighPrint 29 16) ; "Your body can't take too much more of this kind of mountaineering. At this point, you envy the gargoyle his job."
						(self cue:)
					)
					(local1
						(HighPrint 29 17) ; "No matter how strong you feel at the bottom of the mountain, you're always more exhausted than the last time you reached the top."
						(self cue:)
					)
					(else
						(HighPrint 29 18) ; "The climb seems much longer this time, but you made it!"
						(self cue:)
					)
				)
			)
			(5
				(HandsOff)
				(gargoyle cel: 1 forceUpd:)
				(= cycles 5)
			)
			(6
				(gargoyleHead show: startUpd:)
				(cond
					(gNight
						(localproc_0 4 210 29 19)
					)
					(local2
						(localproc_0 4 160 29 20)
					)
					((not (IsFlag 19))
						(localproc_0 4 110 29 21)
					)
					(local1
						(localproc_0 4 210 29 22)
					)
					(else
						(localproc_0 4 140 29 23)
					)
				)
				(= seconds 4)
			)
			(7
				(cond
					(gNight
						(= local7 1)
						(gargoyleHead stopUpd: hide:)
					)
					(local2
						(localproc_0 4 230 29 24)
					)
					((IsFlag 354)
						(localproc_0 4 230 29 25)
					)
					(else
						(SetFlag 354)
						(localproc_0 4 280 29 26)
					)
				)
				(= seconds 4)
			)
			(8
				(gargoyleHead hide: stopUpd:)
				(= cycles 5)
			)
			(9
				(rm29 setScript: askQuestions)
			)
		)
	)
)

(instance teleportOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local5
					(0
						(localproc_0 4 100 29 27)
					)
					(1
						(localproc_0 4 70 29 28)
					)
					(2
						(localproc_0 4 140 29 29)
					)
					(3
						(localproc_0 4 180 29 30)
					)
					(4
						(localproc_0 4 140 29 31)
					)
					(5
						(localproc_0 4 180 29 32)
					)
				)
				(HandsOff)
				(gargoyleHead show: startUpd:)
				(= seconds 4)
			)
			(1
				(if 2
					(gargoyleHead hide: stopUpd:)
				)
				(gargoyle setLoop: 4 setCycle: End self)
			)
			(2
				(gargoyle cel: 0 setCycle: End self)
			)
			(3
				(gargoyle setLoop: 3 cel: 0 setCycle: Fwd)
				(Magic
					ignoreActors:
					setPri: (+ (gEgo priority:) 1)
					posn:
						(if
							(and
								(== (gEgo view:) 515)
								(== (gEgo loop:) 0)
							)
							(+ (gEgo x:) 5)
						else
							(gEgo x:)
						)
						(gEgo y:)
					init:
					setCycle: CT 6 1 self
				)
			)
			(4
				(gEgo hide:)
				(Magic setCycle: End self)
			)
			(5
				(SetFlag 142)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 16)
				(self cue:)
			)
			(6
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance askQuestions of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (< (gEgo y:) 175))
			(= local7 1)
		)
		(if local3
			(= local3 0)
			(rm29 setScript: letHimIn)
			(gargoyle setScript: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gargoyleHead show: startUpd:)
				(switch (++ local9)
					(1
						(localproc_0 4 170 29 33)
						(NormalEgo)
						(gEgo loop: 3)
					)
					(2
						(switch (Random 1 3)
							(1
								(= local8 1)
								(localproc_0 4 260 29 34)
							)
							(2
								(= local8 2)
								(localproc_0 4 160 29 35)
							)
							(3
								(= local8 3)
								(localproc_0 4 180 29 36)
							)
						)
					)
					(3
						(if (IsFlag 154)
							(switch (Random 1 4)
								(1
									(= local8 1)
									(localproc_0 4 230 29 37)
								)
								(2
									(= local8 2)
									(localproc_0 4 260 29 38)
								)
								(3
									(= local8 3)
									(localproc_0 4 230 29 39)
								)
								(4
									(= local8 4)
									(localproc_0 4 240 29 40)
								)
							)
						else
							(switch (Random 1 3)
								(1
									(= local8 1)
									(localproc_0 4 280 29 41)
								)
								(2
									(= local8 2)
									(localproc_0 4 280 29 42)
								)
								(3
									(= local8 3)
									(localproc_0 4 280 29 43)
								)
							)
						)
					)
					(else
						(= local3 1)
					)
				)
				(= seconds 4)
			)
			(1
				(HandsOn)
				(gargoyleHead hide: stopUpd:)
			)
		)
	)
)

(instance letHimIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gargoyleHead show: startUpd:)
				(= local10 0)
				(if local6
					(localproc_0 3 240 29 44)
				else
					(localproc_0 3 140 29 45)
				)
				(= seconds 3)
			)
			(1
				(localproc_0 4 230 29 46)
				(= seconds 4)
			)
			(2
				(localproc_0 4 220 29 47)
				(= seconds 4)
			)
			(3
				(gargoyleHead hide: stopUpd:)
				(gargoyle setLoop: 3 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(4
				(= local4 1)
				(leftDoor setCycle: End)
				(rightDoor setCycle: End self)
			)
			(5
				(leftDoor ignoreActors: stopUpd:)
				(rightDoor ignoreActors: stopUpd:)
				(HandsOn)
				(NormalEgo)
				(gEgo loop: 3)
				(gargoyle setLoop: 2 setCel: 0 stopUpd:)
			)
		)
	)
)

