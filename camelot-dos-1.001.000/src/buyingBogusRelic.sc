;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 167)
(include sci.sh)
(use Main)
(use Rm62)
(use n151)
(use Motion)
(use System)

(public
	buyingBogusRelic 0
	buyRelic 1
)

(instance buyingBogusRelic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(proc62_1 167 0) ; "Ah, please excuse me one moment, habibi."
			)
			(1
				(global186 hide:)
				(global187 hide:)
				(global185
					view: 383
					setLoop: 0
					setCel: 0
					posn: 88 128 0
					setCycle: End self
				)
			)
			(2
				(global185
					setLoop: 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 88 114 self
				)
			)
			(3
				(global185 hide:)
				(= seconds 6)
			)
			(4
				(global185
					show:
					view: 365
					setLoop: 0
					cel: 0
					setMotion: MoveTo 88 128 self
				)
			)
			(5
				(global186 show:)
				(global187 show:)
				(global185
					setLoop: 1
					setCel: 0
					posn: (global185 x:) (global185 y:) 26
				)
				(gTObj talkCue: self)
				(proc62_1 167 1) ; "My apologies. I must have sold the last piece. But I have a special on saints' relics."
			)
			(6
				(= global151 0)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 167)
			)
		)
	)
)

(instance buyRelic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc151_0 2 self self)
			)
			(1
				(gTObj talkCue: self)
				(proc62_1 167 2) ; "Wait but one instant."
			)
			(2
				(global186 hide:)
				(global187 hide:)
				(global185
					view: 383
					setLoop: 0
					setCel: 0
					posn: 88 128 0
					setCycle: End self
				)
			)
			(3
				(global185
					setLoop: 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 88 114 self
				)
			)
			(4
				(global185 hide:)
				(= seconds 6)
			)
			(5
				(global185
					show:
					view: 365
					setLoop: 0
					cel: 0
					setMotion: MoveTo 88 128 self
				)
			)
			(6
				(global186 show:)
				(global187 show:)
				(global185
					setLoop: 6
					setCel: 0
					posn: (global185 x:) (global185 y:) 26
					setCycle: End self
				)
			)
			(7
				(proc151_0 2 self self)
			)
			(8
				(global185 setLoop: 1)
				(gTObj talkCue: self)
				(if (not (IsFlag 161))
					(proc62_1 167 3) ; "A great pleasure to do business with you! Oh, did I mention that I have also a cup called the Grail?"
				else
					(proc62_1 167 4) ; "A great pleasure to do business with you!"
				)
			)
			(9
				(gEgo get: 12) ; relic
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 167)
			)
		)
	)
)

