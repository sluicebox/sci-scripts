;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)
(use Main)
(use eRS)
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
		(HandsOff)
		(gEgo init: x: 71 y: 121 view: 406)
		(clubOwner init: setCycle: Fwd)
		(gEgo edgeHit: EDGE_NONE setLoop: 1)
		(ownersDoor init: setCel: 255)
		(gTheMusic number: 405 flags: 1 setLoop: -1 play:)
		(super init:)
		(self setScript: sCartoon)
	)

	(method (dispose)
		(gTheMusic fade: 0 15 12 1 self)
		(super dispose:)
	)
)

(instance ownersDoor of Prop
	(properties
		x 94
		y 114
		description {the door}
		approachX 109
		approachY 121
		view 405
		signal 16384
	)
)

(instance clubOwner of Prop
	(properties
		x 218
		y 140
		view 407
	)
)

(instance Andy of Talker
	(properties
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
				(gEgo setMotion: MoveTo 109 121 self)
			)
			(1
				(ownersDoor setCycle: Beg)
				((Sound new:) number: 41 play:)
				(gEgo setMotion: MoveTo 165 137 self setPri: 15)
			)
			(2
				(ownersDoor stopUpd:)
				(gEgo setLoop: 0 setCycle: End self)
			)
			(3
				(clubOwner setCycle: 0 setCel: 0 stopUpd:)
				(Say gEgo 405 0 #at 15 15 #width 160) ; "Well, Andy," you say to the swarthy club manager, "that about wraps it up for me. Looks like you've had another good week!"
				(Say Andy 405 1 #dispose #caller self) ; "Funny you'd mention that, Patti."
			)
			(4
				(= ticks 30)
			)
			(5
				(Say Andy 405 2 #dispose #caller self) ; "I was just getting ready to talk to you."
			)
			(6
				(= ticks 123)
			)
			(7
				(Say gEgo 405 3 #at 15 15 #width 160) ; ""You DID enjoy the show, didn't you, Andy?" you ask with your best smile."
				(= seconds 3)
			)
			(8
				(Say Andy 405 4 #dispose #caller self) ; "Oh, Patti, it ain't me. You know I like you just fine. It's just my boss that don't."
			)
			(9
				(= ticks 60)
			)
			(10
				(Say Andy 405 5 #dispose #caller self) ; "Julius doesn't much care for small audiences."
			)
			(11
				(= ticks 60)
			)
			(12
				(Say Andy 405 6 #dispose #caller self) ; "He says your fans listen too much and drink too little."
			)
			(13
				(= ticks 60)
			)
			(14
				(TPrint 405 7 #at -1 185) ; "(How ironic! You were thinking just the opposite!)"
				(Say Andy 405 8 #dispose #caller self) ; "He can't see how he and his 'backers' can be expected to make a profit like that."
			)
			(15
				(= ticks 30)
			)
			(16
				(Say Andy 405 9 #dispose #caller self) ; "Patti, I'm just going to have to let you go."
			)
			(17
				(= ticks 123)
			)
			(18
				(Say gEgo 405 10 #at 15 15 #width 160) ; "But, Andy! How could you? After all I've done for you?"
				(Say Andy 405 11 #dispose #caller self) ; "It's not me, Honey," he says, "you treated me jus' fine. I'll be sorry to see you go."
			)
			(19
				(= ticks 123)
			)
			(20
				(Say gEgo 405 12 #at 15 15 #width 160) ; "Well, then, give me my pay, and I'll get out of here!"
				(Say Andy 405 13 #dispose #caller self) ; "Ah, er," he stutters, "I guess that's the other thing: I can't do that."
			)
			(21
				(= ticks 60)
			)
			(22
				(Say Andy 405 14 #dispose #caller self) ; "Julius says your contract was never valid, so he doesn't have to pay."
			)
			(23
				(= ticks 123)
			)
			(24
				(Say gEgo 405 15 #at 15 15 #width 160) ; "WHAT!" you explode, "Now you're saying I don't even get paid for the week I have worked?! I ought to file a grievance with the Musicians' Union!"
				(Say Andy 405 16 #dispose #caller self) ; "Not exactly shaking, he replies, "Do what you have to do, Patti, but if you ever want to work anywhere in this town again...""
			)
			(25
				(= ticks 60)
			)
			(26
				(Say gEgo 405 17 #at 15 15 #width 160) ; "His meaning is not lost on you. "Goodbye, Andy! Somehow I expected more of you. I don't know why!""
				(Say Andy 405 18 #dispose #caller self) ; "Patti, take my advice: play more commercial. Give 'em what they like! A broad as good lookin' as you could really pull 'em in, if you'd just get smart!"
			)
			(27
				(= ticks 123)
			)
			(28
				(gEgo cel: 4 setCycle: Beg self)
				(clubOwner startUpd: setCycle: Fwd)
			)
			(29
				(Say gEgo 405 19 #at 15 15 #width 160) ; ""Andy, when I start taking musical criticism from you, I'd appreciate it if someone would just put me out of my misery!" you say, leaving his grimy desk."
				(gEgo
					setCycle: Fwd
					setLoop: 2
					setMotion: MoveTo 109 121 self
				)
			)
			(30
				(gEgo setCycle: 0)
				(gEgo setPri: -1)
				(= cycles 1)
			)
			(31
				(ownersDoor setCycle: End self)
				((Sound new:) number: 40 play:)
			)
			(32
				(gEgo setCycle: Fwd setPri: -1 setMotion: MoveTo 71 121 self)
			)
			(33
				(gCurRoom newRoom: (gCurRoom west:))
			)
		)
	)
)

