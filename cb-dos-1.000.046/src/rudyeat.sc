;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 403)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rudyeat 0
)

(synonyms
	(rudolph person man)
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(gCast eachElementDo: #hide)
	(DrawPic 992 6 1 0)
)

(procedure (localproc_1)
	(DrawPic 34 7 1 0)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
	(RHead hide:)
)

(procedure (localproc_2) ; UNUSED
	(Print &rest #at 60 140 #font 4 #mode 1 #draw #dispose)
)

(instance rudyeat of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0001))
			(LoadMany rsFONT 4 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
			(Load rsVIEW 642)
		)
		(LoadMany rsVIEW 380 908)
		(LoadMany rsMESSAGE 243 373)
		(= global208 256)
		(= [global377 8] 373)
		(RHead setPri: 9 init: hide:)
		(Plate ignoreActors: 1 setPri: 9 init: stopUpd:)
		(Rudy ignoreActors: 1 illegalBits: 0)
		(Rudy posn: 108 100 setPri: 9 init:)
		(self setScript: eatPie)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'talk>')
					(if (Said '/rudolph')
						(= global213 9)
						(switch local0
							(0
								(Say 1 403 0) ; "Ah, Laura! Are you still up?"
								(Say 1 403 1) ; "It's getting so quiet around here; everybody must have gone to bed."
							)
							(1
								(Say 1 403 2) ; "Celie is a good cook. Hey, do you want to join me?"
								(= global213 12)
								(Say 0 403 3) ; "Since you're not hungry, you politely decline."
							)
							(2
								(Say 1 403 4) ; "You know, I'd like to get to know you better. You seem like a real swell girl."
								(= global213 12)
								(Say 0 403 5) ; "Well! He seems to be back to his usual, fun-loving self!"
							)
							(3
								(Say 1 403 6) ; "I'm very attracted to you, Laura. You're so...young, sweet, and innocent. I find that very exciting!"
								(= global213 12)
								(Say 0 403 7) ; "Oh, oh! Better watch out!"
							)
							(4
								(Say 1 403 8) ; "Hey, what's the matter with you?! Ain't you attracted to me, likewise?!"
								(= global213 12)
								(Say 0 403 9) ; "Now that you mention it...."
							)
							(5
								(Say 1 403 10) ; "Yeah, well...I don't need no sniveling kid cramping my style, anyhow!"
							)
							(6
								(Say 1 403 11) ; "You still here?! Why don't you go find someone else to play with, little girl?! Yeah!...go find Lillian!"
							)
							(7
								(Say 1 403 12) ; "Did you hear me?! I said, SCRAM!!"
							)
							(else
								(Print 403 13) ; "You have definitely gotten on the wrong side of Rudy. It doesn't appear that he wants anything more to do with you."
							)
						)
						(++ local0)
					)
				)
				((Said 'listen/rudolph')
					(Print 403 14) ; "Currently, Rudy's not saying anything."
				)
				((Said 'look/desert,coffee')
					(Print 403 15) ; "Rudy is enjoying a cup of coffee and a piece of pie."
				)
				((Said 'eat,get/desert,food')
					(Print 403 16) ; "You're not very hungry right now."
				)
			)
		)
	)
)

(instance eatPie of Script
	(properties)

	(method (doit)
		(if
			(and
				(or (== (Rudy loop:) 3) (== (Rudy loop:) 6))
				(== (Rudy cel:) 0)
			)
			(RHead show:)
			(Rudy loop: 6 cel: 0)
		else
			(RHead hide:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0001))
						(|= gMustDos $0001)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Rudy
					view: 396
					setPri: 9
					cycleSpeed: 1
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(Rudy loop: 2 cel: 0 setCycle: Fwd)
				(if (< (Random 1 100) 60)
					(= state -1)
				)
				(= seconds 5)
			)
			(3
				(Rudy loop: 3 cel: 0 setCycle: End)
				(= seconds 5)
			)
			(4
				(Rudy loop: 3 setCycle: Beg)
				(= seconds (Random 3 6))
			)
			(5
				(RHead loop: (if (< (Random 1 100) 51) 4 else 5) setCycle: End)
				(= seconds (Random 3 6))
			)
			(6
				(RHead setCycle: Beg)
				(if (< (Random 1 100) 60)
					(= state -1)
				else
					(= state 2)
				)
				(= seconds (Random 3 8))
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
				(= local1 1)
				(Rudy
					view: 380
					setCycle: Walk
					cycleSpeed: 0
					setPri: -1
					illegalBits: -32768
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo 300 120 self
				)
				(RHead hide:)
			)
			(1
				(= global190 1)
				(localproc_0)
				(= seconds 5)
			)
			(2
				(localproc_1)
				(Print 403 17 #dispose) ; "A short time later..."
				(Rudy setMotion: MoveTo 115 103 self)
				(= global190 0)
			)
			(3
				(cls)
				(= global213 9)
				(Say 1 403 18) ; "You're looney! There's NOTHING there!"
				(HandsOn)
				(Rudy setAvoider: 0)
				(= cycles 1)
			)
			(4
				(Rudy
					view: 396
					loop: 1
					cel: 0
					ignoreActors: 1
					illegalBits: 0
					posn: 108 100
					setPri: 9
					init:
				)
				(RHead show:)
				(rudyeat setScript: eatPie)
			)
		)
	)
)

(instance RHead of Prop
	(properties
		y 100
		x 104
		z 23
		view 396
		loop 4
	)
)

(instance Plate of Prop
	(properties
		y 99
		x 110
		view 396
		cel 1
	)
)

(instance Rudy of Act
	(properties
		view 396
		loop 1
	)

	(method (handleEvent event)
		(cond
			((and (IsFlag 51) (Said 'tell[/rudolph]/actress<about'))
				(= global213 9)
				(if (& gCorpseFlags $0004) ; Gloria
					(if (& global145 $0080)
						(Say 1 403 19) ; "You won't get me to fall for one of your stories this time!"
					else
						(Say 1 403 20) ; "Oh, no! That's terrible."
						(|= global145 $0080)
						(rudyeat setScript: goSee)
					)
				else
					(event claimed: 0)
				)
			)
			((and (IsFlag 51) (Said 'tell[/rudolph]/gertie<about'))
				(= global213 9)
				(if (& gCorpseFlags $0001) ; Gertie
					(if (& global145 $0080)
						(Say 1 403 21) ; "Forget it. You tried that trick on me already!"
					else
						(Say 1 403 20) ; "Oh, no! That's terrible."
						(|= global145 $0080)
						(rudyeat setScript: goSee)
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'get/cup,coffee')
				(Print 403 22) ; "You're not fond of coffee."
			)
			((and (MousedOn self event 3) (not (& global207 $0100)))
				(event claimed: 1)
				(DoLook {rudy})
			)
			(
				(and
					(& global207 $0100)
					(or (MousedOn self event 3) (Said 'look/rudolph'))
				)
				(event claimed: 1)
				(Print 403 15) ; "Rudy is enjoying a cup of coffee and a piece of pie."
			)
		)
	)
)

