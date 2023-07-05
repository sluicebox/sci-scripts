;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 289)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	bustedScript 0
	faceTheMusicScript 1
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(if local0
		(LowPrint &rest)
	else
		(HighPrint &rest)
	)
)

(instance bustedScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 289)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				((ScriptID 321 6) setLoop: 0 cel: 1 posn: 125 119 setPri: 8) ; otto
				((ScriptID 321 5) setLoop: 2 cel: 0 posn: 117 48) ; sheriff
				((ScriptID 321 7) ; bottomDoor
					loop: 7
					cel: 0
					posn: 109 119
					setPri: 9
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
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
				((ScriptID 321 6) setPri: 9 setMotion: MoveTo 136 140) ; otto
				((ScriptID 321 8) setCycle: End self) ; leftDoor
			)
			(2
				((ScriptID 321 5) setMotion: MoveTo 122 60 self) ; sheriff
			)
			(3
				(if (== local1 2)
					((ScriptID 321 3) stop:) ; sneakMusic
					(EgoDead ; "Naughty, naughty. The Sheriff and Otto arrive on the scene and arrest you for "blatant power-gaming". You have to *work* at it to become a *real* hero!"
						289
						0
						80
						{ Try to stay "in character" next time }
						82
						503
						1
						0
					)
				else
					((ScriptID 321 3) stop:) ; sneakMusic
					(localproc_0 289 1) ; "Obviously, you shouldn't have done that!"
					(EgoDead 289 2 80 { Criminal carelessness. } 82 602 4 0) ; "Now you've done it! It's hard to be a hero when you're locked up for breaking and entering (or entering and breaking, as the case may be). Be a little more intelligent (and a lot quieter) if you ever try something like this again."
				)
			)
		)
	)
)

(instance faceTheMusicScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 289)
	)

	(method (doit)
		(cond
			((< (gEgo distanceTo: (ScriptID 321 6)) 20) ; otto
				(self changeState: 9)
			)
			((> (gEgo y:) 187)
				(User canControl: 0)
				(User canInput: 0)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 193)
				(localproc_0 289 3) ; "Gently and stealthily, you lift the lid on the little box."
				(self cue:)
			)
			(1
				(HandsOff)
				((ScriptID 321 10) setCel: 4) ; musicBox
				(SetFlag 194)
				(SetFlag 195)
				((ScriptID 321 2) loop: -1 number: 13 play:) ; miscMusic
				(= seconds 3)
			)
			(2
				(localproc_0 289 4 83) ; "As the little music box begins to play, you hear the Sheriff yell out: "Otto, stop playing with that music box and GO TO BED!""
				(localproc_0 289 5) ; "Boy, did YOU make a mistake!"
				(gEgo setMotion: MoveTo (+ (gEgo x:) 30) (gEgo y:))
				(= seconds 2)
			)
			(3
				((ScriptID 321 6) setLoop: 1 cel: 1 posn: 130 118 setPri: 8) ; otto
				((ScriptID 321 7) setCycle: End self) ; bottomDoor
			)
			(4
				(gEgo loop: 1)
				((ScriptID 321 6) ; otto
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 130 150 self
				)
			)
			(5
				((ScriptID 321 6) setLoop: 5 cel: 0 setCycle: Fwd) ; otto
				(= cycles 20)
			)
			(6
				(cond
					((gEgo has: 16) ; music box
						(localproc_0 289 6) ; "Otto can't find the music box, but he's too dim and sleepy to figure it out, so he heads on back to bed"
					)
					((IsFlag 194)
						((ScriptID 321 10) setCel: 3 forceUpd:) ; musicBox
						((ScriptID 321 2) stop:) ; miscMusic
						(localproc_0 289 7 83) ; "Otto, even in his sleepy state, winds the music box and closes the lid before he heads back to bed."
						(ClearFlag 194)
					)
					(else
						(localproc_0 289 8) ; "Otto stares sleepily at the closed music box for a moment and heads back to bed."
					)
				)
				((ScriptID 321 6) ; otto
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 130 118 self
				)
			)
			(7
				((ScriptID 321 6) posn: 0 1000 stopUpd:) ; otto
				((ScriptID 321 7) setCycle: Beg self) ; bottomDoor
			)
			(8
				(localproc_0 289 9) ; "That was close! The goon must've been so dumb or sleepy or both that he didn't even see you standing there."
				(ClearFlag 193)
				(HandsOn)
				(gEgo setScript: 0)
			)
			(9
				((ScriptID 321 3) stop:) ; sneakMusic
				(EgoDead 289 10 80 { Criminal carelessness. } 82 503 1 0) ; "Obviously, getting in the goon's way was not one of your brighter ideas. You've had it now!"
			)
		)
	)
)

