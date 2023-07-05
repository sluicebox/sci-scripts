;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 197)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	board 0
	muleBoard 1
)

(instance board of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 197)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= global116 0)
					(gTObj talkCue: self)
					(Talk 197 0) ; "There will be only enough room for you and your mule, m'lud. I will see that your horse is delivered safely to Camelot, as I did for Sir Galahad when he departed from here some months ago."
				else
					(self cue:)
				)
			)
			(1
				(gTObj talkCue: self)
				(Talk 197 1 197 2) ; "As fortune would have it, this ship is the very one you need. Ignore the Greek name. It was sold by a Greek trader and the new owner has yet to paint in the new name."
			)
			(2
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 275 155 self
				)
			)
			(3
				(gEgo loop: 3)
				((ScriptID 33 2) ; harborMaster
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					ignoreActors:
					setMotion: MoveTo 237 ((ScriptID 33 2) y:) self ; harborMaster
				)
				((ScriptID 33 3) dispose:) ; hbHead
			)
			(4
				((ScriptID 33 2) setLoop: 2 cel: 0 stopUpd:) ; harborMaster
				(gEgo setMotion: MoveTo 275 148 self)
				(gMuleObj setScript: muleBoard)
			)
			(5
				(gEgo setLoop: 3 setPri: 10 setMotion: MoveTo 265 118 self)
			)
			(6
				(gEgo setPri: 7 setMotion: MoveTo 265 124 self)
			)
			(7
				(gEgo setLoop: -1 setMotion: MoveTo 200 124 self)
			)
			(8
				(gEgo setLoop: 0)
				(= cycles 60)
			)
			(9
				(gEgo setLoop: -1)
				(gMuleObj ignoreActors: 0)
				(gCurRoom newRoom: 34) ; Voyage
			)
		)
	)
)

(instance muleBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMuleObj ignoreActors: setMotion: MoveTo 271 158 self)
			)
			(1
				(gMuleObj setMotion: MoveTo 271 148 self)
			)
			(2
				(= register (gMuleObj looper:))
				(gMuleObj
					setLoop: 3
					setPri: 10
					looper: 0
					setMotion: MoveTo 263 118 self
				)
			)
			(3
				(gMuleObj
					setLoop: 3
					setPri: 7
					looper: 0
					setMotion: MoveTo 262 124 self
				)
			)
			(4
				(gMuleObj
					setLoop: -1
					looper: register
					setMotion: MoveTo 230 123 self
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

