;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 264)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	lillGun 0
)

(synonyms
	(lil person woman)
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(Print &rest #at 40 10 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance lillGun of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0002))
			(LoadMany rsFONT 4 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
		)
		(Load rsVIEW 642 904)
		(LoadMany rsMESSAGE 243 295)
		(= global208 32)
		(= [global377 5] 295)
		(Lillian setCycle: Walk init:)
		(self setScript: reading)
	)

	(method (doit)
		(if (Lillian inRect: 235 102 267 118)
			(Lillian setPri: 8)
		else
			(Lillian setPri: -1)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(cond
			((Said 'talk/lil')
				(= global213 6)
				(switch local1
					(0
						(Say 1 264 0) ; "You surprised me, Laura."
						(Say 1 264 1) ; "Have you been keeping yourself busy?"
					)
					(1
						(Say 1 264 2) ; "I hope you've been getting along with the family. They're quite interesting, aren't they?"
					)
					(2
						(Say 1 264 3) ; "I've noticed you exploring the estate."
						(Say 1 264 4) ; "I must warn you, though. This can be a dangerous place, especially at night. There are areas you really shouldn't go."
						(Say 1 264 5) ; "I'd hate to see you get hurt, Laura."
					)
					(3
						(Say 1 264 6) ; "It's starting to get a little late, isn't it? I may go up to our room in a little bit and relax for the night."
					)
					(4
						(Say 1 264 7) ; "Yawn! Oh, my goodness. I can hardly keep my eyes open."
					)
					(5
						(Say 1 264 8) ; "I think I'd like to just sit here a moment and relax. I'll meet you up in the room later. Okay, Laura?"
					)
					(else
						(Say 1 264 9) ; "Bye, Laura."
					)
				)
				(++ local1)
			)
			((Said 'listen/lil')
				(Print 264 10) ; "Lillian isn't talking."
			)
		)
	)
)

(instance reading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gAct 3)
					(cond
						((not global216)
							(= state -1)
						)
						((not (& gMustDos $0002))
							(|= gMustDos $0002)
							(self setScript: (ScriptID 406 0)) ; Clock
							(= state -1)
						)
						((self script:)
							(= state -1)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(localproc_0 264 11) ; "What an interesting collection of weapons Uncle Henri has! I wonder..."
				(= seconds 7)
			)
			(2
				(cls)
				(LookAt Lillian gEgo)
				(global373 setCycle: Beg)
				(= global213 6)
				(Say 1 264 12) ; "Oh, Laura!...you startled me!"
				(= seconds 3)
			)
			(3
				(Lillian
					setAvoider: (Avoid new:)
					setMotion: MoveTo 262 120 self
				)
			)
			(4
				(lHead setPri: 8 setScript: headActions init:)
				(Lillian
					view: 516
					illegalBits: 0
					posn: 260 118
					loop: 2
					cel: 0
					setAvoider: 0
					setScript: lilActions
				)
				(gEgo observeControl: 16384)
				(DisposeScript 985)
				(client setScript: 0)
			)
		)
	)
)

(instance headActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (not local2)
					(lHead
						loop: (if (< (Random 1 100) 51) 1 else 2)
						setCycle: End
					)
				)
				(= seconds (Random 6 12))
			)
			(2
				(lHead setCycle: Beg)
				(= state 0)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance lilActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(Lillian loop: 0 cycleSpeed: 1 setCycle: End)
				(if (< (Random 1 100) 50)
					(= state 5)
				)
				(= seconds (Random 6 12))
			)
			(1
				(Lillian loop: 5 setCycle: Fwd)
				(= seconds (Random 5 8))
			)
			(2
				(Lillian loop: 0 cel: (- (NumCels Lillian) 1) setCycle: Beg)
				(= local2 1)
				(if (!= (lHead cel:) 0)
					(lHead setCycle: Beg)
				)
				(= seconds (Random 5 8))
			)
			(3
				(Lillian loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(Lillian loop: 4 setCycle: Fwd)
				(= seconds 2)
			)
			(5
				(Lillian loop: 3 cel: (- (NumCels Lillian) 1) setCycle: Beg)
				(= seconds (Random 5 8))
			)
			(6
				(= local2 0)
				(Lillian loop: 6 cel: 0 setCycle: End)
				(= seconds (Random 5 8))
			)
			(7
				(Lillian setCycle: Beg)
				(= seconds (Random 5 8))
			)
			(8
				(= state -1)
				(= seconds (Random 5 8))
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
				(= global213 6)
				(Say 1 264 13) ; "That seems unlikely, Laura, but I'll check it out!"
				(if
					(or
						(gEgo inRect: 64 115 107 131)
						(gEgo inRect: 250 115 275 127)
					)
					(gEgo
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20) self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(LookAt gEgo Lillian)
				(lHead hide:)
				(Lillian
					view: 500
					loop: 2
					setCycle: Walk
					cycleSpeed: 0
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo 94 123 self
				)
			)
			(2
				(global374 setCycle: End)
				(global375 setCycle: End self)
				(doorFX number: 43 loop: 1 play:)
			)
			(3
				(Lillian setMotion: MoveTo 44 123 self)
			)
			(4
				(global374 setCycle: Beg)
				(global375 setCycle: Beg self)
				(doorFX number: 44 loop: 1 play:)
			)
			(5
				(Print 264 14 #dispose) ; "A short time later..."
				(= seconds 3)
			)
			(6
				(cls)
				(global374 setCycle: End)
				(global375 setCycle: End self)
				(doorFX number: 43 loop: 1 play:)
			)
			(7
				(Lillian setMotion: MoveTo 94 123 self)
			)
			(8
				(global374 setCycle: Beg)
				(global375 setCycle: Beg self)
				(doorFX number: 44 loop: 1 play:)
				(= global213 6)
				(Say 1 264 15) ; "Oh, you're just imagining things, Laura!"
			)
			(9
				(global374 stopUpd:)
				(global375 stopUpd:)
				(Lillian setMotion: MoveTo 262 120 self)
			)
			(10
				(lHead show: setPri: 8 setScript: headActions)
				(Lillian
					view: 516
					illegalBits: 0
					posn: 260 118
					loop: 2
					cel: 0
					setAvoider: 0
					setScript: lilActions
				)
				(DisposeScript 985)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance Lillian of Act
	(properties
		y 95
		x 128
		view 500
		loop 3
	)

	(method (handleEvent event)
		(= global213 6)
		(cond
			((and (IsFlag 51) (Said 'tell[/lil]/gertie<about'))
				(if (& gCorpseFlags $0001) ; Gertie
					(if (& global145 $0001)
						(Say 1 264 16) ; "I've already told you, Laura, there's nothing there!"
						(event claimed: 1)
					else
						(|= global145 $0001)
						(self setScript: goSee)
						(event claimed: 1)
					)
				else
					(event claimed: 0)
				)
			)
			((and (IsFlag 51) (Said 'tell[/lil]/actress<about>'))
				(if (& gCorpseFlags $0004) ; Gloria
					(if (& global145 $0001)
						(Say 1 264 16) ; "I've already told you, Laura, there's nothing there!"
						(event claimed: 1)
					else
						(|= global145 $0001)
						(self setScript: goSee)
						(event claimed: 1)
					)
				else
					(event claimed: 0)
				)
			)
			((and (IsFlag 51) (Said 'tell[/lil]/c<about'))
				(if (& gCorpseFlags $0002) ; Wilbur
					(if (& global145 $0001)
						(Say 1 264 16) ; "I've already told you, Laura, there's nothing there!"
						(event claimed: 1)
					else
						(|= global145 $0001)
						(self setScript: goSee)
					)
				else
					(event claimed: 0)
				)
			)
			((and (MousedOn self event 3) (not (& global207 $0020)))
				(event claimed: 1)
				(DoLook {lillian})
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event 3) (Said 'look/lil'))
				)
				(event claimed: 1)
				(if local0
					(Print 264 17) ; "Your friend relaxes in a chair by the fireplace."
				else
					(Print 264 18) ; "After you surprised Lillian at the Colonel's weapons cabinet, she rests in a chair by the fireplace."
				)
			)
		)
	)
)

(instance lHead of Prop
	(properties
		y 85
		x 264
		view 516
		loop 1
	)
)

(instance doorFX of Sound
	(properties)
)

