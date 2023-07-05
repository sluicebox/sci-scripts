;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 293)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use System)

(public
	firstTalk 0
)

(local
	local0
)

(instance firstTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 293)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 21 1) ; baba
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 119 136 self
				)
			)
			(1
				((ScriptID 21 1) setLoop: 1 setCycle: 0 cel: 0) ; baba
				(gEgo
					view: 20
					setLoop: 2
					cel: 0
					cycleSpeed: 1
					posn:
						(- ((ScriptID 21 1) x:) 13) ; baba
						(- ((ScriptID 21 1) y:) 25) ; baba
					setPri: (+ ((ScriptID 21 1) priority:) 1) ; baba
					show:
				)
				((ScriptID 21 4) setCycle: Fwd) ; spider
				((ScriptID 21 3) setCycle: Fwd) ; bat
				(= seconds 3)
			)
			(2
				(= local0 1)
				(TimePrint 4 293 0) ; "BE STILL!"
				((ScriptID 21 1) setCel: 1) ; baba
				((ScriptID 21 2) ; babaHead
					setLoop: 5
					posn: ((ScriptID 21 1) x:) (- ((ScriptID 21 1) y:) 34) ; baba, baba
					setPri: (+ ((ScriptID 21 1) priority:) 1) ; baba
					setCycle: Fwd
					show:
				)
				(= seconds 2)
			)
			(3
				((ScriptID 21 4) setCycle: 0) ; spider
				((ScriptID 21 3) setLoop: 1 cel: 4 setCycle: Beg) ; bat
				(= seconds 2)
			)
			(4
				(TimePrint 6 293 1) ; "Critics! We can't all be gourmands, I suppose."
				((ScriptID 21 2) setLoop: 4) ; babaHead
				(= seconds 4)
			)
			(5
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 2)
			)
			(6
				((ScriptID 21 1) setCel: 0) ; baba
				((ScriptID 21 2) setLoop: 3 setCycle: Fwd) ; babaHead
				(TimePrint 7 293 2) ; "Now, Oh-Soon-To-Be-Supper... I don't suppose you have a name?""
				(= seconds 5)
			)
			(7
				(= local0 (= seconds 0))
				((ScriptID 21 2) setCycle: 0) ; babaHead
				((ScriptID 21 1) setScript: (ScriptID 21 7)) ; baba, babaTalk
				(= global114 100)
				(User canInput: 1)
			)
			(8
				(gEgo setCycle: Fwd)
				(= local0 1)
				(Print 293 3 #at -1 130 #width 250 #mode 1 #dispose #time 8) ; "You try your best to croak out your name, or at least let the witch know that you do indeed have one."
				(= seconds 8)
			)
			(9
				(gEgo setCycle: 0)
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(= local0 1)
				(TimePrint 9 293 4) ; "So you're the one who's trying to be a hero around here. The only good hero's a dead hero, I always say!"
				(= seconds 7)
			)
			(10
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 2)
			)
			(11
				(TimePrint 6 293 5) ; "But I do have a need for a brave fool. Are you brave?"
				(= global324 1)
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(= seconds 4)
			)
			(12
				(= local0 (= seconds 0))
				((ScriptID 21 2) setCycle: 0) ; babaHead
				((ScriptID 21 1) setScript: (ScriptID 21 7)) ; baba, babaTalk
				(= global114 100)
				(User canInput: 1)
			)
			(13
				(gEgo setCycle: Fwd)
				(= local0 1)
				(Print 293 6 #at -1 130 #width 250 #mode 1 #dispose #time 7) ; "You make little froggy sounds, trying your best to indicate your agreement."
				(= seconds 7)
			)
			(14
				(gEgo setCycle: 0)
				(TimePrint 2 293 7) ; "Wellll..."
				(= seconds 2)
			)
			(15
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(TimePrint 8 293 8) ; "If you're willing to do a small little teensy favor for me, I might reconsider having you for supper."
				(= seconds 6)
			)
			(16
				((ScriptID 21 2) setCycle: 0) ; babaHead
				(= seconds 2)
			)
			(17
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(TimePrint 7 293 9) ; "I need the root of a mandrake plant that grows in the graveyard. Will you be a sweet and fetch me some?"
				(= seconds 8)
			)
			(18
				(= local0 (= seconds 0))
				(= global324 2)
				((ScriptID 21 2) setCycle: 0) ; babaHead
				((ScriptID 21 1) setScript: (ScriptID 21 7)) ; baba, babaTalk
				(= global114 100)
				(User canInput: 1)
			)
			(19
				(gEgo setCycle: Fwd)
				(= local0 1)
				(Print 293 10 #at -1 130 #width 250 #mode 1 #dispose #time 7) ; ""Anything but Frog Legs Fricassee!", you think.  You croak your agreement to the task."
				(= seconds 7)
			)
			(20
				(gEgo setCycle: 0)
				((ScriptID 21 4) setCycle: Fwd) ; spider
				((ScriptID 21 3) setLoop: 5 setCycle: Fwd) ; bat
				((ScriptID 21 1) setCel: 1) ; baba
				((ScriptID 21 2) setLoop: 4 setCycle: Fwd) ; babaHead
				(TimePrint 6 293 11) ; "And I had my mouth watering for frog. Oh well!"
				(= seconds 4)
			)
			(21
				((ScriptID 21 1) setCel: 0) ; baba
				((ScriptID 21 2) setCycle: 0 setLoop: 3) ; babaHead
				(= seconds 3)
			)
			(22
				((ScriptID 21 4) setCycle: 0) ; spider
				((ScriptID 21 3) setCycle: 0) ; bat
				((ScriptID 21 2) setCycle: Fwd) ; babaHead
				(Print 293 12 #at -1 12 #width 160 #mode 1 #dispose #time 9) ; "Hear what I say And hear me right: Mandrake must be pulled At precisely Midnight!"
				(= seconds 9)
			)
			(23
				(Print 293 13 #at -1 12 #width 160 #mode 1 #dispose #time 9) ; "This I tell you And this I say: Return with the root Ere the break of next day."
				(= seconds 9)
			)
			(24
				(Print 293 14 #at -1 12 #width 145 #mode 1 #dispose #time 9) ; "Hear what I say And know I don't lie: Bring back the root Or else you will die!!"
				(= seconds 9)
			)
			(25
				(= local0 0)
				((ScriptID 21 2) hide:) ; babaHead
				(gEgo hide:)
				((ScriptID 21 1) ; baba
					setLoop: 0
					setCycle: Beg
					setMotion: MoveTo 140 136 self
				)
			)
			(26
				((ScriptID 21 1) setLoop: 7 cel: 5 setCycle: CT 3 -1 self) ; baba
			)
			(27
				(gEgo
					view: 19
					setLoop: 3
					cel: 7
					posn: (- ((ScriptID 21 1) x:) 17) (+ ((ScriptID 21 1) y:) 4) ; baba, baba
					show:
				)
				((ScriptID 21 1) setCycle: Beg self) ; baba
			)
			(28
				((ScriptID 21 4) setCycle: Fwd) ; spider
				((ScriptID 21 3) setCycle: Fwd) ; bat
				((ScriptID 21 1) setLoop: 6 cel: 0 setCycle: End self) ; baba
				((ScriptID 21 2) ; babaHead
					setLoop: 4
					posn: ((ScriptID 21 1) x:) (- ((ScriptID 21 1) y:) 34) ; baba, baba
					setPri: (+ ((ScriptID 21 1) priority:) 1) ; baba
					show:
					setCycle: Fwd
				)
				(TimePrint 4 293 15) ; "You, Shoo!"
			)
			(29
				((ScriptID 21 2) hide:) ; babaHead
				((ScriptID 21 5) ; TP
					posn: (gEgo x:) (gEgo y:)
					setPri: 15
					init:
					setCycle: CT 5 1 self
				)
				((ScriptID 21 8) play:) ; teleport
			)
			(30
				(gEgo hide:)
				((ScriptID 21 5) setCycle: End) ; TP
				(= cycles 10)
			)
			(31
				(gCurRoom newRoom: 22)
			)
		)
	)
)

