;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use TargActor)
(use Interface)
(use Feature)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	localTime
	[str 100]
	[invSave 58]
	bodySlams
	gotInv
	didDoorMsg
	showedPin
	maybeOk
	guardTimer = 5000
	spellMsg
	[sharafGenList 38] = [1 2 3 0 0 0 0 0 0 0 4 5 6 0 7 0 0 0 0 0 0 8 0 9 10 0 0 0 0 0 11 0 12 0 0 0 0 0]
	[sharafSpecList 22] = [13 '//pin' 14 '//underground,resistance' 15 '//escape,passage' 16 '//equipment,belonging' 17 '//shameen' 18 '//shema' 19 '//khaveen' 20 '//guard' 21 '//capture' 22 '//honor' 0 0]
)

(procedure (RemoveInvItems &tmp i hasPin)
	(= hasPin [gInvNum 27]) ; SapphPin
	(for ((= i 0)) (<= i 58) ((++ i))
		(= [invSave i] [gInvNum i])
		(if (!= i 27)
			(= [gInvNum i] 0)
		)
	)
)

(procedure (ReplaceInvItems &tmp i)
	(for ((= i 0)) (<= i 58) ((++ i))
		(if (or (== i 2) (== i 1))
			(= [gInvNum i] 0)
		else
			(= [gInvNum i] [invSave i])
		)
		(= [invSave i] 0)
	)
	(= gotInv 1)
)

(procedure (LeaveCell)
	(door hide:)
	(sharaf hide:)
	(straw hide:)
	(= global61 1)
	(gEgo illegalBits: -32768 ignoreActors: 0)
	(gCurRoom style: 15 drawPic: 2)
	(gCurRoom drawPic: 440 overlay: 442 7)
	(if (and (IsFlag 94) (gCast contains: shar)) ; fSharafFriend
		(gCurRoom setScript: dualEscapeS)
	)
)

(procedure (GoInCell)
	(door show:)
	(sharaf show:)
	(straw show:)
	(= global61 0)
	(gEgo illegalBits: -32768 ignoreActors: 0)
	(gCurRoom style: 15 drawPic: 2)
	(gCurRoom drawPic: 440 overlay: 441 7)
)

(instance rm440 of Rm
	(properties
		picture 440
		style 15
	)

	(method (init)
		(Load rsPIC 2 441 442)
		(LoadMany rsVIEW 440 445 49 576 6 47 382)
		(Load rsTEXT 445)
		(Load rsSOUND 20)
		(= gSpellChecker theSpellChecker)
		(= gEgoGait 0) ; walking
		(= localTime gTimeODay)
		(RemoveInvItems)
		(= global61 0)
		(super init:)
		(gCurRoom overlay: 441)
		(gEgo init:)
		(sharaf init: hide:)
		(shar init:)
		(door init:)
		(outerDoor init:)
		(secretDoor init: stopUpd:)
		(equipment init: stopUpd:)
		(guard init: setCycle: Walk setLoop: Grooper)
		(straw setPri: 0 init: stopUpd:)
		(win init:)
		(table init:)
		(wall init:)
		(inlets init:)
		(self setScript: thrownInS)
	)

	(method (doit)
		(super doit:)
		(-- guardTimer)
		(cond
			((gCurRoom script:))
			((not guardTimer)
				(self setScript: gotCaughtS)
			)
			((== guardTimer 1000)
				(HighPrint 440 0) ; "You hear the sound of guards talking just outside the door."
			)
		)
		(cond
			((gCurRoom script:))
			((and spellMsg (not (IsFlag 87))) ; fCastingSpell
				(= spellMsg 0)
				(EgoDead 1 440 1 #title {What were you thinking?}) ; "The Katta cries out in pain, causing the guards to rush in.  They take you to a cell from which you can find no escape."
			)
			((<= (gEgo y:) 136)
				(if (not (& (door signal:) $0080))
					(LeaveCell)
				)
			)
			((& (door signal:) $0080)
				(GoInCell)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/cell,dungeon')
				)
				(HighPrint 440 2) ; "The cell is made from quarried rock, with massive iron bars and a huge gate. Despite the heat outside, it is very cold in here."
			)
			((Said 'give/food')
				(cond
					((IsFlag 94) ; fSharafFriend
						(SkillUsed 14 25) ; honor
						(if (> (gEgo use: 3) 0) ; Food
							(Say shar 440 3) ; "Thank you, for your kindness. Now it's time to think about escaping."
						else
							(Say shar 440 4) ; "Thank you for offering, but it appears you are out of food. But that's not the important issue here, it is time to think about escaping."
						)
					)
					(maybeOk
						(Say shar 440 5) ; "My heart says that you are a friend, yet my mind fears you are a trap. Is there not some token you can show me to prove what you say?"
					)
					(else
						(HighPrint 440 6) ; "The katta just stares suspiciously at you."
						(event claimed: 1)
					)
				)
			)
			((Said 'listen')
				(HighPrint 440 7) ; "You hear the sounds of guards talking just outside the outer door."
			)
			((Said 'look,look/bar')
				(HighPrint 440 8) ; "The bars are made of thick iron. Bending them would be out of the question."
			)
			((Said 'kill/catperson,cousin,friend')
				(EgoDead 1 440 9 #title {Next Time, Try Dale Carnegie}) ; "As you struggle with the astonishingly tough katta, the guards enter and separate you both, taking you to a cell from which you cannot escape."
			)
			((Said 'thank/catperson,cousin,friend')
				(cond
					((not (IsFlag 94)) ; fSharafFriend
						(HighPrint 440 10) ; "The Katta raises his eyebrows in surprise, but then resumes his silent, suspicious stare."
					)
					((TrySkill 14 50) ; honor
						(SayThanks shar 440 11)
					)
					(else
						(HighPrint 440 12) ; "No one responds."
					)
				)
			)
			((Said 'make,give,show/sign[<thief]')
				(MakeSign)
				(HighPrint 440 13) ; "That does not seem to be a sign the Katta recognizes, for he watches you with amusement."
				(if (IsFlag 94) ; fSharafFriend
					(HighPrint 440 14) ; "But he soon resumes his silent stare."
				)
			)
			((Said 'force[/boulder,wall]')
				(if (secretDoor cel:)
					(AlreadyDone)
				else
					(HighPrint 440 15) ; "Which one? There are many here, but none of them appear to be moveable."
				)
			)
			((Said 'stare')
				(Face gEgo shar)
				(RedrawCast)
				(HighPrint 440 16) ; "Nobody can stare down a katta. After several seconds, you become bleary-eyed and turn away."
				(gEgo setHeading: 235)
			)
			((<= (gEgo y:) 136)
				(cond
					(
						(or
							(Said 'use/force,strength')
							(Said
								'force,break,force,open,open,unlock/door,gate'
							)
						)
						(self setScript: gotCaughtS)
					)
					((Said 'search')
						(cond
							((not (secretDoor cel:))
								(self setScript: soloEscapeS)
							)
							((not gotInv)
								(HighPrint 440 17) ; "Your equipment is on the stone table."
							)
							(else
								(HighPrint 440 18) ; "You had better leave quickly. There's no time for a search now."
							)
						)
					)
					(
						(or
							(Said
								'go,crawl,done,done,escape,(bend,get,get<down)'
							)
							(Said 'enter/passage')
						)
						(if (gCast contains: secretDoor)
							(HighPrint 440 19) ; "Good idea, but how? Where?"
						else
							(self setScript: leaveS)
						)
					)
					((Said 'force,move[/boulder,wall]')
						(cond
							((secretDoor cel:)
								(AlreadyDone)
							)
							((and (> (gEgo x:) 103) (< (gEgo y:) 123))
								(HighPrint 440 20) ; "You look around and see a large stone whose mortar has been loosened."
								(soloEscapeS start: 3)
								(self setScript: soloEscapeS)
							)
							(else
								(HighPrint 440 15) ; "Which one? There are many here, but none of them appear to be moveable."
							)
						)
					)
				)
			)
			(
				(or
					(Said 'tell//shapeir,shema,shameen,self,cousin')
					(Said 'ask//catperson,cousin,friend')
				)
				(cond
					((IsFlag 94) ; fSharafFriend
						(HighPrint 440 21) ; "Now that you've made friends and told tales, it's time to think about escaping."
					)
					((TrySkill 13 120) ; communication
						(self setScript: makeFriendS)
					)
					(else
						(= maybeOk 1)
						(Say shar 440 5) ; "My heart says that you are a friend, yet my mind fears you are a trap. Is there not some token you can show me to prove what you say?"
					)
				)
			)
			((or (Said 'show/pin') (Said 'show//pin'))
				(cond
					(showedPin
						(HighPrint 440 22) ; "You've already shown him your pin."
					)
					([gInvNum 27] ; SapphPin
						(= showedPin 1)
						(self setScript: makeFriendS)
					)
					(else
						(DontHave)
					)
				)
			)
			((or (Said 'use/strength') (Said 'force,break,force/door,gate'))
				(if (door cel:)
					(HighPrint 440 23) ; "The cell door is already open."
				else
					(self setScript: pushDoorS)
				)
			)
			((Said 'search')
				(cond
					([gInvNum 27] ; SapphPin
						(if (gCast contains: shar)
							(HighPrint 440 24) ; "You find only the Katta and some straw."
						else
							(HighPrint 440 25) ; "You find nothing but straw."
						)
					)
					([gInvNum 58] ; Nail
						(HighPrint 440 25) ; "You find nothing but straw."
					)
					(else
						(HighPrint 440 26) ; "You find a slightly rusty nail in a crack between the stones of the floor."
						(= [gInvNum 58] 1) ; Nail
					)
				)
			)
			(
				(or
					(Said 'use/pin,nail')
					(Said 'lockpick/lock,door,gate/pin,nail')
				)
				(cond
					((not (or [gInvNum 27] [gInvNum 58])) ; SapphPin, Nail
						(DontHave)
					)
					((door cel:)
						(HighPrint 440 23) ; "The cell door is already open."
					)
					((TrySkill 9 5) ; pick locks
						(HighPrint
							(Format ; "Remembering your Advanced Adventuring lessons, you set to work on the cell door lock, using the %s as a lockpick"
								@str
								440
								27
								(if [gInvNum 27] ; SapphPin
									{pointed end of your sapphire pin}
								else
									{nail you found}
								)
							)
						)
						(self setScript: pickS)
					)
					(else
						(HighPrint 440 28) ; "You don't know how to pick locks."
					)
				)
			)
			((Said 'lockpick/lock,door,gate')
				(if gotInv
					(if (not (door cel:))
						(if (CanPickLocks 1)
							(self setScript: pickS)
						)
					else
						(HighPrint 440 23) ; "The cell door is already open."
					)
				else
					(HighPrint 440 29) ; "You find that the guards took all your tools when they searched you. Your equipment is beyond reach. You'll need to find something else."
				)
			)
			((Said 'climb,climb')
				(if [gEgoStats 11] ; climb
					(HighPrint 440 30) ; "You can climb the bars easily, but that won't help you escape."
				)
			)
			((Said 'bend,break/bar')
				(if (TrySkill 0 150) ; strength
					(HighPrint 440 31) ; "The bars are made of heavy iron and it would take far too long to bend or break them, even with your great strength."
				else
					(HighPrint 440 32) ; "The heavy iron bars don't even budge."
				)
			)
			(
				(or
					(Said 'come,follow,heel')
					(Said 'lockpick//catperson,cousin,friend')
				)
				(if (IsFlag 94) ; fSharafFriend
					(if (door cel:)
						(= maybeOk 1)
						(Say shar 440 33) ; "After you, my friend. I will humbly follow."
					else
						(Say shar 440 34) ; "I would follow you gladly. But first we must escape this cell."
					)
				else
					(HighPrint 440 35) ; "The Katta isn't going anywhere he doesn't want to go."
				)
			)
			((Said 'go,done,done,escape')
				(if (door cel:)
					(HighPrint 440 36) ; "Go ahead. The door's open."
				else
					(HighPrint 440 37) ; "That could be hard to do while locked inside a jail cell."
				)
			)
		)
	)
)

(instance thrownInS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 81 135
					setHeading: 135
					setMotion: MoveTo 90 142 self
				)
				(guard posn: 85 127 setMotion: MoveTo 83 138)
			)
			(1
				(gEgo
					view: 49
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End
					setStep: 1 1
					setMotion: MoveTo 95 147 self
				)
			)
			(2
				(guard setMotion: MoveTo 80 125 self)
			)
			(3
				(guard setMotion: MoveTo 95 106 self)
				(door setCycle: Beg)
			)
			(4
				(outerDoor setCycle: End self)
			)
			(5
				(guard setMotion: MoveTo 102 95 self)
			)
			(6
				(guard setMotion: MoveTo 125 94 self)
			)
			(7
				(gEgo
					setLoop: 1
					posn: 93 148
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(guard dispose:)
				(outerDoor setCycle: Beg)
			)
			(8
				(NormalEgo)
				(gEgo posn: 127 167 loop: 4 setHeading: 135)
				(guard dispose:)
				(door ignoreActors: 0 stopUpd:)
				(= cycles 6)
			)
			(9
				(HighPrint 440 38) ; "After being dragged to the dungeon of the palace, you were roughly searched, beaten, and questioned by the guards. They warned you that Khaveen will be coming soon to personally question you..."
				(= cycles 4)
			)
			(10
				(Print 440 39) ; "...and that you won't enjoy it."
				(outerDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance pushDoorS of HandsOffScript
	(properties)

	(method (changeState newState &tmp strength)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 101 145 self)
				(++ bodySlams)
			)
			(1
				(gEgo
					view: 576
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: CT 4 1 self
				)
			)
			(2
				(if
					(= register
						(or
							(TrySkill 0 150) ; strength
							(and (>= [gEgoStats 0] 130) (== bodySlams 2)) ; strength
							(and
								(== gOrigHeroType 0)
								(== bodySlams 3)
								(not [gEgoStats 9]) ; pick locks
								(not [gEgoStats 12]) ; magic use
							)
						)
					)
					(= cycles 1)
				else
					(gEgo cel: 4 setCycle: End self)
				)
			)
			(3
				(if register
					(gEgo
						setLoop: 4
						cel: 0
						setStep: 2 2
						setMotion: MoveTo 120 123
					)
					(door setCycle: End)
				else
					(gEgo
						setLoop: 2
						cel: 1
						setStep: 3 3
						setMotion: MoveTo 93 152
					)
				)
				(gEgo view: 6 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(if register
					(gEgo setLoop: 5)
				else
					(gEgo setLoop: 3)
				)
				(gEgo cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(5
				(NormalEgo)
				(= cycles 5)
			)
			(6
				(cond
					(register
						(cond
							(didDoorMsg
								(self cue:)
							)
							((not (IsFlag 94)) ; fSharafFriend
								(HighPrint 440 40) ; "The katta watches you calmly with a mixture of interest and suspicion."
								(self cue:)
							)
							(else
								(Say shar self 440 41) ; "I have heard from others in the Underground that there is a concealed passage in the room outside this cell."
							)
						)
						(= didDoorMsg 1)
					)
					(
						(and
							(== gOrigHeroType 0)
							(not [gEgoStats 9]) ; pick locks
							(not [gEgoStats 12]) ; magic use
						)
						(switch bodySlams
							(1
								(HighPrint 440 42) ; "Looks as though you could have used more body-building practice. You'll just have to try again."
								(self cue:)
							)
							(2
								(HighPrint 440 43) ; "Looks like you should have eaten your Wheeties this morning. You did feel the door give a little when you hit it this time."
								(self cue:)
							)
						)
					)
					((or [gEgoStats 9] [gEgoStats 12]) ; pick locks, magic use
						(HighPrint 440 44) ; "You don't seem to be strong enough to force the door. You'll have to try something else."
						(self cue:)
					)
					(else
						(self cue:)
					)
				)
			)
			(7
				(if register
					(gEgo loop: 4 setHeading: 135)
				else
					(gEgo loop: 3 setHeading: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance pickS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 78 140 self)
			)
			(1
				(gEgo view: 47 setLoop: 4 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(gMiscSound number: 20 priority: 10 loop: 0 play:)
				(door cycleSpeed: 4 setScript: openDoorS self)
			)
			(3
				(gEgo cel: 3 setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance makeFriendS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= maybeOk 1)
				(sharaf hide:)
				(if (< (gEgo x:) 230)
					(gEgo setMotion: MoveTo 222 152 self)
				else
					(= cycles 3)
				)
			)
			(1
				(Face gEgo sharaf)
				(= cycles 4)
			)
			(2
				(shar setCycle: End self)
			)
			(3
				(shar stopUpd:)
				(RedrawCast)
				(SolvePuzzle 631 7)
				(sharaf posn: 248 124)
				(if showedPin
					(Say shar self 440 45 440 46) ; "A pin like that can only be seen by a friend, such is its magic. It is Katta magic. You must be very trusted by my people to gain such a thing."
				else
					(Say shar self 440 47) ; "Ah, then you are indeed a friend in a place where we both need friends. We need to escape from this prison."
				)
			)
			(4
				(SetFlag 94) ; fSharafFriend
				(self dispose:)
			)
		)
	)
)

(instance openDoorS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door startUpd: setCycle: End self)
			)
			(1
				(door stopUpd: ignoreActors:)
				(if (not didDoorMsg)
					(= cycles 16)
				else
					(self dispose:)
				)
			)
			(2
				(if (not (IsFlag 94)) ; fSharafFriend
					(HighPrint 440 40) ; "The katta watches you calmly with a mixture of interest and suspicion."
					(self dispose:)
				else
					(Say shar self 440 41) ; "I have heard from others in the Underground that there is a concealed passage in the room outside this cell."
				)
				(= didDoorMsg 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance closeDoorS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door startUpd: ignoreActors: 0 setCycle: Beg self)
			)
			(1
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance gotCaughtS of HandsOffScript
	(properties)

	(method (changeState newState &tmp tempVar moveX angleToDoor)
		(switch (= state newState)
			(0
				(if
					(and
						(<= (Abs (= tempVar (- (gEgo x:) 80))) 26)
						(< (gEgo y:) 136)
					)
					(= moveX (if (< tempVar 0) 54 else 106))
					(gEgo view: 0 setCycle: StopWalk 4)
					(if (< (gEgo y:) 112)
						(gEgo setMotion: DPath 80 112 56 120 self)
					else
						(gEgo setMotion: MoveTo moveX (gEgo y:) self)
					)
				else
					(self cue:)
				)
			)
			(1
				(= angleToDoor (GetAngle (gEgo x:) (gEgo y:) 42 136))
				(gEgo setHeading: angleToDoor)
				(outerDoor setCycle: End self)
			)
			(2
				(guard
					init:
					setCycle: Walk
					posn: 125 94
					setMotion: MoveTo 102 95 self
				)
			)
			(3
				(guard setMotion: MoveTo 95 106 self)
				(outerDoor setCycle: Beg)
			)
			(4
				(guard setMotion: MoveTo 80 125 self)
			)
			(5
				(Face gEgo guard 1 self)
			)
			(6
				(EgoDead 1 440 48 #title {In Guarded Condition}) ; "The guards come in and take you to a cell you can't escape from."
			)
		)
	)
)

(instance soloEscapeS of HandsOffScript
	(properties)

	(method (dispose)
		(NormalEgo)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 66 121 self)
			)
			(1
				(gEgo setMotion: MoveTo 30 129 self)
			)
			(2
				(gEgo setMotion: MoveTo 172 121 self)
			)
			(3
				(gEgo setMotion: MoveTo 120 117 self)
			)
			(4
				(gEgo
					posn: 112 117
					view: 47
					cel: 0
					setLoop: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(5
				(HighPrint 440 49) ; "You find a secret panel on the back wall."
				(gEgo
					view: 445
					setLoop: 9
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(6
				(secretDoor cycleSpeed: 3 setCycle: End self)
			)
			(7
				(secretDoor dispose:)
				(gEgo view: 47 setLoop: 0 cel: 3)
				(HighPrint 440 50) ; "The stone slides back to reveal a hidden passageway."
				(if (not gotInv)
					(HighPrint 440 51) ; "Before you escape, perhaps you should get your equipment."
				)
				(= cycles 8)
			)
			(8
				(if gotInv
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 2)
					(Print 440 52) ; "You find yourself crawling through a twisty passage for what seems like forever. When it comes to a dead end, you force open another panel and find yourself in the streets of Raseir."
					(SolvePuzzle 630 7)
					(= gDay 29)
					(FixTime 17 0)
					(= gRoomExitDir 1)
					(gCurRoom newRoom: 703) ; alleyRas
				else
					(gEgo cel: 3 cycleSpeed: 1 setCycle: Beg self)
				)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance dualEscapeS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 93 121)
				(shar
					setPri: -1
					posn: 136 152
					setLoop: 1
					setCycle: Fwd
					setStep: 4 3
					setMotion: MoveTo 44 142 self
				)
				(sharaf posn: -10 -10)
			)
			(1
				(gEgo setMotion: 0)
				(Face gEgo shar)
				(shar setLoop: 4 setMotion: MoveTo 142 120 self)
			)
			(2
				(shar setCycle: 0 cel: 1)
				(if (secretDoor cel:)
					(Say shar self 440 53) ; "Thanks to your great strength, we can leave immediately."
				else
					(Say shar self 440 54) ; "The entrance to the passageway should be here....."
				)
			)
			(3
				(= cycles 8)
			)
			(4
				(sharaf setPri: 14)
				(gEgo setMotion: MoveTo 112 117)
				(if (secretDoor cel:)
					(Say shar self 440 55) ; "I have helped others escape through the secret passageways."
				else
					(Say shar self 440 56) ; "Yes, it is here. Lend your strong shoulder to the task."
				)
			)
			(5
				(if (secretDoor cel:)
					(self state: 7)
				else
					(gEgo
						posn: 112 117
						view: 47
						cel: 0
						setLoop: 0
						cycleSpeed: 1
						setCycle: End
					)
				)
				(shar view: 445 setLoop: 5 cel: 0 setCycle: End self)
			)
			(6
				(gEgo
					view: 445
					setLoop: 9
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
				(shar setLoop: 8 cel: 0 cycleSpeed: 3 setCycle: End)
			)
			(7
				(secretDoor cycleSpeed: 3 setCycle: End self)
			)
			(8
				(secretDoor dispose:)
				(gEgo view: 47 setLoop: 0 cel: 3)
				(sharaf posn: 158 104)
				(= cycles 1)
			)
			(9
				(if (not gotInv)
					(Say shar self 440 57 440 58 440 59) ; "Do not fear. I will lead you to safety through the passageways, Katta-friend."
				else
					(Say shar self 440 57) ; "Do not fear. I will lead you to safety through the passageways, Katta-friend."
				)
			)
			(10
				(shar
					setPri: 4
					setLoop: 6
					posn: 162 111
					cycleSpeed: 0
					setStep: 2 1
					setCycle: Fwd
					setMotion: MoveTo 193 108 self
				)
			)
			(11
				(shar dispose:)
				(sharaf dispose:)
				(= guardTimer 450)
				(if gotInv
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 2)
					(Print 440 60) ; "The katta leads you through dark passages under the Palace to a secret exit into the Raseir streets. Sharaf warns you that tomorrow night the Underground plans to attack the Palace and overthrow the Emir."
					(Print 440 61) ; "He shows you the passage that leads back towards the Blue Parrot Inn and reminds you to be wary of guards. Then he bids you good luck and scurries off."
					(SolvePuzzle 630 7)
					(= gDay 29)
					(FixTime 17 0)
					(= gRoomExitDir 1)
					(gCurRoom newRoom: 703) ; alleyRas
				else
					(gEgo cel: 3 cycleSpeed: 1 setCycle: Beg self)
				)
			)
			(12
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance leaveS of HandsOffScript
	(properties)

	(method (changeState newState &tmp tst)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 112 120 self)
			)
			(1
				(gEgo view: 47 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(= tst (IsFlag 94)) ; fSharafFriend
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(if (not gotInv)
					(if tst
						(EgoDead 1 440 62 #title {Forget something?}) ; "You and Sharaf wander the passages beneath the Palace. Without your equipment, you both perish in the darkness."
					else
						(EgoDead 1 440 63 #title {Forget something?}) ; "You wander the passages beneath the Palace. Without your equipment, you perish in the darkness."
					)
				else
					(if tst
						(Print 440 60) ; "The katta leads you through dark passages under the Palace to a secret exit into the Raseir streets. Sharaf warns you that tomorrow night the Underground plans to attack the Palace and overthrow the Emir."
						(Print 440 61) ; "He shows you the passage that leads back towards the Blue Parrot Inn and reminds you to be wary of guards. Then he bids you good luck and scurries off."
					else
						(Print 440 64) ; "You find yourself crawling through a twisting passage for what seems like forever. When it comes to a dead end, you force open another panel and find yourself in the streets of Raseir."
					)
					(SolvePuzzle 630 7)
					(= gDay 29)
					(FixTime 17 0)
					(= gRoomExitDir 1)
					(gCurRoom newRoom: 703) ; alleyRas
				)
			)
		)
	)
)

(instance getStuffS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 172 126 self)
			)
			(1
				(gEgo setMotion: MoveTo 186 130 self)
			)
			(2
				(ReplaceInvItems)
				(equipment hide:)
				(HighPrint 440 65) ; "You recover all of your equipment."
				(gEgo setMotion: MoveTo 168 126 self)
			)
			(3
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance straw of View
	(properties
		x 249
		y 153
		noun '/hay'
		description {straw}
		view 440
	)
)

(instance guard of Actor
	(properties
		noun '/guard,man'
		description {the guard}
		lookStr {The guards of Raseir sure are less friendly to tourists.}
		view 382
		signal 16384
		illegalBits 0
	)
)

(instance secretDoor of TargActor
	(properties
		x 145
		y 114
		noun '/wall,passage,boulder'
		description {the wall}
		lookStr {The wall looks solid enough.}
		view 440
		loop 1
		priority 8
		signal 2064
		illegalBits 0
	)

	(method (openMe)
		(HighPrint 440 66) ; "The rock is much too heavy for your spell to effect it."
		(return 0)
	)

	(method (fetchMe)
		(HighPrint 440 66) ; "The rock is much too heavy for your spell to effect it."
		(return 0)
	)

	(method (hurtMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 2 1 5)
			(cond
				((secretDoor cel:)
					(AlreadyDone)
				)
				((not (<= (gEgo y:) 136))
					(HighPrint 440 67) ; "The walls in the cell are solid, mortered stone."
				)
				((and (> (gEgo x:) 103) (< (gEgo y:) 123))
					(HighPrint 440 20) ; "You look around and see a large stone whose mortar has been loosened."
					(soloEscapeS start: 3)
					(self setScript: soloEscapeS)
				)
				(else
					(HighPrint 440 68) ; "Which one? There are many here."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance equipment of TargActor
	(properties
		x 209
		y 100
		noun '/equipment,belonging,stuff,clothes,item'
		description {your equipment}
		lookStr {Your equipment has been carefully searched and neatly laid out on the table, awaiting Khaveen's inspection.}
		view 440
		cel 1
		priority 8
		signal 16400
		illegalBits 0
	)

	(method (fetchMe)
		(ReplaceInvItems)
		(self setLoop: 0 setCel: 1)
		(return 1)
	)

	(method (hurtMe amount whatHurt)
		(if (== (whatHurt type:) 25)
			(HighPrint 440 69) ; "Your belongings go up in a puff of smoke."
			(self dispose:)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(cond
				(gotInv
					(HighPrint 440 70) ; "You already have your equipment."
				)
				((not (<= (gEgo y:) 136))
					(HighPrint 440 71) ; "That is difficult to accomplish from inside the cell."
				)
				((< (gEgo y:) 113)
					(HighPrint 440 72) ; "You can't get to your equipment from where you are."
				)
				(else
					(self setScript: getStuffS)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance door of TargActor
	(properties
		x 42
		y 136
		noun '/door,gate[<cell,iron]'
		description {the gate to the cell}
		lookStr {The gate is made of the same iron bars as the rest of the cell.__The lock is a simple key mounting.}
		view 445
		cel 2
		signal 16384
		illegalBits 0
	)

	(method (openMe)
		(if cel
			(HighPrint 440 73) ; "The cell's door is already open."
			(return 0)
		else
			(self setScript: openDoorS)
			(return 1)
		)
	)

	(method (fetchMe)
		(if cel
			(self setScript: closeDoorS)
		else
			(HighPrint 440 74) ; "The cell's door is already closed."
		)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if cel
					(HighPrint 440 75) ; "Why? You're trying to escape, remember?"
				else
					(HighPrint 440 74) ; "The cell's door is already closed."
				)
			)
			(2
				(if cel
					(outerDoor openMe:)
				else
					(HighPrint 440 76) ; "That's a very good idea. But how?"
				)
			)
			(1
				(HighPrint lookStr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sharaf of Prop
	(properties
		x 248
		y 133
		view 445
		loop 3
		cel 1
		priority 11
		signal 16
	)
)

(instance shar of Talker
	(properties
		x 250
		y 151
		description {Sharaf}
		lookStr {The katta is thin, and looks as if he has been recently beaten.}
		yStep 3
		view 445
		loop 2
		priority 10
		signal 16400
		illegalBits 0
		xStep 4
		tLoop -1
		talkSpeed 1
		myName '//cousin,catperson,friend'
		title {Sharaf:}
		color 1
		back 7
		msgFile 445
	)

	(method (onMe)
		(return (or (super onMe: &rest) (sharaf onMe: &rest)))
	)

	(method (hurtMe)
		(sharaf show: setCel: 2)
		(= spellMsg 1)
	)

	(method (atSpec which)
		(return [sharafSpecList which])
	)

	(method (atGen which)
		(return [sharafGenList which])
	)

	(method (messages)
		(cond
			(
				(and
					(IsFlag 94) ; fSharafFriend
					(door cel:)
					didDoorMsg
					(not (<= (gEgo y:) 136))
					(not maybeOk)
				)
				(sharaf show: setCycle: Fwd)
				(switch (Random 1 3)
					(1
						(super
							messages:
								{I would tell you all you wish to know.___But now it is time to depart... in great haste!}
						)
					)
					(2
						(super
							messages:
								{Truly, you have many questions I might answer, but the guards will soon return.__We must leave this most dangerous place.}
						)
					)
					(else
						(super
							messages:
								{I will answer all later.__But now that you have so skillfully opened the door, we should leave.}
						)
					)
				)
			)
			((or (IsFlag 94) maybeOk) ; fSharafFriend
				(= maybeOk 0)
				(sharaf show: setCycle: Fwd)
				(super messages: &rest)
			)
			(else
				(HighPrint 440 6) ; "The katta just stares suspiciously at you."
			)
		)
	)

	(method (endTalk)
		(super endTalk: &rest)
		(sharaf setCycle: 0 hide:)
	)
)

(instance outerDoor of TargActor
	(properties
		x 94
		y 102
		noun '/door<wooden'
		description {the heavy wooden door}
		lookStr {The heavy wooden door leads to the hallway.__You can hear the sound of many boots marching and several guards talking.}
		view 445
		loop 10
		priority 2
		signal 16
	)

	(method (openMe)
		(gCurRoom setScript: gotCaughtS)
		(return 1)
	)

	(method (hurtMe)
		(HighPrint 440 77) ; "Your spell has attracted the attention of the guards."
		(gCurRoom setScript: gotCaughtS)
		(return 1)
	)
)

(instance win of Feature
	(properties
		x 274
		y 151
		z 68
		noun '/window'
		nsTop 65
		nsLeft 258
		nsBottom 102
		nsRight 291
		description {the barred window}
		lookStr {The bars on the window are heavy iron, and are set in stone.}
	)
)

(instance table of Feature
	(properties
		x 206
		y 111
		noun '/table'
		nsTop 96
		nsLeft 186
		nsBottom 126
		nsRight 227
		description {the stone table}
		lookStr {It is a stone table.}
	)
)

(instance wall of Feature
	(properties
		x 213
		y 125
		z 55
		noun '/wall'
		nsTop 44
		nsLeft 199
		nsBottom 97
		nsRight 227
		description {the stone wall}
		lookStr {The stone wall is just that.}
	)
)

(instance inlets of Feature
	(properties
		x 275
		y 150
		z 102
		noun '/duct,duct'
		nsTop 40
		nsLeft 260
		nsBottom 56
		nsRight 291
		description {the ventilation ducts}
		lookStr {The ventilation ducts are heavily reinforced.}
	)
)

(instance theSpellChecker of Code
	(properties)

	(method (doit theSpell)
		(if (OneOf theSpell 28 6)
			(HighPrint 440 78) ; "That wouldn't do you any good here."
			(return 0)
		else
			(return 1)
		)
	)
)

