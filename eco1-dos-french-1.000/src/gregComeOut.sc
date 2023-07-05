;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use n819)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	gregComeOut 0
	getStarFish 1
)

(instance gregComeOut of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 202)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= start 0)
				(self setScript: (ScriptID 200 5) self) ; gregExit
			)
			(1
				(if (not (SetFlag 39))
					(SetScore 2 277)
					(= cycles 1)
				else
					(= state 10)
					(= cycles 1)
				)
			)
			(2
				(Face gEgo (ScriptID 200 7) self) ; gregarious
			)
			(3
				((ScriptID 200 3) init: 2 1 self) ; Gregarious, "Hey! What ya doin' there, stranger?"
			)
			(4
				((ScriptID 2 1) init: 1 1 self) ; Adam, "I'd like to go inside and visit the fish."
			)
			(5
				((ScriptID 200 3) init: 3 1 self) ; Gregarious, "Nope, nope, nope. No can do. I'm Gregarious and I'm 'sposed to keep strangers out. That's ma' job. And I don't know you from Adam."
			)
			(6
				((ScriptID 2 1) init: 2 1 self) ; Adam, "But I AM Adam!"
			)
			(7
				((ScriptID 200 3) init: 4 1 self) ; Gregarious, "Sorry. Sorry. No can do. You'll need a pass ta get in. Yup. A pass."
			)
			(8
				((ScriptID 2 1) init: 3 1 self) ; Adam, "Where can I get that?"
			)
			(9
				((ScriptID 200 3) init: 5 1 self) ; Gregarious, "Ya got me. <a-hyuh> I'm just the watchman."
			)
			(10
				(if (gCast contains: gDelph)
					((ScriptID 2 0) init: 1 1 self) ; Delphineus, "Guess you'll need a pass, Adam."
				else
					(= cycles 1)
				)
				(= state 11)
			)
			(11
				((ScriptID 200 3) init: 6 1 self) ; Gregarious, "Ya got a pass yet, stranger, or are ya just flounderin' around?"
			)
			(12
				(self setScript: gregWait self)
			)
			(13
				(if (gCast contains: (ScriptID 200 7)) ; gregarious
					(self setScript: (ScriptID 200 4) self) ; gregEnter
				else
					(= cycles 1)
				)
			)
			(14
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance gregWait of Script
	(properties)

	(method (doit)
		(if (not ((ScriptID 200 7) script:)) ; gregarious
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar disable: 0)
				((ScriptID 200 7) setCycle: Fwd) ; gregarious
				(= seconds 20)
			)
			(1
				((ScriptID 200 3) init: 8 1 self) ; Gregarious, "Guess ya don't have a pass, <a-hyuh>."
			)
			(2
				(HandsOff)
				(self dispose:)
			)
		)
	)
)

(instance getStarFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 1) init: 21 1 self) ; Adam, "Will this do? The Mayor said it was a 'badge'."
			)
			(1
				(if (and (!= (gEgo x:) 200) (!= (gEgo y:) 88))
					(gEgo setMotion: MoveTo 200 88 self)
				else
					(= cycles 1)
				)
			)
			(2
				(= cycles 12)
			)
			(3
				((ScriptID 200 7) ; gregarious
					view: 248
					loop: 1
					cel: 0
					posn: 167 95
					ignoreActors:
					cycleSpeed: 18
					setCycle: CT 2 1
				)
				(gEgo
					setCycle: 0
					view: 248
					loop: 0
					cel: 0
					posn: 196 87
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(4
				(SetScore 5 278)
				((ScriptID 200 9) approachX: 186 approachY: 109) ; gregariousA
				(gEgo put: 20 200) ; starFish
				(gEgo
					view: 805
					setLoop: 1
					setHeading: 270
					posn: 200 88
					setCycle: Fwd
				)
				(= cycles 12)
			)
			(5
				((ScriptID 200 7) setCycle: End self) ; gregarious
			)
			(6
				((ScriptID 200 3) init: 9 1 self) ; Gregarious, "Well, I'll be a starfish stickin' to a reef shark's back! A badge from the Mayor! Why didn' ya say so, stranger? Er... ummm... visitor. Feel free ta look around."
			)
			(7
				(self setScript: (ScriptID 200 4) self) ; gregEnter
			)
			(8
				(Narrator init: 48 self) ; "A plastic baggie floats down from the surface..."
			)
			(9
				(baggie
					init:
					illegalBits: 0
					setLoop: 9
					setCycle: Fwd
					setMotion: MoveTo 141 58 self
				)
			)
			(10
				(Narrator init: 49 self) ; "Before Adam can grab it..."
			)
			(11
				(baggie dispose:)
				(gSoundEffects number: 210 loop: 1 play:)
				((ScriptID 200 6) ; narci
					init:
					illegalBits: 0
					setPri: 2
					posn: 105 64
					cel: 1
					setCycle: CT 6 1 self
				)
			)
			(12
				(gSoundEffects number: 211 loop: 1 play:)
				((ScriptID 200 6) setCycle: End self) ; narci
			)
			(13
				((ScriptID 200 6) ; narci
					view: 223
					loop: 1
					cel: 0
					x: 144
					y: 66
					setPri: -1
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(14
				(Narrator init: 50 self) ; "The little blowfish panics and inflates..."
			)
			(15
				((ScriptID 200 6) ; narci
					view: 223
					loop: 2
					cel: 0
					cycleSpeed: 17
					setCycle: CT 3 1 self
				)
			)
			(16
				(gSoundEffects number: 212 loop: 1 play:)
				((ScriptID 200 6) cel: 4) ; narci
				(= cycles 8)
			)
			(17
				((ScriptID 200 6) ; narci
					view: 223
					loop: 3
					cel: 0
					x: 122
					y: 72
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(18
				((ScriptID 200 6) ; narci
					view: 223
					loop: 4
					cel: 0
					x: 84
					y: 70
					cycleSpeed: 4
					setCycle: Fwd
				)
				(SetFlag 47)
				(= cycles 1)
			)
			(19
				(Narrator init: 51 self) ; "And gets stuck in his apartment window, too fat to get through!"
			)
			(20
				(NormalEgo)
				(gEgo setHeading: 270 posn: 200 88 setPri: 6)
				(= cycles 12)
			)
			(21
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance baggie of Actor
	(properties
		x 168
		y -8
		view 223
		loop 9
		priority 5
		signal 24592
	)
)

