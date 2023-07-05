;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 259)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	crArgue 0
)

(synonyms
	(butt cigarette)
)

(local
	local0
	local1
	local2
	[local3 2]
	local5
)

(procedure (localproc_0)
	(rHead setCel: -1 setCycle: Fwd)
	(Rudy setCycle: End)
	(Print &rest #at 171 140 #font 4 #width 125 #mode 1 #dispose)
)

(procedure (localproc_1)
	(Clarence setCycle: End)
	(CHead view: 404 loop: 3 setCycle: Fwd)
	(Print &rest #at 80 140 #font 4 #width 125 #mode 1 #dispose)
)

(procedure (localproc_2)
	(gCast eachElementDo: #hide)
	(DrawPic 992 6 1 0)
)

(procedure (localproc_3)
	(DrawPic 48 7 1 0)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
	(rHead hide:)
	(CHead hide:)
)

(instance crArgue of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0004))
			(LoadMany rsFONT 4 41)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
		)
		(Load rsSCRIPT 985)
		(LoadMany rsMESSAGE 243 284 289)
		(LoadMany rsSYNC 7 9)
		(= global208 320)
		(= [global377 6] 284)
		(= [global377 8] 289)
		(Rudy init:)
		(rHead ignoreActors: 1 init:)
		(CHead ignoreActors: 1 init:)
		(Clarence init:)
		(Wisp setPri: 13 ignoreActors: 1 setCycle: Fwd cycleSpeed: 1 init:)
		(AshTray setPri: 13 ignoreActors: 1 init: stopUpd:)
		(Smoke setPri: 12 ignoreActors: 1 init: hide:)
		(glass setPri: 14 ignoreActors: 1 init: stopUpd:)
		(self setScript: argue)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo y:) 158)
			(gEgo setPri: 14)
		else
			(gEgo setPri: -1)
		)
	)

	(method (dispose)
		(if (and (not (& gSpyFlags $0008)) (== [gCycleTimers 2] 0))
			(= [gCycleTimers 2] 1800)
		)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance argue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0004))
						(|= gMustDos $0004)
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
				(User canControl: 1)
				(if (== (= local5 (& global178 $7fff)) global178)
					(if (< global178 8)
						(++ global178)
					else
						(= global178 -32765)
					)
				else
					(switch local5
						(3
							(= global178 -32764)
						)
						(4
							(= global178 -32762)
						)
						(6
							(= global178 -32760)
						)
						(8
							(= global178 -32765)
						)
					)
				)
				(switch local5
					(1
						(localproc_0 259 0) ; "I'm warning you, Clarence! If you...!"
					)
					(2
						(localproc_1 259 1) ; "Gloria will regret the day she...!"
					)
					(3
						(localproc_1 259 2) ; "I can't take these constant intrusions!"
					)
					(4
						(localproc_0 259 3) ; "This conversation isn't for you, toots."
					)
					(5
						(localproc_0 259 4) ; "My sister should have known better than to...!"
					)
					(6
						(localproc_1 259 5) ; "This girl is getting on my nerves!"
					)
					(7
						(localproc_1 259 6) ; "If I can't convince her then..."
					)
					(else
						(localproc_0 259 7) ; "This ain't for you, kid!"
					)
				)
				(= seconds 7)
			)
			(2
				(cls)
				(rHead setCycle: 0)
				(CHead setCycle: 0)
				(if (or (== local5 2) (== local5 3) (== local5 6) (== local5 7))
					(Clarence setCycle: Beg self)
				else
					(Rudy setCycle: Beg self)
				)
			)
			(3
				(switch local5
					(1
						(localproc_1 259 8) ; "Shut up! This is just between you and me!"
						(= seconds 5)
					)
					(2
						(localproc_1 259 9) ; "Young lady! Will you please leave?!!"
						(= seconds 5)
					)
					(5
						(localproc_0 259 10) ; "Listen, sweetie! You have no business buttin' in here!"
						(= seconds 5)
					)
					(6
						(localproc_0 259 11) ; "You have a real way with the dames, don't you, Clarence?!"
						(= seconds 5)
					)
					(7
						(localproc_0 259 12) ; "Oh, no! Not again!"
						(= seconds 5)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(rHead setCycle: 0)
				(CHead setCycle: 0)
				(cls)
				(if (or (== local5 2) (== local5 1))
					(Clarence setCycle: Beg self)
				else
					(Rudy setCycle: Beg self)
				)
			)
			(5
				(HandsOn)
				(Rudy loop: 0 setScript: rudyActions)
				(Clarence setScript: clarActions)
				(client setScript: 0)
				(User canInput: 1)
			)
		)
	)
)

(instance rudyActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 6 12))
				(rHead show:)
			)
			(1
				(rHead setCel: -1 loop: 5 setCycle: End)
				(= seconds (Random 3 5))
			)
			(2
				(Rudy cel: 0 loop: 2 setCycle: End)
				(= seconds (Random 3 5))
			)
			(3
				(rHead setCycle: Beg)
				(= seconds (Random 3 5))
			)
			(4
				(Rudy loop: 3 setCycle: End)
				(= seconds (Random 3 5))
			)
			(5
				(rHead setCycle: End)
				(= seconds (Random 5 8))
			)
			(6
				(rHead setCycle: Beg)
				(= state 4)
				(= seconds (Random 8 16))
			)
		)
	)
)

(instance clarActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(CHead hide:)
				(= cycles 1)
			)
			(1
				(CHead hide:)
				(Clarence
					view: 416
					cycleSpeed: 2
					loop: 3
					cel: 2
					x: 169
					y: 152
					z: 26
					setPri: 13
					illegalBits: 0
					ignoreActors: 1
					setCycle: Beg self
				)
			)
			(2
				(glass hide:)
				(Clarence loop: 2 cel: 3 setCycle: Beg self)
			)
			(3
				(Clarence loop: 1 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(4
				(Clarence setCycle: Beg self)
			)
			(5
				(Clarence loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(glass show:)
				(Clarence loop: 3 cel: 0 setCycle: End)
				(if (< (Random 1 100) 34)
					(= state 0)
				)
				(= seconds (Random 6 12))
			)
			(7
				(CHead
					show:
					view: 416
					posn: 172 161
					cel: 0
					loop: 5
					cycleSpeed: 2
					setCycle: End
				)
				(Clarence loop: 4 setCycle: End)
				(= seconds (Random 3 9))
			)
			(8
				(Clarence loop: 7 setCycle: Fwd)
				(= seconds (Random 3 9))
			)
			(9
				(Clarence loop: 4 cel: 3 setCycle: Beg)
				(CHead setCycle: Beg)
				(= seconds (Random 3 9))
				(if (< (Random 1 100) 51)
					(= state 0)
				)
			)
			(10
				(CHead hide:)
				(Clarence view: 418 loop: 0 setCycle: End self)
			)
			(11
				(Wisp hide:)
				(Clarence loop: 1 setCycle: End self)
			)
			(12
				(Clarence loop: 2 setCycle: End)
				(= seconds 3)
			)
			(13
				(Smoke show: cel: 0 setCycle: End self)
				(Clarence setCycle: Beg)
			)
			(14
				(Clarence loop: 1 cel: 1 setCycle: Beg self)
				(Smoke hide:)
			)
			(15
				(Clarence loop: 0 cel: 2 setCycle: Beg self)
				(Wisp show:)
				(= state 0)
			)
		)
	)
)

(instance goSee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Clarence setScript: 0)
				(= cycles 1)
			)
			(1
				(rHead hide:)
				(Rudy
					view: 380
					setCycle: Walk
					cycleSpeed: 0
					setPri: -1
					illegalBits: -32768
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo -20 96 self
				)
			)
			(2
				(= global190 1)
				(localproc_2)
				(= seconds 5)
			)
			(3
				(localproc_3)
				(Print 259 13 #dispose) ; "A short time later..."
				(Rudy setMotion: MoveTo 201 142 self)
				(= global190 0)
			)
			(4
				(cls)
				(= global213 9)
				(Say 1 259 14) ; "You're looney! There's NOTHING there!"
				(HandsOn)
				(Rudy view: 382 loop: 2 cycleSpeed: 2 setAvoider: 0)
				(Rudy setScript: rudyActions)
				(Clarence setScript: clarActions)
			)
		)
	)
)

(instance rHead of Prop
	(properties
		y 142
		x 201
		z 41
		view 382
		loop 4
		cycleSpeed 1
	)
)

(instance Rudy of Act
	(properties
		y 142
		x 201
		view 382
		loop 2
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if (< (gEgo distanceTo: Rudy) (gEgo distanceTo: Clarence))
			(= global214 256)
		else
			(= global214 64)
		)
		(if (Said 'look/person,man')
			(switch global214
				(256
					(DoLook {rudy})
				)
				(64
					(DoLook {clarence})
				)
			)
		)
		(= global213 9)
		(cond
			((and (IsFlag 51) (Said 'tell[/rudolph]/gertie<about'))
				(= global213 9)
				(if (& gCorpseFlags $0001) ; Gertie
					(if (& global145 $0080)
						(Say 1 259 15) ; "You must really think I'm stupid if you expect me to believe you again!"
					else
						(Say 1 259 16) ; "Mother? Dead? She can't be!"
						(|= global145 $0080)
						(Rudy setScript: goSee)
					)
				else
					(event claimed: 0)
				)
			)
			((and (not (& global207 $0100)) (MousedOn self event 3))
				(event claimed: 1)
				(DoLook {rudy})
			)
			(
				(and
					(& global207 $0100)
					(or (MousedOn self event 3) (Said 'look/rudolph'))
				)
				(event claimed: 1)
				(Print 259 17) ; "Rudy and Clarence seem to be having a very heated discussion about something!"
			)
			((Said 'ask[/rudolph,man,person]/attorney<about')
				(Print 259 18) ; "Rudy shoots an angry look at you. It's obvious that he's in no mood to gab!"
			)
			((Said 'look/men,people')
				(Print 259 17) ; "Rudy and Clarence seem to be having a very heated discussion about something!"
			)
			((Said 'talk/people,men')
				(Print 259 19) ; "You can only talk to one person at a time."
			)
			(
				(or
					(Said '/rudolph>')
					(and (== global214 256) (Said 'talk/person,man>'))
				)
				(cond
					((Said 'talk')
						(switch local0
							(0
								(Say 1 259 20) ; "I don't feel like talkin' to you right now!"
							)
							(1
								(Say 1 259 21) ; "This isn't the time or the place!"
							)
							(2
								(Say 1 259 22) ; "Don't you get the message?! This conversation ain't for you!"
							)
							(else
								(Say 1 259 23) ; "Scram, will ya?!"
							)
						)
						(++ local0)
					)
					((Said 'tell')
						(Print 259 18) ; "Rudy shoots an angry look at you. It's obvious that he's in no mood to gab!"
					)
					((Said 'listen')
						(Say 259 24)
					)
					((Said 'give,show')
						(Print 259 25) ; "Rudy seems to be occupied by other matters. He barely glances at it."
					)
				)
			)
		)
	)
)

(instance glass of Prop
	(properties
		y 138
		x 151
		view 416
	)
)

(instance CHead of Prop
	(properties
		y 145
		x 168
		z 40
		view 404
		cel 2
	)
)

(instance Clarence of Act
	(properties
		y 145
		x 164
		view 402
		illegalBits 0
	)

	(method (handleEvent event)
		(= global213 7)
		(if (< (gEgo distanceTo: Rudy) (gEgo distanceTo: Clarence))
			(= global214 256)
		else
			(= global214 64)
		)
		(cond
			((and (not (& global207 $0040)) (MousedOn self event 3))
				(event claimed: 1)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(event claimed: 1)
				(Print 259 17) ; "Rudy and Clarence seem to be having a very heated discussion about something!"
			)
			((Said 'ask[/attorney,man,person]/rudolph<about')
				(Print 259 26) ; "Clarence sullenly looks your way. It doesn't appear that he wants anything to do with you!"
			)
			(
				(or
					(Said '/attorney>')
					(and (== global214 64) (Said 'talk/person,man>'))
				)
				(cond
					((Said 'talk')
						(switch local2
							(0
								(Say 1 259 27) ; "Get out of here, young lady! NOW!!"
							)
							(1
								(Say 1 259 28) ; "You're not a part of this discussion!"
							)
							(else
								(Say 1 259 29) ; "Bug off!!"
							)
						)
						(++ local2)
					)
					((Said 'tell')
						(Print 259 26) ; "Clarence sullenly looks your way. It doesn't appear that he wants anything to do with you!"
					)
					((Said 'listen')
						(Say 259 24)
					)
					((Said 'give,show')
						(Print 259 30) ; "Clarence is not at all interested in it at the moment."
					)
				)
			)
		)
	)
)

(instance Smoke of Prop
	(properties
		y 120
		x 170
		view 418
		loop 3
	)
)

(instance AshTray of Prop
	(properties
		y 136
		x 151
		view 148
		loop 1
		cel 10
	)

	(method (handleEvent)
		(cond
			((Said 'look/drink,glass,alcohol')
				(Print 259 31) ; "You think it's bourbon."
			)
			((Said 'get/drink,glass,alcohol')
				(Print 259 32) ; "He wouldn't like that!"
			)
			((Said 'get/butt')
				(Print 259 33) ; "He wouldn't give it to you!"
			)
			((Said 'look/ashtray,butt')
				(Print 259 34) ; "Clarence's cigar sits in the ashtray."
			)
			((Said 'drink/alcohol')
				(Print 259 35) ; "You don't like liquor...remember?"
			)
		)
	)
)

(instance Wisp of Prop
	(properties
		y 135
		x 149
		view 418
		loop 4
	)
)

