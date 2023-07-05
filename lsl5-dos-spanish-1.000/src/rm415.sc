;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 415)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use LoadMany)
(use Actor)
(use System)

(public
	rm415 0
)

(local
	seenMsg
)

(instance rm415 of LLRoom
	(properties
		picture 415
	)

	(method (init)
		(LoadMany rsVIEW 1415 1416)
		(super init:)
		(self setScript: sCartoon)
	)

	(method (dispose)
		(gTheMusic fade: 0 15 12 1 self)
		(super dispose:)
	)
)

(instance You_ST_ of Talker
	(properties
		name {You}
		x 160
		y 180
		nsTop 76
		nsLeft 168
		view 1416
		loop 3
	)

	(method (init)
		(= mouth pattiMouth)
		(super init: &rest)
	)
)

(instance pattiMouth of Prop
	(properties
		nsLeft 1
		view 1416
		cycleSpeed 5
	)
)

(instance Inspector_Desmond_SInspector_Desmond of Talker
	(properties
		name {Inspector Desmond}
		x 1
		y 180
		nsTop 73
		nsLeft 120
		view 1415
		loop 3
		talkWidth 240
	)

	(method (init)
		(= mouth desmondMouth)
		(super init: &rest)
	)
)

(instance desmondMouth of Prop
	(properties
		view 1415
		cycleSpeed 5
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say ; "Patti, I'm Inspector Desmond, of your Federal Bureau of Investigation. If it's all right, I'd like to request a few moments of your time."
					Inspector_Desmond_SInspector_Desmond
					415
					0
					108
					139
					self
				)
			)
			(1
				(= ticks 123)
			)
			(2
				(Say You_ST_ 415 1 108 139 self) ; "But, of course, Inspector," you reply. "Nice trench coat!"
			)
			(3
				(= ticks 123)
			)
			(4
				(Say ; "You too," he smiles, easily recognizing your joke. "I'm here, on behalf of your country, to ask a favor of you."
					Inspector_Desmond_SInspector_Desmond
					415
					2
					108
					139
					self
				)
			)
			(5
				(= ticks 123)
			)
			(6
				(Say You_ST_ 415 3 108 139 self) ; "Go ahead, Inspector, but I don't usually grant favors on a first date! Besides, I'm not the private-eye type."
			)
			(7
				(= ticks 123)
			)
			(8
				(Say ; "He smiles again. "Oh, you won't have to do that, Patti. You see, you're exactly the `type' we need!""
					Inspector_Desmond_SInspector_Desmond
					415
					4
					108
					139
					self
				)
			)
			(9
				(= ticks 30)
			)
			(10
				(Say ; "Let me explain: we're right in the middle of a months-long, nation-wide investigation into the infiltration of organized crime into the entertainment industry."
					Inspector_Desmond_SInspector_Desmond
					415
					5
					108
					139
					self
				)
			)
			(11
				(= ticks 30)
			)
			(12
				(Say ; "I'm looking for a special someone, someone willing to take some risks, someone without a family, without many social ties, without any extenuating circumstances to get in the way."
					Inspector_Desmond_SInspector_Desmond
					415
					6
					108
					139
					self
				)
			)
			(13
				(= ticks 30)
			)
			(14
				(Say ; "Someone who understands the music business, who plays an instrument, and who has the looks, brains and talent to be accepted by those insiders we're trying to catch."
					Inspector_Desmond_SInspector_Desmond
					415
					7
					108
					139
					self
				)
			)
			(15
				(= ticks 30)
			)
			(16
				(Say ; "I know you've been `stiffed' by these guys--probably many times. I want these guys, and I bet you do too. So, Patti, in short: I need you to go `undercover'!"
					Inspector_Desmond_SInspector_Desmond
					415
					8
					108
					139
					self
				)
			)
			(17
				(= ticks 30)
			)
			(18
				(Say ; "What do you say?"
					Inspector_Desmond_SInspector_Desmond
					415
					9
					108
					139
					self
				)
			)
			(19
				(= ticks 30)
			)
			(20
				(TPrint 415 10 67 -1 185 70 280) ; "You are taken aback. But considering the requirements, who could be better for the job than you? It would be sweet to get revenge on these guys, not just for tonight's embarrassment, but for all those others times when you gave your talents for a bunch of ingrates."
				(Say You_ST_ 415 11 108 139 self) ; "But, of course I'll help you, Inspector Desmond!" you hear yourself say, "after all, I recently learned I'm taking next week off."
			)
			(21
				(= ticks 123)
			)
			(22
				(Say You_ST_ 415 12 108 139 self) ; "So, how do we start?"
			)
			(23
				(= ticks 123)
			)
			(24
				(Say ; "Follow me, Patti. I have a car and driver waiting for us."
					Inspector_Desmond_SInspector_Desmond
					415
					13
					108
					139
					self
				)
			)
			(25
				(= ticks 210)
			)
			(26
				(gCurRoom newRoom: 410)
			)
		)
	)
)

