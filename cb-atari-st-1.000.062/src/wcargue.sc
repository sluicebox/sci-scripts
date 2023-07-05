;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 237)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	wcargue 0
)

(synonyms
	(men people)
	(butt cigarette)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(gCast eachElementDo: #hide)
	(DrawPic 992 6 1 0)
)

(procedure (localproc_1)
	(DrawPic 34 7 1 0)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
	(WHead hide:)
)

(procedure (localproc_2)
	(Wilbur loop: 3 setCycle: Fwd)
	(WHead view: 404 loop: 5 setCycle: Fwd)
	(CHead view: 402 loop: 8 cel: 2 setCycle: 0)
	(Print &rest #at 171 150 #font 4 #width 125 #mode 1 #dispose)
)

(procedure (localproc_3)
	(Clarence loop: 2 setCycle: Fwd)
	(CHead view: 404 loop: 3 setCycle: Fwd)
	(WHead view: 425 loop: 5 cel: 0 setCycle: 0)
	(Print &rest #at 40 150 #font 4 #width 125 #mode 1 #dispose)
)

(instance wcargue of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(LoadMany rsSYNC 7 8)
		(LoadMany rsMESSAGE 243 247 248)
		(= global208 192)
		(= [global377 6] 248)
		(= [global377 7] 247)
		(Load rsVIEW 404)
		(Clarence init:)
		(CHead init:)
		(Wilbur init:)
		(WHead ignoreActors: 1 init:)
		(Smoke init: hide:)
		(self setScript: argue)
	)

	(method (doit)
		(if (and (== global172 100) (not local5))
			(= local5 1)
			(cls)
			(localproc_2 237 0) ; "What was that?!"
		)
		(if (== global172 110)
			(cls)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
	)
)

(instance argue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(User canInput: 0)
				(if (< global179 6)
					(++ global179)
				else
					(= global179 3)
				)
				(switch global179
					(1
						(localproc_3 237 1) ; "I'm warning you, Wilbur! If you say anything to...!"
						(= seconds 6)
					)
					(2
						(localproc_2 237 2) ; "I don't know, Clarence. I don't feel..."
						(= seconds 6)
					)
					(3
						(localproc_3 237 3) ; "You don't understand. It's not like that at all...!"
						(= seconds 4)
					)
					(4
						(localproc_2 237 4) ; "Well,...Laura!"
						(= seconds 3)
					)
					(5
						(= seconds 5)
						(localproc_3 237 5) ; "I can't stand interruptions!"
					)
					(else
						(localproc_2 237 6) ; "She's back again."
						(= seconds 3)
					)
				)
			)
			(2
				(cls)
				(CHead view: 402 loop: 8 cel: 2 setCycle: 0)
				(WHead view: 425 loop: 5 cel: 0 setCycle: 0)
				(switch global179
					(1
						(Clarence setCycle: 0)
						(= seconds 1)
					)
					(2
						(Wilbur setCycle: 0)
						(= seconds 1)
					)
					(3
						(Wilbur loop: 1 cel: 0 setCycle: End self)
						(Clarence loop: 0 cel: 3 setCycle: Beg)
					)
					(4
						(Wilbur loop: 1 cel: 0 setCycle: End self)
					)
					(else
						(Wilbur cel: 3 setCycle: Beg self)
					)
				)
			)
			(3
				(switch global179
					(1
						(localproc_3 237 7) ; "Young woman! Will you please leave us alone!"
						(= seconds 4)
					)
					(2
						(localproc_2 237 8) ; "Oh, Laura! Hello!"
						(= seconds 4)
					)
					(3
						(localproc_2 237 9) ; "Shhhh."
						(= seconds 3)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(CHead view: 402 loop: 8 cel: 2 setCycle: 0)
				(WHead view: 425 loop: 5 cel: 0 setCycle: 0)
				(Wilbur setScript: wilActions)
				(Clarence setScript: clarActions)
				(cls)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance wilActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (Wilbur loop:) 1)
					(Wilbur loop: 1 cel: 3 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(Wilbur loop: 9 cel: 0 cycleSpeed: 1 setCycle: End)
				(= seconds (Random 6 12))
			)
			(2
				(Wilbur setCycle: Beg)
				(= seconds (Random 6 12))
			)
			(3
				(WHead view: 425 loop: 5 cycleSpeed: 1 setCycle: End)
				(= seconds (Random 6 12))
			)
			(4
				(WHead view: 425 setCycle: Beg)
				(= seconds (Random 6 12))
			)
			(5
				(WHead view: 425 loop: 7 setCycle: End)
				(= seconds (Random 6 12))
			)
			(6
				(WHead view: 425 setCycle: Beg)
				(= state 0)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance clarActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local3 1)
					(= local3 2)
					(cls)
					(Wilbur loop: 1 setCycle: Beg)
				)
				(if (> (Clarence loop:) 1)
					(Clarence loop: 0 cel: 3 setCycle: Beg self)
					(= state -1)
				else
					(Clarence loop: 4 cel: 9 cycleSpeed: 1 setCycle: End self)
				)
			)
			(1
				(Clarence loop: 6 cel: 0 setCycle: End self)
			)
			(2
				(Smoke show: setPri: 7 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(if (< local2 2)
					(++ local2)
					(= state 1)
				else
					(= local2 0)
				)
				(= cycles 1)
			)
			(4
				(= seconds (Random 6 12))
				(cond
					((and (< (Random 1 100) 40) (== local3 0))
						(= local3 1)
						(localproc_2 237 10) ; "Quit blowing smoke in my face."
						(= seconds 4)
					)
					((< (Random 1 100) 60)
						(= state 0)
					)
				)
				(Smoke hide:)
				(Clarence setCycle: Beg)
			)
			(5
				(if (== local3 1)
					(= local3 2)
					(cls)
					(Wilbur loop: 1 setCycle: Beg)
				)
				(CHead loop: 8 cycleSpeed: 1 setCycle: Beg)
				(= seconds (Random 6 12))
			)
			(6
				(CHead setCycle: End)
				(= state 0)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance goSee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(HandsOff)
				(WHead hide:)
				(Wilbur
					view: 420
					setCycle: Walk
					cycleSpeed: 0
					setPri: -1
					illegalBits: -32768
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo 300 120 self
				)
			)
			(1
				(= global190 1)
				(localproc_0)
				(= seconds 5)
			)
			(2
				(localproc_1)
				(Print 237 11 #dispose) ; "A short time later..."
				(if (gEgo inRect: 150 98 175 102)
					(gEgo setMotion: MoveTo (+ (gEgo x:) 10) (gEgo y:))
				)
				(Wilbur setMotion: MoveTo 157 100 self)
				(= global190 0)
			)
			(3
				(cls)
				(= global213 8)
				(Say 1 237 12) ; "You're looney! There's NOTHING there!"
				(HandsOn)
				(Wilbur setAvoider: 0)
				(Wilbur view: 425 loop: 1 setScript: wilActions)
				(Clarence setScript: clarActions)
				(WHead show:)
			)
		)
	)
)

(instance CHead of Prop
	(properties
		y 104
		x 114
		z 40
		view 402
		loop 8
		cel 2
	)
)

(instance Clarence of Prop
	(properties
		y 104
		x 114
		view 402
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (< (gEgo distanceTo: Clarence) (gEgo distanceTo: Wilbur))
			(= global214 64)
		else
			(= global214 128)
		)
		(= global213 7)
		(cond
			((Said 'look/butt')
				(SetFlag 13)
				(Print 237 13) ; "That's a big cigar!"
			)
			((Said 'get/butt')
				(Print 237 14) ; "It belongs to the Clarence!"
			)
			((Said 'look/man')
				(event claimed: 1)
				(if (== global214 64)
					(DoLook {clarence})
				else
					(DoLook {wilbur})
				)
			)
			((and (MousedOn self event 3) (not (& global207 $0040)))
				(event claimed: 1)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(event claimed: 1)
				(Print 237 15) ; "Clarence and Wilbur seem to be having a private discussion."
			)
			(
				(or
					(Said 'talk/attorney')
					(and (== global214 64) (Said 'talk/man'))
				)
				(switch local0
					(0
						(Say 1 237 16) ; "It would be best if you would leave, young lady!"
					)
					(1
						(Say 1 237 17) ; "Why do you insist on being such a pest!"
					)
					(2
						(Say 1 237 18) ; "This IS a private discussion!"
					)
					(else
						(Print 237 19) ; "Angrily, Clarence ignores you."
					)
				)
				(++ local0)
			)
			((Said 'ask[/attorney]/c<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 19 237 20)
			)
			((Said 'listen/attorney,c')
				(Print 237 21) ; "You're bothering them."
			)
		)
	)
)

(instance WHead of Prop
	(properties
		y 100
		x 158
		z 39
		view 425
		loop 5
	)
)

(instance Wilbur of Act
	(properties
		y 100
		x 157
		view 425
		loop 1
	)

	(method (handleEvent event)
		(= global213 8)
		(cond
			((and (IsFlag 51) (Said 'tell[/c]/gertie<about'))
				(= global213 8)
				(if (& gCorpseFlags $0001) ; Gertie
					(if (& global145 $0004)
						(Say 1 237 22) ; "I won't let you fool me again! Once was enough!"
					else
						(Say 1 237 23) ; "No! You can't be serious!"
						(|= global145 $0004)
						(Wilbur setScript: goSee)
						(Clarence setScript: 0)
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'look/men')
				(Print 237 15) ; "Clarence and Wilbur seem to be having a private discussion."
			)
			((Said 'look,talk/person,men')
				(Print 237 24) ; "Which person are you referring to?"
			)
			((Said 'talk/men')
				(Print 237 25) ; "You can only talk to one person at a time."
			)
			((and (not (& global207 $0080)) (MousedOn self event 3))
				(event claimed: 1)
				(DoLook {wilbur})
			)
			(
				(and
					(& global207 $0080)
					(or (MousedOn self event 3) (Said 'look/c,men'))
				)
				(event claimed: 1)
				(Print 237 15) ; "Clarence and Wilbur seem to be having a private discussion."
			)
			((Said 'talk/c,man')
				(switch local1
					(0
						(Say 1 237 26) ; "Hey, Laura. How's tricks?"
					)
					(1
						(Say 1 237 27) ; "You really ought to leave now, Laura. Clarence and I are talking privately."
					)
					(2
						(Say 1 237 28) ; "Clarence is getting hot under the collar. You really should leave."
					)
					(else
						(Say 1 237 29) ; "Go on out, Laura."
					)
				)
				(++ local1)
			)
			((Said 'ask[/c]/attorney<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 4 237 20)
			)
		)
	)
)

(instance Smoke of Prop
	(properties
		y 62
		x 126
		view 402
		loop 9
	)
)

