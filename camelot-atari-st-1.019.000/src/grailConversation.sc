;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 168)
(include sci.sh)
(use Main)
(use Rm62)
(use Motion)
(use System)

(public
	grailConversation 0
	buyGrail 1
)

(instance grailConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(proc62_1 168 0) ; "You refer to the Christian legend of the cup from which the prophet Jesus drank before he was martyred. I know it well. Come close and listen."
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 81 138 self)
			)
			(2
				(gEgo setMotion: MoveTo 81 136 self)
			)
			(3
				(global187 hide:)
				(gTObj talkCue: self actor: global185 tLoop: 9 cSpeed: 1)
				(Talk 168 1 168 2 168 3) ; "This is not well known, but I possess the very cup, this Holy Grail you seek. It was entrusted to me by an ancient priest who died in my care."
			)
			(4
				(global187 show:)
				(global185 setLoop: 3 cel: 0)
				(gEgo setLoop: 3 setMotion: MoveTo 81 142 self)
			)
			(5
				(gEgo setMotion: MoveTo 81 140 self)
			)
			(6
				(gEgo setLoop: -1 setMotion: 0 illegalBits: $8000)
				(= global151 2)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 168)
			)
		)
	)
)

(instance buyGrail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 161)
				(gTObj talkCue: self)
				(proc62_1 168 4) ; "I will fetch it at once."
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
				(= seconds 2)
			)
			(4
				(global185
					view: 365
					setLoop: 0
					cel: 0
					show:
					setMotion: MoveTo 88 128 self
				)
			)
			(5
				(global186 show:)
				(global187 show:)
				(global185 view: 365 setLoop: 3 posn: 88 128 26)
				(gTObj talkCue: self)
				(proc62_1 168 5) ; "Heh heh, sorry, habibi. I must have sold it. But I have a very good deal on saints' fingerbones! And for you, at half price!"
			)
			(6
				(proc0_18)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 168)
			)
		)
	)
)

