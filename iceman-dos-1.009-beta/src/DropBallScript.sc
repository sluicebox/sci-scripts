;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 357)
(include sci.sh)
(use Main)
(use volleyRm)
(use Interface)
(use Approach)
(use Sound)
(use Jump)
(use Motion)
(use User)
(use System)

(public
	DropBallScript 0
	GetBallScript 1
	KickBallScript 2
	ReturnBallScript 3
)

(local
	local0
)

(instance DropBallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(gEgo
						setLoop: (if (== (gEgo heading:) 90) 2 else 3)
						setCycle: End self
					)
				else
					(Print 357 0) ; "You don't have it!"
					(self dispose:)
				)
			)
			(1
				(gEgo
					view: 200
					loop: (if (== (gEgo heading:) 90) 0 else 1)
					setLoop: -1
					setCycle: Walk
					forceUpd:
				)
				((ScriptID 3 3) ; Ball
					posn:
						(+
							(gEgo x:)
							(*
								(gEgo xStep:)
								(if (== (gEgo loop:) 2) 1 else -1)
							)
						)
						(gEgo y:)
					ignoreActors: 0
					show:
					forceUpd:
				)
				(= local0 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance GetBallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 3 3) ignoreActors: 1) ; Ball
				(cond
					((!= (gEgo view:) 503)
						(self setScript: getToBall self)
					)
					((OneOf (gEgo loop:) 0 1)
						(Print 357 1) ; "You already have it!"
						(self dispose:)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(HandsOff)
				(User canInput: 1)
				((ScriptID 3 3) hide:) ; Ball
				(gEgo view: 503)
				(if (< (gEgo x:) ((ScriptID 3 4) x:)) ; Net
					(gEgo heading: 90 setLoop: 0)
				else
					(gEgo heading: 270 setLoop: 1)
				)
				(gEgo setCycle: End self)
			)
			(2
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance KickBallScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(hit1L init:)
				((ScriptID 3 3) ignoreActors: 1) ; Ball
				(if local0
					(self setScript: DropBallScript self)
				else
					(self setScript: getToBall self)
				)
			)
			(1
				(proc3_7 357 2) ; "You kick the ball to the players."
				(if (< (gEgo x:) ((ScriptID 3 4) x:)) ; Net
					(= temp1 ((= temp0 (ScriptID 3 1)) nsLeft:)) ; Man
				else
					(= temp1 ((= temp0 (ScriptID 3 2)) nsRight:)) ; Girl
				)
				(hit1L number: (proc0_5 38) play:)
				((ScriptID 3 3) ; Ball
					setPri: (+ (temp0 priority:) 1)
					setMotion: JumpTo temp1 (temp0 nsTop:) self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance ReturnBallScript of Script
	(properties)

	(method (dispose)
		(hit1L dispose:)
		(super dispose:)
		(DisposeScript 357)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
			)
			(1
				(= cycles 1)
			)
			(2
				(= register 0)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event))
			((Said '[/ball]>')
				(cond
					((Said 'get,pick')
						(self setScript: GetBallScript)
					)
					((Said 'drop')
						(self setScript: DropBallScript)
					)
					((Said 'return,throw,give,hit,kick')
						(self setScript: KickBallScript self)
					)
				)
			)
		)
	)
)

(instance hit1L of Sound
	(properties
		number 38
		priority 1
	)
)

(instance getToBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((< 144 (gEgo x:))
						(self cue:)
					)
					((< 118 (gEgo y:))
						(gEgo setMotion: MoveTo 162 138 self)
					)
					(else
						(gEgo setMotion: MoveTo 132 104 self)
					)
				)
			)
			(1
				(gEgo setMotion: Approach (ScriptID 3 3) 5 self) ; Ball
			)
			(2
				(self dispose:)
			)
		)
	)
)

