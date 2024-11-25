;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 162)
(include sci.sh)
(use Main)
(use Rm57)
(use n151)
(use Motion)
(use System)

(public
	giveVeil 0
)

(instance giveVeil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc151_0 2 self self)
			)
			(1
				(PutItem 13) ; veil
				(if (IsFlag 151)
					(gTObj talkCue: self)
					(proc57_1 162 0 162 1) ; "Ya'Allah! It is the veil, the very veil! Habibi, you are forever my brother!"
				else
					(gTObj talkCue: self)
					(proc57_1 162 2) ; "So, you are a scoundrel and a friend of Mari, no doubt. Expect no gratitude from me. Here is 1 dirham and be gone, or I will call the city guard to deal with you."
					(++ gSilver)
				)
			)
			(2
				(global188 dispose:)
				(global187 dispose:)
				(global185
					view: 352
					setLoop: 6
					cycleSpeed: 0
					posn: (global185 x:) (global185 y:) 0
					setCycle: Walk
					setMotion: MoveTo 95 134 self
				)
			)
			(3
				(global186 setCycle: End self)
			)
			(4
				(global185
					setLoop: 7
					setPri: 6
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 110 110 self
				)
			)
			(5
				(global186 setCel: 255 setCycle: Beg)
				(global185 setMotion: MoveTo 115 115 self)
			)
			(6
				(global185 stopUpd:)
				(SetFlag 146)
				(++ global146)
				(if (IsFlag 151)
					(= seconds 5)
				else
					(SetFlag 136)
					(self changeState: 10)
				)
			)
			(7
				(global185
					setLoop: 8
					cel: 0
					posn: 112 36
					cycleSpeed: 3
					setCycle: CT 4 1 self
				)
			)
			(8
				(= seconds 5)
			)
			(9
				(global185 cycleSpeed: 2 setCycle: End self)
			)
			(10
				(global186 stopUpd:)
				(global185 posn: 100 100 hide: setScript: 0)
				(= global185 0)
				(HandsOn)
				(DisposeScript 162)
			)
		)
	)
)

