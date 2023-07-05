;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Talker)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm405 0
)

(local
	seenMsg
)

(instance rm405 of LLRoom
	(properties
		picture 405
		west 400
	)

	(method (init)
		(LoadMany rsVIEW 405 406 407 1407)
		(gEgo init: view: 406)
		(clubOwner init: setCycle: Fwd)
		(gEgo edgeHit: 0 setLoop: 1)
		(ownersDoor init: caller: rm405)
		(gTheMusic number: 405 flags: 1 setLoop: -1 play:)
		(super init:)
	)

	(method (cue)
		(if (== (ownersDoor state:) 0)
			(self setScript: sCartoon)
		)
	)

	(method (dispose)
		(gTheMusic fade: 0 15 12 1 self)
		(super dispose:)
	)
)

(instance ownersDoor of Door
	(properties
		x 94
		y 114
		description {the door}
		approachX 109
		approachY 124
		view 405
		signal 16384
		entranceTo 400
		moveToX 71
		moveToY 123
		enterType 0
		exitType 0
	)
)

(instance clubOwner of Prop
	(properties
		x 218
		y 140
		view 407
	)
)

(instance the_Piano_Pit_Manager of Talker
	(properties
		name {the Piano Pit Manager}
		nsTop 13
		nsLeft 10
		view 1407
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= eyes ownerEyes)
		(= bust ownerBust)
		(= mouth ownerMouth)
		(super init: &rest)
	)
)

(instance ownerBust of Prop
	(properties
		view 1407
		loop 1
	)
)

(instance ownerEyes of Prop
	(properties
		nsTop 9
		nsLeft 31
		view 1407
		loop 2
		cycleSpeed 70
	)
)

(instance ownerMouth of Prop
	(properties
		nsTop 15
		nsLeft 36
		view 1407
		cycleSpeed 5
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 165 137 self setPri: 15)
			)
			(1
				(gEgo setLoop: 0 setCycle: End self)
			)
			(2
				(clubOwner setCycle: 0 setCel: 0 stopUpd:)
				(Say gEgo 405 0 67 15 15 70 160) ; "Well, Andy," you say to the swarthy club manager, "that about wraps it up for me. Looks like you've had another good week!"
				(Say the_Piano_Pit_Manager 405 1 108 139 self) ; "Funny you'd mention that, Patti."
			)
			(3
				(= ticks 30)
			)
			(4
				(Say the_Piano_Pit_Manager 405 2 108 139 self) ; "I was just getting ready to talk to you."
			)
			(5
				(= ticks 123)
			)
			(6
				(Say gEgo 405 3 67 15 15 70 160) ; ""You DID enjoy the show, didn't you, Andy?" you ask with your best smile."
				(= seconds 3)
			)
			(7
				(Say the_Piano_Pit_Manager 405 4 108 139 self) ; "Oh, Patti, it ain't me. You know I like you just fine. It's just my boss that don't."
			)
			(8
				(= ticks 60)
			)
			(9
				(Say the_Piano_Pit_Manager 405 5 108 139 self) ; "Julius doesn't much care for small audiences."
			)
			(10
				(= ticks 60)
			)
			(11
				(Say the_Piano_Pit_Manager 405 6 108 139 self) ; "He says your fans listen too much and drink too little."
			)
			(12
				(= ticks 60)
			)
			(13
				(TPrint 405 7 67 -1 185) ; "(How ironic! You were thinking just the opposite!)"
				(Say the_Piano_Pit_Manager 405 8 108 139 self) ; "He can't see how he and his 'backers' can be expected to make a profit like that."
			)
			(14
				(= ticks 30)
			)
			(15
				(Say the_Piano_Pit_Manager 405 9 108 139 self) ; "Patti, I'm just going to have to let you go."
			)
			(16
				(= ticks 123)
			)
			(17
				(Say gEgo 405 10 67 15 15 70 160) ; "But, Andy! How could you? After all I've done for you?"
				(Say the_Piano_Pit_Manager 405 11 108 139 self) ; "It's not me, Honey," he says, "you treated me jus' fine. I'll be sorry to see you go."
			)
			(18
				(= ticks 123)
			)
			(19
				(Say gEgo 405 12 67 15 15 70 160) ; "Well, then, give me my pay, and I'll get out of here!"
				(Say the_Piano_Pit_Manager 405 13 108 139 self) ; "Ah, er," he stutters, "I guess that's the other thing: I can't do that."
			)
			(20
				(= ticks 60)
			)
			(21
				(Say the_Piano_Pit_Manager 405 14 108 139 self) ; "Julius says your contract was never valid, so he doesn't have to pay."
			)
			(22
				(= ticks 123)
			)
			(23
				(Say gEgo 405 15 67 15 15 70 160) ; "WHAT!" you explode, "Now you're saying I don't even get paid for the week I have worked?! I ought to file a grievance with the Musicians' Union!"
				(Say the_Piano_Pit_Manager 405 16 108 139 self) ; "Not exactly shaking, he replies, "Do what you have to do, Patti, but if you ever want to work anywhere in this town again...""
			)
			(24
				(= ticks 60)
			)
			(25
				(Say gEgo 405 17 67 15 15 70 160) ; "His meaning is not lost on you. "Goodbye, Andy! Somehow I expected more of you. I don't know why!""
				(Say the_Piano_Pit_Manager 405 18 108 139 self) ; "Patti, take my advice: play more commercial. Give 'em what they like! A broad as good lookin' as you could really pull 'em in, if you'd just get smart!"
			)
			(26
				(= ticks 123)
			)
			(27
				(gEgo cel: 4 setCycle: Beg self)
				(clubOwner startUpd: setCycle: Fwd)
			)
			(28
				(Say gEgo 405 19 67 15 15 70 160) ; ""Andy, when I start taking musical criticism from you, I'd appreciate it if someone would just put me out of my misery!" you say, leaving his grimy desk."
				(gEgo
					setCycle: Fwd
					setLoop: 2
					setMotion: MoveTo 109 124 self
				)
			)
			(29
				(gEgo setCycle: 0)
				(gEgo setPri: -1)
				(= cycles 1)
			)
			(30
				(ownersDoor setCycle: End self)
				(if (ownersDoor openSnd:)
					((Sound new:) number: (ownersDoor openSnd:) play:)
				)
			)
			(31
				(gEgo setCycle: Fwd setPri: -1 setMotion: MoveTo 71 123 self)
			)
			(32
				(gCurRoom newRoom: (gCurRoom west:))
			)
		)
	)
)

