;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 133)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm133 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 100]
	local106
	local107
	local108
	local109
	local110
	local111
	local112
	local113
	local114
	local115
)

(procedure (localproc_0)
	(Print &rest #at -1 20 #font gSmallFont)
)

(instance themeMusic of Sound
	(properties
		priority 7
	)
)

(instance bainsGunShot of Sound
	(properties
		number 41
		priority 8
	)
)

(instance rm133 of Rm
	(properties
		picture 77
		style 6
	)

	(method (init)
		(Load rsVIEW 297)
		(Load rsVIEW 37)
		(Load rsVIEW 38)
		(Load rsVIEW 13)
		(Load rsVIEW 15)
		(Load rsVIEW 274)
		(Load rsVIEW 285)
		(Load rsSOUND 41)
		(Load rsSOUND 38)
		(Load rsSOUND 33)
		(Load rsSOUND 14)
		(Load rsSOUND 47)
		(super init:)
		(gEgo view: (if global204 7 else 1) posn: 160 170 init:)
		(HandsOn)
		(= local111 1)
		(= global211 0)
		(= global212 0)
		((= local0 (Act new:))
			view: 13
			loop: 2
			cel: 0
			illegalBits: 0
			posn: 145 205
			setCycle: Walk
			init:
			hide:
		)
		((= local1 (Act new:))
			view: 38
			loop: 2
			cel: 0
			posn: 210 115
			setCycle: Fwd
			cycleSpeed: 2
			setPri: 8
			init:
		)
		((= local2 (Act new:))
			view: 38
			loop: 3
			cel: 0
			ignoreActors: 1
			posn: 210 115
			init:
			setPri: 8
			addToPic:
		)
		((= local3 (Prop new:))
			view: 297
			loop: 0
			cel: 0
			posn: 155 64
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		((= local4 (Prop new:))
			view: 297
			loop: 1
			cel: 0
			posn: 184 75
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors: 1
			init:
		)
		(if (< global110 30)
			(local3 stopUpd:)
			(local4 stopUpd:)
		)
		(self setScript: rm133Script)
	)

	(method (doit)
		(cond
			((& (gEgo onControl: 1) $0002)
				(gContinuousMusic number: 9 loop: -1 play:)
				(gCurRoom newRoom: 131)
			)
			(global139 0)
			((& (gEgo onControl: 1) $0100)
				(= local108 1)
			)
			(else
				(= local108 0)
			)
		)
		(cond
			((not local111) 0)
			((> (gEgo distanceTo: local1) 40)
				(local1 cycleSpeed: 3)
			)
			((not local110)
				(localproc_0 133 0) ; "Marie squirms excitedly in her chair as you approach. She says "MUMBLE, MUMBLE"."
				(local1 cycleSpeed: 1)
				(= local110 1)
			)
			(else
				(local1 cycleSpeed: 1)
			)
		)
		(if global205
			(if (== global205 2)
				(++ local107)
			)
			(= global205 0)
		)
		(if (and local114 (not local113) (not local115))
			(if (not local108)
				(= local113 1)
				(HandsOff)
				(rm133Script changeState: 18)
			else
				(= local113 1)
				(rm133Script changeState: 21)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look[<at,around][/(!*,chamber)]')
						(localproc_0 133 1) ; "This is the control room for the sewer. There is a control panel on the back wall."
					)
					((Said 'look/gauge')
						(localproc_0 133 2) ; "The gauges have normal readings."
					)
					((Said 'look/panel')
						(localproc_0 133 3) ; "The control panel has controls, but they are complicated and unimportant to you."
					)
					((Said 'press/button')
						(localproc_0 133 4) ; "Pushing the buttons is not very constructive."
					)
					((Said 'use/control')
						(localproc_0 133 5) ; "You're a police officer, not a sanitation engineer."
					)
					((Said 'listen')
						(localproc_0 133 6) ; "You don't hear much except Marie."
					)
					((Said 'smell[/*]')
						(localproc_0 133 7) ; "It smells only a little better in here."
					)
					((Said 'remove/mask')
						(if (gEgo has: 32) ; gas_mask
							(localproc_0 133 8) ; "You don't have the gas mask on."
						else
							(localproc_0 133 9) ; "You don't have a mask."
						)
					)
					((Said 'wear/mask')
						(if (gEgo has: 32) ; gas_mask
							(localproc_0 133 10) ; "You don't need to wear the mask now."
						else
							(localproc_0 133 9) ; "You don't have a mask."
						)
					)
					((Said 'help/cheeks')
						(localproc_0 133 11) ; "Ok...she's tied up and gagged...now what?"
					)
					((or (Said 'untie/(cheeks,rope)') (Said 'remove/rope'))
						(cond
							((not local111)
								(Print 133 12) ; "She already is!"
							)
							((gEgo inRect: 185 110 224 135)
								(SetFlag 125)
								(SetScore 5 160)
								(rm133Script changeState: 1)
							)
							(else
								(localproc_0 133 13) ; "Move closer to untie her."
							)
						)
					)
					(
						(or
							(Said '(keep,be)<calm,calm')
							(Said 'close<up')
							(Said 'calm/cheeks')
						)
						(cond
							(local109
								(localproc_0 133 14) ; "OK."
							)
							((not local111)
								(Print 133 15) ; "She already is."
							)
							((> (gEgo distanceTo: local1) 40)
								(Print 133 16) ; "Get closer."
							)
							(else
								(localproc_0 133 17) ; "After you tell Marie to keep quiet, Marie stops her struggling."
								(= local109 1)
								(local1 setCycle: 0)
								(SetFlag 125)
								(SetScore 5 161)
							)
						)
					)
					((Said 'look/cheeks')
						(cond
							(local111
								(localproc_0 133 18) ; "Marie is tied up in a chair."
							)
							((< (rm133Script state:) 4)
								(localproc_0 133 19) ; "Marie is nervous, but also excited to see you."
							)
							((< (rm133Script state:) 28)
								(localproc_0 133 20) ; "Marie is frozen in a state of panic."
							)
							(else
								(localproc_0 133 21) ; "Marie is overjoyed to see you and excited that both you and her are safe."
							)
						)
					)
					((Said '*/cheeks')
						(if local111
							(localproc_0 133 22) ; "First, she looks like she wants to be untied."
						else
							(localproc_0 133 23) ; "Wait until later..."
						)
					)
					((Said 'remove/gag')
						(if (not local111)
							(localproc_0 133 24) ; "You have already done that."
						else
							(localproc_0 133 25) ; "Untie her first."
						)
					)
					(
						(or
							(Said '(freeze,police,stop)')
							(Said 'say/(freeze,police,stop)')
						)
						(if (not local112)
							(Print 133 26) ; "Why say that now?"
						else
							(localproc_0 133 27) ; "You yell out to Bains to halt."
							(rm133Script changeState: 21)
							(= local113 1)
						)
					)
				)
			)
		)
	)
)

(instance rm133Script of Script
	(properties)

	(method (init)
		(gContinuousMusic fade:)
		(if (not (IsFlag 122))
			(localproc_0 133 28) ; "You cautiously walk into the room...you can't believe your eyes when you see..."
			(SetFlag 125)
			(SetScore 10 122)
			(localproc_0 133 29) ; "Marie!" you mumble, under your breath.."I've located Marie!"
			(localproc_0 133 30) ; "Showing excitement from seeing you, Marie struggles against her restraints."
		)
		(themeMusic number: 14 loop: 1 play:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(if global204
					(proc0_19 gEgo holsterGun)
				)
				(localproc_0 133 31) ; "You nervously struggle with the rope...Finally you loosen her bonds and set her free."
				(local1 setLoop: 1 cel: 1 posn: 215 115 setCycle: 0)
				(gEgo ignoreActors: 1 setMotion: MoveTo 190 115 self)
			)
			(2
				(gEgo ignoreActors: 0 loop: 0 cel: 0 posn: 190 115)
				(local1 ignoreActors: 0 setCycle: End self)
			)
			(3
				(localproc_0 133 32) ; "She whispers in your ear about how happy she is to see you. Then..."
				(localproc_0 133 33) ; "She smothers you in her lipstick."
				(local1 setLoop: 0 cel: 0 posn: 197 115 setCycle: End self)
				(gEgo hide:)
			)
			(4
				(= local111 0)
				(= global203 1)
				(local1 setCel: 4 setCycle: Beg)
				(RedrawCast)
				(if (not local109)
					(User canInput: 0)
					(localproc_0 133 34) ; "Marie is very nervous and excited. Crying loudly, she tells you how happy she is to see you. Then..."
					(localproc_0 133 35) ; "All of a sudden Bains appears in the control room..."
					(local0 show: setMotion: MoveTo 145 150 self)
					(themeMusic stop: number: 33 play:)
				else
					(User canInput: 1)
					(localproc_0 133 36) ; "Nervous and trying to stay as quiet as possible, Marie whispers..."
					(localproc_0 133 37) ; "Please, S-S-Sonny, let's g-get out of here b-before h-he comes b-back."
					(self changeState: 8)
				)
			)
			(5
				(gEgo show:)
				(local1 view: 37 loop: 1 posn: 204 115 ignoreActors: 0)
				(localproc_0 133 38) ; "Bains has the drop on you as he says......"
				(localproc_0 133 39) ; "I have you right where I want you, PIG EYES!!"
				(localproc_0 133 40) ; "You're just in time to see the fire from Bains' gun."
				(local0
					view: 15
					setLoop: 0
					cel: 0
					setMotion: 0
					setCycle: End self
				)
				(bainsGunShot play:)
			)
			(6
				(local0 cel: 0 setCycle: End)
				(bainsGunShot play:)
				(HandsOff)
				(gEgo
					view: 297
					setMotion: 0
					loop: (if (> (local0 x:) (gEgo x:)) 2 else 3)
					setPri: 2
					setCycle: End self
				)
			)
			(7
				(EgoDead 133 41) ; "In Marie's excited state of being, she raised her voice, alerting Bains. Next time try to calm her before untying her."
			)
			(8
				(localproc_0 133 42) ; "The sound of approaching footsteps interrupts your plans, and Marie says..."
				(themeMusic number: 38 loop: -1 play:)
				(localproc_0 133 43) ; "OH MY GOD!!! He's coming back!"
				(localproc_0 133 44) ; "Continuing she says,"Sonny! You must hide.""
				(= cycles 2)
			)
			(9
				(gEgo show:)
				(local1
					view: 38
					loop: 1
					setCel: 255
					posn: 215 115
					setCycle: CT 1 -1
				)
				(HandsOn)
				(= cycles 100)
			)
			(10
				(local0 show:)
				(if (<= (gEgo y:) 170)
					(local0 setMotion: MoveTo 145 170 self)
				else
					(local0 setMotion: MoveTo 145 195 self)
				)
				(themeMusic stop: number: 33 play:)
				(= local112 1)
				(= local107 0)
			)
			(11
				(if (== local108 1)
					(local0 setMotion: MoveTo 150 145 self)
				else
					(self changeState: 17)
				)
			)
			(12
				(local0 setMotion: MoveTo 160 130 self)
				(= local114 1)
			)
			(13
				(= seconds 5)
			)
			(14
				(local0 setMotion: 0)
				(local0 loop: 2)
				(= seconds 1)
			)
			(15
				(local0 loop: 1)
				(= seconds 1)
			)
			(16
				(self changeState: 18)
			)
			(17
				(= local106 (- (local0 x:) (gEgo x:)))
				(if (and (<= (gEgo y:) 150) (>= (Abs local106) 20))
					(local0 setMotion: MoveTo 145 160 self)
				else
					(self changeState: 18)
				)
			)
			(18
				(local0 setMotion: 0)
				(cond
					((<= (+ (local0 x:) 20) (gEgo x:))
						(local0 view: 15 setLoop: 0 cel: 0 setCycle: End self)
					)
					((>= (- (local0 x:) 20) (gEgo x:))
						(local0 view: 15 setLoop: 1 cel: 0 setCycle: End self)
					)
					(else
						(local0 view: 15 setLoop: 3 cel: 0 setCycle: End self)
					)
				)
			)
			(19
				(HandsOff)
				(= global139 1)
				(if local108
					(gEgo
						view: 297
						loop: (if (> (local0 x:) (gEgo x:)) 2 else 3)
						posn: 82 138
						setCycle: End self
					)
				else
					(gEgo
						view: 297
						loop: (if (> (local0 x:) (gEgo x:)) 2 else 3)
						setCycle: End self
					)
				)
				(gEgo setMotion: 0)
				(local0 setMotion: 0)
			)
			(20
				(HandsOff)
				(cond
					((and (== local107 0) (not global204))
						(EgoDead 133 45) ; "One loaded gun in your hand is worth two in the holster."
					)
					((not local108)
						(EgoDead 133 46) ; "Standing out in the open, you shoot it out with Bains. Your nervousness causes you to miss. Unfortunately, he didn't."
					)
					(else
						(EgoDead 133 47) ; "The firefight between you and Bains ends with him winning. Remember, the one with the quick gun AND enough ammo wins."
					)
				)
			)
			(21
				(= local107 0)
				(local0 view: 15 setMotion: 0 setLoop: 1 cel: 0 setCycle: End)
				(= cycles 6)
				(bainsGunShot play:)
			)
			(22
				(if (<= local107 1)
					(local0 view: 15 setLoop: 1 cel: 0 setCycle: End)
					(bainsGunShot play:)
					(= cycles 6)
				else
					(self changeState: 25)
				)
			)
			(23
				(if (<= local107 1)
					(local0 view: 15 setLoop: 1 cel: 0 setCycle: End)
					(bainsGunShot play:)
					(= cycles 6)
				else
					(self changeState: 25)
				)
			)
			(24
				(self changeState: 19)
			)
			(25
				(HandsOff)
				(themeMusic dispose:)
				(bainsGunShot dispose:)
				(gEgo setMotion: 0)
				(SetScore 15)
				(local0 view: 274 setLoop: 0 cel: 0 setCycle: End)
				(= local115 1)
				(= cycles 10)
			)
			(26
				(HandsOff)
				(if global204
					(proc0_19 gEgo holsterGun)
				)
				(local0 ignoreActors: 1 stopUpd:)
				(= local5 (localproc_0 133 48 88)) ; "The barrage is over. Bains lies motionless on the control room floor."
				(= seconds 8)
			)
			(27
				(clr)
				(= local5 (localproc_0 133 49 88)) ; "It appears that all the firing range practice has paid off."
				(gEgo
					view: 1
					setMotion: MoveTo (+ (local0 x:) 8) (- (local0 y:) 15) self
				)
			)
			(28
				(clr)
				(gEgo loop: 2)
				(RedrawCast)
				(themeMusic stop: number: 47 loop: 1 play:)
				(= seconds 3)
			)
			(29
				(= local5 (localproc_0 133 50 88)) ; "Checking Bains, you find all vital signs have ceased."
				(= seconds 7)
			)
			(30
				(clr)
				(= local5 (localproc_0 133 51 88)) ; "You view Bains in his deceased state. Deep down inside, you kind of feel sorry for him. The reality, however, is that...."
				(= seconds 13)
			)
			(31
				(clr)
				(= local5 (localproc_0 133 52 88)) ; "the destructive vengeance of "The Death Angel" has been silenced."
				(= seconds 8)
			)
			(32
				(clr)
				(local1
					view: 38
					loop: 1
					setCel: 0
					posn: 215 115
					setCycle: End
					ignoreActors: 1
				)
				(gEgo setMotion: MoveTo 190 115 self)
			)
			(33
				(local1
					view: 38
					loop: 0
					cel: 0
					posn: 197 115
					setCycle: End self
				)
				(gEgo hide:)
			)
			(34
				(RedrawCast)
				(localproc_0 133 53 88) ; "Oh Sonny!" Marie says..."You're my hero! I never want to be apart from you ever again!"
				(= seconds 5)
			)
			(35
				(if (!= (themeMusic prevSignal:) -1)
					(-- state)
					(= cycles 2)
				else
					(clr)
					(gContinuousMusic stop: dispose:)
					(gCurRoom newRoom: 91)
				)
			)
		)
	)
)

(instance holsterGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view:
						(switch (gEgo view:)
							(7 5)
							(5 5)
						)
					loop: (mod (gEgo loop:) 4)
					setCel: 255
					setCycle: Beg self
				)
			)
			(1
				(= global204 0)
				(gEgo view: 1 setCel: 0 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

