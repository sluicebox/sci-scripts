;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 294)
(include sci.sh)
(use Main)
(use Interface)
(use Chase)
(use Motion)
(use User)
(use System)

(public
	nextWitch 0
)

(local
	local0
)

(instance nextWitch of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 294)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 120 152 self)
			)
			(1
				((ScriptID 21 1) setLoop: 6 posn: 168 122 init:) ; baba
				((ScriptID 21 2) ; babaHead
					posn: ((ScriptID 21 1) x:) (- ((ScriptID 21 1) y:) 34) ; baba, baba
					init:
					setPri: 15
					setCycle: Fwd
				)
				((ScriptID 21 8) play:) ; teleport
				(= cycles 5)
			)
			(2
				(TimePrint 5 294 0) ; "Back so soon?"
				((ScriptID 21 3) setCycle: End) ; bat
				((ScriptID 21 4) startUpd:) ; spider
				(= local0 1)
				(= seconds 3)
			)
			(3
				(gEgo loop: 0)
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 2)
			)
			(4
				((ScriptID 21 3) setCycle: 0) ; bat
				((ScriptID 21 4) setCycle: 0) ; spider
				(Print 294 1 #at -1 12 #width 140 #mode 1 #dispose #time 10) ; "Spirits of Mist And Creatures of Bog: Transform my guest To the shape of a Frog."
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(= seconds 7)
			)
			(5
				(= local0 0)
				((ScriptID 21 1) setCycle: End) ; baba
				(= seconds 2)
			)
			(6
				(gEgo view: 19 loop: 3 cel: 0 setCycle: End)
				((ScriptID 21 8) play:) ; teleport
				((ScriptID 21 2) setCycle: 0 hide:) ; babaHead
				(= cycles 15)
			)
			(7
				((ScriptID 21 4) setCycle: 0) ; spider
				((ScriptID 21 1) ; baba
					setLoop: 8
					setCycle: Fwd
					setMotion: Chase gEgo 20 self
				)
			)
			(8
				((ScriptID 21 1) setCycle: 0) ; baba
				((ScriptID 21 2) ; babaHead
					posn: ((ScriptID 21 1) x:) (- ((ScriptID 21 1) y:) 34) ; baba, baba
					setPri: (+ ((ScriptID 21 1) priority:) 1) ; baba
					setCycle: Fwd
					show:
				)
				(= cycles 2)
			)
			(9
				(= local0 1)
				(TimePrint 7 294 2) ; "This I vow: Stay there now!"
				(= seconds 4)
			)
			(10
				(= local0 0)
				((ScriptID 21 2) setCycle: 0) ; babaHead
				((ScriptID 21 1) setLoop: 6 cel: 0 setCycle: End) ; baba
				(= seconds 3)
			)
			(11
				(= local0 1)
				(TimePrint 8 294 3) ; "Once again you're a frog, and once again you can't move. You find it very exasperating!"
				(= seconds 8)
			)
			(12
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(TimePrint 6 294 4) ; "Yum, Yum. Froggie Frappe!"
				(= seconds 5)
			)
			(13
				((ScriptID 21 2) setCycle: 0) ; babaHead
				((ScriptID 21 3) setLoop: 5 setCycle: Fwd) ; bat
				((ScriptID 21 4) setCycle: Fwd) ; spider
				(= seconds 4)
			)
			(14
				((ScriptID 21 3) setCycle: 0) ; bat
				((ScriptID 21 4) setCycle: 0) ; spider
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(TimePrint 8 294 5) ; "Did you bring me my mandrake like you promised?"
				(= seconds 5)
			)
			(15
				(= local0 (= seconds 0))
				(= global324 3)
				((ScriptID 21 2) setCycle: 0) ; babaHead
				((ScriptID 21 1) setScript: (ScriptID 21 7)) ; baba, babaTalk
				(= global114 100)
				(User canInput: 1)
			)
			(16
				(= local0 1)
				(Print 294 6 #at -1 130 #width 250 #mode 1 #dispose #time 8) ; "As you make a feeble croaking sound, you try to nod your head."
				(= seconds 8)
			)
			(17
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(TimePrint 5 294 7) ; "Well? Where is it?"
				(= seconds 3)
			)
			(18
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 5)
			)
			(19
				((ScriptID 21 2) setLoop: 5 setCycle: Fwd) ; babaHead
				(TimePrint 7 294 8) ; "What's the matter? Got a frog in your throat?"
				(= seconds 5)
			)
			(20
				((ScriptID 21 3) setCycle: Fwd) ; bat
				((ScriptID 21 4) setCycle: Fwd) ; spider
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 3)
			)
			(21
				((ScriptID 21 3) setCycle: 0) ; bat
				((ScriptID 21 4) setCycle: 0) ; spider
				((ScriptID 21 2) setLoop: 4 setCycle: Fwd) ; babaHead
				(TimePrint 14 294 9) ; "I suppose I'll have to turn you back into whatever it is that you were. Pity! You're much more appetizing this way."
				(= seconds 12)
			)
			(22
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 2)
			)
			(23
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(Print 294 10 #at -1 12 #width 160 #mode 1 #dispose #time 12) ; "Creatures of Bog And Spirits of Fog: Return the true form To this rather dumb Frog."
				(= seconds 9)
			)
			(24
				(= local0 0)
				((ScriptID 21 2) setCycle: 0) ; babaHead
				((ScriptID 21 1) setCycle: End) ; baba
				(= seconds 3)
			)
			(25
				((ScriptID 21 8) play:) ; teleport
				(gEgo setCycle: Beg self)
			)
			(26
				(NormalEgo)
				(gEgo loop: 0)
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(= local0 1)
				(TimePrint 6 294 11) ; "Now, did you put it in your backpack?"
				(= seconds 5)
			)
			(27
				(= local0 0)
				((ScriptID 21 2) hide:) ; babaHead
				((ScriptID 21 1) setMotion: Chase gEgo 10) ; baba
				(= cycles 5)
			)
			(28
				(if (gEgo has: 4) ; mandrake
					((ScriptID 21 1) setPri: 9) ; baba
					((ScriptID 21 2) ; babaHead
						posn: ((ScriptID 21 1) x:) (- ((ScriptID 21 1) y:) 34) ; baba, baba
						setPri: 10
						setCycle: Fwd
						show:
					)
					(= local0 1)
					(SolvePuzzle 654 3)
					(TimePrint 5 294 12) ; "Ah! Here it is."
					(gEgo use: 4) ; mandrake
					(ClearFlag 326)
					(= seconds 5)
				else
					((ScriptID 21 0) setScript: (ScriptID 21 6)) ; rm21, noBringDeath
				)
			)
			(29
				((ScriptID 21 3) setCycle: Fwd) ; bat
				((ScriptID 21 4) setCycle: Fwd) ; spider
				((ScriptID 21 2) setLoop: 5) ; babaHead
				(TimePrint 5 294 13) ; "Kids! We have it!"
				(= seconds 4)
			)
			(30
				(= local0 0)
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 2)
			)
			(31
				((ScriptID 21 3) setCycle: 0) ; bat
				((ScriptID 21 4) setCycle: 0) ; spider
				((ScriptID 21 2) hide:) ; babaHead
				((ScriptID 21 1) ; baba
					setPri: -1
					setMotion:
						MoveTo
						(+ ((ScriptID 21 1) x:) 10) ; baba
						(- ((ScriptID 21 1) y:) 5) ; baba
						self
				)
			)
			(32
				((ScriptID 21 2) ; babaHead
					posn: ((ScriptID 21 1) x:) (- ((ScriptID 21 1) y:) 34) ; baba, baba
					setPri: (+ ((ScriptID 21 1) priority:) 1) ; baba
					setLoop: 4
					setCycle: Fwd
					show:
				)
				(= local0 1)
				(TimePrint 10 294 14) ; "That's it! The final ingredient. Now we can make our greatest creation..."
				(= seconds 10)
			)
			(33
				((ScriptID 21 3) setCycle: Fwd) ; bat
				((ScriptID 21 4) setCycle: Fwd) ; spider
				((ScriptID 21 2) setLoop: 5) ; babaHead
				(TimePrint 4 294 15) ; "MANDRAKE MOUSSE!"
				(= seconds 4)
			)
			(34
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 3)
			)
			(35
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(TimePrint 10 294 16) ; "What's that, children? You think we should reward our lackey here?"
				(= seconds 12)
			)
			(36
				((ScriptID 21 2) setLoop: 4) ; babaHead
				(TimePrint 10 294 17) ; "Very well, ex-frog. I'll let you live this time. Next time, though, it's frog legs for sure!"
				(= seconds 8)
			)
			(37
				((ScriptID 21 2) setCycle: 0 hide:) ; babaHead
				(= seconds 2)
			)
			(38
				(= local0 0)
				((ScriptID 21 1) setLoop: 6 cel: 0 setCycle: End self) ; baba
				((ScriptID 21 2) ; babaHead
					setLoop: 4
					posn: ((ScriptID 21 1) x:) (- ((ScriptID 21 1) y:) 34) ; baba, baba
					setPri: (+ ((ScriptID 21 1) priority:) 1) ; baba
					show:
					setCycle: Fwd
				)
				(TimePrint 4 294 18) ; "So...Go!"
			)
			(39
				((ScriptID 21 2) hide:) ; babaHead
				((ScriptID 21 5) ; TP
					posn: (gEgo x:) (gEgo y:)
					setPri: 15
					init:
					setCycle: CT 6 1 self
				)
				((ScriptID 21 8) play:) ; teleport
			)
			(40
				(gEgo hide:)
				((ScriptID 21 5) setCycle: End) ; TP
				(= cycles 15)
			)
			(41
				(client setScript: 0)
				(gCurRoom newRoom: 22)
			)
		)
	)
)

