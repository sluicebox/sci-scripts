;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Interface)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	bottomScript 0
	leftScript 1
	rightScript 2
)

(local
	local0
)

(instance stars of Prop
	(properties)
)

(instance pillow of Prop
	(properties)
)

(instance gerta of Act
	(properties)
)

(instance bottomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				((ScriptID 321 7) setCycle: End self) ; bottomDoor
			)
			(1
				(gEgo setMotion: MoveTo 130 112)
				(= cycles 15)
			)
			(2
				(gEgo
					setLoop: 3
					setCycle: Rev
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo 130 130 self
				)
			)
			(3
				((ScriptID 321 6) ; otto
					setLoop: 0
					posn: 130 112
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 130 120
				)
				(gEgo
					setLoop: 2
					setCycle: Fwd
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 3 3
					setMotion: MoveTo 130 150 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 130 146 self)
			)
			(5
				(++ local0)
				(gEgo setMotion: MoveTo 130 150 self)
			)
			(6
				(if (> local0 4)
					(self cue:)
				else
					(self changeState: 4)
				)
			)
			(7
				((ScriptID 321 3) stop:) ; sneakMusic
				(EgoDead 290 0 80 { Criminal carelessness. } 82 602 4 0) ; "It's hard to be a hero when you're sitting in a jail cell. The Sheriff apologized for your broken arm, but he did warn you (didn't he?) that Otto was only partly trained. In the future, you'll probably be more careful when you're robbing someone."
			)
		)
	)
)

(instance leftScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				((ScriptID 321 8) setCycle: End self) ; leftDoor
			)
			(1
				(gEgo setLoop: 3 setMotion: MoveTo 119 51)
				(= cycles 15)
			)
			(2
				(gEgo
					setLoop: 3
					setCycle: Rev
					moveSpeed: 2
					cycleSpeed: 2
					setMotion: MoveTo 119 59 self
				)
			)
			(3
				(SetFlag 196)
				(gEgo
					view: 525
					posn: 117 59
					setLoop: 1
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 108 59 self
				)
			)
			(4
				((ScriptID 321 5) ; sheriff
					setLoop: 2
					cel: 0
					posn: 117 48
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 122 58
				)
				(gEgo setMotion: MoveTo 85 59 self)
			)
			(5
				((ScriptID 321 5) ; sheriff
					setLoop: 1
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 85 58
				)
				(NormalEgo)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setLoop: 1
					setMotion: MoveTo 80 59 self
				)
			)
			(6
				(gEgo
					view: 507
					setCycle: Fwd
					setLoop: 0
					posn: 79 44
					setStep: 6 9
					setMotion: MoveTo 37 67 self
				)
			)
			(7
				(gEgo setLoop: 5 setMotion: MoveTo 14 97 self)
			)
			(8
				(gEgo setLoop: 1 setMotion: MoveTo 20 135 self)
			)
			(9
				((ScriptID 321 5) setLoop: 2) ; sheriff
				(gEgo setLoop: 3 setCel: 1 setPri: 12 posn: 20 134)
				((View new:)
					view: 507
					loop: 2
					cel: 0
					posn: 19 155
					init:
					stopUpd:
				)
				(stars
					view: 507
					loop: 4
					cel: 0
					posn: 19 135
					init:
					setCycle: Fwd
					startUpd:
				)
				(= cycles 2)
			)
			(10
				(gEgo setCel: 2)
				(++ local0)
				(= cycles 2)
			)
			(11
				(gEgo setCel: 1)
				(= cycles 2)
			)
			(12
				(if (< local0 4)
					(self changeState: 10)
				else
					(stars dispose:)
					(gEgo setCel: 0)
					(= cycles 2)
				)
			)
			(13
				((ScriptID 321 3) stop:) ; sneakMusic
				(EgoDead 290 1 80 { Criminal carelessness. } 82 503 1 0) ; "When it comes to breaking in, it looks like the only thing broken is your head! When at last you come to your senses, you find yourself in a jail cell. By the time you get out of here, you'll be too old to be a hero."
			)
		)
	)
)

(instance rightScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				((ScriptID 321 9) setCycle: End self) ; rightDoor
			)
			(1
				(gEgo setMotion: MoveTo 164 51)
				(= cycles 15)
			)
			(2
				(Print 290 2) ; "Uh Oh! As you see a pillow flying toward you, you hear the Sheriff's wife say..."
				(Print 290 3 #at 90 18) ; "SCREEEEEEEEEEEECH!"
				(pillow
					view: 602
					loop: 6
					cel: 0
					posn: 166 26
					setPri: 1
					init:
					setCycle: Fwd
					cycleSpeed: 1
					startUpd:
				)
				(gEgo setPri: 0)
				(= cycles 12)
			)
			(3
				((ScriptID 321 8) setCycle: End) ; leftDoor
				((ScriptID 321 5) ; sheriff
					setLoop: 2
					cel: 0
					posn: 115 42
					moveSpeed: 1
					setMotion: MoveTo 122 60
				)
				(gEgo
					setLoop: 3
					setPri: -1
					setCycle: Rev
					moveSpeed: 2
					cycleSpeed: 2
					setMotion: MoveTo 175 60 self
				)
			)
			(4
				(pillow dispose:)
				((ScriptID 321 8) stopUpd:) ; leftDoor
				(gEgo
					view: 507
					setLoop: 2
					cel: 1
					posn: 175 43
					setCycle: 0
					setPri: 9
				)
				((ScriptID 321 5) setLoop: 4 setCel: 0) ; sheriff
				(= cycles 8)
			)
			(5
				((ScriptID 321 5) setCel: 1 stopUpd:) ; sheriff
				(gEgo
					view: 507
					setLoop: 1
					cel: 0
					setStep: 4 14
					moveSpeed: 0
					cycleSpeed: 1
					setCycle: CT 1 1 self
				)
			)
			(6
				(gEgo setPri: 10 setCycle: CT 2 1 self)
			)
			(7
				(gEgo setCycle: Fwd setMotion: MoveTo 175 125 self)
				(gerta
					view: 602
					setLoop: 3
					setCel: 0
					posn: 187 44
					illegalBits: 0
					ignoreActors:
					init:
					setCycle: 0
					setMotion: MoveTo 173 44
				)
			)
			(8
				((ScriptID 321 5) setCel: 2) ; sheriff
				(gerta stopUpd:)
				((ScriptID 321 9) stopUpd:) ; rightDoor
				(gEgo posn: 175 128 setLoop: 6 setCel: 0)
				(stars
					view: 507
					loop: 4
					cel: 0
					posn: 176 141
					init:
					setCycle: Fwd
					startUpd:
				)
				(= cycles 2)
			)
			(9
				((ScriptID 321 7) ; bottomDoor
					loop: 7
					cel: 0
					posn: 109 119
					setPri: 9
					cycleSpeed: 1
					setCycle: End self
				)
				((ScriptID 321 6) setLoop: 1 cel: 1 posn: 125 119 setPri: 8) ; otto
			)
			(10
				((ScriptID 321 2) loop: 1 number: (SoundFX 15) play:) ; miscMusic
				((View new:)
					view: 321
					loop: 4
					cel: 5
					posn: 117 128
					init:
					stopUpd:
				)
				((View new:)
					view: 321
					loop: 4
					cel: 6
					posn: 139 128
					init:
					stopUpd:
				)
				((ScriptID 321 6) ; otto
					cycleSpeed: 1
					moveSpeed: 1
					setPri: 9
					setMotion: MoveTo 135 130 self
				)
			)
			(11
				((ScriptID 321 6) setLoop: 5 setCycle: Fwd) ; otto
				(= cycles 10)
			)
			(12
				((ScriptID 321 3) stop:) ; sneakMusic
				(EgoDead 290 4 80 { Criminal carelessness. } 82 507 6 0) ; "You never dreamed a feather pillow could be so HARD! Or was it the floor? You also didn't realize how hard it is for a thief to be a Hero. The Thief of Baghdad should have this kind of luck!"
			)
		)
	)
)

