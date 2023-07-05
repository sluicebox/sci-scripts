;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use n065)
(use TargActor)
(use n095)
(use Interface)
(use PolyPath)
(use Feature)
(use LoadMany)
(use Rev)
(use Chase)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm470 0
	youBlewIt 1
)

(local
	egoJumped
	egoClimbed
	callGuards
	saidCastInCombat
	down
	crashJump
	djinniSearchMsg
	warningMessage
	warningMsgTimer
)

(procedure (AlreadyOpen)
	(djinniPrint 470 0) ; "But Master, the door to the ritual chamber is already open!"
)

(procedure (GoToTheStairs)
	(djinniPrint 470 1 470 2) ; "Now through the door at the top of the stairs is Iblis. There is some sort of spell on the door, but I don't know what it is. There is an awful lot of magic around here."
)

(procedure (ResetWarning)
	(= warningMsgTimer
		(switch gArcadeLevel
			(1 120)
			(2 100)
			(3 80)
		)
	)
	(= warningMessage 0)
)

(procedure (KhaveenPrint)
	(LowPrint &rest 35 khaveenWindow 80 {Khaveen:})
)

(procedure (OpenDoor)
	(if (lDoor cel:)
		(AlreadyOpen)
	else
		(if (not (gCast contains: doorTrap))
			(doorTrap init: setCycle: End)
		)
		(rDoor ignoreActors: 1 setCycle: End)
		(lDoor ignoreActors: 1 setCycle: End)
	)
)

(procedure (TriggerDoor)
	(if (not (gCast contains: doorTrap))
		(doorTrap init: setCycle: End)
	)
)

(instance khaveenWindow of BotWindow
	(properties
		color 7
		back 0
	)
)

(instance rm470 of Rm
	(properties
		picture 2
		style 3
	)

	(method (init)
		(Load rsPIC 470)
		(LoadMany rsVIEW 472 473 474 382 383 465 6 31 591 576 22 475 80 83)
		(LoadMany rsSCRIPT 475 62 30 31 32 969 972)
		(SolvePuzzle 666 5 0)
		(= gSpellChecker gAllChecker)
		(super init:)
		(= global76 1)
		(gCSound number: 470 loop: -1 priority: 0 playBed:)
		(djinniPrint 470 3) ; "Hurry, Master! You must follow me."
		(Print 470 4 #width 250) ; "You race through the palace passageways, pausing now and again to evade scurrying guards. The Djinni of the Ring, for all of his forgetful nature, seems to have a clear idea of where he's taking you."
		(djinniPrint 470 5) ; "Through here, Master! Iblis is close, and time is short."
		(gCurRoom drawPic: 470)
		(gEgo posn: 0 40 init:)
		(lDoor init:)
		(rDoor init:)
		(aGuard init:)
		(khaveenTalker init:)
		(InitAddToPics rope)
		(InitFeatures curtain balcony lowerDoor curtain2 stairs dais)
		(self setScript: enterBalcony)
	)

	(method (notify which)
		(switch which
			(59
				(djinniPrint 470 6) ; "No, Master, you can't! We have to get to Iblis!"
			)
			(58
				(SetFlag 141)
				(SolvePuzzle 665 15 0)
				(ResetWarning)
			)
			(999
				(= saidCastInCombat 1)
				(= callGuards 1)
			)
		)
		(return 0)
	)

	(method (doit)
		(cond
			((and (lDoor cel:) (& (gEgo onControl: 1) $0010))
				(gCurRoom newRoom: 500)
			)
			(
				(and
					(not (and (< (gEgo x:) 50) (< (gEgo y:) 80)))
					(not (gEgo script:))
					(not script)
					(not down)
				)
				(= down 1)
				(if (gCast contains: khaveenTalker)
					(= warningMsgTimer 0)
					(khaveenTalker setScript: 0 setMotion: 0)
					(Face khaveenTalker gEgo)
					(if (and (not egoClimbed) (not egoJumped))
						(gEgo setHeading: 45)
					)
					(if (not (gEgo has: 7)) ; Shield
						(= callGuards 1)
					)
					(self setScript: startFight)
				else
					(if (and egoJumped (> (gEgo x:) 50))
						(gEgo setLoop: -1 setHeading: 45)
					)
					(GoToTheStairs)
				)
			)
			((not warningMsgTimer))
			((-- warningMsgTimer))
			((and (not script) (not (gEgo script:)))
				(switch warningMessage
					(0
						(djinniPrint 470 7) ; "Please, we've got to do something. Hurry!"
						(++ warningMessage)
						(= warningMsgTimer
							(switch gArcadeLevel
								(1 120)
								(2 100)
								(3 80)
							)
						)
					)
					(1
						(djinniPrint 470 8) ; "Master! Iblis is about to be summoned! Don't just stand there, DO something!"
						(++ warningMessage)
						(= warningMsgTimer 80)
					)
					(2
						(gEgo setScript: youBlewIt)
					)
				)
			)
			(else
				(= warningMsgTimer
					(switch gArcadeLevel
						(1 120)
						(2 100)
						(3 80)
					)
				)
			)
		)
		(if
			(and
				(or
					(& (gEgo onControl: 1) $0008)
					(& (gEgo onControl: 1) $0020)
					(& (gEgo onControl: 1) $0040)
					(& (gEgo onControl: 1) $0100)
					(& (gEgo onControl: 1) $0080)
				)
				(not script)
				(not (gEgo script:))
			)
			(gEgo setScript: wrongWay)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp index)
		(cond
			((super handleEvent: event))
			(script 0)
			((Said 'sneak')
				(if (and (< (gEgo x:) 50) (< (gEgo y:) 80))
					(HighPrint 470 9) ; "Sneak around the balcony? If you were down there, you might try sneaking."
				else
					(event claimed: 0)
				)
			)
			((Said 'run')
				(if (and (< (gEgo x:) 50) (< (gEgo y:) 80))
					(HighPrint 470 10) ; "Run around the balcony? If you were down there, you might try running."
				else
					(event claimed: 0)
				)
			)
			((Said 'search,strip/body,khaveen,captain,man')
				(if (IsFlag 141)
					(if (not djinniSearchMsg)
						(djinniPrint 470 11) ; "There is no time, Master. Iblis will be free!"
						(= djinniSearchMsg 1)
					else
						(self setScript: searchBody)
					)
				else
					(HighPrint 470 12) ; "While he's alive? Not likely."
				)
			)
			((Said 'break,force/door')
				(if
					(or
						(< (gEgo distanceTo: lDoor) 40)
						(< (gEgo distanceTo: rDoor) 40)
					)
					(cond
						((lDoor cel:)
							(AlreadyOpen)
						)
						((gCast contains: doorTrap)
							(gEgo setScript: bustDoor)
						)
						(else
							(gEgo setScript: blowDoor)
						)
					)
				else
					(djinniPrint 470 13) ; "I fear you cannot reach the door handles from where you are standing."
				)
			)
			((Said 'get,get/blade,shield,weapon')
				(djinniPrint 470 14) ; "No, Master. You must hurry through the door at the top of the stairs, or Ad Avis will release Iblis!"
			)
			((and (< (gEgo x:) 50) (< (gEgo y:) 80))
				(cond
					((Said 'search,look,look[<at,around][/room,area][/!*]')
						(HighPrint 470 15) ; "The dais and the balcony attest to the fact that this room is used for ceremony and special occasions. For you now, it is simply one more step along the path to the defeat of Ad Avis."
					)
					((Said 'ask,yell,talk,talk')
						(if (gCast contains: khaveenTalker)
							(gEgo setScript: youBlewIt)
						else
							(HighPrint 470 16) ; "No reply."
						)
					)
					((or (Said 'hop') (Said 'get,get<down'))
						(= egoJumped 1)
						(gEgo setScript: jumpDown)
					)
					((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
						(HighPrint 470 17) ; "Why, there's a perfectly good rope, right here next to the balcony."
						(gEgo setScript: climbDown)
						(= egoClimbed 1)
					)
					(
						(or
							(Said
								'get,get,grab,(slide,climb,climb<down)/rope,curtain'
							)
							(Said 'get,get,climb,climb<down[/!*]')
							(Said 'climb,climb[<down][/!*]')
						)
						(gEgo setScript: climbDown)
						(= egoClimbed 1)
					)
					((Said 'cast>')
						(if (== (SaidSpell event) 28)
							(if (TrySpell 28)
								(gEgo setScript: levDown)
							else
								(event claimed: 1)
							)
						else
							(event claimed: 0)
							(if (gCast contains: khaveenTalker)
								(= index (SaidSpell event))
								(self setScript: whatEgoDid 0 index)
							)
						)
					)
					((Said 'throw/dagger,boulder')
						(if (gCast contains: khaveenTalker)
							(self setScript: throwDelay)
						)
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance balcony of Feature
	(properties
		x 32
		y 60
		noun '/balcony'
		nsTop 40
		nsBottom 80
		nsRight 65
		description {the balcony}
		lookStr {The balcony overlooks the antechamber to Ad Avis' ritual chamber.}
	)
)

(instance lowerDoor of Feature
	(properties
		x 109
		y 73
		noun '/door'
		nsTop 48
		nsLeft 94
		nsBottom 98
		nsRight 125
		description {the door to the guards' quarters}
		lookStr {This door leads out to the passageways of the Palace.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(if
				(or
					(< (gEgo distanceTo: lDoor) 40)
					(< (gEgo distanceTo: rDoor) 40)
				)
				(cond
					((lDoor cel:)
						(AlreadyOpen)
					)
					((gCast contains: doorTrap)
						(HighPrint 470 18) ; "You find that the door is locked. It won't open that easily."
					)
					(else
						(gEgo setScript: blowDoor)
					)
				)
			else
				(djinniPrint 470 13) ; "I fear you cannot reach the door handles from where you are standing."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance curtain of Feature
	(properties
		x 14
		y 84
		noun '/curtain,curtain'
		nsTop -1
		nsBottom 169
		nsRight 29
		description {the curtain}
		lookStr {These red drapes match the ones on the other side of the room.}
	)
)

(instance curtain2 of Feature
	(properties
		x 290
		y 25
		noun '/curtain,curtain'
		nsLeft 261
		nsBottom 50
		nsRight 319
		description {the curtains}
		lookStr {These red drapes match the ones on the other side of the room.}
	)
)

(instance stairs of Feature
	(properties
		x 229
		y 73
		noun '/ladder'
		nsTop 55
		nsLeft 148
		nsBottom 91
		nsRight 310
		description {the stairs}
		lookStr {The stairs are not as important as the chamber beyond the top of the stairs.}
	)
)

(instance dais of Feature
	(properties
		x 213
		y 115
		noun '/platform,dais,circle,pizza,simulacrum,(elemental<pizza)'
		nsTop 94
		nsLeft 107
		nsBottom 137
		nsRight 319
		description {the pizza elemental}
		lookStr {Is it...?\nIt is!  It's a simulacrum of the Pizza Elemental!!}
	)
)

(instance doorTrap of Prop
	(properties
		x 195
		y 40
		view 472
		loop 5
		priority 2
		signal 16400
	)
)

(instance lDoor of TargActor
	(properties
		x 178
		y 55
		noun '/door'
		description {the door to Ad Avis' ritual chamber}
		lookStr {It is the door to Ad Avis' ritual chamber.}
		view 472
		priority 1
		signal 16
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(if
				(or
					(< (gEgo distanceTo: lDoor) 40)
					(< (gEgo distanceTo: rDoor) 40)
				)
				(cond
					(cel
						(AlreadyOpen)
					)
					((gCast contains: doorTrap)
						(HighPrint 470 18) ; "You find that the door is locked. It won't open that easily."
					)
					(else
						(gEgo setScript: blowDoor)
					)
				)
			else
				(djinniPrint 470 13) ; "I fear you cannot reach the door handles from where you are standing."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (hurtMe)
		(TriggerDoor)
		(return 1)
	)

	(method (openMe)
		(OpenDoor)
		(return 1)
	)

	(method (triggerMe)
		(TriggerDoor)
		(return 1)
	)

	(method (detectMe)
		(HighPrint 470 19) ; "There is incredibly powerful magic going on in the room beyond the door at the top of the stairs."
		(return 1)
	)
)

(instance rDoor of TargActor
	(properties
		x 214
		y 55
		noun '/door'
		description {the door to Ad Avis' ritual chamber}
		lookStr {It is the door to Ad Avis' ritual chamber.}
		view 472
		loop 1
		priority 1
		signal 16
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(if
				(or
					(< (gEgo distanceTo: lDoor) 40)
					(< (gEgo distanceTo: rDoor) 40)
				)
				(cond
					(cel
						(AlreadyOpen)
					)
					((gCast contains: doorTrap)
						(HighPrint 470 18) ; "You find that the door is locked. It won't open that easily."
					)
					(else
						(gEgo setScript: blowDoor)
					)
				)
			else
				(djinniPrint 470 13) ; "I fear you cannot reach the door handles from where you are standing."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (hurtMe)
		(TriggerDoor)
		(return 1)
	)

	(method (openMe)
		(OpenDoor)
		(return 1)
	)

	(method (triggerMe)
		(TriggerDoor)
		(return 1)
	)
)

(instance rope of PicView
	(properties
		x 10
		y 142
		noun '/rope'
		description {the rope}
		lookStr {It is the rope that ties the curtains together.}
		view 472
		loop 2
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 7) (== theVerb 8))
			(if (and (< (gEgo x:) 50) (< (gEgo y:) 80))
				(gEgo setScript: climbDown)
				(= egoClimbed 1)
			else
				(HighPrint 470 20) ; "You don't need the rope for anything now."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance aGuard of Actor
	(properties
		x 112
		y 98
		noun '/guard,guard,lieutenant'
		description {Khaveen's lieutenant}
		lookStr {It is the Captain of the Raseirian Guards.}
		view 383
		loop 5
		priority 3
		signal 16
		illegalBits 0
	)
)

(instance nextGuard of Actor
	(properties
		x 27
		y 246
		noun '/guard,guard'
		description {one of Khaveen's personal guards}
		lookStr {It is one of Khaveen's personal guards.}
		view 382
		illegalBits 0
	)
)

(instance lastGuard of Actor
	(properties
		x 340
		y 165
		noun '/guard,guard'
		description {one of Khaveen's personal guards}
		lookStr {It is one of Khaveen's personal guards.}
		view 382
		illegalBits 0
	)
)

(instance khaveenTalker of Talker
	(properties
		x 140
		y 110
		description {Khaveen}
		lookStr {It is Khaveen.}
		view 465
		loop 8
		tLoop -1
		myName '//khaveen,guard,man,captain'
		title {Khaveen:}
		color 7
		back 0
	)

	(method (init)
		(super init:)
		(self setLoop: Grooper)
		(= tWindow khaveenWindow)
	)

	(method (calmMe)
		(HighPrint 470 21) ; "Khaveen visibly relaxes and appears to lose track of his train of thought. For a moment, he seems not to know what to do."
		(self setScript: 0 setCycle: Walk illegalBits: 0)
	)

	(method (openMe)
		(HighPrint 470 22) ; "It's really hard to get Khaveen to open up."
		(return 1)
	)

	(method (hurtMe)
		(return 1)
	)
)

(instance enterBalcony of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(EgoGait 0 0) ; walking
				(gEgo setMotion: MoveTo 40 72 self)
			)
			(1
				(gEgo setHeading: 45)
				(= cycles 8)
			)
			(2
				(djinniPrint 470 23) ; "There, Master. Through that door over there is the ritual chamber where Iblis is being summoned. Let's go!"
				(self cue:)
			)
			(3
				(Say khaveenTalker self 470 24 470 25) ; "The people of the city are revolting, and Ad Avis has to choose this time of all times to do some sort of magical ceremony. I am ordered to guard this door when I should be out leading the troops. A pox upon the head of all magicians."
			)
			(4
				(HighPrint 470 26) ; "To hear is to obey, Sir."
				(aGuard view: 382 setLoop: Grooper setHeading: 315 self)
			)
			(5
				(aGuard setCycle: Walk setMotion: MoveTo 85 90 self)
			)
			(6
				(aGuard dispose:)
				(djinniPrint 470 27) ; "Well, what are you waiting for? We need to get to that door."
				(ResetWarning)
				(khaveenTalker setScript: paceAround)
				(self dispose:)
			)
		)
	)
)

(instance callTheGuards of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(gCurRoom setScript: youBlewIt)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if saidCastInCombat
					(KhaveenPrint 470 28) ; "So! I will not fight your petty magic!"
				else
					(KhaveenPrint 470 29) ; "So! The would-be hero who thinks he can fight. You're not worth my time and effort."
				)
				(KhaveenPrint 470 30) ; "Guards! To me! Guards!"
				(self cue:)
			)
			(1
				(aGuard init: setCycle: Walk setMotion: MoveTo 107 99 self)
				(nextGuard init: setCycle: Walk setMotion: MoveTo 75 175)
				(lastGuard init: setCycle: Walk setMotion: MoveTo 268 165)
			)
			(2
				(aGuard setMotion: MoveTo 107 120 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance youBlewIt of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(gCast contains: khaveenTalker)
						(or (gEgo has: 7) (not down)) ; Shield
					)
					(self cue:)
				else
					(self changeState: 7)
				)
			)
			(1
				(gEgo setMotion: MoveTo 40 72)
				(if (khaveenTalker script:)
					(khaveenTalker setScript: 0 setMotion: 0)
				)
				(Face khaveenTalker gEgo)
				(= cycles 5)
			)
			(2
				(khaveenTalker view: 475 setLoop: 0 setCel: 0)
				(= cycles 4)
			)
			(3
				(Say khaveenTalker self 470 31) ; "Guards! The balcony! Guards!!!"
			)
			(4
				(djinniPrint 470 32) ; "That's blown it! We'd better run for it."
				(self cue:)
			)
			(5
				(gEgo setLoop: 4 setMotion: MoveTo 25 50 self)
			)
			(6
				(aGuard
					x: 0
					y: 40
					init:
					setCycle: Walk
					setMotion: Chase gEgo 15 self
				)
				(gEgo setLoop: 7 setMotion: MoveTo 40 70)
				(khaveenTalker
					view: 465
					setLoop: -1
					setCycle: Walk
					setMotion:
						MoveTo
						(- (khaveenTalker x:) 30)
						(khaveenTalker y:)
				)
			)
			(7
				(if (gCast contains: khaveenTalker)
					(LowPrint 470 33) ; "As the guards haul you off for torture and questioning, the Djinni of the Ring starts to scream:"
				else
					(LowPrint 470 34) ; "Suddenly, the Djinni of the Ring starts to scream:"
				)
				(djinniPrint 470 35) ; "No! He's loose!! Iblis is free!"
				(ShakeScreen 15)
				(= cycles 5)
			)
			(8
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(= cycles 2)
			)
			(9
				(LowPrint 470 36 80 {Whatever you did, it didn't work!}) ; "The walls around you start to shake and crumble. You have a funny feeling that you should have done something differently."
				(gCurRoom newRoom: 790)
			)
		)
	)
)

(instance climbDown of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 41 72 self)
			)
			(1
				(gEgo view: 472 setPri: 15 setLoop: 3 cel: 0 posn: 24 50)
				(= cycles 4)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					view: 6
					x: 14
					y: 65
					setLoop: 0
					cel: 1
					xStep: 0
					yStep: 5
					setCycle: Rev
					setMotion: MoveTo 14 135 self
				)
			)
			(4
				(gEgo
					x: (+ (gEgo x:) 8)
					y: (+ (gEgo y:) 38)
					setLoop: 1
					setCycle: 0
					cel: 4
				)
				(= cycles 4)
			)
			(5
				(gEgo setCycle: CT 6 1 self)
			)
			(6
				(NormalEgo)
				(gEgo setHeading: 45 self)
			)
			(7
				(ResetWarning)
				(self dispose:)
			)
		)
	)
)

(instance levDown of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(gEgo setPri: -1 setScript: (ScriptID 62 0)) ; levitate
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 53 73 self)
			)
			(1
				(gEgo
					view: 472
					loop: 3
					cel: 0
					x: (- (gEgo x:) 13)
					y: (- (gEgo y:) 25)
					setPri: 13
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 31
					loop: 3
					x: (- (gEgo x:) 9)
					y: (+ (gEgo y:) 44 80)
					z: 80
				)
				(self dispose:)
			)
		)
	)
)

(instance jumpDown of HandsOffScript
	(properties)

	(method (handleEvent event &tmp zOffset)
		(cond
			((super handleEvent: event))
			((Said 'cast>')
				(if (== (SaidSpell event) 28)
					(if (TrySpell 28)
						(= zOffset (- 160 (gEgo y:)))
						(gEgo setPri: -1 y: (+ (gEgo y:) zOffset) z: zOffset)
						(client setScript: (ScriptID 62 0)) ; levitate
					)
				else
					(Print 470 37) ; "Not now - you're falling!"
					(event claimed: 1)
				)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 46 65 self)
			)
			(1
				(gEgo
					view: 472
					loop: 4
					cel: 0
					setPri: 10
					x: (+ (gEgo x:) 19)
					setCycle: End self
				)
			)
			(2
				(gEgo view: 591 loop: 4 cel: 0 x: 72 y: 53 illegalBits: 0)
				(= cycles 1)
			)
			(3
				(gEgo posn: 89 58)
				(= cycles 1)
			)
			(4
				(DontTalk 0)
				(if (TakeDamage 20)
					(gEgo
						setLoop: 6
						cel: 0
						x: 102
						y: 68
						yStep: 20
						setCycle: Fwd
						setMotion: MoveTo 102 168 self
					)
				else
					(= crashJump 1)
					(gEgo
						view: 22
						loop: 0
						cel: 0
						x: 102
						y: 68
						yStep: 16
						setCycle: End
						setMotion: MoveTo 110 145 self
					)
				)
			)
			(5
				(if crashJump
					(gEgo setCycle: End)
					(= cycles 15)
				else
					(khaveenTalker setMotion: 0 setScript: 0)
					(Face khaveenTalker gEgo 1)
					(gEgo
						setLoop: 2
						cel: 0
						x: 102
						y: 170
						yStep: 2
						xStep: 5
						setMotion: MoveTo 147 170 self
					)
				)
			)
			(6
				(if crashJump
					(EgoDead
						1
						{With all the damage you took to get here, it's really a shame you couldn't take any more.  You should've tended to your healing, but now it's too late.}
						#title
						{You Fell for It}
					)
				else
					(gEgo heading: 45 setLoop: 6)
					(NormalEgo)
					(= cycles 2)
				)
			)
			(7
				(HighPrint 470 38) ; "That hurt, but it's a good thing you're tough, agile, and know how to take a fall."
				(ResetWarning)
				(self dispose:)
			)
		)
	)
)

(instance paceAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khaveenTalker
					setCycle: Walk
					setMotion: MoveTo (Random 173 307) (Random 97 125) self
				)
			)
			(1
				(khaveenTalker
					setHeading:
						(mod (+ (khaveenTalker heading:) (Random 50 200)) 360)
						self
				)
			)
			(2
				(= cycles (Random 15 30))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance getRidOfKhaveen of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khaveenTalker setMotion: MoveTo 112 98 self)
			)
			(1
				(khaveenTalker setPri: 3 setMotion: MoveTo 85 90 self)
			)
			(2
				(SkillUsed 14 100) ; honor
				(SolvePuzzle 680 7 3)
				(djinniPrint 470 39) ; "You did it! Now you must go on."
				(self cue:)
			)
			(3
				(ResetWarning)
				(khaveenTalker dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bustDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 219 61 self)
			)
			(1
				(gEgo view: 576 setLoop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(lDoor ignoreActors: 1 setCycle: End)
				(rDoor ignoreActors: 1 setCycle: End)
			)
			(3
				(NormalEgo)
				(gEgo loop: 7)
				(self dispose:)
			)
		)
	)
)

(instance blowDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 200 61 self)
			)
			(1
				(gEgo view: 472 loop: 6 cel: 0 setCycle: End self)
				(doorTrap init: setCycle: End)
			)
			(2
				(gEgo view: 22 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(= cycles 6)
			)
			(4
				(if (TakeDamage 15)
					(gEgo loop: 1 cel: 0 setCycle: End self)
				else
					(EgoDead 1 470 40 #title {So Near And Yet So Far}) ; "The djinni tried to tell you about the door, but would you listen? Oh, no, Mr. Big Shot Hero. YOU had to go messing around with a Magical Fire Trap. And you weren't even healthy enough to withstand a little bitty blast. Shame on you!"
				)
			)
			(5
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance wrongWay of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(djinniPrint 470 41) ; "Master, you've GOT to go through the door at the top of the stairs. Any other way will take too long. Please, it's almost too late."
				(cond
					((& (gEgo onControl: 1) $0008)
						(gEgo setMotion: MoveTo 40 72 self)
					)
					((& (gEgo onControl: 1) $0020)
						(gEgo setMotion: MoveTo 117 101 self)
					)
					((& (gEgo onControl: 1) $0040)
						(gEgo
							setMotion:
								MoveTo
								(+ (gEgo x:) 20)
								(gEgo y:)
								self
						)
					)
					((& (gEgo onControl: 1) $0100)
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 20)
								(gEgo y:)
								self
						)
					)
					((& (gEgo onControl: 1) $0080)
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(- (gEgo y:) 15)
								self
						)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance throwDelay of Script
	(properties)

	(method (doit)
		(if (not (gEgo script:))
			(gEgo setScript: youBlewIt)
		)
	)
)

(instance whatEgoDid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (CastSpell register gEgo self 0 0))
					(self dispose:)
				)
			)
			(1
				(switch register
					(19
						(if (and (gCast contains: khaveenTalker) (lDoor cel:))
							(gEgo setScript: youBlewIt)
						)
					)
					(21
						(if
							(and
								(gCast contains: khaveenTalker)
								(gCast contains: doorTrap)
							)
							(gEgo setScript: youBlewIt)
						)
					)
					(24
						(gEgo setScript: getRidOfKhaveen)
					)
					(25
						(if (gCast contains: khaveenTalker)
							(gEgo setScript: youBlewIt)
						)
					)
					(27
						(if (gCast contains: khaveenTalker)
							(gEgo setScript: youBlewIt)
						)
					)
					(22
						(if (gCast contains: khaveenTalker)
							(gEgo setScript: youBlewIt)
						)
					)
					(26
						(djinniPrint 470 42) ; "Master, we don't have time for purposeless spells."
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance startFight of Script
	(properties)

	(method (doit)
		(if callGuards
			(= callGuards 0)
			(gCurRoom setScript: callTheGuards)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(= cycles 4)
			)
			(1
				1
				(Say khaveenTalker self 470 43 470 44) ; "So, you have managed to escape. Ad Avis does not know everything, it seems."
			)
			(2
				2
				(khaveenTalker setMotion: MoveTo 165 145 self)
				(if egoJumped
					(gEgo setMotion: MoveTo 143 152 self)
				)
			)
			(3
				3
				(if (and egoJumped (== (gEgo x:) 143) (== (gEgo y:) 152))
					(Face gEgo khaveenTalker)
				else
					(self cue:)
				)
			)
			(4
				4
				(gMiscSound number: 54 priority: 5 loop: -1 play:)
				(gEgo
					view: 83
					loop: 0
					cel: 0
					x: (- (gEgo x:) 8)
					y: (- (gEgo y:) 2)
					cycleSpeed: 1
					setCycle: End self
				)
				(khaveenTalker view: 475 setLoop: 0 setCel: 0)
			)
			(5
				5
				(if egoJumped
					(self cue:)
				else
					(gEgo
						view: 473
						setLoop: 1
						cel: 0
						y: (+ (gEgo y:) 8)
						cycleSpeed: 0
						setCycle: Walk
						setStep: 7 4
						setMotion: MoveTo 59 167 self
					)
				)
			)
			(6
				6
				(if egoJumped
					(self changeState: 11)
				else
					(gEgo setLoop: 2 cel: 0 x: 91 y: 162)
					(= cycles 2)
				)
			)
			(7
				(gEgo cel: 1 x: 112 y: 152)
				(= cycles 2)
			)
			(8
				8
				(gEgo setLoop: 4 cel: 0 x: 135 y: 150)
				(= seconds 2)
			)
			(9
				9
				(gEgo setCycle: End)
				(khaveenTalker setLoop: 9 cel: 0 setCycle: CT 2 1 self)
			)
			(10
				10
				(gEgo setCycle: Beg)
				(khaveenTalker setCycle: Beg self)
			)
			(11
				11
				(HandsOn)
				(khaveenTalker dispose:)
				((ScriptID 475 0) ; khaveen
					barMessage: 0
					ignoreActors: 1
					posn: 165 145
					initCombat:
				)
				(SetFlag 159)
				(gEgo dispose:)
				((ScriptID 475 1) ; rm470Warrior
					barMessage: 0
					ignoreActors: 1
					posn: 135 150
					setPri: 10
					initCombat:
				)
				(self dispose:)
			)
		)
	)
)

(instance searchBody of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 186 125 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo view: 47 setLoop: 0 setCel: 0 setCycle: End)
				(= cycles 12)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo)
				(HighPrint 470 45) ; "You search Khaveen's body and find the golden key to his private treasury. He must have millions and millions of dinars. You're rich! Rich beyond your wildest dreams!"
				(self setScript: youBlewIt)
			)
		)
	)
)

